package k0;

import N.C0722p;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class O extends C1698l {

    /* renamed from: a  reason: collision with root package name */
    private final Object f15479a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final K f15480b = new K();

    /* renamed from: c  reason: collision with root package name */
    private boolean f15481c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f15482d;

    /* renamed from: e  reason: collision with root package name */
    private Object f15483e;

    /* renamed from: f  reason: collision with root package name */
    private Exception f15484f;

    O() {
    }

    private final void v() {
        C0722p.o(this.f15481c, "Task is not yet complete");
    }

    private final void w() {
        if (this.f15482d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void x() {
        if (this.f15481c) {
            throw C1690d.a(this);
        }
    }

    private final void y() {
        synchronized (this.f15479a) {
            try {
                if (this.f15481c) {
                    this.f15480b.b(this);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final C1698l a(Executor executor, C1691e eVar) {
        this.f15480b.a(new C1680A(executor, eVar));
        y();
        return this;
    }

    public final C1698l b(Executor executor, C1692f fVar) {
        this.f15480b.a(new C1682C(executor, fVar));
        y();
        return this;
    }

    public final C1698l c(C1692f fVar) {
        this.f15480b.a(new C1682C(C1700n.f15489a, fVar));
        y();
        return this;
    }

    public final C1698l d(Executor executor, C1693g gVar) {
        this.f15480b.a(new C1684E(executor, gVar));
        y();
        return this;
    }

    public final C1698l e(C1693g gVar) {
        d(C1700n.f15489a, gVar);
        return this;
    }

    public final C1698l f(Executor executor, C1694h hVar) {
        this.f15480b.a(new C1686G(executor, hVar));
        y();
        return this;
    }

    public final C1698l g(Executor executor, C1689c cVar) {
        O o5 = new O();
        this.f15480b.a(new w(executor, cVar, o5));
        y();
        return o5;
    }

    public final C1698l h(Executor executor, C1689c cVar) {
        O o5 = new O();
        this.f15480b.a(new y(executor, cVar, o5));
        y();
        return o5;
    }

    public final Exception i() {
        Exception exc;
        synchronized (this.f15479a) {
            exc = this.f15484f;
        }
        return exc;
    }

    public final Object j() {
        Object obj;
        synchronized (this.f15479a) {
            try {
                v();
                w();
                Exception exc = this.f15484f;
                if (exc == null) {
                    obj = this.f15483e;
                } else {
                    throw new C1696j(exc);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public final Object k(Class cls) {
        Object obj;
        synchronized (this.f15479a) {
            try {
                v();
                w();
                if (!cls.isInstance(this.f15484f)) {
                    Exception exc = this.f15484f;
                    if (exc == null) {
                        obj = this.f15483e;
                    } else {
                        throw new C1696j(exc);
                    }
                } else {
                    throw ((Throwable) cls.cast(this.f15484f));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public final boolean l() {
        return this.f15482d;
    }

    public final boolean m() {
        boolean z4;
        synchronized (this.f15479a) {
            z4 = this.f15481c;
        }
        return z4;
    }

    public final boolean n() {
        boolean z4;
        synchronized (this.f15479a) {
            try {
                z4 = false;
                if (this.f15481c && !this.f15482d && this.f15484f == null) {
                    z4 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z4;
    }

    public final C1698l o(Executor executor, C1697k kVar) {
        O o5 = new O();
        this.f15480b.a(new I(executor, kVar, o5));
        y();
        return o5;
    }

    public final C1698l p(C1697k kVar) {
        Executor executor = C1700n.f15489a;
        O o5 = new O();
        this.f15480b.a(new I(executor, kVar, o5));
        y();
        return o5;
    }

    public final void q(Exception exc) {
        C0722p.l(exc, "Exception must not be null");
        synchronized (this.f15479a) {
            x();
            this.f15481c = true;
            this.f15484f = exc;
        }
        this.f15480b.b(this);
    }

    public final void r(Object obj) {
        synchronized (this.f15479a) {
            x();
            this.f15481c = true;
            this.f15483e = obj;
        }
        this.f15480b.b(this);
    }

    public final boolean s() {
        synchronized (this.f15479a) {
            try {
                if (this.f15481c) {
                    return false;
                }
                this.f15481c = true;
                this.f15482d = true;
                this.f15480b.b(this);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final boolean t(Exception exc) {
        C0722p.l(exc, "Exception must not be null");
        synchronized (this.f15479a) {
            try {
                if (this.f15481c) {
                    return false;
                }
                this.f15481c = true;
                this.f15484f = exc;
                this.f15480b.b(this);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final boolean u(Object obj) {
        synchronized (this.f15479a) {
            try {
                if (this.f15481c) {
                    return false;
                }
                this.f15481c = true;
                this.f15483e = obj;
                this.f15480b.b(this);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }
}
