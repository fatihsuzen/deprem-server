package j$.util;

import j$.com.android.tools.r8.a;
import j$.util.Map;
import j$.util.concurrent.t;
import j$.util.concurrent.u;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* renamed from: j$.util.j  reason: case insensitive filesystem */
public final class C0474j implements Map, Serializable, Map {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: a  reason: collision with root package name */
    public final Map f1394a;

    /* renamed from: b  reason: collision with root package name */
    public final C0474j f1395b = this;

    /* renamed from: c  reason: collision with root package name */
    public transient C0476l f1396c;

    /* renamed from: d  reason: collision with root package name */
    public transient C0476l f1397d;

    /* renamed from: e  reason: collision with root package name */
    public transient C0472h f1398e;

    public C0474j(Map map) {
        this.f1394a = (Map) Objects.requireNonNull(map);
    }

    public final int size() {
        int size;
        synchronized (this.f1395b) {
            size = this.f1394a.size();
        }
        return size;
    }

    public final boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.f1395b) {
            isEmpty = this.f1394a.isEmpty();
        }
        return isEmpty;
    }

    public final boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.f1395b) {
            containsKey = this.f1394a.containsKey(obj);
        }
        return containsKey;
    }

    public final boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.f1395b) {
            containsValue = this.f1394a.containsValue(obj);
        }
        return containsValue;
    }

    public final Object get(Object obj) {
        Object obj2;
        synchronized (this.f1395b) {
            obj2 = this.f1394a.get(obj);
        }
        return obj2;
    }

    public final Object put(Object obj, Object obj2) {
        Object put;
        synchronized (this.f1395b) {
            put = this.f1394a.put(obj, obj2);
        }
        return put;
    }

    public final Object remove(Object obj) {
        Object remove;
        synchronized (this.f1395b) {
            remove = this.f1394a.remove(obj);
        }
        return remove;
    }

    public final void putAll(Map map) {
        synchronized (this.f1395b) {
            this.f1394a.putAll(map);
        }
    }

    public final void clear() {
        synchronized (this.f1395b) {
            this.f1394a.clear();
        }
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [j$.util.h, j$.util.l] */
    public final Set keySet() {
        C0476l lVar;
        synchronized (this.f1395b) {
            try {
                if (this.f1396c == null) {
                    this.f1396c = new C0472h(this.f1394a.keySet(), this.f1395b);
                }
                lVar = this.f1396c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [j$.util.h, j$.util.l] */
    public final Set entrySet() {
        C0476l lVar;
        synchronized (this.f1395b) {
            try {
                if (this.f1397d == null) {
                    this.f1397d = new C0472h(this.f1394a.entrySet(), this.f1395b);
                }
                lVar = this.f1397d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    public final Collection values() {
        C0472h hVar;
        synchronized (this.f1395b) {
            try {
                if (this.f1398e == null) {
                    this.f1398e = new C0472h(this.f1394a.values(), this.f1395b);
                }
                hVar = this.f1398e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    public final boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        synchronized (this.f1395b) {
            equals = this.f1394a.equals(obj);
        }
        return equals;
    }

    public final int hashCode() {
        int hashCode;
        synchronized (this.f1395b) {
            hashCode = this.f1394a.hashCode();
        }
        return hashCode;
    }

    public final String toString() {
        String obj;
        synchronized (this.f1395b) {
            obj = this.f1394a.toString();
        }
        return obj;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        Object s5;
        synchronized (this.f1395b) {
            s5 = C0469e.s(this.f1394a, obj, obj2);
        }
        return s5;
    }

    public final void forEach(BiConsumer biConsumer) {
        synchronized (this.f1395b) {
            C0469e.q(this.f1394a, biConsumer);
        }
    }

    public final void replaceAll(BiFunction biFunction) {
        synchronized (this.f1395b) {
            Map map = this.f1394a;
            if (map instanceof Map) {
                ((Map) map).replaceAll(biFunction);
            } else if (map instanceof ConcurrentMap) {
                ConcurrentMap concurrentMap = (ConcurrentMap) map;
                Objects.requireNonNull(biFunction);
                t tVar = new t(0, (Object) concurrentMap, (Object) biFunction);
                if (concurrentMap instanceof u) {
                    ((u) concurrentMap).forEach(tVar);
                } else {
                    a.j(concurrentMap, tVar);
                }
            } else {
                Map.CC.$default$replaceAll(map, biFunction);
            }
        }
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object t5;
        synchronized (this.f1395b) {
            t5 = C0469e.t(this.f1394a, obj, obj2);
        }
        return t5;
    }

    public final boolean remove(Object obj, Object obj2) {
        boolean remove;
        synchronized (this.f1395b) {
            java.util.Map map = this.f1394a;
            remove = map instanceof Map ? ((Map) map).remove(obj, obj2) : Map.CC.$default$remove(map, obj, obj2);
        }
        return remove;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        boolean replace;
        synchronized (this.f1395b) {
            java.util.Map map = this.f1394a;
            replace = map instanceof Map ? ((Map) map).replace(obj, obj2, obj3) : Map.CC.$default$replace(map, obj, obj2, obj3);
        }
        return replace;
    }

    public final Object replace(Object obj, Object obj2) {
        Object replace;
        synchronized (this.f1395b) {
            java.util.Map map = this.f1394a;
            replace = map instanceof Map ? ((Map) map).replace(obj, obj2) : Map.CC.$default$replace(map, obj, obj2);
        }
        return replace;
    }

    public final Object computeIfAbsent(Object obj, Function function) {
        Object obj2;
        Object apply;
        synchronized (this.f1395b) {
            java.util.Map map = this.f1394a;
            if (map instanceof Map) {
                obj2 = ((Map) map).computeIfAbsent(obj, function);
            } else if (map instanceof ConcurrentMap) {
                ConcurrentMap concurrentMap = (ConcurrentMap) map;
                Objects.requireNonNull(function);
                Object obj3 = concurrentMap.get(obj);
                if (obj3 != null || (apply = function.apply(obj)) == null) {
                    obj2 = obj3;
                } else {
                    obj2 = concurrentMap.putIfAbsent(obj, apply);
                    if (obj2 == null) {
                        obj2 = apply;
                    }
                }
            } else {
                obj2 = Map.CC.$default$computeIfAbsent(map, obj, function);
            }
        }
        return obj2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        r5 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object computeIfPresent(java.lang.Object r5, java.util.function.BiFunction r6) {
        /*
            r4 = this;
            j$.util.j r0 = r4.f1395b
            monitor-enter(r0)
            java.util.Map r1 = r4.f1394a     // Catch:{ all -> 0x003c }
            boolean r2 = r1 instanceof j$.util.Map     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0010
            j$.util.Map r1 = (j$.util.Map) r1     // Catch:{ all -> 0x003c }
            java.lang.Object r5 = r1.computeIfPresent(r5, r6)     // Catch:{ all -> 0x003c }
            goto L_0x003a
        L_0x0010:
            boolean r2 = r1 instanceof java.util.concurrent.ConcurrentMap     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0036
            java.util.concurrent.ConcurrentMap r1 = (java.util.concurrent.ConcurrentMap) r1     // Catch:{ all -> 0x003c }
            j$.util.Objects.requireNonNull(r6)     // Catch:{ all -> 0x003c }
        L_0x0019:
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0034
            java.lang.Object r3 = r6.apply(r5, r2)     // Catch:{ all -> 0x003c }
            if (r3 != 0) goto L_0x002c
            boolean r2 = r1.remove(r5, r2)     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0019
            goto L_0x0032
        L_0x002c:
            boolean r2 = r1.replace(r5, r2, r3)     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0019
        L_0x0032:
            r5 = r3
            goto L_0x003a
        L_0x0034:
            r5 = 0
            goto L_0x003a
        L_0x0036:
            java.lang.Object r5 = j$.util.Map.CC.$default$computeIfPresent(r1, r5, r6)     // Catch:{ all -> 0x003c }
        L_0x003a:
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return r5
        L_0x003c:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.C0474j.computeIfPresent(java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        r5 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object compute(java.lang.Object r5, java.util.function.BiFunction r6) {
        /*
            r4 = this;
            j$.util.j r0 = r4.f1395b
            monitor-enter(r0)
            java.util.Map r1 = r4.f1394a     // Catch:{ all -> 0x0041 }
            boolean r2 = r1 instanceof j$.util.Map     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0010
            j$.util.Map r1 = (j$.util.Map) r1     // Catch:{ all -> 0x0041 }
            java.lang.Object r5 = r1.compute(r5, r6)     // Catch:{ all -> 0x0041 }
            goto L_0x003f
        L_0x0010:
            boolean r2 = r1 instanceof java.util.concurrent.ConcurrentMap     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x003b
            java.util.concurrent.ConcurrentMap r1 = (java.util.concurrent.ConcurrentMap) r1     // Catch:{ all -> 0x0041 }
        L_0x0016:
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x0041 }
        L_0x001a:
            java.lang.Object r3 = r6.apply(r5, r2)     // Catch:{ all -> 0x0041 }
            if (r3 == 0) goto L_0x0031
            if (r2 == 0) goto L_0x0029
            boolean r2 = r1.replace(r5, r2, r3)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0016
            goto L_0x002f
        L_0x0029:
            java.lang.Object r2 = r1.putIfAbsent(r5, r3)     // Catch:{ all -> 0x0041 }
            if (r2 != 0) goto L_0x001a
        L_0x002f:
            r5 = r3
            goto L_0x003f
        L_0x0031:
            if (r2 == 0) goto L_0x0039
            boolean r2 = r1.remove(r5, r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0016
        L_0x0039:
            r5 = 0
            goto L_0x003f
        L_0x003b:
            java.lang.Object r5 = j$.util.Map.CC.$default$compute(r1, r5, r6)     // Catch:{ all -> 0x0041 }
        L_0x003f:
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return r5
        L_0x0041:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.C0474j.compute(java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r3 = r7.apply(r2, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        if (r3 == null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r1.replace(r5, r2, r3) == false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        r6 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        if (r1.remove(r5, r2) == false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        r6 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object merge(java.lang.Object r5, java.lang.Object r6, java.util.function.BiFunction r7) {
        /*
            r4 = this;
            j$.util.j r0 = r4.f1395b
            monitor-enter(r0)
            java.util.Map r1 = r4.f1394a     // Catch:{ all -> 0x0045 }
            boolean r2 = r1 instanceof j$.util.Map     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x0010
            j$.util.Map r1 = (j$.util.Map) r1     // Catch:{ all -> 0x0045 }
            java.lang.Object r6 = r1.merge(r5, r6, r7)     // Catch:{ all -> 0x0045 }
            goto L_0x0043
        L_0x0010:
            boolean r2 = r1 instanceof java.util.concurrent.ConcurrentMap     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x003f
            java.util.concurrent.ConcurrentMap r1 = (java.util.concurrent.ConcurrentMap) r1     // Catch:{ all -> 0x0045 }
            j$.util.Objects.requireNonNull(r7)     // Catch:{ all -> 0x0045 }
            j$.util.Objects.requireNonNull(r6)     // Catch:{ all -> 0x0045 }
        L_0x001c:
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x0045 }
        L_0x0020:
            if (r2 == 0) goto L_0x0038
            java.lang.Object r3 = r7.apply(r2, r6)     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x0030
            boolean r2 = r1.replace(r5, r2, r3)     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x001c
            r6 = r3
            goto L_0x0043
        L_0x0030:
            boolean r2 = r1.remove(r5, r2)     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x001c
            r6 = 0
            goto L_0x0043
        L_0x0038:
            java.lang.Object r2 = r1.putIfAbsent(r5, r6)     // Catch:{ all -> 0x0045 }
            if (r2 != 0) goto L_0x0020
            goto L_0x0043
        L_0x003f:
            java.lang.Object r6 = j$.util.Map.CC.$default$merge(r1, r5, r6, r7)     // Catch:{ all -> 0x0045 }
        L_0x0043:
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return r6
        L_0x0045:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.C0474j.merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        synchronized (this.f1395b) {
            objectOutputStream.defaultWriteObject();
        }
    }
}
