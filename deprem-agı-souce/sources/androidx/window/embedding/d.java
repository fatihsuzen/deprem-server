package androidx.window.embedding;

import android.util.Pair;
import j$.util.function.Predicate$CC;
import java.util.Set;
import java.util.function.Predicate;

public final /* synthetic */ class d implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EmbeddingAdapter f490a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set f491b;

    public /* synthetic */ d(EmbeddingAdapter embeddingAdapter, Set set) {
        this.f490a = embeddingAdapter;
        this.f491b = set;
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
        return EmbeddingAdapter.m198translateActivityIntentPredicates$lambda3(this.f490a, this.f491b, (Pair) obj);
    }
}
