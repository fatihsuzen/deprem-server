package X2;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.t;

abstract class W extends V {
    public static Set h(Set set, Iterable iterable) {
        int i5;
        t.e(set, "<this>");
        t.e(iterable, "elements");
        Integer q5 = C2252t.q(iterable);
        if (q5 != null) {
            i5 = set.size() + q5.intValue();
        } else {
            i5 = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(O.e(i5));
        linkedHashSet.addAll(set);
        C2256x.u(linkedHashSet, iterable);
        return linkedHashSet;
    }
}
