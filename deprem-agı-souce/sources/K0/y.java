package k0;

import java.util.concurrent.Executor;

final class y implements C1694h, C1693g, C1691e, J {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f15509a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C1689c f15510b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final O f15511c;

    public y(Executor executor, C1689c cVar, O o5) {
        this.f15509a = executor;
        this.f15510b = cVar;
        this.f15511c = o5;
    }

    public final void a(Object obj) {
        this.f15511c.r(obj);
    }

    public final void b() {
        this.f15511c.s();
    }

    public final void c(C1698l lVar) {
        this.f15509a.execute(new x(this, lVar));
    }

    public final void d(Exception exc) {
        this.f15511c.q(exc);
    }
}
