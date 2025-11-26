package X2;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;

abstract class N {
    public static final Object a(Map map, Object obj) {
        t.e(map, "<this>");
        if (map instanceof L) {
            return ((L) map).d(obj);
        }
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }
}
