package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.chrono.C0456b;
import j$.time.chrono.C0459e;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.l;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.s;
import j$.time.temporal.u;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class LocalDateTime implements m, o, C0459e, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final LocalDateTime f1009c = y(g.f1142d, j.f1150e);

    /* renamed from: d  reason: collision with root package name */
    public static final LocalDateTime f1010d = y(g.f1143e, j.f1151f);
    private static final long serialVersionUID = 6207766400415563566L;

    /* renamed from: a  reason: collision with root package name */
    public final g f1011a;

    /* renamed from: b  reason: collision with root package name */
    public final j f1012b;

    public final l getChronology() {
        return ((g) toLocalDate()).getChronology();
    }

    public final ChronoZonedDateTime i(ZoneOffset zoneOffset) {
        return ZonedDateTime.v(this, zoneOffset, (ZoneOffset) null);
    }

    public static LocalDateTime y(g gVar, j jVar) {
        Objects.requireNonNull(gVar, "date");
        Objects.requireNonNull(jVar, "time");
        return new LocalDateTime(gVar, jVar);
    }

    public final m k(m mVar) {
        return mVar.a(((g) toLocalDate()).r(), a.EPOCH_DAY).a(toLocalTime().G(), a.NANO_OF_DAY);
    }

    public static LocalDateTime z(long j5, int i5, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        long j6 = (long) i5;
        a.NANO_OF_SECOND.k(j6);
        long j7 = j5 + ((long) zoneOffset.f1021b);
        long j8 = (long) 86400;
        return new LocalDateTime(g.E(j$.com.android.tools.r8.a.B(j7, j8)), j.z((((long) ((int) j$.com.android.tools.r8.a.A(j7, j8))) * C.NANOS_PER_SECOND) + j6));
    }

    public static LocalDateTime w(n nVar) {
        if (nVar instanceof LocalDateTime) {
            return (LocalDateTime) nVar;
        }
        if (nVar instanceof ZonedDateTime) {
            return ((ZonedDateTime) nVar).f1023a;
        }
        if (nVar instanceof OffsetDateTime) {
            return ((OffsetDateTime) nVar).toLocalDateTime();
        }
        try {
            return new LocalDateTime(g.x(nVar), j.x(nVar));
        } catch (b e5) {
            String name = nVar.getClass().getName();
            throw new RuntimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + nVar + " of type " + name, e5);
        }
    }

    public LocalDateTime(g gVar, j jVar) {
        this.f1011a = gVar;
        this.f1012b = jVar;
    }

    public final LocalDateTime E(g gVar, j jVar) {
        if (this.f1011a == gVar && this.f1012b == jVar) {
            return this;
        }
        return new LocalDateTime(gVar, jVar);
    }

    public final boolean c(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar != null && qVar.e(this);
        }
        a aVar = (a) qVar;
        return aVar.isDateBased() || aVar.n();
    }

    public final u g(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.f(this);
        }
        if (!((a) qVar).n()) {
            return this.f1011a.g(qVar);
        }
        j jVar = this.f1012b;
        jVar.getClass();
        return r.d(jVar, qVar);
    }

    public final int e(q qVar) {
        if (qVar instanceof a) {
            return ((a) qVar).n() ? this.f1012b.e(qVar) : this.f1011a.e(qVar);
        }
        return r.a(this, qVar);
    }

    public final long q(q qVar) {
        if (qVar instanceof a) {
            return ((a) qVar).n() ? this.f1012b.q(qVar) : this.f1011a.q(qVar);
        }
        return qVar.g(this);
    }

    public final C0456b toLocalDate() {
        return this.f1011a;
    }

    public final j toLocalTime() {
        return this.f1012b;
    }

    public final m f(g gVar) {
        return E(gVar, this.f1012b);
    }

    /* renamed from: D */
    public final LocalDateTime a(long j5, q qVar) {
        if (!(qVar instanceof a)) {
            return (LocalDateTime) qVar.h(this, j5);
        }
        if (((a) qVar).n()) {
            return E(this.f1011a, this.f1012b.a(j5, qVar));
        }
        return E(this.f1011a.a(j5, qVar), this.f1012b);
    }

    /* renamed from: A */
    public final LocalDateTime b(long j5, s sVar) {
        long j6 = j5;
        s sVar2 = sVar;
        if (!(sVar2 instanceof b)) {
            return (LocalDateTime) sVar2.e(this, j6);
        }
        switch (h.f1147a[((b) sVar2).ordinal()]) {
            case 1:
                return C(this.f1011a, 0, 0, 0, j5);
            case 2:
                LocalDateTime E4 = E(this.f1011a.G(j5 / 86400000000L), this.f1012b);
                return E4.C(E4.f1011a, 0, 0, 0, (j5 % 86400000000L) * 1000);
            case 3:
                LocalDateTime E5 = E(this.f1011a.G(j5 / 86400000), this.f1012b);
                return E5.C(E5.f1011a, 0, 0, 0, (j5 % 86400000) * 1000000);
            case 4:
                return B(j5);
            case 5:
                return C(this.f1011a, 0, j5, 0, 0);
            case 6:
                return C(this.f1011a, j6, 0, 0, 0);
            case 7:
                LocalDateTime E6 = E(this.f1011a.G(j6 / 256), this.f1012b);
                return E6.C(E6.f1011a, (j6 % 256) * 12, 0, 0, 0);
            default:
                return E(this.f1011a.b(j6, sVar2), this.f1012b);
        }
    }

    public final LocalDateTime B(long j5) {
        return C(this.f1011a, 0, 0, j5, 0);
    }

    public final m n(long j5, b bVar) {
        return j5 == Long.MIN_VALUE ? b(Long.MAX_VALUE, bVar).b(1, bVar) : b(-j5, bVar);
    }

    public final LocalDateTime C(g gVar, long j5, long j6, long j7, long j8) {
        g gVar2 = gVar;
        if ((j5 | j6 | j7 | j8) == 0) {
            return E(gVar2, this.f1012b);
        }
        long j9 = j5 / 24;
        long j10 = j9 + (j6 / 1440) + (j7 / 86400) + (j8 / 86400000000000L);
        long j11 = (long) 1;
        long j12 = ((j5 % 24) * 3600000000000L) + ((j6 % 1440) * 60000000000L) + ((j7 % 86400) * C.NANOS_PER_SECOND) + (j8 % 86400000000000L);
        long G4 = this.f1012b.G();
        long j13 = (j12 * j11) + G4;
        long B4 = j$.com.android.tools.r8.a.B(j13, 86400000000000L) + (j10 * j11);
        long A4 = j$.com.android.tools.r8.a.A(j13, 86400000000000L);
        return E(gVar2.G(B4), A4 == G4 ? this.f1012b : j.z(A4));
    }

    public final Object h(j$.time.format.a aVar) {
        if (aVar == r.f1204f) {
            return this.f1011a;
        }
        return j$.com.android.tools.r8.a.q(this, aVar);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.a(this);
    }

    /* renamed from: t */
    public final int compareTo(C0459e eVar) {
        if (eVar instanceof LocalDateTime) {
            return v((LocalDateTime) eVar);
        }
        return j$.com.android.tools.r8.a.h(this, eVar);
    }

    public final int v(LocalDateTime localDateTime) {
        int v5 = this.f1011a.v(localDateTime.f1011a);
        return v5 == 0 ? this.f1012b.compareTo(localDateTime.f1012b) : v5;
    }

    public final boolean x(C0459e eVar) {
        if (eVar instanceof LocalDateTime) {
            return v((LocalDateTime) eVar) < 0;
        }
        int i5 = (this.f1011a.r() > eVar.toLocalDate().r() ? 1 : (this.f1011a.r() == eVar.toLocalDate().r() ? 0 : -1));
        if (i5 >= 0) {
            return i5 == 0 && this.f1012b.G() < eVar.toLocalTime().G();
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            return this.f1011a.equals(localDateTime.f1011a) && this.f1012b.equals(localDateTime.f1012b);
        }
    }

    public final int hashCode() {
        return this.f1011a.hashCode() ^ this.f1012b.hashCode();
    }

    public final String toString() {
        String gVar = this.f1011a.toString();
        String jVar = this.f1012b.toString();
        return gVar + ExifInterface.GPS_DIRECTION_TRUE + jVar;
    }

    private Object writeReplace() {
        return new r((byte) 5, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
