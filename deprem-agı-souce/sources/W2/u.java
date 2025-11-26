package W2;

import W2.t;
import kotlin.jvm.internal.t;

public abstract class u {
    public static final Object a(Throwable th) {
        t.e(th, "exception");
        return new t.b(th);
    }

    public static final void b(Object obj) {
        if (obj instanceof t.b) {
            throw ((t.b) obj).f19968a;
        }
    }
}
