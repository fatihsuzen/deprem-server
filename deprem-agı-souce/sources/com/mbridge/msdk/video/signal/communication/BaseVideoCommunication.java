package com.mbridge.msdk.video.signal.communication;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b.w;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a.b;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.a;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.d;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseVideoCommunication extends AbsFeedBackForH5 implements IVideoCommunication {

    /* renamed from: a  reason: collision with root package name */
    protected IJSFactory f12680a;

    /* renamed from: e  reason: collision with root package name */
    private FastKV f12681e = null;

    private String a(int i5) {
        switch (i5) {
            case 1:
                return "sdk_info";
            case 2:
                return MBridgeConstans.PROPERTIES_UNIT_ID;
            case 3:
                return "appSetting";
            case 4:
                return "unitSetting";
            case 5:
                return "device";
            case 6:
                return "sdkSetting";
            default:
                return "";
        }
    }

    private String b(int i5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i5);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                return Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
            return "";
        } catch (Throwable unused) {
            af.b("JS-Video-Brigde", "code to string is error");
            return "";
        }
    }

    public void appendSubView(Object obj, String str) {
        a(obj, str);
        try {
            d.c().i(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "appendSubView error " + th);
        }
    }

    public void appendViewTo(Object obj, String str) {
        a(obj, str);
        try {
            d.c().j(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "appendViewTo error " + th);
        }
    }

    public void bringViewToFront(Object obj, String str) {
        a(obj, str);
        try {
            d.c().m(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "bringViewToFront error " + th);
        }
    }

    public void broadcast(Object obj, String str) {
        a(obj, str);
        try {
            d.c().J(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "broadcast error " + th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008c, code lost:
        com.mbridge.msdk.mbsignalcommon.communication.d.a(r8, "exception: " + r9.getLocalizedMessage());
        com.mbridge.msdk.foundation.tools.af.b("JS-Video-Brigde", "cai", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a6, code lost:
        com.mbridge.msdk.mbsignalcommon.communication.d.a(r8, "exception: " + r9.getLocalizedMessage());
        com.mbridge.msdk.foundation.tools.af.b("JS-Video-Brigde", "cai", r9);
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
            java.lang.String r3 = "JS-Video-Brigde"
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
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.communication.BaseVideoCommunication.cai(java.lang.Object, java.lang.String):void");
    }

    public void clearAllCache(Object obj, String str) {
        com.mbridge.msdk.foundation.controller.d.a();
        if (this.f12681e == null) {
            try {
                this.f12681e = new FastKV.Builder(e.a(c.MBRIDGE_700_CONFIG), "MBridgeH5CacheSP").build();
            } catch (Exception unused) {
                this.f12681e = null;
            }
        }
        FastKV fastKV = this.f12681e;
        if (fastKV != null) {
            try {
                fastKV.clear();
            } catch (Exception unused2) {
            }
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", 0);
                    jSONObject.put("message", "Success");
                    g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Throwable th) {
                    af.b("JS-Video-Brigde", "getAllCache error " + th);
                }
            }
        } else {
            try {
                com.mbridge.msdk.foundation.controller.c.m().c().getSharedPreferences("MBridgeH5CacheSP", 0).edit().clear().apply();
                if (obj != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", 0);
                    jSONObject2.put("message", "Success");
                    g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                }
            } catch (Throwable th2) {
                af.b("JS-Video-Brigde", "getAllCache error " + th2);
            }
        }
    }

    public void click(Object obj, String str) {
        int i5;
        String str2;
        k kVar;
        af.c("JS-Video-Brigde", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                i5 = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                str2 = jSONObject.optString("pt");
                IJSFactory iJSFactory = this.f12680a;
                if (iJSFactory != null) {
                    iJSFactory.getJSCommon().click(i5, str2);
                } else if (obj != null) {
                    a aVar = (a) obj;
                    if ((aVar.f10205b.getObject() instanceof k) && (kVar = (k) aVar.f10205b.getObject()) != null) {
                        kVar.click(i5, str2);
                    }
                }
            }
        } catch (JSONException e5) {
            str2 = "";
            e5.printStackTrace();
            i5 = 1;
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "click error", th);
        }
    }

    public void closeAd(Object obj, String str) {
        a(obj, str);
        try {
            d.c().I(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "closeAd error " + th);
        }
    }

    public void closeVideoOperte(Object obj, String str) {
        try {
            if (this.f12680a != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
                int optInt2 = jSONObject.optInt("view_visible");
                af.c("JS-Video-Brigde", "closeVideoOperte,close:" + optInt + ",viewVisible:" + optInt2);
                this.f12680a.getJSVideoModule().closeVideoOperate(optInt, optInt2);
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "closeOperte error", th);
        }
    }

    public void closeWeb(Object obj, String str) {
        af.b("JS-Video-Brigde", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY + str);
        try {
            if (!TextUtils.isEmpty(str)) {
                if (this.f12680a != null && !TextUtils.isEmpty(str)) {
                    int optInt = new JSONObject(str).optInt(NotificationCompat.CATEGORY_STATUS);
                    this.f12680a.getJSContainerModule().hideAlertWebview();
                    this.f12680a.getJSVideoModule().hideAlertView(optInt);
                }
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "closeWeb", th);
        }
    }

    public void createNativeEC(Object obj, String str) {
        a(obj, str);
        try {
            d.c().O(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "createNativeEC error " + th);
        }
    }

    public void createPlayerView(Object obj, String str) {
        a(obj, str);
        try {
            d.c().c(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "createPlayerView error " + th);
        }
    }

    public void createSubPlayTemplateView(Object obj, String str) {
        a(obj, str);
        try {
            d.c().d(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "createSubPlayTemplateView error " + th);
        }
    }

    public void createView(Object obj, String str) {
        a(obj, str);
        try {
            d.c().a(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "createView error " + th);
        }
    }

    public void createWebview(Object obj, String str) {
        a(obj, str);
        try {
            d.c().b(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "createWebview error " + th);
        }
    }

    public void destroyComponent(Object obj, String str) {
        a(obj, str);
        try {
            d.c().e(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "destroyComponent error " + th);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.util.Map<java.lang.String, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.util.Map<java.lang.String, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.util.Map<java.lang.String, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.util.Map<java.lang.String, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.util.Map<java.lang.String, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v22, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.util.Map<java.lang.String, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: java.util.Map<java.lang.String, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: java.util.Map<java.lang.String, java.lang.Object>} */
    /* JADX WARNING: type inference failed for: r10v3, types: [java.lang.Object] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fc A[SYNTHETIC, Splitter:B:40:0x00fc] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0102 A[Catch:{ all -> 0x0100 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0109 A[Catch:{ all -> 0x0100 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getAllCache(java.lang.Object r9, java.lang.String r10) {
        /*
            r8 = this;
            com.mbridge.msdk.foundation.controller.d.a()
            com.mbridge.msdk.foundation.tools.FastKV r10 = r8.f12681e
            java.lang.String r0 = "MBridgeH5CacheSP"
            r1 = 0
            if (r10 != 0) goto L_0x001e
            com.mbridge.msdk.foundation.tools.FastKV$Builder r10 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch:{ Exception -> 0x001c }
            com.mbridge.msdk.foundation.same.b.c r2 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG     // Catch:{ Exception -> 0x001c }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.b.e.a((com.mbridge.msdk.foundation.same.b.c) r2)     // Catch:{ Exception -> 0x001c }
            r10.<init>(r2, r0)     // Catch:{ Exception -> 0x001c }
            com.mbridge.msdk.foundation.tools.FastKV r10 = r10.build()     // Catch:{ Exception -> 0x001c }
            r8.f12681e = r10     // Catch:{ Exception -> 0x001c }
            goto L_0x001e
        L_0x001c:
            r8.f12681e = r1
        L_0x001e:
            com.mbridge.msdk.foundation.tools.FastKV r10 = r8.f12681e
            r2 = 0
            java.lang.String r3 = "getAllCache Error, reason is : "
            java.lang.String r4 = "getAllCache Success"
            java.lang.String r5 = "getAllCache error "
            java.lang.String r6 = "JS-Video-Brigde"
            if (r10 == 0) goto L_0x0086
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ all -> 0x005e }
            r10.<init>()     // Catch:{ all -> 0x005e }
            com.mbridge.msdk.foundation.tools.FastKV r0 = r8.f12681e     // Catch:{ Exception -> 0x003a }
            java.util.Map r1 = r0.getAll()     // Catch:{ Exception -> 0x003a }
            goto L_0x003a
        L_0x0037:
            r0 = move-exception
            r1 = r10
            goto L_0x005f
        L_0x003a:
            if (r1 == 0) goto L_0x00e9
            java.util.Set r0 = r1.entrySet()     // Catch:{ all -> 0x0037 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0037 }
        L_0x0044:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0037 }
            if (r1 == 0) goto L_0x00e9
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0037 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x0037 }
            java.lang.Object r7 = r1.getKey()     // Catch:{ all -> 0x0037 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0037 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x0037 }
            r10.put(r7, r1)     // Catch:{ all -> 0x0037 }
            goto L_0x0044
        L_0x005e:
            r0 = move-exception
        L_0x005f:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r5)
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            com.mbridge.msdk.foundation.tools.af.b(r6, r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r3)
            java.lang.String r0 = r0.getMessage()
            r10.append(r0)
            java.lang.String r4 = r10.toString()
        L_0x0084:
            r10 = r1
            goto L_0x00e9
        L_0x0086:
            com.mbridge.msdk.foundation.controller.c r10 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x00c2 }
            android.content.Context r10 = r10.c()     // Catch:{ all -> 0x00c2 }
            android.content.SharedPreferences r10 = r10.getSharedPreferences(r0, r2)     // Catch:{ all -> 0x00c2 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x00c2 }
            r0.<init>()     // Catch:{ all -> 0x00c2 }
            java.util.Map r10 = r10.getAll()     // Catch:{ all -> 0x00bd }
            java.util.Set r10 = r10.entrySet()     // Catch:{ all -> 0x00bd }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x00bd }
        L_0x00a3:
            boolean r1 = r10.hasNext()     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x00c0
            java.lang.Object r1 = r10.next()     // Catch:{ all -> 0x00bd }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x00bd }
            java.lang.Object r7 = r1.getKey()     // Catch:{ all -> 0x00bd }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x00bd }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x00bd }
            r0.put(r7, r1)     // Catch:{ all -> 0x00bd }
            goto L_0x00a3
        L_0x00bd:
            r10 = move-exception
            r1 = r0
            goto L_0x00c3
        L_0x00c0:
            r10 = r0
            goto L_0x00e9
        L_0x00c2:
            r10 = move-exception
        L_0x00c3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.foundation.tools.af.b(r6, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            java.lang.String r10 = r10.getMessage()
            r0.append(r10)
            java.lang.String r4 = r0.toString()
            goto L_0x0084
        L_0x00e9:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0100 }
            r0.<init>()     // Catch:{ all -> 0x0100 }
            java.lang.String r1 = "code"
            r0.put(r1, r2)     // Catch:{ all -> 0x0100 }
            java.lang.String r1 = "message"
            r0.put(r1, r4)     // Catch:{ all -> 0x0100 }
            java.lang.String r1 = "data"
            if (r10 == 0) goto L_0x0102
            r0.put(r1, r10)     // Catch:{ all -> 0x0100 }
            goto L_0x0107
        L_0x0100:
            r9 = move-exception
            goto L_0x011e
        L_0x0102:
            java.lang.String r10 = "{}"
            r0.put(r1, r10)     // Catch:{ all -> 0x0100 }
        L_0x0107:
            if (r9 == 0) goto L_0x0130
            com.mbridge.msdk.mbsignalcommon.windvane.g r10 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ all -> 0x0100 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0100 }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x0100 }
            r1 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r1)     // Catch:{ all -> 0x0100 }
            r10.a(r9, r0)     // Catch:{ all -> 0x0100 }
            goto L_0x0130
        L_0x011e:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r5)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.mbridge.msdk.foundation.tools.af.b(r6, r9)
        L_0x0130:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.communication.BaseVideoCommunication.getAllCache(java.lang.Object, java.lang.String):void");
    }

    public void getAppSetting(Object obj, String str) {
        JSONObject jSONObject;
        try {
            String optString = new JSONObject(str).optString("appid", "");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(optString)) {
                String g5 = h.a().g(optString);
                if (TextUtils.isEmpty(g5)) {
                    h.a();
                    jSONObject = new JSONObject(i.a().aM());
                } else {
                    jSONObject = new JSONObject(g5);
                    jSONObject.put("isDefault", 0);
                }
                if (obj != null) {
                    jSONObject2.put("code", 0);
                    jSONObject2.put("message", "Success");
                    jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("message", "Get App Setting error, plz try again later.");
                }
            } else {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "Get App Setting error, because must give a appId.");
            }
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getAppSetting error : " + th.getMessage());
        }
    }

    public void getComponentOptions(Object obj, String str) {
        a(obj, str);
        try {
            d.c().f(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getComponentOptions error " + th);
        }
    }

    public void getCurrentProgress(Object obj, String str) {
        try {
            IJSFactory iJSFactory = this.f12680a;
            if (iJSFactory != null) {
                String currentProgress = iJSFactory.getJSVideoModule().getCurrentProgress();
                af.c("JS-Video-Brigde", "getCurrentProgress:" + currentProgress);
                if (!TextUtils.isEmpty(currentProgress)) {
                    currentProgress = Base64.encodeToString(currentProgress.getBytes(), 2);
                }
                g.a().a(obj, currentProgress);
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getCurrentProgress error", th);
        }
    }

    public void getCutout(Object obj, String str) {
        try {
            String i5 = this.f12680a.getJSCommon().i();
            af.b("JS-Video-Brigde", i5);
            if (obj == null || TextUtils.isEmpty(i5)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 1);
                jSONObject.put("message", "No notch data, plz try again later.");
                g.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                return;
            }
            g.a().a(obj, Base64.encodeToString(i5.getBytes(), 2));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getCutout error : " + th.getMessage());
        }
    }

    public void getEncryptPrice(Object obj, String str) {
        String str2;
        String str3 = "not replaced";
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            int i5 = 1;
            if (TextUtils.isEmpty(str)) {
                str2 = "params is null";
            } else {
                JSONObject jSONObject3 = new JSONObject(str);
                String optString = jSONObject3.optString("unitid", "");
                String optString2 = jSONObject3.optString("requestId", "");
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    str2 = "params parsing exception";
                } else {
                    com.mbridge.msdk.foundation.entity.d b5 = b.b(optString, optString2);
                    if (b5 != null && b5.c() == 1) {
                        str3 = "success";
                        jSONObject2.put("encrypt_p", b5.b());
                        jSONObject2.put(com.mbridge.msdk.foundation.entity.b.KEY_IRLFA, 1);
                        i5 = 0;
                    }
                    str2 = str3;
                }
            }
            jSONObject.put("code", i5);
            jSONObject.put("message", str2);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getEncryptPrice error : " + th.getMessage());
        }
    }

    public void getFileInfo(Object obj, String str) {
        a(obj, str);
        try {
            d.c().N(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getFileInfo error", th);
        }
    }

    public void getRewardSetting(Object obj, String str) {
        try {
            JSONObject k5 = com.mbridge.msdk.videocommon.d.b.a().b().k();
            JSONObject jSONObject = new JSONObject();
            if (obj == null || k5 == null) {
                jSONObject.put("code", 1);
                jSONObject.put("message", "Get Reward Setting error, plz try again later.");
            } else {
                jSONObject.put("code", 0);
                jSONObject.put("message", "Success");
                jSONObject.put(DataSchemeDataSource.SCHEME_DATA, k5);
            }
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getRewardSetting error : " + th.getMessage());
        }
    }

    public void getRewardUnitSetting(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appid", "");
            String optString2 = jSONObject.optString("unitid", "");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(optString)) {
                if (!TextUtils.isEmpty(optString2)) {
                    JSONObject E4 = com.mbridge.msdk.videocommon.d.b.a().a(optString, optString2).E();
                    if (obj == null || E4 == null) {
                        jSONObject2.put("code", 1);
                        jSONObject2.put("message", "Get Reward Unit Setting error, plz try again later.");
                    } else {
                        jSONObject2.put("code", 0);
                        jSONObject2.put("message", "Success");
                        jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, E4);
                    }
                    g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                }
            }
            jSONObject2.put("code", 1);
            jSONObject2.put("message", "Get reward unit Setting error, because must give appId and unitId.");
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getRewardUnitSetting error : " + th.getMessage());
        }
    }

    public void getSDKInfo(Object obj, String str) {
        af.c("JS-Video-Brigde", "getSDKInfo");
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONObject(str).getJSONArray(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                JSONObject jSONObject = new JSONObject();
                int i5 = 0;
                if (this.f12680a != null) {
                    while (i5 < jSONArray.length()) {
                        int i6 = jSONArray.getInt(i5);
                        jSONObject.put(a(i6), this.f12680a.getJSCommon().g(i6));
                        i5++;
                    }
                } else if (obj != null) {
                    while (i5 < jSONArray.length()) {
                        int i7 = jSONArray.getInt(i5);
                        a aVar = (a) obj;
                        if (aVar.f10205b.getObject() instanceof k) {
                            jSONObject.put(a(i7), ((k) aVar.f10205b.getObject()).g(i7));
                        }
                        i5++;
                    }
                }
                g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                return;
            }
            g.a().b(obj, "params is null");
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getSDKInfo error", th);
            g.a().b(obj, "exception");
        }
    }

    public void getUnitSetting(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("message", "Get Unit Setting error, RV/IV can not support this method.");
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getUnitSetting error : " + th.getMessage());
        }
    }

    public void handleNativeObject(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().a(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "handleNativeObject error " + th);
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        try {
            if (this.f12680a != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                af.c("JS-Video-Brigde", "handlerH5Exception,params:" + str);
                this.f12680a.getJSCommon().handlerH5Exception(jSONObject.optInt("code", -999), jSONObject.optString("message", "h5 error"));
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "handlerH5Exception", th);
        }
    }

    public void hideView(Object obj, String str) {
        a(obj, str);
        try {
            d.c().n(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "hideView error " + th);
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        a(obj, str);
        try {
            d.c().M(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "increaseOfferFrequence error " + th);
        }
    }

    public void init(Object obj, String str) {
        af.c("JS-Video-Brigde", "init");
        try {
            IJSFactory iJSFactory = this.f12680a;
            boolean z4 = false;
            int i5 = 1;
            if (iJSFactory != null) {
                String c5 = iJSFactory.getJSCommon().c();
                if (!TextUtils.isEmpty(c5)) {
                    c5 = Base64.encodeToString(c5.getBytes(), 2);
                }
                g.a().a(obj, c5);
                this.f12680a.getJSCommon().b(true);
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("showTransparent");
                    int optInt2 = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
                    int optInt3 = jSONObject.optInt("closeType");
                    int optInt4 = jSONObject.optInt("orientationType");
                    int optInt5 = jSONObject.optInt("webfront");
                    int optInt6 = jSONObject.optInt("showAlertRole");
                    com.mbridge.msdk.video.signal.d jSCommon = this.f12680a.getJSCommon();
                    if (optInt == 1) {
                        z4 = true;
                    }
                    jSCommon.a(z4);
                    this.f12680a.getJSCommon().b(optInt2);
                    this.f12680a.getJSCommon().c(optInt3);
                    this.f12680a.getJSCommon().d(optInt4);
                    this.f12680a.getJSCommon().e(optInt5);
                    com.mbridge.msdk.video.signal.d jSCommon2 = this.f12680a.getJSCommon();
                    if (optInt6 != 0) {
                        i5 = optInt6;
                    }
                    jSCommon2.h(i5);
                }
            } else if (obj != null) {
                a aVar = (a) obj;
                if (aVar.f10205b.getObject() instanceof k) {
                    k kVar = (k) aVar.f10205b.getObject();
                    String c6 = kVar.c();
                    if (!TextUtils.isEmpty(str)) {
                        JSONObject jSONObject2 = new JSONObject(str);
                        int optInt7 = jSONObject2.optInt("showTransparent");
                        int optInt8 = jSONObject2.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
                        int optInt9 = jSONObject2.optInt("closeType");
                        int optInt10 = jSONObject2.optInt("orientationType");
                        int optInt11 = jSONObject2.optInt("webfront");
                        int optInt12 = jSONObject2.optInt("showAlertRole");
                        if (optInt7 == 1) {
                            z4 = true;
                        }
                        kVar.a(z4);
                        kVar.b(optInt8);
                        kVar.c(optInt9);
                        kVar.d(optInt10);
                        kVar.e(optInt11);
                        if (optInt12 != 0) {
                            i5 = optInt12;
                        }
                        kVar.h(i5);
                        af.c("JS-Video-Brigde", "init jsCommon.setIsShowingTransparent = " + optInt7);
                    }
                    g.a().a(obj, Base64.encodeToString(c6.getBytes(), 2));
                }
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "init error", th);
        }
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        super.initialize(obj, windVaneWebView);
        if (obj instanceof IJSFactory) {
            this.f12680a = (IJSFactory) obj;
        }
    }

    public void insertViewAbove(Object obj, String str) {
        a(obj, str);
        try {
            d.c().a(obj, new JSONObject(str), true);
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "insertViewAbove error " + th);
        }
    }

    public void insertViewBelow(Object obj, String str) {
        a(obj, str);
        try {
            d.c().b(obj, new JSONObject(str), true);
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "insertViewBelow error " + th);
        }
    }

    public void isSystemResume(Object obj, String str) {
        try {
            if (this.f12680a != null) {
                af.c("JS-Video-Brigde", "isSystemResume,params:" + str);
                g.a().a(obj, b(this.f12680a.getActivityProxy().h()));
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "isSystemResume", th);
        }
    }

    public void ivRewardAdsWithoutVideo(Object obj, String str) {
        af.b("JS-Video-Brigde", "ivRewardAdsWithoutVideo ： params" + str);
        try {
            if (!TextUtils.isEmpty(str)) {
                if (this.f12680a != null && !TextUtils.isEmpty(str)) {
                    this.f12680a.getJSContainerModule().ivRewardAdsWithoutVideo(str);
                }
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "ivRewardAdsWithoutVideo", th);
        }
    }

    public void loadads(Object obj, String str) {
        int i5;
        int i6;
        String str2;
        String str3;
        af.c("JS-Video-Brigde", "loadads");
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(MBridgeConstans.PLACEMENT_ID);
                String optString2 = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                int optInt = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
                if (optInt > 2) {
                    optInt = 1;
                }
                str3 = optString;
                i5 = jSONObject.optInt("adtype", 1);
                str2 = optString2;
                i6 = optInt;
            } else {
                str3 = "";
                str2 = str3;
                i6 = 1;
                i5 = 1;
            }
            if (TextUtils.isEmpty(str2)) {
                g.a().a(obj, b(1));
                return;
            }
            if (obj != null) {
                a aVar = (a) obj;
                if (w.a(aVar.f10205b)) {
                    WindVaneWebView windVaneWebView = aVar.f10205b;
                    if (windVaneWebView.getWebViewListener() != null) {
                        ((com.mbridge.msdk.mbsignalcommon.b.a) windVaneWebView.getWebViewListener()).a(windVaneWebView, str3, str2, i6, i5);
                    }
                }
            }
            g.a().a(obj, b(0));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "loadads error", th);
            g.a().a(obj, b(1));
        }
    }

    public void loadingResourceStatus(Object obj, String str) {
        a(obj, str);
        if (obj != null) {
            try {
                int optInt = new JSONObject(str).optInt("isReady", 1);
                WindVaneWebView windVaneWebView = ((a) obj).f10205b;
                if (windVaneWebView != null && windVaneWebView.getWebViewListener() != null) {
                    windVaneWebView.getWebViewListener().c(windVaneWebView, optInt);
                }
            } catch (Throwable th) {
                af.b("JS-Video-Brigde", "loadingResourceStatus error " + th);
            }
        }
    }

    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.f12680a != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt(MRAIDCommunicatorUtil.KEY_STATE);
                af.c("JS-Video-Brigde", "notifyCloseBtn,result:" + optInt);
                this.f12680a.getJSVideoModule().notifyCloseBtn(optInt);
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "notifyCloseBtn", th);
        }
    }

    public void onlyAppendSubView(Object obj, String str) {
        a(obj, str);
        try {
            d.c().k(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "appendSubView error " + th);
        }
    }

    public void onlyAppendViewTo(Object obj, String str) {
        a(obj, str);
        try {
            d.c().l(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "appendViewTo error " + th);
        }
    }

    public void onlyInsertViewAbove(Object obj, String str) {
        a(obj, str);
        try {
            d.c().s(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "insertViewAbove error " + th);
        }
    }

    public void onlyInsertViewBelow(Object obj, String str) {
        a(obj, str);
        try {
            d.c().b(obj, new JSONObject(str), false);
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "insertViewBelow error " + th);
        }
    }

    public void openURL(Object obj, String str) {
        af.b("JS-Video-Brigde", "openURL:" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("url");
                int optInt = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                if (optInt == 1) {
                    com.mbridge.msdk.click.c.d(this.f10228b, optString);
                } else if (optInt == 2) {
                    com.mbridge.msdk.click.c.f(this.f10228b, optString);
                }
            } catch (JSONException e5) {
                af.b("JS-Video-Brigde", e5.getMessage());
            } catch (Throwable th) {
                af.b("JS-Video-Brigde", th.getMessage());
            }
        }
    }

    public void playVideoFinishOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (this.f12680a != null && !TextUtils.isEmpty(str)) {
                    int optInt = new JSONObject(str).optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                    af.c("JS-Video-Brigde", "playVideoFinishOperate,type: " + optInt);
                    this.f12680a.getJSCommon().f(optInt);
                }
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "playVideoFinishOperate error", th);
        }
    }

    public void playerGetMuteState(Object obj, String str) {
        a(obj, str);
        try {
            d.c().E(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "playerGetMuteState error " + th);
        }
    }

    public void playerMute(Object obj, String str) {
        a(obj, str);
        try {
            d.c().C(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "playerMute error " + th);
        }
    }

    public void playerPause(Object obj, String str) {
        a(obj, str);
        try {
            d.c().y(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "playerPause error " + th);
        }
    }

    public void playerPlay(Object obj, String str) {
        a(obj, str);
        try {
            d.c().x(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "playerPlay error " + th);
        }
    }

    public void playerResume(Object obj, String str) {
        a(obj, str);
        try {
            d.c().z(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "playerResume error " + th);
        }
    }

    public void playerSetRenderType(Object obj, String str) {
        a(obj, str);
        try {
            d.c().G(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "playerSetRenderType error " + th);
        }
    }

    public void playerSetSource(Object obj, String str) {
        a(obj, str);
        try {
            d.c().F(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "playerSetSource error " + th);
        }
    }

    public void playerStop(Object obj, String str) {
        a(obj, str);
        try {
            d.c().A(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "playerStop error " + th);
        }
    }

    public void playerUnmute(Object obj, String str) {
        a(obj, str);
        try {
            d.c().D(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "playerUnmute error " + th);
        }
    }

    public void playerUpdateFrame(Object obj, String str) {
        a(obj, str);
        try {
            d.c().B(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "playerUpdateFrame error " + th);
        }
    }

    public void preloadSubPlayTemplateView(Object obj, String str) {
        a(obj, str);
        try {
            if (this.f12680a != null) {
                d.c().H(obj, new JSONObject(str));
                return;
            }
            a aVar = (a) obj;
            if (w.a(aVar.f10205b)) {
                WindVaneWebView windVaneWebView = aVar.f10205b;
                if (windVaneWebView.getWebViewListener() != null) {
                    ((com.mbridge.msdk.mbsignalcommon.b.a) windVaneWebView.getWebViewListener()).a(obj, str);
                    af.a("JS-Video-Brigde", "preloadSubPlayTemplateView: RVWebViewListener");
                    return;
                }
                af.a("JS-Video-Brigde", "preloadSubPlayTemplateView: failed");
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "preloadSubPlayTemplateView error " + th);
        }
    }

    public void progressBarOperate(Object obj, String str) {
        try {
            if (this.f12680a != null && !TextUtils.isEmpty(str)) {
                this.f12680a.getJSVideoModule().progressBarOperate(new JSONObject(str).optInt("view_visible"));
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "progressOperate error", th);
        }
    }

    public void progressOperate(Object obj, String str) {
        try {
            if (this.f12680a != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("progress");
                int optInt2 = jSONObject.optInt("view_visible");
                af.c("JS-Video-Brigde", "progressOperate,progress:" + optInt + ",viewVisible:" + optInt2);
                this.f12680a.getJSVideoModule().progressOperate(optInt, optInt2);
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "progressOperate error", th);
        }
    }

    public void reactDeveloper(Object obj, String str) {
        af.a("JS-Video-Brigde", "reactDeveloper");
        try {
            if (this.f12680a == null || TextUtils.isEmpty(str)) {
                g.a().b(obj, b(1));
            } else {
                this.f12680a.getJSBTModule().reactDeveloper(obj, str);
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "reactDeveloper error " + th);
        }
    }

    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                a aVar = (a) obj;
                int optInt = new JSONObject(str).optInt("isReady", 1);
                if (aVar.f10205b.getObject() instanceof k) {
                    ((k) aVar.f10205b.getObject()).i(optInt);
                }
                WindVaneWebView windVaneWebView = aVar.f10205b;
                if (windVaneWebView != null && windVaneWebView.getWebViewListener() != null) {
                    windVaneWebView.getWebViewListener().a((WebView) windVaneWebView, optInt);
                }
            } catch (Throwable th) {
                af.b("JS-Video-Brigde", "readyStatus", th);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00df A[ADDED_TO_REGION, Catch:{ all -> 0x0109 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeCacheItem(java.lang.Object r11, java.lang.String r12) {
        /*
            r10 = this;
            com.mbridge.msdk.foundation.controller.d.a()
            com.mbridge.msdk.foundation.tools.FastKV r0 = r10.f12681e
            java.lang.String r1 = "MBridgeH5CacheSP"
            if (r0 != 0) goto L_0x001e
            com.mbridge.msdk.foundation.tools.FastKV$Builder r0 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch:{ Exception -> 0x001b }
            com.mbridge.msdk.foundation.same.b.c r2 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG     // Catch:{ Exception -> 0x001b }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.b.e.a((com.mbridge.msdk.foundation.same.b.c) r2)     // Catch:{ Exception -> 0x001b }
            r0.<init>(r2, r1)     // Catch:{ Exception -> 0x001b }
            com.mbridge.msdk.foundation.tools.FastKV r0 = r0.build()     // Catch:{ Exception -> 0x001b }
            r10.f12681e = r0     // Catch:{ Exception -> 0x001b }
            goto L_0x001e
        L_0x001b:
            r0 = 0
            r10.f12681e = r0
        L_0x001e:
            com.mbridge.msdk.foundation.tools.FastKV r0 = r10.f12681e
            java.lang.String r2 = "Delete Error, reason is : "
            java.lang.String r3 = "Delete Success"
            java.lang.String r4 = "key"
            java.lang.String r5 = "removeCacheItem error "
            java.lang.String r6 = "JS-Video-Brigde"
            r7 = 1
            r8 = 0
            java.lang.String r9 = ""
            if (r0 == 0) goto L_0x0078
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x004d
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x004b }
            r0.<init>(r12)     // Catch:{ all -> 0x004b }
            java.lang.String r12 = r0.getString(r4)     // Catch:{ all -> 0x004b }
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x004f
            com.mbridge.msdk.foundation.tools.FastKV r0 = r10.f12681e     // Catch:{ Exception -> 0x004f }
            r0.remove(r12)     // Catch:{ Exception -> 0x004f }
            goto L_0x004f
        L_0x004b:
            r12 = move-exception
            goto L_0x0052
        L_0x004d:
            r7 = r8
            r3 = r9
        L_0x004f:
            r8 = r7
            goto L_0x00cb
        L_0x0052:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.foundation.tools.af.b(r6, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r12 = r12.getMessage()
            r0.append(r12)
            java.lang.String r3 = r0.toString()
            goto L_0x00cb
        L_0x0078:
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x00a5 }
            android.content.Context r0 = r0.c()     // Catch:{ all -> 0x00a5 }
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r8)     // Catch:{ all -> 0x00a5 }
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x00a5 }
            if (r1 != 0) goto L_0x004d
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x00a5 }
            r1.<init>(r12)     // Catch:{ all -> 0x00a5 }
            java.lang.String r12 = r1.getString(r4)     // Catch:{ all -> 0x00a5 }
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x00a5 }
            if (r1 != 0) goto L_0x004f
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x00a5 }
            android.content.SharedPreferences$Editor r12 = r0.remove(r12)     // Catch:{ all -> 0x00a5 }
            r12.apply()     // Catch:{ all -> 0x00a5 }
            goto L_0x004f
        L_0x00a5:
            r12 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.foundation.tools.af.b(r6, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r12 = r12.getMessage()
            r0.append(r12)
            java.lang.String r3 = r0.toString()
        L_0x00cb:
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ all -> 0x0109 }
            r12.<init>()     // Catch:{ all -> 0x0109 }
            java.lang.String r0 = "code"
            r1 = r8 ^ 1
            r12.put(r0, r1)     // Catch:{ all -> 0x0109 }
            java.lang.String r0 = "message"
            r12.put(r0, r3)     // Catch:{ all -> 0x0109 }
            r0 = 2
            if (r11 == 0) goto L_0x00f5
            if (r8 == 0) goto L_0x00f5
            com.mbridge.msdk.mbsignalcommon.windvane.g r1 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ all -> 0x0109 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0109 }
            byte[] r12 = r12.getBytes()     // Catch:{ all -> 0x0109 }
            java.lang.String r12 = android.util.Base64.encodeToString(r12, r0)     // Catch:{ all -> 0x0109 }
            r1.a(r11, r12)     // Catch:{ all -> 0x0109 }
            goto L_0x010c
        L_0x00f5:
            com.mbridge.msdk.mbsignalcommon.windvane.g r1 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ all -> 0x0109 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0109 }
            byte[] r12 = r12.getBytes()     // Catch:{ all -> 0x0109 }
            java.lang.String r12 = android.util.Base64.encodeToString(r12, r0)     // Catch:{ all -> 0x0109 }
            r1.b(r11, r12)     // Catch:{ all -> 0x0109 }
            goto L_0x010c
        L_0x0109:
            com.mbridge.msdk.foundation.tools.af.b(r6, r5)
        L_0x010c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.communication.BaseVideoCommunication.removeCacheItem(java.lang.Object, java.lang.String):void");
    }

    public void removeFromSuperView(Object obj, String str) {
        a(obj, str);
        try {
            d.c().h(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "removeFromSuperView error " + th);
        }
    }

    public void reportData(Object obj, String str) {
    }

    public void reportUrls(Object obj, String str) {
        af.a("JS-Video-Brigde", "reportUrls");
        try {
            if (!TextUtils.isEmpty(str)) {
                IJSFactory iJSFactory = this.f12680a;
                if (iJSFactory == null || iJSFactory.getJSBTModule() == null) {
                    d.c().b(obj, str);
                } else if (this.f12680a.getJSBTModule() instanceof j) {
                    this.f12680a.getJSBTModule().reportUrls(obj, str);
                } else {
                    d.c().b(obj, str);
                }
            } else {
                g.a().b(obj, b(1));
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "reportUrls error " + th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f5 A[ADDED_TO_REGION, Catch:{ all -> 0x011f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCacheItem(java.lang.Object r12, java.lang.String r13) {
        /*
            r11 = this;
            com.mbridge.msdk.foundation.controller.d.a()
            com.mbridge.msdk.foundation.tools.FastKV r0 = r11.f12681e
            java.lang.String r1 = "MBridgeH5CacheSP"
            if (r0 != 0) goto L_0x001e
            com.mbridge.msdk.foundation.tools.FastKV$Builder r0 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch:{ Exception -> 0x001b }
            com.mbridge.msdk.foundation.same.b.c r2 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG     // Catch:{ Exception -> 0x001b }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.b.e.a((com.mbridge.msdk.foundation.same.b.c) r2)     // Catch:{ Exception -> 0x001b }
            r0.<init>(r2, r1)     // Catch:{ Exception -> 0x001b }
            com.mbridge.msdk.foundation.tools.FastKV r0 = r0.build()     // Catch:{ Exception -> 0x001b }
            r11.f12681e = r0     // Catch:{ Exception -> 0x001b }
            goto L_0x001e
        L_0x001b:
            r0 = 0
            r11.f12681e = r0
        L_0x001e:
            com.mbridge.msdk.foundation.tools.FastKV r0 = r11.f12681e
            java.lang.String r2 = "Save Error, reason is : "
            java.lang.String r3 = "Save Success"
            java.lang.String r4 = "value"
            java.lang.String r5 = "key"
            java.lang.String r6 = "setCacheItem error "
            java.lang.String r7 = "JS-Video-Brigde"
            r8 = 1
            r9 = 0
            java.lang.String r10 = ""
            if (r0 == 0) goto L_0x0084
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0057 }
            if (r0 != 0) goto L_0x0059
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0057 }
            r0.<init>(r13)     // Catch:{ all -> 0x0057 }
            java.lang.String r13 = r0.getString(r5)     // Catch:{ all -> 0x0057 }
            java.lang.String r0 = r0.getString(r4)     // Catch:{ all -> 0x0057 }
            boolean r1 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0057 }
            if (r1 != 0) goto L_0x005b
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0057 }
            if (r1 != 0) goto L_0x005b
            com.mbridge.msdk.foundation.tools.FastKV r1 = r11.f12681e     // Catch:{ Exception -> 0x005b }
            r1.putString(r13, r0)     // Catch:{ Exception -> 0x005b }
            goto L_0x005b
        L_0x0057:
            r13 = move-exception
            goto L_0x005e
        L_0x0059:
            r8 = r9
            r3 = r10
        L_0x005b:
            r9 = r8
            goto L_0x00e1
        L_0x005e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.foundation.tools.af.b(r7, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r13 = r13.getMessage()
            r0.append(r13)
            java.lang.String r3 = r0.toString()
            goto L_0x00e1
        L_0x0084:
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x00bb }
            android.content.Context r0 = r0.c()     // Catch:{ all -> 0x00bb }
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r9)     // Catch:{ all -> 0x00bb }
            boolean r1 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x00bb }
            if (r1 != 0) goto L_0x0059
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x00bb }
            r1.<init>(r13)     // Catch:{ all -> 0x00bb }
            java.lang.String r13 = r1.getString(r5)     // Catch:{ all -> 0x00bb }
            java.lang.String r1 = r1.getString(r4)     // Catch:{ all -> 0x00bb }
            boolean r4 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x00bb }
            if (r4 != 0) goto L_0x005b
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00bb }
            if (r4 != 0) goto L_0x005b
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x00bb }
            android.content.SharedPreferences$Editor r13 = r0.putString(r13, r1)     // Catch:{ all -> 0x00bb }
            r13.apply()     // Catch:{ all -> 0x00bb }
            goto L_0x005b
        L_0x00bb:
            r13 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.foundation.tools.af.b(r7, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r13 = r13.getMessage()
            r0.append(r13)
            java.lang.String r3 = r0.toString()
        L_0x00e1:
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ all -> 0x011f }
            r13.<init>()     // Catch:{ all -> 0x011f }
            java.lang.String r0 = "code"
            r1 = r9 ^ 1
            r13.put(r0, r1)     // Catch:{ all -> 0x011f }
            java.lang.String r0 = "message"
            r13.put(r0, r3)     // Catch:{ all -> 0x011f }
            r0 = 2
            if (r12 == 0) goto L_0x010b
            if (r9 == 0) goto L_0x010b
            com.mbridge.msdk.mbsignalcommon.windvane.g r1 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ all -> 0x011f }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x011f }
            byte[] r13 = r13.getBytes()     // Catch:{ all -> 0x011f }
            java.lang.String r13 = android.util.Base64.encodeToString(r13, r0)     // Catch:{ all -> 0x011f }
            r1.a(r12, r13)     // Catch:{ all -> 0x011f }
            goto L_0x0122
        L_0x010b:
            com.mbridge.msdk.mbsignalcommon.windvane.g r1 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ all -> 0x011f }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x011f }
            byte[] r13 = r13.getBytes()     // Catch:{ all -> 0x011f }
            java.lang.String r13 = android.util.Base64.encodeToString(r13, r0)     // Catch:{ all -> 0x011f }
            r1.b(r12, r13)     // Catch:{ all -> 0x011f }
            goto L_0x0122
        L_0x011f:
            com.mbridge.msdk.foundation.tools.af.b(r7, r6)
        L_0x0122:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.communication.BaseVideoCommunication.setCacheItem(java.lang.Object, java.lang.String):void");
    }

    public void setScaleFitXY(Object obj, String str) {
        try {
            if (this.f12680a != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt("fitxy");
                af.c("JS-Video-Brigde", "setScaleFitXY,type:" + optInt);
                this.f12680a.getJSVideoModule().setScaleFitXY(optInt);
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "showVideoClickView error", th);
        }
    }

    public void setSubPlayTemplateInfo(Object obj, String str) {
        af.b("JS-Video-Brigde", "setSubPlayTemplateInfo : " + str);
        a(obj, str);
        try {
            d.c().K(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "setSubPlayTemplateInfo error " + th);
        }
    }

    public void setViewAlpha(Object obj, String str) {
        a(obj, str);
        try {
            d.c().q(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "setViewAlpha error " + th);
        }
    }

    public void setViewBgColor(Object obj, String str) {
        a(obj, str);
        try {
            d.c().p(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "setViewBgColor error " + th);
        }
    }

    public void setViewRect(Object obj, String str) {
        a(obj, str);
        try {
            d.c().g(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "setViewRect error " + th);
        }
    }

    public void setViewScale(Object obj, String str) {
        a(obj, str);
        try {
            d.c().r(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "setViewScale error " + th);
        }
    }

    public void showAlertView(Object obj, String str) {
        af.c("JS-Video-Brigde", "showAlertView");
        try {
            if (this.f12680a != null && !TextUtils.isEmpty(str)) {
                this.f12680a.getJSVideoModule().showIVRewardAlertView(str);
                g.a().a(obj, "showAlertView", "");
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "showAlertView", th);
        }
    }

    public void showVideoClickView(Object obj, String str) {
        try {
            if (this.f12680a != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                af.c("JS-Video-Brigde", "showVideoClickView,type:" + optInt);
                this.f12680a.getJSContainerModule().showVideoClickView(optInt);
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "showVideoClickView error", th);
        }
    }

    public void showVideoLocation(Object obj, String str) {
        try {
            if (this.f12680a != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("margin_top", 0);
                int optInt2 = jSONObject.optInt("margin_left", 0);
                int optInt3 = jSONObject.optInt("view_width", 0);
                int optInt4 = jSONObject.optInt("view_height", 0);
                int optInt5 = jSONObject.optInt("radius", 0);
                int optInt6 = jSONObject.optInt("border_top", 0);
                int optInt7 = jSONObject.optInt("border_left", 0);
                int optInt8 = jSONObject.optInt("border_width", 0);
                int optInt9 = jSONObject.optInt("border_height", 0);
                af.c("JS-Video-Brigde", "showVideoLocation,margin_top:" + optInt + ",marginLeft:" + optInt2 + ",viewWidth:" + optInt3 + ",viewHeight:" + optInt4 + ",radius:" + optInt5 + ",borderTop: " + optInt6 + ",borderLeft: " + optInt7 + ",borderWidth: " + optInt8 + ",borderHeight: " + optInt9);
                this.f12680a.getJSVideoModule().showVideoLocation(optInt, optInt2, optInt3, optInt4, optInt5, optInt6, optInt7, optInt8, optInt9);
                this.f12680a.getJSCommon().f();
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "showVideoLocation error", th);
        }
    }

    public void showView(Object obj, String str) {
        a(obj, str);
        try {
            d.c().o(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "showView error " + th);
        }
    }

    public void soundOperate(Object obj, String str) {
        try {
            if (this.f12680a != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
                int optInt2 = jSONObject.optInt("view_visible");
                String optString = jSONObject.optString("pt", "");
                af.c("JS-Video-Brigde", "soundOperate,mute:" + optInt + ",viewVisible:" + optInt2 + ",pt:" + optString);
                if (TextUtils.isEmpty(optString)) {
                    this.f12680a.getJSVideoModule().soundOperate(optInt, optInt2);
                } else {
                    this.f12680a.getJSVideoModule().soundOperate(optInt, optInt2, optString);
                }
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "soundOperate error", th);
        }
    }

    public void statistics(Object obj, String str) {
        af.c("JS-Video-Brigde", "statistics,params:" + str);
        try {
            if (this.f12680a != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.f12680a.getJSCommon().a(jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY), jSONObject.optString(DataSchemeDataSource.SCHEME_DATA));
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "statistics error", th);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.f12680a != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt(MRAIDCommunicatorUtil.KEY_STATE);
                af.c("JS-Video-Brigde", "toggleCloseBtn,result:" + optInt);
                int i5 = 2;
                if (optInt != 1) {
                    if (optInt == 2) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                }
                this.f12680a.getJSVideoModule().closeVideoOperate(0, i5);
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "toggleCloseBtn", th);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        af.c("JS-Video-Brigde", "triggerCloseBtn");
        try {
            if (this.f12680a != null && !TextUtils.isEmpty(str) && new JSONObject(str).optString(MRAIDCommunicatorUtil.KEY_STATE).equals(CampaignEx.JSON_NATIVE_VIDEO_CLICK)) {
                this.f12680a.getJSVideoModule().closeVideoOperate(1, -1);
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "triggerCloseBtn error", th);
        }
    }

    public void videoOperate(Object obj, String str) {
        try {
            if (this.f12680a != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt("pause_or_resume");
                af.c("JS-Video-Brigde", "videoOperate,pauseOrResume:" + optInt);
                this.f12680a.getJSVideoModule().videoOperate(optInt);
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "videoOperate error", th);
        }
    }

    public void webviewFireEvent(Object obj, String str) {
        a(obj, str);
        try {
            d.c().L(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "setSubPlayTemplateInfo error " + th);
        }
    }

    public void webviewGoBack(Object obj, String str) {
        a(obj, str);
        try {
            d.c().v(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "webviewGoBack error " + th);
        }
    }

    public void webviewGoForward(Object obj, String str) {
        a(obj, str);
        try {
            d.c().w(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "webviewGoForward error " + th);
        }
    }

    public void webviewLoad(Object obj, String str) {
        a(obj, str);
        try {
            d.c().t(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "webviewLoad error " + th);
        }
    }

    public void webviewReload(Object obj, String str) {
        a(obj, str);
        try {
            d.c().u(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "webviewReload error " + th);
        }
    }

    private void a(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 1);
                jSONObject.put("message", "params is null");
                g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Exception e5) {
            af.a("JS-Video-Brigde", e5.getMessage());
        }
    }
}
