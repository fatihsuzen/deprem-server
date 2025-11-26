package androidx.work.impl.utils;

import X2.C2242i;
import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import kotlin.jvm.internal.t;

@RequiresApi(28)
public final class NetworkRequest28 {
    public static final NetworkRequest28 INSTANCE = new NetworkRequest28();

    private NetworkRequest28() {
    }

    public static final NetworkRequest createNetworkRequest(int[] iArr, int[] iArr2) {
        t.e(iArr, "capabilities");
        t.e(iArr2, "transports");
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        for (int i5 : iArr) {
            try {
                builder.addCapability(i5);
            } catch (IllegalArgumentException e5) {
                Logger.get().warning(NetworkRequestCompat.Companion.getTAG(), "Ignoring adding capability '" + i5 + '\'', e5);
            }
        }
        for (int i6 : NetworkRequestCompatKt.defaultCapabilities) {
            if (!C2242i.J(iArr, i6)) {
                try {
                    builder.removeCapability(i6);
                } catch (IllegalArgumentException e6) {
                    Logger.get().warning(NetworkRequestCompat.Companion.getTAG(), "Ignoring removing default capability '" + i6 + '\'', e6);
                }
            }
        }
        for (int addTransportType : iArr2) {
            builder.addTransportType(addTransportType);
        }
        NetworkRequest build = builder.build();
        t.d(build, "build(...)");
        return build;
    }

    public final NetworkRequestCompat createNetworkRequestCompat$work_runtime_release(int[] iArr, int[] iArr2) {
        t.e(iArr, "capabilities");
        t.e(iArr2, "transports");
        return new NetworkRequestCompat(createNetworkRequest(iArr, iArr2));
    }

    public final boolean hasCapability$work_runtime_release(NetworkRequest networkRequest, int i5) {
        t.e(networkRequest, "request");
        return networkRequest.hasCapability(i5);
    }

    public final boolean hasTransport$work_runtime_release(NetworkRequest networkRequest, int i5) {
        t.e(networkRequest, "request");
        return networkRequest.hasTransport(i5);
    }
}
