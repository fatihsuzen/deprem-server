package k0;

import java.util.concurrent.Callable;

final class P implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ O f15485a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Callable f15486b;

    P(O o5, Callable callable) {
        this.f15485a = o5;
        this.f15486b = callable;
    }

    public final void run() {
        try {
            this.f15485a.r(this.f15486b.call());
        } catch (Exception e5) {
            this.f15485a.q(e5);
        } catch (Throwable th) {
            this.f15485a.q(new RuntimeException(th));
        }
    }
}
