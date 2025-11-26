package com.google.android.gms.internal.measurement;

public final class H6 implements G6 {

    /* renamed from: a  reason: collision with root package name */
    public static final C1160m4 f4961a;

    /* renamed from: b  reason: collision with root package name */
    public static final C1160m4 f4962b;

    static {
        C1106g4 b5 = new C1106g4(C1061b4.a("com.google.android.gms.measurement")).a().b();
        f4961a = b5.d("measurement.set_default_event_parameters_propagate_clear.client.dev", true);
        f4962b = b5.d("measurement.set_default_event_parameters_propagate_clear.service", true);
    }

    public final boolean A() {
        return ((Boolean) f4961a.d()).booleanValue();
    }

    public final boolean B() {
        return ((Boolean) f4962b.d()).booleanValue();
    }
}
