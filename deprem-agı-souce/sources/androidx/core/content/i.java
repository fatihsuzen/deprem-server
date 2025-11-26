package androidx.core.content;

import android.content.ComponentName;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

public final /* synthetic */ class i implements Predicate {
    public /* synthetic */ Predicate and(Predicate predicate) {
        return androidx.core.util.i.a(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return androidx.core.util.i.b(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return androidx.core.util.i.c(this, predicate);
    }

    public final boolean test(Object obj) {
        return IntentSanitizer.Builder.j((ComponentName) obj);
    }
}
