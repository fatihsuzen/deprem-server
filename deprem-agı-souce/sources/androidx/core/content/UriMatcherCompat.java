package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.util.Predicate;

public class UriMatcherCompat {
    private UriMatcherCompat() {
    }

    public static /* synthetic */ boolean a(UriMatcher uriMatcher, Uri uri) {
        if (uriMatcher.match(uri) != -1) {
            return true;
        }
        return false;
    }

    @NonNull
    public static Predicate<Uri> asPredicate(@NonNull UriMatcher uriMatcher) {
        return new w(uriMatcher);
    }
}
