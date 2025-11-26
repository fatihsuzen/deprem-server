package T3;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final List f19208a;

    /* renamed from: b  reason: collision with root package name */
    public final a f19209b;

    public b(List list, a aVar) {
        t.e(list, "countries");
        t.e(aVar, "actionButtonSettings");
        this.f19208a = list;
        this.f19209b = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (t.a(this.f19208a, bVar.f19208a) && t.a(this.f19209b, bVar.f19209b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f19209b.hashCode() + (this.f19208a.hashCode() * 31);
    }

    public final String toString() {
        return "ConsentOrPayConfig(countries=" + this.f19208a + ", actionButtonSettings=" + this.f19209b + ')';
    }

    public /* synthetic */ b() {
        this(new ArrayList(), new a());
    }
}
