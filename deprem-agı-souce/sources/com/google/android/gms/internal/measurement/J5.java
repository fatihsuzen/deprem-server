package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;

final class J5 implements Q5 {

    /* renamed from: a  reason: collision with root package name */
    private final F5 f5001a;

    /* renamed from: b  reason: collision with root package name */
    private final C1063b6 f5002b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f5003c = false;

    /* renamed from: d  reason: collision with root package name */
    private final S4 f5004d;

    private J5(C1063b6 b6Var, S4 s42, F5 f5) {
        this.f5002b = b6Var;
        this.f5004d = s42;
        this.f5001a = f5;
    }

    static J5 i(C1063b6 b6Var, S4 s42, F5 f5) {
        return new J5(b6Var, s42, f5);
    }

    public final Object A() {
        F5 f5 = this.f5001a;
        if (f5 instanceof C1089e5) {
            return ((C1089e5) f5).m();
        }
        return f5.b().u();
    }

    public final int a(Object obj) {
        int g5 = ((C1089e5) obj).zzc.g();
        if (!this.f5003c) {
            return g5;
        }
        a.a(obj);
        throw null;
    }

    public final void b(Object obj, Object obj2) {
        S5.d(this.f5002b, obj, obj2);
        if (this.f5003c) {
            S5.c(this.f5004d, obj, obj2);
        }
    }

    public final int c(Object obj) {
        int hashCode = ((C1089e5) obj).zzc.hashCode();
        if (!this.f5003c) {
            return hashCode;
        }
        a.a(obj);
        throw null;
    }

    public final boolean d(Object obj) {
        a.a(obj);
        throw null;
    }

    public final void e(Object obj) {
        this.f5002b.b(obj);
        this.f5004d.a(obj);
    }

    public final void f(Object obj, byte[] bArr, int i5, int i6, C1240v4 v4Var) {
        C1089e5 e5Var = (C1089e5) obj;
        if (e5Var.zzc == C1072c6.a()) {
            e5Var.zzc = C1072c6.b();
        }
        a.a(obj);
        throw null;
    }

    public final void g(Object obj, C1180o6 o6Var) {
        a.a(obj);
        throw null;
    }

    public final boolean h(Object obj, Object obj2) {
        if (!((C1089e5) obj).zzc.equals(((C1089e5) obj2).zzc)) {
            return false;
        }
        if (!this.f5003c) {
            return true;
        }
        a.a(obj);
        throw null;
    }
}
