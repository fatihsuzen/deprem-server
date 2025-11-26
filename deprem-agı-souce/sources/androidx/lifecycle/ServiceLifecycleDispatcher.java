package androidx.lifecycle;

import android.os.Handler;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.t;

public class ServiceLifecycleDispatcher {
    private final Handler handler = new Handler();
    private DispatchRunnable lastDispatchRunnable;
    private final LifecycleRegistry registry;

    public static final class DispatchRunnable implements Runnable {
        private final Lifecycle.Event event;
        private final LifecycleRegistry registry;
        private boolean wasExecuted;

        public DispatchRunnable(LifecycleRegistry lifecycleRegistry, Lifecycle.Event event2) {
            t.e(lifecycleRegistry, "registry");
            t.e(event2, NotificationCompat.CATEGORY_EVENT);
            this.registry = lifecycleRegistry;
            this.event = event2;
        }

        public final Lifecycle.Event getEvent() {
            return this.event;
        }

        public void run() {
            if (!this.wasExecuted) {
                this.registry.handleLifecycleEvent(this.event);
                this.wasExecuted = true;
            }
        }
    }

    public ServiceLifecycleDispatcher(LifecycleOwner lifecycleOwner) {
        t.e(lifecycleOwner, "provider");
        this.registry = new LifecycleRegistry(lifecycleOwner);
    }

    private final void postDispatchRunnable(Lifecycle.Event event) {
        DispatchRunnable dispatchRunnable = this.lastDispatchRunnable;
        if (dispatchRunnable != null) {
            dispatchRunnable.run();
        }
        DispatchRunnable dispatchRunnable2 = new DispatchRunnable(this.registry, event);
        this.lastDispatchRunnable = dispatchRunnable2;
        Handler handler2 = this.handler;
        t.b(dispatchRunnable2);
        handler2.postAtFrontOfQueue(dispatchRunnable2);
    }

    public Lifecycle getLifecycle() {
        return this.registry;
    }

    public void onServicePreSuperOnBind() {
        postDispatchRunnable(Lifecycle.Event.ON_START);
    }

    public void onServicePreSuperOnCreate() {
        postDispatchRunnable(Lifecycle.Event.ON_CREATE);
    }

    public void onServicePreSuperOnDestroy() {
        postDispatchRunnable(Lifecycle.Event.ON_STOP);
        postDispatchRunnable(Lifecycle.Event.ON_DESTROY);
    }

    public void onServicePreSuperOnStart() {
        postDispatchRunnable(Lifecycle.Event.ON_START);
    }
}
