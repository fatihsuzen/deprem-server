package J2;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.t;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final Long f18277a;

    /* renamed from: b  reason: collision with root package name */
    public final Map f18278b;

    public h(Long l5, Map map) {
        t.e(map, "cmpInfoMap");
        this.f18277a = l5;
        this.f18278b = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (t.a(this.f18277a, hVar.f18277a) && t.a(this.f18278b, hVar.f18278b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        Long l5 = this.f18277a;
        if (l5 == null) {
            i5 = 0;
        } else {
            i5 = l5.hashCode();
        }
        return this.f18278b.hashCode() + (i5 * 31);
    }

    public final String toString() {
        return "IabApprovedCmpList(lastUpdated=" + this.f18277a + ", cmpInfoMap=" + this.f18278b + ')';
    }

    public /* synthetic */ h() {
        this((Long) null, new LinkedHashMap());
    }
}
