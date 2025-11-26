package com.google.android.gms.common.util;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f4881a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f4882b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length + length)];
        int i5 = 0;
        for (byte b5 : bArr) {
            char[] cArr2 = f4882b;
            cArr[i5] = cArr2[(b5 & 255) >>> 4];
            cArr[i5 + 1] = cArr2[b5 & 15];
            i5 += 2;
        }
        return new String(cArr);
    }

    public static String b(byte[] bArr, boolean z4) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        int i5 = 0;
        while (i5 < length && (!z4 || i5 != length - 1 || (bArr[i5] & 255) != 0)) {
            char[] cArr = f4881a;
            sb.append(cArr[(bArr[i5] & 240) >>> 4]);
            sb.append(cArr[bArr[i5] & 15]);
            i5++;
        }
        return sb.toString();
    }
}
