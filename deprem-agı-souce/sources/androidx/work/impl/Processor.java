package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import n0.C1722d;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Processor implements ForegroundProcessor {
    private static final String FOREGROUND_WAKELOCK_TAG = "ProcessorForegroundLck";
    private static final String TAG = Logger.tagWithPrefix("Processor");
    private Context mAppContext;
    private Set<String> mCancelledIds = new HashSet();
    private Configuration mConfiguration;
    private Map<String, WorkerWrapper> mEnqueuedWorkMap = new HashMap();
    private PowerManager.WakeLock mForegroundLock = null;
    private Map<String, WorkerWrapper> mForegroundWorkMap = new HashMap();
    private final Object mLock = new Object();
    private final List<ExecutionListener> mOuterListeners = new ArrayList();
    private WorkDatabase mWorkDatabase;
    private Map<String, Set<StartStopToken>> mWorkRuns = new HashMap();
    private TaskExecutor mWorkTaskExecutor;

    public Processor(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase) {
        this.mAppContext = context;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkDatabase = workDatabase;
    }

    public static /* synthetic */ void b(Processor processor, WorkGenerationalId workGenerationalId, boolean z4) {
        synchronized (processor.mLock) {
            try {
                for (ExecutionListener onExecuted : processor.mOuterListeners) {
                    onExecuted.onExecuted(workGenerationalId, z4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void c(Processor processor, C1722d dVar, WorkerWrapper workerWrapper) {
        boolean z4;
        processor.getClass();
        try {
            z4 = ((Boolean) dVar.get()).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            z4 = true;
        }
        processor.onExecuted(workerWrapper, z4);
    }

    private WorkerWrapper cleanUpWorkerUnsafe(String str) {
        boolean z4;
        WorkerWrapper remove = this.mForegroundWorkMap.remove(str);
        if (remove != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            remove = this.mEnqueuedWorkMap.remove(str);
        }
        this.mWorkRuns.remove(str);
        if (z4) {
            stopForegroundService();
        }
        return remove;
    }

    private WorkerWrapper getWorkerWrapperUnsafe(String str) {
        WorkerWrapper workerWrapper = this.mForegroundWorkMap.get(str);
        if (workerWrapper == null) {
            return this.mEnqueuedWorkMap.get(str);
        }
        return workerWrapper;
    }

    private static boolean interrupt(String str, WorkerWrapper workerWrapper, int i5) {
        if (workerWrapper != null) {
            workerWrapper.interrupt(i5);
            Logger logger = Logger.get();
            String str2 = TAG;
            logger.debug(str2, "WorkerWrapper interrupted for " + str);
            return true;
        }
        Logger logger2 = Logger.get();
        String str3 = TAG;
        logger2.debug(str3, "WorkerWrapper could not be found for " + str);
        return false;
    }

    private void onExecuted(WorkerWrapper workerWrapper, boolean z4) {
        synchronized (this.mLock) {
            try {
                WorkGenerationalId workGenerationalId = workerWrapper.getWorkGenerationalId();
                String workSpecId = workGenerationalId.getWorkSpecId();
                if (getWorkerWrapperUnsafe(workSpecId) == workerWrapper) {
                    cleanUpWorkerUnsafe(workSpecId);
                }
                Logger logger = Logger.get();
                String str = TAG;
                logger.debug(str, getClass().getSimpleName() + " " + workSpecId + " executed; reschedule = " + z4);
                for (ExecutionListener onExecuted : this.mOuterListeners) {
                    onExecuted.onExecuted(workGenerationalId, z4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void runOnExecuted(WorkGenerationalId workGenerationalId, boolean z4) {
        this.mWorkTaskExecutor.getMainThreadExecutor().execute(new C0420a(this, workGenerationalId, z4));
    }

    private void stopForegroundService() {
        synchronized (this.mLock) {
            try {
                if (this.mForegroundWorkMap.isEmpty()) {
                    this.mAppContext.startService(SystemForegroundDispatcher.createStopForegroundIntent(this.mAppContext));
                    PowerManager.WakeLock wakeLock = this.mForegroundLock;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.mForegroundLock = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.add(executionListener);
        }
    }

    public WorkSpec getRunningWorkSpec(String str) {
        synchronized (this.mLock) {
            try {
                WorkerWrapper workerWrapperUnsafe = getWorkerWrapperUnsafe(str);
                if (workerWrapperUnsafe == null) {
                    return null;
                }
                WorkSpec workSpec = workerWrapperUnsafe.getWorkSpec();
                return workSpec;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean hasWork() {
        boolean z4;
        synchronized (this.mLock) {
            try {
                if (this.mEnqueuedWorkMap.isEmpty()) {
                    if (this.mForegroundWorkMap.isEmpty()) {
                        z4 = false;
                    }
                }
                z4 = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z4;
    }

    public boolean isCancelled(String str) {
        boolean contains;
        synchronized (this.mLock) {
            contains = this.mCancelledIds.contains(str);
        }
        return contains;
    }

    public boolean isEnqueued(String str) {
        boolean z4;
        synchronized (this.mLock) {
            if (getWorkerWrapperUnsafe(str) != null) {
                z4 = true;
            } else {
                z4 = false;
            }
        }
        return z4;
    }

    public void removeExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.remove(executionListener);
        }
    }

    public void startForeground(String str, ForegroundInfo foregroundInfo) {
        synchronized (this.mLock) {
            try {
                Logger logger = Logger.get();
                String str2 = TAG;
                logger.info(str2, "Moving WorkSpec (" + str + ") to the foreground");
                WorkerWrapper remove = this.mEnqueuedWorkMap.remove(str);
                if (remove != null) {
                    if (this.mForegroundLock == null) {
                        PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(this.mAppContext, FOREGROUND_WAKELOCK_TAG);
                        this.mForegroundLock = newWakeLock;
                        newWakeLock.acquire();
                    }
                    this.mForegroundWorkMap.put(str, remove);
                    ContextCompat.startForegroundService(this.mAppContext, SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, remove.getWorkGenerationalId(), foregroundInfo));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean startWork(StartStopToken startStopToken) {
        return startWork(startStopToken, (WorkerParameters.RuntimeExtras) null);
    }

    public boolean stopAndCancelWork(String str, int i5) {
        WorkerWrapper cleanUpWorkerUnsafe;
        synchronized (this.mLock) {
            Logger logger = Logger.get();
            String str2 = TAG;
            logger.debug(str2, "Processor cancelling " + str);
            this.mCancelledIds.add(str);
            cleanUpWorkerUnsafe = cleanUpWorkerUnsafe(str);
        }
        return interrupt(str, cleanUpWorkerUnsafe, i5);
    }

    public boolean stopForegroundWork(StartStopToken startStopToken, int i5) {
        WorkerWrapper cleanUpWorkerUnsafe;
        String workSpecId = startStopToken.getId().getWorkSpecId();
        synchronized (this.mLock) {
            cleanUpWorkerUnsafe = cleanUpWorkerUnsafe(workSpecId);
        }
        return interrupt(workSpecId, cleanUpWorkerUnsafe, i5);
    }

    public boolean stopWork(StartStopToken startStopToken, int i5) {
        String workSpecId = startStopToken.getId().getWorkSpecId();
        synchronized (this.mLock) {
            try {
                if (this.mForegroundWorkMap.get(workSpecId) != null) {
                    Logger logger = Logger.get();
                    String str = TAG;
                    logger.debug(str, "Ignored stopWork. WorkerWrapper " + workSpecId + " is in foreground");
                    return false;
                }
                Set set = this.mWorkRuns.get(workSpecId);
                if (set != null) {
                    if (set.contains(startStopToken)) {
                        WorkerWrapper cleanUpWorkerUnsafe = cleanUpWorkerUnsafe(workSpecId);
                        return interrupt(workSpecId, cleanUpWorkerUnsafe, i5);
                    }
                }
                return false;
            } finally {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0091, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean startWork(androidx.work.impl.StartStopToken r12, androidx.work.WorkerParameters.RuntimeExtras r13) {
        /*
            r11 = this;
            androidx.work.impl.model.WorkGenerationalId r0 = r12.getId()
            java.lang.String r1 = r0.getWorkSpecId()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            androidx.work.impl.WorkDatabase r2 = r11.mWorkDatabase
            androidx.work.impl.b r3 = new androidx.work.impl.b
            r3.<init>(r11, r9, r1)
            java.lang.Object r2 = r2.runInTransaction(r3)
            r8 = r2
            androidx.work.impl.model.WorkSpec r8 = (androidx.work.impl.model.WorkSpec) r8
            r2 = 0
            if (r8 != 0) goto L_0x003c
            androidx.work.Logger r12 = androidx.work.Logger.get()
            java.lang.String r13 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Didn't find WorkSpec for id "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r12.warning(r13, r1)
            r11.runOnExecuted(r0, r2)
            return r2
        L_0x003c:
            java.lang.Object r10 = r11.mLock
            monitor-enter(r10)
            boolean r3 = r11.isEnqueued(r1)     // Catch:{ all -> 0x0106 }
            if (r3 == 0) goto L_0x0092
            java.util.Map<java.lang.String, java.util.Set<androidx.work.impl.StartStopToken>> r13 = r11.mWorkRuns     // Catch:{ all -> 0x0088 }
            java.lang.Object r13 = r13.get(r1)     // Catch:{ all -> 0x0088 }
            java.util.Set r13 = (java.util.Set) r13     // Catch:{ all -> 0x0088 }
            java.util.Iterator r1 = r13.iterator()     // Catch:{ all -> 0x0088 }
            java.lang.Object r1 = r1.next()     // Catch:{ all -> 0x0088 }
            androidx.work.impl.StartStopToken r1 = (androidx.work.impl.StartStopToken) r1     // Catch:{ all -> 0x0088 }
            androidx.work.impl.model.WorkGenerationalId r1 = r1.getId()     // Catch:{ all -> 0x0088 }
            int r1 = r1.getGeneration()     // Catch:{ all -> 0x0088 }
            int r3 = r0.getGeneration()     // Catch:{ all -> 0x0088 }
            if (r1 != r3) goto L_0x008d
            r13.add(r12)     // Catch:{ all -> 0x0088 }
            androidx.work.Logger r12 = androidx.work.Logger.get()     // Catch:{ all -> 0x0088 }
            java.lang.String r13 = TAG     // Catch:{ all -> 0x0088 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            r1.<init>()     // Catch:{ all -> 0x0088 }
            java.lang.String r3 = "Work "
            r1.append(r3)     // Catch:{ all -> 0x0088 }
            r1.append(r0)     // Catch:{ all -> 0x0088 }
            java.lang.String r0 = " is already enqueued for processing"
            r1.append(r0)     // Catch:{ all -> 0x0088 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0088 }
            r12.debug(r13, r0)     // Catch:{ all -> 0x0088 }
            goto L_0x0090
        L_0x0088:
            r0 = move-exception
            r12 = r0
            r6 = r11
            goto L_0x0109
        L_0x008d:
            r11.runOnExecuted(r0, r2)     // Catch:{ all -> 0x0088 }
        L_0x0090:
            monitor-exit(r10)     // Catch:{ all -> 0x0088 }
            return r2
        L_0x0092:
            int r3 = r8.getGeneration()     // Catch:{ all -> 0x0106 }
            int r4 = r0.getGeneration()     // Catch:{ all -> 0x0106 }
            if (r3 == r4) goto L_0x00a1
            r11.runOnExecuted(r0, r2)     // Catch:{ all -> 0x0088 }
            monitor-exit(r10)     // Catch:{ all -> 0x0088 }
            return r2
        L_0x00a1:
            androidx.work.impl.WorkerWrapper$Builder r2 = new androidx.work.impl.WorkerWrapper$Builder     // Catch:{ all -> 0x0106 }
            android.content.Context r3 = r11.mAppContext     // Catch:{ all -> 0x0106 }
            androidx.work.Configuration r4 = r11.mConfiguration     // Catch:{ all -> 0x0106 }
            androidx.work.impl.utils.taskexecutor.TaskExecutor r5 = r11.mWorkTaskExecutor     // Catch:{ all -> 0x0106 }
            androidx.work.impl.WorkDatabase r7 = r11.mWorkDatabase     // Catch:{ all -> 0x0106 }
            r6 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0103 }
            androidx.work.impl.WorkerWrapper$Builder r13 = r2.withRuntimeExtras(r13)     // Catch:{ all -> 0x0103 }
            androidx.work.impl.WorkerWrapper r13 = r13.build()     // Catch:{ all -> 0x0103 }
            n0.d r2 = r13.launch()     // Catch:{ all -> 0x0103 }
            androidx.work.impl.c r3 = new androidx.work.impl.c     // Catch:{ all -> 0x0103 }
            r3.<init>(r11, r2, r13)     // Catch:{ all -> 0x0103 }
            androidx.work.impl.utils.taskexecutor.TaskExecutor r4 = r6.mWorkTaskExecutor     // Catch:{ all -> 0x0103 }
            java.util.concurrent.Executor r4 = r4.getMainThreadExecutor()     // Catch:{ all -> 0x0103 }
            r2.addListener(r3, r4)     // Catch:{ all -> 0x0103 }
            java.util.Map<java.lang.String, androidx.work.impl.WorkerWrapper> r2 = r6.mEnqueuedWorkMap     // Catch:{ all -> 0x0103 }
            r2.put(r1, r13)     // Catch:{ all -> 0x0103 }
            java.util.HashSet r13 = new java.util.HashSet     // Catch:{ all -> 0x0103 }
            r13.<init>()     // Catch:{ all -> 0x0103 }
            r13.add(r12)     // Catch:{ all -> 0x0103 }
            java.util.Map<java.lang.String, java.util.Set<androidx.work.impl.StartStopToken>> r12 = r6.mWorkRuns     // Catch:{ all -> 0x0103 }
            r12.put(r1, r13)     // Catch:{ all -> 0x0103 }
            monitor-exit(r10)     // Catch:{ all -> 0x0103 }
            androidx.work.Logger r12 = androidx.work.Logger.get()
            java.lang.String r13 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.Class r2 = r11.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r1.append(r2)
            java.lang.String r2 = ": processing "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r12.debug(r13, r0)
            r12 = 1
            return r12
        L_0x0103:
            r0 = move-exception
        L_0x0104:
            r12 = r0
            goto L_0x0109
        L_0x0106:
            r0 = move-exception
            r6 = r11
            goto L_0x0104
        L_0x0109:
            monitor-exit(r10)     // Catch:{ all -> 0x0103 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.Processor.startWork(androidx.work.impl.StartStopToken, androidx.work.WorkerParameters$RuntimeExtras):boolean");
    }
}
