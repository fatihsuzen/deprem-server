package B3;

import W2.J;
import androidx.concurrent.futures.a;
import b3.C2308e;
import b3.C2312i;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.internal.t;
import w3.C2856C;
import w3.C2877i0;
import w3.C2882l;
import w3.C2886n;
import w3.I;
import w3.Q;
import w3.W0;
import w3.Z;

/* renamed from: B3.h  reason: case insensitive filesystem */
public final class C1988h extends Z implements e, C2308e {
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17393h = AtomicReferenceFieldUpdater.newUpdater(C1988h.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* renamed from: d  reason: collision with root package name */
    public final I f17394d;

    /* renamed from: e  reason: collision with root package name */
    public final C2308e f17395e;

    /* renamed from: f  reason: collision with root package name */
    public Object f17396f = C1989i.f17398a;

    /* renamed from: g  reason: collision with root package name */
    public final Object f17397g = K.g(getContext());

    public C1988h(I i5, C2308e eVar) {
        super(-1);
        this.f17394d = i5;
        this.f17395e = eVar;
    }

    private final C2886n o() {
        Object obj = f17393h.get(this);
        if (obj instanceof C2886n) {
            return (C2886n) obj;
        }
        return null;
    }

    public e getCallerFrame() {
        C2308e eVar = this.f17395e;
        if (eVar instanceof e) {
            return (e) eVar;
        }
        return null;
    }

    public C2312i getContext() {
        return this.f17395e.getContext();
    }

    public Object j() {
        Object obj = this.f17396f;
        this.f17396f = C1989i.f17398a;
        return obj;
    }

    public final void l() {
        do {
        } while (f17393h.get(this) == C1989i.f17399b);
    }

    public final C2886n m() {
        AtomicReferenceFieldUpdater p5 = f17393h;
        while (true) {
            Object obj = p5.get(this);
            if (obj == null) {
                f17393h.set(this, C1989i.f17399b);
                return null;
            } else if (obj instanceof C2886n) {
                if (a.a(f17393h, this, obj, C1989i.f17399b)) {
                    return (C2886n) obj;
                }
            } else if (obj != C1989i.f17399b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void n(C2312i iVar, Object obj) {
        this.f17396f = obj;
        this.f26267c = 1;
        this.f17394d.dispatchYield(iVar, this);
    }

    public final boolean r() {
        if (f17393h.get(this) != null) {
            return true;
        }
        return false;
    }

    public void resumeWith(Object obj) {
        C2312i context;
        Object i5;
        Object b5 = C2856C.b(obj);
        if (this.f17394d.isDispatchNeeded(getContext())) {
            this.f17396f = b5;
            this.f26267c = 0;
            this.f17394d.dispatch(getContext(), this);
            return;
        }
        C2877i0 b6 = W0.f26260a.b();
        if (b6.M()) {
            this.f17396f = b5;
            this.f26267c = 0;
            b6.I(this);
            return;
        }
        b6.K(true);
        try {
            context = getContext();
            i5 = K.i(context, this.f17397g);
            this.f17395e.resumeWith(obj);
            J j5 = J.f19942a;
            K.f(context, i5);
            do {
            } while (b6.P());
        } catch (Throwable th) {
            b6.F(true);
            throw th;
        }
        b6.F(true);
    }

    public final boolean s(Throwable th) {
        AtomicReferenceFieldUpdater p5 = f17393h;
        while (true) {
            Object obj = p5.get(this);
            D d5 = C1989i.f17399b;
            if (t.a(obj, d5)) {
                if (a.a(f17393h, this, d5, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (a.a(f17393h, this, obj, (Object) null)) {
                    return false;
                }
            }
        }
    }

    public final void t() {
        l();
        C2886n o5 = o();
        if (o5 != null) {
            o5.s();
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f17394d + ", " + Q.c(this.f17395e) + ']';
    }

    public final Throwable u(C2882l lVar) {
        D d5;
        AtomicReferenceFieldUpdater p5 = f17393h;
        do {
            Object obj = p5.get(this);
            d5 = C1989i.f17399b;
            if (obj != d5) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                } else if (a.a(f17393h, this, obj, (Object) null)) {
                    return (Throwable) obj;
                } else {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
        } while (!a.a(f17393h, this, d5, lVar));
        return null;
    }

    public C2308e d() {
        return this;
    }
}
