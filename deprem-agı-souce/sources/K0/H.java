package k0;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class H implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1698l f15469a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ I f15470b;

    H(I i5, C1698l lVar) {
        this.f15470b = i5;
        this.f15469a = lVar;
    }

    public final void run() {
        try {
            C1698l a5 = this.f15470b.f15472b.a(this.f15469a.j());
            if (a5 == null) {
                this.f15470b.d(new NullPointerException("Continuation returned null"));
                return;
            }
            I i5 = this.f15470b;
            Executor executor = C1700n.f15490b;
            a5.f(executor, i5);
            a5.d(executor, this.f15470b);
            a5.a(executor, this.f15470b);
        } catch (C1696j e5) {
            if (e5.getCause() instanceof Exception) {
                this.f15470b.d((Exception) e5.getCause());
            } else {
                this.f15470b.d(e5);
            }
        } catch (CancellationException unused) {
            this.f15470b.b();
        } catch (Exception e6) {
            this.f15470b.d(e6);
        }
    }
}
