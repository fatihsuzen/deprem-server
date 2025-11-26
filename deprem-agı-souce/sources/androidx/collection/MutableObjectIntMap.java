package androidx.collection;

import W2.D;
import X2.C2242i;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import k3.C2616a;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import s3.C2751e;

public final class MutableObjectIntMap<K> extends ObjectIntMap<K> {
    private int growthLimit;

    public MutableObjectIntMap() {
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

    private final int findIndex(K k5) {
        int i5;
        int i6;
        K k6 = k5;
        if (k6 != null) {
            i5 = k6.hashCode();
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
                if (t.a(this.keys[numberOfTrailingZeros], k6)) {
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
                return ~findFirstAvailableSlot;
            }
            i13 += 8;
            i12 = (i12 + i13) & i11;
            i10 = i16;
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
        this.keys = new Object[i6];
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
        int i6;
        int i7;
        long[] jArr = this.metadata;
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        int i8 = this._capacity;
        initializeStorage(i5);
        Object[] objArr2 = this.keys;
        int[] iArr2 = this.values;
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
                jArr2[i16] = (jArr2[i16] & (~(255 << i17))) | (j5 << i17);
                objArr2[findFirstAvailableSlot] = obj;
                iArr2[findFirstAvailableSlot] = iArr[i6];
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
        C2242i.v(this.keys, (Object) null, 0, this._capacity);
        initializeGrowth();
    }

    public final int getOrPut(K k5, C2616a aVar) {
        t.e(aVar, "defaultValue");
        int findKeyIndex = findKeyIndex(k5);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        int intValue = ((Number) aVar.invoke()).intValue();
        set(k5, intValue);
        return intValue;
    }

    public final void minusAssign(K k5) {
        remove(k5);
    }

    public final void plusAssign(ObjectIntMap<K> objectIntMap) {
        t.e(objectIntMap, TypedValues.TransitionType.S_FROM);
        putAll(objectIntMap);
    }

    public final void put(K k5, int i5) {
        set(k5, i5);
    }

    public final void putAll(ObjectIntMap<K> objectIntMap) {
        t.e(objectIntMap, TypedValues.TransitionType.S_FROM);
        Object[] objArr = objectIntMap.keys;
        int[] iArr = objectIntMap.values;
        long[] jArr = objectIntMap.metadata;
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
                            set(objArr[i8], iArr[i8]);
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

    public final void remove(K k5) {
        int findKeyIndex = findKeyIndex(k5);
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
                            if (((Boolean) pVar.invoke(this.keys[i8], Integer.valueOf(this.values[i8]))).booleanValue()) {
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
        this.keys[i5] = null;
    }

    public final void set(K k5, int i5) {
        int findIndex = findIndex(k5);
        if (findIndex < 0) {
            findIndex = ~findIndex;
        }
        this.keys[findIndex] = k5;
        this.values[findIndex] = i5;
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
    public /* synthetic */ MutableObjectIntMap(int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 6 : i5);
    }

    public final void minusAssign(K[] kArr) {
        t.e(kArr, "keys");
        for (K remove : kArr) {
            remove(remove);
        }
    }

    public final int put(K k5, int i5, int i6) {
        int findIndex = findIndex(k5);
        if (findIndex < 0) {
            findIndex = ~findIndex;
        } else {
            i6 = this.values[findIndex];
        }
        this.keys[findIndex] = k5;
        this.values[findIndex] = i5;
        return i6;
    }

    public MutableObjectIntMap(int i5) {
        super((C2633k) null);
        if (i5 >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i5));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
    }

    public final boolean remove(K k5, int i5) {
        int findKeyIndex = findKeyIndex(k5);
        if (findKeyIndex < 0 || this.values[findKeyIndex] != i5) {
            return false;
        }
        removeValueAt(findKeyIndex);
        return true;
    }

    public final void minusAssign(Iterable<? extends K> iterable) {
        t.e(iterable, "keys");
        for (Object remove : iterable) {
            remove(remove);
        }
    }

    public final void minusAssign(C2751e eVar) {
        t.e(eVar, "keys");
        for (Object remove : eVar) {
            remove(remove);
        }
    }

    public final void minusAssign(ScatterSet<K> scatterSet) {
        t.e(scatterSet, "keys");
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
                            remove(objArr[(i5 << 3) + i7]);
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
