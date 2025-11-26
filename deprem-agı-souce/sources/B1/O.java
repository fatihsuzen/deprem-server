package b1;

import S0.e;
import W2.J;
import android.util.Log;
import b3.C2308e;
import b3.C2312i;
import e1.j;
import k3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import o0.f;
import w3.C2908y0;
import w3.M;
import w3.N;

public final class O implements N {

    /* renamed from: f  reason: collision with root package name */
    public static final a f4549f = new a((C2633k) null);

    /* renamed from: g  reason: collision with root package name */
    private static final double f4550g = Math.random();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final f f4551a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final e f4552b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final j f4553c;

    /* renamed from: d  reason: collision with root package name */
    private final C1024i f4554d;

    /* renamed from: e  reason: collision with root package name */
    private final C2312i f4555e;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f4556a;

        /* renamed from: b  reason: collision with root package name */
        Object f4557b;

        /* renamed from: c  reason: collision with root package name */
        Object f4558c;

        /* renamed from: d  reason: collision with root package name */
        Object f4559d;

        /* renamed from: e  reason: collision with root package name */
        Object f4560e;

        /* renamed from: f  reason: collision with root package name */
        Object f4561f;

        /* renamed from: g  reason: collision with root package name */
        int f4562g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ O f4563h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ K f4564i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(O o5, K k5, C2308e eVar) {
            super(2, eVar);
            this.f4563h = o5;
            this.f4564i = k5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f4563h, this.f4564i, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0050, code lost:
            if (r9 == r0) goto L_0x0095;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0069, code lost:
            if (r9 == r0) goto L_0x0095;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r8.f4562g
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0045
                if (r1 == r4) goto L_0x0041
                if (r1 == r3) goto L_0x003d
                if (r1 != r2) goto L_0x0035
                java.lang.Object r0 = r8.f4561f
                e1.j r0 = (e1.j) r0
                java.lang.Object r1 = r8.f4560e
                b1.K r1 = (b1.K) r1
                java.lang.Object r2 = r8.f4559d
                o0.f r2 = (o0.f) r2
                java.lang.Object r3 = r8.f4558c
                b1.M r3 = (b1.M) r3
                java.lang.Object r4 = r8.f4557b
                b1.O r4 = (b1.O) r4
                java.lang.Object r5 = r8.f4556a
                b1.w r5 = (b1.C1037w) r5
                W2.u.b(r9)
                r7 = r3
                r3 = r0
                r0 = r7
                r7 = r2
                r2 = r1
                r1 = r7
            L_0x0032:
                r7 = r4
                goto L_0x009d
            L_0x0035:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x003d:
                W2.u.b(r9)
                goto L_0x006c
            L_0x0041:
                W2.u.b(r9)
                goto L_0x0053
            L_0x0045:
                W2.u.b(r9)
                b1.O r9 = r8.f4563h
                r8.f4562g = r4
                java.lang.Object r9 = r9.i(r8)
                if (r9 != r0) goto L_0x0053
                goto L_0x0095
            L_0x0053:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto L_0x00b0
                b1.w$a r9 = b1.C1037w.f4725c
                b1.O r1 = r8.f4563h
                S0.e r1 = r1.f4552b
                r8.f4562g = r3
                java.lang.Object r9 = r9.a(r1, r8)
                if (r9 != r0) goto L_0x006c
                goto L_0x0095
            L_0x006c:
                r5 = r9
                b1.w r5 = (b1.C1037w) r5
                b1.O r4 = r8.f4563h
                b1.M r3 = b1.M.f4547a
                o0.f r9 = r4.f4551a
                b1.K r1 = r8.f4564i
                b1.O r6 = r8.f4563h
                e1.j r6 = r6.f4553c
                c1.b r7 = c1.C1045b.f4747a
                r8.f4556a = r5
                r8.f4557b = r4
                r8.f4558c = r3
                r8.f4559d = r9
                r8.f4560e = r1
                r8.f4561f = r6
                r8.f4562g = r2
                java.lang.Object r2 = r7.c(r8)
                if (r2 != r0) goto L_0x0096
            L_0x0095:
                return r0
            L_0x0096:
                r0 = r1
                r1 = r9
                r9 = r2
                r2 = r0
                r0 = r3
                r3 = r6
                goto L_0x0032
            L_0x009d:
                r4 = r9
                java.util.Map r4 = (java.util.Map) r4
                r9 = r5
                java.lang.String r5 = r9.b()
                java.lang.String r6 = r9.a()
                b1.L r9 = r0.a(r1, r2, r3, r4, r5, r6)
                r7.g(r9)
            L_0x00b0:
                W2.J r9 = W2.J.f19942a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: b1.O.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class c extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f4565a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f4566b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ O f4567c;

        /* renamed from: d  reason: collision with root package name */
        int f4568d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(O o5, C2308e eVar) {
            super(eVar);
            this.f4567c = o5;
        }

        public final Object invokeSuspend(Object obj) {
            this.f4566b = obj;
            this.f4568d |= Integer.MIN_VALUE;
            return this.f4567c.i(this);
        }
    }

    public O(f fVar, e eVar, j jVar, C1024i iVar, C2312i iVar2) {
        t.e(fVar, "firebaseApp");
        t.e(eVar, "firebaseInstallations");
        t.e(jVar, "sessionSettings");
        t.e(iVar, "eventGDTLogger");
        t.e(iVar2, "backgroundDispatcher");
        this.f4551a = fVar;
        this.f4552b = eVar;
        this.f4553c = jVar;
        this.f4554d = iVar;
        this.f4555e = iVar2;
    }

    /* access modifiers changed from: private */
    public final void g(L l5) {
        try {
            this.f4554d.a(l5);
            Log.d("FirebaseSessions", "Successfully logged Session Start event.");
        } catch (RuntimeException e5) {
            Log.e("FirebaseSessions", "Error logging Session Start event to DataTransport: ", e5);
        }
    }

    private final boolean h() {
        if (f4550g <= this.f4553c.a()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(b3.C2308e r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof b1.O.c
            if (r0 == 0) goto L_0x0013
            r0 = r9
            b1.O$c r0 = (b1.O.c) r0
            int r1 = r0.f4568d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f4568d = r1
            goto L_0x0018
        L_0x0013:
            b1.O$c r0 = new b1.O$c
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f4566b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f4568d
            r3 = 2
            r4 = 0
            java.lang.String r5 = "FirebaseSessions"
            r6 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 == r6) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r0 = r0.f4565a
            b1.O r0 = (b1.O) r0
            W2.u.b(r9)
            goto L_0x008e
        L_0x0033:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x003b:
            java.lang.Object r2 = r0.f4565a
            b1.O r2 = (b1.O) r2
            W2.u.b(r9)
            goto L_0x0054
        L_0x0043:
            W2.u.b(r9)
            c1.b r9 = c1.C1045b.f4747a
            r0.f4565a = r8
            r0.f4568d = r6
            java.lang.Object r9 = r9.c(r0)
            if (r9 != r1) goto L_0x0053
            goto L_0x008c
        L_0x0053:
            r2 = r8
        L_0x0054:
            java.util.Map r9 = (java.util.Map) r9
            java.util.Collection r9 = r9.values()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            boolean r7 = r9 instanceof java.util.Collection
            if (r7 == 0) goto L_0x006a
            r7 = r9
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x006a
            goto L_0x00b5
        L_0x006a:
            java.util.Iterator r9 = r9.iterator()
        L_0x006e:
            boolean r7 = r9.hasNext()
            if (r7 == 0) goto L_0x00b5
            java.lang.Object r7 = r9.next()
            c1.c r7 = (c1.C1046c) r7
            boolean r7 = r7.a()
            if (r7 == 0) goto L_0x006e
            e1.j r9 = r2.f4553c
            r0.f4565a = r2
            r0.f4568d = r3
            java.lang.Object r9 = r9.f(r0)
            if (r9 != r1) goto L_0x008d
        L_0x008c:
            return r1
        L_0x008d:
            r0 = r2
        L_0x008e:
            e1.j r9 = r0.f4553c
            boolean r9 = r9.c()
            if (r9 != 0) goto L_0x00a0
            java.lang.String r9 = "Sessions SDK disabled through settings API. Events will not be sent."
            android.util.Log.d(r5, r9)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.b.a(r4)
            return r9
        L_0x00a0:
            boolean r9 = r0.h()
            if (r9 != 0) goto L_0x00b0
            java.lang.String r9 = "Sessions SDK has dropped this session due to sampling."
            android.util.Log.d(r5, r9)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.b.a(r4)
            return r9
        L_0x00b0:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.b.a(r6)
            return r9
        L_0x00b5:
            java.lang.String r9 = "Sessions SDK disabled through data collection. Events will not be sent."
            android.util.Log.d(r5, r9)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.b.a(r4)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.O.i(b3.e):java.lang.Object");
    }

    public void a(K k5) {
        t.e(k5, "sessionDetails");
        C2908y0 unused = C2876i.d(N.a(this.f4555e), (C2312i) null, (w3.O) null, new b(this, k5, (C2308e) null), 3, (Object) null);
    }
}
