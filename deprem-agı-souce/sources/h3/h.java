package H3;

import K3.c;
import K3.f;
import L3.C2078b;
import L3.C2080c;
import W2.C2219h;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;

public abstract class h {
    public static final a a(C2078b bVar, c cVar, String str) {
        t.e(bVar, "<this>");
        t.e(cVar, "decoder");
        a c5 = bVar.c(cVar, str);
        if (c5 != null) {
            return c5;
        }
        C2080c.a(str, bVar.e());
        throw new C2219h();
    }

    public static final l b(C2078b bVar, f fVar, Object obj) {
        t.e(bVar, "<this>");
        t.e(fVar, "encoder");
        t.e(obj, "value");
        l d5 = bVar.d(fVar, obj);
        if (d5 != null) {
            return d5;
        }
        C2080c.b(M.b(obj.getClass()), bVar.e());
        throw new C2219h();
    }
}
