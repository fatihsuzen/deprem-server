package y3;

import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.util.concurrent.CancellationException;
import k3.l;
import w3.C2860a;
import w3.C2910z0;
import w3.E0;

/* renamed from: y3.h  reason: case insensitive filesystem */
public abstract class C2935h extends C2860a implements C2934g {

    /* renamed from: d  reason: collision with root package name */
    private final C2934g f26436d;

    public C2935h(C2312i iVar, C2934g gVar, boolean z4, boolean z5) {
        super(iVar, z4, z5);
        this.f26436d = gVar;
    }

    public boolean D() {
        return this.f26436d.D();
    }

    public void N(Throwable th) {
        CancellationException F02 = E0.F0(this, th, (String) null, 1, (Object) null);
        this.f26436d.a(F02);
        L(F02);
    }

    /* access modifiers changed from: protected */
    public final C2934g R0() {
        return this.f26436d;
    }

    public final void a(CancellationException cancellationException) {
        if (!isCancelled()) {
            if (cancellationException == null) {
                cancellationException = new C2910z0(Q(), (Throwable) null, this);
            }
            N(cancellationException);
        }
    }

    public Object b(C2308e eVar) {
        Object b5 = this.f26436d.b(eVar);
        C2316b.f();
        return b5;
    }

    public Object e(Object obj, C2308e eVar) {
        return this.f26436d.e(obj, eVar);
    }

    public Object f() {
        return this.f26436d.f();
    }

    public boolean i(Throwable th) {
        return this.f26436d.i(th);
    }

    public C2936i iterator() {
        return this.f26436d.iterator();
    }

    public Object j(C2308e eVar) {
        return this.f26436d.j(eVar);
    }

    public Object r(Object obj) {
        return this.f26436d.r(obj);
    }

    public void w(l lVar) {
        this.f26436d.w(lVar);
    }

    public final C2934g Q0() {
        return this;
    }
}
