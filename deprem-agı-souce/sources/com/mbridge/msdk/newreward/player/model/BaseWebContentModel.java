package com.mbridge.msdk.newreward.player.model;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.player.view.hybrid.communicator.CommunicatorParameter;
import com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl;
import com.mbridge.msdk.newreward.player.view.hybrid.listener.WebViewEventListener;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import org.json.JSONObject;

public class BaseWebContentModel extends HybridCommunicatorImpl implements WebViewEventListener {
    private final String TAG = "BaseWebContentModel";
    e mAdapterModel;
    c mCommandManager;
    String mInitCallbackParameter;
    String mLifeCycleString = "{}";
    b mReqCallBack;
    String mVideoProgressString = "{}";
    int renderStatus;
    int renderType;

    public void click(CommunicatorParameter communicatorParameter) {
        int i5;
        super.click(communicatorParameter);
        if (communicatorParameter != null) {
            try {
                if (!TextUtils.isEmpty(communicatorParameter.getQuery()) && this.mAdapterModel != null) {
                    String str = "";
                    str = new JSONObject(communicatorParameter.getQuery()).optString("pt");
                    CampaignEx a5 = com.mbridge.msdk.newreward.function.h.b.a(str, this.mAdapterModel.D().a().get(0));
                    if (this.renderType == 3) {
                        i5 = a.f9451h;
                    } else {
                        i5 = a.f9450g;
                    }
                    a5.setClickTempSource(i5);
                    a5.setTriggerClickSource(a.f9456m);
                    new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.mAdapterModel.H()).a(a5);
                }
            } catch (Throwable th) {
                af.b("BaseWebContentModel", th.getMessage());
                return;
            }
        }
        if (this.mReqCallBack != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 0);
            this.mReqCallBack.reqSuccessful(jSONObject);
        }
    }

    public void close(CommunicatorParameter communicatorParameter) {
        super.close(communicatorParameter);
        try {
            int optInt = new JSONObject(communicatorParameter.getQuery()).optInt(MRAIDCommunicatorUtil.KEY_STATE);
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, optInt);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
        } catch (Throwable th) {
            af.b("BaseWebContentModel", CampaignEx.JSON_NATIVE_VIDEO_CLOSE, th);
        }
    }

    public void expand(CommunicatorParameter communicatorParameter) {
        int i5;
        super.expand(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                JSONObject jSONObject = new JSONObject(communicatorParameter.getQuery());
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("shouldUseCustomClose");
                af.b("BaseWebContentModel", "MRAID expand " + optString + " " + optString2);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    boolean equalsIgnoreCase = optString2.equalsIgnoreCase("true");
                    if (this.mReqCallBack != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("action", "expand");
                        jSONObject2.put("url", optString);
                        if (equalsIgnoreCase) {
                            i5 = 1;
                        } else {
                            i5 = 2;
                        }
                        jSONObject2.put("shouldUseCustomClose", i5);
                        this.mReqCallBack.reqSuccessful(jSONObject2);
                    }
                }
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "MRAID expand", th);
            }
        }
    }

    public void feedbackLayoutOperate(CommunicatorParameter communicatorParameter) {
        super.feedbackLayoutOperate(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                if (this.mReqCallBack != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "feedbackOperate");
                    jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, TtmlNode.TAG_LAYOUT);
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, communicatorParameter.getQuery());
                    this.mReqCallBack.reqSuccessful(jSONObject);
                }
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "feedbackLayoutOperate", th);
            }
        }
    }

    public void feedbackOperate(CommunicatorParameter communicatorParameter) {
        super.feedbackOperate(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                if (this.mReqCallBack != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "feedbackOperate");
                    jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "visibility");
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, communicatorParameter.getQuery());
                    this.mReqCallBack.reqSuccessful(jSONObject);
                }
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "feedbackOperate", th);
            }
        }
    }

    public void feedbackPopupOperate(CommunicatorParameter communicatorParameter) {
        super.feedbackPopupOperate(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                if (this.mReqCallBack != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "feedbackOperate");
                    jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "popup");
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, communicatorParameter.getQuery());
                    this.mReqCallBack.reqSuccessful(jSONObject);
                }
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "feedbackPopupOperate", th);
            }
        }
    }

    public void getCurrentProgress(CommunicatorParameter communicatorParameter) {
        super.getCurrentProgress(communicatorParameter);
        if (communicatorParameter != null) {
            try {
                if (!TextUtils.isEmpty(this.mVideoProgressString)) {
                    callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), Base64.encodeToString(this.mVideoProgressString.getBytes(), 2));
                }
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "isSystemResume", th);
                callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
            }
        }
    }

    public void getEndScreenInfo(CommunicatorParameter communicatorParameter) {
        super.getEndScreenInfo(communicatorParameter);
        String a5 = com.mbridge.msdk.newreward.function.h.b.a(this.mAdapterModel.H(), this.mAdapterModel.D().a(), this.mAdapterModel.n(), this.mAdapterModel.O());
        if (!TextUtils.isEmpty(a5)) {
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), Base64.encodeToString(a5.getBytes(), 2));
        }
    }

    public String getH5InitCallbackParameter() {
        return this.mInitCallbackParameter;
    }

    public int getRenderStatus() {
        return this.renderStatus;
    }

    public void handlerH5Exception(CommunicatorParameter communicatorParameter) {
        super.handlerH5Exception(communicatorParameter);
        try {
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "onReceivedError");
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 0);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
            this.renderStatus = 1;
        } catch (Throwable th) {
            af.b("BaseWebContentModel", th.getMessage());
        }
    }

    public void init(CommunicatorParameter communicatorParameter) {
        super.init(communicatorParameter);
        String a5 = com.mbridge.msdk.newreward.function.h.b.a(this.mAdapterModel.H(), this.mAdapterModel.D().a(), this.mAdapterModel.n(), this.mAdapterModel.O());
        if (!TextUtils.isEmpty(a5)) {
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), Base64.encodeToString(a5.getBytes(), 2));
        }
        if (!TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                this.mInitCallbackParameter = communicatorParameter.getQuery();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", communicatorParameter.getPath());
                jSONObject.put("parameter", communicatorParameter.getQuery());
                b bVar = this.mReqCallBack;
                if (bVar != null) {
                    bVar.reqSuccessful(jSONObject);
                }
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "init", th);
            }
        }
    }

    public void install(CommunicatorParameter communicatorParameter) {
        int i5;
        super.install(communicatorParameter);
        if (communicatorParameter != null) {
            try {
                if (!TextUtils.isEmpty(communicatorParameter.getQuery()) && this.mAdapterModel != null) {
                    CampaignEx a5 = com.mbridge.msdk.newreward.function.h.b.a(communicatorParameter.getQuery(), this.mAdapterModel.D().a().get(0));
                    if (this.renderType == 3) {
                        i5 = a.f9451h;
                    } else {
                        i5 = a.f9450g;
                    }
                    a5.setClickTempSource(i5);
                    a5.setTriggerClickSource(a.f9456m);
                    new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.mAdapterModel.H()).a(a5);
                }
            } catch (Throwable th) {
                af.b("BaseWebContentModel", th.getMessage());
                return;
            }
        }
        if (this.mReqCallBack != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 0);
            this.mReqCallBack.reqSuccessful(jSONObject);
        }
    }

    public void isSystemResume(CommunicatorParameter communicatorParameter) {
        super.isSystemResume(communicatorParameter);
        if (communicatorParameter != null) {
            try {
                if (!TextUtils.isEmpty(this.mLifeCycleString)) {
                    callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), Base64.encodeToString(this.mLifeCycleString.getBytes(), 2));
                }
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "isSystemResume", th);
                callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
            }
        }
    }

    public void ivRewardAdsWithoutVideo(CommunicatorParameter communicatorParameter) {
        super.ivRewardAdsWithoutVideo(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                if (this.mReqCallBack != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "ivRewardAdsWithoutVideo");
                    if (!TextUtils.isEmpty(communicatorParameter.getQuery())) {
                        JSONObject jSONObject2 = new JSONObject(communicatorParameter.getQuery());
                        int optInt = jSONObject2.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                        int optInt2 = jSONObject2.optInt(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
                        jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, optInt);
                        jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, optInt2);
                    }
                    this.mReqCallBack.reqSuccessful(jSONObject);
                }
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "ivRewardAdsWithoutVideo", th);
            }
        }
    }

    public void loadingResourceStatus(WebView webView, int i5) {
    }

    public void notifyCloseBtn(CommunicatorParameter communicatorParameter) {
        super.notifyCloseBtn(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                int optInt = new JSONObject(communicatorParameter.getQuery()).optInt(MRAIDCommunicatorUtil.KEY_STATE);
                if (this.mReqCallBack != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", communicatorParameter.getPath());
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, optInt);
                    this.mReqCallBack.reqSuccessful(jSONObject);
                }
                callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "notifyCloseBtn", th);
                callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
            }
        }
    }

    public void onJSBridgeConnect(CommunicatorParameter communicatorParameter) {
        super.onJSBridgeConnect(communicatorParameter);
        onSignalCommunicationConnected(communicatorParameter.getWebView());
    }

    public void onPageFinished(WebView webView, String str) {
        onSignalCommunicationConnected(webView);
        try {
            if (this.renderStatus != 1) {
                this.renderStatus = 2;
            }
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "onPageFinished");
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 0);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
        } catch (Throwable th) {
            af.b("BaseWebContentModel", th.getMessage());
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
    }

    public void onProgressChanged(WebView webView, int i5) {
    }

    public void onReceivedError(WebView webView, int i5, String str, String str2) {
        try {
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "onReceivedError");
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 0);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
            this.renderStatus = 1;
        } catch (Throwable th) {
            af.b("BaseWebContentModel", th.getMessage());
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    public void onRenderProcessGone(WebView webView) {
        try {
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "onReceivedError");
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 0);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
            this.renderStatus = 1;
        } catch (Throwable th) {
            af.b("BaseWebContentModel", th.getMessage());
        }
    }

    public void open(CommunicatorParameter communicatorParameter) {
        super.open(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                String optString = new JSONObject(communicatorParameter.getQuery()).optString("url");
                if (!TextUtils.isEmpty(optString)) {
                    if (this.mAdapterModel.D().b().u().size() > 1) {
                        com.mbridge.msdk.foundation.controller.c.m().c().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(optString)));
                    } else {
                        JSONObject campaignToJsonObject = CampaignEx.campaignToJsonObject(this.mAdapterModel.U());
                        if (campaignToJsonObject != null) {
                            CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(campaignToJsonObject);
                            parseCampaignWithBackData.setClickURL(optString);
                            parseCampaignWithBackData.setClickTempSource(a.f9451h);
                            parseCampaignWithBackData.setTriggerClickSource(a.f9457n);
                            new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.mAdapterModel.H()).a(parseCampaignWithBackData);
                        }
                    }
                }
                if (this.mReqCallBack != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 0);
                    this.mReqCallBack.reqSuccessful(jSONObject);
                }
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "open", th);
            }
        }
    }

    public void progressBarOperate(CommunicatorParameter communicatorParameter) {
        super.progressBarOperate(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                JSONObject jSONObject = new JSONObject(communicatorParameter.getQuery());
                if (this.mReqCallBack != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("action", "progressBarOperate");
                    jSONObject2.put(NotificationCompat.CATEGORY_STATUS, jSONObject);
                    this.mReqCallBack.reqSuccessful(jSONObject2);
                }
                callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "progressBarOperate", th);
                callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
            }
        }
    }

    public void progressOperate(CommunicatorParameter communicatorParameter) {
        super.progressOperate(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                JSONObject jSONObject = new JSONObject(communicatorParameter.getQuery());
                if (this.mReqCallBack != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("action", "progressOperate");
                    jSONObject2.put(NotificationCompat.CATEGORY_STATUS, jSONObject);
                    this.mReqCallBack.reqSuccessful(jSONObject2);
                }
                callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "progressOperate", th);
                callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
            }
        }
    }

    public void readyStatus(CommunicatorParameter communicatorParameter) {
        int i5;
        super.readyStatus(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                int i6 = 1;
                int optInt = new JSONObject(communicatorParameter.getQuery()).optInt("isReady", 1);
                if (optInt == 1) {
                    i5 = 3;
                } else {
                    i5 = 4;
                }
                this.renderStatus = i5;
                callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
                if (this.mReqCallBack != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", communicatorParameter.getPath());
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, optInt);
                    this.mReqCallBack.reqSuccessful(jSONObject);
                }
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                if (optInt != 1) {
                    i6 = 2;
                }
                eVar.a("result", Integer.valueOf(i6));
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(this.renderType));
                this.mAdapterModel.z().a(this.mAdapterModel, eVar.a(), "2000155");
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "readyStatus", th);
            }
        }
    }

    public void setAdapterModel(e eVar) {
        this.mAdapterModel = eVar;
    }

    public void setCallbackListener(b bVar) {
        this.mReqCallBack = bVar;
    }

    public void setCommandManager(c cVar) {
        this.mCommandManager = cVar;
    }

    public void setLifeCycleString(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mLifeCycleString = str;
        }
    }

    public void setRenderStatus(int i5) {
        this.renderStatus = i5;
    }

    public void setRenderType(int i5) {
        this.renderType = i5;
    }

    public void setVideoProgressString(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mVideoProgressString = str;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return false;
    }

    public void showVideoClickView(CommunicatorParameter communicatorParameter) {
        super.showVideoClickView(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                int optInt = new JSONObject(communicatorParameter.getQuery()).optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                if (this.mReqCallBack != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "showVideoClickView");
                    jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, optInt);
                    this.mReqCallBack.reqSuccessful(jSONObject);
                }
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "showVideoClickView", th);
            }
        }
    }

    public void showVideoLocation(CommunicatorParameter communicatorParameter) {
        super.showVideoLocation(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                if (this.mReqCallBack != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "showVideoLocation");
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, communicatorParameter.getQuery());
                    this.mReqCallBack.reqSuccessful(jSONObject);
                }
                callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "showVideoLocation", th);
                callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
            }
        }
    }

    public void soundOperate(CommunicatorParameter communicatorParameter) {
        super.soundOperate(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                JSONObject jSONObject = new JSONObject(communicatorParameter.getQuery());
                if (this.mReqCallBack != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("action", "soundOperate");
                    jSONObject2.put(NotificationCompat.CATEGORY_STATUS, jSONObject);
                    this.mReqCallBack.reqSuccessful(jSONObject2);
                }
                callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "soundOperate", th);
                callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
            }
        }
    }

    public void statistics(CommunicatorParameter communicatorParameter) {
        super.statistics(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
            try {
                JSONObject jSONObject = new JSONObject(communicatorParameter.getQuery());
                final String optString = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, NotificationCompat.CATEGORY_EVENT);
                final String optString2 = jSONObject.optString("template", "-1");
                final String optString3 = jSONObject.optString(TtmlNode.TAG_LAYOUT, "-1");
                final String optString4 = jSONObject.optString(MBridgeConstans.PROPERTIES_UNIT_ID, this.mAdapterModel.H());
                final int m5 = ab.m(com.mbridge.msdk.foundation.controller.c.m().c());
                com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() {
                    public void run() {
                        o.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(new n("2000039", optString, optString2, optString3, optString4, BaseWebContentModel.this.mAdapterModel.U().getId(), m5, ab.a(com.mbridge.msdk.foundation.controller.c.m().c(), m5)));
                    }
                });
            } catch (Throwable th) {
                af.b("BaseWebContentModel", th.getMessage());
            }
        }
    }

    public void toggleCloseBtn(CommunicatorParameter communicatorParameter) {
        super.toggleCloseBtn(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                int optInt = new JSONObject(communicatorParameter.getQuery()).optInt(MRAIDCommunicatorUtil.KEY_STATE);
                if (this.mReqCallBack != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", communicatorParameter.getPath());
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, optInt);
                    this.mReqCallBack.reqSuccessful(jSONObject);
                }
                callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "toggleCloseBtn", th);
                callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
            }
        }
    }

    public void triggerCloseBtn(CommunicatorParameter communicatorParameter) {
        super.triggerCloseBtn(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                int optInt = new JSONObject(communicatorParameter.getQuery()).optInt(MRAIDCommunicatorUtil.KEY_STATE);
                if (this.mReqCallBack != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, optInt);
                    this.mReqCallBack.reqSuccessful(jSONObject);
                }
                callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "triggerCloseBtn", th);
                callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
            }
        }
    }

    public void unload(CommunicatorParameter communicatorParameter) {
        super.unload(communicatorParameter);
        close(communicatorParameter);
    }

    public void useCustomClose(CommunicatorParameter communicatorParameter) {
        int i5;
        super.useCustomClose(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                String optString = new JSONObject(communicatorParameter.getQuery()).optString("shouldUseCustomClose");
                af.b("BaseWebContentModel", "MRAID useCustomClose " + optString);
                if (!TextUtils.isEmpty(optString)) {
                    boolean equalsIgnoreCase = optString.equalsIgnoreCase("true");
                    if (this.mReqCallBack != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("action", "toggleCloseBtn");
                        if (equalsIgnoreCase) {
                            i5 = 1;
                        } else {
                            i5 = 2;
                        }
                        jSONObject.put(NotificationCompat.CATEGORY_STATUS, i5);
                        this.mReqCallBack.reqSuccessful(jSONObject);
                    }
                }
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "MRAID useCustomClose", th);
            }
        }
    }

    public void videoOperate(CommunicatorParameter communicatorParameter) {
        super.videoOperate(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                int optInt = new JSONObject(communicatorParameter.getQuery()).optInt("pause_or_resume");
                if (this.mReqCallBack != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "videoOperate");
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, optInt);
                    this.mReqCallBack.reqSuccessful(jSONObject);
                }
                callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "videoOperate", th);
                callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
            }
        }
    }

    public void loadingResourceStatus(CommunicatorParameter communicatorParameter) {
        super.loadingResourceStatus(communicatorParameter);
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                int optInt = new JSONObject(communicatorParameter.getQuery()).optInt("isReady", 1);
                this.renderStatus = optInt == 1 ? 3 : 4;
                callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
                if (this.mReqCallBack != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", communicatorParameter.getPath());
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, optInt);
                    this.mReqCallBack.reqSuccessful(jSONObject);
                }
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "readyStatus", th);
            }
        }
    }
}
