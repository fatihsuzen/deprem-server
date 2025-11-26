package w3;

import B3.C1988h;
import b3.C2308e;

/* renamed from: w3.p  reason: case insensitive filesystem */
public abstract class C2890p {
    public static final void a(C2882l lVar, C2869e0 e0Var) {
        c(lVar, new C2871f0(e0Var));
    }

    public static final C2886n b(C2308e eVar) {
        if (!(eVar instanceof C1988h)) {
            return new C2886n(eVar, 1);
        }
        C2886n m5 = ((C1988h) eVar).m();
        if (m5 != null) {
            if (!m5.O()) {
                m5 = null;
            }
            if (m5 != null) {
                return m5;
            }
        }
        return new C2886n(eVar, 2);
    }

    public static final void c(C2882l lVar, C2880k kVar) {
        if (lVar instanceof C2886n) {
            ((C2886n) lVar).H(kVar);
            return;
        }
        throw new UnsupportedOperationException("third-party implementation of CancellableContinuation is not supported");
    }
}
