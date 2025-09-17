const os = require('os');

/**
 * Simple push dispatcher for PoC.
 * - Sends push messages in parallel with concurrency limit
 * - Logs timings for telemetry
 */
module.exports = {
  async sendPushToDeviceEntries(deviceEntries = [], payload = {}, notificationService, opts = {}) {
    const concurrency = opts.concurrency || Math.max(10, Math.floor(os.cpus().length * 5));
    const tokens = [];

    for (const d of deviceEntries) {
      if (d && d.token) tokens.push(d.token);
    }

    if (tokens.length === 0) {
      console.log('pushDispatcher: no tokens to send');
      return { sent: 0 };
    }

    console.log(`pushDispatcher: sending to ${tokens.length} tokens with concurrency ${concurrency}`);

    // Chunk tokens to respect concurrency
    function chunkArray(arr, size) {
      const chunks = [];
      for (let i = 0; i < arr.length; i += size) chunks.push(arr.slice(i, i + size));
      return chunks;
    }

    const chunks = chunkArray(tokens, concurrency);
    let totalSent = 0;
    const start = Date.now();

    for (const chunk of chunks) {
      // send this chunk in parallel
      const promises = chunk.map(token => {
        const tStart = Date.now();
        return notificationService.sendPush(token, payload)
          .then(res => ({ token, ok: !!res, latency: Date.now() - tStart }))
          .catch(err => ({ token, ok: false, err: String(err), latency: Date.now() - tStart }));
      });

      const results = await Promise.allSettled(promises);
      for (const r of results) {
        if (r.status === 'fulfilled' && r.value && r.value.ok) totalSent++;
      }
    }

    const took = Date.now() - start;
    console.log(`pushDispatcher: completed sending to ${tokens.length} tokens, success: ${totalSent}, took ${took} ms`);
    return { attempted: tokens.length, sent: totalSent, tookMs: took };
  }
};
