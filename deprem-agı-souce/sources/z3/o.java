package z3;

import b3.C2308e;
import k3.p;
import k3.q;
import kotlin.coroutines.jvm.internal.d;

abstract /* synthetic */ class o {

    static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f26634a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f26635b;

        /* renamed from: c  reason: collision with root package name */
        int f26636c;

        a(C2308e eVar) {
            super(eVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f26635b = obj;
            this.f26636c |= Integer.MIN_VALUE;
            return o.c((C2973f) null, (q) null, (Throwable) null, this);
        }
    }

    public static final class b implements C2972e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2972e f26637a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q f26638b;

        public static final class a extends d {

            /* renamed from: a  reason: collision with root package name */
            /* synthetic */ Object f26639a;

            /* renamed from: b  reason: collision with root package name */
            int f26640b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ b f26641c;

            /* renamed from: d  reason: collision with root package name */
            Object f26642d;

            /* renamed from: e  reason: collision with root package name */
            Object f26643e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, C2308e eVar) {
                super(eVar);
                this.f26641c = bVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f26639a = obj;
                this.f26640b |= Integer.MIN_VALUE;
                return this.f26641c.collect((C2973f) null, this);
            }
        }

        public b(C2972e eVar, q qVar) {
            this.f26637a = eVar;
            this.f26638b = qVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00aa, code lost:
            if (z3.o.a(r10, r2, r9, r0) != r1) goto L_0x00ad;
         */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0088  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object collect(z3.C2973f r9, b3.C2308e r10) {
            /*
                r8 = this;
                boolean r0 = r10 instanceof z3.o.b.a
                if (r0 == 0) goto L_0x0013
                r0 = r10
                z3.o$b$a r0 = (z3.o.b.a) r0
                int r1 = r0.f26640b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f26640b = r1
                goto L_0x0018
            L_0x0013:
                z3.o$b$a r0 = new z3.o$b$a
                r0.<init>(r8, r10)
            L_0x0018:
                java.lang.Object r10 = r0.f26639a
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f26640b
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L_0x0055
                if (r2 == r5) goto L_0x0047
                if (r2 == r4) goto L_0x003e
                if (r2 != r3) goto L_0x0036
                java.lang.Object r9 = r0.f26642d
                A3.t r9 = (A3.t) r9
                W2.u.b(r10)     // Catch:{ all -> 0x0034 }
                goto L_0x0089
            L_0x0034:
                r10 = move-exception
                goto L_0x0093
            L_0x0036:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L_0x003e:
                java.lang.Object r9 = r0.f26642d
                java.lang.Throwable r9 = (java.lang.Throwable) r9
                W2.u.b(r10)
                goto L_0x00ad
            L_0x0047:
                java.lang.Object r9 = r0.f26643e
                z3.f r9 = (z3.C2973f) r9
                java.lang.Object r2 = r0.f26642d
                z3.o$b r2 = (z3.o.b) r2
                W2.u.b(r10)     // Catch:{ all -> 0x0053 }
                goto L_0x0068
            L_0x0053:
                r9 = move-exception
                goto L_0x0099
            L_0x0055:
                W2.u.b(r10)
                z3.e r10 = r8.f26637a     // Catch:{ all -> 0x0097 }
                r0.f26642d = r8     // Catch:{ all -> 0x0097 }
                r0.f26643e = r9     // Catch:{ all -> 0x0097 }
                r0.f26640b = r5     // Catch:{ all -> 0x0097 }
                java.lang.Object r10 = r10.collect(r9, r0)     // Catch:{ all -> 0x0097 }
                if (r10 != r1) goto L_0x0067
                goto L_0x00ac
            L_0x0067:
                r2 = r8
            L_0x0068:
                A3.t r10 = new A3.t
                b3.i r4 = r0.getContext()
                r10.<init>(r9, r4)
                k3.q r9 = r2.f26638b     // Catch:{ all -> 0x008f }
                r0.f26642d = r10     // Catch:{ all -> 0x008f }
                r0.f26643e = r6     // Catch:{ all -> 0x008f }
                r0.f26640b = r3     // Catch:{ all -> 0x008f }
                r2 = 6
                kotlin.jvm.internal.r.c(r2)     // Catch:{ all -> 0x008f }
                java.lang.Object r9 = r9.invoke(r10, r6, r0)     // Catch:{ all -> 0x008f }
                r0 = 7
                kotlin.jvm.internal.r.c(r0)     // Catch:{ all -> 0x008f }
                if (r9 != r1) goto L_0x0088
                goto L_0x00ac
            L_0x0088:
                r9 = r10
            L_0x0089:
                r9.releaseIntercepted()
                W2.J r9 = W2.J.f19942a
                return r9
            L_0x008f:
                r9 = move-exception
                r7 = r10
                r10 = r9
                r9 = r7
            L_0x0093:
                r9.releaseIntercepted()
                throw r10
            L_0x0097:
                r9 = move-exception
                r2 = r8
            L_0x0099:
                z3.H r10 = new z3.H
                r10.<init>(r9)
                k3.q r2 = r2.f26638b
                r0.f26642d = r9
                r0.f26643e = r6
                r0.f26640b = r4
                java.lang.Object r10 = z3.o.c(r10, r2, r9, r0)
                if (r10 != r1) goto L_0x00ad
            L_0x00ac:
                return r1
            L_0x00ad:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: z3.o.b.collect(z3.f, b3.e):java.lang.Object");
        }
    }

    public static final class c implements C2972e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f26644a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2972e f26645b;

        public static final class a extends d {

            /* renamed from: a  reason: collision with root package name */
            /* synthetic */ Object f26646a;

            /* renamed from: b  reason: collision with root package name */
            int f26647b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ c f26648c;

            /* renamed from: d  reason: collision with root package name */
            Object f26649d;

            /* renamed from: e  reason: collision with root package name */
            Object f26650e;

            /* renamed from: f  reason: collision with root package name */
            Object f26651f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(c cVar, C2308e eVar) {
                super(eVar);
                this.f26648c = cVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f26646a = obj;
                this.f26647b |= Integer.MIN_VALUE;
                return this.f26648c.collect((C2973f) null, this);
            }
        }

        public c(p pVar, C2972e eVar) {
            this.f26644a = pVar;
            this.f26645b = eVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
            if (r7.collect(r2, r0) != r1) goto L_0x0083;
         */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object collect(z3.C2973f r7, b3.C2308e r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof z3.o.c.a
                if (r0 == 0) goto L_0x0013
                r0 = r8
                z3.o$c$a r0 = (z3.o.c.a) r0
                int r1 = r0.f26647b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f26647b = r1
                goto L_0x0018
            L_0x0013:
                z3.o$c$a r0 = new z3.o$c$a
                r0.<init>(r6, r8)
            L_0x0018:
                java.lang.Object r8 = r0.f26646a
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f26647b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x0046
                if (r2 == r4) goto L_0x0034
                if (r2 != r3) goto L_0x002c
                W2.u.b(r8)
                goto L_0x0083
            L_0x002c:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L_0x0034:
                java.lang.Object r7 = r0.f26651f
                A3.t r7 = (A3.t) r7
                java.lang.Object r2 = r0.f26650e
                z3.f r2 = (z3.C2973f) r2
                java.lang.Object r4 = r0.f26649d
                z3.o$c r4 = (z3.o.c) r4
                W2.u.b(r8)     // Catch:{ all -> 0x0044 }
                goto L_0x006e
            L_0x0044:
                r8 = move-exception
                goto L_0x008a
            L_0x0046:
                W2.u.b(r8)
                A3.t r8 = new A3.t
                b3.i r2 = r0.getContext()
                r8.<init>(r7, r2)
                k3.p r2 = r6.f26644a     // Catch:{ all -> 0x0086 }
                r0.f26649d = r6     // Catch:{ all -> 0x0086 }
                r0.f26650e = r7     // Catch:{ all -> 0x0086 }
                r0.f26651f = r8     // Catch:{ all -> 0x0086 }
                r0.f26647b = r4     // Catch:{ all -> 0x0086 }
                r4 = 6
                kotlin.jvm.internal.r.c(r4)     // Catch:{ all -> 0x0086 }
                java.lang.Object r2 = r2.invoke(r8, r0)     // Catch:{ all -> 0x0086 }
                r4 = 7
                kotlin.jvm.internal.r.c(r4)     // Catch:{ all -> 0x0086 }
                if (r2 != r1) goto L_0x006b
                goto L_0x0082
            L_0x006b:
                r4 = r6
                r2 = r7
                r7 = r8
            L_0x006e:
                r7.releaseIntercepted()
                z3.e r7 = r4.f26645b
                r8 = 0
                r0.f26649d = r8
                r0.f26650e = r8
                r0.f26651f = r8
                r0.f26647b = r3
                java.lang.Object r7 = r7.collect(r2, r0)
                if (r7 != r1) goto L_0x0083
            L_0x0082:
                return r1
            L_0x0083:
                W2.J r7 = W2.J.f19942a
                return r7
            L_0x0086:
                r7 = move-exception
                r5 = r8
                r8 = r7
                r7 = r5
            L_0x008a:
                r7.releaseIntercepted()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: z3.o.c.collect(z3.f, b3.e):java.lang.Object");
        }
    }

    public static final void b(C2973f fVar) {
        if (fVar instanceof H) {
            throw ((H) fVar).f26604a;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Throwable} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(z3.C2973f r4, k3.q r5, java.lang.Throwable r6, b3.C2308e r7) {
        /*
            boolean r0 = r7 instanceof z3.o.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            z3.o$a r0 = (z3.o.a) r0
            int r1 = r0.f26636c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26636c = r1
            goto L_0x0018
        L_0x0013:
            z3.o$a r0 = new z3.o$a
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f26635b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f26636c
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r4 = r0.f26634a
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            W2.u.b(r7)     // Catch:{ all -> 0x002e }
            goto L_0x0046
        L_0x002e:
            r4 = move-exception
            goto L_0x0049
        L_0x0030:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0038:
            W2.u.b(r7)
            r0.f26634a = r6     // Catch:{ all -> 0x002e }
            r0.f26636c = r3     // Catch:{ all -> 0x002e }
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch:{ all -> 0x002e }
            if (r4 != r1) goto L_0x0046
            return r1
        L_0x0046:
            W2.J r4 = W2.J.f19942a
            return r4
        L_0x0049:
            if (r6 == 0) goto L_0x0050
            if (r6 == r4) goto L_0x0050
            W2.C2216e.a(r4, r6)
        L_0x0050:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.o.c(z3.f, k3.q, java.lang.Throwable, b3.e):java.lang.Object");
    }

    public static final C2972e d(C2972e eVar, q qVar) {
        return new b(eVar, qVar);
    }

    public static final C2972e e(C2972e eVar, p pVar) {
        return new c(pVar, eVar);
    }
}
