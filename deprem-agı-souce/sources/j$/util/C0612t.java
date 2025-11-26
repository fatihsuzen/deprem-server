package j$.util;

import j$.util.Collection;
import j$.util.stream.C0594w1;
import j$.util.stream.Stream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

/* renamed from: j$.util.t  reason: case insensitive filesystem */
public final class C0612t extends C0615w {
    private static final long serialVersionUID = 7854390611657943733L;

    public final void forEach(Consumer consumer) {
        Objects.requireNonNull(consumer);
        Collection.EL.a(this.f1415a, new C0481q(0, consumer));
    }

    public final Spliterator spliterator() {
        return new C0482s(Collection.EL.c(this.f1415a));
    }

    public final Stream stream() {
        return C0594w1.E0(spliterator(), false);
    }

    public final Stream parallelStream() {
        return C0594w1.E0(spliterator(), true);
    }

    public final Iterator iterator() {
        return new C0477m(this);
    }

    public final Object[] toArray() {
        Object[] array = this.f1415a.toArray();
        for (int i5 = 0; i5 < array.length; i5++) {
            array[i5] = new r((Map.Entry) array[i5]);
        }
        return array;
    }

    public final Object[] toArray(Object[] objArr) {
        Object[] array = this.f1415a.toArray(objArr.length == 0 ? objArr : Arrays.copyOf(objArr, 0));
        for (int i5 = 0; i5 < array.length; i5++) {
            array[i5] = new r((Map.Entry) array[i5]);
        }
        if (array.length > objArr.length) {
            return array;
        }
        System.arraycopy(array, 0, objArr, 0, array.length);
        if (objArr.length > array.length) {
            objArr[array.length] = null;
        }
        return objArr;
    }

    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return this.f1415a.contains(new r((Map.Entry) obj));
    }

    public final boolean containsAll(java.util.Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set.size() != this.f1415a.size()) {
            return false;
        }
        return containsAll(set);
    }
}
