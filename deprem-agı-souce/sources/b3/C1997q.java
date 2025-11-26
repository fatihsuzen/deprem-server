package B3;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.C2633k;

/* renamed from: B3.q  reason: case insensitive filesystem */
public final class C1997q {

    /* renamed from: e  reason: collision with root package name */
    public static final a f17414e = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17415f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f17416g;

    /* renamed from: h  reason: collision with root package name */
    public static final D f17417h = new D("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* renamed from: a  reason: collision with root package name */
    private final int f17418a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17419b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17420c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ AtomicReferenceArray f17421d;

    /* renamed from: B3.q$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final int a(long j5) {
            if ((j5 & 2305843009213693952L) != 0) {
                return 2;
            }
            return 1;
        }

        public final long b(long j5, int i5) {
            return d(j5, 1073741823) | ((long) i5);
        }

        public final long c(long j5, int i5) {
            return d(j5, 1152921503533105152L) | (((long) i5) << 30);
        }

        public final long d(long j5, long j6) {
            return j5 & (~j6);
        }

        private a() {
        }
    }

    /* renamed from: B3.q$b */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f17422a;

        public b(int i5) {
            this.f17422a = i5;
        }
    }

    static {
        Class<C1997q> cls = C1997q.class;
        f17415f = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next$volatile");
        f17416g = AtomicLongFieldUpdater.newUpdater(cls, "_state$volatile");
    }

    public C1997q(int i5, boolean z4) {
        this.f17418a = i5;
        this.f17419b = z4;
        int i6 = i5 - 1;
        this.f17420c = i6;
        this.f17421d = new AtomicReferenceArray(i5);
        if (i6 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        } else if ((i5 & i6) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    private final C1997q b(long j5) {
        C1997q qVar = new C1997q(this.f17418a * 2, this.f17419b);
        int i5 = (int) (1073741823 & j5);
        int i6 = (int) ((1152921503533105152L & j5) >> 30);
        while (true) {
            int i7 = this.f17420c;
            if ((i5 & i7) != (i7 & i6)) {
                Object obj = f().get(this.f17420c & i5);
                if (obj == null) {
                    obj = new b(i5);
                }
                qVar.f().set(qVar.f17420c & i5, obj);
                i5++;
            } else {
                f17416g.set(qVar, f17414e.d(j5, 1152921504606846976L));
                return qVar;
            }
        }
    }

    private final C1997q c(long j5) {
        AtomicReferenceFieldUpdater h5 = f17415f;
        while (true) {
            C1997q qVar = (C1997q) h5.get(this);
            if (qVar != null) {
                return qVar;
            }
            androidx.concurrent.futures.a.a(f17415f, this, (Object) null, b(j5));
        }
    }

    private final C1997q e(int i5, Object obj) {
        Object obj2 = f().get(this.f17420c & i5);
        if (!(obj2 instanceof b) || ((b) obj2).f17422a != i5) {
            return null;
        }
        f().set(i5 & this.f17420c, obj);
        return this;
    }

    private final /* synthetic */ AtomicReferenceArray f() {
        return this.f17421d;
    }

    private final long k() {
        long j5;
        long j6;
        AtomicLongFieldUpdater i5 = f17416g;
        do {
            j5 = i5.get(this);
            if ((j5 & 1152921504606846976L) != 0) {
                return j5;
            }
            j6 = 1152921504606846976L | j5;
        } while (!i5.compareAndSet(this, j5, j6));
        return j6;
    }

    private final C1997q n(int i5, int i6) {
        long j5;
        int i7;
        AtomicLongFieldUpdater i8 = f17416g;
        do {
            j5 = i8.get(this);
            i7 = (int) (1073741823 & j5);
            if ((1152921504606846976L & j5) != 0) {
                return l();
            }
        } while (!f17416g.compareAndSet(this, j5, f17414e.b(j5, i6)));
        f().set(this.f17420c & i7, (Object) null);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0072 A[LOOP:1: B:20:0x0072->B:23:0x0089, LOOP_START, PHI: r0 
      PHI: (r0v3 B3.q) = (r0v2 B3.q), (r0v5 B3.q) binds: [B:19:0x0068, B:23:0x0089] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.Object r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f17416g
        L_0x0004:
            long r3 = r0.get(r12)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0018
            B3.q$a r13 = f17414e
            int r13 = r13.a(r3)
            return r13
        L_0x0018:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            int r1 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r2 = 30
            long r5 = r5 >> r2
            int r9 = (int) r5
            int r10 = r12.f17420c
            int r2 = r9 + 2
            r2 = r2 & r10
            r5 = r1 & r10
            r6 = 1
            if (r2 != r5) goto L_0x0032
            return r6
        L_0x0032:
            boolean r2 = r12.f17419b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r2 != 0) goto L_0x0053
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r12.f()
            r11 = r9 & r10
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L_0x0053
            int r2 = r12.f17418a
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 < r3) goto L_0x0052
            int r9 = r9 - r1
            r1 = r9 & r5
            int r2 = r2 >> 1
            if (r1 <= r2) goto L_0x0004
        L_0x0052:
            return r6
        L_0x0053:
            int r1 = r9 + 1
            r1 = r1 & r5
            r2 = r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f17416g
            B3.q$a r5 = f17414e
            long r5 = r5.c(r3, r2)
            r2 = r12
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L_0x0004
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f()
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L_0x0072:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f17416g
            long r1 = r1.get(r0)
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x008b
            B3.q r0 = r0.l()
            B3.q r0 = r0.e(r9, r13)
            if (r0 != 0) goto L_0x0072
        L_0x008b:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: B3.C1997q.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j5;
        AtomicLongFieldUpdater i5 = f17416g;
        do {
            j5 = i5.get(this);
            if ((j5 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j5) != 0) {
                return false;
            }
        } while (!i5.compareAndSet(this, j5, 2305843009213693952L | j5));
        return true;
    }

    public final int g() {
        long j5 = f17416g.get(this);
        return (((int) ((j5 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j5))) & 1073741823;
    }

    public final boolean j() {
        long j5 = f17416g.get(this);
        if (((int) (1073741823 & j5)) == ((int) ((j5 & 1152921503533105152L) >> 30))) {
            return true;
        }
        return false;
    }

    public final C1997q l() {
        return c(k());
    }

    public final Object m() {
        AtomicLongFieldUpdater i5 = f17416g;
        while (true) {
            long j5 = i5.get(this);
            if ((1152921504606846976L & j5) != 0) {
                return f17417h;
            }
            int i6 = (int) (1073741823 & j5);
            int i7 = this.f17420c;
            if ((((int) ((1152921503533105152L & j5) >> 30)) & i7) == (i7 & i6)) {
                return null;
            }
            Object obj = f().get(this.f17420c & i6);
            if (obj == null) {
                if (this.f17419b) {
                    return null;
                }
            } else if (obj instanceof b) {
                return null;
            } else {
                int i8 = (i6 + 1) & 1073741823;
                if (f17416g.compareAndSet(this, j5, f17414e.b(j5, i8))) {
                    f().set(this.f17420c & i6, (Object) null);
                    return obj;
                } else if (this.f17419b) {
                    C1997q qVar = this;
                    do {
                        qVar = qVar.n(i6, i8);
                    } while (qVar != null);
                    return obj;
                }
            }
        }
    }
}
