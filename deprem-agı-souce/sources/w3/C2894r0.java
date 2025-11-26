package w3;

import java.util.concurrent.Executor;

/* renamed from: w3.r0  reason: case insensitive filesystem */
public abstract class C2894r0 {
    public static final Executor a(I i5) {
        C2891p0 p0Var;
        Executor F4;
        if (i5 instanceof C2891p0) {
            p0Var = (C2891p0) i5;
        } else {
            p0Var = null;
        }
        if (p0Var == null || (F4 = p0Var.F()) == null) {
            return new C2863b0(i5);
        }
        return F4;
    }

    public static final I b(Executor executor) {
        C2863b0 b0Var;
        I i5;
        if (executor instanceof C2863b0) {
            b0Var = (C2863b0) executor;
        } else {
            b0Var = null;
        }
        if (b0Var == null || (i5 = b0Var.f26270a) == null) {
            return new C2893q0(executor);
        }
        return i5;
    }
}
