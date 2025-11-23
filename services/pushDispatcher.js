const os = require('os');

/**
 * Simple push dispatcher for PoC.
 * - Sends push messages in parallel with concurrency limit
 * - Logs timings for telemetry
 */
module.exports = {
  async sendPushToDeviceEntries(deviceEntries = [], payload = {}, notificationService, opts = {}) {
    const concurrency = opts.concurrency || Math.max(10, Math.floor(os.cpus().length * 5));
    const targets = [];

    for (const d of deviceEntries) {
      if (!d) continue;
      // Debug: log each device entry
      console.log('pushDispatcher deviceEntry:', d);
      // FCM HTTP v1: Eğer token varsa ve platform android/ios ise, FCM ile gönderilecek
      if (d.token && (d.platform === 'android' || d.platform === 'ios')) {
        targets.push({ type: 'fcm', token: d.token });
      }
      // MQTT client id (Android için)
      else if (d.mqttClientId) targets.push({ type: 'mqtt', id: d.mqttClientId });
      // APNs (iOS için)
      else if (d.platform === 'ios' && d.token) targets.push({ type: 'apn', token: d.token });
    }

    if (targets.length === 0) {
      console.log('pushDispatcher: no targets to send');
      return { sent: 0 };
    }

    console.log(`pushDispatcher: sending to ${targets.length} targets with concurrency ${concurrency}`);

    // Chunk tokens to respect concurrency
    function chunkArray(arr, size) {
      const chunks = [];
      for (let i = 0; i < arr.length; i += size) chunks.push(arr.slice(i, i + size));
      return chunks;
    }

    const chunks = chunkArray(targets, concurrency);
    let totalSent = 0;
    const start = Date.now();
    const { sendFcmHttpV1Notification } = require('./fcmHttpV1');

    for (const chunk of chunks) {
      const promises = chunk.map(async target => {
        const tStart = Date.now();
        try {
          if (target.type === 'fcm') {
            await sendFcmHttpV1Notification({
              title: payload.notification?.title,
              body: payload.notification?.body,
              token: target.token,
              data: payload.data
            });
            return { target, ok: true, latency: Date.now() - tStart };
          } else if (target.type === 'mqtt') {
            return notificationService.sendPush(`mqtt_${target.id}`, payload)
              .then(res => ({ target, ok: !!res, latency: Date.now() - tStart }))
              .catch(err => ({ target, ok: false, err: String(err), latency: Date.now() - tStart }));
          } else if (target.type === 'apn') {
            return notificationService.sendPush(`apn_${target.token}`, payload)
              .then(res => ({ target, ok: !!res, latency: Date.now() - tStart }))
              .catch(err => ({ target, ok: false, err: String(err), latency: Date.now() - tStart }));
          } else {
            return { target, ok: false, latency: Date.now() - tStart };
          }
        } catch (err) {
          return { target, ok: false, err: String(err), latency: Date.now() - tStart };
        }
      });

      const results = await Promise.allSettled(promises);
      for (const r of results) {
        if (r.status === 'fulfilled' && r.value && r.value.ok) totalSent++;
      }
    }

    const took = Date.now() - start;
    console.log(`pushDispatcher: completed sending to ${targets.length} tokens, success: ${totalSent}, took ${took} ms`);
    return { attempted: targets.length, sent: totalSent, tookMs: took };
  }
};
