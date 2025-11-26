package L3;

import k3.l;
import k3.p;
import kotlin.jvm.internal.t;

/* renamed from: L3.o  reason: case insensitive filesystem */
public abstract class C2104o {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f18564a;

    static {
        boolean z4;
        try {
            Class.forName("java.lang.ClassValue");
            z4 = true;
        } catch (Throwable unused) {
            z4 = false;
        }
        f18564a = z4;
    }

    public static final S0 a(l lVar) {
        t.e(lVar, "factory");
        if (f18564a) {
            return new C2113t(lVar);
        }
        return new C2123y(lVar);
    }

    public static final C2126z0 b(p pVar) {
        t.e(pVar, "factory");
        if (f18564a) {
            return new C2115u(pVar);
        }
        return new C2125z(pVar);
    }
}
