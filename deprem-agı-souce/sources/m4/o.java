package m4;

import kotlin.jvm.internal.t;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final String f25473a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25474b;

    public o(String str, String str2) {
        t.e(str, "disclosureLabel");
        t.e(str2, "backLabel");
        this.f25473a = str;
        this.f25474b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (t.a(this.f25473a, oVar.f25473a) && t.a(this.f25474b, oVar.f25474b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f25474b.hashCode() + (this.f25473a.hashCode() * 31);
    }

    public final String toString() {
        return "PartnersDisclosureLabels(disclosureLabel=" + this.f25473a + ", backLabel=" + this.f25474b + ')';
    }
}
