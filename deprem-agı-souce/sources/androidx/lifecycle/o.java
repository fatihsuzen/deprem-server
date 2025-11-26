package androidx.lifecycle;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProcessLifecycleOwner f387a;

    public /* synthetic */ o(ProcessLifecycleOwner processLifecycleOwner) {
        this.f387a = processLifecycleOwner;
    }

    public final void run() {
        ProcessLifecycleOwner.delayedPauseRunnable$lambda$0(this.f387a);
    }
}
