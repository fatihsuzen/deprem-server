package androidx.window.layout;

import W2.J;
import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.annotation.GuardedBy;
import androidx.core.util.Consumer;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import j$.util.function.Consumer$CC;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.t;

public final class ExtensionWindowLayoutInfoBackend implements WindowBackend {
    @GuardedBy("lock")
    private final Map<Activity, MulticastConsumer> activityToListeners = new LinkedHashMap();
    private final WindowLayoutComponent component;
    private final ReentrantLock extensionWindowBackendLock = new ReentrantLock();
    @GuardedBy("lock")
    private final Map<Consumer<WindowLayoutInfo>, Activity> listenerToActivity = new LinkedHashMap();

    @SuppressLint({"NewApi"})
    private static final class MulticastConsumer implements java.util.function.Consumer<WindowLayoutInfo> {
        private final Activity activity;
        @GuardedBy("lock")
        private WindowLayoutInfo lastKnownValue;
        private final ReentrantLock multicastConsumerLock = new ReentrantLock();
        @GuardedBy("lock")
        private final Set<Consumer<WindowLayoutInfo>> registeredListeners = new LinkedHashSet();

        public MulticastConsumer(Activity activity2) {
            t.e(activity2, "activity");
            this.activity = activity2;
        }

        public final void addListener(Consumer<WindowLayoutInfo> consumer) {
            t.e(consumer, "listener");
            ReentrantLock reentrantLock = this.multicastConsumerLock;
            reentrantLock.lock();
            try {
                WindowLayoutInfo windowLayoutInfo = this.lastKnownValue;
                if (windowLayoutInfo != null) {
                    consumer.accept(windowLayoutInfo);
                }
                this.registeredListeners.add(consumer);
            } finally {
                reentrantLock.unlock();
            }
        }

        public /* synthetic */ java.util.function.Consumer andThen(java.util.function.Consumer consumer) {
            return Consumer$CC.$default$andThen(this, consumer);
        }

        public final boolean isEmpty() {
            return this.registeredListeners.isEmpty();
        }

        public final void removeListener(Consumer<WindowLayoutInfo> consumer) {
            t.e(consumer, "listener");
            ReentrantLock reentrantLock = this.multicastConsumerLock;
            reentrantLock.lock();
            try {
                this.registeredListeners.remove(consumer);
            } finally {
                reentrantLock.unlock();
            }
        }

        public void accept(WindowLayoutInfo windowLayoutInfo) {
            t.e(windowLayoutInfo, "value");
            ReentrantLock reentrantLock = this.multicastConsumerLock;
            reentrantLock.lock();
            try {
                this.lastKnownValue = ExtensionsWindowLayoutInfoAdapter.INSTANCE.translate$window_release(this.activity, windowLayoutInfo);
                for (Consumer accept : this.registeredListeners) {
                    accept.accept(this.lastKnownValue);
                }
                J j5 = J.f19942a;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public ExtensionWindowLayoutInfoBackend(WindowLayoutComponent windowLayoutComponent) {
        t.e(windowLayoutComponent, "component");
        this.component = windowLayoutComponent;
    }

    public void registerLayoutChangeCallback(Activity activity, Executor executor, Consumer<WindowLayoutInfo> consumer) {
        J j5;
        t.e(activity, "activity");
        t.e(executor, "executor");
        t.e(consumer, "callback");
        ReentrantLock reentrantLock = this.extensionWindowBackendLock;
        reentrantLock.lock();
        try {
            MulticastConsumer multicastConsumer = this.activityToListeners.get(activity);
            if (multicastConsumer == null) {
                j5 = null;
            } else {
                multicastConsumer.addListener(consumer);
                this.listenerToActivity.put(consumer, activity);
                j5 = J.f19942a;
            }
            if (j5 == null) {
                MulticastConsumer multicastConsumer2 = new MulticastConsumer(activity);
                this.activityToListeners.put(activity, multicastConsumer2);
                this.listenerToActivity.put(consumer, activity);
                multicastConsumer2.addListener(consumer);
                this.component.addWindowLayoutInfoListener(activity, multicastConsumer2);
            }
            J j6 = J.f19942a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void unregisterLayoutChangeCallback(Consumer<WindowLayoutInfo> consumer) {
        t.e(consumer, "callback");
        ReentrantLock reentrantLock = this.extensionWindowBackendLock;
        reentrantLock.lock();
        try {
            Activity activity = this.listenerToActivity.get(consumer);
            if (activity == null) {
                reentrantLock.unlock();
                return;
            }
            MulticastConsumer multicastConsumer = this.activityToListeners.get(activity);
            if (multicastConsumer == null) {
                reentrantLock.unlock();
                return;
            }
            multicastConsumer.removeListener(consumer);
            if (multicastConsumer.isEmpty()) {
                this.component.removeWindowLayoutInfoListener(multicastConsumer);
            }
            J j5 = J.f19942a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
