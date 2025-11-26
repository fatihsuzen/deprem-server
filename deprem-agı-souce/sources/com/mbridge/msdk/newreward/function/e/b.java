package com.mbridge.msdk.newreward.function.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.newreward.a.d;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f10928a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10929b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10930c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f10931d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10932e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f10933f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f10934g;

    /* renamed from: h  reason: collision with root package name */
    private final long f10935h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public c f10936i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f10937j = false;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f10938k = false;

    /* renamed from: l  reason: collision with root package name */
    private d f10939l;

    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f10950a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<b> f10951b;

        /* renamed from: c  reason: collision with root package name */
        private final long f10952c;

        public a(Handler handler, b bVar, long j5) {
            this.f10950a = handler;
            this.f10951b = new WeakReference<>(bVar);
            this.f10952c = j5;
        }

        public final void run() {
            b bVar = this.f10951b.get();
            if (bVar != null) {
                try {
                    b.a(bVar);
                } catch (Exception e5) {
                    af.a("LoadCheckController", "startCheckTask error: " + e5.getMessage());
                }
            }
            Handler handler = this.f10950a;
            if (handler != null) {
                handler.postDelayed(this, this.f10952c);
            }
        }
    }

    public b(int i5, String str, String str2, boolean z4) {
        this.f10928a = i5;
        this.f10929b = str;
        this.f10930c = str2;
        this.f10931d = z4;
        this.f10932e = ah.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_LOAD_CHECK_INTERVAL, 120000);
        this.f10935h = (long) ah.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_LOAD_TOKEN_VALIDITY_PERIOD, 1800000);
        this.f10933f = ah.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_LOAD_CHECK_OPTIMIZED, false);
    }

    public final void a(c cVar, d dVar) {
        if (cVar == null || dVar == null) {
            a();
        } else if (!this.f10933f) {
            a();
        } else {
            this.f10939l = dVar;
            this.f10936i = cVar;
            HandlerThread handlerThread = new HandlerThread("load_check_controller");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.f10934g = handler;
            handler.postDelayed(new a(handler, this, (long) this.f10932e), (long) this.f10932e);
        }
    }

    private void a() {
        com.mbridge.msdk.newreward.function.d.c.a().b().b(this.f10928a, this.f10929b, this.f10930c);
    }

    private void a(e eVar, com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        eVar.F().a(bVar, bVar2);
    }

    @NonNull
    private e a(com.mbridge.msdk.newreward.function.c.a.b bVar) {
        e eVar = new e(false, this.f10928a, bVar.h(), this.f10930c, bVar.i());
        eVar.f(bVar.g());
        eVar.f(30000);
        eVar.g((int) MBridgeCommon.DEFAULT_LOAD_TIMEOUT);
        eVar.e(this.f10929b);
        eVar.a(true);
        eVar.b(false);
        eVar.c(false);
        return eVar;
    }

    static /* synthetic */ void a(b bVar) {
        if (bVar.f10939l.a() != null) {
            for (e y4 : bVar.f10939l.a()) {
                if (y4.y() == 1) {
                    return;
                }
            }
        }
        if (!bVar.f10937j) {
            bVar.f10937j = true;
            com.mbridge.msdk.newreward.function.d.c.a().b().a(bVar.f10928a, bVar.f10929b, bVar.f10930c, bVar.f10931d, (com.mbridge.msdk.newreward.function.d.b) new com.mbridge.msdk.newreward.function.d.b() {
                public final void a(List<com.mbridge.msdk.newreward.function.c.a.b> list) {
                    b.a(b.this, (List) list);
                }

                public final void a() {
                    b.a(b.this, (e) null, (com.mbridge.msdk.newreward.function.c.a.b) null);
                }
            });
        }
    }

    static /* synthetic */ void a(b bVar, List list) {
        Iterator it = list.iterator();
        final com.mbridge.msdk.newreward.function.c.a.b bVar2 = null;
        final com.mbridge.msdk.newreward.function.c.a.b bVar3 = null;
        while (it.hasNext()) {
            com.mbridge.msdk.newreward.function.c.a.b bVar4 = (com.mbridge.msdk.newreward.function.c.a.b) it.next();
            if (bVar4.i()) {
                long I4 = bVar4.I();
                if (I4 == 0) {
                    com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar4.c(), bVar4.d(), bVar4.e(), bVar4.g(), 8);
                } else if (TextUtils.isEmpty(bVar4.h())) {
                    com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar4.c(), bVar4.d(), bVar4.e(), bVar4.g(), 8);
                } else if (System.currentTimeMillis() - I4 > bVar.f10935h && bVar4.u() == null) {
                    com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar4.c(), bVar4.d(), bVar4.e(), bVar4.g(), 8);
                } else if (bVar4.s() <= 0.0d && bVar4.G() != 1) {
                    com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar4.c(), bVar4.d(), bVar4.e(), bVar4.g(), 8);
                } else if (bVar3 != null && bVar4.s() <= bVar3.s()) {
                }
            } else if (bVar4.I() == 0) {
                com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar4.c(), bVar4.d(), bVar4.e(), bVar4.g(), 8);
            } else if (bVar4.E() == null || bVar4.E().size() == 0) {
                com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar4.c(), bVar4.d(), bVar4.e(), bVar4.g(), 8);
            } else if (bVar3 != null && bVar4.I() <= bVar3.I()) {
            }
            bVar3 = bVar4;
        }
        if (list.size() != 0 && !bVar.f10938k) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                com.mbridge.msdk.newreward.function.c.a.b bVar5 = (com.mbridge.msdk.newreward.function.c.a.b) it2.next();
                if (!(bVar5 == bVar3 || bVar5.u() == null)) {
                    if (bVar2 == null || bVar5.I() > bVar2.I()) {
                        bVar2 = bVar5;
                    }
                }
            }
        }
        if (!bVar.f10938k && bVar2 != null) {
            bVar.f10938k = true;
            final e a5 = bVar.a(bVar2);
            try {
                c cVar = bVar.f10936i;
                cVar.a((Object) a5, f.REPORT_LOAD_CHECK, (Object) cVar.a("check_type", "download_start_resource", "campaign", bVar2));
            } catch (Exception e5) {
                af.b("LoadCheckController", "handlerAnthonyNeedDownloadCampaign error: " + e5.getMessage());
            }
            bVar.a(a5, bVar2, (com.mbridge.msdk.newreward.a.b.b) new com.mbridge.msdk.newreward.a.b.b() {
                public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                    boolean unused = b.this.f10938k = false;
                    try {
                        b.this.f10936i.a((Object) a5, f.REPORT_LOAD_CHECK, (Object) b.this.f10936i.a("check_type", "download_failed", "campaign", bVar2));
                    } catch (Exception e5) {
                        af.b("LoadCheckController", "handlerAnthonyNeedDownloadCampaign error: " + e5.getMessage());
                    }
                }

                public final void reqSuccessful(Object obj) {
                    boolean unused = b.this.f10938k = false;
                    try {
                        b.this.f10936i.a((Object) a5, f.REPORT_LOAD_CHECK, (Object) b.this.f10936i.a("check_type", "download_success", "campaign", bVar2));
                    } catch (Exception e5) {
                        af.b("LoadCheckController", "handlerAnthonyNeedDownloadCampaign error: " + e5.getMessage());
                    }
                }
            });
        }
        if (bVar3 != null) {
            List<CampaignEx> E4 = bVar3.E();
            final e a6 = bVar.a(bVar3);
            if (E4 == null) {
                try {
                    c cVar2 = bVar.f10936i;
                    cVar2.a((Object) a6, f.REPORT_LOAD_CHECK, (Object) cVar2.a("check_type", "check_start_campaign"));
                } catch (Exception e6) {
                    Exception exc = e6;
                    af.b("LoadCheckController", "handlerLoadFailedCampaigns error: " + exc.getMessage());
                }
                c cVar3 = bVar.f10936i;
                cVar3.a((Object) cVar3.a("command_manager", cVar3, "adapter_model", a6), (com.mbridge.msdk.newreward.a.b.b) new com.mbridge.msdk.newreward.a.b.b() {
                    public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                        b.a(b.this, a6, bVar3);
                    }

                    public final void reqSuccessful(Object obj) {
                        b.a(b.this, bVar3, a6);
                    }
                });
                return;
            }
            try {
                c cVar4 = bVar.f10936i;
                cVar4.a((Object) a6, f.REPORT_LOAD_CHECK, (Object) cVar4.a("check_type", "check_start_resource"));
            } catch (Exception e7) {
                Exception exc2 = e7;
                af.b("LoadCheckController", "handlerLoadFailedCampaigns error: " + exc2.getMessage());
            }
            bVar.a(a6, bVar3, (com.mbridge.msdk.newreward.a.b.b) new com.mbridge.msdk.newreward.a.b.b() {
                public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                    b.a(b.this, a6, bVar3);
                }

                public final void reqSuccessful(Object obj) {
                    b.a(b.this, bVar3, a6);
                }
            });
            return;
        }
        bVar.f10937j = false;
    }

    static /* synthetic */ void a(b bVar, e eVar, com.mbridge.msdk.newreward.function.c.a.b bVar2) {
        Map map;
        bVar.f10937j = false;
        if (eVar != null) {
            if (bVar2 == null) {
                try {
                    map = bVar.f10936i.a("check_type", "check_failed");
                } catch (Exception e5) {
                    af.b("LoadCheckController", "reportLoadCheckFailed error: " + e5.getMessage());
                    return;
                }
            } else {
                map = bVar.f10936i.a("check_type", "check_failed", "campaign", bVar2);
            }
            bVar.f10936i.a((Object) eVar, f.REPORT_LOAD_CHECK, (Object) map);
        }
    }

    static /* synthetic */ void a(b bVar, com.mbridge.msdk.newreward.function.c.a.b bVar2, e eVar) {
        bVar.f10937j = false;
        if (eVar != null) {
            c cVar = bVar.f10936i;
            cVar.a((Object) eVar, f.REPORT_LOAD_CHECK, (Object) cVar.a("check_type", "check_success", "campaign", bVar2));
            eVar.h(true);
            if (!bVar2.i() || bVar2.s() <= 0.0d) {
                bVar.f10939l.a(eVar);
            }
        }
    }
}
