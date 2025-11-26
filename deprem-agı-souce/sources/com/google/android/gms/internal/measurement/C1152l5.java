package com.google.android.gms.internal.measurement;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.measurement.l5  reason: case insensitive filesystem */
public abstract class C1152l5 {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f5433a = Charset.forName(C.UTF8_NAME);

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f5434b;

    static {
        Charset.forName(C.ASCII_NAME);
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f5434b = bArr;
        ByteBuffer.wrap(bArr);
        int i5 = J4.f5000a;
        try {
            new I4(bArr, 0, 0, false, (byte[]) null).c(0);
        } catch (C1170n5 e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    static Object a(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("messageType");
    }

    public static int b(boolean z4) {
        return z4 ? 1231 : 1237;
    }

    static int c(int i5, byte[] bArr, int i6, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            i5 = (i5 * 31) + bArr[i8];
        }
        return i5;
    }

    static boolean d(F5 f5) {
        return false;
    }
}
