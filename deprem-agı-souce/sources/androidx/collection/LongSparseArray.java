package androidx.collection;

import X2.C2242i;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public class LongSparseArray<E> implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ long[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public LongSparseArray() {
        this(0, 1, (C2633k) null);
    }

    public void append(long j5, E e5) {
        int i5 = this.size;
        if (i5 == 0 || j5 > this.keys[i5 - 1]) {
            if (this.garbage) {
                long[] jArr = this.keys;
                if (i5 >= jArr.length) {
                    Object[] objArr = this.values;
                    int i6 = 0;
                    for (int i7 = 0; i7 < i5; i7++) {
                        Object obj = objArr[i7];
                        if (obj != LongSparseArrayKt.DELETED) {
                            if (i7 != i6) {
                                jArr[i6] = jArr[i7];
                                objArr[i6] = obj;
                                objArr[i7] = null;
                            }
                            i6++;
                        }
                    }
                    this.garbage = false;
                    this.size = i6;
                }
            }
            int i8 = this.size;
            if (i8 >= this.keys.length) {
                int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i8 + 1);
                long[] copyOf = Arrays.copyOf(this.keys, idealLongArraySize);
                t.d(copyOf, "copyOf(this, newSize)");
                this.keys = copyOf;
                Object[] copyOf2 = Arrays.copyOf(this.values, idealLongArraySize);
                t.d(copyOf2, "copyOf(this, newSize)");
                this.values = copyOf2;
            }
            this.keys[i8] = j5;
            this.values[i8] = e5;
            this.size = i8 + 1;
            return;
        }
        put(j5, e5);
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

    public boolean containsKey(long j5) {
        if (indexOfKey(j5) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(E e5) {
        if (indexOfValue(e5) >= 0) {
            return true;
        }
        return false;
    }

    public void delete(long j5) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j5);
        if (binarySearch >= 0 && this.values[binarySearch] != LongSparseArrayKt.DELETED) {
            this.values[binarySearch] = LongSparseArrayKt.DELETED;
            this.garbage = true;
        }
    }

    public E get(long j5) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j5);
        if (binarySearch < 0 || this.values[binarySearch] == LongSparseArrayKt.DELETED) {
            return null;
        }
        return this.values[binarySearch];
    }

    public int indexOfKey(long j5) {
        if (this.garbage) {
            int i5 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj = objArr[i7];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            this.garbage = false;
            this.size = i6;
        }
        return ContainerHelpersKt.binarySearch(this.keys, this.size, j5);
    }

    public int indexOfValue(E e5) {
        if (this.garbage) {
            int i5 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj = objArr[i7];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            this.garbage = false;
            this.size = i6;
        }
        int i8 = this.size;
        for (int i9 = 0; i9 < i8; i9++) {
            if (this.values[i9] == e5) {
                return i9;
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

    public long keyAt(int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i5).toString());
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            this.garbage = false;
            this.size = i7;
        }
        return this.keys[i5];
    }

    public void put(long j5, E e5) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j5);
        if (binarySearch >= 0) {
            this.values[binarySearch] = e5;
            return;
        }
        int i5 = ~binarySearch;
        if (i5 >= this.size || this.values[i5] != LongSparseArrayKt.DELETED) {
            if (this.garbage) {
                int i6 = this.size;
                long[] jArr = this.keys;
                if (i6 >= jArr.length) {
                    Object[] objArr = this.values;
                    int i7 = 0;
                    for (int i8 = 0; i8 < i6; i8++) {
                        Object obj = objArr[i8];
                        if (obj != LongSparseArrayKt.DELETED) {
                            if (i8 != i7) {
                                jArr[i7] = jArr[i8];
                                objArr[i7] = obj;
                                objArr[i8] = null;
                            }
                            i7++;
                        }
                    }
                    this.garbage = false;
                    this.size = i7;
                    i5 = ~ContainerHelpersKt.binarySearch(this.keys, i7, j5);
                }
            }
            int i9 = this.size;
            if (i9 >= this.keys.length) {
                int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i9 + 1);
                long[] copyOf = Arrays.copyOf(this.keys, idealLongArraySize);
                t.d(copyOf, "copyOf(this, newSize)");
                this.keys = copyOf;
                Object[] copyOf2 = Arrays.copyOf(this.values, idealLongArraySize);
                t.d(copyOf2, "copyOf(this, newSize)");
                this.values = copyOf2;
            }
            int i10 = this.size;
            if (i10 - i5 != 0) {
                long[] jArr2 = this.keys;
                int i11 = i5 + 1;
                C2242i.k(jArr2, jArr2, i11, i5, i10);
                Object[] objArr2 = this.values;
                C2242i.l(objArr2, objArr2, i11, i5, this.size);
            }
            this.keys[i5] = j5;
            this.values[i5] = e5;
            this.size++;
            return;
        }
        this.keys[i5] = j5;
        this.values[i5] = e5;
    }

    public void putAll(LongSparseArray<? extends E> longSparseArray) {
        t.e(longSparseArray, "other");
        int size2 = longSparseArray.size();
        for (int i5 = 0; i5 < size2; i5++) {
            put(longSparseArray.keyAt(i5), longSparseArray.valueAt(i5));
        }
    }

    public E putIfAbsent(long j5, E e5) {
        E e6 = get(j5);
        if (e6 == null) {
            put(j5, e5);
        }
        return e6;
    }

    public void remove(long j5) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j5);
        if (binarySearch >= 0 && this.values[binarySearch] != LongSparseArrayKt.DELETED) {
            this.values[binarySearch] = LongSparseArrayKt.DELETED;
            this.garbage = true;
        }
    }

    public void removeAt(int i5) {
        if (this.values[i5] != LongSparseArrayKt.DELETED) {
            this.values[i5] = LongSparseArrayKt.DELETED;
            this.garbage = true;
        }
    }

    public E replace(long j5, E e5) {
        int indexOfKey = indexOfKey(j5);
        if (indexOfKey < 0) {
            return null;
        }
        E[] eArr = this.values;
        E e6 = eArr[indexOfKey];
        eArr[indexOfKey] = e5;
        return e6;
    }

    public void setValueAt(int i5, E e5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i5).toString());
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            this.garbage = false;
            this.size = i7;
        }
        this.values[i5] = e5;
    }

    public int size() {
        if (this.garbage) {
            int i5 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj = objArr[i7];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            this.garbage = false;
            this.size = i6;
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
            if (valueAt != sb) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public E valueAt(int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i5).toString());
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            this.garbage = false;
            this.size = i7;
        }
        return this.values[i5];
    }

    public LongSparseArray(int i5) {
        if (i5 == 0) {
            this.keys = ContainerHelpersKt.EMPTY_LONGS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
            return;
        }
        int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i5);
        this.keys = new long[idealLongArraySize];
        this.values = new Object[idealLongArraySize];
    }

    public LongSparseArray<E> clone() {
        Object clone = super.clone();
        t.c(clone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        LongSparseArray<E> longSparseArray = (LongSparseArray) clone;
        longSparseArray.keys = (long[]) this.keys.clone();
        longSparseArray.values = (Object[]) this.values.clone();
        return longSparseArray;
    }

    public E get(long j5, E e5) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j5);
        return (binarySearch < 0 || this.values[binarySearch] == LongSparseArrayKt.DELETED) ? e5 : this.values[binarySearch];
    }

    public boolean replace(long j5, E e5, E e6) {
        int indexOfKey = indexOfKey(j5);
        if (indexOfKey < 0 || !t.a(this.values[indexOfKey], e5)) {
            return false;
        }
        this.values[indexOfKey] = e6;
        return true;
    }

    public boolean remove(long j5, E e5) {
        int indexOfKey = indexOfKey(j5);
        if (indexOfKey < 0 || !t.a(e5, valueAt(indexOfKey))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LongSparseArray(int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 10 : i5);
    }
}
