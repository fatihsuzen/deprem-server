package r0;

import R0.a;
import R0.b;
import java.util.Set;

/* renamed from: r0.d  reason: case insensitive filesystem */
public abstract /* synthetic */ class C1787d {
    public static Object a(C1788e eVar, Class cls) {
        return eVar.e(F.b(cls));
    }

    public static Object b(C1788e eVar, F f5) {
        b b5 = eVar.b(f5);
        if (b5 == null) {
            return null;
        }
        return b5.get();
    }

    public static a c(C1788e eVar, Class cls) {
        return eVar.g(F.b(cls));
    }

    public static b d(C1788e eVar, Class cls) {
        return eVar.b(F.b(cls));
    }

    public static Set e(C1788e eVar, Class cls) {
        return eVar.d(F.b(cls));
    }

    public static Set f(C1788e eVar, F f5) {
        return (Set) eVar.f(f5).get();
    }
}
