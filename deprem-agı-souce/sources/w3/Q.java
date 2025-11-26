package w3;

import B3.C1988h;
import W2.t;
import W2.u;
import b3.C2308e;

public abstract class Q {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(C2308e eVar) {
        Object obj;
        if (eVar instanceof C1988h) {
            return ((C1988h) eVar).toString();
        }
        try {
            t.a aVar = t.f19966b;
            obj = t.b(eVar + '@' + b(eVar));
        } catch (Throwable th) {
            t.a aVar2 = t.f19966b;
            obj = t.b(u.a(th));
        }
        if (t.e(obj) != null) {
            obj = eVar.getClass().getName() + '@' + b(eVar);
        }
        return (String) obj;
    }
}
