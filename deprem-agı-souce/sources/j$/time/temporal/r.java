package j$.time.temporal;

import j$.time.c;
import j$.time.format.a;
import j$.util.Objects;

public abstract class r {

    /* renamed from: a  reason: collision with root package name */
    public static final a f1199a = new a(1);

    /* renamed from: b  reason: collision with root package name */
    public static final a f1200b = new a(2);

    /* renamed from: c  reason: collision with root package name */
    public static final a f1201c = new a(3);

    /* renamed from: d  reason: collision with root package name */
    public static final a f1202d = new a(4);

    /* renamed from: e  reason: collision with root package name */
    public static final a f1203e = new a(5);

    /* renamed from: f  reason: collision with root package name */
    public static final a f1204f = new a(6);

    /* renamed from: g  reason: collision with root package name */
    public static final a f1205g = new a(7);

    public static u d(n nVar, q qVar) {
        if (!(qVar instanceof a)) {
            Objects.requireNonNull(qVar, "field");
            return qVar.f(nVar);
        } else if (nVar.c(qVar)) {
            return ((a) qVar).f1181b;
        } else {
            throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
    }

    public static int a(n nVar, q qVar) {
        u g5 = nVar.g(qVar);
        if (g5.f1206a < -2147483648L || g5.f1209d > 2147483647L) {
            throw new RuntimeException("Invalid field " + qVar + " for get() method, use getLong() instead");
        }
        long q5 = nVar.q(qVar);
        if (g5.d(q5)) {
            return (int) q5;
        }
        throw new RuntimeException("Invalid value for " + qVar + " (valid values " + g5 + "): " + q5);
    }

    public static Object c(n nVar, a aVar) {
        if (aVar == f1199a || aVar == f1200b || aVar == f1201c) {
            return null;
        }
        return aVar.a(nVar);
    }

    public static m b(m mVar, long j5, s sVar) {
        long j6;
        if (j5 == Long.MIN_VALUE) {
            mVar = mVar.b(Long.MAX_VALUE, sVar);
            j6 = 1;
        } else {
            j6 = -j5;
        }
        return mVar.b(j6, sVar);
    }
}
