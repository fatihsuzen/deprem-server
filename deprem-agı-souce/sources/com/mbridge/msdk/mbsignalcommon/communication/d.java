package com.mbridge.msdk.mbsignalcommon.communication;

import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.a.b;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import org.json.JSONObject;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10163a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static int f10164b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f10165c = 1;

    public static void a(Object obj, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            final CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject);
            if (parseCampaignWithBackData == null) {
                a(obj, "data camapign is empty");
                return;
            }
            new Thread(new Runnable() {
                public final void run() {
                    try {
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
                        d.a(parseCampaignWithBackData.getCampaignUnitId(), parseCampaignWithBackData);
                    } catch (Throwable th) {
                        af.b(d.f10163a, th.getMessage(), th);
                    }
                }
            }).start();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", f10164b);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", "");
            jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject3);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e5) {
            a(obj, e5.getMessage());
            af.a(f10163a, e5.getMessage());
        } catch (Throwable th) {
            a(obj, th.getMessage());
        }
    }

    public static String a(float f5, float f6) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(a.f9189h, ak.b(c.m().c(), f5));
            jSONObject2.put(a.f9190i, ak.b(c.m().c(), f6));
            jSONObject2.put(a.f9194m, 0);
            jSONObject2.put(a.f9192k, c.m().c().getResources().getConfiguration().orientation);
            jSONObject2.put(a.f9193l, (double) ak.d(c.m().c()));
            jSONObject.put(a.f9191j, jSONObject2);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String a(int i5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i5);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                return Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
            return "";
        } catch (Throwable unused) {
            af.b(f10163a, "code to string is error");
            return "";
        }
    }

    public static void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f10165c);
            jSONObject.put("message", str);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            af.a(f10163a, e5.getMessage());
        }
    }

    static /* synthetic */ void a(String str, CampaignEx campaignEx) {
        if (b.f9212b != null && !TextUtils.isEmpty(campaignEx.getId())) {
            b.a(str, campaignEx, "banner");
        }
    }
}
