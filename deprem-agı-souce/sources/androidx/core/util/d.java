package androidx.core.util;

public final /* synthetic */ class d implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f309a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f310b;

    public /* synthetic */ d(Predicate predicate, Predicate predicate2) {
        this.f309a = predicate;
        this.f310b = predicate2;
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
        return i.f(this.f309a, this.f310b, obj);
    }
}
