package com.mbridge.msdk.thrid.okio;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.UnsupportedEncodingException;

final class Base64 {
    private static final byte[] MAP = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_MAP = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    private Base64() {
    }

    public static byte[] decode(String str) {
        int i5;
        int length = str.length();
        while (length > 0 && ((r5 = str.charAt(length - 1)) == '=' || r5 == 10 || r5 == 13 || r5 == ' ' || r5 == 9)) {
            length--;
        }
        int i6 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i6];
        int i7 = 0;
        byte b5 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            char charAt = str.charAt(i9);
            if (charAt >= 'A' && charAt <= 'Z') {
                i5 = charAt - 'A';
            } else if (charAt >= 'a' && charAt <= 'z') {
                i5 = charAt - 'G';
            } else if (charAt >= '0' && charAt <= '9') {
                i5 = charAt + 4;
            } else if (charAt == '+' || charAt == '-') {
                i5 = 62;
            } else if (charAt == '/' || charAt == '_') {
                i5 = 63;
            } else {
                if (!(charAt == 10 || charAt == 13 || charAt == ' ' || charAt == 9)) {
                    return null;
                }
            }
            b5 = (b5 << 6) | ((byte) i5);
            i7++;
            if (i7 % 4 == 0) {
                bArr[i8] = (byte) (b5 >> 16);
                int i10 = i8 + 2;
                bArr[i8 + 1] = (byte) (b5 >> 8);
                i8 += 3;
                bArr[i10] = (byte) b5;
            }
        }
        int i11 = i7 % 4;
        if (i11 == 1) {
            return null;
        }
        if (i11 == 2) {
            bArr[i8] = (byte) ((b5 << 12) >> 16);
            i8++;
        } else if (i11 == 3) {
            int i12 = b5 << 6;
            int i13 = i8 + 1;
            bArr[i8] = (byte) (i12 >> 16);
            i8 += 2;
            bArr[i13] = (byte) (i12 >> 8);
        }
        if (i8 == i6) {
            return bArr;
        }
        byte[] bArr2 = new byte[i8];
        System.arraycopy(bArr, 0, bArr2, 0, i8);
        return bArr2;
    }

    public static String encode(byte[] bArr) {
        return encode(bArr, MAP);
    }

    public static String encodeUrl(byte[] bArr) {
        return encode(bArr, URL_MAP);
    }

    private static String encode(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6 += 3) {
            bArr3[i5] = bArr2[(bArr[i6] & 255) >> 2];
            int i7 = i6 + 1;
            bArr3[i5 + 1] = bArr2[((bArr[i6] & 3) << 4) | ((bArr[i7] & 255) >> 4)];
            int i8 = i5 + 3;
            int i9 = i6 + 2;
            bArr3[i5 + 2] = bArr2[((bArr[i7] & 15) << 2) | ((bArr[i9] & 255) >> 6)];
            i5 += 4;
            bArr3[i8] = bArr2[bArr[i9] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            bArr3[i5] = bArr2[(bArr[length] & 255) >> 2];
            bArr3[i5 + 1] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i5 + 2] = 61;
            bArr3[i5 + 3] = 61;
        } else if (length2 == 2) {
            bArr3[i5] = bArr2[(bArr[length] & 255) >> 2];
            int i10 = length + 1;
            bArr3[i5 + 1] = bArr2[((bArr[i10] & 255) >> 4) | ((bArr[length] & 3) << 4)];
            bArr3[i5 + 2] = bArr2[(bArr[i10] & 15) << 2];
            bArr3[i5 + 3] = 61;
        }
        try {
            return new String(bArr3, C.ASCII_NAME);
        } catch (UnsupportedEncodingException e5) {
            throw new AssertionError(e5);
        }
    }
}
