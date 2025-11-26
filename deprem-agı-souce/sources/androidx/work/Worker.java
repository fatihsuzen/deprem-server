package androidx.work;

import android.content.Context;
import androidx.annotation.WorkerThread;
import androidx.work.ListenableWorker;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.t;
import n0.C1722d;

public abstract class Worker extends ListenableWorker {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        t.e(context, "context");
        t.e(workerParameters, "workerParams");
    }

    /* access modifiers changed from: private */
    public static final ForegroundInfo getForegroundInfoAsync$lambda$1(Worker worker) {
        return worker.getForegroundInfo();
    }

    /* access modifiers changed from: private */
    public static final ListenableWorker.Result startWork$lambda$0(Worker worker) {
        return worker.doWork();
    }

    @WorkerThread
    public abstract ListenableWorker.Result doWork();

    @WorkerThread
    public ForegroundInfo getForegroundInfo() {
        throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for `getForegroundInfo()`");
    }

    public C1722d getForegroundInfoAsync() {
        Executor backgroundExecutor = getBackgroundExecutor();
        t.d(backgroundExecutor, "getBackgroundExecutor(...)");
        return WorkerKt.future(backgroundExecutor, new k(this));
    }

    public final C1722d startWork() {
        Executor backgroundExecutor = getBackgroundExecutor();
        t.d(backgroundExecutor, "getBackgroundExecutor(...)");
        return WorkerKt.future(backgroundExecutor, new j(this));
    }
}
