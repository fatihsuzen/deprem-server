package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.C0456b;
import j$.time.chrono.l;
import j$.time.chrono.s;
import j$.time.temporal.a;
import j$.time.temporal.n;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.util.Objects;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final n f1134a;

    /* renamed from: b  reason: collision with root package name */
    public final DateTimeFormatter f1135b;

    /* renamed from: c  reason: collision with root package name */
    public int f1136c;

    public p(n nVar, DateTimeFormatter dateTimeFormatter) {
        l lVar = dateTimeFormatter.f1097d;
        if (lVar != null) {
            l lVar2 = (l) nVar.h(r.f1200b);
            ZoneId zoneId = (ZoneId) nVar.h(r.f1199a);
            C0456b bVar = null;
            lVar = Objects.equals(lVar, lVar2) ? null : lVar;
            Objects.equals((Object) null, zoneId);
            if (lVar != null) {
                l lVar3 = lVar != null ? lVar : lVar2;
                if (lVar != null) {
                    if (nVar.c(a.EPOCH_DAY)) {
                        bVar = lVar3.o(nVar);
                    } else if (!(lVar == s.f1072c && lVar2 == null)) {
                        a[] values = a.values();
                        int length = values.length;
                        int i5 = 0;
                        while (i5 < length) {
                            a aVar = values[i5];
                            if (!aVar.isDateBased() || !nVar.c(aVar)) {
                                i5++;
                            } else {
                                throw new RuntimeException("Unable to apply override chronology '" + lVar + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + nVar);
                            }
                        }
                    }
                }
                nVar = new o(bVar, nVar, lVar3, zoneId);
            }
        }
        this.f1134a = nVar;
        this.f1135b = dateTimeFormatter;
    }

    public final Long a(q qVar) {
        int i5 = this.f1136c;
        n nVar = this.f1134a;
        if (i5 <= 0 || nVar.c(qVar)) {
            return Long.valueOf(nVar.q(qVar));
        }
        return null;
    }

    public final String toString() {
        return this.f1134a.toString();
    }
}
