package z3;

import W2.J;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.d;

abstract /* synthetic */ class u {

    public static final class a implements C2972e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2972e f26712a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f26713b;

        /* renamed from: z3.u$a$a  reason: collision with other inner class name */
        public static final class C0270a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2973f f26714a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ p f26715b;

            /* renamed from: z3.u$a$a$a  reason: collision with other inner class name */
            public static final class C0271a extends d {

                /* renamed from: a  reason: collision with root package name */
                /* synthetic */ Object f26716a;

                /* renamed from: b  reason: collision with root package name */
                int f26717b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ C0270a f26718c;

                /* renamed from: d  reason: collision with root package name */
                Object f26719d;

                /* renamed from: e  reason: collision with root package name */
                Object f26720e;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0271a(C0270a aVar, C2308e eVar) {
                    super(eVar);
                    this.f26718c = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f26716a = obj;
                    this.f26717b |= Integer.MIN_VALUE;
                    return this.f26718c.emit((Object) null, this);
                }
            }

            public C0270a(C2973f fVar, p pVar) {
                this.f26714a = fVar;
                this.f26715b = pVar;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:18:0x0067, code lost:
                if (r6.emit(r2, r0) != r1) goto L_0x006a;
             */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r6, b3.C2308e r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof z3.u.a.C0270a.C0271a
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    z3.u$a$a$a r0 = (z3.u.a.C0270a.C0271a) r0
                    int r1 = r0.f26717b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f26717b = r1
                    goto L_0x0018
                L_0x0013:
                    z3.u$a$a$a r0 = new z3.u$a$a$a
                    r0.<init>(r5, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.f26716a
                    java.lang.Object r1 = c3.C2316b.f()
                    int r2 = r0.f26717b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x003e
                    if (r2 == r4) goto L_0x0034
                    if (r2 != r3) goto L_0x002c
                    W2.u.b(r7)
                    goto L_0x006a
                L_0x002c:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L_0x0034:
                    java.lang.Object r6 = r0.f26720e
                    z3.f r6 = (z3.C2973f) r6
                    java.lang.Object r2 = r0.f26719d
                    W2.u.b(r7)
                    goto L_0x005c
                L_0x003e:
                    W2.u.b(r7)
                    z3.f r7 = r5.f26714a
                    k3.p r2 = r5.f26715b
                    r0.f26719d = r6
                    r0.f26720e = r7
                    r0.f26717b = r4
                    r4 = 6
                    kotlin.jvm.internal.r.c(r4)
                    java.lang.Object r2 = r2.invoke(r6, r0)
                    r4 = 7
                    kotlin.jvm.internal.r.c(r4)
                    if (r2 != r1) goto L_0x005a
                    goto L_0x0069
                L_0x005a:
                    r2 = r6
                    r6 = r7
                L_0x005c:
                    r7 = 0
                    r0.f26719d = r7
                    r0.f26720e = r7
                    r0.f26717b = r3
                    java.lang.Object r6 = r6.emit(r2, r0)
                    if (r6 != r1) goto L_0x006a
                L_0x0069:
                    return r1
                L_0x006a:
                    W2.J r6 = W2.J.f19942a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: z3.u.a.C0270a.emit(java.lang.Object, b3.e):java.lang.Object");
            }
        }

        public a(C2972e eVar, p pVar) {
            this.f26712a = eVar;
            this.f26713b = pVar;
        }

        public Object collect(C2973f fVar, C2308e eVar) {
            Object collect = this.f26712a.collect(new C0270a(fVar, this.f26713b), eVar);
            if (collect == C2316b.f()) {
                return collect;
            }
            return J.f19942a;
        }
    }

    public static final C2972e a(C2972e eVar, p pVar) {
        return new a(eVar, pVar);
    }
}
