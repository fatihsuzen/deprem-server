package androidx.work.impl.constraints.controllers;

import android.os.Build;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class NetworkMeteredController extends BaseConstraintController<NetworkState> {
    private static final Companion Companion = new Companion((C2633k) null);
    private static final String TAG;
    private final int reason = 7;

    private static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String tagWithPrefix = Logger.tagWithPrefix("NetworkMeteredCtrlr");
        t.d(tagWithPrefix, "tagWithPrefix(...)");
        TAG = tagWithPrefix;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkMeteredController(ConstraintTracker<NetworkState> constraintTracker) {
        super(constraintTracker);
        t.e(constraintTracker, "tracker");
    }

    /* access modifiers changed from: protected */
    public int getReason() {
        return this.reason;
    }

    public boolean hasConstraint(WorkSpec workSpec) {
        t.e(workSpec, "workSpec");
        if (workSpec.constraints.getRequiredNetworkType() == NetworkType.METERED) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isConstrained(NetworkState networkState) {
        t.e(networkState, "value");
        if (Build.VERSION.SDK_INT >= 26) {
            return !networkState.isConnected() || !networkState.isMetered();
        }
        Logger.get().debug(TAG, "Metered network constraint is not supported before API 26, only checking for connected state.");
        return !networkState.isConnected();
    }
}
