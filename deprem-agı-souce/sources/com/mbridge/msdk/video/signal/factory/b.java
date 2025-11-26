package com.mbridge.msdk.video.signal.factory;

import android.app.Activity;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.a;
import com.mbridge.msdk.video.signal.a.i;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.a.m;
import com.mbridge.msdk.video.signal.a.n;
import com.mbridge.msdk.video.signal.a.o;
import com.mbridge.msdk.video.signal.a.q;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.g;
import java.util.List;

public final class b extends a {

    /* renamed from: h  reason: collision with root package name */
    private Activity f12983h;

    /* renamed from: i  reason: collision with root package name */
    private WebView f12984i;

    /* renamed from: j  reason: collision with root package name */
    private MBridgeVideoView f12985j;

    /* renamed from: k  reason: collision with root package name */
    private MBridgeContainerView f12986k;

    /* renamed from: l  reason: collision with root package name */
    private CampaignEx f12987l;

    /* renamed from: m  reason: collision with root package name */
    private MBridgeBTContainer f12988m;

    /* renamed from: n  reason: collision with root package name */
    private a.C0112a f12989n;

    /* renamed from: o  reason: collision with root package name */
    private String f12990o;

    /* renamed from: p  reason: collision with root package name */
    private List<CampaignEx> f12991p;

    public b(Activity activity) {
        this.f12983h = activity;
    }

    public final void a(k kVar) {
        this.f12977b = kVar;
    }

    public final com.mbridge.msdk.video.signal.b getActivityProxy() {
        WebView webView = this.f12984i;
        if (webView == null) {
            return super.getActivityProxy();
        }
        if (this.f12976a == null) {
            this.f12976a = new i(webView);
        }
        return this.f12976a;
    }

    public final com.mbridge.msdk.video.signal.i getIJSRewardVideoV1() {
        Activity activity;
        MBridgeContainerView mBridgeContainerView = this.f12986k;
        if (mBridgeContainerView == null || (activity = this.f12983h) == null) {
            return super.getIJSRewardVideoV1();
        }
        if (this.f12981f == null) {
            this.f12981f = new o(activity, mBridgeContainerView);
        }
        return this.f12981f;
    }

    public final c getJSBTModule() {
        if (this.f12983h == null || this.f12988m == null) {
            return super.getJSBTModule();
        }
        if (this.f12982g == null) {
            this.f12982g = new j(this.f12983h, this.f12988m);
        }
        return this.f12982g;
    }

    public final d getJSCommon() {
        CampaignEx campaignEx;
        List<CampaignEx> list;
        Activity activity = this.f12983h;
        if (activity == null || (campaignEx = this.f12987l) == null) {
            return super.getJSCommon();
        }
        if (this.f12977b == null) {
            this.f12977b = new k(activity, campaignEx);
        }
        if (this.f12987l.getDynamicTempCode() == 5 && (list = this.f12991p) != null) {
            d dVar = this.f12977b;
            if (dVar instanceof k) {
                ((k) dVar).a(list);
            }
        }
        this.f12977b.a(this.f12983h);
        this.f12977b.a(this.f12990o);
        this.f12977b.a(this.f12989n);
        return this.f12977b;
    }

    public final f getJSContainerModule() {
        MBridgeContainerView mBridgeContainerView = this.f12986k;
        if (mBridgeContainerView == null) {
            return super.getJSContainerModule();
        }
        if (this.f12980e == null) {
            this.f12980e = new m(mBridgeContainerView);
        }
        return this.f12980e;
    }

    public final g getJSNotifyProxy() {
        WebView webView = this.f12984i;
        if (webView == null) {
            return super.getJSNotifyProxy();
        }
        if (this.f12979d == null) {
            this.f12979d = new n(webView);
        }
        return this.f12979d;
    }

    public final com.mbridge.msdk.video.signal.j getJSVideoModule() {
        MBridgeVideoView mBridgeVideoView = this.f12985j;
        if (mBridgeVideoView == null) {
            return super.getJSVideoModule();
        }
        if (this.f12978c == null) {
            this.f12978c = new q(mBridgeVideoView);
        }
        return this.f12978c;
    }

    public final void a(List<CampaignEx> list) {
        this.f12991p = list;
    }

    public b(Activity activity, MBridgeBTContainer mBridgeBTContainer, WebView webView) {
        this.f12983h = activity;
        this.f12988m = mBridgeBTContainer;
        this.f12984i = webView;
    }

    public b(Activity activity, WebView webView, MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, a.C0112a aVar) {
        this.f12983h = activity;
        this.f12984i = webView;
        this.f12985j = mBridgeVideoView;
        this.f12986k = mBridgeContainerView;
        this.f12987l = campaignEx;
        this.f12989n = aVar;
        this.f12990o = mBridgeVideoView.getUnitId();
    }
}
