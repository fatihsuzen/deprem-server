package com.mbridge.msdk.foundation.download.utils;

public final class Utils {
    private Utils() {
    }

    public static int getDownloadRate(long j5, long j6) {
        if (j5 == 0 || j6 == 0) {
            return 0;
        }
        if (j5 == j6) {
            return 100;
        }
        return (int) (((((double) j6) * 1.0d) / (((double) j5) * 1.0d)) * 100.0d);
    }
}
