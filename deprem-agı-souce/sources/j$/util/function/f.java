package j$.util.function;

import java.util.function.Predicate;

public final /* synthetic */ class f implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1381a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f1382b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Predicate f1383c;

    public /* synthetic */ f(Predicate predicate, Predicate predicate2, int i5) {
        this.f1381a = i5;
        this.f1382b = predicate;
        this.f1383c = predicate2;
    }

    public final /* synthetic */ Predicate and(Predicate predicate) {
        switch (this.f1381a) {
            case 0:
                return Predicate$CC.$default$and(this, predicate);
            default:
                return Predicate$CC.$default$and(this, predicate);
        }
    }

    public final /* synthetic */ Predicate negate() {
        switch (this.f1381a) {
            case 0:
                return Predicate$CC.$default$negate(this);
            default:
                return Predicate$CC.$default$negate(this);
        }
    }

    public final /* synthetic */ Predicate or(Predicate predicate) {
        switch (this.f1381a) {
            case 0:
                return Predicate$CC.$default$or(this, predicate);
            default:
                return Predicate$CC.$default$or(this, predicate);
        }
    }

    public final boolean test(Object obj) {
        switch (this.f1381a) {
            case 0:
                return this.f1382b.test(obj) && this.f1383c.test(obj);
            default:
                return this.f1382b.test(obj) || this.f1383c.test(obj);
        }
    }
}
