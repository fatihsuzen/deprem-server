package w3;

import W2.t;

/* renamed from: w3.x  reason: case insensitive filesystem */
public abstract class C2905x {
    public static final C2901v a(C2908y0 y0Var) {
        return new C2903w(y0Var);
    }

    public static /* synthetic */ C2901v b(C2908y0 y0Var, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            y0Var = null;
        }
        return a(y0Var);
    }

    public static final boolean c(C2901v vVar, Object obj) {
        Throwable e5 = t.e(obj);
        if (e5 == null) {
            return vVar.v(obj);
        }
        return vVar.t(e5);
    }
}
