package com.google.android.gms.internal.measurement;

public final class E6 implements D6 {

    /* renamed from: a  reason: collision with root package name */
    public static final C1160m4 f4944a;

    /* renamed from: b  reason: collision with root package name */
    public static final C1160m4 f4945b;

    static {
        C1106g4 b5 = new C1106g4(C1061b4.a("com.google.android.gms.measurement")).a().b();
        b5.d("measurement.set_default_event_parameters_with_backfill.client.dev", false);
        b5.d("measurement.set_default_event_parameters_with_backfill.service", true);
        b5.c("measurement.id.set_default_event_parameters.fix_service_request_ordering", 0);
        f4944a = b5.d("measurement.set_default_event_parameters.fix_app_update_logging", true);
        f4945b = b5.d("measurement.set_default_event_parameters.fix_service_request_ordering", false);
        b5.d("measurement.set_default_event_parameters.fix_subsequent_launches", true);
    }

    public final boolean A() {
        return ((Boolean) f4944a.d()).booleanValue();
    }

    public final boolean B() {
        return ((Boolean) f4945b.d()).booleanValue();
    }
}
