package androidx.collection;

import java.util.NoSuchElementException;
import k3.C2616a;
import k3.l;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class LongLongMap {
    public int _capacity;
    public int _size;
    public long[] keys;
    public long[] metadata;
    public long[] values;

    public /* synthetic */ LongLongMap(C2633k kVar) {
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

    public static /* synthetic */ String joinToString$default(LongLongMap longLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, int i6, Object obj) {
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
            return longLongMap.joinToString(charSequence, charSequence2, charSequence3, i7, charSequence5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean all(p pVar) {
        p pVar2 = pVar;
        t.e(pVar2, "predicate");
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            return true;
        }
        int i5 = 0;
        while (true) {
            long j5 = jArr3[i5];
            if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j5) < 128) {
                        int i8 = (i5 << 3) + i7;
                        if (!((Boolean) pVar2.invoke(Long.valueOf(jArr[i8]), Long.valueOf(jArr2[i8]))).booleanValue()) {
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

    public final boolean contains(long j5) {
        if (findKeyIndex(j5) >= 0) {
            return true;
        }
        return false;
    }

    public final boolean containsKey(long j5) {
        if (findKeyIndex(j5) >= 0) {
            return true;
        }
        return false;
    }

    public final boolean containsValue(long j5) {
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j6 = jArr2[i5];
                if ((((~j6) << 7) & j6 & -9187201950435737472L) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j6) < 128 && j5 == jArr[(i5 << 3) + i7]) {
                            return true;
                        }
                        j6 >>= 8;
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

    public final int count() {
        return getSize();
    }

    /* JADX WARNING: type inference failed for: r20v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = 1
            if (r1 != r0) goto L_0x0008
            return r2
        L_0x0008:
            boolean r3 = r1 instanceof androidx.collection.LongLongMap
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            androidx.collection.LongLongMap r1 = (androidx.collection.LongLongMap) r1
            int r3 = r1.getSize()
            int r5 = r0.getSize()
            if (r3 == r5) goto L_0x001b
            return r4
        L_0x001b:
            long[] r3 = r0.keys
            long[] r5 = r0.values
            long[] r6 = r0.metadata
            int r7 = r6.length
            int r7 = r7 + -2
            if (r7 < 0) goto L_0x007a
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
            if (r11 == 0) goto L_0x006f
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r4
        L_0x0041:
            if (r13 >= r11) goto L_0x0069
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.32E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L_0x005f
            int r14 = r8 << 3
            int r14 = r14 + r13
            r15 = r2
            r16 = r3
            r2 = r16[r14]
            r17 = r5[r14]
            long r2 = r1.get(r2)
            int r2 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0062
            return r4
        L_0x005f:
            r15 = r2
            r16 = r3
        L_0x0062:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            r2 = r15
            r3 = r16
            goto L_0x0041
        L_0x0069:
            r15 = r2
            r16 = r3
            if (r11 != r12) goto L_0x007b
            goto L_0x0072
        L_0x006f:
            r15 = r2
            r16 = r3
        L_0x0072:
            if (r8 == r7) goto L_0x007b
            int r8 = r8 + 1
            r2 = r15
            r3 = r16
            goto L_0x0027
        L_0x007a:
            r15 = r2
        L_0x007b:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongLongMap.equals(java.lang.Object):boolean");
    }

    public final int findKeyIndex(long j5) {
        int a5 = a.a(j5) * ScatterMapKt.MurmurHashC1;
        int i5 = a5 ^ (a5 << 16);
        int i6 = i5 & 127;
        int i7 = this._capacity;
        int i8 = (i5 >>> 7) & i7;
        int i9 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i10 = i8 >> 3;
            int i11 = (i8 & 7) << 3;
            long j6 = ((jArr[i10 + 1] << (64 - i11)) & ((-((long) i11)) >> 63)) | (jArr[i10] >>> i11);
            long j7 = (((long) i6) * ScatterMapKt.BitmaskLsb) ^ j6;
            for (long j8 = (~j7) & (j7 - ScatterMapKt.BitmaskLsb) & -9187201950435737472L; j8 != 0; j8 &= j8 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j8) >> 3) + i8) & i7;
                if (this.keys[numberOfTrailingZeros] == j5) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j6 & ((~j6) << 6) & -9187201950435737472L) != 0) {
                return -1;
            }
            i9 += 8;
            i8 = (i8 + i9) & i7;
        }
    }

    public final void forEach(p pVar) {
        p pVar2 = pVar;
        t.e(pVar2, "block");
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr3[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            int i8 = (i5 << 3) + i7;
                            pVar2.invoke(Long.valueOf(jArr[i8]), Long.valueOf(jArr2[i8]));
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
        long[] jArr = this.keys;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr2[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            lVar.invoke(Long.valueOf(jArr[(i5 << 3) + i7]));
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
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr2[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            lVar.invoke(Long.valueOf(jArr[(i5 << 3) + i7]));
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

    public final long get(long j5) {
        int findKeyIndex = findKeyIndex(j5);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        throw new NoSuchElementException("Cannot find value for key " + j5);
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final long getOrDefault(long j5, long j6) {
        int findKeyIndex = findKeyIndex(j5);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        return j6;
    }

    public final long getOrElse(long j5, C2616a aVar) {
        t.e(aVar, "defaultValue");
        int findKeyIndex = findKeyIndex(j5);
        if (findKeyIndex < 0) {
            return ((Number) aVar.invoke()).longValue();
        }
        return this.values[findKeyIndex];
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            return 0;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            long j5 = jArr3[i5];
            if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                int i7 = 8 - ((~(i5 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j5) < 128) {
                        int i9 = (i5 << 3) + i8;
                        i6 += a.a(jArr[i9]) ^ a.a(jArr2[i9]);
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
        int i5;
        int i6;
        int i7;
        int i8;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i9 = 0;
            int i10 = 0;
            while (true) {
                long j5 = jArr3[i9];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i9 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((255 & j5) < 128) {
                            int i14 = (i9 << 3) + i13;
                            i8 = i9;
                            long j6 = jArr[i14];
                            i7 = i11;
                            i6 = i13;
                            long j7 = jArr2[i14];
                            sb.append(j6);
                            sb.append("=");
                            sb.append(j7);
                            i10++;
                            if (i10 < this._size) {
                                sb.append(',');
                                sb.append(' ');
                            }
                        } else {
                            i8 = i9;
                            i7 = i11;
                            i6 = i13;
                        }
                        j5 >>= i7;
                        i13 = i6 + 1;
                        i9 = i8;
                        i11 = i7;
                    }
                    int i15 = i9;
                    if (i12 != i11) {
                        break;
                    }
                    i5 = i15;
                } else {
                    i5 = i9;
                }
                if (i5 == length) {
                    break;
                }
                i9 = i5 + 1;
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        t.d(sb2, "s.append('}').toString()");
        return sb2;
    }

    private LongLongMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = LongSetKt.getEmptyLongArray();
        this.values = LongSetKt.getEmptyLongArray();
    }

    public final boolean any(p pVar) {
        p pVar2 = pVar;
        t.e(pVar2, "predicate");
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr3[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            int i8 = (i5 << 3) + i7;
                            if (((Boolean) pVar2.invoke(Long.valueOf(jArr[i8]), Long.valueOf(jArr2[i8]))).booleanValue()) {
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
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            return 0;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            long j5 = jArr3[i5];
            if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                int i7 = 8 - ((~(i5 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j5) < 128) {
                        int i9 = (i5 << 3) + i8;
                        if (((Boolean) pVar2.invoke(Long.valueOf(jArr[i9]), Long.valueOf(jArr2[i9]))).booleanValue()) {
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

    public static /* synthetic */ String joinToString$default(LongLongMap longLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, p pVar, int i6, Object obj) {
        long[] jArr;
        int i7;
        long[] jArr2;
        LongLongMap longLongMap2 = longLongMap;
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
            long[] jArr3 = longLongMap2.keys;
            long[] jArr4 = longLongMap2.values;
            long[] jArr5 = longLongMap2.metadata;
            int length = jArr5.length - 2;
            if (length >= 0) {
                int i9 = 0;
                int i10 = 0;
                loop0:
                while (true) {
                    long j5 = jArr5[i9];
                    int i11 = i9;
                    if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                        int i12 = 8;
                        int i13 = 8 - ((~(i11 - length)) >>> 31);
                        int i14 = 0;
                        while (i14 < i13) {
                            if ((j5 & 255) < 128) {
                                int i15 = (i11 << 3) + i14;
                                long j6 = jArr3[i15];
                                long j7 = jArr4[i15];
                                if (i10 == i8) {
                                    sb.append(str2);
                                    break loop0;
                                }
                                if (i10 != 0) {
                                    sb.append(str);
                                }
                                i7 = i12;
                                jArr2 = jArr5;
                                sb.append((CharSequence) pVar2.invoke(Long.valueOf(j6), Long.valueOf(j7)));
                                i10++;
                            } else {
                                jArr2 = jArr5;
                                i7 = i12;
                            }
                            j5 >>= i7;
                            i14++;
                            i12 = i7;
                            jArr5 = jArr2;
                        }
                        jArr = jArr5;
                        if (i13 != i12) {
                            break;
                        }
                    } else {
                        jArr = jArr5;
                    }
                    int i16 = i11;
                    if (i16 == length) {
                        break;
                    }
                    i9 = i16 + 1;
                    jArr5 = jArr;
                }
                String sb2 = sb.toString();
                t.d(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
            sb.append(charSequence5);
            String sb22 = sb.toString();
            t.d(sb22, "StringBuilder().apply(builderAction).toString()");
            return sb22;
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
        long[] jArr;
        long[] jArr2;
        long j5;
        long[] jArr3;
        long[] jArr4;
        int i6;
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
        long[] jArr5 = this.keys;
        long[] jArr6 = this.values;
        long[] jArr7 = this.metadata;
        int length = jArr7.length - 2;
        if (length >= 0) {
            int i7 = 0;
            int i8 = 0;
            loop0:
            while (true) {
                long j6 = jArr7[i7];
                if ((((~j6) << 7) & j6 & -9187201950435737472L) != -9187201950435737472L) {
                    int i9 = 8;
                    int i10 = 8 - ((~(i7 - length)) >>> 31);
                    int i11 = 0;
                    while (i11 < i10) {
                        if ((j6 & 255) < 128) {
                            int i12 = (i7 << 3) + i11;
                            jArr4 = jArr6;
                            jArr3 = jArr7;
                            long j7 = jArr5[i12];
                            j5 = j6;
                            long j8 = jArr4[i12];
                            i6 = i9;
                            if (i8 == i5) {
                                sb.append(charSequence8);
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb.append(charSequence5);
                            }
                            sb.append(j7);
                            sb.append('=');
                            sb.append(j8);
                            i8++;
                        } else {
                            jArr4 = jArr6;
                            jArr3 = jArr7;
                            j5 = j6;
                            i6 = i9;
                            int i13 = i5;
                        }
                        j6 = j5 >> i6;
                        i11++;
                        i9 = i6;
                        jArr6 = jArr4;
                        jArr7 = jArr3;
                    }
                    jArr2 = jArr6;
                    jArr = jArr7;
                    int i14 = i9;
                    int i15 = i5;
                    if (i10 != i14) {
                        break;
                    }
                } else {
                    int i16 = i5;
                    jArr2 = jArr6;
                    jArr = jArr7;
                }
                if (i7 == length) {
                    break;
                }
                i7++;
                jArr6 = jArr2;
                jArr7 = jArr;
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

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, p pVar) {
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
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0:
            while (true) {
                long j5 = jArr3[i6];
                int i8 = i6;
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i9 = 8 - ((~(i8 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & 255) < 128) {
                            int i11 = (i8 << 3) + i10;
                            long j6 = jArr[i11];
                            long j7 = jArr2[i11];
                            if (i7 == i5) {
                                sb.append(charSequence8);
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(charSequence5);
                            }
                            sb.append((CharSequence) pVar2.invoke(Long.valueOf(j6), Long.valueOf(j7)));
                            i7++;
                        }
                        j5 >>= 8;
                        i10++;
                        charSequence5 = charSequence;
                    }
                    if (i9 != 8) {
                        break;
                    }
                }
                if (i8 == length) {
                    break;
                }
                i6 = i8 + 1;
                charSequence5 = charSequence;
            }
        }
        sb.append(charSequence7);
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
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
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i7 = 0;
            int i8 = 0;
            loop0:
            while (true) {
                long j5 = jArr3[i7];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i9 = 8;
                    int i10 = 8 - ((~(i7 - length)) >>> 31);
                    int i11 = 0;
                    while (i11 < i10) {
                        if ((j5 & 255) < 128) {
                            int i12 = (i7 << 3) + i11;
                            long j6 = jArr[i12];
                            long j7 = jArr2[i12];
                            i6 = i9;
                            if (i8 == i5) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb.append(charSequence4);
                            }
                            sb.append((CharSequence) pVar2.invoke(Long.valueOf(j6), Long.valueOf(j7)));
                            i8++;
                        } else {
                            i6 = i9;
                            int i13 = i5;
                        }
                        j5 >>= i6;
                        i11++;
                        charSequence4 = charSequence;
                        i9 = i6;
                    }
                    int i14 = i9;
                    int i15 = i5;
                    if (i10 != i14) {
                        break;
                    }
                } else {
                    int i16 = i5;
                }
                if (i7 == length) {
                    break;
                }
                i7++;
                charSequence4 = charSequence;
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
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0:
            while (true) {
                long j5 = jArr3[i6];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i6 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & 255) < 128) {
                            int i11 = (i6 << 3) + i10;
                            long j6 = jArr[i11];
                            long j7 = jArr2[i11];
                            i5 = i8;
                            if (i7 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(charSequence4);
                            }
                            sb.append((CharSequence) pVar2.invoke(Long.valueOf(j6), Long.valueOf(j7)));
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
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0:
            while (true) {
                long j5 = jArr3[i6];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i6 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & 255) < 128) {
                            int i11 = (i6 << 3) + i10;
                            long j6 = jArr[i11];
                            long j7 = jArr2[i11];
                            if (i7 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(charSequence3);
                            }
                            i5 = i8;
                            sb.append((CharSequence) pVar2.invoke(Long.valueOf(j6), Long.valueOf(j7)));
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
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0:
            while (true) {
                long j5 = jArr3[i6];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i6 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & 255) < 128) {
                            int i11 = (i6 << 3) + i10;
                            long j6 = jArr[i11];
                            long j7 = jArr2[i11];
                            i5 = i8;
                            if (i7 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(charSequence2);
                            }
                            sb.append((CharSequence) pVar2.invoke(Long.valueOf(j6), Long.valueOf(j7)));
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
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0:
            while (true) {
                long j5 = jArr3[i6];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i6 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & 255) < 128) {
                            int i11 = (i6 << 3) + i10;
                            long j6 = jArr[i11];
                            long j7 = jArr2[i11];
                            if (i7 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(", ");
                            }
                            Long valueOf = Long.valueOf(j6);
                            i5 = i8;
                            sb.append((CharSequence) pVar2.invoke(valueOf, Long.valueOf(j7)));
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
