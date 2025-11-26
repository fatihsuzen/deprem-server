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
import j$.time.temporal.u;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public final class C extends C0458d {
    private static final long serialVersionUID = 1300372329181994526L;

    /* renamed from: a  reason: collision with root package name */
    public final transient g f1030a;

    public final C0459e s(j jVar) {
        return new C0461g(this, jVar);
    }

    public C(g gVar) {
        Objects.requireNonNull(gVar, "isoDate");
        this.f1030a = gVar;
    }

    public final l getChronology() {
        return A.f1028c;
    }

    public final int hashCode() {
        A.f1028c.getClass();
        return this.f1030a.hashCode() ^ -1990173233;
    }

    public final m w() {
        return C() >= 1 ? D.ROC : D.BEFORE_ROC;
    }

    public final u g(q qVar) {
        long j5;
        if (!(qVar instanceof a)) {
            return qVar.f(this);
        }
        if (j$.com.android.tools.r8.a.n(this, qVar)) {
            a aVar = (a) qVar;
            int i5 = B.f1029a[aVar.ordinal()];
            if (i5 == 1 || i5 == 2 || i5 == 3) {
                return this.f1030a.g(qVar);
            }
            if (i5 != 4) {
                return A.f1028c.f(aVar);
            }
            u uVar = a.YEAR.f1181b;
            if (C() <= 0) {
                j5 = (-uVar.f1206a) + 1912;
            } else {
                j5 = uVar.f1209d - 1911;
            }
            return u.e(1, j5);
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    public final long q(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.g(this);
        }
        int i5 = B.f1029a[((a) qVar).ordinal()];
        int i6 = 1;
        if (i5 == 4) {
            int C4 = C();
            if (C4 < 1) {
                C4 = 1 - C4;
            }
            return (long) C4;
        } else if (i5 == 5) {
            return ((((long) C()) * 12) + ((long) this.f1030a.f1145b)) - 1;
        } else {
            if (i5 == 6) {
                return (long) C();
            }
            if (i5 != 7) {
                return this.f1030a.q(qVar);
            }
            if (C() < 1) {
                i6 = 0;
            }
            return (long) i6;
        }
    }

    public final int C() {
        return this.f1030a.f1144a - 1911;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r2 != 7) goto L_0x005f;
     */
    /* renamed from: D */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.time.chrono.C a(long r8, j$.time.temporal.q r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof j$.time.temporal.a
            if (r0 == 0) goto L_0x009f
            r0 = r10
            j$.time.temporal.a r0 = (j$.time.temporal.a) r0
            long r1 = r7.q(r0)
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x0010
            return r7
        L_0x0010:
            int[] r1 = j$.time.chrono.B.f1029a
            int r2 = r0.ordinal()
            r2 = r1[r2]
            r3 = 7
            r4 = 6
            r5 = 4
            if (r2 == r5) goto L_0x0049
            r6 = 5
            if (r2 == r6) goto L_0x0025
            if (r2 == r4) goto L_0x0049
            if (r2 == r3) goto L_0x0049
            goto L_0x005f
        L_0x0025:
            j$.time.chrono.A r10 = j$.time.chrono.A.f1028c
            j$.time.temporal.u r10 = r10.f(r0)
            r10.b(r8, r0)
            int r10 = r7.C()
            long r0 = (long) r10
            r2 = 12
            long r0 = r0 * r2
            j$.time.g r10 = r7.f1030a
            short r2 = r10.f1145b
            long r2 = (long) r2
            long r0 = r0 + r2
            r2 = 1
            long r0 = r0 - r2
            long r8 = r8 - r0
            j$.time.g r8 = r10.H(r8)
            j$.time.chrono.C r8 = r7.E(r8)
            return r8
        L_0x0049:
            j$.time.chrono.A r2 = j$.time.chrono.A.f1028c
            j$.time.temporal.u r2 = r2.f(r0)
            int r2 = r2.a(r8, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r5) goto L_0x0088
            if (r0 == r4) goto L_0x007b
            if (r0 == r3) goto L_0x006a
        L_0x005f:
            j$.time.g r0 = r7.f1030a
            j$.time.g r8 = r0.a(r8, r10)
            j$.time.chrono.C r8 = r7.E(r8)
            return r8
        L_0x006a:
            j$.time.g r8 = r7.f1030a
            int r9 = r7.C()
            int r9 = 1912 - r9
            j$.time.g r8 = r8.N(r9)
            j$.time.chrono.C r8 = r7.E(r8)
            return r8
        L_0x007b:
            j$.time.g r8 = r7.f1030a
            int r2 = r2 + 1911
            j$.time.g r8 = r8.N(r2)
            j$.time.chrono.C r8 = r7.E(r8)
            return r8
        L_0x0088:
            j$.time.g r8 = r7.f1030a
            int r9 = r7.C()
            r10 = 1
            if (r9 < r10) goto L_0x0094
            int r2 = r2 + 1911
            goto L_0x0096
        L_0x0094:
            int r2 = 1912 - r2
        L_0x0096:
            j$.time.g r8 = r8.N(r2)
            j$.time.chrono.C r8 = r7.E(r8)
            return r8
        L_0x009f:
            j$.time.chrono.b r8 = super.a((long) r8, (j$.time.temporal.q) r10)
            j$.time.chrono.C r8 = (j$.time.chrono.C) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.C.a(long, j$.time.temporal.q):j$.time.chrono.C");
    }

    public final C0456b B(o oVar) {
        return (C) super.f(oVar);
    }

    public final m f(g gVar) {
        return (C) super.f(gVar);
    }

    public final C0456b A(long j5) {
        return E(this.f1030a.I(j5));
    }

    public final C0456b z(long j5) {
        return E(this.f1030a.H(j5));
    }

    public final C0456b y(long j5) {
        return E(this.f1030a.G(j5));
    }

    public final C0456b b(long j5, s sVar) {
        return (C) super.b(j5, sVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final m m206b(long j5, s sVar) {
        return (C) super.b(j5, sVar);
    }

    public final m n(long j5, b bVar) {
        return (C) super.n(j5, bVar);
    }

    public final C0456b x(long j5, s sVar) {
        return (C) super.n(j5, sVar);
    }

    public final C E(g gVar) {
        return gVar.equals(this.f1030a) ? this : new C(gVar);
    }

    public final long r() {
        return this.f1030a.r();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C) {
            return this.f1030a.equals(((C) obj).f1030a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 7, this);
    }
}
