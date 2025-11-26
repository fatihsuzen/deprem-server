package androidx.window.embedding;

import android.view.WindowMetrics;
import j$.util.function.Predicate$CC;
import java.util.function.Predicate;

public final /* synthetic */ class b implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplitRule f487a;

    public /* synthetic */ b(SplitRule splitRule) {
        this.f487a = splitRule;
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
        return EmbeddingAdapter.m202translateParentMetricsPredicate$lambda4(this.f487a, (WindowMetrics) obj);
    }
}
