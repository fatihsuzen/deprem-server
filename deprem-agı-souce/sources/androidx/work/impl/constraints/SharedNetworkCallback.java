package androidx.work.impl.constraints;

import W2.J;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import java.util.LinkedHashMap;
import java.util.Map;
import k3.C2616a;
import k3.l;
import kotlin.jvm.internal.t;

@RequiresApi(30)
final class SharedNetworkCallback extends ConnectivityManager.NetworkCallback {
    public static final SharedNetworkCallback INSTANCE = new SharedNetworkCallback();
    @GuardedBy("requestsLock")
    private static NetworkCapabilities cachedCapabilities;
    @GuardedBy("requestsLock")
    private static boolean capabilitiesInitialized;
    @GuardedBy("requestsLock")
    private static final Map<l, NetworkRequest> requests = new LinkedHashMap();
    private static final Object requestsLock = new Object();

    private SharedNetworkCallback() {
    }

    /* access modifiers changed from: private */
    public static final J addCallback$lambda$6(l lVar, ConnectivityManager connectivityManager) {
        synchronized (requestsLock) {
            Map<l, NetworkRequest> map = requests;
            map.remove(lVar);
            if (map.isEmpty()) {
                Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController unregister shared callback");
                connectivityManager.unregisterNetworkCallback(INSTANCE);
                cachedCapabilities = null;
                capabilitiesInitialized = false;
            }
        }
        return J.f19942a;
    }

    public final C2616a addCallback(ConnectivityManager connectivityManager, NetworkRequest networkRequest, l lVar) {
        Object obj;
        t.e(connectivityManager, "connManager");
        t.e(networkRequest, "networkRequest");
        t.e(lVar, "onConstraintState");
        synchronized (requestsLock) {
            try {
                Map<l, NetworkRequest> map = requests;
                boolean isEmpty = map.isEmpty();
                map.put(lVar, networkRequest);
                if (isEmpty) {
                    Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController register shared callback");
                    connectivityManager.registerDefaultNetworkCallback(INSTANCE);
                }
                Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController send initial capabilities");
                if (networkRequest.canBeSatisfiedBy(INSTANCE.getCurrentNetworkCapabilities(connectivityManager))) {
                    obj = ConstraintsState.ConstraintsMet.INSTANCE;
                } else {
                    obj = new ConstraintsState.ConstraintsNotMet(7);
                }
                lVar.invoke(obj);
                J j5 = J.f19942a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return new f(lVar, connectivityManager);
    }

    public final NetworkCapabilities getCachedCapabilities() {
        return cachedCapabilities;
    }

    public final boolean getCapabilitiesInitialized() {
        return capabilitiesInitialized;
    }

    public final NetworkCapabilities getCurrentNetworkCapabilities(ConnectivityManager connectivityManager) {
        t.e(connectivityManager, "<this>");
        if (capabilitiesInitialized) {
            return cachedCapabilities;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        cachedCapabilities = networkCapabilities;
        capabilitiesInitialized = true;
        return networkCapabilities;
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Object obj;
        t.e(network, "network");
        t.e(networkCapabilities, "networkCapabilities");
        Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController onCapabilitiesChanged callback");
        synchronized (requestsLock) {
            try {
                cachedCapabilities = networkCapabilities;
                for (Map.Entry entry : requests.entrySet()) {
                    l lVar = (l) entry.getKey();
                    if (((NetworkRequest) entry.getValue()).canBeSatisfiedBy(networkCapabilities)) {
                        obj = ConstraintsState.ConstraintsMet.INSTANCE;
                    } else {
                        obj = new ConstraintsState.ConstraintsNotMet(7);
                    }
                    lVar.invoke(obj);
                }
                J j5 = J.f19942a;
            } finally {
            }
        }
    }

    public void onLost(Network network) {
        t.e(network, "network");
        Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController onLost callback");
        synchronized (requestsLock) {
            try {
                cachedCapabilities = null;
                for (l invoke : requests.keySet()) {
                    invoke.invoke(new ConstraintsState.ConstraintsNotMet(7));
                }
                J j5 = J.f19942a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setCachedCapabilities(NetworkCapabilities networkCapabilities) {
        cachedCapabilities = networkCapabilities;
    }

    public final void setCapabilitiesInitialized(boolean z4) {
        capabilitiesInitialized = z4;
    }
}
