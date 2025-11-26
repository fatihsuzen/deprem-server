package j$.util.concurrent;

import j$.util.Objects;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

/* renamed from: j$.util.concurrent.ConcurrentMap$-EL  reason: invalid class name */
public final /* synthetic */ class ConcurrentMap$EL {
    public static Object computeIfAbsent(ConcurrentMap concurrentMap, Object obj, Function function) {
        Object apply;
        if (concurrentMap instanceof u) {
            return ((u) concurrentMap).computeIfAbsent(obj, function);
        }
        Objects.requireNonNull(function);
        Object obj2 = concurrentMap.get(obj);
        if (obj2 != null || (apply = function.apply(obj)) == null) {
            return obj2;
        }
        Object putIfAbsent = concurrentMap.putIfAbsent(obj, apply);
        return putIfAbsent == null ? apply : putIfAbsent;
    }
}
