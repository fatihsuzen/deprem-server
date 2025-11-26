package X2;

import W2.s;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;

abstract class P extends O {
    public static Map h() {
        E e5 = E.f20048a;
        t.c(e5, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return e5;
    }

    public static Object i(Map map, Object obj) {
        t.e(map, "<this>");
        return N.a(map, obj);
    }

    public static HashMap j(s... sVarArr) {
        t.e(sVarArr, "pairs");
        HashMap hashMap = new HashMap(O.e(sVarArr.length));
        q(hashMap, sVarArr);
        return hashMap;
    }

    public static Map k(s... sVarArr) {
        t.e(sVarArr, "pairs");
        if (sVarArr.length > 0) {
            return u(sVarArr, new LinkedHashMap(O.e(sVarArr.length)));
        }
        return h();
    }

    public static Map l(s... sVarArr) {
        t.e(sVarArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(O.e(sVarArr.length));
        q(linkedHashMap, sVarArr);
        return linkedHashMap;
    }

    public static final Map m(Map map) {
        t.e(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return h();
        }
        if (size != 1) {
            return map;
        }
        return O.g(map);
    }

    public static Map n(Map map, s sVar) {
        t.e(map, "<this>");
        t.e(sVar, "pair");
        if (map.isEmpty()) {
            return O.f(sVar);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(sVar.c(), sVar.d());
        return linkedHashMap;
    }

    public static Map o(Map map, Map map2) {
        t.e(map, "<this>");
        t.e(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final void p(Map map, Iterable iterable) {
        t.e(map, "<this>");
        t.e(iterable, "pairs");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            map.put(sVar.a(), sVar.b());
        }
    }

    public static final void q(Map map, s[] sVarArr) {
        t.e(map, "<this>");
        t.e(sVarArr, "pairs");
        for (s sVar : sVarArr) {
            map.put(sVar.a(), sVar.b());
        }
    }

    public static Map r(Iterable iterable) {
        Object next;
        t.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return m(s(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return h();
        }
        if (size != 1) {
            return s(iterable, new LinkedHashMap(O.e(collection.size())));
        }
        if (iterable instanceof List) {
            next = ((List) iterable).get(0);
        } else {
            next = collection.iterator().next();
        }
        return O.f((s) next);
    }

    public static final Map s(Iterable iterable, Map map) {
        t.e(iterable, "<this>");
        t.e(map, "destination");
        p(map, iterable);
        return map;
    }

    public static Map t(Map map) {
        t.e(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return h();
        }
        if (size != 1) {
            return v(map);
        }
        return O.g(map);
    }

    public static final Map u(s[] sVarArr, Map map) {
        t.e(sVarArr, "<this>");
        t.e(map, "destination");
        q(map, sVarArr);
        return map;
    }

    public static Map v(Map map) {
        t.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
