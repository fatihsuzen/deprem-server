package kotlin.jvm.internal;

import W2.C2218g;
import java.util.Collection;
import java.util.Map;
import k3.C2616a;
import k3.l;
import k3.p;
import k3.q;
import k3.r;
import k3.t;
import l3.C2677a;
import l3.C2678b;
import l3.C2679c;
import l3.C2680d;

public abstract class S {
    public static Collection a(Object obj) {
        if ((obj instanceof C2677a) && !(obj instanceof C2678b)) {
            k(obj, "kotlin.collections.MutableCollection");
        }
        return d(obj);
    }

    public static Iterable b(Object obj) {
        if ((obj instanceof C2677a) && !(obj instanceof C2679c)) {
            k(obj, "kotlin.collections.MutableIterable");
        }
        return e(obj);
    }

    public static Object c(Object obj, int i5) {
        if (obj != null && !g(obj, i5)) {
            k(obj, "kotlin.jvm.functions.Function" + i5);
        }
        return obj;
    }

    public static Collection d(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e5) {
            throw j(e5);
        }
    }

    public static Iterable e(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e5) {
            throw j(e5);
        }
    }

    public static int f(Object obj) {
        if (obj instanceof C2637o) {
            return ((C2637o) obj).getArity();
        }
        if (obj instanceof C2616a) {
            return 0;
        }
        if (obj instanceof l) {
            return 1;
        }
        if (obj instanceof p) {
            return 2;
        }
        if (obj instanceof q) {
            return 3;
        }
        if (obj instanceof r) {
            return 4;
        }
        if (obj instanceof t) {
            return 6;
        }
        return -1;
    }

    public static boolean g(Object obj, int i5) {
        if (!(obj instanceof C2218g) || f(obj) != i5) {
            return false;
        }
        return true;
    }

    public static boolean h(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        if (!(obj instanceof C2677a) || (obj instanceof C2680d)) {
            return true;
        }
        return false;
    }

    private static Throwable i(Throwable th) {
        return t.m(th, S.class.getName());
    }

    public static ClassCastException j(ClassCastException classCastException) {
        throw ((ClassCastException) i(classCastException));
    }

    public static void k(Object obj, String str) {
        String str2;
        if (obj == null) {
            str2 = "null";
        } else {
            str2 = obj.getClass().getName();
        }
        l(str2 + " cannot be cast to " + str);
    }

    public static void l(String str) {
        throw j(new ClassCastException(str));
    }
}
