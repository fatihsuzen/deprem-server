package J2;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.t;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public Map f18273a;

    public f(Map map) {
        t.e(map, "googleVendorsInfoList");
        this.f18273a = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof f) && t.a(this.f18273a, ((f) obj).f18273a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f18273a.hashCode();
    }

    public final String toString() {
        return "GoogleVendorList(googleVendorsInfoList=" + this.f18273a + ')';
    }

    public /* synthetic */ f() {
        this(new LinkedHashMap());
    }
}
