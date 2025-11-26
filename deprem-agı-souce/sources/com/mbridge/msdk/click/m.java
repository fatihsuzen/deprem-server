package com.mbridge.msdk.click;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.util.HashMap;
import org.json.JSONObject;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public static long f8163a = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final String f8164d = "m";

    /* renamed from: b  reason: collision with root package name */
    boolean f8165b;

    /* renamed from: c  reason: collision with root package name */
    boolean f8166c;

    /* renamed from: e  reason: collision with root package name */
    private int f8167e = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;

    /* renamed from: f  reason: collision with root package name */
    private int f8168f = 3000;

    /* renamed from: g  reason: collision with root package name */
    private Handler f8169g = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    private g f8170h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f8171i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f8172j;

    /* renamed from: k  reason: collision with root package name */
    private String f8173k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public WebView f8174l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f8175m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public String f8176n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f8177o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f8178p = false;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f8179q;

    /* renamed from: r  reason: collision with root package name */
    private final Runnable f8180r = new Runnable() {
        public final void run() {
            boolean unused = m.this.f8178p = true;
            int unused2 = m.this.f8177o = 1;
            m.m(m.this);
        }
    };

    /* renamed from: s  reason: collision with root package name */
    private final Runnable f8181s = new Runnable() {
        public final void run() {
            boolean unused = m.this.f8178p = true;
            int unused2 = m.this.f8177o = 2;
            m.m(m.this);
        }
    };

    interface a {
        void a(int i5, String str, String str2, String str3);

        void a(String str, boolean z4, String str2);

        boolean a(String str);

        boolean b(String str);

        boolean c(String str);
    }

    public m() {
        g b5 = h.a().b(c.m().k());
        this.f8170h = b5;
        if (b5 == null) {
            h.a();
            this.f8170h = i.a();
        }
        this.f8175m = this.f8170h.aJ();
        this.f8167e = (int) this.f8170h.ar();
        this.f8168f = (int) this.f8170h.ar();
    }

    /* access modifiers changed from: private */
    public void c() {
        this.f8169g.removeCallbacks(this.f8181s);
    }

    static /* synthetic */ void e(m mVar) {
        mVar.c();
        mVar.f8169g.postDelayed(mVar.f8181s, (long) mVar.f8167e);
    }

    static /* synthetic */ void l(m mVar) {
        mVar.d();
        mVar.f8169g.postDelayed(mVar.f8180r, (long) mVar.f8168f);
    }

    static /* synthetic */ void m(m mVar) {
        synchronized (f8164d) {
            try {
                mVar.b();
                mVar.f8174l.destroy();
                a aVar = mVar.f8171i;
                if (aVar != null) {
                    aVar.a(mVar.f8172j, mVar.f8178p, mVar.f8176n);
                }
            } catch (Exception e5) {
                af.b(f8164d, e5.getMessage());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static /* synthetic */ void c(m mVar) {
        synchronized (f8164d) {
            try {
                mVar.b();
                a aVar = mVar.f8171i;
                if (aVar != null) {
                    aVar.a(mVar.f8172j, mVar.f8178p, mVar.f8176n);
                }
            } catch (Exception e5) {
                af.b(f8164d, e5.getMessage());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        this.f8169g.removeCallbacks(this.f8180r);
    }

    /* access modifiers changed from: private */
    public void b() {
        d();
        c();
    }

    public final void a(String str, String str2, Context context, String str3, String str4, a aVar) {
        if (aVar != null) {
            this.f8173k = str4;
            this.f8172j = str3;
            this.f8171i = aVar;
            a(str, str2, context);
            return;
        }
        throw new NullPointerException("OverrideUrlLoadingListener can not be null");
    }

    public final void a(String str, String str2, Context context, String str3, a aVar) {
        if (aVar != null) {
            this.f8172j = str3;
            this.f8171i = aVar;
            a(str, str2, context);
            return;
        }
        throw new NullPointerException("OverrideUrlLoadingListener can not be null");
    }

    private void a(final String str, final String str2, final Context context) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            a(str, str2, context, this.f8172j);
        } else {
            this.f8169g.post(new Runnable() {
                public final void run() {
                    m mVar = m.this;
                    mVar.a(str, str2, context, mVar.f8172j);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, Context context, String str3) {
        try {
            a(context, str, str2);
            if (!TextUtils.isEmpty(this.f8173k)) {
                this.f8174l.getSettings().setDefaultTextEncodingName("utf-8");
                this.f8168f = 2000;
                this.f8167e = 2000;
                af.c(f8164d, this.f8173k);
                this.f8174l.loadDataWithBaseURL(str3, this.f8173k, "*/*", "utf-8", str3);
                return;
            }
            String str4 = str3;
            if (this.f8175m) {
                HashMap hashMap = new HashMap();
                if (this.f8174l.getUrl() != null) {
                    hashMap.put("Referer", this.f8174l.getUrl());
                }
                this.f8174l.loadUrl(str4, hashMap);
                return;
            }
            this.f8174l.loadUrl(str4);
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                a aVar = this.f8171i;
                if (aVar != null) {
                    aVar.a(0, this.f8172j, th2.getMessage(), this.f8176n);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void a(final Context context, final String str, final String str2) {
        WebView webView = new WebView(context);
        this.f8174l = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f8174l.getSettings().setCacheMode(2);
        this.f8174l.getSettings().setLoadsImagesAutomatically(false);
        this.f8174l.setWebViewClient(new WebViewClient() {
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    webView.loadUrl("javascript:window.navigator.vibrate([]);");
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                try {
                    webView.loadUrl("javascript:window.navigator.vibrate([]);");
                    if (m.this.f8179q) {
                        int unused = m.this.f8177o = 0;
                        m.c(m.this);
                        return;
                    }
                    m.this.f8166c = false;
                    if (webView.getTag() == null) {
                        webView.setTag("has_first_started");
                    } else {
                        m.this.f8165b = true;
                    }
                    synchronized (m.f8164d) {
                        String unused2 = m.this.f8172j = str;
                        if (m.this.f8171i == null || !m.this.f8171i.a(str)) {
                            m.e(m.this);
                        } else {
                            boolean unused3 = m.this.f8179q = true;
                            m.c(m.this);
                        }
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                } catch (Throwable th) {
                    throw th;
                }
            }

            public final void onReceivedError(WebView webView, int i5, String str, String str2) {
                synchronized (m.f8164d) {
                    boolean unused = m.this.f8179q = true;
                    m.this.b();
                    m.c(m.this);
                }
                if (m.this.f8171i != null) {
                    m.this.f8171i.a(i5, webView.getUrl(), str, m.this.f8176n);
                }
            }

            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                try {
                    if (MBridgeConstans.IS_SP_CBT_CF && sslErrorHandler != null) {
                        sslErrorHandler.cancel();
                    }
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                        new com.mbridge.msdk.foundation.same.report.h(context);
                        String str = str;
                        String str2 = str2;
                        String url = webView.getUrl();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("click_type", "1");
                            jSONObject.put("cid", str);
                            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                            jSONObject.put("key", "2000027");
                            jSONObject.put("http_url", url);
                            d.a().a(jSONObject);
                        } catch (Exception e5) {
                            af.b(com.mbridge.msdk.foundation.same.report.h.f9530a, e5.getMessage());
                        }
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }

            public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                try {
                    synchronized (m.f8164d) {
                        boolean unused = m.this.f8179q = true;
                        m.this.b();
                        m.c(m.this);
                    }
                    if (m.this.f8171i != null) {
                        m.this.f8171i.a(-1, webView.getUrl(), "WebView render process crash.", m.this.f8176n);
                    }
                    if (webView != null) {
                        webView.destroy();
                    }
                    return true;
                } catch (Throwable th) {
                    af.b(m.f8164d, th.getMessage());
                    return true;
                }
            }

            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
                if (com.mbridge.msdk.click.m.h(r3.f8189d) == false) goto L_0x0080;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
                r4 = new java.util.HashMap();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0065, code lost:
                if (com.mbridge.msdk.click.m.i(r3.f8189d).getUrl() == null) goto L_0x0076;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0067, code lost:
                r4.put("Referer", com.mbridge.msdk.click.m.i(r3.f8189d).getUrl());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0076, code lost:
                com.mbridge.msdk.click.m.i(r3.f8189d).loadUrl(r5, r4);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
                com.mbridge.msdk.click.m.i(r3.f8189d).loadUrl(r5);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x0089, code lost:
                return true;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean shouldOverrideUrlLoading(android.webkit.WebView r4, java.lang.String r5) {
                /*
                    r3 = this;
                    java.lang.String r4 = com.mbridge.msdk.click.m.f8164d
                    monitor-enter(r4)
                    com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this     // Catch:{ all -> 0x0021 }
                    r1 = 1
                    r0.f8166c = r1     // Catch:{ all -> 0x0021 }
                    r0.d()     // Catch:{ all -> 0x0021 }
                    com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this     // Catch:{ all -> 0x0021 }
                    boolean r0 = r0.f8179q     // Catch:{ all -> 0x0021 }
                    if (r0 == 0) goto L_0x0023
                    com.mbridge.msdk.click.m r5 = com.mbridge.msdk.click.m.this     // Catch:{ all -> 0x0021 }
                    r5.c()     // Catch:{ all -> 0x0021 }
                    com.mbridge.msdk.click.m r5 = com.mbridge.msdk.click.m.this     // Catch:{ all -> 0x0021 }
                    com.mbridge.msdk.click.m.c(r5)     // Catch:{ all -> 0x0021 }
                    monitor-exit(r4)     // Catch:{ all -> 0x0021 }
                    return r1
                L_0x0021:
                    r5 = move-exception
                    goto L_0x008a
                L_0x0023:
                    com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this     // Catch:{ all -> 0x0021 }
                    java.lang.String unused = r0.f8172j = r5     // Catch:{ all -> 0x0021 }
                    com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this     // Catch:{ all -> 0x0021 }
                    com.mbridge.msdk.click.m$a r0 = r0.f8171i     // Catch:{ all -> 0x0021 }
                    if (r0 == 0) goto L_0x004d
                    com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this     // Catch:{ all -> 0x0021 }
                    com.mbridge.msdk.click.m$a r0 = r0.f8171i     // Catch:{ all -> 0x0021 }
                    boolean r0 = r0.b(r5)     // Catch:{ all -> 0x0021 }
                    if (r0 == 0) goto L_0x004d
                    com.mbridge.msdk.click.m r5 = com.mbridge.msdk.click.m.this     // Catch:{ all -> 0x0021 }
                    boolean unused = r5.f8179q = r1     // Catch:{ all -> 0x0021 }
                    com.mbridge.msdk.click.m r5 = com.mbridge.msdk.click.m.this     // Catch:{ all -> 0x0021 }
                    r5.c()     // Catch:{ all -> 0x0021 }
                    com.mbridge.msdk.click.m r5 = com.mbridge.msdk.click.m.this     // Catch:{ all -> 0x0021 }
                    com.mbridge.msdk.click.m.c(r5)     // Catch:{ all -> 0x0021 }
                    monitor-exit(r4)     // Catch:{ all -> 0x0021 }
                    return r1
                L_0x004d:
                    monitor-exit(r4)     // Catch:{ all -> 0x0021 }
                    com.mbridge.msdk.click.m r4 = com.mbridge.msdk.click.m.this
                    boolean r4 = r4.f8175m
                    if (r4 == 0) goto L_0x0080
                    java.util.HashMap r4 = new java.util.HashMap
                    r4.<init>()
                    com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this
                    android.webkit.WebView r0 = r0.f8174l
                    java.lang.String r0 = r0.getUrl()
                    if (r0 == 0) goto L_0x0076
                    java.lang.String r0 = "Referer"
                    com.mbridge.msdk.click.m r2 = com.mbridge.msdk.click.m.this
                    android.webkit.WebView r2 = r2.f8174l
                    java.lang.String r2 = r2.getUrl()
                    r4.put(r0, r2)
                L_0x0076:
                    com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this
                    android.webkit.WebView r0 = r0.f8174l
                    r0.loadUrl(r5, r4)
                    goto L_0x0089
                L_0x0080:
                    com.mbridge.msdk.click.m r4 = com.mbridge.msdk.click.m.this
                    android.webkit.WebView r4 = r4.f8174l
                    r4.loadUrl(r5)
                L_0x0089:
                    return r1
                L_0x008a:
                    monitor-exit(r4)     // Catch:{ all -> 0x0021 }
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.m.AnonymousClass2.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
            }
        });
        this.f8174l.setWebChromeClient(new WebChromeClient() {
            public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                return true;
            }

            public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                return true;
            }

            public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                return true;
            }

            public final void onProgressChanged(WebView webView, int i5) {
                if (i5 == 100) {
                    try {
                        webView.loadUrl("javascript:window.navigator.vibrate([]);");
                        if (!m.this.f8179q) {
                            m mVar = m.this;
                            if (!mVar.f8166c) {
                                m.l(mVar);
                            }
                        }
                        if (m.this.f8171i != null) {
                            m.this.f8171i.c(webView.getUrl());
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            }
        });
    }
}
