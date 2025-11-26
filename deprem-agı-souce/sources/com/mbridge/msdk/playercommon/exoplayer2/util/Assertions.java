package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;

public final class Assertions {
    private Assertions() {
    }

    public static void checkArgument(boolean z4) {
        if (!z4) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkIndex(int i5, int i6, int i7) {
        if (i5 >= i6 && i5 < i7) {
            return i5;
        }
        throw new IndexOutOfBoundsException();
    }

    public static void checkMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Not in applications main thread");
        }
    }

    public static String checkNotEmpty(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }

    public static <T> T checkNotNull(@Nullable T t5) {
        t5.getClass();
        return t5;
    }

    public static void checkState(boolean z4) {
        if (!z4) {
            throw new IllegalStateException();
        }
    }

    public static void checkArgument(boolean z4, Object obj) {
        if (!z4) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static <T> T checkNotNull(@Nullable T t5, Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z4, Object obj) {
        if (!z4) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static String checkNotEmpty(@Nullable String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }
}
