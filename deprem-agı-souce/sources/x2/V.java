package X2;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.t;

abstract class V extends U {
    public static Set d() {
        return F.f20049a;
    }

    public static Set e(Object... objArr) {
        t.e(objArr, "elements");
        return (Set) C2247n.o0(objArr, new LinkedHashSet(O.e(objArr.length)));
    }

    public static final Set f(Set set) {
        t.e(set, "<this>");
        int size = set.size();
        if (size == 0) {
            return d();
        }
        if (size != 1) {
            return set;
        }
        return U.c(set.iterator().next());
    }

    public static Set g(Object... objArr) {
        t.e(objArr, "elements");
        return C2247n.v0(objArr);
    }
}
