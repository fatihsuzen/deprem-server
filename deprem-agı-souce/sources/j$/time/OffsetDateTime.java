package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.com.android.tools.r8.a;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.s;
import j$.time.temporal.u;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class OffsetDateTime implements m, o, Comparable<OffsetDateTime>, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f1013c = 0;
    private static final long serialVersionUID = 2287754244819255394L;

    /* renamed from: a  reason: collision with root package name */
    public final LocalDateTime f1014a;

    /* renamed from: b  reason: collision with root package name */
    public final ZoneOffset f1015b;

    public final int compareTo(Object obj) {
        int i5;
        OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
        if (this.f1015b.equals(offsetDateTime.f1015b)) {
            i5 = toLocalDateTime().compareTo(offsetDateTime.toLocalDateTime());
        } else {
            LocalDateTime localDateTime = this.f1014a;
            ZoneOffset zoneOffset = this.f1015b;
            localDateTime.getClass();
            long t5 = a.t(localDateTime, zoneOffset);
            LocalDateTime localDateTime2 = offsetDateTime.f1014a;
            ZoneOffset zoneOffset2 = offsetDateTime.f1015b;
            localDateTime2.getClass();
            i5 = Long.compare(t5, a.t(localDateTime2, zoneOffset2));
            if (i5 == 0) {
                i5 = this.f1014a.f1012b.f1157d - offsetDateTime.f1014a.f1012b.f1157d;
            }
        }
        return i5 == 0 ? toLocalDateTime().compareTo(offsetDateTime.toLocalDateTime()) : i5;
    }

    static {
        LocalDateTime localDateTime = LocalDateTime.f1009c;
        ZoneOffset zoneOffset = ZoneOffset.f1020g;
        localDateTime.getClass();
        new OffsetDateTime(localDateTime, zoneOffset);
        LocalDateTime localDateTime2 = LocalDateTime.f1010d;
        ZoneOffset zoneOffset2 = ZoneOffset.f1019f;
        localDateTime2.getClass();
        new OffsetDateTime(localDateTime2, zoneOffset2);
    }

    public static OffsetDateTime v(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        ZoneOffset d5 = zoneId.v().d(instant);
        return new OffsetDateTime(LocalDateTime.z(instant.f1007a, instant.f1008b, d5), d5);
    }

    public OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        this.f1014a = (LocalDateTime) Objects.requireNonNull(localDateTime, "dateTime");
        this.f1015b = (ZoneOffset) Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
    }

    public final OffsetDateTime x(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        if (this.f1014a != localDateTime || !this.f1015b.equals(zoneOffset)) {
            return new OffsetDateTime(localDateTime, zoneOffset);
        }
        return this;
    }

    public final boolean c(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar != null && qVar.e(this);
        }
        return true;
    }

    public final u g(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.f(this);
        }
        if (qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return ((j$.time.temporal.a) qVar).f1181b;
        }
        return this.f1014a.g(qVar);
    }

    public final int e(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return r.a(this, qVar);
        }
        int i5 = o.f1165a[((j$.time.temporal.a) qVar).ordinal()];
        if (i5 == 1) {
            throw new RuntimeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        } else if (i5 != 2) {
            return this.f1014a.e(qVar);
        } else {
            return this.f1015b.f1021b;
        }
    }

    public final long q(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        int i5 = o.f1165a[((j$.time.temporal.a) qVar).ordinal()];
        if (i5 == 1) {
            LocalDateTime localDateTime = this.f1014a;
            ZoneOffset zoneOffset = this.f1015b;
            localDateTime.getClass();
            return a.t(localDateTime, zoneOffset);
        } else if (i5 != 2) {
            return this.f1014a.q(qVar);
        } else {
            return (long) this.f1015b.f1021b;
        }
    }

    public LocalDateTime toLocalDateTime() {
        return this.f1014a;
    }

    public final m f(g gVar) {
        LocalDateTime localDateTime = this.f1014a;
        return x(localDateTime.E(gVar, localDateTime.f1012b), this.f1015b);
    }

    public final m a(long j5, q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (OffsetDateTime) qVar.h(this, j5);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        int i5 = o.f1165a[aVar.ordinal()];
        if (i5 == 1) {
            return v(Instant.w(j5, (long) this.f1014a.f1012b.f1157d), this.f1015b);
        }
        if (i5 != 2) {
            return x(this.f1014a.a(j5, qVar), this.f1015b);
        }
        return x(this.f1014a, ZoneOffset.C(aVar.f1181b.a(j5, aVar)));
    }

    /* renamed from: w */
    public final OffsetDateTime b(long j5, s sVar) {
        if (sVar instanceof b) {
            return x(this.f1014a.b(j5, sVar), this.f1015b);
        }
        return (OffsetDateTime) sVar.e(this, j5);
    }

    public final m n(long j5, b bVar) {
        return j5 == Long.MIN_VALUE ? b(Long.MAX_VALUE, bVar).b(1, bVar) : b(-j5, bVar);
    }

    public final Object h(j$.time.format.a aVar) {
        if (aVar == r.f1202d || aVar == r.f1203e) {
            return this.f1015b;
        }
        if (aVar == r.f1199a) {
            return null;
        }
        if (aVar == r.f1204f) {
            return this.f1014a.f1011a;
        }
        if (aVar == r.f1205g) {
            return this.f1014a.f1012b;
        }
        if (aVar == r.f1200b) {
            return j$.time.chrono.s.f1072c;
        }
        if (aVar == r.f1201c) {
            return b.NANOS;
        }
        return aVar.a(this);
    }

    public final m k(m mVar) {
        return mVar.a(this.f1014a.f1011a.r(), j$.time.temporal.a.EPOCH_DAY).a(this.f1014a.f1012b.G(), j$.time.temporal.a.NANO_OF_DAY).a((long) this.f1015b.f1021b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetDateTime) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
            return this.f1014a.equals(offsetDateTime.f1014a) && this.f1015b.equals(offsetDateTime.f1015b);
        }
    }

    public final int hashCode() {
        return this.f1014a.hashCode() ^ this.f1015b.f1021b;
    }

    public final String toString() {
        String localDateTime = this.f1014a.toString();
        String str = this.f1015b.f1022c;
        return localDateTime + str;
    }

    private Object writeReplace() {
        return new r((byte) 10, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
