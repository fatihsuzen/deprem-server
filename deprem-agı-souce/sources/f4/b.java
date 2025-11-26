package f4;

import e4.C2356e;
import e4.C2359h;
import kotlin.jvm.internal.t;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f21627a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x018d, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005d, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x009d, code lost:
        return -1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01ac A[EDGE_INSN: B:161:0x01ac->B:158:0x01ac ?: BREAK  
    EDGE_INSN: B:163:0x01ac->B:158:0x01ac ?: BREAK  
    EDGE_INSN: B:180:0x01ac->B:158:0x01ac ?: BREAK  
    EDGE_INSN: B:185:0x01ac->B:158:0x01ac ?: BREAK  
    EDGE_INSN: B:195:0x01ac->B:158:0x01ac ?: BREAK  , RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int c(byte[] r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            int r2 = r0.length
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x0008:
            if (r3 >= r2) goto L_0x01ac
            byte r6 = r0[r3]
            r7 = 65533(0xfffd, float:9.1831E-41)
            r8 = 160(0xa0, float:2.24E-43)
            r9 = 127(0x7f, float:1.78E-43)
            r10 = 32
            r11 = 13
            r12 = 10
            r13 = 65536(0x10000, float:9.18355E-41)
            r16 = -1
            if (r6 < 0) goto L_0x0065
            int r17 = r5 + 1
            if (r5 != r1) goto L_0x0025
            goto L_0x01ac
        L_0x0025:
            if (r6 == r12) goto L_0x0033
            if (r6 == r11) goto L_0x0033
            if (r6 < 0) goto L_0x002e
            if (r6 >= r10) goto L_0x002e
            goto L_0x0035
        L_0x002e:
            if (r9 > r6) goto L_0x0033
            if (r6 >= r8) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            if (r6 != r7) goto L_0x0036
        L_0x0035:
            return r16
        L_0x0036:
            if (r6 >= r13) goto L_0x003a
            r5 = 1
            goto L_0x003b
        L_0x003a:
            r5 = 2
        L_0x003b:
            int r4 = r4 + r5
            int r3 = r3 + 1
        L_0x003e:
            r5 = r17
            if (r3 >= r2) goto L_0x0008
            byte r6 = r0[r3]
            if (r6 < 0) goto L_0x0008
            int r3 = r3 + 1
            int r17 = r5 + 1
            if (r5 != r1) goto L_0x004d
            return r4
        L_0x004d:
            if (r6 == r12) goto L_0x005b
            if (r6 == r11) goto L_0x005b
            if (r6 < 0) goto L_0x0056
            if (r6 >= r10) goto L_0x0056
            goto L_0x005d
        L_0x0056:
            if (r9 > r6) goto L_0x005b
            if (r6 >= r8) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            if (r6 != r7) goto L_0x005e
        L_0x005d:
            return r16
        L_0x005e:
            if (r6 >= r13) goto L_0x0062
            r5 = 1
            goto L_0x0063
        L_0x0062:
            r5 = 2
        L_0x0063:
            int r4 = r4 + r5
            goto L_0x003e
        L_0x0065:
            int r14 = r6 >> 5
            r15 = -2
            r13 = 128(0x80, float:1.794E-43)
            if (r14 != r15) goto L_0x00b2
            int r14 = r3 + 1
            if (r2 > r14) goto L_0x0075
            if (r5 != r1) goto L_0x0074
            goto L_0x01ac
        L_0x0074:
            return r16
        L_0x0075:
            byte r14 = r0[r14]
            r15 = r14 & 192(0xc0, float:2.69E-43)
            if (r15 != r13) goto L_0x00ad
            r14 = r14 ^ 3968(0xf80, float:5.56E-42)
            int r6 = r6 << 6
            r6 = r6 ^ r14
            if (r6 >= r13) goto L_0x0087
            if (r5 != r1) goto L_0x0086
            goto L_0x01ac
        L_0x0086:
            return r16
        L_0x0087:
            int r13 = r5 + 1
            if (r5 != r1) goto L_0x008d
            goto L_0x01ac
        L_0x008d:
            if (r6 == r12) goto L_0x009b
            if (r6 == r11) goto L_0x009b
            if (r6 < 0) goto L_0x0096
            if (r6 >= r10) goto L_0x0096
            goto L_0x009d
        L_0x0096:
            if (r9 > r6) goto L_0x009b
            if (r6 >= r8) goto L_0x009b
            goto L_0x009d
        L_0x009b:
            if (r6 != r7) goto L_0x009e
        L_0x009d:
            return r16
        L_0x009e:
            r5 = 65536(0x10000, float:9.18355E-41)
            if (r6 >= r5) goto L_0x00a4
            r14 = 1
            goto L_0x00a5
        L_0x00a4:
            r14 = 2
        L_0x00a5:
            int r4 = r4 + r14
            W2.J r5 = W2.J.f19942a
            int r3 = r3 + 2
            r5 = r13
            goto L_0x0008
        L_0x00ad:
            if (r5 != r1) goto L_0x00b1
            goto L_0x01ac
        L_0x00b1:
            return r16
        L_0x00b2:
            int r14 = r6 >> 4
            r7 = 57344(0xe000, float:8.0356E-41)
            r8 = 55296(0xd800, float:7.7486E-41)
            if (r14 != r15) goto L_0x0126
            int r14 = r3 + 2
            if (r2 > r14) goto L_0x00c5
            if (r5 != r1) goto L_0x00c4
            goto L_0x01ac
        L_0x00c4:
            return r16
        L_0x00c5:
            int r15 = r3 + 1
            byte r15 = r0[r15]
            r9 = r15 & 192(0xc0, float:2.69E-43)
            if (r9 != r13) goto L_0x0121
            byte r9 = r0[r14]
            r14 = r9 & 192(0xc0, float:2.69E-43)
            if (r14 != r13) goto L_0x011c
            r13 = -123008(0xfffffffffffe1f80, float:NaN)
            r9 = r9 ^ r13
            int r13 = r15 << 6
            r9 = r9 ^ r13
            int r6 = r6 << 12
            r6 = r6 ^ r9
            r9 = 2048(0x800, float:2.87E-42)
            if (r6 >= r9) goto L_0x00e6
            if (r5 != r1) goto L_0x00e5
            goto L_0x01ac
        L_0x00e5:
            return r16
        L_0x00e6:
            if (r8 > r6) goto L_0x00ef
            if (r6 >= r7) goto L_0x00ef
            if (r5 != r1) goto L_0x00ee
            goto L_0x01ac
        L_0x00ee:
            return r16
        L_0x00ef:
            int r7 = r5 + 1
            if (r5 != r1) goto L_0x00f5
            goto L_0x01ac
        L_0x00f5:
            if (r6 == r12) goto L_0x0107
            if (r6 == r11) goto L_0x0107
            if (r6 < 0) goto L_0x00fe
            if (r6 >= r10) goto L_0x00fe
            goto L_0x010c
        L_0x00fe:
            r5 = 127(0x7f, float:1.78E-43)
            if (r5 > r6) goto L_0x0107
            r5 = 160(0xa0, float:2.24E-43)
            if (r6 >= r5) goto L_0x0107
            goto L_0x010c
        L_0x0107:
            r5 = 65533(0xfffd, float:9.1831E-41)
            if (r6 != r5) goto L_0x010d
        L_0x010c:
            return r16
        L_0x010d:
            r5 = 65536(0x10000, float:9.18355E-41)
            if (r6 >= r5) goto L_0x0113
            r14 = 1
            goto L_0x0114
        L_0x0113:
            r14 = 2
        L_0x0114:
            int r4 = r4 + r14
            W2.J r5 = W2.J.f19942a
            int r3 = r3 + 3
        L_0x0119:
            r5 = r7
            goto L_0x0008
        L_0x011c:
            if (r5 != r1) goto L_0x0120
            goto L_0x01ac
        L_0x0120:
            return r16
        L_0x0121:
            if (r5 != r1) goto L_0x0125
            goto L_0x01ac
        L_0x0125:
            return r16
        L_0x0126:
            int r9 = r6 >> 3
            if (r9 != r15) goto L_0x01a8
            int r9 = r3 + 3
            if (r2 > r9) goto L_0x0133
            if (r5 != r1) goto L_0x0132
            goto L_0x01ac
        L_0x0132:
            return r16
        L_0x0133:
            int r14 = r3 + 1
            byte r14 = r0[r14]
            r15 = r14 & 192(0xc0, float:2.69E-43)
            if (r15 != r13) goto L_0x01a4
            int r15 = r3 + 2
            byte r15 = r0[r15]
            r10 = r15 & 192(0xc0, float:2.69E-43)
            if (r10 != r13) goto L_0x01a0
            byte r9 = r0[r9]
            r10 = r9 & 192(0xc0, float:2.69E-43)
            if (r10 != r13) goto L_0x019c
            r10 = 3678080(0x381f80, float:5.154088E-39)
            r9 = r9 ^ r10
            int r10 = r15 << 6
            r9 = r9 ^ r10
            int r10 = r14 << 12
            r9 = r9 ^ r10
            int r6 = r6 << 18
            r6 = r6 ^ r9
            r9 = 1114111(0x10ffff, float:1.561202E-39)
            if (r6 <= r9) goto L_0x015f
            if (r5 != r1) goto L_0x015e
            goto L_0x01ac
        L_0x015e:
            return r16
        L_0x015f:
            if (r8 > r6) goto L_0x0167
            if (r6 >= r7) goto L_0x0167
            if (r5 != r1) goto L_0x0166
            goto L_0x01ac
        L_0x0166:
            return r16
        L_0x0167:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r6 >= r7) goto L_0x016f
            if (r5 != r1) goto L_0x016e
            goto L_0x01ac
        L_0x016e:
            return r16
        L_0x016f:
            int r7 = r5 + 1
            if (r5 != r1) goto L_0x0174
            goto L_0x01ac
        L_0x0174:
            if (r6 == r12) goto L_0x0188
            if (r6 == r11) goto L_0x0188
            if (r6 < 0) goto L_0x017f
            r5 = 32
            if (r6 >= r5) goto L_0x017f
            goto L_0x018d
        L_0x017f:
            r5 = 127(0x7f, float:1.78E-43)
            if (r5 > r6) goto L_0x0188
            r5 = 160(0xa0, float:2.24E-43)
            if (r6 >= r5) goto L_0x0188
            goto L_0x018d
        L_0x0188:
            r5 = 65533(0xfffd, float:9.1831E-41)
            if (r6 != r5) goto L_0x018e
        L_0x018d:
            return r16
        L_0x018e:
            r5 = 65536(0x10000, float:9.18355E-41)
            if (r6 >= r5) goto L_0x0194
            r14 = 1
            goto L_0x0195
        L_0x0194:
            r14 = 2
        L_0x0195:
            int r4 = r4 + r14
            W2.J r5 = W2.J.f19942a
            int r3 = r3 + 4
            goto L_0x0119
        L_0x019c:
            if (r5 != r1) goto L_0x019f
            goto L_0x01ac
        L_0x019f:
            return r16
        L_0x01a0:
            if (r5 != r1) goto L_0x01a3
            goto L_0x01ac
        L_0x01a3:
            return r16
        L_0x01a4:
            if (r5 != r1) goto L_0x01a7
            goto L_0x01ac
        L_0x01a7:
            return r16
        L_0x01a8:
            if (r5 != r1) goto L_0x01ab
            goto L_0x01ac
        L_0x01ab:
            return r16
        L_0x01ac:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: f4.b.c(byte[], int):int");
    }

    public static final void d(C2359h hVar, C2356e eVar, int i5, int i6) {
        t.e(hVar, "<this>");
        t.e(eVar, "buffer");
        eVar.write(hVar.i(), i5, i6);
    }

    /* access modifiers changed from: private */
    public static final int e(char c5) {
        if ('0' <= c5 && c5 < ':') {
            return c5 - '0';
        }
        if ('a' <= c5 && c5 < 'g') {
            return c5 - 'W';
        }
        if ('A' <= c5 && c5 < 'G') {
            return c5 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c5);
    }

    public static final char[] f() {
        return f21627a;
    }
}
