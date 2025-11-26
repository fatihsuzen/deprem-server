package com.google.android.gms.common.util;

import android.os.Looper;

public abstract class v {
    public static boolean a() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }
}
