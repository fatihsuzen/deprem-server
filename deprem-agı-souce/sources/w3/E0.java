package w3;

import B3.C1995o;
import W2.C2216e;
import W2.J;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k3.l;
import k3.p;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2908y0;

public class E0 implements C2908y0, C2899u, N0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f26219a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f26220b;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    private static final class a extends C2886n {

        /* renamed from: i  reason: collision with root package name */
        private final E0 f26221i;

        public a(C2308e eVar, E0 e02) {
            super(eVar, 1);
            this.f26221i = e02;
        }

        /* access modifiers changed from: protected */
        public String L() {
            return "AwaitContinuation";
        }

        public Throwable v(C2908y0 y0Var) {
            Throwable e5;
            Object e02 = this.f26221i.e0();
            if ((e02 instanceof c) && (e5 = ((c) e02).e()) != null) {
                return e5;
            }
            if (e02 instanceof C2854A) {
                return ((C2854A) e02).f26214a;
            }
            return y0Var.m();
        }
    }

    private static final class b extends D0 {

        /* renamed from: e  reason: collision with root package name */
        private final E0 f26222e;

        /* renamed from: f  reason: collision with root package name */
        private final c f26223f;

        /* renamed from: g  reason: collision with root package name */
        private final C2897t f26224g;

        /* renamed from: h  reason: collision with root package name */
        private final Object f26225h;

        public b(E0 e02, c cVar, C2897t tVar, Object obj) {
            this.f26222e = e02;
            this.f26223f = cVar;
            this.f26224g = tVar;
            this.f26225h = obj;
        }

        public boolean u() {
            return false;
        }

        public void v(Throwable th) {
            this.f26222e.T(this.f26223f, this.f26224g, this.f26225h);
        }
    }

    private static final class c implements C2900u0 {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f26226b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f26227c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f26228d;
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile;
        private volatile /* synthetic */ Object _rootCause$volatile;

        /* renamed from: a  reason: collision with root package name */
        private final J0 f26229a;

        static {
            Class<c> cls = c.class;
            f26226b = AtomicIntegerFieldUpdater.newUpdater(cls, "_isCompleting$volatile");
            Class<Object> cls2 = Object.class;
            f26227c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_rootCause$volatile");
            f26228d = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_exceptionsHolder$volatile");
        }

        public c(J0 j02, boolean z4, Throwable th) {
            this.f26229a = j02;
            this._isCompleting$volatile = z4 ? 1 : 0;
            this._rootCause$volatile = th;
        }

        private final ArrayList c() {
            return new ArrayList(4);
        }

        private final Object d() {
            return f26228d.get(this);
        }

        private final void n(Object obj) {
            f26228d.set(this, obj);
        }

        public final void a(Throwable th) {
            Throwable e5 = e();
            if (e5 == null) {
                o(th);
            } else if (th != e5) {
                Object d5 = d();
                if (d5 == null) {
                    n(th);
                } else if (d5 instanceof Throwable) {
                    if (th != d5) {
                        ArrayList c5 = c();
                        c5.add(d5);
                        c5.add(th);
                        n(c5);
                    }
                } else if (d5 instanceof ArrayList) {
                    ((ArrayList) d5).add(th);
                } else {
                    throw new IllegalStateException(("State is " + d5).toString());
                }
            }
        }

        public J0 b() {
            return this.f26229a;
        }

        public final Throwable e() {
            return (Throwable) f26227c.get(this);
        }

        public final boolean i() {
            if (e() != null) {
                return true;
            }
            return false;
        }

        public boolean isActive() {
            if (e() == null) {
                return true;
            }
            return false;
        }

        public final boolean j() {
            if (f26226b.get(this) != 0) {
                return true;
            }
            return false;
        }

        public final boolean k() {
            if (d() == F0.f26234e) {
                return true;
            }
            return false;
        }

        public final List l(Throwable th) {
            ArrayList arrayList;
            Object d5 = d();
            if (d5 == null) {
                arrayList = c();
            } else if (d5 instanceof Throwable) {
                ArrayList c5 = c();
                c5.add(d5);
                arrayList = c5;
            } else if (d5 instanceof ArrayList) {
                arrayList = (ArrayList) d5;
            } else {
                throw new IllegalStateException(("State is " + d5).toString());
            }
            Throwable e5 = e();
            if (e5 != null) {
                arrayList.add(0, e5);
            }
            if (th != null && !t.a(th, e5)) {
                arrayList.add(th);
            }
            n(F0.f26234e);
            return arrayList;
        }

        public final void m(boolean z4) {
            f26226b.set(this, z4 ? 1 : 0);
        }

        public final void o(Throwable th) {
            f26227c.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + i() + ", completing=" + j() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + b() + ']';
        }
    }

    static {
        Class<E0> cls = E0.class;
        Class<Object> cls2 = Object.class;
        f26219a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state$volatile");
        f26220b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_parentHandle$volatile");
    }

    public E0(boolean z4) {
        C2875h0 h0Var;
        if (z4) {
            h0Var = F0.f26236g;
        } else {
            h0Var = F0.f26235f;
        }
        this._state$volatile = h0Var;
    }

    private final int C0(Object obj) {
        if (obj instanceof C2875h0) {
            if (((C2875h0) obj).isActive()) {
                return 0;
            }
            if (!androidx.concurrent.futures.a.a(f26219a, this, obj, F0.f26236g)) {
                return -1;
            }
            x0();
            return 1;
        } else if (!(obj instanceof C2898t0)) {
            return 0;
        } else {
            if (!androidx.concurrent.futures.a.a(f26219a, this, obj, ((C2898t0) obj).b())) {
                return -1;
            }
            x0();
            return 1;
        }
    }

    private final String D0(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.i()) {
                return "Cancelling";
            }
            if (cVar.j()) {
                return "Completing";
            }
            return "Active";
        } else if (obj instanceof C2900u0) {
            if (((C2900u0) obj).isActive()) {
                return "Active";
            }
            return "New";
        } else if (obj instanceof C2854A) {
            return "Cancelled";
        } else {
            return "Completed";
        }
    }

    public static /* synthetic */ CancellationException F0(E0 e02, Throwable th, String str, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 1) != 0) {
                str = null;
            }
            return e02.E0(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final void H(Throwable th, List list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Throwable th2 = (Throwable) it.next();
                if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                    C2216e.a(th, th2);
                }
            }
        }
    }

    private final boolean H0(C2900u0 u0Var, Object obj) {
        if (!androidx.concurrent.futures.a.a(f26219a, this, u0Var, F0.g(obj))) {
            return false;
        }
        v0((Throwable) null);
        w0(obj);
        S(u0Var, obj);
        return true;
    }

    private final boolean I0(C2900u0 u0Var, Throwable th) {
        J0 b02 = b0(u0Var);
        if (b02 == null) {
            return false;
        }
        if (!androidx.concurrent.futures.a.a(f26219a, this, u0Var, new c(b02, false, th))) {
            return false;
        }
        t0(b02, th);
        return true;
    }

    private final Object J0(Object obj, Object obj2) {
        if (!(obj instanceof C2900u0)) {
            return F0.f26230a;
        }
        if ((!(obj instanceof C2875h0) && !(obj instanceof D0)) || (obj instanceof C2897t) || (obj2 instanceof C2854A)) {
            return K0((C2900u0) obj, obj2);
        }
        if (H0((C2900u0) obj, obj2)) {
            return obj2;
        }
        return F0.f26232c;
    }

    private final Object K(C2308e eVar) {
        a aVar = new a(C2316b.c(eVar), this);
        aVar.D();
        C2890p.a(aVar, C0.j(this, false, new O0(aVar), 1, (Object) null));
        Object x4 = aVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        return x4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0067, code lost:
        if (r2 == null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0069, code lost:
        t0(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006c, code lost:
        r6 = s0(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0070, code lost:
        if (r6 == null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0076, code lost:
        if (L0(r1, r6, r7) == false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x007a, code lost:
        return w3.F0.f26231b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x007b, code lost:
        r0.f(2);
        r6 = s0(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0083, code lost:
        if (r6 == null) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0089, code lost:
        if (L0(r1, r6, r7) == false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x008d, code lost:
        return w3.F0.f26231b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0092, code lost:
        return V(r1, r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object K0(w3.C2900u0 r6, java.lang.Object r7) {
        /*
            r5 = this;
            w3.J0 r0 = r5.b0(r6)
            if (r0 != 0) goto L_0x000b
            B3.D r6 = w3.F0.f26232c
            return r6
        L_0x000b:
            boolean r1 = r6 instanceof w3.E0.c
            r2 = 0
            if (r1 == 0) goto L_0x0014
            r1 = r6
            w3.E0$c r1 = (w3.E0.c) r1
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            if (r1 != 0) goto L_0x001d
            w3.E0$c r1 = new w3.E0$c
            r3 = 0
            r1.<init>(r0, r3, r2)
        L_0x001d:
            kotlin.jvm.internal.L r3 = new kotlin.jvm.internal.L
            r3.<init>()
            monitor-enter(r1)
            boolean r4 = r1.j()     // Catch:{ all -> 0x002f }
            if (r4 == 0) goto L_0x0031
            B3.D r6 = w3.F0.f26230a     // Catch:{ all -> 0x002f }
            monitor-exit(r1)
            return r6
        L_0x002f:
            r6 = move-exception
            goto L_0x0093
        L_0x0031:
            r4 = 1
            r1.m(r4)     // Catch:{ all -> 0x002f }
            if (r1 == r6) goto L_0x0047
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f26219a     // Catch:{ all -> 0x002f }
            boolean r6 = androidx.concurrent.futures.a.a(r4, r5, r6, r1)     // Catch:{ all -> 0x002f }
            if (r6 != 0) goto L_0x0047
            B3.D r6 = w3.F0.f26232c     // Catch:{ all -> 0x002f }
            monitor-exit(r1)
            return r6
        L_0x0047:
            boolean r6 = r1.i()     // Catch:{ all -> 0x002f }
            boolean r4 = r7 instanceof w3.C2854A     // Catch:{ all -> 0x002f }
            if (r4 == 0) goto L_0x0053
            r4 = r7
            w3.A r4 = (w3.C2854A) r4     // Catch:{ all -> 0x002f }
            goto L_0x0054
        L_0x0053:
            r4 = r2
        L_0x0054:
            if (r4 == 0) goto L_0x005b
            java.lang.Throwable r4 = r4.f26214a     // Catch:{ all -> 0x002f }
            r1.a(r4)     // Catch:{ all -> 0x002f }
        L_0x005b:
            java.lang.Throwable r4 = r1.e()     // Catch:{ all -> 0x002f }
            if (r6 != 0) goto L_0x0062
            r2 = r4
        L_0x0062:
            r3.f24690a = r2     // Catch:{ all -> 0x002f }
            W2.J r6 = W2.J.f19942a     // Catch:{ all -> 0x002f }
            monitor-exit(r1)
            if (r2 == 0) goto L_0x006c
            r5.t0(r0, r2)
        L_0x006c:
            w3.t r6 = r5.s0(r0)
            if (r6 == 0) goto L_0x007b
            boolean r6 = r5.L0(r1, r6, r7)
            if (r6 == 0) goto L_0x007b
            B3.D r6 = w3.F0.f26231b
            return r6
        L_0x007b:
            r6 = 2
            r0.f(r6)
            w3.t r6 = r5.s0(r0)
            if (r6 == 0) goto L_0x008e
            boolean r6 = r5.L0(r1, r6, r7)
            if (r6 == 0) goto L_0x008e
            B3.D r6 = w3.F0.f26231b
            return r6
        L_0x008e:
            java.lang.Object r6 = r5.V(r1, r7)
            return r6
        L_0x0093:
            monitor-exit(r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.E0.K0(w3.u0, java.lang.Object):java.lang.Object");
    }

    private final boolean L0(c cVar, C2897t tVar, Object obj) {
        while (B0.i(tVar.f26314e, false, new b(this, cVar, tVar, obj)) == L0.f26244a) {
            tVar = s0(tVar);
            if (tVar == null) {
                return false;
            }
        }
        return true;
    }

    private final Object O(Object obj) {
        Object J02;
        do {
            Object e02 = e0();
            if (!(e02 instanceof C2900u0) || ((e02 instanceof c) && ((c) e02).j())) {
                return F0.f26230a;
            }
            J02 = J0(e02, new C2854A(U(obj), false, 2, (C2633k) null));
        } while (J02 == F0.f26232c);
        return J02;
    }

    private final boolean P(Throwable th) {
        if (l0()) {
            return true;
        }
        boolean z4 = th instanceof CancellationException;
        C2895s d02 = d0();
        if (d02 == null || d02 == L0.f26244a) {
            return z4;
        }
        if (d02.a(th) || z4) {
            return true;
        }
        return false;
    }

    private final void S(C2900u0 u0Var, Object obj) {
        C2854A a5;
        C2895s d02 = d0();
        if (d02 != null) {
            d02.dispose();
            B0(L0.f26244a);
        }
        Throwable th = null;
        if (obj instanceof C2854A) {
            a5 = (C2854A) obj;
        } else {
            a5 = null;
        }
        if (a5 != null) {
            th = a5.f26214a;
        }
        if (u0Var instanceof D0) {
            try {
                ((D0) u0Var).v(th);
            } catch (Throwable th2) {
                i0(new C2855B("Exception in completion handler " + u0Var + " for " + this, th2));
            }
        } else {
            J0 b5 = u0Var.b();
            if (b5 != null) {
                u0(b5, th);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void T(c cVar, C2897t tVar, Object obj) {
        C2897t s02 = s0(tVar);
        if (s02 == null || !L0(cVar, s02, obj)) {
            cVar.b().f(2);
            C2897t s03 = s0(tVar);
            if (s03 == null || !L0(cVar, s03, obj)) {
                I(V(cVar, obj));
            }
        }
    }

    private final Throwable U(Object obj) {
        boolean z4;
        if (obj == null) {
            z4 = true;
        } else {
            z4 = obj instanceof Throwable;
        }
        if (z4) {
            Throwable th = (Throwable) obj;
            if (th == null) {
                return new C2910z0(Q(), (Throwable) null, this);
            }
            return th;
        }
        t.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((N0) obj).y();
    }

    private final Object V(c cVar, Object obj) {
        C2854A a5;
        Throwable th;
        boolean i5;
        Throwable Y4;
        if (obj instanceof C2854A) {
            a5 = (C2854A) obj;
        } else {
            a5 = null;
        }
        if (a5 != null) {
            th = a5.f26214a;
        } else {
            th = null;
        }
        synchronized (cVar) {
            i5 = cVar.i();
            List l5 = cVar.l(th);
            Y4 = Y(cVar, l5);
            if (Y4 != null) {
                H(Y4, l5);
            }
        }
        if (!(Y4 == null || Y4 == th)) {
            obj = new C2854A(Y4, false, 2, (C2633k) null);
        }
        if (Y4 != null && (P(Y4) || h0(Y4))) {
            t.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((C2854A) obj).c();
        }
        if (!i5) {
            v0(Y4);
        }
        w0(obj);
        androidx.concurrent.futures.a.a(f26219a, this, cVar, F0.g(obj));
        S(cVar, obj);
        return obj;
    }

    private final Throwable X(Object obj) {
        C2854A a5;
        if (obj instanceof C2854A) {
            a5 = (C2854A) obj;
        } else {
            a5 = null;
        }
        if (a5 != null) {
            return a5.f26214a;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Throwable Y(w3.E0.c r5, java.util.List r6) {
        /*
            r4 = this;
            boolean r0 = r6.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0018
            boolean r5 = r5.i()
            if (r5 == 0) goto L_0x0017
            w3.z0 r5 = new w3.z0
            java.lang.String r6 = r4.Q()
            r5.<init>(r6, r1, r4)
            return r5
        L_0x0017:
            return r1
        L_0x0018:
            r5 = r6
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r0 = r5.iterator()
        L_0x001f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0031
            java.lang.Object r2 = r0.next()
            r3 = r2
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            boolean r3 = r3 instanceof java.util.concurrent.CancellationException
            if (r3 != 0) goto L_0x001f
            goto L_0x0032
        L_0x0031:
            r2 = r1
        L_0x0032:
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            if (r2 == 0) goto L_0x0037
            return r2
        L_0x0037:
            r0 = 0
            java.lang.Object r6 = r6.get(r0)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            boolean r0 = r6 instanceof w3.X0
            if (r0 == 0) goto L_0x005f
            java.util.Iterator r5 = r5.iterator()
        L_0x0046:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x005a
            java.lang.Object r0 = r5.next()
            r2 = r0
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            if (r2 == r6) goto L_0x0046
            boolean r2 = r2 instanceof w3.X0
            if (r2 == 0) goto L_0x0046
            r1 = r0
        L_0x005a:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            if (r1 == 0) goto L_0x005f
            return r1
        L_0x005f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.E0.Y(w3.E0$c, java.util.List):java.lang.Throwable");
    }

    private final J0 b0(C2900u0 u0Var) {
        J0 b5 = u0Var.b();
        if (b5 != null) {
            return b5;
        }
        if (u0Var instanceof C2875h0) {
            return new J0();
        }
        if (u0Var instanceof D0) {
            z0((D0) u0Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + u0Var).toString());
    }

    private final boolean m0() {
        Object e02;
        do {
            e02 = e0();
            if (!(e02 instanceof C2900u0)) {
                return false;
            }
        } while (C0(e02) < 0);
        return true;
    }

    private final Object n0(C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        C2890p.a(nVar, C0.j(this, false, new P0(nVar), 1, (Object) null));
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        if (x4 == C2316b.f()) {
            return x4;
        }
        return J.f19942a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        if (r0 == null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        t0(((w3.E0.c) r2).b(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
        return w3.F0.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object o0(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r6.e0()
            boolean r3 = r2 instanceof w3.E0.c
            if (r3 == 0) goto L_0x0050
            monitor-enter(r2)
            r3 = r2
            w3.E0$c r3 = (w3.E0.c) r3     // Catch:{ all -> 0x001a }
            boolean r3 = r3.k()     // Catch:{ all -> 0x001a }
            if (r3 == 0) goto L_0x001c
            B3.D r7 = w3.F0.f26233d     // Catch:{ all -> 0x001a }
            monitor-exit(r2)
            return r7
        L_0x001a:
            r7 = move-exception
            goto L_0x004e
        L_0x001c:
            r3 = r2
            w3.E0$c r3 = (w3.E0.c) r3     // Catch:{ all -> 0x001a }
            boolean r3 = r3.i()     // Catch:{ all -> 0x001a }
            if (r7 != 0) goto L_0x0027
            if (r3 != 0) goto L_0x0033
        L_0x0027:
            if (r1 != 0) goto L_0x002d
            java.lang.Throwable r1 = r6.U(r7)     // Catch:{ all -> 0x001a }
        L_0x002d:
            r7 = r2
            w3.E0$c r7 = (w3.E0.c) r7     // Catch:{ all -> 0x001a }
            r7.a(r1)     // Catch:{ all -> 0x001a }
        L_0x0033:
            r7 = r2
            w3.E0$c r7 = (w3.E0.c) r7     // Catch:{ all -> 0x001a }
            java.lang.Throwable r7 = r7.e()     // Catch:{ all -> 0x001a }
            if (r3 != 0) goto L_0x003d
            r0 = r7
        L_0x003d:
            monitor-exit(r2)
            if (r0 == 0) goto L_0x0049
            w3.E0$c r2 = (w3.E0.c) r2
            w3.J0 r7 = r2.b()
            r6.t0(r7, r0)
        L_0x0049:
            B3.D r7 = w3.F0.f26230a
            return r7
        L_0x004e:
            monitor-exit(r2)
            throw r7
        L_0x0050:
            boolean r3 = r2 instanceof w3.C2900u0
            if (r3 == 0) goto L_0x00a1
            if (r1 != 0) goto L_0x005a
            java.lang.Throwable r1 = r6.U(r7)
        L_0x005a:
            r3 = r2
            w3.u0 r3 = (w3.C2900u0) r3
            boolean r4 = r3.isActive()
            if (r4 == 0) goto L_0x006e
            boolean r2 = r6.I0(r3, r1)
            if (r2 == 0) goto L_0x0002
            B3.D r7 = w3.F0.f26230a
            return r7
        L_0x006e:
            w3.A r3 = new w3.A
            r4 = 0
            r5 = 2
            r3.<init>(r1, r4, r5, r0)
            java.lang.Object r3 = r6.J0(r2, r3)
            B3.D r4 = w3.F0.f26230a
            if (r3 == r4) goto L_0x0086
            B3.D r2 = w3.F0.f26232c
            if (r3 == r2) goto L_0x0002
            return r3
        L_0x0086:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot happen in "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x00a1:
            B3.D r7 = w3.F0.f26233d
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.E0.o0(java.lang.Object):java.lang.Object");
    }

    private final C2897t s0(C1995o oVar) {
        while (oVar.p()) {
            oVar = oVar.l();
        }
        while (true) {
            oVar = oVar.k();
            if (!oVar.p()) {
                if (oVar instanceof C2897t) {
                    return (C2897t) oVar;
                }
                if (oVar instanceof J0) {
                    return null;
                }
            }
        }
    }

    private final void t0(J0 j02, Throwable th) {
        v0(th);
        j02.f(4);
        Object j5 = j02.j();
        t.c(j5, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        C2855B b5 = null;
        for (C1995o oVar = (C1995o) j5; !t.a(oVar, j02); oVar = oVar.k()) {
            if ((oVar instanceof D0) && ((D0) oVar).u()) {
                try {
                    ((D0) oVar).v(th);
                } catch (Throwable th2) {
                    if (b5 != null) {
                        C2216e.a(b5, th2);
                    } else {
                        b5 = new C2855B("Exception in completion handler " + oVar + " for " + this, th2);
                        J j6 = J.f19942a;
                    }
                }
            }
        }
        if (b5 != null) {
            i0(b5);
        }
        P(th);
    }

    private final void u0(J0 j02, Throwable th) {
        j02.f(1);
        Object j5 = j02.j();
        t.c(j5, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        C2855B b5 = null;
        for (C1995o oVar = (C1995o) j5; !t.a(oVar, j02); oVar = oVar.k()) {
            if (oVar instanceof D0) {
                try {
                    ((D0) oVar).v(th);
                } catch (Throwable th2) {
                    if (b5 != null) {
                        C2216e.a(b5, th2);
                    } else {
                        b5 = new C2855B("Exception in completion handler " + oVar + " for " + this, th2);
                        J j6 = J.f19942a;
                    }
                }
            }
        }
        if (b5 != null) {
            i0(b5);
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [w3.t0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void y0(w3.C2875h0 r3) {
        /*
            r2 = this;
            w3.J0 r0 = new w3.J0
            r0.<init>()
            boolean r1 = r3.isActive()
            if (r1 == 0) goto L_0x000c
            goto L_0x0012
        L_0x000c:
            w3.t0 r1 = new w3.t0
            r1.<init>(r0)
            r0 = r1
        L_0x0012:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f26219a
            androidx.concurrent.futures.a.a(r1, r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.E0.y0(w3.h0):void");
    }

    private final void z0(D0 d02) {
        d02.e(new J0());
        androidx.concurrent.futures.a.a(f26219a, this, d02, d02.k());
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A0(w3.D0 r4) {
        /*
            r3 = this;
        L_0x0000:
            java.lang.Object r0 = r3.e0()
            boolean r1 = r0 instanceof w3.D0
            if (r1 == 0) goto L_0x001a
            if (r0 == r4) goto L_0x000b
            goto L_0x0029
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f26219a
            w3.h0 r2 = w3.F0.f26236g
            boolean r0 = androidx.concurrent.futures.a.a(r1, r3, r0, r2)
            if (r0 == 0) goto L_0x0000
            goto L_0x0029
        L_0x001a:
            boolean r1 = r0 instanceof w3.C2900u0
            if (r1 == 0) goto L_0x0029
            w3.u0 r0 = (w3.C2900u0) r0
            w3.J0 r0 = r0.b()
            if (r0 == 0) goto L_0x0029
            r4.q()
        L_0x0029:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.E0.A0(w3.D0):void");
    }

    public final void B0(C2895s sVar) {
        f26220b.set(this, sVar);
    }

    public final boolean C() {
        return !(e0() instanceof C2900u0);
    }

    /* access modifiers changed from: protected */
    public final CancellationException E0(Throwable th, String str) {
        CancellationException cancellationException;
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        } else {
            cancellationException = null;
        }
        if (cancellationException == null) {
            if (str == null) {
                str = Q();
            }
            cancellationException = new C2910z0(str, th, this);
        }
        return cancellationException;
    }

    public final String G0() {
        return r0() + '{' + D0(e0()) + '}';
    }

    /* access modifiers changed from: protected */
    public final Object J(C2308e eVar) {
        Object e02;
        do {
            e02 = e0();
            if (!(e02 instanceof C2900u0)) {
                if (!(e02 instanceof C2854A)) {
                    return F0.h(e02);
                }
                throw ((C2854A) e02).f26214a;
            }
        } while (C0(e02) < 0);
        return K(eVar);
    }

    public final boolean L(Throwable th) {
        return M(th);
    }

    public final boolean M(Object obj) {
        Object a5 = F0.f26230a;
        if (a0() && (a5 = O(obj)) == F0.f26231b) {
            return true;
        }
        if (a5 == F0.f26230a) {
            a5 = o0(obj);
        }
        if (a5 == F0.f26230a || a5 == F0.f26231b) {
            return true;
        }
        if (a5 == F0.f26233d) {
            return false;
        }
        I(a5);
        return true;
    }

    public void N(Throwable th) {
        M(th);
    }

    /* access modifiers changed from: protected */
    public String Q() {
        return "Job was cancelled";
    }

    public boolean R(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        if (!M(th) || !Z()) {
            return false;
        }
        return true;
    }

    public final Object W() {
        Object e02 = e0();
        if (e02 instanceof C2900u0) {
            throw new IllegalStateException("This job has not completed yet");
        } else if (!(e02 instanceof C2854A)) {
            return F0.h(e02);
        } else {
            throw ((C2854A) e02).f26214a;
        }
    }

    public boolean Z() {
        return true;
    }

    public void a(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new C2910z0(Q(), (Throwable) null, this);
        }
        N(cancellationException);
    }

    public boolean a0() {
        return false;
    }

    public C2908y0 c0() {
        C2895s d02 = d0();
        if (d02 != null) {
            return d02.getParent();
        }
        return null;
    }

    public final C2895s d0() {
        return (C2895s) f26220b.get(this);
    }

    public final Object e0() {
        return f26219a.get(this);
    }

    public Object fold(Object obj, p pVar) {
        return C2908y0.a.b(this, obj, pVar);
    }

    public C2312i.b get(C2312i.c cVar) {
        return C2908y0.a.c(this, cVar);
    }

    public final C2312i.c getKey() {
        return C2908y0.f26320k0;
    }

    /* access modifiers changed from: protected */
    public boolean h0(Throwable th) {
        return false;
    }

    public boolean isActive() {
        Object e02 = e0();
        if (!(e02 instanceof C2900u0) || !((C2900u0) e02).isActive()) {
            return false;
        }
        return true;
    }

    public final boolean isCancelled() {
        Object e02 = e0();
        if (e02 instanceof C2854A) {
            return true;
        }
        if (!(e02 instanceof c) || !((c) e02).i()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void j0(C2908y0 y0Var) {
        if (y0Var == null) {
            B0(L0.f26244a);
            return;
        }
        y0Var.start();
        C2895s z4 = y0Var.z(this);
        B0(z4);
        if (C()) {
            z4.dispose();
            B0(L0.f26244a);
        }
    }

    public final C2869e0 k0(boolean z4, D0 d02) {
        boolean z5;
        Throwable th;
        C2854A a5;
        boolean z6;
        c cVar;
        Throwable th2;
        d02.w(this);
        while (true) {
            Object e02 = e0();
            z5 = true;
            th = null;
            if (!(e02 instanceof C2875h0)) {
                if (!(e02 instanceof C2900u0)) {
                    z5 = false;
                    break;
                }
                C2900u0 u0Var = (C2900u0) e02;
                J0 b5 = u0Var.b();
                if (b5 == null) {
                    t.c(e02, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    z0((D0) e02);
                } else {
                    if (d02.u()) {
                        if (u0Var instanceof c) {
                            cVar = (c) u0Var;
                        } else {
                            cVar = null;
                        }
                        if (cVar != null) {
                            th2 = cVar.e();
                        } else {
                            th2 = null;
                        }
                        if (th2 == null) {
                            z6 = b5.c(d02, 5);
                        } else {
                            if (z4) {
                                d02.v(th2);
                            }
                            return L0.f26244a;
                        }
                    } else {
                        z6 = b5.c(d02, 1);
                    }
                    if (z6) {
                        break;
                    }
                }
            } else {
                C2875h0 h0Var = (C2875h0) e02;
                if (!h0Var.isActive()) {
                    y0(h0Var);
                } else if (androidx.concurrent.futures.a.a(f26219a, this, e02, d02)) {
                    break;
                }
            }
        }
        if (z5) {
            return d02;
        }
        if (z4) {
            Object e03 = e0();
            if (e03 instanceof C2854A) {
                a5 = (C2854A) e03;
            } else {
                a5 = null;
            }
            if (a5 != null) {
                th = a5.f26214a;
            }
            d02.v(th);
        }
        return L0.f26244a;
    }

    public final Object l(C2308e eVar) {
        if (!m0()) {
            B0.g(eVar.getContext());
            return J.f19942a;
        }
        Object n02 = n0(eVar);
        if (n02 == C2316b.f()) {
            return n02;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: protected */
    public boolean l0() {
        return false;
    }

    public final CancellationException m() {
        Object e02 = e0();
        if (e02 instanceof c) {
            Throwable e5 = ((c) e02).e();
            if (e5 != null) {
                CancellationException E02 = E0(e5, Q.a(this) + " is cancelling");
                if (E02 != null) {
                    return E02;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (e02 instanceof C2900u0) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (e02 instanceof C2854A) {
            return F0(this, ((C2854A) e02).f26214a, (String) null, 1, (Object) null);
        } else {
            return new C2910z0(Q.a(this) + " has completed normally", (Throwable) null, this);
        }
    }

    public C2312i minusKey(C2312i.c cVar) {
        return C2908y0.a.d(this, cVar);
    }

    public final void n(N0 n02) {
        M(n02);
    }

    public final C2869e0 p(boolean z4, boolean z5, l lVar) {
        D0 d02;
        if (z4) {
            d02 = new C2904w0(lVar);
        } else {
            d02 = new C2906x0(lVar);
        }
        return k0(z5, d02);
    }

    public final boolean p0(Object obj) {
        Object J02;
        do {
            J02 = J0(e0(), obj);
            if (J02 == F0.f26230a) {
                return false;
            }
            if (J02 == F0.f26231b) {
                return true;
            }
        } while (J02 == F0.f26232c);
        I(J02);
        return true;
    }

    public C2312i plus(C2312i iVar) {
        return C2908y0.a.e(this, iVar);
    }

    public final Object q0(Object obj) {
        Object J02;
        do {
            J02 = J0(e0(), obj);
            if (J02 == F0.f26230a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, X(obj));
            }
        } while (J02 == F0.f26232c);
        return J02;
    }

    public String r0() {
        return Q.a(this);
    }

    public final C2869e0 s(l lVar) {
        return k0(true, new C2906x0(lVar));
    }

    public final boolean start() {
        int C02;
        do {
            C02 = C0(e0());
            if (C02 == 0) {
                return false;
            }
        } while (C02 != 1);
        return true;
    }

    public String toString() {
        return G0() + '@' + Q.b(this);
    }

    public CancellationException y() {
        Throwable th;
        Object e02 = e0();
        CancellationException cancellationException = null;
        if (e02 instanceof c) {
            th = ((c) e02).e();
        } else if (e02 instanceof C2854A) {
            th = ((C2854A) e02).f26214a;
        } else if (!(e02 instanceof C2900u0)) {
            th = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + e02).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        }
        if (cancellationException != null) {
            return cancellationException;
        }
        return new C2910z0("Parent job is " + D0(e02), th, this);
    }

    public final C2895s z(C2899u uVar) {
        C2854A a5;
        C2854A a6;
        C2897t tVar = new C2897t(uVar);
        tVar.w(this);
        while (true) {
            Object e02 = e0();
            if (e02 instanceof C2875h0) {
                C2875h0 h0Var = (C2875h0) e02;
                if (!h0Var.isActive()) {
                    y0(h0Var);
                } else if (androidx.concurrent.futures.a.a(f26219a, this, e02, tVar)) {
                    return tVar;
                }
            } else {
                Throwable th = null;
                if (e02 instanceof C2900u0) {
                    J0 b5 = ((C2900u0) e02).b();
                    if (b5 == null) {
                        t.c(e02, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        z0((D0) e02);
                    } else {
                        if (!b5.c(tVar, 7)) {
                            boolean c5 = b5.c(tVar, 3);
                            Object e03 = e0();
                            if (e03 instanceof c) {
                                th = ((c) e03).e();
                            } else {
                                if (e03 instanceof C2854A) {
                                    a6 = (C2854A) e03;
                                } else {
                                    a6 = null;
                                }
                                if (a6 != null) {
                                    th = a6.f26214a;
                                }
                            }
                            tVar.v(th);
                            if (!c5) {
                                return L0.f26244a;
                            }
                        }
                        return tVar;
                    }
                } else {
                    Object e04 = e0();
                    if (e04 instanceof C2854A) {
                        a5 = (C2854A) e04;
                    } else {
                        a5 = null;
                    }
                    if (a5 != null) {
                        th = a5.f26214a;
                    }
                    tVar.v(th);
                    return L0.f26244a;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void x0() {
    }

    /* access modifiers changed from: protected */
    public void I(Object obj) {
    }

    public void i0(Throwable th) {
        throw th;
    }

    /* access modifiers changed from: protected */
    public void v0(Throwable th) {
    }

    /* access modifiers changed from: protected */
    public void w0(Object obj) {
    }
}
