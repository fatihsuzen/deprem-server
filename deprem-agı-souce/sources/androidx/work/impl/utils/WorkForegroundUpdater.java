package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableFutureKt;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.UUID;
import n0.C1722d;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkForegroundUpdater implements ForegroundUpdater {
    private static final String TAG = Logger.tagWithPrefix("WMFgUpdater");
    final ForegroundProcessor mForegroundProcessor;
    private final TaskExecutor mTaskExecutor;
    final WorkSpecDao mWorkSpecDao;

    @SuppressLint({"LambdaLast"})
    public WorkForegroundUpdater(WorkDatabase workDatabase, ForegroundProcessor foregroundProcessor, TaskExecutor taskExecutor) {
        this.mForegroundProcessor = foregroundProcessor;
        this.mTaskExecutor = taskExecutor;
        this.mWorkSpecDao = workDatabase.workSpecDao();
    }

    public static /* synthetic */ Void a(WorkForegroundUpdater workForegroundUpdater, UUID uuid, ForegroundInfo foregroundInfo, Context context) {
        workForegroundUpdater.getClass();
        String uuid2 = uuid.toString();
        WorkSpec workSpec = workForegroundUpdater.mWorkSpecDao.getWorkSpec(uuid2);
        if (workSpec == null || workSpec.state.isFinished()) {
            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
        }
        workForegroundUpdater.mForegroundProcessor.startForeground(uuid2, foregroundInfo);
        context.startService(SystemForegroundDispatcher.createNotifyIntent(context, WorkSpecKt.generationalId(workSpec), foregroundInfo));
        return null;
    }

    public C1722d setForegroundAsync(Context context, UUID uuid, ForegroundInfo foregroundInfo) {
        return ListenableFutureKt.executeAsync(this.mTaskExecutor.getSerialTaskExecutor(), "setForegroundAsync", new B(this, uuid, foregroundInfo, context));
    }
}
