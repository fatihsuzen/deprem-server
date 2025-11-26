package g2;

import W2.J;
import W2.u;
import android.content.Context;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import k2.C2585B;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2647G;
import l2.C2657f;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.O;

/* renamed from: g2.p  reason: case insensitive filesystem */
public final class C2394p {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f21998a;

    /* renamed from: b  reason: collision with root package name */
    private final M f21999b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final C2585B f22000c;

    /* renamed from: g2.p$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22001a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2394p f22002b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2647G f22003c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2394p pVar, C2647G g5, C2308e eVar) {
            super(2, eVar);
            this.f22002b = pVar;
            this.f22003c = g5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f22002b, this.f22003c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f22001a;
            if (i5 == 0) {
                u.b(obj);
                C2394p pVar = this.f22002b;
                C2647G g5 = this.f22003c;
                this.f22001a = 1;
                if (pVar.f(g5, this) == f5) {
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

    /* renamed from: g2.p$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22004a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2394p f22005b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2647G f22006c;

        /* renamed from: g2.p$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22007a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2394p f22008b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2394p pVar, C2308e eVar) {
                super(2, eVar);
                this.f22008b = pVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f22008b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22007a == 0) {
                    u.b(obj);
                    this.f22008b.f22000c.b();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.p$b$b  reason: collision with other inner class name */
        static final class C0236b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22009a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2394p f22010b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0236b(C2394p pVar, C2308e eVar) {
                super(2, eVar);
                this.f22010b = pVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0236b(this.f22010b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22009a == 0) {
                    u.b(obj);
                    this.f22010b.f22000c.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0236b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.p$b$c */
        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22011a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2394p f22012b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(C2394p pVar, C2308e eVar) {
                super(2, eVar);
                this.f22012b = pVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new c(this.f22012b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22011a == 0) {
                    u.b(obj);
                    this.f22012b.f22000c.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2394p pVar, C2647G g5, C2308e eVar) {
            super(2, eVar);
            this.f22005b = pVar;
            this.f22006c = g5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f22005b, this.f22006c, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x008b, code lost:
            if (w3.C2872g.g(r8, r1, r7) == r0) goto L_0x00b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x009f, code lost:
            if (w3.C2872g.g(r8, r1, r7) == r0) goto L_0x00b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x00b3, code lost:
            if (w3.C2872g.g(r8, r1, r7) == r0) goto L_0x00b5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r7.f22004a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001f
                if (r1 == r4) goto L_0x001a
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                goto L_0x001a
            L_0x0012:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001a:
                W2.u.b(r8)
                goto L_0x00b6
            L_0x001f:
                W2.u.b(r8)
                z2.Z r8 = new z2.Z
                g2.p r1 = r7.f22005b
                android.content.Context r1 = r1.f21998a
                r8.<init>(r1)
                l2.G r1 = r7.f22006c
                long r5 = r1.b()
                l2.M r8 = r8.f(r5)
                boolean r1 = r8.b()
                r5 = 0
                if (r1 != 0) goto L_0x00a2
                org.json.JSONObject r1 = r8.e()
                if (r1 == 0) goto L_0x00a2
                org.json.JSONObject r8 = r8.e()
                kotlin.jvm.internal.t.b(r8)
                java.lang.String r1 = "success"
                int r8 = r8.optInt(r1)
                if (r8 != r4) goto L_0x008e
                android.os.Bundle r8 = new android.os.Bundle
                r8.<init>()
                java.lang.String r1 = "type"
                java.lang.String r2 = "removed"
                r8.putString(r1, r2)
                z2.F r1 = new z2.F
                g2.p r2 = r7.f22005b
                android.content.Context r2 = r2.f21998a
                r1.<init>(r2)
                java.lang.String r2 = "preregister"
                r1.d(r2, r8)
                l2.G r8 = r7.f22006c
                g2.p r1 = r7.f22005b
                android.content.Context r1 = r1.f21998a
                r8.j(r1)
                w3.I0 r8 = w3.C2865c0.c()
                g2.p$b$a r1 = new g2.p$b$a
                g2.p r2 = r7.f22005b
                r1.<init>(r2, r5)
                r7.f22004a = r4
                java.lang.Object r8 = w3.C2872g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x00b6
                goto L_0x00b5
            L_0x008e:
                w3.I0 r8 = w3.C2865c0.c()
                g2.p$b$b r1 = new g2.p$b$b
                g2.p r2 = r7.f22005b
                r1.<init>(r2, r5)
                r7.f22004a = r3
                java.lang.Object r8 = w3.C2872g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x00b6
                goto L_0x00b5
            L_0x00a2:
                w3.I0 r8 = w3.C2865c0.c()
                g2.p$b$c r1 = new g2.p$b$c
                g2.p r3 = r7.f22005b
                r1.<init>(r3, r5)
                r7.f22004a = r2
                java.lang.Object r8 = w3.C2872g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x00b6
            L_0x00b5:
                return r0
            L_0x00b6:
                W2.J r8 = W2.J.f19942a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2394p.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.p$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22013a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2394p f22014b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2657f f22015c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2394p pVar, C2657f fVar, C2308e eVar) {
            super(2, eVar);
            this.f22014b = pVar;
            this.f22015c = fVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f22014b, this.f22015c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f22013a;
            if (i5 == 0) {
                u.b(obj);
                C2394p pVar = this.f22014b;
                C2657f fVar = this.f22015c;
                this.f22013a = 1;
                if (pVar.h(fVar, this) == f5) {
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
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.p$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22016a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2657f f22017b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2394p f22018c;

        /* renamed from: g2.p$d$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22019a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2394p f22020b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2394p pVar, C2308e eVar) {
                super(2, eVar);
                this.f22020b = pVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f22020b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22019a == 0) {
                    u.b(obj);
                    this.f22020b.f22000c.c();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.p$d$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22021a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2394p f22022b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2394p pVar, C2308e eVar) {
                super(2, eVar);
                this.f22022b = pVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f22022b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22021a == 0) {
                    u.b(obj);
                    this.f22022b.f22000c.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.p$d$c */
        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22023a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2394p f22024b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(C2394p pVar, C2308e eVar) {
                super(2, eVar);
                this.f22024b = pVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new c(this.f22024b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22023a == 0) {
                    u.b(obj);
                    this.f22024b.f22000c.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C2657f fVar, C2394p pVar, C2308e eVar) {
            super(2, eVar);
            this.f22017b = fVar;
            this.f22018c = pVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f22017b, this.f22018c, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b8, code lost:
            if (w3.C2872g.g(r12, r1, r11) == r0) goto L_0x00e2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00cc, code lost:
            if (w3.C2872g.g(r12, r1, r11) == r0) goto L_0x00e2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e0, code lost:
            if (w3.C2872g.g(r12, r1, r11) == r0) goto L_0x00e2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r11.f22016a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001f
                if (r1 == r4) goto L_0x001a
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                goto L_0x001a
            L_0x0012:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x001a:
                W2.u.b(r12)
                goto L_0x00e3
            L_0x001f:
                W2.u.b(r12)
                l2.f r12 = r11.f22017b
                java.lang.String r12 = r12.N()
                if (r12 == 0) goto L_0x0035
                l2.f r12 = r11.f22017b
                java.lang.String r12 = r12.N()
                kotlin.jvm.internal.t.b(r12)
            L_0x0033:
                r8 = r12
                goto L_0x003f
            L_0x0035:
                l2.f r12 = r11.f22017b
                java.lang.String r12 = r12.S()
                kotlin.jvm.internal.t.b(r12)
                goto L_0x0033
            L_0x003f:
                l2.G r5 = new l2.G
                l2.f r12 = r11.f22017b
                long r6 = r12.e()
                l2.f r12 = r11.f22017b
                java.lang.String r9 = r12.G()
                r10 = 1
                r5.<init>(r6, r8, r9, r10)
                z2.Z r12 = new z2.Z
                g2.p r1 = r11.f22018c
                android.content.Context r1 = r1.f21998a
                r12.<init>(r1)
                l2.f r1 = r11.f22017b
                long r6 = r1.e()
                l2.M r12 = r12.b(r6)
                boolean r1 = r12.b()
                r6 = 0
                if (r1 != 0) goto L_0x00cf
                org.json.JSONObject r1 = r12.e()
                if (r1 == 0) goto L_0x00cf
                org.json.JSONObject r12 = r12.e()
                kotlin.jvm.internal.t.b(r12)
                java.lang.String r1 = "success"
                int r12 = r12.optInt(r1)
                if (r12 != r4) goto L_0x00bb
                android.os.Bundle r12 = new android.os.Bundle
                r12.<init>()
                java.lang.String r1 = "type"
                java.lang.String r2 = "added"
                r12.putString(r1, r2)
                z2.F r1 = new z2.F
                g2.p r2 = r11.f22018c
                android.content.Context r2 = r2.f21998a
                r1.<init>(r2)
                java.lang.String r2 = "preregister"
                r1.d(r2, r12)
                g2.p r12 = r11.f22018c
                android.content.Context r12 = r12.f21998a
                r5.i(r12)
                w3.I0 r12 = w3.C2865c0.c()
                g2.p$d$a r1 = new g2.p$d$a
                g2.p r2 = r11.f22018c
                r1.<init>(r2, r6)
                r11.f22016a = r4
                java.lang.Object r12 = w3.C2872g.g(r12, r1, r11)
                if (r12 != r0) goto L_0x00e3
                goto L_0x00e2
            L_0x00bb:
                w3.I0 r12 = w3.C2865c0.c()
                g2.p$d$b r1 = new g2.p$d$b
                g2.p r2 = r11.f22018c
                r1.<init>(r2, r6)
                r11.f22016a = r3
                java.lang.Object r12 = w3.C2872g.g(r12, r1, r11)
                if (r12 != r0) goto L_0x00e3
                goto L_0x00e2
            L_0x00cf:
                w3.I0 r12 = w3.C2865c0.c()
                g2.p$d$c r1 = new g2.p$d$c
                g2.p r3 = r11.f22018c
                r1.<init>(r3, r6)
                r11.f22016a = r2
                java.lang.Object r12 = w3.C2872g.g(r12, r1, r11)
                if (r12 != r0) goto L_0x00e3
            L_0x00e2:
                return r0
            L_0x00e3:
                W2.J r12 = W2.J.f19942a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2394p.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2394p(Context context, M m5, C2585B b5) {
        t.e(context, "context");
        t.e(m5, "scope");
        t.e(b5, "listener");
        this.f21998a = context;
        this.f21999b = m5;
        this.f22000c = b5;
    }

    /* access modifiers changed from: private */
    public final Object f(C2647G g5, C2308e eVar) {
        Object g6 = C2872g.g(C2865c0.b(), new b(this, g5, (C2308e) null), eVar);
        if (g6 == C2316b.f()) {
            return g6;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object h(C2657f fVar, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new d(fVar, this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public final void e(C2647G g5) {
        t.e(g5, "preRegister");
        C2908y0 unused = C2876i.d(this.f21999b, (C2312i) null, (O) null, new a(this, g5, (C2308e) null), 3, (Object) null);
    }

    public final void g(C2657f fVar) {
        t.e(fVar, "appInfo");
        C2908y0 unused = C2876i.d(this.f21999b, (C2312i) null, (O) null, new c(this, fVar, (C2308e) null), 3, (Object) null);
    }
}
