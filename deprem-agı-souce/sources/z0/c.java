package Z0;

import java.util.Iterator;
import java.util.Set;
import r0.C1786c;
import r0.C1788e;
import r0.r;

public class c implements i {

    /* renamed from: a  reason: collision with root package name */
    private final String f4500a;

    /* renamed from: b  reason: collision with root package name */
    private final d f4501b;

    c(Set set, d dVar) {
        this.f4500a = d(set);
        this.f4501b = dVar;
    }

    public static /* synthetic */ i b(C1788e eVar) {
        return new c(eVar.h(f.class), d.a());
    }

    public static C1786c c() {
        return C1786c.c(i.class).b(r.o(f.class)).f(new b()).d();
    }

    private static String d(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            sb.append(fVar.b());
            sb.append('/');
            sb.append(fVar.c());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public String a() {
        if (this.f4501b.b().isEmpty()) {
            return this.f4500a;
        }
        return this.f4500a + ' ' + d(this.f4501b.b());
    }
}
