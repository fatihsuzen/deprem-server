package androidx.collection;

import W2.D;
import X2.C2242i;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import k3.C2616a;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class MutableFloatIntMap extends FloatIntMap {
    private int growthLimit;

    public MutableFloatIntMap() {
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

    private final int findInsertIndex(float f5) {
        int i5;
        int floatToIntBits = Float.floatToIntBits(f5) * ScatterMapKt.MurmurHashC1;
        int i6 = floatToIntBits ^ (floatToIntBits << 16);
        int i7 = i6 >>> 7;
        int i8 = i6 & 127;
        int i9 = this._capacity;
        int i10 = i7 & i9;
        int i11 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i12 = i10 >> 3;
            int i13 = (i10 & 7) << 3;
            long j5 = ((jArr[i12 + 1] << (64 - i13)) & ((-((long) i13)) >> 63)) | (jArr[i12] >>> i13);
            long j6 = (long) i8;
            int i14 = i11;
            long j7 = j5 ^ (j6 * ScatterMapKt.BitmaskLsb);
            for (long j8 = (~j7) & (j7 - ScatterMapKt.BitmaskLsb) & -9187201950435737472L; j8 != 0; j8 &= j8 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j8) >> 3) + i10) & i9;
                if (this.keys[numberOfTrailingZeros] == f5) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j5) << 6) & j5 & -9187201950435737472L) != 0) {
                int findFirstAvailableSlot = findFirstAvailableSlot(i7);
                if (this.growthLimit == 0 && ((this.metadata[findFirstAvailableSlot >> 3] >> ((findFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    findFirstAvailableSlot = findFirstAvailableSlot(i7);
                }
                this._size++;
                int i15 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i16 = findFirstAvailableSlot >> 3;
                long j9 = jArr2[i16];
                int i17 = (findFirstAvailableSlot & 7) << 3;
                if (((j9 >> i17) & 255) == 128) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                this.growthLimit = i15 - i5;
                jArr2[i16] = (j9 & (~(255 << i17))) | (j6 << i17);
                int i18 = this._capacity;
                int i19 = ((findFirstAvailableSlot - 7) & i18) + (i18 & 7);
                int i20 = i19 >> 3;
                int i21 = (i19 & 7) << 3;
                jArr2[i20] = ((~(255 << i21)) & jArr2[i20]) | (j6 << i21);
                return ~findFirstAvailableSlot;
            }
            i11 = i14 + 8;
            i10 = (i10 + i11) & i9;
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
        this.keys = new float[i6];
        this.values = new int[i6];
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
        MutableFloatIntMap mutableFloatIntMap = this;
        long[] jArr2 = mutableFloatIntMap.metadata;
        float[] fArr = mutableFloatIntMap.keys;
        int[] iArr = mutableFloatIntMap.values;
        int i6 = mutableFloatIntMap._capacity;
        initializeStorage(i5);
        float[] fArr2 = mutableFloatIntMap.keys;
        int[] iArr2 = mutableFloatIntMap.values;
        int i7 = 0;
        while (i7 < i6) {
            if (((jArr2[i7 >> 3] >> ((i7 & 7) << 3)) & 255) < 128) {
                float f5 = fArr[i7];
                int floatToIntBits = Float.floatToIntBits(f5) * ScatterMapKt.MurmurHashC1;
                int i8 = floatToIntBits ^ (floatToIntBits << 16);
                int findFirstAvailableSlot = mutableFloatIntMap.findFirstAvailableSlot(i8 >>> 7);
                long j5 = (long) (i8 & 127);
                long[] jArr3 = mutableFloatIntMap.metadata;
                int i9 = findFirstAvailableSlot >> 3;
                int i10 = (findFirstAvailableSlot & 7) << 3;
                jArr3[i9] = (jArr3[i9] & (~(255 << i10))) | (j5 << i10);
                int i11 = mutableFloatIntMap._capacity;
                int i12 = ((findFirstAvailableSlot - 7) & i11) + (i11 & 7);
                int i13 = i12 >> 3;
                int i14 = (i12 & 7) << 3;
                jArr = jArr2;
                jArr3[i13] = ((~(255 << i14)) & jArr3[i13]) | (j5 << i14);
                fArr2[findFirstAvailableSlot] = f5;
                iArr2[findFirstAvailableSlot] = iArr[i7];
            } else {
                jArr = jArr2;
            }
            i7++;
            mutableFloatIntMap = this;
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

    public final int getOrPut(float f5, C2616a aVar) {
        t.e(aVar, "defaultValue");
        int findKeyIndex = findKeyIndex(f5);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        int intValue = ((Number) aVar.invoke()).intValue();
        put(f5, intValue);
        return intValue;
    }

    public final void minusAssign(float f5) {
        remove(f5);
    }

    public final void plusAssign(FloatIntMap floatIntMap) {
        t.e(floatIntMap, TypedValues.TransitionType.S_FROM);
        putAll(floatIntMap);
    }

    public final void put(float f5, int i5) {
        set(f5, i5);
    }

    public final void putAll(FloatIntMap floatIntMap) {
        t.e(floatIntMap, TypedValues.TransitionType.S_FROM);
        float[] fArr = floatIntMap.keys;
        int[] iArr = floatIntMap.values;
        long[] jArr = floatIntMap.metadata;
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
                            set(fArr[i8], iArr[i8]);
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

    public final void remove(float f5) {
        int findKeyIndex = findKeyIndex(f5);
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
                            if (((Boolean) pVar.invoke(Float.valueOf(this.keys[i8]), Integer.valueOf(this.values[i8]))).booleanValue()) {
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

    public final void set(float f5, int i5) {
        int findInsertIndex = findInsertIndex(f5);
        if (findInsertIndex < 0) {
            findInsertIndex = ~findInsertIndex;
        }
        this.keys[findInsertIndex] = f5;
        this.values[findInsertIndex] = i5;
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
    public /* synthetic */ MutableFloatIntMap(int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 6 : i5);
    }

    public final void minusAssign(float[] fArr) {
        t.e(fArr, "keys");
        for (float remove : fArr) {
            remove(remove);
        }
    }

    public final int put(float f5, int i5, int i6) {
        int findInsertIndex = findInsertIndex(f5);
        if (findInsertIndex < 0) {
            findInsertIndex = ~findInsertIndex;
        } else {
            i6 = this.values[findInsertIndex];
        }
        this.keys[findInsertIndex] = f5;
        this.values[findInsertIndex] = i5;
        return i6;
    }

    public MutableFloatIntMap(int i5) {
        super((C2633k) null);
        if (i5 >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i5));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
    }

    public final boolean remove(float f5, int i5) {
        int findKeyIndex = findKeyIndex(f5);
        if (findKeyIndex < 0 || this.values[findKeyIndex] != i5) {
            return false;
        }
        removeValueAt(findKeyIndex);
        return true;
    }

    public final void minusAssign(FloatSet floatSet) {
        t.e(floatSet, "keys");
        float[] fArr = floatSet.elements;
        long[] jArr = floatSet.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            remove(fArr[(i5 << 3) + i7]);
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

    public final void minusAssign(FloatList floatList) {
        t.e(floatList, "keys");
        float[] fArr = floatList.content;
        int i5 = floatList._size;
        for (int i6 = 0; i6 < i5; i6++) {
            remove(fArr[i6]);
        }
    }
}
