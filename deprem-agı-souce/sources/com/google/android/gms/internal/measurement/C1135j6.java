package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.j6  reason: case insensitive filesystem */
abstract class C1135j6 {
    static /* synthetic */ boolean a(byte b5) {
        return b5 >= 0;
    }

    static /* synthetic */ void b(byte b5, byte b6, char[] cArr, int i5) {
        if (b5 < -62 || e(b6)) {
            throw new C1170n5("Protocol message had invalid UTF-8.");
        }
        cArr[i5] = (char) (((b5 & 31) << 6) | (b6 & 63));
    }

    static /* synthetic */ void c(byte b5, byte b6, byte b7, char[] cArr, int i5) {
        if (!e(b6)) {
            if (b5 == -32) {
                if (b6 >= -96) {
                    b5 = -32;
                }
            }
            if (b5 == -19) {
                if (b6 < -96) {
                    b5 = -19;
                }
            }
            if (!e(b7)) {
                cArr[i5] = (char) (((b5 & 15) << 12) | ((b6 & 63) << 6) | (b7 & 63));
                return;
            }
        }
        throw new C1170n5("Protocol message had invalid UTF-8.");
    }

    static /* synthetic */ void d(byte b5, byte b6, byte b7, byte b8, char[] cArr, int i5) {
        if (e(b6) || (((b5 << 28) + (b6 + 112)) >> 30) != 0 || e(b7) || e(b8)) {
            throw new C1170n5("Protocol message had invalid UTF-8.");
        }
        byte b9 = ((b5 & 7) << 18) | ((b6 & 63) << 12) | ((b7 & 63) << 6) | (b8 & 63);
        cArr[i5] = (char) ((b9 >>> 10) + 55232);
        cArr[i5 + 1] = (char) ((b9 & 1023) + 56320);
    }

    private static boolean e(byte b5) {
        return b5 > -65;
    }
}
