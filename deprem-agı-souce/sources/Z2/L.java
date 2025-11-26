package z2;

import S1.k;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1598a;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.Updates;
import kotlin.jvm.internal.t;

public final class L {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f26503a;

    /* renamed from: b  reason: collision with root package name */
    private final a f26504b = new a(this);

    public static final class a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ L f26505a;

        a(L l5) {
            this.f26505a = l5;
        }

        public void onAvailable(Network network) {
            t.e(network, "network");
            H h5 = H.f26488a;
            if (!h5.d()) {
                h5.h(true);
                Activity g5 = k.f32g.g();
                if (g5 != null) {
                    UptodownApp.f13477F.e(this.f26505a.f26503a);
                    if (g5 instanceof C1598a) {
                        ((C1598a) g5).z2();
                    }
                    if (g5 instanceof MainActivity) {
                        MainActivity mainActivity = (MainActivity) g5;
                        if (mainActivity.d6()) {
                            mainActivity.runOnUiThread(new MainActivity.C1590c());
                        }
                    }
                }
            }
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            t.e(network, "network");
            t.e(networkCapabilities, "networkCapabilities");
            super.onCapabilitiesChanged(network, networkCapabilities);
            boolean hasTransport = networkCapabilities.hasTransport(1);
            H h5 = H.f26488a;
            boolean f5 = h5.f();
            int linkDownstreamBandwidthKbps = networkCapabilities.getLinkDownstreamBandwidthKbps();
            int a5 = h5.a();
            int b5 = h5.b();
            h5.j(hasTransport);
            h5.g(networkCapabilities.getLinkDownstreamBandwidthKbps());
            h5.i(networkCapabilities.getLinkUpstreamBandwidthKbps());
            if (a5 == 0 || b5 == 0) {
                UptodownApp.f13477F.e(this.f26505a.f26503a);
            } else if (f5 != hasTransport) {
                UptodownApp.a aVar = UptodownApp.f13477F;
                aVar.e(this.f26505a.f26503a);
                if (h5.f()) {
                    UptodownApp.a.O0(aVar, this.f26505a.f26503a, false, 2, (Object) null);
                    Activity g5 = k.f32g.g();
                    if (g5 != null && (g5 instanceof Updates)) {
                        ((Updates) g5).K5();
                    }
                }
            } else {
                boolean b6 = this.f26505a.b(a5, linkDownstreamBandwidthKbps);
                if (!h5.f() && b6) {
                    UptodownApp.f13477F.e(this.f26505a.f26503a);
                }
            }
        }

        public void onLost(Network network) {
            t.e(network, "network");
            H h5 = H.f26488a;
            h5.h(false);
            h5.j(false);
        }
    }

    public L(Context context) {
        t.e(context, "context");
        this.f26503a = context;
    }

    public final boolean b(int i5, int i6) {
        if (4300 < i6) {
            if (i5 < 4300) {
                return true;
            }
            return false;
        } else if (i5 > 4300) {
            return true;
        } else {
            return false;
        }
    }

    public final void c() {
        Object systemService = this.f26503a.getSystemService("connectivity");
        t.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        if (Build.VERSION.SDK_INT >= 24) {
            connectivityManager.registerDefaultNetworkCallback(this.f26504b);
        } else {
            connectivityManager.registerNetworkCallback(builder.build(), this.f26504b);
        }
    }

    public final void d() {
        Object systemService = this.f26503a.getSystemService("connectivity");
        t.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ((ConnectivityManager) systemService).unregisterNetworkCallback(new ConnectivityManager.NetworkCallback());
    }
}
