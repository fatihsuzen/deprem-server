package androidx.collection;

import X2.C2242i;
import X2.K;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import java.util.Iterator;
import k3.C2616a;
import k3.p;
import kotlin.jvm.internal.t;

public final class LongSparseArrayKt {
    /* access modifiers changed from: private */
    public static final Object DELETED = new Object();

    public static final <E> void commonAppend(LongSparseArray<E> longSparseArray, long j5, E e5) {
        t.e(longSparseArray, "<this>");
        int i5 = longSparseArray.size;
        if (i5 == 0 || j5 > longSparseArray.keys[i5 - 1]) {
            if (longSparseArray.garbage) {
                long[] jArr = longSparseArray.keys;
                if (i5 >= jArr.length) {
                    Object[] objArr = longSparseArray.values;
                    int i6 = 0;
                    for (int i7 = 0; i7 < i5; i7++) {
                        Object obj = objArr[i7];
                        if (obj != DELETED) {
                            if (i7 != i6) {
                                jArr[i6] = jArr[i7];
                                objArr[i6] = obj;
                                objArr[i7] = null;
                            }
                            i6++;
                        }
                    }
                    longSparseArray.garbage = false;
                    longSparseArray.size = i6;
                }
            }
            int i8 = longSparseArray.size;
            if (i8 >= longSparseArray.keys.length) {
                int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i8 + 1);
                long[] copyOf = Arrays.copyOf(longSparseArray.keys, idealLongArraySize);
                t.d(copyOf, "copyOf(this, newSize)");
                longSparseArray.keys = copyOf;
                Object[] copyOf2 = Arrays.copyOf(longSparseArray.values, idealLongArraySize);
                t.d(copyOf2, "copyOf(this, newSize)");
                longSparseArray.values = copyOf2;
            }
            longSparseArray.keys[i8] = j5;
            longSparseArray.values[i8] = e5;
            longSparseArray.size = i8 + 1;
            return;
        }
        longSparseArray.put(j5, e5);
    }

    public static final <E> void commonClear(LongSparseArray<E> longSparseArray) {
        t.e(longSparseArray, "<this>");
        int i5 = longSparseArray.size;
        Object[] objArr = longSparseArray.values;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        longSparseArray.size = 0;
        longSparseArray.garbage = false;
    }

    public static final <E> boolean commonContainsKey(LongSparseArray<E> longSparseArray, long j5) {
        t.e(longSparseArray, "<this>");
        if (longSparseArray.indexOfKey(j5) >= 0) {
            return true;
        }
        return false;
    }

    public static final <E> boolean commonContainsValue(LongSparseArray<E> longSparseArray, E e5) {
        t.e(longSparseArray, "<this>");
        if (longSparseArray.indexOfValue(e5) >= 0) {
            return true;
        }
        return false;
    }

    public static final <E> void commonGc(LongSparseArray<E> longSparseArray) {
        t.e(longSparseArray, "<this>");
        int i5 = longSparseArray.size;
        long[] jArr = longSparseArray.keys;
        Object[] objArr = longSparseArray.values;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            Object obj = objArr[i7];
            if (obj != DELETED) {
                if (i7 != i6) {
                    jArr[i6] = jArr[i7];
                    objArr[i6] = obj;
                    objArr[i7] = null;
                }
                i6++;
            }
        }
        longSparseArray.garbage = false;
        longSparseArray.size = i6;
    }

    public static final <E> E commonGet(LongSparseArray<E> longSparseArray, long j5) {
        t.e(longSparseArray, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j5);
        if (binarySearch < 0 || longSparseArray.values[binarySearch] == DELETED) {
            return null;
        }
        return longSparseArray.values[binarySearch];
    }

    public static final <T extends E, E> T commonGetInternal(LongSparseArray<E> longSparseArray, long j5, T t5) {
        t.e(longSparseArray, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j5);
        if (binarySearch < 0 || longSparseArray.values[binarySearch] == DELETED) {
            return t5;
        }
        return longSparseArray.values[binarySearch];
    }

    public static final <E> int commonIndexOfKey(LongSparseArray<E> longSparseArray, long j5) {
        t.e(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i5 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj = objArr[i7];
                if (obj != DELETED) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i6;
        }
        return ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j5);
    }

    public static final <E> int commonIndexOfValue(LongSparseArray<E> longSparseArray, E e5) {
        t.e(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i5 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj = objArr[i7];
                if (obj != DELETED) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i6;
        }
        int i8 = longSparseArray.size;
        for (int i9 = 0; i9 < i8; i9++) {
            if (longSparseArray.values[i9] == e5) {
                return i9;
            }
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(LongSparseArray<E> longSparseArray) {
        t.e(longSparseArray, "<this>");
        if (longSparseArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <E> long commonKeyAt(LongSparseArray<E> longSparseArray, int i5) {
        int i6;
        t.e(longSparseArray, "<this>");
        if (i5 < 0 || i5 >= (i6 = longSparseArray.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i5).toString());
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i7;
        }
        return longSparseArray.keys[i5];
    }

    public static final <E> void commonPut(LongSparseArray<E> longSparseArray, long j5, E e5) {
        t.e(longSparseArray, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j5);
        if (binarySearch >= 0) {
            longSparseArray.values[binarySearch] = e5;
            return;
        }
        int i5 = ~binarySearch;
        if (i5 >= longSparseArray.size || longSparseArray.values[i5] != DELETED) {
            if (longSparseArray.garbage) {
                int i6 = longSparseArray.size;
                long[] jArr = longSparseArray.keys;
                if (i6 >= jArr.length) {
                    Object[] objArr = longSparseArray.values;
                    int i7 = 0;
                    for (int i8 = 0; i8 < i6; i8++) {
                        Object obj = objArr[i8];
                        if (obj != DELETED) {
                            if (i8 != i7) {
                                jArr[i7] = jArr[i8];
                                objArr[i7] = obj;
                                objArr[i8] = null;
                            }
                            i7++;
                        }
                    }
                    longSparseArray.garbage = false;
                    longSparseArray.size = i7;
                    i5 = ~ContainerHelpersKt.binarySearch(longSparseArray.keys, i7, j5);
                }
            }
            int i9 = longSparseArray.size;
            if (i9 >= longSparseArray.keys.length) {
                int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i9 + 1);
                long[] copyOf = Arrays.copyOf(longSparseArray.keys, idealLongArraySize);
                t.d(copyOf, "copyOf(this, newSize)");
                longSparseArray.keys = copyOf;
                Object[] copyOf2 = Arrays.copyOf(longSparseArray.values, idealLongArraySize);
                t.d(copyOf2, "copyOf(this, newSize)");
                longSparseArray.values = copyOf2;
            }
            int i10 = longSparseArray.size;
            if (i10 - i5 != 0) {
                long[] jArr2 = longSparseArray.keys;
                int i11 = i5 + 1;
                C2242i.k(jArr2, jArr2, i11, i5, i10);
                Object[] objArr2 = longSparseArray.values;
                C2242i.l(objArr2, objArr2, i11, i5, longSparseArray.size);
            }
            longSparseArray.keys[i5] = j5;
            longSparseArray.values[i5] = e5;
            longSparseArray.size++;
            return;
        }
        longSparseArray.keys[i5] = j5;
        longSparseArray.values[i5] = e5;
    }

    public static final <E> void commonPutAll(LongSparseArray<E> longSparseArray, LongSparseArray<? extends E> longSparseArray2) {
        t.e(longSparseArray, "<this>");
        t.e(longSparseArray2, "other");
        int size = longSparseArray2.size();
        for (int i5 = 0; i5 < size; i5++) {
            longSparseArray.put(longSparseArray2.keyAt(i5), longSparseArray2.valueAt(i5));
        }
    }

    public static final <E> E commonPutIfAbsent(LongSparseArray<E> longSparseArray, long j5, E e5) {
        t.e(longSparseArray, "<this>");
        E e6 = longSparseArray.get(j5);
        if (e6 == null) {
            longSparseArray.put(j5, e5);
        }
        return e6;
    }

    public static final <E> void commonRemove(LongSparseArray<E> longSparseArray, long j5) {
        t.e(longSparseArray, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j5);
        if (binarySearch >= 0 && longSparseArray.values[binarySearch] != DELETED) {
            longSparseArray.values[binarySearch] = DELETED;
            longSparseArray.garbage = true;
        }
    }

    public static final <E> void commonRemoveAt(LongSparseArray<E> longSparseArray, int i5) {
        t.e(longSparseArray, "<this>");
        if (longSparseArray.values[i5] != DELETED) {
            longSparseArray.values[i5] = DELETED;
            longSparseArray.garbage = true;
        }
    }

    public static final <E> E commonReplace(LongSparseArray<E> longSparseArray, long j5, E e5) {
        t.e(longSparseArray, "<this>");
        int indexOfKey = longSparseArray.indexOfKey(j5);
        if (indexOfKey < 0) {
            return null;
        }
        E[] eArr = longSparseArray.values;
        E e6 = eArr[indexOfKey];
        eArr[indexOfKey] = e5;
        return e6;
    }

    public static final <E> void commonSetValueAt(LongSparseArray<E> longSparseArray, int i5, E e5) {
        int i6;
        t.e(longSparseArray, "<this>");
        if (i5 < 0 || i5 >= (i6 = longSparseArray.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i5).toString());
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i7;
        }
        longSparseArray.values[i5] = e5;
    }

    public static final <E> int commonSize(LongSparseArray<E> longSparseArray) {
        t.e(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i5 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj = objArr[i7];
                if (obj != DELETED) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i6;
        }
        return longSparseArray.size;
    }

    public static final <E> String commonToString(LongSparseArray<E> longSparseArray) {
        t.e(longSparseArray, "<this>");
        if (longSparseArray.size() <= 0) {
            return "{}";
        }
        E sb = new StringBuilder(longSparseArray.size * 28);
        sb.append('{');
        int i5 = longSparseArray.size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(longSparseArray.keyAt(i6));
            sb.append('=');
            E valueAt = longSparseArray.valueAt(i6);
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

    public static final <E> E commonValueAt(LongSparseArray<E> longSparseArray, int i5) {
        int i6;
        t.e(longSparseArray, "<this>");
        if (i5 < 0 || i5 >= (i6 = longSparseArray.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i5).toString());
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i7;
        }
        return longSparseArray.values[i5];
    }

    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j5) {
        t.e(longSparseArray, "<this>");
        return longSparseArray.containsKey(j5);
    }

    public static final <T> void forEach(LongSparseArray<T> longSparseArray, p pVar) {
        t.e(longSparseArray, "<this>");
        t.e(pVar, "action");
        int size = longSparseArray.size();
        for (int i5 = 0; i5 < size; i5++) {
            pVar.invoke(Long.valueOf(longSparseArray.keyAt(i5)), longSparseArray.valueAt(i5));
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j5, T t5) {
        t.e(longSparseArray, "<this>");
        return longSparseArray.get(j5, t5);
    }

    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j5, C2616a aVar) {
        t.e(longSparseArray, "<this>");
        t.e(aVar, "defaultValue");
        T t5 = longSparseArray.get(j5);
        if (t5 == null) {
            return aVar.invoke();
        }
        return t5;
    }

    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        t.e(longSparseArray, "<this>");
        return longSparseArray.size();
    }

    public static /* synthetic */ void getSize$annotations(LongSparseArray longSparseArray) {
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        t.e(longSparseArray, "<this>");
        return !longSparseArray.isEmpty();
    }

    public static final <T> K keyIterator(LongSparseArray<T> longSparseArray) {
        t.e(longSparseArray, "<this>");
        return new LongSparseArrayKt$keyIterator$1(longSparseArray);
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        t.e(longSparseArray, "<this>");
        t.e(longSparseArray2, "other");
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
        longSparseArray3.putAll(longSparseArray);
        longSparseArray3.putAll(longSparseArray2);
        return longSparseArray3;
    }

    public static final <T> void set(LongSparseArray<T> longSparseArray, long j5, T t5) {
        t.e(longSparseArray, "<this>");
        longSparseArray.put(j5, t5);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        t.e(longSparseArray, "<this>");
        return new LongSparseArrayKt$valueIterator$1(longSparseArray);
    }

    public static final <E> E commonGet(LongSparseArray<E> longSparseArray, long j5, E e5) {
        t.e(longSparseArray, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j5);
        return (binarySearch < 0 || longSparseArray.values[binarySearch] == DELETED) ? e5 : longSparseArray.values[binarySearch];
    }

    public static final <E> boolean commonReplace(LongSparseArray<E> longSparseArray, long j5, E e5, E e6) {
        t.e(longSparseArray, "<this>");
        int indexOfKey = longSparseArray.indexOfKey(j5);
        if (indexOfKey < 0 || !t.a(longSparseArray.values[indexOfKey], e5)) {
            return false;
        }
        longSparseArray.values[indexOfKey] = e6;
        return true;
    }

    public static final <E> boolean commonRemove(LongSparseArray<E> longSparseArray, long j5, E e5) {
        t.e(longSparseArray, "<this>");
        int indexOfKey = longSparseArray.indexOfKey(j5);
        if (indexOfKey < 0 || !t.a(e5, longSparseArray.valueAt(indexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(indexOfKey);
        return true;
    }
}
