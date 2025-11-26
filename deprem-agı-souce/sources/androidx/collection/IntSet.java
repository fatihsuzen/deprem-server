package androidx.collection;

import androidx.annotation.IntRange;
import java.util.NoSuchElementException;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class IntSet {
    public int _capacity;
    public int _size;
    public int[] elements;
    public long[] metadata;

    public /* synthetic */ IntSet(C2633k kVar) {
        this();
    }

    public static /* synthetic */ void getElements$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ String joinToString$default(IntSet intSet, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, int i6, Object obj) {
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
            return intSet.joinToString(charSequence, charSequence2, charSequence3, i7, charSequence5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean all(l lVar) {
        t.e(lVar, "predicate");
        int[] iArr = this.elements;
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
                    if ((255 & j5) < 128 && !((Boolean) lVar.invoke(Integer.valueOf(iArr[(i5 << 3) + i7]))).booleanValue()) {
                        return false;
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

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0062, code lost:
        if (((r7 & ((~r7) << 6)) & -9187201950435737472L) == 0) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0064, code lost:
        r11 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean contains(int r18) {
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
            int[] r15 = r0.elements
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
            if (r7 == 0) goto L_0x0069
            r11 = -1
        L_0x0065:
            if (r11 < 0) goto L_0x0068
            return r12
        L_0x0068:
            return r5
        L_0x0069:
            int r6 = r6 + 8
            int r2 = r2 + r6
            r2 = r2 & r4
            goto L_0x0014
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntSet.contains(int):boolean");
    }

    @IntRange(from = 0)
    public final int count() {
        return this._size;
    }

    /* JADX WARNING: type inference failed for: r18v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 1
            if (r1 != r0) goto L_0x0008
            return r2
        L_0x0008:
            boolean r3 = r1 instanceof androidx.collection.IntSet
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            androidx.collection.IntSet r1 = (androidx.collection.IntSet) r1
            int r3 = r1._size
            int r5 = r0._size
            if (r3 == r5) goto L_0x0017
            return r4
        L_0x0017:
            int[] r3 = r0.elements
            long[] r5 = r0.metadata
            int r6 = r5.length
            int r6 = r6 + -2
            if (r6 < 0) goto L_0x005d
            r7 = r4
        L_0x0021:
            r8 = r5[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L_0x0058
            int r10 = r7 - r6
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r4
        L_0x003b:
            if (r12 >= r10) goto L_0x0056
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.32E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L_0x0052
            int r13 = r7 << 3
            int r13 = r13 + r12
            r13 = r3[r13]
            boolean r13 = r1.contains(r13)
            if (r13 != 0) goto L_0x0052
            return r4
        L_0x0052:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L_0x003b
        L_0x0056:
            if (r10 != r11) goto L_0x005d
        L_0x0058:
            if (r7 == r6) goto L_0x005d
            int r7 = r7 + 1
            goto L_0x0021
        L_0x005d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntSet.equals(java.lang.Object):boolean");
    }

    public final int findElementIndex$collection(int i5) {
        int i6 = ScatterMapKt.MurmurHashC1 * i5;
        int i7 = i6 ^ (i6 << 16);
        int i8 = i7 & 127;
        int i9 = this._capacity;
        int i10 = (i7 >>> 7) & i9;
        int i11 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i12 = i10 >> 3;
            int i13 = (i10 & 7) << 3;
            long j5 = ((jArr[i12 + 1] << (64 - i13)) & ((-((long) i13)) >> 63)) | (jArr[i12] >>> i13);
            long j6 = (((long) i8) * ScatterMapKt.BitmaskLsb) ^ j5;
            for (long j7 = (~j6) & (j6 - ScatterMapKt.BitmaskLsb) & -9187201950435737472L; j7 != 0; j7 &= j7 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j7) >> 3) + i10) & i9;
                if (this.elements[numberOfTrailingZeros] == i5) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j5 & ((~j5) << 6) & -9187201950435737472L) != 0) {
                return -1;
            }
            i11 += 8;
            i10 = (i10 + i11) & i9;
        }
    }

    public final int first() {
        int[] iArr = this.elements;
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
                            return iArr[(i5 << 3) + i7];
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
        throw new NoSuchElementException("The IntSet is empty");
    }

    public final void forEach(l lVar) {
        t.e(lVar, "block");
        int[] iArr = this.elements;
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

    public final void forEachIndex(l lVar) {
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

    @IntRange(from = 0)
    public final int getCapacity() {
        return this._capacity;
    }

    @IntRange(from = 0)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int[] iArr = this.elements;
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
                        i6 += iArr[(i5 << 3) + i8];
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
        return joinToString$default(this, (CharSequence) null, "[", "]", 0, (CharSequence) null, 25, (Object) null);
    }

    private IntSet() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = IntSetKt.getEmptyIntArray();
    }

    public final boolean any(l lVar) {
        t.e(lVar, "predicate");
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128 && ((Boolean) lVar.invoke(Integer.valueOf(iArr[(i5 << 3) + i7]))).booleanValue()) {
                            return true;
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

    @IntRange(from = 0)
    public final int count(l lVar) {
        l lVar2 = lVar;
        t.e(lVar2, "predicate");
        int[] iArr = this.elements;
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
                    if ((255 & j5) < 128 && ((Boolean) lVar2.invoke(Integer.valueOf(iArr[(i5 << 3) + i8]))).booleanValue()) {
                        i6++;
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

    public static /* synthetic */ String joinToString$default(IntSet intSet, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar, int i6, Object obj) {
        int i7;
        IntSet intSet2 = intSet;
        l lVar2 = lVar;
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
            t.e(lVar2, "transform");
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence6);
            int[] iArr = intSet2.elements;
            long[] jArr = intSet2.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i9 = 0;
                int i10 = 0;
                loop0:
                while (true) {
                    long j5 = jArr[i9];
                    if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                        int i11 = 8;
                        int i12 = 8 - ((~(i9 - length)) >>> 31);
                        int i13 = 0;
                        while (i13 < i12) {
                            if ((j5 & 255) < 128) {
                                int i14 = iArr[(i9 << 3) + i13];
                                if (i10 == i8) {
                                    sb.append(str2);
                                    break loop0;
                                }
                                if (i10 != 0) {
                                    sb.append(str);
                                }
                                i7 = i11;
                                sb.append((CharSequence) lVar2.invoke(Integer.valueOf(i14)));
                                i10++;
                            } else {
                                i7 = i11;
                            }
                            j5 >>= i7;
                            i13++;
                            i11 = i7;
                        }
                        if (i12 != i11) {
                            break;
                        }
                    }
                    if (i9 == length) {
                        break;
                    }
                    i9++;
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
        int[] iArr = this.elements;
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
                            int i12 = iArr[(i7 << 3) + i11];
                            i6 = i9;
                            if (i8 == i5) {
                                sb.append(charSequence8);
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb.append(charSequence5);
                            }
                            sb.append(i12);
                            i8++;
                        } else {
                            i6 = i9;
                            int i13 = i5;
                        }
                        j5 >>= i6;
                        i11++;
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
            }
        }
        sb.append(charSequence7);
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final int first(l lVar) {
        t.e(lVar, "predicate");
        int[] iArr = this.elements;
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
                            int i8 = iArr[(i5 << 3) + i7];
                            if (((Boolean) lVar.invoke(Integer.valueOf(i8))).booleanValue()) {
                                return i8;
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
        throw new NoSuchElementException("Could not find a match");
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar) {
        int i6;
        CharSequence charSequence5 = charSequence;
        CharSequence charSequence6 = charSequence2;
        CharSequence charSequence7 = charSequence3;
        CharSequence charSequence8 = charSequence4;
        l lVar2 = lVar;
        t.e(charSequence5, "separator");
        t.e(charSequence6, "prefix");
        t.e(charSequence7, "postfix");
        t.e(charSequence8, "truncated");
        t.e(lVar2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence6);
        int[] iArr = this.elements;
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
                            int i12 = iArr[(i7 << 3) + i11];
                            i6 = i9;
                            if (i8 == i5) {
                                sb.append(charSequence8);
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb.append(charSequence5);
                            }
                            sb.append((CharSequence) lVar2.invoke(Integer.valueOf(i12)));
                            i8++;
                        } else {
                            i6 = i9;
                            int i13 = i5;
                        }
                        j5 >>= i6;
                        i11++;
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
            }
        }
        sb.append(charSequence7);
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, l lVar) {
        int i6;
        CharSequence charSequence4 = charSequence;
        CharSequence charSequence5 = charSequence2;
        CharSequence charSequence6 = charSequence3;
        l lVar2 = lVar;
        t.e(charSequence4, "separator");
        t.e(charSequence5, "prefix");
        t.e(charSequence6, "postfix");
        t.e(lVar2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence5);
        int[] iArr = this.elements;
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
                            int i12 = iArr[(i7 << 3) + i11];
                            if (i8 == i5) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb.append(charSequence4);
                            }
                            i6 = i9;
                            sb.append((CharSequence) lVar2.invoke(Integer.valueOf(i12)));
                            i8++;
                        } else {
                            int i13 = i5;
                            i6 = i9;
                        }
                        j5 >>= i6;
                        i11++;
                        i9 = i6;
                    }
                    int i14 = i5;
                    if (i10 != i9) {
                        break;
                    }
                } else {
                    int i15 = i5;
                }
                if (i7 == length) {
                    break;
                }
                i7++;
            }
            String sb2 = sb.toString();
            t.d(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        sb.append(charSequence6);
        String sb22 = sb.toString();
        t.d(sb22, "StringBuilder().apply(builderAction).toString()");
        return sb22;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, l lVar) {
        CharSequence charSequence4 = charSequence;
        CharSequence charSequence5 = charSequence2;
        CharSequence charSequence6 = charSequence3;
        l lVar2 = lVar;
        t.e(charSequence4, "separator");
        t.e(charSequence5, "prefix");
        t.e(charSequence6, "postfix");
        t.e(lVar2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence5);
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            int i6 = 0;
            loop0:
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((j5 & 255) < 128) {
                            int i9 = iArr[(i5 << 3) + i8];
                            if (i6 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i6 != 0) {
                                sb.append(charSequence4);
                            }
                            sb.append((CharSequence) lVar2.invoke(Integer.valueOf(i9)));
                            i6++;
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
            String sb2 = sb.toString();
            t.d(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        sb.append(charSequence6);
        String sb22 = sb.toString();
        t.d(sb22, "StringBuilder().apply(builderAction).toString()");
        return sb22;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, l lVar) {
        CharSequence charSequence3 = charSequence;
        CharSequence charSequence4 = charSequence2;
        l lVar2 = lVar;
        t.e(charSequence3, "separator");
        t.e(charSequence4, "prefix");
        t.e(lVar2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence4);
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            int i6 = 0;
            loop0:
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((255 & j5) < 128) {
                            int i9 = iArr[(i5 << 3) + i8];
                            if (i6 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i6 != 0) {
                                sb.append(charSequence3);
                            }
                            sb.append((CharSequence) lVar2.invoke(Integer.valueOf(i9)));
                            i6++;
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
        sb.append("");
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(CharSequence charSequence, l lVar) {
        CharSequence charSequence2 = charSequence;
        l lVar2 = lVar;
        t.e(charSequence2, "separator");
        t.e(lVar2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            int i6 = 0;
            loop0:
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((j5 & 255) < 128) {
                            int i9 = iArr[(i5 << 3) + i8];
                            if (i6 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i6 != 0) {
                                sb.append(charSequence2);
                            }
                            sb.append((CharSequence) lVar2.invoke(Integer.valueOf(i9)));
                            i6++;
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
        sb.append("");
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(l lVar) {
        l lVar2 = lVar;
        t.e(lVar2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            int i6 = 0;
            loop0:
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((255 & j5) < 128) {
                            int i9 = iArr[(i5 << 3) + i8];
                            if (i6 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i6 != 0) {
                                sb.append(", ");
                            }
                            sb.append((CharSequence) lVar2.invoke(Integer.valueOf(i9)));
                            i6++;
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
        sb.append("");
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
