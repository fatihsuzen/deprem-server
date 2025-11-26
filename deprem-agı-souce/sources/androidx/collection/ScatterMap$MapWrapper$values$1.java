package androidx.collection;

import b3.C2308e;
import j$.lang.Iterable$CC;
import j$.util.Collection;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import kotlin.jvm.internal.C2632j;
import kotlin.jvm.internal.t;
import l3.C2677a;
import s3.C2754h;

public final class ScatterMap$MapWrapper$values$1 implements Collection<V>, C2677a, j$.util.Collection {
    final /* synthetic */ ScatterMap<K, V> this$0;

    ScatterMap$MapWrapper$values$1(ScatterMap<K, V> scatterMap) {
        this.this$0 = scatterMap;
    }

    public boolean add(V v5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends V> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        return this.this$0.containsValue(obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        t.e(collection, "elements");
        Iterable<Object> iterable = collection;
        ScatterMap<K, V> scatterMap = this.this$0;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object containsValue : iterable) {
            if (!scatterMap.containsValue(containsValue)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable$CC.$default$forEach(this, consumer);
    }

    public int getSize() {
        return this.this$0._size;
    }

    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    public Iterator<V> iterator() {
        return C2754h.a(new ScatterMap$MapWrapper$values$1$iterator$1(this.this$0, (C2308e) null));
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeIf(Predicate<? super V> predicate) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public Object[] toArray() {
        return C2632j.a(this);
    }

    public /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.CC.$default$toArray(this, intFunction);
    }

    public <T> T[] toArray(T[] tArr) {
        t.e(tArr, "array");
        return C2632j.b(this, tArr);
    }
}
