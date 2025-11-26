package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.y5  reason: case insensitive filesystem */
public final class C1267y5 {

    /* renamed from: a  reason: collision with root package name */
    private final C1259x5 f5630a;

    private C1267y5(C1162m6 m6Var, Object obj, C1162m6 m6Var2, Object obj2) {
        this.f5630a = new C1259x5(m6Var, "", m6Var2, "");
    }

    public static C1267y5 a(C1162m6 m6Var, Object obj, C1162m6 m6Var2, Object obj2) {
        return new C1267y5(m6Var, "", m6Var2, "");
    }

    static void b(M4 m42, C1259x5 x5Var, Object obj, Object obj2) {
        W4.c(m42, x5Var.f5623a, 1, obj);
        W4.c(m42, x5Var.f5625c, 2, obj2);
    }

    static int c(C1259x5 x5Var, Object obj, Object obj2) {
        return W4.d(x5Var.f5623a, 1, obj) + W4.d(x5Var.f5625c, 2, obj2);
    }

    public final int d(int i5, Object obj, Object obj2) {
        C1259x5 x5Var = this.f5630a;
        int E4 = M4.E(i5 << 3);
        int c5 = c(x5Var, obj, obj2);
        return E4 + M4.E(c5) + c5;
    }

    /* access modifiers changed from: package-private */
    public final C1259x5 e() {
        return this.f5630a;
    }
}
