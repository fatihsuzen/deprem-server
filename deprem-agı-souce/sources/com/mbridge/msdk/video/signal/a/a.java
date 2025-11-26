package com.mbridge.msdk.video.signal.a;

import android.app.Activity;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.video.signal.a;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.videocommon.d.c;

public abstract class a implements d {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f12631a = false;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f12632b = false;

    /* renamed from: c  reason: collision with root package name */
    protected int f12633c = 0;

    /* renamed from: d  reason: collision with root package name */
    protected int f12634d = 0;

    /* renamed from: e  reason: collision with root package name */
    protected int f12635e = 0;

    /* renamed from: f  reason: collision with root package name */
    protected int f12636f = 0;

    /* renamed from: g  reason: collision with root package name */
    protected int f12637g = 0;

    /* renamed from: h  reason: collision with root package name */
    protected int f12638h = 1;

    /* renamed from: i  reason: collision with root package name */
    protected int f12639i = -1;

    /* renamed from: j  reason: collision with root package name */
    protected String f12640j;

    /* renamed from: k  reason: collision with root package name */
    protected c f12641k;

    /* renamed from: l  reason: collision with root package name */
    protected com.mbridge.msdk.click.a f12642l;

    /* renamed from: m  reason: collision with root package name */
    public a.C0112a f12643m = new C0113a();

    /* renamed from: n  reason: collision with root package name */
    protected int f12644n = 2;

    /* renamed from: o  reason: collision with root package name */
    private u1.b f12645o = null;

    /* renamed from: p  reason: collision with root package name */
    private v1.b f12646p = null;

    /* renamed from: q  reason: collision with root package name */
    private u1.a f12647q = null;

    /* renamed from: com.mbridge.msdk.video.signal.a.a$a  reason: collision with other inner class name */
    public static class C0113a implements a.C0112a {
        public void a() {
            af.a("DefaultJSCommon", "onInitSuccess");
        }

        public void b() {
            af.a("DefaultJSCommon", "videoLocationReady");
        }

        public void onDismissLoading(Campaign campaign) {
            af.a("DefaultJSCommon", "onDismissLoading,campaign:" + campaign);
        }

        public void onDownloadFinish(Campaign campaign) {
            af.a("DefaultJSCommon", "onDownloadFinish,campaign:" + campaign);
        }

        public void onDownloadProgress(int i5) {
            af.a("DefaultJSCommon", "onDownloadProgress,progress:" + i5);
        }

        public void onDownloadStart(Campaign campaign) {
            af.a("DefaultJSCommon", "onDownloadStart,campaign:" + campaign);
        }

        public void onFinishRedirection(Campaign campaign, String str) {
            af.a("DefaultJSCommon", "onFinishRedirection,campaign:" + campaign + ",url:" + str);
        }

        public boolean onInterceptDefaultLoadingDialog() {
            af.a("DefaultJSCommon", "onInterceptDefaultLoadingDialog");
            return false;
        }

        public void onRedirectionFailed(Campaign campaign, String str) {
            af.a("DefaultJSCommon", "onFinishRedirection,campaign:" + campaign + ",url:" + str);
        }

        public void onShowLoading(Campaign campaign) {
            af.a("DefaultJSCommon", "onShowLoading,campaign:" + campaign);
        }

        public void onStartRedirection(Campaign campaign, String str) {
            af.a("DefaultJSCommon", "onStartRedirection,campaign:" + campaign + ",url:" + str);
        }

        public void a(boolean z4) {
            af.a("DefaultJSCommon", "onStartInstall");
        }

        public void a(int i5, String str) {
            af.a("DefaultJSCommon", "onH5Error,code:" + i5 + "，msg:" + str);
        }
    }

    public final void a(u1.b bVar) {
        this.f12645o = bVar;
    }

    public final void b(int i5) {
        this.f12634d = i5;
    }

    public final void c(int i5) {
        this.f12633c = i5;
    }

    public void click(int i5, String str) {
        af.a("DefaultJSCommon", "click:type" + i5 + ",pt:" + str);
    }

    public final void d(int i5) {
        this.f12635e = i5;
    }

    public final void e(int i5) {
        this.f12637g = i5;
    }

    public void f() {
    }

    public final int g() {
        return this.f12639i;
    }

    public final void h(int i5) {
        af.a("DefaultJSCommon", "setAlertDialogRole " + i5);
        this.f12638h = i5;
    }

    public void handlerH5Exception(int i5, String str) {
        af.a("DefaultJSCommon", "handlerH5Exception,code=" + i5 + ",msg:" + str);
    }

    public String i() {
        af.a("DefaultJSCommon", "getNotchArea");
        return null;
    }

    public final u1.b j() {
        return this.f12645o;
    }

    public final v1.b k() {
        return this.f12646p;
    }

    public final u1.a l() {
        return this.f12647q;
    }

    public final int m() {
        if (this.f12633c == 0 && this.f12632b) {
            this.f12633c = 1;
        }
        return this.f12633c;
    }

    public final int n() {
        if (this.f12634d == 0 && this.f12632b) {
            this.f12634d = 1;
        }
        return this.f12634d;
    }

    public final int o() {
        if (this.f12635e == 0 && this.f12632b) {
            this.f12635e = 1;
        }
        return this.f12635e;
    }

    public final boolean p() {
        return this.f12632b;
    }

    public static class b implements a.C0112a {

        /* renamed from: a  reason: collision with root package name */
        private d f12648a;

        /* renamed from: b  reason: collision with root package name */
        private a.C0112a f12649b;

        public b(d dVar, a.C0112a aVar) {
            this.f12648a = dVar;
            this.f12649b = aVar;
        }

        public final void a() {
            a.C0112a aVar = this.f12649b;
            if (aVar != null) {
                aVar.a();
            }
        }

        public final void b() {
            a.C0112a aVar = this.f12649b;
            if (aVar != null) {
                aVar.b();
            }
        }

        public final void onDismissLoading(Campaign campaign) {
            a.C0112a aVar = this.f12649b;
            if (aVar != null) {
                aVar.onDismissLoading(campaign);
            }
        }

        public final void onDownloadFinish(Campaign campaign) {
            a.C0112a aVar = this.f12649b;
            if (aVar != null) {
                aVar.onDownloadFinish(campaign);
            }
        }

        public final void onDownloadProgress(int i5) {
            a.C0112a aVar = this.f12649b;
            if (aVar != null) {
                aVar.onDownloadProgress(i5);
            }
        }

        public final void onDownloadStart(Campaign campaign) {
            a.C0112a aVar = this.f12649b;
            if (aVar != null) {
                aVar.onDownloadStart(campaign);
            }
        }

        public final void onFinishRedirection(Campaign campaign, String str) {
            a.C0112a aVar = this.f12649b;
            if (aVar != null) {
                aVar.onFinishRedirection(campaign, str);
            }
            d dVar = this.f12648a;
            if (dVar != null) {
                dVar.d();
            }
        }

        public final boolean onInterceptDefaultLoadingDialog() {
            a.C0112a aVar = this.f12649b;
            if (aVar == null || !aVar.onInterceptDefaultLoadingDialog()) {
                return false;
            }
            return true;
        }

        public final void onRedirectionFailed(Campaign campaign, String str) {
            a.C0112a aVar = this.f12649b;
            if (aVar != null) {
                aVar.onRedirectionFailed(campaign, str);
            }
            d dVar = this.f12648a;
            if (dVar != null) {
                dVar.d();
            }
        }

        public final void onShowLoading(Campaign campaign) {
            a.C0112a aVar = this.f12649b;
            if (aVar != null) {
                aVar.onShowLoading(campaign);
            }
        }

        public final void onStartRedirection(Campaign campaign, String str) {
            a.C0112a aVar = this.f12649b;
            if (aVar != null) {
                aVar.onStartRedirection(campaign, str);
            }
        }

        public final void a(boolean z4) {
            a.C0112a aVar = this.f12649b;
            if (aVar != null) {
                aVar.a(z4);
            }
        }

        public final void a(int i5, String str) {
            a.C0112a aVar = this.f12649b;
            if (aVar != null) {
                aVar.a(i5, str);
            }
        }
    }

    public final void a(v1.b bVar) {
        this.f12646p = bVar;
    }

    public final boolean b() {
        return this.f12631a;
    }

    public String c() {
        af.a("DefaultJSCommon", "init");
        return "{}";
    }

    public void d() {
        af.a("DefaultJSCommon", "finish");
    }

    public final void e() {
        af.a("DefaultJSCommon", "release");
        com.mbridge.msdk.click.a aVar = this.f12642l;
        if (aVar != null) {
            aVar.a(false);
            this.f12642l.a((NativeListener.NativeTrackingListener) null);
            this.f12642l.a();
        }
    }

    public final void f(int i5) {
        this.f12639i = i5;
    }

    public String g(int i5) {
        af.a("DefaultJSCommon", "getSDKInfo");
        return "{}";
    }

    public final void a(u1.a aVar) {
        this.f12647q = aVar;
    }

    public final void b(boolean z4) {
        this.f12631a = z4;
    }

    public final int h() {
        af.a("DefaultJSCommon", "getAlertDialogRole " + this.f12638h);
        return this.f12638h;
    }

    public final void a(int i5) {
        this.f12644n = i5;
    }

    public void b(String str) {
        af.a("DefaultJSCommon", "setNotchArea");
    }

    public final int a() {
        return this.f12637g;
    }

    public final void a(boolean z4) {
        af.a("DefaultJSCommon", "setIsShowingTransparent:" + z4);
        this.f12632b = z4;
    }

    public final void a(String str) {
        af.a("DefaultJSCommon", "setUnitId:" + str);
        this.f12640j = str;
    }

    public final void a(a.C0112a aVar) {
        af.a("DefaultJSCommon", "setTrackingListener:" + aVar);
        this.f12643m = aVar;
    }

    public final void a(c cVar) {
        af.a("DefaultJSCommon", "setSetting:" + cVar);
        this.f12641k = cVar;
    }

    public void a(int i5, String str) {
        af.a("DefaultJSCommon", "statistics,type:" + i5 + ",json:" + str);
    }

    public void a(Activity activity) {
        af.a("DefaultJSCommon", "setActivity ");
    }
}
