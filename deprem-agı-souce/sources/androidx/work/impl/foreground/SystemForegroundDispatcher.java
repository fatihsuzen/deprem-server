package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import w3.C2908y0;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemForegroundDispatcher implements OnConstraintsStateChangedListener, ExecutionListener {
    private static final String ACTION_CANCEL_WORK = "ACTION_CANCEL_WORK";
    private static final String ACTION_NOTIFY = "ACTION_NOTIFY";
    private static final String ACTION_START_FOREGROUND = "ACTION_START_FOREGROUND";
    private static final String ACTION_STOP_FOREGROUND = "ACTION_STOP_FOREGROUND";
    private static final String KEY_FOREGROUND_SERVICE_TYPE = "KEY_FOREGROUND_SERVICE_TYPE";
    private static final String KEY_GENERATION = "KEY_GENERATION";
    private static final String KEY_NOTIFICATION = "KEY_NOTIFICATION";
    private static final String KEY_NOTIFICATION_ID = "KEY_NOTIFICATION_ID";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    static final String TAG = Logger.tagWithPrefix("SystemFgDispatcher");
    private Callback mCallback;
    final WorkConstraintsTracker mConstraintsTracker;
    private Context mContext;
    WorkGenerationalId mCurrentForegroundId;
    final Map<WorkGenerationalId, ForegroundInfo> mForegroundInfoById;
    final Object mLock = new Object();
    /* access modifiers changed from: private */
    public final TaskExecutor mTaskExecutor;
    final Map<WorkGenerationalId, C2908y0> mTrackedWorkSpecs;
    /* access modifiers changed from: private */
    public WorkManagerImpl mWorkManagerImpl;
    final Map<WorkGenerationalId, WorkSpec> mWorkSpecById;

    interface Callback {
        @MainThread
        void cancelNotification(int i5);

        @MainThread
        void notify(int i5, Notification notification);

        @MainThread
        void startForeground(int i5, int i6, Notification notification);

        @MainThread
        void stop(int i5);
    }

    SystemForegroundDispatcher(Context context) {
        this.mContext = context;
        WorkManagerImpl instance = WorkManagerImpl.getInstance(context);
        this.mWorkManagerImpl = instance;
        this.mTaskExecutor = instance.getWorkTaskExecutor();
        this.mCurrentForegroundId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashMap();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = new WorkConstraintsTracker(this.mWorkManagerImpl.getTrackers());
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
    }

    public static Intent createCancelWorkIntent(Context context, String str) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction(ACTION_CANCEL_WORK);
        intent.setData(Uri.parse("workspec://" + str));
        intent.putExtra(KEY_WORKSPEC_ID, str);
        return intent;
    }

    public static Intent createNotifyIntent(Context context, WorkGenerationalId workGenerationalId, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction(ACTION_NOTIFY);
        intent.putExtra(KEY_NOTIFICATION_ID, foregroundInfo.getNotificationId());
        intent.putExtra(KEY_FOREGROUND_SERVICE_TYPE, foregroundInfo.getForegroundServiceType());
        intent.putExtra(KEY_NOTIFICATION, foregroundInfo.getNotification());
        intent.putExtra(KEY_WORKSPEC_ID, workGenerationalId.getWorkSpecId());
        intent.putExtra(KEY_GENERATION, workGenerationalId.getGeneration());
        return intent;
    }

    public static Intent createStartForegroundIntent(Context context, WorkGenerationalId workGenerationalId, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction(ACTION_START_FOREGROUND);
        intent.putExtra(KEY_WORKSPEC_ID, workGenerationalId.getWorkSpecId());
        intent.putExtra(KEY_GENERATION, workGenerationalId.getGeneration());
        intent.putExtra(KEY_NOTIFICATION_ID, foregroundInfo.getNotificationId());
        intent.putExtra(KEY_FOREGROUND_SERVICE_TYPE, foregroundInfo.getForegroundServiceType());
        intent.putExtra(KEY_NOTIFICATION, foregroundInfo.getNotification());
        return intent;
    }

    public static Intent createStopForegroundIntent(Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction(ACTION_STOP_FOREGROUND);
        return intent;
    }

    @MainThread
    private void handleCancelWork(Intent intent) {
        Logger logger = Logger.get();
        String str = TAG;
        logger.info(str, "Stopping foreground work for " + intent);
        String stringExtra = intent.getStringExtra(KEY_WORKSPEC_ID);
        if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
            this.mWorkManagerImpl.cancelWorkById(UUID.fromString(stringExtra));
        }
    }

    @MainThread
    private void handleNotify(Intent intent) {
        if (this.mCallback != null) {
            int i5 = 0;
            int intExtra = intent.getIntExtra(KEY_NOTIFICATION_ID, 0);
            int intExtra2 = intent.getIntExtra(KEY_FOREGROUND_SERVICE_TYPE, 0);
            String stringExtra = intent.getStringExtra(KEY_WORKSPEC_ID);
            WorkGenerationalId workGenerationalId = new WorkGenerationalId(stringExtra, intent.getIntExtra(KEY_GENERATION, 0));
            Notification notification = (Notification) intent.getParcelableExtra(KEY_NOTIFICATION);
            Logger logger = Logger.get();
            String str = TAG;
            logger.debug(str, "Notifying with (id:" + intExtra + ", workSpecId: " + stringExtra + ", notificationType :" + intExtra2 + ")");
            if (notification != null) {
                ForegroundInfo foregroundInfo = new ForegroundInfo(intExtra, notification, intExtra2);
                this.mForegroundInfoById.put(workGenerationalId, foregroundInfo);
                ForegroundInfo foregroundInfo2 = this.mForegroundInfoById.get(this.mCurrentForegroundId);
                if (foregroundInfo2 == null) {
                    this.mCurrentForegroundId = workGenerationalId;
                } else {
                    this.mCallback.notify(intExtra, notification);
                    if (Build.VERSION.SDK_INT >= 29) {
                        for (Map.Entry<WorkGenerationalId, ForegroundInfo> value : this.mForegroundInfoById.entrySet()) {
                            i5 |= ((ForegroundInfo) value.getValue()).getForegroundServiceType();
                        }
                        foregroundInfo = new ForegroundInfo(foregroundInfo2.getNotificationId(), foregroundInfo2.getNotification(), i5);
                    } else {
                        foregroundInfo = foregroundInfo2;
                    }
                }
                this.mCallback.startForeground(foregroundInfo.getNotificationId(), foregroundInfo.getForegroundServiceType(), foregroundInfo.getNotification());
                return;
            }
            throw new IllegalArgumentException("Notification passed in the intent was null.");
        }
        throw new IllegalStateException("handleNotify was called on the destroyed dispatcher");
    }

    @MainThread
    private void handleStartForeground(Intent intent) {
        Logger logger = Logger.get();
        String str = TAG;
        logger.info(str, "Started foreground service " + intent);
        final String stringExtra = intent.getStringExtra(KEY_WORKSPEC_ID);
        this.mTaskExecutor.executeOnTaskThread(new Runnable() {
            public void run() {
                WorkSpec runningWorkSpec = SystemForegroundDispatcher.this.mWorkManagerImpl.getProcessor().getRunningWorkSpec(stringExtra);
                if (runningWorkSpec != null && runningWorkSpec.hasConstraints()) {
                    synchronized (SystemForegroundDispatcher.this.mLock) {
                        SystemForegroundDispatcher.this.mWorkSpecById.put(WorkSpecKt.generationalId(runningWorkSpec), runningWorkSpec);
                        SystemForegroundDispatcher systemForegroundDispatcher = SystemForegroundDispatcher.this;
                        SystemForegroundDispatcher.this.mTrackedWorkSpecs.put(WorkSpecKt.generationalId(runningWorkSpec), WorkConstraintsTrackerKt.listen(systemForegroundDispatcher.mConstraintsTracker, runningWorkSpec, systemForegroundDispatcher.mTaskExecutor.getTaskCoroutineDispatcher(), SystemForegroundDispatcher.this));
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    @MainThread
    public void handleStop(Intent intent, int i5) {
        Logger.get().info(TAG, "Stopping foreground service");
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.stop(i5);
        }
    }

    public void onConstraintsStateChanged(WorkSpec workSpec, ConstraintsState constraintsState) {
        if (constraintsState instanceof ConstraintsState.ConstraintsNotMet) {
            String str = workSpec.id;
            Logger logger = Logger.get();
            String str2 = TAG;
            logger.debug(str2, "Constraints unmet for WorkSpec " + str);
            this.mWorkManagerImpl.stopForegroundWork(WorkSpecKt.generationalId(workSpec), ((ConstraintsState.ConstraintsNotMet) constraintsState).getReason());
        }
    }

    /* access modifiers changed from: package-private */
    @MainThread
    public void onDestroy() {
        this.mCallback = null;
        synchronized (this.mLock) {
            try {
                for (C2908y0 a5 : this.mTrackedWorkSpecs.values()) {
                    a5.a((CancellationException) null);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.mWorkManagerImpl.getProcessor().removeExecutionListener(this);
    }

    @MainThread
    public void onExecuted(WorkGenerationalId workGenerationalId, boolean z4) {
        C2908y0 y0Var;
        Map.Entry entry;
        synchronized (this.mLock) {
            try {
                if (this.mWorkSpecById.remove(workGenerationalId) != null) {
                    y0Var = this.mTrackedWorkSpecs.remove(workGenerationalId);
                } else {
                    y0Var = null;
                }
                if (y0Var != null) {
                    y0Var.a((CancellationException) null);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        ForegroundInfo remove = this.mForegroundInfoById.remove(workGenerationalId);
        if (workGenerationalId.equals(this.mCurrentForegroundId)) {
            if (this.mForegroundInfoById.size() > 0) {
                Iterator it = this.mForegroundInfoById.entrySet().iterator();
                Object next = it.next();
                while (true) {
                    entry = (Map.Entry) next;
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                }
                this.mCurrentForegroundId = (WorkGenerationalId) entry.getKey();
                if (this.mCallback != null) {
                    ForegroundInfo foregroundInfo = (ForegroundInfo) entry.getValue();
                    this.mCallback.startForeground(foregroundInfo.getNotificationId(), foregroundInfo.getForegroundServiceType(), foregroundInfo.getNotification());
                    this.mCallback.cancelNotification(foregroundInfo.getNotificationId());
                }
            } else {
                this.mCurrentForegroundId = null;
            }
        }
        Callback callback = this.mCallback;
        if (remove != null && callback != null) {
            Logger.get().debug(TAG, "Removing Notification (id: " + remove.getNotificationId() + ", workSpecId: " + workGenerationalId + ", notificationType: " + remove.getForegroundServiceType());
            callback.cancelNotification(remove.getNotificationId());
        }
    }

    /* access modifiers changed from: package-private */
    @MainThread
    public void onStartCommand(Intent intent, int i5) {
        String action = intent.getAction();
        if (ACTION_START_FOREGROUND.equals(action)) {
            handleStartForeground(intent);
            handleNotify(intent);
        } else if (ACTION_NOTIFY.equals(action)) {
            handleNotify(intent);
        } else if (ACTION_CANCEL_WORK.equals(action)) {
            handleCancelWork(intent);
        } else if (ACTION_STOP_FOREGROUND.equals(action)) {
            handleStop(intent, i5);
        }
    }

    /* access modifiers changed from: package-private */
    @MainThread
    public void onTimeout(int i5, int i6) {
        Logger logger = Logger.get();
        String str = TAG;
        logger.info(str, "Foreground service timed out, FGS type: " + i6);
        for (Map.Entry next : this.mForegroundInfoById.entrySet()) {
            if (((ForegroundInfo) next.getValue()).getForegroundServiceType() == i6) {
                this.mWorkManagerImpl.stopForegroundWork((WorkGenerationalId) next.getKey(), WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT);
            }
        }
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.stop(i5);
        }
    }

    /* access modifiers changed from: package-private */
    @MainThread
    public void setCallback(Callback callback) {
        if (this.mCallback != null) {
            Logger.get().error(TAG, "A callback already exists.");
        } else {
            this.mCallback = callback;
        }
    }

    @VisibleForTesting
    SystemForegroundDispatcher(Context context, WorkManagerImpl workManagerImpl, WorkConstraintsTracker workConstraintsTracker) {
        this.mContext = context;
        this.mWorkManagerImpl = workManagerImpl;
        this.mTaskExecutor = workManagerImpl.getWorkTaskExecutor();
        this.mCurrentForegroundId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashMap();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = workConstraintsTracker;
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
    }
}
