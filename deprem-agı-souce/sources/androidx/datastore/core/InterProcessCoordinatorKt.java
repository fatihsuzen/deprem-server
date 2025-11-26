package androidx.datastore.core;

import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.t;

public final class InterProcessCoordinatorKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final InterProcessCoordinator createSingleProcessCoordinator(String str) {
        t.e(str, "filePath");
        return new SingleProcessCoordinator(str);
    }
}
