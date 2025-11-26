package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.l6  reason: case insensitive filesystem */
abstract class C1153l6 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f5435a = 0;

    static {
        if (C1126i6.f() && C1126i6.g()) {
            int i5 = C1231u4.f5596a;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(byte[] r6, int r7, int r8) {
        /*
        L_0x0000:
            if (r7 >= r8) goto L_0x0009
            byte r0 = r6[r7]
            if (r0 < 0) goto L_0x0009
            int r7 = r7 + 1
            goto L_0x0000
        L_0x0009:
            if (r7 < r8) goto L_0x000d
            goto L_0x007a
        L_0x000d:
            if (r7 >= r8) goto L_0x007a
            int r0 = r7 + 1
            byte r1 = r6[r7]
            if (r1 >= 0) goto L_0x0078
            r2 = -32
            r3 = -65
            if (r1 >= r2) goto L_0x0029
            if (r0 < r8) goto L_0x001e
            goto L_0x0057
        L_0x001e:
            r2 = -62
            if (r1 < r2) goto L_0x0076
            int r7 = r7 + 2
            byte r0 = r6[r0]
            if (r0 <= r3) goto L_0x000d
            goto L_0x0076
        L_0x0029:
            r4 = -16
            if (r1 >= r4) goto L_0x004f
            int r4 = r8 + -1
            if (r0 < r4) goto L_0x0036
            int r1 = d(r6, r0, r8)
            goto L_0x0057
        L_0x0036:
            int r4 = r7 + 2
            byte r0 = r6[r0]
            if (r0 > r3) goto L_0x0076
            r5 = -96
            if (r1 != r2) goto L_0x0042
            if (r0 < r5) goto L_0x0076
        L_0x0042:
            r2 = -19
            if (r1 != r2) goto L_0x0048
            if (r0 >= r5) goto L_0x0076
        L_0x0048:
            int r7 = r7 + 3
            byte r0 = r6[r4]
            if (r0 <= r3) goto L_0x000d
            goto L_0x0076
        L_0x004f:
            int r2 = r8 + -2
            if (r0 < r2) goto L_0x005a
            int r1 = d(r6, r0, r8)
        L_0x0057:
            if (r1 == 0) goto L_0x007a
            goto L_0x0076
        L_0x005a:
            int r2 = r7 + 2
            byte r0 = r6[r0]
            if (r0 > r3) goto L_0x0076
            int r1 = r1 << 28
            int r0 = r0 + 112
            int r1 = r1 + r0
            int r0 = r1 >> 30
            if (r0 != 0) goto L_0x0076
            int r0 = r7 + 3
            byte r1 = r6[r2]
            if (r1 > r3) goto L_0x0076
            int r7 = r7 + 4
            byte r0 = r6[r0]
            if (r0 > r3) goto L_0x0076
            goto L_0x000d
        L_0x0076:
            r6 = 0
            return r6
        L_0x0078:
            r7 = r0
            goto L_0x000d
        L_0x007a:
            r6 = 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1153l6.a(byte[], int, int):boolean");
    }

    static int b(String str) {
        int length = str.length();
        int i5 = 0;
        int i6 = 0;
        while (i6 < length && str.charAt(i6) < 128) {
            i6++;
        }
        int i7 = length;
        while (true) {
            if (i6 >= length) {
                break;
            }
            char charAt = str.charAt(i6);
            if (charAt < 2048) {
                i7 += (127 - charAt) >>> 31;
                i6++;
            } else {
                int length2 = str.length();
                while (i6 < length2) {
                    char charAt2 = str.charAt(i6);
                    if (charAt2 < 2048) {
                        i5 += (127 - charAt2) >>> 31;
                    } else {
                        i5 += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(str, i6) >= 65536) {
                                i6++;
                            } else {
                                throw new C1144k6(i6, length2);
                            }
                        }
                    }
                    i6++;
                }
                i7 += i5;
            }
        }
        if (i7 >= length) {
            return i7;
        }
        long j5 = ((long) i7) + 4294967296L;
        StringBuilder sb = new StringBuilder(String.valueOf(j5).length() + 34);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j5);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int c(java.lang.String r8, byte[] r9, int r10, int r11) {
        /*
            int r0 = r8.length()
            r1 = 0
        L_0x0005:
            int r2 = r10 + r11
            r3 = 128(0x80, float:1.794E-43)
            if (r1 >= r0) goto L_0x001b
            int r4 = r1 + r10
            if (r4 >= r2) goto L_0x001b
            char r5 = r8.charAt(r1)
            if (r5 >= r3) goto L_0x001b
            byte r2 = (byte) r5
            r9[r4] = r2
            int r1 = r1 + 1
            goto L_0x0005
        L_0x001b:
            if (r1 != r0) goto L_0x001f
            int r10 = r10 + r0
            return r10
        L_0x001f:
            int r10 = r10 + r1
        L_0x0020:
            if (r1 >= r0) goto L_0x0113
            char r11 = r8.charAt(r1)
            if (r11 >= r3) goto L_0x0032
            if (r10 >= r2) goto L_0x0032
            int r4 = r10 + 1
            byte r11 = (byte) r11
            r9[r10] = r11
            r10 = r4
            goto L_0x00b8
        L_0x0032:
            r4 = 2048(0x800, float:2.87E-42)
            if (r11 >= r4) goto L_0x004d
            int r4 = r2 + -2
            if (r10 > r4) goto L_0x004d
            int r4 = r10 + 1
            int r5 = r10 + 2
            int r6 = r11 >>> 6
            r6 = r6 | 960(0x3c0, float:1.345E-42)
            byte r6 = (byte) r6
            r9[r10] = r6
            r10 = r11 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            r9[r4] = r10
            r10 = r5
            goto L_0x00b8
        L_0x004d:
            r4 = 57343(0xdfff, float:8.0355E-41)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r11 < r5) goto L_0x0057
            if (r11 <= r4) goto L_0x0078
        L_0x0057:
            int r6 = r2 + -3
            if (r10 > r6) goto L_0x0078
            int r4 = r10 + 1
            int r5 = r10 + 2
            int r6 = r10 + 3
            int r7 = r11 >>> 12
            r7 = r7 | 480(0x1e0, float:6.73E-43)
            byte r7 = (byte) r7
            r9[r10] = r7
            int r10 = r11 >>> 6
            r10 = r10 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            r9[r4] = r10
            r10 = r11 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            r9[r5] = r10
            r10 = r6
            goto L_0x00b8
        L_0x0078:
            int r6 = r2 + -4
            if (r10 > r6) goto L_0x00c5
            int r4 = r1 + 1
            int r5 = r8.length()
            if (r4 == r5) goto L_0x00bd
            char r1 = r8.charAt(r4)
            boolean r5 = java.lang.Character.isSurrogatePair(r11, r1)
            if (r5 == 0) goto L_0x00bc
            int r5 = r10 + 1
            int r6 = r10 + 2
            int r7 = r10 + 3
            int r11 = java.lang.Character.toCodePoint(r11, r1)
            int r1 = r11 >>> 18
            r1 = r1 | 240(0xf0, float:3.36E-43)
            byte r1 = (byte) r1
            r9[r10] = r1
            int r1 = r11 >>> 12
            r1 = r1 & 63
            r1 = r1 | r3
            byte r1 = (byte) r1
            r9[r5] = r1
            int r1 = r11 >>> 6
            r1 = r1 & 63
            r1 = r1 | r3
            byte r1 = (byte) r1
            r9[r6] = r1
            int r10 = r10 + 4
            r11 = r11 & 63
            r11 = r11 | r3
            byte r11 = (byte) r11
            r9[r7] = r11
            r1 = r4
        L_0x00b8:
            int r1 = r1 + 1
            goto L_0x0020
        L_0x00bc:
            r1 = r4
        L_0x00bd:
            com.google.android.gms.internal.measurement.k6 r8 = new com.google.android.gms.internal.measurement.k6
            int r1 = r1 + -1
            r8.<init>(r1, r0)
            throw r8
        L_0x00c5:
            if (r11 < r5) goto L_0x00e1
            if (r11 > r4) goto L_0x00e1
            int r9 = r1 + 1
            int r2 = r8.length()
            if (r9 == r2) goto L_0x00db
            char r8 = r8.charAt(r9)
            boolean r8 = java.lang.Character.isSurrogatePair(r11, r8)
            if (r8 != 0) goto L_0x00e1
        L_0x00db:
            com.google.android.gms.internal.measurement.k6 r8 = new com.google.android.gms.internal.measurement.k6
            r8.<init>(r1, r0)
            throw r8
        L_0x00e1:
            java.lang.ArrayIndexOutOfBoundsException r8 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.String r9 = java.lang.String.valueOf(r11)
            int r9 = r9.length()
            java.lang.String r0 = java.lang.String.valueOf(r10)
            int r9 = r9 + 25
            int r0 = r0.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r9 = r9 + r0
            r1.<init>(r9)
            java.lang.String r9 = "Failed writing "
            r1.append(r9)
            r1.append(r11)
            java.lang.String r9 = " at index "
            r1.append(r9)
            r1.append(r10)
            java.lang.String r9 = r1.toString()
            r8.<init>(r9)
            throw r8
        L_0x0113:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1153l6.c(java.lang.String, byte[], int, int):int");
    }

    static /* synthetic */ int d(byte[] bArr, int i5, int i6) {
        int i7 = i6 - i5;
        byte b5 = bArr[i5 - 1];
        if (i7 != 0) {
            if (i7 == 1) {
                byte b6 = bArr[i5];
                if (b5 > -12 || b6 > -65) {
                    return -1;
                }
                return (b6 << 8) ^ b5;
            } else if (i7 == 2) {
                byte b7 = bArr[i5];
                byte b8 = bArr[i5 + 1];
                if (b5 > -12 || b7 > -65 || b8 > -65) {
                    return -1;
                }
                return (b8 << 16) ^ ((b7 << 8) ^ b5);
            } else {
                throw new AssertionError();
            }
        } else if (b5 <= -12) {
            return b5;
        } else {
            return -1;
        }
    }
}
