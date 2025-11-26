package androidx.collection;

import X2.C2250q;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.C2632j;
import kotlin.jvm.internal.t;
import l3.C2678b;

public final class MutableScatterMap$MutableMapWrapper$keys$1 implements Set<K>, C2678b {
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    MutableScatterMap$MutableMapWrapper$keys$1(MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
    }

    public boolean add(K k5) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends K> collection) {
        t.e(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.this$0.clear();
    }

    public boolean contains(Object obj) {
        return this.this$0.containsKey(obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        t.e(collection, "elements");
        Iterable<Object> iterable = collection;
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object containsKey : iterable) {
            if (!mutableScatterMap.containsKey(containsKey)) {
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

    public Iterator<K> iterator() {
        return new MutableScatterMap$MutableMapWrapper$keys$1$iterator$1(this.this$0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006b, code lost:
        r18 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0074, code lost:
        if (((r8 & ((~r8) << 6)) & -9187201950435737472L) == 0) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0076, code lost:
        r12 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean remove(java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            androidx.collection.MutableScatterMap<K, V> r2 = r0.this$0
            if (r1 == 0) goto L_0x000d
            int r4 = r1.hashCode()
            goto L_0x000e
        L_0x000d:
            r4 = 0
        L_0x000e:
            r5 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r4 = r4 * r5
            int r5 = r4 << 16
            r4 = r4 ^ r5
            r5 = r4 & 127(0x7f, float:1.78E-43)
            int r6 = r2._capacity
            int r4 = r4 >>> 7
            r4 = r4 & r6
            r7 = 0
        L_0x001d:
            long[] r8 = r2.metadata
            int r9 = r4 >> 3
            r10 = r4 & 7
            int r10 = r10 << 3
            r11 = r8[r9]
            long r11 = r11 >>> r10
            r13 = 1
            int r9 = r9 + r13
            r14 = r8[r9]
            int r8 = 64 - r10
            long r8 = r14 << r8
            long r14 = (long) r10
            long r14 = -r14
            r10 = 63
            long r14 = r14 >> r10
            long r8 = r8 & r14
            long r8 = r8 | r11
            long r10 = (long) r5
            r14 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r10 = r10 * r14
            long r10 = r10 ^ r8
            long r14 = r10 - r14
            long r10 = ~r10
            long r10 = r10 & r14
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r14
        L_0x0049:
            r16 = 0
            int r12 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r12 == 0) goto L_0x006b
            int r12 = java.lang.Long.numberOfTrailingZeros(r10)
            int r12 = r12 >> 3
            int r12 = r12 + r4
            r12 = r12 & r6
            r18 = 0
            java.lang.Object[] r3 = r2.keys
            r3 = r3[r12]
            boolean r3 = kotlin.jvm.internal.t.a(r3, r1)
            if (r3 == 0) goto L_0x0064
            goto L_0x0077
        L_0x0064:
            r16 = 1
            long r16 = r10 - r16
            long r10 = r10 & r16
            goto L_0x0049
        L_0x006b:
            r18 = 0
            long r10 = ~r8
            r3 = 6
            long r10 = r10 << r3
            long r8 = r8 & r10
            long r8 = r8 & r14
            int r3 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r3 == 0) goto L_0x0080
            r12 = -1
        L_0x0077:
            if (r12 < 0) goto L_0x007f
            androidx.collection.MutableScatterMap<K, V> r1 = r0.this$0
            r1.removeValueAt(r12)
            return r13
        L_0x007f:
            return r18
        L_0x0080:
            int r7 = r7 + 8
            int r4 = r4 + r7
            r4 = r4 & r6
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterMap$MutableMapWrapper$keys$1.remove(java.lang.Object):boolean");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        Collection<? extends Object> collection2 = collection;
        t.e(collection2, "elements");
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i5 = 0;
        boolean z4 = false;
        while (true) {
            long j5 = jArr[i5];
            if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j5) < 128) {
                        int i8 = (i5 << 3) + i7;
                        if (C2250q.E(collection2, mutableScatterMap.keys[i8])) {
                            mutableScatterMap.removeValueAt(i8);
                            z4 = true;
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return z4;
                }
            }
            if (i5 == length) {
                return z4;
            }
            i5++;
        }
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        Collection<? extends Object> collection2 = collection;
        t.e(collection2, "elements");
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i5 = 0;
        boolean z4 = false;
        while (true) {
            long j5 = jArr[i5];
            if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j5) < 128) {
                        int i8 = (i5 << 3) + i7;
                        if (!C2250q.E(collection2, mutableScatterMap.keys[i8])) {
                            mutableScatterMap.removeValueAt(i8);
                            z4 = true;
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return z4;
                }
            }
            if (i5 == length) {
                return z4;
            }
            i5++;
        }
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public Object[] toArray() {
        return C2632j.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        t.e(tArr, "array");
        return C2632j.b(this, tArr);
    }
}
