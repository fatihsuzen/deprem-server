package com.mbridge.msdk.newreward.player.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.d.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.command.receiver.d;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.player.imodel.IECModel;
import com.mbridge.msdk.newreward.player.iview.IBaseWebView;
import com.mbridge.msdk.newreward.player.model.WebViewECModel;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MBCommunicatorUtil;
import com.mbridge.msdk.out.RewardInfo;
import java.lang.reflect.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

public class ECWebPresenter extends AbsPresenter implements b {
    final int END_CARD_BUILD_TYPE = 2;
    private final String TAG = "ECWebPresenter";
    IECModel ecTempleModel;
    a feedbackDialogEventListener = new a() {
        public void close() {
            ECWebPresenter.this.firePrivacyFeedbackEvent(2);
        }

        public void showed() {
            ECWebPresenter.this.firePrivacyFeedbackEvent(1);
        }

        public void summit(String str) {
            ECWebPresenter.this.firePrivacyFeedbackEvent(2);
        }
    };
    boolean isLoadResourceError = false;
    boolean isShown = false;
    boolean isWebContentLoadFinish = false;
    boolean mCanResponseBackPress = false;
    Handler mHandler = new Handler(Looper.getMainLooper());
    float mTouchX;
    float mTouchY;
    IBaseWebView mWebContentView;
    int muteState = -1;
    public Runnable nativeCloseBtnVisibleRunnable = new Runnable() {
        public void run() {
            CampaignEx campaignEx;
            ECWebPresenter eCWebPresenter = ECWebPresenter.this;
            if (eCWebPresenter.webCloseViewStatus == -1 || (campaignEx = eCWebPresenter.campaignEx) == null || campaignEx.getVideo_end_type() == 4) {
                ECWebPresenter.this.mWebContentView.setNativeCloseButtonVisibility(0);
            }
        }
    };
    int webCloseViewStatus = -1;

    public ECWebPresenter(IBaseWebView iBaseWebView) {
        super(iBaseWebView);
        this.mWebContentView = (IBaseWebView) Proxy.newProxyInstance(iBaseWebView.getClass().getClassLoader(), new Class[]{IBaseWebView.class}, new e(iBaseWebView, this.adapterModel, this.commandManager));
        this.TEMPLATE_MARK_TYPE = 3;
    }

    /* access modifiers changed from: private */
    public void firePrivacyFeedbackEvent(int i5) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            if (c.m().c() != null) {
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, i5);
            }
            str = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
        } catch (Throwable th) {
            af.b("ECWebPresenter", th.getMessage(), th);
            str = "";
        }
        MBCommunicatorUtil.fireEvent(this.mWebContentView.getWebView(), "onFeedbackAlertStatusNotify", str);
    }

    public void adClosed() {
        if (!this.adapterModel.aa()) {
            this.adapterModel.l(true);
            if (this.reward != null) {
                this.ecTempleModel.onAdClose(this.mBridgeIds, new RewardInfo(this.adapterModel.ab(), this.reward.a(), String.valueOf(this.reward.b())), 2);
            }
        }
    }

    public void adShowSuccess() {
        if (!this.adapterModel.Y()) {
            this.adapterModel.j(true);
            super.adShowSuccess();
            this.ecTempleModel.onAdShow(this.mBridgeIds);
            this.ecTempleModel.eventImpression(this.redirectModel);
            this.ecTempleModel.eventOnlyImpression(this.redirectModel);
            this.ecTempleModel.eventPvUrls(this.redirectModel);
            this.ecTempleModel.eventTrackingForImpression(this.redirectModel);
        }
    }

    public void addECModel() {
        WebViewECModel webViewECModel = new WebViewECModel(this.commandManager, this.adapterModel);
        webViewECModel.setCallbackListener(this);
        webViewECModel.setRenderType(this.TEMPLATE_MARK_TYPE);
        this.mWebContentView.getWebView().setHybridCommunicator(webViewECModel);
        this.mWebContentView.getWebView().setWebViewEventListener(webViewECModel);
        this.ecTempleModel = (IECModel) Proxy.newProxyInstance(WebViewECModel.class.getClassLoader(), new Class[]{IECModel.class}, new e(webViewECModel, this.adapterModel, this.commandManager));
    }

    public void changeNativeCloseButton() {
        int cbd = this.adapterModel.U().getCbd();
        if (cbd < 0) {
            cbd = this.adapterModel.x().b().p();
        }
        this.mHandler.postDelayed(this.nativeCloseBtnVisibleRunnable, ((long) cbd) * 1000);
    }

    public void click(View view) {
        this.mWebContentView.removeTempleFromSuperView(this.data.getRootViewGroup());
        if (isIVRewardEnable()) {
            this.ecTempleModel.onAdCloseWithIVReward(this.mBridgeIds, this.adapterModel.ab(), this.adapterModel.w());
        }
        adClosed();
        if (!this.isIV && this.adapterModel.ab()) {
            this.ecTempleModel.eventAddReward(this.redirectModel);
        }
        finish(true);
    }

    public void finish(boolean z4) {
        this.mWebContentView.onDestroyWebContent(this.TEMPLATE_MARK_TYPE);
        d.a().d(f.SHOW_OR_PRELOAD_WEB_EC);
        Context context = this.context;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    public int getCampaignOrientation() {
        try {
            if (this.adapterModel.U() != null) {
                return this.adapterModel.U().getRewardTemplateMode().b();
            }
            return 0;
        } catch (Throwable th) {
            af.b("ECWebPresenter", th.getMessage());
            return 0;
        }
    }

    public int getRenderStatus() {
        return this.ecTempleModel.getRenderStatus();
    }

    public void getView() {
        initDataForView((com.mbridge.msdk.video.dynview.a) null);
    }

    public String getWebViewShowExtraData() {
        if (this.reward == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(RewardPlus.NAME, this.reward.a());
            jSONObject2.put(RewardPlus.AMOUNT, this.reward.b());
            jSONObject2.put("id", "");
            jSONObject.put("userId", "");
            jSONObject.put("reward", jSONObject2);
            jSONObject.put("playVideoMute", this.muteState);
            jSONObject.put("extra", this.adapterModel.W());
            return jSONObject.toString();
        } catch (JSONException e5) {
            throw new RuntimeException(e5);
        }
    }

    public void handleInterceptTouchEvent(MotionEvent motionEvent) {
        this.mTouchX = motionEvent.getRawX();
        this.mTouchY = motionEvent.getRawY();
    }

    public void initDataForView(com.mbridge.msdk.video.dynview.a aVar) {
        this.mWebContentView.initViews(false);
        ak.a(2, this.mWebContentView.getPrivacyButton(), this.adapterModel.U(), this.context, false, this.feedbackDialogEventListener);
    }

    public void onActivityLifeCycleCallback(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            str.getClass();
            char c5 = 65535;
            switch (str.hashCode()) {
                case -1401315045:
                    if (str.equals("onDestroy")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1340212393:
                    if (str.equals("onPause")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case -1111243300:
                    if (str.equals("onBackPressed")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 1463983852:
                    if (str.equals("onResume")) {
                        c5 = 3;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    adClosed();
                    finish(false);
                    str2 = "onSystemDestory";
                    break;
                case 1:
                    str2 = "onSystemPause";
                    break;
                case 2:
                    str2 = "onSystemBackPressed";
                    break;
                case 3:
                    str2 = "onSystemResume";
                    break;
                default:
                    str2 = "";
                    break;
            }
            if (!TextUtils.isEmpty(str2)) {
                MBCommunicatorUtil.fireEvent(this.mWebContentView.getWebView(), str2, "");
            }
            if (str.equals("onBackPressed") && this.isShown && this.mCanResponseBackPress) {
                click((View) null);
            }
        }
    }

    public void onAttachedToWindow() {
    }

    public void onDetachedFromWindow() {
        this.mHandler.removeCallbacks(this.nativeCloseBtnVisibleRunnable);
    }

    public void onShown() {
        adShowSuccess();
        if (this.ecTempleModel != null && !this.adapterModel.Z()) {
            int i5 = this.videoEndType;
            if (!(i5 == 4 || i5 == 5)) {
                this.ecTempleModel.onEndCardShow(this.mBridgeIds, 2);
                this.ecTempleModel.eventTrackingForEndCardShow(this.redirectModel, 2);
            }
            this.isShown = true;
            if (this.isWebContentLoadFinish) {
                this.mWebContentView.onWebViewShow(this.TEMPLATE_MARK_TYPE);
            }
            this.adapterModel.k(true);
            changeNativeCloseButton();
        }
    }

    public void onWebContentError() {
        long j5;
        if (!this.isLoadResourceError) {
            this.isLoadResourceError = true;
            this.mWebContentView.onDestroyWebContent(this.TEMPLATE_MARK_TYPE);
            if (this.isShown) {
                CampaignEx campaignEx = this.campaignEx;
                if (campaignEx != null) {
                    j5 = campaignEx.getEcTemplateId();
                } else {
                    j5 = 404;
                }
                com.mbridge.msdk.newreward.function.command.c cVar = this.commandManager;
                cVar.g(cVar.a("add_temple", Long.valueOf(j5), "template_type", 18, "adapter_model", this.adapterModel, "parent_temple", this.data.getRootViewGroup()), f.SHOW_ADD_TEMPLE);
                d.a().d(f.SHOW_OR_PRELOAD_WEB_EC);
            } else {
                this.ecTempleModel.setRenderStatus(1);
            }
            this.mWebContentView.removeTempleFromSuperView(this.data.getRootViewGroup());
        }
    }

    public void releaseSource() {
    }

    public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void reqSuccessful(java.lang.Object r26) {
        /*
            r25 = this;
            r1 = r25
            r0 = r26
            boolean r2 = r0 instanceof org.json.JSONObject     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x01fb
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x0033 }
            int r2 = r0.length()     // Catch:{ all -> 0x0033 }
            if (r2 <= 0) goto L_0x01fb
            java.lang.String r2 = "action"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0033 }
            int r3 = r2.hashCode()     // Catch:{ all -> 0x0033 }
            r4 = 3
            r5 = 4
            r6 = 8
            r7 = 2
            r8 = 0
            r9 = -1
            r10 = 1
            switch(r3) {
                case -1765453640: goto L_0x0092;
                case -1488920312: goto L_0x0088;
                case -1289167206: goto L_0x007d;
                case -1258199123: goto L_0x0073;
                case -920773881: goto L_0x0069;
                case -505277536: goto L_0x005f;
                case 94750088: goto L_0x0055;
                case 94756344: goto L_0x004b;
                case 96046965: goto L_0x0041;
                case 1639551484: goto L_0x0036;
                case 1843897919: goto L_0x0027;
                default: goto L_0x0025;
            }     // Catch:{ all -> 0x0033 }
        L_0x0025:
            goto L_0x009c
        L_0x0027:
            java.lang.String r3 = "feedbackOperate"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x009c
            r2 = 10
            goto L_0x009d
        L_0x0033:
            r0 = move-exception
            goto L_0x01fc
        L_0x0036:
            java.lang.String r3 = "loadingResourceStatus"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x009c
            r2 = r10
            goto L_0x009d
        L_0x0041:
            java.lang.String r3 = "readyStatus"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x009c
            r2 = r8
            goto L_0x009d
        L_0x004b:
            java.lang.String r3 = "close"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x009c
            r2 = 5
            goto L_0x009d
        L_0x0055:
            java.lang.String r3 = "click"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x009c
            r2 = r6
            goto L_0x009d
        L_0x005f:
            java.lang.String r3 = "onPageFinished"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x009c
            r2 = r7
            goto L_0x009d
        L_0x0069:
            java.lang.String r3 = "ivRewardAdsWithoutVideo"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x009c
            r2 = 6
            goto L_0x009d
        L_0x0073:
            java.lang.String r3 = "notifyCloseBtn"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x009c
            r2 = r5
            goto L_0x009d
        L_0x007d:
            java.lang.String r3 = "expand"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x009c
            r2 = 9
            goto L_0x009d
        L_0x0088:
            java.lang.String r3 = "onReceivedError"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x009c
            r2 = 7
            goto L_0x009d
        L_0x0092:
            java.lang.String r3 = "toggleCloseBtn"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x009c
            r2 = r4
            goto L_0x009d
        L_0x009c:
            r2 = r9
        L_0x009d:
            java.lang.String r3 = "type"
            java.lang.String r11 = "status"
            java.lang.String r12 = ""
            switch(r2) {
                case 0: goto L_0x01f3;
                case 1: goto L_0x01f3;
                case 2: goto L_0x01e5;
                case 3: goto L_0x01cf;
                case 4: goto L_0x01c0;
                case 5: goto L_0x01ba;
                case 6: goto L_0x0191;
                case 7: goto L_0x018d;
                case 8: goto L_0x0175;
                case 9: goto L_0x015d;
                case 10: goto L_0x00a8;
                default: goto L_0x00a6;
            }
        L_0x00a6:
            goto L_0x01fb
        L_0x00a8:
            java.lang.String r2 = r0.optString(r3, r12)     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = r0.optString(r11, r12)     // Catch:{ all -> 0x0033 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x00b8
            goto L_0x01fb
        L_0x00b8:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0033 }
            r3.<init>(r0)     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = "popup"
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = "view_visible"
            java.lang.String r5 = "key"
            if (r0 == 0) goto L_0x00da
            java.lang.String r0 = r3.optString(r5, r12)     // Catch:{ all -> 0x0033 }
            int r7 = r3.optInt(r4, r10)     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.foundation.d.b r11 = com.mbridge.msdk.foundation.d.b.a()     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.foundation.d.a r13 = r1.feedbackDialogEventListener     // Catch:{ all -> 0x0033 }
            r11.a((java.lang.String) r0, (int) r7, (com.mbridge.msdk.foundation.d.a) r13)     // Catch:{ all -> 0x0033 }
        L_0x00da:
            java.lang.String r0 = "visibility"
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x00fb
            int r0 = r3.optInt(r4, r10)     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = r3.optString(r5, r12)     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.foundation.d.b r7 = com.mbridge.msdk.foundation.d.b.a()     // Catch:{ all -> 0x0033 }
            if (r0 != r10) goto L_0x00f1
            goto L_0x00f2
        L_0x00f1:
            r6 = r8
        L_0x00f2:
            com.mbridge.msdk.newreward.player.iview.IBaseWebView r0 = r1.mWebContentView     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.newreward.player.view.hybrid.MBWebView r0 = r0.getWebView()     // Catch:{ all -> 0x0033 }
            r7.a((java.lang.String) r4, (int) r6, (android.view.ViewGroup) r0)     // Catch:{ all -> 0x0033 }
        L_0x00fb:
            java.lang.String r0 = "layout"
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x01fb
            java.lang.String r0 = "width"
            int r15 = r3.optInt(r0, r9)     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = "height"
            int r16 = r3.optInt(r0, r9)     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = "left"
            int r0 = r3.optInt(r0, r9)     // Catch:{ all -> 0x0033 }
            java.lang.String r2 = "top"
            int r2 = r3.optInt(r2, r9)     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = "opacity"
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r6 = r3.optDouble(r4, r6)     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = "radius"
            r8 = 20
            int r17 = r3.optInt(r4, r8)     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = "fontColor"
            java.lang.String r21 = r3.optString(r4, r12)     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = "bgColor"
            java.lang.String r22 = r3.optString(r4, r12)     // Catch:{ all -> 0x0033 }
            java.lang.String r14 = r3.optString(r5, r12)     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = "fontSize"
            r8 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            double r4 = r3.optDouble(r4, r8)     // Catch:{ all -> 0x0033 }
            java.lang.String r8 = "padding"
            org.json.JSONArray r24 = r3.optJSONArray(r8)     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.foundation.d.b r13 = com.mbridge.msdk.foundation.d.b.a()     // Catch:{ all -> 0x0033 }
            float r0 = (float) r0     // Catch:{ all -> 0x0033 }
            float r2 = (float) r2     // Catch:{ all -> 0x0033 }
            float r3 = (float) r6     // Catch:{ all -> 0x0033 }
            float r4 = (float) r4     // Catch:{ all -> 0x0033 }
            r18 = r0
            r19 = r2
            r20 = r3
            r23 = r4
            r13.a(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x0033 }
            return
        L_0x015d:
            java.lang.String r2 = "url"
            java.lang.String r2 = r0.optString(r2, r12)     // Catch:{ all -> 0x0033 }
            java.lang.String r3 = "shouldUseCustomClose"
            int r0 = r0.optInt(r3, r10)     // Catch:{ all -> 0x0033 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0033 }
            if (r3 != 0) goto L_0x01fb
            com.mbridge.msdk.newreward.player.iview.IBaseWebView r3 = r1.mWebContentView     // Catch:{ all -> 0x0033 }
            r3.showMRAIDExpandView(r2, r0)     // Catch:{ all -> 0x0033 }
            return
        L_0x0175:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.campaignEx     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x017e
            int r2 = com.mbridge.msdk.foundation.same.report.d.a.f9451h     // Catch:{ all -> 0x0033 }
            r0.setClickTempSource(r2)     // Catch:{ all -> 0x0033 }
        L_0x017e:
            com.mbridge.msdk.newreward.player.imodel.IECModel r0 = r1.ecTempleModel     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.newreward.player.redirect.RedirectModel r2 = r1.redirectModel     // Catch:{ all -> 0x0033 }
            r0.eventTrackingForClick(r2)     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.newreward.player.imodel.IECModel r0 = r1.ecTempleModel     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.out.MBridgeIds r2 = r1.mBridgeIds     // Catch:{ all -> 0x0033 }
            r0.onAdClick(r2)     // Catch:{ all -> 0x0033 }
            return
        L_0x018d:
            r1.onWebContentError()     // Catch:{ all -> 0x0033 }
            return
        L_0x0191:
            int r2 = r0.optInt(r3)     // Catch:{ all -> 0x0033 }
            java.lang.String r3 = "complete"
            int r0 = r0.optInt(r3)     // Catch:{ all -> 0x0033 }
            if (r2 == r7) goto L_0x01a5
            if (r2 == r4) goto L_0x01a2
            int r2 = com.mbridge.msdk.foundation.same.a.f9163F     // Catch:{ all -> 0x0033 }
            goto L_0x01a7
        L_0x01a2:
            int r2 = com.mbridge.msdk.foundation.same.a.f9162E     // Catch:{ all -> 0x0033 }
            goto L_0x01a7
        L_0x01a5:
            int r2 = com.mbridge.msdk.foundation.same.a.f9161D     // Catch:{ all -> 0x0033 }
        L_0x01a7:
            com.mbridge.msdk.newreward.a.e r3 = r1.adapterModel     // Catch:{ all -> 0x0033 }
            r3.b((int) r2)     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.newreward.a.e r2 = r1.adapterModel     // Catch:{ all -> 0x0033 }
            if (r0 != r10) goto L_0x01b1
            r8 = r10
        L_0x01b1:
            r2.m(r8)     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.newreward.player.iview.IBaseWebView r0 = r1.mWebContentView     // Catch:{ all -> 0x0033 }
            r0.onCloseViewClick(r7)     // Catch:{ all -> 0x0033 }
            return
        L_0x01ba:
            com.mbridge.msdk.newreward.player.iview.IBaseWebView r0 = r1.mWebContentView     // Catch:{ all -> 0x0033 }
            r0.onCloseViewClick(r7)     // Catch:{ all -> 0x0033 }
            return
        L_0x01c0:
            int r0 = r0.optInt(r11, r9)     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x01c8
            if (r0 != r10) goto L_0x01ca
        L_0x01c8:
            r1.webCloseViewStatus = r0     // Catch:{ all -> 0x0033 }
        L_0x01ca:
            if (r0 != r10) goto L_0x01fb
            r1.mCanResponseBackPress = r10     // Catch:{ all -> 0x0033 }
            return
        L_0x01cf:
            int r0 = r0.optInt(r11, r10)     // Catch:{ all -> 0x0033 }
            r1.webCloseViewStatus = r0     // Catch:{ all -> 0x0033 }
            android.os.Handler r2 = r1.mHandler     // Catch:{ all -> 0x0033 }
            java.lang.Runnable r3 = r1.nativeCloseBtnVisibleRunnable     // Catch:{ all -> 0x0033 }
            r2.removeCallbacks(r3)     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.newreward.player.iview.IBaseWebView r2 = r1.mWebContentView     // Catch:{ all -> 0x0033 }
            if (r0 != r10) goto L_0x01e1
            r5 = r8
        L_0x01e1:
            r2.setNativeCloseButtonVisibility(r5)     // Catch:{ all -> 0x0033 }
            return
        L_0x01e5:
            r1.isWebContentLoadFinish = r10     // Catch:{ all -> 0x0033 }
            boolean r0 = r1.isShown     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x01fb
            com.mbridge.msdk.newreward.player.iview.IBaseWebView r0 = r1.mWebContentView     // Catch:{ all -> 0x0033 }
            int r2 = r1.TEMPLATE_MARK_TYPE     // Catch:{ all -> 0x0033 }
            r0.onWebViewShow(r2)     // Catch:{ all -> 0x0033 }
            return
        L_0x01f3:
            int r0 = r0.optInt(r11, r10)     // Catch:{ all -> 0x0033 }
            if (r0 != r10) goto L_0x01fb
            r1.isWebContentLoadFinish = r10     // Catch:{ all -> 0x0033 }
        L_0x01fb:
            return
        L_0x01fc:
            java.lang.String r2 = "ECWebPresenter"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.presenter.ECWebPresenter.reqSuccessful(java.lang.Object):void");
    }

    public void setCanResponseBack(boolean z4) {
        this.mCanResponseBackPress = z4;
    }

    public void setNotchData(String str) {
        MBCommunicatorUtil.notifyNotchData(this.mWebContentView.getWebView(), str);
    }

    public void setRenderError() {
        IECModel iECModel = this.ecTempleModel;
        if (iECModel != null) {
            iECModel.setRenderStatus(1);
        }
    }
}
