package w3;

import W2.t;
import W2.u;
import b3.C2308e;
import kotlin.jvm.internal.C2633k;

/* renamed from: w3.C  reason: case insensitive filesystem */
public abstract class C2856C {
    public static final Object a(Object obj, C2308e eVar) {
        if (!(obj instanceof C2854A)) {
            return t.b(obj);
        }
        t.a aVar = t.f19966b;
        return t.b(u.a(((C2854A) obj).f26214a));
    }

    public static final Object b(Object obj) {
        Throwable e5 = t.e(obj);
        if (e5 == null) {
            return obj;
        }
        return new C2854A(e5, false, 2, (C2633k) null);
    }

    public static final Object c(Object obj, C2882l lVar) {
        Throwable e5 = t.e(obj);
        if (e5 == null) {
            return obj;
        }
        return new C2854A(e5, false, 2, (C2633k) null);
    }
}
