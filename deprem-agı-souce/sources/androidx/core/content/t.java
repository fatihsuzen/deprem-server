package androidx.core.content;

import android.content.ClipData;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;
import androidx.core.util.i;

public final /* synthetic */ class t implements Predicate {
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
        return IntentSanitizer.Builder.q((ClipData) obj);
    }
}
