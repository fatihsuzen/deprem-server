package com.google.android.gms.internal.measurement;

public final class N6 implements M6 {

    /* renamed from: a  reason: collision with root package name */
    public static final C1160m4 f5039a;

    /* renamed from: b  reason: collision with root package name */
    public static final C1160m4 f5040b;

    static {
        C1106g4 b5 = new C1106g4(C1061b4.a("com.google.android.gms.measurement")).a().b();
        b5.d("measurement.collection.event_safelist", true);
        f5039a = b5.d("measurement.service.store_null_safelist", true);
        f5040b = b5.d("measurement.service.store_safelist", true);
    }

    public final boolean A() {
        return true;
    }

    public final boolean B() {
        return ((Boolean) f5039a.d()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f5040b.d()).booleanValue();
    }
}
