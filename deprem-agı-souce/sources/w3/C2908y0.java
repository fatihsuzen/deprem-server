package w3;

import b3.C2308e;
import b3.C2312i;
import java.util.concurrent.CancellationException;
import k3.l;
import k3.p;

/* renamed from: w3.y0  reason: case insensitive filesystem */
public interface C2908y0 extends C2312i.b {

    /* renamed from: k0  reason: collision with root package name */
    public static final b f26320k0 = b.f26321a;

    /* renamed from: w3.y0$a */
    public static final class a {
        public static /* synthetic */ void a(C2908y0 y0Var, CancellationException cancellationException, int i5, Object obj) {
            if (obj == null) {
                if ((i5 & 1) != 0) {
                    cancellationException = null;
                }
                y0Var.a(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static Object b(C2908y0 y0Var, Object obj, p pVar) {
            return C2312i.b.a.a(y0Var, obj, pVar);
        }

        public static C2312i.b c(C2908y0 y0Var, C2312i.c cVar) {
            return C2312i.b.a.b(y0Var, cVar);
        }

        public static C2312i d(C2908y0 y0Var, C2312i.c cVar) {
            return C2312i.b.a.c(y0Var, cVar);
        }

        public static C2312i e(C2908y0 y0Var, C2312i iVar) {
            return C2312i.b.a.d(y0Var, iVar);
        }
    }

    /* renamed from: w3.y0$b */
    public static final class b implements C2312i.c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f26321a = new b();

        private b() {
        }
    }

    boolean C();

    void a(CancellationException cancellationException);

    boolean isActive();

    boolean isCancelled();

    Object l(C2308e eVar);

    CancellationException m();

    C2869e0 p(boolean z4, boolean z5, l lVar);

    C2869e0 s(l lVar);

    boolean start();

    C2895s z(C2899u uVar);
}
