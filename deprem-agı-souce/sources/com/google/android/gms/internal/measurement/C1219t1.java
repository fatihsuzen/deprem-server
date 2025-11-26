package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.t1  reason: case insensitive filesystem */
public final class C1219t1 {

    /* renamed from: a  reason: collision with root package name */
    final C1269z f5580a;

    /* renamed from: b  reason: collision with root package name */
    final U1 f5581b;

    /* renamed from: c  reason: collision with root package name */
    final U1 f5582c;

    /* renamed from: d  reason: collision with root package name */
    final C1257x3 f5583d;

    public C1219t1() {
        C1269z zVar = new C1269z();
        this.f5580a = zVar;
        U1 u12 = new U1((U1) null, zVar);
        this.f5582c = u12;
        this.f5581b = u12.c();
        C1257x3 x3Var = new C1257x3();
        this.f5583d = x3Var;
        u12.e("require", new T7(x3Var));
        x3Var.a("internal.platform", C1067c1.f5316a);
        u12.e("runtime.counter", new C1128j(Double.valueOf(0.0d)));
    }

    public final r a(U1 u12, C3... c3Arr) {
        r rVar = r.f5553b0;
        for (C3 b5 : c3Arr) {
            rVar = W2.b(b5);
            C1238v2.l(this.f5582c);
            if ((rVar instanceof C1208s) || (rVar instanceof C1191q)) {
                rVar = this.f5580a.b(u12, rVar);
            }
        }
        return rVar;
    }
}
