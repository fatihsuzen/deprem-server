package T3;

import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import kotlin.jvm.internal.t;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f19265a;

    /* renamed from: b  reason: collision with root package name */
    public final GBCConsentValue f19266b;

    public e(int i5, GBCConsentValue gBCConsentValue) {
        t.e(gBCConsentValue, "defaultValue");
        this.f19265a = i5;
        this.f19266b = gBCConsentValue;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f19265a == eVar.f19265a && this.f19266b == eVar.f19266b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f19266b.hashCode() + (this.f19265a * 31);
    }

    public final String toString() {
        return "GBCApplicablePurpose(id=" + this.f19265a + ", defaultValue=" + this.f19266b + ')';
    }
}
