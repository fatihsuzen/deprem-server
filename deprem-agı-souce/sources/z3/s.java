package z3;

import b3.C2308e;
import kotlin.jvm.internal.L;

abstract /* synthetic */ class s {

    public static final class a implements C2973f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ L f26702a;

        public a(L l5) {
            this.f26702a = l5;
        }

        public Object emit(Object obj, C2308e eVar) {
            this.f26702a.f24690a = obj;
            throw new A3.a(this);
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f26703a;

        /* renamed from: b  reason: collision with root package name */
        Object f26704b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f26705c;

        /* renamed from: d  reason: collision with root package name */
        int f26706d;

        b(C2308e eVar) {
            super(eVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f26705c = obj;
            this.f26706d |= Integer.MIN_VALUE;
            return C2974g.o((C2972e) null, this);
        }
    }

    public static final class c implements C2973f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ L f26707a;

        public c(L l5) {
            this.f26707a = l5;
        }

        public Object emit(Object obj, C2308e eVar) {
            this.f26707a.f24690a = obj;
            throw new A3.a(this);
        }
    }

    static final class d extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f26708a;

        /* renamed from: b  reason: collision with root package name */
        Object f26709b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f26710c;

        /* renamed from: d  reason: collision with root package name */
        int f26711d;

        d(C2308e eVar) {
            super(eVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f26710c = obj;
            this.f26711d |= Integer.MIN_VALUE;
            return C2974g.p((C2972e) null, this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(z3.C2972e r4, b3.C2308e r5) {
        /*
            boolean r0 = r5 instanceof z3.s.b
            if (r0 == 0) goto L_0x0013
            r0 = r5
            z3.s$b r0 = (z3.s.b) r0
            int r1 = r0.f26706d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26706d = r1
            goto L_0x0018
        L_0x0013:
            z3.s$b r0 = new z3.s$b
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.f26705c
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f26706d
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r4 = r0.f26704b
            z3.s$a r4 = (z3.s.a) r4
            java.lang.Object r0 = r0.f26703a
            kotlin.jvm.internal.L r0 = (kotlin.jvm.internal.L) r0
            W2.u.b(r5)     // Catch:{ a -> 0x0031 }
            goto L_0x0062
        L_0x0031:
            r5 = move-exception
            goto L_0x005f
        L_0x0033:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003b:
            W2.u.b(r5)
            kotlin.jvm.internal.L r5 = new kotlin.jvm.internal.L
            r5.<init>()
            B3.D r2 = A3.r.f17311a
            r5.f24690a = r2
            z3.s$a r2 = new z3.s$a
            r2.<init>(r5)
            r0.f26703a = r5     // Catch:{ a -> 0x005b }
            r0.f26704b = r2     // Catch:{ a -> 0x005b }
            r0.f26706d = r3     // Catch:{ a -> 0x005b }
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch:{ a -> 0x005b }
            if (r4 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r0 = r5
            goto L_0x0062
        L_0x005b:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L_0x005f:
            A3.n.a(r5, r4)
        L_0x0062:
            java.lang.Object r4 = r0.f24690a
            B3.D r5 = A3.r.f17311a
            if (r4 == r5) goto L_0x0069
            return r4
        L_0x0069:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.s.a(z3.e, b3.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(z3.C2972e r4, b3.C2308e r5) {
        /*
            boolean r0 = r5 instanceof z3.s.d
            if (r0 == 0) goto L_0x0013
            r0 = r5
            z3.s$d r0 = (z3.s.d) r0
            int r1 = r0.f26711d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26711d = r1
            goto L_0x0018
        L_0x0013:
            z3.s$d r0 = new z3.s$d
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.f26710c
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f26711d
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r4 = r0.f26709b
            z3.s$c r4 = (z3.s.c) r4
            java.lang.Object r0 = r0.f26708a
            kotlin.jvm.internal.L r0 = (kotlin.jvm.internal.L) r0
            W2.u.b(r5)     // Catch:{ a -> 0x0031 }
            goto L_0x005e
        L_0x0031:
            r5 = move-exception
            goto L_0x005b
        L_0x0033:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003b:
            W2.u.b(r5)
            kotlin.jvm.internal.L r5 = new kotlin.jvm.internal.L
            r5.<init>()
            z3.s$c r2 = new z3.s$c
            r2.<init>(r5)
            r0.f26708a = r5     // Catch:{ a -> 0x0057 }
            r0.f26709b = r2     // Catch:{ a -> 0x0057 }
            r0.f26711d = r3     // Catch:{ a -> 0x0057 }
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch:{ a -> 0x0057 }
            if (r4 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r0 = r5
            goto L_0x005e
        L_0x0057:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L_0x005b:
            A3.n.a(r5, r4)
        L_0x005e:
            java.lang.Object r4 = r0.f24690a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.s.b(z3.e, b3.e):java.lang.Object");
    }
}
