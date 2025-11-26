package com.mbridge.msdk.playercommon.exoplayer2.upstream.crypto;

final class CryptoUtil {
    private CryptoUtil() {
    }

    public static long getFNV64Hash(String str) {
        long j5 = 0;
        if (str == null) {
            return 0;
        }
        for (int i5 = 0; i5 < str.length(); i5++) {
            long charAt = j5 ^ ((long) str.charAt(i5));
            j5 = charAt + (charAt << 1) + (charAt << 4) + (charAt << 5) + (charAt << 7) + (charAt << 8) + (charAt << 40);
        }
        return j5;
    }
}
