package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.Predicate;
import androidx.core.util.i;

public final /* synthetic */ class w implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UriMatcher f259a;

    public /* synthetic */ w(UriMatcher uriMatcher) {
        this.f259a = uriMatcher;
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
        return UriMatcherCompat.a(this.f259a, (Uri) obj);
    }
}
