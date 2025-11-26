package z3;

import W2.J;
import b3.C2308e;
import c3.C2316b;
import kotlin.coroutines.jvm.internal.d;
import y3.x;

abstract /* synthetic */ class i {

    static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f26624a;

        /* renamed from: b  reason: collision with root package name */
        Object f26625b;

        /* renamed from: c  reason: collision with root package name */
        Object f26626c;

        /* renamed from: d  reason: collision with root package name */
        boolean f26627d;

        /* renamed from: e  reason: collision with root package name */
        /* synthetic */ Object f26628e;

        /* renamed from: f  reason: collision with root package name */
        int f26629f;

        a(C2308e eVar) {
            super(eVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f26628e = obj;
            this.f26629f |= Integer.MIN_VALUE;
            return i.c((C2973f) null, (x) null, false, this);
        }
    }

    public static final Object b(C2973f fVar, x xVar, C2308e eVar) {
        Object c5 = c(fVar, xVar, true, eVar);
        if (c5 == C2316b.f()) {
            return c5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r2.emit(r9, r0) == r1) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009e, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009f, code lost:
        if (r8 != false) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a1, code lost:
        y3.n.a(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a4, code lost:
        throw r9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072 A[Catch:{ all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073 A[Catch:{ all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007f A[Catch:{ all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(z3.C2973f r6, y3.x r7, boolean r8, b3.C2308e r9) {
        /*
            boolean r0 = r9 instanceof z3.i.a
            if (r0 == 0) goto L_0x0013
            r0 = r9
            z3.i$a r0 = (z3.i.a) r0
            int r1 = r0.f26629f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26629f = r1
            goto L_0x0018
        L_0x0013:
            z3.i$a r0 = new z3.i$a
            r0.<init>(r9)
        L_0x0018:
            java.lang.Object r9 = r0.f26628e
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f26629f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0058
            if (r2 == r4) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            boolean r8 = r0.f26627d
            java.lang.Object r6 = r0.f26626c
            y3.i r6 = (y3.C2936i) r6
            java.lang.Object r7 = r0.f26625b
            y3.x r7 = (y3.x) r7
            java.lang.Object r2 = r0.f26624a
            z3.f r2 = (z3.C2973f) r2
            W2.u.b(r9)     // Catch:{ all -> 0x003c }
        L_0x0039:
            r9 = r6
            r6 = r2
            goto L_0x0062
        L_0x003c:
            r6 = move-exception
            goto L_0x009d
        L_0x003e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0046:
            boolean r8 = r0.f26627d
            java.lang.Object r6 = r0.f26626c
            y3.i r6 = (y3.C2936i) r6
            java.lang.Object r7 = r0.f26625b
            y3.x r7 = (y3.x) r7
            java.lang.Object r2 = r0.f26624a
            z3.f r2 = (z3.C2973f) r2
            W2.u.b(r9)     // Catch:{ all -> 0x003c }
            goto L_0x0077
        L_0x0058:
            W2.u.b(r9)
            z3.C2974g.n(r6)
            y3.i r9 = r7.iterator()     // Catch:{ all -> 0x003c }
        L_0x0062:
            r0.f26624a = r6     // Catch:{ all -> 0x003c }
            r0.f26625b = r7     // Catch:{ all -> 0x003c }
            r0.f26626c = r9     // Catch:{ all -> 0x003c }
            r0.f26627d = r8     // Catch:{ all -> 0x003c }
            r0.f26629f = r4     // Catch:{ all -> 0x003c }
            java.lang.Object r2 = r9.b(r0)     // Catch:{ all -> 0x003c }
            if (r2 != r1) goto L_0x0073
            goto L_0x0093
        L_0x0073:
            r5 = r2
            r2 = r6
            r6 = r9
            r9 = r5
        L_0x0077:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x003c }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x003c }
            if (r9 == 0) goto L_0x0094
            java.lang.Object r9 = r6.next()     // Catch:{ all -> 0x003c }
            r0.f26624a = r2     // Catch:{ all -> 0x003c }
            r0.f26625b = r7     // Catch:{ all -> 0x003c }
            r0.f26626c = r6     // Catch:{ all -> 0x003c }
            r0.f26627d = r8     // Catch:{ all -> 0x003c }
            r0.f26629f = r3     // Catch:{ all -> 0x003c }
            java.lang.Object r9 = r2.emit(r9, r0)     // Catch:{ all -> 0x003c }
            if (r9 != r1) goto L_0x0039
        L_0x0093:
            return r1
        L_0x0094:
            if (r8 == 0) goto L_0x009a
            r6 = 0
            y3.n.a(r7, r6)
        L_0x009a:
            W2.J r6 = W2.J.f19942a
            return r6
        L_0x009d:
            throw r6     // Catch:{ all -> 0x009e }
        L_0x009e:
            r9 = move-exception
            if (r8 == 0) goto L_0x00a4
            y3.n.a(r7, r6)
        L_0x00a4:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.i.c(z3.f, y3.x, boolean, b3.e):java.lang.Object");
    }
}
