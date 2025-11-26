package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.w5  reason: case insensitive filesystem */
final class C1250w5 implements R5 {

    /* renamed from: b  reason: collision with root package name */
    private static final D5 f5617b = new C1232u5();

    /* renamed from: a  reason: collision with root package name */
    private final D5 f5618a;

    public C1250w5() {
        C1062b5 c5 = C1062b5.c();
        int i5 = N5.f5036d;
        C1241v5 v5Var = new C1241v5(c5, f5617b);
        byte[] bArr = C1152l5.f5434b;
        this.f5618a = v5Var;
    }

    public final Q5 a(Class cls) {
        S4 s42;
        int i5 = S5.f5173b;
        if (!C1089e5.class.isAssignableFrom(cls)) {
            int i6 = N5.f5036d;
        }
        C5 b5 = this.f5618a.b(cls);
        if (!b5.A()) {
            int i7 = N5.f5036d;
            K5 a5 = L5.a();
            C1197q5 a6 = C1205r5.a();
            C1063b6 a7 = S5.a();
            if (b5.b() - 1 != 1) {
                s42 = U4.a();
            } else {
                s42 = null;
            }
            return I5.B(cls, b5, a5, a6, a7, s42, B5.a());
        }
        int i8 = N5.f5036d;
        return J5.i(S5.a(), U4.a(), b5.B());
    }
}
