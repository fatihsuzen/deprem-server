package T3;

import R3.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final List f19288a;

    /* renamed from: b  reason: collision with root package name */
    public final List f19289b;

    /* renamed from: c  reason: collision with root package name */
    public final List f19290c;

    public j(List list, List list2, List list3) {
        t.e(list, "vendorBlacklist");
        t.e(list2, "vendorWhitelist");
        t.e(list3, "googleWhitelist");
        this.f19288a = list;
        this.f19289b = list2;
        this.f19290c = list3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (t.a(this.f19288a, jVar.f19288a) && t.a(this.f19289b, jVar.f19289b) && t.a(this.f19290c, jVar.f19290c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f19290c.hashCode() + m.a(this.f19289b, this.f19288a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "PremiumProperties(vendorBlacklist=" + this.f19288a + ", vendorWhitelist=" + this.f19289b + ", googleWhitelist=" + this.f19290c + ')';
    }

    public /* synthetic */ j() {
        this(new ArrayList(), new ArrayList(), new ArrayList());
    }
}
