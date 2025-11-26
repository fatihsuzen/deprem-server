package w3;

import b3.C2309f;
import b3.C2312i;
import b3.C2313j;
import k3.p;

/* renamed from: w3.h  reason: case insensitive filesystem */
abstract /* synthetic */ class C2874h {
    public static final Object a(C2312i iVar, p pVar) {
        C2312i iVar2;
        C2877i0 i0Var;
        C2877i0 i0Var2;
        Thread currentThread = Thread.currentThread();
        C2309f fVar = (C2309f) iVar.get(C2309f.f20792a0);
        if (fVar == null) {
            i0Var = W0.f26260a.b();
            iVar2 = G.k(C2896s0.f26313a, iVar.plus(i0Var));
        } else {
            C2877i0 i0Var3 = null;
            if (fVar instanceof C2877i0) {
                i0Var2 = (C2877i0) fVar;
            } else {
                i0Var2 = null;
            }
            if (i0Var2 != null) {
                if (i0Var2.Q()) {
                    i0Var3 = i0Var2;
                }
                if (i0Var3 != null) {
                    i0Var = i0Var3;
                    iVar2 = G.k(C2896s0.f26313a, iVar);
                }
            }
            i0Var = W0.f26260a.a();
            iVar2 = G.k(C2896s0.f26313a, iVar);
        }
        C2868e eVar = new C2868e(iVar2, currentThread, i0Var);
        eVar.P0(O.DEFAULT, eVar, pVar);
        return eVar.Q0();
    }

    public static /* synthetic */ Object b(C2312i iVar, p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            iVar = C2313j.f20794a;
        }
        return C2872g.e(iVar, pVar);
    }
}
