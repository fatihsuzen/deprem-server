package r;

import p.f;
import p.i;
import v.C1892a;

public abstract class l {
    public static void a(i iVar, f fVar) {
        if (iVar instanceof s) {
            u.c().e().l(((s) iVar).d().f(fVar), 1);
            return;
        }
        C1892a.g("ForcedSender", "Expected instance of `TransportImpl`, got `%s`.", iVar);
    }
}
