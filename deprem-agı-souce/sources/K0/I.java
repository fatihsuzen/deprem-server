package k0;

import java.util.concurrent.Executor;

final class I implements C1694h, C1693g, C1691e, J {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f15471a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C1697k f15472b;

    /* renamed from: c  reason: collision with root package name */
    private final O f15473c;

    public I(Executor executor, C1697k kVar, O o5) {
        this.f15471a = executor;
        this.f15472b = kVar;
        this.f15473c = o5;
    }

    public final void a(Object obj) {
        this.f15473c.r(obj);
    }

    public final void b() {
        this.f15473c.s();
    }

    public final void c(C1698l lVar) {
        this.f15471a.execute(new H(this, lVar));
    }

    public final void d(Exception exc) {
        this.f15473c.q(exc);
    }
}
