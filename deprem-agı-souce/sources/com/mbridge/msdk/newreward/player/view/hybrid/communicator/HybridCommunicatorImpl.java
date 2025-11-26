package com.mbridge.msdk.newreward.player.view.hybrid.communicator;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a.b;
import com.mbridge.msdk.foundation.same.f.a;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MBCommunicatorUtil;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import org.json.JSONArray;
import org.json.JSONObject;

public class HybridCommunicatorImpl implements HybridCommunicator {
    private final String TAG = "HybridCommunicatorImpl";

    public void appendSubView(CommunicatorParameter communicatorParameter) {
    }

    public void appendViewTo(CommunicatorParameter communicatorParameter) {
    }

    public void bringViewToFront(CommunicatorParameter communicatorParameter) {
    }

    public void broadcast(CommunicatorParameter communicatorParameter) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("message", "NOT IMPLEMENTATION");
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            af.a("HybridCommunicatorImpl", e5.getMessage());
        }
    }

    public void cai(CommunicatorParameter communicatorParameter) {
    }

    public void callFailure(WebView webView, String str, String str2) {
        if (webView != null) {
            MBCommunicatorUtil.callFailure(webView, str, str2);
        }
    }

    public void callNotSupportMethod(CommunicatorParameter communicatorParameter) {
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getScheme()) && communicatorParameter.getScheme().equals(CampaignEx.JSON_KEY_MRAID)) {
            MRAIDCommunicatorUtil.fireNativeMethodCompleteEvent(communicatorParameter.getWebView(), communicatorParameter.getPath());
            MRAIDCommunicatorUtil.fireErrorEvent(communicatorParameter.getWebView(), communicatorParameter.getPath(), "Specified command is not implemented");
        }
    }

    public void callSuccess(WebView webView, String str, String str2) {
        if (webView != null) {
            MBCommunicatorUtil.callSuccess(webView, str, str2);
        }
    }

    public void clearAllCache(CommunicatorParameter communicatorParameter) {
    }

    public void click(CommunicatorParameter communicatorParameter) {
    }

    public void close(CommunicatorParameter communicatorParameter) {
        if (communicatorParameter != null) {
            MRAIDCommunicatorUtil.fireNativeMethodCompleteEvent(communicatorParameter.getWebView(), CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
        }
    }

    public void closeAd(CommunicatorParameter communicatorParameter) {
    }

    public void closeVideoOperte(CommunicatorParameter communicatorParameter) {
    }

    public void closeWeb(CommunicatorParameter communicatorParameter) {
    }

    public void createNativeEC(CommunicatorParameter communicatorParameter) {
    }

    public void createPlayerView(CommunicatorParameter communicatorParameter) {
    }

    public void createSubPlayTemplateView(CommunicatorParameter communicatorParameter) {
    }

    public void createView(CommunicatorParameter communicatorParameter) {
    }

    public void createWebview(CommunicatorParameter communicatorParameter) {
    }

    public void destroyComponent(CommunicatorParameter communicatorParameter) {
    }

    public void expand(CommunicatorParameter communicatorParameter) {
        if (communicatorParameter != null) {
            MRAIDCommunicatorUtil.fireNativeMethodCompleteEvent(communicatorParameter.getWebView(), "expand");
        }
    }

    public void feedbackLayoutOperate(CommunicatorParameter communicatorParameter) {
        if (communicatorParameter != null) {
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), "");
        }
    }

    public void feedbackOperate(CommunicatorParameter communicatorParameter) {
        if (communicatorParameter != null) {
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), "");
        }
    }

    public void feedbackPopupOperate(CommunicatorParameter communicatorParameter) {
        if (communicatorParameter != null) {
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), "");
        }
    }

    public void fireEvent(WebView webView, String str, String str2) {
        if (webView != null) {
            MBCommunicatorUtil.fireEvent(webView, str, str2);
        }
    }

    public void getAllCache(CommunicatorParameter communicatorParameter) {
    }

    public void getAppSetting(CommunicatorParameter communicatorParameter) {
    }

    public void getComponentOptions(CommunicatorParameter communicatorParameter) {
    }

    public void getCurrentProgress(CommunicatorParameter communicatorParameter) {
    }

    public void getCutout(CommunicatorParameter communicatorParameter) {
    }

    public void getEncryptPrice(CommunicatorParameter communicatorParameter) {
    }

    public void getEndScreenInfo(CommunicatorParameter communicatorParameter) {
    }

    public void getFileInfo(CommunicatorParameter communicatorParameter) {
    }

    public void getNetstat(CommunicatorParameter communicatorParameter) {
    }

    public void getRewardSetting(CommunicatorParameter communicatorParameter) {
    }

    public void getRewardUnitSetting(CommunicatorParameter communicatorParameter) {
    }

    public void getSDKInfo(CommunicatorParameter communicatorParameter) {
    }

    public void getUnitSetting(CommunicatorParameter communicatorParameter) {
    }

    public void gial(CommunicatorParameter communicatorParameter) {
    }

    public void handleNativeObject(CommunicatorParameter communicatorParameter) {
    }

    public void handlerH5Exception(CommunicatorParameter communicatorParameter) {
    }

    public void handlerPlayableException(CommunicatorParameter communicatorParameter) {
    }

    public void hideView(CommunicatorParameter communicatorParameter) {
    }

    public void increaseOfferFrequence(CommunicatorParameter communicatorParameter) {
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                JSONObject jSONObject = new JSONObject(communicatorParameter.getQuery());
                if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                    callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), "H5 transfer data is empty");
                    return;
                }
                final CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObject);
                if (parseCampaignWithBackData == null) {
                    MBCommunicatorUtil.callException(communicatorParameter.getWebView(), communicatorParameter.getToken(), "H5 transfer campaign is empty");
                    return;
                }
                a.b().execute(new Runnable() {
                    public void run() {
                        j a5 = j.a((f) g.a(c.m().c()));
                        if (a5 != null) {
                            if (!a5.b(parseCampaignWithBackData.getId())) {
                                com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                                gVar.a(parseCampaignWithBackData.getId());
                                gVar.b(parseCampaignWithBackData.getFca());
                                gVar.c(parseCampaignWithBackData.getFcb());
                                gVar.a(0);
                                gVar.d(1);
                                gVar.a(System.currentTimeMillis());
                                a5.a(gVar);
                            } else {
                                a5.a(parseCampaignWithBackData.getId());
                            }
                        }
                        if (b.f9220j != null && !TextUtils.isEmpty(parseCampaignWithBackData.getId())) {
                            b.a(parseCampaignWithBackData.getCampaignUnitId(), parseCampaignWithBackData, "reward");
                        }
                    }
                });
                callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), "");
            } catch (Throwable th) {
                MBCommunicatorUtil.callException(communicatorParameter.getWebView(), communicatorParameter.getToken(), th.getMessage());
            }
        }
    }

    public void init(CommunicatorParameter communicatorParameter) {
    }

    public void insertViewAbove(CommunicatorParameter communicatorParameter) {
    }

    public void insertViewBelow(CommunicatorParameter communicatorParameter) {
    }

    public void install(CommunicatorParameter communicatorParameter) {
    }

    public void isSystemResume(CommunicatorParameter communicatorParameter) {
    }

    public void ivRewardAdsWithoutVideo(CommunicatorParameter communicatorParameter) {
    }

    public void loadads(CommunicatorParameter communicatorParameter) {
    }

    public void loadingResourceStatus(CommunicatorParameter communicatorParameter) {
    }

    public void notifyCloseBtn(CommunicatorParameter communicatorParameter) {
    }

    public void onJSBridgeConnect(CommunicatorParameter communicatorParameter) {
    }

    public void onSignalCommunicationConnected(WebView webView) {
        String a5 = z.a("YFPpVTzBLkxgHVfXYrPQDbxQHv==");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("api_version", "1.0.0");
            fireEvent(webView, a5, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception unused) {
            fireEvent(webView, a5, "");
        } catch (Throwable unused2) {
            fireEvent(webView, a5, "");
        }
    }

    public void onlyAppendSubView(CommunicatorParameter communicatorParameter) {
    }

    public void onlyAppendViewTo(CommunicatorParameter communicatorParameter) {
    }

    public void onlyInsertViewAbove(CommunicatorParameter communicatorParameter) {
    }

    public void onlyInsertViewBelow(CommunicatorParameter communicatorParameter) {
    }

    public void open(CommunicatorParameter communicatorParameter) {
        if (communicatorParameter != null) {
            MRAIDCommunicatorUtil.fireNativeMethodCompleteEvent(communicatorParameter.getWebView(), "open");
        }
    }

    public void openURL(CommunicatorParameter communicatorParameter) {
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                JSONObject jSONObject = new JSONObject(communicatorParameter.getQuery());
                String optString = jSONObject.optString("url");
                int optInt = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                if (optInt == 1) {
                    com.mbridge.msdk.click.c.d(c.m().c(), optString);
                } else if (optInt == 2) {
                    com.mbridge.msdk.click.c.f(c.m().c(), optString);
                }
            } catch (Throwable th) {
                af.b("HybridCommunicatorImpl", th.getMessage());
            }
        }
    }

    public void playVideoFinishOperate(CommunicatorParameter communicatorParameter) {
    }

    public void playerGetMuteState(CommunicatorParameter communicatorParameter) {
    }

    public void playerMute(CommunicatorParameter communicatorParameter) {
    }

    public void playerPause(CommunicatorParameter communicatorParameter) {
    }

    public void playerPlay(CommunicatorParameter communicatorParameter) {
    }

    public void playerResume(CommunicatorParameter communicatorParameter) {
    }

    public void playerSetRenderType(CommunicatorParameter communicatorParameter) {
    }

    public void playerSetSource(CommunicatorParameter communicatorParameter) {
    }

    public void playerStop(CommunicatorParameter communicatorParameter) {
    }

    public void playerUnmute(CommunicatorParameter communicatorParameter) {
    }

    public void playerUpdateFrame(CommunicatorParameter communicatorParameter) {
    }

    public void preloadSubPlayTemplateView(CommunicatorParameter communicatorParameter) {
    }

    public void progressBarOperate(CommunicatorParameter communicatorParameter) {
    }

    public void progressOperate(CommunicatorParameter communicatorParameter) {
    }

    public void reactDeveloper(CommunicatorParameter communicatorParameter) {
    }

    public void readyStatus(CommunicatorParameter communicatorParameter) {
    }

    public void removeCacheItem(CommunicatorParameter communicatorParameter) {
    }

    public void removeFromSuperView(CommunicatorParameter communicatorParameter) {
    }

    public void reportData(CommunicatorParameter communicatorParameter) {
    }

    public void reportUrls(CommunicatorParameter communicatorParameter) {
        boolean z4;
        boolean z5;
        if (communicatorParameter != null && !TextUtils.isEmpty(communicatorParameter.getQuery())) {
            try {
                JSONArray jSONArray = new JSONArray(communicatorParameter.getQuery());
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i5);
                    int optInt = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                    String a5 = ak.a(jSONObject.optString("url"), "&tun=", ab.q() + "");
                    int optInt2 = jSONObject.optInt("report");
                    if (optInt2 == 0) {
                        Context c5 = c.m().c();
                        if (optInt != 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        com.mbridge.msdk.click.a.a(c5, (CampaignEx) null, "", a5, false, z5);
                    } else {
                        Context c6 = c.m().c();
                        if (optInt != 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        com.mbridge.msdk.click.a.a(c6, (CampaignEx) null, "", a5, false, z4, optInt2);
                    }
                }
                callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), "");
            } catch (Throwable th) {
                af.b("HybridCommunicatorImpl", "reportUrls", th);
                callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
            }
        }
    }

    public void resetCountdown(CommunicatorParameter communicatorParameter) {
    }

    public void sendImpressions(CommunicatorParameter communicatorParameter) {
    }

    public void sendNotchData(WebView webView, String str) {
        MBCommunicatorUtil.notifyNotchData(webView, str);
    }

    public void setCacheItem(CommunicatorParameter communicatorParameter) {
    }

    public void setOrientation(CommunicatorParameter communicatorParameter) {
    }

    public void setOrientationProperties(CommunicatorParameter communicatorParameter) {
        String str;
        if (communicatorParameter != null) {
            MRAIDCommunicatorUtil.fireNativeMethodCompleteEvent(communicatorParameter.getWebView(), "setOrientationProperties");
            if (communicatorParameter.getQuery() != null) {
                try {
                    JSONObject jSONObject = new JSONObject(communicatorParameter.getQuery());
                    String optString = jSONObject.optString("allowOrientationChange");
                    String optString2 = jSONObject.optString("forceOrientation");
                    af.b("HybridCommunicatorImpl", "MRAID setOrientationProperties");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        optString.toLowerCase().equals("true");
                        String lowerCase = optString2.toLowerCase();
                        int hashCode = lowerCase.hashCode();
                        if (hashCode == 729267099) {
                            str = "portrait";
                        } else if (hashCode == 1430647483) {
                            str = "landscape";
                        } else {
                            return;
                        }
                        lowerCase.equals(str);
                    }
                } catch (Throwable th) {
                    af.b("HybridCommunicatorImpl", "MRAID setOrientationProperties", th);
                }
            }
        }
    }

    public void setScaleFitXY(CommunicatorParameter communicatorParameter) {
    }

    public void setSubPlayTemplateInfo(CommunicatorParameter communicatorParameter) {
    }

    public void setViewAlpha(CommunicatorParameter communicatorParameter) {
    }

    public void setViewBgColor(CommunicatorParameter communicatorParameter) {
    }

    public void setViewRect(CommunicatorParameter communicatorParameter) {
    }

    public void setViewScale(CommunicatorParameter communicatorParameter) {
    }

    public void showAlertView(CommunicatorParameter communicatorParameter) {
    }

    public void showVideoClickView(CommunicatorParameter communicatorParameter) {
    }

    public void showVideoLocation(CommunicatorParameter communicatorParameter) {
    }

    public void showView(CommunicatorParameter communicatorParameter) {
    }

    public void soundOperate(CommunicatorParameter communicatorParameter) {
    }

    public void statistics(CommunicatorParameter communicatorParameter) {
    }

    public void toggleCloseBtn(CommunicatorParameter communicatorParameter) {
    }

    public void triggerCloseBtn(CommunicatorParameter communicatorParameter) {
    }

    public void unload(CommunicatorParameter communicatorParameter) {
        if (communicatorParameter != null) {
            MRAIDCommunicatorUtil.fireNativeMethodCompleteEvent(communicatorParameter.getWebView(), "unload");
        }
    }

    public void useCustomClose(CommunicatorParameter communicatorParameter) {
        if (communicatorParameter != null) {
            MRAIDCommunicatorUtil.fireNativeMethodCompleteEvent(communicatorParameter.getWebView(), "useCustomClose");
        }
    }

    public void videoOperate(CommunicatorParameter communicatorParameter) {
    }

    public void webViewShow(WebView webView, String str) {
        fireEvent(webView, "webviewshow", str);
    }

    public void webviewFireEvent(CommunicatorParameter communicatorParameter) {
    }

    public void webviewGoBack(CommunicatorParameter communicatorParameter) {
    }

    public void webviewGoForward(CommunicatorParameter communicatorParameter) {
    }

    public void webviewLoad(CommunicatorParameter communicatorParameter) {
    }

    public void webviewReload(CommunicatorParameter communicatorParameter) {
    }
}
