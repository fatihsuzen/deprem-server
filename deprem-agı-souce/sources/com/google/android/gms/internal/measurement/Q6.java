package com.google.android.gms.internal.measurement;

public final class Q6 implements P6 {

    /* renamed from: a  reason: collision with root package name */
    public static final C1160m4 f5152a;

    /* renamed from: b  reason: collision with root package name */
    public static final C1160m4 f5153b;

    /* renamed from: c  reason: collision with root package name */
    public static final C1160m4 f5154c;

    static {
        C1106g4 b5 = new C1106g4(C1061b4.a("com.google.android.gms.measurement")).a().b();
        b5.d("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f5152a = b5.d("measurement.audience.refresh_event_count_filters_timestamp", false);
        f5153b = b5.d("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        f5154c = b5.d("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    public final boolean A() {
        return true;
    }

    public final boolean B() {
        return ((Boolean) f5152a.d()).booleanValue();
    }

    public final boolean C() {
        return ((Boolean) f5154c.d()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f5153b.d()).booleanValue();
    }
}
