package androidx.work.impl.utils;

import android.net.NetworkRequest;
import android.net.NetworkSpecifier;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;

@RequiresApi(30)
public final class NetworkRequest30 {
    public static final NetworkRequest30 INSTANCE = new NetworkRequest30();

    private NetworkRequest30() {
    }

    public final NetworkSpecifier getNetworkSpecifier(NetworkRequest networkRequest) {
        t.e(networkRequest, "request");
        return networkRequest.getNetworkSpecifier();
    }
}
