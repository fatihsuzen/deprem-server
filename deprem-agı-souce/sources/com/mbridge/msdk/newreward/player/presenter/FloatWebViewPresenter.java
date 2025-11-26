package com.mbridge.msdk.newreward.player.presenter;

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.d.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.player.iview.IBaseWebView;
import com.mbridge.msdk.newreward.player.model.BaseWebContentModel;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MBCommunicatorUtil;
import com.mbridge.msdk.widget.MBAdChoice;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class FloatWebViewPresenter extends AbsPresenter implements b {
    final int EXPAND_VIEW_BUILD_TYPE;
    final int MINI_CARD_BUILD_TYPE = 3;
    private final String TAG = "MiniCardPresenter";
    boolean isLoadResourceError = false;
    boolean isShown = false;
    Handler mHandler;
    IBaseWebView mWebContentView;
    int muteState = -1;
    public Runnable nativeCloseBtnVisibleRunnable;
    int webCloseViewStatus = -1;
    BaseWebContentModel webContentModel;

    public FloatWebViewPresenter(IBaseWebView iBaseWebView, int i5) {
        super(iBaseWebView);
        int i6 = 4;
        this.EXPAND_VIEW_BUILD_TYPE = 4;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.nativeCloseBtnVisibleRunnable = new Runnable() {
            public void run() {
                FloatWebViewPresenter floatWebViewPresenter = FloatWebViewPresenter.this;
                if (floatWebViewPresenter.webCloseViewStatus == -1) {
                    floatWebViewPresenter.mWebContentView.setNativeCloseButtonVisibility(0);
                }
            }
        };
        this.mWebContentView = iBaseWebView;
        BaseWebContentModel baseWebContentModel = new BaseWebContentModel();
        this.webContentModel = baseWebContentModel;
        baseWebContentModel.setCommandManager(this.commandManager);
        this.webContentModel.setAdapterModel(this.adapterModel);
        this.webContentModel.setCallbackListener(this);
        this.TEMPLATE_MARK_TYPE = i5 != 273 ? 5 : i6;
    }

    private void addAdChoice() {
        try {
            CampaignEx campaignEx = this.campaignEx;
            if (campaignEx != null && campaignEx.getPrivacyButtonTemplateVisibility() != 0) {
                MBAdChoice mBAdChoice = new MBAdChoice(c.m().c());
                mBAdChoice.setCampaign(this.campaignEx);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ak.a(c.m().c(), 12.0f), ak.a(c.m().c(), 12.0f));
                layoutParams.gravity = 8388693;
                layoutParams.bottomMargin = 30;
                layoutParams.rightMargin = 30;
                mBAdChoice.setLayoutParams(layoutParams);
                mBAdChoice.setFeedbackDialogEventListener(new a() {
                    public void close() {
                    }

                    public void showed() {
                    }

                    public void summit(String str) {
                    }
                });
                this.mWebContentView.addViewToCurrentViewGroup(mBAdChoice);
            }
        } catch (Throwable th) {
            af.b("MiniCardPresenter", th.getMessage());
        }
    }

    private void addWaterMark(String str) {
        try {
            BitmapDrawable a5 = c.m().a(str, 296);
            if (a5 != null) {
                ImageView imageView = new ImageView(c.m().c());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                ak.a(imageView, a5, this.mWebContentView.getWebView().getResources().getDisplayMetrics());
                this.mWebContentView.addViewToCurrentViewGroup(imageView);
            }
        } catch (Throwable th) {
            af.b("MiniCardPresenter", th.getMessage());
        }
    }

    private void render(String str) {
        if (!TextUtils.isEmpty(str) && this.mWebContentView.getWebView() != null) {
            this.mWebContentView.getWebView().setHybridCommunicator(this.webContentModel);
            this.mWebContentView.getWebView().setWebViewEventListener(this.webContentModel);
            this.mWebContentView.getWebView().loadUrl(str);
        }
    }

    public void changeNativeCloseButton() {
        int cbd = this.adapterModel.U().getCbd();
        if (cbd < 0) {
            cbd = this.adapterModel.x().b().p();
        }
        this.mHandler.postDelayed(this.nativeCloseBtnVisibleRunnable, ((long) cbd) * 1000);
    }

    public void click(View view) {
        IBaseWebView iBaseWebView = this.mWebContentView;
        if (iBaseWebView != null) {
            iBaseWebView.removeTempleFromSuperView((ViewGroup) null);
        }
    }

    public void finish(boolean z4) {
        this.mWebContentView.onDestroyWebContent(this.TEMPLATE_MARK_TYPE);
    }

    public int getCampaignOrientation() {
        try {
            if (this.adapterModel.U() != null) {
                return this.adapterModel.U().getRewardTemplateMode().b();
            }
            return 0;
        } catch (Throwable th) {
            af.b("MiniCardPresenter", th.getMessage());
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

    public void initDataForView(com.mbridge.msdk.video.dynview.a aVar) {
        this.mWebContentView.initViews(false);
        addWaterMark(this.adapterModel.H());
        addAdChoice();
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
            if (str.equals("onBackPressed") && this.isShown) {
                click((View) null);
            }
        }
    }

    public void onDetachedFromWindow() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    public void onShown() {
        this.isShown = true;
    }

    public void onWebContentError() {
        if (!this.isLoadResourceError) {
            this.isLoadResourceError = true;
            this.mWebContentView.onDestroyWebContent(this.TEMPLATE_MARK_TYPE);
            this.mWebContentView.removeTempleFromSuperView(this.data.getRootViewGroup());
        }
    }

    public void releaseSource() {
    }

    public void renderMRAID(String str) {
        CampaignEx campaignEx;
        try {
            if (TextUtils.isEmpty(str) && (campaignEx = this.campaignEx) != null && !TextUtils.isEmpty(campaignEx.getMraid())) {
                str = "file:////" + this.campaignEx.getMraid();
            }
            render(str);
        } catch (Throwable th) {
            af.b("MiniCardPresenter", th.getMessage());
        }
    }

    public void renderPauseUrl() {
        try {
            if (this.adapterModel.U() != null) {
                String V4 = this.adapterModel.V();
                String str = "";
                if (!TextUtils.isEmpty(V4)) {
                    Iterator<com.mbridge.msdk.newreward.function.c.a.a> it = this.adapterModel.D().b().u().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.mbridge.msdk.newreward.function.c.a.a next = it.next();
                        if (next.g().equals(V4)) {
                            str = next.a().i();
                            break;
                        }
                    }
                }
                render(str);
            }
        } catch (Throwable th) {
            af.b("MiniCardPresenter", th.getMessage());
        }
    }

    public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void reqSuccessful(java.lang.Object r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof org.json.JSONObject     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x00c7
            org.json.JSONObject r9 = (org.json.JSONObject) r9     // Catch:{ all -> 0x002a }
            int r0 = r9.length()     // Catch:{ all -> 0x002a }
            if (r0 <= 0) goto L_0x00c7
            java.lang.String r0 = "action"
            java.lang.String r0 = r9.getString(r0)     // Catch:{ all -> 0x002a }
            int r1 = r0.hashCode()     // Catch:{ all -> 0x002a }
            r2 = 2
            r3 = 0
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 1
            switch(r1) {
                case -1765453640: goto L_0x0055;
                case -1488920312: goto L_0x004b;
                case -505277536: goto L_0x0041;
                case 94750088: goto L_0x0037;
                case 94756344: goto L_0x002d;
                case 96046965: goto L_0x0020;
                default: goto L_0x001f;
            }     // Catch:{ all -> 0x002a }
        L_0x001f:
            goto L_0x005f
        L_0x0020:
            java.lang.String r1 = "readyStatus"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x005f
            r0 = r7
            goto L_0x0060
        L_0x002a:
            r9 = move-exception
            goto L_0x00c8
        L_0x002d:
            java.lang.String r1 = "close"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x005f
            r0 = r6
            goto L_0x0060
        L_0x0037:
            java.lang.String r1 = "click"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x005f
            r0 = r4
            goto L_0x0060
        L_0x0041:
            java.lang.String r1 = "onPageFinished"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x005f
            r0 = r3
            goto L_0x0060
        L_0x004b:
            java.lang.String r1 = "onReceivedError"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x005f
            r0 = r5
            goto L_0x0060
        L_0x0055:
            java.lang.String r1 = "toggleCloseBtn"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x005f
            r0 = r2
            goto L_0x0060
        L_0x005f:
            r0 = -1
        L_0x0060:
            if (r0 == 0) goto L_0x00c0
            java.lang.String r1 = "status"
            if (r0 == r7) goto L_0x00ae
            if (r0 == r2) goto L_0x009e
            if (r0 == r6) goto L_0x0098
            if (r0 == r5) goto L_0x0094
            if (r0 == r4) goto L_0x006f
            goto L_0x00c7
        L_0x006f:
            com.mbridge.msdk.newreward.function.command.c r9 = r8.commandManager     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.newreward.player.redirect.RedirectModel r0 = r8.redirectModel     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.AD_TRACKING_CLICK_URL     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.newreward.player.redirect.RedirectModel r0 = r0.setRedirectType(r1)     // Catch:{ all -> 0x002a }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "campaign_redirect"
            r1[r3] = r2     // Catch:{ all -> 0x002a }
            r1[r7] = r0     // Catch:{ all -> 0x002a }
            java.util.Map r0 = r9.a((java.lang.Object[]) r1)     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.CAMPAIGN_REDIRECT     // Catch:{ all -> 0x002a }
            r9.f(r0, r1)     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.newout.RewardVideoListener r9 = r8.rewardVideoListener     // Catch:{ all -> 0x002a }
            if (r9 == 0) goto L_0x00c7
            com.mbridge.msdk.out.MBridgeIds r0 = r8.mBridgeIds     // Catch:{ all -> 0x002a }
            r9.onVideoAdClicked(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0094:
            r8.onWebContentError()     // Catch:{ all -> 0x002a }
            return
        L_0x0098:
            com.mbridge.msdk.newreward.player.iview.IBaseWebView r9 = r8.mWebContentView     // Catch:{ all -> 0x002a }
            r9.onCloseViewClick(r6)     // Catch:{ all -> 0x002a }
            return
        L_0x009e:
            int r9 = r9.optInt(r1, r7)     // Catch:{ all -> 0x002a }
            r8.webCloseViewStatus = r9     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.newreward.player.iview.IBaseWebView r0 = r8.mWebContentView     // Catch:{ all -> 0x002a }
            if (r9 != r7) goto L_0x00a9
            goto L_0x00aa
        L_0x00a9:
            r3 = r5
        L_0x00aa:
            r0.setNativeCloseButtonVisibility(r3)     // Catch:{ all -> 0x002a }
            return
        L_0x00ae:
            int r9 = r9.optInt(r1, r7)     // Catch:{ all -> 0x002a }
            if (r9 != r7) goto L_0x00bc
            com.mbridge.msdk.newreward.player.iview.IBaseWebView r9 = r8.mWebContentView     // Catch:{ all -> 0x002a }
            int r0 = r8.TEMPLATE_MARK_TYPE     // Catch:{ all -> 0x002a }
            r9.onWebViewShow(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x00bc:
            r8.onWebContentError()     // Catch:{ all -> 0x002a }
            return
        L_0x00c0:
            com.mbridge.msdk.newreward.player.iview.IBaseWebView r9 = r8.mWebContentView     // Catch:{ all -> 0x002a }
            int r0 = r8.TEMPLATE_MARK_TYPE     // Catch:{ all -> 0x002a }
            r9.onWebViewShow(r0)     // Catch:{ all -> 0x002a }
        L_0x00c7:
            return
        L_0x00c8:
            java.lang.String r0 = "MiniCardPresenter"
            java.lang.String r9 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.presenter.FloatWebViewPresenter.reqSuccessful(java.lang.Object):void");
    }

    public void setNotchData(String str) {
        this.webContentModel.sendNotchData(this.mWebContentView.getWebView(), str);
    }
}
