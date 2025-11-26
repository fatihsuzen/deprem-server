package androidx.collection;

import X2.C2242i;
import X2.C2250q;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class ArraySetKt {
    public static final int ARRAY_SET_BASE_SIZE = 4;

    public static final <E> void addAllInternal(ArraySet<E> arraySet, ArraySet<? extends E> arraySet2) {
        t.e(arraySet, "<this>");
        t.e(arraySet2, "array");
        int i5 = arraySet2.get_size$collection();
        arraySet.ensureCapacity(arraySet.get_size$collection() + i5);
        if (arraySet.get_size$collection() != 0) {
            for (int i6 = 0; i6 < i5; i6++) {
                arraySet.add(arraySet2.valueAt(i6));
            }
        } else if (i5 > 0) {
            C2242i.o(arraySet2.getHashes$collection(), arraySet.getHashes$collection(), 0, 0, i5, 6, (Object) null);
            C2242i.q(arraySet2.getArray$collection(), arraySet.getArray$collection(), 0, 0, i5, 6, (Object) null);
            if (arraySet.get_size$collection() == 0) {
                arraySet.set_size$collection(i5);
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> boolean addInternal(ArraySet<E> arraySet, E e5) {
        int i5;
        int i6;
        ArraySet<E> arraySet2 = arraySet;
        E e6 = e5;
        t.e(arraySet2, "<this>");
        int i7 = arraySet2.get_size$collection();
        boolean z4 = false;
        if (e6 == null) {
            i6 = indexOfNull(arraySet2);
            i5 = 0;
        } else {
            int hashCode = e6.hashCode();
            i5 = hashCode;
            i6 = indexOf(arraySet2, e6, hashCode);
        }
        if (i6 >= 0) {
            return false;
        }
        int i8 = ~i6;
        if (i7 >= arraySet2.getHashes$collection().length) {
            int i9 = 8;
            if (i7 >= 8) {
                i9 = (i7 >> 1) + i7;
            } else if (i7 < 4) {
                i9 = 4;
            }
            int[] hashes$collection = arraySet2.getHashes$collection();
            Object[] array$collection = arraySet2.getArray$collection();
            allocArrays(arraySet2, i9);
            if (i7 == arraySet2.get_size$collection()) {
                if (arraySet2.getHashes$collection().length == 0) {
                    z4 = true;
                }
                if (!z4) {
                    C2242i.o(hashes$collection, arraySet2.getHashes$collection(), 0, 0, hashes$collection.length, 6, (Object) null);
                    C2242i.q(array$collection, arraySet2.getArray$collection(), 0, 0, array$collection.length, 6, (Object) null);
                }
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i8 < i7) {
            int i10 = i8 + 1;
            C2242i.j(arraySet2.getHashes$collection(), arraySet2.getHashes$collection(), i10, i8, i7);
            C2242i.l(arraySet2.getArray$collection(), arraySet2.getArray$collection(), i10, i8, i7);
        }
        if (i7 != arraySet2.get_size$collection() || i8 >= arraySet2.getHashes$collection().length) {
            throw new ConcurrentModificationException();
        }
        arraySet2.getHashes$collection()[i8] = i5;
        arraySet2.getArray$collection()[i8] = e6;
        arraySet2.set_size$collection(arraySet2.get_size$collection() + 1);
        return true;
    }

    public static final <E> void allocArrays(ArraySet<E> arraySet, int i5) {
        t.e(arraySet, "<this>");
        arraySet.setHashes$collection(new int[i5]);
        arraySet.setArray$collection(new Object[i5]);
    }

    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet<>(0, 1, (C2633k) null);
    }

    public static final <E> int binarySearchInternal(ArraySet<E> arraySet, int i5) {
        t.e(arraySet, "<this>");
        try {
            return ContainerHelpersKt.binarySearch(arraySet.getHashes$collection(), arraySet.get_size$collection(), i5);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> void clearInternal(ArraySet<E> arraySet) {
        t.e(arraySet, "<this>");
        if (arraySet.get_size$collection() != 0) {
            arraySet.setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            arraySet.setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            arraySet.set_size$collection(0);
        }
        if (arraySet.get_size$collection() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> boolean containsAllInternal(ArraySet<E> arraySet, Collection<? extends E> collection) {
        t.e(arraySet, "<this>");
        t.e(collection, "elements");
        for (Object contains : collection) {
            if (!arraySet.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public static final <E> boolean containsInternal(ArraySet<E> arraySet, E e5) {
        t.e(arraySet, "<this>");
        if (arraySet.indexOf(e5) >= 0) {
            return true;
        }
        return false;
    }

    public static final <E> void ensureCapacityInternal(ArraySet<E> arraySet, int i5) {
        t.e(arraySet, "<this>");
        int i6 = arraySet.get_size$collection();
        if (arraySet.getHashes$collection().length < i5) {
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i5);
            if (arraySet.get_size$collection() > 0) {
                C2242i.o(hashes$collection, arraySet.getHashes$collection(), 0, 0, arraySet.get_size$collection(), 6, (Object) null);
                C2242i.q(array$collection, arraySet.getArray$collection(), 0, 0, arraySet.get_size$collection(), 6, (Object) null);
            }
        }
        if (arraySet.get_size$collection() != i6) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> boolean equalsInternal(ArraySet<E> arraySet, Object obj) {
        t.e(arraySet, "<this>");
        if (arraySet == obj) {
            return true;
        }
        if (!(obj instanceof Set) || arraySet.size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int i5 = arraySet.get_size$collection();
            for (int i6 = 0; i6 < i5; i6++) {
                if (!((Set) obj).contains(arraySet.valueAt(i6))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static final <E> int hashCodeInternal(ArraySet<E> arraySet) {
        t.e(arraySet, "<this>");
        int[] hashes$collection = arraySet.getHashes$collection();
        int i5 = arraySet.get_size$collection();
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += hashes$collection[i7];
        }
        return i6;
    }

    public static final <E> int indexOf(ArraySet<E> arraySet, Object obj, int i5) {
        t.e(arraySet, "<this>");
        int i6 = arraySet.get_size$collection();
        if (i6 == 0) {
            return -1;
        }
        int binarySearchInternal = binarySearchInternal(arraySet, i5);
        if (binarySearchInternal < 0 || t.a(obj, arraySet.getArray$collection()[binarySearchInternal])) {
            return binarySearchInternal;
        }
        int i7 = binarySearchInternal + 1;
        while (i7 < i6 && arraySet.getHashes$collection()[i7] == i5) {
            if (t.a(obj, arraySet.getArray$collection()[i7])) {
                return i7;
            }
            i7++;
        }
        int i8 = binarySearchInternal - 1;
        while (i8 >= 0 && arraySet.getHashes$collection()[i8] == i5) {
            if (t.a(obj, arraySet.getArray$collection()[i8])) {
                return i8;
            }
            i8--;
        }
        return ~i7;
    }

    public static final <E> int indexOfInternal(ArraySet<E> arraySet, Object obj) {
        t.e(arraySet, "<this>");
        if (obj == null) {
            return indexOfNull(arraySet);
        }
        return indexOf(arraySet, obj, obj.hashCode());
    }

    public static final <E> int indexOfNull(ArraySet<E> arraySet) {
        t.e(arraySet, "<this>");
        return indexOf(arraySet, (Object) null, 0);
    }

    public static final <E> boolean isEmptyInternal(ArraySet<E> arraySet) {
        t.e(arraySet, "<this>");
        if (arraySet.get_size$collection() <= 0) {
            return true;
        }
        return false;
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> arraySet, ArraySet<? extends E> arraySet2) {
        t.e(arraySet, "<this>");
        t.e(arraySet2, "array");
        int i5 = arraySet2.get_size$collection();
        int i6 = arraySet.get_size$collection();
        for (int i7 = 0; i7 < i5; i7++) {
            arraySet.remove(arraySet2.valueAt(i7));
        }
        if (i6 != arraySet.get_size$collection()) {
            return true;
        }
        return false;
    }

    public static final <E> E removeAtInternal(ArraySet<E> arraySet, int i5) {
        int i6;
        Object[] objArr;
        t.e(arraySet, "<this>");
        int i7 = arraySet.get_size$collection();
        E e5 = arraySet.getArray$collection()[i5];
        if (i7 <= 1) {
            arraySet.clear();
            return e5;
        }
        int i8 = i7 - 1;
        int i9 = 8;
        if (arraySet.getHashes$collection().length <= 8 || arraySet.get_size$collection() >= arraySet.getHashes$collection().length / 3) {
            int i10 = i5;
            if (i10 < i8) {
                int i11 = i10 + 1;
                C2242i.j(arraySet.getHashes$collection(), arraySet.getHashes$collection(), i10, i11, i7);
                C2242i.l(arraySet.getArray$collection(), arraySet.getArray$collection(), i10, i11, i7);
            }
            arraySet.getArray$collection()[i8] = null;
        } else {
            if (arraySet.get_size$collection() > 8) {
                i9 = arraySet.get_size$collection() + (arraySet.get_size$collection() >> 1);
            }
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i9);
            if (i5 > 0) {
                int i12 = i5;
                C2242i.o(hashes$collection, arraySet.getHashes$collection(), 0, 0, i12, 6, (Object) null);
                int i13 = i12;
                objArr = array$collection;
                C2242i.q(objArr, arraySet.getArray$collection(), 0, 0, i13, 6, (Object) null);
                i6 = i13;
            } else {
                i6 = i5;
                objArr = array$collection;
            }
            if (i6 < i8) {
                int i14 = i6 + 1;
                C2242i.j(hashes$collection, arraySet.getHashes$collection(), i6, i14, i7);
                C2242i.l(objArr, arraySet.getArray$collection(), i6, i14, i7);
            }
        }
        if (i7 == arraySet.get_size$collection()) {
            arraySet.set_size$collection(i8);
            return e5;
        }
        throw new ConcurrentModificationException();
    }

    public static final <E> boolean removeInternal(ArraySet<E> arraySet, E e5) {
        t.e(arraySet, "<this>");
        int indexOf = arraySet.indexOf(e5);
        if (indexOf < 0) {
            return false;
        }
        arraySet.removeAt(indexOf);
        return true;
    }

    public static final <E> boolean retainAllInternal(ArraySet<E> arraySet, Collection<? extends E> collection) {
        t.e(arraySet, "<this>");
        t.e(collection, "elements");
        boolean z4 = false;
        for (int i5 = arraySet.get_size$collection() - 1; -1 < i5; i5--) {
            if (!C2250q.E(collection, arraySet.getArray$collection()[i5])) {
                arraySet.removeAt(i5);
                z4 = true;
            }
        }
        return z4;
    }

    public static final <E> String toStringInternal(ArraySet<E> arraySet) {
        t.e(arraySet, "<this>");
        if (arraySet.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(arraySet.get_size$collection() * 14);
        sb.append('{');
        int i5 = arraySet.get_size$collection();
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            E valueAt = arraySet.valueAt(i6);
            if (valueAt != arraySet) {
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

    public static final <E> E valueAtInternal(ArraySet<E> arraySet, int i5) {
        t.e(arraySet, "<this>");
        return arraySet.getArray$collection()[i5];
    }

    public static final <T> ArraySet<T> arraySetOf(T... tArr) {
        t.e(tArr, "values");
        ArraySet<T> arraySet = new ArraySet<>(tArr.length);
        for (T add : tArr) {
            arraySet.add(add);
        }
        return arraySet;
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> arraySet, Collection<? extends E> collection) {
        t.e(arraySet, "<this>");
        t.e(collection, "elements");
        boolean z4 = false;
        for (Object remove : collection) {
            z4 |= arraySet.remove(remove);
        }
        return z4;
    }

    public static final <E> boolean addAllInternal(ArraySet<E> arraySet, Collection<? extends E> collection) {
        t.e(arraySet, "<this>");
        t.e(collection, "elements");
        arraySet.ensureCapacity(arraySet.get_size$collection() + collection.size());
        boolean z4 = false;
        for (Object add : collection) {
            z4 |= arraySet.add(add);
        }
        return z4;
    }
}
