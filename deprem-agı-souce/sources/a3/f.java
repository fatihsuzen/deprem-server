package A3;

import B3.K;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.S;
import z3.C2973f;

public abstract class f {
    /* JADX INFO: finally extract failed */
    public static final Object b(C2312i iVar, Object obj, Object obj2, p pVar, C2308e eVar) {
        Object obj3;
        Object i5 = K.i(iVar, obj2);
        try {
            y yVar = new y(eVar, iVar);
            if (!(pVar instanceof a)) {
                obj3 = C2316b.d(pVar, obj, yVar);
            } else {
                obj3 = ((p) S.c(pVar, 2)).invoke(obj, yVar);
            }
            K.f(iVar, i5);
            if (obj3 == C2316b.f()) {
                h.c(eVar);
            }
            return obj3;
        } catch (Throwable th) {
            K.f(iVar, i5);
            throw th;
        }
    }

    public static /* synthetic */ Object c(C2312i iVar, Object obj, Object obj2, p pVar, C2308e eVar, int i5, Object obj3) {
        if ((i5 & 4) != 0) {
            obj2 = K.g(iVar);
        }
        return b(iVar, obj, obj2, pVar, eVar);
    }

    /* access modifiers changed from: private */
    public static final C2973f d(C2973f fVar, C2312i iVar) {
        if ((fVar instanceof x) || (fVar instanceof q)) {
            return fVar;
        }
        return new z(fVar, iVar);
    }
}
