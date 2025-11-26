package n4;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final ConnectivityManager f25518a;

    public a(ConnectivityManager connectivityManager) {
        this.f25518a = connectivityManager;
    }

    public final boolean a() {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = this.f25518a;
        if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16)) {
            return true;
        }
        return false;
    }
}
