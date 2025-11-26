package X2;

import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.jvm.internal.t;

abstract class z extends y {
    public static SortedSet B(Iterable iterable) {
        t.e(iterable, "<this>");
        return (SortedSet) B.k0(iterable, new TreeSet());
    }
}
