package androidx.core.util;

public final /* synthetic */ class f implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f311a;

    public /* synthetic */ f(Object obj) {
        this.f311a = obj;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return i.a(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return i.b(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return i.c(this, predicate);
    }

    public final boolean test(Object obj) {
        return this.f311a.equals(obj);
    }
}
