package X2;

import W2.s;
import Y2.d;
import java.util.Collections;
import java.util.Map;
import kotlin.jvm.internal.t;

abstract class O extends N {
    public static Map b(Map map) {
        t.e(map, "builder");
        return ((d) map).l();
    }

    public static Map c() {
        return new d();
    }

    public static Map d(int i5) {
        return new d(i5);
    }

    public static int e(int i5) {
        if (i5 < 0) {
            return i5;
        }
        if (i5 < 3) {
            return i5 + 1;
        }
        if (i5 < 1073741824) {
            return (int) ((((float) i5) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map f(s sVar) {
        t.e(sVar, "pair");
        Map singletonMap = Collections.singletonMap(sVar.c(), sVar.d());
        t.d(singletonMap, "singletonMap(...)");
        return singletonMap;
    }

    public static final Map g(Map map) {
        t.e(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map singletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        t.d(singletonMap, "with(...)");
        return singletonMap;
    }
}
