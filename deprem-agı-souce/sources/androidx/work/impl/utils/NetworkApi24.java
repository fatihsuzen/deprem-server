package androidx.work.impl.utils;

import android.net.ConnectivityManager;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;

@RequiresApi(24)
public final class NetworkApi24 {
    public static final void registerDefaultNetworkCallbackCompat(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
        t.e(connectivityManager, "<this>");
        t.e(networkCallback, "networkCallback");
        connectivityManager.registerDefaultNetworkCallback(networkCallback);
    }
}
