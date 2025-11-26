package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import k3.C2616a;
import k3.l;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class LongObjectMap<V> {
    public int _capacity;
    public int _size;
    public long[] keys;
    public long[] metadata;
    public Object[] values;

    public /* synthetic */ LongObjectMap(C2633k kVar) {
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

    public static /* synthetic */ String joinToString$default(LongObjectMap longObjectMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, int i6, Object obj) {
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
            return longObjectMap.joinToString(charSequence, charSequence2, charSequence3, i7, charSequence5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean all(p pVar) {
        p pVar2 = pVar;
        t.e(pVar2, "predicate");
        long[] jArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return true;
        }
        int i5 = 0;
        while (true) {
            long j5 = jArr2[i5];
            if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j5) < 128) {
                        int i8 = (i5 << 3) + i7;
                        if (!((Boolean) pVar2.invoke(Long.valueOf(jArr[i8]), objArr[i8])).booleanValue()) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0066, code lost:
        if (((r6 & ((~r6) << 6)) & -9187201950435737472L) == 0) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0068, code lost:
        r10 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean contains(long r18) {
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
            long[] r14 = r0.keys
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
            if (r6 == 0) goto L_0x006d
            r10 = -1
        L_0x0069:
            if (r10 < 0) goto L_0x006c
            return r11
        L_0x006c:
            return r4
        L_0x006d:
            int r5 = r5 + 8
            int r1 = r1 + r5
            r1 = r1 & r3
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.contains(long):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0066, code lost:
        if (((r6 & ((~r6) << 6)) & -9187201950435737472L) == 0) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0068, code lost:
        r10 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean containsKey(long r18) {
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
            long[] r14 = r0.keys
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
            if (r6 == 0) goto L_0x006d
            r10 = -1
        L_0x0069:
            if (r10 < 0) goto L_0x006c
            return r11
        L_0x006c:
            return r4
        L_0x006d:
            int r5 = r5 + 8
            int r1 = r1 + r5
            r1 = r1 & r3
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.containsKey(long):boolean");
    }

    public final boolean containsValue(V v5) {
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128 && t.a(v5, objArr[(i5 << 3) + i7])) {
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
            boolean r3 = r1 instanceof androidx.collection.LongObjectMap
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            androidx.collection.LongObjectMap r1 = (androidx.collection.LongObjectMap) r1
            int r3 = r1.getSize()
            int r5 = r0.getSize()
            if (r3 == r5) goto L_0x001b
            return r4
        L_0x001b:
            long[] r3 = r0.keys
            java.lang.Object[] r5 = r0.values
            long[] r6 = r0.metadata
            int r7 = r6.length
            int r7 = r7 + -2
            if (r7 < 0) goto L_0x008b
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
            if (r11 == 0) goto L_0x0080
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r4
        L_0x0041:
            if (r13 >= r11) goto L_0x007a
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.32E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L_0x0070
            int r14 = r8 << 3
            int r14 = r14 + r13
            r15 = r2
            r16 = r3
            r2 = r16[r14]
            r14 = r5[r14]
            if (r14 != 0) goto L_0x0065
            java.lang.Object r14 = r1.get(r2)
            if (r14 != 0) goto L_0x0064
            boolean r2 = r1.containsKey(r2)
            if (r2 != 0) goto L_0x0073
        L_0x0064:
            return r4
        L_0x0065:
            java.lang.Object r2 = r1.get(r2)
            boolean r2 = kotlin.jvm.internal.t.a(r14, r2)
            if (r2 != 0) goto L_0x0073
            return r4
        L_0x0070:
            r15 = r2
            r16 = r3
        L_0x0073:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            r2 = r15
            r3 = r16
            goto L_0x0041
        L_0x007a:
            r15 = r2
            r16 = r3
            if (r11 != r12) goto L_0x008c
            goto L_0x0083
        L_0x0080:
            r15 = r2
            r16 = r3
        L_0x0083:
            if (r8 == r7) goto L_0x008c
            int r8 = r8 + 1
            r2 = r15
            r3 = r16
            goto L_0x0027
        L_0x008b:
            r15 = r2
        L_0x008c:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.equals(java.lang.Object):boolean");
    }

    public final int findKeyIndex$collection(long j5) {
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
        Object[] objArr = this.values;
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
                            int i8 = (i5 << 3) + i7;
                            pVar2.invoke(Long.valueOf(jArr[i8]), objArr[i8]);
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
        Object[] objArr = this.values;
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

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0063, code lost:
        if (((r4 & ((~r4) << 6)) & -9187201950435737472L) == 0) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0065, code lost:
        r10 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(long r15) {
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
            long[] r11 = r14.keys
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
            if (r4 == 0) goto L_0x006f
            r10 = -1
        L_0x0066:
            if (r10 < 0) goto L_0x006d
            java.lang.Object[] r0 = r14.values
            r0 = r0[r10]
            return r0
        L_0x006d:
            r0 = 0
            return r0
        L_0x006f:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L_0x0013
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.get(long):java.lang.Object");
    }

    public final int getCapacity() {
        return this._capacity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0063, code lost:
        if (((r4 & ((~r4) << 6)) & -9187201950435737472L) == 0) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0065, code lost:
        r10 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V getOrDefault(long r15, V r17) {
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
            long[] r11 = r14.keys
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
            if (r4 == 0) goto L_0x006e
            r10 = -1
        L_0x0066:
            if (r10 < 0) goto L_0x006d
            java.lang.Object[] r0 = r14.values
            r0 = r0[r10]
            return r0
        L_0x006d:
            return r17
        L_0x006e:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L_0x0013
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.getOrDefault(long, java.lang.Object):java.lang.Object");
    }

    public final V getOrElse(long j5, C2616a aVar) {
        t.e(aVar, "defaultValue");
        V v5 = get(j5);
        if (v5 == null) {
            return aVar.invoke();
        }
        return v5;
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int i5;
        long[] jArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i6 = 0;
        int i7 = 0;
        while (true) {
            long j5 = jArr2[i6];
            if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                int i8 = 8 - ((~(i6 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j5) < 128) {
                        int i10 = (i6 << 3) + i9;
                        long j6 = jArr[i10];
                        Object obj = objArr[i10];
                        int a5 = a.a(j6);
                        if (obj != null) {
                            i5 = obj.hashCode();
                        } else {
                            i5 = 0;
                        }
                        i7 += i5 ^ a5;
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
        int i5;
        int i6;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        long[] jArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i7 = 0;
            int i8 = 0;
            while (true) {
                long j5 = jArr2[i7];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i9 = 8 - ((~(i7 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((255 & j5) < 128) {
                            int i11 = (i7 << 3) + i10;
                            i6 = i7;
                            long j6 = jArr[i11];
                            Object obj = objArr[i11];
                            sb.append(j6);
                            sb.append("=");
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            i8++;
                            if (i8 < this._size) {
                                sb.append(',');
                                sb.append(' ');
                            }
                        } else {
                            i6 = i7;
                        }
                        j5 >>= 8;
                        i10++;
                        i7 = i6;
                    }
                    int i12 = i7;
                    if (i9 != 8) {
                        break;
                    }
                    i5 = i12;
                } else {
                    i5 = i7;
                }
                if (i5 == length) {
                    break;
                }
                i7 = i5 + 1;
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        t.d(sb2, "s.append('}').toString()");
        return sb2;
    }

    private LongObjectMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = LongSetKt.getEmptyLongArray();
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    public final boolean any(p pVar) {
        p pVar2 = pVar;
        t.e(pVar2, "predicate");
        long[] jArr = this.keys;
        Object[] objArr = this.values;
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
                            int i8 = (i5 << 3) + i7;
                            if (((Boolean) pVar2.invoke(Long.valueOf(jArr[i8]), objArr[i8])).booleanValue()) {
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
        Object[] objArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            long j5 = jArr2[i5];
            if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                int i7 = 8 - ((~(i5 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j5) < 128) {
                        int i9 = (i5 << 3) + i8;
                        if (((Boolean) pVar2.invoke(Long.valueOf(jArr[i9]), objArr[i9])).booleanValue()) {
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

    public static /* synthetic */ String joinToString$default(LongObjectMap longObjectMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, p pVar, int i6, Object obj) {
        long[] jArr;
        int i7;
        long[] jArr2;
        LongObjectMap longObjectMap2 = longObjectMap;
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
            long[] jArr3 = longObjectMap2.keys;
            Object[] objArr = longObjectMap2.values;
            long[] jArr4 = longObjectMap2.metadata;
            int length = jArr4.length - 2;
            if (length >= 0) {
                int i9 = 0;
                int i10 = 0;
                loop0:
                while (true) {
                    long j5 = jArr4[i9];
                    int i11 = i9;
                    if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                        int i12 = 8;
                        int i13 = 8 - ((~(i11 - length)) >>> 31);
                        int i14 = 0;
                        while (i14 < i13) {
                            if ((j5 & 255) < 128) {
                                int i15 = (i11 << 3) + i14;
                                long j6 = jArr3[i15];
                                i7 = i12;
                                Object obj2 = objArr[i15];
                                if (i10 == i8) {
                                    sb.append(str2);
                                    break loop0;
                                }
                                if (i10 != 0) {
                                    sb.append(str);
                                }
                                jArr2 = jArr4;
                                sb.append((CharSequence) pVar2.invoke(Long.valueOf(j6), obj2));
                                i10++;
                            } else {
                                jArr2 = jArr4;
                                i7 = i12;
                            }
                            j5 >>= i7;
                            i14++;
                            i12 = i7;
                            jArr4 = jArr2;
                        }
                        jArr = jArr4;
                        if (i13 != i12) {
                            break;
                        }
                    } else {
                        jArr = jArr4;
                    }
                    int i16 = i11;
                    if (i16 == length) {
                        break;
                    }
                    i9 = i16 + 1;
                    jArr4 = jArr;
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
        long[] jArr;
        Object[] objArr;
        int i6;
        long[] jArr2;
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
        long[] jArr3 = this.keys;
        Object[] objArr3 = this.values;
        long[] jArr4 = this.metadata;
        int length = jArr4.length - 2;
        if (length >= 0) {
            int i7 = 0;
            int i8 = 0;
            loop0:
            while (true) {
                long j5 = jArr4[i7];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i9 = 8;
                    int i10 = 8 - ((~(i7 - length)) >>> 31);
                    int i11 = 0;
                    while (i11 < i10) {
                        if ((j5 & 255) < 128) {
                            int i12 = (i7 << 3) + i11;
                            objArr2 = objArr3;
                            jArr2 = jArr4;
                            long j6 = jArr3[i12];
                            i6 = i9;
                            Object obj = objArr2[i12];
                            if (i8 == i5) {
                                sb.append(charSequence8);
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb.append(charSequence5);
                            }
                            sb.append(j6);
                            sb.append('=');
                            sb.append(obj);
                            i8++;
                        } else {
                            int i13 = i5;
                            objArr2 = objArr3;
                            jArr2 = jArr4;
                            i6 = i9;
                        }
                        j5 >>= i6;
                        i11++;
                        objArr3 = objArr2;
                        jArr4 = jArr2;
                        i9 = i6;
                    }
                    int i14 = i5;
                    objArr = objArr3;
                    jArr = jArr4;
                    if (i10 != i9) {
                        break;
                    }
                } else {
                    int i15 = i5;
                    objArr = objArr3;
                    jArr = jArr4;
                }
                if (i7 == length) {
                    break;
                }
                i7++;
                objArr3 = objArr;
                jArr4 = jArr;
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
        long[] jArr;
        long[] jArr2;
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
        long[] jArr3 = this.keys;
        Object[] objArr = this.values;
        long[] jArr4 = this.metadata;
        int length = jArr4.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0:
            while (true) {
                long j5 = jArr4[i6];
                int i8 = i6;
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i9 = 8 - ((~(i8 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & 255) < 128) {
                            int i11 = (i8 << 3) + i10;
                            long j6 = jArr3[i11];
                            Object obj = objArr[i11];
                            jArr2 = jArr3;
                            if (i7 == i5) {
                                sb.append(charSequence8);
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(charSequence5);
                            }
                            sb.append((CharSequence) pVar2.invoke(Long.valueOf(j6), obj));
                            i7++;
                        } else {
                            jArr2 = jArr3;
                            int i12 = i5;
                        }
                        j5 >>= 8;
                        i10++;
                        charSequence5 = charSequence;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    int i13 = i5;
                    if (i9 != 8) {
                        break;
                    }
                } else {
                    jArr = jArr3;
                    int i14 = i5;
                }
                if (i8 == length) {
                    break;
                }
                i6 = i8 + 1;
                charSequence5 = charSequence;
                jArr3 = jArr;
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
        long[] jArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i7 = 0;
            int i8 = 0;
            loop0:
            while (true) {
                long j5 = jArr2[i7];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i9 = 8;
                    int i10 = 8 - ((~(i7 - length)) >>> 31);
                    int i11 = 0;
                    while (i11 < i10) {
                        if ((j5 & 255) < 128) {
                            int i12 = (i7 << 3) + i11;
                            long j6 = jArr[i12];
                            i6 = i9;
                            Object obj = objArr[i12];
                            if (i8 == i5) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb.append(charSequence4);
                            }
                            sb.append((CharSequence) pVar2.invoke(Long.valueOf(j6), obj));
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
        long[] jArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0:
            while (true) {
                long j5 = jArr2[i6];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i6 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & 255) < 128) {
                            int i11 = (i6 << 3) + i10;
                            long j6 = jArr[i11];
                            i5 = i8;
                            Object obj = objArr[i11];
                            if (i7 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(charSequence4);
                            }
                            sb.append((CharSequence) pVar2.invoke(Long.valueOf(j6), obj));
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
        Object[] objArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0:
            while (true) {
                long j5 = jArr2[i6];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i6 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & 255) < 128) {
                            int i11 = (i6 << 3) + i10;
                            long j6 = jArr[i11];
                            Object obj = objArr[i11];
                            i5 = i8;
                            if (i7 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(charSequence3);
                            }
                            sb.append((CharSequence) pVar2.invoke(Long.valueOf(j6), obj));
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
        Object[] objArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0:
            while (true) {
                long j5 = jArr2[i6];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i6 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & 255) < 128) {
                            int i11 = (i6 << 3) + i10;
                            long j6 = jArr[i11];
                            i5 = i8;
                            Object obj = objArr[i11];
                            if (i7 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(charSequence2);
                            }
                            sb.append((CharSequence) pVar2.invoke(Long.valueOf(j6), obj));
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
        Object[] objArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0:
            while (true) {
                long j5 = jArr2[i6];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i6 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & 255) < 128) {
                            int i11 = (i6 << 3) + i10;
                            long j6 = jArr[i11];
                            Object obj = objArr[i11];
                            i5 = i8;
                            if (i7 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(", ");
                            }
                            sb.append((CharSequence) pVar2.invoke(Long.valueOf(j6), obj));
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
