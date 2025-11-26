package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.NoSuchElementException;
import k3.C2616a;
import k3.l;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class ObjectIntMap<K> {
    public int _capacity;
    public int _size;
    public Object[] keys;
    public long[] metadata;
    public int[] values;

    public /* synthetic */ ObjectIntMap(C2633k kVar) {
        this();
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
    }

    public static /* synthetic */ String joinToString$default(ObjectIntMap objectIntMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 1) != 0) {
                charSequence = ", ";
            }
            if ((i6 & 2) != 0) {
                charSequence2 = "";
            }
            if ((i6 & 4) != 0) {
                charSequence3 = "";
            }
            if ((i6 & 8) != 0) {
                i5 = -1;
            }
            if ((i6 & 16) != 0) {
                charSequence4 = "...";
            }
            int i7 = i5;
            CharSequence charSequence5 = charSequence4;
            return objectIntMap.joinToString(charSequence, charSequence2, charSequence3, i7, charSequence5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean all(p pVar) {
        p pVar2 = pVar;
        t.e(pVar2, "predicate");
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i5 = 0;
        while (true) {
            long j5 = jArr[i5];
            if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j5) < 128) {
                        int i8 = (i5 << 3) + i7;
                        if (!((Boolean) pVar2.invoke(objArr[i8], Integer.valueOf(iArr[i8]))).booleanValue()) {
                            return false;
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return true;
                }
            }
            if (i5 == length) {
                return true;
            }
            i5++;
        }
    }

    public final boolean any() {
        return this._size != 0;
    }

    public final boolean contains(K k5) {
        if (findKeyIndex(k5) >= 0) {
            return true;
        }
        return false;
    }

    public final boolean containsKey(K k5) {
        if (findKeyIndex(k5) >= 0) {
            return true;
        }
        return false;
    }

    public final boolean containsValue(int i5) {
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j5 = jArr[i6];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((255 & j5) < 128 && i5 == iArr[(i6 << 3) + i8]) {
                            return true;
                        }
                        j5 >>= 8;
                    }
                    if (i7 != 8) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
        }
        return false;
    }

    public final int count() {
        return getSize();
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 1
            if (r1 != r0) goto L_0x0008
            return r2
        L_0x0008:
            boolean r3 = r1 instanceof androidx.collection.ObjectIntMap
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            androidx.collection.ObjectIntMap r1 = (androidx.collection.ObjectIntMap) r1
            int r3 = r1.getSize()
            int r5 = r0.getSize()
            if (r3 == r5) goto L_0x001b
            return r4
        L_0x001b:
            java.lang.Object[] r3 = r0.keys
            int[] r5 = r0.values
            long[] r6 = r0.metadata
            int r7 = r6.length
            int r7 = r7 + -2
            if (r7 < 0) goto L_0x0065
            r8 = r4
        L_0x0027:
            r9 = r6[r8]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L_0x0060
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r4
        L_0x0041:
            if (r13 >= r11) goto L_0x005e
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.32E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L_0x005a
            int r14 = r8 << 3
            int r14 = r14 + r13
            r15 = r3[r14]
            r14 = r5[r14]
            int r15 = r1.get(r15)
            if (r14 == r15) goto L_0x005a
            return r4
        L_0x005a:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L_0x0041
        L_0x005e:
            if (r11 != r12) goto L_0x0065
        L_0x0060:
            if (r8 == r7) goto L_0x0065
            int r8 = r8 + 1
            goto L_0x0027
        L_0x0065:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ObjectIntMap.equals(java.lang.Object):boolean");
    }

    public final int findKeyIndex(K k5) {
        int i5;
        int i6 = 0;
        if (k5 != null) {
            i5 = k5.hashCode();
        } else {
            i5 = 0;
        }
        int i7 = i5 * ScatterMapKt.MurmurHashC1;
        int i8 = i7 ^ (i7 << 16);
        int i9 = i8 & 127;
        int i10 = this._capacity;
        int i11 = i8 >>> 7;
        while (true) {
            int i12 = i11 & i10;
            long[] jArr = this.metadata;
            int i13 = i12 >> 3;
            int i14 = (i12 & 7) << 3;
            long j5 = ((jArr[i13 + 1] << (64 - i14)) & ((-((long) i14)) >> 63)) | (jArr[i13] >>> i14);
            long j6 = (((long) i9) * ScatterMapKt.BitmaskLsb) ^ j5;
            for (long j7 = (~j6) & (j6 - ScatterMapKt.BitmaskLsb) & -9187201950435737472L; j7 != 0; j7 &= j7 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j7) >> 3) + i12) & i10;
                if (t.a(this.keys[numberOfTrailingZeros], k5)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j5 & ((~j5) << 6) & -9187201950435737472L) != 0) {
                return -1;
            }
            i6 += 8;
            i11 = i12 + i6;
        }
    }

    public final void forEach(p pVar) {
        p pVar2 = pVar;
        t.e(pVar2, "block");
        Object[] objArr = this.keys;
        int[] iArr = this.values;
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
                            pVar2.invoke(objArr[i8], Integer.valueOf(iArr[i8]));
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

    public final void forEachIndexed(l lVar) {
        t.e(lVar, "block");
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
                            lVar.invoke(Integer.valueOf((i5 << 3) + i7));
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

    public final void forEachKey(l lVar) {
        t.e(lVar, "block");
        Object[] objArr = this.keys;
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
                            lVar.invoke(objArr[(i5 << 3) + i7]);
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

    public final void forEachValue(l lVar) {
        t.e(lVar, "block");
        int[] iArr = this.values;
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
                            lVar.invoke(Integer.valueOf(iArr[(i5 << 3) + i7]));
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

    public final int get(K k5) {
        int findKeyIndex = findKeyIndex(k5);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        throw new NoSuchElementException("There is no key " + k5 + " in the map");
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final int getOrDefault(K k5, int i5) {
        int findKeyIndex = findKeyIndex(k5);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        return i5;
    }

    public final int getOrElse(K k5, C2616a aVar) {
        t.e(aVar, "defaultValue");
        int findKeyIndex = findKeyIndex(k5);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        return ((Number) aVar.invoke()).intValue();
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int i5;
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i6 = 0;
        int i7 = 0;
        while (true) {
            long j5 = jArr[i6];
            if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                int i8 = 8 - ((~(i6 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j5) < 128) {
                        int i10 = (i6 << 3) + i9;
                        Object obj = objArr[i10];
                        int i11 = iArr[i10];
                        if (obj != null) {
                            i5 = obj.hashCode();
                        } else {
                            i5 = 0;
                        }
                        i7 += i11 ^ i5;
                    }
                    j5 >>= 8;
                }
                if (i8 != 8) {
                    return i7;
                }
            }
            if (i6 == length) {
                return i7;
            }
            i6++;
        }
    }

    public final boolean isEmpty() {
        if (this._size == 0) {
            return true;
        }
        return false;
    }

    public final boolean isNotEmpty() {
        if (this._size != 0) {
            return true;
        }
        return false;
    }

    public final String joinToString() {
        return joinToString$default(this, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, 31, (Object) null);
    }

    public final boolean none() {
        if (this._size == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((255 & j5) < 128) {
                            int i9 = (i5 << 3) + i8;
                            Object obj = objArr[i9];
                            int i10 = iArr[i9];
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            sb.append("=");
                            sb.append(i10);
                            i6++;
                            if (i6 < this._size) {
                                sb.append(',');
                                sb.append(' ');
                            }
                        }
                        j5 >>= 8;
                    }
                    if (i7 != 8) {
                        break;
                    }
                }
                if (i5 == length) {
                    break;
                }
                i5++;
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        t.d(sb2, "s.append('}').toString()");
        return sb2;
    }

    private ObjectIntMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = ContainerHelpersKt.EMPTY_OBJECTS;
        this.values = IntSetKt.getEmptyIntArray();
    }

    public final boolean any(p pVar) {
        p pVar2 = pVar;
        t.e(pVar2, "predicate");
        Object[] objArr = this.keys;
        int[] iArr = this.values;
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
                            if (((Boolean) pVar2.invoke(objArr[i8], Integer.valueOf(iArr[i8]))).booleanValue()) {
                                return true;
                            }
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        break;
                    }
                }
                if (i5 == length) {
                    break;
                }
                i5++;
            }
        }
        return false;
    }

    public final int count(p pVar) {
        p pVar2 = pVar;
        t.e(pVar2, "predicate");
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            long j5 = jArr[i5];
            if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                int i7 = 8 - ((~(i5 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j5) < 128) {
                        int i9 = (i5 << 3) + i8;
                        if (((Boolean) pVar2.invoke(objArr[i9], Integer.valueOf(iArr[i9]))).booleanValue()) {
                            i6++;
                        }
                    }
                    j5 >>= 8;
                }
                if (i7 != 8) {
                    return i6;
                }
            }
            if (i5 == length) {
                return i6;
            }
            i5++;
        }
    }

    public final String joinToString(CharSequence charSequence) {
        t.e(charSequence, "separator");
        return joinToString$default(this, charSequence, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, 30, (Object) null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2) {
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        return joinToString$default(this, charSequence, charSequence2, (CharSequence) null, 0, (CharSequence) null, 28, (Object) null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, 0, (CharSequence) null, 24, (Object) null);
    }

    public static /* synthetic */ String joinToString$default(ObjectIntMap objectIntMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, p pVar, int i6, Object obj) {
        long[] jArr;
        int i7;
        long[] jArr2;
        ObjectIntMap objectIntMap2 = objectIntMap;
        p pVar2 = pVar;
        if (obj == null) {
            String str = (i6 & 1) != 0 ? ", " : charSequence;
            CharSequence charSequence5 = "";
            CharSequence charSequence6 = (i6 & 2) != 0 ? charSequence5 : charSequence2;
            if ((i6 & 4) == 0) {
                charSequence5 = charSequence3;
            }
            int i8 = (i6 & 8) != 0 ? -1 : i5;
            String str2 = (i6 & 16) != 0 ? "..." : charSequence4;
            t.e(str, "separator");
            t.e(charSequence6, "prefix");
            t.e(charSequence5, "postfix");
            t.e(str2, "truncated");
            t.e(pVar2, "transform");
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence6);
            Object[] objArr = objectIntMap2.keys;
            int[] iArr = objectIntMap2.values;
            long[] jArr3 = objectIntMap2.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i9 = 0;
                int i10 = 0;
                loop0:
                while (true) {
                    long j5 = jArr3[i9];
                    int i11 = i9;
                    if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                        int i12 = 8;
                        int i13 = 8 - ((~(i11 - length)) >>> 31);
                        int i14 = 0;
                        while (i14 < i13) {
                            if ((j5 & 255) < 128) {
                                int i15 = (i11 << 3) + i14;
                                i7 = i12;
                                Object obj2 = objArr[i15];
                                int i16 = iArr[i15];
                                if (i10 == i8) {
                                    sb.append(str2);
                                    break loop0;
                                }
                                if (i10 != 0) {
                                    sb.append(str);
                                }
                                jArr2 = jArr3;
                                sb.append((CharSequence) pVar2.invoke(obj2, Integer.valueOf(i16)));
                                i10++;
                            } else {
                                jArr2 = jArr3;
                                i7 = i12;
                            }
                            j5 >>= i7;
                            i14++;
                            i12 = i7;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i13 != i12) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    int i17 = i11;
                    if (i17 == length) {
                        break;
                    }
                    i9 = i17 + 1;
                    jArr3 = jArr;
                }
            }
            sb.append(charSequence5);
            String sb2 = sb.toString();
            t.d(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5) {
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i5, (CharSequence) null, 16, (Object) null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4) {
        Object[] objArr;
        int i6;
        Object[] objArr2;
        CharSequence charSequence5 = charSequence;
        CharSequence charSequence6 = charSequence2;
        CharSequence charSequence7 = charSequence3;
        CharSequence charSequence8 = charSequence4;
        t.e(charSequence5, "separator");
        t.e(charSequence6, "prefix");
        t.e(charSequence7, "postfix");
        t.e(charSequence8, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence6);
        Object[] objArr3 = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i7 = 0;
            int i8 = 0;
            loop0:
            while (true) {
                long j5 = jArr[i7];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i9 = 8;
                    int i10 = 8 - ((~(i7 - length)) >>> 31);
                    int i11 = 0;
                    while (i11 < i10) {
                        if ((j5 & 255) < 128) {
                            int i12 = (i7 << 3) + i11;
                            i6 = i9;
                            Object obj = objArr3[i12];
                            int i13 = iArr[i12];
                            objArr2 = objArr3;
                            if (i8 == i5) {
                                sb.append(charSequence8);
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb.append(charSequence5);
                            }
                            sb.append(obj);
                            sb.append('=');
                            sb.append(i13);
                            i8++;
                        } else {
                            objArr2 = objArr3;
                            i6 = i9;
                            int i14 = i5;
                        }
                        j5 >>= i6;
                        i11++;
                        objArr3 = objArr2;
                        i9 = i6;
                    }
                    objArr = objArr3;
                    int i15 = i5;
                    if (i10 != i9) {
                        break;
                    }
                } else {
                    objArr = objArr3;
                    int i16 = i5;
                }
                if (i7 == length) {
                    break;
                }
                i7++;
                objArr3 = objArr;
            }
        }
        sb.append(charSequence7);
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, p pVar) {
        Object[] objArr;
        Object[] objArr2;
        CharSequence charSequence5 = charSequence;
        CharSequence charSequence6 = charSequence2;
        CharSequence charSequence7 = charSequence3;
        CharSequence charSequence8 = charSequence4;
        p pVar2 = pVar;
        t.e(charSequence5, "separator");
        t.e(charSequence6, "prefix");
        t.e(charSequence7, "postfix");
        t.e(charSequence8, "truncated");
        t.e(pVar2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence6);
        Object[] objArr3 = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0:
            while (true) {
                long j5 = jArr[i6];
                int i8 = i6;
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i9 = 8 - ((~(i8 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & 255) < 128) {
                            int i11 = (i8 << 3) + i10;
                            Object obj = objArr3[i11];
                            int i12 = iArr[i11];
                            objArr2 = objArr3;
                            if (i7 == i5) {
                                sb.append(charSequence8);
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(charSequence5);
                            }
                            sb.append((CharSequence) pVar2.invoke(obj, Integer.valueOf(i12)));
                            i7++;
                        } else {
                            objArr2 = objArr3;
                            int i13 = i5;
                        }
                        j5 >>= 8;
                        i10++;
                        charSequence5 = charSequence;
                        objArr3 = objArr2;
                    }
                    objArr = objArr3;
                    int i14 = i5;
                    if (i9 != 8) {
                        break;
                    }
                } else {
                    objArr = objArr3;
                    int i15 = i5;
                }
                if (i8 == length) {
                    break;
                }
                i6 = i8 + 1;
                charSequence5 = charSequence;
                objArr3 = objArr;
            }
            String sb2 = sb.toString();
            t.d(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        sb.append(charSequence7);
        String sb22 = sb.toString();
        t.d(sb22, "StringBuilder().apply(builderAction).toString()");
        return sb22;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, p pVar) {
        int i6;
        CharSequence charSequence4 = charSequence;
        CharSequence charSequence5 = charSequence2;
        CharSequence charSequence6 = charSequence3;
        p pVar2 = pVar;
        t.e(charSequence4, "separator");
        t.e(charSequence5, "prefix");
        t.e(charSequence6, "postfix");
        t.e(pVar2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence5);
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i7 = 0;
            int i8 = 0;
            loop0:
            while (true) {
                long j5 = jArr[i7];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i9 = 8;
                    int i10 = 8 - ((~(i7 - length)) >>> 31);
                    int i11 = 0;
                    while (i11 < i10) {
                        if ((j5 & 255) < 128) {
                            int i12 = (i7 << 3) + i11;
                            i6 = i9;
                            Object obj = objArr[i12];
                            int i13 = iArr[i12];
                            if (i8 == i5) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb.append(charSequence4);
                            }
                            sb.append((CharSequence) pVar2.invoke(obj, Integer.valueOf(i13)));
                            i8++;
                        } else {
                            i6 = i9;
                        }
                        j5 >>= i6;
                        i11++;
                        i9 = i6;
                    }
                    if (i10 != i9) {
                        break;
                    }
                }
                if (i7 == length) {
                    break;
                }
                i7++;
            }
        }
        sb.append(charSequence6);
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, p pVar) {
        int i5;
        CharSequence charSequence4 = charSequence;
        CharSequence charSequence5 = charSequence2;
        CharSequence charSequence6 = charSequence3;
        p pVar2 = pVar;
        t.e(charSequence4, "separator");
        t.e(charSequence5, "prefix");
        t.e(charSequence6, "postfix");
        t.e(pVar2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence5);
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0:
            while (true) {
                long j5 = jArr[i6];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i6 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & 255) < 128) {
                            int i11 = (i6 << 3) + i10;
                            i5 = i8;
                            Object obj = objArr[i11];
                            int i12 = iArr[i11];
                            if (i7 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(charSequence4);
                            }
                            sb.append((CharSequence) pVar2.invoke(obj, Integer.valueOf(i12)));
                            i7++;
                        } else {
                            i5 = i8;
                        }
                        j5 >>= i5;
                        i10++;
                        i8 = i5;
                    }
                    if (i9 != i8) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
        }
        sb.append(charSequence6);
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, p pVar) {
        int i5;
        CharSequence charSequence3 = charSequence;
        CharSequence charSequence4 = charSequence2;
        p pVar2 = pVar;
        t.e(charSequence3, "separator");
        t.e(charSequence4, "prefix");
        t.e(pVar2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence4);
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0:
            while (true) {
                long j5 = jArr[i6];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i6 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & 255) < 128) {
                            int i11 = (i6 << 3) + i10;
                            Object obj = objArr[i11];
                            int i12 = iArr[i11];
                            i5 = i8;
                            if (i7 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(charSequence3);
                            }
                            sb.append((CharSequence) pVar2.invoke(obj, Integer.valueOf(i12)));
                            i7++;
                        } else {
                            i5 = i8;
                        }
                        j5 >>= i5;
                        i10++;
                        i8 = i5;
                    }
                    if (i9 != i8) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
            String sb2 = sb.toString();
            t.d(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        sb.append("");
        String sb22 = sb.toString();
        t.d(sb22, "StringBuilder().apply(builderAction).toString()");
        return sb22;
    }

    public final String joinToString(CharSequence charSequence, p pVar) {
        int i5;
        CharSequence charSequence2 = charSequence;
        p pVar2 = pVar;
        t.e(charSequence2, "separator");
        t.e(pVar2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0:
            while (true) {
                long j5 = jArr[i6];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i6 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & 255) < 128) {
                            int i11 = (i6 << 3) + i10;
                            i5 = i8;
                            Object obj = objArr[i11];
                            int i12 = iArr[i11];
                            if (i7 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(charSequence2);
                            }
                            sb.append((CharSequence) pVar2.invoke(obj, Integer.valueOf(i12)));
                            i7++;
                        } else {
                            i5 = i8;
                        }
                        j5 >>= i5;
                        i10++;
                        i8 = i5;
                    }
                    if (i9 != i8) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
            String sb2 = sb.toString();
            t.d(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        sb.append("");
        String sb22 = sb.toString();
        t.d(sb22, "StringBuilder().apply(builderAction).toString()");
        return sb22;
    }

    public final String joinToString(p pVar) {
        int i5;
        p pVar2 = pVar;
        t.e(pVar2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0:
            while (true) {
                long j5 = jArr[i6];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i6 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & 255) < 128) {
                            int i11 = (i6 << 3) + i10;
                            Object obj = objArr[i11];
                            int i12 = iArr[i11];
                            i5 = i8;
                            if (i7 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(", ");
                            }
                            sb.append((CharSequence) pVar2.invoke(obj, Integer.valueOf(i12)));
                            i7++;
                        } else {
                            i5 = i8;
                        }
                        j5 >>= i5;
                        i10++;
                        i8 = i5;
                    }
                    if (i9 != i8) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
        }
        sb.append("");
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
