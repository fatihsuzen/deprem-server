package androidx.collection;

import W2.D;
import X2.C2242i;
import androidx.annotation.IntRange;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class MutableLongSet extends LongSet {
    private int growthLimit;

    public MutableLongSet() {
        this(0, 1, (C2633k) null);
    }

    private final void adjustStorage() {
        if (this._capacity <= 8 || Long.compare(D.b(D.b((long) this._size) * 32) ^ Long.MIN_VALUE, D.b(D.b((long) this._capacity) * 25) ^ Long.MIN_VALUE) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            removeDeletedMarkers();
        }
    }

    private final int findAbsoluteInsertIndex(long j5) {
        int i5;
        int a5 = a.a(j5) * ScatterMapKt.MurmurHashC1;
        int i6 = a5 ^ (a5 << 16);
        int i7 = i6 >>> 7;
        int i8 = i6 & 127;
        int i9 = this._capacity;
        int i10 = i7 & i9;
        int i11 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i12 = i10 >> 3;
            int i13 = (i10 & 7) << 3;
            long j6 = ((jArr[i12 + 1] << (64 - i13)) & ((-((long) i13)) >> 63)) | (jArr[i12] >>> i13);
            long j7 = (long) i8;
            int i14 = i11;
            long j8 = j6 ^ (j7 * ScatterMapKt.BitmaskLsb);
            for (long j9 = (~j8) & (j8 - ScatterMapKt.BitmaskLsb) & -9187201950435737472L; j9 != 0; j9 &= j9 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j9) >> 3) + i10) & i9;
                if (this.elements[numberOfTrailingZeros] == j5) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j6) << 6) & j6 & -9187201950435737472L) != 0) {
                int findFirstAvailableSlot = findFirstAvailableSlot(i7);
                if (this.growthLimit == 0 && ((this.metadata[findFirstAvailableSlot >> 3] >> ((findFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    findFirstAvailableSlot = findFirstAvailableSlot(i7);
                }
                this._size++;
                int i15 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i16 = findFirstAvailableSlot >> 3;
                long j10 = jArr2[i16];
                int i17 = (findFirstAvailableSlot & 7) << 3;
                if (((j10 >> i17) & 255) == 128) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                this.growthLimit = i15 - i5;
                jArr2[i16] = (j10 & (~(255 << i17))) | (j7 << i17);
                int i18 = this._capacity;
                int i19 = ((findFirstAvailableSlot - 7) & i18) + (i18 & 7);
                int i20 = i19 >> 3;
                int i21 = (i19 & 7) << 3;
                jArr2[i20] = ((~(255 << i21)) & jArr2[i20]) | (j7 << i21);
                return findFirstAvailableSlot;
            }
            i11 = i14 + 8;
            i10 = (i10 + i11) & i9;
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
        this.elements = new long[i6];
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

    private final void removeElementAt(int i5) {
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
    }

    private final void resizeStorage(int i5) {
        long[] jArr;
        MutableLongSet mutableLongSet = this;
        long[] jArr2 = mutableLongSet.metadata;
        long[] jArr3 = mutableLongSet.elements;
        int i6 = mutableLongSet._capacity;
        initializeStorage(i5);
        long[] jArr4 = mutableLongSet.elements;
        int i7 = 0;
        while (i7 < i6) {
            if (((jArr2[i7 >> 3] >> ((i7 & 7) << 3)) & 255) < 128) {
                long j5 = jArr3[i7];
                int a5 = a.a(j5) * ScatterMapKt.MurmurHashC1;
                int i8 = a5 ^ (a5 << 16);
                int findFirstAvailableSlot = mutableLongSet.findFirstAvailableSlot(i8 >>> 7);
                long j6 = (long) (i8 & 127);
                long[] jArr5 = mutableLongSet.metadata;
                int i9 = findFirstAvailableSlot >> 3;
                int i10 = (findFirstAvailableSlot & 7) << 3;
                jArr5[i9] = (jArr5[i9] & (~(255 << i10))) | (j6 << i10);
                int i11 = mutableLongSet._capacity;
                int i12 = ((findFirstAvailableSlot - 7) & i11) + (i11 & 7);
                int i13 = i12 >> 3;
                int i14 = (i12 & 7) << 3;
                jArr = jArr2;
                jArr5[i13] = ((~(255 << i14)) & jArr5[i13]) | (j6 << i14);
                jArr4[findFirstAvailableSlot] = j5;
            } else {
                jArr = jArr2;
            }
            i7++;
            mutableLongSet = this;
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

    public final boolean add(long j5) {
        int i5 = this._size;
        this.elements[findAbsoluteInsertIndex(j5)] = j5;
        if (this._size != i5) {
            return true;
        }
        return false;
    }

    public final boolean addAll(long[] jArr) {
        t.e(jArr, "elements");
        int i5 = this._size;
        plusAssign(jArr);
        return i5 != this._size;
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
        initializeGrowth();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0063, code lost:
        if (((r4 & ((~r4) << 6)) & -9187201950435737472L) == 0) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0065, code lost:
        r10 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void minusAssign(long r15) {
        /*
            r14 = this;
            int r0 = androidx.collection.a.a(r15)
            r1 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r0 = r0 * r1
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r14._capacity
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        L_0x0013:
            long[] r4 = r14.metadata
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
        L_0x003f:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x005c
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r0
            r10 = r10 & r2
            long[] r11 = r14.elements
            r12 = r11[r10]
            int r11 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r11 != 0) goto L_0x0056
            goto L_0x0066
        L_0x0056:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L_0x003f
        L_0x005c:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x006c
            r10 = -1
        L_0x0066:
            if (r10 < 0) goto L_0x006b
            r14.removeElementAt(r10)
        L_0x006b:
            return
        L_0x006c:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L_0x0013
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableLongSet.minusAssign(long):void");
    }

    public final void plusAssign(long j5) {
        this.elements[findAbsoluteInsertIndex(j5)] = j5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0066, code lost:
        if (((r6 & ((~r6) << 6)) & -9187201950435737472L) == 0) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0068, code lost:
        r10 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean remove(long r18) {
        /*
            r17 = this;
            r0 = r17
            int r1 = androidx.collection.a.a(r18)
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r0._capacity
            int r1 = r1 >>> 7
            r1 = r1 & r3
            r4 = 0
            r5 = r4
        L_0x0016:
            long[] r6 = r0.metadata
            int r7 = r1 >> 3
            r8 = r1 & 7
            int r8 = r8 << 3
            r9 = r6[r7]
            long r9 = r9 >>> r8
            r11 = 1
            int r7 = r7 + r11
            r12 = r6[r7]
            int r6 = 64 - r8
            long r6 = r12 << r6
            long r12 = (long) r8
            long r12 = -r12
            r8 = 63
            long r12 = r12 >> r8
            long r6 = r6 & r12
            long r6 = r6 | r9
            long r8 = (long) r2
            r12 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r8 = r8 * r12
            long r8 = r8 ^ r6
            long r12 = r8 - r12
            long r8 = ~r8
            long r8 = r8 & r12
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r12
        L_0x0042:
            r14 = 0
            int r10 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r10 == 0) goto L_0x005f
            int r10 = java.lang.Long.numberOfTrailingZeros(r8)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            long[] r14 = r0.elements
            r15 = r14[r10]
            int r14 = (r15 > r18 ? 1 : (r15 == r18 ? 0 : -1))
            if (r14 != 0) goto L_0x0059
            goto L_0x0069
        L_0x0059:
            r14 = 1
            long r14 = r8 - r14
            long r8 = r8 & r14
            goto L_0x0042
        L_0x005f:
            long r8 = ~r6
            r10 = 6
            long r8 = r8 << r10
            long r6 = r6 & r8
            long r6 = r6 & r12
            int r6 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0072
            r10 = -1
        L_0x0069:
            if (r10 < 0) goto L_0x006c
            r4 = r11
        L_0x006c:
            if (r4 == 0) goto L_0x0071
            r0.removeElementAt(r10)
        L_0x0071:
            return r4
        L_0x0072:
            int r5 = r5 + 8
            int r1 = r1 + r5
            r1 = r1 & r3
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableLongSet.remove(long):boolean");
    }

    public final boolean removeAll(long[] jArr) {
        t.e(jArr, "elements");
        int i5 = this._size;
        minusAssign(jArr);
        return i5 != this._size;
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
    public /* synthetic */ MutableLongSet(int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 6 : i5);
    }

    public MutableLongSet(int i5) {
        super((C2633k) null);
        if (i5 >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i5));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
    }

    public final void plusAssign(long[] jArr) {
        t.e(jArr, "elements");
        for (long plusAssign : jArr) {
            plusAssign(plusAssign);
        }
    }

    public final boolean addAll(LongSet longSet) {
        t.e(longSet, "elements");
        int i5 = this._size;
        plusAssign(longSet);
        return i5 != this._size;
    }

    public final boolean removeAll(LongSet longSet) {
        t.e(longSet, "elements");
        int i5 = this._size;
        minusAssign(longSet);
        return i5 != this._size;
    }

    public final void plusAssign(LongSet longSet) {
        t.e(longSet, "elements");
        long[] jArr = longSet.elements;
        long[] jArr2 = longSet.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr2[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            plusAssign(jArr[(i5 << 3) + i7]);
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

    public final void minusAssign(long[] jArr) {
        t.e(jArr, "elements");
        for (long minusAssign : jArr) {
            minusAssign(minusAssign);
        }
    }

    public final void minusAssign(LongSet longSet) {
        t.e(longSet, "elements");
        long[] jArr = longSet.elements;
        long[] jArr2 = longSet.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr2[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            minusAssign(jArr[(i5 << 3) + i7]);
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
}
