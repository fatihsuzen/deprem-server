package androidx.work;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface Tracer {
    void beginAsyncSection(String str, int i5);

    void beginSection(String str);

    void endAsyncSection(String str, int i5);

    void endSection();

    boolean isEnabled();
}
