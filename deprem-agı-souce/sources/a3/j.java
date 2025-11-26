package A3;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import java.util.concurrent.atomic.AtomicInteger;
import k3.C2616a;
import k3.p;
import k3.q;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.l;
import w3.M;
import y3.C2934g;
import y3.y;
import z3.C2972e;
import z3.C2973f;

public abstract class j {

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f17286a;

        /* renamed from: b  reason: collision with root package name */
        Object f17287b;

        /* renamed from: c  reason: collision with root package name */
        int f17288c;

        /* renamed from: d  reason: collision with root package name */
        int f17289d;

        /* renamed from: e  reason: collision with root package name */
        int f17290e;

        /* renamed from: f  reason: collision with root package name */
        private /* synthetic */ Object f17291f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ C2972e[] f17292g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ C2616a f17293h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ q f17294i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ C2973f f17295j;

        /* renamed from: A3.j$a$a  reason: collision with other inner class name */
        static final class C0171a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f17296a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2972e[] f17297b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f17298c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ AtomicInteger f17299d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ C2934g f17300e;

            /* renamed from: A3.j$a$a$a  reason: collision with other inner class name */
            static final class C0172a implements C2973f {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ C2934g f17301a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ int f17302b;

                /* renamed from: A3.j$a$a$a$a  reason: collision with other inner class name */
                static final class C0173a extends d {

                    /* renamed from: a  reason: collision with root package name */
                    /* synthetic */ Object f17303a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ C0172a f17304b;

                    /* renamed from: c  reason: collision with root package name */
                    int f17305c;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    C0173a(C0172a aVar, C2308e eVar) {
                        super(eVar);
                        this.f17304b = aVar;
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.f17303a = obj;
                        this.f17305c |= Integer.MIN_VALUE;
                        return this.f17304b.emit((Object) null, this);
                    }
                }

                C0172a(C2934g gVar, int i5) {
                    this.f17301a = gVar;
                    this.f17302b = i5;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
                    if (r8.e(r2, r0) == r1) goto L_0x0055;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
                    if (w3.f1.a(r0) != r1) goto L_0x0056;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
                    return r1;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(java.lang.Object r7, b3.C2308e r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof A3.j.a.C0171a.C0172a.C0173a
                        if (r0 == 0) goto L_0x0013
                        r0 = r8
                        A3.j$a$a$a$a r0 = (A3.j.a.C0171a.C0172a.C0173a) r0
                        int r1 = r0.f17305c
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.f17305c = r1
                        goto L_0x0018
                    L_0x0013:
                        A3.j$a$a$a$a r0 = new A3.j$a$a$a$a
                        r0.<init>(r6, r8)
                    L_0x0018:
                        java.lang.Object r8 = r0.f17303a
                        java.lang.Object r1 = c3.C2316b.f()
                        int r2 = r0.f17305c
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L_0x0038
                        if (r2 == r4) goto L_0x0034
                        if (r2 != r3) goto L_0x002c
                        W2.u.b(r8)
                        goto L_0x0056
                    L_0x002c:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L_0x0034:
                        W2.u.b(r8)
                        goto L_0x004d
                    L_0x0038:
                        W2.u.b(r8)
                        y3.g r8 = r6.f17301a
                        X2.G r2 = new X2.G
                        int r5 = r6.f17302b
                        r2.<init>(r5, r7)
                        r0.f17305c = r4
                        java.lang.Object r7 = r8.e(r2, r0)
                        if (r7 != r1) goto L_0x004d
                        goto L_0x0055
                    L_0x004d:
                        r0.f17305c = r3
                        java.lang.Object r7 = w3.f1.a(r0)
                        if (r7 != r1) goto L_0x0056
                    L_0x0055:
                        return r1
                    L_0x0056:
                        W2.J r7 = W2.J.f19942a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: A3.j.a.C0171a.C0172a.emit(java.lang.Object, b3.e):java.lang.Object");
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0171a(C2972e[] eVarArr, int i5, AtomicInteger atomicInteger, C2934g gVar, C2308e eVar) {
                super(2, eVar);
                this.f17297b = eVarArr;
                this.f17298c = i5;
                this.f17299d = atomicInteger;
                this.f17300e = gVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0171a(this.f17297b, this.f17298c, this.f17299d, this.f17300e, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object f5 = C2316b.f();
                int i5 = this.f17296a;
                if (i5 == 0) {
                    u.b(obj);
                    C2972e[] eVarArr = this.f17297b;
                    int i6 = this.f17298c;
                    C2972e eVar = eVarArr[i6];
                    C0172a aVar = new C0172a(this.f17300e, i6);
                    this.f17296a = 1;
                    if (eVar.collect(aVar, this) == f5) {
                        return f5;
                    }
                } else if (i5 == 1) {
                    try {
                        u.b(obj);
                    } catch (Throwable th) {
                        if (this.f17299d.decrementAndGet() == 0) {
                            y.a.a(this.f17300e, (Throwable) null, 1, (Object) null);
                        }
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (this.f17299d.decrementAndGet() == 0) {
                    y.a.a(this.f17300e, (Throwable) null, 1, (Object) null);
                }
                return J.f19942a;
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0171a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2972e[] eVarArr, C2616a aVar, q qVar, C2973f fVar, C2308e eVar) {
            super(2, eVar);
            this.f17292g = eVarArr;
            this.f17293h = aVar;
            this.f17294i = qVar;
            this.f17295j = fVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            a aVar = new a(this.f17292g, this.f17293h, this.f17294i, this.f17295j, eVar);
            aVar.f17291f = obj;
            return aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0106, code lost:
            if (r10.invoke(r11, r9, r0) == r1) goto L_0x0128;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0126, code lost:
            if (r11.invoke(r12, r10, r0) == r1) goto L_0x0128;
         */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00c1 A[LOOP:1: B:24:0x00c1->B:30:0x00e4, LOOP_START, PHI: r6 r10 
          PHI: (r6v3 int) = (r6v2 int), (r6v4 int) binds: [B:21:0x00bc, B:30:0x00e4] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r10v3 X2.G) = (r10v2 X2.G), (r10v16 X2.G) binds: [B:21:0x00bc, B:30:0x00e4] A[DONT_GENERATE, DONT_INLINE]] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                r21 = this;
                r0 = r21
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f17290e
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L_0x004e
                if (r2 == r5) goto L_0x0031
                if (r2 == r4) goto L_0x001c
                if (r2 != r3) goto L_0x0014
                goto L_0x001c
            L_0x0014:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x001c:
                int r2 = r0.f17289d
                int r6 = r0.f17288c
                java.lang.Object r7 = r0.f17287b
                byte[] r7 = (byte[]) r7
                java.lang.Object r8 = r0.f17286a
                y3.g r8 = (y3.C2934g) r8
                java.lang.Object r9 = r0.f17291f
                java.lang.Object[] r9 = (java.lang.Object[]) r9
                W2.u.b(r22)
                goto L_0x0129
            L_0x0031:
                int r2 = r0.f17289d
                int r6 = r0.f17288c
                java.lang.Object r7 = r0.f17287b
                byte[] r7 = (byte[]) r7
                java.lang.Object r8 = r0.f17286a
                y3.g r8 = (y3.C2934g) r8
                java.lang.Object r9 = r0.f17291f
                java.lang.Object[] r9 = (java.lang.Object[]) r9
                W2.u.b(r22)
                r10 = r22
                y3.k r10 = (y3.C2938k) r10
                java.lang.Object r10 = r10.k()
                goto L_0x00b6
            L_0x004e:
                W2.u.b(r22)
                java.lang.Object r2 = r0.f17291f
                r6 = r2
                w3.M r6 = (w3.M) r6
                z3.e[] r2 = r0.f17292g
                int r2 = r2.length
                if (r2 != 0) goto L_0x005e
                W2.J r1 = W2.J.f19942a
                return r1
            L_0x005e:
                java.lang.Object[] r7 = new java.lang.Object[r2]
                B3.D r8 = A3.r.f17312b
                r11 = 6
                r12 = 0
                r9 = 0
                r10 = 0
                X2.C2242i.z(r7, r8, r9, r10, r11, r12)
                r12 = r7
                r7 = 6
                r8 = 0
                y3.g r17 = y3.C2937j.b(r2, r8, r8, r7, r8)
                java.util.concurrent.atomic.AtomicInteger r7 = new java.util.concurrent.atomic.AtomicInteger
                r7.<init>(r2)
                r19 = 0
                r15 = r19
            L_0x0079:
                if (r15 >= r2) goto L_0x0093
                A3.j$a$a r9 = new A3.j$a$a
                z3.e[] r14 = r0.f17292g
                r18 = 0
                r16 = r7
                r13 = r9
                r13.<init>(r14, r15, r16, r17, r18)
                r10 = 3
                r11 = 0
                r7 = 0
                r8 = 0
                w3.C2908y0 unused = w3.C2876i.d(r6, r7, r8, r9, r10, r11)
                int r15 = r15 + 1
                r7 = r16
                goto L_0x0079
            L_0x0093:
                byte[] r6 = new byte[r2]
                r7 = r12
                r8 = r17
            L_0x0098:
                int r9 = r19 + 1
                byte r9 = (byte) r9
                r0.f17291f = r7
                r0.f17286a = r8
                r0.f17287b = r6
                r0.f17288c = r2
                r0.f17289d = r9
                r0.f17290e = r5
                java.lang.Object r10 = r8.b(r0)
                if (r10 != r1) goto L_0x00af
                goto L_0x0128
            L_0x00af:
                r20 = r6
                r6 = r2
                r2 = r9
                r9 = r7
                r7 = r20
            L_0x00b6:
                java.lang.Object r10 = y3.C2938k.f(r10)
                X2.G r10 = (X2.G) r10
                if (r10 != 0) goto L_0x00c1
                W2.J r1 = W2.J.f19942a
                return r1
            L_0x00c1:
                int r11 = r10.a()
                r12 = r9[r11]
                java.lang.Object r10 = r10.b()
                r9[r11] = r10
                B3.D r10 = A3.r.f17312b
                if (r12 != r10) goto L_0x00d3
                int r6 = r6 + -1
            L_0x00d3:
                byte r10 = r7[r11]
                if (r10 == r2) goto L_0x00e6
                byte r10 = (byte) r2
                r7[r11] = r10
                java.lang.Object r10 = r8.f()
                java.lang.Object r10 = y3.C2938k.f(r10)
                X2.G r10 = (X2.G) r10
                if (r10 != 0) goto L_0x00c1
            L_0x00e6:
                if (r6 != 0) goto L_0x0129
                k3.a r10 = r0.f17293h
                java.lang.Object r10 = r10.invoke()
                java.lang.Object[] r10 = (java.lang.Object[]) r10
                if (r10 != 0) goto L_0x0109
                k3.q r10 = r0.f17294i
                z3.f r11 = r0.f17295j
                r0.f17291f = r9
                r0.f17286a = r8
                r0.f17287b = r7
                r0.f17288c = r6
                r0.f17289d = r2
                r0.f17290e = r4
                java.lang.Object r10 = r10.invoke(r11, r9, r0)
                if (r10 != r1) goto L_0x0129
                goto L_0x0128
            L_0x0109:
                r14 = 14
                r15 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                X2.C2242i.q(r9, r10, r11, r12, r13, r14, r15)
                k3.q r11 = r0.f17294i
                z3.f r12 = r0.f17295j
                r0.f17291f = r9
                r0.f17286a = r8
                r0.f17287b = r7
                r0.f17288c = r6
                r0.f17289d = r2
                r0.f17290e = r3
                java.lang.Object r10 = r11.invoke(r12, r10, r0)
                if (r10 != r1) goto L_0x0129
            L_0x0128:
                return r1
            L_0x0129:
                r19 = r2
                r2 = r6
                r6 = r7
                r7 = r9
                goto L_0x0098
            */
            throw new UnsupportedOperationException("Method not decompiled: A3.j.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final Object a(C2973f fVar, C2972e[] eVarArr, C2616a aVar, q qVar, C2308e eVar) {
        Object a5 = m.a(new a(eVarArr, aVar, qVar, fVar, (C2308e) null), eVar);
        if (a5 == C2316b.f()) {
            return a5;
        }
        return J.f19942a;
    }
}
