package androidx.work.impl.utils;

import android.app.Application;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;

@RequiresApi(28)
final class Api28Impl {
    public static final Api28Impl INSTANCE = new Api28Impl();

    private Api28Impl() {
    }

    public final String getProcessName() {
        String processName = Application.getProcessName();
        t.d(processName, "getProcessName(...)");
        return processName;
    }
}
