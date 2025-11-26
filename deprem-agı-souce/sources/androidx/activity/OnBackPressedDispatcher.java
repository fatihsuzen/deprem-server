package androidx.activity;

import W2.J;
import X2.C2241h;
import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import b.w;
import java.util.Iterator;
import java.util.ListIterator;
import k3.C2616a;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class OnBackPressedDispatcher {
    private boolean backInvokedCallbackRegistered;
    private final Runnable fallbackOnBackPressed;
    private boolean hasEnabledCallbacks;
    /* access modifiers changed from: private */
    public OnBackPressedCallback inProgressCallback;
    private OnBackInvokedDispatcher invokedDispatcher;
    private OnBackInvokedCallback onBackInvokedCallback;
    /* access modifiers changed from: private */
    public final C2241h onBackPressedCallbacks;
    private final Consumer<Boolean> onHasEnabledCallbacksChanged;

    @RequiresApi(33)
    public static final class Api33Impl {
        public static final Api33Impl INSTANCE = new Api33Impl();

        private Api33Impl() {
        }

        /* access modifiers changed from: private */
        public static final void createOnBackInvokedCallback$lambda$0(C2616a aVar) {
            t.e(aVar, "$onBackInvoked");
            aVar.invoke();
        }

        @DoNotInline
        public final OnBackInvokedCallback createOnBackInvokedCallback(C2616a aVar) {
            t.e(aVar, "onBackInvoked");
            return new k(aVar);
        }

        @DoNotInline
        public final void registerOnBackInvokedCallback(Object obj, int i5, Object obj2) {
            t.e(obj, "dispatcher");
            t.e(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i5, (OnBackInvokedCallback) obj2);
        }

        @DoNotInline
        public final void unregisterOnBackInvokedCallback(Object obj, Object obj2) {
            t.e(obj, "dispatcher");
            t.e(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    @RequiresApi(34)
    public static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        @DoNotInline
        public final OnBackInvokedCallback createOnBackAnimationCallback(l lVar, l lVar2, C2616a aVar, C2616a aVar2) {
            t.e(lVar, "onBackStarted");
            t.e(lVar2, "onBackProgressed");
            t.e(aVar, "onBackInvoked");
            t.e(aVar2, "onBackCancelled");
            return new OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1(lVar, lVar2, aVar, aVar2);
        }
    }

    private final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {
        private Cancellable currentCancellable;
        private final Lifecycle lifecycle;
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle2, OnBackPressedCallback onBackPressedCallback2) {
            t.e(lifecycle2, "lifecycle");
            t.e(onBackPressedCallback2, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.lifecycle = lifecycle2;
            this.onBackPressedCallback = onBackPressedCallback2;
            lifecycle2.addObserver(this);
        }

        public void cancel() {
            this.lifecycle.removeObserver(this);
            this.onBackPressedCallback.removeCancellable(this);
            Cancellable cancellable = this.currentCancellable;
            if (cancellable != null) {
                cancellable.cancel();
            }
            this.currentCancellable = null;
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            t.e(lifecycleOwner, "source");
            t.e(event, NotificationCompat.CATEGORY_EVENT);
            if (event == Lifecycle.Event.ON_START) {
                this.currentCancellable = this.this$0.addCancellableCallback$activity_release(this.onBackPressedCallback);
            } else if (event == Lifecycle.Event.ON_STOP) {
                Cancellable cancellable = this.currentCancellable;
                if (cancellable != null) {
                    cancellable.cancel();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }
    }

    private final class OnBackPressedCancellable implements Cancellable {
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public OnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback2) {
            t.e(onBackPressedCallback2, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.onBackPressedCallback = onBackPressedCallback2;
        }

        public void cancel() {
            this.this$0.onBackPressedCallbacks.remove(this.onBackPressedCallback);
            if (t.a(this.this$0.inProgressCallback, this.onBackPressedCallback)) {
                this.onBackPressedCallback.handleOnBackCancelled();
                this.this$0.inProgressCallback = null;
            }
            this.onBackPressedCallback.removeCancellable(this);
            C2616a enabledChangedCallback$activity_release = this.onBackPressedCallback.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            this.onBackPressedCallback.setEnabledChangedCallback$activity_release((C2616a) null);
        }
    }

    public OnBackPressedDispatcher() {
        this((Runnable) null, 1, (C2633k) null);
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void onBackCancelled() {
        Object obj;
        C2241h hVar = this.onBackPressedCallbacks;
        ListIterator listIterator = hVar.listIterator(hVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (((OnBackPressedCallback) obj).isEnabled()) {
                break;
            }
        }
        OnBackPressedCallback onBackPressedCallback = (OnBackPressedCallback) obj;
        this.inProgressCallback = null;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackCancelled();
        }
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void onBackProgressed(BackEventCompat backEventCompat) {
        Object obj;
        C2241h hVar = this.onBackPressedCallbacks;
        ListIterator listIterator = hVar.listIterator(hVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (((OnBackPressedCallback) obj).isEnabled()) {
                break;
            }
        }
        OnBackPressedCallback onBackPressedCallback = (OnBackPressedCallback) obj;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackProgressed(backEventCompat);
        }
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void onBackStarted(BackEventCompat backEventCompat) {
        Object obj;
        C2241h hVar = this.onBackPressedCallbacks;
        ListIterator listIterator = hVar.listIterator(hVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (((OnBackPressedCallback) obj).isEnabled()) {
                break;
            }
        }
        OnBackPressedCallback onBackPressedCallback = (OnBackPressedCallback) obj;
        this.inProgressCallback = onBackPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackStarted(backEventCompat);
        }
    }

    @RequiresApi(33)
    private final void updateBackInvokedCallbackState(boolean z4) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.invokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback2 = this.onBackInvokedCallback;
        if (onBackInvokedDispatcher != null && onBackInvokedCallback2 != null) {
            if (z4 && !this.backInvokedCallbackRegistered) {
                Api33Impl.INSTANCE.registerOnBackInvokedCallback(onBackInvokedDispatcher, 0, onBackInvokedCallback2);
                this.backInvokedCallbackRegistered = true;
            } else if (!z4 && this.backInvokedCallbackRegistered) {
                Api33Impl.INSTANCE.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback2);
                this.backInvokedCallbackRegistered = false;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateEnabledCallbacks() {
        boolean z4 = this.hasEnabledCallbacks;
        C2241h hVar = this.onBackPressedCallbacks;
        boolean z5 = false;
        if (!w.a(hVar) || !hVar.isEmpty()) {
            Iterator it = hVar.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((OnBackPressedCallback) it.next()).isEnabled()) {
                        z5 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.hasEnabledCallbacks = z5;
        if (z5 != z4) {
            Consumer<Boolean> consumer = this.onHasEnabledCallbacksChanged;
            if (consumer != null) {
                consumer.accept(Boolean.valueOf(z5));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                updateBackInvokedCallbackState(z5);
            }
        }
    }

    @MainThread
    public final void addCallback(OnBackPressedCallback onBackPressedCallback) {
        t.e(onBackPressedCallback, "onBackPressedCallback");
        addCancellableCallback$activity_release(onBackPressedCallback);
    }

    @MainThread
    public final Cancellable addCancellableCallback$activity_release(OnBackPressedCallback onBackPressedCallback) {
        t.e(onBackPressedCallback, "onBackPressedCallback");
        this.onBackPressedCallbacks.add(onBackPressedCallback);
        OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(onBackPressedCancellable);
        updateEnabledCallbacks();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return onBackPressedCancellable;
    }

    @VisibleForTesting
    @MainThread
    public final void dispatchOnBackCancelled() {
        onBackCancelled();
    }

    @VisibleForTesting
    @MainThread
    public final void dispatchOnBackProgressed(BackEventCompat backEventCompat) {
        t.e(backEventCompat, "backEvent");
        onBackProgressed(backEventCompat);
    }

    @VisibleForTesting
    @MainThread
    public final void dispatchOnBackStarted(BackEventCompat backEventCompat) {
        t.e(backEventCompat, "backEvent");
        onBackStarted(backEventCompat);
    }

    @MainThread
    public final boolean hasEnabledCallbacks() {
        return this.hasEnabledCallbacks;
    }

    @MainThread
    public final void onBackPressed() {
        Object obj;
        C2241h hVar = this.onBackPressedCallbacks;
        ListIterator listIterator = hVar.listIterator(hVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (((OnBackPressedCallback) obj).isEnabled()) {
                break;
            }
        }
        OnBackPressedCallback onBackPressedCallback = (OnBackPressedCallback) obj;
        this.inProgressCallback = null;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.fallbackOnBackPressed;
        if (runnable != null) {
            runnable.run();
        }
    }

    @RequiresApi(33)
    public final void setOnBackInvokedDispatcher(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        t.e(onBackInvokedDispatcher, "invoker");
        this.invokedDispatcher = onBackInvokedDispatcher;
        updateBackInvokedCallbackState(this.hasEnabledCallbacks);
    }

    public OnBackPressedDispatcher(Runnable runnable, Consumer<Boolean> consumer) {
        OnBackInvokedCallback onBackInvokedCallback2;
        this.fallbackOnBackPressed = runnable;
        this.onHasEnabledCallbacksChanged = consumer;
        this.onBackPressedCallbacks = new C2241h();
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 33) {
            if (i5 >= 34) {
                onBackInvokedCallback2 = Api34Impl.INSTANCE.createOnBackAnimationCallback(new l(this) {
                    final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r1;
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((BackEventCompat) obj);
                        return J.f19942a;
                    }

                    public final void invoke(BackEventCompat backEventCompat) {
                        t.e(backEventCompat, "backEvent");
                        this.this$0.onBackStarted(backEventCompat);
                    }
                }, new l(this) {
                    final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r1;
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((BackEventCompat) obj);
                        return J.f19942a;
                    }

                    public final void invoke(BackEventCompat backEventCompat) {
                        t.e(backEventCompat, "backEvent");
                        this.this$0.onBackProgressed(backEventCompat);
                    }
                }, new C2616a(this) {
                    final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        this.this$0.onBackPressed();
                    }
                }, new C2616a(this) {
                    final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        this.this$0.onBackCancelled();
                    }
                });
            } else {
                onBackInvokedCallback2 = Api33Impl.INSTANCE.createOnBackInvokedCallback(new C2616a(this) {
                    final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        this.this$0.onBackPressed();
                    }
                });
            }
            this.onBackInvokedCallback = onBackInvokedCallback2;
        }
    }

    @MainThread
    public final void addCallback(LifecycleOwner lifecycleOwner, OnBackPressedCallback onBackPressedCallback) {
        t.e(lifecycleOwner, "owner");
        t.e(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            onBackPressedCallback.addCancellable(new LifecycleOnBackPressedCancellable(this, lifecycle, onBackPressedCallback));
            updateEnabledCallbacks();
            onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCallback$1(this));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? null : runnable);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this(runnable, (Consumer<Boolean>) null);
    }
}
