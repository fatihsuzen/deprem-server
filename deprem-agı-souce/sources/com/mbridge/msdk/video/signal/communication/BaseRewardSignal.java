package com.mbridge.msdk.video.signal.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b.w;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.communication.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.a;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseRewardSignal extends BaseRewardSignalDiff {

    /* renamed from: a  reason: collision with root package name */
    protected BaseIRewardCommunication f12678a;

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
            af.b("JS-Reward-Brigde", "code to string is error");
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        com.mbridge.msdk.mbsignalcommon.communication.d.a(r8, "exception: " + r9.getLocalizedMessage());
        com.mbridge.msdk.foundation.tools.af.b("JS-Reward-Brigde", "cai", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009e, code lost:
        com.mbridge.msdk.mbsignalcommon.communication.d.a(r8, "exception: " + r9.getLocalizedMessage());
        com.mbridge.msdk.foundation.tools.af.b("JS-Reward-Brigde", "cai", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f A[Catch:{ JSONException -> 0x0031, all -> 0x002f }, ExcHandler: all (r9v2 'th' java.lang.Throwable A[CUSTOM_DECLARE, Catch:{ JSONException -> 0x0031, all -> 0x002f }]), Splitter:B:6:0x0018] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cai(java.lang.Object r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "cai"
            java.lang.String r1 = "exception: "
            java.lang.String r2 = "JS-Reward-Brigde"
            boolean r3 = android.text.TextUtils.isEmpty(r9)
            if (r3 == 0) goto L_0x0012
            java.lang.String r9 = "params is null"
            com.mbridge.msdk.mbsignalcommon.communication.d.a((java.lang.Object) r8, (java.lang.String) r9)
            return
        L_0x0012:
            boolean r3 = android.text.TextUtils.isEmpty(r9)
            if (r3 != 0) goto L_0x00b7
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0031, all -> 0x002f }
            r3.<init>(r9)     // Catch:{ JSONException -> 0x0031, all -> 0x002f }
            java.lang.String r9 = "packageName"
            java.lang.String r9 = r3.optString(r9)     // Catch:{ JSONException -> 0x0031, all -> 0x002f }
            boolean r3 = android.text.TextUtils.isEmpty(r9)     // Catch:{ JSONException -> 0x0031, all -> 0x002f }
            if (r3 == 0) goto L_0x0033
            java.lang.String r3 = "packageName is empty"
            com.mbridge.msdk.mbsignalcommon.communication.d.a((java.lang.Object) r8, (java.lang.String) r3)     // Catch:{ JSONException -> 0x0031, all -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r9 = move-exception
            goto L_0x0084
        L_0x0031:
            r9 = move-exception
            goto L_0x009e
        L_0x0033:
            com.mbridge.msdk.foundation.controller.c r3 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ JSONException -> 0x0031, all -> 0x002f }
            android.content.Context r3 = r3.c()     // Catch:{ JSONException -> 0x0031, all -> 0x002f }
            boolean r9 = com.mbridge.msdk.foundation.tools.ak.c((android.content.Context) r3, (java.lang.String) r9)     // Catch:{ JSONException -> 0x0031, all -> 0x002f }
            r3 = 2
            if (r9 == 0) goto L_0x0044
            r9 = 1
            goto L_0x0045
        L_0x0044:
            r9 = r3
        L_0x0045:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0074, all -> 0x002f }
            r4.<init>()     // Catch:{ Exception -> 0x0074, all -> 0x002f }
            java.lang.String r5 = "code"
            int r6 = com.mbridge.msdk.mbsignalcommon.communication.d.f10164b     // Catch:{ Exception -> 0x0074, all -> 0x002f }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0074, all -> 0x002f }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0074, all -> 0x002f }
            r5.<init>()     // Catch:{ Exception -> 0x0074, all -> 0x002f }
            java.lang.String r6 = "result"
            r5.put(r6, r9)     // Catch:{ Exception -> 0x0074, all -> 0x002f }
            java.lang.String r9 = "data"
            r4.put(r9, r5)     // Catch:{ Exception -> 0x0074, all -> 0x002f }
            com.mbridge.msdk.mbsignalcommon.windvane.g r9 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ Exception -> 0x0074, all -> 0x002f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0074, all -> 0x002f }
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x0074, all -> 0x002f }
            java.lang.String r3 = android.util.Base64.encodeToString(r4, r3)     // Catch:{ Exception -> 0x0074, all -> 0x002f }
            r9.a(r8, r3)     // Catch:{ Exception -> 0x0074, all -> 0x002f }
            goto L_0x00b7
        L_0x0074:
            r9 = move-exception
            java.lang.String r3 = r9.getMessage()     // Catch:{ JSONException -> 0x0031, all -> 0x002f }
            com.mbridge.msdk.mbsignalcommon.communication.d.a((java.lang.Object) r8, (java.lang.String) r3)     // Catch:{ JSONException -> 0x0031, all -> 0x002f }
            java.lang.String r9 = r9.getMessage()     // Catch:{ JSONException -> 0x0031, all -> 0x002f }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r2, (java.lang.String) r9)     // Catch:{ JSONException -> 0x0031, all -> 0x002f }
            goto L_0x00b7
        L_0x0084:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = r9.getLocalizedMessage()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.mbridge.msdk.mbsignalcommon.communication.d.a((java.lang.Object) r8, (java.lang.String) r1)
            com.mbridge.msdk.foundation.tools.af.b(r2, r0, r9)
            goto L_0x00b7
        L_0x009e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = r9.getLocalizedMessage()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.mbridge.msdk.mbsignalcommon.communication.d.a((java.lang.Object) r8, (java.lang.String) r1)
            com.mbridge.msdk.foundation.tools.af.b(r2, r0, r9)
        L_0x00b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.communication.BaseRewardSignal.cai(java.lang.Object, java.lang.String):void");
    }

    public void getEndScreenInfo(Object obj, String str) {
        try {
            BaseIRewardCommunication baseIRewardCommunication = this.f12678a;
            if (baseIRewardCommunication != null) {
                baseIRewardCommunication.getEndScreenInfo(obj, str);
                af.b("JS-Reward-Brigde", "getEndScreenInfo factory is true");
                return;
            }
            af.b("JS-Reward-Brigde", "getEndScreenInfo factory is null");
            if (obj != null) {
                a aVar = (a) obj;
                if (w.a(aVar.f10205b)) {
                    WindVaneWebView windVaneWebView = aVar.f10205b;
                    if (windVaneWebView.getWebViewListener() != null) {
                        ((com.mbridge.msdk.mbsignalcommon.b.a) windVaneWebView.getWebViewListener()).a(obj);
                    }
                }
            }
        } catch (Throwable th) {
            af.b("JS-Reward-Brigde", "getEndScreenInfo", th);
        }
    }

    public void handlerPlayableException(Object obj, String str) {
        try {
            if (this.f12678a != null && !TextUtils.isEmpty(str)) {
                this.f12678a.handlerPlayableException(obj, str);
            }
        } catch (Throwable th) {
            af.b("JS-Reward-Brigde", "handlerPlayableException", th);
        }
    }

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        boolean z4;
        super.initialize(context, windVaneWebView);
        try {
            z4 = IJSFactory.class.isInstance(context);
        } catch (ClassNotFoundException e5) {
            e5.printStackTrace();
            z4 = false;
        }
        if (z4) {
            Class<BaseRewardSignalH5> cls = BaseRewardSignalH5.class;
            try {
                this.f12678a = cls.newInstance();
                cls.getMethod("initialize", new Class[]{Context.class, WindVaneWebView.class}).invoke(this.f12678a, new Object[]{context, windVaneWebView});
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    e6.printStackTrace();
                }
            }
        } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof BaseIRewardCommunication)) {
            this.f12678a = (BaseIRewardCommunication) windVaneWebView.getObject();
        }
    }

    public void install(Object obj, String str) {
        try {
            BaseIRewardCommunication baseIRewardCommunication = this.f12678a;
            if (baseIRewardCommunication != null) {
                baseIRewardCommunication.install(obj, str);
            } else if (!TextUtils.isEmpty(str)) {
                if (obj != null) {
                    a aVar = (a) obj;
                    if (aVar.f10205b.getObject() instanceof k) {
                        ((k) aVar.f10205b.getObject()).click(1, str);
                        af.b("JS-Reward-Brigde", "JSCommon install jump success");
                    }
                }
                af.b("JS-Reward-Brigde", "JSCommon install failed");
            }
        } catch (Throwable th) {
            af.b("JS-Reward-Brigde", "install", th);
        }
    }

    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.f12678a != null && !TextUtils.isEmpty(str)) {
                this.f12678a.notifyCloseBtn(obj, str);
            }
        } catch (Throwable th) {
            af.b("JS-Reward-Brigde", "notifyCloseBtn", th);
        }
    }

    public void openURL(Object obj, String str) {
        af.b("JS-Reward-Brigde", "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
        } else if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("url");
                int optInt = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                if (optInt == 1) {
                    c.d(this.f10228b, optString);
                } else if (optInt == 2) {
                    c.f(this.f10228b, optString);
                }
            } catch (JSONException e5) {
                af.b("JS-Reward-Brigde", e5.getMessage());
            } catch (Throwable th) {
                af.b("JS-Reward-Brigde", th.getMessage());
            }
        }
    }

    public void setOrientation(Object obj, String str) {
        try {
            if (this.f12678a != null && !TextUtils.isEmpty(str)) {
                this.f12678a.setOrientation(obj, str);
            }
        } catch (Throwable th) {
            af.b("JS-Reward-Brigde", "setOrientation", th);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.f12678a != null && !TextUtils.isEmpty(str)) {
                this.f12678a.toggleCloseBtn(obj, str);
            }
        } catch (Throwable th) {
            af.b("JS-Reward-Brigde", "toggleCloseBtn", th);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        try {
            if (this.f12678a != null && !TextUtils.isEmpty(str)) {
                this.f12678a.triggerCloseBtn(obj, str);
            }
        } catch (Throwable th) {
            af.b("JS-Reward-Brigde", "triggerCloseBtn", th);
            g.a().a(obj, a(-1));
        }
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        boolean z4;
        super.initialize(obj, windVaneWebView);
        try {
            z4 = IJSFactory.class.isInstance(obj);
        } catch (ClassNotFoundException e5) {
            e5.printStackTrace();
            z4 = false;
        }
        if (z4) {
            Class<BaseRewardSignalH5> cls = BaseRewardSignalH5.class;
            try {
                this.f12678a = cls.newInstance();
                cls.getMethod("initialize", new Class[]{Object.class, WindVaneWebView.class}).invoke(this.f12678a, new Object[]{obj, windVaneWebView});
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    e6.printStackTrace();
                }
            }
        } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof BaseIRewardCommunication)) {
            this.f12678a = (BaseIRewardCommunication) windVaneWebView.getObject();
        }
    }
}
