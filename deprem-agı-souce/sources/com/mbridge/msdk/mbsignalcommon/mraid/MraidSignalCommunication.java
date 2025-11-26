package com.mbridge.msdk.mbsignalcommon.mraid;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.mraid.a;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.a;
import org.json.JSONObject;

public class MraidSignalCommunication extends BaseMraidSignalCommunication {

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ int f10167g = 0;

    /* renamed from: a  reason: collision with root package name */
    private b f10168a;

    public void close(Object obj, String str) {
        if (obj instanceof a) {
            a.C0096a.f10169a.a((WebView) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b, CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
        }
        try {
            af.b("MraidSignalCommunication", "MRAID close");
            b bVar = this.f10168a;
            if (bVar != null) {
                bVar.close();
            }
        } catch (Throwable th) {
            af.b("MraidSignalCommunication", "MRAID close", th);
        }
    }

    public void expand(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0096a.f10169a.a((WebView) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b, "expand");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("shouldUseCustomClose");
            af.b("MraidSignalCommunication", "MRAID expand " + optString + " " + optString2);
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && this.f10168a != null) {
                this.f10168a.expand(optString, optString2.toLowerCase().equals("true"));
            }
        } catch (Throwable th) {
            af.b("MraidSignalCommunication", "MRAID expand", th);
        }
    }

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof b) {
                this.f10168a = (b) context;
                return;
            }
            if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof b)) {
                this.f10168a = (b) windVaneWebView.getObject();
            }
            if (windVaneWebView.getMraidObject() != null && (windVaneWebView.getMraidObject() instanceof b)) {
                this.f10168a = (b) windVaneWebView.getMraidObject();
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public void open(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
            windVaneWebView = aVar.f10205b;
            a.C0096a.f10169a.a((WebView) aVar.f10205b, "open");
        } else {
            windVaneWebView = null;
        }
        try {
            String optString = new JSONObject(str).optString("url");
            af.b("MraidSignalCommunication", "MRAID Open " + optString);
            if (this.f10168a != null && !TextUtils.isEmpty(optString)) {
                if (windVaneWebView == null || System.currentTimeMillis() - windVaneWebView.lastTouchTime <= ((long) com.mbridge.msdk.click.b.a.f8100c) || !com.mbridge.msdk.click.b.a.a(this.f10168a.getMraidCampaign(), windVaneWebView.getUrl(), com.mbridge.msdk.click.b.a.f8098a)) {
                    this.f10168a.open(optString);
                }
            }
        } catch (Throwable th) {
            af.b("MraidSignalCommunication", "MRAID Open", th);
        }
    }

    public void setOrientationProperties(Object obj, String str) {
        String str2;
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0096a.f10169a.a((WebView) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b, "setOrientationProperties");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("allowOrientationChange");
            String optString2 = jSONObject.optString("forceOrientation");
            af.b("MraidSignalCommunication", "MRAID setOrientationProperties");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && this.f10168a != null) {
                optString.toLowerCase().equals("true");
                String lowerCase = optString2.toLowerCase();
                int hashCode = lowerCase.hashCode();
                if (hashCode == 729267099) {
                    str2 = "portrait";
                } else if (hashCode == 1430647483) {
                    str2 = "landscape";
                } else {
                    return;
                }
                lowerCase.equals(str2);
            }
        } catch (Throwable th) {
            af.b("MraidSignalCommunication", "MRAID setOrientationProperties", th);
        }
    }

    public void unload(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0096a.f10169a.a((WebView) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b, "unload");
        }
        try {
            af.b("MraidSignalCommunication", "MRAID unload");
            b bVar = this.f10168a;
            if (bVar != null) {
                bVar.unload();
            }
        } catch (Throwable th) {
            af.b("MraidSignalCommunication", "MRAID unload", th);
        }
    }

    public void useCustomClose(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0096a.f10169a.a((WebView) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b, "useCustomClose");
        }
        try {
            String optString = new JSONObject(str).optString("shouldUseCustomClose");
            af.b("MraidSignalCommunication", "MRAID useCustomClose " + optString);
            if (!TextUtils.isEmpty(optString) && this.f10168a != null) {
                this.f10168a.useCustomClose(optString.toLowerCase().equals("true"));
            }
        } catch (Throwable th) {
            af.b("MraidSignalCommunication", "MRAID useCustomClose", th);
        }
    }
}
