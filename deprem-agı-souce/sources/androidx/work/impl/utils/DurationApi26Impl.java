package androidx.work.impl.utils;

import androidx.annotation.RequiresApi;
import j$.time.Duration;
import kotlin.jvm.internal.t;

@RequiresApi(26)
public final class DurationApi26Impl {
    public static final long toMillisCompat(Duration duration) {
        t.e(duration, "<this>");
        return duration.toMillis();
    }
}
