package androidx.collection;

import W2.D;
import X2.C2242i;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import k3.C2616a;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class MutableIntFloatMap extends IntFloatMap {
    private int growthLimit;

    public MutableIntFloatMap() {
        this(0, 1, (C2633k) null);
    }

    private final void adjustStorage() {
        if (this._capacity <= 8 || Long.compare(D.b(D.b((long) this._size) * 32) ^ Long.MIN_VALUE, D.b(D.b((long) this._capacity) * 25) ^ Long.MIN_VALUE) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            removeDeletedMarkers();
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

    private final int findInsertIndex(int i5) {
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
                return ~findFirstAvailableSlot;
            }
            i14 = i17 + 8;
            i13 = (i13 + i14) & i12;
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
        this.values = new float[i6];
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
        MutableIntFloatMap mutableIntFloatMap = this;
        long[] jArr2 = mutableIntFloatMap.metadata;
        int[] iArr = mutableIntFloatMap.keys;
        float[] fArr = mutableIntFloatMap.values;
        int i6 = mutableIntFloatMap._capacity;
        initializeStorage(i5);
        int[] iArr2 = mutableIntFloatMap.keys;
        float[] fArr2 = mutableIntFloatMap.values;
        int i7 = 0;
        while (i7 < i6) {
            if (((jArr2[i7 >> 3] >> ((i7 & 7) << 3)) & 255) < 128) {
                int i8 = iArr[i7];
                int i9 = ScatterMapKt.MurmurHashC1 * i8;
                int i10 = i9 ^ (i9 << 16);
                int findFirstAvailableSlot = mutableIntFloatMap.findFirstAvailableSlot(i10 >>> 7);
                long j5 = (long) (i10 & 127);
                long[] jArr3 = mutableIntFloatMap.metadata;
                int i11 = findFirstAvailableSlot >> 3;
                int i12 = (findFirstAvailableSlot & 7) << 3;
                jArr3[i11] = (jArr3[i11] & (~(255 << i12))) | (j5 << i12);
                int i13 = mutableIntFloatMap._capacity;
                int i14 = ((findFirstAvailableSlot - 7) & i13) + (i13 & 7);
                int i15 = i14 >> 3;
                int i16 = (i14 & 7) << 3;
                jArr = jArr2;
                jArr3[i15] = ((~(255 << i16)) & jArr3[i15]) | (j5 << i16);
                iArr2[findFirstAvailableSlot] = i8;
                fArr2[findFirstAvailableSlot] = fArr[i7];
            } else {
                jArr = jArr2;
            }
            i7++;
            mutableIntFloatMap = this;
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
        initializeGrowth();
    }

    public final float getOrPut(int i5, C2616a aVar) {
        t.e(aVar, "defaultValue");
        int findKeyIndex = findKeyIndex(i5);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        float floatValue = ((Number) aVar.invoke()).floatValue();
        put(i5, floatValue);
        return floatValue;
    }

    public final void minusAssign(int i5) {
        remove(i5);
    }

    public final void plusAssign(IntFloatMap intFloatMap) {
        t.e(intFloatMap, TypedValues.TransitionType.S_FROM);
        putAll(intFloatMap);
    }

    public final void put(int i5, float f5) {
        set(i5, f5);
    }

    public final void putAll(IntFloatMap intFloatMap) {
        t.e(intFloatMap, TypedValues.TransitionType.S_FROM);
        int[] iArr = intFloatMap.keys;
        float[] fArr = intFloatMap.values;
        long[] jArr = intFloatMap.metadata;
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
                            set(iArr[i8], fArr[i8]);
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

    public final void remove(int i5) {
        int findKeyIndex = findKeyIndex(i5);
        if (findKeyIndex >= 0) {
            removeValueAt(findKeyIndex);
        }
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
                            if (((Boolean) pVar.invoke(Integer.valueOf(this.keys[i8]), Float.valueOf(this.values[i8]))).booleanValue()) {
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

    public final void removeValueAt(int i5) {
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

    public final void set(int i5, float f5) {
        int findInsertIndex = findInsertIndex(i5);
        if (findInsertIndex < 0) {
            findInsertIndex = ~findInsertIndex;
        }
        this.keys[findInsertIndex] = i5;
        this.values[findInsertIndex] = f5;
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
    public /* synthetic */ MutableIntFloatMap(int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 6 : i5);
    }

    public final void minusAssign(int[] iArr) {
        t.e(iArr, "keys");
        for (int remove : iArr) {
            remove(remove);
        }
    }

    public final float put(int i5, float f5, float f6) {
        int findInsertIndex = findInsertIndex(i5);
        if (findInsertIndex < 0) {
            findInsertIndex = ~findInsertIndex;
        } else {
            f6 = this.values[findInsertIndex];
        }
        this.keys[findInsertIndex] = i5;
        this.values[findInsertIndex] = f5;
        return f6;
    }

    public MutableIntFloatMap(int i5) {
        super((C2633k) null);
        if (i5 >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i5));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
    }

    public final boolean remove(int i5, float f5) {
        int findKeyIndex = findKeyIndex(i5);
        if (findKeyIndex < 0 || this.values[findKeyIndex] != f5) {
            return false;
        }
        removeValueAt(findKeyIndex);
        return true;
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

    public final void minusAssign(IntList intList) {
        t.e(intList, "keys");
        int[] iArr = intList.content;
        int i5 = intList._size;
        for (int i6 = 0; i6 < i5; i6++) {
            remove(iArr[i6]);
        }
    }
}
