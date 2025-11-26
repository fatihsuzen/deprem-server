package com.mbridge.msdk.thrid.okio;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.charset.Charset;

final class Util {
    public static final Charset UTF_8 = Charset.forName(C.UTF8_NAME);

    private Util() {
    }

    public static boolean arrayRangeEquals(byte[] bArr, int i5, byte[] bArr2, int i6, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            if (bArr[i8 + i5] != bArr2[i8 + i6]) {
                return false;
            }
        }
        return true;
    }

    public static void checkOffsetAndCount(long j5, long j6, long j7) {
        if ((j6 | j7) < 0 || j6 > j5 || j5 - j6 < j7) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7)}));
        }
    }

    public static int reverseBytesInt(int i5) {
        return ((i5 & 255) << 24) | ((-16777216 & i5) >>> 24) | ((16711680 & i5) >>> 8) | ((65280 & i5) << 8);
    }

    public static long reverseBytesLong(long j5) {
        return ((j5 & 255) << 56) | ((-72057594037927936L & j5) >>> 56) | ((71776119061217280L & j5) >>> 40) | ((280375465082880L & j5) >>> 24) | ((1095216660480L & j5) >>> 8) | ((4278190080L & j5) << 8) | ((16711680 & j5) << 24) | ((65280 & j5) << 40);
    }

    public static short reverseBytesShort(short s5) {
        return (short) (((s5 & 255) << 8) | ((65280 & s5) >>> 8));
    }

    public static void sneakyRethrow(Throwable th) {
        sneakyThrow2(th);
    }

    private static <T extends Throwable> void sneakyThrow2(Throwable th) throws Throwable {
        throw th;
    }
}
