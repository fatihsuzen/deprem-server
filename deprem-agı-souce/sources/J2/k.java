package J2;

import L2.g;
import kotlin.jvm.internal.t;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f18283a;

    /* renamed from: b  reason: collision with root package name */
    public final m f18284b;

    public k(int i5, m mVar) {
        t.e(mVar, "restrictionType");
        this.f18283a = i5;
        this.f18284b = mVar;
    }

    public final String a() {
        if (this.f18283a > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f18283a);
            sb.append('-');
            sb.append(this.f18284b.f18293a);
            return sb.toString();
        }
        throw new g(t.n("f.k", ": TCModelError, cannot hash invalid PurposeRestriction"));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (this.f18283a == kVar.f18283a && this.f18284b == kVar.f18284b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f18284b.hashCode() + (this.f18283a * 31);
    }

    public final String toString() {
        return "PurposeRestriction(purposeId=" + this.f18283a + ", restrictionType=" + this.f18284b + ')';
    }
}
