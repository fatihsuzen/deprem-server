package u3;

import d3.C2345b;
import java.util.concurrent.TimeUnit;

/* renamed from: u3.d  reason: case insensitive filesystem */
public enum C2798d {
    NANOSECONDS(TimeUnit.NANOSECONDS),
    MICROSECONDS(TimeUnit.MICROSECONDS),
    MILLISECONDS(TimeUnit.MILLISECONDS),
    SECONDS(TimeUnit.SECONDS),
    MINUTES(TimeUnit.MINUTES),
    HOURS(TimeUnit.HOURS),
    DAYS(TimeUnit.DAYS);
    

    /* renamed from: a  reason: collision with root package name */
    private final TimeUnit f26010a;

    static {
        C2798d[] a5;
        f26009j = C2345b.a(a5);
    }

    private C2798d(TimeUnit timeUnit) {
        this.f26010a = timeUnit;
    }

    public final TimeUnit b() {
        return this.f26010a;
    }
}
