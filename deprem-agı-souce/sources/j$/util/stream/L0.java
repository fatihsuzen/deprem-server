package j$.util.stream;

import j$.util.Collection;
import j$.util.Spliterator;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public final class L0 implements H0 {

    /* renamed from: a  reason: collision with root package name */
    public final Collection f1527a;

    public final /* synthetic */ H0 i(long j5, long j6, IntFunction intFunction) {
        return C0594w1.V(this, j5, j6, intFunction);
    }

    public final /* synthetic */ int o() {
        return 0;
    }

    public final H0 a(int i5) {
        throw new IndexOutOfBoundsException();
    }

    public L0(Collection collection) {
        this.f1527a = collection;
    }

    public final Spliterator spliterator() {
        return Collection.EL.stream(this.f1527a).spliterator();
    }

    public final void k(Object[] objArr, int i5) {
        for (Object obj : this.f1527a) {
            objArr[i5] = obj;
            i5++;
        }
    }

    public final Object[] m(IntFunction intFunction) {
        java.util.Collection collection = this.f1527a;
        return collection.toArray((Object[]) intFunction.apply(collection.size()));
    }

    public final long count() {
        return (long) this.f1527a.size();
    }

    public final void forEach(Consumer consumer) {
        Collection.EL.a(this.f1527a, consumer);
    }

    public final String toString() {
        return String.format("CollectionNode[%d][%s]", new Object[]{Integer.valueOf(this.f1527a.size()), this.f1527a});
    }
}
