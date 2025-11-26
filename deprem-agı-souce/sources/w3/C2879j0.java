package w3;

import B3.C1997q;
import B3.O;
import B3.P;
import W2.J;
import b3.C2312i;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.t;
import q3.C2729e;
import w3.W;

/* renamed from: w3.j0  reason: case insensitive filesystem */
public abstract class C2879j0 extends C2881k0 implements W {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f26290d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f26291e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f26292f;
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    /* renamed from: w3.j0$a */
    private final class a extends c {

        /* renamed from: c  reason: collision with root package name */
        private final C2882l f26293c;

        public a(long j5, C2882l lVar) {
            super(j5);
            this.f26293c = lVar;
        }

        public void run() {
            this.f26293c.h(C2879j0.this, J.f19942a);
        }

        public String toString() {
            return super.toString() + this.f26293c;
        }
    }

    /* renamed from: w3.j0$b */
    private static final class b extends c {

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f26295c;

        public b(long j5, Runnable runnable) {
            super(j5);
            this.f26295c = runnable;
        }

        public void run() {
            this.f26295c.run();
        }

        public String toString() {
            return super.toString() + this.f26295c;
        }
    }

    /* renamed from: w3.j0$c */
    public static abstract class c implements Runnable, Comparable, C2869e0, P {
        private volatile Object _heap;

        /* renamed from: a  reason: collision with root package name */
        public long f26296a;

        /* renamed from: b  reason: collision with root package name */
        private int f26297b = -1;

        public c(long j5) {
            this.f26296a = j5;
        }

        public O b() {
            Object obj = this._heap;
            if (obj instanceof O) {
                return (O) obj;
            }
            return null;
        }

        public void c(O o5) {
            if (this._heap != C2885m0.f26301a) {
                this._heap = o5;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.");
        }

        /* renamed from: d */
        public int compareTo(c cVar) {
            int i5 = ((this.f26296a - cVar.f26296a) > 0 ? 1 : ((this.f26296a - cVar.f26296a) == 0 ? 0 : -1));
            if (i5 > 0) {
                return 1;
            }
            if (i5 < 0) {
                return -1;
            }
            return 0;
        }

        public final void dispose() {
            d dVar;
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    if (obj != C2885m0.f26301a) {
                        if (obj instanceof d) {
                            dVar = (d) obj;
                        } else {
                            dVar = null;
                        }
                        if (dVar != null) {
                            dVar.h(this);
                        }
                        this._heap = C2885m0.f26301a;
                        J j5 = J.f19942a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final int e(long j5, d dVar, C2879j0 j0Var) {
            synchronized (this) {
                if (this._heap == C2885m0.f26301a) {
                    return 2;
                }
                synchronized (dVar) {
                    try {
                        c cVar = (c) dVar.b();
                        if (j0Var.C()) {
                            return 1;
                        }
                        if (cVar == null) {
                            dVar.f26298c = j5;
                        } else {
                            long j6 = cVar.f26296a;
                            if (j6 - j5 < 0) {
                                j5 = j6;
                            }
                            if (j5 - dVar.f26298c > 0) {
                                dVar.f26298c = j5;
                            }
                        }
                        long j7 = this.f26296a;
                        long j8 = dVar.f26298c;
                        if (j7 - j8 < 0) {
                            this.f26296a = j8;
                        }
                        dVar.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final boolean f(long j5) {
            if (j5 - this.f26296a >= 0) {
                return true;
            }
            return false;
        }

        public int getIndex() {
            return this.f26297b;
        }

        public void setIndex(int i5) {
            this.f26297b = i5;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f26296a + ']';
        }
    }

    /* renamed from: w3.j0$d */
    public static final class d extends O {

        /* renamed from: c  reason: collision with root package name */
        public long f26298c;

        public d(long j5) {
            this.f26298c = j5;
        }
    }

    static {
        Class<C2879j0> cls = C2879j0.class;
        Class<Object> cls2 = Object.class;
        f26290d = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_queue$volatile");
        f26291e = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_delayed$volatile");
        f26292f = AtomicIntegerFieldUpdater.newUpdater(cls, "_isCompleted$volatile");
    }

    /* access modifiers changed from: private */
    public final boolean C() {
        if (f26292f.get(this) != 0) {
            return true;
        }
        return false;
    }

    private final void V() {
        AtomicReferenceFieldUpdater c02 = f26290d;
        while (true) {
            Object obj = c02.get(this);
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f26290d, this, (Object) null, C2885m0.f26302b)) {
                    return;
                }
            } else if (obj instanceof C1997q) {
                ((C1997q) obj).d();
                return;
            } else if (obj != C2885m0.f26302b) {
                C1997q qVar = new C1997q(8, true);
                t.c(obj, "null cannot be cast to non-null type java.lang.Runnable");
                qVar.a((Runnable) obj);
                if (androidx.concurrent.futures.a.a(f26290d, this, obj, qVar)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final Runnable W() {
        AtomicReferenceFieldUpdater c02 = f26290d;
        while (true) {
            Object obj = c02.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof C1997q) {
                t.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                C1997q qVar = (C1997q) obj;
                Object m5 = qVar.m();
                if (m5 != C1997q.f17417h) {
                    return (Runnable) m5;
                }
                androidx.concurrent.futures.a.a(f26290d, this, obj, qVar.l());
            } else if (obj == C2885m0.f26302b) {
                return null;
            } else {
                if (androidx.concurrent.futures.a.a(f26290d, this, obj, (Object) null)) {
                    t.c(obj, "null cannot be cast to non-null type java.lang.Runnable");
                    return (Runnable) obj;
                }
            }
        }
    }

    private final void Y() {
        P p5;
        boolean z4;
        d dVar = (d) f26291e.get(this);
        if (dVar != null && !dVar.e()) {
            C2864c.a();
            long nanoTime = System.nanoTime();
            do {
                synchronized (dVar) {
                    try {
                        P b5 = dVar.b();
                        p5 = null;
                        if (b5 != null) {
                            c cVar = (c) b5;
                            if (cVar.f(nanoTime)) {
                                z4 = Z(cVar);
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                                p5 = dVar.i(0);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } while (((c) p5) != null);
        }
    }

    private final boolean Z(Runnable runnable) {
        AtomicReferenceFieldUpdater c02 = f26290d;
        while (true) {
            Object obj = c02.get(this);
            if (C()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f26290d, this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof C1997q) {
                t.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                C1997q qVar = (C1997q) obj;
                int a5 = qVar.a(runnable);
                if (a5 == 0) {
                    return true;
                }
                if (a5 == 1) {
                    androidx.concurrent.futures.a.a(f26290d, this, obj, qVar.l());
                } else if (a5 == 2) {
                    return false;
                }
            } else if (obj == C2885m0.f26302b) {
                return false;
            } else {
                C1997q qVar2 = new C1997q(8, true);
                t.c(obj, "null cannot be cast to non-null type java.lang.Runnable");
                qVar2.a((Runnable) obj);
                qVar2.a(runnable);
                if (androidx.concurrent.futures.a.a(f26290d, this, obj, qVar2)) {
                    return true;
                }
            }
        }
    }

    private final void e0() {
        c cVar;
        C2864c.a();
        long nanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) f26291e.get(this);
            if (dVar != null && (cVar = (c) dVar.j()) != null) {
                S(nanoTime, cVar);
            } else {
                return;
            }
        }
    }

    private final int h0(long j5, c cVar) {
        if (C()) {
            return 1;
        }
        d dVar = (d) f26291e.get(this);
        if (dVar == null) {
            androidx.concurrent.futures.a.a(f26291e, this, (Object) null, new d(j5));
            Object obj = f26291e.get(this);
            t.b(obj);
            dVar = (d) obj;
        }
        return cVar.e(j5, dVar, this);
    }

    private final void j0(boolean z4) {
        f26292f.set(this, z4 ? 1 : 0);
    }

    private final boolean k0(c cVar) {
        c cVar2;
        d dVar = (d) f26291e.get(this);
        if (dVar != null) {
            cVar2 = (c) dVar.f();
        } else {
            cVar2 = null;
        }
        if (cVar2 == cVar) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public long J() {
        c cVar;
        if (super.J() == 0) {
            return 0;
        }
        Object obj = f26290d.get(this);
        if (obj != null) {
            if (obj instanceof C1997q) {
                if (!((C1997q) obj).j()) {
                    return 0;
                }
            } else if (obj == C2885m0.f26302b) {
                return Long.MAX_VALUE;
            } else {
                return 0;
            }
        }
        d dVar = (d) f26291e.get(this);
        if (dVar == null || (cVar = (c) dVar.f()) == null) {
            return Long.MAX_VALUE;
        }
        long j5 = cVar.f26296a;
        C2864c.a();
        return C2729e.d(j5 - System.nanoTime(), 0);
    }

    public long O() {
        if (P()) {
            return 0;
        }
        Y();
        Runnable W4 = W();
        if (W4 == null) {
            return J();
        }
        W4.run();
        return 0;
    }

    public void X(Runnable runnable) {
        Y();
        if (Z(runnable)) {
            T();
        } else {
            S.f26256g.X(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public boolean d0() {
        if (!N()) {
            return false;
        }
        d dVar = (d) f26291e.get(this);
        if (dVar != null && !dVar.e()) {
            return false;
        }
        Object obj = f26290d.get(this);
        if (obj == null) {
            return true;
        }
        if (obj instanceof C1997q) {
            return ((C1997q) obj).j();
        }
        if (obj == C2885m0.f26302b) {
            return true;
        }
        return false;
    }

    public final void dispatch(C2312i iVar, Runnable runnable) {
        X(runnable);
    }

    /* access modifiers changed from: protected */
    public final void f0() {
        f26290d.set(this, (Object) null);
        f26291e.set(this, (Object) null);
    }

    public final void g0(long j5, c cVar) {
        int h02 = h0(j5, cVar);
        if (h02 != 0) {
            if (h02 == 1) {
                S(j5, cVar);
            } else if (h02 != 2) {
                throw new IllegalStateException("unexpected result");
            }
        } else if (k0(cVar)) {
            T();
        }
    }

    /* access modifiers changed from: protected */
    public final C2869e0 i0(long j5, Runnable runnable) {
        long c5 = C2885m0.c(j5);
        if (c5 >= 4611686018427387903L) {
            return L0.f26244a;
        }
        C2864c.a();
        long nanoTime = System.nanoTime();
        b bVar = new b(c5 + nanoTime, runnable);
        g0(nanoTime, bVar);
        return bVar;
    }

    public void o(long j5, C2882l lVar) {
        long c5 = C2885m0.c(j5);
        if (c5 < 4611686018427387903L) {
            C2864c.a();
            long nanoTime = System.nanoTime();
            a aVar = new a(c5 + nanoTime, lVar);
            g0(nanoTime, aVar);
            C2890p.a(lVar, aVar);
        }
    }

    public C2869e0 q(long j5, Runnable runnable, C2312i iVar) {
        return W.a.a(this, j5, runnable, iVar);
    }

    public void shutdown() {
        W0.f26260a.c();
        j0(true);
        V();
        do {
        } while (O() <= 0);
        e0();
    }
}
