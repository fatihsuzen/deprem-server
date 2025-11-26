package w3;

import B3.C1986f;
import W2.C2216e;
import b3.C2312i;

public abstract class K {
    public static final void a(C2312i iVar, Throwable th) {
        try {
            J j5 = (J) iVar.get(J.f26239j0);
            if (j5 != null) {
                j5.B(iVar, th);
            } else {
                C1986f.a(iVar, th);
            }
        } catch (Throwable th2) {
            C1986f.a(iVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        C2216e.a(runtimeException, th);
        return runtimeException;
    }
}
