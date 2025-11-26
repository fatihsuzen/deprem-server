package e1;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import u3.C2795a;
import u3.C2797c;
import u3.C2798d;

public final class j {

    /* renamed from: c  reason: collision with root package name */
    public static final a f15274c = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final o f15275a;

    /* renamed from: b  reason: collision with root package name */
    private final o f15276b;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f15277a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f15278b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ j f15279c;

        /* renamed from: d  reason: collision with root package name */
        int f15280d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(j jVar, C2308e eVar) {
            super(eVar);
            this.f15279c = jVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f15278b = obj;
            this.f15280d |= Integer.MIN_VALUE;
            return this.f15279c.f(this);
        }
    }

    public j(o oVar, o oVar2) {
        t.e(oVar, "localOverrideSettings");
        t.e(oVar2, "remoteSettings");
        this.f15275a = oVar;
        this.f15276b = oVar2;
    }

    private final boolean d(double d5) {
        if (0.0d > d5 || d5 > 1.0d) {
            return false;
        }
        return true;
    }

    private final boolean e(long j5) {
        if (!C2795a.E(j5) || !C2795a.w(j5)) {
            return false;
        }
        return true;
    }

    public final double a() {
        Double d5 = this.f15275a.d();
        if (d5 != null) {
            double doubleValue = d5.doubleValue();
            if (d(doubleValue)) {
                return doubleValue;
            }
        }
        Double d6 = this.f15276b.d();
        if (d6 == null) {
            return 1.0d;
        }
        double doubleValue2 = d6.doubleValue();
        if (d(doubleValue2)) {
            return doubleValue2;
        }
        return 1.0d;
    }

    public final long b() {
        C2795a c5 = this.f15275a.c();
        if (c5 != null) {
            long K4 = c5.K();
            if (e(K4)) {
                return K4;
            }
        }
        C2795a c6 = this.f15276b.c();
        if (c6 != null) {
            long K5 = c6.K();
            if (e(K5)) {
                return K5;
            }
        }
        C2795a.C0262a aVar = C2795a.f25994b;
        return C2797c.s(30, C2798d.MINUTES);
    }

    public final boolean c() {
        Boolean b5 = this.f15275a.b();
        if (b5 != null) {
            return b5.booleanValue();
        }
        Boolean b6 = this.f15276b.b();
        if (b6 != null) {
            return b6.booleanValue();
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        if (r6.a(r0) != r1) goto L_0x005b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(b3.C2308e r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof e1.j.b
            if (r0 == 0) goto L_0x0013
            r0 = r6
            e1.j$b r0 = (e1.j.b) r0
            int r1 = r0.f15280d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f15280d = r1
            goto L_0x0018
        L_0x0013:
            e1.j$b r0 = new e1.j$b
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f15278b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f15280d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            W2.u.b(r6)
            goto L_0x005b
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0034:
            java.lang.Object r2 = r0.f15277a
            e1.j r2 = (e1.j) r2
            W2.u.b(r6)
            goto L_0x004d
        L_0x003c:
            W2.u.b(r6)
            e1.o r6 = r5.f15275a
            r0.f15277a = r5
            r0.f15280d = r4
            java.lang.Object r6 = r6.a(r0)
            if (r6 != r1) goto L_0x004c
            goto L_0x005a
        L_0x004c:
            r2 = r5
        L_0x004d:
            e1.o r6 = r2.f15276b
            r2 = 0
            r0.f15277a = r2
            r0.f15280d = r3
            java.lang.Object r6 = r6.a(r0)
            if (r6 != r1) goto L_0x005b
        L_0x005a:
            return r1
        L_0x005b:
            W2.J r6 = W2.J.f19942a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.j.f(b3.e):java.lang.Object");
    }
}
