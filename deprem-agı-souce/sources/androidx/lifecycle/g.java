package androidx.lifecycle;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DispatchQueue f378a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f379b;

    public /* synthetic */ g(DispatchQueue dispatchQueue, Runnable runnable) {
        this.f378a = dispatchQueue;
        this.f379b = runnable;
    }

    public final void run() {
        DispatchQueue.dispatchAndEnqueue$lambda$2$lambda$1(this.f378a, this.f379b);
    }
}
