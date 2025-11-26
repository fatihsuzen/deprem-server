package K1;

import W2.J;
import W2.t;
import W2.u;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2747a;

    /* renamed from: b  reason: collision with root package name */
    private final List f2748b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private a f2749c;

    /* renamed from: d  reason: collision with root package name */
    private ConnectivityManager.NetworkCallback f2750d;

    public interface a {
        void a();

        void b();
    }

    public static final class b extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f2751a = new Handler(Looper.getMainLooper());

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f2752b;

        b(d dVar) {
            this.f2752b = dVar;
        }

        /* access modifiers changed from: private */
        public static final void c(d dVar) {
            for (a a5 : dVar.h()) {
                a5.a();
            }
        }

        /* access modifiers changed from: private */
        public static final void d(d dVar) {
            for (a b5 : dVar.h()) {
                b5.b();
            }
        }

        public void onAvailable(Network network) {
            t.e(network, "network");
            this.f2751a.post(new e(this.f2752b));
        }

        public void onLost(Network network) {
            t.e(network, "network");
            this.f2751a.post(new f(this.f2752b));
        }
    }

    public d(Context context) {
        t.e(context, "context");
        this.f2747a = context;
    }

    private final void d(Context context) {
        b bVar = new b(this);
        this.f2750d = bVar;
        Object systemService = context.getSystemService("connectivity");
        t.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ((ConnectivityManager) systemService).registerDefaultNetworkCallback(bVar);
    }

    private final void e(Context context) {
        a aVar = new a(new b(this), new c(this));
        this.f2749c = aVar;
        context.registerReceiver(aVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* access modifiers changed from: private */
    public static final J f(d dVar) {
        for (a a5 : dVar.f2748b) {
            a5.a();
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J g(d dVar) {
        for (a b5 : dVar.f2748b) {
            b5.b();
        }
        return J.f19942a;
    }

    public final void c() {
        Object obj;
        if (Build.VERSION.SDK_INT >= 24) {
            ConnectivityManager.NetworkCallback networkCallback = this.f2750d;
            if (networkCallback != null) {
                Object systemService = this.f2747a.getSystemService("connectivity");
                t.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                ((ConnectivityManager) systemService).unregisterNetworkCallback(networkCallback);
            } else {
                return;
            }
        } else {
            a aVar = this.f2749c;
            if (aVar != null) {
                try {
                    t.a aVar2 = W2.t.f19966b;
                    this.f2747a.unregisterReceiver(aVar);
                    obj = W2.t.b(J.f19942a);
                } catch (Throwable th) {
                    t.a aVar3 = W2.t.f19966b;
                    obj = W2.t.b(u.a(th));
                }
                W2.t.a(obj);
            } else {
                return;
            }
        }
        this.f2748b.clear();
        this.f2750d = null;
        this.f2749c = null;
    }

    public final List h() {
        return this.f2748b;
    }

    public final void i() {
        if (Build.VERSION.SDK_INT >= 24) {
            d(this.f2747a);
        } else {
            e(this.f2747a);
        }
    }
}
