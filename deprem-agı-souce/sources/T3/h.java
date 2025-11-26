package T3;

import J2.v;
import X2.C2250q;
import java.util.List;
import kotlin.jvm.internal.t;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final List f19277a;

    /* renamed from: b  reason: collision with root package name */
    public final String f19278b;

    /* renamed from: c  reason: collision with root package name */
    public final String f19279c;

    public h(List list, String str, String str2) {
        t.e(list, "nonIabVendorList");
        t.e(str, "updateAt");
        t.e(str2, "nonIabVendorsHash");
        this.f19277a = list;
        this.f19278b = str;
        this.f19279c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (t.a(this.f19277a, hVar.f19277a) && t.a(this.f19278b, hVar.f19278b) && t.a(this.f19279c, hVar.f19279c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f19279c.hashCode() + v.a(this.f19278b, this.f19277a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "NonIabVendorsInfo(nonIabVendorList=" + this.f19277a + ", updateAt=" + this.f19278b + ", nonIabVendorsHash=" + this.f19279c + ')';
    }

    public /* synthetic */ h() {
        this(C2250q.g(), "", "");
    }
}
