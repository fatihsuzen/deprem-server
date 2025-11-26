package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;
import java.util.List;

abstract class S5 {

    /* renamed from: a  reason: collision with root package name */
    private static final C1063b6 f5172a = new C1081d6();

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f5173b = 0;

    static {
        int i5 = N5.f5036d;
    }

    static int A(List list) {
        return list.size() * 4;
    }

    static int B(int i5, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (M4.E(i5 << 3) + 4);
    }

    static int C(List list) {
        return list.size() * 8;
    }

    static int D(int i5, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (M4.E(i5 << 3) + 8);
    }

    static int E(int i5, Object obj, Q5 q5) {
        return M4.E(i5 << 3) + M4.d((F5) obj, q5);
    }

    public static C1063b6 a() {
        return f5172a;
    }

    static boolean b(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || !obj.equals(obj2)) {
            return false;
        }
        return true;
    }

    static void c(S4 s42, Object obj, Object obj2) {
        a.a(obj2);
        throw null;
    }

    static void d(C1063b6 b6Var, Object obj, Object obj2) {
        C1089e5 e5Var = (C1089e5) obj;
        C1072c6 c6Var = e5Var.zzc;
        C1072c6 c6Var2 = ((C1089e5) obj2).zzc;
        if (!C1072c6.a().equals(c6Var2)) {
            if (C1072c6.a().equals(c6Var)) {
                c6Var = C1072c6.c(c6Var, c6Var2);
            } else {
                c6Var.k(c6Var2);
            }
        }
        e5Var.zzc = c6Var;
    }

    static Object e(Object obj, int i5, int i6, Object obj2, C1063b6 b6Var) {
        if (obj2 == null) {
            obj2 = b6Var.a(obj);
        }
        ((C1072c6) obj2).j(i5 << 3, Long.valueOf((long) i6));
        return obj2;
    }

    public static void f(int i5, List list, C1180o6 o6Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            o6Var.s(i5, list, z4);
        }
    }

    public static void g(int i5, List list, C1180o6 o6Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            o6Var.x(i5, list, z4);
        }
    }

    public static void h(int i5, List list, C1180o6 o6Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            o6Var.e(i5, list, z4);
        }
    }

    public static void i(int i5, List list, C1180o6 o6Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            o6Var.c(i5, list, z4);
        }
    }

    public static void j(int i5, List list, C1180o6 o6Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            o6Var.w(i5, list, z4);
        }
    }

    public static void k(int i5, List list, C1180o6 o6Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            o6Var.n(i5, list, z4);
        }
    }

    public static void l(int i5, List list, C1180o6 o6Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            o6Var.k(i5, list, z4);
        }
    }

    public static void m(int i5, List list, C1180o6 o6Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            o6Var.J(i5, list, z4);
        }
    }

    public static void n(int i5, List list, C1180o6 o6Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            o6Var.q(i5, list, z4);
        }
    }

    public static void o(int i5, List list, C1180o6 o6Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            o6Var.A(i5, list, z4);
        }
    }

    public static void p(int i5, List list, C1180o6 o6Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            o6Var.E(i5, list, z4);
        }
    }

    public static void q(int i5, List list, C1180o6 o6Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            o6Var.j(i5, list, z4);
        }
    }

    public static void r(int i5, List list, C1180o6 o6Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            o6Var.I(i5, list, z4);
        }
    }

    public static void s(int i5, List list, C1180o6 o6Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            o6Var.D(i5, list, z4);
        }
    }

    static int t(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1223t5) {
            C1223t5 t5Var = (C1223t5) list;
            int i6 = 0;
            while (i5 < size) {
                i6 += M4.a(t5Var.h(i5));
                i5++;
            }
            return i6;
        }
        int i7 = 0;
        while (i5 < size) {
            i7 += M4.a(((Long) list.get(i5)).longValue());
            i5++;
        }
        return i7;
    }

    static int u(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1223t5) {
            C1223t5 t5Var = (C1223t5) list;
            int i6 = 0;
            while (i5 < size) {
                i6 += M4.a(t5Var.h(i5));
                i5++;
            }
            return i6;
        }
        int i7 = 0;
        while (i5 < size) {
            i7 += M4.a(((Long) list.get(i5)).longValue());
            i5++;
        }
        return i7;
    }

    static int v(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1223t5) {
            C1223t5 t5Var = (C1223t5) list;
            int i6 = 0;
            while (i5 < size) {
                long h5 = t5Var.h(i5);
                i6 += M4.a((h5 >> 63) ^ (h5 + h5));
                i5++;
            }
            return i6;
        }
        int i7 = 0;
        while (i5 < size) {
            long longValue = ((Long) list.get(i5)).longValue();
            i7 += M4.a((longValue >> 63) ^ (longValue + longValue));
            i5++;
        }
        return i7;
    }

    static int w(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1098f5) {
            C1098f5 f5Var = (C1098f5) list;
            int i6 = 0;
            while (i5 < size) {
                i6 += M4.a((long) f5Var.f(i5));
                i5++;
            }
            return i6;
        }
        int i7 = 0;
        while (i5 < size) {
            i7 += M4.a((long) ((Integer) list.get(i5)).intValue());
            i5++;
        }
        return i7;
    }

    static int x(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1098f5) {
            C1098f5 f5Var = (C1098f5) list;
            int i6 = 0;
            while (i5 < size) {
                i6 += M4.a((long) f5Var.f(i5));
                i5++;
            }
            return i6;
        }
        int i7 = 0;
        while (i5 < size) {
            i7 += M4.a((long) ((Integer) list.get(i5)).intValue());
            i5++;
        }
        return i7;
    }

    static int y(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1098f5) {
            C1098f5 f5Var = (C1098f5) list;
            int i6 = 0;
            while (i5 < size) {
                i6 += M4.E(f5Var.f(i5));
                i5++;
            }
            return i6;
        }
        int i7 = 0;
        while (i5 < size) {
            i7 += M4.E(((Integer) list.get(i5)).intValue());
            i5++;
        }
        return i7;
    }

    static int z(List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1098f5) {
            C1098f5 f5Var = (C1098f5) list;
            int i6 = 0;
            while (i5 < size) {
                int f5 = f5Var.f(i5);
                i6 += M4.E((f5 >> 31) ^ (f5 + f5));
                i5++;
            }
            return i6;
        }
        int i7 = 0;
        while (i5 < size) {
            int intValue = ((Integer) list.get(i5)).intValue();
            i7 += M4.E((intValue >> 31) ^ (intValue + intValue));
            i5++;
        }
        return i7;
    }
}
