package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2632j;
import kotlin.jvm.internal.S;
import kotlin.jvm.internal.t;
import l3.C2678b;

public final class MutableScatterMap$MutableMapWrapper$entries$1 implements Set<Map.Entry<K, V>>, C2678b {
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    MutableScatterMap$MutableMapWrapper$entries$1(MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
    }

    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        t.e(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.this$0.clear();
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!S.h(obj)) {
            return false;
        }
        return contains((Map.Entry) obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        t.e(collection, "elements");
        Iterable<Map.Entry> iterable = collection;
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Map.Entry entry : iterable) {
            if (!t.a(mutableScatterMap.get(entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return this.this$0._size;
    }

    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new MutableScatterMap$MutableMapWrapper$entries$1$iterator$1(this.this$0);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (!S.h(obj)) {
            return false;
        }
        return remove((Map.Entry) obj);
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        int i5;
        Collection<? extends Object> collection2 = collection;
        t.e(collection2, "elements");
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i6 = 0;
        boolean z4 = false;
        while (true) {
            long j5 = jArr[i6];
            if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                int i7 = 8;
                int i8 = 8 - ((~(i6 - length)) >>> 31);
                int i9 = 0;
                while (i9 < i8) {
                    if ((255 & j5) < 128) {
                        int i10 = (i6 << 3) + i9;
                        Iterator<? extends Object> it = collection2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Map.Entry entry = (Map.Entry) it.next();
                            i5 = i7;
                            if (t.a(entry.getKey(), mutableScatterMap.keys[i10]) && t.a(entry.getValue(), mutableScatterMap.values[i10])) {
                                mutableScatterMap.removeValueAt(i10);
                                z4 = true;
                                break;
                            }
                            i7 = i5;
                        }
                        j5 >>= i5;
                        i9++;
                        i7 = i5;
                    }
                    i5 = i7;
                    j5 >>= i5;
                    i9++;
                    i7 = i5;
                }
                if (i8 != i7) {
                    return z4;
                }
            }
            if (i6 == length) {
                return z4;
            }
            i6++;
        }
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        int i5;
        Collection<? extends Object> collection2 = collection;
        t.e(collection2, "elements");
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i6 = 0;
        boolean z4 = false;
        while (true) {
            long j5 = jArr[i6];
            if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                int i7 = 8;
                int i8 = 8 - ((~(i6 - length)) >>> 31);
                int i9 = 0;
                while (i9 < i8) {
                    if ((255 & j5) < 128) {
                        int i10 = (i6 << 3) + i9;
                        Iterator<? extends Object> it = collection2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i5 = i7;
                                mutableScatterMap.removeValueAt(i10);
                                z4 = true;
                                break;
                            }
                            Map.Entry entry = (Map.Entry) it.next();
                            i5 = i7;
                            if (t.a(entry.getKey(), mutableScatterMap.keys[i10]) && t.a(entry.getValue(), mutableScatterMap.values[i10])) {
                                break;
                            }
                            i7 = i5;
                        }
                    } else {
                        i5 = i7;
                    }
                    j5 >>= i5;
                    i9++;
                    i7 = i5;
                }
                if (i8 != i7) {
                    return z4;
                }
            }
            if (i6 == length) {
                return z4;
            }
            i6++;
        }
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public Object[] toArray() {
        return C2632j.a(this);
    }

    public boolean add(Map.Entry<K, V> entry) {
        t.e(entry, "element");
        throw new UnsupportedOperationException();
    }

    public boolean contains(Map.Entry<K, V> entry) {
        t.e(entry, "element");
        return t.a(this.this$0.get(entry.getKey()), entry.getValue());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0083, code lost:
        if (((r4 & ((~r4) << 6)) & r11) == 0) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0085, code lost:
        r13 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean remove(java.util.Map.Entry<K, V> r22) {
        /*
            r21 = this;
            r0 = r21
            java.lang.String r1 = "element"
            r2 = r22
            kotlin.jvm.internal.t.e(r2, r1)
            androidx.collection.MutableScatterMap<K, V> r1 = r0.this$0
            java.lang.Object r3 = r2.getKey()
            if (r3 == 0) goto L_0x0016
            int r5 = r3.hashCode()
            goto L_0x0017
        L_0x0016:
            r5 = 0
        L_0x0017:
            r6 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r5 = r5 * r6
            int r6 = r5 << 16
            r5 = r5 ^ r6
            r6 = r5 & 127(0x7f, float:1.78E-43)
            int r7 = r1._capacity
            int r5 = r5 >>> 7
            r5 = r5 & r7
            r8 = 0
        L_0x0026:
            long[] r9 = r1.metadata
            int r10 = r5 >> 3
            r11 = r5 & 7
            int r11 = r11 << 3
            r12 = r9[r10]
            long r12 = r12 >>> r11
            r14 = 1
            int r10 = r10 + r14
            r15 = r9[r10]
            int r9 = 64 - r11
            long r9 = r15 << r9
            r16 = r5
            r15 = 0
            long r4 = (long) r11
            long r4 = -r4
            r11 = 63
            long r4 = r4 >> r11
            long r4 = r4 & r9
            long r4 = r4 | r12
            long r9 = (long) r6
            r11 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r11
            long r9 = r9 ^ r4
            long r11 = r9 - r11
            long r9 = ~r9
            long r9 = r9 & r11
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
        L_0x0055:
            r17 = 0
            int r13 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r13 == 0) goto L_0x0079
            int r13 = java.lang.Long.numberOfTrailingZeros(r9)
            int r13 = r13 >> 3
            int r13 = r16 + r13
            r13 = r13 & r7
            r19 = r11
            java.lang.Object[] r11 = r1.keys
            r11 = r11[r13]
            boolean r11 = kotlin.jvm.internal.t.a(r11, r3)
            if (r11 == 0) goto L_0x0071
            goto L_0x0086
        L_0x0071:
            r11 = 1
            long r11 = r9 - r11
            long r9 = r9 & r11
            r11 = r19
            goto L_0x0055
        L_0x0079:
            r19 = r11
            long r9 = ~r4
            r11 = 6
            long r9 = r9 << r11
            long r4 = r4 & r9
            long r4 = r4 & r19
            int r4 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r4 == 0) goto L_0x009f
            r13 = -1
        L_0x0086:
            if (r13 < 0) goto L_0x009e
            androidx.collection.MutableScatterMap<K, V> r1 = r0.this$0
            java.lang.Object[] r1 = r1.values
            r1 = r1[r13]
            java.lang.Object r2 = r2.getValue()
            boolean r1 = kotlin.jvm.internal.t.a(r1, r2)
            if (r1 == 0) goto L_0x009e
            androidx.collection.MutableScatterMap<K, V> r1 = r0.this$0
            r1.removeValueAt(r13)
            return r14
        L_0x009e:
            return r15
        L_0x009f:
            int r8 = r8 + 8
            int r5 = r16 + r8
            r5 = r5 & r7
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1.remove(java.util.Map$Entry):boolean");
    }

    public <T> T[] toArray(T[] tArr) {
        t.e(tArr, "array");
        return C2632j.b(this, tArr);
    }
}
