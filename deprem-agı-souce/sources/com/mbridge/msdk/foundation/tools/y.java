package com.mbridge.msdk.foundation.tools;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f9751a;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f9752b;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        f9751a = charArray;
        int[] iArr = new int[256];
        f9752b = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i5 = 0; i5 < length; i5++) {
            f9752b[f9751a[i5]] = i5;
        }
        f9752b[61] = 0;
    }

    public static String a(String str) {
        byte[] bArr;
        int i5;
        int i6;
        int i7;
        int i8;
        String str2 = str;
        int length = str2.length();
        if (length == 0) {
            bArr = new byte[0];
        } else {
            int i9 = length - 1;
            int i10 = 0;
            while (i5 < i9 && f9752b[str2.charAt(i5) & 255] < 0) {
                i10 = i5 + 1;
            }
            while (i9 > 0 && f9752b[str2.charAt(i9) & 255] < 0) {
                i9--;
            }
            if (str2.charAt(i9) != '=') {
                i6 = 0;
            } else if (str2.charAt(i9 - 1) == '=') {
                i6 = 2;
            } else {
                i6 = 1;
            }
            int i11 = (i9 - i5) + 1;
            if (length > 76) {
                if (str2.charAt(76) == 13) {
                    i8 = i11 / 78;
                } else {
                    i8 = 0;
                }
                i7 = i8 << 1;
            } else {
                i7 = 0;
            }
            int i12 = (((i11 - i7) * 6) >> 3) - i6;
            byte[] bArr2 = new byte[i12];
            int i13 = (i12 / 3) * 3;
            int i14 = 0;
            int i15 = 0;
            while (i14 < i13) {
                int[] iArr = f9752b;
                int i16 = i5 + 4;
                int i17 = iArr[str2.charAt(i5 + 3)] | (iArr[str2.charAt(i5 + 1)] << 12) | (iArr[str2.charAt(i5)] << 18) | (iArr[str2.charAt(i5 + 2)] << 6);
                bArr2[i14] = (byte) (i17 >> 16);
                int i18 = i14 + 2;
                bArr2[i14 + 1] = (byte) (i17 >> 8);
                i14 += 3;
                bArr2[i18] = (byte) i17;
                if (i7 <= 0 || (i15 = i15 + 1) != 19) {
                    i5 = i16;
                } else {
                    i5 += 6;
                    i15 = 0;
                }
            }
            if (i14 < i12) {
                int i19 = 0;
                int i20 = 0;
                while (i5 <= i9 - i6) {
                    i19 |= f9752b[str2.charAt(i5)] << (18 - (i20 * 6));
                    i20++;
                    i5++;
                }
                int i21 = 16;
                while (i14 < i12) {
                    bArr2[i14] = (byte) (i19 >> i21);
                    i21 -= 8;
                    i14++;
                }
            }
            bArr = bArr2;
        }
        if (bArr.length == 0) {
            return "";
        }
        return new String(bArr, StandardCharsets.UTF_8);
    }
}
