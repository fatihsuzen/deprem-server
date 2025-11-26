package y0;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import k0.C1698l;
import k0.C1701o;

public class e implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f17079a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f17080b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private C1698l f17081c = C1701o.e((Object) null);

    e(ExecutorService executorService) {
        this.f17079a = executorService;
    }

    public static /* synthetic */ C1698l b(Callable callable, C1698l lVar) {
        return (C1698l) callable.call();
    }

    public ExecutorService c() {
        return this.f17079a;
    }

    public C1698l d(Runnable runnable) {
        C1698l h5;
        synchronized (this.f17080b) {
            h5 = this.f17081c.h(this.f17079a, new d(runnable));
            this.f17081c = h5;
        }
        return h5;
    }

    public C1698l e(Callable callable) {
        C1698l h5;
        synchronized (this.f17080b) {
            h5 = this.f17081c.h(this.f17079a, new C1939c(callable));
            this.f17081c = h5;
        }
        return h5;
    }

    public void execute(Runnable runnable) {
        this.f17079a.execute(runnable);
    }
}
