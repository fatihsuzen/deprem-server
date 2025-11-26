package j$.util.concurrent;

import j$.util.Collection;
import j$.util.Spliterator;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public final class s extends b implements Collection {
    private static final long serialVersionUID = 2249069246763182397L;

    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.CC.$default$toArray(this, intFunction);
    }

    public final boolean contains(Object obj) {
        return this.f1313a.containsValue(obj);
    }

    public final boolean remove(Object obj) {
        a aVar;
        if (obj == null) {
            return false;
        }
        Iterator it = iterator();
        do {
            aVar = (a) it;
            if (!aVar.hasNext()) {
                return false;
            }
        } while (!obj.equals(((h) it).next()));
        aVar.remove();
        return true;
    }

    public final Iterator iterator() {
        ConcurrentHashMap concurrentHashMap = this.f1313a;
        l[] lVarArr = concurrentHashMap.f1298a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new h(lVarArr, length, length, concurrentHashMap, 1);
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(java.util.Collection collection) {
        collection.getClass();
        Iterator it = iterator();
        boolean z4 = false;
        while (true) {
            a aVar = (a) it;
            if (!aVar.hasNext()) {
                return z4;
            }
            if (collection.contains(((h) it).next())) {
                aVar.remove();
                z4 = true;
            }
        }
    }

    public final boolean removeIf(Predicate predicate) {
        ConcurrentHashMap concurrentHashMap = this.f1313a;
        predicate.getClass();
        l[] lVarArr = concurrentHashMap.f1298a;
        boolean z4 = false;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 == null) {
                    break;
                }
                Object obj = a5.f1324b;
                Object obj2 = a5.f1325c;
                if (predicate.test(obj2) && concurrentHashMap.g(obj, (Object) null, obj2) != null) {
                    z4 = true;
                }
            }
        }
        return z4;
    }

    public final Spliterator spliterator() {
        ConcurrentHashMap concurrentHashMap = this.f1313a;
        long j5 = concurrentHashMap.j();
        l[] lVarArr = concurrentHashMap.f1298a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new j(lVarArr, length, 0, length, j5 < 0 ? 0 : j5, 1);
    }

    public final void forEach(Consumer consumer) {
        consumer.getClass();
        l[] lVarArr = this.f1313a.f1298a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 != null) {
                    consumer.accept(a5.f1325c);
                } else {
                    return;
                }
            }
        }
    }
}
