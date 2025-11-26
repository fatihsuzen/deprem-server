package N3;

import M3.C2128b;
import kotlin.jvm.internal.t;

/* renamed from: N3.q  reason: case insensitive filesystem */
public abstract class C2147q {
    public static final C2138h a(C2149t tVar, C2128b bVar) {
        t.e(tVar, "sb");
        t.e(bVar, "json");
        if (bVar.c().m()) {
            return new C2146p(tVar, bVar);
        }
        return new C2138h(tVar);
    }
}
