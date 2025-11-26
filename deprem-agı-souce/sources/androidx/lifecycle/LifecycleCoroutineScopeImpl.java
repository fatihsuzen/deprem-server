package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import b3.C2308e;
import b3.C2312i;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2908y0;
import w3.O;

public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    private final C2312i coroutineContext;
    private final Lifecycle lifecycle;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle2, C2312i iVar) {
        t.e(lifecycle2, "lifecycle");
        t.e(iVar, "coroutineContext");
        this.lifecycle = lifecycle2;
        this.coroutineContext = iVar;
        if (getLifecycle$lifecycle_common().getCurrentState() == Lifecycle.State.DESTROYED) {
            C0.d(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }

    public C2312i getCoroutineContext() {
        return this.coroutineContext;
    }

    public Lifecycle getLifecycle$lifecycle_common() {
        return this.lifecycle;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        t.e(lifecycleOwner, "source");
        t.e(event, NotificationCompat.CATEGORY_EVENT);
        if (getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle$lifecycle_common().removeObserver(this);
            C0.d(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }

    public final void register() {
        C2908y0 unused = C2876i.d(this, C2865c0.c().F(), (O) null, new LifecycleCoroutineScopeImpl$register$1(this, (C2308e) null), 2, (Object) null);
    }
}
