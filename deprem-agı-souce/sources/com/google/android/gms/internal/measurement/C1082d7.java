package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.d7  reason: case insensitive filesystem */
public final class C1082d7 implements C1073c7 {

    /* renamed from: a  reason: collision with root package name */
    public static final C1160m4 f5330a;

    static {
        C1106g4 b5 = new C1106g4(C1061b4.a("com.google.android.gms.measurement")).a().b();
        b5.d("measurement.gmscore_feature_tracking", true);
        f5330a = b5.d("measurement.gmscore_client_telemetry", false);
    }

    public final boolean A() {
        return ((Boolean) f5330a.d()).booleanValue();
    }
}
