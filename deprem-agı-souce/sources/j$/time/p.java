package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.temporal.a;
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

public final class p implements m, o, Comparable, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f1166c = 0;
    private static final long serialVersionUID = 7264499704384272492L;

    /* renamed from: a  reason: collision with root package name */
    public final j f1167a;

    /* renamed from: b  reason: collision with root package name */
    public final ZoneOffset f1168b;

    public final int compareTo(Object obj) {
        p pVar = (p) obj;
        if (this.f1168b.equals(pVar.f1168b)) {
            return this.f1167a.compareTo(pVar.f1167a);
        }
        int compare = Long.compare(this.f1167a.G() - (((long) this.f1168b.f1021b) * C.NANOS_PER_SECOND), pVar.f1167a.G() - (((long) pVar.f1168b.f1021b) * C.NANOS_PER_SECOND));
        return compare == 0 ? this.f1167a.compareTo(pVar.f1167a) : compare;
    }

    static {
        j jVar = j.f1150e;
        ZoneOffset zoneOffset = ZoneOffset.f1020g;
        jVar.getClass();
        new p(jVar, zoneOffset);
        j jVar2 = j.f1151f;
        ZoneOffset zoneOffset2 = ZoneOffset.f1019f;
        jVar2.getClass();
        new p(jVar2, zoneOffset2);
    }

    public p(j jVar, ZoneOffset zoneOffset) {
        this.f1167a = (j) Objects.requireNonNull(jVar, "time");
        this.f1168b = (ZoneOffset) Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
    }

    public final p w(j jVar, ZoneOffset zoneOffset) {
        if (this.f1167a != jVar || !this.f1168b.equals(zoneOffset)) {
            return new p(jVar, zoneOffset);
        }
        return this;
    }

    public final boolean c(q qVar) {
        return qVar instanceof a ? ((a) qVar).n() || qVar == a.OFFSET_SECONDS : qVar != null && qVar.e(this);
    }

    public final u g(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.f(this);
        }
        if (qVar == a.OFFSET_SECONDS) {
            return ((a) qVar).f1181b;
        }
        j jVar = this.f1167a;
        jVar.getClass();
        return r.d(jVar, qVar);
    }

    public final int e(q qVar) {
        return r.a(this, qVar);
    }

    public final long q(q qVar) {
        if (qVar instanceof a) {
            return qVar == a.OFFSET_SECONDS ? (long) this.f1168b.f1021b : this.f1167a.q(qVar);
        }
        return qVar.g(this);
    }

    public final m a(long j5, q qVar) {
        if (!(qVar instanceof a)) {
            return (p) qVar.h(this, j5);
        }
        if (qVar != a.OFFSET_SECONDS) {
            return w(this.f1167a.a(j5, qVar), this.f1168b);
        }
        a aVar = (a) qVar;
        return w(this.f1167a, ZoneOffset.C(aVar.f1181b.a(j5, aVar)));
    }

    /* renamed from: v */
    public final p b(long j5, s sVar) {
        if (sVar instanceof b) {
            return w(this.f1167a.b(j5, sVar), this.f1168b);
        }
        return (p) sVar.e(this, j5);
    }

    public final m n(long j5, b bVar) {
        return j5 == Long.MIN_VALUE ? b(Long.MAX_VALUE, bVar).b(1, bVar) : b(-j5, bVar);
    }

    public final Object h(j$.time.format.a aVar) {
        if (aVar == r.f1202d || aVar == r.f1203e) {
            return this.f1168b;
        }
        boolean z4 = false;
        boolean z5 = aVar == r.f1199a;
        if (aVar == r.f1200b) {
            z4 = true;
        }
        if ((z5 || z4) || aVar == r.f1204f) {
            return null;
        }
        if (aVar == r.f1205g) {
            return this.f1167a;
        }
        if (aVar == r.f1201c) {
            return b.NANOS;
        }
        return aVar.a(this);
    }

    public final m k(m mVar) {
        return mVar.a(this.f1167a.G(), a.NANO_OF_DAY).a((long) this.f1168b.f1021b, a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            return this.f1167a.equals(pVar.f1167a) && this.f1168b.equals(pVar.f1168b);
        }
    }

    public final int hashCode() {
        return this.f1167a.hashCode() ^ this.f1168b.f1021b;
    }

    public final String toString() {
        String jVar = this.f1167a.toString();
        String str = this.f1168b.f1022c;
        return jVar + str;
    }

    private Object writeReplace() {
        return new r((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final m f(g gVar) {
        return (p) j$.com.android.tools.r8.a.a(gVar, this);
    }
}
