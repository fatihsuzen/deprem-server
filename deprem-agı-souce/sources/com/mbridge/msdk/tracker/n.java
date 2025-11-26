package com.mbridge.msdk.tracker;

import android.util.Log;
import com.mbridge.msdk.tracker.network.ad;
import com.mbridge.msdk.tracker.network.g;
import com.mbridge.msdk.tracker.network.u;
import com.mbridge.msdk.tracker.network.v;
import com.mbridge.msdk.tracker.network.w;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class n {

    /* renamed from: a  reason: collision with root package name */
    private q f11550a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11551b;

    /* renamed from: c  reason: collision with root package name */
    private final o f11552c;

    /* renamed from: d  reason: collision with root package name */
    private final v f11553d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11554e;

    /* renamed from: f  reason: collision with root package name */
    private v f11555f;

    /* renamed from: g  reason: collision with root package name */
    private final Executor f11556g;

    private static final class a implements w.a {

        /* renamed from: a  reason: collision with root package name */
        private final q f11558a;

        /* renamed from: b  reason: collision with root package name */
        private final s f11559b;

        public a(q qVar, s sVar) {
            this.f11558a = qVar;
            this.f11559b = sVar;
        }

        public final void a(ad adVar) {
            if (y.b((Object) this.f11558a)) {
                try {
                    this.f11558a.a(this.f11559b, 0, adVar.getMessage());
                } catch (Exception e5) {
                    if (a.f11490a) {
                        Log.e("TrackManager", "onErrorResponse error", e5);
                    }
                }
            }
        }
    }

    private static final class b implements w.b {

        /* renamed from: a  reason: collision with root package name */
        private final q f11560a;

        /* renamed from: b  reason: collision with root package name */
        private final s f11561b;

        public b(q qVar, s sVar) {
            this.f11560a = qVar;
            this.f11561b = sVar;
        }

        public final void a(Object obj) {
            if (y.b((Object) this.f11560a)) {
                try {
                    this.f11560a.a(this.f11561b);
                } catch (Exception e5) {
                    if (a.f11490a) {
                        Log.e("TrackManager", "onResponse error", e5);
                    }
                }
            }
        }
    }

    public n(int i5, o oVar, v vVar, int i6) {
        this.f11551b = i5;
        this.f11552c = oVar;
        this.f11553d = vVar;
        this.f11554e = i6;
        int i7 = i5;
        this.f11556g = new ThreadPoolExecutor(i7, i5, 20, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "MBridgeReportResponseThread");
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    public final void a(q qVar) {
        this.f11550a = qVar;
    }

    public final void a(s sVar, Map<String, String> map, boolean z4) {
        u uVar;
        if (y.a((Object) map)) {
            q qVar = this.f11550a;
            if (qVar != null) {
                try {
                    qVar.a(sVar, 0, "params is null");
                } catch (Exception e5) {
                    if (a.f11490a) {
                        Log.e("TrackManager", "send error", e5);
                    }
                }
            }
        } else {
            try {
                if (!y.b((Object) this.f11555f)) {
                    v a5 = com.mbridge.msdk.tracker.network.toolbox.n.a(new com.mbridge.msdk.tracker.network.toolbox.b(this.f11552c.c()), new g(this.f11556g), this.f11551b, (com.mbridge.msdk.tracker.network.b) null);
                    this.f11555f = a5;
                    a5.a();
                }
                if (this.f11554e == 1) {
                    uVar = new u(this.f11552c.b(), 1, this.f11552c.a());
                } else {
                    uVar = new u(this.f11552c.b(), 1);
                }
                uVar.a(map);
                uVar.b(false);
                uVar.c(true);
                uVar.d(true);
                uVar.a(this.f11553d);
                uVar.a(z4 ? u.b.HIGH : u.b.NORMAL);
                uVar.a(new b(this.f11550a, sVar));
                uVar.a((w.a) new a(this.f11550a, sVar));
                this.f11555f.a(uVar);
            } catch (Exception e6) {
                if (a.f11490a) {
                    Log.e("TrackManager", "send error", e6);
                }
                if (y.b((Object) this.f11550a)) {
                    this.f11550a.a(sVar, 0, e6.getMessage());
                }
            }
        }
    }
}
