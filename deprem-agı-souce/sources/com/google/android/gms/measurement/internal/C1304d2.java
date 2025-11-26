package com.google.android.gms.measurement.internal;

import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.multiprocess.RemoteWorkManager;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.d2  reason: case insensitive filesystem */
public abstract class C1304d2 {

    /* renamed from: A  reason: collision with root package name */
    public static final C1296c2 f6260A;

    /* renamed from: A0  reason: collision with root package name */
    public static final C1296c2 f6261A0;

    /* renamed from: B  reason: collision with root package name */
    public static final C1296c2 f6262B = a("measurement.sgtm.upload.batches_retrieval_limit", 5, 5, C1379n0.f6572a, false);

    /* renamed from: B0  reason: collision with root package name */
    public static final C1296c2 f6263B0;

    /* renamed from: C  reason: collision with root package name */
    public static final C1296c2 f6264C = a("measurement.sgtm.upload.min_delay_after_startup", 5000L, 5000L, C1386o0.f6589a, false);

    /* renamed from: C0  reason: collision with root package name */
    public static final C1296c2 f6265C0 = a("measurement.rb.attribution.notify_app_delay_millis", 3000, 3000, C1428u1.f6763a, false);

    /* renamed from: D  reason: collision with root package name */
    public static final C1296c2 f6266D = a("measurement.sgtm.upload.min_delay_after_broadcast", 1000L, 1000L, C1393p0.f6607a, false);

    /* renamed from: D0  reason: collision with root package name */
    public static final C1296c2 f6267D0;

    /* renamed from: E  reason: collision with root package name */
    public static final C1296c2 f6268E;

    /* renamed from: E0  reason: collision with root package name */
    public static final C1296c2 f6269E0;

    /* renamed from: F  reason: collision with root package name */
    public static final C1296c2 f6270F = a("measurement.sgtm.batch.long_queuing_threshold", 14400000L, 14400000L, C1406r0.f6687a, false);

    /* renamed from: F0  reason: collision with root package name */
    public static final C1296c2 f6271F0;

    /* renamed from: G  reason: collision with root package name */
    public static final C1296c2 f6272G = a("measurement.upload.backoff_period", 43200000L, 43200000L, C1420t0.f6721a, false);

    /* renamed from: G0  reason: collision with root package name */
    public static final C1296c2 f6273G0;

    /* renamed from: H  reason: collision with root package name */
    public static final C1296c2 f6274H = a("measurement.upload.window_interval", 3600000L, 3600000L, C1427u0.f6762a, false);

    /* renamed from: H0  reason: collision with root package name */
    public static final C1296c2 f6275H0;

    /* renamed from: I  reason: collision with root package name */
    public static final C1296c2 f6276I = a("measurement.upload.interval", 3600000L, 3600000L, C1434v0.f6779a, false);

    /* renamed from: I0  reason: collision with root package name */
    public static final C1296c2 f6277I0;

    /* renamed from: J  reason: collision with root package name */
    public static final C1296c2 f6278J;

    /* renamed from: J0  reason: collision with root package name */
    public static final C1296c2 f6279J0;

    /* renamed from: K  reason: collision with root package name */
    public static final C1296c2 f6280K = a("measurement.upload.debug_upload_interval", 1000L, 1000L, C1448x0.f6860a, false);

    /* renamed from: K0  reason: collision with root package name */
    public static final C1296c2 f6281K0 = a("measurement.service.storage_consent_support_version", 203600, 203600, C1.f5805a, false);

    /* renamed from: L  reason: collision with root package name */
    public static final C1296c2 f6282L = a("measurement.upload.minimum_delay", 500L, 500L, C1455y0.f6903a, false);

    /* renamed from: L0  reason: collision with root package name */
    public static final C1296c2 f6283L0;

    /* renamed from: M  reason: collision with root package name */
    public static final C1296c2 f6284M;

    /* renamed from: M0  reason: collision with root package name */
    public static final C1296c2 f6285M0;

    /* renamed from: N  reason: collision with root package name */
    public static final C1296c2 f6286N = a("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, A0.f5724a, false);

    /* renamed from: N0  reason: collision with root package name */
    public static final C1296c2 f6287N0;

    /* renamed from: O  reason: collision with root package name */
    public static final C1296c2 f6288O = a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, B0.f5750a, false);

    /* renamed from: O0  reason: collision with root package name */
    public static final C1296c2 f6289O0;

    /* renamed from: P  reason: collision with root package name */
    public static final C1296c2 f6290P = a("measurement.upload.initial_upload_delay_time", 15000L, 15000L, D0.f5817a, false);

    /* renamed from: P0  reason: collision with root package name */
    public static final C1296c2 f6291P0;

    /* renamed from: Q  reason: collision with root package name */
    public static final C1296c2 f6292Q = a("measurement.upload.retry_time", 1800000L, 1800000L, F0.f5869a, false);

    /* renamed from: Q0  reason: collision with root package name */
    public static final C1296c2 f6293Q0;

    /* renamed from: R  reason: collision with root package name */
    public static final C1296c2 f6294R = a("measurement.upload.retry_count", 6, 6, G0.f5887a, false);

    /* renamed from: R0  reason: collision with root package name */
    public static final C1296c2 f6295R0;

    /* renamed from: S  reason: collision with root package name */
    public static final C1296c2 f6296S = a("measurement.upload.max_queue_time", 518400000L, 518400000L, H0.f5905a, false);

    /* renamed from: S0  reason: collision with root package name */
    public static final C1296c2 f6297S0;

    /* renamed from: T  reason: collision with root package name */
    public static final C1296c2 f6298T;

    /* renamed from: T0  reason: collision with root package name */
    public static final C1296c2 f6299T0;

    /* renamed from: U  reason: collision with root package name */
    public static final C1296c2 f6300U = a("measurement.lifetimevalue.max_currency_tracked", 4, 4, J0.f5932a, false);

    /* renamed from: U0  reason: collision with root package name */
    public static final C1296c2 f6301U0;

    /* renamed from: V  reason: collision with root package name */
    public static final C1296c2 f6302V = a("measurement.audience.filter_result_max_count", 200, 200, K0.f5945a, false);

    /* renamed from: V0  reason: collision with root package name */
    public static final C1296c2 f6303V0;

    /* renamed from: W  reason: collision with root package name */
    public static final C1296c2 f6304W = a("measurement.upload.max_public_user_properties", 100, 100, (N) null, false);

    /* renamed from: W0  reason: collision with root package name */
    public static final C1296c2 f6305W0;

    /* renamed from: X  reason: collision with root package name */
    public static final C1296c2 f6306X = a("measurement.upload.max_event_name_cardinality", 2000, 2000, (N) null, false);

    /* renamed from: X0  reason: collision with root package name */
    public static final C1296c2 f6307X0;

    /* renamed from: Y  reason: collision with root package name */
    public static final C1296c2 f6308Y = a("measurement.upload.max_public_event_params", 100, 100, (N) null, false);

    /* renamed from: Y0  reason: collision with root package name */
    public static final C1296c2 f6309Y0;

    /* renamed from: Z  reason: collision with root package name */
    public static final C1296c2 f6310Z = a("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, L0.f5958a, false);

    /* renamed from: Z0  reason: collision with root package name */
    public static final C1296c2 f6311Z0;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final List f6312a = DesugarCollections.synchronizedList(new ArrayList());

    /* renamed from: a0  reason: collision with root package name */
    public static final C1296c2 f6313a0 = a("measurement.service_client.reconnect_millis", 1000L, 1000L, M0.f5969a, false);

    /* renamed from: a1  reason: collision with root package name */
    public static final C1296c2 f6314a1;

    /* renamed from: b  reason: collision with root package name */
    public static final C1296c2 f6315b;

    /* renamed from: b0  reason: collision with root package name */
    public static final C1296c2 f6316b0;

    /* renamed from: b1  reason: collision with root package name */
    public static final C1296c2 f6317b1;

    /* renamed from: c  reason: collision with root package name */
    public static final C1296c2 f6318c = a("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L, 3600000L, O.f6001a, false);

    /* renamed from: c0  reason: collision with root package name */
    public static final C1296c2 f6319c0 = a("measurement.test.string_flag", "---", "---", O0.f6002a, false);

    /* renamed from: c1  reason: collision with root package name */
    public static final C1296c2 f6320c1;

    /* renamed from: d  reason: collision with root package name */
    public static final C1296c2 f6321d = a("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, C1334h0.f6454a, false);

    /* renamed from: d0  reason: collision with root package name */
    public static final C1296c2 f6322d0 = a("measurement.test.long_flag", -1L, -1L, Q0.f6037a, false);

    /* renamed from: d1  reason: collision with root package name */
    public static final C1296c2 f6323d1;

    /* renamed from: e  reason: collision with root package name */
    public static final C1296c2 f6324e = a("measurement.config.cache_time", 86400000L, 3600000L, C1413s0.f6702a, false);

    /* renamed from: e0  reason: collision with root package name */
    public static final C1296c2 f6325e0 = a("measurement.test.int_flag", -2, -2, S0.f6067a, false);

    /* renamed from: e1  reason: collision with root package name */
    public static final C1296c2 f6326e1;

    /* renamed from: f  reason: collision with root package name */
    public static final C1296c2 f6327f = a("measurement.config.url_scheme", "https", "https", E0.f5831a, false);

    /* renamed from: f0  reason: collision with root package name */
    public static final C1296c2 f6328f0;

    /* renamed from: f1  reason: collision with root package name */
    public static final C1296c2 f6329f1;

    /* renamed from: g  reason: collision with root package name */
    public static final C1296c2 f6330g = a("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", P0.f6014a, false);

    /* renamed from: g0  reason: collision with root package name */
    public static final C1296c2 f6331g0 = a("measurement.experiment.max_ids", 50, 50, U0.f6102a, false);

    /* renamed from: g1  reason: collision with root package name */
    public static final C1296c2 f6332g1;

    /* renamed from: h  reason: collision with root package name */
    public static final C1296c2 f6333h = a("measurement.upload.max_bundles", 100, 100, C1279a1.f6208a, false);

    /* renamed from: h0  reason: collision with root package name */
    public static final C1296c2 f6334h0 = a("measurement.upload.max_item_scoped_custom_parameters", 27, 27, V0.f6111a, false);

    /* renamed from: h1  reason: collision with root package name */
    public static final C1296c2 f6335h1 = a("measurement.gbraid_compaign.compaign_params_triggering_info_update", "gclid,gbraid,gad_campaignid", "gclid,gbraid,gad_campaignid", T.f6084a, false);

    /* renamed from: i  reason: collision with root package name */
    public static final C1296c2 f6336i = a("measurement.upload.max_batch_size", 65536, 65536, C1373m1.f6543a, false);

    /* renamed from: i0  reason: collision with root package name */
    public static final C1296c2 f6337i0 = a("measurement.upload.max_event_parameter_value_length", 500, 500, W0.f6123a, true);

    /* renamed from: i1  reason: collision with root package name */
    public static final C1296c2 f6338i1;

    /* renamed from: j  reason: collision with root package name */
    public static final C1296c2 f6339j = a("measurement.upload.max_bundle_size", 65536, 65536, C1449x1.f6861a, false);

    /* renamed from: j0  reason: collision with root package name */
    public static final C1296c2 f6340j0 = a("measurement.max_bundles_per_iteration", 100, 100, X0.f6131a, false);

    /* renamed from: j1  reason: collision with root package name */
    public static final C1296c2 f6341j1 = a("measurement.edpb.events_cached_in_no_data_mode", "_f,_v,_cmp", "_f,_v,_cmp", U.f6101a, false);

    /* renamed from: k  reason: collision with root package name */
    public static final C1296c2 f6342k = a("measurement.upload.max_events_per_bundle", 1000, 1000, J1.f5933a, false);

    /* renamed from: k0  reason: collision with root package name */
    public static final C1296c2 f6343k0 = a("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, Y0.f6176a, false);

    /* renamed from: k1  reason: collision with root package name */
    public static final C1296c2 f6344k1;

    /* renamed from: l  reason: collision with root package name */
    public static final C1296c2 f6345l;

    /* renamed from: l0  reason: collision with root package name */
    public static final C1296c2 f6346l0 = a("measurement.redaction.app_instance_id.ttl", 7200000L, 7200000L, Z0.f6190a, false);

    /* renamed from: l1  reason: collision with root package name */
    public static final C1296c2 f6347l1;

    /* renamed from: m  reason: collision with root package name */
    public static final C1296c2 f6348m = a("measurement.upload.max_error_events_per_day", 1000, 1000, W.f6122a, false);

    /* renamed from: m0  reason: collision with root package name */
    public static final C1296c2 f6349m0 = a("measurement.rb.attribution.client.min_ad_services_version", 7, 7, C1287b1.f6219a, false);

    /* renamed from: n  reason: collision with root package name */
    public static final C1296c2 f6350n;

    /* renamed from: n0  reason: collision with root package name */
    public static final C1296c2 f6351n0 = a("measurement.dma_consent.max_daily_dcu_realtime_events", 1, 1, C1295c1.f6237a, false);

    /* renamed from: o  reason: collision with root package name */
    public static final C1296c2 f6352o = a("measurement.upload.max_conversions_per_day", 10000, 10000, Y.f6175a, false);

    /* renamed from: o0  reason: collision with root package name */
    public static final C1296c2 f6353o0 = a("measurement.rb.attribution.uri_scheme", "https", "https", C1311e1.f6390a, false);

    /* renamed from: p  reason: collision with root package name */
    public static final C1296c2 f6354p = a("measurement.upload.max_realtime_events_per_day", 10, 10, Z.f6189a, false);

    /* renamed from: p0  reason: collision with root package name */
    public static final C1296c2 f6355p0 = a("measurement.rb.attribution.uri_authority", "google-analytics.com", "google-analytics.com", C1319f1.f6404a, false);

    /* renamed from: q  reason: collision with root package name */
    public static final C1296c2 f6356q;

    /* renamed from: q0  reason: collision with root package name */
    public static final C1296c2 f6357q0 = a("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion", "privacy-sandbox/register-app-conversion", C1327g1.f6424a, false);

    /* renamed from: r  reason: collision with root package name */
    public static final C1296c2 f6358r = a("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", C1294c0.f6236a, false);

    /* renamed from: r0  reason: collision with root package name */
    public static final C1296c2 f6359r0 = a("measurement.session.engagement_interval", 3600000L, 3600000L, C1335h1.f6455a, false);

    /* renamed from: s  reason: collision with root package name */
    public static final C1296c2 f6360s = a("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d", "https://app-measurement.com/s/d", C1302d0.f6258a, false);

    /* renamed from: s0  reason: collision with root package name */
    public static final C1296c2 f6361s0 = a("measurement.rb.attribution.app_allowlist", "", "", C1343i1.f6482a, false);

    /* renamed from: t  reason: collision with root package name */
    public static final C1296c2 f6362t = a("measurement.sgtm.service_upload_apps_list", "", "", C1310e0.f6389a, false);

    /* renamed from: t0  reason: collision with root package name */
    public static final C1296c2 f6363t0 = a("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot", "_npa,npa|_fot,fot", C1351j1.f6497a, false);

    /* renamed from: u  reason: collision with root package name */
    public static final C1296c2 f6364u = a("measurement.sgtm.upload.backoff_http_codes", "404,429,503,504", "404,429,503,504", C1318f0.f6403a, false);

    /* renamed from: u0  reason: collision with root package name */
    public static final C1296c2 f6365u0 = a("measurement.rb.attribution.event_params", "value|currency", "value|currency", C1359k1.f6514a, false);

    /* renamed from: v  reason: collision with root package name */
    public static final C1296c2 f6366v;

    /* renamed from: v0  reason: collision with root package name */
    public static final C1296c2 f6367v0 = a("measurement.rb.attribution.query_parameters_to_remove", "", "", C1366l1.f6529a, false);

    /* renamed from: w  reason: collision with root package name */
    public static final C1296c2 f6368w = a("measurement.sgtm.upload.retry_max_wait", 21600000L, 21600000L, C1342i0.f6481a, false);

    /* renamed from: w0  reason: collision with root package name */
    public static final C1296c2 f6369w0 = a("measurement.rb.attribution.max_queue_time", 864000000L, 864000000L, C1380n1.f6573a, false);

    /* renamed from: x  reason: collision with root package name */
    public static final C1296c2 f6370x = a("measurement.sgtm.batch.retry_interval", 1800000L, 1800000L, C1350j0.f6496a, false);

    /* renamed from: x0  reason: collision with root package name */
    public static final C1296c2 f6371x0 = a("measurement.rb.attribution.max_retry_delay_seconds", 16, 16, C1387o1.f6590a, false);

    /* renamed from: y  reason: collision with root package name */
    public static final C1296c2 f6372y = a("measurement.sgtm.batch.retry_max_wait", 21600000L, 21600000L, C1358k0.f6513a, false);

    /* renamed from: y0  reason: collision with root package name */
    public static final C1296c2 f6373y0 = a("measurement.rb.attribution.client.min_time_after_boot_seconds", 90, 90, C1394p1.f6608a, false);

    /* renamed from: z  reason: collision with root package name */
    public static final C1296c2 f6374z = a("measurement.sgtm.batch.retry_max_count", 10, 10, C1365l0.f6528a, false);

    /* renamed from: z0  reason: collision with root package name */
    public static final C1296c2 f6375z0 = a("measurement.rb.max_trigger_registrations_per_day", 1000, 1000, C1407r1.f6688a, false);

    static {
        DesugarCollections.synchronizedSet(new HashSet());
        Long valueOf = Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS);
        f6315b = a("measurement.ad_id_cache_time", valueOf, valueOf, V1.f6112a, false);
        Integer valueOf2 = Integer.valueOf(DefaultOggSeeker.MATCH_BYTE_RANGE);
        f6345l = a("measurement.upload.max_events_per_day", valueOf2, valueOf2, U1.f6103a, false);
        Integer valueOf3 = Integer.valueOf(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS);
        f6350n = a("measurement.upload.max_public_events_per_day", valueOf3, valueOf3, X.f6130a, false);
        f6356q = a("measurement.store.max_stored_events_per_app", valueOf2, valueOf2, C1278a0.f6207a, false);
        Long valueOf4 = Long.valueOf(RemoteWorkManager.DEFAULT_SESSION_TIMEOUT_MILLIS);
        f6366v = a("measurement.sgtm.upload.retry_interval", valueOf4, valueOf4, C1326g0.f6423a, false);
        Integer valueOf5 = Integer.valueOf(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS);
        f6260A = a("measurement.sgtm.upload.max_queued_batches", valueOf5, valueOf5, C1372m0.f6542a, false);
        f6268E = a("measurement.sgtm.upload.min_delay_after_background", valueOf4, valueOf4, C1400q0.f6625a, false);
        f6278J = a("measurement.upload.realtime_upload_interval", valueOf, valueOf, C1441w0.f6796a, false);
        Long valueOf6 = Long.valueOf(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        f6284M = a("measurement.alarm_manager.minimum_interval", valueOf6, valueOf6, C1462z0.f6920a, false);
        Long valueOf7 = Long.valueOf(PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        f6298T = a("measurement.upload.google_signal_max_queue_time", valueOf7, valueOf7, I0.f5915a, false);
        Boolean bool = Boolean.FALSE;
        f6316b0 = a("measurement.test.boolean_flag", bool, bool, N0.f5985a, false);
        a("measurement.test.cached_long_flag", -1L, -1L, R0.f6047a, true);
        Double valueOf8 = Double.valueOf(-3.0d);
        f6328f0 = a("measurement.test.double_flag", valueOf8, valueOf8, T0.f6085a, false);
        a("measurement.rb.attribution.max_trigger_uris_queried_at_once", 0, 0, C1401q1.f6626a, false);
        Boolean bool2 = Boolean.TRUE;
        f6261A0 = a("measurement.config.bundle_for_all_apps_on_backgrounded", bool2, bool2, C1414s1.f6703a, false);
        f6263B0 = a("measurement.config.notify_trigger_uris_on_backgrounded", bool2, bool2, C1421t1.f6722a, false);
        f6267D0 = a("measurement.quality.checksum", bool, bool, (N) null, false);
        f6269E0 = a("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, bool, C1435v1.f6780a, false);
        f6271F0 = a("measurement.audience.refresh_event_count_filters_timestamp", bool, bool, C1442w1.f6797a, false);
        f6273G0 = a("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, bool, C1456y1.f6904a, true);
        f6275H0 = a("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, bool, C1463z1.f6921a, false);
        f6277I0 = a("measurement.integration.disable_firebase_instance_id", bool, bool, A1.f5725a, false);
        f6279J0 = a("measurement.collection.service.update_with_analytics_fix", bool, bool, B1.f5751a, false);
        f6283L0 = a("measurement.service.store_null_safelist", bool2, bool2, D1.f5818a, false);
        f6285M0 = a("measurement.service.store_safelist", bool2, bool2, F1.f5870a, false);
        f6287N0 = a("measurement.session_stitching_token_enabled", bool, bool, G1.f5888a, false);
        f6289O0 = a("measurement.sgtm.client.upload_on_backgrounded.dev", bool, bool, H1.f5906a, true);
        f6291P0 = a("measurement.gmscore_client_telemetry", bool, bool, Y1.f6177a, false);
        f6293Q0 = a("measurement.rb.attribution.service", bool2, bool2, I1.f5916a, true);
        f6295R0 = a("measurement.rb.attribution.client2", bool2, bool2, K1.f5946a, true);
        f6297S0 = a("measurement.rb.attribution.uuid_generation", bool2, bool2, L1.f5959a, false);
        f6299T0 = a("measurement.rb.attribution.enable_trigger_redaction", bool2, bool2, M1.f5970a, false);
        a("measurement.rb.attribution.followup1.service", bool, bool, N1.f5986a, false);
        f6301U0 = a("measurement.rb.attribution.retry_disposition", bool, bool, O1.f6003a, false);
        f6303V0 = a("measurement.client.sessions.enable_fix_background_engagement", bool, bool, C1288b2.f6220a, false);
        f6305W0 = a("measurement.set_default_event_parameters_propagate_clear.service.dev", bool2, bool2, P1.f6015a, false);
        f6307X0 = a("measurement.set_default_event_parameters_propagate_clear.client.dev", bool2, bool2, Q1.f6038a, false);
        f6309Y0 = a("measurement.service.ad_impression.convert_value_to_double", bool2, bool2, R1.f6048a, false);
        a("measurement.rb.attribution.service.enable_max_trigger_uris_queried_at_once", bool2, bool2, S1.f6068a, false);
        a("measurement.remove_conflicting_first_party_apis.dev", bool, bool, T1.f6086a, false);
        f6311Z0 = a("measurement.rb.attribution.service.trigger_uris_high_priority", bool2, bool2, P.f6013a, false);
        f6314a1 = a("measurement.tcf.consent_fix", bool2, bool2, Q.f6036a, false);
        f6317b1 = a("measurement.experiment.enable_phenotype_experiment_reporting", bool2, bool2, S.f6066a, false);
        f6320c1 = a("measurement.set_default_event_parameters.fix_service_request_ordering", bool, bool, J.f5931a, false);
        f6323d1 = a("measurement.set_default_event_parameters.fix_app_update_logging", bool2, bool2, I.f5914a, false);
        f6326e1 = a("measurement.service.fix_stop_bundling_bug", bool2, bool2, M.f5968a, false);
        f6329f1 = a("measurement.fix_params_logcat_spam", bool2, bool2, L.f5957a, false);
        f6332g1 = a("measurement.gbraid_campaign.stop_lgclid", bool, bool, X1.f6132a, false);
        f6338i1 = a("measurement.edpb.service", bool, bool, K.f5944a, false);
        f6344k1 = a("measurement.add_first_launch_logging_timestamp.service", bool, bool, C1280a2.f6209a, false);
        f6347l1 = a("measurement.overlapping_bundles_fix", bool, bool, V.f6110a, false);
    }

    static C1296c2 a(String str, Object obj, Object obj2, N n5, boolean z4) {
        C1296c2 c2Var = new C1296c2(str, obj, obj2, n5, (byte[]) null);
        if (z4) {
            f6312a.add(c2Var);
        }
        return c2Var;
    }
}
