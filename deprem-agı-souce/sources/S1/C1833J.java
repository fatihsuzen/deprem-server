package s1;

import j$.util.function.Predicate$CC;
import java.util.function.Predicate;

/* renamed from: s1.J  reason: case insensitive filesystem */
public final /* synthetic */ class C1833J implements Predicate {
    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate$CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate$CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate$CC.$default$or(this, predicate);
    }

    public final boolean test(Object obj) {
        return M.l((Integer) obj);
    }
}
