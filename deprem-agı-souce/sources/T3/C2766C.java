package t3;

import kotlin.jvm.internal.t;

/* renamed from: t3.C  reason: case insensitive filesystem */
abstract class C2766C extends C2765B {
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0019 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001a A[LOOP:1: B:8:0x001a->B:11:0x0022, LOOP_START, PHI: r1 
      PHI: (r1v2 int) = (r1v1 int), (r1v3 int) binds: [B:6:0x0017, B:11:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean q(java.lang.String r19) {
        /*
            r0 = r19
            int r1 = r0.length()
            r2 = 1
            int r1 = r1 - r2
            r3 = 0
            r4 = r3
        L_0x000a:
            r5 = 32
            if (r4 > r1) goto L_0x0017
            char r6 = r0.charAt(r4)
            if (r6 > r5) goto L_0x0017
            int r4 = r4 + 1
            goto L_0x000a
        L_0x0017:
            if (r4 <= r1) goto L_0x001a
            return r3
        L_0x001a:
            if (r1 <= r4) goto L_0x0025
            char r6 = r0.charAt(r1)
            if (r6 > r5) goto L_0x0025
            int r1 = r1 + -1
            goto L_0x001a
        L_0x0025:
            char r6 = r0.charAt(r4)
            r7 = 45
            r8 = 43
            if (r6 == r8) goto L_0x0035
            char r6 = r0.charAt(r4)
            if (r6 != r7) goto L_0x0037
        L_0x0035:
            int r4 = r4 + 1
        L_0x0037:
            if (r4 <= r1) goto L_0x003a
            return r3
        L_0x003a:
            char r6 = r0.charAt(r4)
            r9 = 46
            r10 = 10
            r11 = 48
            r12 = 65535(0xffff, float:9.1834E-41)
            r13 = -1
            if (r6 != r11) goto L_0x00c5
            int r6 = r4 + 1
            if (r6 <= r1) goto L_0x004f
            return r2
        L_0x004f:
            char r6 = r0.charAt(r6)
            r6 = r6 | r5
            r14 = 120(0x78, float:1.68E-43)
            if (r6 != r14) goto L_0x00c5
            int r4 = r4 + 2
            r6 = r4
        L_0x005b:
            r14 = 6
            if (r6 > r1) goto L_0x0077
            char r15 = r0.charAt(r6)
            int r16 = r15 + -48
            r17 = r2
            r2 = r16 & r12
            if (r2 >= r10) goto L_0x006b
            goto L_0x0072
        L_0x006b:
            r2 = r15 | 32
            int r2 = r2 + -97
            r2 = r2 & r12
            if (r2 >= r14) goto L_0x0079
        L_0x0072:
            int r6 = r6 + 1
            r2 = r17
            goto L_0x005b
        L_0x0077:
            r17 = r2
        L_0x0079:
            if (r4 == r6) goto L_0x007e
            r2 = r17
            goto L_0x007f
        L_0x007e:
            r2 = r3
        L_0x007f:
            if (r6 <= r1) goto L_0x0085
            r18 = r5
        L_0x0083:
            r4 = r13
            goto L_0x00bc
        L_0x0085:
            char r4 = r0.charAt(r6)
            if (r4 != r9) goto L_0x00b3
            int r6 = r6 + 1
            r4 = r6
        L_0x008e:
            if (r4 > r1) goto L_0x00a9
            char r15 = r0.charAt(r4)
            int r16 = r15 + -48
            r18 = r5
            r5 = r16 & r12
            if (r5 >= r10) goto L_0x009d
            goto L_0x00a4
        L_0x009d:
            r5 = r15 | 32
            int r5 = r5 + -97
            r5 = r5 & r12
            if (r5 >= r14) goto L_0x00ab
        L_0x00a4:
            int r4 = r4 + 1
            r5 = r18
            goto L_0x008e
        L_0x00a9:
            r18 = r5
        L_0x00ab:
            if (r6 == r4) goto L_0x00b0
            r5 = r17
            goto L_0x00b1
        L_0x00b0:
            r5 = r3
        L_0x00b1:
            r6 = r4
            goto L_0x00b6
        L_0x00b3:
            r18 = r5
            r5 = r3
        L_0x00b6:
            if (r2 != 0) goto L_0x00bb
            if (r5 != 0) goto L_0x00bb
            goto L_0x0083
        L_0x00bb:
            r4 = r6
        L_0x00bc:
            if (r4 == r13) goto L_0x00c4
            if (r4 <= r1) goto L_0x00c1
            goto L_0x00c4
        L_0x00c1:
            r2 = r17
            goto L_0x00ca
        L_0x00c4:
            return r3
        L_0x00c5:
            r17 = r2
            r18 = r5
            r2 = r3
        L_0x00ca:
            if (r2 != 0) goto L_0x0128
            r5 = r4
        L_0x00cd:
            if (r5 > r1) goto L_0x00da
            char r6 = r0.charAt(r5)
            int r6 = r6 - r11
            r6 = r6 & r12
            if (r6 >= r10) goto L_0x00da
            int r5 = r5 + 1
            goto L_0x00cd
        L_0x00da:
            if (r4 == r5) goto L_0x00df
            r4 = r17
            goto L_0x00e0
        L_0x00df:
            r4 = r3
        L_0x00e0:
            if (r5 <= r1) goto L_0x00e4
            r4 = r5
            goto L_0x0122
        L_0x00e4:
            char r6 = r0.charAt(r5)
            if (r6 != r9) goto L_0x00ff
            int r5 = r5 + 1
            r6 = r5
        L_0x00ed:
            if (r6 > r1) goto L_0x00fa
            char r9 = r0.charAt(r6)
            int r9 = r9 - r11
            r9 = r9 & r12
            if (r9 >= r10) goto L_0x00fa
            int r6 = r6 + 1
            goto L_0x00ed
        L_0x00fa:
            if (r5 == r6) goto L_0x0100
            r5 = r17
            goto L_0x0101
        L_0x00ff:
            r6 = r5
        L_0x0100:
            r5 = r3
        L_0x0101:
            if (r4 != 0) goto L_0x0121
            if (r5 != 0) goto L_0x0121
            int r4 = r6 + 2
            if (r1 != r4) goto L_0x010c
            java.lang.String r4 = "NaN"
            goto L_0x0114
        L_0x010c:
            int r4 = r6 + 7
            if (r1 != r4) goto L_0x0113
            java.lang.String r4 = "Infinity"
            goto L_0x0114
        L_0x0113:
            r4 = 0
        L_0x0114:
            if (r4 != 0) goto L_0x0118
        L_0x0116:
            r4 = r13
            goto L_0x0122
        L_0x0118:
            int r4 = t3.C2771H.b0(r0, r4, r6, r3)
            if (r4 != r6) goto L_0x0116
            int r4 = r1 + 1
            goto L_0x0122
        L_0x0121:
            r4 = r6
        L_0x0122:
            if (r4 != r13) goto L_0x0125
            return r3
        L_0x0125:
            if (r4 <= r1) goto L_0x0128
            return r17
        L_0x0128:
            int r5 = r4 + 1
            char r6 = r0.charAt(r4)
            r6 = r6 | 32
            if (r2 == 0) goto L_0x0135
            r9 = 112(0x70, float:1.57E-43)
            goto L_0x0137
        L_0x0135:
            r9 = 101(0x65, float:1.42E-43)
        L_0x0137:
            r13 = 100
            r14 = 102(0x66, float:1.43E-43)
            if (r6 == r9) goto L_0x0147
            if (r2 != 0) goto L_0x0146
            if (r6 == r14) goto L_0x0143
            if (r6 != r13) goto L_0x0146
        L_0x0143:
            if (r5 <= r1) goto L_0x0146
            return r17
        L_0x0146:
            return r3
        L_0x0147:
            if (r5 <= r1) goto L_0x014a
            return r3
        L_0x014a:
            char r2 = r0.charAt(r5)
            if (r2 == r8) goto L_0x0156
            char r2 = r0.charAt(r5)
            if (r2 != r7) goto L_0x015b
        L_0x0156:
            int r5 = r4 + 2
            if (r5 <= r1) goto L_0x015b
            return r3
        L_0x015b:
            if (r5 > r1) goto L_0x0168
            char r2 = r0.charAt(r5)
            int r2 = r2 - r11
            r2 = r2 & r12
            if (r2 >= r10) goto L_0x0168
            int r5 = r5 + 1
            goto L_0x015b
        L_0x0168:
            if (r5 <= r1) goto L_0x016b
            return r17
        L_0x016b:
            if (r5 != r1) goto L_0x017a
            char r0 = r0.charAt(r5)
            r0 = r0 | 32
            if (r0 == r14) goto L_0x0179
            if (r0 != r13) goto L_0x0178
            goto L_0x0179
        L_0x0178:
            return r3
        L_0x0179:
            return r17
        L_0x017a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.C2766C.q(java.lang.String):boolean");
    }

    public static Double r(String str) {
        t.e(str, "<this>");
        try {
            if (q(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }
}
