package L2;

import java.util.List;
import kotlin.jvm.internal.t;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f18419a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f18420b;

    /* renamed from: c  reason: collision with root package name */
    public final List f18421c;

    public h(Boolean bool, Integer num, List list) {
        this.f18419a = bool;
        this.f18420b = num;
        this.f18421c = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (t.a(this.f18419a, hVar.f18419a) && t.a(this.f18420b, hVar.f18420b) && t.a(this.f18421c, hVar.f18421c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        int i6;
        Boolean bool = this.f18419a;
        int i7 = 0;
        if (bool == null) {
            i5 = 0;
        } else {
            i5 = bool.hashCode();
        }
        int i8 = i5 * 31;
        Integer num = this.f18420b;
        if (num == null) {
            i6 = 0;
        } else {
            i6 = num.hashCode();
        }
        int i9 = (i8 + i6) * 31;
        List list = this.f18421c;
        if (list != null) {
            i7 = list.hashCode();
        }
        return i9 + i7;
    }

    public final String toString() {
        return "EncodingOptions(isForVendors=" + this.f18419a + ", version=" + this.f18420b + ", segments=" + this.f18421c + ')';
    }
}
