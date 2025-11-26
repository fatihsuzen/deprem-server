package androidx.window.embedding;

import android.app.Activity;
import j$.util.function.Predicate$CC;
import java.util.Set;
import java.util.function.Predicate;

public final /* synthetic */ class e implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Set f492a;

    public /* synthetic */ e(Set set) {
        this.f492a = set;
    }

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
        return EmbeddingAdapter.m200translateActivityPredicates$lambda6(this.f492a, (Activity) obj);
    }
}
