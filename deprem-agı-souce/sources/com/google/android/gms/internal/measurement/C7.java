package com.google.android.gms.internal.measurement;

public final class C7 implements B7 {

    /* renamed from: a  reason: collision with root package name */
    public static final C1160m4 f4933a;

    static {
        C1106g4 b5 = new C1106g4(C1061b4.a("com.google.android.gms.measurement")).a().b();
        f4933a = b5.d("measurement.client.sessions.enable_fix_background_engagement", false);
        b5.d("measurement.client.sessions.enable_pause_engagement_in_background", true);
        b5.c("measurement.id.client.sessions.enable_fix_background_engagement", 0);
    }

    public final boolean A() {
        return ((Boolean) f4933a.d()).booleanValue();
    }
}
