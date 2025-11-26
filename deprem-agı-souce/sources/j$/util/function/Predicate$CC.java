package j$.util.function;

import j$.util.C0481q;
import j$.util.Objects;
import java.util.function.Predicate;

/* renamed from: j$.util.function.Predicate$-CC  reason: invalid class name */
public final /* synthetic */ class Predicate$CC {
    public static Predicate $default$and(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new f(predicate, predicate2, 0);
    }

    public static Predicate $default$negate(Predicate predicate) {
        return new C0481q(1, predicate);
    }

    public static Predicate $default$or(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new f(predicate, predicate2, 1);
    }
}
