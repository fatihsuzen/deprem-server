package androidx.work.impl.utils;

import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;

@RequiresApi(31)
final class NetworkRequest31 {
    public static final NetworkRequest31 INSTANCE = new NetworkRequest31();

    private NetworkRequest31() {
    }

    public final int[] capabilities(NetworkRequest networkRequest) {
        t.e(networkRequest, "request");
        int[] a5 = networkRequest.getCapabilities();
        t.d(a5, "getCapabilities(...)");
        return a5;
    }

    public final int[] transportTypes(NetworkRequest networkRequest) {
        t.e(networkRequest, "request");
        int[] a5 = networkRequest.getTransportTypes();
        t.d(a5, "getTransportTypes(...)");
        return a5;
    }
}
