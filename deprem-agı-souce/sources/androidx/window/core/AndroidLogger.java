package androidx.window.core;

import android.util.Log;
import kotlin.jvm.internal.t;

public final class AndroidLogger implements Logger {
    public static final AndroidLogger INSTANCE = new AndroidLogger();

    private AndroidLogger() {
    }

    public void debug(String str, String str2) {
        t.e(str, "tag");
        t.e(str2, "message");
        Log.d(str, str2);
    }
}
