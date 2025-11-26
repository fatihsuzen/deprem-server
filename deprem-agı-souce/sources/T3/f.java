package T3;

import R3.m;
import X2.C2250q;
import java.util.List;
import kotlin.jvm.internal.t;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f19267a;

    /* renamed from: b  reason: collision with root package name */
    public final List f19268b;

    /* renamed from: c  reason: collision with root package name */
    public final List f19269c;

    public f(boolean z4, List list, List list2) {
        t.e(list, "locations");
        t.e(list2, "applicablePurposes");
        this.f19267a = z4;
        this.f19268b = list;
        this.f19269c = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f19267a == fVar.f19267a && t.a(this.f19268b, fVar.f19268b) && t.a(this.f19269c, fVar.f19269c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        boolean z4 = this.f19267a;
        if (z4) {
            z4 = true;
        }
        return this.f19269c.hashCode() + m.a(this.f19268b, (z4 ? 1 : 0) * true, 31);
    }

    public final String toString() {
        return "GBCConfig(enabled=" + this.f19267a + ", locations=" + this.f19268b + ", applicablePurposes=" + this.f19269c + ')';
    }

    public /* synthetic */ f() {
        this(false, C2250q.g(), C2250q.g());
    }
}
