package F3;

import B3.A;
import B3.B;
import B3.C1981a;
import E3.c;
import W2.J;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k3.p;
import k3.q;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.C2639q;
import kotlin.jvm.internal.t;
import w3.C2882l;
import w3.C2886n;
import w3.C2890p;
import w3.d1;
import y3.l;

public class j {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18122c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f18123d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18124e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f18125f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f18126g;
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* renamed from: a  reason: collision with root package name */
    private final int f18127a;

    /* renamed from: b  reason: collision with root package name */
    private final q f18128b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    /* synthetic */ class a extends C2639q implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final a f18129a = new a();

        a() {
            super(2, l.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final m g(long j5, m mVar) {
            return l.j(j5, mVar);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return g(((Number) obj).longValue(), (m) obj2);
        }
    }

    /* synthetic */ class b extends C2639q implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final b f18130a = new b();

        b() {
            super(2, l.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final m g(long j5, m mVar) {
            return l.j(j5, mVar);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return g(((Number) obj).longValue(), (m) obj2);
        }
    }

    static {
        Class<j> cls = j.class;
        Class<Object> cls2 = Object.class;
        f18122c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "head$volatile");
        f18123d = AtomicLongFieldUpdater.newUpdater(cls, "deqIdx$volatile");
        f18124e = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "tail$volatile");
        f18125f = AtomicLongFieldUpdater.newUpdater(cls, "enqIdx$volatile");
        f18126g = AtomicIntegerFieldUpdater.newUpdater(cls, "_availablePermits$volatile");
    }

    public j(int i5, int i6) {
        this.f18127a = i5;
        if (i5 <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i5).toString());
        } else if (i6 < 0 || i6 > i5) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i5).toString());
        } else {
            m mVar = new m(0, (m) null, 2);
            this.head$volatile = mVar;
            this.tail$volatile = mVar;
            this._availablePermits$volatile = i5 - i6;
            this.f18128b = new i(this);
        }
    }

    private final Object f(C2308e eVar) {
        C2886n b5 = C2890p.b(C2316b.c(eVar));
        try {
            if (!g(b5)) {
                e(b5);
            }
            Object x4 = b5.x();
            if (x4 == C2316b.f()) {
                h.c(eVar);
            }
            if (x4 == C2316b.f()) {
                return x4;
            }
            return J.f19942a;
        } catch (Throwable th) {
            b5.N();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final boolean g(d1 d1Var) {
        Object c5;
        m mVar = (m) f18124e.get(this);
        long andIncrement = f18125f.getAndIncrement(this);
        a aVar = a.f18129a;
        AtomicReferenceFieldUpdater m5 = f18124e;
        long h5 = andIncrement / ((long) l.f18136f);
        loop0:
        while (true) {
            c5 = C1981a.c(mVar, h5, aVar);
            if (B.c(c5)) {
                break;
            }
            A b5 = B.b(c5);
            while (true) {
                A a5 = (A) m5.get(this);
                if (a5.f17367c >= b5.f17367c) {
                    break loop0;
                } else if (b5.u()) {
                    if (androidx.concurrent.futures.a.a(m5, this, a5, b5)) {
                        if (a5.p()) {
                            a5.n();
                        }
                    } else if (b5.p()) {
                        b5.n();
                    }
                }
            }
        }
        m mVar2 = (m) B.b(c5);
        int h6 = (int) (andIncrement % ((long) l.f18136f));
        if (l.a(mVar2.v(), h6, (Object) null, d1Var)) {
            d1Var.a(mVar2, h6);
            return true;
        }
        if (!l.a(mVar2.v(), h6, l.f18132b, l.f18133c)) {
            return false;
        }
        if (d1Var instanceof C2882l) {
            t.c(d1Var, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((C2882l) d1Var).c(J.f19942a, this.f18128b);
        } else if (d1Var instanceof c) {
            ((c) d1Var).c(J.f19942a);
        } else {
            throw new IllegalStateException(("unexpected: " + d1Var).toString());
        }
        return true;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private final void h() {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f18126g
            int r0 = r0.get(r3)
            int r1 = r3.f18127a
            if (r0 <= r1) goto L_0x0018
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = f18126g
            int r2 = r3.f18127a
            boolean r0 = r1.compareAndSet(r3, r0, r2)
            if (r0 == 0) goto L_0x0000
        L_0x0018:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: F3.j.h():void");
    }

    private final int i() {
        int andDecrement;
        do {
            andDecrement = f18126g.getAndDecrement(this);
        } while (andDecrement > this.f18127a);
        return andDecrement;
    }

    /* access modifiers changed from: private */
    public static final J p(j jVar, Throwable th, J j5, C2312i iVar) {
        jVar.release();
        return J.f19942a;
    }

    private final boolean r(Object obj) {
        if (obj instanceof C2882l) {
            t.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            C2882l lVar = (C2882l) obj;
            Object q5 = lVar.q(J.f19942a, (Object) null, this.f18128b);
            if (q5 == null) {
                return false;
            }
            lVar.E(q5);
            return true;
        } else if (obj instanceof c) {
            return ((c) obj).b(this, J.f19942a);
        } else {
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
    }

    private final boolean s() {
        Object c5;
        m mVar = (m) f18122c.get(this);
        long andIncrement = f18123d.getAndIncrement(this);
        long h5 = andIncrement / ((long) l.f18136f);
        b bVar = b.f18130a;
        AtomicReferenceFieldUpdater l5 = f18122c;
        loop0:
        while (true) {
            c5 = C1981a.c(mVar, h5, bVar);
            if (B.c(c5)) {
                break;
            }
            A b5 = B.b(c5);
            while (true) {
                A a5 = (A) l5.get(this);
                if (a5.f17367c >= b5.f17367c) {
                    break loop0;
                } else if (b5.u()) {
                    if (androidx.concurrent.futures.a.a(l5, this, a5, b5)) {
                        if (a5.p()) {
                            a5.n();
                        }
                    } else if (b5.p()) {
                        b5.n();
                    }
                }
            }
        }
        m mVar2 = (m) B.b(c5);
        mVar2.c();
        if (mVar2.f17367c > h5) {
            return false;
        }
        int h6 = (int) (andIncrement % ((long) l.f18136f));
        Object andSet = mVar2.v().getAndSet(h6, l.f18132b);
        if (andSet == null) {
            int f5 = l.f18131a;
            for (int i5 = 0; i5 < f5; i5++) {
                if (mVar2.v().get(h6) == l.f18133c) {
                    return true;
                }
            }
            return !l.a(mVar2.v(), h6, l.f18132b, l.f18134d);
        } else if (andSet == l.f18135e) {
            return false;
        } else {
            return r(andSet);
        }
    }

    public final int a() {
        return Math.max(f18126g.get(this), 0);
    }

    public final Object b(C2308e eVar) {
        if (i() > 0) {
            return J.f19942a;
        }
        Object f5 = f(eVar);
        if (f5 == C2316b.f()) {
            return f5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: protected */
    public final void e(C2882l lVar) {
        while (i() <= 0) {
            t.c(lVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (g((d1) lVar)) {
                return;
            }
        }
        lVar.c(J.f19942a, this.f18128b);
    }

    /* access modifiers changed from: protected */
    public final void o(c cVar, Object obj) {
        while (i() <= 0) {
            t.c(cVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (g((d1) cVar)) {
                return;
            }
        }
        cVar.c(J.f19942a);
    }

    public final boolean q() {
        while (true) {
            int i5 = f18126g.get(this);
            if (i5 > this.f18127a) {
                h();
            } else if (i5 <= 0) {
                return false;
            } else {
                if (f18126g.compareAndSet(this, i5, i5 - 1)) {
                    return true;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void release() {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f18126g
            int r0 = r0.getAndIncrement(r3)
            int r1 = r3.f18127a
            if (r0 >= r1) goto L_0x0016
            if (r0 < 0) goto L_0x000f
            goto L_0x0015
        L_0x000f:
            boolean r0 = r3.s()
            if (r0 == 0) goto L_0x0000
        L_0x0015:
            return
        L_0x0016:
            r3.h()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "The number of released permits cannot be greater than "
            r1.append(r2)
            int r2 = r3.f18127a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: F3.j.release():void");
    }
}
