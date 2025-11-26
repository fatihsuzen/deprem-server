package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.com.android.tools.r8.a;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.s;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class Instant implements m, o, Comparable<Instant>, Serializable {
    public static final Instant MAX = w(31556889864403199L, 999999999);
    public static final Instant MIN = w(-31557014167219200L, 0);

    /* renamed from: c  reason: collision with root package name */
    public static final Instant f1006c = new Instant(0, 0);
    private static final long serialVersionUID = -665713676816604388L;

    /* renamed from: a  reason: collision with root package name */
    public final long f1007a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1008b;

    public final int compareTo(Object obj) {
        Instant instant = (Instant) obj;
        int compare = Long.compare(this.f1007a, instant.f1007a);
        if (compare != 0) {
            return compare;
        }
        return this.f1008b - instant.f1008b;
    }

    public static Instant w(long j5, long j6) {
        return v(a.x(j5, a.B(j6, C.NANOS_PER_SECOND)), (int) a.A(j6, C.NANOS_PER_SECOND));
    }

    public static Instant ofEpochMilli(long j5) {
        long j6 = (long) 1000;
        return v(a.B(j5, j6), ((int) a.A(j5, j6)) * 1000000);
    }

    public static Instant v(long j5, int i5) {
        if ((((long) i5) | j5) == 0) {
            return f1006c;
        }
        if (j5 >= -31557014167219200L && j5 <= 31556889864403199L) {
            return new Instant(j5, i5);
        }
        throw new RuntimeException("Instant exceeds minimum or maximum instant");
    }

    public Instant(long j5, int i5) {
        this.f1007a = j5;
        this.f1008b = i5;
    }

    public final boolean c(q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.NANO_OF_SECOND || qVar == j$.time.temporal.a.MICRO_OF_SECOND || qVar == j$.time.temporal.a.MILLI_OF_SECOND : qVar != null && qVar.e(this);
    }

    public final u g(q qVar) {
        return r.d(this, qVar);
    }

    public final int e(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return r.d(this, qVar).a(qVar.g(this), qVar);
        }
        int i5 = e.f1089a[((j$.time.temporal.a) qVar).ordinal()];
        if (i5 == 1) {
            return this.f1008b;
        }
        if (i5 == 2) {
            return this.f1008b / 1000;
        }
        if (i5 == 3) {
            return this.f1008b / 1000000;
        }
        if (i5 == 4) {
            j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
            aVar.f1181b.a(this.f1007a, aVar);
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    public final long q(q qVar) {
        int i5;
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        int i6 = e.f1089a[((j$.time.temporal.a) qVar).ordinal()];
        if (i6 == 1) {
            i5 = this.f1008b;
        } else if (i6 == 2) {
            i5 = this.f1008b / 1000;
        } else if (i6 == 3) {
            i5 = this.f1008b / 1000000;
        } else if (i6 == 4) {
            return this.f1007a;
        } else {
            throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
        return (long) i5;
    }

    public final m a(long j5, q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (Instant) qVar.h(this, j5);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.k(j5);
        int i5 = e.f1089a[aVar.ordinal()];
        if (i5 != 1) {
            if (i5 == 2) {
                int i6 = ((int) j5) * 1000;
                if (i6 != this.f1008b) {
                    return v(this.f1007a, i6);
                }
            } else if (i5 == 3) {
                int i7 = ((int) j5) * 1000000;
                if (i7 != this.f1008b) {
                    return v(this.f1007a, i7);
                }
            } else if (i5 != 4) {
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
            } else if (j5 != this.f1007a) {
                return v(j5, this.f1008b);
            }
        } else if (j5 != ((long) this.f1008b)) {
            return v(this.f1007a, (int) j5);
        }
        return this;
    }

    /* renamed from: y */
    public final Instant b(long j5, s sVar) {
        if (!(sVar instanceof b)) {
            return (Instant) sVar.e(this, j5);
        }
        switch (e.f1090b[((b) sVar).ordinal()]) {
            case 1:
                return x(0, j5);
            case 2:
                return x(j5 / 1000000, (j5 % 1000000) * 1000);
            case 3:
                return x(j5 / 1000, (j5 % 1000) * 1000000);
            case 4:
                return x(j5, 0);
            case 5:
                return x(a.w(j5, 60), 0);
            case 6:
                return x(a.w(j5, 3600), 0);
            case 7:
                return x(a.w(j5, 43200), 0);
            case 8:
                return x(a.w(j5, 86400), 0);
            default:
                throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    public final Instant x(long j5, long j6) {
        if ((j5 | j6) == 0) {
            return this;
        }
        return w(a.x(a.x(this.f1007a, j5), j6 / C.NANOS_PER_SECOND), ((long) this.f1008b) + (j6 % C.NANOS_PER_SECOND));
    }

    public final m n(long j5, b bVar) {
        return j5 == Long.MIN_VALUE ? b(Long.MAX_VALUE, bVar).b(1, bVar) : b(-j5, bVar);
    }

    public final Object h(j$.time.format.a aVar) {
        if (aVar == r.f1201c) {
            return b.NANOS;
        }
        if (aVar == r.f1200b || aVar == r.f1199a || aVar == r.f1203e || aVar == r.f1202d || aVar == r.f1204f || aVar == r.f1205g) {
            return null;
        }
        return aVar.a(this);
    }

    public final m k(m mVar) {
        return mVar.a(this.f1007a, j$.time.temporal.a.INSTANT_SECONDS).a((long) this.f1008b, j$.time.temporal.a.NANO_OF_SECOND);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.v(this, zoneOffset);
    }

    public long toEpochMilli() {
        long j5 = this.f1007a;
        if (j5 >= 0 || this.f1008b <= 0) {
            return a.x(a.w(j5, 1000), (long) (this.f1008b / 1000000));
        }
        return a.x(a.w(j5 + 1, 1000), (long) ((this.f1008b / 1000000) - 1000));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            Instant instant = (Instant) obj;
            return this.f1007a == instant.f1007a && this.f1008b == instant.f1008b;
        }
    }

    public int hashCode() {
        long j5 = this.f1007a;
        return (this.f1008b * 51) + ((int) (j5 ^ (j5 >>> 32)));
    }

    public final String toString() {
        return DateTimeFormatter.f1093e.a(this);
    }

    private Object writeReplace() {
        return new r((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final m f(g gVar) {
        return (Instant) a.a(gVar, this);
    }
}
