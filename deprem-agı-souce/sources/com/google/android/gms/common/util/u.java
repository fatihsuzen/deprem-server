package com.google.android.gms.common.util;

import android.os.StrictMode;

public abstract class u {
    public static StrictMode.VmPolicy a() {
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (k.i()) {
            StrictMode.setVmPolicy(t.a(new StrictMode.VmPolicy.Builder(vmPolicy)).build());
        }
        return vmPolicy;
    }
}
