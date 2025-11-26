package androidx.work.multiprocess;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ForegroundInfo;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import n0.C1722d;

public abstract class RemoteWorkManager {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final long DEFAULT_SESSION_TIMEOUT_MILLIS = 600000;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final long MAX_SESSION_TIMEOUT_MILLIS = 1200000;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected RemoteWorkManager() {
    }

    public static RemoteWorkManager getInstance(Context context) {
        RemoteWorkManager remoteWorkManager = WorkManagerImpl.getInstance(context).getRemoteWorkManager();
        if (remoteWorkManager != null) {
            return remoteWorkManager;
        }
        throw new IllegalStateException("Unable to initialize RemoteWorkManager");
    }

    public final RemoteWorkContinuation beginUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest oneTimeWorkRequest) {
        return beginUniqueWork(str, existingWorkPolicy, (List<OneTimeWorkRequest>) Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract RemoteWorkContinuation beginUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list);

    public final RemoteWorkContinuation beginWith(OneTimeWorkRequest oneTimeWorkRequest) {
        return beginWith((List<OneTimeWorkRequest>) Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract RemoteWorkContinuation beginWith(List<OneTimeWorkRequest> list);

    public abstract C1722d cancelAllWork();

    public abstract C1722d cancelAllWorkByTag(String str);

    public abstract C1722d cancelUniqueWork(String str);

    public abstract C1722d cancelWorkById(UUID uuid);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract C1722d enqueue(WorkContinuation workContinuation);

    public abstract C1722d enqueue(WorkRequest workRequest);

    public abstract C1722d enqueue(List<WorkRequest> list);

    public abstract C1722d enqueueUniquePeriodicWork(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest);

    public final C1722d enqueueUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest oneTimeWorkRequest) {
        return enqueueUniqueWork(str, existingWorkPolicy, (List<OneTimeWorkRequest>) Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract C1722d enqueueUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list);

    public abstract C1722d getWorkInfos(WorkQuery workQuery);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract C1722d setForegroundAsync(String str, ForegroundInfo foregroundInfo);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract C1722d setProgress(UUID uuid, Data data);
}
