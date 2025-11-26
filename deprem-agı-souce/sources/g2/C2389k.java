package g2;

import W2.J;
import W2.u;
import android.content.Context;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import k2.C2610u;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2657f;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.O;
import z2.Z;

/* renamed from: g2.k  reason: case insensitive filesystem */
public final class C2389k {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f21940a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f21941b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final C2610u f21942c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final M f21943d;

    /* renamed from: g2.k$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21944a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2389k f21945b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2389k kVar, C2308e eVar) {
            super(2, eVar);
            this.f21945b = kVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f21945b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21944a;
            if (i5 == 0) {
                u.b(obj);
                C2389k kVar = this.f21945b;
                this.f21944a = 1;
                if (kVar.f(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.k$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21946a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2389k f21947b;

        /* renamed from: g2.k$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21948a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2389k f21949b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2389k kVar, C2308e eVar) {
                super(2, eVar);
                this.f21949b = kVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21949b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21948a == 0) {
                    u.b(obj);
                    this.f21949b.f21942c.d(-1);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2389k kVar, C2308e eVar) {
            super(2, eVar);
            this.f21947b = kVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21947b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21946a;
            if (i5 == 0) {
                u.b(obj);
                Context a5 = this.f21947b.f21940a;
                t.b(a5);
                long f6 = new C2657f().f(new Z(a5).n(this.f21947b.f21941b));
                if (f6 > 0) {
                    return new C2388j(this.f21947b.f21940a, f6, this.f21947b.f21942c, this.f21947b.f21943d);
                }
                I0 c5 = C2865c0.c();
                a aVar = new a(this.f21947b, (C2308e) null);
                this.f21946a = 1;
                if (C2872g.g(c5, aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2389k(Context context, String str, C2610u uVar, M m5) {
        t.e(str, "packagename");
        t.e(uVar, "listener");
        t.e(m5, "scope");
        this.f21940a = context;
        this.f21941b = str;
        this.f21942c = uVar;
        this.f21943d = m5;
        C2908y0 unused = C2876i.d(m5, (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object f(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
