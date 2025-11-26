package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;
import java.util.List;
import java.util.Map;

final class N4 implements C1180o6 {

    /* renamed from: a  reason: collision with root package name */
    private final M4 f5034a;

    private N4(M4 m42) {
        byte[] bArr = C1152l5.f5434b;
        this.f5034a = m42;
        m42.f5025a = this;
    }

    public static N4 L(M4 m42) {
        N4 n42 = m42.f5025a;
        if (n42 != null) {
            return n42;
        }
        return new N4(m42);
    }

    public final void A(int i5, List list, boolean z4) {
        int i6 = 0;
        if (list instanceof C1098f5) {
            C1098f5 f5Var = (C1098f5) list;
            if (z4) {
                M4 m42 = this.f5034a;
                m42.i(i5, 2);
                int i7 = 0;
                for (int i8 = 0; i8 < f5Var.size(); i8++) {
                    int f5 = f5Var.f(i8);
                    i7 += M4.E((f5 >> 31) ^ (f5 + f5));
                }
                m42.x(i7);
                while (i6 < f5Var.size()) {
                    int f6 = f5Var.f(i6);
                    m42.x((f6 >> 31) ^ (f6 + f6));
                    i6++;
                }
                return;
            }
            while (i6 < f5Var.size()) {
                M4 m43 = this.f5034a;
                int f7 = f5Var.f(i6);
                m43.k(i5, (f7 >> 31) ^ (f7 + f7));
                i6++;
            }
        } else if (z4) {
            M4 m44 = this.f5034a;
            m44.i(i5, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                int intValue = ((Integer) list.get(i10)).intValue();
                i9 += M4.E((intValue >> 31) ^ (intValue + intValue));
            }
            m44.x(i9);
            while (i6 < list.size()) {
                int intValue2 = ((Integer) list.get(i6)).intValue();
                m44.x((intValue2 >> 31) ^ (intValue2 + intValue2));
                i6++;
            }
        } else {
            while (i6 < list.size()) {
                M4 m45 = this.f5034a;
                int intValue3 = ((Integer) list.get(i6)).intValue();
                m45.k(i5, (intValue3 >> 31) ^ (intValue3 + intValue3));
                i6++;
            }
        }
    }

    public final void B(int i5, int i6) {
        this.f5034a.j(i5, i6);
    }

    public final void C(int i5, int i6) {
        this.f5034a.k(i5, (i6 >> 31) ^ (i6 + i6));
    }

    public final void D(int i5, List list, boolean z4) {
        if (list instanceof C1258x4) {
            a.a(list);
            if (z4) {
                this.f5034a.i(i5, 2);
                throw null;
            }
            throw null;
        }
        int i6 = 0;
        if (z4) {
            M4 m42 = this.f5034a;
            m42.i(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Boolean) list.get(i8)).getClass();
                i7++;
            }
            m42.x(i7);
            while (i6 < list.size()) {
                m42.v(((Boolean) list.get(i6)).booleanValue() ? (byte) 1 : 0);
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f5034a.o(i5, ((Boolean) list.get(i6)).booleanValue());
            i6++;
        }
    }

    public final void E(int i5, List list, boolean z4) {
        int i6 = 0;
        if (list instanceof C1098f5) {
            C1098f5 f5Var = (C1098f5) list;
            if (z4) {
                M4 m42 = this.f5034a;
                m42.i(i5, 2);
                int i7 = 0;
                for (int i8 = 0; i8 < f5Var.size(); i8++) {
                    f5Var.f(i8);
                    i7 += 4;
                }
                m42.x(i7);
                while (i6 < f5Var.size()) {
                    m42.y(f5Var.f(i6));
                    i6++;
                }
                return;
            }
            while (i6 < f5Var.size()) {
                this.f5034a.l(i5, f5Var.f(i6));
                i6++;
            }
        } else if (z4) {
            M4 m43 = this.f5034a;
            m43.i(i5, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Integer) list.get(i10)).getClass();
                i9 += 4;
            }
            m43.x(i9);
            while (i6 < list.size()) {
                m43.y(((Integer) list.get(i6)).intValue());
                i6++;
            }
        } else {
            while (i6 < list.size()) {
                this.f5034a.l(i5, ((Integer) list.get(i6)).intValue());
                i6++;
            }
        }
    }

    public final void F(int i5, Object obj, Q5 q5) {
        M4 m42 = this.f5034a;
        m42.i(i5, 3);
        q5.g((F5) obj, m42.f5025a);
        m42.i(i5, 4);
    }

    public final void G(int i5, boolean z4) {
        this.f5034a.o(i5, z4);
    }

    public final void H(int i5, long j5) {
        this.f5034a.n(i5, j5);
    }

    public final void I(int i5, List list, boolean z4) {
        int i6 = 0;
        if (list instanceof C1098f5) {
            C1098f5 f5Var = (C1098f5) list;
            if (z4) {
                M4 m42 = this.f5034a;
                m42.i(i5, 2);
                int i7 = 0;
                for (int i8 = 0; i8 < f5Var.size(); i8++) {
                    i7 += M4.a((long) f5Var.f(i8));
                }
                m42.x(i7);
                while (i6 < f5Var.size()) {
                    m42.w(f5Var.f(i6));
                    i6++;
                }
                return;
            }
            while (i6 < f5Var.size()) {
                this.f5034a.j(i5, f5Var.f(i6));
                i6++;
            }
        } else if (z4) {
            M4 m43 = this.f5034a;
            m43.i(i5, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                i9 += M4.a((long) ((Integer) list.get(i10)).intValue());
            }
            m43.x(i9);
            while (i6 < list.size()) {
                m43.w(((Integer) list.get(i6)).intValue());
                i6++;
            }
        } else {
            while (i6 < list.size()) {
                this.f5034a.j(i5, ((Integer) list.get(i6)).intValue());
                i6++;
            }
        }
    }

    public final void J(int i5, List list, boolean z4) {
        int i6 = 0;
        if (list instanceof C1098f5) {
            C1098f5 f5Var = (C1098f5) list;
            if (z4) {
                M4 m42 = this.f5034a;
                m42.i(i5, 2);
                int i7 = 0;
                for (int i8 = 0; i8 < f5Var.size(); i8++) {
                    i7 += M4.a((long) f5Var.f(i8));
                }
                m42.x(i7);
                while (i6 < f5Var.size()) {
                    m42.w(f5Var.f(i6));
                    i6++;
                }
                return;
            }
            while (i6 < f5Var.size()) {
                this.f5034a.j(i5, f5Var.f(i6));
                i6++;
            }
        } else if (z4) {
            M4 m43 = this.f5034a;
            m43.i(i5, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                i9 += M4.a((long) ((Integer) list.get(i10)).intValue());
            }
            m43.x(i9);
            while (i6 < list.size()) {
                m43.w(((Integer) list.get(i6)).intValue());
                i6++;
            }
        } else {
            while (i6 < list.size()) {
                this.f5034a.j(i5, ((Integer) list.get(i6)).intValue());
                i6++;
            }
        }
    }

    public final void K(int i5, float f5) {
        this.f5034a.l(i5, Float.floatToRawIntBits(f5));
    }

    public final void a(int i5, H4 h42) {
        this.f5034a.q(i5, h42);
    }

    public final void b(int i5, long j5) {
        this.f5034a.n(i5, j5);
    }

    public final void c(int i5, List list, boolean z4) {
        int i6 = 0;
        if (list instanceof C1223t5) {
            C1223t5 t5Var = (C1223t5) list;
            if (z4) {
                M4 m42 = this.f5034a;
                m42.i(i5, 2);
                int i7 = 0;
                for (int i8 = 0; i8 < t5Var.size(); i8++) {
                    i7 += M4.a(t5Var.h(i8));
                }
                m42.x(i7);
                while (i6 < t5Var.size()) {
                    m42.z(t5Var.h(i6));
                    i6++;
                }
                return;
            }
            while (i6 < t5Var.size()) {
                this.f5034a.m(i5, t5Var.h(i6));
                i6++;
            }
        } else if (z4) {
            M4 m43 = this.f5034a;
            m43.i(i5, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                i9 += M4.a(((Long) list.get(i10)).longValue());
            }
            m43.x(i9);
            while (i6 < list.size()) {
                m43.z(((Long) list.get(i6)).longValue());
                i6++;
            }
        } else {
            while (i6 < list.size()) {
                this.f5034a.m(i5, ((Long) list.get(i6)).longValue());
                i6++;
            }
        }
    }

    public final void d(int i5, int i6) {
        this.f5034a.l(i5, i6);
    }

    public final void e(int i5, List list, boolean z4) {
        int i6 = 0;
        if (list instanceof C1223t5) {
            C1223t5 t5Var = (C1223t5) list;
            if (z4) {
                M4 m42 = this.f5034a;
                m42.i(i5, 2);
                int i7 = 0;
                for (int i8 = 0; i8 < t5Var.size(); i8++) {
                    i7 += M4.a(t5Var.h(i8));
                }
                m42.x(i7);
                while (i6 < t5Var.size()) {
                    m42.z(t5Var.h(i6));
                    i6++;
                }
                return;
            }
            while (i6 < t5Var.size()) {
                this.f5034a.m(i5, t5Var.h(i6));
                i6++;
            }
        } else if (z4) {
            M4 m43 = this.f5034a;
            m43.i(i5, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                i9 += M4.a(((Long) list.get(i10)).longValue());
            }
            m43.x(i9);
            while (i6 < list.size()) {
                m43.z(((Long) list.get(i6)).longValue());
                i6++;
            }
        } else {
            while (i6 < list.size()) {
                this.f5034a.m(i5, ((Long) list.get(i6)).longValue());
                i6++;
            }
        }
    }

    public final void f(int i5, int i6) {
        this.f5034a.l(i5, i6);
    }

    public final void g(int i5, C1259x5 x5Var, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            M4 m42 = this.f5034a;
            m42.i(i5, 2);
            m42.x(C1267y5.c(x5Var, entry.getKey(), entry.getValue()));
            C1267y5.b(m42, x5Var, entry.getKey(), entry.getValue());
        }
    }

    public final void h(int i5, Object obj, Q5 q5) {
        this.f5034a.t(i5, (F5) obj, q5);
    }

    public final void i(int i5, long j5) {
        this.f5034a.m(i5, j5);
    }

    public final void j(int i5, List list, boolean z4) {
        int i6 = 0;
        if (list instanceof C1098f5) {
            C1098f5 f5Var = (C1098f5) list;
            if (z4) {
                M4 m42 = this.f5034a;
                m42.i(i5, 2);
                int i7 = 0;
                for (int i8 = 0; i8 < f5Var.size(); i8++) {
                    f5Var.f(i8);
                    i7 += 4;
                }
                m42.x(i7);
                while (i6 < f5Var.size()) {
                    m42.y(f5Var.f(i6));
                    i6++;
                }
                return;
            }
            while (i6 < f5Var.size()) {
                this.f5034a.l(i5, f5Var.f(i6));
                i6++;
            }
        } else if (z4) {
            M4 m43 = this.f5034a;
            m43.i(i5, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Integer) list.get(i10)).getClass();
                i9 += 4;
            }
            m43.x(i9);
            while (i6 < list.size()) {
                m43.y(((Integer) list.get(i6)).intValue());
                i6++;
            }
        } else {
            while (i6 < list.size()) {
                this.f5034a.l(i5, ((Integer) list.get(i6)).intValue());
                i6++;
            }
        }
    }

    public final void k(int i5, List list, boolean z4) {
        int i6 = 0;
        if (list instanceof C1223t5) {
            C1223t5 t5Var = (C1223t5) list;
            if (z4) {
                M4 m42 = this.f5034a;
                m42.i(i5, 2);
                int i7 = 0;
                for (int i8 = 0; i8 < t5Var.size(); i8++) {
                    t5Var.h(i8);
                    i7 += 8;
                }
                m42.x(i7);
                while (i6 < t5Var.size()) {
                    m42.A(t5Var.h(i6));
                    i6++;
                }
                return;
            }
            while (i6 < t5Var.size()) {
                this.f5034a.n(i5, t5Var.h(i6));
                i6++;
            }
        } else if (z4) {
            M4 m43 = this.f5034a;
            m43.i(i5, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Long) list.get(i10)).getClass();
                i9 += 8;
            }
            m43.x(i9);
            while (i6 < list.size()) {
                m43.A(((Long) list.get(i6)).longValue());
                i6++;
            }
        } else {
            while (i6 < list.size()) {
                this.f5034a.n(i5, ((Long) list.get(i6)).longValue());
                i6++;
            }
        }
    }

    public final void l(int i5, long j5) {
        this.f5034a.m(i5, j5);
    }

    public final void m(int i5, long j5) {
        this.f5034a.m(i5, (j5 >> 63) ^ (j5 + j5));
    }

    public final void n(int i5, List list, boolean z4) {
        int i6 = 0;
        if (list instanceof C1223t5) {
            C1223t5 t5Var = (C1223t5) list;
            if (z4) {
                M4 m42 = this.f5034a;
                m42.i(i5, 2);
                int i7 = 0;
                for (int i8 = 0; i8 < t5Var.size(); i8++) {
                    t5Var.h(i8);
                    i7 += 8;
                }
                m42.x(i7);
                while (i6 < t5Var.size()) {
                    m42.A(t5Var.h(i6));
                    i6++;
                }
                return;
            }
            while (i6 < t5Var.size()) {
                this.f5034a.n(i5, t5Var.h(i6));
                i6++;
            }
        } else if (z4) {
            M4 m43 = this.f5034a;
            m43.i(i5, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Long) list.get(i10)).getClass();
                i9 += 8;
            }
            m43.x(i9);
            while (i6 < list.size()) {
                m43.A(((Long) list.get(i6)).longValue());
                i6++;
            }
        } else {
            while (i6 < list.size()) {
                this.f5034a.n(i5, ((Long) list.get(i6)).longValue());
                i6++;
            }
        }
    }

    public final void o(int i5) {
        this.f5034a.i(i5, 3);
    }

    public final void p(int i5, int i6) {
        this.f5034a.j(i5, i6);
    }

    public final void q(int i5, List list, boolean z4) {
        int i6 = 0;
        if (list instanceof C1098f5) {
            C1098f5 f5Var = (C1098f5) list;
            if (z4) {
                M4 m42 = this.f5034a;
                m42.i(i5, 2);
                int i7 = 0;
                for (int i8 = 0; i8 < f5Var.size(); i8++) {
                    i7 += M4.E(f5Var.f(i8));
                }
                m42.x(i7);
                while (i6 < f5Var.size()) {
                    m42.x(f5Var.f(i6));
                    i6++;
                }
                return;
            }
            while (i6 < f5Var.size()) {
                this.f5034a.k(i5, f5Var.f(i6));
                i6++;
            }
        } else if (z4) {
            M4 m43 = this.f5034a;
            m43.i(i5, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                i9 += M4.E(((Integer) list.get(i10)).intValue());
            }
            m43.x(i9);
            while (i6 < list.size()) {
                m43.x(((Integer) list.get(i6)).intValue());
                i6++;
            }
        } else {
            while (i6 < list.size()) {
                this.f5034a.k(i5, ((Integer) list.get(i6)).intValue());
                i6++;
            }
        }
    }

    public final void r(int i5) {
        this.f5034a.i(i5, 4);
    }

    public final void s(int i5, List list, boolean z4) {
        if (list instanceof O4) {
            a.a(list);
            if (z4) {
                this.f5034a.i(i5, 2);
                throw null;
            }
            throw null;
        }
        int i6 = 0;
        if (z4) {
            M4 m42 = this.f5034a;
            m42.i(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Double) list.get(i8)).getClass();
                i7 += 8;
            }
            m42.x(i7);
            while (i6 < list.size()) {
                m42.A(Double.doubleToRawLongBits(((Double) list.get(i6)).doubleValue()));
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f5034a.n(i5, Double.doubleToRawLongBits(((Double) list.get(i6)).doubleValue()));
            i6++;
        }
    }

    public final void t(int i5, List list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.f5034a.q(i5, (H4) list.get(i6));
        }
    }

    public final void u(int i5, String str) {
        this.f5034a.p(i5, str);
    }

    public final void v(int i5, double d5) {
        this.f5034a.n(i5, Double.doubleToRawLongBits(d5));
    }

    public final void w(int i5, List list, boolean z4) {
        int i6 = 0;
        if (list instanceof C1223t5) {
            C1223t5 t5Var = (C1223t5) list;
            if (z4) {
                M4 m42 = this.f5034a;
                m42.i(i5, 2);
                int i7 = 0;
                for (int i8 = 0; i8 < t5Var.size(); i8++) {
                    long h5 = t5Var.h(i8);
                    i7 += M4.a((h5 >> 63) ^ (h5 + h5));
                }
                m42.x(i7);
                while (i6 < t5Var.size()) {
                    long h6 = t5Var.h(i6);
                    m42.z((h6 >> 63) ^ (h6 + h6));
                    i6++;
                }
                return;
            }
            while (i6 < t5Var.size()) {
                M4 m43 = this.f5034a;
                long h7 = t5Var.h(i6);
                m43.m(i5, (h7 >> 63) ^ (h7 + h7));
                i6++;
            }
        } else if (z4) {
            M4 m44 = this.f5034a;
            m44.i(i5, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                long longValue = ((Long) list.get(i10)).longValue();
                i9 += M4.a((longValue >> 63) ^ (longValue + longValue));
            }
            m44.x(i9);
            while (i6 < list.size()) {
                long longValue2 = ((Long) list.get(i6)).longValue();
                m44.z((longValue2 >> 63) ^ (longValue2 + longValue2));
                i6++;
            }
        } else {
            while (i6 < list.size()) {
                M4 m45 = this.f5034a;
                long longValue3 = ((Long) list.get(i6)).longValue();
                m45.m(i5, (longValue3 >> 63) ^ (longValue3 + longValue3));
                i6++;
            }
        }
    }

    public final void x(int i5, List list, boolean z4) {
        if (list instanceof Y4) {
            a.a(list);
            if (z4) {
                this.f5034a.i(i5, 2);
                throw null;
            }
            throw null;
        }
        int i6 = 0;
        if (z4) {
            M4 m42 = this.f5034a;
            m42.i(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Float) list.get(i8)).getClass();
                i7 += 4;
            }
            m42.x(i7);
            while (i6 < list.size()) {
                m42.y(Float.floatToRawIntBits(((Float) list.get(i6)).floatValue()));
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f5034a.l(i5, Float.floatToRawIntBits(((Float) list.get(i6)).floatValue()));
            i6++;
        }
    }

    public final void y(int i5, int i6) {
        this.f5034a.k(i5, i6);
    }

    public final void z(int i5, List list) {
        int i6 = 0;
        if (list instanceof C1188p5) {
            C1188p5 p5Var = (C1188p5) list;
            while (i6 < list.size()) {
                Object b5 = p5Var.b();
                if (b5 instanceof String) {
                    this.f5034a.p(i5, (String) b5);
                } else {
                    this.f5034a.q(i5, (H4) b5);
                }
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f5034a.p(i5, (String) list.get(i6));
            i6++;
        }
    }
}
