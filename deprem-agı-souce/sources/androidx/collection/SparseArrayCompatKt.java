package androidx.collection;

import X2.C2242i;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.jvm.internal.t;

public final class SparseArrayCompatKt {
    /* access modifiers changed from: private */
    public static final Object DELETED = new Object();

    public static final <E> void commonAppend(SparseArrayCompat<E> sparseArrayCompat, int i5, E e5) {
        t.e(sparseArrayCompat, "<this>");
        int i6 = sparseArrayCompat.size;
        if (i6 == 0 || i5 > sparseArrayCompat.keys[i6 - 1]) {
            if (sparseArrayCompat.garbage && i6 >= sparseArrayCompat.keys.length) {
                gc(sparseArrayCompat);
            }
            int i7 = sparseArrayCompat.size;
            if (i7 >= sparseArrayCompat.keys.length) {
                int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i7 + 1);
                int[] copyOf = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
                t.d(copyOf, "copyOf(this, newSize)");
                sparseArrayCompat.keys = copyOf;
                Object[] copyOf2 = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
                t.d(copyOf2, "copyOf(this, newSize)");
                sparseArrayCompat.values = copyOf2;
            }
            sparseArrayCompat.keys[i7] = i5;
            sparseArrayCompat.values[i7] = e5;
            sparseArrayCompat.size = i7 + 1;
            return;
        }
        sparseArrayCompat.put(i5, e5);
    }

    public static final <E> void commonClear(SparseArrayCompat<E> sparseArrayCompat) {
        t.e(sparseArrayCompat, "<this>");
        int i5 = sparseArrayCompat.size;
        Object[] objArr = sparseArrayCompat.values;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        sparseArrayCompat.size = 0;
        sparseArrayCompat.garbage = false;
    }

    public static final <E> boolean commonContainsKey(SparseArrayCompat<E> sparseArrayCompat, int i5) {
        t.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.indexOfKey(i5) >= 0) {
            return true;
        }
        return false;
    }

    public static final <E> boolean commonContainsValue(SparseArrayCompat<E> sparseArrayCompat, E e5) {
        t.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        int i5 = sparseArrayCompat.size;
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                i6 = -1;
                break;
            } else if (sparseArrayCompat.values[i6] == e5) {
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

    public static final <E> E commonGet(SparseArrayCompat<E> sparseArrayCompat, int i5) {
        E e5;
        t.e(sparseArrayCompat, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i5);
        if (binarySearch < 0 || (e5 = sparseArrayCompat.values[binarySearch]) == DELETED) {
            return null;
        }
        return e5;
    }

    public static final <E> int commonIndexOfKey(SparseArrayCompat<E> sparseArrayCompat, int i5) {
        t.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i5);
    }

    public static final <E> int commonIndexOfValue(SparseArrayCompat<E> sparseArrayCompat, E e5) {
        t.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        int i5 = sparseArrayCompat.size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (sparseArrayCompat.values[i6] == e5) {
                return i6;
            }
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(SparseArrayCompat<E> sparseArrayCompat) {
        t.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <E> int commonKeyAt(SparseArrayCompat<E> sparseArrayCompat, int i5) {
        t.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.keys[i5];
    }

    public static final <E> void commonPut(SparseArrayCompat<E> sparseArrayCompat, int i5, E e5) {
        t.e(sparseArrayCompat, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i5);
        if (binarySearch >= 0) {
            sparseArrayCompat.values[binarySearch] = e5;
            return;
        }
        int i6 = ~binarySearch;
        if (i6 >= sparseArrayCompat.size || sparseArrayCompat.values[i6] != DELETED) {
            if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                gc(sparseArrayCompat);
                i6 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i5);
            }
            int i7 = sparseArrayCompat.size;
            if (i7 >= sparseArrayCompat.keys.length) {
                int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i7 + 1);
                int[] copyOf = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
                t.d(copyOf, "copyOf(this, newSize)");
                sparseArrayCompat.keys = copyOf;
                Object[] copyOf2 = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
                t.d(copyOf2, "copyOf(this, newSize)");
                sparseArrayCompat.values = copyOf2;
            }
            int i8 = sparseArrayCompat.size;
            if (i8 - i6 != 0) {
                int[] iArr = sparseArrayCompat.keys;
                int i9 = i6 + 1;
                C2242i.j(iArr, iArr, i9, i6, i8);
                Object[] objArr = sparseArrayCompat.values;
                C2242i.l(objArr, objArr, i9, i6, sparseArrayCompat.size);
            }
            sparseArrayCompat.keys[i6] = i5;
            sparseArrayCompat.values[i6] = e5;
            sparseArrayCompat.size++;
            return;
        }
        sparseArrayCompat.keys[i6] = i5;
        sparseArrayCompat.values[i6] = e5;
    }

    public static final <E> void commonPutAll(SparseArrayCompat<E> sparseArrayCompat, SparseArrayCompat<? extends E> sparseArrayCompat2) {
        t.e(sparseArrayCompat, "<this>");
        t.e(sparseArrayCompat2, "other");
        int size = sparseArrayCompat2.size();
        for (int i5 = 0; i5 < size; i5++) {
            int keyAt = sparseArrayCompat2.keyAt(i5);
            Object valueAt = sparseArrayCompat2.valueAt(i5);
            int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, keyAt);
            if (binarySearch >= 0) {
                sparseArrayCompat.values[binarySearch] = valueAt;
            } else {
                int i6 = ~binarySearch;
                if (i6 >= sparseArrayCompat.size || sparseArrayCompat.values[i6] != DELETED) {
                    if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                        gc(sparseArrayCompat);
                        i6 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, keyAt);
                    }
                    int i7 = sparseArrayCompat.size;
                    if (i7 >= sparseArrayCompat.keys.length) {
                        int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i7 + 1);
                        int[] copyOf = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
                        t.d(copyOf, "copyOf(this, newSize)");
                        sparseArrayCompat.keys = copyOf;
                        Object[] copyOf2 = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
                        t.d(copyOf2, "copyOf(this, newSize)");
                        sparseArrayCompat.values = copyOf2;
                    }
                    int i8 = sparseArrayCompat.size;
                    if (i8 - i6 != 0) {
                        int[] iArr = sparseArrayCompat.keys;
                        int i9 = i6 + 1;
                        C2242i.j(iArr, iArr, i9, i6, i8);
                        Object[] objArr = sparseArrayCompat.values;
                        C2242i.l(objArr, objArr, i9, i6, sparseArrayCompat.size);
                    }
                    sparseArrayCompat.keys[i6] = keyAt;
                    sparseArrayCompat.values[i6] = valueAt;
                    sparseArrayCompat.size++;
                } else {
                    sparseArrayCompat.keys[i6] = keyAt;
                    sparseArrayCompat.values[i6] = valueAt;
                }
            }
        }
    }

    public static final <E> E commonPutIfAbsent(SparseArrayCompat<E> sparseArrayCompat, int i5, E e5) {
        t.e(sparseArrayCompat, "<this>");
        E commonGet = commonGet(sparseArrayCompat, i5);
        if (commonGet == null) {
            int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i5);
            if (binarySearch >= 0) {
                sparseArrayCompat.values[binarySearch] = e5;
                return commonGet;
            }
            int i6 = ~binarySearch;
            if (i6 >= sparseArrayCompat.size || sparseArrayCompat.values[i6] != DELETED) {
                if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                    gc(sparseArrayCompat);
                    i6 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i5);
                }
                int i7 = sparseArrayCompat.size;
                if (i7 >= sparseArrayCompat.keys.length) {
                    int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i7 + 1);
                    int[] copyOf = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
                    t.d(copyOf, "copyOf(this, newSize)");
                    sparseArrayCompat.keys = copyOf;
                    Object[] copyOf2 = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
                    t.d(copyOf2, "copyOf(this, newSize)");
                    sparseArrayCompat.values = copyOf2;
                }
                int i8 = sparseArrayCompat.size;
                if (i8 - i6 != 0) {
                    int[] iArr = sparseArrayCompat.keys;
                    int i9 = i6 + 1;
                    C2242i.j(iArr, iArr, i9, i6, i8);
                    Object[] objArr = sparseArrayCompat.values;
                    C2242i.l(objArr, objArr, i9, i6, sparseArrayCompat.size);
                }
                sparseArrayCompat.keys[i6] = i5;
                sparseArrayCompat.values[i6] = e5;
                sparseArrayCompat.size++;
            } else {
                sparseArrayCompat.keys[i6] = i5;
                sparseArrayCompat.values[i6] = e5;
                return commonGet;
            }
        }
        return commonGet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r0 = r3.values;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> void commonRemove(androidx.collection.SparseArrayCompat<E> r3, int r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.t.e(r3, r0)
            int[] r0 = r3.keys
            int r1 = r3.size
            int r4 = androidx.collection.internal.ContainerHelpersKt.binarySearch((int[]) r0, (int) r1, (int) r4)
            if (r4 < 0) goto L_0x001c
            java.lang.Object[] r0 = r3.values
            r1 = r0[r4]
            java.lang.Object r2 = DELETED
            if (r1 == r2) goto L_0x001c
            r0[r4] = r2
            r4 = 1
            r3.garbage = r4
        L_0x001c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SparseArrayCompatKt.commonRemove(androidx.collection.SparseArrayCompat, int):void");
    }

    public static final <E> void commonRemoveAt(SparseArrayCompat<E> sparseArrayCompat, int i5) {
        t.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.values[i5] != DELETED) {
            sparseArrayCompat.values[i5] = DELETED;
            sparseArrayCompat.garbage = true;
        }
    }

    public static final <E> void commonRemoveAtRange(SparseArrayCompat<E> sparseArrayCompat, int i5, int i6) {
        t.e(sparseArrayCompat, "<this>");
        int min = Math.min(i6, i5 + i6);
        while (i5 < min) {
            sparseArrayCompat.removeAt(i5);
            i5++;
        }
    }

    public static final <E> E commonReplace(SparseArrayCompat<E> sparseArrayCompat, int i5, E e5) {
        t.e(sparseArrayCompat, "<this>");
        int indexOfKey = sparseArrayCompat.indexOfKey(i5);
        if (indexOfKey < 0) {
            return null;
        }
        E[] eArr = sparseArrayCompat.values;
        E e6 = eArr[indexOfKey];
        eArr[indexOfKey] = e5;
        return e6;
    }

    public static final <E> void commonSetValueAt(SparseArrayCompat<E> sparseArrayCompat, int i5, E e5) {
        t.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        sparseArrayCompat.values[i5] = e5;
    }

    public static final <E> int commonSize(SparseArrayCompat<E> sparseArrayCompat) {
        t.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.size;
    }

    public static final <E> String commonToString(SparseArrayCompat<E> sparseArrayCompat) {
        t.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(sparseArrayCompat.size * 28);
        sb.append('{');
        int i5 = sparseArrayCompat.size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(sparseArrayCompat.keyAt(i6));
            sb.append('=');
            E valueAt = sparseArrayCompat.valueAt(i6);
            if (valueAt != sparseArrayCompat) {
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

    public static final <E> E commonValueAt(SparseArrayCompat<E> sparseArrayCompat, int i5) {
        t.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.values[i5];
    }

    /* access modifiers changed from: private */
    public static final <E> void gc(SparseArrayCompat<E> sparseArrayCompat) {
        int i5 = sparseArrayCompat.size;
        int[] iArr = sparseArrayCompat.keys;
        Object[] objArr = sparseArrayCompat.values;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            Object obj = objArr[i7];
            if (obj != DELETED) {
                if (i7 != i6) {
                    iArr[i6] = iArr[i7];
                    objArr[i6] = obj;
                    objArr[i7] = null;
                }
                i6++;
            }
        }
        sparseArrayCompat.garbage = false;
        sparseArrayCompat.size = i6;
    }

    private static final <E, T extends E> T internalGet(SparseArrayCompat<E> sparseArrayCompat, int i5, T t5) {
        T t6;
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i5);
        if (binarySearch < 0 || (t6 = sparseArrayCompat.values[binarySearch]) == DELETED) {
            return t5;
        }
        return t6;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r2 = r2.values[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> E commonGet(androidx.collection.SparseArrayCompat<E> r2, int r3, E r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.t.e(r2, r0)
            int[] r0 = r2.keys
            int r1 = r2.size
            int r3 = androidx.collection.internal.ContainerHelpersKt.binarySearch((int[]) r0, (int) r1, (int) r3)
            if (r3 < 0) goto L_0x0019
            java.lang.Object[] r2 = r2.values
            r2 = r2[r3]
            java.lang.Object r3 = DELETED
            if (r2 != r3) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            return r2
        L_0x0019:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SparseArrayCompatKt.commonGet(androidx.collection.SparseArrayCompat, int, java.lang.Object):java.lang.Object");
    }

    public static final <E> boolean commonReplace(SparseArrayCompat<E> sparseArrayCompat, int i5, E e5, E e6) {
        t.e(sparseArrayCompat, "<this>");
        int indexOfKey = sparseArrayCompat.indexOfKey(i5);
        if (indexOfKey < 0 || !t.a(sparseArrayCompat.values[indexOfKey], e5)) {
            return false;
        }
        sparseArrayCompat.values[indexOfKey] = e6;
        return true;
    }

    public static final <E> boolean commonRemove(SparseArrayCompat<E> sparseArrayCompat, int i5, Object obj) {
        t.e(sparseArrayCompat, "<this>");
        int indexOfKey = sparseArrayCompat.indexOfKey(i5);
        if (indexOfKey < 0 || !t.a(obj, sparseArrayCompat.valueAt(indexOfKey))) {
            return false;
        }
        sparseArrayCompat.removeAt(indexOfKey);
        return true;
    }
}
