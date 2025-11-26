package k0;

import java.util.concurrent.Executor;

final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1698l f15507a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ y f15508b;

    x(y yVar, C1698l lVar) {
        this.f15508b = yVar;
        this.f15507a = lVar;
    }

    public final void run() {
        try {
            C1698l lVar = (C1698l) this.f15508b.f15510b.a(this.f15507a);
            if (lVar == null) {
                this.f15508b.d(new NullPointerException("Continuation returned null"));
                return;
            }
            y yVar = this.f15508b;
            Executor executor = C1700n.f15490b;
            lVar.f(executor, yVar);
            lVar.d(executor, this.f15508b);
            lVar.a(executor, this.f15508b);
        } catch (C1696j e5) {
            if (e5.getCause() instanceof Exception) {
                this.f15508b.f15511c.q((Exception) e5.getCause());
            } else {
                this.f15508b.f15511c.q(e5);
            }
        } catch (Exception e6) {
            this.f15508b.f15511c.q(e6);
        }
    }
}
