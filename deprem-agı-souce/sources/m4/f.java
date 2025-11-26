package m4;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final List f25338a;

    public f(List list) {
        t.e(list, "disclosures");
        this.f25338a = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof f) && t.a(this.f25338a, ((f) obj).f25338a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f25338a.hashCode();
    }

    public final String toString() {
        return "CookieDisclosure(disclosures=" + this.f25338a + ')';
    }

    public /* synthetic */ f() {
        this(new ArrayList());
    }
}
