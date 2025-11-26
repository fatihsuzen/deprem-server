package com.mbridge.msdk.video.bt.a;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.at;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.b;
import com.mbridge.msdk.video.bt.module.BTBaseView;
import com.mbridge.msdk.video.bt.module.MBTempContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTLayout;
import com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC;
import com.mbridge.msdk.video.bt.module.MBridgeBTVideoView;
import com.mbridge.msdk.video.bt.module.MBridgeBTWebView;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.videocommon.d.c;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, LinkedHashMap<String, View>> f11778a = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static LinkedHashMap<String, String> f11779b = new LinkedHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static LinkedHashMap<String, CampaignEx> f11780c = new LinkedHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static LinkedHashMap<String, c> f11781d = new LinkedHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private static LinkedHashMap<String, String> f11782e = new LinkedHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private static LinkedHashMap<String, Integer> f11783f = new LinkedHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private static LinkedHashMap<String, Activity> f11784g = new LinkedHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private static volatile int f11785h = 10000;

    /* renamed from: i  reason: collision with root package name */
    private static int f11786i = 0;

    /* renamed from: j  reason: collision with root package name */
    private static int f11787j = 1;

    /* renamed from: k  reason: collision with root package name */
    private static String f11788k = "";

    /* renamed from: l  reason: collision with root package name */
    private static int f11789l;

    /* renamed from: m  reason: collision with root package name */
    private static int f11790m;

    /* renamed from: n  reason: collision with root package name */
    private static int f11791n;

    /* renamed from: o  reason: collision with root package name */
    private static int f11792o;

    /* renamed from: p  reason: collision with root package name */
    private static int f11793p;

    private String h(String str) {
        if (f11779b.containsKey(str)) {
            return f11779b.get(str);
        }
        return "";
    }

    public final void A(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).stop();
                    a(obj, optString2);
                    af.a("OperateViews", "playerStop success");
                    return;
                }
                c(obj, "instanceId is not player");
                af.a("OperateViews", "playerStop failed instanceId is not player instanceId = " + optString2);
                return;
            }
            c(obj, "instanceId not exit");
            af.a("OperateViews", "playerStop failed instanceId not exit instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "playerStop failed: " + th.getMessage());
        }
    }

    public final void B(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public final void C(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (!(view instanceof MBridgeBTVideoView)) {
                    c(obj, "instanceId is not player");
                    af.a("OperateViews", "playerMute failed: instanceId is not player");
                } else if (((MBridgeBTVideoView) view).playMute()) {
                    a(obj, optString2);
                    af.a("OperateViews", "playerMute success");
                } else {
                    c(obj, "set mute failed");
                    af.a("OperateViews", "playerMute failed set mute failed");
                }
            } else {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "playerMute failed: instanceId is not exist");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "playerMute failed: " + th.getMessage());
        }
    }

    public final void D(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (!(view instanceof MBridgeBTVideoView)) {
                    c(obj, "instanceId is not player");
                    af.a("OperateViews", "playerUnmute failed: instanceId is not player");
                } else if (((MBridgeBTVideoView) view).playUnMute()) {
                    a(obj, optString2);
                    a(obj, "onUnmute", optString2);
                    af.a("OperateViews", "playerUnmute successed");
                } else {
                    a(obj, "set unmute failed");
                    af.a("OperateViews", "playerUnmute failed: set unmute failed");
                }
            } else {
                c(obj, "instanceId not exit");
                af.a("OperateViews", "playerUnmute failed: instanceId not exit");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "playerUnmute failed: " + th.getMessage());
        }
    }

    public final void E(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (view instanceof MBridgeBTVideoView) {
                    int mute = ((MBridgeBTVideoView) view).getMute();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", f11786i);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("id", optString2);
                    jSONObject3.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, mute);
                    jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject3);
                    g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    af.a("OperateViews", "playerGetMuteState successed mute = " + mute);
                    return;
                }
                c(obj, "instanceId is not player");
                af.a("OperateViews", "playerGetMuteState failed instanceId is not player");
                return;
            }
            c(obj, "instanceId not exist");
            af.a("OperateViews", "playerGetMuteState failed instanceId not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "playerGetMuteState failed: " + th.getMessage());
        }
    }

    public final void F(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public final void G(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            jSONObject.optString("id");
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
            } else {
                c(obj, "android mediaPlayer not support setScaleType");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public final void H(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).preload();
                    a(obj, optString2);
                    return;
                }
                c(obj, "view not exist");
                return;
            }
            c(obj, "instanceId not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "preloadSubPlayTemplateView failed: " + th.getMessage());
        }
    }

    /* JADX WARNING: type inference failed for: r6v2, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void I(java.lang.Object r9, org.json.JSONObject r10) {
        /*
            r8 = this;
            java.lang.String r0 = "OperateViews"
            java.lang.String r1 = "unitId"
            java.lang.String r1 = r10.optString(r1)     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = "id"
            java.lang.String r2 = r10.optString(r2)     // Catch:{ all -> 0x0024 }
            java.lang.String r3 = r8.h(r2)     // Catch:{ all -> 0x0024 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0024 }
            if (r4 == 0) goto L_0x0027
            r4 = r9
            com.mbridge.msdk.mbsignalcommon.windvane.a r4 = (com.mbridge.msdk.mbsignalcommon.windvane.a) r4     // Catch:{ all -> 0x0024 }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r4 = r4.f10205b     // Catch:{ all -> 0x0024 }
            if (r4 == 0) goto L_0x0027
            java.lang.String r3 = r4.getRid()     // Catch:{ all -> 0x0024 }
            goto L_0x0027
        L_0x0024:
            r10 = move-exception
            goto L_0x00d2
        L_0x0027:
            java.lang.String r4 = "data"
            org.json.JSONObject r10 = r10.optJSONObject(r4)     // Catch:{ all -> 0x0024 }
            if (r10 != 0) goto L_0x0035
            java.lang.String r10 = "data is empty"
            r8.c((java.lang.Object) r9, (java.lang.String) r10)     // Catch:{ all -> 0x0024 }
            return
        L_0x0035:
            java.util.LinkedHashMap r10 = r8.b((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x0024 }
            int r4 = r10.size()     // Catch:{ all -> 0x0024 }
            if (r4 <= 0) goto L_0x00b8
            java.util.Collection r4 = r10.values()     // Catch:{ all -> 0x0024 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0024 }
            r5 = 0
        L_0x0048:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x0024 }
            if (r6 == 0) goto L_0x0083
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x0024 }
            android.view.View r6 = (android.view.View) r6     // Catch:{ all -> 0x0024 }
            boolean r7 = r6 instanceof com.mbridge.msdk.video.bt.module.MBridgeBTContainer     // Catch:{ all -> 0x0024 }
            if (r7 == 0) goto L_0x005c
            r5 = r6
            com.mbridge.msdk.video.bt.module.MBridgeBTContainer r5 = (com.mbridge.msdk.video.bt.module.MBridgeBTContainer) r5     // Catch:{ all -> 0x0024 }
            goto L_0x0048
        L_0x005c:
            boolean r7 = r6 instanceof com.mbridge.msdk.video.bt.module.MBridgeBTWebView     // Catch:{ all -> 0x0024 }
            if (r7 == 0) goto L_0x0066
            com.mbridge.msdk.video.bt.module.MBridgeBTWebView r6 = (com.mbridge.msdk.video.bt.module.MBridgeBTWebView) r6     // Catch:{ all -> 0x0024 }
            r6.onDestory()     // Catch:{ all -> 0x0024 }
            goto L_0x0048
        L_0x0066:
            boolean r7 = r6 instanceof com.mbridge.msdk.video.bt.module.MBridgeBTVideoView     // Catch:{ all -> 0x0024 }
            if (r7 == 0) goto L_0x0079
            r7 = r6
            com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r7 = (com.mbridge.msdk.video.bt.module.MBridgeBTVideoView) r7     // Catch:{ all -> 0x0024 }
            r7.getInstanceId()     // Catch:{ all -> 0x0024 }
            com.mbridge.msdk.video.bt.a.b unused = com.mbridge.msdk.video.bt.a.b.a.f11811a     // Catch:{ all -> 0x0024 }
            com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r6 = (com.mbridge.msdk.video.bt.module.MBridgeBTVideoView) r6     // Catch:{ all -> 0x0024 }
            r6.onDestory()     // Catch:{ all -> 0x0024 }
            goto L_0x0048
        L_0x0079:
            boolean r7 = r6 instanceof com.mbridge.msdk.video.bt.module.MBTempContainer     // Catch:{ all -> 0x0024 }
            if (r7 == 0) goto L_0x0048
            com.mbridge.msdk.video.bt.module.MBTempContainer r6 = (com.mbridge.msdk.video.bt.module.MBTempContainer) r6     // Catch:{ all -> 0x0024 }
            r6.onDestroy()     // Catch:{ all -> 0x0024 }
            goto L_0x0048
        L_0x0083:
            if (r5 == 0) goto L_0x00ad
            r5.onAdClose()     // Catch:{ all -> 0x0024 }
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.LinkedHashMap<java.lang.String, android.view.View>> r4 = f11778a     // Catch:{ all -> 0x0024 }
            r4.remove(r10)     // Catch:{ all -> 0x0024 }
            r10.clear()     // Catch:{ all -> 0x0024 }
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.LinkedHashMap<java.lang.String, android.view.View>> r10 = f11778a     // Catch:{ all -> 0x0024 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0024 }
            r4.<init>()     // Catch:{ all -> 0x0024 }
            r4.append(r1)     // Catch:{ all -> 0x0024 }
            java.lang.String r1 = "_"
            r4.append(r1)     // Catch:{ all -> 0x0024 }
            r4.append(r3)     // Catch:{ all -> 0x0024 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0024 }
            r10.remove(r1)     // Catch:{ all -> 0x0024 }
            r8.a((java.lang.Object) r9, (java.lang.String) r2)     // Catch:{ all -> 0x0024 }
            return
        L_0x00ad:
            java.lang.String r10 = "not found MBridgeBTContainer"
            r8.c((java.lang.Object) r9, (java.lang.String) r10)     // Catch:{ all -> 0x0024 }
            java.lang.String r10 = "closeAd successed"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r10)     // Catch:{ all -> 0x0024 }
            return
        L_0x00b8:
            java.lang.String r10 = "unitId or instanceId not exist"
            r8.c((java.lang.Object) r9, (java.lang.String) r10)     // Catch:{ all -> 0x0024 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0024 }
            r10.<init>()     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = "closeAd failed: unitId or instanceId not exist unitId = "
            r10.append(r2)     // Catch:{ all -> 0x0024 }
            r10.append(r1)     // Catch:{ all -> 0x0024 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0024 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r10)     // Catch:{ all -> 0x0024 }
            return
        L_0x00d2:
            java.lang.String r1 = r10.getMessage()
            r8.c((java.lang.Object) r9, (java.lang.String) r1)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "closeAd failed: "
            r9.append(r1)
            java.lang.String r10 = r10.getMessage()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.a.a.I(java.lang.Object, org.json.JSONObject):void");
    }

    public final void J(Object obj, JSONObject jSONObject) {
        String str;
        try {
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b;
            if (windVaneWebView != null) {
                str = windVaneWebView.getRid();
            } else {
                str = "";
            }
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("eventName");
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            LinkedHashMap<String, View> b5 = b(optString, str);
            if (b5 == null || b5.size() <= 0) {
                c(obj, "unitId not exist");
                return;
            }
            for (View next : b5.values()) {
                if (next instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) next).broadcast(optString2, optJSONObject);
                }
                if (next instanceof MBridgeBTLayout) {
                    ((MBridgeBTLayout) next).broadcast(optString2, optJSONObject);
                }
            }
            a(obj, "");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "broadcast failed: " + th.getMessage());
        }
    }

    public final void K(Object obj, JSONObject jSONObject) {
        String str;
        com.mbridge.msdk.videocommon.b.c cVar;
        String str2;
        try {
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b;
            if (windVaneWebView != null) {
                str = windVaneWebView.getRid();
            } else {
                str = "";
            }
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            String optString3 = optJSONObject.optString("userId");
            boolean optBoolean = optJSONObject.optBoolean("expired");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("reward");
            String optString4 = optJSONObject.optString("extra");
            if (optJSONObject2 != null) {
                cVar = new com.mbridge.msdk.videocommon.b.c(optJSONObject2.optString(RewardPlus.NAME), optJSONObject2.optInt(RewardPlus.AMOUNT));
                str2 = optJSONObject2.optString("id");
            } else {
                cVar = null;
                str2 = "";
            }
            LinkedHashMap<String, View> b5 = b(optString, str);
            if (b5.size() <= 0 || !f11782e.containsKey(optString2)) {
                c(obj, "unitId not exist");
                af.a("OperateViews", "setSubPlayTemplateInfo failed: unitId not exist instanceId = " + optString2);
                return;
            }
            View view = b5.get(optString2);
            if (view instanceof MBTempContainer) {
                MBTempContainer mBTempContainer = (MBTempContainer) view;
                mBTempContainer.setReward(cVar);
                mBTempContainer.setUserId(optString3);
                mBTempContainer.setRewardId(str2);
                mBTempContainer.setCampaignExpired(optBoolean);
                if (!TextUtils.isEmpty(optString4)) {
                    mBTempContainer.setDeveloperExtraData(optString4);
                }
                a(obj, optString2);
                af.a("OperateViews", "setSubPlayTemplateInfo success instanceId = " + optString2);
                return;
            }
            c(obj, "instanceId not exist");
            af.a("OperateViews", "setSubPlayTemplateInfo failed: instanceId not exist instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "setSubPlayTemplateInfo failed: " + th.getMessage());
        }
    }

    public final void L(Object obj, JSONObject jSONObject) {
        try {
            String str = "";
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b;
            if (windVaneWebView != null) {
                str = windVaneWebView.getRid();
            }
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            String optString3 = optJSONObject.optString("eventName");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("eventData");
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            LinkedHashMap<String, View> b5 = b(optString, str);
            if (b5.size() > 0) {
                View view = b5.get(optString2);
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt = viewGroup.getChildAt(i5);
                        if (childAt instanceof WindVaneWebView) {
                            g.a().a((WebView) (WindVaneWebView) childAt, optString3, Base64.encodeToString(optJSONObject2.toString().getBytes(), 2));
                            a(obj, optString2);
                            af.a("OperateViews", "webviewFireEvent instanceId = " + optString2);
                            return;
                        }
                    }
                }
                c(obj, "instanceId not exist");
                af.a("OperateViews", "webviewFireEvent failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            c(obj, "unitId not exist");
            af.a("OperateViews", "webviewFireEvent failed: unitId not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "webviewFireEvent failed: " + th.getMessage());
        }
    }

    public final void M(Object obj, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            final CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject);
            if (parseCampaignWithBackData == null) {
                c(obj, "data camapign is empty");
                return;
            }
            new Thread(new Runnable() {
                public final void run() {
                    try {
                        j a5 = j.a((f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
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
                        a.a(a.this, parseCampaignWithBackData.getCampaignUnitId(), parseCampaignWithBackData);
                    } catch (Throwable th) {
                        af.b("OperateViews", th.getMessage(), th);
                    }
                }
            }).start();
            a(obj, "");
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public final void N(Object obj, JSONObject jSONObject) {
        String str;
        int i5;
        boolean z4;
        String str2;
        String str3;
        String str4;
        Object obj2 = obj;
        JSONObject jSONObject2 = jSONObject;
        String str5 = "";
        JSONObject jSONObject3 = new JSONObject();
        int i6 = 1;
        if (jSONObject2 == null) {
            try {
                jSONObject3.put("code", 1);
                jSONObject3.put("message", "params is null");
                g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
            } catch (JSONException e5) {
                af.a("OperateViews", e5.getMessage());
            }
        } else {
            try {
                jSONObject3.put("code", 0);
                jSONObject3.put("message", str5);
                JSONArray jSONArray = jSONObject2.getJSONArray("resource");
                if (jSONArray == null || jSONArray.length() <= 0) {
                    try {
                        jSONObject3.put("code", 1);
                        jSONObject3.put("message", "resource is null");
                        g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                    } catch (JSONException e6) {
                        af.a("OperateViews", e6.getMessage());
                    }
                } else {
                    JSONArray jSONArray2 = new JSONArray();
                    int length = jSONArray.length();
                    int i7 = 0;
                    while (i7 < length) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i7);
                        String optString = jSONObject4.optString("ref", str5);
                        int i8 = jSONObject4.getInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                        JSONObject jSONObject5 = new JSONObject();
                        JSONArray jSONArray3 = jSONArray;
                        if (i8 == i6) {
                            if (!TextUtils.isEmpty(optString)) {
                                JSONObject jSONObject6 = new JSONObject();
                                m a5 = n.a((f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(optString);
                                if (a5 != null) {
                                    m mVar = a5;
                                    af.a("OperateViews", "VideoBean not null");
                                    jSONObject6.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
                                    i5 = length;
                                    jSONObject6.put("videoDataLength", mVar.d());
                                    String e7 = mVar.e();
                                    if (TextUtils.isEmpty(e7)) {
                                        af.a("OperateViews", "VideoPath null");
                                        jSONObject6.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str5);
                                        jSONObject6.put("path4Web", str5);
                                        str = str5;
                                    } else {
                                        str = str5;
                                        af.a("OperateViews", "VideoPath not null");
                                        jSONObject6.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, e7);
                                        jSONObject6.put("path4Web", e7);
                                    }
                                    if (mVar.b() == 5) {
                                        jSONObject6.put("downloaded", 1);
                                        z4 = false;
                                    } else {
                                        z4 = false;
                                        jSONObject6.put("downloaded", 0);
                                    }
                                    jSONObject5.put(optString, jSONObject6);
                                    jSONArray2.put(jSONObject5);
                                } else {
                                    str = str5;
                                    i5 = length;
                                    z4 = false;
                                    af.a("OperateViews", "VideoBean null");
                                }
                                i7++;
                                jSONArray = jSONArray3;
                                boolean z5 = z4;
                                length = i5;
                                str5 = str;
                                i6 = 1;
                            }
                        }
                        str = str5;
                        i5 = length;
                        z4 = false;
                        if (i8 == 2 && !TextUtils.isEmpty(optString)) {
                            JSONObject jSONObject7 = new JSONObject();
                            jSONObject7.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                            if (H5DownLoadManager.getInstance().getH5ResAddress(optString) == null) {
                                str4 = str;
                            } else {
                                str4 = H5DownLoadManager.getInstance().getH5ResAddress(optString);
                            }
                            jSONObject7.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str4);
                            jSONObject5.put(optString, jSONObject7);
                            jSONArray2.put(jSONObject5);
                            i7++;
                            jSONArray = jSONArray3;
                            boolean z52 = z4;
                            length = i5;
                            str5 = str;
                            i6 = 1;
                        } else if (i8 != 3 || TextUtils.isEmpty(optString)) {
                            if (i8 == 4 && !TextUtils.isEmpty(optString)) {
                                JSONObject jSONObject8 = new JSONObject();
                                jSONObject8.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 4);
                                if (aj.a(optString) == null) {
                                    str2 = str;
                                } else {
                                    str2 = aj.a(optString);
                                }
                                jSONObject8.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str2);
                                jSONObject5.put(optString, jSONObject8);
                                jSONArray2.put(jSONObject5);
                            }
                            i7++;
                            jSONArray = jSONArray3;
                            boolean z522 = z4;
                            length = i5;
                            str5 = str;
                            i6 = 1;
                        } else {
                            File file = new File(optString);
                            if (file.exists() && file.isFile() && file.canRead()) {
                                af.a("OperateViews", "getFileInfo Mraid file " + optString);
                                str3 = "file:////" + optString;
                                JSONObject jSONObject9 = new JSONObject();
                                jSONObject9.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 3);
                                jSONObject9.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str3);
                                jSONObject5.put(optString, jSONObject9);
                                jSONArray2.put(jSONObject5);
                                i7++;
                                jSONArray = jSONArray3;
                                boolean z5222 = z4;
                                length = i5;
                                str5 = str;
                                i6 = 1;
                            }
                            str3 = str;
                            JSONObject jSONObject92 = new JSONObject();
                            jSONObject92.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 3);
                            jSONObject92.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str3);
                            jSONObject5.put(optString, jSONObject92);
                            jSONArray2.put(jSONObject5);
                            i7++;
                            jSONArray = jSONArray3;
                            boolean z52222 = z4;
                            length = i5;
                            str5 = str;
                            i6 = 1;
                        }
                    }
                    jSONObject3.put("resource", jSONArray2);
                    g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                }
            } catch (Throwable th) {
                try {
                    jSONObject3.put("code", 1);
                    jSONObject3.put("message", th.getLocalizedMessage());
                    g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                } catch (JSONException e8) {
                    af.a("OperateViews", e8.getMessage());
                }
            }
        }
    }

    public final void O(Object obj, JSONObject jSONObject) {
        af.a("OperateViews", "createNativeEC:" + jSONObject);
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject != null) {
                if (!TextUtils.isEmpty(optString)) {
                    String str = "";
                    CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject.optJSONObject("campaign"));
                    if (parseCampaignWithBackData != null && !TextUtils.isEmpty(optString)) {
                        parseCampaignWithBackData.setCampaignUnitId(optString);
                        str = parseCampaignWithBackData.getRequestId();
                    }
                    c a5 = c.a(optJSONObject.optJSONObject("unitSetting"));
                    if (a5 != null) {
                        a5.a(optString);
                    }
                    MBridgeBTNativeEC mBridgeBTNativeEC = new MBridgeBTNativeEC(com.mbridge.msdk.foundation.controller.c.m().c());
                    mBridgeBTNativeEC.setCampaign(parseCampaignWithBackData);
                    k kVar = new k((Activity) null, parseCampaignWithBackData);
                    kVar.a(optString);
                    mBridgeBTNativeEC.setJSCommon(kVar);
                    mBridgeBTNativeEC.setUnitId(optString);
                    mBridgeBTNativeEC.setRewardUnitSetting(a5);
                    WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b;
                    if (windVaneWebView != null) {
                        str = windVaneWebView.getRid();
                        mBridgeBTNativeEC.setCreateWebView(windVaneWebView);
                    }
                    LinkedHashMap<String, View> b5 = b(optString, str);
                    String a6 = a();
                    f11779b.put(a6, str);
                    mBridgeBTNativeEC.setInstanceId(a6);
                    b5.put(a6, mBridgeBTNativeEC);
                    mBridgeBTNativeEC.preLoadData();
                    if (parseCampaignWithBackData == null) {
                        c(obj, "campaign is null");
                        af.a("OperateViews", "createNativeEC failed");
                        return;
                    }
                    a(obj, a6);
                    af.a("OperateViews", "createNativeEC instanceId = " + a6);
                    return;
                }
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "createNativeEC failed：" + th.getMessage());
        }
    }

    public final String a() {
        f11785h++;
        return String.valueOf(f11785h);
    }

    public final String c(String str) {
        if (f11782e.containsKey(str)) {
            return f11782e.get(str);
        }
        return "";
    }

    public final void d(String str) {
        f11784g.remove(str);
    }

    public final int e(String str) {
        if (f11783f.containsKey(str)) {
            return f11783f.get(str).intValue();
        }
        return 2;
    }

    public final void f(String str) {
        if (f11782e.containsKey(str)) {
            f11782e.remove(str);
        }
        if (f11781d.containsKey(str)) {
            f11781d.remove(str);
        }
        if (f11780c.containsKey(str)) {
            f11780c.remove(str);
        }
        if (f11779b.containsKey(str)) {
            f11779b.remove(str);
        }
    }

    public final void g(String str) {
        if (f11783f.containsKey(str)) {
            f11783f.remove(str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e1, code lost:
        com.mbridge.msdk.foundation.tools.at.a(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r0 = (com.mbridge.msdk.video.bt.module.MBTempContainer) r8;
        r7 = (com.mbridge.msdk.video.signal.a.k) ((com.mbridge.msdk.mbsignalcommon.windvane.a) r2).f10205b.getObject();
        r0.setAdEvents(r7.l());
        r0.setAdSession(r7.j());
        r0.setVideoEvents(r7.k());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(java.lang.Object r17, org.json.JSONObject r18) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r0 = r18
            java.lang.String r3 = "id"
            java.lang.String r4 = "OperateViews"
            java.lang.String r5 = "unitId"
            java.lang.String r5 = r0.optString(r5)     // Catch:{ all -> 0x002a }
            java.lang.String r6 = r0.optString(r3)     // Catch:{ all -> 0x002a }
            java.lang.String r7 = r1.h(r6)     // Catch:{ all -> 0x002a }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x002a }
            if (r8 == 0) goto L_0x002d
            r8 = r2
            com.mbridge.msdk.mbsignalcommon.windvane.a r8 = (com.mbridge.msdk.mbsignalcommon.windvane.a) r8     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r8 = r8.f10205b     // Catch:{ all -> 0x002a }
            if (r8 == 0) goto L_0x002d
            java.lang.String r7 = r8.getRid()     // Catch:{ all -> 0x002a }
            goto L_0x002d
        L_0x002a:
            r0 = move-exception
            goto L_0x01cf
        L_0x002d:
            java.lang.String r8 = "data"
            org.json.JSONObject r0 = r0.optJSONObject(r8)     // Catch:{ all -> 0x002a }
            if (r0 != 0) goto L_0x003b
            java.lang.String r0 = "data is empty"
            r1.c((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ all -> 0x002a }
            return
        L_0x003b:
            java.lang.String r3 = r0.optString(r3)     // Catch:{ all -> 0x002a }
            java.util.LinkedHashMap r5 = r1.b((java.lang.String) r5, (java.lang.String) r7)     // Catch:{ all -> 0x002a }
            boolean r7 = r5.containsKey(r3)     // Catch:{ all -> 0x002a }
            if (r7 == 0) goto L_0x01c4
            boolean r7 = r5.containsKey(r6)     // Catch:{ all -> 0x002a }
            if (r7 == 0) goto L_0x01c4
            java.lang.Object r7 = r5.get(r6)     // Catch:{ all -> 0x002a }
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7     // Catch:{ all -> 0x002a }
            java.lang.Object r8 = r5.get(r3)     // Catch:{ all -> 0x002a }
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.foundation.tools.at.a(r8)     // Catch:{ all -> 0x002a }
            if (r7 == 0) goto L_0x01be
            if (r8 != 0) goto L_0x0064
            goto L_0x01be
        L_0x0064:
            java.lang.String r9 = "rect"
            org.json.JSONObject r9 = r0.optJSONObject(r9)     // Catch:{ all -> 0x002a }
            boolean r0 = r8 instanceof com.mbridge.msdk.video.bt.module.MBTempContainer     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x011c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
            r0.<init>()     // Catch:{ all -> 0x002a }
            java.lang.String r7 = "OperateViews setNotchString = "
            r0.append(r7)     // Catch:{ all -> 0x002a }
            java.lang.String r7 = "%1$s-%2$s-%3$s-%4$s-%5$s"
            int r11 = f11789l     // Catch:{ all -> 0x002a }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x002a }
            int r12 = f11790m     // Catch:{ all -> 0x002a }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x002a }
            int r13 = f11791n     // Catch:{ all -> 0x002a }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x002a }
            int r14 = f11792o     // Catch:{ all -> 0x002a }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x002a }
            int r15 = f11793p     // Catch:{ all -> 0x002a }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x002a }
            r18 = 0
            r10 = 5
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ all -> 0x002a }
            r10[r18] = r11     // Catch:{ all -> 0x002a }
            r11 = 1
            r10[r11] = r12     // Catch:{ all -> 0x002a }
            r11 = 2
            r10[r11] = r13     // Catch:{ all -> 0x002a }
            r11 = 3
            r10[r11] = r14     // Catch:{ all -> 0x002a }
            r11 = 4
            r10[r11] = r15     // Catch:{ all -> 0x002a }
            java.lang.String r7 = java.lang.String.format(r7, r10)     // Catch:{ all -> 0x002a }
            r0.append(r7)     // Catch:{ all -> 0x002a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.foundation.tools.af.b(r4, r0)     // Catch:{ all -> 0x002a }
            r10 = r8
            com.mbridge.msdk.video.bt.module.MBTempContainer r10 = (com.mbridge.msdk.video.bt.module.MBTempContainer) r10     // Catch:{ all -> 0x002a }
            int r11 = f11789l     // Catch:{ all -> 0x002a }
            int r12 = f11790m     // Catch:{ all -> 0x002a }
            int r13 = f11791n     // Catch:{ all -> 0x002a }
            int r14 = f11792o     // Catch:{ all -> 0x002a }
            int r15 = f11793p     // Catch:{ all -> 0x002a }
            r10.setNotchPadding(r11, r12, r13, r14, r15)     // Catch:{ all -> 0x002a }
            java.util.Collection r0 = r5.values()     // Catch:{ all -> 0x002a }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x002a }
        L_0x00d1:
            boolean r5 = r0.hasNext()     // Catch:{ all -> 0x002a }
            if (r5 == 0) goto L_0x0199
            java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x002a }
            android.view.View r5 = (android.view.View) r5     // Catch:{ all -> 0x002a }
            boolean r7 = r5 instanceof com.mbridge.msdk.video.bt.module.MBridgeBTContainer     // Catch:{ all -> 0x002a }
            if (r7 == 0) goto L_0x00d1
            com.mbridge.msdk.foundation.tools.at.a(r8)     // Catch:{ all -> 0x002a }
            r0 = r8
            com.mbridge.msdk.video.bt.module.MBTempContainer r0 = (com.mbridge.msdk.video.bt.module.MBTempContainer) r0     // Catch:{ Exception -> 0x0108 }
            r7 = r2
            com.mbridge.msdk.mbsignalcommon.windvane.a r7 = (com.mbridge.msdk.mbsignalcommon.windvane.a) r7     // Catch:{ Exception -> 0x0108 }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r7 = r7.f10205b     // Catch:{ Exception -> 0x0108 }
            java.lang.Object r7 = r7.getObject()     // Catch:{ Exception -> 0x0108 }
            com.mbridge.msdk.video.signal.a.k r7 = (com.mbridge.msdk.video.signal.a.k) r7     // Catch:{ Exception -> 0x0108 }
            u1.a r10 = r7.l()     // Catch:{ Exception -> 0x0108 }
            r0.setAdEvents(r10)     // Catch:{ Exception -> 0x0108 }
            u1.b r10 = r7.j()     // Catch:{ Exception -> 0x0108 }
            r0.setAdSession(r10)     // Catch:{ Exception -> 0x0108 }
            v1.b r7 = r7.k()     // Catch:{ Exception -> 0x0108 }
            r0.setVideoEvents(r7)     // Catch:{ Exception -> 0x0108 }
            goto L_0x0110
        L_0x0108:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.foundation.tools.af.b(r4, r0)     // Catch:{ all -> 0x002a }
        L_0x0110:
            r0 = r5
            com.mbridge.msdk.video.bt.module.MBridgeBTContainer r0 = (com.mbridge.msdk.video.bt.module.MBridgeBTContainer) r0     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.video.bt.module.MBridgeBTContainer r5 = (com.mbridge.msdk.video.bt.module.MBridgeBTContainer) r5     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.video.bt.module.MBTempContainer r8 = (com.mbridge.msdk.video.bt.module.MBTempContainer) r8     // Catch:{ all -> 0x002a }
            r0.appendSubView(r5, r8, r9)     // Catch:{ all -> 0x002a }
            goto L_0x0199
        L_0x011c:
            r18 = 0
            if (r9 != 0) goto L_0x013f
            boolean r0 = r8 instanceof com.mbridge.msdk.video.bt.module.BTBaseView     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x013a
            r0 = r8
            com.mbridge.msdk.video.bt.module.BTBaseView r0 = (com.mbridge.msdk.video.bt.module.BTBaseView) r0     // Catch:{ all -> 0x002a }
            android.graphics.Rect r0 = r0.getRect()     // Catch:{ all -> 0x002a }
            r5 = r8
            com.mbridge.msdk.video.bt.module.BTBaseView r5 = (com.mbridge.msdk.video.bt.module.BTBaseView) r5     // Catch:{ all -> 0x002a }
            int r10 = r5.getViewWidth()     // Catch:{ all -> 0x002a }
            r5 = r8
            com.mbridge.msdk.video.bt.module.BTBaseView r5 = (com.mbridge.msdk.video.bt.module.BTBaseView) r5     // Catch:{ all -> 0x002a }
            int r5 = r5.getViewHeight()     // Catch:{ all -> 0x002a }
            goto L_0x016c
        L_0x013a:
            r0 = 0
            r5 = r18
            r10 = r5
            goto L_0x016c
        L_0x013f:
            java.lang.String r0 = "left"
            r5 = -999(0xfffffffffffffc19, float:NaN)
            int r0 = r9.optInt(r0, r5)     // Catch:{ all -> 0x002a }
            java.lang.String r10 = "top"
            int r10 = r9.optInt(r10, r5)     // Catch:{ all -> 0x002a }
            java.lang.String r11 = "right"
            int r11 = r9.optInt(r11, r5)     // Catch:{ all -> 0x002a }
            java.lang.String r12 = "bottom"
            int r5 = r9.optInt(r12, r5)     // Catch:{ all -> 0x002a }
            android.graphics.Rect r12 = new android.graphics.Rect     // Catch:{ all -> 0x002a }
            r12.<init>(r0, r10, r11, r5)     // Catch:{ all -> 0x002a }
            java.lang.String r0 = "width"
            int r10 = r9.optInt(r0)     // Catch:{ all -> 0x002a }
            java.lang.String r0 = "height"
            int r0 = r9.optInt(r0)     // Catch:{ all -> 0x002a }
            r5 = r0
            r0 = r12
        L_0x016c:
            android.view.ViewGroup$LayoutParams r9 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x002a }
            r11 = -1
            r9.<init>(r11, r11)     // Catch:{ all -> 0x002a }
            boolean r12 = r7 instanceof android.widget.FrameLayout     // Catch:{ all -> 0x002a }
            if (r12 == 0) goto L_0x017c
            android.widget.FrameLayout$LayoutParams r9 = new android.widget.FrameLayout$LayoutParams     // Catch:{ all -> 0x002a }
            r9.<init>(r11, r11)     // Catch:{ all -> 0x002a }
            goto L_0x018f
        L_0x017c:
            boolean r12 = r7 instanceof android.widget.RelativeLayout     // Catch:{ all -> 0x002a }
            if (r12 == 0) goto L_0x0186
            android.widget.RelativeLayout$LayoutParams r9 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x002a }
            r9.<init>(r11, r11)     // Catch:{ all -> 0x002a }
            goto L_0x018f
        L_0x0186:
            boolean r12 = r7 instanceof android.widget.LinearLayout     // Catch:{ all -> 0x002a }
            if (r12 == 0) goto L_0x018f
            android.widget.LinearLayout$LayoutParams r9 = new android.widget.LinearLayout$LayoutParams     // Catch:{ all -> 0x002a }
            r9.<init>(r11, r11)     // Catch:{ all -> 0x002a }
        L_0x018f:
            android.view.ViewGroup$LayoutParams r0 = r1.a(r9, r0, r10, r5)     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.foundation.tools.at.a(r8)     // Catch:{ all -> 0x002a }
            r7.addView(r8, r0)     // Catch:{ all -> 0x002a }
        L_0x0199:
            r1.a((java.lang.Object) r2, (java.lang.String) r6)     // Catch:{ all -> 0x002a }
            java.lang.String r0 = "onAppendView"
            r1.a((java.lang.Object) r2, (java.lang.String) r0, (java.lang.String) r6)     // Catch:{ all -> 0x002a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
            r0.<init>()     // Catch:{ all -> 0x002a }
            java.lang.String r5 = "appendSubView parentId = "
            r0.append(r5)     // Catch:{ all -> 0x002a }
            r0.append(r6)     // Catch:{ all -> 0x002a }
            java.lang.String r5 = " childId = "
            r0.append(r5)     // Catch:{ all -> 0x002a }
            r0.append(r3)     // Catch:{ all -> 0x002a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ all -> 0x002a }
            goto L_0x01ee
        L_0x01be:
            java.lang.String r0 = "view is not exist"
            r1.c((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ all -> 0x002a }
            return
        L_0x01c4:
            java.lang.String r0 = "instanceId is not exist"
            r1.c((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ all -> 0x002a }
            java.lang.String r0 = "appendSubView failed: instanceId is not exist"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ all -> 0x002a }
            goto L_0x01ee
        L_0x01cf:
            java.lang.String r3 = r0.getMessage()
            r1.c((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "appendSubView failed: "
            r2.append(r3)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r4, (java.lang.String) r0)
        L_0x01ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.a.a.i(java.lang.Object, org.json.JSONObject):void");
    }

    public final void j(Object obj, JSONObject jSONObject) {
        Rect rect;
        int i5;
        int i6;
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject != null) {
                if (!TextUtils.isEmpty(optString)) {
                    String optString3 = optJSONObject.optString("id");
                    LinkedHashMap<String, View> b5 = b(optString, h5);
                    if (!b5.containsKey(optString2) || !b5.containsKey(optString3)) {
                        c(obj, "instanceId is not exist");
                        af.a("OperateViews", "appendViewTo failed: instanceId is not exist");
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) b5.get(optString3);
                    View view = b5.get(optString2);
                    at.a(view);
                    if (viewGroup != null) {
                        if (view != null) {
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                            if (view instanceof MBTempContainer) {
                                Iterator<View> it = b5.values().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    View next = it.next();
                                    if (next instanceof MBridgeBTContainer) {
                                        at.a(view);
                                        ((MBridgeBTContainer) next).appendSubView((MBridgeBTContainer) next, (MBTempContainer) view, optJSONObject2);
                                        break;
                                    }
                                }
                            } else {
                                if (optJSONObject2 != null) {
                                    Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
                                    i6 = optJSONObject2.optInt("width");
                                    i5 = optJSONObject2.optInt("height");
                                    rect = rect2;
                                } else if (view instanceof BTBaseView) {
                                    rect = ((BTBaseView) view).getRect();
                                    i6 = ((BTBaseView) view).getViewWidth();
                                    i5 = ((BTBaseView) view).getViewHeight();
                                } else {
                                    i6 = 0;
                                    rect = null;
                                    i5 = 0;
                                }
                                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                                if (viewGroup instanceof FrameLayout) {
                                    layoutParams = new FrameLayout.LayoutParams(-1, -1);
                                } else if (viewGroup instanceof RelativeLayout) {
                                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                                } else if (viewGroup instanceof LinearLayout) {
                                    layoutParams = new LinearLayout.LayoutParams(-1, -1);
                                }
                                ViewGroup.LayoutParams a5 = a(layoutParams, rect, i6, i5);
                                at.a(view);
                                viewGroup.addView(view, a5);
                            }
                            a(obj, optString2);
                            a(obj, "onAppendViewTo", optString2);
                            af.a("OperateViews", "appendViewTo parentId = " + optString3 + " childId = " + optString2);
                            return;
                        }
                    }
                    c(obj, "view is not exist");
                    return;
                }
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "appendViewTo failed: " + th.getMessage());
        }
    }

    public final void k(Object obj, JSONObject jSONObject) {
        int i5;
        int i6;
        Rect rect;
        WindVaneWebView windVaneWebView;
        Object obj2 = obj;
        JSONObject jSONObject2 = jSONObject;
        try {
            String optString = jSONObject2.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject2.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj2).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj2, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("id");
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (!b5.containsKey(optString3) || !b5.containsKey(optString2)) {
                c(obj2, "instanceId is not exist");
                af.a("OperateViews", "appendSubView failed: instanceId is not exist");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) b5.get(optString2);
            View view = b5.get(optString3);
            if (viewGroup != null) {
                if (view != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                    if (view instanceof MBTempContainer) {
                        af.b("OperateViews", "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", new Object[]{Integer.valueOf(f11789l), Integer.valueOf(f11790m), Integer.valueOf(f11791n), Integer.valueOf(f11792o), Integer.valueOf(f11793p)}));
                        ((MBTempContainer) view).setNotchPadding(f11789l, f11790m, f11791n, f11792o, f11793p);
                        Iterator<View> it = b5.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            View next = it.next();
                            if (next instanceof MBridgeBTContainer) {
                                at.a(view);
                                ((MBridgeBTContainer) next).appendSubView((MBridgeBTContainer) next, (MBTempContainer) view, optJSONObject2);
                                break;
                            }
                        }
                    } else {
                        if (optJSONObject2 != null) {
                            Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
                            i5 = optJSONObject2.optInt("width");
                            i6 = optJSONObject2.optInt("height");
                            rect = rect2;
                        } else if (view instanceof BTBaseView) {
                            rect = ((BTBaseView) view).getRect();
                            i5 = ((BTBaseView) view).getViewWidth();
                            i6 = ((BTBaseView) view).getViewHeight();
                        } else {
                            rect = null;
                            i6 = 0;
                            i5 = 0;
                        }
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        if (viewGroup instanceof FrameLayout) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof RelativeLayout) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof LinearLayout) {
                            layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        }
                        viewGroup.addView(view, a(layoutParams, rect, i5, i6));
                    }
                    a(obj2, optString2);
                    a(obj2, "onAppendView", optString2);
                    af.a("OperateViews", "appendSubView parentId = " + optString2 + " childId = " + optString3);
                    return;
                }
            }
            c(obj2, "view is not exist");
        } catch (Throwable th) {
            c(obj2, th.getMessage());
            af.a("OperateViews", "appendSubView failed: " + th.getMessage());
        }
    }

    public final void l(Object obj, JSONObject jSONObject) {
        Rect rect;
        int i5;
        int i6;
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject != null) {
                if (!TextUtils.isEmpty(optString)) {
                    String optString3 = optJSONObject.optString("id");
                    LinkedHashMap<String, View> b5 = b(optString, h5);
                    if (!b5.containsKey(optString2) || !b5.containsKey(optString3)) {
                        c(obj, "instanceId is not exist");
                        af.a("OperateViews", "appendViewTo failed: instanceId is not exist");
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) b5.get(optString3);
                    View view = b5.get(optString2);
                    if (viewGroup != null) {
                        if (view != null) {
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                            if (view instanceof MBTempContainer) {
                                Iterator<View> it = b5.values().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    View next = it.next();
                                    if (next instanceof MBridgeBTContainer) {
                                        at.a(view);
                                        ((MBridgeBTContainer) next).appendSubView((MBridgeBTContainer) next, (MBTempContainer) view, optJSONObject2);
                                        break;
                                    }
                                }
                            } else {
                                if (optJSONObject2 != null) {
                                    Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
                                    i6 = optJSONObject2.optInt("width");
                                    i5 = optJSONObject2.optInt("height");
                                    rect = rect2;
                                } else if (view instanceof BTBaseView) {
                                    rect = ((BTBaseView) view).getRect();
                                    i6 = ((BTBaseView) view).getViewWidth();
                                    i5 = ((BTBaseView) view).getViewHeight();
                                } else {
                                    i6 = 0;
                                    rect = null;
                                    i5 = 0;
                                }
                                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                                if (viewGroup instanceof FrameLayout) {
                                    layoutParams = new FrameLayout.LayoutParams(-1, -1);
                                } else if (viewGroup instanceof RelativeLayout) {
                                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                                } else if (viewGroup instanceof LinearLayout) {
                                    layoutParams = new LinearLayout.LayoutParams(-1, -1);
                                }
                                viewGroup.addView(view, a(layoutParams, rect, i6, i5));
                            }
                            a(obj, optString2);
                            a(obj, "onAppendViewTo", optString2);
                            af.a("OperateViews", "appendViewTo parentId = " + optString3 + " childId = " + optString2);
                            return;
                        }
                    }
                    c(obj, "view is not exist");
                    return;
                }
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "appendViewTo failed: " + th.getMessage());
        }
    }

    public final void m(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (view == null || view.getParent() == null) {
                    c(obj, "view is null");
                    af.a("OperateViews", "bringViewToFront failed: view is null");
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.bringChildToFront(view);
                    a(obj, optString2);
                    a(obj, "onBringViewToFront", optString2);
                    af.a("OperateViews", "bringViewToFront instanceId = " + optString2);
                    return;
                }
                c(obj, "parent is null");
                af.a("OperateViews", "bringViewToFront failed: parent is null");
                return;
            }
            c(obj, "instanceId is not exist");
            af.a("OperateViews", "bringViewToFront failed: instanceId is not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "bringViewToFront failed: " + th.getMessage());
        }
    }

    public final void n(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (view != null) {
                    view.setVisibility(8);
                    a(obj, optString2);
                    a(obj, "onHideView", optString2);
                    af.a("OperateViews", "hideView instanceId = " + optString2);
                    return;
                }
                c(obj, "view not exist");
                af.a("OperateViews", "hideView failed: view not exist");
                return;
            }
            c(obj, "instanceId not exist");
            af.a("OperateViews", "hideView failed: instanceId not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "hideView failed: + " + th.getMessage());
        }
    }

    public final void o(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (view != null) {
                    view.setVisibility(0);
                    a(obj, optString2);
                    a(obj, "onShowView", optString2);
                    af.a("OperateViews", "showView instanceId = " + optString2);
                    return;
                }
                c(obj, "view not exist");
                af.a("OperateViews", "showView failed: view not exist instanceId = " + optString2);
                return;
            }
            c(obj, "instanceId not exist");
            af.a("OperateViews", "showView failed: instanceId not exist instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "showView failed: " + th.getMessage());
        }
    }

    public final void p(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("color");
            if (TextUtils.isEmpty(optString3)) {
                c(obj, "color is not exist");
                return;
            }
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (view != null) {
                    a(obj, optString2);
                    view.setBackgroundColor(Color.parseColor(optString3));
                    a(obj, "onViewBgColorChanged", optString2);
                    af.a("OperateViews", "setViewBgColor instanceId = " + optString2);
                    return;
                }
                c(obj, "view not exist");
                af.a("OperateViews", "setViewBgColor failed: view not exist instanceId = " + optString2);
                return;
            }
            c(obj, "instanceId not exist");
            af.a("OperateViews", "setViewBgColor failed: instanceId not exist instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "setViewBgColor failed: " + th.getMessage());
        }
    }

    public final void q(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            double optDouble = optJSONObject.optDouble("alpha", 1.0d);
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (view != null) {
                    view.setAlpha((float) optDouble);
                    a(obj, optString2);
                    a(obj, "onViewAlphaChanged", optString2);
                    af.a("OperateViews", "setViewAlpha instanceId = " + optString2);
                    return;
                }
                c(obj, "view not exist");
                af.a("OperateViews", "setViewAlpha failed: view not exist instanceId = " + optString2);
                return;
            }
            c(obj, "instanceId not exist");
            af.a("OperateViews", "setViewAlpha failed: instanceId not exist instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "setViewAlpha failed: " + th.getMessage());
        }
    }

    public final void r(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            double optDouble = optJSONObject.optDouble("vertical", 1.0d);
            double optDouble2 = optJSONObject.optDouble("horizon", 1.0d);
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (view != null) {
                    view.setScaleX((float) optDouble2);
                    view.setScaleY((float) optDouble);
                    a(obj, optString2);
                    a(obj, "onViewScaleChanged", optString2);
                    af.a("OperateViews", "setViewScale instanceId = " + optString2);
                    return;
                }
                c(obj, "view not exist");
                af.a("OperateViews", "setViewScale failed: view not exist instanceId = " + optString2);
                return;
            }
            c(obj, "instanceId not exist");
            af.a("OperateViews", "setViewScale failed: instanceId not exist instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "setViewScale failed: " + th.getMessage());
        }
    }

    public final void s(Object obj, JSONObject jSONObject) {
        Rect rect;
        int i5;
        int i6;
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("targetComponentId");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (!b5.containsKey(optString2) || !b5.containsKey(optString3)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "insertViewAbove failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b5.get(optString2);
            View view2 = b5.get(optString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                af.a("OperateViews", "insertViewAbove failed: view not exist instanceId = " + optString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int indexOfChild = viewGroup.indexOfChild(view2);
            if (optJSONObject2 != null) {
                Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
                i6 = optJSONObject2.optInt("width");
                i5 = optJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                i6 = ((BTBaseView) view).getViewWidth();
                i5 = ((BTBaseView) view).getViewHeight();
            } else {
                i6 = 0;
                rect = null;
                i5 = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            viewGroup.addView(view, indexOfChild + 1, a(layoutParams, rect, i6, i5));
            a(obj, optString2);
            a(obj, "onInsertViewAbove", optString2);
            af.a("OperateViews", "insertViewAbove instanceId = " + optString2 + " brotherId = " + optString3);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "insertViewAbove failed: " + th.getMessage());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v9, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: android.graphics.Rect} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v13, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(java.lang.Object r19, org.json.JSONObject r20) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r0 = r20
            java.lang.String r3 = "unitId"
            java.lang.String r4 = "OperateViews"
            java.lang.String r5 = r0.optString(r3)     // Catch:{ all -> 0x002a }
            java.lang.String r6 = "id"
            java.lang.String r6 = r0.optString(r6)     // Catch:{ all -> 0x002a }
            java.lang.String r7 = r1.h(r6)     // Catch:{ all -> 0x002a }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x002a }
            if (r8 == 0) goto L_0x002e
            r8 = r2
            com.mbridge.msdk.mbsignalcommon.windvane.a r8 = (com.mbridge.msdk.mbsignalcommon.windvane.a) r8     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r8 = r8.f10205b     // Catch:{ all -> 0x002a }
            if (r8 == 0) goto L_0x002e
            java.lang.String r7 = r8.getRid()     // Catch:{ all -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r0 = move-exception
            r3 = r4
            goto L_0x0194
        L_0x002e:
            java.lang.String r8 = "data"
            org.json.JSONObject r8 = r0.optJSONObject(r8)     // Catch:{ all -> 0x002a }
            if (r8 != 0) goto L_0x003c
            java.lang.String r0 = "data is empty"
            r1.c((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ all -> 0x002a }
            return
        L_0x003c:
            java.lang.String r9 = "content"
            org.json.JSONObject r8 = r8.optJSONObject(r9)     // Catch:{ all -> 0x002a }
            if (r8 != 0) goto L_0x004a
            java.lang.String r0 = "content is empty"
            r1.c((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ all -> 0x002a }
            return
        L_0x004a:
            java.lang.String r9 = "fileURL"
            java.lang.String r9 = r8.optString(r9)     // Catch:{ all -> 0x002a }
            java.lang.String r10 = "filePath"
            java.lang.String r10 = r8.optString(r10)     // Catch:{ all -> 0x002a }
            java.lang.String r11 = "html"
            java.lang.String r11 = r8.optString(r11)     // Catch:{ all -> 0x002a }
            boolean r12 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x002a }
            if (r12 == 0) goto L_0x0074
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x002a }
            if (r12 == 0) goto L_0x0074
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x002a }
            if (r12 == 0) goto L_0x0074
            java.lang.String r0 = "url is empty"
            r1.c((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0074:
            java.lang.String r12 = "campaigns"
            org.json.JSONArray r12 = r8.optJSONArray(r12)     // Catch:{ all -> 0x002a }
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x002a }
            r13.<init>()     // Catch:{ all -> 0x002a }
            if (r12 == 0) goto L_0x00a5
            int r15 = r12.length()     // Catch:{ all -> 0x002a }
            if (r15 <= 0) goto L_0x00a5
            int r15 = r12.length()     // Catch:{ all -> 0x002a }
            r14 = 0
        L_0x008c:
            if (r14 >= r15) goto L_0x00a5
            org.json.JSONObject r16 = r12.getJSONObject(r14)     // Catch:{ all -> 0x002a }
            r17 = r12
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaignWithBackData(r16)     // Catch:{ all -> 0x002a }
            if (r12 == 0) goto L_0x00a0
            r12.setCampaignUnitId(r5)     // Catch:{ all -> 0x002a }
            r13.add(r12)     // Catch:{ all -> 0x002a }
        L_0x00a0:
            int r14 = r14 + 1
            r12 = r17
            goto L_0x008c
        L_0x00a5:
            java.lang.String r3 = r8.optString(r3)     // Catch:{ all -> 0x002a }
            java.lang.String r12 = "unitSetting"
            org.json.JSONObject r12 = r8.optJSONObject(r12)     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.videocommon.d.c r12 = com.mbridge.msdk.videocommon.d.c.a((org.json.JSONObject) r12)     // Catch:{ all -> 0x002a }
            if (r12 == 0) goto L_0x00b8
            r12.a((java.lang.String) r3)     // Catch:{ all -> 0x002a }
        L_0x00b8:
            java.lang.String r3 = "rect"
            org.json.JSONObject r0 = r0.optJSONObject(r3)     // Catch:{ all -> 0x002a }
            android.graphics.Rect r3 = new android.graphics.Rect     // Catch:{ all -> 0x002a }
            r14 = -999(0xfffffffffffffc19, float:NaN)
            r3.<init>(r14, r14, r14, r14)     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x00ff
            java.lang.String r3 = "left"
            int r3 = r0.optInt(r3, r14)     // Catch:{ all -> 0x00fb }
            java.lang.String r15 = "top"
            int r15 = r0.optInt(r15, r14)     // Catch:{ all -> 0x00fb }
            r16 = r4
            java.lang.String r4 = "right"
            int r4 = r0.optInt(r4, r14)     // Catch:{ all -> 0x00f4 }
            java.lang.String r2 = "bottom"
            int r2 = r0.optInt(r2, r14)     // Catch:{ all -> 0x00f4 }
            android.graphics.Rect r14 = new android.graphics.Rect     // Catch:{ all -> 0x00f4 }
            r14.<init>(r3, r15, r4, r2)     // Catch:{ all -> 0x00f4 }
            java.lang.String r2 = "width"
            int r2 = r0.optInt(r2)     // Catch:{ all -> 0x00f4 }
            java.lang.String r3 = "height"
            int r0 = r0.optInt(r3)     // Catch:{ all -> 0x00f4 }
            r3 = r14
            goto L_0x0103
        L_0x00f4:
            r0 = move-exception
        L_0x00f5:
            r2 = r19
        L_0x00f7:
            r3 = r16
            goto L_0x0194
        L_0x00fb:
            r0 = move-exception
            r16 = r4
            goto L_0x00f5
        L_0x00ff:
            r16 = r4
            r0 = 0
            r2 = 0
        L_0x0103:
            java.lang.String r4 = "refreshCache"
            r14 = 0
            int r4 = r8.optInt(r4, r14)     // Catch:{ all -> 0x00f4 }
            java.util.LinkedHashMap r5 = r1.b((java.lang.String) r5, (java.lang.String) r7)     // Catch:{ all -> 0x00f4 }
            boolean r7 = r5.containsKey(r6)     // Catch:{ all -> 0x00f4 }
            if (r7 == 0) goto L_0x0176
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x00f4 }
            android.view.View r5 = (android.view.View) r5     // Catch:{ all -> 0x00f4 }
            boolean r7 = r5 instanceof com.mbridge.msdk.video.bt.module.MBridgeBTWebView     // Catch:{ all -> 0x00f4 }
            if (r7 == 0) goto L_0x0158
            com.mbridge.msdk.video.bt.module.MBridgeBTWebView r5 = (com.mbridge.msdk.video.bt.module.MBridgeBTWebView) r5     // Catch:{ all -> 0x00f4 }
            r5.setHtml(r11)     // Catch:{ all -> 0x00f4 }
            r5.setFilePath(r10)     // Catch:{ all -> 0x00f4 }
            r5.setFileURL(r9)     // Catch:{ all -> 0x00f4 }
            r5.setRect(r3)     // Catch:{ all -> 0x00f4 }
            r5.setLayout(r2, r0)     // Catch:{ all -> 0x00f4 }
            r5.setCampaigns(r13)     // Catch:{ all -> 0x00f4 }
            r5.setRewardUnitSetting(r12)     // Catch:{ all -> 0x00f4 }
            r5.webviewLoad(r4)     // Catch:{ all -> 0x00f4 }
            r2 = r19
            r1.a((java.lang.Object) r2, (java.lang.String) r6)     // Catch:{ all -> 0x0156 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0156 }
            r0.<init>()     // Catch:{ all -> 0x0156 }
            java.lang.String r3 = "webviewLoad instanceId = "
            r0.append(r3)     // Catch:{ all -> 0x0156 }
            r0.append(r6)     // Catch:{ all -> 0x0156 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0156 }
            r3 = r16
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r3, (java.lang.String) r0)     // Catch:{ all -> 0x0154 }
            return
        L_0x0154:
            r0 = move-exception
            goto L_0x0194
        L_0x0156:
            r0 = move-exception
            goto L_0x00f7
        L_0x0158:
            r2 = r19
            r3 = r16
            java.lang.String r0 = "view not exist"
            r1.c((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ all -> 0x0154 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0154 }
            r0.<init>()     // Catch:{ all -> 0x0154 }
            java.lang.String r4 = "webviewLoad failed: view not exist instanceId = "
            r0.append(r4)     // Catch:{ all -> 0x0154 }
            r0.append(r6)     // Catch:{ all -> 0x0154 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0154 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r3, (java.lang.String) r0)     // Catch:{ all -> 0x0154 }
            return
        L_0x0176:
            r2 = r19
            r3 = r16
            java.lang.String r0 = "instanceId not exist"
            r1.c((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ all -> 0x0154 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0154 }
            r0.<init>()     // Catch:{ all -> 0x0154 }
            java.lang.String r4 = "webviewLoad failed: instanceId not exist instanceId = "
            r0.append(r4)     // Catch:{ all -> 0x0154 }
            r0.append(r6)     // Catch:{ all -> 0x0154 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0154 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r3, (java.lang.String) r0)     // Catch:{ all -> 0x0154 }
            return
        L_0x0194:
            java.lang.String r4 = r0.getMessage()
            r1.c((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "webviewLoad failed: "
            r2.append(r4)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r3, (java.lang.String) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.a.a.t(java.lang.Object, org.json.JSONObject):void");
    }

    public final void u(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (!(view instanceof MBridgeBTWebView)) {
                    c(obj, "view not exist");
                    af.a("OperateViews", "webviewReload failed view not exist instanceId = " + optString2);
                } else if (((MBridgeBTWebView) view).webviewReload()) {
                    a(obj, optString2);
                    af.a("OperateViews", "webviewReload instanceId = " + optString2);
                } else {
                    c(obj, "reload failed");
                    af.a("OperateViews", "webviewReload failed reload failed instanceId = " + optString2);
                }
            } else {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "webviewReload failed instanceId not exist instanceId = " + optString2);
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "webviewReload failed: " + th.getMessage());
        }
    }

    public final void v(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (!(view instanceof MBridgeBTWebView)) {
                    c(obj, "view not exist");
                    af.a("OperateViews", "webviewGoBack failed view not exist instanceId = " + optString2);
                } else if (((MBridgeBTWebView) view).webviewGoBack()) {
                    a(obj, optString2);
                    af.a("OperateViews", "webviewGoBack instanceId = " + optString2);
                } else {
                    c(obj, "webviewGoBack failed");
                    af.a("OperateViews", "webviewGoBack failed instanceId = " + optString2);
                }
            } else {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "webviewGoBack failed instanceId not exist instanceId = " + optString2);
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "webviewGoBack failed: " + th.getMessage());
        }
    }

    public final void w(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (!(view instanceof MBridgeBTWebView)) {
                    c(obj, "view not exist");
                    af.a("OperateViews", "webviewGoForward failed view not exist instanceId = " + optString2);
                } else if (((MBridgeBTWebView) view).webviewGoForward()) {
                    a(obj, optString2);
                    af.a("OperateViews", "webviewGoForward instanceId = " + optString2);
                } else {
                    c(obj, "webviewGoForward failed");
                    af.a("OperateViews", "webviewGoForward failed instanceId = " + optString2);
                }
            } else {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "webviewGoForward failed instanceId not exist instanceId = " + optString2);
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "webviewGoForward failed: " + th.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0073 A[Catch:{ all -> 0x0024 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void x(java.lang.Object r6, org.json.JSONObject r7) {
        /*
            r5 = this;
            java.lang.String r0 = "OperateViews"
            java.lang.String r1 = "unitId"
            java.lang.String r1 = r7.optString(r1)     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = "id"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ all -> 0x0024 }
            java.lang.String r3 = r5.h(r2)     // Catch:{ all -> 0x0024 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0024 }
            if (r4 == 0) goto L_0x0027
            r4 = r6
            com.mbridge.msdk.mbsignalcommon.windvane.a r4 = (com.mbridge.msdk.mbsignalcommon.windvane.a) r4     // Catch:{ all -> 0x0024 }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r4 = r4.f10205b     // Catch:{ all -> 0x0024 }
            if (r4 == 0) goto L_0x0027
            java.lang.String r3 = r4.getRid()     // Catch:{ all -> 0x0024 }
            goto L_0x0027
        L_0x0024:
            r7 = move-exception
            goto L_0x00c8
        L_0x0027:
            java.lang.String r4 = "data"
            org.json.JSONObject r7 = r7.optJSONObject(r4)     // Catch:{ all -> 0x0024 }
            if (r7 != 0) goto L_0x0035
            java.lang.String r7 = "data is empty"
            r5.c((java.lang.Object) r6, (java.lang.String) r7)     // Catch:{ all -> 0x0024 }
            return
        L_0x0035:
            java.util.LinkedHashMap r7 = r5.b((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x0024 }
            boolean r4 = r7.containsKey(r2)     // Catch:{ all -> 0x0024 }
            if (r4 == 0) goto L_0x00ae
            java.lang.Object r7 = r7.get(r2)     // Catch:{ all -> 0x0024 }
            android.view.View r7 = (android.view.View) r7     // Catch:{ all -> 0x0024 }
            boolean r4 = r7 instanceof com.mbridge.msdk.video.bt.module.MBridgeBTVideoView     // Catch:{ all -> 0x0024 }
            if (r4 == 0) goto L_0x0094
            com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r7 = (com.mbridge.msdk.video.bt.module.MBridgeBTVideoView) r7     // Catch:{ all -> 0x0024 }
            java.util.LinkedHashMap r1 = r5.b((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x0024 }
            int r3 = r1.size()     // Catch:{ all -> 0x0024 }
            if (r3 <= 0) goto L_0x0070
            java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x0024 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0024 }
        L_0x005d:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0024 }
            if (r3 == 0) goto L_0x0070
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0024 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x0024 }
            boolean r4 = r3 instanceof com.mbridge.msdk.video.bt.module.MBridgeBTContainer     // Catch:{ all -> 0x0024 }
            if (r4 == 0) goto L_0x005d
            com.mbridge.msdk.video.bt.module.MBridgeBTContainer r3 = (com.mbridge.msdk.video.bt.module.MBridgeBTContainer) r3     // Catch:{ all -> 0x0024 }
            goto L_0x0071
        L_0x0070:
            r3 = 0
        L_0x0071:
            if (r3 == 0) goto L_0x0088
            u1.a r1 = r3.getAdEvents()     // Catch:{ all -> 0x0024 }
            r7.setAdEvents(r1)     // Catch:{ all -> 0x0024 }
            u1.b r1 = r3.getAdSession()     // Catch:{ all -> 0x0024 }
            r7.setAdSession(r1)     // Catch:{ all -> 0x0024 }
            v1.b r1 = r3.getVideoEvents()     // Catch:{ all -> 0x0024 }
            r7.setVideoEvents(r1)     // Catch:{ all -> 0x0024 }
        L_0x0088:
            r7.play()     // Catch:{ all -> 0x0024 }
            r5.a((java.lang.Object) r6, (java.lang.String) r2)     // Catch:{ all -> 0x0024 }
            java.lang.String r7 = "playerPlay success"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r7)     // Catch:{ all -> 0x0024 }
            return
        L_0x0094:
            java.lang.String r7 = "instanceId is not player"
            r5.c((java.lang.Object) r6, (java.lang.String) r7)     // Catch:{ all -> 0x0024 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0024 }
            r7.<init>()     // Catch:{ all -> 0x0024 }
            java.lang.String r1 = "playerPlay failed instanceId is not player instanceId = "
            r7.append(r1)     // Catch:{ all -> 0x0024 }
            r7.append(r2)     // Catch:{ all -> 0x0024 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0024 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r7)     // Catch:{ all -> 0x0024 }
            return
        L_0x00ae:
            java.lang.String r7 = "instanceId not exit"
            r5.c((java.lang.Object) r6, (java.lang.String) r7)     // Catch:{ all -> 0x0024 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0024 }
            r7.<init>()     // Catch:{ all -> 0x0024 }
            java.lang.String r1 = "playerPlay failed instanceId not exit instanceId = "
            r7.append(r1)     // Catch:{ all -> 0x0024 }
            r7.append(r2)     // Catch:{ all -> 0x0024 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0024 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r7)     // Catch:{ all -> 0x0024 }
            return
        L_0x00c8:
            java.lang.String r1 = r7.getMessage()
            r5.c((java.lang.Object) r6, (java.lang.String) r1)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "playerPlay failed: "
            r6.append(r1)
            java.lang.String r7 = r7.getMessage()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.a.a.x(java.lang.Object, org.json.JSONObject):void");
    }

    public final void y(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).pause();
                    a(obj, optString2);
                    af.a("OperateViews", "playerPause success");
                    return;
                }
                c(obj, "instanceId is not player");
                af.a("OperateViews", "playerPause failed instanceId is not player instanceId = " + optString2);
                return;
            }
            c(obj, "instanceId not exit");
            af.a("OperateViews", "playerPause failed instanceId not exit instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "playerPause failed: " + th.getMessage());
        }
    }

    public final void z(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).resume();
                    a(obj, optString2);
                    af.a("OperateViews", "playerResume success");
                    return;
                }
                c(obj, "instanceId is not player");
                af.a("OperateViews", "playerResume failed instanceId is not player instanceId = " + optString2);
                return;
            }
            c(obj, "instanceId not exit");
            af.a("OperateViews", "playerResume failed instanceId not exit instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "playerResume failed: " + th.getMessage());
        }
    }

    public final c b(String str) {
        if (f11781d.containsKey(str)) {
            return f11781d.get(str);
        }
        return null;
    }

    public final void d(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject != null) {
                if (!TextUtils.isEmpty(optString)) {
                    int optInt = optJSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
                    String str = "";
                    CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject.optJSONObject("campaign"));
                    if (parseCampaignWithBackData != null && !TextUtils.isEmpty(optString)) {
                        parseCampaignWithBackData.setCampaignUnitId(optString);
                        str = parseCampaignWithBackData.getRequestId();
                    }
                    c a5 = c.a(optJSONObject.optJSONObject("unitSetting"));
                    if (a5 != null) {
                        a5.a(optString);
                    }
                    String optString2 = optJSONObject.optString("userId");
                    if (TextUtils.isEmpty(str) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                        str = windVaneWebView.getRid();
                    }
                    LinkedHashMap<String, View> b5 = b(optString, str);
                    String a6 = a();
                    f11779b.put(a6, str);
                    MBTempContainer mBTempContainer = new MBTempContainer(com.mbridge.msdk.foundation.controller.c.m().c());
                    k kVar = (k) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b.getObject();
                    mBTempContainer.setAdEvents(kVar.l());
                    mBTempContainer.setAdSession(kVar.j());
                    mBTempContainer.setVideoEvents(kVar.k());
                    mBTempContainer.setInstanceId(a6);
                    mBTempContainer.setUnitId(optString);
                    mBTempContainer.setCampaign(parseCampaignWithBackData);
                    mBTempContainer.setRewardUnitSetting(a5);
                    mBTempContainer.setBigOffer(true);
                    if (!TextUtils.isEmpty(optString2)) {
                        mBTempContainer.setUserId(optString2);
                    }
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("reward");
                    if (optJSONObject2 != null) {
                        String optString3 = optJSONObject2.optString("id");
                        com.mbridge.msdk.videocommon.b.c cVar = new com.mbridge.msdk.videocommon.b.c(optJSONObject2.optString(RewardPlus.NAME), optJSONObject2.optInt(RewardPlus.AMOUNT));
                        if (!TextUtils.isEmpty(optString3)) {
                            mBTempContainer.setRewardId(optString3);
                        }
                        if (!TextUtils.isEmpty(cVar.a())) {
                            mBTempContainer.setReward(cVar);
                        }
                    }
                    String optString4 = optJSONObject.optString("extra");
                    if (!TextUtils.isEmpty(optString4)) {
                        mBTempContainer.setDeveloperExtraData(optString4);
                    }
                    mBTempContainer.setMute(optInt);
                    b5.put(a6, mBTempContainer);
                    f11782e.put(a6, optString);
                    f11780c.put(a6, parseCampaignWithBackData);
                    f11781d.put(a6, a5);
                    a(obj, a6);
                    af.a("OperateViews", "createSubPlayTemplateView instanceId = " + a6);
                    return;
                }
            }
            c(obj, "unitId or data is empty");
        } catch (Exception e5) {
            af.b("OperateViews", e5.getMessage());
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "createSubPlayTemplateView failed：" + th.getMessage());
        }
    }

    public final CampaignEx a(String str) {
        if (f11780c.containsKey(str)) {
            return f11780c.get(str);
        }
        return null;
    }

    public final void e(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) != null) {
                if (!TextUtils.isEmpty(optString)) {
                    String h5 = h(optString2);
                    if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                        h5 = windVaneWebView.getRid();
                    }
                    LinkedHashMap<String, View> b5 = b(optString, h5);
                    if (b5 == null || !b5.containsKey(optString2)) {
                        c(obj, "unitId or instanceId not exist");
                        af.a("OperateViews", "destroyComponent failed");
                        return;
                    }
                    View view = b5.get(optString2);
                    b5.remove(optString2);
                    if (!(view == null || view.getParent() == null)) {
                        ViewGroup viewGroup = (ViewGroup) view.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(view);
                        }
                        if (view instanceof ViewGroup) {
                            ViewGroup viewGroup2 = (ViewGroup) view;
                            if (viewGroup2.getChildCount() > 0) {
                                int childCount = viewGroup2.getChildCount();
                                for (int i5 = 0; i5 < childCount; i5++) {
                                    View childAt = viewGroup2.getChildAt(i5);
                                    if (childAt instanceof MBridgeBTWebView) {
                                        b5.remove(((MBridgeBTWebView) childAt).getInstanceId());
                                        ((MBridgeBTWebView) childAt).onDestory();
                                    } else if (childAt instanceof MBridgeBTVideoView) {
                                        b5.remove(((MBridgeBTVideoView) childAt).getInstanceId());
                                        ((MBridgeBTVideoView) childAt).onDestory();
                                    } else if (childAt instanceof MBTempContainer) {
                                        b5.remove(((MBTempContainer) childAt).getInstanceId());
                                        ((MBTempContainer) childAt).onDestroy();
                                    }
                                }
                            }
                        }
                    }
                    if (view instanceof MBTempContainer) {
                        ((MBTempContainer) view).onDestroy();
                    }
                    if (view instanceof MBridgeBTWebView) {
                        ((MBridgeBTWebView) view).onDestory();
                    }
                    if (view instanceof MBridgeBTVideoView) {
                        ((MBridgeBTVideoView) view).onDestory();
                    }
                    a(obj, optString2);
                    a(obj, "onComponentDestroy", optString2);
                    af.a("OperateViews", "destroyComponent instanceId = " + optString2);
                    return;
                }
            }
            c(obj, "unidId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "destroyComponent failed");
        }
    }

    public final void g(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            if (optJSONObject2 == null) {
                c(obj, "rect not exist");
                return;
            }
            LinkedHashMap<String, View> b5 = b(optString, h5);
            Rect rect = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
            int optInt = optJSONObject2.optInt("width");
            int optInt2 = optJSONObject2.optInt("height");
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (view != null) {
                    if (view.getParent() != null) {
                        view.setLayoutParams(a(view.getLayoutParams(), rect, optInt, optInt2));
                        view.requestLayout();
                    } else {
                        if (view instanceof MBridgeBTWebView) {
                            ((MBridgeBTWebView) view).setRect(rect);
                            ((MBridgeBTWebView) view).setLayout(optInt, optInt2);
                        }
                        if (view instanceof MBridgeBTVideoView) {
                            ((MBridgeBTVideoView) view).setRect(rect);
                            ((MBridgeBTVideoView) view).setLayout(optInt, optInt2);
                        }
                    }
                    a(obj, optString2);
                    a(obj, "onViewRectChanged", optString2);
                    af.a("OperateViews", "setViewRect instanceId = " + optString2);
                    return;
                }
                c(obj, "view is null");
                af.a("OperateViews", "setViewRect failed: view is null");
                return;
            }
            c(obj, "instanceId not exist");
            af.a("OperateViews", "setViewRect failed: instanceId not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "setViewRect failed: " + th.getMessage());
        }
    }

    private void c(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f11787j);
            jSONObject.put("message", str);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            af.a("OperateViews", e5.getMessage());
        }
    }

    public final synchronized LinkedHashMap<String, View> b(String str, String str2) {
        ConcurrentHashMap<String, LinkedHashMap<String, View>> concurrentHashMap = f11778a;
        if (concurrentHashMap.containsKey(str + "_" + str2)) {
            ConcurrentHashMap<String, LinkedHashMap<String, View>> concurrentHashMap2 = f11778a;
            return concurrentHashMap2.get(str + "_" + str2);
        }
        LinkedHashMap<String, View> linkedHashMap = new LinkedHashMap<>();
        ConcurrentHashMap<String, LinkedHashMap<String, View>> concurrentHashMap3 = f11778a;
        concurrentHashMap3.put(str + "_" + str2, linkedHashMap);
        return linkedHashMap;
    }

    public final void h(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (b5.containsKey(optString2)) {
                View view = b5.get(optString2);
                if (view == null || view.getParent() == null) {
                    c(obj, "view is null");
                    af.a("OperateViews", "removeFromSuperView failed: view is null instanceId = " + optString2);
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                    a(obj, optString2);
                    a(obj, "onRemoveFromView", optString2);
                    af.a("OperateViews", "removeFromSuperView instanceId = " + optString2);
                    return;
                }
                c(obj, "parent is null");
                af.a("OperateViews", "removeFromSuperView failed: parent is null instanceId = " + optString2);
                return;
            }
            c(obj, "params not enough");
            af.a("OperateViews", "removeFromSuperView failed: params not enough instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "removeFromSuperView failed: " + th.getMessage());
        }
    }

    public final void a(String str, String str2) {
        f11779b.put(str, str2);
    }

    public final void a(String str, Activity activity) {
        f11784g.put(str, activity);
    }

    public final void a(String str, int i5) {
        f11783f.put(str, Integer.valueOf(i5));
    }

    public final void a(WebView webView, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f11787j);
            jSONObject.put("message", str);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            g.a().a(webView, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            af.a("OperateViews", e5.getMessage());
        }
    }

    public final void b(Object obj, JSONObject jSONObject) {
        Throwable th;
        final Object obj2;
        final int i5;
        final int i6;
        try {
            final String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (TextUtils.isEmpty(optString)) {
                try {
                    c(obj, "unitId is empty");
                } catch (Throwable th2) {
                    th = th2;
                    obj2 = obj;
                    c(obj2, th.getMessage());
                    af.a("OperateViews", "createWebview failed：" + th.getMessage());
                }
            } else {
                JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                int optInt = optJSONObject.optInt("delay", 0);
                final String optString2 = optJSONObject.optString("fileURL");
                final String optString3 = optJSONObject.optString("filePath");
                final String optString4 = optJSONObject.optString("html");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                Rect rect = new Rect(-999, -999, -999, -999);
                if (optJSONObject2 != null) {
                    rect = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
                    int optInt2 = optJSONObject2.optInt("width");
                    i6 = optJSONObject2.optInt("height");
                    i5 = optInt2;
                } else {
                    i5 = 0;
                    i6 = 0;
                }
                final Rect rect2 = rect;
                obj2 = obj;
                try {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public final void run() {
                            String str;
                            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj2).f10205b;
                            if (windVaneWebView != null) {
                                str = windVaneWebView.getRid();
                            } else {
                                str = "";
                                windVaneWebView = null;
                            }
                            LinkedHashMap<String, View> b5 = a.this.b(optString, str);
                            String a5 = a.this.a();
                            a.f11779b.put(a5, str);
                            MBridgeBTWebView mBridgeBTWebView = new MBridgeBTWebView(com.mbridge.msdk.foundation.controller.c.m().c());
                            b5.put(a5, mBridgeBTWebView);
                            mBridgeBTWebView.setInstanceId(a5);
                            mBridgeBTWebView.setUnitId(optString);
                            mBridgeBTWebView.setFileURL(optString2);
                            mBridgeBTWebView.setFilePath(optString3);
                            mBridgeBTWebView.setHtml(optString4);
                            mBridgeBTWebView.setRect(rect2);
                            mBridgeBTWebView.setWebViewRid(str);
                            mBridgeBTWebView.setCreateWebView(windVaneWebView);
                            int i5 = i5;
                            if (i5 > 0 || i6 > 0) {
                                mBridgeBTWebView.setLayout(i5, i6);
                            }
                            mBridgeBTWebView.preload();
                            a.this.a(obj2, a5);
                            af.a("OperateViews", "createWebview instanceId = " + a5);
                        }
                    }, (long) optInt);
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    c(obj2, th.getMessage());
                    af.a("OperateViews", "createWebview failed：" + th.getMessage());
                }
            }
        } catch (Throwable th4) {
            th = th4;
            obj2 = obj;
            th = th;
            c(obj2, th.getMessage());
            af.a("OperateViews", "createWebview failed：" + th.getMessage());
        }
    }

    public final void f(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString = jSONObject.optString("id");
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
            } else {
                a(obj, optString);
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public final void c(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject != null) {
                if (!TextUtils.isEmpty(optString)) {
                    String str = "";
                    CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject.optJSONObject("campaign"));
                    if (parseCampaignWithBackData != null && !TextUtils.isEmpty(optString)) {
                        parseCampaignWithBackData.setCampaignUnitId(optString);
                        str = parseCampaignWithBackData.getRequestId();
                    }
                    int optInt = optJSONObject.optInt("show_time", 0);
                    int optInt2 = optJSONObject.optInt("show_mute", 0);
                    int optInt3 = optJSONObject.optInt("show_close", 0);
                    int optInt4 = optJSONObject.optInt("orientation", 1);
                    int optInt5 = optJSONObject.optInt("show_pgb", 0);
                    MBridgeBTVideoView mBridgeBTVideoView = new MBridgeBTVideoView(com.mbridge.msdk.foundation.controller.c.m().c());
                    k kVar = (k) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b.getObject();
                    mBridgeBTVideoView.setAdEvents(kVar.l());
                    mBridgeBTVideoView.setAdSession(kVar.j());
                    mBridgeBTVideoView.setVideoEvents(kVar.k());
                    mBridgeBTVideoView.setCampaign(parseCampaignWithBackData);
                    mBridgeBTVideoView.setUnitId(optString);
                    mBridgeBTVideoView.setShowMute(optInt2);
                    mBridgeBTVideoView.setShowTime(optInt);
                    mBridgeBTVideoView.setShowClose(optInt3);
                    mBridgeBTVideoView.setOrientation(optInt4);
                    mBridgeBTVideoView.setProgressBarState(optInt5);
                    WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b;
                    if (windVaneWebView != null) {
                        str = windVaneWebView.getRid();
                        mBridgeBTVideoView.setCreateWebView(windVaneWebView);
                    }
                    LinkedHashMap<String, View> b5 = b(optString, str);
                    String a5 = a();
                    f11779b.put(a5, str);
                    mBridgeBTVideoView.setInstanceId(a5);
                    b5.put(a5, mBridgeBTVideoView);
                    mBridgeBTVideoView.preLoadData();
                    if (parseCampaignWithBackData == null) {
                        c(obj, "campaign is null");
                        af.a("OperateViews", "createPlayerView failed");
                    } else {
                        a(obj, a5);
                        af.a("OperateViews", "createPlayerView instanceId = " + a5);
                    }
                    b unused = b.a.f11811a;
                    return;
                }
            }
            c(obj, "unitId or data is empty");
        } catch (Exception e5) {
            af.b("OperateViews", e5.getMessage());
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "createPlayerView failed：" + th.getMessage());
        }
    }

    public final void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f11786i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            c(obj, e5.getMessage());
            af.a("OperateViews", e5.getMessage());
        }
    }

    private void a(Object obj, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f11786i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
            g.a().a(obj, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            c(obj, e5.getMessage());
            af.a("OperateViews", e5.getMessage());
        }
    }

    public final void b(Object obj, JSONObject jSONObject, boolean z4) {
        Rect rect;
        int i5;
        int i6;
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("targetComponentId");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (!b5.containsKey(optString2) || !b5.containsKey(optString3)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "insertViewBelow failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b5.get(optString2);
            View view2 = b5.get(optString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                af.a("OperateViews", "insertViewBelow failed: view not exist instanceId = " + optString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int indexOfChild = viewGroup.indexOfChild(view2);
            int i7 = 0;
            if (optJSONObject2 != null) {
                Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
                i6 = optJSONObject2.optInt("width");
                i5 = optJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                i6 = ((BTBaseView) view).getViewWidth();
                i5 = ((BTBaseView) view).getViewHeight();
            } else {
                rect = null;
                i6 = 0;
                i5 = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            ViewGroup.LayoutParams a5 = a(layoutParams, rect, i6, i5);
            if (z4) {
                at.a(view);
            }
            int i8 = indexOfChild - 1;
            if (i8 > -1) {
                i7 = i8;
            }
            viewGroup.addView(view, i7, a5);
            a(obj, optString2);
            a(obj, "onInsertViewBelow", optString2);
            af.a("OperateViews", "insertViewBelow instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "insertViewBelow failed: " + th.getMessage());
        }
    }

    public final void a(WebView webView, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f11786i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
            g.a().a(webView, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            a(webView, e5.getMessage());
            af.a("OperateViews", e5.getMessage());
        }
    }

    public final void a(Object obj, JSONObject jSONObject) {
        Throwable th;
        final Object obj2;
        final int i5;
        final int i6;
        try {
            final String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (TextUtils.isEmpty(optString)) {
                try {
                    c(obj, "unitId is empty");
                } catch (Throwable th2) {
                    th = th2;
                    obj2 = obj;
                    c(obj2, th.getMessage());
                    af.a("OperateViews", "create view failed：" + th.getMessage());
                }
            } else {
                JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                int optInt = optJSONObject.optInt("delay", 0);
                optJSONObject.optString("fileURL");
                optJSONObject.optString("filePath");
                optJSONObject.optString("html");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                Rect rect = new Rect(-999, -999, -999, -999);
                if (optJSONObject2 != null) {
                    rect = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
                    int optInt2 = optJSONObject2.optInt("width");
                    i6 = optJSONObject2.optInt("height");
                    i5 = optInt2;
                } else {
                    i5 = 0;
                    i6 = 0;
                }
                final Rect rect2 = rect;
                obj2 = obj;
                try {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public final void run() {
                            String str;
                            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj2).f10205b;
                            if (windVaneWebView != null) {
                                str = windVaneWebView.getRid();
                            } else {
                                str = "";
                                windVaneWebView = null;
                            }
                            LinkedHashMap<String, View> b5 = a.this.b(optString, str);
                            String a5 = a.this.a();
                            a.f11779b.put(a5, str);
                            MBridgeBTLayout mBridgeBTLayout = new MBridgeBTLayout(com.mbridge.msdk.foundation.controller.c.m().c());
                            b5.put(a5, mBridgeBTLayout);
                            mBridgeBTLayout.setInstanceId(a5);
                            mBridgeBTLayout.setUnitId(optString);
                            mBridgeBTLayout.setWebView(windVaneWebView);
                            mBridgeBTLayout.setRect(rect2);
                            int i5 = i5;
                            if (i5 > 0 || i6 > 0) {
                                mBridgeBTLayout.setLayout(i5, i6);
                            }
                            a.this.a(obj2, a5);
                            af.a("OperateViews", "create view instanceId = " + a5);
                        }
                    }, (long) optInt);
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    c(obj2, th.getMessage());
                    af.a("OperateViews", "create view failed：" + th.getMessage());
                }
            }
        } catch (Throwable th4) {
            th = th4;
            obj2 = obj;
            th = th;
            c(obj2, th.getMessage());
            af.a("OperateViews", "create view failed：" + th.getMessage());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: android.widget.LinearLayout$LayoutParams} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: android.widget.LinearLayout$LayoutParams} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: android.widget.LinearLayout$LayoutParams} */
    /* JADX WARNING: type inference failed for: r5v1, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.ViewGroup.LayoutParams a(android.view.ViewGroup.LayoutParams r5, android.graphics.Rect r6, int r7, int r8) {
        /*
            r4 = this;
            r0 = -999(0xfffffffffffffc19, float:NaN)
            if (r6 != 0) goto L_0x0009
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>(r0, r0, r0, r0)
        L_0x0009:
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r1 = r1.c()
            if (r1 != 0) goto L_0x0015
            goto L_0x00ed
        L_0x0015:
            boolean r2 = r5 instanceof android.widget.FrameLayout.LayoutParams
            r3 = -1
            if (r2 == 0) goto L_0x005e
            android.widget.FrameLayout$LayoutParams r5 = new android.widget.FrameLayout$LayoutParams
            r5.<init>(r3, r3)
            int r2 = r6.left
            if (r2 == r0) goto L_0x002a
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r2)
            r5.leftMargin = r2
        L_0x002a:
            int r2 = r6.top
            if (r2 == r0) goto L_0x0035
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r2)
            r5.topMargin = r2
        L_0x0035:
            int r2 = r6.right
            if (r2 == r0) goto L_0x0040
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r2)
            r5.rightMargin = r2
        L_0x0040:
            int r6 = r6.bottom
            if (r6 == r0) goto L_0x004b
            float r6 = (float) r6
            int r6 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r6)
            r5.bottomMargin = r6
        L_0x004b:
            if (r7 <= 0) goto L_0x0054
            float r6 = (float) r7
            int r6 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r6)
            r5.width = r6
        L_0x0054:
            if (r8 <= 0) goto L_0x005d
            float r6 = (float) r8
            int r6 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r6)
            r5.height = r6
        L_0x005d:
            return r5
        L_0x005e:
            boolean r2 = r5 instanceof android.widget.RelativeLayout.LayoutParams
            if (r2 == 0) goto L_0x00a6
            android.widget.RelativeLayout$LayoutParams r5 = new android.widget.RelativeLayout$LayoutParams
            r5.<init>(r3, r3)
            int r2 = r6.left
            if (r2 == r0) goto L_0x0072
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r2)
            r5.leftMargin = r2
        L_0x0072:
            int r2 = r6.top
            if (r2 == r0) goto L_0x007d
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r2)
            r5.topMargin = r2
        L_0x007d:
            int r2 = r6.right
            if (r2 == r0) goto L_0x0088
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r2)
            r5.rightMargin = r2
        L_0x0088:
            int r6 = r6.bottom
            if (r6 == r0) goto L_0x0093
            float r6 = (float) r6
            int r6 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r6)
            r5.bottomMargin = r6
        L_0x0093:
            if (r7 <= 0) goto L_0x009c
            float r6 = (float) r7
            int r6 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r6)
            r5.width = r6
        L_0x009c:
            if (r8 <= 0) goto L_0x00a5
            float r6 = (float) r8
            int r6 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r6)
            r5.height = r6
        L_0x00a5:
            return r5
        L_0x00a6:
            boolean r2 = r5 instanceof android.widget.LinearLayout.LayoutParams
            if (r2 == 0) goto L_0x00ed
            android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
            r5.<init>(r3, r3)
            int r2 = r6.left
            if (r2 == r0) goto L_0x00ba
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r2)
            r5.leftMargin = r2
        L_0x00ba:
            int r2 = r6.top
            if (r2 == r0) goto L_0x00c5
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r2)
            r5.topMargin = r2
        L_0x00c5:
            int r2 = r6.right
            if (r2 == r0) goto L_0x00d0
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r2)
            r5.rightMargin = r2
        L_0x00d0:
            int r6 = r6.bottom
            if (r6 == r0) goto L_0x00db
            float r6 = (float) r6
            int r6 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r6)
            r5.bottomMargin = r6
        L_0x00db:
            if (r7 <= 0) goto L_0x00e4
            float r6 = (float) r7
            int r6 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r6)
            r5.width = r6
        L_0x00e4:
            if (r8 <= 0) goto L_0x00ed
            float r6 = (float) r8
            int r6 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r6)
            r5.height = r6
        L_0x00ed:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.a.a.a(android.view.ViewGroup$LayoutParams, android.graphics.Rect, int, int):android.view.ViewGroup$LayoutParams");
    }

    public final void b(Object obj, String str) {
        String str2 = str;
        af.a("OperateViews", "reportUrls:" + str2);
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i5);
                    int optInt = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                    String a5 = ak.a(jSONObject.optString("url"), "&tun=", ab.q() + "");
                    int optInt2 = jSONObject.optInt("report");
                    if (optInt2 == 0) {
                        com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), (CampaignEx) null, "", a5, false, optInt != 0);
                    } else {
                        com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), (CampaignEx) null, "", a5, false, optInt != 0, optInt2);
                    }
                }
                try {
                    a(obj, "");
                } catch (Throwable th) {
                    th = th;
                    af.b("OperateViews", "reportUrls", th);
                }
            } catch (Throwable th2) {
                th = th2;
                af.b("OperateViews", "reportUrls", th);
            }
        }
    }

    public final void a(Object obj, JSONObject jSONObject, boolean z4) {
        Rect rect;
        int i5;
        int i6;
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String h5 = h(optString2);
            if (TextUtils.isEmpty(h5) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                h5 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("targetComponentId");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> b5 = b(optString, h5);
            if (!b5.containsKey(optString2) || !b5.containsKey(optString3)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "insertViewAbove failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b5.get(optString2);
            View view2 = b5.get(optString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                af.a("OperateViews", "insertViewAbove failed: view not exist instanceId = " + optString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int indexOfChild = viewGroup.indexOfChild(view2);
            if (optJSONObject2 != null) {
                Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
                i6 = optJSONObject2.optInt("width");
                i5 = optJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                i6 = ((BTBaseView) view).getViewWidth();
                i5 = ((BTBaseView) view).getViewHeight();
            } else {
                i6 = 0;
                rect = null;
                i5 = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            ViewGroup.LayoutParams a5 = a(layoutParams, rect, i6, i5);
            if (z4) {
                at.a(view);
            }
            viewGroup.addView(view, indexOfChild + 1, a5);
            a(obj, optString2);
            a(obj, "onInsertViewAbove", optString2);
            af.a("OperateViews", "insertViewAbove instanceId = " + optString2 + " brotherId = " + optString3);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "insertViewAbove failed: " + th.getMessage());
        }
    }

    public final void a(int i5, int i6, int i7, int i8, int i9) {
        af.a("OperateViews", "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}));
        f11788k = s.a(i5, i6, i7, i8, i9);
        f11789l = i5;
        f11790m = i6;
        f11791n = i7;
        f11792o = i8;
        f11793p = i9;
    }

    static /* synthetic */ void a(a aVar, String str, CampaignEx campaignEx) {
        if (com.mbridge.msdk.foundation.same.a.b.f9220j != null && !TextUtils.isEmpty(campaignEx.getId())) {
            com.mbridge.msdk.foundation.same.a.b.a(str, campaignEx, "reward");
        }
    }
}
