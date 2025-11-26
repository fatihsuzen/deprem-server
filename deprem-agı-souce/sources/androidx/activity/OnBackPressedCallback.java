package androidx.activity;

import androidx.annotation.MainThread;
import java.util.concurrent.CopyOnWriteArrayList;
import k3.C2616a;
import kotlin.jvm.internal.t;

public abstract class OnBackPressedCallback {
    private final CopyOnWriteArrayList<Cancellable> cancellables = new CopyOnWriteArrayList<>();
    private C2616a enabledChangedCallback;
    private boolean isEnabled;

    public OnBackPressedCallback(boolean z4) {
        this.isEnabled = z4;
    }

    public final void addCancellable(Cancellable cancellable) {
        t.e(cancellable, "cancellable");
        this.cancellables.add(cancellable);
    }

    public final C2616a getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    @MainThread
    public void handleOnBackCancelled() {
    }

    @MainThread
    public abstract void handleOnBackPressed();

    @MainThread
    public void handleOnBackProgressed(BackEventCompat backEventCompat) {
        t.e(backEventCompat, "backEvent");
    }

    @MainThread
    public void handleOnBackStarted(BackEventCompat backEventCompat) {
        t.e(backEventCompat, "backEvent");
    }

    @MainThread
    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @MainThread
    public final void remove() {
        for (Cancellable cancel : this.cancellables) {
            cancel.cancel();
        }
    }

    public final void removeCancellable(Cancellable cancellable) {
        t.e(cancellable, "cancellable");
        this.cancellables.remove(cancellable);
    }

    @MainThread
    public final void setEnabled(boolean z4) {
        this.isEnabled = z4;
        C2616a aVar = this.enabledChangedCallback;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(C2616a aVar) {
        this.enabledChangedCallback = aVar;
    }
}
