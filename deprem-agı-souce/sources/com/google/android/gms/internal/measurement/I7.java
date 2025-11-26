package com.google.android.gms.internal.measurement;

public final class I7 implements H7 {

    /* renamed from: a  reason: collision with root package name */
    public static final C1160m4 f4982a;

    static {
        C1106g4 b5 = new C1106g4(C1061b4.a("com.google.android.gms.measurement")).a().b();
        f4982a = b5.d("measurement.tcf.consent_fix", true);
        b5.d("measurement.tcf.client", true);
        b5.d("measurement.tcf.empty_pref_fix", true);
    }

    public final boolean A() {
        return ((Boolean) f4982a.d()).booleanValue();
    }
}
