package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.j7  reason: case insensitive filesystem */
public final class C1136j7 implements C1127i7 {

    /* renamed from: a  reason: collision with root package name */
    public static final C1160m4 f5399a;

    /* renamed from: b  reason: collision with root package name */
    public static final C1160m4 f5400b;

    /* renamed from: c  reason: collision with root package name */
    public static final C1160m4 f5401c;

    /* renamed from: d  reason: collision with root package name */
    public static final C1160m4 f5402d;

    /* renamed from: e  reason: collision with root package name */
    public static final C1160m4 f5403e;

    /* renamed from: f  reason: collision with root package name */
    public static final C1160m4 f5404f;

    static {
        C1106g4 b5 = new C1106g4(C1061b4.a("com.google.android.gms.measurement")).a().b();
        f5399a = b5.d("measurement.test.boolean_flag", false);
        f5400b = b5.c("measurement.test.cached_long_flag", -1);
        f5401c = b5.e("measurement.test.double_flag", -3.0d);
        f5402d = b5.c("measurement.test.int_flag", -2);
        f5403e = b5.c("measurement.test.long_flag", -1);
        f5404f = b5.f("measurement.test.string_flag", "---");
    }

    public final boolean A() {
        return ((Boolean) f5399a.d()).booleanValue();
    }

    public final long B() {
        return ((Long) f5400b.d()).longValue();
    }

    public final long C() {
        return ((Long) f5402d.d()).longValue();
    }

    public final double b() {
        return ((Double) f5401c.d()).doubleValue();
    }

    public final String c() {
        return (String) f5404f.d();
    }

    public final long d() {
        return ((Long) f5403e.d()).longValue();
    }
}
