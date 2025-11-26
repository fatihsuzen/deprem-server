package androidx.core.content;

import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;
import androidx.core.util.i;

public final /* synthetic */ class g implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f249a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f250b;

    public /* synthetic */ g(Class cls, Predicate predicate) {
        this.f249a = cls;
        this.f250b = predicate;
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
        return IntentSanitizer.Builder.e(this.f249a, this.f250b, obj);
    }
}
