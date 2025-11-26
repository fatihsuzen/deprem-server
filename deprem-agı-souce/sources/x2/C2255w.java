package X2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.t;

/* renamed from: X2.w  reason: case insensitive filesystem */
abstract class C2255w extends C2254v {
    public static final void s(List list) {
        t.e(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static void t(List list, Comparator comparator) {
        t.e(list, "<this>");
        t.e(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
