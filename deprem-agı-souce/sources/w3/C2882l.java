package w3;

import b3.C2308e;
import k3.l;
import k3.q;

/* renamed from: w3.l  reason: case insensitive filesystem */
public interface C2882l extends C2308e {

    /* renamed from: w3.l$a */
    public static final class a {
        public static /* synthetic */ boolean a(C2882l lVar, Throwable th, int i5, Object obj) {
            if (obj == null) {
                if ((i5 & 1) != 0) {
                    th = null;
                }
                return lVar.k(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
    }

    void E(Object obj);

    void c(Object obj, q qVar);

    void g(l lVar);

    void h(I i5, Object obj);

    boolean k(Throwable th);

    Object q(Object obj, Object obj2, q qVar);
}
