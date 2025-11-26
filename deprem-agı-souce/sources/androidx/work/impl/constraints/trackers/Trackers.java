package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Trackers {
    private final ConstraintTracker<Boolean> batteryChargingTracker;
    private final BatteryNotLowTracker batteryNotLowTracker;
    private final Context context;
    private final ConstraintTracker<NetworkState> networkStateTracker;
    private final ConstraintTracker<Boolean> storageNotLowTracker;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Trackers(Context context2, TaskExecutor taskExecutor) {
        this(context2, taskExecutor, (ConstraintTracker) null, (BatteryNotLowTracker) null, (ConstraintTracker) null, (ConstraintTracker) null, 60, (C2633k) null);
        t.e(context2, "context");
        t.e(taskExecutor, "taskExecutor");
    }

    public final ConstraintTracker<Boolean> getBatteryChargingTracker() {
        return this.batteryChargingTracker;
    }

    public final BatteryNotLowTracker getBatteryNotLowTracker() {
        return this.batteryNotLowTracker;
    }

    public final Context getContext() {
        return this.context;
    }

    public final ConstraintTracker<NetworkState> getNetworkStateTracker() {
        return this.networkStateTracker;
    }

    public final ConstraintTracker<Boolean> getStorageNotLowTracker() {
        return this.storageNotLowTracker;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Trackers(Context context2, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker) {
        this(context2, taskExecutor, constraintTracker, (BatteryNotLowTracker) null, (ConstraintTracker) null, (ConstraintTracker) null, 56, (C2633k) null);
        t.e(context2, "context");
        t.e(taskExecutor, "taskExecutor");
        t.e(constraintTracker, "batteryChargingTracker");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Trackers(Context context2, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker, BatteryNotLowTracker batteryNotLowTracker2) {
        this(context2, taskExecutor, constraintTracker, batteryNotLowTracker2, (ConstraintTracker) null, (ConstraintTracker) null, 48, (C2633k) null);
        t.e(context2, "context");
        t.e(taskExecutor, "taskExecutor");
        t.e(constraintTracker, "batteryChargingTracker");
        t.e(batteryNotLowTracker2, "batteryNotLowTracker");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Trackers(Context context2, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker, BatteryNotLowTracker batteryNotLowTracker2, ConstraintTracker<NetworkState> constraintTracker2) {
        this(context2, taskExecutor, constraintTracker, batteryNotLowTracker2, constraintTracker2, (ConstraintTracker) null, 32, (C2633k) null);
        t.e(context2, "context");
        t.e(taskExecutor, "taskExecutor");
        t.e(constraintTracker, "batteryChargingTracker");
        t.e(batteryNotLowTracker2, "batteryNotLowTracker");
        t.e(constraintTracker2, "networkStateTracker");
    }

    public Trackers(Context context2, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker, BatteryNotLowTracker batteryNotLowTracker2, ConstraintTracker<NetworkState> constraintTracker2, ConstraintTracker<Boolean> constraintTracker3) {
        t.e(context2, "context");
        t.e(taskExecutor, "taskExecutor");
        t.e(constraintTracker, "batteryChargingTracker");
        t.e(batteryNotLowTracker2, "batteryNotLowTracker");
        t.e(constraintTracker2, "networkStateTracker");
        t.e(constraintTracker3, "storageNotLowTracker");
        this.context = context2;
        this.batteryChargingTracker = constraintTracker;
        this.batteryNotLowTracker = batteryNotLowTracker2;
        this.networkStateTracker = constraintTracker2;
        this.storageNotLowTracker = constraintTracker3;
    }

    public /* synthetic */ Trackers(Context context2, TaskExecutor taskExecutor, ConstraintTracker constraintTracker, BatteryNotLowTracker batteryNotLowTracker2, ConstraintTracker constraintTracker2, ConstraintTracker constraintTracker3, int i5, C2633k kVar) {
        BatteryChargingTracker batteryChargingTracker2;
        BatteryNotLowTracker batteryNotLowTracker3;
        ConstraintTracker<NetworkState> constraintTracker4;
        StorageNotLowTracker storageNotLowTracker2;
        TaskExecutor taskExecutor2;
        Context context3;
        Trackers trackers;
        if ((i5 & 4) != 0) {
            Context applicationContext = context2.getApplicationContext();
            t.d(applicationContext, "getApplicationContext(...)");
            batteryChargingTracker2 = new BatteryChargingTracker(applicationContext, taskExecutor);
        } else {
            batteryChargingTracker2 = constraintTracker;
        }
        if ((i5 & 8) != 0) {
            Context applicationContext2 = context2.getApplicationContext();
            t.d(applicationContext2, "getApplicationContext(...)");
            batteryNotLowTracker3 = new BatteryNotLowTracker(applicationContext2, taskExecutor);
        } else {
            batteryNotLowTracker3 = batteryNotLowTracker2;
        }
        if ((i5 & 16) != 0) {
            Context applicationContext3 = context2.getApplicationContext();
            t.d(applicationContext3, "getApplicationContext(...)");
            constraintTracker4 = NetworkStateTrackerKt.NetworkStateTracker(applicationContext3, taskExecutor);
        } else {
            constraintTracker4 = constraintTracker2;
        }
        if ((i5 & 32) != 0) {
            Context applicationContext4 = context2.getApplicationContext();
            t.d(applicationContext4, "getApplicationContext(...)");
            storageNotLowTracker2 = new StorageNotLowTracker(applicationContext4, taskExecutor);
            context3 = context2;
            taskExecutor2 = taskExecutor;
            trackers = this;
        } else {
            storageNotLowTracker2 = constraintTracker3;
            trackers = this;
            context3 = context2;
            taskExecutor2 = taskExecutor;
        }
        new Trackers(context3, taskExecutor2, batteryChargingTracker2, batteryNotLowTracker3, constraintTracker4, storageNotLowTracker2);
    }
}
