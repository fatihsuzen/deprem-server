package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Half;
import androidx.annotation.RequiresApi;

@SuppressLint({"ClassVerificationFailure"})
public final class HalfKt {
    @RequiresApi(26)
    public static final Half toHalf(short s5) {
        return Half.valueOf(s5);
    }

    @RequiresApi(26)
    public static final Half toHalf(float f5) {
        return Half.valueOf(f5);
    }

    @RequiresApi(26)
    public static final Half toHalf(String str) {
        return Half.valueOf(str);
    }

    @RequiresApi(26)
    public static final Half toHalf(double d5) {
        return Half.valueOf((float) d5);
    }
}
