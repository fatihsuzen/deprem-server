package com.google.android.gms.common.util;

import android.os.StrictMode;
import androidx.annotation.DoNotInline;

abstract class t {
    @DoNotInline
    static StrictMode.VmPolicy.Builder a(StrictMode.VmPolicy.Builder builder) {
        return builder.permitUnsafeIntentLaunch();
    }
}
