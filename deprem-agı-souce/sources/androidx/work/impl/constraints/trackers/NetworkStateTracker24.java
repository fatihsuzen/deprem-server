package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi24;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.t;

@RequiresApi(24)
public final class NetworkStateTracker24 extends ConstraintTracker<NetworkState> {
    /* access modifiers changed from: private */
    public final ConnectivityManager connectivityManager;
    private final NetworkStateTracker24$networkCallback$1 networkCallback = new NetworkStateTracker24$networkCallback$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkStateTracker24(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        t.e(context, "context");
        t.e(taskExecutor, "taskExecutor");
        Object systemService = getAppContext().getSystemService("connectivity");
        t.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) systemService;
    }

    public void startTracking() {
        try {
            Logger.get().debug(NetworkStateTrackerKt.TAG, "Registering network callback");
            NetworkApi24.registerDefaultNetworkCallbackCompat(this.connectivityManager, this.networkCallback);
        } catch (IllegalArgumentException e5) {
            Logger.get().error(NetworkStateTrackerKt.TAG, "Received exception while registering network callback", e5);
        } catch (SecurityException e6) {
            Logger.get().error(NetworkStateTrackerKt.TAG, "Received exception while registering network callback", e6);
        }
    }

    public void stopTracking() {
        try {
            Logger.get().debug(NetworkStateTrackerKt.TAG, "Unregistering network callback");
            this.connectivityManager.unregisterNetworkCallback(this.networkCallback);
        } catch (IllegalArgumentException e5) {
            Logger.get().error(NetworkStateTrackerKt.TAG, "Received exception while unregistering network callback", e5);
        } catch (SecurityException e6) {
            Logger.get().error(NetworkStateTrackerKt.TAG, "Received exception while unregistering network callback", e6);
        }
    }

    public NetworkState readSystemState() {
        return NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager);
    }
}
