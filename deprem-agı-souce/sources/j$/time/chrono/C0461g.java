package j$.time.chrono;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.ZoneOffset;
import j$.time.format.a;
import j$.time.g;
import j$.time.j;
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

/* renamed from: j$.time.chrono.g  reason: case insensitive filesystem */
public final class C0461g implements C0459e, m, o, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;

    /* renamed from: a  reason: collision with root package name */
    public final transient C0456b f1043a;

    /* renamed from: b  reason: collision with root package name */
    public final transient j f1044b;

    public final /* synthetic */ Object h(a aVar) {
        return j$.com.android.tools.r8.a.q(this, aVar);
    }

    /* renamed from: t */
    public final /* synthetic */ int compareTo(C0459e eVar) {
        return j$.com.android.tools.r8.a.h(this, eVar);
    }

    public static C0461g v(l lVar, m mVar) {
        C0461g gVar = (C0461g) mVar;
        if (lVar.equals(gVar.f1043a.getChronology())) {
            return gVar;
        }
        String d5 = lVar.d();
        String d6 = gVar.f1043a.getChronology().d();
        throw new ClassCastException("Chronology mismatch, required: " + d5 + ", actual: " + d6);
    }

    public C0461g(C0456b bVar, j jVar) {
        Objects.requireNonNull(bVar, "date");
        Objects.requireNonNull(jVar, "time");
        this.f1043a = bVar;
        this.f1044b = jVar;
    }

    public final C0461g z(m mVar, j jVar) {
        C0456b bVar = this.f1043a;
        if (bVar == mVar && this.f1044b == jVar) {
            return this;
        }
        return new C0461g(C0458d.v(bVar.getChronology(), mVar), jVar);
    }

    public final l getChronology() {
        return this.f1043a.getChronology();
    }

    public final int hashCode() {
        return this.f1043a.hashCode() ^ this.f1044b.hashCode();
    }

    public final m n(long j5, b bVar) {
        return v(this.f1043a.getChronology(), r.b(this, j5, bVar));
    }

    public final C0456b toLocalDate() {
        return this.f1043a;
    }

    public final String toString() {
        String bVar = this.f1043a.toString();
        String jVar = this.f1044b.toString();
        return bVar + ExifInterface.GPS_DIRECTION_TRUE + jVar;
    }

    public final j toLocalTime() {
        return this.f1044b;
    }

    public final boolean c(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar != null && qVar.e(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        return aVar.isDateBased() || aVar.n();
    }

    public final u g(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.f(this);
        }
        if (!((j$.time.temporal.a) qVar).n()) {
            return this.f1043a.g(qVar);
        }
        j jVar = this.f1044b;
        jVar.getClass();
        return r.d(jVar, qVar);
    }

    public final int e(q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).n() ? this.f1044b.e(qVar) : this.f1043a.e(qVar);
        }
        return g(qVar).a(q(qVar), qVar);
    }

    public final long q(q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).n() ? this.f1044b.q(qVar) : this.f1043a.q(qVar);
        }
        return qVar.g(this);
    }

    public final m f(g gVar) {
        return z(gVar, this.f1044b);
    }

    /* renamed from: y */
    public final C0461g a(long j5, q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return v(this.f1043a.getChronology(), qVar.h(this, j5));
        }
        if (((j$.time.temporal.a) qVar).n()) {
            return z(this.f1043a, this.f1044b.a(j5, qVar));
        }
        return z(this.f1043a.a(j5, qVar), this.f1044b);
    }

    /* renamed from: w */
    public final C0461g b(long j5, s sVar) {
        long j6 = j5;
        s sVar2 = sVar;
        if (!(sVar2 instanceof b)) {
            return v(this.f1043a.getChronology(), sVar2.e(this, j6));
        }
        switch (C0460f.f1042a[((b) sVar2).ordinal()]) {
            case 1:
                return x(this.f1043a, 0, 0, 0, j5);
            case 2:
                C0461g z4 = z(this.f1043a.b(j5 / 86400000000L, b.DAYS), this.f1044b);
                return z4.x(z4.f1043a, 0, 0, 0, (j5 % 86400000000L) * 1000);
            case 3:
                C0461g z5 = z(this.f1043a.b(j5 / 86400000, b.DAYS), this.f1044b);
                return z5.x(z5.f1043a, 0, 0, 0, (j5 % 86400000) * 1000000);
            case 4:
                return x(this.f1043a, 0, 0, j5, 0);
            case 5:
                return x(this.f1043a, 0, j5, 0, 0);
            case 6:
                return x(this.f1043a, j6, 0, 0, 0);
            case 7:
                C0461g z6 = z(this.f1043a.b(j6 / 256, b.DAYS), this.f1044b);
                return z6.x(z6.f1043a, (j6 % 256) * 12, 0, 0, 0);
            default:
                return z(this.f1043a.b(j6, sVar2), this.f1044b);
        }
    }

    public final C0461g x(C0456b bVar, long j5, long j6, long j7, long j8) {
        C0456b bVar2 = bVar;
        if ((j5 | j6 | j7 | j8) == 0) {
            return z(bVar2, this.f1044b);
        }
        long j9 = j5 / 24;
        long j10 = ((j5 % 24) * 3600000000000L) + ((j6 % 1440) * 60000000000L) + ((j7 % 86400) * C.NANOS_PER_SECOND) + (j8 % 86400000000000L);
        long G4 = this.f1044b.G();
        long j11 = j10 + G4;
        long B4 = j$.com.android.tools.r8.a.B(j11, 86400000000000L) + j9 + (j6 / 1440) + (j7 / 86400) + (j8 / 86400000000000L);
        long A4 = j$.com.android.tools.r8.a.A(j11, 86400000000000L);
        return z(bVar2.b(B4, b.DAYS), A4 == G4 ? this.f1044b : j.z(A4));
    }

    public final ChronoZonedDateTime i(ZoneOffset zoneOffset) {
        return k.v(zoneOffset, (ZoneOffset) null, this);
    }

    public final m k(m mVar) {
        return mVar.a(toLocalDate().r(), j$.time.temporal.a.EPOCH_DAY).a(toLocalTime().G(), j$.time.temporal.a.NANO_OF_DAY);
    }

    private Object writeReplace() {
        return new E((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0459e) && j$.com.android.tools.r8.a.h(this, (C0459e) obj) == 0;
    }
}
