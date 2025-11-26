package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class BroadcastReceiverConstraintTracker<T> extends ConstraintTracker<T> {
    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiverConstraintTracker$broadcastReceiver$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BroadcastReceiverConstraintTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        t.e(context, "context");
        t.e(taskExecutor, "taskExecutor");
    }

    public abstract IntentFilter getIntentFilter();

    public abstract void onBroadcastReceive(Intent intent);

    public void startTracking() {
        Logger logger = Logger.get();
        String access$getTAG$p = BroadcastReceiverConstraintTrackerKt.TAG;
        logger.debug(access$getTAG$p, getClass().getSimpleName() + ": registering receiver");
        getAppContext().registerReceiver(this.broadcastReceiver, getIntentFilter());
    }

    public void stopTracking() {
        Logger logger = Logger.get();
        String access$getTAG$p = BroadcastReceiverConstraintTrackerKt.TAG;
        logger.debug(access$getTAG$p, getClass().getSimpleName() + ": unregistering receiver");
        getAppContext().unregisterReceiver(this.broadcastReceiver);
    }
}
