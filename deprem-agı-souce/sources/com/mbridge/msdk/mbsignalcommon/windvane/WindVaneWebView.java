package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;
import com.mbridge.msdk.mbsignalcommon.base.b;

public class WindVaneWebView extends BaseWebView {

    /* renamed from: b  reason: collision with root package name */
    protected k f10189b;

    /* renamed from: c  reason: collision with root package name */
    protected c f10190c;

    /* renamed from: d  reason: collision with root package name */
    protected f f10191d;

    /* renamed from: e  reason: collision with root package name */
    private Object f10192e;

    /* renamed from: f  reason: collision with root package name */
    private Object f10193f;

    /* renamed from: g  reason: collision with root package name */
    private String f10194g;

    /* renamed from: h  reason: collision with root package name */
    private d f10195h;

    /* renamed from: i  reason: collision with root package name */
    private String f10196i;

    /* renamed from: j  reason: collision with root package name */
    private String f10197j;

    /* renamed from: k  reason: collision with root package name */
    private CampaignEx f10198k;

    /* renamed from: l  reason: collision with root package name */
    private int f10199l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f10200m = false;

    /* renamed from: n  reason: collision with root package name */
    private float f10201n = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    private float f10202o = 0.0f;

    public WindVaneWebView(Context context) {
        super(context);
    }

    public void clearWebView() {
        if (!this.f10200m) {
            loadUrl("about:blank");
        }
    }

    public CampaignEx getCampaignEx() {
        return this.f10198k;
    }

    public String getCampaignId() {
        return this.f10194g;
    }

    public Object getJsObject(String str) {
        f fVar = this.f10191d;
        if (fVar == null) {
            return null;
        }
        return fVar.a(str);
    }

    public String getLocalRequestId() {
        return this.f10197j;
    }

    public Object getMraidObject() {
        return this.f10193f;
    }

    public Object getObject() {
        return this.f10192e;
    }

    public String getRid() {
        return this.f10196i;
    }

    public c getSignalCommunication() {
        return this.f10190c;
    }

    public d getWebViewListener() {
        return this.f10195h;
    }

    public boolean isDestoryed() {
        return this.f10200m;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar = this.mWebViewClient;
        if (bVar != null && (bVar.b() instanceof IntentFilter)) {
            String url = getUrl();
            if (!TextUtils.isEmpty(url) && url.contains("https://play.google.com")) {
                if (motionEvent.getAction() == 0) {
                    this.f10201n = motionEvent.getRawX();
                    this.f10202o = motionEvent.getRawY();
                } else {
                    float rawX = motionEvent.getRawX() - this.f10201n;
                    float y4 = motionEvent.getY() - this.f10202o;
                    if ((rawX >= 0.0f || rawX * -1.0f <= ((float) 48)) && ((rawX <= 0.0f || rawX <= ((float) 48)) && ((y4 >= 0.0f || -1.0f * y4 <= ((float) 48)) && (y4 <= 0.0f || y4 <= ((float) 48))))) {
                        setClickable(false);
                        return true;
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void registerWindVanePlugin(Class cls) {
        f fVar = this.f10191d;
        if (fVar != null) {
            fVar.a(cls.getSimpleName(), cls);
        }
    }

    public void release() {
        try {
            if (!this.f10200m) {
                e eVar = new e();
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(this.f10199l));
                d.a().a("2000135", this.f10198k, eVar);
            }
        } catch (Exception unused) {
        }
        try {
            setVisibility(8);
            removeAllViews();
            setDownloadListener((DownloadListener) null);
            this.f10192e = null;
            int b5 = ak.b(getContext());
            if (b5 == 0) {
                this.f10200m = true;
                destroy();
                return;
            }
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    boolean unused = WindVaneWebView.this.f10200m = true;
                    WindVaneWebView.this.destroy();
                }
            }, (long) (b5 * 1000));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setApiManagerContext(Context context) {
        f fVar = this.f10191d;
        if (fVar != null) {
            fVar.a(context);
        }
    }

    public void setApiManagerJSFactory(Object obj) {
        f fVar = this.f10191d;
        if (fVar != null) {
            fVar.a(obj);
        }
    }

    public void setCampaignEx(CampaignEx campaignEx) {
        this.f10198k = campaignEx;
    }

    public void setCampaignId(String str) {
        this.f10194g = str;
    }

    public void setLocalRequestId(String str) {
        this.f10197j = str;
    }

    public void setMraidObject(Object obj) {
        this.f10193f = obj;
    }

    public void setObject(Object obj) {
        this.f10192e = obj;
    }

    public void setRid(String str) {
        this.f10196i = str;
    }

    public void setSignalCommunication(c cVar) {
        this.f10190c = cVar;
        cVar.a(this);
    }

    public void setTempTypeForMetrics(int i5) {
        this.f10199l = i5;
    }

    public void setWebViewChromeClient(k kVar) {
        this.f10189b = kVar;
        setWebChromeClient(kVar);
    }

    public void setWebViewListener(d dVar) {
        this.f10195h = dVar;
        k kVar = this.f10189b;
        if (kVar != null) {
            kVar.a(dVar);
        }
        b bVar = this.mWebViewClient;
        if (bVar != null) {
            bVar.a(dVar);
        }
    }

    public void setWebViewTransparent() {
        super.setTransparent();
    }

    /* access modifiers changed from: protected */
    public final void a() {
        super.a();
        getSettings().setSavePassword(false);
        WebSettings settings = getSettings();
        settings.setUserAgentString(getSettings().getUserAgentString() + " WindVane/3.0.2");
        if (this.f10189b == null) {
            this.f10189b = new k(this);
        }
        setWebViewChromeClient(this.f10189b);
        l lVar = new l();
        this.mWebViewClient = lVar;
        setWebViewClient(lVar);
        if (this.f10190c == null) {
            i iVar = new i(this.f10087a);
            this.f10190c = iVar;
            setSignalCommunication(iVar);
        }
        this.f10191d = new f(this.f10087a, this);
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
