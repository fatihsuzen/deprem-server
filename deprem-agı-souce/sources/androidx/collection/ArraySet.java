package androidx.collection;

import X2.C2242i;
import X2.C2250q;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l3.C2678b;

public final class ArraySet<E> implements Collection<E>, Set<E>, C2678b {
    private int _size;
    private Object[] array;
    private int[] hashes;

    private final class ElementIterator extends IndexBasedArrayIterator<E> {
        public ElementIterator() {
            super(ArraySet.this.get_size$collection());
        }

        /* access modifiers changed from: protected */
        public E elementAt(int i5) {
            return ArraySet.this.valueAt(i5);
        }

        /* access modifiers changed from: protected */
        public void removeAt(int i5) {
            ArraySet.this.removeAt(i5);
        }
    }

    public ArraySet() {
        this(0, 1, (C2633k) null);
    }

    public boolean add(E e5) {
        int i5;
        int i6;
        E e6 = e5;
        int i7 = get_size$collection();
        boolean z4 = false;
        if (e6 == null) {
            i6 = ArraySetKt.indexOfNull(this);
            i5 = 0;
        } else {
            int hashCode = e6.hashCode();
            i5 = hashCode;
            i6 = ArraySetKt.indexOf(this, e6, hashCode);
        }
        if (i6 >= 0) {
            return false;
        }
        int i8 = ~i6;
        if (i7 >= getHashes$collection().length) {
            int i9 = 8;
            if (i7 >= 8) {
                i9 = (i7 >> 1) + i7;
            } else if (i7 < 4) {
                i9 = 4;
            }
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i9);
            if (i7 == get_size$collection()) {
                if (getHashes$collection().length == 0) {
                    z4 = true;
                }
                if (!z4) {
                    C2242i.o(hashes$collection, getHashes$collection(), 0, 0, hashes$collection.length, 6, (Object) null);
                    C2242i.q(array$collection, getArray$collection(), 0, 0, array$collection.length, 6, (Object) null);
                }
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i8 < i7) {
            int i10 = i8 + 1;
            C2242i.j(getHashes$collection(), getHashes$collection(), i10, i8, i7);
            C2242i.l(getArray$collection(), getArray$collection(), i10, i8, i7);
        }
        if (i7 != get_size$collection() || i8 >= getHashes$collection().length) {
            throw new ConcurrentModificationException();
        }
        getHashes$collection()[i8] = i5;
        getArray$collection()[i8] = e6;
        set_size$collection(get_size$collection() + 1);
        return true;
    }

    public final void addAll(ArraySet<? extends E> arraySet) {
        t.e(arraySet, "array");
        int i5 = arraySet.get_size$collection();
        ensureCapacity(get_size$collection() + i5);
        if (get_size$collection() != 0) {
            for (int i6 = 0; i6 < i5; i6++) {
                add(arraySet.valueAt(i6));
            }
        } else if (i5 > 0) {
            C2242i.o(arraySet.getHashes$collection(), getHashes$collection(), 0, 0, i5, 6, (Object) null);
            C2242i.q(arraySet.getArray$collection(), getArray$collection(), 0, 0, i5, 6, (Object) null);
            if (get_size$collection() == 0) {
                set_size$collection(i5);
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        if (get_size$collection() != 0) {
            setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            set_size$collection(0);
        }
        if (get_size$collection() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        t.e(collection, "elements");
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final void ensureCapacity(int i5) {
        int i6 = get_size$collection();
        if (getHashes$collection().length < i5) {
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i5);
            if (get_size$collection() > 0) {
                C2242i.o(hashes$collection, getHashes$collection(), 0, 0, get_size$collection(), 6, (Object) null);
                C2242i.q(array$collection, getArray$collection(), 0, 0, get_size$collection(), 6, (Object) null);
            }
        }
        if (get_size$collection() != i6) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int i5 = get_size$collection();
            for (int i6 = 0; i6 < i5; i6++) {
                if (!((Set) obj).contains(valueAt(i6))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final Object[] getArray$collection() {
        return this.array;
    }

    public final int[] getHashes$collection() {
        return this.hashes;
    }

    public int getSize() {
        return this._size;
    }

    public final int get_size$collection() {
        return this._size;
    }

    public int hashCode() {
        int[] hashes$collection = getHashes$collection();
        int i5 = get_size$collection();
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += hashes$collection[i7];
        }
        return i6;
    }

    public final int indexOf(Object obj) {
        if (obj == null) {
            return ArraySetKt.indexOfNull(this);
        }
        return ArraySetKt.indexOf(this, obj, obj.hashCode());
    }

    public boolean isEmpty() {
        if (get_size$collection() <= 0) {
            return true;
        }
        return false;
    }

    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(ArraySet<? extends E> arraySet) {
        t.e(arraySet, "array");
        int i5 = arraySet.get_size$collection();
        int i6 = get_size$collection();
        for (int i7 = 0; i7 < i5; i7++) {
            remove(arraySet.valueAt(i7));
        }
        if (i6 != get_size$collection()) {
            return true;
        }
        return false;
    }

    public final E removeAt(int i5) {
        int i6;
        Object[] objArr;
        int i7 = get_size$collection();
        E e5 = getArray$collection()[i5];
        if (i7 <= 1) {
            clear();
            return e5;
        }
        int i8 = i7 - 1;
        int i9 = 8;
        if (getHashes$collection().length <= 8 || get_size$collection() >= getHashes$collection().length / 3) {
            int i10 = i5;
            if (i10 < i8) {
                int i11 = i10 + 1;
                C2242i.j(getHashes$collection(), getHashes$collection(), i10, i11, i7);
                C2242i.l(getArray$collection(), getArray$collection(), i10, i11, i7);
            }
            getArray$collection()[i8] = null;
        } else {
            if (get_size$collection() > 8) {
                i9 = get_size$collection() + (get_size$collection() >> 1);
            }
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i9);
            if (i5 > 0) {
                int i12 = i5;
                C2242i.o(hashes$collection, getHashes$collection(), 0, 0, i12, 6, (Object) null);
                int i13 = i12;
                objArr = array$collection;
                C2242i.q(objArr, getArray$collection(), 0, 0, i13, 6, (Object) null);
                i6 = i13;
            } else {
                i6 = i5;
                objArr = array$collection;
            }
            if (i6 < i8) {
                int i14 = i6 + 1;
                C2242i.j(hashes$collection, getHashes$collection(), i6, i14, i7);
                C2242i.l(objArr, getArray$collection(), i6, i14, i7);
            }
        }
        if (i7 == get_size$collection()) {
            set_size$collection(i8);
            return e5;
        }
        throw new ConcurrentModificationException();
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        t.e(collection, "elements");
        boolean z4 = false;
        for (int i5 = get_size$collection() - 1; -1 < i5; i5--) {
            if (!C2250q.E(collection, getArray$collection()[i5])) {
                removeAt(i5);
                z4 = true;
            }
        }
        return z4;
    }

    public final void setArray$collection(Object[] objArr) {
        t.e(objArr, "<set-?>");
        this.array = objArr;
    }

    public final void setHashes$collection(int[] iArr) {
        t.e(iArr, "<set-?>");
        this.hashes = iArr;
    }

    public final void set_size$collection(int i5) {
        this._size = i5;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final Object[] toArray() {
        return C2242i.s(this.array, 0, this._size);
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(get_size$collection() * 14);
        sb.append('{');
        int i5 = get_size$collection();
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            Object valueAt = valueAt(i6);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public final E valueAt(int i5) {
        return getArray$collection()[i5];
    }

    public ArraySet(int i5) {
        this.hashes = ContainerHelpersKt.EMPTY_INTS;
        this.array = ContainerHelpersKt.EMPTY_OBJECTS;
        if (i5 > 0) {
            ArraySetKt.allocArrays(this, i5);
        }
    }

    public final <T> T[] toArray(T[] tArr) {
        t.e(tArr, "array");
        T[] resizeForToArray = ArraySetJvmUtil.resizeForToArray(tArr, this._size);
        C2242i.l(this.array, resizeForToArray, 0, 0, this._size);
        t.d(resizeForToArray, "result");
        return resizeForToArray;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        t.e(collection, "elements");
        boolean z4 = false;
        for (Object remove : collection) {
            z4 |= remove(remove);
        }
        return z4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ArraySet(int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 0 : i5);
    }

    public ArraySet(ArraySet<? extends E> arraySet) {
        this(0);
        if (arraySet != null) {
            addAll(arraySet);
        }
    }

    public ArraySet(Collection<? extends E> collection) {
        this(0);
        if (collection != null) {
            addAll(collection);
        }
    }

    public boolean addAll(Collection<? extends E> collection) {
        t.e(collection, "elements");
        ensureCapacity(get_size$collection() + collection.size());
        boolean z4 = false;
        for (Object add : collection) {
            z4 |= add(add);
        }
        return z4;
    }

    public ArraySet(E[] eArr) {
        this(0);
        if (eArr != null) {
            Iterator a5 = C2625c.a(eArr);
            while (a5.hasNext()) {
                add(a5.next());
            }
        }
    }
}
