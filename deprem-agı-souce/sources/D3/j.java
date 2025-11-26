package D3;

import B3.E;
import java.util.concurrent.TimeUnit;
import q3.C2729e;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f18085a = E.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* renamed from: b  reason: collision with root package name */
    public static final long f18086b = G.f("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, (Object) null);

    /* renamed from: c  reason: collision with root package name */
    public static final int f18087c = G.e("kotlinx.coroutines.scheduler.core.pool.size", C2729e.c(E.a(), 2), 1, 0, 8, (Object) null);

    /* renamed from: d  reason: collision with root package name */
    public static final int f18088d = G.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, (Object) null);

    /* renamed from: e  reason: collision with root package name */
    public static final long f18089e = TimeUnit.SECONDS.toNanos(G.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, (Object) null));

    /* renamed from: f  reason: collision with root package name */
    public static g f18090f = e.f18076a;

    public static final h b(Runnable runnable, long j5, boolean z4) {
        return new i(runnable, j5, z4);
    }

    /* access modifiers changed from: private */
    public static final String c(boolean z4) {
        if (z4) {
            return "Blocking";
        }
        return "Non-blocking";
    }
}
