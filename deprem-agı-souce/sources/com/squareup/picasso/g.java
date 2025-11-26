package com.squareup.picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.squareup.picasso.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

class g {

    /* renamed from: a  reason: collision with root package name */
    final b f13298a;

    /* renamed from: b  reason: collision with root package name */
    final Context f13299b;

    /* renamed from: c  reason: collision with root package name */
    final ExecutorService f13300c;

    /* renamed from: d  reason: collision with root package name */
    final M1.c f13301d;

    /* renamed from: e  reason: collision with root package name */
    final Map f13302e = new LinkedHashMap();

    /* renamed from: f  reason: collision with root package name */
    final Map f13303f = new WeakHashMap();

    /* renamed from: g  reason: collision with root package name */
    final Map f13304g = new WeakHashMap();

    /* renamed from: h  reason: collision with root package name */
    final Set f13305h = new LinkedHashSet();

    /* renamed from: i  reason: collision with root package name */
    final Handler f13306i;

    /* renamed from: j  reason: collision with root package name */
    final Handler f13307j;

    /* renamed from: k  reason: collision with root package name */
    final M1.a f13308k;

    /* renamed from: l  reason: collision with root package name */
    final z f13309l;

    /* renamed from: m  reason: collision with root package name */
    final List f13310m;

    /* renamed from: n  reason: collision with root package name */
    final c f13311n;

    /* renamed from: o  reason: collision with root package name */
    final boolean f13312o;

    /* renamed from: p  reason: collision with root package name */
    boolean f13313p;

    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final g f13314a;

        /* renamed from: com.squareup.picasso.g$a$a  reason: collision with other inner class name */
        class C0117a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Message f13315a;

            C0117a(Message message) {
                this.f13315a = message;
            }

            public void run() {
                throw new AssertionError("Unknown handler message received: " + this.f13315a.what);
            }
        }

        a(Looper looper, g gVar) {
            super(looper);
            this.f13314a = gVar;
        }

        public void handleMessage(Message message) {
            boolean z4 = false;
            switch (message.what) {
                case 1:
                    this.f13314a.v((C1585a) message.obj);
                    return;
                case 2:
                    this.f13314a.o((C1585a) message.obj);
                    return;
                case 4:
                    this.f13314a.p((C1587c) message.obj);
                    return;
                case 5:
                    this.f13314a.u((C1587c) message.obj);
                    return;
                case 6:
                    this.f13314a.q((C1587c) message.obj, false);
                    return;
                case 7:
                    this.f13314a.n();
                    return;
                case 9:
                    this.f13314a.r((NetworkInfo) message.obj);
                    return;
                case 10:
                    g gVar = this.f13314a;
                    if (message.arg1 == 1) {
                        z4 = true;
                    }
                    gVar.m(z4);
                    return;
                case 11:
                    this.f13314a.s(message.obj);
                    return;
                case 12:
                    this.f13314a.t(message.obj);
                    return;
                default:
                    s.f13356o.post(new C0117a(message));
                    return;
            }
        }
    }

    static class b extends HandlerThread {
        b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    static class c extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private final g f13317a;

        c(g gVar) {
            this.f13317a = gVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f13317a.f13312o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f13317a.f13299b.registerReceiver(this, intentFilter);
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra(MRAIDCommunicatorUtil.KEY_STATE)) {
                        this.f13317a.b(intent.getBooleanExtra(MRAIDCommunicatorUtil.KEY_STATE, false));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    this.f13317a.f(((ConnectivityManager) C.o(context, "connectivity")).getActiveNetworkInfo());
                }
            }
        }
    }

    g(Context context, ExecutorService executorService, Handler handler, M1.c cVar, M1.a aVar, z zVar) {
        b bVar = new b();
        this.f13298a = bVar;
        bVar.start();
        C.i(bVar.getLooper());
        this.f13299b = context;
        this.f13300c = executorService;
        this.f13306i = new a(bVar.getLooper(), this);
        this.f13301d = cVar;
        this.f13307j = handler;
        this.f13308k = aVar;
        this.f13309l = zVar;
        this.f13310m = new ArrayList(4);
        this.f13313p = C.q(context);
        this.f13312o = C.p(context, "android.permission.ACCESS_NETWORK_STATE");
        c cVar2 = new c(this);
        this.f13311n = cVar2;
        cVar2.a();
    }

    private void a(C1587c cVar) {
        if (!cVar.u()) {
            Bitmap bitmap = cVar.f13280m;
            if (bitmap != null) {
                bitmap.prepareToDraw();
            }
            this.f13310m.add(cVar);
            if (!this.f13306i.hasMessages(7)) {
                this.f13306i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    private void i() {
        if (!this.f13303f.isEmpty()) {
            Iterator it = this.f13303f.values().iterator();
            while (it.hasNext()) {
                C1585a aVar = (C1585a) it.next();
                it.remove();
                if (aVar.g().f13370m) {
                    C.t("Dispatcher", "replaying", aVar.i().d());
                }
                w(aVar, false);
            }
        }
    }

    private void j(List list) {
        if (list != null && !list.isEmpty() && ((C1587c) list.get(0)).q().f13370m) {
            StringBuilder sb = new StringBuilder();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C1587c cVar = (C1587c) it.next();
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(C.k(cVar));
            }
            C.t("Dispatcher", "delivered", sb.toString());
        }
    }

    private void k(C1585a aVar) {
        Object k5 = aVar.k();
        if (k5 != null) {
            aVar.f13257k = true;
            this.f13303f.put(k5, aVar);
        }
    }

    private void l(C1587c cVar) {
        C1585a h5 = cVar.h();
        if (h5 != null) {
            k(h5);
        }
        List i5 = cVar.i();
        if (i5 != null) {
            int size = i5.size();
            for (int i6 = 0; i6 < size; i6++) {
                k((C1585a) i5.get(i6));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z4) {
        Handler handler = this.f13306i;
        handler.sendMessage(handler.obtainMessage(10, z4 ? 1 : 0, 0));
    }

    /* access modifiers changed from: package-private */
    public void c(C1585a aVar) {
        Handler handler = this.f13306i;
        handler.sendMessage(handler.obtainMessage(2, aVar));
    }

    /* access modifiers changed from: package-private */
    public void d(C1587c cVar) {
        Handler handler = this.f13306i;
        handler.sendMessage(handler.obtainMessage(4, cVar));
    }

    /* access modifiers changed from: package-private */
    public void e(C1587c cVar) {
        Handler handler = this.f13306i;
        handler.sendMessage(handler.obtainMessage(6, cVar));
    }

    /* access modifiers changed from: package-private */
    public void f(NetworkInfo networkInfo) {
        Handler handler = this.f13306i;
        handler.sendMessage(handler.obtainMessage(9, networkInfo));
    }

    /* access modifiers changed from: package-private */
    public void g(C1587c cVar) {
        Handler handler = this.f13306i;
        handler.sendMessageDelayed(handler.obtainMessage(5, cVar), 500);
    }

    /* access modifiers changed from: package-private */
    public void h(C1585a aVar) {
        Handler handler = this.f13306i;
        handler.sendMessage(handler.obtainMessage(1, aVar));
    }

    /* access modifiers changed from: package-private */
    public void m(boolean z4) {
        this.f13313p = z4;
    }

    /* access modifiers changed from: package-private */
    public void n() {
        ArrayList arrayList = new ArrayList(this.f13310m);
        this.f13310m.clear();
        Handler handler = this.f13307j;
        handler.sendMessage(handler.obtainMessage(8, arrayList));
        j(arrayList);
    }

    /* access modifiers changed from: package-private */
    public void o(C1585a aVar) {
        String d5 = aVar.d();
        C1587c cVar = (C1587c) this.f13302e.get(d5);
        if (cVar != null) {
            cVar.f(aVar);
            if (cVar.c()) {
                this.f13302e.remove(d5);
                if (aVar.g().f13370m) {
                    C.t("Dispatcher", "canceled", aVar.i().d());
                }
            }
        }
        if (this.f13305h.contains(aVar.j())) {
            this.f13304g.remove(aVar.k());
            if (aVar.g().f13370m) {
                C.u("Dispatcher", "canceled", aVar.i().d(), "because paused request got canceled");
            }
        }
        C1585a aVar2 = (C1585a) this.f13303f.remove(aVar.k());
        if (aVar2 != null && aVar2.g().f13370m) {
            C.u("Dispatcher", "canceled", aVar2.i().d(), "from replaying");
        }
    }

    /* access modifiers changed from: package-private */
    public void p(C1587c cVar) {
        if (o.b(cVar.p())) {
            this.f13308k.b(cVar.n(), cVar.s());
        }
        this.f13302e.remove(cVar.n());
        a(cVar);
        if (cVar.q().f13370m) {
            C.u("Dispatcher", "batched", C.k(cVar), "for completion");
        }
    }

    /* access modifiers changed from: package-private */
    public void q(C1587c cVar, boolean z4) {
        String str;
        if (cVar.q().f13370m) {
            String k5 = C.k(cVar);
            StringBuilder sb = new StringBuilder();
            sb.append("for error");
            if (z4) {
                str = " (will replay)";
            } else {
                str = "";
            }
            sb.append(str);
            C.u("Dispatcher", "batched", k5, sb.toString());
        }
        this.f13302e.remove(cVar.n());
        a(cVar);
    }

    /* access modifiers changed from: package-private */
    public void r(NetworkInfo networkInfo) {
        ExecutorService executorService = this.f13300c;
        if (executorService instanceof u) {
            ((u) executorService).a(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            i();
        }
    }

    /* access modifiers changed from: package-private */
    public void s(Object obj) {
        boolean z4;
        if (this.f13305h.add(obj)) {
            Iterator it = this.f13302e.values().iterator();
            while (it.hasNext()) {
                C1587c cVar = (C1587c) it.next();
                boolean z5 = cVar.q().f13370m;
                C1585a h5 = cVar.h();
                List i5 = cVar.i();
                if (i5 == null || i5.isEmpty()) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (h5 != null || z4) {
                    if (h5 != null && h5.j().equals(obj)) {
                        cVar.f(h5);
                        this.f13304g.put(h5.k(), h5);
                        if (z5) {
                            C.u("Dispatcher", "paused", h5.f13248b.d(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (z4) {
                        for (int size = i5.size() - 1; size >= 0; size--) {
                            C1585a aVar = (C1585a) i5.get(size);
                            if (aVar.j().equals(obj)) {
                                cVar.f(aVar);
                                this.f13304g.put(aVar.k(), aVar);
                                if (z5) {
                                    C.u("Dispatcher", "paused", aVar.f13248b.d(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (cVar.c()) {
                        it.remove();
                        if (z5) {
                            C.u("Dispatcher", "canceled", C.k(cVar), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void t(Object obj) {
        if (this.f13305h.remove(obj)) {
            Iterator it = this.f13304g.values().iterator();
            ArrayList arrayList = null;
            while (it.hasNext()) {
                C1585a aVar = (C1585a) it.next();
                if (aVar.j().equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(aVar);
                    it.remove();
                }
            }
            if (arrayList != null) {
                Handler handler = this.f13307j;
                handler.sendMessage(handler.obtainMessage(13, arrayList));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void u(C1587c cVar) {
        NetworkInfo networkInfo;
        if (!cVar.u()) {
            boolean z4 = false;
            if (this.f13300c.isShutdown()) {
                q(cVar, false);
                return;
            }
            if (this.f13312o) {
                networkInfo = ((ConnectivityManager) C.o(this.f13299b, "connectivity")).getActiveNetworkInfo();
            } else {
                networkInfo = null;
            }
            if (cVar.w(this.f13313p, networkInfo)) {
                if (cVar.q().f13370m) {
                    C.t("Dispatcher", "retrying", C.k(cVar));
                }
                if (cVar.k() instanceof q.a) {
                    cVar.f13276i |= p.NO_CACHE.f13348a;
                }
                cVar.f13281n = this.f13300c.submit(cVar);
                return;
            }
            if (this.f13312o && cVar.x()) {
                z4 = true;
            }
            q(cVar, z4);
            if (z4) {
                l(cVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v(C1585a aVar) {
        w(aVar, true);
    }

    /* access modifiers changed from: package-private */
    public void w(C1585a aVar, boolean z4) {
        if (this.f13305h.contains(aVar.j())) {
            this.f13304g.put(aVar.k(), aVar);
            if (aVar.g().f13370m) {
                String d5 = aVar.f13248b.d();
                C.u("Dispatcher", "paused", d5, "because tag '" + aVar.j() + "' is paused");
                return;
            }
            return;
        }
        C1587c cVar = (C1587c) this.f13302e.get(aVar.d());
        if (cVar != null) {
            cVar.b(aVar);
        } else if (!this.f13300c.isShutdown()) {
            C1587c g5 = C1587c.g(aVar.g(), this, this.f13308k, this.f13309l, aVar);
            g5.f13281n = this.f13300c.submit(g5);
            this.f13302e.put(aVar.d(), g5);
            if (z4) {
                this.f13303f.remove(aVar.k());
            }
            if (aVar.g().f13370m) {
                C.t("Dispatcher", "enqueued", aVar.f13248b.d());
            }
        } else if (aVar.g().f13370m) {
            C.u("Dispatcher", "ignored", aVar.f13248b.d(), "because shut down");
        }
    }
}
