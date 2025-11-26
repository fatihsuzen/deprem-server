package androidx.work.impl;

import androidx.annotation.RestrictTo;
import java.util.concurrent.CancellationException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class WorkerStoppedException extends CancellationException {
    private final int reason;

    public WorkerStoppedException(int i5) {
        this.reason = i5;
    }

    public final int getReason() {
        return this.reason;
    }
}
