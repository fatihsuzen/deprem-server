package androidx.window.embedding;

import android.util.Pair;
import j$.util.function.Predicate$CC;
import java.util.Set;
import java.util.function.Predicate;

public final /* synthetic */ class c implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EmbeddingAdapter f488a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set f489b;

    public /* synthetic */ c(EmbeddingAdapter embeddingAdapter, Set set) {
        this.f488a = embeddingAdapter;
        this.f489b = set;
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
        return EmbeddingAdapter.m199translateActivityPairPredicates$lambda1(this.f488a, this.f489b, (Pair) obj);
    }
}
