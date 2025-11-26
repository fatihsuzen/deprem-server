package androidx.work.impl.constraints;

import W2.J;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import k3.C2616a;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.t;
import t3.s;

@RequiresApi(28)
final class IndividualNetworkCallback extends ConnectivityManager.NetworkCallback {
    public static final Companion Companion = new Companion((C2633k) null);
    private final l onConstraintState;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public static final J addCallback$lambda$0(I i5, ConnectivityManager connectivityManager, IndividualNetworkCallback individualNetworkCallback) {
            if (i5.f24687a) {
                Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController unregister callback");
                connectivityManager.unregisterNetworkCallback(individualNetworkCallback);
            }
            return J.f19942a;
        }

        public final C2616a addCallback(ConnectivityManager connectivityManager, NetworkRequest networkRequest, l lVar) {
            t.e(connectivityManager, "connManager");
            t.e(networkRequest, "networkRequest");
            t.e(lVar, "onConstraintState");
            IndividualNetworkCallback individualNetworkCallback = new IndividualNetworkCallback(lVar, (C2633k) null);
            I i5 = new I();
            try {
                Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController register callback");
                connectivityManager.registerNetworkCallback(networkRequest, individualNetworkCallback);
                i5.f24687a = true;
            } catch (RuntimeException e5) {
                String name = e5.getClass().getName();
                t.d(name, "getName(...)");
                if (s.D(name, "TooManyRequestsException", false, 2, (Object) null)) {
                    Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController couldn't register callback", e5);
                    lVar.invoke(new ConstraintsState.ConstraintsNotMet(7));
                } else {
                    throw e5;
                }
            }
            return new a(i5, connectivityManager, individualNetworkCallback);
        }

        private Companion() {
        }
    }

    public /* synthetic */ IndividualNetworkCallback(l lVar, C2633k kVar) {
        this(lVar);
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        t.e(network, "network");
        t.e(networkCapabilities, "networkCapabilities");
        Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController onCapabilitiesChanged callback");
        this.onConstraintState.invoke(ConstraintsState.ConstraintsMet.INSTANCE);
    }

    public void onLost(Network network) {
        t.e(network, "network");
        Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController onLost callback");
        this.onConstraintState.invoke(new ConstraintsState.ConstraintsNotMet(7));
    }

    private IndividualNetworkCallback(l lVar) {
        this.onConstraintState = lVar;
    }
}
