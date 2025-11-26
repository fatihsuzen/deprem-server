package g2;

import W2.J;
import W2.u;
import android.content.Context;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.util.ArrayList;
import k2.C2584A;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2657f;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.O;

/* renamed from: g2.i  reason: case insensitive filesystem */
public final class C2387i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f21912a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2657f f21913b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final C2584A f21914c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f21915d;

    /* renamed from: g2.i$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21916a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2387i f21917b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2387i iVar, C2308e eVar) {
            super(2, eVar);
            this.f21917b = iVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f21917b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21916a;
            if (i5 == 0) {
                u.b(obj);
                C2387i iVar = this.f21917b;
                this.f21916a = 1;
                if (iVar.f(this) == f5) {
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

    /* renamed from: g2.i$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21918a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2387i f21919b;

        /* renamed from: g2.i$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21920a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2387i f21921b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f21922c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2387i iVar, ArrayList arrayList, C2308e eVar) {
                super(2, eVar);
                this.f21921b = iVar;
                this.f21922c = arrayList;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21921b, this.f21922c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21920a == 0) {
                    u.b(obj);
                    this.f21921b.f21914c.a(this.f21922c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.i$b$b  reason: collision with other inner class name */
        static final class C0232b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21923a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2387i f21924b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0232b(C2387i iVar, C2308e eVar) {
                super(2, eVar);
                this.f21924b = iVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0232b(this.f21924b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21923a == 0) {
                    u.b(obj);
                    this.f21924b.f21914c.b();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0232b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2387i iVar, C2308e eVar) {
            super(2, eVar);
            this.f21919b = iVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21919b, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0072, code lost:
            if (w3.C2872g.g(r2, r4, r7) == r0) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0086, code lost:
            if (w3.C2872g.g(r8, r3, r7) == r0) goto L_0x0088;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r7.f21918a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001b
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x0017:
                W2.u.b(r8)
                goto L_0x0089
            L_0x001b:
                W2.u.b(r8)
                z2.Z r8 = new z2.Z
                g2.i r1 = r7.f21919b
                android.content.Context r1 = r1.f21912a
                r8.<init>(r1)
                g2.i r1 = r7.f21919b
                l2.f r1 = r1.f21913b
                long r4 = r1.e()
                g2.i r1 = r7.f21919b
                int r1 = r1.f21915d
                r6 = 20
                l2.M r8 = r8.R0(r4, r6, r1)
                boolean r1 = r8.b()
                if (r1 != 0) goto L_0x0089
                org.json.JSONObject r1 = r8.e()
                if (r1 == 0) goto L_0x0089
                l2.C$b r1 = l2.C2643C.f24734j
                org.json.JSONObject r8 = r8.e()
                kotlin.jvm.internal.t.b(r8)
                java.util.ArrayList r8 = r1.a(r8)
                r1 = 0
                if (r8 == 0) goto L_0x0075
                int r4 = r8.size()
                if (r4 <= 0) goto L_0x0075
                w3.I0 r2 = w3.C2865c0.c()
                g2.i$b$a r4 = new g2.i$b$a
                g2.i r5 = r7.f21919b
                r4.<init>(r5, r8, r1)
                r7.f21918a = r3
                java.lang.Object r8 = w3.C2872g.g(r2, r4, r7)
                if (r8 != r0) goto L_0x0089
                goto L_0x0088
            L_0x0075:
                w3.I0 r8 = w3.C2865c0.c()
                g2.i$b$b r3 = new g2.i$b$b
                g2.i r4 = r7.f21919b
                r3.<init>(r4, r1)
                r7.f21918a = r2
                java.lang.Object r8 = w3.C2872g.g(r8, r3, r7)
                if (r8 != r0) goto L_0x0089
            L_0x0088:
                return r0
            L_0x0089:
                W2.J r8 = W2.J.f19942a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2387i.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2387i(M m5, Context context, C2657f fVar, C2584A a5, int i5) {
        t.e(m5, "scope");
        t.e(context, "context");
        t.e(fVar, "appInfo");
        t.e(a5, "listener");
        this.f21912a = context;
        this.f21913b = fVar;
        this.f21914c = a5;
        this.f21915d = i5;
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
