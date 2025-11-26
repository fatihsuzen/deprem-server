package z3;

import b3.C2308e;
import b3.C2312i;
import k3.q;
import k3.r;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import w3.C2908y0;

abstract /* synthetic */ class p {

    public static final class a implements C2972e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2972e f26652a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q f26653b;

        /* renamed from: z3.p$a$a  reason: collision with other inner class name */
        public static final class C0269a extends kotlin.coroutines.jvm.internal.d {

            /* renamed from: a  reason: collision with root package name */
            /* synthetic */ Object f26654a;

            /* renamed from: b  reason: collision with root package name */
            int f26655b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ a f26656c;

            /* renamed from: d  reason: collision with root package name */
            Object f26657d;

            /* renamed from: e  reason: collision with root package name */
            Object f26658e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0269a(a aVar, C2308e eVar) {
                super(eVar);
                this.f26656c = aVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f26654a = obj;
                this.f26655b |= Integer.MIN_VALUE;
                return this.f26656c.collect((C2973f) null, this);
            }
        }

        public a(C2972e eVar, q qVar) {
            this.f26652a = eVar;
            this.f26653b = qVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
            if (r6 == r1) goto L_0x006e;
         */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0057  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object collect(z3.C2973f r6, b3.C2308e r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof z3.p.a.C0269a
                if (r0 == 0) goto L_0x0013
                r0 = r7
                z3.p$a$a r0 = (z3.p.a.C0269a) r0
                int r1 = r0.f26655b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f26655b = r1
                goto L_0x0018
            L_0x0013:
                z3.p$a$a r0 = new z3.p$a$a
                r0.<init>(r5, r7)
            L_0x0018:
                java.lang.Object r7 = r0.f26654a
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f26655b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x0040
                if (r2 == r4) goto L_0x0034
                if (r2 != r3) goto L_0x002c
                W2.u.b(r7)
                goto L_0x006f
            L_0x002c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L_0x0034:
                java.lang.Object r6 = r0.f26658e
                z3.f r6 = (z3.C2973f) r6
                java.lang.Object r2 = r0.f26657d
                z3.p$a r2 = (z3.p.a) r2
                W2.u.b(r7)
                goto L_0x0053
            L_0x0040:
                W2.u.b(r7)
                z3.e r7 = r5.f26652a
                r0.f26657d = r5
                r0.f26658e = r6
                r0.f26655b = r4
                java.lang.Object r7 = z3.C2974g.f(r7, r6, r0)
                if (r7 != r1) goto L_0x0052
                goto L_0x006e
            L_0x0052:
                r2 = r5
            L_0x0053:
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L_0x006f
                k3.q r2 = r2.f26653b
                r4 = 0
                r0.f26657d = r4
                r0.f26658e = r4
                r0.f26655b = r3
                r3 = 6
                kotlin.jvm.internal.r.c(r3)
                java.lang.Object r6 = r2.invoke(r6, r7, r0)
                r7 = 7
                kotlin.jvm.internal.r.c(r7)
                if (r6 != r1) goto L_0x006f
            L_0x006e:
                return r1
            L_0x006f:
                W2.J r6 = W2.J.f19942a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: z3.p.a.collect(z3.f, b3.e):java.lang.Object");
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f26659a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f26660b;

        /* renamed from: c  reason: collision with root package name */
        int f26661c;

        b(C2308e eVar) {
            super(eVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f26660b = obj;
            this.f26661c |= Integer.MIN_VALUE;
            return C2974g.f((C2972e) null, (C2973f) null, this);
        }
    }

    static final class c implements C2973f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2973f f26662a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ L f26663b;

        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* renamed from: a  reason: collision with root package name */
            Object f26664a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ Object f26665b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ c f26666c;

            /* renamed from: d  reason: collision with root package name */
            int f26667d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, C2308e eVar) {
                super(eVar);
                this.f26666c = cVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f26665b = obj;
                this.f26667d |= Integer.MIN_VALUE;
                return this.f26666c.emit((Object) null, this);
            }
        }

        c(C2973f fVar, L l5) {
            this.f26662a = fVar;
            this.f26663b = l5;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object emit(java.lang.Object r5, b3.C2308e r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof z3.p.c.a
                if (r0 == 0) goto L_0x0013
                r0 = r6
                z3.p$c$a r0 = (z3.p.c.a) r0
                int r1 = r0.f26667d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f26667d = r1
                goto L_0x0018
            L_0x0013:
                z3.p$c$a r0 = new z3.p$c$a
                r0.<init>(r4, r6)
            L_0x0018:
                java.lang.Object r6 = r0.f26665b
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f26667d
                r3 = 1
                if (r2 == 0) goto L_0x0037
                if (r2 != r3) goto L_0x002f
                java.lang.Object r5 = r0.f26664a
                z3.p$c r5 = (z3.p.c) r5
                W2.u.b(r6)     // Catch:{ all -> 0x002d }
                goto L_0x0047
            L_0x002d:
                r6 = move-exception
                goto L_0x004c
            L_0x002f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x0037:
                W2.u.b(r6)
                z3.f r6 = r4.f26662a     // Catch:{ all -> 0x004a }
                r0.f26664a = r4     // Catch:{ all -> 0x004a }
                r0.f26667d = r3     // Catch:{ all -> 0x004a }
                java.lang.Object r5 = r6.emit(r5, r0)     // Catch:{ all -> 0x004a }
                if (r5 != r1) goto L_0x0047
                return r1
            L_0x0047:
                W2.J r5 = W2.J.f19942a
                return r5
            L_0x004a:
                r6 = move-exception
                r5 = r4
            L_0x004c:
                kotlin.jvm.internal.L r5 = r5.f26663b
                r5.f24690a = r6
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: z3.p.c.emit(java.lang.Object, b3.e):java.lang.Object");
        }
    }

    public static final class d implements C2972e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2972e f26668a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ r f26669b;

        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* renamed from: a  reason: collision with root package name */
            /* synthetic */ Object f26670a;

            /* renamed from: b  reason: collision with root package name */
            int f26671b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ d f26672c;

            /* renamed from: d  reason: collision with root package name */
            Object f26673d;

            /* renamed from: e  reason: collision with root package name */
            Object f26674e;

            /* renamed from: f  reason: collision with root package name */
            Object f26675f;

            /* renamed from: g  reason: collision with root package name */
            long f26676g;

            /* renamed from: h  reason: collision with root package name */
            int f26677h;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(d dVar, C2308e eVar) {
                super(eVar);
                this.f26672c = dVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f26670a = obj;
                this.f26671b |= Integer.MIN_VALUE;
                return this.f26672c.collect((C2973f) null, this);
            }
        }

        public d(C2972e eVar, r rVar) {
            this.f26668a = eVar;
            this.f26669b = rVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0078  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00a2  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00ab  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00ae  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object collect(z3.C2973f r12, b3.C2308e r13) {
            /*
                r11 = this;
                boolean r0 = r13 instanceof z3.p.d.a
                if (r0 == 0) goto L_0x0013
                r0 = r13
                z3.p$d$a r0 = (z3.p.d.a) r0
                int r1 = r0.f26671b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f26671b = r1
                goto L_0x0018
            L_0x0013:
                z3.p$d$a r0 = new z3.p$d$a
                r0.<init>(r11, r13)
            L_0x0018:
                java.lang.Object r13 = r0.f26670a
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f26671b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x0052
                if (r2 == r4) goto L_0x0042
                if (r2 != r3) goto L_0x003a
                long r5 = r0.f26676g
                java.lang.Object r12 = r0.f26675f
                java.lang.Throwable r12 = (java.lang.Throwable) r12
                java.lang.Object r2 = r0.f26674e
                z3.f r2 = (z3.C2973f) r2
                java.lang.Object r7 = r0.f26673d
                z3.p$d r7 = (z3.p.d) r7
                W2.u.b(r13)
                goto L_0x009a
            L_0x003a:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L_0x0042:
                int r12 = r0.f26677h
                long r5 = r0.f26676g
                java.lang.Object r2 = r0.f26674e
                z3.f r2 = (z3.C2973f) r2
                java.lang.Object r7 = r0.f26673d
                z3.p$d r7 = (z3.p.d) r7
                W2.u.b(r13)
                goto L_0x0074
            L_0x0052:
                W2.u.b(r13)
                r5 = 0
                r13 = r11
            L_0x0058:
                z3.e r2 = r13.f26668a
                r0.f26673d = r13
                r0.f26674e = r12
                r7 = 0
                r0.f26675f = r7
                r0.f26676g = r5
                r7 = 0
                r0.f26677h = r7
                r0.f26671b = r4
                java.lang.Object r2 = z3.C2974g.f(r2, r12, r0)
                if (r2 != r1) goto L_0x006f
                goto L_0x0096
            L_0x006f:
                r10 = r2
                r2 = r12
                r12 = r7
                r7 = r13
                r13 = r10
            L_0x0074:
                java.lang.Throwable r13 = (java.lang.Throwable) r13
                if (r13 == 0) goto L_0x00a6
                k3.r r12 = r7.f26669b
                java.lang.Long r8 = kotlin.coroutines.jvm.internal.b.c(r5)
                r0.f26673d = r7
                r0.f26674e = r2
                r0.f26675f = r13
                r0.f26676g = r5
                r0.f26671b = r3
                r9 = 6
                kotlin.jvm.internal.r.c(r9)
                java.lang.Object r12 = r12.invoke(r2, r13, r8, r0)
                r8 = 7
                kotlin.jvm.internal.r.c(r8)
                if (r12 != r1) goto L_0x0097
            L_0x0096:
                return r1
            L_0x0097:
                r10 = r13
                r13 = r12
                r12 = r10
            L_0x009a:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r13 = r13.booleanValue()
                if (r13 == 0) goto L_0x00a8
                r12 = 1
                long r5 = r5 + r12
                r12 = r4
            L_0x00a6:
                r13 = r7
                goto L_0x00a9
            L_0x00a8:
                throw r12
            L_0x00a9:
                if (r12 != 0) goto L_0x00ae
                W2.J r12 = W2.J.f19942a
                return r12
            L_0x00ae:
                r12 = r2
                goto L_0x0058
            */
            throw new UnsupportedOperationException("Method not decompiled: z3.p.d.collect(z3.f, b3.e):java.lang.Object");
        }
    }

    public static final C2972e a(C2972e eVar, q qVar) {
        return new a(eVar, qVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(z3.C2972e r4, z3.C2973f r5, b3.C2308e r6) {
        /*
            boolean r0 = r6 instanceof z3.p.b
            if (r0 == 0) goto L_0x0013
            r0 = r6
            z3.p$b r0 = (z3.p.b) r0
            int r1 = r0.f26661c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26661c = r1
            goto L_0x0018
        L_0x0013:
            z3.p$b r0 = new z3.p$b
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.f26660b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f26661c
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.f26659a
            kotlin.jvm.internal.L r4 = (kotlin.jvm.internal.L) r4
            W2.u.b(r6)     // Catch:{ all -> 0x002d }
            goto L_0x004f
        L_0x002d:
            r5 = move-exception
            goto L_0x0053
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            W2.u.b(r6)
            kotlin.jvm.internal.L r6 = new kotlin.jvm.internal.L
            r6.<init>()
            z3.p$c r2 = new z3.p$c     // Catch:{ all -> 0x0051 }
            r2.<init>(r5, r6)     // Catch:{ all -> 0x0051 }
            r0.f26659a = r6     // Catch:{ all -> 0x0051 }
            r0.f26661c = r3     // Catch:{ all -> 0x0051 }
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch:{ all -> 0x0051 }
            if (r4 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r4 = 0
            return r4
        L_0x0051:
            r5 = move-exception
            r4 = r6
        L_0x0053:
            java.lang.Object r4 = r4.f24690a
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r6 = d(r5, r4)
            if (r6 != 0) goto L_0x0076
            b3.i r6 = r0.getContext()
            boolean r6 = c(r5, r6)
            if (r6 != 0) goto L_0x0076
            if (r4 != 0) goto L_0x006a
            return r5
        L_0x006a:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L_0x0072
            W2.C2216e.a(r4, r5)
            throw r4
        L_0x0072:
            W2.C2216e.a(r5, r4)
            throw r5
        L_0x0076:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.p.b(z3.e, z3.f, b3.e):java.lang.Object");
    }

    private static final boolean c(Throwable th, C2312i iVar) {
        C2908y0 y0Var = (C2908y0) iVar.get(C2908y0.f26320k0);
        if (y0Var == null || !y0Var.isCancelled()) {
            return false;
        }
        return d(th, y0Var.m());
    }

    private static final boolean d(Throwable th, Throwable th2) {
        if (th2 == null || !t.a(th2, th)) {
            return false;
        }
        return true;
    }

    public static final C2972e e(C2972e eVar, r rVar) {
        return new d(eVar, rVar);
    }
}
