package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.m7  reason: case insensitive filesystem */
public final class C1163m7 implements C1154l7 {

    /* renamed from: a  reason: collision with root package name */
    public static final C1160m4 f5471a;

    /* renamed from: b  reason: collision with root package name */
    public static final C1160m4 f5472b;

    /* renamed from: c  reason: collision with root package name */
    public static final C1160m4 f5473c;

    /* renamed from: d  reason: collision with root package name */
    public static final C1160m4 f5474d;

    /* renamed from: e  reason: collision with root package name */
    public static final C1160m4 f5475e;

    /* renamed from: f  reason: collision with root package name */
    public static final C1160m4 f5476f;

    /* renamed from: g  reason: collision with root package name */
    public static final C1160m4 f5477g;

    /* renamed from: h  reason: collision with root package name */
    public static final C1160m4 f5478h;

    static {
        C1106g4 b5 = new C1106g4(C1061b4.a("com.google.android.gms.measurement")).a().b();
        b5.d("measurement.rb.attribution.ad_campaign_info", true);
        b5.d("measurement.rb.attribution.service.bundle_on_backgrounded", true);
        f5471a = b5.d("measurement.rb.attribution.client2", true);
        f5472b = b5.d("measurement.rb.attribution.followup1.service", false);
        b5.d("measurement.rb.attribution.client.get_trigger_uris_async", true);
        f5473c = b5.d("measurement.rb.attribution.service.trigger_uris_high_priority", true);
        b5.d("measurement.rb.attribution.index_out_of_bounds_fix", true);
        f5474d = b5.d("measurement.rb.attribution.service.enable_max_trigger_uris_queried_at_once", true);
        f5475e = b5.d("measurement.rb.attribution.retry_disposition", false);
        f5476f = b5.d("measurement.rb.attribution.service", true);
        f5477g = b5.d("measurement.rb.attribution.enable_trigger_redaction", true);
        f5478h = b5.d("measurement.rb.attribution.uuid_generation", true);
        b5.c("measurement.id.rb.attribution.retry_disposition", 0);
        b5.d("measurement.rb.attribution.improved_retry", true);
    }

    public final boolean A() {
        return true;
    }

    public final boolean B() {
        return ((Boolean) f5471a.d()).booleanValue();
    }

    public final boolean C() {
        return ((Boolean) f5473c.d()).booleanValue();
    }

    public final boolean a() {
        return ((Boolean) f5477g.d()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f5472b.d()).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) f5475e.d()).booleanValue();
    }

    public final boolean d() {
        return ((Boolean) f5474d.d()).booleanValue();
    }

    public final boolean e() {
        return ((Boolean) f5478h.d()).booleanValue();
    }

    public final boolean f() {
        return ((Boolean) f5476f.d()).booleanValue();
    }
}
