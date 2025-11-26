package androidx.collection;

import W2.D;
import X2.C2242i;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import k3.C2616a;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class MutableIntObjectMap<V> extends IntObjectMap<V> {
    private int growthLimit;

    public MutableIntObjectMap() {
        this(0, 1, (C2633k) null);
    }

    private final void adjustStorage() {
        if (this._capacity <= 8 || Long.compare(D.b(D.b((long) this._size) * 32) ^ Long.MIN_VALUE, D.b(D.b((long) this._capacity) * 25) ^ Long.MIN_VALUE) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            removeDeletedMarkers();
        }
    }

    private final int findAbsoluteInsertIndex(int i5) {
        int i6;
        int i7 = i5;
        int i8 = ScatterMapKt.MurmurHashC1 * i7;
        int i9 = i8 ^ (i8 << 16);
        int i10 = i9 >>> 7;
        int i11 = i9 & 127;
        int i12 = this._capacity;
        int i13 = i10 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i15 = i13 >> 3;
            int i16 = (i13 & 7) << 3;
            long j5 = ((jArr[i15 + 1] << (64 - i16)) & ((-((long) i16)) >> 63)) | (jArr[i15] >>> i16);
            long j6 = (long) i11;
            int i17 = i14;
            long j7 = j5 ^ (j6 * ScatterMapKt.BitmaskLsb);
            for (long j8 = (~j7) & (j7 - ScatterMapKt.BitmaskLsb) & -9187201950435737472L; j8 != 0; j8 &= j8 - 1) {
                int numberOfTrailingZeros = (i13 + (Long.numberOfTrailingZeros(j8) >> 3)) & i12;
                if (this.keys[numberOfTrailingZeros] == i7) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j5) << 6) & j5 & -9187201950435737472L) != 0) {
                int findFirstAvailableSlot = findFirstAvailableSlot(i10);
                if (this.growthLimit == 0 && ((this.metadata[findFirstAvailableSlot >> 3] >> ((findFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    findFirstAvailableSlot = findFirstAvailableSlot(i10);
                }
                this._size++;
                int i18 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i19 = findFirstAvailableSlot >> 3;
                long j9 = jArr2[i19];
                int i20 = (findFirstAvailableSlot & 7) << 3;
                if (((j9 >> i20) & 255) == 128) {
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                this.growthLimit = i18 - i6;
                jArr2[i19] = (j9 & (~(255 << i20))) | (j6 << i20);
                int i21 = this._capacity;
                int i22 = ((findFirstAvailableSlot - 7) & i21) + (i21 & 7);
                int i23 = i22 >> 3;
                int i24 = (i22 & 7) << 3;
                jArr2[i23] = ((~(255 << i24)) & jArr2[i23]) | (j6 << i24);
                return findFirstAvailableSlot;
            }
            i14 = i17 + 8;
            i13 = (i13 + i14) & i12;
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
        this.keys = new int[i6];
        this.values = new Object[i6];
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
        long[] jArr;
        MutableIntObjectMap mutableIntObjectMap = this;
        long[] jArr2 = mutableIntObjectMap.metadata;
        int[] iArr = mutableIntObjectMap.keys;
        Object[] objArr = mutableIntObjectMap.values;
        int i6 = mutableIntObjectMap._capacity;
        initializeStorage(i5);
        int[] iArr2 = mutableIntObjectMap.keys;
        Object[] objArr2 = mutableIntObjectMap.values;
        int i7 = 0;
        while (i7 < i6) {
            if (((jArr2[i7 >> 3] >> ((i7 & 7) << 3)) & 255) < 128) {
                int i8 = iArr[i7];
                int i9 = ScatterMapKt.MurmurHashC1 * i8;
                int i10 = i9 ^ (i9 << 16);
                int findFirstAvailableSlot = mutableIntObjectMap.findFirstAvailableSlot(i10 >>> 7);
                long j5 = (long) (i10 & 127);
                long[] jArr3 = mutableIntObjectMap.metadata;
                int i11 = findFirstAvailableSlot >> 3;
                int i12 = (findFirstAvailableSlot & 7) << 3;
                jArr3[i11] = (jArr3[i11] & (~(255 << i12))) | (j5 << i12);
                int i13 = mutableIntObjectMap._capacity;
                int i14 = ((findFirstAvailableSlot - 7) & i13) + (i13 & 7);
                int i15 = i14 >> 3;
                int i16 = (i14 & 7) << 3;
                jArr = jArr2;
                jArr3[i15] = ((~(255 << i16)) & jArr3[i15]) | (j5 << i16);
                iArr2[findFirstAvailableSlot] = i8;
                objArr2[findFirstAvailableSlot] = objArr[i7];
            } else {
                jArr = jArr2;
            }
            i7++;
            mutableIntObjectMap = this;
            jArr2 = jArr;
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
        C2242i.v(this.values, (Object) null, 0, this._capacity);
        initializeGrowth();
    }

    public final V getOrPut(int i5, C2616a aVar) {
        t.e(aVar, "defaultValue");
        V v5 = get(i5);
        if (v5 != null) {
            return v5;
        }
        V invoke = aVar.invoke();
        set(i5, invoke);
        return invoke;
    }

    public final void minusAssign(int i5) {
        remove(i5);
    }

    public final void plusAssign(IntObjectMap<V> intObjectMap) {
        t.e(intObjectMap, TypedValues.TransitionType.S_FROM);
        putAll(intObjectMap);
    }

    public final V put(int i5, V v5) {
        int findAbsoluteInsertIndex = findAbsoluteInsertIndex(i5);
        V[] vArr = this.values;
        V v6 = vArr[findAbsoluteInsertIndex];
        this.keys[findAbsoluteInsertIndex] = i5;
        vArr[findAbsoluteInsertIndex] = v5;
        return v6;
    }

    public final void putAll(IntObjectMap<V> intObjectMap) {
        t.e(intObjectMap, TypedValues.TransitionType.S_FROM);
        int[] iArr = intObjectMap.keys;
        Object[] objArr = intObjectMap.values;
        long[] jArr = intObjectMap.metadata;
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
                            set(iArr[i8], objArr[i8]);
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

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x005d, code lost:
        if (((r4 & ((~r4) << 6)) & -9187201950435737472L) == 0) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x005f, code lost:
        r10 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V remove(int r14) {
        /*
            r13 = this;
            r0 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r0 = r0 * r14
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r13._capacity
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        L_0x000f:
            long[] r4 = r13.metadata
            int r5 = r0 >> 3
            r6 = r0 & 7
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
            long r6 = (long) r1
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L_0x003b:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x0056
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r0
            r10 = r10 & r2
            int[] r11 = r13.keys
            r11 = r11[r10]
            if (r11 != r14) goto L_0x0050
            goto L_0x0060
        L_0x0050:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L_0x003b
        L_0x0056:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x0069
            r10 = -1
        L_0x0060:
            if (r10 < 0) goto L_0x0067
            java.lang.Object r14 = r13.removeValueAt(r10)
            return r14
        L_0x0067:
            r14 = 0
            return r14
        L_0x0069:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L_0x000f
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableIntObjectMap.remove(int):java.lang.Object");
    }

    public final void removeIf(p pVar) {
        t.e(pVar, "predicate");
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
                            if (((Boolean) pVar.invoke(Integer.valueOf(this.keys[i8]), this.values[i8])).booleanValue()) {
                                removeValueAt(i8);
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

    public final V removeValueAt(int i5) {
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
        V[] vArr = this.values;
        V v5 = vArr[i5];
        vArr[i5] = null;
        return v5;
    }

    public final void set(int i5, V v5) {
        int findAbsoluteInsertIndex = findAbsoluteInsertIndex(i5);
        this.keys[findAbsoluteInsertIndex] = i5;
        this.values[findAbsoluteInsertIndex] = v5;
    }

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
    public /* synthetic */ MutableIntObjectMap(int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 6 : i5);
    }

    public final void minusAssign(int[] iArr) {
        t.e(iArr, "keys");
        for (int remove : iArr) {
            remove(remove);
        }
    }

    public MutableIntObjectMap(int i5) {
        super((C2633k) null);
        if (i5 >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i5));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
    }

    public final void minusAssign(IntSet intSet) {
        t.e(intSet, "keys");
        int[] iArr = intSet.elements;
        long[] jArr = intSet.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            remove(iArr[(i5 << 3) + i7]);
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

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0062, code lost:
        if (((r7 & ((~r7) << 6)) & -9187201950435737472L) == 0) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0064, code lost:
        r11 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean remove(int r18, V r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r2 = r2 * r1
            int r3 = r2 << 16
            r2 = r2 ^ r3
            r3 = r2 & 127(0x7f, float:1.78E-43)
            int r4 = r0._capacity
            int r2 = r2 >>> 7
            r2 = r2 & r4
            r5 = 0
            r6 = r5
        L_0x0014:
            long[] r7 = r0.metadata
            int r8 = r2 >> 3
            r9 = r2 & 7
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
            long r9 = (long) r3
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L_0x0040:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L_0x005b
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r2
            r11 = r11 & r4
            int[] r15 = r0.keys
            r15 = r15[r11]
            if (r15 != r1) goto L_0x0055
            goto L_0x0065
        L_0x0055:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L_0x0040
        L_0x005b:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L_0x0078
            r11 = -1
        L_0x0065:
            if (r11 < 0) goto L_0x0077
            java.lang.Object[] r1 = r0.values
            r1 = r1[r11]
            r7 = r19
            boolean r1 = kotlin.jvm.internal.t.a(r1, r7)
            if (r1 == 0) goto L_0x0077
            r0.removeValueAt(r11)
            return r12
        L_0x0077:
            return r5
        L_0x0078:
            r7 = r19
            int r6 = r6 + 8
            int r2 = r2 + r6
            r2 = r2 & r4
            goto L_0x0014
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableIntObjectMap.remove(int, java.lang.Object):boolean");
    }

    public final void minusAssign(IntList intList) {
        t.e(intList, "keys");
        int[] iArr = intList.content;
        int i5 = intList._size;
        for (int i6 = 0; i6 < i5; i6++) {
            remove(iArr[i6]);
        }
    }
}
