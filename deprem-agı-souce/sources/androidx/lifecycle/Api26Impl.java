package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import j$.time.Duration;
import kotlin.jvm.internal.t;

@RequiresApi(26)
public final class Api26Impl {
    public static final Api26Impl INSTANCE = new Api26Impl();

    private Api26Impl() {
    }

    public final long toMillis(Duration duration) {
        t.e(duration, "timeout");
        return duration.toMillis();
    }
}
