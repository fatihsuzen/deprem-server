package androidx.work.impl;

import W2.J;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.work.Configuration;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableFutureKt;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.TracerKt;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.RawWorkInfoDaoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDaoKt;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.LiveDataUtils;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.PruneWorkRunnableKt;
import androidx.work.impl.utils.RawQueries;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.multiprocess.RemoteWorkManager;
import j$.util.Objects;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import n0.C1722d;
import w3.M;
import z3.C2972e;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkManagerImpl extends WorkManager {
    public static final int CONTENT_URI_TRIGGER_API_LEVEL = 24;
    public static final String REMOTE_WORK_MANAGER_CLIENT = "androidx.work.multiprocess.RemoteWorkManagerClient";
    private static final String TAG = Logger.tagWithPrefix("WorkManagerImpl");
    private static WorkManagerImpl sDefaultInstance = null;
    private static WorkManagerImpl sDelegatedInstance = null;
    private static final Object sLock = new Object();
    private Configuration mConfiguration;
    private Context mContext;
    private boolean mForceStopRunnableCompleted = false;
    private PreferenceUtils mPreferenceUtils;
    private Processor mProcessor;
    private volatile RemoteWorkManager mRemoteWorkManager;
    private BroadcastReceiver.PendingResult mRescheduleReceiverResult;
    private List<Scheduler> mSchedulers;
    private final Trackers mTrackers;
    private WorkDatabase mWorkDatabase;
    private final M mWorkManagerScope;
    private TaskExecutor mWorkTaskExecutor;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean isDeviceProtectedStorage(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, List<Scheduler> list, Processor processor, Trackers trackers) {
        Context applicationContext = context.getApplicationContext();
        if (Build.VERSION.SDK_INT < 24 || !Api24Impl.isDeviceProtectedStorage(applicationContext)) {
            Logger.setLogger(new Logger.LogcatLogger(configuration.getMinimumLoggingLevel()));
            this.mContext = applicationContext;
            this.mWorkTaskExecutor = taskExecutor;
            this.mWorkDatabase = workDatabase;
            this.mProcessor = processor;
            this.mTrackers = trackers;
            this.mConfiguration = configuration;
            this.mSchedulers = list;
            M createWorkManagerScope = WorkManagerImplExtKt.createWorkManagerScope(taskExecutor);
            this.mWorkManagerScope = createWorkManagerScope;
            this.mPreferenceUtils = new PreferenceUtils(this.mWorkDatabase);
            Schedulers.registerRescheduling(list, this.mProcessor, taskExecutor.getSerialTaskExecutor(), this.mWorkDatabase, configuration);
            this.mWorkTaskExecutor.executeOnTaskThread(new ForceStopRunnable(applicationContext, this));
            UnfinishedWorkListenerKt.maybeLaunchUnfinishedWorkListener(createWorkManagerScope, this.mContext, configuration, workDatabase);
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    public static /* synthetic */ J a(WorkManagerImpl workManagerImpl) {
        SystemJobScheduler.cancelAllInAllNamespaces(workManagerImpl.getApplicationContext());
        workManagerImpl.getWorkDatabase().workSpecDao().resetScheduledState();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
        return J.f19942a;
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static WorkManagerImpl getInstance() {
        synchronized (sLock) {
            try {
                WorkManagerImpl workManagerImpl = sDelegatedInstance;
                if (workManagerImpl != null) {
                    return workManagerImpl;
                }
                WorkManagerImpl workManagerImpl2 = sDefaultInstance;
                return workManagerImpl2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void initialize(Context context, Configuration configuration) {
        synchronized (sLock) {
            try {
                WorkManagerImpl workManagerImpl = sDelegatedInstance;
                if (workManagerImpl != null) {
                    if (sDefaultInstance != null) {
                        throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                    }
                }
                if (workManagerImpl == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (sDefaultInstance == null) {
                        sDefaultInstance = WorkManagerImplExtKt.createWorkManager(applicationContext, configuration);
                    }
                    sDelegatedInstance = sDefaultInstance;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean isInitialized() {
        if (getInstance() != null) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setDelegate(WorkManagerImpl workManagerImpl) {
        synchronized (sLock) {
            sDelegatedInstance = workManagerImpl;
        }
    }

    private void tryInitializeMultiProcessSupport() {
        try {
            this.mRemoteWorkManager = (RemoteWorkManager) Class.forName(REMOTE_WORK_MANAGER_CLIENT).getConstructor(new Class[]{Context.class, WorkManagerImpl.class}).newInstance(new Object[]{this.mContext, this});
        } catch (Throwable th) {
            Logger.get().debug(TAG, "Unable to initialize multi-process support", th);
        }
    }

    public WorkContinuation beginUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, str, existingWorkPolicy, list);
        }
        throw new IllegalArgumentException("beginUniqueWork needs at least one OneTimeWorkRequest.");
    }

    public WorkContinuation beginWith(List<OneTimeWorkRequest> list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, list);
        }
        throw new IllegalArgumentException("beginWith needs at least one OneTimeWorkRequest.");
    }

    public Operation cancelAllWork() {
        return CancelWorkRunnable.forAll(this);
    }

    public Operation cancelAllWorkByTag(String str) {
        return CancelWorkRunnable.forTag(str, this);
    }

    public Operation cancelUniqueWork(String str) {
        return CancelWorkRunnable.forName(str, this);
    }

    public Operation cancelWorkById(UUID uuid) {
        return CancelWorkRunnable.forId(uuid, this);
    }

    public void closeDatabase() {
        WorkManagerImplExtKt.close(this);
    }

    public PendingIntent createCancelPendingIntent(UUID uuid) {
        int i5;
        Intent createCancelWorkIntent = SystemForegroundDispatcher.createCancelWorkIntent(this.mContext, uuid.toString());
        if (Build.VERSION.SDK_INT >= 31) {
            i5 = 167772160;
        } else {
            i5 = 134217728;
        }
        return PendingIntent.getService(this.mContext, 0, createCancelWorkIntent, i5);
    }

    public WorkContinuationImpl createWorkContinuationForUniquePeriodicWork(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest) {
        ExistingWorkPolicy existingWorkPolicy;
        if (existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.KEEP) {
            existingWorkPolicy = ExistingWorkPolicy.KEEP;
        } else {
            existingWorkPolicy = ExistingWorkPolicy.REPLACE;
        }
        return new WorkContinuationImpl(this, str, existingWorkPolicy, Collections.singletonList(periodicWorkRequest));
    }

    public Operation enqueue(List<? extends WorkRequest> list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, list).enqueue();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    public Operation enqueueUniquePeriodicWork(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest) {
        if (existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.UPDATE) {
            return WorkerUpdater.enqueueUniquelyNamedPeriodic(this, str, periodicWorkRequest);
        }
        return createWorkContinuationForUniquePeriodicWork(str, existingPeriodicWorkPolicy, periodicWorkRequest).enqueue();
    }

    public Operation enqueueUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list) {
        return new WorkContinuationImpl(this, str, existingWorkPolicy, list).enqueue();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Context getApplicationContext() {
        return this.mContext;
    }

    public Configuration getConfiguration() {
        return this.mConfiguration;
    }

    public C1722d getLastCancelAllTimeMillis() {
        PreferenceUtils preferenceUtils = this.mPreferenceUtils;
        SerialExecutor serialTaskExecutor = this.mWorkTaskExecutor.getSerialTaskExecutor();
        Objects.requireNonNull(preferenceUtils);
        return ListenableFutureKt.executeAsync(serialTaskExecutor, "getLastCancelAllTimeMillis", new s(preferenceUtils));
    }

    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return this.mPreferenceUtils.getLastCancelAllTimeMillisLiveData();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PreferenceUtils getPreferenceUtils() {
        return this.mPreferenceUtils;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Processor getProcessor() {
        return this.mProcessor;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteWorkManager getRemoteWorkManager() {
        if (this.mRemoteWorkManager == null) {
            synchronized (sLock) {
                try {
                    if (this.mRemoteWorkManager == null) {
                        tryInitializeMultiProcessSupport();
                        if (this.mRemoteWorkManager == null) {
                            if (!TextUtils.isEmpty(this.mConfiguration.getDefaultProcessName())) {
                                throw new IllegalStateException("Invalid multiprocess configuration. Define an `implementation` dependency on :work:work-multiprocess library");
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.mRemoteWorkManager;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<Scheduler> getSchedulers() {
        return this.mSchedulers;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Trackers getTrackers() {
        return this.mTrackers;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkDatabase getWorkDatabase() {
        return this.mWorkDatabase;
    }

    public C1722d getWorkInfoById(UUID uuid) {
        return StatusRunnable.forUUID(this.mWorkDatabase, this.mWorkTaskExecutor, uuid);
    }

    public C2972e getWorkInfoByIdFlow(UUID uuid) {
        return WorkSpecDaoKt.getWorkStatusPojoFlowDataForIds(getWorkDatabase().workSpecDao(), uuid);
    }

    public LiveData<WorkInfo> getWorkInfoByIdLiveData(UUID uuid) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(Collections.singletonList(uuid.toString())), new Function<List<WorkSpec.WorkInfoPojo>, WorkInfo>() {
            public WorkInfo apply(List<WorkSpec.WorkInfoPojo> list) {
                if (list == null || list.size() <= 0) {
                    return null;
                }
                return list.get(0).toWorkInfo();
            }
        }, this.mWorkTaskExecutor);
    }

    public C1722d getWorkInfos(WorkQuery workQuery) {
        return StatusRunnable.forWorkQuerySpec(this.mWorkDatabase, this.mWorkTaskExecutor, workQuery);
    }

    /* access modifiers changed from: package-private */
    public LiveData<List<WorkInfo>> getWorkInfosById(List<String> list) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(list), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    public C1722d getWorkInfosByTag(String str) {
        return StatusRunnable.forTag(this.mWorkDatabase, this.mWorkTaskExecutor, str);
    }

    public C2972e getWorkInfosByTagFlow(String str) {
        return WorkSpecDaoKt.getWorkStatusPojoFlowForTag(this.mWorkDatabase.workSpecDao(), this.mWorkTaskExecutor.getTaskCoroutineDispatcher(), str);
    }

    public LiveData<List<WorkInfo>> getWorkInfosByTagLiveData(String str) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForTag(str), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    public C2972e getWorkInfosFlow(WorkQuery workQuery) {
        return RawWorkInfoDaoKt.getWorkInfoPojosFlow(this.mWorkDatabase.rawWorkInfoDao(), this.mWorkTaskExecutor.getTaskCoroutineDispatcher(), RawQueries.toRawQuery(workQuery));
    }

    public C1722d getWorkInfosForUniqueWork(String str) {
        return StatusRunnable.forUniqueWork(this.mWorkDatabase, this.mWorkTaskExecutor, str);
    }

    public C2972e getWorkInfosForUniqueWorkFlow(String str) {
        return WorkSpecDaoKt.getWorkStatusPojoFlowForName(this.mWorkDatabase.workSpecDao(), this.mWorkTaskExecutor.getTaskCoroutineDispatcher(), str);
    }

    public LiveData<List<WorkInfo>> getWorkInfosForUniqueWorkLiveData(String str) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForName(str), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    public LiveData<List<WorkInfo>> getWorkInfosLiveData(WorkQuery workQuery) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.rawWorkInfoDao().getWorkInfoPojosLiveData(RawQueries.toRawQuery(workQuery)), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    /* access modifiers changed from: package-private */
    public M getWorkManagerScope() {
        return this.mWorkManagerScope;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TaskExecutor getWorkTaskExecutor() {
        return this.mWorkTaskExecutor;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onForceStopRunnableCompleted() {
        synchronized (sLock) {
            try {
                this.mForceStopRunnableCompleted = true;
                BroadcastReceiver.PendingResult pendingResult = this.mRescheduleReceiverResult;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.mRescheduleReceiverResult = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Operation pruneWork() {
        return PruneWorkRunnableKt.pruneWork(this.mWorkDatabase, this.mConfiguration, this.mWorkTaskExecutor);
    }

    public void rescheduleEligibleWork() {
        TracerKt.traced(getConfiguration().getTracer(), "ReschedulingWork", new t(this));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setReschedulePendingResult(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (sLock) {
            try {
                BroadcastReceiver.PendingResult pendingResult2 = this.mRescheduleReceiverResult;
                if (pendingResult2 != null) {
                    pendingResult2.finish();
                }
                this.mRescheduleReceiverResult = pendingResult;
                if (this.mForceStopRunnableCompleted) {
                    pendingResult.finish();
                    this.mRescheduleReceiverResult = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void stopForegroundWork(WorkGenerationalId workGenerationalId, int i5) {
        this.mWorkTaskExecutor.executeOnTaskThread(new StopWorkRunnable(this.mProcessor, new StartStopToken(workGenerationalId), true, i5));
    }

    public C1722d updateWork(WorkRequest workRequest) {
        return WorkerUpdater.updateWorkImpl(this, workRequest);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static WorkManagerImpl getInstance(Context context) {
        WorkManagerImpl instance;
        synchronized (sLock) {
            try {
                instance = getInstance();
                if (instance == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext instanceof Configuration.Provider) {
                        initialize(applicationContext, ((Configuration.Provider) applicationContext).getWorkManagerConfiguration());
                        instance = getInstance(applicationContext);
                    } else {
                        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return instance;
    }
}
