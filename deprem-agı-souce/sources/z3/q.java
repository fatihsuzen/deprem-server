package z3;

import W2.J;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.jvm.internal.I;

abstract /* synthetic */ class q {

    public static final class a implements C2972e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2972e f26678a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f26679b;

        public a(C2972e eVar, p pVar) {
            this.f26678a = eVar;
            this.f26679b = pVar;
        }

        public Object collect(C2973f fVar, C2308e eVar) {
            Object collect = this.f26678a.collect(new b(new I(), fVar, this.f26679b), eVar);
            if (collect == C2316b.f()) {
                return collect;
            }
            return J.f19942a;
        }
    }

    static final class b implements C2973f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ I f26680a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2973f f26681b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ p f26682c;

        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* renamed from: a  reason: collision with root package name */
            Object f26683a;

            /* renamed from: b  reason: collision with root package name */
            Object f26684b;

            /* renamed from: c  reason: collision with root package name */
            /* synthetic */ Object f26685c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ b f26686d;

            /* renamed from: e  reason: collision with root package name */
            int f26687e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, C2308e eVar) {
                super(eVar);
                this.f26686d = bVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f26685c = obj;
                this.f26687e |= Integer.MIN_VALUE;
                return this.f26686d.emit((Object) null, this);
            }
        }

        b(I i5, C2973f fVar, p pVar) {
            this.f26680a = i5;
            this.f26681b = fVar;
            this.f26682c = pVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
            if (r8.emit(r7, r0) == r1) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0085, code lost:
            if (r8.emit(r7, r0) == r1) goto L_0x0087;
         */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object emit(java.lang.Object r7, b3.C2308e r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof z3.q.b.a
                if (r0 == 0) goto L_0x0013
                r0 = r8
                z3.q$b$a r0 = (z3.q.b.a) r0
                int r1 = r0.f26687e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f26687e = r1
                goto L_0x0018
            L_0x0013:
                z3.q$b$a r0 = new z3.q$b$a
                r0.<init>(r6, r8)
            L_0x0018:
                java.lang.Object r8 = r0.f26685c
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f26687e
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L_0x0045
                if (r2 == r5) goto L_0x0041
                if (r2 == r4) goto L_0x0037
                if (r2 != r3) goto L_0x002f
                W2.u.b(r8)
                goto L_0x0088
            L_0x002f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L_0x0037:
                java.lang.Object r7 = r0.f26684b
                java.lang.Object r2 = r0.f26683a
                z3.q$b r2 = (z3.q.b) r2
                W2.u.b(r8)
                goto L_0x006c
            L_0x0041:
                W2.u.b(r8)
                goto L_0x0059
            L_0x0045:
                W2.u.b(r8)
                kotlin.jvm.internal.I r8 = r6.f26680a
                boolean r8 = r8.f24687a
                if (r8 == 0) goto L_0x005c
                z3.f r8 = r6.f26681b
                r0.f26687e = r5
                java.lang.Object r7 = r8.emit(r7, r0)
                if (r7 != r1) goto L_0x0059
                goto L_0x0087
            L_0x0059:
                W2.J r7 = W2.J.f19942a
                return r7
            L_0x005c:
                k3.p r8 = r6.f26682c
                r0.f26683a = r6
                r0.f26684b = r7
                r0.f26687e = r4
                java.lang.Object r8 = r8.invoke(r7, r0)
                if (r8 != r1) goto L_0x006b
                goto L_0x0087
            L_0x006b:
                r2 = r6
            L_0x006c:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 != 0) goto L_0x008b
                kotlin.jvm.internal.I r8 = r2.f26680a
                r8.f24687a = r5
                z3.f r8 = r2.f26681b
                r2 = 0
                r0.f26683a = r2
                r0.f26684b = r2
                r0.f26687e = r3
                java.lang.Object r7 = r8.emit(r7, r0)
                if (r7 != r1) goto L_0x0088
            L_0x0087:
                return r1
            L_0x0088:
                W2.J r7 = W2.J.f19942a
                return r7
            L_0x008b:
                W2.J r7 = W2.J.f19942a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: z3.q.b.emit(java.lang.Object, b3.e):java.lang.Object");
        }
    }

    public static final class c implements C2972e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2972e f26688a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f26689b;

        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* renamed from: a  reason: collision with root package name */
            /* synthetic */ Object f26690a;

            /* renamed from: b  reason: collision with root package name */
            int f26691b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ c f26692c;

            /* renamed from: d  reason: collision with root package name */
            Object f26693d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(c cVar, C2308e eVar) {
                super(eVar);
                this.f26692c = cVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f26690a = obj;
                this.f26691b |= Integer.MIN_VALUE;
                return this.f26692c.collect((C2973f) null, this);
            }
        }

        public c(C2972e eVar, p pVar) {
            this.f26688a = eVar;
            this.f26689b = pVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object collect(z3.C2973f r6, b3.C2308e r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof z3.q.c.a
                if (r0 == 0) goto L_0x0013
                r0 = r7
                z3.q$c$a r0 = (z3.q.c.a) r0
                int r1 = r0.f26691b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f26691b = r1
                goto L_0x0018
            L_0x0013:
                z3.q$c$a r0 = new z3.q$c$a
                r0.<init>(r5, r7)
            L_0x0018:
                java.lang.Object r7 = r0.f26690a
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f26691b
                r3 = 1
                if (r2 == 0) goto L_0x0037
                if (r2 != r3) goto L_0x002f
                java.lang.Object r6 = r0.f26693d
                z3.q$d r6 = (z3.q.d) r6
                W2.u.b(r7)     // Catch:{ a -> 0x002d }
                goto L_0x0053
            L_0x002d:
                r7 = move-exception
                goto L_0x0050
            L_0x002f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L_0x0037:
                W2.u.b(r7)
                z3.e r7 = r5.f26688a
                z3.q$d r2 = new z3.q$d
                k3.p r4 = r5.f26689b
                r2.<init>(r4, r6)
                r0.f26693d = r2     // Catch:{ a -> 0x004e }
                r0.f26691b = r3     // Catch:{ a -> 0x004e }
                java.lang.Object r6 = r7.collect(r2, r0)     // Catch:{ a -> 0x004e }
                if (r6 != r1) goto L_0x0053
                return r1
            L_0x004e:
                r7 = move-exception
                r6 = r2
            L_0x0050:
                A3.n.a(r7, r6)
            L_0x0053:
                W2.J r6 = W2.J.f19942a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: z3.q.c.collect(z3.f, b3.e):java.lang.Object");
        }
    }

    public static final class d implements C2973f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f26694a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2973f f26695b;

        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* renamed from: a  reason: collision with root package name */
            Object f26696a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ Object f26697b;

            /* renamed from: c  reason: collision with root package name */
            int f26698c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ d f26699d;

            /* renamed from: e  reason: collision with root package name */
            Object f26700e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(d dVar, C2308e eVar) {
                super(eVar);
                this.f26699d = dVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f26697b = obj;
                this.f26698c |= Integer.MIN_VALUE;
                return this.f26699d.emit((Object) null, this);
            }
        }

        public d(p pVar, C2973f fVar) {
            this.f26694a = pVar;
            this.f26695b = fVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0078, code lost:
            if (r2.emit(r9, r0) == r1) goto L_0x007a;
         */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x006b  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x007e  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0081  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object emit(java.lang.Object r8, b3.C2308e r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof z3.q.d.a
                if (r0 == 0) goto L_0x0013
                r0 = r9
                z3.q$d$a r0 = (z3.q.d.a) r0
                int r1 = r0.f26698c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f26698c = r1
                goto L_0x0018
            L_0x0013:
                z3.q$d$a r0 = new z3.q$d$a
                r0.<init>(r7, r9)
            L_0x0018:
                java.lang.Object r9 = r0.f26697b
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f26698c
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x0046
                if (r2 == r4) goto L_0x0038
                if (r2 != r3) goto L_0x0030
                java.lang.Object r8 = r0.f26696a
                z3.q$d r8 = (z3.q.d) r8
                W2.u.b(r9)
                goto L_0x007c
            L_0x0030:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L_0x0038:
                java.lang.Object r8 = r0.f26700e
                java.lang.Object r2 = r0.f26696a
                z3.q$d r2 = (z3.q.d) r2
                W2.u.b(r9)
                r6 = r9
                r9 = r8
                r8 = r2
                r2 = r6
                goto L_0x0063
            L_0x0046:
                W2.u.b(r9)
                k3.p r9 = r7.f26694a
                r0.f26696a = r7
                r0.f26700e = r8
                r0.f26698c = r4
                r2 = 6
                kotlin.jvm.internal.r.c(r2)
                java.lang.Object r9 = r9.invoke(r8, r0)
                r2 = 7
                kotlin.jvm.internal.r.c(r2)
                if (r9 != r1) goto L_0x0060
                goto L_0x007a
            L_0x0060:
                r2 = r9
                r9 = r8
                r8 = r7
            L_0x0063:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 == 0) goto L_0x007b
                z3.f r2 = r8.f26695b
                r0.f26696a = r8
                r5 = 0
                r0.f26700e = r5
                r0.f26698c = r3
                java.lang.Object r9 = r2.emit(r9, r0)
                if (r9 != r1) goto L_0x007c
            L_0x007a:
                return r1
            L_0x007b:
                r4 = 0
            L_0x007c:
                if (r4 == 0) goto L_0x0081
                W2.J r8 = W2.J.f19942a
                return r8
            L_0x0081:
                A3.a r9 = new A3.a
                r9.<init>(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: z3.q.d.emit(java.lang.Object, b3.e):java.lang.Object");
        }
    }

    public static final C2972e a(C2972e eVar, p pVar) {
        return new a(eVar, pVar);
    }

    public static final C2972e b(C2972e eVar, p pVar) {
        return new c(eVar, pVar);
    }
}
