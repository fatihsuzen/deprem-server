package Z1;

import S1.k;
import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager$ServiceInfoCallback;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

public final class h {

    /* renamed from: h  reason: collision with root package name */
    public static final a f20257h = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final i f20258a;

    /* renamed from: b  reason: collision with root package name */
    private final NsdManager f20259b;

    /* renamed from: c  reason: collision with root package name */
    private NsdManager.ResolveListener f20260c;

    /* renamed from: d  reason: collision with root package name */
    private NsdManager$ServiceInfoCallback f20261d;

    /* renamed from: e  reason: collision with root package name */
    private NsdManager.DiscoveryListener f20262e;

    /* renamed from: f  reason: collision with root package name */
    private NsdServiceInfo f20263f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList f20264g = new ArrayList();

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final String a(String str, String str2, int i5) {
            t.e(str, "manufacturer");
            t.e(str2, "model");
            String str3 = str + ' ' + str2;
            if (str3.length() <= i5) {
                return str3;
            }
            String substring = str3.substring(0, i5 - 1);
            t.d(substring, "substring(...)");
            return substring;
        }

        public final String b(String str) {
            t.e(str, "deviceId");
            if (str.length() > 16) {
                str = str.substring(0, 15);
                t.d(str, "substring(...)");
            }
            String d5 = d();
            int length = (52 - str.length()) - d5.length();
            String str2 = Build.MANUFACTURER;
            t.d(str2, "MANUFACTURER");
            String str3 = Build.MODEL;
            t.d(str3, "MODEL");
            String a5 = a(str2, str3, length);
            return a5 + "_d:_" + str + "_:d__t:_" + d5;
        }

        public final String c(String str) {
            t.e(str, "serviceName");
            String str2 = str;
            String substring = str2.substring(0, s.f0(str2, "_d:_", 0, false, 6, (Object) null));
            t.d(substring, "substring(...)");
            return substring;
        }

        public final String d() {
            return "0";
        }

        private a() {
        }
    }

    public static final class b implements NsdManager.DiscoveryListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f20265a;

        b(h hVar) {
            this.f20265a = hVar;
        }

        public void onDiscoveryStarted(String str) {
            t.e(str, "regType");
            this.f20265a.f20258a.t();
        }

        public void onDiscoveryStopped(String str) {
            t.e(str, "serviceType");
            this.f20265a.f20258a.g();
        }

        public void onServiceFound(NsdServiceInfo nsdServiceInfo) {
            t.e(nsdServiceInfo, NotificationCompat.CATEGORY_SERVICE);
            if (this.f20265a.l(nsdServiceInfo)) {
                this.f20265a.g().add(nsdServiceInfo);
            }
        }

        public void onServiceLost(NsdServiceInfo nsdServiceInfo) {
            t.e(nsdServiceInfo, NotificationCompat.CATEGORY_SERVICE);
            if (this.f20265a.g().size() > 0) {
                Iterator it = this.f20265a.g().iterator();
                t.d(it, "iterator(...)");
                int i5 = 0;
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    if (t.a(((NsdServiceInfo) next).getServiceName(), nsdServiceInfo.getServiceName())) {
                        break;
                    }
                    i5++;
                }
                if (i5 < this.f20265a.g().size()) {
                    this.f20265a.g().remove(i5);
                }
            }
        }

        public void onStartDiscoveryFailed(String str, int i5) {
            t.e(str, "serviceType");
        }

        public void onStopDiscoveryFailed(String str, int i5) {
            t.e(str, "serviceType");
        }
    }

    public static final class d implements NsdManager.ResolveListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f20267a;

        d(h hVar) {
            this.f20267a = hVar;
        }

        public void onResolveFailed(NsdServiceInfo nsdServiceInfo, int i5) {
            t.e(nsdServiceInfo, "serviceInfo");
        }

        public void onServiceResolved(NsdServiceInfo nsdServiceInfo) {
            t.e(nsdServiceInfo, "serviceInfo");
            this.f20267a.o(nsdServiceInfo);
        }
    }

    public h(Context context, i iVar) {
        t.e(context, "context");
        t.e(iVar, "nsdListener");
        this.f20258a = iVar;
        Object systemService = context.getSystemService("servicediscovery");
        t.c(systemService, "null cannot be cast to non-null type android.net.nsd.NsdManager");
        this.f20259b = (NsdManager) systemService;
    }

    private final void h() {
        if (Build.VERSION.SDK_INT >= 34) {
            if (this.f20261d == null) {
                this.f20261d = g.a(new c(this));
            }
        } else if (this.f20260c == null) {
            this.f20260c = new d(this);
        }
    }

    /* access modifiers changed from: private */
    public final boolean l(NsdServiceInfo nsdServiceInfo) {
        String serviceName = nsdServiceInfo.getServiceName();
        if (!t.a(nsdServiceInfo.getServiceType(), "_nsduptodown._tcp.") || serviceName == null || serviceName.length() == 0 || s.E(serviceName, k.f32g.p(), true)) {
            return false;
        }
        return true;
    }

    private final void n() {
        NsdManager$ServiceInfoCallback nsdManager$ServiceInfoCallback;
        if (Build.VERSION.SDK_INT >= 34 && (nsdManager$ServiceInfoCallback = this.f20261d) != null) {
            try {
                NsdManager nsdManager = this.f20259b;
                t.b(nsdManager$ServiceInfoCallback);
                nsdManager.unregisterServiceInfoCallback(nsdManager$ServiceInfoCallback);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public final void o(NsdServiceInfo nsdServiceInfo) {
        if (!t.a(nsdServiceInfo.getServiceName(), k.f32g.p())) {
            this.f20263f = nsdServiceInfo;
            this.f20258a.a();
        }
    }

    public final void d() {
        if (this.f20262e == null) {
            b bVar = new b(this);
            this.f20262e = bVar;
            try {
                this.f20259b.discoverServices("_nsduptodown._tcp.", 1, bVar);
            } catch (IllegalArgumentException e5) {
                e5.printStackTrace();
                this.f20258a.e();
            }
        }
    }

    public final NsdServiceInfo e() {
        return this.f20263f;
    }

    public final NsdManager f() {
        return this.f20259b;
    }

    public final ArrayList g() {
        return this.f20264g;
    }

    public final void i(int i5, NsdManager.RegistrationListener registrationListener) {
        t.e(registrationListener, "mRegistrationListener");
        NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
        nsdServiceInfo.setPort(i5);
        nsdServiceInfo.setServiceName(k.f32g.p());
        nsdServiceInfo.setServiceType("_nsduptodown._tcp.");
        try {
            this.f20259b.registerService(nsdServiceInfo, 1, registrationListener);
        } catch (Exception unused) {
            this.f20258a.i();
        }
    }

    public final void j() {
        m();
        n();
        this.f20264g.clear();
        this.f20263f = null;
    }

    public final void k(NsdServiceInfo nsdServiceInfo) {
        NsdManager$ServiceInfoCallback nsdManager$ServiceInfoCallback;
        t.e(nsdServiceInfo, NotificationCompat.CATEGORY_SERVICE);
        h();
        if (Build.VERSION.SDK_INT >= 34) {
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            if (newSingleThreadScheduledExecutor != null && (nsdManager$ServiceInfoCallback = this.f20261d) != null) {
                NsdManager nsdManager = this.f20259b;
                t.b(nsdManager$ServiceInfoCallback);
                nsdManager.registerServiceInfoCallback(nsdServiceInfo, newSingleThreadScheduledExecutor, nsdManager$ServiceInfoCallback);
                return;
            }
            return;
        }
        this.f20259b.resolveService(nsdServiceInfo, this.f20260c);
    }

    public final void m() {
        NsdManager.DiscoveryListener discoveryListener = this.f20262e;
        if (discoveryListener != null) {
            try {
                this.f20259b.stopServiceDiscovery(discoveryListener);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            this.f20262e = null;
        }
    }

    public static final class c implements NsdManager$ServiceInfoCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f20266a;

        c(h hVar) {
            this.f20266a = hVar;
        }

        public void onServiceUpdated(NsdServiceInfo nsdServiceInfo) {
            t.e(nsdServiceInfo, "serviceInfo");
            this.f20266a.o(nsdServiceInfo);
        }

        public void onServiceInfoCallbackUnregistered() {
        }

        public void onServiceLost() {
        }

        public void onServiceInfoCallbackRegistrationFailed(int i5) {
        }
    }
}
