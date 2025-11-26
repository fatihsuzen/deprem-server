package R2;

import kotlin.jvm.internal.t;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f18951a;

    /* renamed from: b  reason: collision with root package name */
    public final a f18952b;

    public b(Integer num, a aVar) {
        this.f18951a = num;
        this.f18952b = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (t.a(this.f18951a, bVar.f18951a) && t.a(this.f18952b, bVar.f18952b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        Integer num = this.f18951a;
        int i6 = 0;
        if (num == null) {
            i5 = 0;
        } else {
            i5 = num.hashCode();
        }
        int i7 = i5 * 31;
        a aVar = this.f18952b;
        if (aVar != null) {
            i6 = aVar.hashCode();
        }
        return i7 + i6;
    }

    public final String toString() {
        return "GBCPurpose(id=" + this.f18951a + ", banner=" + this.f18952b + ')';
    }
}
