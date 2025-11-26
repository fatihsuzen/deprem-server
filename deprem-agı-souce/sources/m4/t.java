package m4;

import java.util.ArrayList;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public final g f25496a;

    /* renamed from: b  reason: collision with root package name */
    public final p f25497b;

    /* renamed from: c  reason: collision with root package name */
    public final k f25498c;

    /* renamed from: d  reason: collision with root package name */
    public final e f25499d;

    /* renamed from: e  reason: collision with root package name */
    public final a f25500e;

    public t(g gVar, p pVar, k kVar, e eVar, a aVar) {
        kotlin.jvm.internal.t.e(gVar, "coreUiLabels");
        kotlin.jvm.internal.t.e(pVar, "premiumUiLabels");
        kotlin.jvm.internal.t.e(kVar, "mobileUiLabels");
        kotlin.jvm.internal.t.e(eVar, "consentOrPay");
        kotlin.jvm.internal.t.e(aVar, "advanced");
        this.f25496a = gVar;
        this.f25497b = pVar;
        this.f25498c = kVar;
        this.f25499d = eVar;
        this.f25500e = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (kotlin.jvm.internal.t.a(this.f25496a, tVar.f25496a) && kotlin.jvm.internal.t.a(this.f25497b, tVar.f25497b) && kotlin.jvm.internal.t.a(this.f25498c, tVar.f25498c) && kotlin.jvm.internal.t.a(this.f25499d, tVar.f25499d) && kotlin.jvm.internal.t.a(this.f25500e, tVar.f25500e)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f25497b.hashCode();
        int hashCode2 = this.f25498c.hashCode();
        int hashCode3 = this.f25499d.hashCode();
        return this.f25500e.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (this.f25496a.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "TranslationsText(coreUiLabels=" + this.f25496a + ", premiumUiLabels=" + this.f25497b + ", mobileUiLabels=" + this.f25498c + ", consentOrPay=" + this.f25499d + ", advanced=" + this.f25500e + ')';
    }

    public /* synthetic */ t() {
        this(new g(), new p((String) null, (String) null, (String) null, (ArrayList) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, 1023), new k(), new e(), new a());
    }
}
