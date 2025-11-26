package w3;

import b3.C2308e;
import b3.C2312i;
import k3.p;

/* renamed from: w3.a  reason: case insensitive filesystem */
public abstract class C2860a extends E0 implements C2908y0, C2308e, M {

    /* renamed from: c  reason: collision with root package name */
    private final C2312i f26268c;

    public C2860a(C2312i iVar, boolean z4, boolean z5) {
        super(z5);
        if (z4) {
            j0((C2908y0) iVar.get(C2908y0.f26320k0));
        }
        this.f26268c = iVar.plus(this);
    }

    /* access modifiers changed from: protected */
    public void M0(Object obj) {
        I(obj);
    }

    public final void P0(O o5, Object obj, p pVar) {
        o5.b(pVar, obj, this);
    }

    /* access modifiers changed from: protected */
    public String Q() {
        return Q.a(this) + " was cancelled";
    }

    public final C2312i getContext() {
        return this.f26268c;
    }

    public C2312i getCoroutineContext() {
        return this.f26268c;
    }

    public final void i0(Throwable th) {
        K.a(this.f26268c, th);
    }

    public boolean isActive() {
        return super.isActive();
    }

    public String r0() {
        String g5 = G.g(this.f26268c);
        if (g5 == null) {
            return super.r0();
        }
        return '\"' + g5 + "\":" + super.r0();
    }

    public final void resumeWith(Object obj) {
        Object q02 = q0(C2856C.b(obj));
        if (q02 != F0.f26231b) {
            M0(q02);
        }
    }

    /* access modifiers changed from: protected */
    public final void w0(Object obj) {
        if (obj instanceof C2854A) {
            C2854A a5 = (C2854A) obj;
            N0(a5.f26214a, a5.a());
            return;
        }
        O0(obj);
    }

    /* access modifiers changed from: protected */
    public void O0(Object obj) {
    }

    /* access modifiers changed from: protected */
    public void N0(Throwable th, boolean z4) {
    }
}
