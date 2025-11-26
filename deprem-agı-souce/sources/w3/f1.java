package w3;

import B3.C1988h;
import B3.C1989i;
import W2.J;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import kotlin.coroutines.jvm.internal.h;

public abstract class f1 {
    public static final Object a(C2308e eVar) {
        C1988h hVar;
        Object obj;
        C2312i context = eVar.getContext();
        B0.g(context);
        C2308e c5 = C2316b.c(eVar);
        if (c5 instanceof C1988h) {
            hVar = (C1988h) c5;
        } else {
            hVar = null;
        }
        if (hVar == null) {
            obj = J.f19942a;
        } else {
            if (hVar.f17394d.isDispatchNeeded(context)) {
                hVar.n(context, J.f19942a);
            } else {
                e1 e1Var = new e1();
                C2312i plus = context.plus(e1Var);
                J j5 = J.f19942a;
                hVar.n(plus, j5);
                if (e1Var.f26281a) {
                    if (C1989i.c(hVar)) {
                        obj = C2316b.f();
                    } else {
                        obj = j5;
                    }
                }
            }
            obj = C2316b.f();
        }
        if (obj == C2316b.f()) {
            h.c(eVar);
        }
        if (obj == C2316b.f()) {
            return obj;
        }
        return J.f19942a;
    }
}
