package androidx.work;

import X2.C2250q;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.work.impl.WorkManagerImpl;
import d3.C2344a;
import d3.C2345b;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import n0.C1722d;
import z3.C2972e;

@SuppressLint({"AddedAbstractMethod"})
public abstract class WorkManager {
    public static final Companion Companion = new Companion((C2633k) null);

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public WorkManager getInstance() {
            WorkManagerImpl instance = WorkManagerImpl.getInstance();
            if (instance != null) {
                return instance;
            }
            throw new IllegalStateException("WorkManager is not initialized properly.  The most likely cause is that you disabled WorkManagerInitializer in your manifest but forgot to call WorkManager#initialize in your Application#onCreate or a ContentProvider.");
        }

        public void initialize(Context context, Configuration configuration) {
            t.e(context, "context");
            t.e(configuration, "configuration");
            WorkManagerImpl.initialize(context, configuration);
        }

        public boolean isInitialized() {
            return WorkManagerImpl.isInitialized();
        }

        private Companion() {
        }

        public WorkManager getInstance(Context context) {
            t.e(context, "context");
            WorkManagerImpl instance = WorkManagerImpl.getInstance(context);
            t.d(instance, "getInstance(...)");
            return instance;
        }
    }

    public enum UpdateResult {
        NOT_APPLIED,
        APPLIED_IMMEDIATELY,
        APPLIED_FOR_NEXT_RUN;

        static {
            UpdateResult[] $values;
            $ENTRIES = C2345b.a($values);
        }

        public static C2344a getEntries() {
            return $ENTRIES;
        }
    }

    public static WorkManager getInstance() {
        return Companion.getInstance();
    }

    public static void initialize(Context context, Configuration configuration) {
        Companion.initialize(context, configuration);
    }

    public static boolean isInitialized() {
        return Companion.isInitialized();
    }

    public final WorkContinuation beginUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest oneTimeWorkRequest) {
        t.e(str, "uniqueWorkName");
        t.e(existingWorkPolicy, "existingWorkPolicy");
        t.e(oneTimeWorkRequest, "request");
        return beginUniqueWork(str, existingWorkPolicy, (List<OneTimeWorkRequest>) C2250q.d(oneTimeWorkRequest));
    }

    public abstract WorkContinuation beginUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list);

    public final WorkContinuation beginWith(OneTimeWorkRequest oneTimeWorkRequest) {
        t.e(oneTimeWorkRequest, "request");
        return beginWith((List<OneTimeWorkRequest>) C2250q.d(oneTimeWorkRequest));
    }

    public abstract WorkContinuation beginWith(List<OneTimeWorkRequest> list);

    public abstract Operation cancelAllWork();

    public abstract Operation cancelAllWorkByTag(String str);

    public abstract Operation cancelUniqueWork(String str);

    public abstract Operation cancelWorkById(UUID uuid);

    public abstract PendingIntent createCancelPendingIntent(UUID uuid);

    public final Operation enqueue(WorkRequest workRequest) {
        t.e(workRequest, "request");
        return enqueue((List<? extends WorkRequest>) C2250q.d(workRequest));
    }

    public abstract Operation enqueue(List<? extends WorkRequest> list);

    public abstract Operation enqueueUniquePeriodicWork(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest);

    public Operation enqueueUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest oneTimeWorkRequest) {
        t.e(str, "uniqueWorkName");
        t.e(existingWorkPolicy, "existingWorkPolicy");
        t.e(oneTimeWorkRequest, "request");
        return enqueueUniqueWork(str, existingWorkPolicy, (List<OneTimeWorkRequest>) C2250q.d(oneTimeWorkRequest));
    }

    public abstract Operation enqueueUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list);

    public abstract Configuration getConfiguration();

    public abstract C1722d getLastCancelAllTimeMillis();

    public abstract LiveData<Long> getLastCancelAllTimeMillisLiveData();

    public abstract C1722d getWorkInfoById(UUID uuid);

    public abstract C2972e getWorkInfoByIdFlow(UUID uuid);

    public abstract LiveData<WorkInfo> getWorkInfoByIdLiveData(UUID uuid);

    public abstract C1722d getWorkInfos(WorkQuery workQuery);

    public abstract C1722d getWorkInfosByTag(String str);

    public abstract C2972e getWorkInfosByTagFlow(String str);

    public abstract LiveData<List<WorkInfo>> getWorkInfosByTagLiveData(String str);

    public abstract C2972e getWorkInfosFlow(WorkQuery workQuery);

    public abstract C1722d getWorkInfosForUniqueWork(String str);

    public abstract C2972e getWorkInfosForUniqueWorkFlow(String str);

    public abstract LiveData<List<WorkInfo>> getWorkInfosForUniqueWorkLiveData(String str);

    public abstract LiveData<List<WorkInfo>> getWorkInfosLiveData(WorkQuery workQuery);

    public abstract Operation pruneWork();

    public abstract C1722d updateWork(WorkRequest workRequest);

    public static WorkManager getInstance(Context context) {
        return Companion.getInstance(context);
    }
}
