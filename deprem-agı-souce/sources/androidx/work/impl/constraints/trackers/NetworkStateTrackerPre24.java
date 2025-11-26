package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.t;

public final class NetworkStateTrackerPre24 extends BroadcastReceiverConstraintTracker<NetworkState> {
    private final ConnectivityManager connectivityManager;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkStateTrackerPre24(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        t.e(context, "context");
        t.e(taskExecutor, "taskExecutor");
        Object systemService = getAppContext().getSystemService("connectivity");
        t.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) systemService;
    }

    public static /* synthetic */ void getIntentFilter$annotations() {
    }

    public IntentFilter getIntentFilter() {
        return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    public void onBroadcastReceive(Intent intent) {
        t.e(intent, "intent");
        if (t.a(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
            Logger.get().debug(NetworkStateTrackerKt.TAG, "Network broadcast received");
            setState(NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager));
        }
    }

    public NetworkState readSystemState() {
        return NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager);
    }
}
