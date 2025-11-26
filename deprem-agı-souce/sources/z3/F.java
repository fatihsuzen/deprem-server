package z3;

import A3.r;
import B3.D;
import b3.C2312i;
import y3.C2928a;

public abstract class F {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final D f26601a = new D("NONE");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final D f26602b = new D("PENDING");

    public static final w a(Object obj) {
        if (obj == null) {
            obj = r.f17311a;
        }
        return new E(obj);
    }

    public static final C2972e d(D d5, C2312i iVar, int i5, C2928a aVar) {
        if (((i5 < 0 || i5 >= 2) && i5 != -2) || aVar != C2928a.DROP_OLDEST) {
            return B.d(d5, iVar, i5, aVar);
        }
        return d5;
    }
}
