package androidx.browser.trusted;

import androidx.annotation.NonNull;
import androidx.concurrent.futures.ResolvableFuture;
import n0.C1722d;

class FutureUtils {
    private FutureUtils() {
    }

    @NonNull
    static <T> C1722d immediateFailedFuture(@NonNull Throwable th) {
        ResolvableFuture create = ResolvableFuture.create();
        create.setException(th);
        return create;
    }
}
