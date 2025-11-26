package B3;

import kotlin.jvm.internal.t;

public abstract class B {
    public static final A b(Object obj) {
        if (obj != C1981a.f17387a) {
            t.c(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
            return (A) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final boolean c(Object obj) {
        if (obj == C1981a.f17387a) {
            return true;
        }
        return false;
    }

    public static Object a(Object obj) {
        return obj;
    }
}
