package g2;

import W2.J;
import W2.u;
import android.content.Context;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.util.concurrent.atomic.AtomicBoolean;
import k2.C2610u;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2657f;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.O;

/* renamed from: g2.j  reason: case insensitive filesystem */
public final class C2388j {

    /* renamed from: d  reason: collision with root package name */
    public static final b f21925d = new b((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static AtomicBoolean f21926e = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f21927a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final long f21928b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final C2610u f21929c;

    /* renamed from: g2.j$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21930a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2388j f21931b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2388j jVar, C2308e eVar) {
            super(2, eVar);
            this.f21931b = jVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f21931b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21930a;
            if (i5 == 0) {
                u.b(obj);
                C2388j jVar = this.f21931b;
                this.f21930a = 1;
                if (jVar.f(this) == f5) {
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

    /* renamed from: g2.j$b */
    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        private b() {
        }
    }

    /* renamed from: g2.j$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21932a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2388j f21933b;

        /* renamed from: g2.j$c$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21934a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2388j f21935b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C2657f f21936c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2388j jVar, C2657f fVar, C2308e eVar) {
                super(2, eVar);
                this.f21935b = jVar;
                this.f21936c = fVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21935b, this.f21936c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21934a == 0) {
                    u.b(obj);
                    C2610u c5 = this.f21935b.f21929c;
                    if (c5 != null) {
                        c5.c(this.f21936c);
                    }
                    C2388j.f21926e.set(false);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.j$c$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21937a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2388j f21938b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ l2.M f21939c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2388j jVar, l2.M m5, C2308e eVar) {
                super(2, eVar);
                this.f21938b = jVar;
                this.f21939c = m5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f21938b, this.f21939c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21937a == 0) {
                    u.b(obj);
                    C2610u c5 = this.f21938b.f21929c;
                    if (c5 != null) {
                        c5.d(this.f21939c.f());
                    }
                    C2388j.f21926e.set(false);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2388j jVar, C2308e eVar) {
            super(2, eVar);
            this.f21933b = jVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f21933b, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0081, code lost:
            if (w3.C2872g.g(r1, r2, r6) == r0) goto L_0x009d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x009b, code lost:
            if (w3.C2872g.g(r1, r3, r6) == r0) goto L_0x009d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r6.f21932a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x0017:
                W2.u.b(r7)
                goto L_0x009e
            L_0x001c:
                W2.u.b(r7)
                z2.Z r7 = new z2.Z
                g2.j r1 = r6.f21933b
                android.content.Context r1 = r1.f21927a
                r7.<init>(r1)
                g2.j r1 = r6.f21933b
                long r4 = r1.f21928b
                l2.M r7 = r7.X(r4)
                boolean r1 = r7.b()
                r4 = 0
                if (r1 != 0) goto L_0x0084
                java.lang.String r1 = r7.d()
                if (r1 == 0) goto L_0x0084
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0048
                goto L_0x0084
            L_0x0048:
                org.json.JSONObject r1 = new org.json.JSONObject
                java.lang.String r7 = r7.d()
                kotlin.jvm.internal.t.b(r7)
                r1.<init>(r7)
                java.lang.String r7 = "data"
                org.json.JSONObject r7 = r1.optJSONObject(r7)
                java.lang.String r2 = "success"
                int r1 = r1.optInt(r2)
                if (r1 != r3) goto L_0x009e
                if (r7 == 0) goto L_0x009e
                l2.f$b r1 = l2.C2657f.f25002J0
                g2.j r2 = r6.f21933b
                android.content.Context r2 = r2.f21927a
                l2.f r7 = r1.a(r7, r2)
                w3.I0 r1 = w3.C2865c0.c()
                g2.j$c$a r2 = new g2.j$c$a
                g2.j r5 = r6.f21933b
                r2.<init>(r5, r7, r4)
                r6.f21932a = r3
                java.lang.Object r7 = w3.C2872g.g(r1, r2, r6)
                if (r7 != r0) goto L_0x009e
                goto L_0x009d
            L_0x0084:
                boolean r1 = r7.b()
                if (r1 == 0) goto L_0x009e
                w3.I0 r1 = w3.C2865c0.c()
                g2.j$c$b r3 = new g2.j$c$b
                g2.j r5 = r6.f21933b
                r3.<init>(r5, r7, r4)
                r6.f21932a = r2
                java.lang.Object r7 = w3.C2872g.g(r1, r3, r6)
                if (r7 != r0) goto L_0x009e
            L_0x009d:
                return r0
            L_0x009e:
                W2.J r7 = W2.J.f19942a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2388j.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2388j(Context context, long j5, C2610u uVar, M m5) {
        t.e(context, "context");
        t.e(m5, "scope");
        this.f21927a = context;
        this.f21928b = j5;
        this.f21929c = uVar;
        if (j5 > 0 && f21926e.compareAndSet(false, true)) {
            C2908y0 unused = C2876i.d(m5, (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final Object f(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new c(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
