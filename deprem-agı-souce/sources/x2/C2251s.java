package X2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.t;
import q3.C2728d;

/* renamed from: X2.s  reason: case insensitive filesystem */
abstract class C2251s extends r {
    public static final Collection f(Object[] objArr) {
        t.e(objArr, "<this>");
        return new C2240g(objArr, false);
    }

    public static List g() {
        return D.f20047a;
    }

    public static C2728d h(Collection collection) {
        t.e(collection, "<this>");
        return new C2728d(0, collection.size() - 1);
    }

    public static int i(List list) {
        t.e(list, "<this>");
        return list.size() - 1;
    }

    public static List j(Object... objArr) {
        t.e(objArr, "elements");
        if (objArr.length > 0) {
            return C2245l.g(objArr);
        }
        return g();
    }

    public static List k(Object... objArr) {
        t.e(objArr, "elements");
        return C2247n.O(objArr);
    }

    public static List l(Object... objArr) {
        t.e(objArr, "elements");
        if (objArr.length == 0) {
            return new ArrayList();
        }
        return new ArrayList(new C2240g(objArr, true));
    }

    public static final List m(List list) {
        t.e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            return g();
        }
        if (size != 1) {
            return list;
        }
        return r.d(list.get(0));
    }

    public static void n() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void o() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
