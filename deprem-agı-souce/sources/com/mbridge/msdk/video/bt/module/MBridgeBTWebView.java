package com.mbridge.msdk.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.mbridge.msdk.click.i;
import com.mbridge.msdk.e.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.mbsignalcommon.b.a;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.d;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.videocommon.d.c;
import java.util.List;
import org.json.JSONObject;

public class MBridgeBTWebView extends MBridgeBTWebViewDiff {
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public String f11997p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public String f11998q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public String f11999r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f12000s = false;

    /* renamed from: t  reason: collision with root package name */
    private ImageView f12001t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f12002u = false;

    /* renamed from: v  reason: collision with root package name */
    private c f12003v;

    /* renamed from: w  reason: collision with root package name */
    private List<CampaignEx> f12004w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public WebView f12005x;

    public MBridgeBTWebView(Context context) {
        super(context);
    }

    public void broadcast(String str, JSONObject jSONObject) {
        if (this.webView != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", BTBaseView.f11817n);
                jSONObject2.put("id", this.f11822d);
                jSONObject2.put("eventName", str);
                jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject);
                g.a().a((WebView) this.webView, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception unused) {
                d.c().a((WebView) this.webView, "broadcast", this.f11822d);
            }
        }
    }

    public void close() {
        WebView webView = this.f12005x;
        if (webView != null) {
            BTBaseView.a(webView, "onPlayerCloseBtnClicked", this.f11822d);
        }
    }

    public void expand(String str, boolean z4) {
    }

    public List<CampaignEx> getCampaigns() {
        return this.f12004w;
    }

    public String getFilePath() {
        return this.f11998q;
    }

    public String getFileURL() {
        return this.f11997p;
    }

    public String getHtml() {
        return this.f11999r;
    }

    public CampaignEx getMraidCampaign() {
        return this.f11820b;
    }

    public c getRewardUnitSetting() {
        return this.f12003v;
    }

    public WindVaneWebView getWebView() {
        return this.webView;
    }

    public void init(Context context) {
        int i5;
        WindVaneWebView windVaneWebView = new WindVaneWebView(context);
        this.webView = windVaneWebView;
        windVaneWebView.setBackgroundColor(0);
        this.webView.setVisibility(0);
        k kVar = new k((Activity) null, this.f11820b, this.f12004w);
        this.jsCommon = kVar;
        kVar.a(this.f11821c);
        if (b.a()) {
            setChinaAlertInstallState(this.jsCommon);
        }
        this.webView.setObject(this.jsCommon);
        this.webView.setMraidObject(this);
        this.webView.setWebViewListener(new a() {
            public final void a(Object obj) {
                super.a(obj);
                try {
                    k kVar = MBridgeBTWebView.this.jsCommon;
                    String str = "";
                    String c5 = kVar != null ? kVar.c() : str;
                    if (!TextUtils.isEmpty(c5)) {
                        str = Base64.encodeToString(c5.getBytes(), 2);
                        af.a("RVWindVaneWebView", "getEndScreenInfo success");
                    } else {
                        af.a("RVWindVaneWebView", "getEndScreenInfo failed");
                    }
                    g.a().a(obj, str);
                } catch (Throwable th) {
                    af.a("RVWindVaneWebView", th.getMessage());
                }
            }

            public final void a(WebView webView, String str) {
                super.a(webView, str);
                if (MBridgeBTWebView.this.f12005x != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", MBridgeBTWebView.this.f11822d);
                        jSONObject.put("code", BTBaseView.f11817n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", MBridgeBTWebView.this.f11822d);
                        jSONObject2.put("result", 1);
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                        g.a().a(MBridgeBTWebView.this.f12005x, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e5) {
                        d.c().a(MBridgeBTWebView.this.f12005x, e5.getMessage());
                        af.a("RVWindVaneWebView", e5.getMessage());
                    }
                }
                g.a().a(MBridgeBTWebView.this.webView);
            }

            public final void a(WebView webView, int i5, String str, String str2) {
                super.a(webView, i5, str, str2);
                if (MBridgeBTWebView.this.f12005x != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", MBridgeBTWebView.this.f11822d);
                        jSONObject.put("code", BTBaseView.f11817n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", MBridgeBTWebView.this.f11822d);
                        jSONObject2.put("result", 2);
                        jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                        g.a().a(MBridgeBTWebView.this.f12005x, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e5) {
                        d.c().a(MBridgeBTWebView.this.f12005x, e5.getMessage());
                        af.a("RVWindVaneWebView", e5.getMessage());
                    }
                }
            }

            public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.a(webView, sslErrorHandler, sslError);
                if (MBridgeBTWebView.this.f12005x != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", MBridgeBTWebView.this.f11822d);
                        jSONObject.put("code", BTBaseView.f11817n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", MBridgeBTWebView.this.f11822d);
                        jSONObject2.put("result", 2);
                        jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, sslError.toString());
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                        g.a().a(MBridgeBTWebView.this.f12005x, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e5) {
                        d.c().a(MBridgeBTWebView.this.f12005x, e5.getMessage());
                        af.a("RVWindVaneWebView", e5.getMessage());
                    }
                }
            }

            public final void a(WebView webView, int i5) {
                super.a(webView, i5);
            }
        });
        addView(this.webView, new FrameLayout.LayoutParams(-1, -1));
        setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (MBridgeBTWebView.this.f12005x != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", BTBaseView.f11817n);
                        jSONObject.put("id", MBridgeBTWebView.this.f11822d);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("x", String.valueOf(view.getX()));
                        jSONObject2.put("y", String.valueOf(view.getY()));
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                        g.a().a(MBridgeBTWebView.this.f12005x, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception unused) {
                        d.c().a(MBridgeBTWebView.this.f12005x, "onClicked", MBridgeBTWebView.this.f11822d);
                    }
                }
            }
        });
        try {
            ImageView imageView = new ImageView(getContext());
            this.f12001t = imageView;
            imageView.setImageResource(findDrawable("mbridge_reward_close"));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
            layoutParams.gravity = 8388661;
            layoutParams.setMargins(30, 30, 30, 30);
            this.f12001t.setLayoutParams(layoutParams);
            ImageView imageView2 = this.f12001t;
            if (this.f12000s) {
                i5 = 4;
            } else {
                i5 = 8;
            }
            imageView2.setVisibility(i5);
            CampaignEx campaignEx = this.f11820b;
            if (campaignEx != null && campaignEx.isMraid()) {
                this.f12001t.setVisibility(4);
            }
            this.f12001t.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MBridgeBTWebView.this.close();
                }
            });
            addView(this.f12001t);
        } catch (Throwable th) {
            af.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void onBackPressed() {
        if (this.webView != null) {
            d.c().a((WebView) this.webView, "onSystemBackPressed", this.f11822d);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.webView != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (configuration.orientation == 2) {
                    jSONObject.put("orientation", "landscape");
                } else {
                    jSONObject.put("orientation", "portrait");
                }
                jSONObject.put("instanceId", this.f11822d);
                g.a().a((WebView) this.webView, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public void onDestory() {
        if (!this.f12002u) {
            this.f12002u = true;
            try {
                if (this.webView != null) {
                    d.c().a((WebView) this.webView, "onSystemDestory", this.f11822d);
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        try {
                            WindVaneWebView windVaneWebView = MBridgeBTWebView.this.webView;
                            if (windVaneWebView != null) {
                                windVaneWebView.clearWebView();
                                MBridgeBTWebView.this.webView.release();
                            }
                            String unused = MBridgeBTWebView.this.f11997p = null;
                            String unused2 = MBridgeBTWebView.this.f11998q = null;
                            String unused3 = MBridgeBTWebView.this.f11999r = null;
                            if (MBridgeBTWebView.this.f12005x != null) {
                                WebView unused4 = MBridgeBTWebView.this.f12005x = null;
                            }
                        } catch (Throwable th) {
                            af.a(BTBaseView.TAG, th.getMessage());
                        }
                    }
                }, 500);
                setOnClickListener((View.OnClickListener) null);
                removeAllViews();
            } catch (Throwable th) {
                af.a(BTBaseView.TAG, th.getMessage());
            }
        }
    }

    public void onFinishRedirection(Campaign campaign, String str) {
        aj.a(campaign, this);
    }

    public void onRedirectionFailed(Campaign campaign, String str) {
        aj.a(campaign, this);
    }

    public void onStartRedirection(Campaign campaign, String str) {
        aj.b(campaign, this);
    }

    public void open(String str) {
        try {
            String clickURL = this.f11820b.getClickURL();
            if (!TextUtils.isEmpty(str)) {
                this.f11820b.setClickURL(str);
                reportOpen(str);
            }
            com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(getContext(), this.f11821c);
            aVar.a((i) this);
            aVar.a(this.f11820b);
            this.f11820b.setClickURL(clickURL);
        } catch (Throwable th) {
            af.b(BTBaseView.TAG, th.getMessage());
        }
    }

    public void preload() {
        if (!TextUtils.isEmpty(this.f11997p)) {
            this.webView.loadUrl(this.f11997p);
        } else if (!TextUtils.isEmpty(this.f11998q)) {
            this.webView.loadUrl(this.f11998q);
        } else if (!TextUtils.isEmpty(this.f11999r)) {
            this.webView.loadDataWithBaseURL("", this.f11999r, "text/html", C.UTF8_NAME, (String) null);
        }
    }

    public void reportOpen(String str) {
        try {
            CampaignEx mraidCampaign = getMraidCampaign();
            if (mraidCampaign != null) {
                new h(getContext()).a(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.f11821c, str, this.f11820b.isBidCampaign());
            }
        } catch (Throwable th) {
            af.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void setCampaigns(List<CampaignEx> list) {
        this.f12004w = list;
    }

    public void setCreateWebView(WebView webView) {
        this.f12005x = webView;
    }

    public void setFilePath(String str) {
        this.f11998q = str;
    }

    public void setFileURL(String str) {
        this.f11997p = str;
        if (!TextUtils.isEmpty(str)) {
            boolean contains = str.contains("play.google.com");
            setWebviewClickable(!contains);
            if (contains) {
                com.mbridge.msdk.mbsignalcommon.base.c cVar = new com.mbridge.msdk.mbsignalcommon.base.c();
                WindVaneWebView windVaneWebView = this.webView;
                if (windVaneWebView != null) {
                    windVaneWebView.setFilter(cVar);
                }
            }
        }
    }

    public void setHtml(String str) {
        this.f11999r = str;
    }

    public void setRewardUnitSetting(c cVar) {
        this.f12003v = cVar;
    }

    public void setTempTypeForMetrics(int i5) {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView != null) {
            windVaneWebView.setTempTypeForMetrics(i5);
        }
    }

    public void setWebViewLocalRequestId(String str) {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView != null) {
            windVaneWebView.setLocalRequestId(str);
        }
    }

    public void setWebViewRid(String str) {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView != null) {
            windVaneWebView.setRid(str);
        }
    }

    public void setWebviewClickable(boolean z4) {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView != null) {
            windVaneWebView.setClickable(z4);
        }
    }

    public void unload() {
        close();
    }

    public void useCustomClose(boolean z4) {
        int i5;
        try {
            ImageView imageView = this.f12001t;
            if (z4) {
                i5 = 4;
            } else {
                i5 = 0;
            }
            imageView.setVisibility(i5);
        } catch (Throwable th) {
            af.b(BTBaseView.TAG, th.getMessage());
        }
    }

    public boolean webviewGoBack() {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView == null || !windVaneWebView.canGoBack()) {
            return false;
        }
        this.webView.goBack();
        return true;
    }

    public boolean webviewGoForward() {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView == null || !windVaneWebView.canGoForward()) {
            return false;
        }
        this.webView.goForward();
        return true;
    }

    public void webviewLoad(int i5) {
        if (this.jsCommon == null) {
            this.jsCommon = new k((Activity) null, this.f11820b, this.f12004w);
        }
        CampaignEx campaignEx = this.f11820b;
        if (campaignEx != null) {
            this.jsCommon.a(campaignEx);
        } else {
            List<CampaignEx> list = this.f12004w;
            if (list != null && list.size() > 0) {
                this.jsCommon.a(this.f12004w);
                if (this.f12004w.size() == 1) {
                    this.jsCommon.a(this.f12004w.get(0));
                }
            }
        }
        c cVar = this.f12003v;
        if (cVar != null) {
            this.jsCommon.a(cVar);
        }
        this.jsCommon.a(this.f11821c);
        this.jsCommon.c(this.f11822d);
        if (b.a()) {
            setChinaAlertInstallState(this.jsCommon);
        }
        if (i5 == 1) {
            this.jsCommon.q();
        }
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView != null) {
            windVaneWebView.setObject(this.jsCommon);
        }
        CampaignEx campaignEx2 = this.f11820b;
        if (campaignEx2 != null && campaignEx2.isMraid()) {
            this.f12001t.setVisibility(4);
        }
        preload();
    }

    public boolean webviewReload() {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView == null) {
            return false;
        }
        windVaneWebView.reload();
        return true;
    }

    public MBridgeBTWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
