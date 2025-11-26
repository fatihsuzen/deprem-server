package com.mbridge.msdk.foundation.tools;

import android.os.SystemClock;

public final class aa {
    public static final long a() {
        try {
            long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            if (currentTimeMillis > 0) {
                return (currentTimeMillis / 10) * 10;
            }
        } catch (Exception unused) {
        }
        return 0;
    }
}
