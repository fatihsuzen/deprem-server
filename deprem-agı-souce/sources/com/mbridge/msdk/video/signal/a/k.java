package com.mbridge.msdk.video.signal.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.d;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.video.signal.a;
import com.mbridge.msdk.videocommon.d.a;
import com.mbridge.msdk.videocommon.d.b;
import com.mbridge.msdk.videocommon.d.c;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k extends l {
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public Activity f12655p;

    /* renamed from: q  reason: collision with root package name */
    private String f12656q;

    /* renamed from: r  reason: collision with root package name */
    private String f12657r;

    /* renamed from: s  reason: collision with root package name */
    private int f12658s = 0;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public CampaignEx f12659t;

    /* renamed from: u  reason: collision with root package name */
    private List<CampaignEx> f12660u;

    /* renamed from: v  reason: collision with root package name */
    private int f12661v;

    /* renamed from: w  reason: collision with root package name */
    private String f12662w = "";

    /* renamed from: x  reason: collision with root package name */
    private String f12663x = "";

    /* renamed from: y  reason: collision with root package name */
    private boolean f12664y = false;

    /* renamed from: z  reason: collision with root package name */
    private boolean f12665z = false;

    public k(Activity activity, CampaignEx campaignEx) {
        this.f12655p = activity;
        this.f12659t = campaignEx;
    }

    private JSONObject A() {
        JSONObject jSONObject = new JSONObject();
        c cVar = this.f12641k;
        if (cVar != null) {
            return cVar.E();
        }
        return jSONObject;
    }

    private JSONObject B() {
        JSONObject jSONObject = new JSONObject();
        a b5 = b.a().b();
        if (b5 != null) {
            return b5.k();
        }
        return jSONObject;
    }

    private String s() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.f12640j);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("instanceId", this.f12662w);
            jSONObject2.put("rootViewInstanceId", this.f12663x);
            jSONObject2.put("isRootTemplateWebView", this.f12664y);
            jSONObject.put("sdk_info", "MAL_16.8.61,3.0.1");
            jSONObject2.put("playVideoMute", this.f12644n);
            jSONObject.put("sdkSetting", jSONObject2);
            a(jSONObject);
            JSONArray jSONArray = new JSONArray();
            List<CampaignEx> list = this.f12660u;
            if (list == null || list.size() <= 0) {
                jSONArray.put(CampaignEx.campaignToJsonObject(this.f12659t));
            } else {
                for (CampaignEx next : this.f12660u) {
                    jSONArray.put(CampaignEx.campaignToJsonObject(next, next.isReady(), b(next)));
                }
            }
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", A());
            String g5 = h.a().g(com.mbridge.msdk.foundation.controller.c.m().k());
            if (!TextUtils.isEmpty(g5)) {
                JSONObject jSONObject3 = new JSONObject(g5);
                b(jSONObject3);
                String c5 = h.a().c(this.f12640j);
                if (!TextUtils.isEmpty(c5)) {
                    jSONObject3.put("ivreward", new JSONObject(c5));
                }
                jSONObject.put("appSetting", jSONObject3);
            }
            jSONObject.put("rewardSetting", B());
            if (!TextUtils.isEmpty(this.f12640j)) {
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.f12640j);
            }
            if (this.f12665z) {
                str = "1";
            } else {
                str = "0";
            }
            jSONObject.put("rw_plus", str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    private JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.f12644n);
            jSONObject.put("sdkSetting", jSONObject2);
            a(jSONObject);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(CampaignEx.campaignToJsonObject(this.f12659t));
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", A());
            String g5 = h.a().g(com.mbridge.msdk.foundation.controller.c.m().k());
            if (!TextUtils.isEmpty(g5)) {
                JSONObject jSONObject3 = new JSONObject(g5);
                b(jSONObject3);
                String c5 = h.a().c(this.f12640j);
                if (!TextUtils.isEmpty(c5)) {
                    jSONObject3.put("ivreward", c5);
                }
                jSONObject.put("appSetting", jSONObject3.toString());
            }
            jSONObject.put("rewardSetting", B());
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_info", "MAL_16.8.61,3.0.1");
            return jSONObject;
        } catch (JSONException e5) {
            e5.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject v() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (TextUtils.isEmpty(this.f12640j)) {
                return jSONObject;
            }
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.f12640j);
            return jSONObject;
        } catch (JSONException e5) {
            e5.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            String g5 = h.a().g(com.mbridge.msdk.foundation.controller.c.m().k());
            if (!TextUtils.isEmpty(g5)) {
                jSONObject.put("appSetting", new JSONObject(g5));
                return jSONObject;
            }
        } catch (JSONException e5) {
            e5.printStackTrace();
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        try {
            c cVar = this.f12641k;
            if (cVar == null) {
                return jSONObject;
            }
            jSONObject.put("unitSetting", cVar.E());
            return jSONObject;
        } catch (JSONException e5) {
            e5.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject y() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
            return jSONObject;
        } catch (Exception e5) {
            e5.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.f12644n);
            jSONObject2.put("instanceId", this.f12662w);
            jSONObject.put("sdkSetting", jSONObject2);
            return jSONObject;
        } catch (JSONException e5) {
            e5.printStackTrace();
            return jSONObject;
        }
    }

    public final void c(boolean z4) {
        this.f12664y = z4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c0, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        com.mbridge.msdk.foundation.tools.af.b("DefaultJSCommon", r6.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00f1, code lost:
        com.mbridge.msdk.foundation.tools.af.b("DefaultJSCommon", r6.getMessage(), r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:21:0x004c, B:51:0x00ae] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void click(int r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "camp_position"
            super.click(r6, r7)
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r5.f12659t
            if (r1 == 0) goto L_0x003f
            int r1 = r1.getDynamicTempCode()
            r2 = 5
            if (r1 != r2) goto L_0x003f
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r5.f12659t
            if (r1 != 0) goto L_0x0015
            goto L_0x003f
        L_0x0015:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r5.f12660u
            if (r1 != 0) goto L_0x001a
            goto L_0x003f
        L_0x001a:
            int r1 = r1.size()
            if (r1 != 0) goto L_0x0021
            goto L_0x003f
        L_0x0021:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x003b }
            r1.<init>(r7)     // Catch:{ JSONException -> 0x003b }
            boolean r2 = r1.has(r0)     // Catch:{ JSONException -> 0x003b }
            if (r2 == 0) goto L_0x003f
            int r0 = r1.getInt(r0)     // Catch:{ JSONException -> 0x003b }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r5.f12660u     // Catch:{ JSONException -> 0x003b }
            java.lang.Object r0 = r1.get(r0)     // Catch:{ JSONException -> 0x003b }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ JSONException -> 0x003b }
            r5.f12659t = r0     // Catch:{ JSONException -> 0x003b }
            goto L_0x003f
        L_0x003b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003f:
            java.lang.String r0 = "DefaultJSCommon"
            r1 = 3
            r2 = 1
            if (r6 == r2) goto L_0x0086
            if (r6 == r1) goto L_0x0056
            r7 = 4
            if (r6 == r7) goto L_0x004c
            goto L_0x00f8
        L_0x004c:
            com.mbridge.msdk.video.signal.a$a r6 = r5.f12643m     // Catch:{ all -> 0x0053 }
            r6.a(r2)     // Catch:{ all -> 0x0053 }
            goto L_0x00f8
        L_0x0053:
            r6 = move-exception
            goto L_0x00f1
        L_0x0056:
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r5.f12659t     // Catch:{ all -> 0x0053 }
            if (r1 == 0) goto L_0x0068
            int r1 = r1.getCbd()     // Catch:{ all -> 0x0053 }
            r3 = -2
            if (r1 <= r3) goto L_0x0068
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r5.f12659t     // Catch:{ all -> 0x0053 }
            int r1 = r1.getCbd()     // Catch:{ all -> 0x0053 }
            goto L_0x0072
        L_0x0068:
            com.mbridge.msdk.videocommon.d.c r1 = r5.f12641k     // Catch:{ all -> 0x0053 }
            if (r1 == 0) goto L_0x0071
            int r1 = r1.p()     // Catch:{ all -> 0x0053 }
            goto L_0x0072
        L_0x0071:
            r1 = r2
        L_0x0072:
            r3 = -1
            if (r1 != r3) goto L_0x007f
            com.mbridge.msdk.video.signal.a.a$b r1 = new com.mbridge.msdk.video.signal.a.a$b     // Catch:{ all -> 0x0053 }
            com.mbridge.msdk.video.signal.a$a r3 = r5.f12643m     // Catch:{ all -> 0x0053 }
            r1.<init>(r5, r3)     // Catch:{ all -> 0x0053 }
            r5.a((com.mbridge.msdk.video.signal.a.C0112a) r1)     // Catch:{ all -> 0x0053 }
        L_0x007f:
            r5.f12658s = r6     // Catch:{ all -> 0x0053 }
            r5.click(r2, r7)     // Catch:{ all -> 0x0053 }
            goto L_0x00f8
        L_0x0086:
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r5.f12659t     // Catch:{ all -> 0x0053 }
            if (r3 != 0) goto L_0x009f
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r5.f12660u     // Catch:{ all -> 0x0053 }
            if (r3 == 0) goto L_0x009f
            int r3 = r3.size()     // Catch:{ all -> 0x0053 }
            if (r3 <= 0) goto L_0x009f
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r5.f12660u     // Catch:{ all -> 0x0053 }
            r4 = 0
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0053 }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3     // Catch:{ all -> 0x0053 }
            r5.f12659t = r3     // Catch:{ all -> 0x0053 }
        L_0x009f:
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r5.f12659t     // Catch:{ all -> 0x0053 }
            if (r3 != 0) goto L_0x00a4
            goto L_0x00f8
        L_0x00a4:
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r5.a((java.lang.String) r7, (com.mbridge.msdk.foundation.entity.CampaignEx) r3)     // Catch:{ all -> 0x0053 }
            int r3 = r5.f12658s     // Catch:{ all -> 0x0053 }
            if (r3 == r1) goto L_0x00ae
            r5.f12658s = r6     // Catch:{ all -> 0x0053 }
        L_0x00ae:
            int r6 = r5.f12658s     // Catch:{ Exception -> 0x00c0 }
            r3 = 2
            if (r6 != r1) goto L_0x00c2
            r7.setClickTempSource(r3)     // Catch:{ Exception -> 0x00c0 }
            int r6 = r7.getTriggerClickSource()     // Catch:{ Exception -> 0x00c0 }
            if (r6 != 0) goto L_0x00d5
            r7.setTriggerClickSource(r3)     // Catch:{ Exception -> 0x00c0 }
            goto L_0x00d5
        L_0x00c0:
            r6 = move-exception
            goto L_0x00ce
        L_0x00c2:
            if (r6 != r2) goto L_0x00d5
            int r6 = r7.getClickTempSource()     // Catch:{ Exception -> 0x00c0 }
            if (r6 == r3) goto L_0x00d5
            r7.setClickTempSource(r2)     // Catch:{ Exception -> 0x00c0 }
            goto L_0x00d5
        L_0x00ce:
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0053 }
            com.mbridge.msdk.foundation.tools.af.b(r0, r6)     // Catch:{ all -> 0x0053 }
        L_0x00d5:
            if (r7 == 0) goto L_0x00eb
            com.mbridge.msdk.scheme.applet.AppletModelManager r6 = com.mbridge.msdk.scheme.applet.AppletModelManager.getInstance()     // Catch:{ all -> 0x0053 }
            com.mbridge.msdk.scheme.applet.AppletsModel r6 = r6.get(r7)     // Catch:{ all -> 0x0053 }
            if (r6 == 0) goto L_0x00eb
            r6.setUserClick(r2)     // Catch:{ all -> 0x0053 }
            com.mbridge.msdk.scheme.applet.AppletModelManager r1 = com.mbridge.msdk.scheme.applet.AppletModelManager.getInstance()     // Catch:{ all -> 0x0053 }
            r1.replace(r6, r7)     // Catch:{ all -> 0x0053 }
        L_0x00eb:
            android.app.Activity r6 = r5.f12655p     // Catch:{ all -> 0x0053 }
            r5.a(r7, r6)     // Catch:{ all -> 0x0053 }
            goto L_0x00f8
        L_0x00f1:
            java.lang.String r7 = r6.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r7, r6)
        L_0x00f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.a.k.click(int, java.lang.String):void");
    }

    public final void d(String str) {
        this.f12663x = str;
    }

    public final void f() {
        super.f();
        a.C0112a aVar = this.f12643m;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final String g(int i5) {
        switch (i5) {
            case 1:
                return u().toString();
            case 2:
                return v().toString();
            case 3:
                return w().toString();
            case 4:
                return x().toString();
            case 5:
                return y().toString();
            case 6:
                return z().toString();
            default:
                return t().toString();
        }
    }

    public final void handlerH5Exception(int i5, String str) {
        super.handlerH5Exception(i5, str);
        try {
            this.f12643m.a(i5, str);
        } catch (Throwable th) {
            af.b("DefaultJSCommon", th.getMessage(), th);
        }
    }

    public final void i(int i5) {
        this.f12661v = i5;
    }

    public final void q() {
        this.f12656q = "";
    }

    public final int r() {
        return this.f12661v;
    }

    private void b(JSONObject jSONObject) {
        try {
            Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
            String obj = an.a(c5, "MBridge_ConfirmTitle" + this.f12640j, "").toString();
            String obj2 = an.a(c5, "MBridge_ConfirmContent" + this.f12640j, "").toString();
            String obj3 = an.a(c5, "MBridge_CancelText" + this.f12640j, "").toString();
            String obj4 = an.a(c5, "MBridge_ConfirmText" + this.f12640j, "").toString();
            if (!TextUtils.isEmpty(obj)) {
                jSONObject.put("confirm_title", obj);
            }
            if (!TextUtils.isEmpty(obj2)) {
                jSONObject.put("confirm_description", obj2);
            }
            if (!TextUtils.isEmpty(obj3)) {
                jSONObject.put("confirm_t", obj3);
            }
            if (!TextUtils.isEmpty(obj4)) {
                jSONObject.put("confirm_c_play", obj4);
            }
            if (!TextUtils.isEmpty(obj4)) {
                jSONObject.put("confirm_c_rv", obj4);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(CampaignEx campaignEx) {
        this.f12659t = campaignEx;
    }

    public final void c(String str) {
        this.f12662w = str;
    }

    public final void d(boolean z4) {
        this.f12665z = z4;
    }

    public final String i() {
        af.a("DefaultJSCommon", "getNotchArea");
        return this.f12657r;
    }

    public final void a(List<CampaignEx> list) {
        this.f12660u = list;
    }

    public final String c() {
        this.f12643m.a();
        this.f12631a = true;
        if (TextUtils.isEmpty(this.f12656q)) {
            this.f12656q = s();
        } else {
            String str = this.f12656q;
            this.f12656q = ak.b(str, "tun", ab.q() + "");
        }
        return this.f12656q;
    }

    public final void d() {
        super.d();
        try {
            Activity activity = this.f12655p;
            if (activity != null) {
                activity.finish();
            }
        } catch (Throwable th) {
            af.b("DefaultJSCommon", th.getMessage(), th);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:37|38|39|40|(1:42)|43|44|(2:47|45)|56|50|51|60) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0106 */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0110 A[Catch:{ JSONException -> 0x011e }, LOOP:1: B:45:0x010a->B:47:0x0110, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.foundation.entity.CampaignEx a(java.lang.String r8, com.mbridge.msdk.foundation.entity.CampaignEx r9) {
        /*
            r7 = this;
            java.lang.String r0 = "deep_link"
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 == 0) goto L_0x0009
            return r9
        L_0x0009:
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 == 0) goto L_0x0014
            if (r9 == 0) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            r8 = 0
            return r8
        L_0x0014:
            java.lang.String r1 = "notice"
            boolean r1 = r8.contains(r1)
            if (r1 != 0) goto L_0x00f2
            org.json.JSONObject r0 = com.mbridge.msdk.foundation.entity.CampaignEx.campaignToJsonObject(r9)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaignWithBackData(r0)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            if (r1 != 0) goto L_0x0027
            r1 = r9
        L_0x0027:
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            if (r2 != 0) goto L_0x00e9
            r7.a((org.json.JSONObject) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r1)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            r0.<init>(r8)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.String r8 = com.mbridge.msdk.foundation.same.a.f9191j     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            org.json.JSONObject r8 = r0.optJSONObject(r8)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            if (r8 == 0) goto L_0x0076
            android.app.Activity r0 = r7.f12655p     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.f9189h     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            int r2 = r2.intValue()     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            float r2 = (float) r2     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            int r0 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r0, (float) r2)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            android.app.Activity r2 = r7.f12655p     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.f9190i     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.String r3 = r8.getString(r3)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            int r3 = r3.intValue()     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            float r3 = (float) r3     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r2, (float) r3)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            goto L_0x0079
        L_0x0070:
            r8 = move-exception
            goto L_0x00ea
        L_0x0073:
            r8 = move-exception
            goto L_0x00ee
        L_0x0076:
            java.lang.String r0 = "-999"
            r2 = r0
        L_0x0079:
            java.lang.String r3 = r1.getClickURL()     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.String r0 = com.mbridge.msdk.click.c.a((java.lang.String) r3, (java.lang.String) r0, (java.lang.String) r2)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            r1.setClickURL(r0)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.String r0 = r1.getNoticeUrl()     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            if (r8 == 0) goto L_0x00e9
            java.util.Iterator r2 = r8.keys()     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            r3.<init>()     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
        L_0x0093:
            boolean r4 = r2.hasNext()     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            if (r4 == 0) goto L_0x00d7
            java.lang.String r4 = "&"
            r3.append(r4)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.Object r4 = r2.next()     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.String r5 = r8.optString(r4)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.f9189h     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            boolean r6 = r6.equals(r4)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            if (r6 != 0) goto L_0x00b8
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.f9190i     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            boolean r6 = r6.equals(r4)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            if (r6 == 0) goto L_0x00cb
        L_0x00b8:
            android.app.Activity r6 = r7.f12655p     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            int r5 = r5.intValue()     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            float r5 = (float) r5     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            int r5 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r6, (float) r5)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
        L_0x00cb:
            r3.append(r4)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.String r4 = "="
            r3.append(r4)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            r3.append(r5)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            goto L_0x0093
        L_0x00d7:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            r8.<init>()     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            r8.append(r0)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            r8.append(r3)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
            r1.setNoticeUrl(r8)     // Catch:{ JSONException -> 0x0073, all -> 0x0070 }
        L_0x00e9:
            return r1
        L_0x00ea:
            r8.printStackTrace()
            goto L_0x012c
        L_0x00ee:
            r8.printStackTrace()
            goto L_0x012c
        L_0x00f2:
            org.json.JSONObject r1 = com.mbridge.msdk.foundation.entity.CampaignEx.campaignToJsonObject(r9)     // Catch:{ JSONException -> 0x011e }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x011e }
            r2.<init>(r8)     // Catch:{ JSONException -> 0x011e }
            boolean r8 = r2.has(r0)     // Catch:{ Exception -> 0x0106 }
            if (r8 != 0) goto L_0x0106
            java.lang.String r8 = ""
            r1.put(r0, r8)     // Catch:{ Exception -> 0x0106 }
        L_0x0106:
            java.util.Iterator r8 = r2.keys()     // Catch:{ JSONException -> 0x011e }
        L_0x010a:
            boolean r0 = r8.hasNext()     // Catch:{ JSONException -> 0x011e }
            if (r0 == 0) goto L_0x0120
            java.lang.Object r0 = r8.next()     // Catch:{ JSONException -> 0x011e }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x011e }
            java.lang.String r3 = r2.getString(r0)     // Catch:{ JSONException -> 0x011e }
            r1.put(r0, r3)     // Catch:{ JSONException -> 0x011e }
            goto L_0x010a
        L_0x011e:
            r8 = move-exception
            goto L_0x0129
        L_0x0120:
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaignWithBackData(r1)     // Catch:{ JSONException -> 0x011e }
            r7.a((org.json.JSONObject) r1, (com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ JSONException -> 0x011e }
            r9 = r8
            goto L_0x012c
        L_0x0129:
            r8.printStackTrace()
        L_0x012c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.a.k.a(java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx):com.mbridge.msdk.foundation.entity.CampaignEx");
    }

    public k(Activity activity, CampaignEx campaignEx, List<CampaignEx> list) {
        this.f12655p = activity;
        this.f12659t = campaignEx;
        this.f12660u = list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r0 = com.mbridge.msdk.c.h.a().b(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(com.mbridge.msdk.foundation.entity.CampaignEx r7) {
        /*
            r6 = this;
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0038 }
            java.lang.String r0 = r0.k()     // Catch:{ Exception -> 0x0038 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0038 }
            r2 = 0
            if (r1 != 0) goto L_0x0022
            com.mbridge.msdk.c.h r1 = com.mbridge.msdk.c.h.a()     // Catch:{ Exception -> 0x0038 }
            com.mbridge.msdk.c.g r0 = r1.b(r0)     // Catch:{ Exception -> 0x0038 }
            if (r0 == 0) goto L_0x0022
            long r0 = r0.ad()     // Catch:{ Exception -> 0x0038 }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r4
            goto L_0x0023
        L_0x0022:
            r0 = r2
        L_0x0023:
            com.mbridge.msdk.videocommon.d.b r4 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x0038 }
            com.mbridge.msdk.videocommon.d.a r4 = r4.b()     // Catch:{ Exception -> 0x0038 }
            if (r4 == 0) goto L_0x0031
            long r2 = r4.f()     // Catch:{ Exception -> 0x0038 }
        L_0x0031:
            if (r7 == 0) goto L_0x0038
            boolean r7 = r7.isSpareOffer(r2, r0)     // Catch:{ Exception -> 0x0038 }
            return r7
        L_0x0038:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.a.k.b(com.mbridge.msdk.foundation.entity.CampaignEx):boolean");
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f12657r = str;
        }
    }

    private void a(JSONObject jSONObject, CampaignEx campaignEx) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (!TextUtils.isEmpty(optString)) {
                campaignEx.setCampaignUnitId(optString);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(int i5, String str) {
        super.a(i5, str);
        if (i5 == 2) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                final String optString = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, NotificationCompat.CATEGORY_EVENT);
                final String optString2 = jSONObject.optString("template", "-1");
                final String optString3 = jSONObject.optString(TtmlNode.TAG_LAYOUT, "-1");
                final String optString4 = jSONObject.optString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f12640j);
                final int m5 = ab.m(this.f12655p.getApplication());
                AnonymousClass1 r22 = new Runnable() {
                    public final void run() {
                        o.a((f) g.a((Context) k.this.f12655p.getApplication())).a(new n("2000039", optString, optString2, optString3, optString4, k.this.f12659t.getId(), m5, ab.a((Context) k.this.f12655p.getApplication(), m5)));
                    }
                };
                d.a();
                com.mbridge.msdk.foundation.same.f.a.b().execute(r22);
            } catch (Throwable th) {
                Throwable th2 = th;
                af.b("DefaultJSCommon", th2.getMessage(), th2);
            }
        }
    }

    public final void a(Activity activity) {
        this.f12655p = activity;
    }
}
