package o0;

import android.os.SystemClock;

public abstract class p {
    public static p a(long j5, long j6, long j7) {
        return new C1728a(j5, j6, j7);
    }

    public static p e() {
        return a(System.currentTimeMillis(), SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
    }

    public abstract long b();

    public abstract long c();

    public abstract long d();
}
