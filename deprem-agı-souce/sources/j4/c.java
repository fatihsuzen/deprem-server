package j4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final ConnectivityManager f24534a;

    public enum a {
        NONE,
        MOBILE,
        WIFI
    }

    public c(Context context) {
        this.f24534a = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public a a() {
        NetworkInfo activeNetworkInfo = this.f24534a.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return a.NONE;
        }
        if (activeNetworkInfo.getType() == 1) {
            return a.WIFI;
        }
        return a.MOBILE;
    }

    public boolean b() {
        NetworkInfo activeNetworkInfo = this.f24534a.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }
}
