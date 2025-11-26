package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.com.android.tools.r8.a;
import java.time.Duration;
import java.time.Instant;

public class TimeConversions {
    public static Duration convert(Duration duration) {
        if (duration == null) {
            return null;
        }
        long seconds = duration.getSeconds();
        long nano = (long) duration.getNano();
        Duration duration2 = Duration.f1003c;
        return Duration.e(a.x(seconds, a.B(nano, C.NANOS_PER_SECOND)), (int) a.A(nano, C.NANOS_PER_SECOND));
    }

    public static Instant convert(Instant instant) {
        if (instant == null) {
            return null;
        }
        return Instant.ofEpochSecond(instant.f1007a, (long) instant.f1008b);
    }

    public static Duration convert(Duration duration) {
        if (duration == null) {
            return null;
        }
        return Duration.ofSeconds(duration.f1004a, (long) duration.f1005b);
    }
}
