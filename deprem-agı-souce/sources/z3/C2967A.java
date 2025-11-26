package z3;

import A3.o;
import B3.D;
import W2.J;
import W2.q;
import W2.t;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.t;
import w3.C2869e0;
import w3.C2886n;
import y3.C2928a;

/* renamed from: z3.A  reason: case insensitive filesystem */
public class C2967A extends A3.b implements v, C2972e, o {

    /* renamed from: d  reason: collision with root package name */
    private final int f26568d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final int f26569e;

    /* renamed from: f  reason: collision with root package name */
    private final C2928a f26570f;

    /* renamed from: g  reason: collision with root package name */
    private Object[] f26571g;

    /* renamed from: h  reason: collision with root package name */
    private long f26572h;

    /* renamed from: i  reason: collision with root package name */
    private long f26573i;

    /* renamed from: j  reason: collision with root package name */
    private int f26574j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public int f26575k;

    /* renamed from: z3.A$a */
    private static final class a implements C2869e0 {

        /* renamed from: a  reason: collision with root package name */
        public final C2967A f26576a;

        /* renamed from: b  reason: collision with root package name */
        public long f26577b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f26578c;

        /* renamed from: d  reason: collision with root package name */
        public final C2308e f26579d;

        public a(C2967A a5, long j5, Object obj, C2308e eVar) {
            this.f26576a = a5;
            this.f26577b = j5;
            this.f26578c = obj;
            this.f26579d = eVar;
        }

        public void dispose() {
            this.f26576a.v(this);
        }
    }

    /* renamed from: z3.A$b */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26580a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                y3.a[] r0 = y3.C2928a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                y3.a r1 = y3.C2928a.SUSPEND     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                y3.a r1 = y3.C2928a.DROP_LATEST     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                y3.a r1 = y3.C2928a.DROP_OLDEST     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f26580a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: z3.C2967A.b.<clinit>():void");
        }
    }

    /* renamed from: z3.A$c */
    static final class c extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f26581a;

        /* renamed from: b  reason: collision with root package name */
        Object f26582b;

        /* renamed from: c  reason: collision with root package name */
        Object f26583c;

        /* renamed from: d  reason: collision with root package name */
        Object f26584d;

        /* renamed from: e  reason: collision with root package name */
        /* synthetic */ Object f26585e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ C2967A f26586f;

        /* renamed from: g  reason: collision with root package name */
        int f26587g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2967A a5, C2308e eVar) {
            super(eVar);
            this.f26586f = a5;
        }

        public final Object invokeSuspend(Object obj) {
            this.f26585e = obj;
            this.f26587g |= Integer.MIN_VALUE;
            return C2967A.x(this.f26586f, (C2973f) null, this);
        }
    }

    public C2967A(int i5, int i6, C2928a aVar) {
        this.f26568d = i5;
        this.f26569e = i6;
        this.f26570f = aVar;
    }

    private final void B() {
        Object[] objArr = this.f26571g;
        t.b(objArr);
        B.f(objArr, H(), (Object) null);
        this.f26574j--;
        long H4 = H() + 1;
        if (this.f26572h < H4) {
            this.f26572h = H4;
        }
        if (this.f26573i < H4) {
            y(H4);
        }
    }

    static /* synthetic */ Object C(C2967A a5, Object obj, C2308e eVar) {
        if (a5.N(obj)) {
            return J.f19942a;
        }
        Object D4 = a5.D(obj, eVar);
        if (D4 == C2316b.f()) {
            return D4;
        }
        return J.f19942a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        if (r0 == null) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        w3.C2890p.a(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        r0 = r9.length;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r2 >= r0) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0062, code lost:
        r3 = r9[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        if (r3 == null) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
        r4 = W2.t.f19966b;
        r3.resumeWith(W2.t.b(W2.J.f19942a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0071, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0074, code lost:
        r9 = r5.x();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007c, code lost:
        if (r9 != c3.C2316b.f()) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007e, code lost:
        kotlin.coroutines.jvm.internal.h.c(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0085, code lost:
        if (r9 != c3.C2316b.f()) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0087, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008a, code lost:
        return W2.J.f19942a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object D(java.lang.Object r9, b3.C2308e r10) {
        /*
            r8 = this;
            w3.n r5 = new w3.n
            b3.e r0 = c3.C2316b.c(r10)
            r6 = 1
            r5.<init>(r0, r6)
            r5.D()
            b3.e[] r7 = A3.c.f17267a
            monitor-enter(r8)
            boolean r0 = r8.O(r9)     // Catch:{ all -> 0x008b }
            if (r0 == 0) goto L_0x002c
            W2.t$a r9 = W2.t.f19966b     // Catch:{ all -> 0x0028 }
            W2.J r9 = W2.J.f19942a     // Catch:{ all -> 0x0028 }
            java.lang.Object r9 = W2.t.b(r9)     // Catch:{ all -> 0x0028 }
            r5.resumeWith(r9)     // Catch:{ all -> 0x0028 }
            b3.e[] r9 = r8.F(r7)     // Catch:{ all -> 0x0028 }
            r0 = 0
            r1 = r8
            goto L_0x0058
        L_0x0028:
            r0 = move-exception
            r9 = r0
            r1 = r8
            goto L_0x008e
        L_0x002c:
            z3.A$a r0 = new z3.A$a     // Catch:{ all -> 0x008b }
            long r1 = r8.H()     // Catch:{ all -> 0x008b }
            int r3 = r8.L()     // Catch:{ all -> 0x008b }
            long r3 = (long) r3
            long r1 = r1 + r3
            r4 = r9
            r2 = r1
            r1 = r8
            r0.<init>(r1, r2, r4, r5)     // Catch:{ all -> 0x0054 }
            r8.E(r0)     // Catch:{ all -> 0x0054 }
            int r9 = r8.f26575k     // Catch:{ all -> 0x0054 }
            int r9 = r9 + r6
            r8.f26575k = r9     // Catch:{ all -> 0x0054 }
            int r9 = r8.f26569e     // Catch:{ all -> 0x0054 }
            if (r9 != 0) goto L_0x0057
            b3.e[] r7 = r8.F(r7)     // Catch:{ all -> 0x0054 }
            goto L_0x0057
        L_0x0054:
            r0 = move-exception
        L_0x0055:
            r9 = r0
            goto L_0x008e
        L_0x0057:
            r9 = r7
        L_0x0058:
            monitor-exit(r8)
            if (r0 == 0) goto L_0x005e
            w3.C2890p.a(r5, r0)
        L_0x005e:
            int r0 = r9.length
            r2 = 0
        L_0x0060:
            if (r2 >= r0) goto L_0x0074
            r3 = r9[r2]
            if (r3 == 0) goto L_0x0071
            W2.t$a r4 = W2.t.f19966b
            W2.J r4 = W2.J.f19942a
            java.lang.Object r4 = W2.t.b(r4)
            r3.resumeWith(r4)
        L_0x0071:
            int r2 = r2 + 1
            goto L_0x0060
        L_0x0074:
            java.lang.Object r9 = r5.x()
            java.lang.Object r0 = c3.C2316b.f()
            if (r9 != r0) goto L_0x0081
            kotlin.coroutines.jvm.internal.h.c(r10)
        L_0x0081:
            java.lang.Object r10 = c3.C2316b.f()
            if (r9 != r10) goto L_0x0088
            return r9
        L_0x0088:
            W2.J r9 = W2.J.f19942a
            return r9
        L_0x008b:
            r0 = move-exception
            r1 = r8
            goto L_0x0055
        L_0x008e:
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.C2967A.D(java.lang.Object, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void E(Object obj) {
        int L4 = L();
        Object[] objArr = this.f26571g;
        if (objArr == null) {
            objArr = M((Object[]) null, 0, 2);
        } else if (L4 >= objArr.length) {
            objArr = M(objArr, L4, objArr.length * 2);
        }
        B.f(objArr, H() + ((long) L4), obj);
    }

    /* JADX WARNING: type inference failed for: r11v6, types: [java.lang.Object[], java.lang.Object] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        r4 = (z3.C) r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final b3.C2308e[] F(b3.C2308e[] r11) {
        /*
            r10 = this;
            int r0 = r11.length
            int r1 = r10.f17265b
            if (r1 == 0) goto L_0x0047
            A3.d[] r1 = r10.f17264a
            if (r1 == 0) goto L_0x0047
            int r2 = r1.length
            r3 = 0
        L_0x000f:
            if (r3 >= r2) goto L_0x0047
            r4 = r1[r3]
            if (r4 == 0) goto L_0x0044
            z3.C r4 = (z3.C) r4
            b3.e r5 = r4.f26590b
            if (r5 != 0) goto L_0x001c
            goto L_0x0044
        L_0x001c:
            long r6 = r10.Q(r4)
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x0044
            int r6 = r11.length
            if (r0 < r6) goto L_0x0039
            int r6 = r11.length
            r7 = 2
            int r6 = r6 * r7
            int r6 = java.lang.Math.max(r7, r6)
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r6)
            java.lang.String r6 = "copyOf(...)"
            kotlin.jvm.internal.t.d(r11, r6)
        L_0x0039:
            r6 = r11
            b3.e[] r6 = (b3.C2308e[]) r6
            int r7 = r0 + 1
            r6[r0] = r5
            r0 = 0
            r4.f26590b = r0
            r0 = r7
        L_0x0044:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0047:
            b3.e[] r11 = (b3.C2308e[]) r11
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.C2967A.F(b3.e[]):b3.e[]");
    }

    private final long G() {
        return H() + ((long) this.f26574j);
    }

    /* access modifiers changed from: private */
    public final long H() {
        return Math.min(this.f26573i, this.f26572h);
    }

    private final Object I(long j5) {
        Object[] objArr = this.f26571g;
        t.b(objArr);
        Object b5 = B.e(objArr, j5);
        if (b5 instanceof a) {
            return ((a) b5).f26578c;
        }
        return b5;
    }

    private final long J() {
        return H() + ((long) this.f26574j) + ((long) this.f26575k);
    }

    private final int K() {
        return (int) ((H() + ((long) this.f26574j)) - this.f26572h);
    }

    /* access modifiers changed from: private */
    public final int L() {
        return this.f26574j + this.f26575k;
    }

    private final Object[] M(Object[] objArr, int i5, int i6) {
        if (i6 > 0) {
            Object[] objArr2 = new Object[i6];
            this.f26571g = objArr2;
            if (objArr != null) {
                long H4 = H();
                for (int i7 = 0; i7 < i5; i7++) {
                    long j5 = ((long) i7) + H4;
                    B.f(objArr2, j5, B.e(objArr, j5));
                }
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow");
    }

    /* access modifiers changed from: private */
    public final boolean O(Object obj) {
        if (i() == 0) {
            return P(obj);
        }
        if (this.f26574j >= this.f26569e && this.f26573i <= this.f26572h) {
            int i5 = b.f26580a[this.f26570f.ordinal()];
            if (i5 == 1) {
                return false;
            }
            if (i5 == 2) {
                return true;
            }
            if (i5 != 3) {
                throw new q();
            }
        }
        E(obj);
        int i6 = this.f26574j + 1;
        this.f26574j = i6;
        if (i6 > this.f26569e) {
            B();
        }
        if (K() > this.f26568d) {
            S(this.f26572h + 1, this.f26573i, G(), J());
        }
        return true;
    }

    private final boolean P(Object obj) {
        if (this.f26568d == 0) {
            return true;
        }
        E(obj);
        int i5 = this.f26574j + 1;
        this.f26574j = i5;
        if (i5 > this.f26568d) {
            B();
        }
        this.f26573i = H() + ((long) this.f26574j);
        return true;
    }

    /* access modifiers changed from: private */
    public final long Q(C c5) {
        long j5 = c5.f26589a;
        if (j5 >= G() && (this.f26569e > 0 || j5 > H() || this.f26575k == 0)) {
            return -1;
        }
        return j5;
    }

    private final Object R(C c5) {
        Object obj;
        C2308e[] eVarArr = A3.c.f17267a;
        synchronized (this) {
            try {
                long Q4 = Q(c5);
                if (Q4 < 0) {
                    obj = B.f26588a;
                } else {
                    long j5 = c5.f26589a;
                    Object I4 = I(Q4);
                    c5.f26589a = Q4 + 1;
                    Object obj2 = I4;
                    eVarArr = T(j5);
                    obj = obj2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (C2308e eVar : eVarArr) {
            if (eVar != null) {
                t.a aVar = W2.t.f19966b;
                eVar.resumeWith(W2.t.b(J.f19942a));
            }
        }
        return obj;
    }

    private final void S(long j5, long j6, long j7, long j8) {
        long min = Math.min(j6, j5);
        for (long H4 = H(); H4 < min; H4++) {
            Object[] objArr = this.f26571g;
            kotlin.jvm.internal.t.b(objArr);
            B.f(objArr, H4, (Object) null);
        }
        this.f26572h = j5;
        this.f26573i = j6;
        this.f26574j = (int) (j7 - min);
        this.f26575k = (int) (j8 - j7);
    }

    private final Object u(C c5, C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        synchronized (this) {
            try {
                if (Q(c5) < 0) {
                    c5.f26590b = nVar;
                } else {
                    t.a aVar = W2.t.f19966b;
                    nVar.resumeWith(W2.t.b(J.f19942a));
                }
                J j5 = J.f19942a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        if (x4 == C2316b.f()) {
            return x4;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final void v(a aVar) {
        synchronized (this) {
            if (aVar.f26577b >= H()) {
                Object[] objArr = this.f26571g;
                kotlin.jvm.internal.t.b(objArr);
                if (B.e(objArr, aVar.f26577b) == aVar) {
                    B.f(objArr, aVar.f26577b, B.f26588a);
                    w();
                    J j5 = J.f19942a;
                }
            }
        }
    }

    private final void w() {
        if (this.f26569e != 0 || this.f26575k > 1) {
            Object[] objArr = this.f26571g;
            kotlin.jvm.internal.t.b(objArr);
            while (this.f26575k > 0 && B.e(objArr, (H() + ((long) L())) - 1) == B.f26588a) {
                this.f26575k--;
                B.f(objArr, H() + ((long) L()), (Object) null);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: z3.C} */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ab, code lost:
        if (r8 == null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ad, code lost:
        w3.B0.h(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b0, code lost:
        r0.f26581a = r5;
        r0.f26582b = r2;
        r0.f26583c = r9;
        r0.f26584d = r8;
        r0.f26587g = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00be, code lost:
        if (r2.emit(r10, r0) != r1) goto L_0x003e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ab A[EDGE_INSN: B:48:0x00ab->B:38:0x00ab ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object x(z3.C2967A r8, z3.C2973f r9, b3.C2308e r10) {
        /*
            boolean r0 = r10 instanceof z3.C2967A.c
            if (r0 == 0) goto L_0x0013
            r0 = r10
            z3.A$c r0 = (z3.C2967A.c) r0
            int r1 = r0.f26587g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26587g = r1
            goto L_0x0018
        L_0x0013:
            z3.A$c r0 = new z3.A$c
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f26585e
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f26587g
            r3 = 3
            r4 = 2
            if (r2 == 0) goto L_0x0077
            r8 = 1
            if (r2 == r8) goto L_0x0061
            if (r2 == r4) goto L_0x004d
            if (r2 != r3) goto L_0x0045
            java.lang.Object r8 = r0.f26584d
            w3.y0 r8 = (w3.C2908y0) r8
            java.lang.Object r9 = r0.f26583c
            z3.C r9 = (z3.C) r9
            java.lang.Object r2 = r0.f26582b
            z3.f r2 = (z3.C2973f) r2
            java.lang.Object r5 = r0.f26581a
            z3.A r5 = (z3.C2967A) r5
            W2.u.b(r10)     // Catch:{ all -> 0x0042 }
        L_0x003e:
            r10 = r2
            r2 = r8
            r8 = r5
            goto L_0x008f
        L_0x0042:
            r8 = move-exception
            goto L_0x00c4
        L_0x0045:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x004d:
            java.lang.Object r8 = r0.f26584d
            w3.y0 r8 = (w3.C2908y0) r8
            java.lang.Object r9 = r0.f26583c
            z3.C r9 = (z3.C) r9
            java.lang.Object r2 = r0.f26582b
            z3.f r2 = (z3.C2973f) r2
            java.lang.Object r5 = r0.f26581a
            z3.A r5 = (z3.C2967A) r5
            W2.u.b(r10)     // Catch:{ all -> 0x0042 }
            goto L_0x0092
        L_0x0061:
            java.lang.Object r8 = r0.f26583c
            r9 = r8
            z3.C r9 = (z3.C) r9
            java.lang.Object r8 = r0.f26582b
            z3.f r8 = (z3.C2973f) r8
            java.lang.Object r2 = r0.f26581a
            z3.A r2 = (z3.C2967A) r2
            W2.u.b(r10)     // Catch:{ all -> 0x0074 }
            r10 = r8
            r8 = r2
            goto L_0x0083
        L_0x0074:
            r8 = move-exception
            r5 = r2
            goto L_0x00c4
        L_0x0077:
            W2.u.b(r10)
            A3.d r10 = r8.e()
            z3.C r10 = (z3.C) r10
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0083:
            b3.i r2 = r0.getContext()     // Catch:{ all -> 0x00c1 }
            w3.y0$b r5 = w3.C2908y0.f26320k0     // Catch:{ all -> 0x00c1 }
            b3.i$b r2 = r2.get(r5)     // Catch:{ all -> 0x00c1 }
            w3.y0 r2 = (w3.C2908y0) r2     // Catch:{ all -> 0x00c1 }
        L_0x008f:
            r5 = r8
            r8 = r2
            r2 = r10
        L_0x0092:
            java.lang.Object r10 = r5.R(r9)     // Catch:{ all -> 0x0042 }
            B3.D r6 = z3.B.f26588a     // Catch:{ all -> 0x0042 }
            if (r10 != r6) goto L_0x00ab
            r0.f26581a = r5     // Catch:{ all -> 0x0042 }
            r0.f26582b = r2     // Catch:{ all -> 0x0042 }
            r0.f26583c = r9     // Catch:{ all -> 0x0042 }
            r0.f26584d = r8     // Catch:{ all -> 0x0042 }
            r0.f26587g = r4     // Catch:{ all -> 0x0042 }
            java.lang.Object r10 = r5.u(r9, r0)     // Catch:{ all -> 0x0042 }
            if (r10 != r1) goto L_0x0092
            goto L_0x00c0
        L_0x00ab:
            if (r8 == 0) goto L_0x00b0
            w3.B0.h(r8)     // Catch:{ all -> 0x0042 }
        L_0x00b0:
            r0.f26581a = r5     // Catch:{ all -> 0x0042 }
            r0.f26582b = r2     // Catch:{ all -> 0x0042 }
            r0.f26583c = r9     // Catch:{ all -> 0x0042 }
            r0.f26584d = r8     // Catch:{ all -> 0x0042 }
            r0.f26587g = r3     // Catch:{ all -> 0x0042 }
            java.lang.Object r10 = r2.emit(r10, r0)     // Catch:{ all -> 0x0042 }
            if (r10 != r1) goto L_0x003e
        L_0x00c0:
            return r1
        L_0x00c1:
            r10 = move-exception
            r5 = r8
            r8 = r10
        L_0x00c4:
            r5.h(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.C2967A.x(z3.A, z3.f, b3.e):java.lang.Object");
    }

    private final void y(long j5) {
        A3.d[] d5;
        if (!(this.f17265b == 0 || (d5 = this.f17264a) == null)) {
            for (A3.d dVar : d5) {
                if (dVar != null) {
                    C c5 = (C) dVar;
                    long j6 = c5.f26589a;
                    if (j6 >= 0 && j6 < j5) {
                        c5.f26589a = j5;
                    }
                }
            }
        }
        this.f26573i = j5;
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public C[] g(int i5) {
        return new C[i5];
    }

    public boolean N(Object obj) {
        int i5;
        boolean z4;
        C2308e[] eVarArr = A3.c.f17267a;
        synchronized (this) {
            if (O(obj)) {
                eVarArr = F(eVarArr);
                z4 = true;
            } else {
                z4 = false;
            }
        }
        for (C2308e eVar : eVarArr) {
            if (eVar != null) {
                t.a aVar = W2.t.f19966b;
                eVar.resumeWith(W2.t.b(J.f19942a));
            }
        }
        return z4;
    }

    public final C2308e[] T(long j5) {
        int i5;
        long j6;
        long j7;
        long j8;
        long j9;
        boolean z4;
        A3.d[] d5;
        if (j5 > this.f26573i) {
            return A3.c.f17267a;
        }
        long H4 = H();
        long j10 = ((long) this.f26574j) + H4;
        if (this.f26569e == 0 && this.f26575k > 0) {
            j10++;
        }
        if (!(this.f17265b == 0 || (d5 = this.f17264a) == null)) {
            for (A3.d dVar : d5) {
                if (dVar != null) {
                    long j11 = ((C) dVar).f26589a;
                    if (j11 >= 0 && j11 < j10) {
                        j10 = j11;
                    }
                }
            }
        }
        if (j10 <= this.f26573i) {
            return A3.c.f17267a;
        }
        long G4 = G();
        if (i() > 0) {
            i5 = Math.min(this.f26575k, this.f26569e - ((int) (G4 - j10)));
        } else {
            i5 = this.f26575k;
        }
        C2308e[] eVarArr = A3.c.f17267a;
        long j12 = ((long) this.f26575k) + G4;
        if (i5 > 0) {
            eVarArr = new C2308e[i5];
            Object[] objArr = this.f26571g;
            kotlin.jvm.internal.t.b(objArr);
            j8 = 1;
            long j13 = G4;
            int i6 = 0;
            while (true) {
                if (G4 >= j12) {
                    j6 = H4;
                    j7 = j10;
                    G4 = j13;
                    break;
                }
                Object b5 = B.e(objArr, G4);
                j6 = H4;
                D d6 = B.f26588a;
                if (b5 != d6) {
                    kotlin.jvm.internal.t.c(b5, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) b5;
                    int i7 = i6 + 1;
                    j7 = j10;
                    eVarArr[i6] = aVar.f26579d;
                    B.f(objArr, G4, d6);
                    B.f(objArr, j13, aVar.f26578c);
                    long j14 = j13 + 1;
                    if (i7 >= i5) {
                        G4 = j14;
                        break;
                    }
                    i6 = i7;
                    j13 = j14;
                } else {
                    j7 = j10;
                }
                G4++;
                H4 = j6;
                j10 = j7;
            }
        } else {
            j6 = H4;
            j7 = j10;
            j8 = 1;
        }
        C2308e[] eVarArr2 = eVarArr;
        int i8 = (int) (G4 - j6);
        if (i() == 0) {
            j9 = G4;
        } else {
            j9 = j7;
        }
        long max = Math.max(this.f26572h, G4 - ((long) Math.min(this.f26568d, i8)));
        if (this.f26569e == 0 && max < j12) {
            Object[] objArr2 = this.f26571g;
            kotlin.jvm.internal.t.b(objArr2);
            if (kotlin.jvm.internal.t.a(B.e(objArr2, max), B.f26588a)) {
                G4 += j8;
                max += j8;
            }
        }
        S(max, j9, G4, j12);
        w();
        if (eVarArr2.length == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            return F(eVarArr2);
        }
        return eVarArr2;
    }

    public final long U() {
        long j5 = this.f26572h;
        if (j5 < this.f26573i) {
            this.f26573i = j5;
        }
        return j5;
    }

    public C2972e b(C2312i iVar, int i5, C2928a aVar) {
        return B.d(this, iVar, i5, aVar);
    }

    public Object collect(C2973f fVar, C2308e eVar) {
        return x(this, fVar, eVar);
    }

    public Object emit(Object obj, C2308e eVar) {
        return C(this, obj, eVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public C f() {
        return new C();
    }
}
