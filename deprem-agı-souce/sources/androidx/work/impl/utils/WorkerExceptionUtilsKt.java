package androidx.work.impl.utils;

import androidx.core.util.Consumer;
import androidx.work.Logger;
import androidx.work.WorkerExceptionInfo;
import kotlin.jvm.internal.t;

public final class WorkerExceptionUtilsKt {
    public static final void safeAccept(Consumer<WorkerExceptionInfo> consumer, WorkerExceptionInfo workerExceptionInfo, String str) {
        t.e(consumer, "<this>");
        t.e(workerExceptionInfo, "info");
        t.e(str, "tag");
        try {
            consumer.accept(workerExceptionInfo);
        } catch (Throwable th) {
            Logger.get().error(str, "Exception handler threw an exception", th);
        }
    }
}
