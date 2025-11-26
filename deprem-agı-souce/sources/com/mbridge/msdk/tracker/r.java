package com.mbridge.msdk.tracker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.mbridge.msdk.e.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

final class r {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final c f11728a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11729b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f11730c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11731d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final k f11732e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f11733f = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final AtomicInteger f11734g = new AtomicInteger(0);

    /* renamed from: h  reason: collision with root package name */
    private final Object f11735h = new Object();

    /* renamed from: i  reason: collision with root package name */
    private Handler f11736i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11737j = true;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public long f11738k = 0;

    /* renamed from: l  reason: collision with root package name */
    private volatile boolean f11739l = false;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f11740m = false;

    private static final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final r f11743a;

        public b(Looper looper, r rVar) {
            super(looper);
            this.f11743a = rVar;
        }

        private void a(String str) {
            Log.d("TrackManager", this.f11743a.f11732e.c() + " " + str + this.f11743a.f11734g.addAndGet(0) + " 数据库记录数：" + this.f11743a.f11728a.a());
        }

        private void b() {
            try {
                removeMessages(1);
                removeMessages(6);
                removeMessages(2);
                removeMessages(3);
            } catch (Exception e5) {
                if (a.f11490a) {
                    Log.e("TrackManager", this.f11743a.f11732e.c() + " removeMessages failed ", e5);
                }
            }
            if (!this.f11743a.f()) {
                try {
                    sendMessageDelayed(Message.obtain(this, 1), y.a(this.f11743a.f11733f.get(), this.f11743a.f11738k, (long) this.f11743a.f11730c));
                } catch (Exception e6) {
                    if (a.f11490a) {
                        Log.e("TrackManager", this.f11743a.f11732e.c() + " sendMessageDelayed failed ", e6);
                    }
                }
            }
        }

        public final void dispatchMessage(Message message) {
            e eVar;
            super.dispatchMessage(message);
            int i5 = message.what;
            if (i5 == 2 || i5 == 3) {
                b();
                if (a.f11490a) {
                    a("触发上报（report result）当前 Event 数量：");
                }
                a();
            } else if (i5 == 5) {
                if (a.f11490a) {
                    a("触发删除 当前 Event 数量：");
                }
                r.a(this.f11743a);
                sendMessageDelayed(Message.obtain(this, 5), 120000);
            } else if (i5 == 6) {
                Object obj = message.obj;
                if (obj instanceof e) {
                    eVar = (e) obj;
                } else {
                    eVar = null;
                }
                if (a.f11490a && !y.a((Object) eVar)) {
                    a(String.format("收到 Event( %s )，当前 Event 数量：", new Object[]{eVar.a()}));
                }
                if ((y.b((Object) eVar) && eVar.c() == 1) || this.f11743a.e()) {
                    b();
                    if (a.f11490a) {
                        a("触发上报（notice check）当前 Event 数量：");
                    }
                    a();
                }
            } else if (i5 != 7) {
                b();
                if (a.f11490a) {
                    a("触发上报（timer）当前 Event 数量：");
                }
                a();
            } else {
                this.f11743a.c();
                b();
                if (a.f11490a) {
                    a("触发上报（flush）当前 Event 数量：");
                }
                a();
            }
        }

        private synchronized void a() {
            try {
                r.e(this.f11743a);
            } catch (Exception e5) {
                if (a.f11490a) {
                    Log.e("TrackManager", this.f11743a.f11732e.c() + " report failed ", e5);
                }
            }
        }
    }

    public r(k kVar) {
        this.f11728a = kVar.g();
        this.f11729b = kVar.l();
        this.f11730c = kVar.m();
        this.f11731d = kVar.n();
        this.f11732e = kVar;
    }

    /* access modifiers changed from: protected */
    public final boolean e() {
        return this.f11734g.addAndGet(0) >= this.f11729b;
    }

    static /* synthetic */ void e(r rVar) {
        if (rVar.f11732e.t()) {
            List<i> a5 = rVar.f11728a.a(rVar.f11729b);
            if (!y.a((List<?>) a5)) {
                rVar.f11728a.a(a5);
                int size = a5.size();
                rVar.f11734g.addAndGet(-size);
                boolean z4 = false;
                if (a.f11490a) {
                    Log.d("TrackManager", rVar.f11732e.c() + " report: 上报的数量 = " + size + " 当前剩余事件数 = " + rVar.f11734g.addAndGet(0) + " 数据库中剩余事件数 = " + rVar.f11728a.a());
                }
                try {
                    z4 = rVar.f11732e.p();
                } catch (IllegalStateException e5) {
                    if (a.f11490a) {
                        Log.e("TrackManager", rVar.f11732e.c() + " report environment check failed ", e5);
                    }
                }
                if (z4) {
                    n q5 = rVar.f11732e.q();
                    q5.a(new a(rVar.f11736i, rVar));
                    Map<String, String> hashMap = new HashMap<>();
                    try {
                        hashMap = rVar.f11732e.j().a(rVar.f11732e.k(), a5, rVar.f11732e.f());
                    } catch (Exception e6) {
                        if (a.f11490a) {
                            Log.e("TrackManager", rVar.f11732e.c() + " report decorate request params failed ", e6);
                        }
                    }
                    q5.a(new s(a5), hashMap, y.b(a5));
                } else if (a.f11490a) {
                    Log.e("TrackManager", rVar.f11732e.c() + " report 失败，请检查 TrackConfig 配置是否正确");
                }
            } else if (a.f11490a) {
                Log.d("TrackManager", rVar.f11732e.c() + " report: 没有可以上报的数据");
            }
        }
    }

    public final void a() {
        HandlerThread handlerThread = new HandlerThread("report_timer");
        handlerThread.start();
        b bVar = new b(handlerThread.getLooper(), this);
        this.f11736i = bVar;
        bVar.sendMessageDelayed(Message.obtain(bVar, 5), 5000);
        Handler handler = this.f11736i;
        handler.sendMessageDelayed(Message.obtain(handler, 1), (long) this.f11730c);
        this.f11737j = false;
    }

    public final void b() {
        this.f11736i.removeMessages(1);
        Handler handler = this.f11736i;
        handler.sendMessage(Message.obtain(handler, 7));
    }

    public final void c() {
        synchronized (this.f11735h) {
            try {
                if (!this.f11739l) {
                    this.f11739l = true;
                    this.f11728a.c();
                }
                if (!this.f11740m) {
                    this.f11740m = true;
                    this.f11734g.addAndGet(this.f11728a.a());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        this.f11734g.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return this.f11737j;
    }

    static /* synthetic */ void b(r rVar, List list) {
        if (!y.a((List<?>) list)) {
            Iterator it = list.iterator();
            int i5 = 0;
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (!y.a((Object) iVar)) {
                    boolean z4 = true;
                    boolean z5 = !iVar.b() && iVar.d() >= rVar.f11731d;
                    if (iVar.a() || iVar.g() >= System.currentTimeMillis()) {
                        z4 = false;
                    }
                    if (z5 || z4) {
                        iVar.b(-1);
                    } else {
                        iVar.a(iVar.d() + (y.a(rVar.f11732e.e()) ? 1 : 0));
                        iVar.b(3);
                        i5++;
                    }
                }
            }
            rVar.f11728a.c((List<i>) list);
            rVar.f11734g.addAndGet(i5);
        }
    }

    private static final class a implements q {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f11741a;

        /* renamed from: b  reason: collision with root package name */
        private final r f11742b;

        public a(Handler handler, r rVar) {
            this.f11741a = handler;
            this.f11742b = rVar;
        }

        public final void a(s sVar) {
            r.a(this.f11742b, (List) sVar.a());
            this.f11742b.f11733f.set(0);
            long unused = this.f11742b.f11738k = 0;
            if (this.f11742b.e()) {
                Handler handler = this.f11741a;
                handler.sendMessage(Message.obtain(handler, 2));
            }
            if (a.f11490a) {
                Log.d("TrackManager", this.f11742b.f11732e.c() + " report success " + sVar.a().size() + " 剩余事件数：" + this.f11742b.f11734g.addAndGet(0) + " 个，数据库记录数：" + this.f11742b.f11728a.a() + " 个");
            }
        }

        public final void a(s sVar, int i5, String str) {
            r.b(this.f11742b, sVar.a());
            long unused = this.f11742b.f11738k = System.currentTimeMillis();
            int j5 = this.f11742b.f11733f.getAndIncrement();
            if (j5 <= 10) {
                Handler handler = this.f11741a;
                handler.sendMessageDelayed(Message.obtain(handler, 3), ((long) j5) * 1000);
            }
            if (a.f11490a) {
                Log.d("TrackManager", this.f11742b.f11732e.c() + " report failed " + sVar.a().size() + " 剩余事件数：" + this.f11742b.f11734g.addAndGet(0) + " 个，数据库记录数：" + this.f11742b.f11728a.a() + " 个 连续失败次数： " + j5);
            }
        }
    }

    public final void a(e eVar) {
        Handler handler = this.f11736i;
        handler.sendMessage(Message.obtain(handler, 6, eVar));
    }

    static /* synthetic */ void a(r rVar) {
        if (!a.f11490a || !e.f8767b) {
            int b5 = rVar.f11728a.b();
            if (a.f11490a) {
                Log.d("TrackManager", rVar.f11732e.c() + " 删除无效数据的数量 = " + b5 + " 当前剩余事件数 = " + rVar.f11734g.addAndGet(0) + " 数据库中剩余事件数 = " + rVar.f11728a.a());
            }
        }
    }

    static /* synthetic */ void a(r rVar, List list) {
        if (!y.a((List<?>) list)) {
            rVar.f11728a.b((List<i>) list);
        }
    }
}
