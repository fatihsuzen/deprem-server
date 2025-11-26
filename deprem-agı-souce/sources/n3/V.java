package N3;

import J3.b;
import J3.e;
import J3.f;
import J3.n;
import J3.o;
import M3.C2128b;
import O3.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.t;

public abstract class V {
    public static final f a(f fVar, d dVar) {
        f a5;
        t.e(fVar, "<this>");
        t.e(dVar, "module");
        if (t.a(fVar.getKind(), n.a.f18388a)) {
            f b5 = b.b(dVar, fVar);
            if (b5 == null || (a5 = a(b5, dVar)) == null) {
                return fVar;
            }
            return a5;
        } else if (fVar.isInline()) {
            return a(fVar.h(0), dVar);
        } else {
            return fVar;
        }
    }

    public static final U b(C2128b bVar, f fVar) {
        t.e(bVar, "<this>");
        t.e(fVar, CampaignEx.JSON_KEY_DESC);
        n kind = fVar.getKind();
        if (kind instanceof J3.d) {
            return U.POLY_OBJ;
        }
        if (t.a(kind, o.b.f18391a)) {
            return U.LIST;
        }
        if (!t.a(kind, o.c.f18392a)) {
            return U.OBJ;
        }
        f a5 = a(fVar.h(0), bVar.d());
        n kind2 = a5.getKind();
        if ((kind2 instanceof e) || t.a(kind2, n.b.f18389a)) {
            return U.MAP;
        }
        if (bVar.c().c()) {
            return U.LIST;
        }
        throw z.c(a5);
    }
}
