package com.mbridge.msdk.newreward.player.presenter;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
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
import com.mbridge.msdk.newreward.player.imodel.IPlayModel;
import com.mbridge.msdk.newreward.player.iview.IWebTemplateView;
import com.mbridge.msdk.newreward.player.model.WebTemplateModel;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MBCommunicatorUtil;
import java.io.File;
import java.lang.reflect.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

public class PlayWebPresenter extends BaseTemplatePresenter implements b {
    final int CLOSE_BUILD_TYPE = 2;
    private final String TAG = "PlayWebPresenter";
    a feedbackDialogEventListener = new a() {
        public void close() {
            PlayWebPresenter.this.firePrivacyFeedbackEvent(2);
        }

        public void showed() {
            PlayWebPresenter.this.firePrivacyFeedbackEvent(1);
        }

        public void summit(String str) {
            PlayWebPresenter.this.firePrivacyFeedbackEvent(2);
        }
    };
    boolean mCanResponseBackPress = false;
    Handler mHandler = new Handler(Looper.getMainLooper());
    boolean mNativeHandleClick = false;
    float mTouchX;
    float mTouchY;
    IWebTemplateView mWebTemplateView;
    private boolean muteState = true;
    public Runnable nativeCloseBtnVisibleRunnable = new Runnable() {
        public void run() {
            PlayWebPresenter playWebPresenter = PlayWebPresenter.this;
            if (playWebPresenter.webCloseViewStatus == -1) {
                playWebPresenter.mWebTemplateView.setNativeCloseButtonVisibility(0);
            }
        }
    };
    int webCloseViewStatus = -1;

    public PlayWebPresenter(IWebTemplateView iWebTemplateView) {
        super(iWebTemplateView);
        IWebTemplateView iWebTemplateView2 = (IWebTemplateView) Proxy.newProxyInstance(iWebTemplateView.getClass().getClassLoader(), new Class[]{IWebTemplateView.class}, new e(iWebTemplateView, this.adapterModel, this.commandManager));
        this.mWebTemplateView = iWebTemplateView2;
        this.iView = iWebTemplateView2;
        this.TEMPLATE_MARK_TYPE = 2;
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
            af.b("PlayWebPresenter", th.getMessage(), th);
            str = "";
        }
        MBCommunicatorUtil.fireEvent(this.mWebTemplateView.getWebView(), "onFeedbackAlertStatusNotify", str);
    }

    private void showCTAOrMiniEndCard(int i5) {
        if (i5 == -1) {
            this.mWebTemplateView.hideCTAView();
        }
        if (i5 == 1) {
            this.mWebTemplateView.showCTAView(this.adapterModel.H(), this.adapterModel.U());
        }
        if (i5 == 2) {
            this.mWebTemplateView.showMiniCard();
        }
    }

    public void adShowSuccess() {
        super.adShowSuccess();
    }

    public void changeNativeCloseButton() {
        int cbd = this.adapterModel.U().getCbd();
        if (cbd < 0) {
            cbd = this.adapterModel.x().b().p();
        }
        this.mHandler.postDelayed(this.nativeCloseBtnVisibleRunnable, ((long) cbd) * 1000);
    }

    public void click(View view) {
        if (view.getId() == filterFindViewId(false, "mbridge_alertview_close_button")) {
            onClick(8);
        } else if (view.getId() == filterFindViewId(false, "mbridge_alertview_continue_button")) {
            onClick(6);
        }
        super.click(view);
    }

    public void finish(boolean z4) {
        try {
            releaseSource();
            if (z4) {
                ((Activity) this.context).finish();
                d.a().d(f.SHOW_OR_PRELOAD_WEB_EC);
            }
            d.a().a(this.adapterModel.G());
        } catch (Throwable th) {
            af.b("PlayWebPresenter", th.getMessage());
        }
    }

    public int getCampaignOrientation() {
        try {
            if (this.adapterModel.U() != null) {
                return this.adapterModel.U().getRewardTemplateMode().b();
            }
            return 0;
        } catch (Throwable th) {
            af.b("PlayWebPresenter", th.getMessage());
            return 0;
        }
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
        this.mWebTemplateView.initViews(false);
        if (this.campaignEx.getVideoUrlEncode() != null) {
            File g5 = this.adapterModel.g(this.campaignEx.getRequestIdNotice());
            if (this.campaignEx.getVst() > -2) {
                this.videoSkipTime = this.campaignEx.getVst();
            } else {
                this.videoSkipTime = this.adapterModel.x().b().e();
            }
            this.videoCompleteTime = this.campaignEx.getVideoCompleteTime();
            if (g5 == null || !g5.exists()) {
                this.mWebTemplateView.play(this.campaignEx.getVideoUrlEncode(), getBufferTimeout());
            } else {
                this.mWebTemplateView.play(g5.getAbsolutePath(), getBufferTimeout());
            }
        }
        ak.a(1, this.mWebTemplateView.getPrivacyButton(), this.adapterModel.U(), this.context, false, new a() {
            public void close() {
                PlayWebPresenter.this.mWebTemplateView.playOrPauseVideo(1);
            }

            public void showed() {
                PlayWebPresenter.this.onPause();
            }

            public void summit(String str) {
                PlayWebPresenter.this.mWebTemplateView.playOrPauseVideo(1);
            }
        });
        com.mbridge.msdk.newreward.a.e eVar = this.adapterModel;
        if (eVar != null && eVar.aj().equals("WEB_EC")) {
            com.mbridge.msdk.newreward.function.command.c cVar = this.commandManager;
            cVar.i(cVar.a("web_resource_action", 1, "parent_temple", this.data.getRootViewGroup(), "adapter_model", this.adapterModel, "bridge_ids", this.campaignEx.getRequestIdNotice()), f.SHOW_OR_PRELOAD_WEB_EC);
        }
    }

    public void onBackPressed() {
        if (this.mCanResponseBackPress) {
            onClick(2);
        }
    }

    public void onClick(int i5) {
        if (isIVRewardEnable()) {
            this.adapterModel.b(this.ivRewardAlertViewStatus);
        }
        if (i5 == 2) {
            onCloseButtonClick();
        }
        if (i5 == 5) {
            if (this.iView.getMuteState()) {
                this.playTempleModel.eventTrackingForUnMute(this.redirectModel);
                this.muteState = false;
            } else {
                this.playTempleModel.eventTrackingForMute(this.redirectModel);
                this.muteState = true;
            }
            this.mWebTemplateView.setMuteState(this.muteState);
        }
        if ((i5 == 1 || i5 == 3) && this.mNativeHandleClick) {
            CampaignEx campaignEx = this.campaignEx;
            if (campaignEx != null) {
                campaignEx.setClickTempSource(com.mbridge.msdk.foundation.same.report.d.a.f9450g);
                if (i5 == 1) {
                    this.campaignEx.setTriggerClickSource(com.mbridge.msdk.foundation.same.report.d.a.f9457n);
                } else {
                    this.campaignEx.setTriggerClickSource(com.mbridge.msdk.foundation.same.report.d.a.f9456m);
                }
            }
            this.playTempleModel.onAdClick(this.mBridgeIds);
            this.playTempleModel.eventClickUrl(this.redirectModel);
            this.playTempleModel.eventTrackingForClick(this.redirectModel);
            return;
        }
        MBCommunicatorUtil.notifyClick(this.mWebTemplateView.getWebView(), i5, com.mbridge.msdk.newreward.function.h.b.a(this.mTouchX, this.mTouchY, 0));
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            releaseSource();
            d.a().a(this.adapterModel.G());
            d.a().d(f.SHOW_OR_PRELOAD_WEB_EC);
        } catch (Throwable th) {
            af.b("PlayWebPresenter", th.getMessage());
        }
    }

    public void onDetachedFromWindow() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.nativeCloseBtnVisibleRunnable);
        }
    }

    public void onPlayCompleted() {
        super.onPlayCompleted();
        MBCommunicatorUtil.notifyVideoStatus(this.mWebTemplateView.getWebView(), 1);
    }

    public void onPlayError(String str) {
        super.onPlayError(str);
        MBCommunicatorUtil.notifyVideoStatus(this.mWebTemplateView.getWebView(), 2);
    }

    public void onPlayProgress(int i5, int i6) {
        super.onPlayProgress(i5, i6);
        try {
            JSONObject jSONObject = new JSONObject();
            if (i6 == 0) {
                i6 = this.campaignEx.getVideoLength();
            }
            if (i6 == 0) {
                i6 = 1;
            }
            jSONObject.put("progress", (int) (((float) i5) / ((float) i6)));
            jSONObject.put("time", i5);
            jSONObject.put(TypedValues.TransitionType.S_DURATION, i6);
            IPlayModel iPlayModel = this.playTempleModel;
            if (iPlayModel instanceof WebTemplateModel) {
                ((WebTemplateModel) iPlayModel).setVideoProgressString(jSONObject.toString());
            }
            MBCommunicatorUtil.notifyVideoProgress(this.mWebTemplateView.getWebView(), i5, i6);
        } catch (Throwable th) {
            af.b("PlayWebPresenter", th.getMessage());
        }
    }

    public void onPlayStarted(int i5) {
        super.onPlayStarted(i5);
        MBCommunicatorUtil.notifyVideoStatus(this.mWebTemplateView.getWebView(), 0);
    }

    public void onWebContentError() {
        this.mWebTemplateView.onDestroyWebContent(this.TEMPLATE_MARK_TYPE);
        if (!this.adapterModel.Y()) {
            this.mWebTemplateView.removeTempleFromSuperView(this.data.getRootViewGroup());
        } else {
            this.webCloseViewStatus = -1;
            this.mNativeHandleClick = true;
            this.mHandler.post(this.nativeCloseBtnVisibleRunnable);
        }
        d.a().a(this.adapterModel.G());
    }

    public void onWebViewShow() {
        this.mWebTemplateView.onWebViewShow(this.TEMPLATE_MARK_TYPE);
    }

    public void releaseSource() {
        if (!this.adapterModel.ac()) {
            this.adapterModel.n(true);
            this.playTempleModel.modelReport("2000146");
        }
        this.iView.release();
    }

    public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void reqSuccessful(java.lang.Object r23) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            java.lang.String r2 = ""
            boolean r3 = r0 instanceof org.json.JSONObject     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x0248
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x0033 }
            int r3 = r0.length()     // Catch:{ all -> 0x0033 }
            if (r3 <= 0) goto L_0x0248
            java.lang.String r3 = "action"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x0033 }
            int r4 = r3.hashCode()     // Catch:{ all -> 0x0033 }
            r5 = 4
            r6 = 8
            r7 = 0
            r8 = 2
            r9 = -1
            r10 = 1
            switch(r4) {
                case -1765453640: goto L_0x00ab;
                case -1488920312: goto L_0x00a1;
                case -1410229111: goto L_0x0097;
                case -1258199123: goto L_0x008d;
                case 94750088: goto L_0x0082;
                case 94756344: goto L_0x0078;
                case 96046965: goto L_0x006e;
                case 131169903: goto L_0x0063;
                case 181688693: goto L_0x0059;
                case 1691567443: goto L_0x004e;
                case 1779467262: goto L_0x0042;
                case 1843897919: goto L_0x0036;
                case 1941013143: goto L_0x0028;
                default: goto L_0x0026;
            }     // Catch:{ all -> 0x0033 }
        L_0x0026:
            goto L_0x00b5
        L_0x0028:
            java.lang.String r4 = "progressOperate"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x00b5
            r3 = r6
            goto L_0x00b6
        L_0x0033:
            r0 = move-exception
            goto L_0x0249
        L_0x0036:
            java.lang.String r4 = "feedbackOperate"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x00b5
            r3 = 12
            goto L_0x00b6
        L_0x0042:
            java.lang.String r4 = "progressBarOperate"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x00b5
            r3 = 9
            goto L_0x00b6
        L_0x004e:
            java.lang.String r4 = "showVideoLocation"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x00b5
            r3 = 5
            goto L_0x00b6
        L_0x0059:
            java.lang.String r4 = "soundOperate"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x00b5
            r3 = 7
            goto L_0x00b6
        L_0x0063:
            java.lang.String r4 = "showVideoClickView"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x00b5
            r3 = 11
            goto L_0x00b6
        L_0x006e:
            java.lang.String r4 = "readyStatus"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x00b5
            r3 = r7
            goto L_0x00b6
        L_0x0078:
            java.lang.String r4 = "close"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x00b5
            r3 = 3
            goto L_0x00b6
        L_0x0082:
            java.lang.String r4 = "click"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x00b5
            r3 = 10
            goto L_0x00b6
        L_0x008d:
            java.lang.String r4 = "notifyCloseBtn"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x00b5
            r3 = r8
            goto L_0x00b6
        L_0x0097:
            java.lang.String r4 = "videoOperate"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x00b5
            r3 = 6
            goto L_0x00b6
        L_0x00a1:
            java.lang.String r4 = "onReceivedError"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x00b5
            r3 = r5
            goto L_0x00b6
        L_0x00ab:
            java.lang.String r4 = "toggleCloseBtn"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x00b5
            r3 = r10
            goto L_0x00b6
        L_0x00b5:
            r3 = r9
        L_0x00b6:
            r4 = -999(0xfffffffffffffc19, float:NaN)
            java.lang.String r11 = "type"
            java.lang.String r12 = "view_visible"
            java.lang.String r13 = "status"
            switch(r3) {
                case 0: goto L_0x0237;
                case 1: goto L_0x0221;
                case 2: goto L_0x020b;
                case 3: goto L_0x0205;
                case 4: goto L_0x0201;
                case 5: goto L_0x01ec;
                case 6: goto L_0x01e2;
                case 7: goto L_0x01cc;
                case 8: goto L_0x01a8;
                case 9: goto L_0x0194;
                case 10: goto L_0x017c;
                case 11: goto L_0x0174;
                case 12: goto L_0x00c3;
                default: goto L_0x00c1;
            }
        L_0x00c1:
            goto L_0x0248
        L_0x00c3:
            java.lang.String r3 = r0.optString(r11, r2)     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = r0.optString(r13, r2)     // Catch:{ all -> 0x0033 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0033 }
            if (r4 == 0) goto L_0x00d3
            goto L_0x0248
        L_0x00d3:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0033 }
            r4.<init>(r0)     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = "popup"
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x0033 }
            java.lang.String r5 = "key"
            if (r0 == 0) goto L_0x00f3
            java.lang.String r0 = r4.optString(r5, r2)     // Catch:{ all -> 0x0033 }
            int r8 = r4.optInt(r12, r10)     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.foundation.d.b r11 = com.mbridge.msdk.foundation.d.b.a()     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.foundation.d.a r13 = r1.feedbackDialogEventListener     // Catch:{ all -> 0x0033 }
            r11.a((java.lang.String) r0, (int) r8, (com.mbridge.msdk.foundation.d.a) r13)     // Catch:{ all -> 0x0033 }
        L_0x00f3:
            java.lang.String r0 = "visibility"
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0114
            int r0 = r4.optInt(r12, r10)     // Catch:{ all -> 0x0033 }
            java.lang.String r8 = r4.optString(r5, r2)     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.foundation.d.b r11 = com.mbridge.msdk.foundation.d.b.a()     // Catch:{ all -> 0x0033 }
            if (r0 != r10) goto L_0x010a
            goto L_0x010b
        L_0x010a:
            r6 = r7
        L_0x010b:
            com.mbridge.msdk.newreward.player.iview.IWebTemplateView r0 = r1.mWebTemplateView     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.newreward.player.view.hybrid.MBWebView r0 = r0.getWebView()     // Catch:{ all -> 0x0033 }
            r11.a((java.lang.String) r8, (int) r6, (android.view.ViewGroup) r0)     // Catch:{ all -> 0x0033 }
        L_0x0114:
            java.lang.String r0 = "layout"
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0248
            java.lang.String r0 = "width"
            int r12 = r4.optInt(r0, r9)     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = "height"
            int r13 = r4.optInt(r0, r9)     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = "left"
            int r0 = r4.optInt(r0, r9)     // Catch:{ all -> 0x0033 }
            java.lang.String r3 = "top"
            int r3 = r4.optInt(r3, r9)     // Catch:{ all -> 0x0033 }
            java.lang.String r6 = "opacity"
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r6 = r4.optDouble(r6, r7)     // Catch:{ all -> 0x0033 }
            java.lang.String r8 = "radius"
            r9 = 20
            int r14 = r4.optInt(r8, r9)     // Catch:{ all -> 0x0033 }
            java.lang.String r8 = "fontColor"
            java.lang.String r18 = r4.optString(r8, r2)     // Catch:{ all -> 0x0033 }
            java.lang.String r8 = "bgColor"
            java.lang.String r19 = r4.optString(r8, r2)     // Catch:{ all -> 0x0033 }
            java.lang.String r11 = r4.optString(r5, r2)     // Catch:{ all -> 0x0033 }
            java.lang.String r2 = "fontSize"
            r8 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            double r8 = r4.optDouble(r2, r8)     // Catch:{ all -> 0x0033 }
            java.lang.String r2 = "padding"
            org.json.JSONArray r21 = r4.optJSONArray(r2)     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.foundation.d.b r10 = com.mbridge.msdk.foundation.d.b.a()     // Catch:{ all -> 0x0033 }
            float r15 = (float) r0     // Catch:{ all -> 0x0033 }
            float r0 = (float) r3     // Catch:{ all -> 0x0033 }
            float r2 = (float) r6     // Catch:{ all -> 0x0033 }
            float r3 = (float) r8     // Catch:{ all -> 0x0033 }
            r16 = r0
            r17 = r2
            r20 = r3
            r10.a(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0033 }
            return
        L_0x0174:
            int r0 = r0.optInt(r11, r4)     // Catch:{ all -> 0x0033 }
            r1.showCTAOrMiniEndCard(r0)     // Catch:{ all -> 0x0033 }
            return
        L_0x017c:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.campaignEx     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0185
            int r2 = com.mbridge.msdk.foundation.same.report.d.a.f9450g     // Catch:{ all -> 0x0033 }
            r0.setClickTempSource(r2)     // Catch:{ all -> 0x0033 }
        L_0x0185:
            com.mbridge.msdk.newreward.player.imodel.IPlayModel r0 = r1.playTempleModel     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.out.MBridgeIds r2 = r1.mBridgeIds     // Catch:{ all -> 0x0033 }
            r0.onAdClick(r2)     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.newreward.player.imodel.IPlayModel r0 = r1.playTempleModel     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.newreward.player.redirect.RedirectModel r2 = r1.redirectModel     // Catch:{ all -> 0x0033 }
            r0.eventTrackingForClick(r2)     // Catch:{ all -> 0x0033 }
            return
        L_0x0194:
            org.json.JSONObject r0 = r0.optJSONObject(r13)     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0248
            int r0 = r0.optInt(r12, r8)     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.newreward.player.iview.IWebTemplateView r2 = r1.mWebTemplateView     // Catch:{ all -> 0x0033 }
            if (r0 != r10) goto L_0x01a3
            goto L_0x01a4
        L_0x01a3:
            r6 = r7
        L_0x01a4:
            r2.setSegmentsProgressBar(r6)     // Catch:{ all -> 0x0033 }
            return
        L_0x01a8:
            org.json.JSONObject r0 = r0.optJSONObject(r13)     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0248
            java.lang.String r2 = "progress"
            int r2 = r0.optInt(r2, r9)     // Catch:{ all -> 0x0033 }
            int r0 = r0.optInt(r12, r8)     // Catch:{ all -> 0x0033 }
            if (r2 == r9) goto L_0x01bf
            com.mbridge.msdk.newreward.player.iview.IWebTemplateView r3 = r1.mWebTemplateView     // Catch:{ all -> 0x0033 }
            r3.seekToPlay(r2)     // Catch:{ all -> 0x0033 }
        L_0x01bf:
            com.mbridge.msdk.newreward.player.iview.IWebTemplateView r2 = r1.mWebTemplateView     // Catch:{ all -> 0x0033 }
            android.view.View r2 = r2.getCountDownView()     // Catch:{ all -> 0x0033 }
            if (r0 != r8) goto L_0x01c8
            r5 = r7
        L_0x01c8:
            r2.setVisibility(r5)     // Catch:{ all -> 0x0033 }
            return
        L_0x01cc:
            org.json.JSONObject r0 = r0.optJSONObject(r13)     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0248
            java.lang.String r2 = "mute"
            int r2 = r0.optInt(r2, r8)     // Catch:{ all -> 0x0033 }
            int r0 = r0.optInt(r12, r8)     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.newreward.player.iview.IWebTemplateView r3 = r1.mWebTemplateView     // Catch:{ all -> 0x0033 }
            r3.setMuteState(r2, r0)     // Catch:{ all -> 0x0033 }
            return
        L_0x01e2:
            int r0 = r0.optInt(r13, r4)     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.newreward.player.iview.IWebTemplateView r2 = r1.mWebTemplateView     // Catch:{ all -> 0x0033 }
            r2.playOrPauseVideo(r0)     // Catch:{ all -> 0x0033 }
            return
        L_0x01ec:
            java.lang.String r0 = r0.optString(r13)     // Catch:{ all -> 0x0033 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0033 }
            if (r2 != 0) goto L_0x0248
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0033 }
            r2.<init>(r0)     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.newreward.player.iview.IWebTemplateView r0 = r1.mWebTemplateView     // Catch:{ all -> 0x0033 }
            r0.changeVideoViewPosition(r2)     // Catch:{ all -> 0x0033 }
            return
        L_0x0201:
            r1.onWebContentError()     // Catch:{ all -> 0x0033 }
            return
        L_0x0205:
            com.mbridge.msdk.newreward.player.iview.IWebTemplateView r0 = r1.mWebTemplateView     // Catch:{ all -> 0x0033 }
            r0.onCloseViewClick(r8)     // Catch:{ all -> 0x0033 }
            return
        L_0x020b:
            int r0 = r0.optInt(r13, r9)     // Catch:{ all -> 0x0033 }
            r1.webCloseViewStatus = r0     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0215
            if (r0 != r10) goto L_0x021c
        L_0x0215:
            android.os.Handler r2 = r1.mHandler     // Catch:{ all -> 0x0033 }
            java.lang.Runnable r3 = r1.nativeCloseBtnVisibleRunnable     // Catch:{ all -> 0x0033 }
            r2.removeCallbacks(r3)     // Catch:{ all -> 0x0033 }
        L_0x021c:
            if (r0 != r10) goto L_0x0248
            r1.mCanResponseBackPress = r10     // Catch:{ all -> 0x0033 }
            return
        L_0x0221:
            int r0 = r0.optInt(r13, r10)     // Catch:{ all -> 0x0033 }
            r1.webCloseViewStatus = r0     // Catch:{ all -> 0x0033 }
            android.os.Handler r2 = r1.mHandler     // Catch:{ all -> 0x0033 }
            java.lang.Runnable r3 = r1.nativeCloseBtnVisibleRunnable     // Catch:{ all -> 0x0033 }
            r2.removeCallbacks(r3)     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.newreward.player.iview.IWebTemplateView r2 = r1.mWebTemplateView     // Catch:{ all -> 0x0033 }
            if (r0 != r10) goto L_0x0233
            r5 = r7
        L_0x0233:
            r2.setNativeCloseButtonVisibility(r5)     // Catch:{ all -> 0x0033 }
            return
        L_0x0237:
            int r0 = r0.optInt(r13, r10)     // Catch:{ all -> 0x0033 }
            if (r0 != r10) goto L_0x0245
            com.mbridge.msdk.newreward.player.iview.IWebTemplateView r0 = r1.mWebTemplateView     // Catch:{ all -> 0x0033 }
            int r2 = r1.TEMPLATE_MARK_TYPE     // Catch:{ all -> 0x0033 }
            r0.onWebViewShow(r2)     // Catch:{ all -> 0x0033 }
            return
        L_0x0245:
            r1.onWebContentError()     // Catch:{ all -> 0x0033 }
        L_0x0248:
            return
        L_0x0249:
            java.lang.String r2 = "PlayWebPresenter"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.presenter.PlayWebPresenter.reqSuccessful(java.lang.Object):void");
    }

    public void setCanResponseBack(boolean z4) {
        this.mCanResponseBackPress = z4;
    }

    public void setNotchData(String str) {
        MBCommunicatorUtil.notifyNotchData(this.mWebTemplateView.getWebView(), str);
    }

    public void setTemplateModel(IPlayModel iPlayModel) {
        if (iPlayModel == null) {
            WebTemplateModel webTemplateModel = new WebTemplateModel(this.commandManager, this.adapterModel);
            webTemplateModel.setRenderType(this.TEMPLATE_MARK_TYPE);
            Class<WebTemplateModel> cls = WebTemplateModel.class;
            this.playTempleModel = (IPlayModel) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), new e(webTemplateModel, this.adapterModel, this.commandManager));
            return;
        }
        if (iPlayModel instanceof WebTemplateModel) {
            WebTemplateModel webTemplateModel2 = (WebTemplateModel) iPlayModel;
            webTemplateModel2.setCommandManager(this.commandManager);
            webTemplateModel2.setCallbackListener(this);
            webTemplateModel2.setRewardVideoListener(this.adapterModel.K());
        }
        this.playTempleModel = (IPlayModel) Proxy.newProxyInstance(iPlayModel.getClass().getClassLoader(), iPlayModel.getClass().getInterfaces(), new e(iPlayModel, this.adapterModel, this.commandManager));
    }
}
