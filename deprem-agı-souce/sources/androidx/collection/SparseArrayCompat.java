package androidx.collection;

import X2.C2242i;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public class SparseArrayCompat<E> implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ int[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public SparseArrayCompat() {
        this(0, 1, (C2633k) null);
    }

    public void append(int i5, E e5) {
        int i6 = this.size;
        if (i6 == 0 || i5 > this.keys[i6 - 1]) {
            if (this.garbage && i6 >= this.keys.length) {
                SparseArrayCompatKt.gc(this);
            }
            int i7 = this.size;
            if (i7 >= this.keys.length) {
                int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i7 + 1);
                int[] copyOf = Arrays.copyOf(this.keys, idealIntArraySize);
                t.d(copyOf, "copyOf(this, newSize)");
                this.keys = copyOf;
                Object[] copyOf2 = Arrays.copyOf(this.values, idealIntArraySize);
                t.d(copyOf2, "copyOf(this, newSize)");
                this.values = copyOf2;
            }
            this.keys[i7] = i5;
            this.values[i7] = e5;
            this.size = i7 + 1;
            return;
        }
        put(i5, e5);
    }

    public void clear() {
        int i5 = this.size;
        Object[] objArr = this.values;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        this.size = 0;
        this.garbage = false;
    }

    public boolean containsKey(int i5) {
        if (indexOfKey(i5) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(E e5) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        int i5 = this.size;
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                i6 = -1;
                break;
            } else if (this.values[i6] == e5) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 >= 0) {
            return true;
        }
        return false;
    }

    public void delete(int i5) {
        remove(i5);
    }

    public E get(int i5) {
        return SparseArrayCompatKt.commonGet(this, i5);
    }

    public final boolean getIsEmpty() {
        return isEmpty();
    }

    public int indexOfKey(int i5) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return ContainerHelpersKt.binarySearch(this.keys, this.size, i5);
    }

    public int indexOfValue(E e5) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        int i5 = this.size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.values[i6] == e5) {
                return i6;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public int keyAt(int i5) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.keys[i5];
    }

    public void put(int i5, E e5) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, i5);
        if (binarySearch >= 0) {
            this.values[binarySearch] = e5;
            return;
        }
        int i6 = ~binarySearch;
        if (i6 >= this.size || this.values[i6] != SparseArrayCompatKt.DELETED) {
            if (this.garbage && this.size >= this.keys.length) {
                SparseArrayCompatKt.gc(this);
                i6 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, i5);
            }
            int i7 = this.size;
            if (i7 >= this.keys.length) {
                int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i7 + 1);
                int[] copyOf = Arrays.copyOf(this.keys, idealIntArraySize);
                t.d(copyOf, "copyOf(this, newSize)");
                this.keys = copyOf;
                Object[] copyOf2 = Arrays.copyOf(this.values, idealIntArraySize);
                t.d(copyOf2, "copyOf(this, newSize)");
                this.values = copyOf2;
            }
            int i8 = this.size;
            if (i8 - i6 != 0) {
                int[] iArr = this.keys;
                int i9 = i6 + 1;
                C2242i.j(iArr, iArr, i9, i6, i8);
                Object[] objArr = this.values;
                C2242i.l(objArr, objArr, i9, i6, this.size);
            }
            this.keys[i6] = i5;
            this.values[i6] = e5;
            this.size++;
            return;
        }
        this.keys[i6] = i5;
        this.values[i6] = e5;
    }

    public void putAll(SparseArrayCompat<? extends E> sparseArrayCompat) {
        t.e(sparseArrayCompat, "other");
        int size2 = sparseArrayCompat.size();
        for (int i5 = 0; i5 < size2; i5++) {
            int keyAt = sparseArrayCompat.keyAt(i5);
            Object valueAt = sparseArrayCompat.valueAt(i5);
            int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, keyAt);
            if (binarySearch >= 0) {
                this.values[binarySearch] = valueAt;
            } else {
                int i6 = ~binarySearch;
                if (i6 >= this.size || this.values[i6] != SparseArrayCompatKt.DELETED) {
                    if (this.garbage && this.size >= this.keys.length) {
                        SparseArrayCompatKt.gc(this);
                        i6 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, keyAt);
                    }
                    int i7 = this.size;
                    if (i7 >= this.keys.length) {
                        int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i7 + 1);
                        int[] copyOf = Arrays.copyOf(this.keys, idealIntArraySize);
                        t.d(copyOf, "copyOf(this, newSize)");
                        this.keys = copyOf;
                        Object[] copyOf2 = Arrays.copyOf(this.values, idealIntArraySize);
                        t.d(copyOf2, "copyOf(this, newSize)");
                        this.values = copyOf2;
                    }
                    int i8 = this.size;
                    if (i8 - i6 != 0) {
                        int[] iArr = this.keys;
                        int i9 = i6 + 1;
                        C2242i.j(iArr, iArr, i9, i6, i8);
                        Object[] objArr = this.values;
                        C2242i.l(objArr, objArr, i9, i6, this.size);
                    }
                    this.keys[i6] = keyAt;
                    this.values[i6] = valueAt;
                    this.size++;
                } else {
                    this.keys[i6] = keyAt;
                    this.values[i6] = valueAt;
                }
            }
        }
    }

    public E putIfAbsent(int i5, E e5) {
        E commonGet = SparseArrayCompatKt.commonGet(this, i5);
        if (commonGet == null) {
            int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, i5);
            if (binarySearch >= 0) {
                this.values[binarySearch] = e5;
                return commonGet;
            }
            int i6 = ~binarySearch;
            if (i6 >= this.size || this.values[i6] != SparseArrayCompatKt.DELETED) {
                if (this.garbage && this.size >= this.keys.length) {
                    SparseArrayCompatKt.gc(this);
                    i6 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, i5);
                }
                int i7 = this.size;
                if (i7 >= this.keys.length) {
                    int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i7 + 1);
                    int[] copyOf = Arrays.copyOf(this.keys, idealIntArraySize);
                    t.d(copyOf, "copyOf(this, newSize)");
                    this.keys = copyOf;
                    Object[] copyOf2 = Arrays.copyOf(this.values, idealIntArraySize);
                    t.d(copyOf2, "copyOf(this, newSize)");
                    this.values = copyOf2;
                }
                int i8 = this.size;
                if (i8 - i6 != 0) {
                    int[] iArr = this.keys;
                    int i9 = i6 + 1;
                    C2242i.j(iArr, iArr, i9, i6, i8);
                    Object[] objArr = this.values;
                    C2242i.l(objArr, objArr, i9, i6, this.size);
                }
                this.keys[i6] = i5;
                this.values[i6] = e5;
                this.size++;
            } else {
                this.keys[i6] = i5;
                this.values[i6] = e5;
                return commonGet;
            }
        }
        return commonGet;
    }

    public void remove(int i5) {
        SparseArrayCompatKt.commonRemove(this, i5);
    }

    public void removeAt(int i5) {
        if (this.values[i5] != SparseArrayCompatKt.DELETED) {
            this.values[i5] = SparseArrayCompatKt.DELETED;
            this.garbage = true;
        }
    }

    public void removeAtRange(int i5, int i6) {
        int min = Math.min(i6, i5 + i6);
        while (i5 < min) {
            removeAt(i5);
            i5++;
        }
    }

    public E replace(int i5, E e5) {
        int indexOfKey = indexOfKey(i5);
        if (indexOfKey < 0) {
            return null;
        }
        E[] eArr = this.values;
        E e6 = eArr[indexOfKey];
        eArr[indexOfKey] = e5;
        return e6;
    }

    public void setValueAt(int i5, E e5) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        this.values[i5] = e5;
    }

    public int size() {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.size;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i5 = this.size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i6));
            sb.append('=');
            Object valueAt = valueAt(i6);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        t.d(sb2, "buffer.toString()");
        return sb2;
    }

    public E valueAt(int i5) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.values[i5];
    }

    public SparseArrayCompat(int i5) {
        if (i5 == 0) {
            this.keys = ContainerHelpersKt.EMPTY_INTS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
            return;
        }
        int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i5);
        this.keys = new int[idealIntArraySize];
        this.values = new Object[idealIntArraySize];
    }

    public SparseArrayCompat<E> clone() {
        Object clone = super.clone();
        t.c(clone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) clone;
        sparseArrayCompat.keys = (int[]) this.keys.clone();
        sparseArrayCompat.values = (Object[]) this.values.clone();
        return sparseArrayCompat;
    }

    public E get(int i5, E e5) {
        return SparseArrayCompatKt.commonGet(this, i5, e5);
    }

    public boolean remove(int i5, Object obj) {
        int indexOfKey = indexOfKey(i5);
        if (indexOfKey < 0 || !t.a(obj, valueAt(indexOfKey))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public boolean replace(int i5, E e5, E e6) {
        int indexOfKey = indexOfKey(i5);
        if (indexOfKey < 0 || !t.a(this.values[indexOfKey], e5)) {
            return false;
        }
        this.values[indexOfKey] = e6;
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SparseArrayCompat(int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 10 : i5);
    }
}
