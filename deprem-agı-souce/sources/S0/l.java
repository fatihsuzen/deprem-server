package s0;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public enum l implements Executor {
    INSTANCE;
    

    /* renamed from: b  reason: collision with root package name */
    private static final Handler f16496b = null;

    static {
        f16496b = new Handler(Looper.getMainLooper());
    }

    public void execute(Runnable runnable) {
        f16496b.post(runnable);
    }
}
