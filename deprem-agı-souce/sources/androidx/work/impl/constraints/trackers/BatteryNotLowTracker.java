package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class BatteryNotLowTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BatteryNotLowTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        t.e(context, "context");
        t.e(taskExecutor, "taskExecutor");
    }

    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    public void onBroadcastReceive(Intent intent) {
        t.e(intent, "intent");
        if (intent.getAction() != null) {
            Logger logger = Logger.get();
            String access$getTAG$p = BatteryNotLowTrackerKt.TAG;
            logger.debug(access$getTAG$p, "Received " + intent.getAction());
            String action = intent.getAction();
            if (action != null) {
                int hashCode = action.hashCode();
                if (hashCode != -1980154005) {
                    if (hashCode == 490310653 && action.equals("android.intent.action.BATTERY_LOW")) {
                        setState(Boolean.FALSE);
                    }
                } else if (action.equals("android.intent.action.BATTERY_OKAY")) {
                    setState(Boolean.TRUE);
                }
            }
        }
    }

    public Boolean readSystemState() {
        Intent registerReceiver = getAppContext().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            Logger.get().error(BatteryNotLowTrackerKt.TAG, "getInitialState - null intent received");
            return Boolean.FALSE;
        }
        int intExtra = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        float intExtra2 = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
        boolean z4 = true;
        if (intExtra != 1 && intExtra2 <= 0.15f) {
            z4 = false;
        }
        return Boolean.valueOf(z4);
    }
}
