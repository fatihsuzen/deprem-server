package j$.util.stream;

public final class E3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f1470a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f1471b;

    public E3(Runnable runnable, Runnable runnable2) {
        this.f1470a = runnable;
        this.f1471b = runnable2;
    }

    public final void run() {
        try {
            this.f1470a.run();
            this.f1471b.run();
            return;
        } catch (Throwable th) {
            try {
                th.addSuppressed(th);
            } catch (Throwable unused) {
            }
        }
        throw th;
    }
}
