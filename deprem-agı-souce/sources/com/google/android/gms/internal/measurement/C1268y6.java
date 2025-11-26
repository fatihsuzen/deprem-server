package com.google.android.gms.internal.measurement;

import androidx.work.WorkRequest;
import androidx.work.multiprocess.RemoteWorkManager;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;

/* renamed from: com.google.android.gms.internal.measurement.y6  reason: case insensitive filesystem */
public final class C1268y6 implements C1260x6 {

    /* renamed from: A  reason: collision with root package name */
    public static final C1160m4 f5631A;

    /* renamed from: B  reason: collision with root package name */
    public static final C1160m4 f5632B;

    /* renamed from: C  reason: collision with root package name */
    public static final C1160m4 f5633C;

    /* renamed from: D  reason: collision with root package name */
    public static final C1160m4 f5634D;

    /* renamed from: E  reason: collision with root package name */
    public static final C1160m4 f5635E;

    /* renamed from: F  reason: collision with root package name */
    public static final C1160m4 f5636F;

    /* renamed from: G  reason: collision with root package name */
    public static final C1160m4 f5637G;

    /* renamed from: H  reason: collision with root package name */
    public static final C1160m4 f5638H;

    /* renamed from: I  reason: collision with root package name */
    public static final C1160m4 f5639I;

    /* renamed from: J  reason: collision with root package name */
    public static final C1160m4 f5640J;

    /* renamed from: K  reason: collision with root package name */
    public static final C1160m4 f5641K;

    /* renamed from: L  reason: collision with root package name */
    public static final C1160m4 f5642L;

    /* renamed from: M  reason: collision with root package name */
    public static final C1160m4 f5643M;

    /* renamed from: N  reason: collision with root package name */
    public static final C1160m4 f5644N;

    /* renamed from: O  reason: collision with root package name */
    public static final C1160m4 f5645O;

    /* renamed from: P  reason: collision with root package name */
    public static final C1160m4 f5646P;

    /* renamed from: Q  reason: collision with root package name */
    public static final C1160m4 f5647Q;

    /* renamed from: R  reason: collision with root package name */
    public static final C1160m4 f5648R;

    /* renamed from: S  reason: collision with root package name */
    public static final C1160m4 f5649S;

    /* renamed from: T  reason: collision with root package name */
    public static final C1160m4 f5650T;

    /* renamed from: U  reason: collision with root package name */
    public static final C1160m4 f5651U;

    /* renamed from: V  reason: collision with root package name */
    public static final C1160m4 f5652V;

    /* renamed from: W  reason: collision with root package name */
    public static final C1160m4 f5653W;

    /* renamed from: X  reason: collision with root package name */
    public static final C1160m4 f5654X;

    /* renamed from: Y  reason: collision with root package name */
    public static final C1160m4 f5655Y;

    /* renamed from: Z  reason: collision with root package name */
    public static final C1160m4 f5656Z;

    /* renamed from: a  reason: collision with root package name */
    public static final C1160m4 f5657a;

    /* renamed from: a0  reason: collision with root package name */
    public static final C1160m4 f5658a0;

    /* renamed from: b  reason: collision with root package name */
    public static final C1160m4 f5659b;

    /* renamed from: b0  reason: collision with root package name */
    public static final C1160m4 f5660b0;

    /* renamed from: c  reason: collision with root package name */
    public static final C1160m4 f5661c;

    /* renamed from: c0  reason: collision with root package name */
    public static final C1160m4 f5662c0;

    /* renamed from: d  reason: collision with root package name */
    public static final C1160m4 f5663d;

    /* renamed from: d0  reason: collision with root package name */
    public static final C1160m4 f5664d0;

    /* renamed from: e  reason: collision with root package name */
    public static final C1160m4 f5665e;

    /* renamed from: e0  reason: collision with root package name */
    public static final C1160m4 f5666e0;

    /* renamed from: f  reason: collision with root package name */
    public static final C1160m4 f5667f;

    /* renamed from: f0  reason: collision with root package name */
    public static final C1160m4 f5668f0;

    /* renamed from: g  reason: collision with root package name */
    public static final C1160m4 f5669g;

    /* renamed from: g0  reason: collision with root package name */
    public static final C1160m4 f5670g0;

    /* renamed from: h  reason: collision with root package name */
    public static final C1160m4 f5671h;

    /* renamed from: h0  reason: collision with root package name */
    public static final C1160m4 f5672h0;

    /* renamed from: i  reason: collision with root package name */
    public static final C1160m4 f5673i;

    /* renamed from: i0  reason: collision with root package name */
    public static final C1160m4 f5674i0;

    /* renamed from: j  reason: collision with root package name */
    public static final C1160m4 f5675j;

    /* renamed from: j0  reason: collision with root package name */
    public static final C1160m4 f5676j0;

    /* renamed from: k  reason: collision with root package name */
    public static final C1160m4 f5677k;

    /* renamed from: k0  reason: collision with root package name */
    public static final C1160m4 f5678k0;

    /* renamed from: l  reason: collision with root package name */
    public static final C1160m4 f5679l;

    /* renamed from: l0  reason: collision with root package name */
    public static final C1160m4 f5680l0;

    /* renamed from: m  reason: collision with root package name */
    public static final C1160m4 f5681m;

    /* renamed from: m0  reason: collision with root package name */
    public static final C1160m4 f5682m0;

    /* renamed from: n  reason: collision with root package name */
    public static final C1160m4 f5683n;

    /* renamed from: n0  reason: collision with root package name */
    public static final C1160m4 f5684n0;

    /* renamed from: o  reason: collision with root package name */
    public static final C1160m4 f5685o;

    /* renamed from: o0  reason: collision with root package name */
    public static final C1160m4 f5686o0;

    /* renamed from: p  reason: collision with root package name */
    public static final C1160m4 f5687p;

    /* renamed from: p0  reason: collision with root package name */
    public static final C1160m4 f5688p0;

    /* renamed from: q  reason: collision with root package name */
    public static final C1160m4 f5689q;

    /* renamed from: q0  reason: collision with root package name */
    public static final C1160m4 f5690q0;

    /* renamed from: r  reason: collision with root package name */
    public static final C1160m4 f5691r;

    /* renamed from: r0  reason: collision with root package name */
    public static final C1160m4 f5692r0;

    /* renamed from: s  reason: collision with root package name */
    public static final C1160m4 f5693s;

    /* renamed from: s0  reason: collision with root package name */
    public static final C1160m4 f5694s0;

    /* renamed from: t  reason: collision with root package name */
    public static final C1160m4 f5695t;

    /* renamed from: t0  reason: collision with root package name */
    public static final C1160m4 f5696t0;

    /* renamed from: u  reason: collision with root package name */
    public static final C1160m4 f5697u;

    /* renamed from: u0  reason: collision with root package name */
    public static final C1160m4 f5698u0;

    /* renamed from: v  reason: collision with root package name */
    public static final C1160m4 f5699v;

    /* renamed from: v0  reason: collision with root package name */
    public static final C1160m4 f5700v0;

    /* renamed from: w  reason: collision with root package name */
    public static final C1160m4 f5701w;

    /* renamed from: w0  reason: collision with root package name */
    public static final C1160m4 f5702w0;

    /* renamed from: x  reason: collision with root package name */
    public static final C1160m4 f5703x;

    /* renamed from: y  reason: collision with root package name */
    public static final C1160m4 f5704y;

    /* renamed from: z  reason: collision with root package name */
    public static final C1160m4 f5705z;

    static {
        C1106g4 b5 = new C1106g4(C1061b4.a("com.google.android.gms.measurement")).a().b();
        f5657a = b5.c("measurement.ad_id_cache_time", WorkRequest.MIN_BACKOFF_MILLIS);
        f5659b = b5.c("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000);
        f5661c = b5.d("measurement.config.bundle_for_all_apps_on_backgrounded", true);
        f5663d = b5.c("measurement.max_bundles_per_iteration", 100);
        f5665e = b5.f("measurement.gbraid_campaign.campaign_params_triggering_info_update", "gclid,gbraid,gad_campaignid");
        f5667f = b5.c("measurement.config.cache_time", 86400000);
        b5.f("measurement.log_tag", "FA");
        f5669g = b5.f("measurement.config.url_authority", "app-measurement.com");
        f5671h = b5.f("measurement.config.url_scheme", "https");
        f5673i = b5.c("measurement.upload.debug_upload_interval", 1000);
        b5.d("measurement.config.default_flag_values", true);
        f5675j = b5.c("measurement.session.engagement_interval", 3600000);
        f5677k = b5.f("measurement.rb.attribution.event_params", "value|currency");
        f5679l = b5.f("measurement.edpb.events_cached_in_no_data_mode", "_f,_v,_cmp");
        f5681m = b5.c("measurement.upload.google_signal_max_queue_time", 605000);
        f5683n = b5.f("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d");
        b5.c("measurement.id.upload.max_conversions_per_day", 0);
        f5685o = b5.c("measurement.lifetimevalue.max_currency_tracked", 4);
        f5687p = b5.c("measurement.dma_consent.max_daily_dcu_realtime_events", 1);
        f5689q = b5.c("measurement.upload.max_event_parameter_value_length", 500);
        f5691r = b5.c("measurement.store.max_stored_events_per_app", 100000);
        f5693s = b5.c("measurement.experiment.max_ids", 50);
        f5695t = b5.c("measurement.audience.filter_result_max_count", 200);
        f5697u = b5.c("measurement.upload.max_item_scoped_custom_parameters", 27);
        f5699v = b5.c("measurement.rb.max_trigger_registrations_per_day", 1000);
        f5701w = b5.c("measurement.rb.attribution.max_trigger_uris_queried_at_once", 0);
        f5703x = b5.c("measurement.rb.attribution.client.min_ad_services_version", 7);
        f5704y = b5.c("measurement.alarm_manager.minimum_interval", ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        f5705z = b5.c("measurement.upload.minimum_delay", 500);
        f5631A = b5.c("measurement.monitoring.sample_period_millis", 86400000);
        f5632B = b5.c("measurement.rb.attribution.notify_app_delay_millis", 3000);
        f5633C = b5.d("measurement.config.notify_trigger_uris_on_backgrounded", true);
        f5634D = b5.f("measurement.rb.attribution.app_allowlist", "");
        f5635E = b5.c("measurement.upload.realtime_upload_interval", WorkRequest.MIN_BACKOFF_MILLIS);
        f5636F = b5.c("measurement.upload.refresh_blacklisted_config_interval", 604800000);
        b5.c("measurement.config.cache_time.service", 3600000);
        f5637G = b5.c("measurement.service_client.idle_disconnect_millis", 5000);
        b5.f("measurement.log_tag.service", "FA-SVC");
        f5638H = b5.c("measurement.service_client.reconnect_millis", 1000);
        b5.f("measurement.sgtm.app_allowlist", "*");
        f5639I = b5.c("measurement.sgtm.batch.long_queuing_threshold", 240000);
        f5640J = b5.c("measurement.sgtm.batch.retry_interval", 1800000);
        f5641K = b5.c("measurement.sgtm.batch.retry_max_count", 10);
        f5642L = b5.c("measurement.sgtm.batch.retry_max_wait", 21600000);
        f5643M = b5.f("measurement.sgtm.service_upload_apps_list", "");
        f5644N = b5.f("measurement.sgtm.upload.backoff_http_codes", "404,429,503,504");
        f5645O = b5.c("measurement.sgtm.upload.batches_retrieval_limit", 5);
        f5646P = b5.c("measurement.sgtm.upload.max_queued_batches", 5000);
        f5647Q = b5.c("measurement.sgtm.upload.min_delay_after_background", RemoteWorkManager.DEFAULT_SESSION_TIMEOUT_MILLIS);
        f5648R = b5.c("measurement.sgtm.upload.min_delay_after_broadcast", 1000);
        f5649S = b5.c("measurement.sgtm.upload.min_delay_after_startup", 5000);
        f5650T = b5.c("measurement.sgtm.upload.retry_interval", RemoteWorkManager.DEFAULT_SESSION_TIMEOUT_MILLIS);
        f5651U = b5.c("measurement.sgtm.upload.retry_max_wait", 21600000);
        f5652V = b5.c("measurement.upload.stale_data_deletion_interval", 86400000);
        f5653W = b5.c("measurement.rb.attribution.max_retry_delay_seconds", 16);
        f5654X = b5.c("measurement.rb.attribution.client.min_time_after_boot_seconds", 90);
        f5655Y = b5.f("measurement.rb.attribution.uri_authority", "google-analytics.com");
        f5656Z = b5.c("measurement.rb.attribution.max_queue_time", 864000000);
        f5658a0 = b5.f("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion");
        f5660b0 = b5.f("measurement.rb.attribution.query_parameters_to_remove", "");
        f5662c0 = b5.f("measurement.rb.attribution.uri_scheme", "https");
        f5664d0 = b5.c("measurement.sdk.attribution.cache.ttl", 604800000);
        f5666e0 = b5.c("measurement.redaction.app_instance_id.ttl", 7200000);
        f5668f0 = b5.c("measurement.upload.backoff_period", 43200000);
        f5670g0 = b5.c("measurement.upload.initial_upload_delay_time", 15000);
        f5672h0 = b5.c("measurement.upload.interval", 3600000);
        f5674i0 = b5.c("measurement.upload.max_bundle_size", 65536);
        f5676j0 = b5.c("measurement.upload.max_bundles", 100);
        f5678k0 = b5.c("measurement.upload.max_conversions_per_day", 500);
        f5680l0 = b5.c("measurement.upload.max_error_events_per_day", 1000);
        f5682m0 = b5.c("measurement.upload.max_events_per_bundle", 1000);
        f5684n0 = b5.c("measurement.upload.max_events_per_day", 100000);
        f5686o0 = b5.c("measurement.upload.max_public_events_per_day", 50000);
        f5688p0 = b5.c("measurement.upload.max_queue_time", 518400000);
        f5690q0 = b5.c("measurement.upload.max_realtime_events_per_day", 10);
        f5692r0 = b5.c("measurement.upload.max_batch_size", 65536);
        f5694s0 = b5.c("measurement.upload.retry_count", 6);
        f5696t0 = b5.c("measurement.upload.retry_time", 1800000);
        f5698u0 = b5.f("measurement.upload.url", "https://app-measurement.com/a");
        f5700v0 = b5.c("measurement.upload.window_interval", 3600000);
        f5702w0 = b5.f("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot");
    }

    public final long A() {
        return ((Long) f5657a.d()).longValue();
    }

    public final long B() {
        return ((Long) f5659b.d()).longValue();
    }

    public final long C() {
        return ((Long) f5663d.d()).longValue();
    }

    public final long D() {
        return ((Long) f5684n0.d()).longValue();
    }

    public final long E() {
        return ((Long) f5642L.d()).longValue();
    }

    public final long F() {
        return ((Long) f5701w.d()).longValue();
    }

    public final long G() {
        return ((Long) f5666e0.d()).longValue();
    }

    public final long H() {
        return ((Long) f5700v0.d()).longValue();
    }

    public final String I() {
        return (String) f5634D.d();
    }

    public final long J() {
        return ((Long) f5651U.d()).longValue();
    }

    public final long K() {
        return ((Long) f5685o.d()).longValue();
    }

    public final String L() {
        return (String) f5643M.d();
    }

    public final long M() {
        return ((Long) f5686o0.d()).longValue();
    }

    public final long N() {
        return ((Long) f5635E.d()).longValue();
    }

    public final long O() {
        return ((Long) f5652V.d()).longValue();
    }

    public final long P() {
        return ((Long) f5703x.d()).longValue();
    }

    public final long Q() {
        return ((Long) f5668f0.d()).longValue();
    }

    public final String R() {
        return (String) f5702w0.d();
    }

    public final long S() {
        return ((Long) f5680l0.d()).longValue();
    }

    public final long T() {
        return ((Long) f5640J.d()).longValue();
    }

    public final String U() {
        return (String) f5662c0.d();
    }

    public final long V() {
        return ((Long) f5696t0.d()).longValue();
    }

    public final long W() {
        return ((Long) f5632B.d()).longValue();
    }

    public final long X() {
        return ((Long) f5697u.d()).longValue();
    }

    public final long Y() {
        return ((Long) f5649S.d()).longValue();
    }

    public final long Z() {
        return ((Long) f5682m0.d()).longValue();
    }

    public final String a() {
        return (String) f5671h.d();
    }

    public final long a0() {
        return ((Long) f5681m.d()).longValue();
    }

    public final boolean b() {
        return ((Boolean) f5661c.d()).booleanValue();
    }

    public final long b0() {
        return ((Long) f5641K.d()).longValue();
    }

    public final long c() {
        return ((Long) f5667f.d()).longValue();
    }

    public final long c0() {
        return ((Long) f5699v.d()).longValue();
    }

    public final String d() {
        return (String) f5665e.d();
    }

    public final long d0() {
        return ((Long) f5664d0.d()).longValue();
    }

    public final long e() {
        return ((Long) f5673i.d()).longValue();
    }

    public final String e0() {
        return (String) f5698u0.d();
    }

    public final String f() {
        return (String) f5669g.d();
    }

    public final long f0() {
        return ((Long) f5650T.d()).longValue();
    }

    public final String g() {
        return (String) f5679l.d();
    }

    public final boolean g0() {
        return ((Boolean) f5633C.d()).booleanValue();
    }

    public final long h() {
        return ((Long) f5675j.d()).longValue();
    }

    public final long h0() {
        return ((Long) f5676j0.d()).longValue();
    }

    public final String i() {
        return (String) f5677k.d();
    }

    public final long i0() {
        return ((Long) f5646P.d()).longValue();
    }

    public final long j() {
        return ((Long) f5695t.d()).longValue();
    }

    public final String j0() {
        return (String) f5658a0.d();
    }

    public final String k() {
        return (String) f5644N.d();
    }

    public final long k0() {
        return ((Long) f5692r0.d()).longValue();
    }

    public final long l() {
        return ((Long) f5687p.d()).longValue();
    }

    public final long l0() {
        return ((Long) f5638H.d()).longValue();
    }

    public final long m() {
        return ((Long) f5688p0.d()).longValue();
    }

    public final String m0() {
        return (String) f5655Y.d();
    }

    public final long n() {
        return ((Long) f5636F.d()).longValue();
    }

    public final long n0() {
        return ((Long) f5693s.d()).longValue();
    }

    public final long o() {
        return ((Long) f5653W.d()).longValue();
    }

    public final long o0() {
        return ((Long) f5647Q.d()).longValue();
    }

    public final long p() {
        return ((Long) f5704y.d()).longValue();
    }

    public final long p0() {
        return ((Long) f5674i0.d()).longValue();
    }

    public final long q() {
        return ((Long) f5670g0.d()).longValue();
    }

    public final long q0() {
        return ((Long) f5678k0.d()).longValue();
    }

    public final long r() {
        return ((Long) f5689q.d()).longValue();
    }

    public final long r0() {
        return ((Long) f5639I.d()).longValue();
    }

    public final long s() {
        return ((Long) f5645O.d()).longValue();
    }

    public final long s0() {
        return ((Long) f5656Z.d()).longValue();
    }

    public final long t() {
        return ((Long) f5705z.d()).longValue();
    }

    public final String t0() {
        return (String) f5660b0.d();
    }

    public final long u() {
        return ((Long) f5690q0.d()).longValue();
    }

    public final long u0() {
        return ((Long) f5694s0.d()).longValue();
    }

    public final long v() {
        return ((Long) f5637G.d()).longValue();
    }

    public final long v0() {
        return ((Long) f5648R.d()).longValue();
    }

    public final long w() {
        return ((Long) f5654X.d()).longValue();
    }

    public final long w0() {
        return ((Long) f5631A.d()).longValue();
    }

    public final long x() {
        return ((Long) f5691r.d()).longValue();
    }

    public final long y() {
        return ((Long) f5672h0.d()).longValue();
    }

    public final String z() {
        return (String) f5683n.d();
    }
}
