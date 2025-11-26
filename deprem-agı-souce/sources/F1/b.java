package F1;

import J2.v;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.inmobi.cmp.model.Regulations;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public DisplayStatus f2463a;

    /* renamed from: b  reason: collision with root package name */
    public String f2464b;

    /* renamed from: c  reason: collision with root package name */
    public Regulations f2465c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2466d;

    public b(DisplayStatus displayStatus, String str, Regulations regulations, boolean z4) {
        t.e(displayStatus, "displayStatus");
        t.e(str, "displayMessage");
        t.e(regulations, "regulationShown");
        this.f2463a = displayStatus;
        this.f2464b = str;
        this.f2465c = regulations;
        this.f2466d = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f2463a == bVar.f2463a && t.a(this.f2464b, bVar.f2464b) && this.f2465c == bVar.f2465c && this.f2466d == bVar.f2466d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.f2465c.hashCode() + v.a(this.f2464b, this.f2463a.hashCode() * 31, 31)) * 31;
        boolean z4 = this.f2466d;
        if (z4) {
            z4 = true;
        }
        return hashCode + (z4 ? 1 : 0);
    }

    public String toString() {
        return "DisplayInfo(displayStatus=" + this.f2463a + ", displayMessage=" + this.f2464b + ", regulationShown=" + this.f2465c + ", gbcShown=" + this.f2466d + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(DisplayStatus displayStatus, String str, Regulations regulations, boolean z4, int i5, C2633k kVar) {
        this(displayStatus, str, regulations, (i5 & 8) != 0 ? false : z4);
    }
}
