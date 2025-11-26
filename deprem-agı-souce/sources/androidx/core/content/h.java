package androidx.core.content;

import android.content.ComponentName;
import androidx.core.util.Predicate;
import androidx.core.util.i;

public final /* synthetic */ class h implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentName f251a;

    public /* synthetic */ h(ComponentName componentName) {
        this.f251a = componentName;
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
        return this.f251a.equals((ComponentName) obj);
    }
}
