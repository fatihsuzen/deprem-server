package X2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import k3.l;
import kotlin.jvm.internal.S;
import kotlin.jvm.internal.t;

/* renamed from: X2.x  reason: case insensitive filesystem */
abstract class C2256x extends C2255w {
    public static Object A(List list) {
        t.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(C2251s.i(list));
    }

    public static boolean u(Collection collection, Iterable iterable) {
        t.e(collection, "<this>");
        t.e(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z4 = false;
        for (Object add : iterable) {
            if (collection.add(add)) {
                z4 = true;
            }
        }
        return z4;
    }

    public static boolean v(Collection collection, Object[] objArr) {
        t.e(collection, "<this>");
        t.e(objArr, "elements");
        return collection.addAll(C2245l.g(objArr));
    }

    private static final boolean w(Iterable iterable, l lVar, boolean z4) {
        Iterator it = iterable.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            if (((Boolean) lVar.invoke(it.next())).booleanValue() == z4) {
                it.remove();
                z5 = true;
            }
        }
        return z5;
    }

    private static final boolean x(List list, l lVar, boolean z4) {
        int i5;
        if (!(list instanceof RandomAccess)) {
            t.c(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return w(S.b(list), lVar, z4);
        }
        int i6 = C2251s.i(list);
        if (i6 >= 0) {
            int i7 = 0;
            i5 = 0;
            while (true) {
                Object obj = list.get(i7);
                if (((Boolean) lVar.invoke(obj)).booleanValue() != z4) {
                    if (i5 != i7) {
                        list.set(i5, obj);
                    }
                    i5++;
                }
                if (i7 == i6) {
                    break;
                }
                i7++;
            }
        } else {
            i5 = 0;
        }
        if (i5 >= list.size()) {
            return false;
        }
        int i8 = C2251s.i(list);
        if (i5 > i8) {
            return true;
        }
        while (true) {
            list.remove(i8);
            if (i8 == i5) {
                return true;
            }
            i8--;
        }
    }

    public static boolean y(List list, l lVar) {
        t.e(list, "<this>");
        t.e(lVar, "predicate");
        return x(list, lVar, true);
    }

    public static Object z(List list) {
        t.e(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(C2251s.i(list));
        }
        throw new NoSuchElementException("List is empty.");
    }
}
