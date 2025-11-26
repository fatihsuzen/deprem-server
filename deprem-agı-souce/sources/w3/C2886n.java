package w3;

import B3.A;
import B3.C1988h;
import B3.D;
import W2.C2219h;
import W2.J;
import androidx.concurrent.futures.a;
import b.w;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k3.l;
import k3.q;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2880k;

/* renamed from: w3.n  reason: case insensitive filesystem */
public class C2886n extends Z implements C2882l, e, d1 {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f26303f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f26304g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f26305h;
    private volatile /* synthetic */ int _decisionAndIndex$volatile = 536870911;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile = C2866d.f26276a;

    /* renamed from: d  reason: collision with root package name */
    private final C2308e f26306d;

    /* renamed from: e  reason: collision with root package name */
    private final C2312i f26307e;

    static {
        Class<C2886n> cls = C2886n.class;
        f26303f = AtomicIntegerFieldUpdater.newUpdater(cls, "_decisionAndIndex$volatile");
        Class<Object> cls2 = Object.class;
        f26304g = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state$volatile");
        f26305h = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_parentHandle$volatile");
    }

    public C2886n(C2308e eVar, int i5) {
        super(i5);
        this.f26306d = eVar;
        this.f26307e = eVar.getContext();
    }

    private final C2869e0 F() {
        C2908y0 y0Var = (C2908y0) getContext().get(C2908y0.f26320k0);
        if (y0Var == null) {
            return null;
        }
        C2869e0 j5 = C0.j(y0Var, false, new r(this), 1, (Object) null);
        a.a(f26305h, this, (Object) null, j5);
        return j5;
    }

    private final void G(Object obj) {
        AtomicReferenceFieldUpdater C4 = f26304g;
        while (true) {
            Object obj2 = C4.get(this);
            if (obj2 instanceof C2866d) {
                if (a.a(f26304g, this, obj2, obj)) {
                    return;
                }
            } else if ((obj2 instanceof C2880k) || (obj2 instanceof A)) {
                K(obj, obj2);
            } else if (obj2 instanceof C2854A) {
                C2854A a5 = (C2854A) obj2;
                if (!a5.c()) {
                    K(obj, obj2);
                }
                if (obj2 instanceof C2892q) {
                    boolean a6 = w.a(obj2);
                    Throwable th = null;
                    if (!a6) {
                        a5 = null;
                    }
                    if (a5 != null) {
                        th = a5.f26214a;
                    }
                    if (obj instanceof C2880k) {
                        n((C2880k) obj, th);
                        return;
                    }
                    t.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                    p((A) obj, th);
                    return;
                }
                return;
            } else if (obj2 instanceof C2909z) {
                C2909z zVar = (C2909z) obj2;
                if (zVar.f26323b != null) {
                    K(obj, obj2);
                }
                if (!(obj instanceof A)) {
                    t.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    C2880k kVar = (C2880k) obj;
                    if (zVar.c()) {
                        n(kVar, zVar.f26326e);
                        return;
                    }
                    if (a.a(f26304g, this, obj2, C2909z.b(zVar, (Object) null, kVar, (q) null, (Object) null, (Throwable) null, 29, (Object) null))) {
                        return;
                    }
                } else {
                    return;
                }
            } else if (!(obj instanceof A)) {
                t.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                if (a.a(f26304g, this, obj2, new C2909z(obj2, (C2880k) obj, (q) null, (Object) null, (Throwable) null, 28, (C2633k) null))) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final boolean J() {
        if (!C2861a0.c(this.f26267c)) {
            return false;
        }
        C2308e eVar = this.f26306d;
        t.c(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        if (((C1988h) eVar).r()) {
            return true;
        }
        return false;
    }

    private final void K(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    /* access modifiers changed from: private */
    public static final J Q(l lVar, Throwable th, Object obj, C2312i iVar) {
        lVar.invoke(th);
        return J.f19942a;
    }

    public static /* synthetic */ void S(C2886n nVar, Object obj, int i5, q qVar, int i6, Object obj2) {
        if (obj2 == null) {
            if ((i6 & 4) != 0) {
                qVar = null;
            }
            nVar.R(obj, i5, qVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object T(M0 m02, Object obj, int i5, q qVar, Object obj2) {
        C2880k kVar;
        if (obj instanceof C2854A) {
            return obj;
        }
        if ((!C2861a0.b(i5) && obj2 == null) || (qVar == null && !(m02 instanceof C2880k) && obj2 == null)) {
            return obj;
        }
        if (m02 instanceof C2880k) {
            kVar = (C2880k) m02;
        } else {
            kVar = null;
        }
        return new C2909z(obj, kVar, qVar, obj2, (Throwable) null, 16, (C2633k) null);
    }

    private final boolean U() {
        int i5;
        AtomicIntegerFieldUpdater A4 = f26303f;
        do {
            i5 = A4.get(this);
            int i6 = i5 >> 29;
            if (i6 != 0) {
                if (i6 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f26303f.compareAndSet(this, i5, 1073741824 + (536870911 & i5)));
        return true;
    }

    private final D V(Object obj, Object obj2, q qVar) {
        AtomicReferenceFieldUpdater C4 = f26304g;
        while (true) {
            Object obj3 = C4.get(this);
            if (obj3 instanceof M0) {
                Object obj4 = obj;
                Object obj5 = obj2;
                q qVar2 = qVar;
                if (a.a(f26304g, this, obj3, T((M0) obj3, obj4, this.f26267c, qVar2, obj5))) {
                    t();
                    return C2888o.f26308a;
                }
                obj = obj4;
                qVar = qVar2;
                obj2 = obj5;
            } else {
                Object obj6 = obj2;
                if (!(obj3 instanceof C2909z) || obj6 == null || ((C2909z) obj3).f26325d != obj6) {
                    return null;
                }
                return C2888o.f26308a;
            }
        }
    }

    private final boolean W() {
        int i5;
        AtomicIntegerFieldUpdater A4 = f26303f;
        do {
            i5 = A4.get(this);
            int i6 = i5 >> 29;
            if (i6 != 0) {
                if (i6 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f26303f.compareAndSet(this, i5, 536870912 + (536870911 & i5)));
        return true;
    }

    private final Void m(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void p(A a5, Throwable th) {
        int i5 = f26303f.get(this) & 536870911;
        if (i5 != 536870911) {
            try {
                a5.s(i5, th, getContext());
            } catch (Throwable th2) {
                C2312i context = getContext();
                K.a(context, new C2855B("Exception in invokeOnCancellation handler for " + this, th2));
            }
        } else {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
    }

    private final boolean r(Throwable th) {
        if (!J()) {
            return false;
        }
        C2308e eVar = this.f26306d;
        t.c(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((C1988h) eVar).s(th);
    }

    private final void t() {
        if (!J()) {
            s();
        }
    }

    private final void u(int i5) {
        if (!U()) {
            C2861a0.a(this, i5);
        }
    }

    private final C2869e0 w() {
        return (C2869e0) f26305h.get(this);
    }

    private final String z() {
        Object y4 = y();
        if (y4 instanceof M0) {
            return "Active";
        }
        if (y4 instanceof C2892q) {
            return "Cancelled";
        }
        return "Completed";
    }

    public void D() {
        C2869e0 F4 = F();
        if (F4 != null && I()) {
            F4.dispose();
            f26305h.set(this, L0.f26244a);
        }
    }

    public void E(Object obj) {
        u(this.f26267c);
    }

    public final void H(C2880k kVar) {
        G(kVar);
    }

    public boolean I() {
        return !(y() instanceof M0);
    }

    /* access modifiers changed from: protected */
    public String L() {
        return "CancellableContinuation";
    }

    public final void M(Throwable th) {
        if (!r(th)) {
            k(th);
            t();
        }
    }

    public final void N() {
        C1988h hVar;
        Throwable u5;
        C2308e eVar = this.f26306d;
        if (eVar instanceof C1988h) {
            hVar = (C1988h) eVar;
        } else {
            hVar = null;
        }
        if (hVar != null && (u5 = hVar.u(this)) != null) {
            s();
            k(u5);
        }
    }

    public final boolean O() {
        Object obj = f26304g.get(this);
        if (!(obj instanceof C2909z) || ((C2909z) obj).f26325d == null) {
            f26303f.set(this, 536870911);
            f26304g.set(this, C2866d.f26276a);
            return true;
        }
        s();
        return false;
    }

    public void P(Object obj, l lVar) {
        C2884m mVar;
        int i5 = this.f26267c;
        if (lVar != null) {
            mVar = new C2884m(lVar);
        } else {
            mVar = null;
        }
        R(obj, i5, mVar);
    }

    public final void R(Object obj, int i5, q qVar) {
        AtomicReferenceFieldUpdater C4 = f26304g;
        while (true) {
            Object obj2 = C4.get(this);
            if (obj2 instanceof M0) {
                Object obj3 = obj;
                int i6 = i5;
                q qVar2 = qVar;
                if (a.a(f26304g, this, obj2, T((M0) obj2, obj3, i6, qVar2, (Object) null))) {
                    t();
                    u(i6);
                    return;
                }
                obj = obj3;
                i5 = i6;
                qVar = qVar2;
            } else {
                Object obj4 = obj;
                q qVar3 = qVar;
                if (obj2 instanceof C2892q) {
                    C2892q qVar4 = (C2892q) obj2;
                    if (qVar4.e()) {
                        if (qVar3 != null) {
                            o(qVar3, qVar4.f26214a, obj4);
                            return;
                        }
                        return;
                    }
                }
                m(obj4);
                throw new C2219h();
            }
        }
    }

    public void a(A a5, int i5) {
        int i6;
        AtomicIntegerFieldUpdater A4 = f26303f;
        do {
            i6 = A4.get(this);
            if ((i6 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!A4.compareAndSet(this, i6, ((i6 >> 29) << 29) + i5));
        G(a5);
    }

    public void b(Object obj, Throwable th) {
        Throwable th2;
        AtomicReferenceFieldUpdater C4 = f26304g;
        while (true) {
            Object obj2 = C4.get(this);
            if (obj2 instanceof M0) {
                throw new IllegalStateException("Not completed");
            } else if (!(obj2 instanceof C2854A)) {
                if (obj2 instanceof C2909z) {
                    C2909z zVar = (C2909z) obj2;
                    if (!zVar.c()) {
                        Throwable th3 = th;
                        th2 = th3;
                        if (a.a(f26304g, this, obj2, C2909z.b(zVar, (Object) null, (C2880k) null, (q) null, (Object) null, th3, 15, (Object) null))) {
                            zVar.d(this, th2);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once");
                    }
                } else {
                    th2 = th;
                    if (a.a(f26304g, this, obj2, new C2909z(obj2, (C2880k) null, (q) null, (Object) null, th2, 14, (C2633k) null))) {
                        return;
                    }
                }
                th = th2;
            } else {
                return;
            }
        }
    }

    public void c(Object obj, q qVar) {
        R(obj, this.f26267c, qVar);
    }

    public final C2308e d() {
        return this.f26306d;
    }

    public Throwable e(Object obj) {
        Throwable e5 = super.e(obj);
        if (e5 != null) {
            return e5;
        }
        return null;
    }

    public Object f(Object obj) {
        if (obj instanceof C2909z) {
            return ((C2909z) obj).f26322a;
        }
        return obj;
    }

    public void g(l lVar) {
        C2890p.c(this, new C2880k.a(lVar));
    }

    public e getCallerFrame() {
        C2308e eVar = this.f26306d;
        if (eVar instanceof e) {
            return (e) eVar;
        }
        return null;
    }

    public C2312i getContext() {
        return this.f26307e;
    }

    public void h(I i5, Object obj) {
        C1988h hVar;
        int i6;
        C2308e eVar = this.f26306d;
        I i7 = null;
        if (eVar instanceof C1988h) {
            hVar = (C1988h) eVar;
        } else {
            hVar = null;
        }
        if (hVar != null) {
            i7 = hVar.f17394d;
        }
        if (i7 == i5) {
            i6 = 4;
        } else {
            i6 = this.f26267c;
        }
        S(this, obj, i6, (q) null, 4, (Object) null);
    }

    public Object j() {
        return y();
    }

    public boolean k(Throwable th) {
        Object obj;
        boolean z4;
        AtomicReferenceFieldUpdater C4 = f26304g;
        do {
            obj = C4.get(this);
            z4 = false;
            if (!(obj instanceof M0)) {
                return false;
            }
            if ((obj instanceof C2880k) || (obj instanceof A)) {
                z4 = true;
            }
        } while (!a.a(f26304g, this, obj, new C2892q(this, th, z4)));
        M0 m02 = (M0) obj;
        if (m02 instanceof C2880k) {
            n((C2880k) obj, th);
        } else if (m02 instanceof A) {
            p((A) obj, th);
        }
        t();
        u(this.f26267c);
        return true;
    }

    public final void n(C2880k kVar, Throwable th) {
        try {
            kVar.a(th);
        } catch (Throwable th2) {
            C2312i context = getContext();
            K.a(context, new C2855B("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void o(q qVar, Throwable th, Object obj) {
        try {
            qVar.invoke(th, obj, getContext());
        } catch (Throwable th2) {
            C2312i context = getContext();
            K.a(context, new C2855B("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public Object q(Object obj, Object obj2, q qVar) {
        return V(obj, obj2, qVar);
    }

    public void resumeWith(Object obj) {
        S(this, C2856C.c(obj, this), this.f26267c, (q) null, 4, (Object) null);
    }

    public final void s() {
        C2869e0 w4 = w();
        if (w4 != null) {
            w4.dispose();
            f26305h.set(this, L0.f26244a);
        }
    }

    public String toString() {
        return L() + '(' + Q.c(this.f26306d) + "){" + z() + "}@" + Q.b(this);
    }

    public Throwable v(C2908y0 y0Var) {
        return y0Var.m();
    }

    public final Object x() {
        C2908y0 y0Var;
        boolean J4 = J();
        if (W()) {
            if (w() == null) {
                F();
            }
            if (J4) {
                N();
            }
            return C2316b.f();
        }
        if (J4) {
            N();
        }
        Object y4 = y();
        if (y4 instanceof C2854A) {
            throw ((C2854A) y4).f26214a;
        } else if (!C2861a0.b(this.f26267c) || (y0Var = (C2908y0) getContext().get(C2908y0.f26320k0)) == null || y0Var.isActive()) {
            return f(y4);
        } else {
            CancellationException m5 = y0Var.m();
            b(y4, m5);
            throw m5;
        }
    }

    public final Object y() {
        return f26304g.get(this);
    }
}
