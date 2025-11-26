package X2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;

/* renamed from: X2.t  reason: case insensitive filesystem */
abstract class C2252t extends C2251s {
    public static int p(Iterable iterable, int i5) {
        t.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return i5;
    }

    public static final Integer q(Iterable iterable) {
        t.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    public static List r(Iterable iterable) {
        t.e(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            C2256x.u(arrayList, (Iterable) it.next());
        }
        return arrayList;
    }
}
