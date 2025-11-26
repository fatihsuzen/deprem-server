package androidx.core.util;

public final /* synthetic */ class h implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f314a;

    public /* synthetic */ h(Predicate predicate) {
        this.f314a = predicate;
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
        return i.e(this.f314a, obj);
    }
}
