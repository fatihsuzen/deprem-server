package j$.time.chrono;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.com.android.tools.r8.a;
import j$.time.Duration;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.g;
import j$.time.j;
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

public final class k implements ChronoZonedDateTime, Serializable {
    private static final long serialVersionUID = -5261813987200935591L;

    /* renamed from: a  reason: collision with root package name */
    public final transient C0461g f1052a;

    /* renamed from: b  reason: collision with root package name */
    public final transient ZoneOffset f1053b;

    /* renamed from: c  reason: collision with root package name */
    public final transient ZoneId f1054c;

    public final /* synthetic */ int e(q qVar) {
        return a.k(this, qVar);
    }

    public final /* synthetic */ Object h(j$.time.format.a aVar) {
        return a.r(this, aVar);
    }

    public final /* synthetic */ long toEpochSecond() {
        return a.u(this);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return a.i(this, (ChronoZonedDateTime) obj);
    }

    public static k v(ZoneId zoneId, ZoneOffset zoneOffset, C0461g gVar) {
        Objects.requireNonNull(gVar, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new k(zoneId, (ZoneOffset) zoneId, gVar);
        }
        f v5 = zoneId.v();
        LocalDateTime w4 = LocalDateTime.w(gVar);
        List f5 = v5.f(w4);
        if (f5.size() == 1) {
            zoneOffset = (ZoneOffset) f5.get(0);
        } else if (f5.size() == 0) {
            Object e5 = v5.e(w4);
            b bVar = e5 instanceof b ? (b) e5 : null;
            gVar = gVar.x(gVar.f1043a, 0, 0, Duration.e((long) (bVar.f1225d.f1021b - bVar.f1224c.f1021b), 0).f1004a, 0);
            zoneOffset = bVar.f1225d;
        } else {
            C0461g gVar2 = gVar;
            if (zoneOffset == null || !f5.contains(zoneOffset)) {
                zoneOffset = (ZoneOffset) f5.get(0);
            }
            gVar = gVar2;
        }
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        return new k(zoneId, zoneOffset, gVar);
    }

    public final u g(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.f(this);
        }
        if (qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return ((j$.time.temporal.a) qVar).f1181b;
        }
        return ((C0461g) toLocalDateTime()).g(qVar);
    }

    public static k k(l lVar, m mVar) {
        k kVar = (k) mVar;
        if (lVar.equals(kVar.getChronology())) {
            return kVar;
        }
        String d5 = lVar.d();
        String d6 = kVar.getChronology().d();
        throw new ClassCastException("Chronology mismatch, required: " + d5 + ", actual: " + d6);
    }

    public final long q(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        int i5 = C0463i.f1050a[((j$.time.temporal.a) qVar).ordinal()];
        if (i5 == 1) {
            return toEpochSecond();
        }
        if (i5 != 2) {
            return ((C0461g) toLocalDateTime()).q(qVar);
        }
        return (long) getOffset().f1021b;
    }

    public k(ZoneId zoneId, ZoneOffset zoneOffset, C0461g gVar) {
        this.f1052a = (C0461g) Objects.requireNonNull(gVar, "dateTime");
        this.f1053b = (ZoneOffset) Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        this.f1054c = (ZoneId) Objects.requireNonNull(zoneId, "zone");
    }

    public final ZoneOffset getOffset() {
        return this.f1053b;
    }

    public final C0456b toLocalDate() {
        return ((C0461g) toLocalDateTime()).toLocalDate();
    }

    public final j toLocalTime() {
        return ((C0461g) toLocalDateTime()).toLocalTime();
    }

    public final int hashCode() {
        return (this.f1052a.hashCode() ^ this.f1053b.f1021b) ^ Integer.rotateLeft(this.f1054c.hashCode(), 3);
    }

    public final C0459e toLocalDateTime() {
        return this.f1052a;
    }

    public final String toString() {
        String str = this.f1052a.toString() + this.f1053b.f1022c;
        ZoneOffset zoneOffset = this.f1053b;
        ZoneId zoneId = this.f1054c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    public final ZoneId getZone() {
        return this.f1054c;
    }

    public final l getChronology() {
        return toLocalDate().getChronology();
    }

    public final ChronoZonedDateTime m(ZoneId zoneId) {
        return v(zoneId, this.f1053b, this.f1052a);
    }

    public final boolean c(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar != null && qVar.e(this);
        }
        return true;
    }

    public final m a(long j5, q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return k(getChronology(), qVar.h(this, j5));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        int i5 = C0464j.f1051a[aVar.ordinal()];
        if (i5 == 1) {
            return b(j5 - a.u(this), j$.time.temporal.b.SECONDS);
        }
        if (i5 != 2) {
            return v(this.f1054c, this.f1053b, this.f1052a.a(j5, qVar));
        }
        ZoneOffset C4 = ZoneOffset.C(aVar.f1181b.a(j5, aVar));
        C0461g gVar = this.f1052a;
        gVar.getClass();
        Instant w4 = Instant.w(a.t(gVar, C4), (long) gVar.f1044b.f1157d);
        ZoneId zoneId = this.f1054c;
        l chronology = getChronology();
        ZoneOffset d5 = zoneId.v().d(w4);
        Objects.requireNonNull(d5, TypedValues.CycleType.S_WAVE_OFFSET);
        return new k(zoneId, d5, (C0461g) chronology.p(LocalDateTime.z(w4.f1007a, w4.f1008b, d5)));
    }

    /* renamed from: w */
    public final k b(long j5, s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return k(getChronology(), sVar.e(this, j5));
        }
        return k(getChronology(), this.f1052a.b(j5, sVar).k(this));
    }

    private Object writeReplace() {
        return new E((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoZonedDateTime) && a.i(this, (ChronoZonedDateTime) obj) == 0;
    }

    public final m f(g gVar) {
        return k(getChronology(), gVar.k(this));
    }

    public final m n(long j5, j$.time.temporal.b bVar) {
        return k(getChronology(), r.b(this, j5, bVar));
    }

    public final Instant toInstant() {
        return Instant.w(toEpochSecond(), (long) toLocalTime().f1157d);
    }
}
