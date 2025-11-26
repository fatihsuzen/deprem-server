package J3;

import L3.Q0;
import O3.d;
import java.util.List;
import kotlin.jvm.internal.t;
import r3.C2733c;

public abstract class b {
    public static final C2733c a(f fVar) {
        t.e(fVar, "<this>");
        if (fVar instanceof c) {
            return ((c) fVar).f18355b;
        }
        if (fVar instanceof Q0) {
            return a(((Q0) fVar).j());
        }
        return null;
    }

    public static final f b(d dVar, f fVar) {
        H3.b c5;
        t.e(dVar, "<this>");
        t.e(fVar, "descriptor");
        C2733c a5 = a(fVar);
        if (a5 == null || (c5 = d.c(dVar, a5, (List) null, 2, (Object) null)) == null) {
            return null;
        }
        return c5.getDescriptor();
    }

    public static final f c(f fVar, C2733c cVar) {
        t.e(fVar, "<this>");
        t.e(cVar, "context");
        return new c(fVar, cVar);
    }
}
