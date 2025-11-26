package g2;

import W2.J;
import W2.u;
import android.content.Context;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import k2.C2606p;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.K;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.O;

/* renamed from: g2.d  reason: case insensitive filesystem */
public final class C2382d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f21689a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f21690b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C2606p f21691c;

    /* renamed from: d  reason: collision with root package name */
    private final M f21692d;

    /* renamed from: g2.d$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21693a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2382d f21694b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2382d dVar, C2308e eVar) {
            super(2, eVar);
            this.f21694b = dVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f21694b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21693a;
            if (i5 == 0) {
                u.b(obj);
                C2382d dVar = this.f21694b;
                this.f21693a = 1;
                if (dVar.e(this) == f5) {
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

    /* renamed from: g2.d$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21695a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2382d f21696b;

        /* renamed from: g2.d$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21697a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2382d f21698b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ K f21699c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ K f21700d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ L f21701e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ K f21702f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ I f21703g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2382d dVar, K k5, K k6, L l5, K k7, I i5, C2308e eVar) {
                super(2, eVar);
                this.f21698b = dVar;
                this.f21699c = k5;
                this.f21700d = k6;
                this.f21701e = l5;
                this.f21702f = k7;
                this.f21703g = i5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21698b, this.f21699c, this.f21700d, this.f21701e, this.f21702f, this.f21703g, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21697a == 0) {
                    u.b(obj);
                    this.f21698b.f21691c.a(this.f21699c.f24689a, this.f21700d.f24689a, (String) this.f21701e.f24690a, this.f21702f.f24689a, this.f21703g.f24687a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.d$b$b  reason: collision with other inner class name */
        static final class C0226b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21704a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2382d f21705b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0226b(C2382d dVar, C2308e eVar) {
                super(2, eVar);
                this.f21705b = dVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0226b(this.f21705b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21704a == 0) {
                    u.b(obj);
                    this.f21705b.f21691c.b();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0226b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2382d dVar, C2308e eVar) {
            super(2, eVar);
            this.f21696b = dVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21696b, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d5, code lost:
            if (w3.C2872g.g(r13, r4, r12) == r0) goto L_0x00ec;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ea, code lost:
            if (w3.C2872g.g(r13, r1, r12) == r0) goto L_0x00ec;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r12.f21695a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x0017:
                W2.u.b(r13)
                goto L_0x00ed
            L_0x001c:
                W2.u.b(r13)
                z2.Z r13 = new z2.Z
                g2.d r1 = r12.f21696b
                android.content.Context r1 = r1.f21689a
                r13.<init>(r1)
                g2.d r1 = r12.f21696b
                java.lang.String r1 = r1.f21690b
                l2.M r13 = r13.o(r1)
                boolean r1 = r13.b()
                if (r1 != 0) goto L_0x00d8
                java.lang.String r1 = r13.d()
                if (r1 == 0) goto L_0x00d8
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0048
                goto L_0x00d8
            L_0x0048:
                org.json.JSONObject r1 = new org.json.JSONObject
                java.lang.String r13 = r13.d()
                kotlin.jvm.internal.t.b(r13)
                r1.<init>(r13)
                java.lang.String r13 = "data"
                org.json.JSONObject r13 = r1.optJSONObject(r13)
                if (r13 == 0) goto L_0x00ed
                kotlin.jvm.internal.K r6 = new kotlin.jvm.internal.K
                r6.<init>()
                r4 = -1
                r6.f24689a = r4
                kotlin.jvm.internal.K r7 = new kotlin.jvm.internal.K
                r7.<init>()
                r7.f24689a = r4
                kotlin.jvm.internal.L r8 = new kotlin.jvm.internal.L
                r8.<init>()
                kotlin.jvm.internal.K r9 = new kotlin.jvm.internal.K
                r9.<init>()
                r9.f24689a = r4
                kotlin.jvm.internal.I r10 = new kotlin.jvm.internal.I
                r10.<init>()
                java.lang.String r2 = "appID"
                boolean r4 = r13.isNull(r2)
                if (r4 != 0) goto L_0x008b
                long r4 = r13.optLong(r2)
                r6.f24689a = r4
            L_0x008b:
                java.lang.String r2 = "fileID"
                boolean r4 = r13.isNull(r2)
                if (r4 != 0) goto L_0x0099
                long r4 = r13.optLong(r2)
                r7.f24689a = r4
            L_0x0099:
                java.lang.String r2 = "sha256"
                boolean r4 = r13.isNull(r2)
                if (r4 != 0) goto L_0x00a7
                java.lang.String r2 = r13.optString(r2)
                r8.f24690a = r2
            L_0x00a7:
                java.lang.String r2 = "versionCode"
                boolean r4 = r13.isNull(r2)
                if (r4 != 0) goto L_0x00b5
                long r4 = r13.optLong(r2)
                r9.f24689a = r4
            L_0x00b5:
                java.lang.String r2 = "deepLink"
                boolean r13 = r13.isNull(r2)
                if (r13 != 0) goto L_0x00c3
                boolean r13 = r1.optBoolean(r2)
                r10.f24687a = r13
            L_0x00c3:
                w3.I0 r13 = w3.C2865c0.c()
                g2.d$b$a r4 = new g2.d$b$a
                g2.d r5 = r12.f21696b
                r11 = 0
                r4.<init>(r5, r6, r7, r8, r9, r10, r11)
                r12.f21695a = r3
                java.lang.Object r13 = w3.C2872g.g(r13, r4, r12)
                if (r13 != r0) goto L_0x00ed
                goto L_0x00ec
            L_0x00d8:
                w3.I0 r13 = w3.C2865c0.c()
                g2.d$b$b r1 = new g2.d$b$b
                g2.d r3 = r12.f21696b
                r4 = 0
                r1.<init>(r3, r4)
                r12.f21695a = r2
                java.lang.Object r13 = w3.C2872g.g(r13, r1, r12)
                if (r13 != r0) goto L_0x00ed
            L_0x00ec:
                return r0
            L_0x00ed:
                W2.J r13 = W2.J.f19942a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2382d.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2382d(Context context, String str, C2606p pVar, M m5) {
        t.e(context, "context");
        t.e(str, "downloadURL");
        t.e(pVar, "listener");
        t.e(m5, "scope");
        this.f21689a = context;
        this.f21690b = str;
        this.f21691c = pVar;
        this.f21692d = m5;
        C2908y0 unused = C2876i.d(m5, (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object e(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
