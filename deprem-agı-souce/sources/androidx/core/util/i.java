package androidx.core.util;

import j$.util.Objects;

public abstract /* synthetic */ class i {
    public static Predicate a(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new g(predicate, predicate2);
    }

    public static Predicate b(Predicate predicate) {
        return new h(predicate);
    }

    public static Predicate c(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new d(predicate, predicate2);
    }

    public static /* synthetic */ boolean d(Predicate predicate, Predicate predicate2, Object obj) {
        if (!predicate.test(obj) || !predicate2.test(obj)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean e(Predicate predicate, Object obj) {
        return !predicate.test(obj);
    }

    public static /* synthetic */ boolean f(Predicate predicate, Predicate predicate2, Object obj) {
        if (predicate.test(obj) || predicate2.test(obj)) {
            return true;
        }
        return false;
    }

    public static Predicate g(Object obj) {
        if (obj == null) {
            return new e();
        }
        return new f(obj);
    }

    public static Predicate j(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }
}
