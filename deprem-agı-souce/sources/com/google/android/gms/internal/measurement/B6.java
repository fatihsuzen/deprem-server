package com.google.android.gms.internal.measurement;

public final class B6 implements A6 {

    /* renamed from: a  reason: collision with root package name */
    public static final C1160m4 f4927a;

    static {
        C1106g4 b5 = new C1106g4(C1061b4.a("com.google.android.gms.measurement")).a().b();
        b5.d("measurement.client.3p_consent_state_v1", true);
        f4927a = b5.c("measurement.service.storage_consent_support_version", 203600);
    }

    public final long A() {
        return ((Long) f4927a.d()).longValue();
    }
}
