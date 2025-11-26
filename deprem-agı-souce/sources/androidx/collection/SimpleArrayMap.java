package androidx.collection;

import X2.C2242i;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public class SimpleArrayMap<K, V> {
    private Object[] array;
    private int[] hashes;
    private int size;

    public SimpleArrayMap() {
        this(0, 1, (C2633k) null);
    }

    private final <T extends V> T getOrDefaultInternal(Object obj, T t5) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return this.array[(indexOfKey << 1) + 1];
        }
        return t5;
    }

    private final int indexOf(K k5, int i5) {
        int i6 = this.size;
        if (i6 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpersKt.binarySearch(this.hashes, i6, i5);
        if (binarySearch < 0 || t.a(k5, this.array[binarySearch << 1])) {
            return binarySearch;
        }
        int i7 = binarySearch + 1;
        while (i7 < i6 && this.hashes[i7] == i5) {
            if (t.a(k5, this.array[i7 << 1])) {
                return i7;
            }
            i7++;
        }
        int i8 = binarySearch - 1;
        while (i8 >= 0 && this.hashes[i8] == i5) {
            if (t.a(k5, this.array[i8 << 1])) {
                return i8;
            }
            i8--;
        }
        return ~i7;
    }

    private final int indexOfNull() {
        int i5 = this.size;
        if (i5 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpersKt.binarySearch(this.hashes, i5, 0);
        if (binarySearch < 0 || this.array[binarySearch << 1] == null) {
            return binarySearch;
        }
        int i6 = binarySearch + 1;
        while (i6 < i5 && this.hashes[i6] == 0) {
            if (this.array[i6 << 1] == null) {
                return i6;
            }
            i6++;
        }
        int i7 = binarySearch - 1;
        while (i7 >= 0 && this.hashes[i7] == 0) {
            if (this.array[i7 << 1] == null) {
                return i7;
            }
            i7--;
        }
        return ~i6;
    }

    public final int __restricted$indexOfValue(V v5) {
        int i5 = this.size * 2;
        Object[] objArr = this.array;
        if (v5 == null) {
            for (int i6 = 1; i6 < i5; i6 += 2) {
                if (objArr[i6] == null) {
                    return i6 >> 1;
                }
            }
            return -1;
        }
        for (int i7 = 1; i7 < i5; i7 += 2) {
            if (t.a(v5, objArr[i7])) {
                return i7 >> 1;
            }
        }
        return -1;
    }

    public void clear() {
        if (this.size > 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.array = ContainerHelpersKt.EMPTY_OBJECTS;
            this.size = 0;
        }
        if (this.size > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(K k5) {
        if (indexOfKey(k5) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(V v5) {
        if (__restricted$indexOfValue(v5) >= 0) {
            return true;
        }
        return false;
    }

    public void ensureCapacity(int i5) {
        int i6 = this.size;
        int[] iArr = this.hashes;
        if (iArr.length < i5) {
            int[] copyOf = Arrays.copyOf(iArr, i5);
            t.d(copyOf, "copyOf(this, newSize)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.array, i5 * 2);
            t.d(copyOf2, "copyOf(this, newSize)");
            this.array = copyOf2;
        }
        if (this.size != i6) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                if (size() != ((SimpleArrayMap) obj).size()) {
                    return false;
                }
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                int i5 = this.size;
                for (int i6 = 0; i6 < i5; i6++) {
                    Object keyAt = keyAt(i6);
                    Object valueAt = valueAt(i6);
                    Object obj2 = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!t.a(valueAt, obj2)) {
                        return false;
                    }
                }
                return true;
            } else if (!(obj instanceof Map) || size() != ((Map) obj).size()) {
                return false;
            } else {
                int i7 = this.size;
                for (int i8 = 0; i8 < i7; i8++) {
                    Object keyAt2 = keyAt(i8);
                    Object valueAt2 = valueAt(i8);
                    Object obj3 = ((Map) obj).get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj3 != null || !((Map) obj).containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!t.a(valueAt2, obj3)) {
                        return false;
                    }
                }
                return true;
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public V get(K k5) {
        int indexOfKey = indexOfKey(k5);
        if (indexOfKey >= 0) {
            return this.array[(indexOfKey << 1) + 1];
        }
        return null;
    }

    public V getOrDefault(Object obj, V v5) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return this.array[(indexOfKey << 1) + 1];
        }
        return v5;
    }

    public int hashCode() {
        int i5;
        int[] iArr = this.hashes;
        Object[] objArr = this.array;
        int i6 = this.size;
        int i7 = 1;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            Object obj = objArr[i7];
            int i10 = iArr[i8];
            if (obj != null) {
                i5 = obj.hashCode();
            } else {
                i5 = 0;
            }
            i9 += i5 ^ i10;
            i8++;
            i7 += 2;
        }
        return i9;
    }

    public int indexOfKey(K k5) {
        if (k5 == null) {
            return indexOfNull();
        }
        return indexOf(k5, k5.hashCode());
    }

    public boolean isEmpty() {
        if (this.size <= 0) {
            return true;
        }
        return false;
    }

    public K keyAt(int i5) {
        if (i5 >= 0 && i5 < this.size) {
            return this.array[i5 << 1];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i5).toString());
    }

    public V put(K k5, V v5) {
        int i5;
        int i6;
        int i7 = this.size;
        if (k5 != null) {
            i5 = k5.hashCode();
        } else {
            i5 = 0;
        }
        if (k5 != null) {
            i6 = indexOf(k5, i5);
        } else {
            i6 = indexOfNull();
        }
        if (i6 >= 0) {
            int i8 = (i6 << 1) + 1;
            V[] vArr = this.array;
            V v6 = vArr[i8];
            vArr[i8] = v5;
            return v6;
        }
        int i9 = ~i6;
        int[] iArr = this.hashes;
        if (i7 >= iArr.length) {
            int i10 = 8;
            if (i7 >= 8) {
                i10 = (i7 >> 1) + i7;
            } else if (i7 < 4) {
                i10 = 4;
            }
            int[] copyOf = Arrays.copyOf(iArr, i10);
            t.d(copyOf, "copyOf(this, newSize)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.array, i10 << 1);
            t.d(copyOf2, "copyOf(this, newSize)");
            this.array = copyOf2;
            if (i7 != this.size) {
                throw new ConcurrentModificationException();
            }
        }
        if (i9 < i7) {
            int[] iArr2 = this.hashes;
            int i11 = i9 + 1;
            C2242i.j(iArr2, iArr2, i11, i9, i7);
            Object[] objArr = this.array;
            C2242i.l(objArr, objArr, i11 << 1, i9 << 1, this.size << 1);
        }
        int i12 = this.size;
        if (i7 == i12) {
            int[] iArr3 = this.hashes;
            if (i9 < iArr3.length) {
                iArr3[i9] = i5;
                Object[] objArr2 = this.array;
                int i13 = i9 << 1;
                objArr2[i13] = k5;
                objArr2[i13 + 1] = v5;
                this.size = i12 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        t.e(simpleArrayMap, "map");
        int i5 = simpleArrayMap.size;
        ensureCapacity(this.size + i5);
        if (this.size != 0) {
            for (int i6 = 0; i6 < i5; i6++) {
                put(simpleArrayMap.keyAt(i6), simpleArrayMap.valueAt(i6));
            }
        } else if (i5 > 0) {
            C2242i.j(simpleArrayMap.hashes, this.hashes, 0, 0, i5);
            C2242i.l(simpleArrayMap.array, this.array, 0, 0, i5 << 1);
            this.size = i5;
        }
    }

    public V putIfAbsent(K k5, V v5) {
        V v6 = get(k5);
        if (v6 == null) {
            return put(k5, v5);
        }
        return v6;
    }

    public V remove(K k5) {
        int indexOfKey = indexOfKey(k5);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i5).toString());
        }
        V[] vArr = this.array;
        int i7 = i5 << 1;
        V v5 = vArr[i7 + 1];
        if (i6 <= 1) {
            clear();
            return v5;
        }
        int i8 = i6 - 1;
        int[] iArr = this.hashes;
        int i9 = 8;
        if (iArr.length <= 8 || i6 >= iArr.length / 3) {
            if (i5 < i8) {
                int i10 = i5 + 1;
                C2242i.j(iArr, iArr, i5, i10, i6);
                Object[] objArr = this.array;
                C2242i.l(objArr, objArr, i7, i10 << 1, i6 << 1);
            }
            Object[] objArr2 = this.array;
            int i11 = i8 << 1;
            objArr2[i11] = null;
            objArr2[i11 + 1] = null;
        } else {
            if (i6 > 8) {
                i9 = i6 + (i6 >> 1);
            }
            int[] copyOf = Arrays.copyOf(iArr, i9);
            t.d(copyOf, "copyOf(this, newSize)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.array, i9 << 1);
            t.d(copyOf2, "copyOf(this, newSize)");
            this.array = copyOf2;
            if (i6 == this.size) {
                if (i5 > 0) {
                    C2242i.j(iArr, this.hashes, 0, 0, i5);
                    C2242i.l(vArr, this.array, 0, 0, i7);
                }
                if (i5 < i8) {
                    int i12 = i5 + 1;
                    C2242i.j(iArr, this.hashes, i5, i12, i6);
                    C2242i.l(vArr, this.array, i7, i12 << 1, i6 << 1);
                }
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i6 == this.size) {
            this.size = i8;
            return v5;
        }
        throw new ConcurrentModificationException();
    }

    public V replace(K k5, V v5) {
        int indexOfKey = indexOfKey(k5);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, v5);
        }
        return null;
    }

    public V setValueAt(int i5, V v5) {
        if (i5 < 0 || i5 >= this.size) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i5).toString());
        }
        int i6 = (i5 << 1) + 1;
        V[] vArr = this.array;
        V v6 = vArr[i6];
        vArr[i6] = v5;
        return v6;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i5 = this.size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            Object keyAt = keyAt(i6);
            if (keyAt != sb) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
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

    public V valueAt(int i5) {
        if (i5 >= 0 && i5 < this.size) {
            return this.array[(i5 << 1) + 1];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i5).toString());
    }

    public SimpleArrayMap(int i5) {
        int[] iArr;
        Object[] objArr;
        if (i5 == 0) {
            iArr = ContainerHelpersKt.EMPTY_INTS;
        } else {
            iArr = new int[i5];
        }
        this.hashes = iArr;
        if (i5 == 0) {
            objArr = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            objArr = new Object[(i5 << 1)];
        }
        this.array = objArr;
    }

    public boolean remove(K k5, V v5) {
        int indexOfKey = indexOfKey(k5);
        if (indexOfKey < 0 || !t.a(v5, valueAt(indexOfKey))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public boolean replace(K k5, V v5, V v6) {
        int indexOfKey = indexOfKey(k5);
        if (indexOfKey < 0 || !t.a(v5, valueAt(indexOfKey))) {
            return false;
        }
        setValueAt(indexOfKey, v6);
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleArrayMap(int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 0 : i5);
    }

    public SimpleArrayMap(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this(0, 1, (C2633k) null);
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }
}
