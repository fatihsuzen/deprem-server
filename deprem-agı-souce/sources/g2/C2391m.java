package g2;

import W2.J;
import W2.u;
import android.content.Context;
import b3.C2308e;
import c3.C2316b;
import java.util.concurrent.atomic.AtomicBoolean;
import k2.N;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.V;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import w3.O;

/* renamed from: g2.m  reason: case insensitive filesystem */
public final class C2391m {

    /* renamed from: c  reason: collision with root package name */
    public static final a f21958c = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static AtomicBoolean f21959d = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f21960a;

    /* renamed from: b  reason: collision with root package name */
    private final M f21961b;

    /* renamed from: g2.m$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: g2.m$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21962a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2391m f21963b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f21964c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ N f21965d;

        /* renamed from: g2.m$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21966a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ N f21967b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ V f21968c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(N n5, V v5, C2308e eVar) {
                super(2, eVar);
                this.f21967b = n5;
                this.f21968c = v5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21967b, this.f21968c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21966a == 0) {
                    u.b(obj);
                    this.f21967b.b(this.f21968c);
                    C2391m.f21959d.set(false);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.m$b$b  reason: collision with other inner class name */
        static final class C0233b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21969a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ N f21970b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0233b(N n5, C2308e eVar) {
                super(2, eVar);
                this.f21970b = n5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0233b(this.f21970b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21969a == 0) {
                    u.b(obj);
                    this.f21970b.a();
                    C2391m.f21959d.set(false);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0233b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2391m mVar, String str, N n5, C2308e eVar) {
            super(2, eVar);
            this.f21963b = mVar;
            this.f21964c = str;
            this.f21965d = n5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21963b, this.f21964c, this.f21965d, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x006b, code lost:
            if (w3.C2872g.g(r1, r2, r6) == r0) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x007f, code lost:
            if (w3.C2872g.g(r7, r1, r6) == r0) goto L_0x0081;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r6.f21962a
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
                goto L_0x0082
            L_0x001b:
                W2.u.b(r7)
                l2.V r7 = new l2.V
                r7.<init>()
                z2.Z r1 = new z2.Z
                g2.m r4 = r6.f21963b
                android.content.Context r4 = r4.f21960a
                r1.<init>(r4)
                java.lang.String r4 = r6.f21964c
                l2.M r1 = r1.x0(r4)
                boolean r4 = r1.b()
                r5 = 0
                if (r4 != 0) goto L_0x006e
                org.json.JSONObject r4 = r1.e()
                if (r4 == 0) goto L_0x006e
                org.json.JSONObject r1 = r1.e()
                kotlin.jvm.internal.t.b(r1)
                java.lang.String r2 = "data"
                boolean r4 = r1.isNull(r2)
                if (r4 != 0) goto L_0x0082
                org.json.JSONObject r1 = r1.getJSONObject(r2)
                kotlin.jvm.internal.t.b(r1)
                r7.n(r1)
                w3.I0 r1 = w3.C2865c0.c()
                g2.m$b$a r2 = new g2.m$b$a
                k2.N r4 = r6.f21965d
                r2.<init>(r4, r7, r5)
                r6.f21962a = r3
                java.lang.Object r7 = w3.C2872g.g(r1, r2, r6)
                if (r7 != r0) goto L_0x0082
                goto L_0x0081
            L_0x006e:
                w3.I0 r7 = w3.C2865c0.c()
                g2.m$b$b r1 = new g2.m$b$b
                k2.N r3 = r6.f21965d
                r1.<init>(r3, r5)
                r6.f21962a = r2
                java.lang.Object r7 = w3.C2872g.g(r7, r1, r6)
                if (r7 != r0) goto L_0x0082
            L_0x0081:
                return r0
            L_0x0082:
                W2.J r7 = W2.J.f19942a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2391m.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2391m(Context context, M m5) {
        t.e(context, "context");
        t.e(m5, "scope");
        this.f21960a = context;
        this.f21961b = m5;
    }

    public final void c(String str, N n5) {
        t.e(str, "userID");
        t.e(n5, "listener");
        if (f21959d.compareAndSet(false, true)) {
            C2908y0 unused = C2876i.d(this.f21961b, C2865c0.b(), (O) null, new b(this, str, n5, (C2308e) null), 2, (Object) null);
        }
    }
}
