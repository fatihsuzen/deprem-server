package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.same.report.g;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView;
import com.mbridge.msdk.video.module.a.a;
import com.mbridge.msdk.video.module.a.a.i;
import com.mbridge.msdk.video.module.a.a.k;
import com.mbridge.msdk.video.module.a.a.l;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.video.signal.h;
import java.util.ArrayList;
import java.util.List;

public class MBridgeContainerView extends MBridgeBaseView implements f, h {

    /* renamed from: A  reason: collision with root package name */
    private int f12322A = 1;

    /* renamed from: B  reason: collision with root package name */
    private boolean f12323B = false;

    /* renamed from: C  reason: collision with root package name */
    private boolean f12324C = false;

    /* renamed from: D  reason: collision with root package name */
    private boolean f12325D = false;

    /* renamed from: E  reason: collision with root package name */
    private boolean f12326E = true;

    /* renamed from: F  reason: collision with root package name */
    private boolean f12327F = false;

    /* renamed from: G  reason: collision with root package name */
    private boolean f12328G = false;

    /* renamed from: H  reason: collision with root package name */
    private int f12329H;

    /* renamed from: I  reason: collision with root package name */
    private boolean f12330I = false;

    /* renamed from: J  reason: collision with root package name */
    private boolean f12331J = false;

    /* renamed from: K  reason: collision with root package name */
    private int f12332K;

    /* renamed from: L  reason: collision with root package name */
    private int f12333L;

    /* renamed from: M  reason: collision with root package name */
    private int f12334M;

    /* renamed from: N  reason: collision with root package name */
    private int f12335N;

    /* renamed from: O  reason: collision with root package name */
    private int f12336O;

    /* renamed from: P  reason: collision with root package name */
    private String f12337P;

    /* renamed from: Q  reason: collision with root package name */
    private b f12338Q;

    /* renamed from: R  reason: collision with root package name */
    private boolean f12339R = false;

    /* renamed from: S  reason: collision with root package name */
    private boolean f12340S = false;

    /* renamed from: T  reason: collision with root package name */
    private List<CampaignEx> f12341T = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private MBridgePlayableView f12342m;

    /* renamed from: n  reason: collision with root package name */
    private MBridgeClickCTAView f12343n;

    /* renamed from: o  reason: collision with root package name */
    private MBridgeClickMiniCardView f12344o;

    /* renamed from: p  reason: collision with root package name */
    private MBridgeNativeEndCardView f12345p;

    /* renamed from: q  reason: collision with root package name */
    private MBridgeH5EndCardView f12346q;

    /* renamed from: r  reason: collision with root package name */
    private MBridgeVastEndCardView f12347r;

    /* renamed from: s  reason: collision with root package name */
    private MBridgeLandingPageView f12348s;

    /* renamed from: t  reason: collision with root package name */
    private MBridgeVideoEndCoverView f12349t;

    /* renamed from: u  reason: collision with root package name */
    private MBridgeAlertWebview f12350u;

    /* renamed from: v  reason: collision with root package name */
    private MBridgeOrderCampView f12351v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public String f12352w;

    /* renamed from: x  reason: collision with root package name */
    private int f12353x;

    /* renamed from: y  reason: collision with root package name */
    private int f12354y = 1;

    /* renamed from: z  reason: collision with root package name */
    private int f12355z = 1;

    public MBridgeContainerView(Context context) {
        super(context);
    }

    private void b() {
        if (this.f12346q == null) {
            a(this.f12338Q, 2);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f12346q;
        if (mBridgeH5EndCardView == null || !mBridgeH5EndCardView.isLoadSuccess()) {
            e();
            MBridgeH5EndCardView mBridgeH5EndCardView2 = this.f12346q;
            if (mBridgeH5EndCardView2 != null) {
                mBridgeH5EndCardView2.reportRenderResult("timeout", 3);
                this.f12346q.setError(true);
            }
        } else {
            this.f12330I = true;
            addView(this.f12346q);
            webviewshow();
            onConfigurationChanged(getResources().getConfiguration());
            this.f12346q.excuteTask();
            this.f12346q.setNotchValue(this.f12337P, this.f12332K, this.f12333L, this.f12334M, this.f12335N);
            n nVar = new n();
            nVar.f(this.f12294b.getRequestId());
            nVar.g(this.f12294b.getRequestIdNotice());
            nVar.e(this.f12294b.getId());
            nVar.d(this.f12294b.isMraid() ? n.f9116a : n.f9117b);
            g.d(nVar, this.f12293a, this.f12352w);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView3 = this.f12346q;
        if (mBridgeH5EndCardView3 != null) {
            mBridgeH5EndCardView3.setUnitId(this.f12352w);
        }
    }

    private void e() {
        this.f12354y = 1;
        if (this.f12345p == null) {
            a(this.f12338Q, 2);
        }
        addView(this.f12345p);
        onConfigurationChanged(getResources().getConfiguration());
        this.f12345p.notifyShowListener();
        this.f12340S = true;
        bringToFront();
    }

    private void f() {
        if (this.f12344o == null) {
            b(-2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        if (this.f12325D && this.f12326E) {
            this.f12326E = false;
            layoutParams.width = 1;
            layoutParams.height = 1;
        }
        addView(this.f12344o, layoutParams);
    }

    private void g() {
        if (this.f12350u == null) {
            MBridgeAlertWebview mBridgeAlertWebview = new MBridgeAlertWebview(this.f12293a);
            this.f12350u = mBridgeAlertWebview;
            mBridgeAlertWebview.setUnitId(this.f12352w);
            this.f12350u.setCampaign(this.f12294b);
        }
        this.f12350u.preLoadData(this.f12338Q);
    }

    private void h() {
        this.f12324C = false;
        this.f12340S = false;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            int i5 = 0;
            for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                View childAt = viewGroup.getChildAt(i5);
                if (!(childAt instanceof MBridgeContainerView)) {
                    viewGroup.bringChildToFront(childAt);
                } else {
                    i5++;
                }
            }
        }
    }

    private void i() {
        boolean z4;
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null) {
            String str = campaignEx.getendcard_url();
            boolean isEmpty = TextUtils.isEmpty(str);
            int i5 = MBridgeCommon.CampaignState.STATE_LOAD_FAILED_RESOURCE_DOWNLOAD_ERROR;
            if (!isEmpty) {
                try {
                    i5 = Integer.parseInt(aq.a(str, "ecid"));
                } catch (Throwable th) {
                    af.b(MBridgeBaseView.TAG, th.getMessage());
                }
            }
            int i6 = i5;
            Context context = this.f12293a;
            if (this.f12294b.getAdSpaceT() == 2) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f12345p = new MBridgeNativeEndCardView(context, (AttributeSet) null, true, i6, z4, this.f12303k, this.f12294b.getMof_tplid());
            if (this.f12294b.getDynamicTempCode() == 5) {
                a aVar = this.notifyListener;
                if (aVar != null && (aVar instanceof k)) {
                    ((k) aVar).a(this.f12294b);
                }
                this.f12345p.setCampaign(this.f12294b);
                return;
            }
            this.f12345p.setCampaign(this.f12294b);
        }
    }

    public void addOrderViewData(List<CampaignEx> list) {
        if (list != null) {
            this.f12341T = list;
        }
    }

    public void addView(View view) {
        if (view != null) {
            a(view);
            super.addView(view);
            return;
        }
        af.b(MBridgeBaseView.TAG, "view is null");
    }

    public boolean canBackPress() {
        if (this.f12345p != null) {
            return false;
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f12346q;
        if (mBridgeH5EndCardView != null) {
            return mBridgeH5EndCardView.canBackPress();
        }
        MBridgeLandingPageView mBridgeLandingPageView = this.f12348s;
        if (mBridgeLandingPageView != null) {
            return mBridgeLandingPageView.canBackPress();
        }
        MBridgePlayableView mBridgePlayableView = this.f12342m;
        if (mBridgePlayableView != null) {
            return mBridgePlayableView.canBackPress();
        }
        return false;
    }

    public void configurationChanged(int i5, int i6, int i7) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f12344o;
        if (mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.getVisibility() == 0) {
            this.f12344o.resizeMiniCard(i5, i6);
        }
    }

    public void defaultShow() {
        super.defaultShow();
    }

    public boolean endCardShowing() {
        return this.f12323B;
    }

    public boolean endcardIsPlayable() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f12346q;
        if (mBridgeH5EndCardView == null || !mBridgeH5EndCardView.isPlayable()) {
            return false;
        }
        return true;
    }

    public MBridgeH5EndCardView getH5EndCardView() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f12346q;
        if (mBridgeH5EndCardView == null) {
            return this.f12342m;
        }
        return mBridgeH5EndCardView;
    }

    public CampaignEx getReSetCampaign() {
        if (!this.f12294b.isDynamicView() || !TextUtils.isEmpty(this.f12294b.getendcard_url())) {
            return null;
        }
        int size = this.f12341T.size();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i6 < size) {
                if (this.f12341T.get(i6) != null && this.f12341T.get(i6).getId() == this.f12294b.getId()) {
                    i5 = i6 - 1;
                    break;
                }
                i6++;
            } else {
                break;
            }
        }
        if (i5 < 0 || i5 >= size || this.f12341T.get(i5) == null) {
            return null;
        }
        return this.f12341T.get(i5);
    }

    public boolean getShowingTransparent() {
        return this.f12325D;
    }

    public String getUnitID() {
        return this.f12352w;
    }

    public int getVideoInteractiveType() {
        return this.f12353x;
    }

    public int getVideoSkipTime() {
        return this.f12329H;
    }

    public void handlerPlayableException(String str) {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f12346q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.handlerPlayableException(str);
            if (!this.f12330I) {
                return;
            }
        }
        a();
    }

    public void hideAlertWebview() {
        if (!isLast()) {
            if (this.f12339R && !this.f12340S) {
                h();
                this.f12339R = false;
            }
            MBridgeAlertWebview mBridgeAlertWebview = this.f12350u;
            if (mBridgeAlertWebview != null && mBridgeAlertWebview.getParent() != null) {
                removeView(this.f12350u);
                MBridgeClickCTAView mBridgeClickCTAView = this.f12343n;
                if (mBridgeClickCTAView != null && mBridgeClickCTAView.getParent() != null) {
                    setWrapContent();
                    ViewGroup.LayoutParams layoutParams = getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) layoutParams).addRule(12, -1);
                    }
                }
            }
        }
    }

    public void init(Context context) {
        setVisibility(0);
    }

    public void install(CampaignEx campaignEx) {
        this.notifyListener.a(105, campaignEx);
    }

    public boolean isLast() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null || viewGroup.indexOfChild(this) != 0) {
            return false;
        }
        return true;
    }

    public void ivRewardAdsWithoutVideo(String str) {
        this.notifyListener.a(103, str);
    }

    public boolean miniCardLoaded() {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f12344o;
        if (mBridgeClickMiniCardView == null || !mBridgeClickMiniCardView.isLoadSuccess()) {
            return false;
        }
        return true;
    }

    public boolean miniCardShowing() {
        return this.f12324C;
    }

    public void notifyCloseBtn(int i5) {
        MBridgePlayableView mBridgePlayableView = this.f12342m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.notifyCloseBtn(i5);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f12346q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.notifyCloseBtn(i5);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MBridgeBaseView[] mBridgeBaseViewArr = {this.f12342m, this.f12343n, this.f12344o, this.f12345p, this.f12346q, this.f12347r, this.f12348s, this.f12349t};
        for (int i5 = 0; i5 < 8; i5++) {
            MBridgeBaseView mBridgeBaseView = mBridgeBaseViewArr[i5];
            if (mBridgeBaseView != null && (mBridgeBaseView instanceof MBridgeClickMiniCardView)) {
                mBridgeBaseView.onSelfConfigurationChanged(configuration);
            } else if (mBridgeBaseView != null && mBridgeBaseView.getVisibility() == 0 && mBridgeBaseView.getParent() != null && !isLast()) {
                mBridgeBaseView.onSelfConfigurationChanged(configuration);
            }
        }
    }

    public void onEndcardBackPress() {
        if (this.f12345p != null || this.f12347r != null) {
            this.notifyListener.a(104, "");
            try {
                com.mbridge.msdk.video.dynview.moffer.a.a().b();
            } catch (Exception e5) {
                af.b(MBridgeBaseView.TAG, e5.getMessage());
            }
        } else if (this.f12348s != null) {
            this.notifyListener.a(103, "");
        } else {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f12346q;
            if (mBridgeH5EndCardView != null) {
                mBridgeH5EndCardView.onBackPress();
            }
        }
    }

    public void onMiniEndcardBackPress() {
        if (this.f12324C) {
            this.notifyListener.a(107, "");
        }
    }

    public void onPlayableBackPress() {
        MBridgePlayableView mBridgePlayableView = this.f12342m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.onBackPress();
        }
    }

    public void orientation(Configuration configuration) {
        MBridgeH5EndCardView[] mBridgeH5EndCardViewArr = {this.f12342m, this.f12344o, this.f12346q, this.f12350u};
        for (int i5 = 0; i5 < 4; i5++) {
            MBridgeH5EndCardView mBridgeH5EndCardView = mBridgeH5EndCardViewArr[i5];
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getVisibility() == 0) {
                mBridgeH5EndCardView.orientation(getResources().getConfiguration());
            }
        }
    }

    public void preLoadData(final b bVar) {
        this.f12338Q = bVar;
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null) {
            if (campaignEx.getPlayable_ads_without_video() == 2) {
                if (this.f12342m == null) {
                    this.f12342m = new MBridgePlayableView(this.f12293a);
                }
                this.f12342m.setCloseDelayShowTime(this.f12355z);
                this.f12342m.setPlayCloseBtnTm(this.f12322A);
                this.f12342m.setCampaign(this.f12294b);
                this.f12342m.setNotifyListener(new i(this.notifyListener) {
                    public final void a(int i5, Object obj) {
                        int i6;
                        super.a(i5, obj);
                        if (i5 == 100) {
                            MBridgeContainerView.this.webviewshow();
                            MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                            mBridgeContainerView.onConfigurationChanged(mBridgeContainerView.getResources().getConfiguration());
                            n nVar = new n();
                            nVar.f(MBridgeContainerView.this.f12294b.getRequestId());
                            nVar.g(MBridgeContainerView.this.f12294b.getRequestIdNotice());
                            nVar.e(MBridgeContainerView.this.f12294b.getId());
                            if (MBridgeContainerView.this.f12294b.isMraid()) {
                                i6 = n.f9116a;
                            } else {
                                i6 = n.f9117b;
                            }
                            nVar.d(i6);
                            MBridgeContainerView mBridgeContainerView2 = MBridgeContainerView.this;
                            g.d(nVar, mBridgeContainerView2.f12293a, mBridgeContainerView2.f12352w);
                        }
                    }
                });
                this.f12342m.preLoadData(bVar);
            } else {
                b(this.f12353x);
                if (this.f12294b.isDynamicView()) {
                    try {
                        a(bVar, Integer.valueOf(this.f12294b.getVideo_end_type()));
                    } catch (Throwable th) {
                        af.b(MBridgeBaseView.TAG, th.getMessage());
                        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                            public final void run() {
                                MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                                mBridgeContainerView.a(bVar, Integer.valueOf(mBridgeContainerView.f12294b.getVideo_end_type()));
                            }
                        });
                    }
                    if (!ak.l(this.f12294b.getendcard_url())) {
                        try {
                            String a5 = aq.a(this.f12294b.getendcard_url(), "mof");
                            if (!TextUtils.isEmpty(a5) && Integer.parseInt(a5) == 1) {
                                com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f12294b, 2);
                            }
                        } catch (Exception e5) {
                            af.b(MBridgeBaseView.TAG, e5.getMessage());
                        }
                    }
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public final void run() {
                            MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                            mBridgeContainerView.a(bVar, Integer.valueOf(mBridgeContainerView.f12294b.getVideo_end_type()));
                        }
                    }, (long) getVideoSkipTime());
                }
            }
            g();
        }
    }

    public void readyStatus(int i5) {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f12346q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.readyStatus(i5);
        }
    }

    public void release() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f12346q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.release();
            this.f12346q = null;
        }
        MBridgePlayableView mBridgePlayableView = this.f12342m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.release();
        }
        MBridgeLandingPageView mBridgeLandingPageView = this.f12348s;
        if (mBridgeLandingPageView != null) {
            mBridgeLandingPageView.release();
        }
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f12345p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.clearMoreOfferBitmap();
            this.f12345p.release();
        }
        if (this.notifyListener != null) {
            this.notifyListener = null;
        }
    }

    public void resizeMiniCard(int i5, int i6, int i7) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f12344o;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.resizeMiniCard(i5, i6);
            this.f12344o.setRadius(i7);
            removeAllViews();
            setMatchParent();
            this.f12340S = true;
            bringToFront();
            f();
        }
    }

    public void setCloseDelayTime(int i5) {
        this.f12355z = i5;
    }

    public void setEndscreenType(int i5) {
        this.f12354y = i5;
    }

    public void setJSFactory(b bVar) {
        this.f12338Q = bVar;
    }

    public void setMBridgeClickMiniCardViewTransparent() {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f12344o;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.setMBridgeClickMiniCardViewTransparent();
            this.f12344o.setMBridgeClickMiniCardViewClickable(false);
        }
    }

    public void setNotchPadding(int i5, int i6, int i7, int i8, int i9) {
        af.b(MBridgeBaseView.TAG, "NOTCH ContainerView " + String.format("%1s-%2s-%3s-%4s-%5s", new Object[]{Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i5)}));
        this.f12336O = i5;
        this.f12332K = i6;
        this.f12333L = i7;
        this.f12334M = i8;
        this.f12335N = i9;
        this.f12337P = s.a(i5, i6, i7, i8, i9);
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f12345p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setNotchPadding(i6, i7, i8, i9);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f12346q;
        if (!(mBridgeH5EndCardView == null || mBridgeH5EndCardView.f12380p == null)) {
            mBridgeH5EndCardView.setNotchValue(this.f12337P, i6, i7, i8, i9);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f12346q.f12380p, "oncutoutfetched", Base64.encodeToString(this.f12337P.getBytes(), 0));
        }
        MBridgePlayableView mBridgePlayableView = this.f12342m;
        if (!(mBridgePlayableView == null || mBridgePlayableView.f12380p == null)) {
            mBridgePlayableView.setNotchValue(this.f12337P, i6, i7, i8, i9);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f12342m.f12380p, "oncutoutfetched", Base64.encodeToString(this.f12337P.getBytes(), 0));
        }
        MBridgeOrderCampView mBridgeOrderCampView = this.f12351v;
        if (mBridgeOrderCampView != null) {
            mBridgeOrderCampView.setNotchPadding(i6, i7, i8, i9);
        }
    }

    public void setNotifyListener(a aVar) {
        super.setNotifyListener(aVar);
        MBridgeBaseView[] mBridgeBaseViewArr = {this.f12342m, this.f12343n, this.f12344o, this.f12345p, this.f12346q, this.f12347r, this.f12348s, this.f12349t};
        for (int i5 = 0; i5 < 8; i5++) {
            MBridgeBaseView mBridgeBaseView = mBridgeBaseViewArr[i5];
            if (mBridgeBaseView != null) {
                if (mBridgeBaseView instanceof MBridgeClickMiniCardView) {
                    mBridgeBaseView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.g(this.f12344o, aVar));
                } else {
                    mBridgeBaseView.setNotifyListener(new i(aVar));
                }
            }
        }
    }

    public void setOnPause() {
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f12345p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setOnPause();
        }
    }

    public void setOnResume() {
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f12345p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setOnResume();
        }
    }

    public void setPlayCloseBtnTm(int i5) {
        this.f12322A = i5;
    }

    public void setRewardStatus(boolean z4) {
        this.f12331J = z4;
    }

    public void setShowingTransparent(boolean z4) {
        this.f12325D = z4;
    }

    public void setUnitID(String str) {
        this.f12352w = str;
    }

    public void setVideoInteractiveType(int i5) {
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx == null || !campaignEx.isDynamicView()) {
            this.f12353x = i5;
            return;
        }
        int a5 = com.mbridge.msdk.video.dynview.i.a.a(this.f12294b);
        if (a5 == 100) {
            this.f12353x = i5;
        } else {
            this.f12353x = a5;
        }
    }

    public void setVideoSkipTime(int i5) {
        this.f12329H = i5;
    }

    public boolean showAlertWebView() {
        MBridgeAlertWebview mBridgeAlertWebview = this.f12350u;
        if (mBridgeAlertWebview == null || !mBridgeAlertWebview.isLoadSuccess()) {
            return false;
        }
        setMatchParent();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1 && !this.f12340S) {
            removeAllViews();
            bringToFront();
            this.f12339R = true;
        }
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f12344o;
        if (mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.getParent() != null) {
            return false;
        }
        if (this.f12350u == null) {
            g();
        }
        MBridgeAlertWebview mBridgeAlertWebview2 = this.f12350u;
        if (!(mBridgeAlertWebview2 == null || mBridgeAlertWebview2.getParent() == null)) {
            removeView(this.f12350u);
        }
        addView(this.f12350u);
        setBackgroundColor(0);
        this.f12350u.webviewshow();
        return true;
    }

    public void showEndcard(int i5) {
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null) {
            if (i5 == 1) {
                this.notifyListener.a(104, "");
            } else if (i5 == 100) {
                if (campaignEx.getPlayable_ads_without_video() == 2) {
                    this.f12328G = true;
                }
                a((View) this.f12342m);
                setMatchParent();
                e();
            } else if (i5 == 3) {
                removeAllViews();
                setMatchParent();
                if (this.f12347r == null) {
                    a(this.f12338Q, 3);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13, -1);
                addView(this.f12347r, layoutParams);
                this.f12347r.notifyShowListener();
                this.f12340S = true;
                bringToFront();
            } else if (i5 == 4) {
                this.notifyListener.a(113, "");
                removeAllViews();
                setMatchParent();
                if (this.f12348s == null) {
                    a(this.f12338Q, 4);
                }
                this.f12348s.setUnitId(this.f12352w);
                this.f12348s.preLoadData(this.f12338Q);
                addView(this.f12348s);
                this.f12340S = true;
                bringToFront();
            } else if (i5 != 5) {
                removeAllViews();
                setMatchParent();
                this.f12340S = true;
                bringToFront();
                a();
                this.notifyListener.a(117, "");
            } else {
                this.notifyListener.a(106, "");
            }
        }
        this.f12323B = true;
    }

    public void showMiniCard(int i5, int i6, int i7, int i8, int i9) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f12344o;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.setMiniCardLocation(i5, i6, i7, i8);
            this.f12344o.setRadius(i9);
            this.f12344o.setCloseVisible(8);
            this.f12344o.setClickable(false);
            removeAllViews();
            setMatchParent();
            this.f12340S = true;
            bringToFront();
            f();
            if (!this.f12327F) {
                this.f12327F = true;
                this.notifyListener.a(109, "");
                this.notifyListener.a(117, "");
            }
        }
    }

    public void showOrderCampView() {
        MBridgeOrderCampView mBridgeOrderCampView = new MBridgeOrderCampView(this.f12293a);
        this.f12351v = mBridgeOrderCampView;
        mBridgeOrderCampView.setCampaignExes(this.f12341T);
        a aVar = this.notifyListener;
        if (aVar != null && (aVar instanceof k)) {
            ((k) aVar).a(this.f12341T);
        }
        this.f12351v.setNotifyListener(new i(this.notifyListener));
        this.f12351v.setRewarded(this.f12331J);
        this.f12351v.setNotchPadding(this.f12332K, this.f12333L, this.f12334M, this.f12335N);
        this.f12351v.setCampOrderViewBuildCallback(new com.mbridge.msdk.video.dynview.e.b() {
            public final void a() {
                a aVar = MBridgeContainerView.this.notifyListener;
                if (aVar != null) {
                    aVar.a(117, "");
                }
            }

            public final void b() {
                if (MBridgeContainerView.this.f12294b.getAdSpaceT() == 2) {
                    MBridgeContainerView.this.showVideoEndCover();
                    return;
                }
                MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                mBridgeContainerView.showEndcard(mBridgeContainerView.f12294b.getVideo_end_type());
            }
        });
        this.f12351v.createView(this);
    }

    public void showPlayableView() {
        if (this.f12294b != null && !this.f12328G) {
            removeAllViews();
            setMatchParent();
            if (this.f12342m == null) {
                preLoadData(this.f12338Q);
            }
            addView(this.f12342m);
            MBridgePlayableView mBridgePlayableView = this.f12342m;
            if (mBridgePlayableView != null) {
                mBridgePlayableView.setUnitId(this.f12352w);
                CampaignEx campaignEx = this.f12294b;
                if (campaignEx != null && campaignEx.isMraid() && this.f12294b.getPlayable_ads_without_video() == 2) {
                    this.f12342m.setCloseVisible(0);
                }
                this.f12342m.setNotchValue(this.f12337P, this.f12332K, this.f12333L, this.f12334M, this.f12335N);
            }
            this.f12340S = true;
            bringToFront();
        }
    }

    public void showVideoClickView(int i5) {
        if (this.f12294b == null) {
            return;
        }
        if (i5 != -1) {
            if (i5 != 1) {
                if (i5 == 2) {
                    MBridgeClickCTAView mBridgeClickCTAView = this.f12343n;
                    if (!(mBridgeClickCTAView == null || mBridgeClickCTAView.getParent() == null)) {
                        removeView(this.f12343n);
                    }
                    MBridgeAlertWebview mBridgeAlertWebview = this.f12350u;
                    if (mBridgeAlertWebview == null || mBridgeAlertWebview.getParent() == null) {
                        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f12344o;
                        if (mBridgeClickMiniCardView == null || mBridgeClickMiniCardView.getParent() == null) {
                            try {
                                CampaignEx campaignEx = this.f12294b;
                                if (campaignEx != null && campaignEx.getPlayable_ads_without_video() == 1) {
                                    setMatchParent();
                                    f();
                                }
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (miniCardLoaded()) {
                            MBridgeH5EndCardView mBridgeH5EndCardView = this.f12346q;
                            if (!(mBridgeH5EndCardView == null || mBridgeH5EndCardView.getParent() == null)) {
                                removeView(this.f12346q);
                            }
                            this.notifyListener.a(112, "");
                            CampaignEx campaignEx2 = this.f12294b;
                            if (campaignEx2 != null && !campaignEx2.isHasReportAdTrackPause()) {
                                this.f12294b.setHasReportAdTrackPause(true);
                                com.mbridge.msdk.video.module.b.b.f(this.f12293a, this.f12294b);
                            }
                            if (this.f12325D) {
                                this.notifyListener.a(115, "");
                            } else {
                                this.f12340S = true;
                                bringToFront();
                                webviewshow();
                                onConfigurationChanged(getResources().getConfiguration());
                            }
                            this.f12324C = true;
                            return;
                        }
                        h();
                    }
                }
            } else if (!this.f12323B) {
                MBridgeH5EndCardView mBridgeH5EndCardView2 = this.f12346q;
                if (!(mBridgeH5EndCardView2 == null || mBridgeH5EndCardView2.getParent() == null)) {
                    removeView(this.f12346q);
                }
                MBridgeClickMiniCardView mBridgeClickMiniCardView2 = this.f12344o;
                if (!(mBridgeClickMiniCardView2 == null || mBridgeClickMiniCardView2.getParent() == null)) {
                    removeView(this.f12344o);
                }
                MBridgeClickCTAView mBridgeClickCTAView2 = this.f12343n;
                if (mBridgeClickCTAView2 == null || mBridgeClickCTAView2.getParent() == null) {
                    try {
                        CampaignEx campaignEx3 = this.f12294b;
                        if (campaignEx3 != null && campaignEx3.getPlayable_ads_without_video() == 1) {
                            this.f12340S = true;
                            if (this.f12343n == null) {
                                b(-1);
                            }
                            if (this.f12343n != null) {
                                CampaignEx campaignEx4 = this.f12294b;
                                if (campaignEx4 == null || !campaignEx4.isDynamicView()) {
                                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                                    layoutParams.addRule(12, -1);
                                    addView(this.f12343n, 0, layoutParams);
                                }
                            }
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                if (isLast()) {
                    bringToFront();
                }
            }
        } else if (!isLast() && !endCardShowing()) {
            h();
        }
    }

    public void showVideoEndCover() {
        removeAllViews();
        setMatchParent();
        MBridgeVideoEndCoverView mBridgeVideoEndCoverView = this.f12349t;
        if (mBridgeVideoEndCoverView == null) {
            b bVar = this.f12338Q;
            this.f12338Q = bVar;
            if (mBridgeVideoEndCoverView == null) {
                MBridgeVideoEndCoverView mBridgeVideoEndCoverView2 = new MBridgeVideoEndCoverView(this.f12293a);
                this.f12349t = mBridgeVideoEndCoverView2;
                mBridgeVideoEndCoverView2.setCampaign(this.f12294b);
                this.f12349t.setNotifyListener(new i(this.notifyListener));
                this.f12349t.preLoadData(bVar);
            }
        }
        addView(this.f12349t);
        onConfigurationChanged(getResources().getConfiguration());
        this.f12340S = true;
        bringToFront();
    }

    public void toggleCloseBtn(int i5) {
        MBridgePlayableView mBridgePlayableView = this.f12342m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.toggleCloseBtn(i5);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f12346q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.toggleCloseBtn(i5);
        }
    }

    public void triggerCloseBtn(String str) {
        try {
            e eVar = new e();
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
            d.a().a("2000152", eVar);
            d.a().a("2000134", this.f12294b);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
        if (this.f12294b != null) {
            this.notifyListener.a(122, "");
            this.notifyListener.a(104, "");
        }
    }

    public void webviewshow() {
        try {
            e eVar = new e();
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 3);
            d.a().a("2000133", this.f12294b, eVar);
        } catch (Exception unused) {
        }
        MBridgeH5EndCardView[] mBridgeH5EndCardViewArr = {this.f12342m, this.f12344o, this.f12346q, this.f12350u};
        for (int i5 = 0; i5 < 4; i5++) {
            MBridgeH5EndCardView mBridgeH5EndCardView = mBridgeH5EndCardViewArr[i5];
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getVisibility() == 0 && mBridgeH5EndCardView.getParent() != null && !isLast()) {
                mBridgeH5EndCardView.webviewshow();
            }
        }
    }

    private void a(View view) {
        if (view != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            } catch (Throwable th) {
                af.b(MBridgeBaseView.TAG, th.getMessage(), th);
            }
        }
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view != null) {
            a(view);
            super.addView(view, layoutParams);
            return;
        }
        af.b(MBridgeBaseView.TAG, "view is null");
    }

    private void a() {
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null) {
            boolean isDynamicView = campaignEx.isDynamicView();
            boolean l5 = ak.l(this.f12294b.getendcard_url());
            if (isDynamicView && !l5 && !this.f12294b.isMraid()) {
                e();
                return;
            }
        }
        if (this.f12354y != 2 || this.f12330I) {
            e();
        } else {
            b();
        }
    }

    /* access modifiers changed from: private */
    public void a(b bVar, Integer num) {
        CampaignEx campaignEx;
        a aVar;
        CampaignEx campaignEx2;
        this.f12338Q = bVar;
        CampaignEx campaignEx3 = this.f12294b;
        if (campaignEx3 != null) {
            if (num == null) {
                num = Integer.valueOf(campaignEx3.getVideo_end_type());
            }
            if (!isLast()) {
                h();
            }
            int intValue = num.intValue();
            if (intValue == 1) {
                return;
            }
            if (intValue == 3) {
                if (this.f12347r == null) {
                    this.f12347r = new MBridgeVastEndCardView(this.f12293a);
                }
                this.f12347r.setCampaign(this.f12294b);
                this.f12347r.setNotifyListener(new l(this.notifyListener));
                this.f12347r.preLoadData(bVar);
            } else if (intValue == 4) {
                if (this.f12348s == null) {
                    this.f12348s = new MBridgeLandingPageView(this.f12293a);
                }
                this.f12348s.setCampaign(this.f12294b);
                this.f12348s.setNotifyListener(new i(this.notifyListener));
            } else if (intValue == 5) {
            } else {
                if (this.f12354y == 2) {
                    boolean isDynamicView = this.f12294b.isDynamicView();
                    boolean l5 = ak.l(this.f12294b.getendcard_url());
                    if ((!isDynamicView || l5 || (campaignEx2 = this.f12294b) == null || campaignEx2.isMraid()) && (campaignEx = this.f12294b) != null && campaignEx.getAdSpaceT() != 2) {
                        if (this.f12346q == null) {
                            this.f12346q = new MBridgeH5EndCardView(this.f12293a);
                            try {
                                e eVar = new e();
                                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 3);
                                d.a().a("2000154", this.f12294b, eVar);
                            } catch (Throwable th) {
                                af.b(MBridgeBaseView.TAG, th.getMessage());
                            }
                        }
                        if (this.f12294b.getDynamicTempCode() == 5 && (aVar = this.notifyListener) != null && (aVar instanceof k)) {
                            ((k) aVar).a(this.f12294b);
                        }
                        this.f12346q.setCampaign(this.f12294b);
                        this.f12346q.setCloseDelayShowTime(this.f12355z);
                        this.f12346q.setNotifyListener(new i(this.notifyListener));
                        this.f12346q.setUnitId(this.f12352w);
                        this.f12346q.setNotchValue(this.f12337P, this.f12332K, this.f12333L, this.f12334M, this.f12335N);
                        this.f12346q.preLoadData(bVar);
                        if (!this.f12325D) {
                            addView(this.f12346q);
                            return;
                        }
                        return;
                    }
                    return;
                }
                CampaignEx campaignEx4 = this.f12294b;
                int i5 = 0;
                int b5 = (campaignEx4 == null || campaignEx4.getRewardTemplateMode() == null) ? 0 : this.f12294b.getRewardTemplateMode().b();
                if (this.f12345p == null) {
                    CampaignEx campaignEx5 = this.f12294b;
                    if (campaignEx5 == null || !campaignEx5.isDynamicView()) {
                        Context context = this.f12293a;
                        CampaignEx campaignEx6 = this.f12294b;
                        boolean z4 = campaignEx6 != null && campaignEx6.getAdSpaceT() == 2;
                        CampaignEx campaignEx7 = this.f12294b;
                        if (campaignEx7 != null) {
                            i5 = campaignEx7.getMof_tplid();
                        }
                        MBridgeNativeEndCardView mBridgeNativeEndCardView = new MBridgeNativeEndCardView(context, (AttributeSet) null, false, -1, z4, b5, i5);
                        this.f12345p = mBridgeNativeEndCardView;
                        mBridgeNativeEndCardView.setCampaign(this.f12294b);
                    } else {
                        i();
                    }
                }
                this.f12345p.setLayout();
                if (this.f12294b.isDynamicView()) {
                    com.mbridge.msdk.video.dynview.moffer.a a5 = com.mbridge.msdk.video.dynview.moffer.a.a();
                    if (a5.a(this.f12294b.getRequestId() + "_" + this.f12294b.getId())) {
                        try {
                            com.mbridge.msdk.video.dynview.moffer.a a6 = com.mbridge.msdk.video.dynview.moffer.a.a();
                            MBridgeNativeEndCardView mBridgeNativeEndCardView2 = this.f12345p;
                            a6.a(mBridgeNativeEndCardView2, this.f12294b.getRequestId() + "_" + this.f12294b.getId(), new i(this.notifyListener));
                        } catch (Exception e5) {
                            af.b(MBridgeBaseView.TAG, e5.getMessage());
                        }
                    } else {
                        try {
                            String a7 = aq.a(this.f12294b.getendcard_url(), "mof");
                            if (!TextUtils.isEmpty(a7) && Integer.parseInt(a7) == 1) {
                                com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f12294b, this.f12345p, new i(this.notifyListener), 2);
                            }
                        } catch (Exception e6) {
                            af.b(MBridgeBaseView.TAG, e6.getMessage());
                        }
                    }
                }
                this.f12345p.setUnitId(this.f12352w);
                this.f12345p.setCloseBtnDelay(this.f12355z);
                this.f12345p.setNotifyListener(new i(this.notifyListener));
                this.f12345p.preLoadData(bVar);
                this.f12345p.setNotchPadding(this.f12332K, this.f12333L, this.f12334M, this.f12335N);
            }
        }
    }

    public MBridgeContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void b(int i5) {
        if (i5 == -3) {
            return;
        }
        if (i5 != -2) {
            if (this.f12343n == null) {
                this.f12343n = new MBridgeClickCTAView(this.f12293a);
            }
            this.f12343n.setCampaign(this.f12294b);
            this.f12343n.setUnitId(this.f12352w);
            this.f12343n.setNotifyListener(new i(this.notifyListener));
            this.f12343n.preLoadData(this.f12338Q);
            return;
        }
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null && campaignEx.getVideo_end_type() == 2) {
            if (this.f12344o == null) {
                this.f12344o = new MBridgeClickMiniCardView(this.f12293a);
            }
            this.f12344o.setCampaign(this.f12294b);
            MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f12344o;
            mBridgeClickMiniCardView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.g(mBridgeClickMiniCardView, this.notifyListener));
            this.f12344o.preLoadData(this.f12338Q);
            setMatchParent();
            f();
            h();
        }
    }
}
