package j$.util.concurrent;

import j$.util.Collection;
import j$.util.Spliterator;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public final class i extends b implements Set, Collection {
    private static final long serialVersionUID = 7249069246763182397L;

    public final /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.CC.$default$toArray(this, intFunction);
    }

    public final boolean contains(Object obj) {
        return this.f1313a.containsKey(obj);
    }

    public final boolean remove(Object obj) {
        return this.f1313a.remove(obj) != null;
    }

    public final Iterator iterator() {
        ConcurrentHashMap concurrentHashMap = this.f1313a;
        l[] lVarArr = concurrentHashMap.f1298a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new h(lVarArr, length, length, concurrentHashMap, 0);
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        Iterator it = iterator();
        int i5 = 0;
        while (((a) it).hasNext()) {
            i5 += ((h) it).next().hashCode();
        }
        return i5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set != this) {
            return containsAll(set) && set.containsAll(this);
        }
        return true;
    }

    public final Spliterator spliterator() {
        ConcurrentHashMap concurrentHashMap = this.f1313a;
        long j5 = concurrentHashMap.j();
        l[] lVarArr = concurrentHashMap.f1298a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new j(lVarArr, length, 0, length, j5 < 0 ? 0 : j5, 0);
    }

    public final void forEach(Consumer consumer) {
        consumer.getClass();
        l[] lVarArr = this.f1313a.f1298a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 != null) {
                    consumer.accept(a5.f1324b);
                } else {
                    return;
                }
            }
        }
    }
}
