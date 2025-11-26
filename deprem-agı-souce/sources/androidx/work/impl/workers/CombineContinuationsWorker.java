package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import kotlin.jvm.internal.t;

public final class CombineContinuationsWorker extends Worker {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CombineContinuationsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        t.e(context, "context");
        t.e(workerParameters, "workerParams");
    }

    public ListenableWorker.Result doWork() {
        ListenableWorker.Result success = ListenableWorker.Result.success(getInputData());
        t.d(success, "success(...)");
        return success;
    }
}
