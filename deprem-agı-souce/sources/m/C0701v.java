package M;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: M.v  reason: case insensitive filesystem */
public final /* synthetic */ class C0701v implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f2941a;

    public /* synthetic */ C0701v(Handler handler) {
        this.f2941a = handler;
    }

    public final void execute(Runnable runnable) {
        this.f2941a.post(runnable);
    }
}
