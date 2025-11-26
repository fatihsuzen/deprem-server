package androidx.core.util;

public final /* synthetic */ class g implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f312a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f313b;

    public /* synthetic */ g(Predicate predicate, Predicate predicate2) {
        this.f312a = predicate;
        this.f313b = predicate2;
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
        return i.d(this.f312a, this.f313b, obj);
    }
}
