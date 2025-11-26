package A3;

import B3.z;
import b3.C2312i;
import kotlin.jvm.internal.t;
import w3.C2908y0;

public abstract class w {
    public static final void b(t tVar, C2312i iVar) {
        if (((Number) iVar.fold(0, new v(tVar))).intValue() != tVar.f17316c) {
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + tVar.f17315b + ",\n\t\tbut emission happened in " + iVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
        }
    }

    /* access modifiers changed from: private */
    public static final int c(t tVar, int i5, C2312i.b bVar) {
        C2312i.c key = bVar.getKey();
        C2312i.b bVar2 = tVar.f17315b.get(key);
        if (key == C2908y0.f26320k0) {
            C2908y0 y0Var = (C2908y0) bVar2;
            t.c(bVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
            C2908y0 d5 = d((C2908y0) bVar, y0Var);
            if (d5 != y0Var) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + d5 + ", expected child of " + y0Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
            } else if (y0Var == null) {
                return i5;
            } else {
                return i5 + 1;
            }
        } else if (bVar != bVar2) {
            return Integer.MIN_VALUE;
        } else {
            return i5 + 1;
        }
    }

    public static final C2908y0 d(C2908y0 y0Var, C2908y0 y0Var2) {
        while (y0Var != null) {
            if (y0Var == y0Var2 || !(y0Var instanceof z)) {
                return y0Var;
            }
            y0Var = ((z) y0Var).c0();
        }
        return null;
    }
}
