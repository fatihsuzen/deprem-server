package com.google.android.gms.internal.measurement;

public final class z7 implements y7 {

    /* renamed from: a  reason: collision with root package name */
    public static final C1160m4 f5713a;

    static {
        C1106g4 b5 = new C1106g4(C1061b4.a("com.google.android.gms.measurement")).a().b();
        f5713a = b5.d("measurement.session_stitching_token_enabled", false);
        b5.d("measurement.link_sst_to_sid", true);
    }

    public final boolean A() {
        return true;
    }

    public final boolean B() {
        return ((Boolean) f5713a.d()).booleanValue();
    }
}
