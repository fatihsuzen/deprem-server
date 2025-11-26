package W1;

import W2.J;
import W2.u;
import X1.m;
import android.content.Context;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;

/* renamed from: W1.c  reason: case insensitive filesystem */
public final class C2210c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f19896a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f19897b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final m f19898c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final boolean f19899d;

    /* renamed from: W1.c$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19900a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2210c f19901b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2210c cVar, C2308e eVar) {
            super(2, eVar);
            this.f19901b = cVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f19901b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f19900a;
            if (i5 == 0) {
                u.b(obj);
                C2210c cVar = this.f19901b;
                this.f19900a = 1;
                if (cVar.f(this) == f5) {
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

    /* renamed from: W1.c$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19902a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2210c f19903b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ I f19904c;

        /* renamed from: W1.c$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19905a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2210c f19906b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2210c cVar, C2308e eVar) {
                super(2, eVar);
                this.f19906b = cVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f19906b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f19905a == 0) {
                    u.b(obj);
                    this.f19906b.f19898c.f();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: W1.c$b$b  reason: collision with other inner class name */
        static final class C0189b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19907a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2210c f19908b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0189b(C2210c cVar, C2308e eVar) {
                super(2, eVar);
                this.f19908b = cVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0189b(this.f19908b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f19907a == 0) {
                    u.b(obj);
                    this.f19908b.f19898c.i();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0189b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2210c cVar, I i5, C2308e eVar) {
            super(2, eVar);
            this.f19903b = cVar;
            this.f19904c = i5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f19903b, this.f19904c, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a7, code lost:
            if (r15.g(r1, r5, r2, r14) == r0) goto L_0x00da;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c4, code lost:
            if (w3.C2872g.g(r15, r2, r14) == r0) goto L_0x00da;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d8, code lost:
            if (w3.C2872g.g(r15, r3, r14) == r0) goto L_0x00da;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r14.f19902a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001f
                if (r1 == r4) goto L_0x001a
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                goto L_0x001a
            L_0x0012:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x001a:
                W2.u.b(r15)
                goto L_0x00db
            L_0x001f:
                W2.u.b(r15)
                S1.k$a r15 = S1.k.f32g
                W1.c r1 = r14.f19903b
                java.lang.String r1 = r1.f19897b
                r15.c(r1)
                b2.j r15 = new b2.j
                r15.<init>()
                W1.c r1 = r14.f19903b
                android.content.Context r1 = r1.f19896a
                java.io.File r15 = r15.g(r1)
                java.io.File r1 = new java.io.File
                W1.c r5 = r14.f19903b
                java.lang.String r5 = r5.f19897b
                r1.<init>(r5)
                java.io.File r5 = new java.io.File
                java.lang.String r6 = r1.getName()
                java.lang.String r7 = "getName(...)"
                kotlin.jvm.internal.t.d(r6, r7)
                java.lang.String r8 = r1.getName()
                kotlin.jvm.internal.t.d(r8, r7)
                r12 = 6
                r13 = 0
                java.lang.String r9 = "."
                r10 = 0
                r11 = 0
                int r7 = t3.s.l0(r8, r9, r10, r11, r12, r13)
                r8 = 0
                java.lang.String r6 = r6.substring(r8, r7)
                java.lang.String r7 = "substring(...)"
                kotlin.jvm.internal.t.d(r6, r7)
                r5.<init>(r15, r6)
                boolean r15 = r5.exists()
                if (r15 != 0) goto L_0x0079
                r5.mkdirs()
            L_0x0079:
                b2.K r15 = new b2.K
                r15.<init>()
                boolean r6 = r15.c(r1)
                if (r6 == 0) goto L_0x0095
                b2.j r6 = new b2.j
                r6.<init>()
                java.io.File r6 = r6.e()
                kotlin.jvm.internal.I r7 = r14.f19904c
                boolean r6 = r6.canWrite()
                r7.f24687a = r6
            L_0x0095:
                kotlin.jvm.internal.I r6 = r14.f19904c
                boolean r6 = r6.f24687a
                if (r6 == 0) goto L_0x00aa
                W1.c r2 = r14.f19903b
                X1.m r2 = r2.f19898c
                r14.f19902a = r4
                java.lang.Object r15 = r15.g(r1, r5, r2, r14)
                if (r15 != r0) goto L_0x00db
                goto L_0x00da
            L_0x00aa:
                W1.c r15 = r14.f19903b
                boolean r15 = r15.f19899d
                r1 = 0
                if (r15 == 0) goto L_0x00c7
                w3.I0 r15 = w3.C2865c0.c()
                W1.c$b$a r2 = new W1.c$b$a
                W1.c r4 = r14.f19903b
                r2.<init>(r4, r1)
                r14.f19902a = r3
                java.lang.Object r15 = w3.C2872g.g(r15, r2, r14)
                if (r15 != r0) goto L_0x00db
                goto L_0x00da
            L_0x00c7:
                w3.I0 r15 = w3.C2865c0.c()
                W1.c$b$b r3 = new W1.c$b$b
                W1.c r4 = r14.f19903b
                r3.<init>(r4, r1)
                r14.f19902a = r2
                java.lang.Object r15 = w3.C2872g.g(r15, r3, r14)
                if (r15 != r0) goto L_0x00db
            L_0x00da:
                return r0
            L_0x00db:
                W2.J r15 = W2.J.f19942a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.C2210c.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2210c(Context context, String str, m mVar, boolean z4) {
        t.e(context, "context");
        t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        t.e(mVar, "xapkProcesationListener");
        this.f19896a = context;
        this.f19897b = str;
        this.f19898c = mVar;
        this.f19899d = z4;
        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object f(C2308e eVar) {
        I i5 = new I();
        i5.f24687a = true;
        Object g5 = C2872g.g(C2865c0.b(), new b(this, i5, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
