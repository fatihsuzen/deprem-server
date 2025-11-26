package B3;

import W2.C2216e;
import b3.C2312i;
import w3.J;
import w3.K;

/* renamed from: B3.f  reason: case insensitive filesystem */
public abstract class C1986f {
    public static final void a(C2312i iVar, Throwable th) {
        for (J B4 : C1985e.a()) {
            try {
                B4.B(iVar, th);
            } catch (Throwable th2) {
                C1985e.b(K.b(th, th2));
            }
        }
        try {
            C2216e.a(th, new C1987g(iVar));
        } catch (Throwable unused) {
        }
        C1985e.b(th);
    }
}
