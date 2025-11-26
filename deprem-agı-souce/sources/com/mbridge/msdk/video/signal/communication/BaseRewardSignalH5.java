package com.mbridge.msdk.video.signal.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.a;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseRewardSignalH5 extends a {

    /* renamed from: a  reason: collision with root package name */
    protected IJSFactory f12679a;

    private String a(int i5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i5);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                return Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
            return "";
        } catch (Throwable unused) {
            af.b("JS-Reward-Communication", "code to string is error");
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008c, code lost:
        com.mbridge.msdk.mbsignalcommon.communication.d.a(r8, "exception: " + r9.getLocalizedMessage());
        com.mbridge.msdk.foundation.tools.af.b("JS-Reward-Communication", "cai", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a6, code lost:
        com.mbridge.msdk.mbsignalcommon.communication.d.a(r8, "exception: " + r9.getLocalizedMessage());
        com.mbridge.msdk.foundation.tools.af.b("JS-Reward-Communication", "cai", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0037, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0039, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0037 A[Catch:{ JSONException -> 0x0039, all -> 0x0037 }, ExcHandler: all (r9v2 'th' java.lang.Throwable A[CUSTOM_DECLARE, Catch:{ JSONException -> 0x0039, all -> 0x0037 }]), Splitter:B:2:0x0020] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cai(java.lang.Object r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "cai"
            java.lang.String r1 = "exception: "
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "cai:"
            r2.append(r3)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "JS-Reward-Communication"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r3, (java.lang.String) r2)
            boolean r2 = android.text.TextUtils.isEmpty(r9)
            if (r2 != 0) goto L_0x00bf
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0039, all -> 0x0037 }
            r2.<init>(r9)     // Catch:{ JSONException -> 0x0039, all -> 0x0037 }
            java.lang.String r9 = "packageName"
            java.lang.String r9 = r2.optString(r9)     // Catch:{ JSONException -> 0x0039, all -> 0x0037 }
            boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch:{ JSONException -> 0x0039, all -> 0x0037 }
            if (r2 == 0) goto L_0x003b
            java.lang.String r2 = "packageName is empty"
            com.mbridge.msdk.mbsignalcommon.communication.d.a((java.lang.Object) r8, (java.lang.String) r2)     // Catch:{ JSONException -> 0x0039, all -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r9 = move-exception
            goto L_0x008c
        L_0x0039:
            r9 = move-exception
            goto L_0x00a6
        L_0x003b:
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ JSONException -> 0x0039, all -> 0x0037 }
            android.content.Context r2 = r2.c()     // Catch:{ JSONException -> 0x0039, all -> 0x0037 }
            boolean r9 = com.mbridge.msdk.foundation.tools.ak.c((android.content.Context) r2, (java.lang.String) r9)     // Catch:{ JSONException -> 0x0039, all -> 0x0037 }
            r2 = 2
            if (r9 == 0) goto L_0x004c
            r9 = 1
            goto L_0x004d
        L_0x004c:
            r9 = r2
        L_0x004d:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x007c, all -> 0x0037 }
            r4.<init>()     // Catch:{ Exception -> 0x007c, all -> 0x0037 }
            java.lang.String r5 = "code"
            int r6 = com.mbridge.msdk.mbsignalcommon.communication.d.f10164b     // Catch:{ Exception -> 0x007c, all -> 0x0037 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x007c, all -> 0x0037 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x007c, all -> 0x0037 }
            r5.<init>()     // Catch:{ Exception -> 0x007c, all -> 0x0037 }
            java.lang.String r6 = "result"
            r5.put(r6, r9)     // Catch:{ Exception -> 0x007c, all -> 0x0037 }
            java.lang.String r9 = "data"
            r4.put(r9, r5)     // Catch:{ Exception -> 0x007c, all -> 0x0037 }
            com.mbridge.msdk.mbsignalcommon.windvane.g r9 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ Exception -> 0x007c, all -> 0x0037 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x007c, all -> 0x0037 }
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x007c, all -> 0x0037 }
            java.lang.String r2 = android.util.Base64.encodeToString(r4, r2)     // Catch:{ Exception -> 0x007c, all -> 0x0037 }
            r9.a(r8, r2)     // Catch:{ Exception -> 0x007c, all -> 0x0037 }
            goto L_0x00bf
        L_0x007c:
            r9 = move-exception
            java.lang.String r2 = r9.getMessage()     // Catch:{ JSONException -> 0x0039, all -> 0x0037 }
            com.mbridge.msdk.mbsignalcommon.communication.d.a((java.lang.Object) r8, (java.lang.String) r2)     // Catch:{ JSONException -> 0x0039, all -> 0x0037 }
            java.lang.String r9 = r9.getMessage()     // Catch:{ JSONException -> 0x0039, all -> 0x0037 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r3, (java.lang.String) r9)     // Catch:{ JSONException -> 0x0039, all -> 0x0037 }
            goto L_0x00bf
        L_0x008c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = r9.getLocalizedMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.mbridge.msdk.mbsignalcommon.communication.d.a((java.lang.Object) r8, (java.lang.String) r1)
            com.mbridge.msdk.foundation.tools.af.b(r3, r0, r9)
            goto L_0x00bf
        L_0x00a6:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = r9.getLocalizedMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.mbridge.msdk.mbsignalcommon.communication.d.a((java.lang.Object) r8, (java.lang.String) r1)
            com.mbridge.msdk.foundation.tools.af.b(r3, r0, r9)
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.communication.BaseRewardSignalH5.cai(java.lang.Object, java.lang.String):void");
    }

    public void getEndScreenInfo(Object obj, String str) {
        String str2;
        try {
            IJSFactory iJSFactory = this.f12679a;
            if (iJSFactory != null) {
                String a5 = iJSFactory.getIJSRewardVideoV1().a();
                if (!TextUtils.isEmpty(a5)) {
                    str2 = Base64.encodeToString(a5.getBytes(), 2);
                    af.a("JS-Reward-Communication", "getEndScreenInfo success");
                } else {
                    str2 = "";
                    af.a("JS-Reward-Communication", "getEndScreenInfo failed");
                }
                g.a().a(obj, str2);
            }
        } catch (Throwable th) {
            af.b("JS-Reward-Communication", "getEndScreenInfo", th);
        }
    }

    public void handlerPlayableException(Object obj, String str) {
        try {
            if (this.f12679a != null && !TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString(NotificationCompat.CATEGORY_MESSAGE);
                af.a("JS-Reward-Communication", "handlerPlayableException,msg:" + str);
                this.f12679a.getIJSRewardVideoV1().c(optString);
            }
        } catch (Throwable th) {
            af.b("JS-Reward-Communication", "setOrientation", th);
        }
    }

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        if (context instanceof IJSFactory) {
            this.f12679a = (IJSFactory) context;
        }
    }

    public void install(Object obj, String str) {
        try {
            if (this.f12679a != null) {
                af.a("JS-Reward-Communication", "install:" + str);
                if (this.f12679a.getJSContainerModule().endCardShowing()) {
                    this.f12679a.getJSCommon().click(3, str);
                } else {
                    this.f12679a.getJSCommon().click(1, str);
                }
            }
        } catch (Throwable th) {
            af.b("JS-Reward-Communication", "install", th);
        }
    }

    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.f12679a != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt(MRAIDCommunicatorUtil.KEY_STATE);
                af.a("JS-Reward-Communication", "notifyCloseBtn,state:" + str);
                this.f12679a.getIJSRewardVideoV1().notifyCloseBtn(optInt);
            }
        } catch (Throwable th) {
            af.b("JS-Reward-Communication", "notifyCloseBtn", th);
        }
    }

    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        af.b("JS-Reward-Communication", "openURL:" + str);
        Context c5 = c.m().c();
        if (!TextUtils.isEmpty(str)) {
            if (c5 == null) {
                try {
                    if ((obj instanceof a) && (windVaneWebView = ((a) obj).f10205b) != null) {
                        c5 = windVaneWebView.getContext();
                    }
                } catch (Exception e5) {
                    af.b("JS-Reward-Communication", e5.getMessage());
                }
            }
            if (c5 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("url");
                    int optInt = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                    if (optInt == 1) {
                        com.mbridge.msdk.click.c.d(c5, optString);
                    } else if (optInt == 2) {
                        com.mbridge.msdk.click.c.f(c5, optString);
                    }
                } catch (JSONException e6) {
                    af.b("JS-Reward-Communication", e6.getMessage());
                } catch (Throwable th) {
                    af.b("JS-Reward-Communication", th.getMessage());
                }
            }
        }
    }

    public void setOrientation(Object obj, String str) {
        try {
            if (this.f12679a != null && !TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString(MRAIDCommunicatorUtil.KEY_STATE);
                af.a("JS-Reward-Communication", "setOrientation,state:" + str);
                this.f12679a.getIJSRewardVideoV1().b(optString);
            }
        } catch (Throwable th) {
            af.b("JS-Reward-Communication", "setOrientation", th);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.f12679a != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt(MRAIDCommunicatorUtil.KEY_STATE);
                af.a("JS-Reward-Communication", "toggleCloseBtn,state:" + str);
                this.f12679a.getIJSRewardVideoV1().toggleCloseBtn(optInt);
            }
        } catch (Throwable th) {
            af.b("JS-Reward-Communication", "toggleCloseBtn", th);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        try {
            if (this.f12679a != null && !TextUtils.isEmpty(str)) {
                g.a().a(obj, a(0));
                this.f12679a.getIJSRewardVideoV1().a(new JSONObject(str).optString(MRAIDCommunicatorUtil.KEY_STATE));
                af.a("JS-Reward-Communication", "triggerCloseBtn,state:" + str);
            }
        } catch (Throwable th) {
            af.b("JS-Reward-Communication", "triggerCloseBtn", th);
            g.a().a(obj, a(-1));
        }
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        if (obj instanceof IJSFactory) {
            this.f12679a = (IJSFactory) obj;
        }
    }
}
