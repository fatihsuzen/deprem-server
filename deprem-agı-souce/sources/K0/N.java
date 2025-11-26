package k0;

import android.os.Handler;
import android.os.Looper;
import d0.C1623a;
import java.util.concurrent.Executor;

final class N implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f15478a = new C1623a(Looper.getMainLooper());

    public final void execute(Runnable runnable) {
        this.f15478a.post(runnable);
    }
}
