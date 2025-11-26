package z3;

import A3.r;
import W2.J;
import b3.C2308e;
import c3.C2316b;
import k3.l;
import k3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.L;

/* renamed from: z3.d  reason: case insensitive filesystem */
final class C2971d implements C2972e {

    /* renamed from: a  reason: collision with root package name */
    private final C2972e f26615a;

    /* renamed from: b  reason: collision with root package name */
    public final l f26616b;

    /* renamed from: c  reason: collision with root package name */
    public final p f26617c;

    /* renamed from: z3.d$a */
    static final class a implements C2973f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2971d f26618a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ L f26619b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2973f f26620c;

        /* renamed from: z3.d$a$a  reason: collision with other inner class name */
        static final class C0268a extends d {

            /* renamed from: a  reason: collision with root package name */
            /* synthetic */ Object f26621a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f26622b;

            /* renamed from: c  reason: collision with root package name */
            int f26623c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0268a(a aVar, C2308e eVar) {
                super(eVar);
                this.f26622b = aVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f26621a = obj;
                this.f26623c |= Integer.MIN_VALUE;
                return this.f26622b.emit((Object) null, this);
            }
        }

        a(C2971d dVar, L l5, C2973f fVar) {
            this.f26618a = dVar;
            this.f26619b = l5;
            this.f26620c = fVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object emit(java.lang.Object r6, b3.C2308e r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof z3.C2971d.a.C0268a
                if (r0 == 0) goto L_0x0013
                r0 = r7
                z3.d$a$a r0 = (z3.C2971d.a.C0268a) r0
                int r1 = r0.f26623c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f26623c = r1
                goto L_0x0018
            L_0x0013:
                z3.d$a$a r0 = new z3.d$a$a
                r0.<init>(r5, r7)
            L_0x0018:
                java.lang.Object r7 = r0.f26621a
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f26623c
                r3 = 1
                if (r2 == 0) goto L_0x0031
                if (r2 != r3) goto L_0x0029
                W2.u.b(r7)
                goto L_0x0067
            L_0x0029:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L_0x0031:
                W2.u.b(r7)
                z3.d r7 = r5.f26618a
                k3.l r7 = r7.f26616b
                java.lang.Object r7 = r7.invoke(r6)
                kotlin.jvm.internal.L r2 = r5.f26619b
                java.lang.Object r2 = r2.f24690a
                B3.D r4 = A3.r.f17311a
                if (r2 == r4) goto L_0x0058
                z3.d r4 = r5.f26618a
                k3.p r4 = r4.f26617c
                java.lang.Object r2 = r4.invoke(r2, r7)
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 != 0) goto L_0x0055
                goto L_0x0058
            L_0x0055:
                W2.J r6 = W2.J.f19942a
                return r6
            L_0x0058:
                kotlin.jvm.internal.L r2 = r5.f26619b
                r2.f24690a = r7
                z3.f r7 = r5.f26620c
                r0.f26623c = r3
                java.lang.Object r6 = r7.emit(r6, r0)
                if (r6 != r1) goto L_0x0067
                return r1
            L_0x0067:
                W2.J r6 = W2.J.f19942a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: z3.C2971d.a.emit(java.lang.Object, b3.e):java.lang.Object");
        }
    }

    public C2971d(C2972e eVar, l lVar, p pVar) {
        this.f26615a = eVar;
        this.f26616b = lVar;
        this.f26617c = pVar;
    }

    public Object collect(C2973f fVar, C2308e eVar) {
        L l5 = new L();
        l5.f24690a = r.f17311a;
        Object collect = this.f26615a.collect(new a(this, l5, fVar), eVar);
        if (collect == C2316b.f()) {
            return collect;
        }
        return J.f19942a;
    }
}
