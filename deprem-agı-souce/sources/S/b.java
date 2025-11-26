package S;

import android.os.Process;

final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f4340a;

    public b(Runnable runnable, int i5) {
        this.f4340a = runnable;
    }

    public final void run() {
        Process.setThreadPriority(0);
        this.f4340a.run();
    }
}
