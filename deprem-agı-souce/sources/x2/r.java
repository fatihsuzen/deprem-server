package X2;

import Y2.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

abstract class r {
    public static List a(List list) {
        t.e(list, "builder");
        return ((b) list).t();
    }

    public static final Object[] b(Object[] objArr, boolean z4) {
        t.e(objArr, "<this>");
        Class<Object[]> cls = Object[].class;
        if (z4 && t.a(objArr.getClass(), cls)) {
            return objArr;
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length, cls);
        t.d(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static List c() {
        return new b(0, 1, (C2633k) null);
    }

    public static List d(Object obj) {
        List singletonList = Collections.singletonList(obj);
        t.d(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static Object[] e(int i5, Object[] objArr) {
        t.e(objArr, "array");
        if (i5 < objArr.length) {
            objArr[i5] = null;
        }
        return objArr;
    }
}
