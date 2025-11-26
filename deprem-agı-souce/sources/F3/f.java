package F3;

import B3.A;
import B3.D;
import W2.J;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k3.l;
import k3.q;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.C2639q;
import kotlin.jvm.internal.S;
import kotlin.jvm.internal.t;
import w3.C2882l;
import w3.C2886n;
import w3.C2890p;
import w3.I;
import w3.Q;
import w3.d1;

public class f extends j implements a {
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18109i = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "owner$volatile");

    /* renamed from: h  reason: collision with root package name */
    private final q f18110h;
    private volatile /* synthetic */ Object owner$volatile;

    private final class a implements C2882l, d1 {

        /* renamed from: a  reason: collision with root package name */
        public final C2886n f18111a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f18112b;

        public a(C2886n nVar, Object obj) {
            this.f18111a = nVar;
            this.f18112b = obj;
        }

        /* access modifiers changed from: private */
        public static final J f(f fVar, a aVar, Throwable th) {
            fVar.unlock(aVar.f18112b);
            return J.f19942a;
        }

        /* access modifiers changed from: private */
        public static final J l(f fVar, a aVar, Throwable th, J j5, C2312i iVar) {
            f.f18109i.set(fVar, aVar.f18112b);
            fVar.unlock(aVar.f18112b);
            return J.f19942a;
        }

        public void E(Object obj) {
            this.f18111a.E(obj);
        }

        public void a(A a5, int i5) {
            this.f18111a.a(a5, i5);
        }

        /* renamed from: e */
        public void c(J j5, q qVar) {
            f.f18109i.set(f.this, this.f18112b);
            this.f18111a.P(j5, new e(f.this, this));
        }

        public void g(l lVar) {
            this.f18111a.g(lVar);
        }

        public C2312i getContext() {
            return this.f18111a.getContext();
        }

        /* renamed from: i */
        public void h(I i5, J j5) {
            this.f18111a.h(i5, j5);
        }

        /* renamed from: j */
        public Object q(J j5, Object obj, q qVar) {
            Object q5 = this.f18111a.q(j5, obj, new d(f.this, this));
            if (q5 != null) {
                f.f18109i.set(f.this, this.f18112b);
            }
            return q5;
        }

        public boolean k(Throwable th) {
            return this.f18111a.k(th);
        }

        public void resumeWith(Object obj) {
            this.f18111a.resumeWith(obj);
        }
    }

    private final class b implements E3.d {

        /* renamed from: a  reason: collision with root package name */
        public final E3.d f18114a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f18115b;

        public b(E3.d dVar, Object obj) {
            this.f18114a = dVar;
            this.f18115b = obj;
        }

        public void a(A a5, int i5) {
            this.f18114a.a(a5, i5);
        }

        public boolean b(Object obj, Object obj2) {
            boolean b5 = this.f18114a.b(obj, obj2);
            f fVar = f.this;
            if (b5) {
                f.f18109i.set(fVar, this.f18115b);
            }
            return b5;
        }

        public void c(Object obj) {
            f.f18109i.set(f.this, this.f18115b);
            this.f18114a.c(obj);
        }

        public C2312i getContext() {
            return this.f18114a.getContext();
        }
    }

    /* synthetic */ class c extends C2639q implements q {

        /* renamed from: a  reason: collision with root package name */
        public static final c f18117a = new c();

        c() {
            super(3, f.class, "onLockRegFunction", "onLockRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        public final void g(f fVar, E3.c cVar, Object obj) {
            fVar.B(cVar, obj);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            g((f) obj, (E3.c) obj2, obj3);
            return J.f19942a;
        }
    }

    /* synthetic */ class d extends C2639q implements q {

        /* renamed from: a  reason: collision with root package name */
        public static final d f18118a = new d();

        d() {
            super(3, f.class, "onLockProcessResult", "onLockProcessResult(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        /* renamed from: g */
        public final Object invoke(f fVar, Object obj, Object obj2) {
            return fVar.A(obj, obj2);
        }
    }

    public f(boolean z4) {
        super(1, z4 ? 1 : 0);
        D d5;
        if (z4) {
            d5 = null;
        } else {
            d5 = g.f18119a;
        }
        this.owner$volatile = d5;
        this.f18110h = new b(this);
    }

    /* access modifiers changed from: private */
    public static final q C(f fVar, E3.c cVar, Object obj, Object obj2) {
        return new c(fVar, obj);
    }

    /* access modifiers changed from: private */
    public static final J D(f fVar, Object obj, Throwable th, Object obj2, C2312i iVar) {
        fVar.unlock(obj);
        return J.f19942a;
    }

    private final int E(Object obj) {
        while (!q()) {
            if (obj == null) {
                return 1;
            }
            int x4 = x(obj);
            if (x4 == 1) {
                return 2;
            }
            if (x4 == 2) {
                return 1;
            }
        }
        f18109i.set(this, obj);
        return 0;
    }

    private final int x(Object obj) {
        while (isLocked()) {
            Object obj2 = f18109i.get(this);
            if (obj2 != g.f18119a) {
                if (obj2 == obj) {
                    return 1;
                }
                return 2;
            }
        }
        return 0;
    }

    static /* synthetic */ Object y(f fVar, Object obj, C2308e eVar) {
        if (fVar.tryLock(obj)) {
            return J.f19942a;
        }
        Object z4 = fVar.z(obj, eVar);
        if (z4 == C2316b.f()) {
            return z4;
        }
        return J.f19942a;
    }

    private final Object z(Object obj, C2308e eVar) {
        C2886n b5 = C2890p.b(C2316b.c(eVar));
        try {
            e(new a(b5, obj));
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

    /* access modifiers changed from: protected */
    public Object A(Object obj, Object obj2) {
        if (!t.a(obj2, g.f18120b)) {
            return this;
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    /* access modifiers changed from: protected */
    public void B(E3.c cVar, Object obj) {
        if (obj == null || !holdsLock(obj)) {
            t.c(cVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
            o(new b((E3.d) cVar, obj), obj);
            return;
        }
        cVar.c(g.f18120b);
    }

    public E3.a getOnLock() {
        c cVar = c.f18117a;
        t.c(cVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        d dVar = d.f18118a;
        t.c(dVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new E3.b(this, (q) S.c(cVar, 3), (q) S.c(dVar, 3), this.f18110h);
    }

    public boolean holdsLock(Object obj) {
        if (x(obj) == 1) {
            return true;
        }
        return false;
    }

    public boolean isLocked() {
        if (a() == 0) {
            return true;
        }
        return false;
    }

    public Object lock(Object obj, C2308e eVar) {
        return y(this, obj, eVar);
    }

    public String toString() {
        return "Mutex@" + Q.b(this) + "[isLocked=" + isLocked() + ",owner=" + f18109i.get(this) + ']';
    }

    public boolean tryLock(Object obj) {
        int E4 = E(obj);
        if (E4 == 0) {
            return true;
        }
        if (E4 == 1) {
            return false;
        }
        if (E4 != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    public void unlock(Object obj) {
        while (isLocked()) {
            Object obj2 = f18109i.get(this);
            if (obj2 != g.f18119a) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                } else if (androidx.concurrent.futures.a.a(f18109i, this, obj2, g.f18119a)) {
                    release();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }
}
