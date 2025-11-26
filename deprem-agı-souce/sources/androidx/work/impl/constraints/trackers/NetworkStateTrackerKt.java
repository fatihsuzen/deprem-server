package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.t;

public final class NetworkStateTrackerKt {
    /* access modifiers changed from: private */
    public static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("NetworkStateTracker");
        t.d(tagWithPrefix, "tagWithPrefix(...)");
        TAG = tagWithPrefix;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final ConstraintTracker<NetworkState> NetworkStateTracker(Context context, TaskExecutor taskExecutor) {
        t.e(context, "context");
        t.e(taskExecutor, "taskExecutor");
        if (Build.VERSION.SDK_INT >= 24) {
            return new NetworkStateTracker24(context, taskExecutor);
        }
        return new NetworkStateTrackerPre24(context, taskExecutor);
    }

    public static final NetworkState getActiveNetworkState(ConnectivityManager connectivityManager) {
        t.e(connectivityManager, "<this>");
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return new NetworkState(activeNetworkInfo != null && activeNetworkInfo.isConnected(), isActiveNetworkValidated(connectivityManager), ConnectivityManagerCompat.isActiveNetworkMetered(connectivityManager), activeNetworkInfo != null && !activeNetworkInfo.isRoaming());
        } catch (SecurityException e5) {
            Logger.get().error(TAG, "Unable to get active network state", e5);
            return new NetworkState(false, false, false, true);
        }
    }

    public static /* synthetic */ void getActiveNetworkState$annotations(ConnectivityManager connectivityManager) {
    }

    public static final boolean isActiveNetworkValidated(ConnectivityManager connectivityManager) {
        t.e(connectivityManager, "<this>");
        try {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null) {
                return networkCapabilities.hasCapability(16);
            }
            return false;
        } catch (SecurityException e5) {
            Logger.get().error(TAG, "Unable to validate active network", e5);
            return false;
        }
    }

    @RequiresApi(28)
    public static final NetworkState getActiveNetworkState(NetworkCapabilities networkCapabilities) {
        t.e(networkCapabilities, "<this>");
        return new NetworkState(networkCapabilities.hasCapability(12), networkCapabilities.hasCapability(16), !networkCapabilities.hasCapability(11), networkCapabilities.hasCapability(18));
    }
}
