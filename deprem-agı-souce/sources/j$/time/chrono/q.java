package j$.time.chrono;

import j$.time.c;
import j$.time.g;
import j$.time.j;
import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.s;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public final class q extends C0458d {
    private static final long serialVersionUID = -5207853542612002020L;

    /* renamed from: a  reason: collision with root package name */
    public final transient o f1067a;

    /* renamed from: b  reason: collision with root package name */
    public final transient int f1068b;

    /* renamed from: c  reason: collision with root package name */
    public final transient int f1069c;

    /* renamed from: d  reason: collision with root package name */
    public final transient int f1070d;

    public final C0459e s(j jVar) {
        return new C0461g(this, jVar);
    }

    public q(o oVar, int i5, int i6, int i7) {
        oVar.h(i5, i6, i7);
        this.f1067a = oVar;
        this.f1068b = i5;
        this.f1069c = i6;
        this.f1070d = i7;
    }

    public q(o oVar, long j5) {
        int i5 = (int) j5;
        oVar.f();
        if (i5 < oVar.f1059e || i5 >= oVar.f1060f) {
            throw new RuntimeException("Hijrah date out of range");
        }
        int binarySearch = Arrays.binarySearch(oVar.f1058d, i5);
        binarySearch = binarySearch < 0 ? (-binarySearch) - 2 : binarySearch;
        int i6 = oVar.f1061g;
        int[] iArr = {(binarySearch + i6) / 12, ((i6 + binarySearch) % 12) + 1, (i5 - oVar.f1058d[binarySearch]) + 1};
        this.f1067a = oVar;
        this.f1068b = iArr[0];
        this.f1069c = iArr[1];
        this.f1070d = iArr[2];
    }

    public final l getChronology() {
        return this.f1067a;
    }

    public final m w() {
        return r.AH;
    }

    public final u g(j$.time.temporal.q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.f(this);
        }
        if (j$.com.android.tools.r8.a.n(this, qVar)) {
            a aVar = (a) qVar;
            int i5 = p.f1066a[aVar.ordinal()];
            if (i5 == 1) {
                return u.e(1, (long) this.f1067a.k(this.f1068b, this.f1069c));
            }
            if (i5 == 2) {
                return u.e(1, (long) this.f1067a.v(this.f1068b, 12));
            }
            if (i5 != 3) {
                return this.f1067a.q(aVar);
            }
            return u.e(1, 5);
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    public final long q(j$.time.temporal.q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.g(this);
        }
        int i5 = 1;
        switch (p.f1066a[((a) qVar).ordinal()]) {
            case 1:
                return (long) this.f1070d;
            case 2:
                return (long) C();
            case 3:
                return (long) (((this.f1070d - 1) / 7) + 1);
            case 4:
                return (long) (((int) j$.com.android.tools.r8.a.A(r() + 3, (long) 7)) + 1);
            case 5:
                return (long) (((this.f1070d - 1) % 7) + 1);
            case 6:
                return (long) (((C() - 1) % 7) + 1);
            case 7:
                return r();
            case 8:
                return (long) (((C() - 1) / 7) + 1);
            case 9:
                return (long) this.f1069c;
            case 10:
                return ((((long) this.f1068b) * 12) + ((long) this.f1069c)) - 1;
            case 11:
                return (long) this.f1068b;
            case 12:
                return (long) this.f1068b;
            case 13:
                if (this.f1068b <= 1) {
                    i5 = 0;
                }
                return (long) i5;
            default:
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
    }

    /* renamed from: G */
    public final q a(long j5, j$.time.temporal.q qVar) {
        if (!(qVar instanceof a)) {
            return (q) super.a(j5, qVar);
        }
        a aVar = (a) qVar;
        this.f1067a.q(aVar).b(j5, aVar);
        int i5 = (int) j5;
        switch (p.f1066a[aVar.ordinal()]) {
            case 1:
                return F(this.f1068b, this.f1069c, i5);
            case 2:
                return y((long) (Math.min(i5, this.f1067a.v(this.f1068b, 12)) - C()));
            case 3:
                return y((j5 - q(a.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 4:
                return y(j5 - ((long) (((int) j$.com.android.tools.r8.a.A(r() + 3, (long) 7)) + 1)));
            case 5:
                return y(j5 - q(a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 6:
                return y(j5 - q(a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 7:
                return new q(this.f1067a, j5);
            case 8:
                return y((j5 - q(a.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 9:
                return F(this.f1068b, i5, this.f1070d);
            case 10:
                return z(j5 - (((((long) this.f1068b) * 12) + ((long) this.f1069c)) - 1));
            case 11:
                if (this.f1068b < 1) {
                    i5 = 1 - i5;
                }
                return F(i5, this.f1069c, this.f1070d);
            case 12:
                return F(i5, this.f1069c, this.f1070d);
            case 13:
                return F(1 - this.f1068b, this.f1069c, this.f1070d);
            default:
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
    }

    public final q F(int i5, int i6, int i7) {
        int k5 = this.f1067a.k(i5, i6);
        if (i7 > k5) {
            i7 = k5;
        }
        return new q(this.f1067a, i5, i6, i7);
    }

    public final C0456b B(o oVar) {
        return (q) super.f(oVar);
    }

    public final m f(g gVar) {
        return (q) super.f(gVar);
    }

    public final long r() {
        return this.f1067a.h(this.f1068b, this.f1069c, this.f1070d);
    }

    public final int C() {
        return this.f1067a.v(this.f1068b, this.f1069c - 1) + this.f1070d;
    }

    public final C0456b A(long j5) {
        if (j5 == 0) {
            return this;
        }
        long j6 = ((long) this.f1068b) + ((long) ((int) j5));
        int i5 = (int) j6;
        if (j6 == ((long) i5)) {
            return F(i5, this.f1069c, this.f1070d);
        }
        throw new ArithmeticException();
    }

    /* renamed from: E */
    public final q z(long j5) {
        if (j5 == 0) {
            return this;
        }
        long j6 = (((long) this.f1068b) * 12) + ((long) (this.f1069c - 1)) + j5;
        o oVar = this.f1067a;
        long B4 = j$.com.android.tools.r8.a.B(j6, 12);
        int i5 = oVar.f1061g;
        if (B4 >= ((long) (i5 / 12)) && B4 <= ((long) ((((oVar.f1058d.length - 1) + i5) / 12) - 1))) {
            return F((int) B4, ((int) j$.com.android.tools.r8.a.A(j6, 12)) + 1, this.f1070d);
        }
        throw new RuntimeException("Invalid Hijrah year: " + B4);
    }

    /* renamed from: D */
    public final q y(long j5) {
        return new q(this.f1067a, r() + j5);
    }

    public final C0456b b(long j5, s sVar) {
        return (q) super.b(j5, sVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final m m208b(long j5, s sVar) {
        return (q) super.b(j5, sVar);
    }

    public final m n(long j5, b bVar) {
        return (q) super.n(j5, bVar);
    }

    public final C0456b x(long j5, s sVar) {
        return (q) super.n(j5, sVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            return this.f1068b == qVar.f1068b && this.f1069c == qVar.f1069c && this.f1070d == qVar.f1070d && this.f1067a.equals(qVar.f1067a);
        }
    }

    public final int hashCode() {
        int i5 = this.f1068b;
        int i6 = this.f1069c;
        int i7 = this.f1070d;
        this.f1067a.getClass();
        return (((i5 << 11) + (i6 << 6)) + i7) ^ ((i5 & -2048) ^ 2100100019);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 6, this);
    }
}
