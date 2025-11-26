package com.mbridge.msdk.mbsignalcommon.windvane;

import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.d.a;
import com.mbridge.msdk.foundation.d.b;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import org.json.JSONArray;
import org.json.JSONObject;

public class BaseAbsFeedBackForH5 extends h {

    /* renamed from: e  reason: collision with root package name */
    private static int f10184e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static int f10185f = 1;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f10186a = "AbsFeedBackForH5";

    public void callbackExcep(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f10185f);
            jSONObject.put("message", str);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            af.a(this.f10186a, e5.getMessage());
        }
    }

    public void callbackSuccess(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f10184e);
            jSONObject.put("message", "");
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            callbackExcep(obj, e5.getMessage());
            af.a(this.f10186a, e5.getMessage());
        }
    }

    public void callbackSuccessWithData(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", f10184e);
            jSONObject2.put("message", "");
            jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject);
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e5) {
            callbackExcep(obj, e5.getMessage());
            af.a(this.f10186a, e5.getMessage());
        }
    }

    public void feedbackLayoutOperate(Object obj, String str) {
        Object obj2 = obj;
        try {
            if (!TextUtils.isEmpty(str)) {
                a aVar = (a) obj2;
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("width", -1);
                int optInt2 = jSONObject.optInt("height", -1);
                int optInt3 = jSONObject.optInt(TtmlNode.LEFT, -1);
                int optInt4 = jSONObject.optInt("top", -1);
                double optDouble = jSONObject.optDouble("opacity", 1.0d);
                int optInt5 = jSONObject.optInt("radius", 20);
                String optString = jSONObject.optString("fontColor", "");
                String optString2 = jSONObject.optString("bgColor", "");
                String optString3 = jSONObject.optString("key", "");
                double optDouble2 = jSONObject.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE, -1.0d);
                JSONArray optJSONArray = jSONObject.optJSONArray("padding");
                b a5 = b.a();
                a5.a(optString3, optInt, optInt2, optInt5, (float) optInt3, (float) optInt4, (float) optDouble, optString, optString2, (float) optDouble2, optJSONArray);
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj2, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackOperate(Object obj, String str) {
        int i5;
        try {
            if (!TextUtils.isEmpty(str)) {
                a aVar = (a) obj;
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("view_visible", 1);
                String optString = jSONObject.optString("key", "");
                b a5 = b.a();
                if (optInt == 1) {
                    i5 = 8;
                } else {
                    i5 = 0;
                }
                a5.a(optString, i5, (ViewGroup) aVar.f10205b);
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackPopupOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("view_visible", 1);
                String optString = jSONObject.optString("key", "");
                final WindVaneWebView windVaneWebView = ((a) obj).f10205b;
                b.a().a(optString, optInt, (a) new a() {
                    public final void close() {
                        String str;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (c.m().c() != null) {
                                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                            }
                            str = jSONObject.toString();
                        } catch (Throwable th) {
                            af.b(BaseAbsFeedBackForH5.this.f10186a, th.getMessage(), th);
                            str = "";
                        }
                        g.a().a((WebView) windVaneWebView, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                    }

                    public final void showed() {
                        String str;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (c.m().c() != null) {
                                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                            }
                            str = jSONObject.toString();
                        } catch (Throwable th) {
                            af.b(BaseAbsFeedBackForH5.this.f10186a, th.getMessage(), th);
                            str = "";
                        }
                        g.a().a((WebView) windVaneWebView, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                    }

                    public final void summit(String str) {
                        String str2;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (c.m().c() != null) {
                                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                            }
                            str2 = jSONObject.toString();
                        } catch (Throwable th) {
                            af.b(BaseAbsFeedBackForH5.this.f10186a, th.getMessage(), th);
                            str2 = "";
                        }
                        g.a().a((WebView) windVaneWebView, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
                    }
                });
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }
}
