package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.com.android.tools.r8.a;
import j$.time.chrono.C0456b;
import j$.time.chrono.C0459e;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.l;
import j$.time.temporal.m;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.s;
import j$.time.temporal.u;
import j$.time.zone.b;
import j$.time.zone.f;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public final class ZonedDateTime implements m, ChronoZonedDateTime<g>, Serializable {
    private static final long serialVersionUID = -6260982410461394882L;

    /* renamed from: a  reason: collision with root package name */
    public final LocalDateTime f1023a;

    /* renamed from: b  reason: collision with root package name */
    public final ZoneOffset f1024b;

    /* renamed from: c  reason: collision with root package name */
    public final ZoneId f1025c;

    public final /* synthetic */ long toEpochSecond() {
        return a.u(this);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return a.i(this, (ChronoZonedDateTime) obj);
    }

    public static ZonedDateTime now() {
        String id = TimeZone.getDefault().getID();
        Map map = ZoneId.f1016a;
        Objects.requireNonNull(id, "zoneId");
        Objects.requireNonNull(map, "aliasMap");
        Object obj = (String) map.get(id);
        if (obj == null) {
            obj = Objects.requireNonNull(id, "defaultObj");
        }
        ZoneId of = ZoneId.of((String) obj);
        Objects.requireNonNull(new a(of), "clock");
        return ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), of);
    }

    public static ZonedDateTime now(ZoneId zoneId) {
        a aVar;
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId == ZoneOffset.UTC) {
            aVar = a.f1026b;
        } else {
            aVar = new a(zoneId);
        }
        Objects.requireNonNull(aVar, "clock");
        aVar.getClass();
        return ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), aVar.f1027a);
    }

    public final l getChronology() {
        return ((g) toLocalDate()).getChronology();
    }

    public static ZonedDateTime of(int i5, int i6, int i7, int i8, int i9, int i10, int i11, ZoneId zoneId) {
        LocalDateTime localDateTime = LocalDateTime.f1009c;
        g D4 = g.D(i5, i6, i7);
        j$.time.temporal.a.HOUR_OF_DAY.k((long) i8);
        j$.time.temporal.a.MINUTE_OF_HOUR.k((long) i9);
        j$.time.temporal.a.SECOND_OF_MINUTE.k((long) i10);
        j$.time.temporal.a.NANO_OF_SECOND.k((long) i11);
        return v(new LocalDateTime(D4, j.w(i8, i9, i10, i11)), zoneId, (ZoneOffset) null);
    }

    public static ZonedDateTime v(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, zoneId, (ZoneOffset) zoneId);
        }
        f v5 = zoneId.v();
        List f5 = v5.f(localDateTime);
        if (f5.size() == 1) {
            zoneOffset = (ZoneOffset) f5.get(0);
        } else if (f5.size() == 0) {
            Object e5 = v5.e(localDateTime);
            b bVar = e5 instanceof b ? (b) e5 : null;
            localDateTime = localDateTime.B(Duration.e((long) (bVar.f1225d.f1021b - bVar.f1224c.f1021b), 0).f1004a);
            zoneOffset = bVar.f1225d;
        } else if (zoneOffset == null || !f5.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) Objects.requireNonNull((ZoneOffset) f5.get(0), TypedValues.CycleType.S_WAVE_OFFSET);
        }
        return new ZonedDateTime(localDateTime, zoneId, zoneOffset);
    }

    public static ZonedDateTime ofInstant(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return k(instant.f1007a, instant.f1008b, zoneId);
    }

    public static ZonedDateTime k(long j5, int i5, ZoneId zoneId) {
        ZoneOffset d5 = zoneId.v().d(Instant.w(j5, (long) i5));
        return new ZonedDateTime(LocalDateTime.z(j5, i5, d5), zoneId, d5);
    }

    public final Instant toInstant() {
        return Instant.w(toEpochSecond(), (long) toLocalTime().f1157d);
    }

    public ZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        this.f1023a = localDateTime;
        this.f1024b = zoneOffset;
        this.f1025c = zoneId;
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
        return this.f1023a.g(qVar);
    }

    public final int e(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return a.k(this, qVar);
        }
        int i5 = x.f1218a[((j$.time.temporal.a) qVar).ordinal()];
        if (i5 == 1) {
            throw new RuntimeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        } else if (i5 != 2) {
            return this.f1023a.e(qVar);
        } else {
            return this.f1024b.f1021b;
        }
    }

    public final long q(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        int i5 = x.f1218a[((j$.time.temporal.a) qVar).ordinal()];
        return i5 != 1 ? i5 != 2 ? this.f1023a.q(qVar) : (long) this.f1024b.f1021b : a.u(this);
    }

    public final ZoneOffset getOffset() {
        return this.f1024b;
    }

    public final ZoneId getZone() {
        return this.f1025c;
    }

    public final ChronoZonedDateTime m(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        return this.f1025c.equals(zoneId) ? this : v(this.f1023a, zoneId, this.f1024b);
    }

    public final C0459e toLocalDateTime() {
        return this.f1023a;
    }

    public final C0456b toLocalDate() {
        return this.f1023a.f1011a;
    }

    public int getYear() {
        return this.f1023a.f1011a.f1144a;
    }

    public int getMonthValue() {
        return this.f1023a.f1011a.f1145b;
    }

    public int getDayOfMonth() {
        return this.f1023a.f1011a.f1146c;
    }

    public final j toLocalTime() {
        return this.f1023a.f1012b;
    }

    public final m f(g gVar) {
        return v(LocalDateTime.y(gVar, this.f1023a.f1012b), this.f1025c, this.f1024b);
    }

    public final m a(long j5, q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (ZonedDateTime) qVar.h(this, j5);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        int i5 = x.f1218a[aVar.ordinal()];
        if (i5 == 1) {
            return k(j5, this.f1023a.f1012b.f1157d, this.f1025c);
        }
        if (i5 != 2) {
            return v(this.f1023a.a(j5, qVar), this.f1025c, this.f1024b);
        }
        ZoneOffset C4 = ZoneOffset.C(aVar.f1181b.a(j5, aVar));
        return (C4.equals(this.f1024b) || !this.f1025c.v().f(this.f1023a).contains(C4)) ? this : new ZonedDateTime(this.f1023a, this.f1025c, C4);
    }

    /* renamed from: w */
    public final ZonedDateTime b(long j5, s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (ZonedDateTime) sVar.e(this, j5);
        }
        j$.time.temporal.b bVar = (j$.time.temporal.b) sVar;
        if (bVar.compareTo(j$.time.temporal.b.DAYS) >= 0 && bVar != j$.time.temporal.b.FOREVER) {
            return v(this.f1023a.b(j5, sVar), this.f1025c, this.f1024b);
        }
        LocalDateTime A4 = this.f1023a.b(j5, sVar);
        ZoneOffset zoneOffset = this.f1024b;
        ZoneId zoneId = this.f1025c;
        Objects.requireNonNull(A4, "localDateTime");
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId.v().f(A4).contains(zoneOffset)) {
            return new ZonedDateTime(A4, zoneId, zoneOffset);
        }
        A4.getClass();
        return k(a.t(A4, zoneOffset), A4.f1012b.f1157d, zoneId);
    }

    public final m n(long j5, j$.time.temporal.b bVar) {
        return j5 == Long.MIN_VALUE ? b(Long.MAX_VALUE, bVar).b(1, bVar) : b(-j5, bVar);
    }

    public final Object h(j$.time.format.a aVar) {
        if (aVar == r.f1204f) {
            return this.f1023a.f1011a;
        }
        return a.r(this, aVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZonedDateTime) {
            ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
            return this.f1023a.equals(zonedDateTime.f1023a) && this.f1024b.equals(zonedDateTime.f1024b) && this.f1025c.equals(zonedDateTime.f1025c);
        }
    }

    public final int hashCode() {
        return (this.f1023a.hashCode() ^ this.f1024b.f1021b) ^ Integer.rotateLeft(this.f1025c.hashCode(), 3);
    }

    public final String toString() {
        String str = this.f1023a.toString() + this.f1024b.f1022c;
        ZoneOffset zoneOffset = this.f1024b;
        ZoneId zoneId = this.f1025c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    private Object writeReplace() {
        return new r((byte) 6, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
