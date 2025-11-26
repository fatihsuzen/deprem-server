package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.p7  reason: case insensitive filesystem */
public final class C1190p7 implements C1181o7 {

    /* renamed from: a  reason: collision with root package name */
    public static final C1160m4 f5538a;

    static {
        C1106g4 b5 = new C1106g4(C1061b4.a("com.google.android.gms.measurement")).a().b();
        f5538a = b5.d("measurement.add_first_launch_logging_timestamp.service", false);
        b5.c("measurement.id.add_first_launch_logging_timestamp.service", 0);
    }

    public final boolean A() {
        return ((Boolean) f5538a.d()).booleanValue();
    }
}
