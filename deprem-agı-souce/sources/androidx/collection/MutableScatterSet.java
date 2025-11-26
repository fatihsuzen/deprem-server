package androidx.collection;

import W2.D;
import X2.C2242i;
import androidx.annotation.IntRange;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l3.C2678b;
import s3.C2751e;

public final class MutableScatterSet<E> extends ScatterSet<E> {
    private int growthLimit;

    private final class MutableSetWrapper extends ScatterSet<E>.SetWrapper implements Set<E>, C2678b {
        public MutableSetWrapper() {
            super();
        }

        public boolean add(E e5) {
            return MutableScatterSet.this.add(e5);
        }

        public boolean addAll(Collection<? extends E> collection) {
            t.e(collection, "elements");
            return MutableScatterSet.this.addAll(collection);
        }

        public void clear() {
            MutableScatterSet.this.clear();
        }

        public Iterator<E> iterator() {
            return new MutableScatterSet$MutableSetWrapper$iterator$1(MutableScatterSet.this);
        }

        public boolean remove(Object obj) {
            return MutableScatterSet.this.remove(obj);
        }

        public boolean removeAll(Collection<? extends Object> collection) {
            t.e(collection, "elements");
            int size = MutableScatterSet.this.getSize();
            for (Object minusAssign : collection) {
                MutableScatterSet.this.minusAssign(minusAssign);
            }
            if (size != MutableScatterSet.this.getSize()) {
                return true;
            }
            return false;
        }

        public boolean retainAll(Collection<? extends Object> collection) {
            Collection<? extends Object> collection2 = collection;
            t.e(collection2, "elements");
            MutableScatterSet<E> mutableScatterSet = MutableScatterSet.this;
            long[] jArr = mutableScatterSet.metadata;
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
                            if (!collection2.contains(mutableScatterSet.elements[i8])) {
                                mutableScatterSet.removeElementAt(i8);
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
    }

    public MutableScatterSet() {
        this(0, 1, (C2633k) null);
    }

    private final void adjustStorage() {
        if (this._capacity <= 8 || Long.compare(D.b(D.b((long) this._size) * 32) ^ Long.MIN_VALUE, D.b(D.b((long) this._capacity) * 25) ^ Long.MIN_VALUE) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            removeDeletedMarkers();
        }
    }

    private final int findAbsoluteInsertIndex(E e5) {
        int i5;
        int i6;
        E e6 = e5;
        if (e6 != null) {
            i5 = e6.hashCode();
        } else {
            i5 = 0;
        }
        int i7 = i5 * ScatterMapKt.MurmurHashC1;
        int i8 = i7 ^ (i7 << 16);
        int i9 = i8 >>> 7;
        int i10 = i8 & 127;
        int i11 = this._capacity;
        int i12 = i9 & i11;
        int i13 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i14 = i12 >> 3;
            int i15 = (i12 & 7) << 3;
            long j5 = ((jArr[i14 + 1] << (64 - i15)) & ((-((long) i15)) >> 63)) | (jArr[i14] >>> i15);
            long j6 = (long) i10;
            int i16 = i10;
            long j7 = j5 ^ (j6 * ScatterMapKt.BitmaskLsb);
            for (long j8 = (~j7) & (j7 - ScatterMapKt.BitmaskLsb) & -9187201950435737472L; j8 != 0; j8 &= j8 - 1) {
                int numberOfTrailingZeros = (i12 + (Long.numberOfTrailingZeros(j8) >> 3)) & i11;
                if (t.a(this.elements[numberOfTrailingZeros], e6)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j5) << 6) & j5 & -9187201950435737472L) != 0) {
                int findFirstAvailableSlot = findFirstAvailableSlot(i9);
                if (this.growthLimit == 0 && ((this.metadata[findFirstAvailableSlot >> 3] >> ((findFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    findFirstAvailableSlot = findFirstAvailableSlot(i9);
                }
                this._size++;
                int i17 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i18 = findFirstAvailableSlot >> 3;
                long j9 = jArr2[i18];
                int i19 = (findFirstAvailableSlot & 7) << 3;
                if (((j9 >> i19) & 255) == 128) {
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                this.growthLimit = i17 - i6;
                jArr2[i18] = (j9 & (~(255 << i19))) | (j6 << i19);
                int i20 = this._capacity;
                int i21 = ((findFirstAvailableSlot - 7) & i20) + (i20 & 7);
                int i22 = i21 >> 3;
                int i23 = (i21 & 7) << 3;
                jArr2[i22] = ((~(255 << i23)) & jArr2[i22]) | (j6 << i23);
                return findFirstAvailableSlot;
            }
            i13 += 8;
            i12 = (i12 + i13) & i11;
            i10 = i16;
        }
    }

    private final int findFirstAvailableSlot(int i5) {
        int i6 = this._capacity;
        int i7 = i5 & i6;
        int i8 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j5 = ((jArr[i9 + 1] << (64 - i10)) & ((-((long) i10)) >> 63)) | (jArr[i9] >>> i10);
            long j6 = j5 & ((~j5) << 7) & -9187201950435737472L;
            if (j6 != 0) {
                return (i7 + (Long.numberOfTrailingZeros(j6) >> 3)) & i6;
            }
            i8 += 8;
            i7 = (i7 + i8) & i6;
        }
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(getCapacity()) - this._size;
    }

    private final void initializeMetadata(int i5) {
        long[] jArr;
        if (i5 == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            long[] jArr2 = new long[(((i5 + 15) & -8) >> 3)];
            C2242i.y(jArr2, -9187201950435737472L, 0, 0, 6, (Object) null);
            jArr = jArr2;
        }
        this.metadata = jArr;
        int i6 = i5 >> 3;
        long j5 = 255 << ((i5 & 7) << 3);
        jArr[i6] = (jArr[i6] & (~j5)) | j5;
        initializeGrowth();
    }

    private final void initializeStorage(int i5) {
        int i6;
        if (i5 > 0) {
            i6 = Math.max(7, ScatterMapKt.normalizeCapacity(i5));
        } else {
            i6 = 0;
        }
        this._capacity = i6;
        initializeMetadata(i6);
        this.elements = new Object[i6];
    }

    private final void removeDeletedMarkers() {
        long[] jArr = this.metadata;
        int i5 = this._capacity;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = i7 >> 3;
            int i9 = (i7 & 7) << 3;
            if (((jArr[i8] >> i9) & 255) == 254) {
                long[] jArr2 = this.metadata;
                jArr2[i8] = (128 << i9) | (jArr2[i8] & (~(255 << i9)));
                int i10 = this._capacity;
                int i11 = ((i7 - 7) & i10) + (i10 & 7);
                int i12 = i11 >> 3;
                int i13 = (i11 & 7) << 3;
                jArr2[i12] = ((~(255 << i13)) & jArr2[i12]) | (128 << i13);
                i6++;
            }
        }
        this.growthLimit += i6;
    }

    private final void resizeStorage(int i5) {
        int i6;
        int i7;
        long[] jArr = this.metadata;
        Object[] objArr = this.elements;
        int i8 = this._capacity;
        initializeStorage(i5);
        Object[] objArr2 = this.elements;
        int i9 = 0;
        while (i9 < i8) {
            if (((jArr[i9 >> 3] >> ((i9 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i9];
                if (obj != null) {
                    i7 = obj.hashCode();
                } else {
                    i7 = 0;
                }
                int i10 = i7 * ScatterMapKt.MurmurHashC1;
                int i11 = i10 ^ (i10 << 16);
                int findFirstAvailableSlot = findFirstAvailableSlot(i11 >>> 7);
                long j5 = (long) (i11 & 127);
                long[] jArr2 = this.metadata;
                int i12 = findFirstAvailableSlot >> 3;
                int i13 = (findFirstAvailableSlot & 7) << 3;
                i6 = i9;
                jArr2[i12] = (jArr2[i12] & (~(255 << i13))) | (j5 << i13);
                int i14 = this._capacity;
                int i15 = ((findFirstAvailableSlot - 7) & i14) + (i14 & 7);
                int i16 = i15 >> 3;
                int i17 = (i15 & 7) << 3;
                jArr2[i16] = ((~(255 << i17)) & jArr2[i16]) | (j5 << i17);
                objArr2[findFirstAvailableSlot] = obj;
            } else {
                i6 = i9;
            }
            i9 = i6 + 1;
        }
    }

    private final void writeMetadata(int i5, long j5) {
        long[] jArr = this.metadata;
        int i6 = i5 >> 3;
        int i7 = (i5 & 7) << 3;
        jArr[i6] = (jArr[i6] & (~(255 << i7))) | (j5 << i7);
        int i8 = this._capacity;
        int i9 = ((i5 - 7) & i8) + (i8 & 7);
        int i10 = i9 >> 3;
        int i11 = (i9 & 7) << 3;
        jArr[i10] = (j5 << i11) | (jArr[i10] & (~(255 << i11)));
    }

    public final boolean add(E e5) {
        int size = getSize();
        this.elements[findAbsoluteInsertIndex(e5)] = e5;
        if (getSize() != size) {
            return true;
        }
        return false;
    }

    public final boolean addAll(E[] eArr) {
        t.e(eArr, "elements");
        int size = getSize();
        plusAssign(eArr);
        return size != getSize();
    }

    public final Set<E> asMutableSet() {
        return new MutableSetWrapper();
    }

    public final void clear() {
        this._size = 0;
        long[] jArr = this.metadata;
        if (jArr != ScatterMapKt.EmptyGroup) {
            C2242i.y(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr2 = this.metadata;
            int i5 = this._capacity;
            int i6 = i5 >> 3;
            long j5 = 255 << ((i5 & 7) << 3);
            jArr2[i6] = (jArr2[i6] & (~j5)) | j5;
        }
        C2242i.v(this.elements, (Object) null, 0, this._capacity);
        initializeGrowth();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0069, code lost:
        if (((r4 & ((~r4) << 6)) & -9187201950435737472L) == 0) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006b, code lost:
        r10 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void minusAssign(E r14) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto L_0x0008
            int r1 = r14.hashCode()
            goto L_0x0009
        L_0x0008:
            r1 = r0
        L_0x0009:
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r13._capacity
            int r1 = r1 >>> 7
        L_0x0016:
            r1 = r1 & r3
            long[] r4 = r13.metadata
            int r5 = r1 >> 3
            r6 = r1 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r9 = r4[r5]
            int r4 = 64 - r6
            long r4 = r9 << r4
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r2
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L_0x0043:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x0062
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            java.lang.Object[] r11 = r13.elements
            r11 = r11[r10]
            boolean r11 = kotlin.jvm.internal.t.a(r11, r14)
            if (r11 == 0) goto L_0x005c
            goto L_0x006c
        L_0x005c:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L_0x0043
        L_0x0062:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x0072
            r10 = -1
        L_0x006c:
            if (r10 < 0) goto L_0x0071
            r13.removeElementAt(r10)
        L_0x0071:
            return
        L_0x0072:
            int r0 = r0 + 8
            int r1 = r1 + r0
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.minusAssign(java.lang.Object):void");
    }

    public final void plusAssign(E e5) {
        this.elements[findAbsoluteInsertIndex(e5)] = e5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006e, code lost:
        if (((r7 & ((~r7) << 6)) & -9187201950435737472L) == 0) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0070, code lost:
        r11 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean remove(E r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            if (r1 == 0) goto L_0x000c
            int r3 = r1.hashCode()
            goto L_0x000d
        L_0x000c:
            r3 = r2
        L_0x000d:
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r3 = r3 * r4
            int r4 = r3 << 16
            r3 = r3 ^ r4
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r5 = r0._capacity
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = r2
        L_0x001c:
            long[] r7 = r0.metadata
            int r8 = r3 >> 3
            r9 = r3 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r13 = r7[r8]
            int r7 = 64 - r9
            long r7 = r13 << r7
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r4
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L_0x0048:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L_0x0067
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r3
            r11 = r11 & r5
            java.lang.Object[] r15 = r0.elements
            r15 = r15[r11]
            boolean r15 = kotlin.jvm.internal.t.a(r15, r1)
            if (r15 == 0) goto L_0x0061
            goto L_0x0071
        L_0x0061:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L_0x0048
        L_0x0067:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L_0x007a
            r11 = -1
        L_0x0071:
            if (r11 < 0) goto L_0x0074
            r2 = r12
        L_0x0074:
            if (r2 == 0) goto L_0x0079
            r0.removeElementAt(r11)
        L_0x0079:
            return r2
        L_0x007a:
            int r6 = r6 + 8
            int r3 = r3 + r6
            r3 = r3 & r5
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.remove(java.lang.Object):boolean");
    }

    public final boolean removeAll(E[] eArr) {
        t.e(eArr, "elements");
        int size = getSize();
        minusAssign(eArr);
        return size != getSize();
    }

    public final void removeElementAt(int i5) {
        this._size--;
        long[] jArr = this.metadata;
        int i6 = i5 >> 3;
        int i7 = (i5 & 7) << 3;
        jArr[i6] = (jArr[i6] & (~(255 << i7))) | (254 << i7);
        int i8 = this._capacity;
        int i9 = ((i5 - 7) & i8) + (i8 & 7);
        int i10 = i9 >> 3;
        int i11 = (i9 & 7) << 3;
        jArr[i10] = (jArr[i10] & (~(255 << i11))) | (254 << i11);
        this.elements[i5] = null;
    }

    public final void removeIf(l lVar) {
        t.e(lVar, "predicate");
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            int i8 = (i5 << 3) + i7;
                            if (((Boolean) lVar.invoke(objArr[i8])).booleanValue()) {
                                removeElementAt(i8);
                            }
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        return;
                    }
                }
                if (i5 != length) {
                    i5++;
                } else {
                    return;
                }
            }
        }
    }

    @IntRange(from = 0)
    public final int trim() {
        int i5 = this._capacity;
        int normalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (normalizeCapacity >= i5) {
            return 0;
        }
        resizeStorage(normalizeCapacity);
        return i5 - this._capacity;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableScatterSet(int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 6 : i5);
    }

    public MutableScatterSet(int i5) {
        super((C2633k) null);
        if (i5 >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i5));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
    }

    public final void plusAssign(E[] eArr) {
        t.e(eArr, "elements");
        for (E plusAssign : eArr) {
            plusAssign(plusAssign);
        }
    }

    public final boolean addAll(Iterable<? extends E> iterable) {
        t.e(iterable, "elements");
        int size = getSize();
        plusAssign(iterable);
        return size != getSize();
    }

    public final boolean removeAll(C2751e eVar) {
        t.e(eVar, "elements");
        int size = getSize();
        minusAssign(eVar);
        return size != getSize();
    }

    public final void plusAssign(Iterable<? extends E> iterable) {
        t.e(iterable, "elements");
        for (Object plusAssign : iterable) {
            plusAssign(plusAssign);
        }
    }

    public final boolean addAll(C2751e eVar) {
        t.e(eVar, "elements");
        int size = getSize();
        plusAssign(eVar);
        return size != getSize();
    }

    public final void plusAssign(C2751e eVar) {
        t.e(eVar, "elements");
        for (Object plusAssign : eVar) {
            plusAssign(plusAssign);
        }
    }

    public final boolean removeAll(Iterable<? extends E> iterable) {
        t.e(iterable, "elements");
        int size = getSize();
        minusAssign(iterable);
        return size != getSize();
    }

    public final void minusAssign(E[] eArr) {
        t.e(eArr, "elements");
        for (E minusAssign : eArr) {
            minusAssign(minusAssign);
        }
    }

    public final void plusAssign(ScatterSet<E> scatterSet) {
        t.e(scatterSet, "elements");
        Object[] objArr = scatterSet.elements;
        long[] jArr = scatterSet.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            plusAssign(objArr[(i5 << 3) + i7]);
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        return;
                    }
                }
                if (i5 != length) {
                    i5++;
                } else {
                    return;
                }
            }
        }
    }

    public final boolean addAll(ScatterSet<E> scatterSet) {
        t.e(scatterSet, "elements");
        int size = getSize();
        plusAssign(scatterSet);
        return size != getSize();
    }

    public final void minusAssign(C2751e eVar) {
        t.e(eVar, "elements");
        for (Object minusAssign : eVar) {
            minusAssign(minusAssign);
        }
    }

    public final boolean removeAll(ScatterSet<E> scatterSet) {
        t.e(scatterSet, "elements");
        int size = getSize();
        minusAssign(scatterSet);
        return size != getSize();
    }

    public final void minusAssign(Iterable<? extends E> iterable) {
        t.e(iterable, "elements");
        for (Object minusAssign : iterable) {
            minusAssign(minusAssign);
        }
    }

    public final boolean addAll(ObjectList<E> objectList) {
        t.e(objectList, "elements");
        int size = getSize();
        plusAssign(objectList);
        return size != getSize();
    }

    public final boolean removeAll(ObjectList<E> objectList) {
        t.e(objectList, "elements");
        int size = getSize();
        minusAssign(objectList);
        return size != getSize();
    }

    public final void minusAssign(ScatterSet<E> scatterSet) {
        t.e(scatterSet, "elements");
        Object[] objArr = scatterSet.elements;
        long[] jArr = scatterSet.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            minusAssign(objArr[(i5 << 3) + i7]);
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        return;
                    }
                }
                if (i5 != length) {
                    i5++;
                } else {
                    return;
                }
            }
        }
    }

    public final void plusAssign(ObjectList<E> objectList) {
        t.e(objectList, "elements");
        Object[] objArr = objectList.content;
        int i5 = objectList._size;
        for (int i6 = 0; i6 < i5; i6++) {
            plusAssign(objArr[i6]);
        }
    }

    public final void minusAssign(ObjectList<E> objectList) {
        t.e(objectList, "elements");
        Object[] objArr = objectList.content;
        int i5 = objectList._size;
        for (int i6 = 0; i6 < i5; i6++) {
            minusAssign(objArr[i6]);
        }
    }
}
