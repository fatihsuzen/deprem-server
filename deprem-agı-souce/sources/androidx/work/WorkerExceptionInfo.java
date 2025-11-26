package androidx.work;

import kotlin.jvm.internal.t;

public final class WorkerExceptionInfo {
    private final Throwable throwable;
    private final String workerClassName;
    private final WorkerParameters workerParameters;

    public WorkerExceptionInfo(String str, WorkerParameters workerParameters2, Throwable th) {
        t.e(str, "workerClassName");
        t.e(workerParameters2, "workerParameters");
        t.e(th, "throwable");
        this.workerClassName = str;
        this.workerParameters = workerParameters2;
        this.throwable = th;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final String getWorkerClassName() {
        return this.workerClassName;
    }

    public final WorkerParameters getWorkerParameters() {
        return this.workerParameters;
    }
}
