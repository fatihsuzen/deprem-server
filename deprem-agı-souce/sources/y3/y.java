package y3;

import b3.C2308e;
import k3.l;

public interface y {

    public static final class a {
        public static /* synthetic */ boolean a(y yVar, Throwable th, int i5, Object obj) {
            if (obj == null) {
                if ((i5 & 1) != 0) {
                    th = null;
                }
                return yVar.i(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }

    boolean D();

    Object e(Object obj, C2308e eVar);

    boolean i(Throwable th);

    Object r(Object obj);

    void w(l lVar);
}
