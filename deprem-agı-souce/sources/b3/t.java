package B3;

import W2.C2219h;
import java.util.List;
import w3.I0;

public abstract class t {
    private static final u a(Throwable th, String str) {
        if (th != null) {
            throw th;
        }
        d();
        throw new C2219h();
    }

    static /* synthetic */ u b(Throwable th, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            th = null;
        }
        if ((i5 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final boolean c(I0 i02) {
        return i02.F() instanceof u;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final I0 e(r rVar, List list) {
        try {
            return rVar.b(list);
        } catch (Throwable th) {
            return a(th, rVar.a());
        }
    }
}
