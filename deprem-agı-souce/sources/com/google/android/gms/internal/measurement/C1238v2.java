package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.v2  reason: case insensitive filesystem */
public abstract class C1238v2 {
    public static void a(String str, int i5, List list) {
        if (list.size() != i5) {
            throw new IllegalArgumentException(String.format("%s operation requires %s parameters found %s", new Object[]{str, Integer.valueOf(i5), Integer.valueOf(list.size())}));
        }
    }

    public static void b(String str, int i5, List list) {
        if (list.size() < i5) {
            throw new IllegalArgumentException(String.format("%s operation requires at least %s parameters found %s", new Object[]{str, Integer.valueOf(i5), Integer.valueOf(list.size())}));
        }
    }

    public static void c(String str, int i5, List list) {
        if (list.size() > i5) {
            throw new IllegalArgumentException(String.format("%s operation requires at most %s parameters found %s", new Object[]{str, Integer.valueOf(i5), Integer.valueOf(list.size())}));
        }
    }

    public static boolean d(r rVar) {
        if (rVar == null) {
            return false;
        }
        Double C4 = rVar.C();
        if (C4.isNaN() || C4.doubleValue() < 0.0d || !C4.equals(Double.valueOf(Math.floor(C4.doubleValue())))) {
            return false;
        }
        return true;
    }

    public static O e(String str) {
        O o5 = null;
        if (str != null && !str.isEmpty()) {
            o5 = O.a(Integer.parseInt(str));
        }
        if (o5 != null) {
            return o5;
        }
        throw new IllegalArgumentException(String.format("Unsupported commandId %s", new Object[]{str}));
    }

    public static boolean f(r rVar, r rVar2) {
        if (!rVar.getClass().equals(rVar2.getClass())) {
            return false;
        }
        if ((rVar instanceof C1244w) || (rVar instanceof C1182p)) {
            return true;
        }
        if (rVar instanceof C1128j) {
            if (Double.isNaN(rVar.C().doubleValue()) || Double.isNaN(rVar2.C().doubleValue())) {
                return false;
            }
            return rVar.C().equals(rVar2.C());
        } else if (rVar instanceof C1235v) {
            return rVar.b().equals(rVar2.b());
        } else {
            if (rVar instanceof C1101g) {
                return rVar.d().equals(rVar2.d());
            }
            if (rVar == rVar2) {
                return true;
            }
            return false;
        }
    }

    public static int g(double d5) {
        int i5;
        int i6;
        if (Double.isNaN(d5) || Double.isInfinite(d5) || d5 == 0.0d) {
            return 0;
        }
        if (i5 > 0) {
            i6 = 1;
        } else {
            i6 = -1;
        }
        return (int) ((long) ((((double) i6) * Math.floor(Math.abs(d5))) % 4.294967296E9d));
    }

    public static long h(double d5) {
        return ((long) g(d5)) & 4294967295L;
    }

    public static double i(double d5) {
        int i5;
        int i6;
        if (Double.isNaN(d5)) {
            return 0.0d;
        }
        if (Double.isInfinite(d5) || d5 == 0.0d || i5 == 0) {
            return d5;
        }
        if (i5 > 0) {
            i6 = 1;
        } else {
            i6 = -1;
        }
        return ((double) i6) * Math.floor(Math.abs(d5));
    }

    public static Object j(r rVar) {
        if (r.f5554c0.equals(rVar)) {
            return null;
        }
        if (r.f5553b0.equals(rVar)) {
            return "";
        }
        if (rVar instanceof C1173o) {
            return k((C1173o) rVar);
        }
        if (rVar instanceof C1092f) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((C1092f) rVar).iterator();
            while (it.hasNext()) {
                Object j5 = j((r) it.next());
                if (j5 != null) {
                    arrayList.add(j5);
                }
            }
            return arrayList;
        } else if (!rVar.C().isNaN()) {
            return rVar.C();
        } else {
            return rVar.b();
        }
    }

    public static Map k(C1173o oVar) {
        HashMap hashMap = new HashMap();
        for (String str : oVar.a()) {
            Object j5 = j(oVar.f(str));
            if (j5 != null) {
                hashMap.put(str, j5);
            }
        }
        return hashMap;
    }

    public static int l(U1 u12) {
        int g5 = g(u12.h("runtime.counter").C().doubleValue() + 1.0d);
        if (g5 <= 1000000) {
            u12.e("runtime.counter", new C1128j(Double.valueOf((double) g5)));
            return g5;
        }
        throw new IllegalStateException("Instructions allowed exceeded");
    }
}
