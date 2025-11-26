package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.C0456b;
import j$.time.chrono.l;
import j$.time.temporal.n;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.u;

public final class o implements n {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0456b f1130a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f1131b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f1132c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ZoneId f1133d;

    public final /* synthetic */ int e(q qVar) {
        return r.a(this, qVar);
    }

    public o(C0456b bVar, n nVar, l lVar, ZoneId zoneId) {
        this.f1130a = bVar;
        this.f1131b = nVar;
        this.f1132c = lVar;
        this.f1133d = zoneId;
    }

    public final boolean c(q qVar) {
        C0456b bVar = this.f1130a;
        if (bVar == null || !qVar.isDateBased()) {
            return this.f1131b.c(qVar);
        }
        return bVar.c(qVar);
    }

    public final u g(q qVar) {
        C0456b bVar = this.f1130a;
        if (bVar == null || !qVar.isDateBased()) {
            return this.f1131b.g(qVar);
        }
        return bVar.g(qVar);
    }

    public final long q(q qVar) {
        C0456b bVar = this.f1130a;
        if (bVar == null || !qVar.isDateBased()) {
            return this.f1131b.q(qVar);
        }
        return bVar.q(qVar);
    }

    public final Object h(a aVar) {
        if (aVar == r.f1200b) {
            return this.f1132c;
        }
        if (aVar == r.f1199a) {
            return this.f1133d;
        }
        if (aVar == r.f1201c) {
            return this.f1131b.h(aVar);
        }
        return aVar.a(this);
    }

    public final String toString() {
        String str;
        String str2 = "";
        l lVar = this.f1132c;
        if (lVar != null) {
            str = " with chronology " + lVar;
        } else {
            str = str2;
        }
        ZoneId zoneId = this.f1133d;
        if (zoneId != null) {
            str2 = " with zone " + zoneId;
        }
        return this.f1131b + str + str2;
    }
}
