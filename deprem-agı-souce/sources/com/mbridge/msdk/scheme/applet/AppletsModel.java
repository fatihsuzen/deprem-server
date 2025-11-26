package com.mbridge.msdk.scheme.applet;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.a.a;
import com.mbridge.msdk.foundation.same.net.b;
import com.mbridge.msdk.foundation.same.net.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.scheme.report.AppletsReport;
import com.mbridge.msdk.scheme.request.AppletSchemeRequest;
import com.mbridge.msdk.scheme.response.AppletSchemeResponse;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class AppletsModel implements Serializable {
    private static final String DYNAMIC_VIEW_WX_IS_REDIRECT_0 = "0";
    private static final String DYNAMIC_VIEW_WX_IS_REDIRECT_1 = "1";
    private static final String DYNAMIC_VIEW_WX_QUERY_PARAM_EVENT_CALLBACK = "event_callback";
    private static final String DYNAMIC_VIEW_WX_QUERY_PARAM_INSTALL_CALLBACK = "install_callback";
    public static final int REQUEST_TYPE_CLICK = 1;
    public static final int REQUEST_TYPE_SHOW = 0;
    private static String TAG = "AppletsModel";
    private static final String URL_ENCODE_UTF_8 = "UTF-8";
    private static final String WX_MINIPROGRAM = "wx_miniprogram";
    private static final int WX_SCHEME_REQUEST_ERROR_CODE_44993 = 44993;
    private volatile IAppletSchemeCallBack appletSchemeCallBack;
    private final CampaignEx campaignEx;
    private String deepLink = "";
    private volatile boolean isRequestSuccess = false;
    private boolean isRequestTimesMaxPerDay = false;
    private volatile boolean isRequesting = false;
    private boolean isSupportWxScheme = false;
    private boolean isUserClick = false;
    private int lastRequestType = -1;
    private Map<String, String> params;
    private String reBuildClickUrl;
    private final String requestId;
    private final String unitID;

    private static final class DefaultAppletSchemeResponse extends AppletSchemeResponse {
        private AppletsModel appletsModel;

        public DefaultAppletSchemeResponse(AppletsModel appletsModel2) {
            this.appletsModel = appletsModel2;
        }

        public final void onError(a aVar) {
            super.onError(aVar);
            AppletsModel appletsModel2 = this.appletsModel;
            if (appletsModel2 != null) {
                appletsModel2.changeRequestingState(false);
                this.appletsModel.handlerSchemeRequestNetworkError(aVar);
            }
        }

        public final void onSuccess(d<JSONObject> dVar) {
            super.onSuccess(dVar);
            AppletsModel appletsModel2 = this.appletsModel;
            if (appletsModel2 != null) {
                appletsModel2.changeRequestingState(false);
                if (dVar == null || dVar.f9311c == null) {
                    this.appletsModel.handlerRequestNetworkError();
                    return;
                }
                try {
                    this.appletsModel.handlerSchemeRequestResult(dVar);
                } catch (SchemeRequestException e5) {
                    this.appletsModel.handlerSchemeRequestFailed(-2, e5.getMessage());
                }
            }
        }
    }

    private static final class SchemeRequestException extends Exception {
        public SchemeRequestException(String str) {
            super(str);
        }
    }

    public AppletsModel(CampaignEx campaignEx2, String str, String str2) {
        this.campaignEx = campaignEx2;
        this.unitID = str;
        this.requestId = str2;
    }

    /* access modifiers changed from: private */
    public void changeRequestingState(boolean z4) {
        this.isRequesting = z4;
    }

    private Map<String, String> getAppletsParamsAndBuildRequest(CampaignEx campaignEx2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = MBridgeConstans.DYNAMIC_VIEW_WX_IS_REDIRECT;
        String str8 = MBridgeConstans.DYNAMIC_VIEW_WX_QUERY;
        HashMap hashMap = new HashMap();
        if (campaignEx2 != null) {
            try {
                Uri parse = Uri.parse(campaignEx2.getClickURL());
                if (parse != null) {
                    if (parse.getQueryParameterNames() != null) {
                        StringBuilder sb = new StringBuilder();
                        Iterator<String> it = parse.getQueryParameterNames().iterator();
                        int i5 = 0;
                        while (true) {
                            str = "";
                            if (!it.hasNext()) {
                                break;
                            }
                            Iterator<String> it2 = it;
                            String next = it.next();
                            if (TextUtils.isEmpty(next) || TextUtils.equals(next, "wx_miniprogram")) {
                                str6 = str7;
                                str5 = str8;
                            } else {
                                try {
                                    str = parse.getQueryParameter(next);
                                } catch (Exception unused) {
                                }
                                String str9 = str;
                                if (TextUtils.equals(next, DYNAMIC_VIEW_WX_QUERY_PARAM_EVENT_CALLBACK) || TextUtils.equals(next, DYNAMIC_VIEW_WX_QUERY_PARAM_INSTALL_CALLBACK)) {
                                    try {
                                        str9 = URLEncoder.encode(str9, "UTF-8");
                                    } catch (Exception e5) {
                                        if (MBridgeConstans.DEBUG) {
                                            String str10 = TAG;
                                            str6 = str7;
                                            StringBuilder sb2 = new StringBuilder();
                                            str5 = str8;
                                            sb2.append("encode url for ");
                                            sb2.append(str9);
                                            sb2.append(" failed");
                                            af.b(str10, sb2.toString(), e5);
                                        }
                                    }
                                }
                                str6 = str7;
                                str5 = str8;
                                sb.append(next);
                                sb.append("=");
                                sb.append(str9);
                                if (i5 < parse.getQueryParameterNames().size()) {
                                    sb.append("&");
                                }
                                i5++;
                            }
                            it = it2;
                            str7 = str6;
                            str8 = str5;
                        }
                        String str11 = str7;
                        String str12 = str8;
                        try {
                            String queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                            if (queryParameter == null) {
                                queryParameter = str;
                            }
                            str2 = queryParameter;
                        } catch (Exception e6) {
                            if (MBridgeConstans.DEBUG) {
                                af.b(TAG, "create wechat app request param failed ", e6);
                            }
                            str2 = str;
                        }
                        hashMap.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, str2);
                        try {
                            String queryParameter2 = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                            if (queryParameter2 == null) {
                                queryParameter2 = str;
                            }
                            str3 = queryParameter2;
                        } catch (Exception e7) {
                            if (MBridgeConstans.DEBUG) {
                                af.b(TAG, "create wechat app request param failed ", e7);
                            }
                            str3 = str;
                        }
                        hashMap.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str3);
                        try {
                            String queryParameter3 = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_WX_CLICKID);
                            if (queryParameter3 == null) {
                                queryParameter3 = str;
                            }
                            str4 = queryParameter3;
                        } catch (Exception e8) {
                            if (MBridgeConstans.DEBUG) {
                                af.b(TAG, "create wechat app request param failed ", e8);
                            }
                            str4 = str;
                        }
                        hashMap.put(MBridgeConstans.DYNAMIC_VIEW_WX_CLICKID, str4);
                        try {
                            String encode = URLEncoder.encode(sb.toString(), "UTF-8");
                            if (encode != null) {
                                str = encode;
                            }
                        } catch (UnsupportedEncodingException e9) {
                            if (MBridgeConstans.DEBUG) {
                                af.b(TAG, "create wechat app request param failed ", e9);
                            }
                        }
                        String str13 = str;
                        String str14 = str12;
                        hashMap.put(str14, str13);
                        String str15 = str11;
                        hashMap.put(str15, "0");
                        if (MBridgeConstans.DEBUG) {
                            af.a(TAG, "query: " + str13);
                        }
                        try {
                            this.reBuildClickUrl = reCreateClickUrl(MBridgeConstans.DYNAMIC_VIEW_WX_APP + "=" + str2 + "&" + MBridgeConstans.DYNAMIC_VIEW_WX_PATH + "=" + str3 + "&" + str14 + "=" + str13 + "&" + MBridgeConstans.DYNAMIC_VIEW_WX_CLICKID + "=" + str4 + "&" + str15 + "=" + "1");
                        } catch (Exception e10) {
                            e = e10;
                        }
                        return hashMap;
                    }
                }
            } catch (Exception e11) {
                e = e11;
                if (MBridgeConstans.DEBUG) {
                    af.b(TAG, "create wechat app request param failed ", e);
                }
                return hashMap;
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public void handlerRequestNetworkError() {
        if (this.appletSchemeCallBack != null) {
            if (MBridgeConstans.DEBUG) {
                af.a(TAG, "handlerRequestNetworkError response or result is null");
            }
            try {
                this.appletSchemeCallBack.onNetworkError(1, "response or result is null", this.reBuildClickUrl);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b(TAG, "handler request network error exception ", e5);
                }
            }
            AppletsReport.reportAppletsLoadState(c.m().c(), "response or result is null", this.unitID, this.requestId);
        }
    }

    /* access modifiers changed from: private */
    public void handlerSchemeRequestFailed(int i5, String str) {
        if (this.appletSchemeCallBack != null) {
            if (MBridgeConstans.DEBUG) {
                af.a(TAG, String.format("handlerSchemeRequestFailed network error by code %s and %s", new Object[]{String.valueOf(i5), str}));
            }
            try {
                this.appletSchemeCallBack.onAppletSchemeRequestFailed(i5, str, this.reBuildClickUrl);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b(TAG, "handler wx scheme failed exception  ", e5);
                }
            }
            AppletsReport.reportAppletsLoadState(c.m().c(), String.format("network error by code %s and %s", new Object[]{String.valueOf(i5), str}), this.unitID, this.requestId);
        }
    }

    /* access modifiers changed from: private */
    public void handlerSchemeRequestNetworkError(a aVar) {
        String str;
        int i5;
        if (this.appletSchemeCallBack != null) {
            if (aVar != null) {
                i5 = aVar.f9304a;
                str = aVar.getMessage();
                if (i5 == 10) {
                    str = "request timeout";
                }
            } else {
                i5 = -1;
                str = "unKnown";
            }
            if (MBridgeConstans.DEBUG) {
                af.a(TAG, String.format("handlerSchemeRequestNetworkError network error by code %s and %s", new Object[]{String.valueOf(i5), str}));
            }
            try {
                IAppletSchemeCallBack iAppletSchemeCallBack = this.appletSchemeCallBack;
                iAppletSchemeCallBack.onNetworkError(i5, "network error: " + str, this.reBuildClickUrl);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b(TAG, "handler wx scheme network error exception ", e5);
                }
            }
            AppletsReport.reportAppletsLoadState(c.m().c(), String.format("network error by code %s and %s", new Object[]{String.valueOf(i5), str}), this.unitID, this.requestId);
        }
    }

    /* access modifiers changed from: private */
    public void handlerSchemeRequestResult(d<JSONObject> dVar) throws SchemeRequestException {
        JSONObject jSONObject = (JSONObject) dVar.f9311c;
        if (MBridgeConstans.DEBUG) {
            af.a("AppletsModel", "result: " + jSONObject.toString());
        }
        if (jSONObject.has("wx_scheme")) {
            String optString = jSONObject.optString("wx_scheme", "");
            if (!TextUtils.isEmpty(optString)) {
                this.isRequestSuccess = true;
                handlerSchemeRequestSuccess(optString);
                return;
            }
            throw new SchemeRequestException("wx_scheme value is null");
        }
        int optInt = jSONObject.optInt("error_code", -1);
        String optString2 = jSONObject.optString("error_msg", "");
        if (optInt == WX_SCHEME_REQUEST_ERROR_CODE_44993) {
            this.isRequestTimesMaxPerDay = true;
        }
        handlerSchemeRequestFailed(optInt, optString2);
    }

    private void handlerSchemeRequestStart() {
        if (this.appletSchemeCallBack != null) {
            try {
                this.appletSchemeCallBack.onAppletSchemeRequestStart();
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b(TAG, "handler wx scheme start exception ", e5);
                }
            }
            AppletsReport.reportAppletsLoadState(c.m().c(), "start load wx scheme", this.unitID, this.requestId);
        }
    }

    private void handlerSchemeRequestSuccess(String str) {
        if (this.appletSchemeCallBack != null) {
            if (MBridgeConstans.DEBUG) {
                String str2 = TAG;
                af.a(str2, "handlerSchemeRequestSuccess: " + str);
            }
            try {
                this.deepLink = str;
                this.appletSchemeCallBack.onAppletSchemeRequestSuccess(str);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b(TAG, "handler wx scheme success exception ", e5);
                }
            }
            AppletsReport.reportAppletsLoadState(c.m().c(), "request wx scheme success", this.unitID, this.requestId);
        }
    }

    private boolean isCanRequestByClickUrl(String str) {
        try {
            CampaignEx campaignEx2 = this.campaignEx;
            if (campaignEx2 == null) {
                return false;
            }
            String clickURL = campaignEx2.getClickURL();
            if (TextUtils.isEmpty(clickURL)) {
                return false;
            }
            return TextUtils.equals(aq.a(clickURL, "wx_miniprogram"), str);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b(TAG, "query wx_miniprogram from click url exception ", e5);
            }
            return false;
        }
    }

    private boolean isCanRequestByLinkType() {
        CampaignEx campaignEx2 = this.campaignEx;
        if (campaignEx2 == null) {
            return false;
        }
        int linkType = campaignEx2.getLinkType();
        if (linkType == 8 || linkType == 9) {
            return true;
        }
        return false;
    }

    private boolean isCanRequestByTemplateUrl(String str) {
        CampaignEx.c rewardTemplateMode;
        try {
            CampaignEx campaignEx2 = this.campaignEx;
            if (!(campaignEx2 == null || (rewardTemplateMode = campaignEx2.getRewardTemplateMode()) == null)) {
                if (!TextUtils.isEmpty(rewardTemplateMode.e())) {
                    return TextUtils.equals(aq.a(rewardTemplateMode.e(), MBridgeConstans.DYNAMIC_VIEW_REQ_WX_URL), str);
                }
            }
            return false;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b(TAG, "query reqwxurl from template url exception ", e5);
            }
            return false;
        }
    }

    private String reCreateClickUrl(String str) {
        return com.mbridge.msdk.foundation.same.net.e.d.f().f9366a + "?" + str;
    }

    public boolean can(int i5) {
        if (isRequesting() || !canRequestWxScheme(i5)) {
            return false;
        }
        if (this.lastRequestType == -1) {
            return true;
        }
        if (isRequestSuccess()) {
            return false;
        }
        int i6 = this.lastRequestType;
        if ((i6 == 0 && i5 == 1) || (i6 == 1 && i5 == 1 && this.isUserClick)) {
            return true;
        }
        return false;
    }

    public boolean canRequestWxScheme(int i5) {
        if (!isSupportWxScheme()) {
            return false;
        }
        if (i5 == 0) {
            return isCanRequestByTemplateUrl("2");
        }
        if (i5 != 1) {
            return false;
        }
        return true;
    }

    public void clearRequestState() {
        this.isRequestSuccess = false;
        this.isRequesting = false;
        this.appletSchemeCallBack = null;
    }

    public String getDeepLink() {
        return this.deepLink;
    }

    public String getReBuildClickUrl() {
        return this.reBuildClickUrl;
    }

    public boolean isRequestSuccess() {
        return this.isRequestSuccess;
    }

    public boolean isRequestTimesMaxPerDay() {
        return this.isRequestTimesMaxPerDay;
    }

    public boolean isRequesting() {
        return this.isRequesting;
    }

    public boolean isSupportWxScheme() {
        boolean z4;
        if (!this.isSupportWxScheme) {
            if (!isCanRequestByClickUrl("1") || !isCanRequestByLinkType()) {
                z4 = false;
            } else {
                z4 = true;
            }
            this.isSupportWxScheme = z4;
        }
        return this.isSupportWxScheme;
    }

    public void requestWxAppletsScheme(int i5, IAppletSchemeCallBack iAppletSchemeCallBack) {
        if (this.campaignEx != null && !TextUtils.isEmpty(this.unitID)) {
            if (MBridgeConstans.DEBUG) {
                af.b(TAG, "start request wx scheme");
            }
            this.isRequesting = true;
            if (iAppletSchemeCallBack != null) {
                this.appletSchemeCallBack = iAppletSchemeCallBack;
            }
            handlerSchemeRequestStart();
            AppletSchemeRequest appletSchemeRequest = new AppletSchemeRequest(c.m().c());
            if (this.params == null) {
                this.params = getAppletsParamsAndBuildRequest(this.campaignEx);
            }
            if (this.params != null) {
                if (isRequestTimesMaxPerDay()) {
                    handlerSchemeRequestFailed(WX_SCHEME_REQUEST_ERROR_CODE_44993, "get wxscheme failed : request times is max");
                    return;
                }
                this.lastRequestType = i5;
                appletSchemeRequest.get(1, com.mbridge.msdk.foundation.same.net.e.d.f().f9366a, this.params, (b) new DefaultAppletSchemeResponse(this), "applets_model", (long) ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
            }
        }
    }

    public void setAppletSchemeCallBack(IAppletSchemeCallBack iAppletSchemeCallBack) {
        this.appletSchemeCallBack = iAppletSchemeCallBack;
    }

    public void setRequestingFinish() {
        this.isRequesting = false;
    }

    public void setUserClick(boolean z4) {
        this.isUserClick = z4;
    }
}
