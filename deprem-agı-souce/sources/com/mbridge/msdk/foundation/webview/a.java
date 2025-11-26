package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.mbridge.msdk.activity.MBCommonActivity;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.out.NativeListener;
import java.util.ArrayList;
import java.util.List;

public class a implements BrowserView.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static String f9797a = "a";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f9798b = 10000;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9799c = true;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f9800d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9801e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public BaseTrackingListener f9802f;

    /* renamed from: g  reason: collision with root package name */
    private BrowserView f9803g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CampaignEx f9804h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public com.mbridge.msdk.click.a f9805i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Context f9806j;

    /* renamed from: k  reason: collision with root package name */
    private Handler f9807k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public JumpLoaderResult f9808l = null;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f9809m = false;

    /* renamed from: n  reason: collision with root package name */
    private final Runnable f9810n = new Runnable() {
        public final void run() {
            String b5 = a.f9797a;
            af.b(b5, "webview js！超时上限：" + a.this.f9798b + "ms");
            if (!(a.this.f9805i == null || a.this.f9808l == null)) {
                a.this.f9808l.setSuccess(false);
                a.this.f9808l.setUrl(a.this.f9800d);
                a.this.f9808l.setType(2);
                a.this.f9808l.setExceptionMsg("linktype 8 time out");
                a.this.f9805i.a(a.this.f9808l, a.this.f9804h, 1, false);
            }
            a aVar = a.this;
            if (aVar.d((WebView) null, aVar.f9800d) && !a.this.f9809m) {
                boolean unused = a.this.f9809m = true;
                a aVar2 = a.this;
                aVar2.a(aVar2.f9806j, a.this.f9800d, a.this.f9804h);
            }
            if (a.this.f9802f != null) {
                a.this.f9802f.onFinishRedirection(a.this.f9804h, a.this.f9800d);
            }
        }
    };

    /* renamed from: o  reason: collision with root package name */
    private long f9811o;

    public a(Context context, CampaignEx campaignEx, com.mbridge.msdk.click.a aVar, BrowserView browserView, BaseTrackingListener baseTrackingListener) {
        this.f9806j = context;
        this.f9804h = campaignEx;
        this.f9803g = browserView;
        this.f9802f = baseTrackingListener;
        this.f9807k = new Handler(Looper.getMainLooper());
        g b5 = h.a().b(c.m().k());
        if (b5 == null) {
            h.a();
            b5 = i.a();
        }
        this.f9805i = aVar;
        this.f9808l = new JumpLoaderResult();
        this.f9798b = (int) b5.ar();
    }

    public final void a() {
    }

    /* access modifiers changed from: private */
    public boolean d(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            Uri parse = Uri.parse(str);
            if (!parse.getScheme().equals("http")) {
                if (!parse.getScheme().equals("https")) {
                    if (parse.getScheme().equals("intent")) {
                        Intent parseUri = Intent.parseUri(str, 1);
                        String str2 = parseUri.getPackage();
                        if (!TextUtils.isEmpty(str2) && this.f9806j.getPackageManager().getLaunchIntentForPackage(str2) != null) {
                            return false;
                        }
                        try {
                            String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                            if (!TextUtils.isEmpty(stringExtra)) {
                                Uri parse2 = Uri.parse(str);
                                if (parse2.getScheme().equals("http") || parse2.getScheme().equals("https")) {
                                    return true;
                                }
                                str = stringExtra;
                            }
                        } catch (Throwable th) {
                            af.b(f9797a, th.getMessage());
                        }
                    }
                    if (com.mbridge.msdk.click.c.e(this.f9806j, str)) {
                        af.b(f9797a, "openDeepLink");
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th2) {
            af.b(f9797a, th2.getMessage());
            return true;
        }
    }

    private boolean e(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            if (!parse.getScheme().equals("http")) {
                if (!parse.getScheme().equals("https")) {
                    if (parse.getScheme().equals("intent")) {
                        Intent parseUri = Intent.parseUri(str, 1);
                        String str2 = parseUri.getPackage();
                        if (!TextUtils.isEmpty(str2) && this.f9806j.getPackageManager().getLaunchIntentForPackage(str2) != null) {
                            parseUri.setFlags(268435456);
                            this.f9806j.startActivity(parseUri);
                            this.f9809m = true;
                            return true;
                        }
                        try {
                            String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                            if (!TextUtils.isEmpty(stringExtra)) {
                                Uri parse2 = Uri.parse(str);
                                if (!parse2.getScheme().equals("http")) {
                                    if (!parse2.getScheme().equals("https")) {
                                        str = stringExtra;
                                    }
                                }
                                webView.loadUrl(stringExtra);
                                return false;
                            }
                        } catch (Throwable th) {
                            af.b(f9797a, th.getMessage());
                        }
                    }
                    if (com.mbridge.msdk.click.c.e(this.f9806j, str)) {
                        af.b(f9797a, "openDeepLink");
                        this.f9809m = true;
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            af.b(f9797a, th2.getMessage());
            return false;
        }
    }

    public final void c(WebView webView, final String str) {
        String str2 = f9797a;
        af.b(str2, "onPageFinished1  " + str);
        if (this.f9799c) {
            this.f9811o = 0;
            this.f9799c = false;
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() {
                public final void run() {
                    if (a.this.f9802f != null) {
                        a.this.f9802f.onFinishRedirection(a.this.f9804h, str);
                    }
                    if (a.this.f9805i != null && a.this.f9808l != null) {
                        a.this.f9808l.setSuccess(true);
                        a.this.f9808l.setUrl(str);
                        a.this.f9808l.setType(2);
                        a.this.f9805i.a(a.this.f9808l, a.this.f9804h, 1, true);
                    }
                }
            });
            if (!TextUtils.isEmpty(str)) {
                c();
                Uri parse = Uri.parse(str);
                if ((parse.getScheme().equals("http") || parse.getScheme().equals("https")) && !this.f9809m) {
                    this.f9809m = true;
                    a(this.f9806j, str, this.f9804h);
                }
            }
        }
    }

    public final boolean b(WebView webView, final String str) {
        String str2 = f9797a;
        af.b(str2, "shouldOverrideUrlLoading1  " + str);
        this.f9799c = false;
        if (aj.a.b(str) && aj.a.a(this.f9806j, str, (NativeListener.NativeTrackingListener) null)) {
            this.f9809m = true;
        }
        boolean e5 = e(webView, str);
        if (e5) {
            this.f9811o = 0;
            this.f9799c = false;
            c();
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() {
                public final void run() {
                    if (!(a.this.f9805i == null || a.this.f9808l == null)) {
                        a.this.f9808l.setSuccess(true);
                        a.this.f9808l.setUrl(str);
                        a.this.f9808l.setType(2);
                        a.this.f9805i.a(a.this.f9808l, a.this.f9804h, 1, true);
                    }
                    if (a.this.f9802f != null) {
                        a.this.f9802f.onFinishRedirection(a.this.f9804h, str);
                    }
                }
            });
        }
        return e5;
    }

    public final void a(WebView webView, String str) {
        if (this.f9811o == 0) {
            this.f9811o = System.currentTimeMillis();
            if (!this.f9801e) {
                this.f9801e = true;
                d();
            }
        }
        this.f9800d = str;
        this.f9799c = true;
    }

    public final void a(WebView webView, String str, Bitmap bitmap) {
        if (this.f9811o == 0) {
            this.f9811o = System.currentTimeMillis();
            if (!this.f9801e) {
                this.f9801e = true;
                d();
            }
            this.f9809m = false;
        }
        this.f9800d = str;
        this.f9799c = true;
    }

    private void c() {
        this.f9807k.removeCallbacks(this.f9810n);
    }

    private void d() {
        this.f9807k.postDelayed(this.f9810n, (long) this.f9798b);
    }

    public final void a(WebView webView, int i5, final String str, final String str2) {
        af.d(f9797a, str);
        c();
        com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() {
            public final void run() {
                if (a.this.f9802f != null) {
                    a.this.f9802f.onFinishRedirection(a.this.f9804h, str2);
                }
                if (a.this.f9805i != null && a.this.f9808l != null) {
                    a.this.f9808l.setSuccess(false);
                    a.this.f9808l.setUrl(str2);
                    a.this.f9808l.setType(2);
                    a.this.f9808l.setExceptionMsg(str);
                    a.this.f9805i.a(a.this.f9808l, a.this.f9804h, 1, true);
                }
            }
        });
        if (d(webView, str2) && !this.f9809m) {
            this.f9809m = true;
            a(this.f9806j, str2, this.f9804h);
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str, CampaignEx campaignEx) {
        if (context != null) {
            if (campaignEx != null) {
                campaignEx.getCurrentLocalRid();
            }
            try {
                int i5 = MBCommonActivity.f7863d;
                Intent intent = new Intent(context, MBCommonActivity.class);
                if (!TextUtils.isEmpty(str)) {
                    b.f9820a.put(str, this.f9803g);
                    if (aj.a.a(str)) {
                        str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
                    }
                    intent.putExtra("url", str);
                    af.c("url", "webview url = " + str);
                    intent.setFlags(805306368);
                    intent.putExtra("mvcommon", campaignEx);
                    context.startActivity(intent);
                }
            } catch (Exception unused) {
                aj.a(context, str, this.f9802f, campaignEx, (List<String>) new ArrayList());
            }
        }
    }
}
