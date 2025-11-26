package e4;

import kotlin.jvm.internal.t;

/* renamed from: e4.l  reason: case insensitive filesystem */
public abstract class C2363l implements X {

    /* renamed from: a  reason: collision with root package name */
    private final X f21593a;

    public C2363l(X x4) {
        t.e(x4, "delegate");
        this.f21593a = x4;
    }

    public void close() {
        this.f21593a.close();
    }

    public void f(C2356e eVar, long j5) {
        t.e(eVar, "source");
        this.f21593a.f(eVar, j5);
    }

    public void flush() {
        this.f21593a.flush();
    }

    public a0 timeout() {
        return this.f21593a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f21593a + ')';
    }
}
