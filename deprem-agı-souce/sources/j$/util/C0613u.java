package j$.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* renamed from: j$.util.u  reason: case insensitive filesystem */
public final class C0613u implements Map, Serializable, Map {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: a  reason: collision with root package name */
    public final Map f1844a;

    /* renamed from: b  reason: collision with root package name */
    public transient Set f1845b;

    /* renamed from: c  reason: collision with root package name */
    public transient C0612t f1846c;

    /* renamed from: d  reason: collision with root package name */
    public transient Collection f1847d;

    public C0613u(Map map) {
        map.getClass();
        this.f1844a = map;
    }

    public final int size() {
        return this.f1844a.size();
    }

    public final boolean isEmpty() {
        return this.f1844a.isEmpty();
    }

    public final boolean containsKey(Object obj) {
        return this.f1844a.containsKey(obj);
    }

    public final boolean containsValue(Object obj) {
        return this.f1844a.containsValue(obj);
    }

    public final Object get(Object obj) {
        return this.f1844a.get(obj);
    }

    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final Set keySet() {
        if (this.f1845b == null) {
            this.f1845b = DesugarCollections.unmodifiableSet(this.f1844a.keySet());
        }
        return this.f1845b;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [j$.util.t, j$.util.n] */
    public final Set entrySet() {
        if (this.f1846c == null) {
            this.f1846c = new C0478n(this.f1844a.entrySet());
        }
        return this.f1846c;
    }

    public final Collection values() {
        if (this.f1847d == null) {
            this.f1847d = DesugarCollections.unmodifiableCollection(this.f1844a.values());
        }
        return this.f1847d;
    }

    public final boolean equals(Object obj) {
        return obj == this || this.f1844a.equals(obj);
    }

    public final int hashCode() {
        return this.f1844a.hashCode();
    }

    public final String toString() {
        return this.f1844a.toString();
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        return C0469e.s(this.f1844a, obj, obj2);
    }

    public final void forEach(BiConsumer biConsumer) {
        C0469e.q(this.f1844a, biConsumer);
    }

    public final void replaceAll(BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException();
    }

    public final Object replace(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public final Object computeIfAbsent(Object obj, Function function) {
        throw new UnsupportedOperationException();
    }

    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    public final Object compute(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }
}
