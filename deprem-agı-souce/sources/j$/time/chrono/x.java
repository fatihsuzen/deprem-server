package j$.time.chrono;

import j$.time.c;
import j$.time.g;
import j$.time.j;
import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.s;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public final class x extends C0458d {

    /* renamed from: d  reason: collision with root package name */
    public static final g f1077d = g.D(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;

    /* renamed from: a  reason: collision with root package name */
    public final transient g f1078a;

    /* renamed from: b  reason: collision with root package name */
    public final transient y f1079b;

    /* renamed from: c  reason: collision with root package name */
    public final transient int f1080c;

    public final C0459e s(j jVar) {
        return new C0461g(this, jVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
        if (r6.v(r0) < 0) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0020, code lost:
        if (r6.r() < r0.r()) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0024, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public x(j$.time.g r6) {
        /*
            r5 = this;
            r5.<init>()
            j$.time.g r0 = f1077d
            boolean r1 = j$.time.c.b(r0)
            r2 = 1
            if (r1 == 0) goto L_0x0016
            r6.getClass()
            int r0 = r6.v(r0)
            if (r0 >= 0) goto L_0x0024
            goto L_0x0022
        L_0x0016:
            long r3 = r6.r()
            long r0 = r0.r()
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0024
        L_0x0022:
            r0 = r2
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            if (r0 != 0) goto L_0x003a
            j$.time.chrono.y r0 = j$.time.chrono.y.d(r6)
            r5.f1079b = r0
            int r1 = r6.f1144a
            j$.time.g r0 = r0.f1084b
            int r0 = r0.f1144a
            int r1 = r1 - r0
            int r1 = r1 + r2
            r5.f1080c = r1
            r5.f1078a = r6
            return
        L_0x003a:
            j$.time.b r6 = new j$.time.b
            java.lang.String r0 = "JapaneseDate before Meiji 6 is not supported"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.x.<init>(j$.time.g):void");
    }

    public final l getChronology() {
        return v.f1075c;
    }

    public final int hashCode() {
        v.f1075c.getClass();
        return this.f1078a.hashCode() ^ -688086063;
    }

    public final m w() {
        return this.f1079b;
    }

    public final boolean c(q qVar) {
        if (qVar == a.ALIGNED_DAY_OF_WEEK_IN_MONTH || qVar == a.ALIGNED_DAY_OF_WEEK_IN_YEAR || qVar == a.ALIGNED_WEEK_OF_MONTH || qVar == a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        if (qVar instanceof a) {
            return ((a) qVar).isDateBased();
        }
        return qVar != null && qVar.e(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.time.temporal.u g(j$.time.temporal.q r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof j$.time.temporal.a
            if (r0 == 0) goto L_0x0099
            boolean r0 = r5.c(r6)
            if (r0 == 0) goto L_0x008d
            j$.time.temporal.a r6 = (j$.time.temporal.a) r6
            int[] r0 = j$.time.chrono.w.f1076a
            int r1 = r6.ordinal()
            r0 = r0[r1]
            r1 = 1
            r2 = 1
            if (r0 == r1) goto L_0x0081
            r4 = 2
            if (r0 == r4) goto L_0x0048
            r4 = 3
            if (r0 == r4) goto L_0x0026
            j$.time.chrono.v r0 = j$.time.chrono.v.f1075c
            j$.time.temporal.u r6 = r0.f(r6)
            return r6
        L_0x0026:
            j$.time.chrono.y r6 = r5.f1079b
            j$.time.g r0 = r6.f1084b
            int r0 = r0.f1144a
            j$.time.chrono.y r6 = r6.j()
            if (r6 == 0) goto L_0x003e
            j$.time.g r6 = r6.f1084b
            int r6 = r6.f1144a
            int r6 = r6 - r0
            int r6 = r6 + r1
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.e(r2, r0)
            return r6
        L_0x003e:
            r6 = 999999999(0x3b9ac9ff, float:0.004723787)
            int r6 = r6 - r0
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.e(r2, r0)
            return r6
        L_0x0048:
            j$.time.chrono.y r6 = r5.f1079b
            j$.time.chrono.y r6 = r6.j()
            if (r6 == 0) goto L_0x0060
            j$.time.g r6 = r6.f1084b
            int r0 = r6.f1144a
            j$.time.g r4 = r5.f1078a
            int r4 = r4.f1144a
            if (r0 != r4) goto L_0x0060
            int r6 = r6.A()
            int r6 = r6 - r1
            goto L_0x006d
        L_0x0060:
            j$.time.g r6 = r5.f1078a
            boolean r6 = r6.B()
            if (r6 == 0) goto L_0x006b
            r6 = 366(0x16e, float:5.13E-43)
            goto L_0x006d
        L_0x006b:
            r6 = 365(0x16d, float:5.11E-43)
        L_0x006d:
            int r0 = r5.f1080c
            if (r0 != r1) goto L_0x007b
            j$.time.chrono.y r0 = r5.f1079b
            j$.time.g r0 = r0.f1084b
            int r0 = r0.A()
            int r0 = r0 - r1
            int r6 = r6 - r0
        L_0x007b:
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.e(r2, r0)
            return r6
        L_0x0081:
            j$.time.g r6 = r5.f1078a
            int r6 = r6.C()
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.e(r2, r0)
            return r6
        L_0x008d:
            j$.time.temporal.t r0 = new j$.time.temporal.t
            java.lang.String r1 = "Unsupported field: "
            java.lang.String r6 = j$.time.c.a(r1, r6)
            r0.<init>(r6)
            throw r0
        L_0x0099:
            j$.time.temporal.u r6 = r6.f(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.x.g(j$.time.temporal.q):j$.time.temporal.u");
    }

    public final long q(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.g(this);
        }
        switch (w.f1076a[((a) qVar).ordinal()]) {
            case 2:
                if (this.f1080c == 1) {
                    return (long) ((this.f1078a.A() - this.f1079b.f1084b.A()) + 1);
                }
                return (long) this.f1078a.A();
            case 3:
                return (long) this.f1080c;
            case 4:
            case 5:
            case 6:
            case 7:
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
            case 8:
                return (long) this.f1079b.f1083a;
            default:
                return this.f1078a.q(qVar);
        }
    }

    /* renamed from: C */
    public final x a(long j5, q qVar) {
        if (!(qVar instanceof a)) {
            return (x) super.a(j5, qVar);
        }
        a aVar = (a) qVar;
        if (q(aVar) == j5) {
            return this;
        }
        int[] iArr = w.f1076a;
        int i5 = iArr[aVar.ordinal()];
        if (i5 == 3 || i5 == 8 || i5 == 9) {
            int a5 = v.f1075c.f(aVar).a(j5, aVar);
            int i6 = iArr[aVar.ordinal()];
            if (i6 == 3) {
                return E(this.f1079b, a5);
            }
            if (i6 == 8) {
                return E(y.l(a5), this.f1080c);
            }
            if (i6 == 9) {
                return D(this.f1078a.N(a5));
            }
        }
        return D(this.f1078a.a(j5, qVar));
    }

    public final C0456b B(o oVar) {
        return (x) super.f(oVar);
    }

    public final m f(g gVar) {
        return (x) super.f(gVar);
    }

    public final x E(y yVar, int i5) {
        v.f1075c.getClass();
        if (yVar != null) {
            int i6 = yVar.f1084b.f1144a;
            int i7 = (i6 + i5) - 1;
            if (i5 == 1 || (i7 >= -999999999 && i7 <= 999999999 && i7 >= i6 && yVar == y.d(g.D(i7, 1, 1)))) {
                return D(this.f1078a.N(i7));
            }
            throw new RuntimeException("Invalid yearOfEra value");
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    public final C0456b A(long j5) {
        return D(this.f1078a.I(j5));
    }

    public final C0456b z(long j5) {
        return D(this.f1078a.H(j5));
    }

    public final C0456b y(long j5) {
        return D(this.f1078a.G(j5));
    }

    public final C0456b b(long j5, s sVar) {
        return (x) super.b(j5, sVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final m m209b(long j5, s sVar) {
        return (x) super.b(j5, sVar);
    }

    public final m n(long j5, b bVar) {
        return (x) super.n(j5, bVar);
    }

    public final C0456b x(long j5, s sVar) {
        return (x) super.n(j5, sVar);
    }

    public final x D(g gVar) {
        return gVar.equals(this.f1078a) ? this : new x(gVar);
    }

    public final long r() {
        return this.f1078a.r();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return this.f1078a.equals(((x) obj).f1078a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 4, this);
    }
}
