package androidx.work.impl.constraints.controllers;

import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.t;

public final class NetworkUnmeteredController extends BaseConstraintController<NetworkState> {
    private final int reason = 7;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkUnmeteredController(ConstraintTracker<NetworkState> constraintTracker) {
        super(constraintTracker);
        t.e(constraintTracker, "tracker");
    }

    /* access modifiers changed from: protected */
    public int getReason() {
        return this.reason;
    }

    public boolean hasConstraint(WorkSpec workSpec) {
        t.e(workSpec, "workSpec");
        NetworkType requiredNetworkType = workSpec.constraints.getRequiredNetworkType();
        if (requiredNetworkType == NetworkType.UNMETERED) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 30 || requiredNetworkType != NetworkType.TEMPORARILY_UNMETERED) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isConstrained(NetworkState networkState) {
        t.e(networkState, "value");
        return !networkState.isConnected() || networkState.isMetered();
    }
}
