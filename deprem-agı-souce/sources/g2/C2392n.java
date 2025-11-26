package g2;

import W2.J;
import W2.u;
import android.content.Context;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import k2.Z;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.L;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.O;

/* renamed from: g2.n  reason: case insensitive filesystem */
public final class C2392n {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f21971a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f21972b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f21973c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Z f21974d;

    /* renamed from: g2.n$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21975a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2392n f21976b;

        /* renamed from: g2.n$a$a  reason: collision with other inner class name */
        static final class C0234a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21977a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2392n f21978b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0234a(C2392n nVar, C2308e eVar) {
                super(2, eVar);
                this.f21978b = nVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0234a(this.f21978b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21977a == 0) {
                    u.b(obj);
                    this.f21978b.f21974d.b();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0234a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2392n nVar, C2308e eVar) {
            super(2, eVar);
            this.f21976b = nVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f21976b, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
            if (g2.C2392n.f(r6, r5) == r0) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0071, code lost:
            if (g2.C2392n.g(r6, r5) == r0) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0086, code lost:
            if (w3.C2872g.g(r6, r1, r5) == r0) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
            return r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r5.f21975a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001e
                if (r1 == r4) goto L_0x001a
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                goto L_0x001a
            L_0x0012:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x001a:
                W2.u.b(r6)
                goto L_0x0089
            L_0x001e:
                W2.u.b(r6)
                g2.n r6 = r5.f21976b
                java.lang.String r6 = r6.f21972b
                if (r6 == 0) goto L_0x0052
                g2.n r6 = r5.f21976b
                java.lang.String r6 = r6.f21972b
                kotlin.jvm.internal.t.b(r6)
                int r6 = r6.length()
                if (r6 <= 0) goto L_0x0052
                g2.n r6 = r5.f21976b
                java.lang.String r6 = r6.f21972b
                kotlin.jvm.internal.t.b(r6)
                int r6 = java.lang.Integer.parseInt(r6)
                if (r6 <= 0) goto L_0x0052
                g2.n r6 = r5.f21976b
                r5.f21975a = r4
                java.lang.Object r6 = r6.i(r5)
                if (r6 != r0) goto L_0x0089
                goto L_0x0088
            L_0x0052:
                g2.n r6 = r5.f21976b
                java.lang.String r6 = r6.f21973c
                if (r6 == 0) goto L_0x0074
                g2.n r6 = r5.f21976b
                java.lang.String r6 = r6.f21973c
                kotlin.jvm.internal.t.b(r6)
                int r6 = r6.length()
                if (r6 <= 0) goto L_0x0074
                g2.n r6 = r5.f21976b
                r5.f21975a = r3
                java.lang.Object r6 = r6.j(r5)
                if (r6 != r0) goto L_0x0089
                goto L_0x0088
            L_0x0074:
                w3.I0 r6 = w3.C2865c0.c()
                g2.n$a$a r1 = new g2.n$a$a
                g2.n r3 = r5.f21976b
                r4 = 0
                r1.<init>(r3, r4)
                r5.f21975a = r2
                java.lang.Object r6 = w3.C2872g.g(r6, r1, r5)
                if (r6 != r0) goto L_0x0089
            L_0x0088:
                return r0
            L_0x0089:
                W2.J r6 = W2.J.f19942a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2392n.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.n$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21979a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2392n f21980b;

        /* renamed from: g2.n$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21981a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2392n f21982b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f21983c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2392n nVar, L l5, C2308e eVar) {
                super(2, eVar);
                this.f21982b = nVar;
                this.f21983c = l5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21982b, this.f21983c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21981a == 0) {
                    u.b(obj);
                    this.f21982b.f21974d.a(this.f21983c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.n$b$b  reason: collision with other inner class name */
        static final class C0235b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21984a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2392n f21985b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0235b(C2392n nVar, C2308e eVar) {
                super(2, eVar);
                this.f21985b = nVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0235b(this.f21985b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21984a == 0) {
                    u.b(obj);
                    this.f21985b.f21974d.b();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0235b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2392n nVar, C2308e eVar) {
            super(2, eVar);
            this.f21980b = nVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21980b, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0063, code lost:
            if (w3.C2872g.g(r1, r2, r6) == r0) goto L_0x0079;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0077, code lost:
            if (w3.C2872g.g(r7, r1, r6) == r0) goto L_0x0079;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r6.f21979a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001b
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
                goto L_0x007a
            L_0x001b:
                W2.u.b(r7)
                z2.Z r7 = new z2.Z
                g2.n r1 = r6.f21980b
                android.content.Context r1 = r1.f21971a
                r7.<init>(r1)
                g2.n r1 = r6.f21980b
                java.lang.String r1 = r1.f21972b
                kotlin.jvm.internal.t.b(r1)
                l2.M r7 = r7.D0(r1)
                boolean r1 = r7.b()
                r4 = 0
                if (r1 != 0) goto L_0x0066
                org.json.JSONObject r1 = r7.e()
                if (r1 == 0) goto L_0x0066
                g2.n r1 = r6.f21980b
                org.json.JSONObject r7 = r7.e()
                kotlin.jvm.internal.t.b(r7)
                l2.L r7 = r1.h(r7)
                if (r7 == 0) goto L_0x007a
                w3.I0 r1 = w3.C2865c0.c()
                g2.n$b$a r2 = new g2.n$b$a
                g2.n r5 = r6.f21980b
                r2.<init>(r5, r7, r4)
                r6.f21979a = r3
                java.lang.Object r7 = w3.C2872g.g(r1, r2, r6)
                if (r7 != r0) goto L_0x007a
                goto L_0x0079
            L_0x0066:
                w3.I0 r7 = w3.C2865c0.c()
                g2.n$b$b r1 = new g2.n$b$b
                g2.n r3 = r6.f21980b
                r1.<init>(r3, r4)
                r6.f21979a = r2
                java.lang.Object r7 = w3.C2872g.g(r7, r1, r6)
                if (r7 != r0) goto L_0x007a
            L_0x0079:
                return r0
            L_0x007a:
                W2.J r7 = W2.J.f19942a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2392n.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.n$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21986a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2392n f21987b;

        /* renamed from: g2.n$c$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21988a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2392n f21989b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f21990c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2392n nVar, L l5, C2308e eVar) {
                super(2, eVar);
                this.f21989b = nVar;
                this.f21990c = l5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21989b, this.f21990c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21988a == 0) {
                    u.b(obj);
                    this.f21989b.f21974d.a(this.f21990c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.n$c$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21991a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2392n f21992b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2392n nVar, C2308e eVar) {
                super(2, eVar);
                this.f21992b = nVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f21992b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21991a == 0) {
                    u.b(obj);
                    this.f21992b.f21974d.b();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2392n nVar, C2308e eVar) {
            super(2, eVar);
            this.f21987b = nVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f21987b, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0063, code lost:
            if (w3.C2872g.g(r1, r2, r6) == r0) goto L_0x0079;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0077, code lost:
            if (w3.C2872g.g(r7, r1, r6) == r0) goto L_0x0079;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r6.f21986a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001b
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
                goto L_0x007a
            L_0x001b:
                W2.u.b(r7)
                z2.Z r7 = new z2.Z
                g2.n r1 = r6.f21987b
                android.content.Context r1 = r1.f21971a
                r7.<init>(r1)
                g2.n r1 = r6.f21987b
                java.lang.String r1 = r1.f21973c
                kotlin.jvm.internal.t.b(r1)
                l2.M r7 = r7.E0(r1)
                boolean r1 = r7.b()
                r4 = 0
                if (r1 != 0) goto L_0x0066
                org.json.JSONObject r1 = r7.e()
                if (r1 == 0) goto L_0x0066
                g2.n r1 = r6.f21987b
                org.json.JSONObject r7 = r7.e()
                kotlin.jvm.internal.t.b(r7)
                l2.L r7 = r1.h(r7)
                if (r7 == 0) goto L_0x007a
                w3.I0 r1 = w3.C2865c0.c()
                g2.n$c$a r2 = new g2.n$c$a
                g2.n r5 = r6.f21987b
                r2.<init>(r5, r7, r4)
                r6.f21986a = r3
                java.lang.Object r7 = w3.C2872g.g(r1, r2, r6)
                if (r7 != r0) goto L_0x007a
                goto L_0x0079
            L_0x0066:
                w3.I0 r7 = w3.C2865c0.c()
                g2.n$c$b r1 = new g2.n$c$b
                g2.n r3 = r6.f21987b
                r1.<init>(r3, r4)
                r6.f21986a = r2
                java.lang.Object r7 = w3.C2872g.g(r7, r1, r6)
                if (r7 != r0) goto L_0x007a
            L_0x0079:
                return r0
            L_0x007a:
                W2.J r7 = W2.J.f19942a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2392n.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2392n(Context context, String str, String str2, Z z4, M m5) {
        t.e(context, "context");
        t.e(z4, "listener");
        t.e(m5, "scope");
        this.f21971a = context;
        this.f21972b = str;
        this.f21973c = str2;
        this.f21974d = z4;
        C2908y0 unused = C2876i.d(m5, (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final L h(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
        if (jSONObject.optInt("success") != 1 || optJSONObject == null) {
            return null;
        }
        L l5 = new L();
        l5.a(optJSONObject);
        return l5;
    }

    /* access modifiers changed from: private */
    public final Object i(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object j(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new c(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
