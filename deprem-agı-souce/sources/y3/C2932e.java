package y3;

import B3.A;
import B3.B;
import B3.C;
import B3.C1981a;
import B3.C1982b;
import B3.C1990j;
import B3.D;
import B3.S;
import B3.w;
import W2.C2216e;
import W2.J;
import W2.t;
import W2.u;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k3.l;
import k3.p;
import k3.q;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.C2639q;
import kotlin.jvm.internal.t;
import r3.C2736f;
import w3.C2882l;
import w3.C2886n;
import w3.C2890p;
import w3.d1;

/* renamed from: y3.e  reason: case insensitive filesystem */
public class C2932e implements C2934g {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f26388d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f26389e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f26390f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f26391g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f26392h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f26393i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f26394j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f26395k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f26396l;
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* renamed from: a  reason: collision with root package name */
    private final int f26397a;

    /* renamed from: b  reason: collision with root package name */
    public final l f26398b;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;

    /* renamed from: c  reason: collision with root package name */
    private final q f26399c;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    /* renamed from: y3.e$a */
    private final class a implements C2936i, d1 {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Object f26400a = C2933f.f26428p;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public C2886n f26401b;

        public a() {
        }

        private final Object f(m mVar, int i5, long j5, C2308e eVar) {
            Boolean a5;
            m mVar2;
            C2932e eVar2 = C2932e.this;
            C2886n b5 = C2890p.b(C2316b.c(eVar));
            try {
                this.f26401b = b5;
                m mVar3 = mVar;
                int i6 = i5;
                long j6 = j5;
                try {
                    Object G4 = eVar2.h1(mVar3, i6, j6, this);
                    if (G4 == C2933f.f26425m) {
                        eVar2.P0(this, mVar3, i6);
                    } else {
                        q qVar = null;
                        if (G4 == C2933f.f26427o) {
                            if (j6 < eVar2.m0()) {
                                mVar3.c();
                            }
                            m mVar4 = (m) C2932e.f26393i.get(eVar2);
                            while (true) {
                                if (eVar2.u0()) {
                                    h();
                                    break;
                                }
                                long andIncrement = C2932e.f26389e.getAndIncrement(eVar2);
                                int i7 = C2933f.f26414b;
                                long j7 = andIncrement / ((long) i7);
                                int i8 = (int) (andIncrement % ((long) i7));
                                if (mVar4.f17367c != j7) {
                                    mVar2 = eVar2.X(j7, mVar4);
                                    if (mVar2 == null) {
                                    }
                                } else {
                                    mVar2 = mVar4;
                                }
                                int i9 = i8;
                                Object G5 = eVar2.h1(mVar2, i9, andIncrement, this);
                                if (G5 == C2933f.f26425m) {
                                    eVar2.P0(this, mVar2, i9);
                                    break;
                                } else if (G5 == C2933f.f26427o) {
                                    if (andIncrement < eVar2.m0()) {
                                        mVar2.c();
                                    }
                                    mVar4 = mVar2;
                                } else if (G5 != C2933f.f26426n) {
                                    mVar2.c();
                                    this.f26400a = G5;
                                    this.f26401b = null;
                                    a5 = kotlin.coroutines.jvm.internal.b.a(true);
                                    l lVar = eVar2.f26398b;
                                    if (lVar != null) {
                                        qVar = eVar2.I(lVar, G5);
                                    }
                                } else {
                                    throw new IllegalStateException("unexpected");
                                }
                            }
                        } else {
                            mVar3.c();
                            this.f26400a = G4;
                            this.f26401b = null;
                            a5 = kotlin.coroutines.jvm.internal.b.a(true);
                            l lVar2 = eVar2.f26398b;
                            if (lVar2 != null) {
                                qVar = eVar2.I(lVar2, G4);
                            }
                        }
                        b5.c(a5, qVar);
                    }
                    Object x4 = b5.x();
                    if (x4 == C2316b.f()) {
                        h.c(eVar);
                    }
                    return x4;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    b5.N();
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                Throwable th22 = th;
                b5.N();
                throw th22;
            }
        }

        private final boolean g() {
            this.f26400a = C2933f.z();
            Throwable c02 = C2932e.this.c0();
            if (c02 == null) {
                return false;
            }
            throw C.a(c02);
        }

        /* access modifiers changed from: private */
        public final void h() {
            C2886n nVar = this.f26401b;
            t.b(nVar);
            this.f26401b = null;
            this.f26400a = C2933f.z();
            Throwable c02 = C2932e.this.c0();
            if (c02 == null) {
                t.a aVar = W2.t.f19966b;
                nVar.resumeWith(W2.t.b(Boolean.FALSE));
                return;
            }
            t.a aVar2 = W2.t.f19966b;
            nVar.resumeWith(W2.t.b(u.a(c02)));
        }

        public void a(A a5, int i5) {
            C2886n nVar = this.f26401b;
            if (nVar != null) {
                nVar.a(a5, i5);
            }
        }

        public Object b(C2308e eVar) {
            m mVar;
            boolean z4 = true;
            if (this.f26400a == C2933f.f26428p || this.f26400a == C2933f.z()) {
                C2932e eVar2 = C2932e.this;
                m mVar2 = (m) C2932e.f26393i.get(eVar2);
                while (!eVar2.u0()) {
                    long andIncrement = C2932e.f26389e.getAndIncrement(eVar2);
                    int i5 = C2933f.f26414b;
                    long j5 = andIncrement / ((long) i5);
                    int i6 = (int) (andIncrement % ((long) i5));
                    if (mVar2.f17367c != j5) {
                        mVar = eVar2.X(j5, mVar2);
                        if (mVar == null) {
                            continue;
                        }
                    } else {
                        mVar = mVar2;
                    }
                    int i7 = i6;
                    Object G4 = eVar2.h1(mVar, i7, andIncrement, (Object) null);
                    if (G4 == C2933f.f26425m) {
                        throw new IllegalStateException("unreachable");
                    } else if (G4 == C2933f.f26427o) {
                        if (andIncrement < eVar2.m0()) {
                            mVar.c();
                        }
                        mVar2 = mVar;
                    } else if (G4 == C2933f.f26426n) {
                        long j6 = andIncrement;
                        int i8 = i7;
                        m mVar3 = mVar;
                        return f(mVar3, i8, j6, eVar);
                    } else {
                        mVar.c();
                        this.f26400a = G4;
                        return kotlin.coroutines.jvm.internal.b.a(z4);
                    }
                }
                z4 = g();
            }
            return kotlin.coroutines.jvm.internal.b.a(z4);
        }

        public final boolean i(Object obj) {
            C2886n nVar = this.f26401b;
            kotlin.jvm.internal.t.b(nVar);
            q qVar = null;
            this.f26401b = null;
            this.f26400a = obj;
            Boolean bool = Boolean.TRUE;
            C2932e eVar = C2932e.this;
            l lVar = eVar.f26398b;
            if (lVar != null) {
                qVar = eVar.I(lVar, obj);
            }
            return C2933f.B(nVar, bool, qVar);
        }

        public final void j() {
            C2886n nVar = this.f26401b;
            kotlin.jvm.internal.t.b(nVar);
            this.f26401b = null;
            this.f26400a = C2933f.z();
            Throwable c02 = C2932e.this.c0();
            if (c02 == null) {
                t.a aVar = W2.t.f19966b;
                nVar.resumeWith(W2.t.b(Boolean.FALSE));
                return;
            }
            t.a aVar2 = W2.t.f19966b;
            nVar.resumeWith(W2.t.b(u.a(c02)));
        }

        public Object next() {
            Object obj = this.f26400a;
            if (obj != C2933f.f26428p) {
                this.f26400a = C2933f.f26428p;
                if (obj != C2933f.z()) {
                    return obj;
                }
                throw C.a(C2932e.this.f0());
            }
            throw new IllegalStateException("`hasNext()` has not been invoked");
        }
    }

    /* renamed from: y3.e$b */
    /* synthetic */ class b extends C2639q implements q {
        b(Object obj) {
            super(3, obj, C2932e.class, "onCancellationImplDoNotCall", "onCancellationImplDoNotCall(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
        }

        public final void g(Throwable th, Object obj, C2312i iVar) {
            ((C2932e) this.receiver).F0(th, obj, iVar);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            g((Throwable) obj, obj2, (C2312i) obj3);
            return J.f19942a;
        }
    }

    /* renamed from: y3.e$c */
    /* synthetic */ class c extends C2639q implements q {
        c(Object obj) {
            super(3, obj, C2932e.class, "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
        }

        public final void g(Throwable th, Object obj, C2312i iVar) {
            ((C2932e) this.receiver).E0(th, obj, iVar);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            g((Throwable) obj, ((C2938k) obj2).k(), (C2312i) obj3);
            return J.f19942a;
        }
    }

    /* renamed from: y3.e$d */
    static final class d extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f26403a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2932e f26404b;

        /* renamed from: c  reason: collision with root package name */
        int f26405c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C2932e eVar, C2308e eVar2) {
            super(eVar2);
            this.f26404b = eVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f26403a = obj;
            this.f26405c |= Integer.MIN_VALUE;
            Object S02 = C2932e.S0(this.f26404b, this);
            if (S02 == C2316b.f()) {
                return S02;
            }
            return C2938k.b(S02);
        }
    }

    /* renamed from: y3.e$e  reason: collision with other inner class name */
    static final class C0264e extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f26406a;

        /* renamed from: b  reason: collision with root package name */
        Object f26407b;

        /* renamed from: c  reason: collision with root package name */
        int f26408c;

        /* renamed from: d  reason: collision with root package name */
        long f26409d;

        /* renamed from: e  reason: collision with root package name */
        /* synthetic */ Object f26410e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ C2932e f26411f;

        /* renamed from: g  reason: collision with root package name */
        int f26412g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0264e(C2932e eVar, C2308e eVar2) {
            super(eVar2);
            this.f26411f = eVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f26410e = obj;
            this.f26412g |= Integer.MIN_VALUE;
            Object F4 = this.f26411f.T0((m) null, 0, 0, this);
            if (F4 == C2316b.f()) {
                return F4;
            }
            return C2938k.b(F4);
        }
    }

    static {
        Class<C2932e> cls = C2932e.class;
        f26388d = AtomicLongFieldUpdater.newUpdater(cls, "sendersAndCloseStatus$volatile");
        f26389e = AtomicLongFieldUpdater.newUpdater(cls, "receivers$volatile");
        f26390f = AtomicLongFieldUpdater.newUpdater(cls, "bufferEnd$volatile");
        f26391g = AtomicLongFieldUpdater.newUpdater(cls, "completedExpandBuffersAndPauseFlag$volatile");
        Class<Object> cls2 = Object.class;
        f26392h = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "sendSegment$volatile");
        f26393i = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "receiveSegment$volatile");
        f26394j = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "bufferEndSegment$volatile");
        f26395k = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_closeCause$volatile");
        f26396l = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "closeHandler$volatile");
    }

    public C2932e(int i5, l lVar) {
        C2929b bVar;
        this.f26397a = i5;
        this.f26398b = lVar;
        if (i5 >= 0) {
            this.bufferEnd$volatile = C2933f.A(i5);
            this.completedExpandBuffersAndPauseFlag$volatile = a0();
            m mVar = new m(0, (m) null, this, 3);
            this.sendSegment$volatile = mVar;
            this.receiveSegment$volatile = mVar;
            if (y0()) {
                mVar = C2933f.f26413a;
                kotlin.jvm.internal.t.c(mVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment$volatile = mVar;
            if (lVar != null) {
                bVar = new C2929b(this);
            } else {
                bVar = null;
            }
            this.f26399c = bVar;
            this._closeCause$volatile = C2933f.f26431s;
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + i5 + ", should be >=0").toString());
    }

    private final void A0() {
        long j5;
        AtomicLongFieldUpdater l02 = f26388d;
        do {
            j5 = l02.get(this);
            if (((int) (j5 >> 60)) != 0) {
                return;
            }
        } while (!l02.compareAndSet(this, j5, C2933f.w(1152921504606846975L & j5, 1)));
    }

    private final void B0() {
        long j5;
        AtomicLongFieldUpdater l02 = f26388d;
        do {
            j5 = l02.get(this);
        } while (!l02.compareAndSet(this, j5, C2933f.w(1152921504606846975L & j5, 3)));
    }

    private final void C0() {
        long j5;
        long b5;
        AtomicLongFieldUpdater l02 = f26388d;
        do {
            j5 = l02.get(this);
            int i5 = (int) (j5 >> 60);
            if (i5 == 0) {
                b5 = C2933f.w(1152921504606846975L & j5, 2);
            } else if (i5 == 1) {
                b5 = C2933f.w(1152921504606846975L & j5, 3);
            } else {
                return;
            }
        } while (!l02.compareAndSet(this, j5, b5));
    }

    private final void D0(long j5, m mVar) {
        m mVar2;
        m mVar3;
        while (mVar.f17367c < j5 && (mVar3 = (m) mVar.f()) != null) {
            mVar = mVar3;
        }
        while (true) {
            if (!mVar.k() || (mVar2 = (m) mVar.f()) == null) {
                AtomicReferenceFieldUpdater b02 = f26394j;
                while (true) {
                    A a5 = (A) b02.get(this);
                    if (a5.f17367c < mVar.f17367c) {
                        if (!mVar.u()) {
                            continue;
                            break;
                        } else if (androidx.concurrent.futures.a.a(b02, this, a5, mVar)) {
                            if (a5.p()) {
                                a5.n();
                                return;
                            }
                            return;
                        } else if (mVar.p()) {
                            mVar.n();
                        }
                    } else {
                        return;
                    }
                }
            } else {
                mVar = mVar2;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void E0(Throwable th, Object obj, C2312i iVar) {
        l lVar = this.f26398b;
        kotlin.jvm.internal.t.b(lVar);
        Object f5 = C2938k.f(obj);
        kotlin.jvm.internal.t.b(f5);
        w.a(lVar, f5, iVar);
    }

    /* access modifiers changed from: private */
    public final void F0(Throwable th, Object obj, C2312i iVar) {
        l lVar = this.f26398b;
        kotlin.jvm.internal.t.b(lVar);
        w.a(lVar, obj, iVar);
    }

    /* access modifiers changed from: private */
    public final void H0(C2882l lVar) {
        t.a aVar = W2.t.f19966b;
        lVar.resumeWith(W2.t.b(C2938k.b(C2938k.f26437b.a(c0()))));
    }

    /* access modifiers changed from: private */
    public final q I(l lVar, Object obj) {
        return new C2930c(lVar, obj);
    }

    /* access modifiers changed from: private */
    public final void I0(C2882l lVar) {
        t.a aVar = W2.t.f19966b;
        lVar.resumeWith(W2.t.b(u.a(f0())));
    }

    /* access modifiers changed from: private */
    public final C2736f J(l lVar) {
        return new b(this);
    }

    private final Object J0(Object obj, C2308e eVar) {
        S c5;
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        l lVar = this.f26398b;
        if (lVar == null || (c5 = w.c(lVar, obj, (S) null, 2, (Object) null)) == null) {
            Throwable j02 = j0();
            t.a aVar = W2.t.f19966b;
            nVar.resumeWith(W2.t.b(u.a(j02)));
        } else {
            C2216e.a(c5, j0());
            t.a aVar2 = W2.t.f19966b;
            nVar.resumeWith(W2.t.b(u.a(c5)));
        }
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        if (x4 == C2316b.f()) {
            return x4;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J K(l lVar, Object obj, Throwable th, Object obj2, C2312i iVar) {
        w.a(lVar, obj, iVar);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final void K0(Object obj, C2882l lVar) {
        l lVar2 = this.f26398b;
        if (lVar2 != null) {
            w.a(lVar2, obj, lVar.getContext());
        }
        Throwable j02 = j0();
        t.a aVar = W2.t.f19966b;
        lVar.resumeWith(W2.t.b(u.a(j02)));
    }

    /* access modifiers changed from: private */
    public final C2736f L(l lVar) {
        return new c(this);
    }

    private final boolean M(long j5) {
        if (j5 < a0() || j5 < i0() + ((long) this.f26397a)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final q N0(C2932e eVar, E3.c cVar, Object obj, Object obj2) {
        return new C2931d(obj2, eVar, cVar);
    }

    private final void O(m mVar, long j5) {
        Object b5 = C1990j.b((Object) null, 1, (C2633k) null);
        loop0:
        while (mVar != null) {
            for (int i5 = C2933f.f26414b - 1; -1 < i5; i5--) {
                if ((mVar.f17367c * ((long) C2933f.f26414b)) + ((long) i5) < j5) {
                    break loop0;
                }
                while (true) {
                    Object B4 = mVar.B(i5);
                    if (B4 == null || B4 == C2933f.f26417e) {
                        if (mVar.v(i5, B4, C2933f.z())) {
                            mVar.t();
                            break;
                        }
                    } else if (B4 instanceof z) {
                        if (mVar.v(i5, B4, C2933f.z())) {
                            b5 = C1990j.c(b5, ((z) B4).f26455a);
                            mVar.C(i5, true);
                            break;
                        }
                    } else if (!(B4 instanceof d1)) {
                        break;
                    } else if (mVar.v(i5, B4, C2933f.z())) {
                        b5 = C1990j.c(b5, B4);
                        mVar.C(i5, true);
                        break;
                    }
                }
            }
            mVar = (m) mVar.h();
        }
        if (b5 == null) {
            return;
        }
        if (!(b5 instanceof ArrayList)) {
            W0((d1) b5);
            return;
        }
        kotlin.jvm.internal.t.c(b5, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
        ArrayList arrayList = (ArrayList) b5;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            W0((d1) arrayList.get(size));
        }
    }

    /* access modifiers changed from: private */
    public static final J O0(Object obj, C2932e eVar, E3.c cVar, Throwable th, Object obj2, C2312i iVar) {
        if (obj != C2933f.z()) {
            w.a(eVar.f26398b, obj, cVar.getContext());
        }
        return J.f19942a;
    }

    private final m P() {
        m mVar = f26394j.get(this);
        m mVar2 = (m) f26392h.get(this);
        if (mVar2.f17367c > ((m) mVar).f17367c) {
            mVar = mVar2;
        }
        m mVar3 = (m) f26393i.get(this);
        if (mVar3.f17367c > ((m) mVar).f17367c) {
            mVar = mVar3;
        }
        return (m) C1981a.b((C1982b) mVar);
    }

    /* access modifiers changed from: private */
    public final void P0(d1 d1Var, m mVar, int i5) {
        M0();
        d1Var.a(mVar, i5);
    }

    /* access modifiers changed from: private */
    public final void Q0(d1 d1Var, m mVar, int i5) {
        d1Var.a(mVar, i5 + C2933f.f26414b);
    }

    private final void R(long j5) {
        V0(S(j5));
    }

    static /* synthetic */ Object R0(C2932e eVar, C2308e eVar2) {
        m mVar;
        m mVar2 = (m) f26393i.get(eVar);
        while (!eVar.u0()) {
            long andIncrement = f26389e.getAndIncrement(eVar);
            int i5 = C2933f.f26414b;
            long j5 = andIncrement / ((long) i5);
            int i6 = (int) (andIncrement % ((long) i5));
            if (mVar2.f17367c != j5) {
                m m5 = eVar.X(j5, mVar2);
                if (m5 == null) {
                    continue;
                } else {
                    mVar = m5;
                }
            } else {
                mVar = mVar2;
            }
            C2932e eVar3 = eVar;
            Object G4 = eVar3.h1(mVar, i6, andIncrement, (Object) null);
            if (G4 == C2933f.f26425m) {
                throw new IllegalStateException("unexpected");
            } else if (G4 == C2933f.f26427o) {
                if (andIncrement < eVar3.m0()) {
                    mVar.c();
                }
                eVar = eVar3;
                mVar2 = mVar;
            } else if (G4 == C2933f.f26426n) {
                return eVar3.U0(mVar, i6, andIncrement, eVar2);
            } else {
                mVar.c();
                return G4;
            }
        }
        throw C.a(eVar.f0());
    }

    private final m S(long j5) {
        m P4 = P();
        if (x0()) {
            long z02 = z0(P4);
            if (z02 != -1) {
                U(z02);
            }
        }
        O(P4, j5);
        return P4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object S0(y3.C2932e r13, b3.C2308e r14) {
        /*
            boolean r0 = r14 instanceof y3.C2932e.d
            if (r0 == 0) goto L_0x0014
            r0 = r14
            y3.e$d r0 = (y3.C2932e.d) r0
            int r1 = r0.f26405c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.f26405c = r1
        L_0x0012:
            r6 = r0
            goto L_0x001a
        L_0x0014:
            y3.e$d r0 = new y3.e$d
            r0.<init>(r13, r14)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r14 = r6.f26403a
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r6.f26405c
            r2 = 1
            if (r1 == 0) goto L_0x0039
            if (r1 != r2) goto L_0x0031
            W2.u.b(r14)
            y3.k r14 = (y3.C2938k) r14
            java.lang.Object r13 = r14.k()
            return r13
        L_0x0031:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0039:
            W2.u.b(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = f26393i
            java.lang.Object r14 = r14.get(r13)
            y3.m r14 = (y3.m) r14
        L_0x0046:
            boolean r1 = r13.u0()
            if (r1 == 0) goto L_0x0057
            y3.k$b r14 = y3.C2938k.f26437b
            java.lang.Throwable r13 = r13.c0()
            java.lang.Object r13 = r14.a(r13)
            return r13
        L_0x0057:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f26389e
            long r4 = r1.getAndIncrement(r13)
            int r1 = y3.C2933f.f26414b
            long r7 = (long) r1
            long r7 = r4 / r7
            long r9 = (long) r1
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r14.f17367c
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0077
            y3.m r1 = r13.X(r7, r14)
            if (r1 != 0) goto L_0x0075
            goto L_0x0046
        L_0x0075:
            r8 = r1
            goto L_0x0078
        L_0x0077:
            r8 = r14
        L_0x0078:
            r12 = 0
            r7 = r13
            r9 = r3
            r10 = r4
            java.lang.Object r13 = r7.h1(r8, r9, r10, r12)
            r1 = r7
            B3.D r14 = y3.C2933f.f26425m
            if (r13 == r14) goto L_0x00b6
            B3.D r14 = y3.C2933f.f26427o
            if (r13 != r14) goto L_0x009b
            long r13 = r1.m0()
            int r13 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r13 >= 0) goto L_0x0098
            r8.c()
        L_0x0098:
            r13 = r1
            r14 = r8
            goto L_0x0046
        L_0x009b:
            B3.D r14 = y3.C2933f.f26426n
            if (r13 != r14) goto L_0x00ac
            r6.f26405c = r2
            r2 = r8
            java.lang.Object r13 = r1.T0(r2, r3, r4, r6)
            if (r13 != r0) goto L_0x00ab
            return r0
        L_0x00ab:
            return r13
        L_0x00ac:
            r8.c()
            y3.k$b r14 = y3.C2938k.f26437b
            java.lang.Object r13 = r14.c(r13)
            return r13
        L_0x00b6:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.C2932e.S0(y3.e, b3.e):java.lang.Object");
    }

    private final void T() {
        D();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object T0(y3.m r11, int r12, long r13, b3.C2308e r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof y3.C2932e.C0264e
            if (r0 == 0) goto L_0x0013
            r0 = r15
            y3.e$e r0 = (y3.C2932e.C0264e) r0
            int r1 = r0.f26412g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26412g = r1
            goto L_0x0018
        L_0x0013:
            y3.e$e r0 = new y3.e$e
            r0.<init>(r10, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f26410e
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f26412g
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r11 = r0.f26407b
            y3.m r11 = (y3.m) r11
            java.lang.Object r11 = r0.f26406a
            y3.e r11 = (y3.C2932e) r11
            W2.u.b(r15)
            r2 = r10
            goto L_0x012e
        L_0x0033:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003b:
            W2.u.b(r15)
            r0.f26406a = r10
            r0.f26407b = r11
            r0.f26408c = r12
            r0.f26409d = r13
            r0.f26412g = r3
            b3.e r15 = c3.C2316b.c(r0)
            w3.n r15 = w3.C2890p.b(r15)
            y3.w r7 = new y3.w     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$38>>"
            kotlin.jvm.internal.t.c(r15, r2)     // Catch:{ all -> 0x0135 }
            r7.<init>(r15)     // Catch:{ all -> 0x0135 }
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            java.lang.Object r11 = r2.h1(r3, r4, r5, r7)     // Catch:{ all -> 0x006d }
            B3.D r12 = y3.C2933f.f26425m     // Catch:{ all -> 0x006d }
            if (r11 != r12) goto L_0x0071
            r10.P0(r7, r3, r4)     // Catch:{ all -> 0x006d }
            goto L_0x011e
        L_0x006d:
            r0 = move-exception
        L_0x006e:
            r11 = r0
            goto L_0x0139
        L_0x0071:
            B3.D r12 = y3.C2933f.f26427o     // Catch:{ all -> 0x006d }
            r13 = 0
            if (r11 != r12) goto L_0x0106
            long r11 = r10.m0()     // Catch:{ all -> 0x006d }
            int r11 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0083
            r3.c()     // Catch:{ all -> 0x006d }
        L_0x0083:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r11 = f26393i     // Catch:{ all -> 0x006d }
            java.lang.Object r11 = r11.get(r10)     // Catch:{ all -> 0x006d }
            y3.m r11 = (y3.m) r11     // Catch:{ all -> 0x006d }
        L_0x008d:
            boolean r12 = r10.u0()     // Catch:{ all -> 0x006d }
            if (r12 == 0) goto L_0x0098
            r10.H0(r15)     // Catch:{ all -> 0x006d }
            goto L_0x011e
        L_0x0098:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r12 = f26389e     // Catch:{ all -> 0x006d }
            long r5 = r12.getAndIncrement(r10)     // Catch:{ all -> 0x006d }
            int r12 = y3.C2933f.f26414b     // Catch:{ all -> 0x006d }
            long r3 = (long) r12     // Catch:{ all -> 0x006d }
            long r3 = r5 / r3
            long r8 = (long) r12     // Catch:{ all -> 0x006d }
            long r8 = r5 % r8
            int r12 = (int) r8     // Catch:{ all -> 0x006d }
            long r8 = r11.f17367c     // Catch:{ all -> 0x006d }
            int r14 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r14 == 0) goto L_0x00b9
            y3.m r14 = r10.X(r3, r11)     // Catch:{ all -> 0x006d }
            if (r14 != 0) goto L_0x00b6
            goto L_0x008d
        L_0x00b6:
            r3 = r14
        L_0x00b7:
            r4 = r12
            goto L_0x00bb
        L_0x00b9:
            r3 = r11
            goto L_0x00b7
        L_0x00bb:
            java.lang.Object r11 = r2.h1(r3, r4, r5, r7)     // Catch:{ all -> 0x006d }
            r14 = r3
            B3.D r12 = y3.C2933f.f26425m     // Catch:{ all -> 0x006d }
            if (r11 != r12) goto L_0x00ca
            r10.P0(r7, r14, r4)     // Catch:{ all -> 0x006d }
            goto L_0x011e
        L_0x00ca:
            B3.D r12 = y3.C2933f.f26427o     // Catch:{ all -> 0x006d }
            if (r11 != r12) goto L_0x00dd
            long r11 = r10.m0()     // Catch:{ all -> 0x006d }
            int r11 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x00db
            r14.c()     // Catch:{ all -> 0x006d }
        L_0x00db:
            r11 = r14
            goto L_0x008d
        L_0x00dd:
            B3.D r12 = y3.C2933f.f26426n     // Catch:{ all -> 0x006d }
            if (r11 == r12) goto L_0x00fe
            r14.c()     // Catch:{ all -> 0x006d }
            y3.k$b r12 = y3.C2938k.f26437b     // Catch:{ all -> 0x006d }
            java.lang.Object r11 = r12.c(r11)     // Catch:{ all -> 0x006d }
            y3.k r11 = y3.C2938k.b(r11)     // Catch:{ all -> 0x006d }
            k3.l r12 = r2.f26398b     // Catch:{ all -> 0x006d }
            if (r12 == 0) goto L_0x00f8
            r3.f r13 = r10.L(r12)     // Catch:{ all -> 0x006d }
        L_0x00f8:
            k3.q r13 = (k3.q) r13     // Catch:{ all -> 0x006d }
        L_0x00fa:
            r15.c(r11, r13)     // Catch:{ all -> 0x006d }
            goto L_0x011e
        L_0x00fe:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x006d }
            java.lang.String r12 = "unexpected"
            r11.<init>(r12)     // Catch:{ all -> 0x006d }
            throw r11     // Catch:{ all -> 0x006d }
        L_0x0106:
            r3.c()     // Catch:{ all -> 0x006d }
            y3.k$b r12 = y3.C2938k.f26437b     // Catch:{ all -> 0x006d }
            java.lang.Object r11 = r12.c(r11)     // Catch:{ all -> 0x006d }
            y3.k r11 = y3.C2938k.b(r11)     // Catch:{ all -> 0x006d }
            k3.l r12 = r2.f26398b     // Catch:{ all -> 0x006d }
            if (r12 == 0) goto L_0x011b
            r3.f r13 = r10.L(r12)     // Catch:{ all -> 0x006d }
        L_0x011b:
            k3.q r13 = (k3.q) r13     // Catch:{ all -> 0x006d }
            goto L_0x00fa
        L_0x011e:
            java.lang.Object r15 = r15.x()
            java.lang.Object r11 = c3.C2316b.f()
            if (r15 != r11) goto L_0x012b
            kotlin.coroutines.jvm.internal.h.c(r0)
        L_0x012b:
            if (r15 != r1) goto L_0x012e
            return r1
        L_0x012e:
            y3.k r15 = (y3.C2938k) r15
            java.lang.Object r11 = r15.k()
            return r11
        L_0x0135:
            r0 = move-exception
            r2 = r10
            goto L_0x006e
        L_0x0139:
            r15.N()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.C2932e.T0(y3.m, int, long, b3.e):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r12v4, types: [r3.f] */
    /* JADX WARNING: type inference failed for: r12v10, types: [r3.f] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object U0(y3.m r10, int r11, long r12, b3.C2308e r14) {
        /*
            r9 = this;
            b3.e r0 = c3.C2316b.c(r14)
            w3.n r6 = w3.C2890p.b(r0)
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            java.lang.Object r10 = r1.h1(r2, r3, r4, r6)     // Catch:{ all -> 0x001b }
            B3.D r11 = y3.C2933f.f26425m     // Catch:{ all -> 0x001b }
            if (r10 != r11) goto L_0x001f
            r9.P0(r6, r2, r3)     // Catch:{ all -> 0x001b }
            goto L_0x00c1
        L_0x001b:
            r0 = move-exception
            r10 = r0
            goto L_0x00cf
        L_0x001f:
            B3.D r11 = y3.C2933f.f26427o     // Catch:{ all -> 0x001b }
            r12 = 0
            if (r10 != r11) goto L_0x00b3
            long r10 = r9.m0()     // Catch:{ all -> 0x001b }
            int r10 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x0031
            r2.c()     // Catch:{ all -> 0x001b }
        L_0x0031:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r10 = f26393i     // Catch:{ all -> 0x001b }
            java.lang.Object r10 = r10.get(r9)     // Catch:{ all -> 0x001b }
            y3.m r10 = (y3.m) r10     // Catch:{ all -> 0x001b }
        L_0x003b:
            boolean r11 = r9.u0()     // Catch:{ all -> 0x001b }
            if (r11 == 0) goto L_0x0046
            r9.I0(r6)     // Catch:{ all -> 0x001b }
            goto L_0x00c1
        L_0x0046:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r11 = f26389e     // Catch:{ all -> 0x001b }
            long r4 = r11.getAndIncrement(r9)     // Catch:{ all -> 0x001b }
            int r11 = y3.C2933f.f26414b     // Catch:{ all -> 0x001b }
            long r2 = (long) r11     // Catch:{ all -> 0x001b }
            long r2 = r4 / r2
            long r7 = (long) r11     // Catch:{ all -> 0x001b }
            long r7 = r4 % r7
            int r11 = (int) r7     // Catch:{ all -> 0x001b }
            long r7 = r10.f17367c     // Catch:{ all -> 0x001b }
            int r13 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x0067
            y3.m r13 = r9.X(r2, r10)     // Catch:{ all -> 0x001b }
            if (r13 != 0) goto L_0x0064
            goto L_0x003b
        L_0x0064:
            r2 = r13
        L_0x0065:
            r3 = r11
            goto L_0x0069
        L_0x0067:
            r2 = r10
            goto L_0x0065
        L_0x0069:
            java.lang.Object r10 = r1.h1(r2, r3, r4, r6)     // Catch:{ all -> 0x001b }
            r13 = r2
            B3.D r11 = y3.C2933f.f26425m     // Catch:{ all -> 0x001b }
            if (r10 != r11) goto L_0x0081
            boolean r10 = b.w.a(r6)     // Catch:{ all -> 0x001b }
            if (r10 == 0) goto L_0x007b
            r12 = r6
        L_0x007b:
            if (r12 == 0) goto L_0x00c1
            r9.P0(r12, r13, r3)     // Catch:{ all -> 0x001b }
            goto L_0x00c1
        L_0x0081:
            B3.D r11 = y3.C2933f.f26427o     // Catch:{ all -> 0x001b }
            if (r10 != r11) goto L_0x0094
            long r10 = r9.m0()     // Catch:{ all -> 0x001b }
            int r10 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x0092
            r13.c()     // Catch:{ all -> 0x001b }
        L_0x0092:
            r10 = r13
            goto L_0x003b
        L_0x0094:
            B3.D r11 = y3.C2933f.f26426n     // Catch:{ all -> 0x001b }
            if (r10 == r11) goto L_0x00ab
            r13.c()     // Catch:{ all -> 0x001b }
            k3.l r11 = r1.f26398b     // Catch:{ all -> 0x001b }
            if (r11 == 0) goto L_0x00a5
            r3.f r12 = r9.J(r11)     // Catch:{ all -> 0x001b }
        L_0x00a5:
            k3.q r12 = (k3.q) r12     // Catch:{ all -> 0x001b }
        L_0x00a7:
            r6.c(r10, r12)     // Catch:{ all -> 0x001b }
            goto L_0x00c1
        L_0x00ab:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x001b }
            java.lang.String r11 = "unexpected"
            r10.<init>(r11)     // Catch:{ all -> 0x001b }
            throw r10     // Catch:{ all -> 0x001b }
        L_0x00b3:
            r2.c()     // Catch:{ all -> 0x001b }
            k3.l r11 = r1.f26398b     // Catch:{ all -> 0x001b }
            if (r11 == 0) goto L_0x00be
            r3.f r12 = r9.J(r11)     // Catch:{ all -> 0x001b }
        L_0x00be:
            k3.q r12 = (k3.q) r12     // Catch:{ all -> 0x001b }
            goto L_0x00a7
        L_0x00c1:
            java.lang.Object r10 = r6.x()
            java.lang.Object r11 = c3.C2316b.f()
            if (r10 != r11) goto L_0x00ce
            kotlin.coroutines.jvm.internal.h.c(r14)
        L_0x00ce:
            return r10
        L_0x00cf:
            r6.N()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.C2932e.U0(y3.m, int, long, b3.e):java.lang.Object");
    }

    private final void V() {
        if (!y0()) {
            m mVar = (m) f26394j.get(this);
            while (true) {
                long andIncrement = f26390f.getAndIncrement(this);
                int i5 = C2933f.f26414b;
                long j5 = andIncrement / ((long) i5);
                if (m0() <= andIncrement) {
                    if (mVar.f17367c < j5 && mVar.f() != null) {
                        D0(j5, mVar);
                    }
                    q0(this, 0, 1, (Object) null);
                    return;
                }
                if (mVar.f17367c != j5) {
                    m W4 = W(j5, mVar, andIncrement);
                    if (W4 == null) {
                        continue;
                    } else {
                        mVar = W4;
                    }
                }
                if (f1(mVar, (int) (andIncrement % ((long) i5)), andIncrement)) {
                    q0(this, 0, 1, (Object) null);
                    return;
                }
                q0(this, 0, 1, (Object) null);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b3, code lost:
        r12 = (y3.m) r12.h();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void V0(y3.m r12) {
        /*
            r11 = this;
            k3.l r0 = r11.f26398b
            r1 = 0
            r2 = 1
            java.lang.Object r3 = B3.C1990j.b(r1, r2, r1)
        L_0x0008:
            int r4 = y3.C2933f.f26414b
            int r4 = r4 - r2
        L_0x000b:
            r5 = -1
            if (r5 >= r4) goto L_0x00b3
            long r6 = r12.f17367c
            int r8 = y3.C2933f.f26414b
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L_0x0016:
            java.lang.Object r8 = r12.B(r4)
            B3.D r9 = y3.C2933f.f26421i
            if (r8 == r9) goto L_0x00bb
            B3.D r9 = y3.C2933f.f26416d
            if (r8 != r9) goto L_0x0048
            long r9 = r11.i0()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x00bb
            B3.D r9 = y3.C2933f.z()
            boolean r8 = r12.v(r4, r8, r9)
            if (r8 == 0) goto L_0x0016
            if (r0 == 0) goto L_0x0040
            java.lang.Object r5 = r12.A(r4)
            B3.S r1 = B3.w.b(r0, r5, r1)
        L_0x0040:
            r12.w(r4)
            r12.t()
            goto L_0x00af
        L_0x0048:
            B3.D r9 = y3.C2933f.f26417e
            if (r8 == r9) goto L_0x00a2
            if (r8 != 0) goto L_0x0051
            goto L_0x00a2
        L_0x0051:
            boolean r9 = r8 instanceof w3.d1
            if (r9 != 0) goto L_0x006e
            boolean r9 = r8 instanceof y3.z
            if (r9 == 0) goto L_0x005a
            goto L_0x006e
        L_0x005a:
            B3.D r9 = y3.C2933f.f26419g
            if (r8 == r9) goto L_0x00bb
            B3.D r9 = y3.C2933f.f26418f
            if (r8 != r9) goto L_0x0067
            goto L_0x00bb
        L_0x0067:
            B3.D r9 = y3.C2933f.f26419g
            if (r8 == r9) goto L_0x0016
            goto L_0x00af
        L_0x006e:
            long r9 = r11.i0()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x00bb
            boolean r9 = r8 instanceof y3.z
            if (r9 == 0) goto L_0x0080
            r9 = r8
            y3.z r9 = (y3.z) r9
            w3.d1 r9 = r9.f26455a
            goto L_0x0083
        L_0x0080:
            r9 = r8
            w3.d1 r9 = (w3.d1) r9
        L_0x0083:
            B3.D r10 = y3.C2933f.z()
            boolean r8 = r12.v(r4, r8, r10)
            if (r8 == 0) goto L_0x0016
            if (r0 == 0) goto L_0x0097
            java.lang.Object r5 = r12.A(r4)
            B3.S r1 = B3.w.b(r0, r5, r1)
        L_0x0097:
            java.lang.Object r3 = B3.C1990j.c(r3, r9)
            r12.w(r4)
            r12.t()
            goto L_0x00af
        L_0x00a2:
            B3.D r9 = y3.C2933f.z()
            boolean r8 = r12.v(r4, r8, r9)
            if (r8 == 0) goto L_0x0016
            r12.t()
        L_0x00af:
            int r4 = r4 + -1
            goto L_0x000b
        L_0x00b3:
            B3.b r12 = r12.h()
            y3.m r12 = (y3.m) r12
            if (r12 != 0) goto L_0x0008
        L_0x00bb:
            if (r3 == 0) goto L_0x00e1
            boolean r12 = r3 instanceof java.util.ArrayList
            if (r12 != 0) goto L_0x00c7
            w3.d1 r3 = (w3.d1) r3
            r11.X0(r3)
            goto L_0x00e1
        L_0x00c7:
            java.lang.String r12 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>"
            kotlin.jvm.internal.t.c(r3, r12)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r12 = r3.size()
            int r12 = r12 - r2
        L_0x00d3:
            if (r5 >= r12) goto L_0x00e1
            java.lang.Object r0 = r3.get(r12)
            w3.d1 r0 = (w3.d1) r0
            r11.X0(r0)
            int r12 = r12 + -1
            goto L_0x00d3
        L_0x00e1:
            if (r1 != 0) goto L_0x00e4
            return
        L_0x00e4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.C2932e.V0(y3.m):void");
    }

    private final m W(long j5, m mVar, long j6) {
        Object c5;
        long j7 = j5;
        AtomicReferenceFieldUpdater b02 = f26394j;
        p pVar = (p) C2933f.y();
        m mVar2 = mVar;
        loop0:
        while (true) {
            c5 = C1981a.c(mVar2, j7, pVar);
            if (B.c(c5)) {
                break;
            }
            A b5 = B.b(c5);
            while (true) {
                A a5 = (A) b02.get(this);
                if (a5.f17367c >= b5.f17367c) {
                    break loop0;
                } else if (b5.u()) {
                    if (androidx.concurrent.futures.a.a(b02, this, a5, b5)) {
                        if (a5.p()) {
                            a5.n();
                        }
                    } else if (b5.p()) {
                        b5.n();
                    }
                }
            }
        }
        if (B.c(c5)) {
            T();
            D0(j5, mVar);
            q0(this, 0, 1, (Object) null);
            return null;
        }
        m mVar3 = (m) B.b(c5);
        if (mVar3.f17367c <= j7) {
            return mVar3;
        }
        long j8 = mVar3.f17367c;
        int i5 = C2933f.f26414b;
        if (f26390f.compareAndSet(this, j6 + 1, j8 * ((long) i5))) {
            p0((mVar3.f17367c * ((long) i5)) - j6);
        } else {
            q0(this, 0, 1, (Object) null);
        }
        return null;
    }

    private final void W0(d1 d1Var) {
        Y0(d1Var, true);
    }

    /* access modifiers changed from: private */
    public final m X(long j5, m mVar) {
        Object c5;
        AtomicReferenceFieldUpdater g02 = f26393i;
        p pVar = (p) C2933f.y();
        loop0:
        while (true) {
            c5 = C1981a.c(mVar, j5, pVar);
            if (B.c(c5)) {
                break;
            }
            A b5 = B.b(c5);
            while (true) {
                A a5 = (A) g02.get(this);
                if (a5.f17367c >= b5.f17367c) {
                    break loop0;
                } else if (b5.u()) {
                    if (androidx.concurrent.futures.a.a(g02, this, a5, b5)) {
                        if (a5.p()) {
                            a5.n();
                        }
                    } else if (b5.p()) {
                        b5.n();
                    }
                }
            }
        }
        if (B.c(c5)) {
            T();
            if (mVar.f17367c * ((long) C2933f.f26414b) < m0()) {
                mVar.c();
            }
            return null;
        }
        m mVar2 = (m) B.b(c5);
        if (!y0() && j5 <= a0() / ((long) C2933f.f26414b)) {
            AtomicReferenceFieldUpdater b02 = f26394j;
            while (true) {
                A a6 = (A) b02.get(this);
                if (a6.f17367c >= mVar2.f17367c || !mVar2.u()) {
                    break;
                } else if (androidx.concurrent.futures.a.a(b02, this, a6, mVar2)) {
                    if (a6.p()) {
                        a6.n();
                    }
                } else if (mVar2.p()) {
                    mVar2.n();
                }
            }
        }
        long j6 = mVar2.f17367c;
        if (j6 <= j5) {
            return mVar2;
        }
        int i5 = C2933f.f26414b;
        l1(j6 * ((long) i5));
        if (mVar2.f17367c * ((long) i5) < m0()) {
            mVar2.c();
        }
        return null;
    }

    private final void X0(d1 d1Var) {
        Y0(d1Var, false);
    }

    /* access modifiers changed from: private */
    public final m Y(long j5, m mVar) {
        Object c5;
        AtomicReferenceFieldUpdater k02 = f26392h;
        p pVar = (p) C2933f.y();
        loop0:
        while (true) {
            c5 = C1981a.c(mVar, j5, pVar);
            if (B.c(c5)) {
                break;
            }
            A b5 = B.b(c5);
            while (true) {
                A a5 = (A) k02.get(this);
                if (a5.f17367c >= b5.f17367c) {
                    break loop0;
                } else if (b5.u()) {
                    if (androidx.concurrent.futures.a.a(k02, this, a5, b5)) {
                        if (a5.p()) {
                            a5.n();
                        }
                    } else if (b5.p()) {
                        b5.n();
                    }
                }
            }
        }
        if (B.c(c5)) {
            T();
            if (mVar.f17367c * ((long) C2933f.f26414b) < i0()) {
                mVar.c();
            }
            return null;
        }
        m mVar2 = (m) B.b(c5);
        long j6 = mVar2.f17367c;
        if (j6 <= j5) {
            return mVar2;
        }
        int i5 = C2933f.f26414b;
        m1(j6 * ((long) i5));
        if (mVar2.f17367c * ((long) i5) < i0()) {
            mVar2.c();
        }
        return null;
    }

    private final void Y0(d1 d1Var, boolean z4) {
        Throwable th;
        if (d1Var instanceof C2882l) {
            C2308e eVar = (C2308e) d1Var;
            t.a aVar = W2.t.f19966b;
            if (z4) {
                th = f0();
            } else {
                th = j0();
            }
            eVar.resumeWith(W2.t.b(u.a(th)));
        } else if (d1Var instanceof w) {
            C2886n nVar = ((w) d1Var).f26454a;
            t.a aVar2 = W2.t.f19966b;
            nVar.resumeWith(W2.t.b(C2938k.b(C2938k.f26437b.a(c0()))));
        } else if (d1Var instanceof a) {
            ((a) d1Var).j();
        } else if (d1Var instanceof E3.c) {
            ((E3.c) d1Var).b(this, C2933f.z());
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + d1Var).toString());
        }
    }

    static /* synthetic */ Object Z0(C2932e eVar, Object obj, C2308e eVar2) {
        m mVar;
        m mVar2 = (m) f26392h.get(eVar);
        while (true) {
            long andIncrement = f26388d.getAndIncrement(eVar);
            long j5 = andIncrement & 1152921504606846975L;
            boolean v5 = eVar.w0(andIncrement);
            int i5 = C2933f.f26414b;
            long j6 = j5 / ((long) i5);
            int i6 = (int) (j5 % ((long) i5));
            if (mVar2.f17367c != j6) {
                m n5 = eVar.Y(j6, mVar2);
                if (n5 != null) {
                    mVar = n5;
                } else if (v5) {
                    Object J02 = eVar.J0(obj, eVar2);
                    if (J02 == C2316b.f()) {
                        return J02;
                    }
                }
            } else {
                mVar = mVar2;
            }
            C2932e eVar3 = eVar;
            Object obj2 = obj;
            int H4 = eVar3.j1(mVar, i6, obj2, j5, (Object) null, v5);
            if (H4 == 0) {
                mVar.c();
                break;
            } else if (H4 == 1) {
                break;
            } else if (H4 == 2) {
                C2308e eVar4 = eVar2;
                if (v5) {
                    mVar.t();
                    Object J03 = eVar3.J0(obj2, eVar4);
                    if (J03 == C2316b.f()) {
                        return J03;
                    }
                }
            } else if (H4 == 3) {
                Object a12 = eVar3.a1(mVar, i6, obj2, j5, eVar2);
                if (a12 == C2316b.f()) {
                    return a12;
                }
            } else if (H4 != 4) {
                if (H4 == 5) {
                    mVar.c();
                }
                eVar = eVar3;
                mVar2 = mVar;
                obj = obj2;
            } else {
                if (j5 < eVar3.i0()) {
                    mVar.c();
                }
                Object J04 = eVar3.J0(obj2, eVar2);
                if (J04 == C2316b.f()) {
                    return J04;
                }
            }
        }
        return J.f19942a;
    }

    private final long a0() {
        return f26390f.get(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x010d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object a1(y3.m r17, int r18, java.lang.Object r19, long r20, b3.C2308e r22) {
        /*
            r16 = this;
            b3.e r0 = c3.C2316b.c(r22)
            w3.n r7 = w3.C2890p.b(r0)
            r8 = 0
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            int r0 = r1.j1(r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x00ec
            r9 = 1
            if (r0 == r9) goto L_0x00e3
            r10 = 2
            if (r0 == r10) goto L_0x00db
            r11 = 4
            if (r0 == r11) goto L_0x00cf
            java.lang.String r12 = "unexpected"
            r13 = 5
            if (r0 != r13) goto L_0x00c8
            r17.c()     // Catch:{ all -> 0x0064 }
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f26392h     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0064 }
            y3.m r0 = (y3.m) r0     // Catch:{ all -> 0x0064 }
        L_0x0034:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = f26388d     // Catch:{ all -> 0x0064 }
            long r2 = r2.getAndIncrement(r1)     // Catch:{ all -> 0x0064 }
            r5 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r5 = r5 & r2
            boolean r8 = r1.w0(r2)     // Catch:{ all -> 0x0064 }
            int r2 = y3.C2933f.f26414b     // Catch:{ all -> 0x0064 }
            long r14 = (long) r2     // Catch:{ all -> 0x0064 }
            long r14 = r5 / r14
            long r2 = (long) r2     // Catch:{ all -> 0x0064 }
            long r2 = r5 % r2
            int r3 = (int) r2     // Catch:{ all -> 0x0064 }
            r20 = r12
            long r11 = r0.f17367c     // Catch:{ all -> 0x0064 }
            int r2 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r2 == 0) goto L_0x006b
            y3.m r2 = r1.Y(r14, r0)     // Catch:{ all -> 0x0064 }
            if (r2 != 0) goto L_0x006c
            if (r8 == 0) goto L_0x0067
        L_0x005f:
            r1.K0(r4, r7)     // Catch:{ all -> 0x0064 }
            goto L_0x00fa
        L_0x0064:
            r0 = move-exception
            goto L_0x0111
        L_0x0067:
            r12 = r20
            r11 = 4
            goto L_0x0034
        L_0x006b:
            r2 = r0
        L_0x006c:
            int r0 = r1.j1(r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x00bc
            if (r0 == r9) goto L_0x00b0
            if (r0 == r10) goto L_0x009b
            r3 = 3
            if (r0 == r3) goto L_0x0093
            r3 = 4
            if (r0 == r3) goto L_0x0087
            if (r0 == r13) goto L_0x007f
            goto L_0x0082
        L_0x007f:
            r2.c()     // Catch:{ all -> 0x0064 }
        L_0x0082:
            r12 = r20
            r0 = r2
            r11 = r3
            goto L_0x0034
        L_0x0087:
            long r8 = r1.i0()     // Catch:{ all -> 0x0064 }
            int r0 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x005f
            r2.c()     // Catch:{ all -> 0x0064 }
            goto L_0x005f
        L_0x0093:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0064 }
            r2 = r20
            r0.<init>(r2)     // Catch:{ all -> 0x0064 }
            throw r0     // Catch:{ all -> 0x0064 }
        L_0x009b:
            if (r8 == 0) goto L_0x00a1
            r2.t()     // Catch:{ all -> 0x0064 }
            goto L_0x005f
        L_0x00a1:
            boolean r0 = b.w.a(r7)     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x00a9
            r0 = r7
            goto L_0x00aa
        L_0x00a9:
            r0 = 0
        L_0x00aa:
            if (r0 == 0) goto L_0x00fa
            r1.Q0(r0, r2, r3)     // Catch:{ all -> 0x0064 }
            goto L_0x00fa
        L_0x00b0:
            W2.t$a r0 = W2.t.f19966b     // Catch:{ all -> 0x0064 }
            W2.J r0 = W2.J.f19942a     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = W2.t.b(r0)     // Catch:{ all -> 0x0064 }
        L_0x00b8:
            r7.resumeWith(r0)     // Catch:{ all -> 0x0064 }
            goto L_0x00fa
        L_0x00bc:
            r2.c()     // Catch:{ all -> 0x0064 }
            W2.t$a r0 = W2.t.f19966b     // Catch:{ all -> 0x0064 }
            W2.J r0 = W2.J.f19942a     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = W2.t.b(r0)     // Catch:{ all -> 0x0064 }
            goto L_0x00b8
        L_0x00c8:
            r2 = r12
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0064 }
            r0.<init>(r2)     // Catch:{ all -> 0x0064 }
            throw r0     // Catch:{ all -> 0x0064 }
        L_0x00cf:
            long r2 = r1.i0()     // Catch:{ all -> 0x0064 }
            int r0 = (r20 > r2 ? 1 : (r20 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x005f
            r17.c()     // Catch:{ all -> 0x0064 }
            goto L_0x005f
        L_0x00db:
            r2 = r17
            r3 = r18
            r1.Q0(r7, r2, r3)     // Catch:{ all -> 0x0064 }
            goto L_0x00fa
        L_0x00e3:
            W2.t$a r0 = W2.t.f19966b     // Catch:{ all -> 0x0064 }
            W2.J r0 = W2.J.f19942a     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = W2.t.b(r0)     // Catch:{ all -> 0x0064 }
            goto L_0x00b8
        L_0x00ec:
            r2 = r17
            r2.c()     // Catch:{ all -> 0x0064 }
            W2.t$a r0 = W2.t.f19966b     // Catch:{ all -> 0x0064 }
            W2.J r0 = W2.J.f19942a     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = W2.t.b(r0)     // Catch:{ all -> 0x0064 }
            goto L_0x00b8
        L_0x00fa:
            java.lang.Object r0 = r7.x()
            java.lang.Object r2 = c3.C2316b.f()
            if (r0 != r2) goto L_0x0107
            kotlin.coroutines.jvm.internal.h.c(r22)
        L_0x0107:
            java.lang.Object r2 = c3.C2316b.f()
            if (r0 != r2) goto L_0x010e
            return r0
        L_0x010e:
            W2.J r0 = W2.J.f19942a
            return r0
        L_0x0111:
            r7.N()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.C2932e.a1(y3.m, int, java.lang.Object, long, b3.e):java.lang.Object");
    }

    private final boolean b1(long j5) {
        if (w0(j5)) {
            return false;
        }
        return !M(j5 & 1152921504606846975L);
    }

    private final boolean c1(Object obj, Object obj2) {
        if (obj instanceof E3.c) {
            return ((E3.c) obj).b(this, obj2);
        }
        C2736f fVar = null;
        if (obj instanceof w) {
            kotlin.jvm.internal.t.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            C2886n nVar = ((w) obj).f26454a;
            C2938k b5 = C2938k.b(C2938k.f26437b.c(obj2));
            l lVar = this.f26398b;
            if (lVar != null) {
                fVar = L(lVar);
            }
            return C2933f.B(nVar, b5, (q) fVar);
        } else if (obj instanceof a) {
            kotlin.jvm.internal.t.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).i(obj2);
        } else if (obj instanceof C2882l) {
            kotlin.jvm.internal.t.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            C2882l lVar2 = (C2882l) obj;
            l lVar3 = this.f26398b;
            if (lVar3 != null) {
                fVar = J(lVar3);
            }
            return C2933f.B(lVar2, obj2, (q) fVar);
        } else {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
    }

    private final boolean d1(Object obj, m mVar, int i5) {
        if (obj instanceof C2882l) {
            kotlin.jvm.internal.t.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return C2933f.C((C2882l) obj, J.f19942a, (q) null, 2, (Object) null);
        } else if (!(obj instanceof E3.c)) {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        } else {
            kotlin.jvm.internal.t.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            android.support.v4.media.a.a(obj);
            android.support.v4.media.a.a(obj);
            J j5 = J.f19942a;
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public final Throwable f0() {
        Throwable c02 = c0();
        if (c02 == null) {
            return new q("Channel was closed");
        }
        return c02;
    }

    private final boolean f1(m mVar, int i5, long j5) {
        Object B4 = mVar.B(i5);
        if (!(B4 instanceof d1) || j5 < f26389e.get(this) || !mVar.v(i5, B4, C2933f.f26419g)) {
            return g1(mVar, i5, j5);
        }
        if (d1(B4, mVar, i5)) {
            mVar.F(i5, C2933f.f26416d);
            return true;
        }
        mVar.F(i5, C2933f.f26422j);
        mVar.C(i5, false);
        return false;
    }

    private final boolean g1(m mVar, int i5, long j5) {
        while (true) {
            Object B4 = mVar.B(i5);
            if (B4 instanceof d1) {
                if (j5 < f26389e.get(this)) {
                    if (mVar.v(i5, B4, new z((d1) B4))) {
                        return true;
                    }
                } else if (mVar.v(i5, B4, C2933f.f26419g)) {
                    if (d1(B4, mVar, i5)) {
                        mVar.F(i5, C2933f.f26416d);
                        return true;
                    }
                    mVar.F(i5, C2933f.f26422j);
                    mVar.C(i5, false);
                    return false;
                }
            } else if (B4 == C2933f.f26422j) {
                return false;
            } else {
                if (B4 == null) {
                    if (mVar.v(i5, B4, C2933f.f26417e)) {
                        return true;
                    }
                } else if (B4 == C2933f.f26416d || B4 == C2933f.f26420h || B4 == C2933f.f26421i || B4 == C2933f.f26423k || B4 == C2933f.z()) {
                    return true;
                } else {
                    if (B4 != C2933f.f26418f) {
                        throw new IllegalStateException(("Unexpected cell state: " + B4).toString());
                    }
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final Object h1(m mVar, int i5, long j5, Object obj) {
        Object B4 = mVar.B(i5);
        if (B4 == null) {
            if (j5 >= (f26388d.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return C2933f.f26426n;
                }
                if (mVar.v(i5, B4, obj)) {
                    V();
                    return C2933f.f26425m;
                }
            }
        } else if (B4 == C2933f.f26416d && mVar.v(i5, B4, C2933f.f26421i)) {
            V();
            return mVar.D(i5);
        }
        return i1(mVar, i5, j5, obj);
    }

    private final Object i1(m mVar, int i5, long j5, Object obj) {
        while (true) {
            Object B4 = mVar.B(i5);
            if (B4 == null || B4 == C2933f.f26417e) {
                if (j5 < (f26388d.get(this) & 1152921504606846975L)) {
                    if (mVar.v(i5, B4, C2933f.f26420h)) {
                        V();
                        return C2933f.f26427o;
                    }
                } else if (obj == null) {
                    return C2933f.f26426n;
                } else {
                    if (mVar.v(i5, B4, obj)) {
                        V();
                        return C2933f.f26425m;
                    }
                }
            } else if (B4 == C2933f.f26416d) {
                if (mVar.v(i5, B4, C2933f.f26421i)) {
                    V();
                    return mVar.D(i5);
                }
            } else if (B4 == C2933f.f26422j) {
                return C2933f.f26427o;
            } else {
                if (B4 == C2933f.f26420h) {
                    return C2933f.f26427o;
                }
                if (B4 == C2933f.z()) {
                    V();
                    return C2933f.f26427o;
                } else if (B4 != C2933f.f26419g && mVar.v(i5, B4, C2933f.f26418f)) {
                    boolean z4 = B4 instanceof z;
                    if (z4) {
                        B4 = ((z) B4).f26455a;
                    }
                    if (d1(B4, mVar, i5)) {
                        mVar.F(i5, C2933f.f26421i);
                        V();
                        return mVar.D(i5);
                    }
                    mVar.F(i5, C2933f.f26422j);
                    mVar.C(i5, false);
                    if (z4) {
                        V();
                    }
                    return C2933f.f26427o;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final int j1(m mVar, int i5, Object obj, long j5, Object obj2, boolean z4) {
        mVar.G(i5, obj);
        if (z4) {
            int k12 = k1(mVar, i5, obj, j5, obj2, z4);
            return k12;
        }
        boolean z5 = z4;
        Object obj3 = obj2;
        long j6 = j5;
        Object obj4 = obj;
        Object B4 = mVar.B(i5);
        if (B4 == null) {
            if (M(j6)) {
                if (mVar.v(i5, (Object) null, C2933f.f26416d)) {
                    return 1;
                }
            } else if (obj3 == null) {
                return 3;
            } else {
                if (mVar.v(i5, (Object) null, obj3)) {
                    return 2;
                }
            }
        } else if (B4 instanceof d1) {
            mVar.w(i5);
            if (c1(B4, obj4)) {
                mVar.F(i5, C2933f.f26421i);
                L0();
                return 0;
            } else if (mVar.x(i5, C2933f.f26423k) == C2933f.f26423k) {
                return 5;
            } else {
                mVar.C(i5, true);
                return 5;
            }
        }
        return k1(mVar, i5, obj4, j6, obj3, z5);
    }

    private final int k1(m mVar, int i5, Object obj, long j5, Object obj2, boolean z4) {
        while (true) {
            Object B4 = mVar.B(i5);
            if (B4 == null) {
                if (!M(j5) || z4) {
                    if (z4) {
                        if (mVar.v(i5, (Object) null, C2933f.f26422j)) {
                            mVar.C(i5, false);
                            return 4;
                        }
                    } else if (obj2 == null) {
                        return 3;
                    } else {
                        if (mVar.v(i5, (Object) null, obj2)) {
                            return 2;
                        }
                    }
                } else if (mVar.v(i5, (Object) null, C2933f.f26416d)) {
                    return 1;
                }
            } else if (B4 == C2933f.f26417e) {
                if (mVar.v(i5, B4, C2933f.f26416d)) {
                    return 1;
                }
            } else if (B4 == C2933f.f26423k) {
                mVar.w(i5);
                return 5;
            } else if (B4 == C2933f.f26420h) {
                mVar.w(i5);
                return 5;
            } else if (B4 == C2933f.z()) {
                mVar.w(i5);
                T();
                return 4;
            } else {
                mVar.w(i5);
                if (B4 instanceof z) {
                    B4 = ((z) B4).f26455a;
                }
                if (c1(B4, obj)) {
                    mVar.F(i5, C2933f.f26421i);
                    L0();
                    return 0;
                }
                if (mVar.x(i5, C2933f.f26423k) != C2933f.f26423k) {
                    mVar.C(i5, true);
                }
                return 5;
            }
        }
    }

    private final void l1(long j5) {
        AtomicLongFieldUpdater h02 = f26389e;
        while (true) {
            long j6 = h02.get(this);
            if (j6 < j5) {
                long j7 = j5;
                if (!f26389e.compareAndSet(this, j6, j7)) {
                    j5 = j7;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final void m1(long j5) {
        long j6;
        long j7;
        AtomicLongFieldUpdater l02 = f26388d;
        do {
            j6 = l02.get(this);
            j7 = 1152921504606846975L & j6;
            if (j7 < j5) {
            } else {
                return;
            }
        } while (!f26388d.compareAndSet(this, j6, C2933f.w(j7, (int) (j6 >> 60))));
    }

    private final void p0(long j5) {
        if ((f26391g.addAndGet(this, j5) & 4611686018427387904L) != 0) {
            do {
            } while ((f26391g.get(this) & 4611686018427387904L) != 0);
        }
    }

    static /* synthetic */ void q0(C2932e eVar, long j5, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 1) != 0) {
                j5 = 1;
            }
            eVar.p0(j5);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    private final void r0() {
        Object obj;
        D d5;
        AtomicReferenceFieldUpdater d02 = f26396l;
        do {
            obj = d02.get(this);
            if (obj == null) {
                d5 = C2933f.f26429q;
            } else {
                d5 = C2933f.f26430r;
            }
        } while (!androidx.concurrent.futures.a.a(d02, this, obj, d5));
        if (obj != null) {
            l lVar = (l) kotlin.jvm.internal.S.c(obj, 1);
            ((l) obj).invoke(c0());
        }
    }

    private final boolean s0(m mVar, int i5, long j5) {
        Object B4;
        do {
            B4 = mVar.B(i5);
            if (B4 != null && B4 != C2933f.f26417e) {
                if (B4 == C2933f.f26416d) {
                    return true;
                }
                if (B4 == C2933f.f26422j || B4 == C2933f.z() || B4 == C2933f.f26421i || B4 == C2933f.f26420h) {
                    return false;
                }
                if (B4 == C2933f.f26419g) {
                    return true;
                }
                if (B4 != C2933f.f26418f && j5 == i0()) {
                    return true;
                }
                return false;
            }
        } while (!mVar.v(i5, B4, C2933f.f26420h));
        V();
        return false;
    }

    private final boolean t0(long j5, boolean z4) {
        int i5 = (int) (j5 >> 60);
        if (i5 == 0 || i5 == 1) {
            return false;
        }
        if (i5 == 2) {
            S(j5 & 1152921504606846975L);
            if (!z4 || !o0()) {
                return true;
            }
            return false;
        } else if (i5 == 3) {
            R(j5 & 1152921504606846975L);
            return true;
        } else {
            throw new IllegalStateException(("unexpected close status: " + i5).toString());
        }
    }

    private final boolean v0(long j5) {
        return t0(j5, true);
    }

    /* access modifiers changed from: private */
    public final boolean w0(long j5) {
        return t0(j5, false);
    }

    private final boolean y0() {
        long a02 = a0();
        if (a02 == 0 || a02 == Long.MAX_VALUE) {
            return true;
        }
        return false;
    }

    private final long z0(m mVar) {
        do {
            int i5 = C2933f.f26414b;
            while (true) {
                i5--;
                if (-1 < i5) {
                    long j5 = (mVar.f17367c * ((long) C2933f.f26414b)) + ((long) i5);
                    if (j5 < i0()) {
                        return -1;
                    }
                    while (true) {
                        Object B4 = mVar.B(i5);
                        if (B4 == null || B4 == C2933f.f26417e) {
                            if (mVar.v(i5, B4, C2933f.z())) {
                                mVar.t();
                                break;
                            }
                        } else if (B4 == C2933f.f26416d) {
                            return j5;
                        }
                    }
                } else {
                    mVar = (m) mVar.h();
                }
            }
        } while (mVar != null);
        return -1;
    }

    public boolean D() {
        return w0(f26388d.get(this));
    }

    public boolean N(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return Q(th, true);
    }

    /* access modifiers changed from: protected */
    public boolean Q(Throwable th, boolean z4) {
        if (z4) {
            A0();
        }
        boolean a5 = androidx.concurrent.futures.a.a(f26395k, this, C2933f.f26431s, th);
        if (z4) {
            B0();
        } else {
            C0();
        }
        T();
        G0();
        if (a5) {
            r0();
        }
        return a5;
    }

    /* access modifiers changed from: protected */
    public final void U(long j5) {
        m mVar;
        S c5;
        m mVar2 = (m) f26393i.get(this);
        while (true) {
            long j6 = f26389e.get(this);
            if (j5 >= Math.max(((long) this.f26397a) + j6, a0())) {
                if (f26389e.compareAndSet(this, j6, 1 + j6)) {
                    int i5 = C2933f.f26414b;
                    long j7 = j6 / ((long) i5);
                    int i6 = (int) (j6 % ((long) i5));
                    if (mVar2.f17367c != j7) {
                        mVar = X(j7, mVar2);
                        if (mVar == null) {
                            continue;
                        }
                    } else {
                        mVar = mVar2;
                    }
                    long j8 = j6;
                    Object h12 = h1(mVar, i6, j8, (Object) null);
                    long j9 = j8;
                    if (h12 != C2933f.f26427o) {
                        mVar.c();
                        l lVar = this.f26398b;
                        if (!(lVar == null || (c5 = w.c(lVar, h12, (S) null, 2, (Object) null)) == null)) {
                            throw c5;
                        }
                    } else if (j9 < m0()) {
                        mVar.c();
                    }
                    mVar2 = mVar;
                }
            } else {
                return;
            }
        }
    }

    public final void a(CancellationException cancellationException) {
        N(cancellationException);
    }

    public Object b(C2308e eVar) {
        return S0(this, eVar);
    }

    /* access modifiers changed from: protected */
    public final Throwable c0() {
        return (Throwable) f26395k.get(this);
    }

    public Object e(Object obj, C2308e eVar) {
        return Z0(this, obj, eVar);
    }

    /* access modifiers changed from: protected */
    public final Object e1(Object obj) {
        m mVar;
        int i5;
        C2932e eVar;
        d1 d1Var;
        D d5 = C2933f.f26416d;
        m mVar2 = (m) f26392h.get(this);
        while (true) {
            long andIncrement = f26388d.getAndIncrement(this);
            long j5 = 1152921504606846975L & andIncrement;
            boolean v5 = w0(andIncrement);
            int i6 = C2933f.f26414b;
            long j6 = j5 / ((long) i6);
            int i7 = (int) (j5 % ((long) i6));
            if (mVar2.f17367c != j6) {
                mVar = Y(j6, mVar2);
                if (mVar != null) {
                    eVar = this;
                    i5 = i7;
                } else if (v5) {
                    return C2938k.f26437b.a(j0());
                }
            } else {
                mVar = mVar2;
                i5 = i7;
                eVar = this;
            }
            long j7 = j5;
            Object obj2 = obj;
            int H4 = eVar.j1(mVar, i5, obj2, j7, d5, v5);
            m mVar3 = mVar;
            C2932e eVar2 = eVar;
            mVar2 = mVar3;
            if (H4 == 0) {
                mVar2.c();
                return C2938k.f26437b.c(J.f19942a);
            } else if (H4 == 1) {
                return C2938k.f26437b.c(J.f19942a);
            } else {
                if (H4 != 2) {
                    if (H4 == 3) {
                        throw new IllegalStateException("unexpected");
                    } else if (H4 != 4) {
                        if (H4 == 5) {
                            mVar2.c();
                        }
                        obj = obj2;
                    } else {
                        if (j7 < i0()) {
                            mVar2.c();
                        }
                        return C2938k.f26437b.a(j0());
                    }
                } else if (v5) {
                    mVar2.t();
                    return C2938k.f26437b.a(j0());
                } else {
                    if (d5 instanceof d1) {
                        d1Var = (d1) d5;
                    } else {
                        d1Var = null;
                    }
                    if (d1Var != null) {
                        Q0(d1Var, mVar2, i5);
                    }
                    U((mVar2.f17367c * ((long) i6)) + ((long) i5));
                    return C2938k.f26437b.c(J.f19942a);
                }
            }
        }
    }

    public Object f() {
        m mVar;
        d1 d1Var;
        long j5 = f26389e.get(this);
        long j6 = f26388d.get(this);
        if (v0(j6)) {
            return C2938k.f26437b.a(c0());
        }
        if (j5 >= (j6 & 1152921504606846975L)) {
            return C2938k.f26437b.b();
        }
        D i5 = C2933f.f26423k;
        m mVar2 = (m) f26393i.get(this);
        while (!u0()) {
            long andIncrement = f26389e.getAndIncrement(this);
            int i6 = C2933f.f26414b;
            long j7 = andIncrement / ((long) i6);
            int i7 = (int) (andIncrement % ((long) i6));
            if (mVar2.f17367c != j7) {
                mVar = X(j7, mVar2);
                if (mVar == null) {
                    continue;
                }
            } else {
                mVar = mVar2;
            }
            int i8 = i7;
            Object G4 = h1(mVar, i8, andIncrement, i5);
            if (G4 == C2933f.f26425m) {
                if (i5 instanceof d1) {
                    d1Var = (d1) i5;
                } else {
                    d1Var = null;
                }
                if (d1Var != null) {
                    P0(d1Var, mVar, i8);
                }
                n1(andIncrement);
                mVar.t();
                return C2938k.f26437b.b();
            } else if (G4 == C2933f.f26427o) {
                if (andIncrement < m0()) {
                    mVar.c();
                }
                mVar2 = mVar;
            } else if (G4 != C2933f.f26426n) {
                mVar.c();
                return C2938k.f26437b.c(G4);
            } else {
                throw new IllegalStateException("unexpected");
            }
        }
        return C2938k.f26437b.a(c0());
    }

    public boolean i(Throwable th) {
        return Q(th, false);
    }

    public final long i0() {
        return f26389e.get(this);
    }

    public C2936i iterator() {
        return new a();
    }

    public Object j(C2308e eVar) {
        return R0(this, eVar);
    }

    /* access modifiers changed from: protected */
    public final Throwable j0() {
        Throwable c02 = c0();
        if (c02 == null) {
            return new r("Channel was closed");
        }
        return c02;
    }

    public final long m0() {
        return f26388d.get(this) & 1152921504606846975L;
    }

    public final void n1(long j5) {
        C2932e eVar;
        boolean z4;
        C2932e eVar2 = this;
        if (!eVar2.y0()) {
            while (eVar2.a0() <= j5) {
                eVar2 = this;
            }
            int g5 = C2933f.f26415c;
            int i5 = 0;
            while (i5 < g5) {
                long a02 = eVar2.a0();
                if (a02 != (4611686018427387903L & f26391g.get(eVar2)) || a02 != eVar2.a0()) {
                    i5++;
                } else {
                    return;
                }
            }
            AtomicLongFieldUpdater e02 = f26391g;
            while (true) {
                long j6 = e02.get(eVar);
                if (e02.compareAndSet(eVar, j6, C2933f.v(j6 & 4611686018427387903L, true))) {
                    break;
                }
                eVar2 = this;
            }
            while (true) {
                long a03 = eVar.a0();
                long j7 = f26391g.get(eVar);
                long j8 = j7 & 4611686018427387903L;
                if ((4611686018427387904L & j7) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (a03 == j8 && a03 == eVar.a0()) {
                    break;
                } else if (!z4) {
                    eVar = this;
                    f26391g.compareAndSet(eVar, j7, C2933f.v(j8, true));
                } else {
                    eVar = this;
                }
            }
            AtomicLongFieldUpdater e03 = f26391g;
            while (true) {
                long j9 = e03.get(eVar);
                boolean compareAndSet = e03.compareAndSet(eVar, j9, C2933f.v(j9 & 4611686018427387903L, false));
                AtomicLongFieldUpdater atomicLongFieldUpdater = e03;
                if (!compareAndSet) {
                    e03 = atomicLongFieldUpdater;
                    eVar = this;
                } else {
                    return;
                }
            }
        }
    }

    public final boolean o0() {
        while (true) {
            m mVar = (m) f26393i.get(this);
            long i02 = i0();
            if (m0() <= i02) {
                return false;
            }
            int i5 = C2933f.f26414b;
            long j5 = i02 / ((long) i5);
            if (mVar.f17367c == j5 || (mVar = X(j5, mVar)) != null) {
                mVar.c();
                if (s0(mVar, (int) (i02 % ((long) i5)), i02)) {
                    return true;
                }
                f26389e.compareAndSet(this, i02, 1 + i02);
            } else if (((m) f26393i.get(this)).f17367c < j5) {
                return false;
            }
        }
    }

    public Object r(Object obj) {
        m mVar;
        long j5;
        C2932e eVar;
        d1 d1Var;
        if (b1(f26388d.get(this))) {
            return C2938k.f26437b.b();
        }
        D j6 = C2933f.f26422j;
        m mVar2 = (m) f26392h.get(this);
        while (true) {
            long andIncrement = f26388d.getAndIncrement(this);
            long j7 = 1152921504606846975L & andIncrement;
            boolean v5 = w0(andIncrement);
            int i5 = C2933f.f26414b;
            long j8 = j7 / ((long) i5);
            int i6 = (int) (j7 % ((long) i5));
            if (mVar2.f17367c != j8) {
                mVar = Y(j8, mVar2);
                if (mVar != null) {
                    eVar = this;
                    j5 = j7;
                } else if (v5) {
                    return C2938k.f26437b.a(j0());
                }
            } else {
                mVar = mVar2;
                j5 = j7;
                eVar = this;
            }
            Object obj2 = obj;
            int H4 = eVar.j1(mVar, i6, obj2, j5, j6, v5);
            m mVar3 = mVar;
            C2932e eVar2 = eVar;
            mVar2 = mVar3;
            if (H4 == 0) {
                mVar2.c();
                return C2938k.f26437b.c(J.f19942a);
            } else if (H4 == 1) {
                return C2938k.f26437b.c(J.f19942a);
            } else {
                if (H4 != 2) {
                    if (H4 == 3) {
                        throw new IllegalStateException("unexpected");
                    } else if (H4 != 4) {
                        if (H4 == 5) {
                            mVar2.c();
                        }
                        obj = obj2;
                    } else {
                        if (j5 < i0()) {
                            mVar2.c();
                        }
                        return C2938k.f26437b.a(j0());
                    }
                } else if (v5) {
                    mVar2.t();
                    return C2938k.f26437b.a(j0());
                } else {
                    if (j6 instanceof d1) {
                        d1Var = (d1) j6;
                    } else {
                        d1Var = null;
                    }
                    if (d1Var != null) {
                        Q0(d1Var, mVar2, i6);
                    }
                    mVar2.t();
                    return C2938k.f26437b.b();
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r2v13, types: [B3.b] */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01d7, code lost:
        r16 = r7;
        r3 = r3.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01e0, code lost:
        if (r3 != null) goto L_0x0201;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r17 = this;
            r0 = r17
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = f26388d
            long r2 = r2.get(r0)
            r4 = 60
            long r2 = r2 >> r4
            int r2 = (int) r2
            r3 = 3
            r4 = 2
            if (r2 == r4) goto L_0x0020
            if (r2 == r3) goto L_0x001a
            goto L_0x0025
        L_0x001a:
            java.lang.String r2 = "cancelled,"
            r1.append(r2)
            goto L_0x0025
        L_0x0020:
            java.lang.String r2 = "closed,"
            r1.append(r2)
        L_0x0025:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "capacity="
            r2.append(r5)
            int r5 = r0.f26397a
            r2.append(r5)
            r5 = 44
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r2 = "data=["
            r1.append(r2)
            y3.m[] r2 = new y3.m[r3]
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f26393i
            java.lang.Object r3 = r3.get(r0)
            r6 = 0
            r2[r6] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f26392h
            java.lang.Object r3 = r3.get(r0)
            r7 = 1
            r2[r7] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f26394j
            java.lang.Object r3 = r3.get(r0)
            r2[r4] = r3
            java.util.List r2 = X2.C2250q.j(r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x0076:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x008d
            java.lang.Object r4 = r2.next()
            r8 = r4
            y3.m r8 = (y3.m) r8
            y3.m r9 = y3.C2933f.f26413a
            if (r8 == r9) goto L_0x0076
            r3.add(r4)
            goto L_0x0076
        L_0x008d:
            java.util.Iterator r2 = r3.iterator()
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0206
            java.lang.Object r3 = r2.next()
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x00a2
            goto L_0x00bc
        L_0x00a2:
            r4 = r3
            y3.m r4 = (y3.m) r4
            long r8 = r4.f17367c
        L_0x00a7:
            java.lang.Object r4 = r2.next()
            r10 = r4
            y3.m r10 = (y3.m) r10
            long r10 = r10.f17367c
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x00b6
            r3 = r4
            r8 = r10
        L_0x00b6:
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x00a7
        L_0x00bc:
            y3.m r3 = (y3.m) r3
            long r10 = r0.i0()
            long r12 = r0.m0()
        L_0x00c6:
            int r2 = y3.C2933f.f26414b
            r4 = r6
        L_0x00c9:
            if (r4 >= r2) goto L_0x01d7
            long r8 = r3.f17367c
            int r14 = y3.C2933f.f26414b
            long r14 = (long) r14
            long r8 = r8 * r14
            long r14 = (long) r4
            long r8 = r8 + r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x00e0
            int r15 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r15 >= 0) goto L_0x00dc
            goto L_0x00e0
        L_0x00dc:
            r16 = r7
            goto L_0x01e2
        L_0x00e0:
            java.lang.Object r15 = r3.B(r4)
            java.lang.Object r6 = r3.A(r4)
            r16 = r7
            boolean r7 = r15 instanceof w3.C2882l
            if (r7 == 0) goto L_0x0104
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x00f8
            if (r14 < 0) goto L_0x00f8
            java.lang.String r7 = "receive"
            goto L_0x019c
        L_0x00f8:
            if (r14 >= 0) goto L_0x0100
            if (r7 < 0) goto L_0x0100
            java.lang.String r7 = "send"
            goto L_0x019c
        L_0x0100:
            java.lang.String r7 = "cont"
            goto L_0x019c
        L_0x0104:
            boolean r7 = r15 instanceof E3.c
            if (r7 == 0) goto L_0x011e
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x0112
            if (r14 < 0) goto L_0x0112
            java.lang.String r7 = "onReceive"
            goto L_0x019c
        L_0x0112:
            if (r14 >= 0) goto L_0x011a
            if (r7 < 0) goto L_0x011a
            java.lang.String r7 = "onSend"
            goto L_0x019c
        L_0x011a:
            java.lang.String r7 = "select"
            goto L_0x019c
        L_0x011e:
            boolean r7 = r15 instanceof y3.w
            if (r7 == 0) goto L_0x0126
            java.lang.String r7 = "receiveCatching"
            goto L_0x019c
        L_0x0126:
            boolean r7 = r15 instanceof y3.z
            if (r7 == 0) goto L_0x0141
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "EB("
            r7.append(r8)
            r7.append(r15)
            r8 = 41
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            goto L_0x019c
        L_0x0141:
            B3.D r7 = y3.C2933f.f26418f
            boolean r7 = kotlin.jvm.internal.t.a(r15, r7)
            if (r7 != 0) goto L_0x019a
            B3.D r7 = y3.C2933f.f26419g
            boolean r7 = kotlin.jvm.internal.t.a(r15, r7)
            if (r7 == 0) goto L_0x0156
            goto L_0x019a
        L_0x0156:
            if (r15 == 0) goto L_0x01d0
            B3.D r7 = y3.C2933f.f26417e
            boolean r7 = kotlin.jvm.internal.t.a(r15, r7)
            if (r7 != 0) goto L_0x01d0
            B3.D r7 = y3.C2933f.f26421i
            boolean r7 = kotlin.jvm.internal.t.a(r15, r7)
            if (r7 != 0) goto L_0x01d0
            B3.D r7 = y3.C2933f.f26420h
            boolean r7 = kotlin.jvm.internal.t.a(r15, r7)
            if (r7 != 0) goto L_0x01d0
            B3.D r7 = y3.C2933f.f26423k
            boolean r7 = kotlin.jvm.internal.t.a(r15, r7)
            if (r7 != 0) goto L_0x01d0
            B3.D r7 = y3.C2933f.f26422j
            boolean r7 = kotlin.jvm.internal.t.a(r15, r7)
            if (r7 != 0) goto L_0x01d0
            B3.D r7 = y3.C2933f.z()
            boolean r7 = kotlin.jvm.internal.t.a(r15, r7)
            if (r7 == 0) goto L_0x0195
            goto L_0x01d0
        L_0x0195:
            java.lang.String r7 = r15.toString()
            goto L_0x019c
        L_0x019a:
            java.lang.String r7 = "resuming_sender"
        L_0x019c:
            if (r6 == 0) goto L_0x01be
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r9 = 40
            r8.append(r9)
            r8.append(r7)
            r8.append(r5)
            r8.append(r6)
            java.lang.String r6 = "),"
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r1.append(r6)
            goto L_0x01d0
        L_0x01be:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            r1.append(r6)
        L_0x01d0:
            int r4 = r4 + 1
            r7 = r16
            r6 = 0
            goto L_0x00c9
        L_0x01d7:
            r16 = r7
            B3.b r2 = r3.f()
            r3 = r2
            y3.m r3 = (y3.m) r3
            if (r3 != 0) goto L_0x0201
        L_0x01e2:
            char r2 = t3.s.a1(r1)
            if (r2 != r5) goto L_0x01f7
            int r2 = r1.length()
            int r2 = r2 + -1
            java.lang.StringBuilder r2 = r1.deleteCharAt(r2)
            java.lang.String r3 = "deleteCharAt(...)"
            kotlin.jvm.internal.t.d(r2, r3)
        L_0x01f7:
            java.lang.String r2 = "]"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0201:
            r7 = r16
            r6 = 0
            goto L_0x00c6
        L_0x0206:
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.C2932e.toString():java.lang.String");
    }

    public boolean u0() {
        return v0(f26388d.get(this));
    }

    public void w(l lVar) {
        if (!androidx.concurrent.futures.a.a(f26396l, this, (Object) null, lVar)) {
            AtomicReferenceFieldUpdater d02 = f26396l;
            do {
                Object obj = d02.get(this);
                if (obj != C2933f.f26429q) {
                    if (obj == C2933f.f26430r) {
                        throw new IllegalStateException("Another handler was already registered and successfully invoked");
                    }
                    throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                }
            } while (!androidx.concurrent.futures.a.a(f26396l, this, C2933f.f26429q, C2933f.f26430r));
            lVar.invoke(c0());
        }
    }

    /* access modifiers changed from: protected */
    public boolean x0() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void G0() {
    }

    /* access modifiers changed from: protected */
    public void L0() {
    }

    /* access modifiers changed from: protected */
    public void M0() {
    }
}
