package androidx.emoji2.text;

import android.os.Handler;
import java.util.concurrent.Executor;

public final /* synthetic */ class a implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f346a;

    public /* synthetic */ a(Handler handler) {
        this.f346a = handler;
    }

    public final void execute(Runnable runnable) {
        this.f346a.post(runnable);
    }
}
