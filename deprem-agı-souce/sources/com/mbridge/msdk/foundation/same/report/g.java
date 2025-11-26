package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.f;
import org.json.JSONObject;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f9529a = new Handler(Looper.getMainLooper());

    public static void a(CampaignEx campaignEx, String str, String str2, String str3) {
        if (campaignEx != null && campaignEx.isMraid()) {
            n nVar = new n("m_download_end", !TextUtils.isEmpty(campaignEx.getMraid()) ? 1 : 3, "0", "", campaignEx.getId(), str2, str, String.valueOf(campaignEx.getKeyIaRst()));
            nVar.e(campaignEx.getId());
            nVar.f(campaignEx.getRequestId());
            nVar.s(campaignEx.getCurrentLocalRid());
            nVar.g(campaignEx.getRequestIdNotice());
            nVar.c(campaignEx.getAdSpaceT());
            nVar.d(str3);
            nVar.e(7);
            nVar.a(ab.m(c.m().c()));
            nVar.d(campaignEx.isMraid() ? n.f9116a : n.f9117b);
            d.a().a(nVar, campaignEx);
        }
    }

    public static void b(n nVar, String str, CampaignEx campaignEx) {
        if (nVar != null) {
            nVar.a("2000059");
            nVar.c(str);
            nVar.a(ab.m(c.m().c()));
            nVar.j(f.c());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", nVar.a());
                jSONObject.put("result", nVar.m());
                jSONObject.put(TypedValues.TransitionType.S_DURATION, nVar.n());
                jSONObject.put("cid", nVar.e());
                jSONObject.put("reason", nVar.h());
                jSONObject.put("ad_type", nVar.d());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, nVar.c());
                jSONObject.put("devid", nVar.j());
                jSONObject.put("mraid_type", nVar.B());
                jSONObject.put("network_type", nVar.k());
                jSONObject.put("rid_n", nVar.g());
                jSONObject.put("rid", nVar.f());
                if (!TextUtils.isEmpty(nVar.s())) {
                    jSONObject.put(CampaignEx.ENDCARD_URL, nVar.s());
                }
                if (!TextUtils.isEmpty(nVar.t())) {
                    jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, nVar.t());
                }
                if (nVar.b() != null) {
                    jSONObject.put("resource_type", nVar.b());
                }
                d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }

    public static void c(n nVar, Context context, String str) {
        if (nVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", nVar.a());
                jSONObject.put("cid", nVar.e());
                jSONObject.put("rid", nVar.f());
                jSONObject.put("rid_n", nVar.g());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, nVar.c());
                jSONObject.put("reason", nVar.h());
                jSONObject.put("case", nVar.C());
                jSONObject.put("network_type", nVar.k());
                d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }

    public static void d(n nVar, Context context, String str) {
        if (nVar != null) {
            nVar.a("2000060");
            nVar.c(str);
            nVar.a(ab.m(context));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", nVar.a());
                jSONObject.put("cid", nVar.e());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, nVar.c());
                jSONObject.put("network_type", nVar.k());
                jSONObject.put("mraid_type", nVar.B());
                jSONObject.put("rid_n", nVar.g());
                jSONObject.put("rid", nVar.f());
                d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }

    public static void a(n nVar, String str, CampaignEx campaignEx) {
        int adType;
        if (nVar != null) {
            nVar.j(f.c());
            if (campaignEx == null || !((adType = campaignEx.getAdType()) == 94 || adType == 287)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", nVar.a());
                    jSONObject.put("result", nVar.m());
                    jSONObject.put(TypedValues.TransitionType.S_DURATION, nVar.n());
                    jSONObject.put("cid", nVar.e());
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, nVar.c());
                    jSONObject.put("reason", nVar.h());
                    jSONObject.put("ad_type", nVar.d());
                    jSONObject.put("rid", nVar.f());
                    jSONObject.put("rid_n", nVar.g());
                    jSONObject.put("network_type", nVar.k());
                    jSONObject.put("mraid_type", nVar.B());
                    jSONObject.put("devid", nVar.j());
                    jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, nVar.t());
                    if (nVar.b() != null) {
                        jSONObject.put("resource_type", nVar.b());
                    }
                    if (!TextUtils.isEmpty(nVar.s())) {
                        jSONObject.put(CampaignEx.ENDCARD_URL, nVar.s());
                    }
                    d.a().a(jSONObject);
                } catch (Throwable th) {
                    af.b("VideoDataReport", th.getMessage());
                }
            } else {
                d.a().a(nVar, campaignEx);
            }
        }
    }

    public static void b(n nVar, Context context, String str) {
        if (nVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", nVar.a());
                jSONObject.put("cid", nVar.e());
                jSONObject.put("rid", nVar.f());
                jSONObject.put("rid_n", nVar.g());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, nVar.c());
                jSONObject.put("network_type", nVar.k());
                jSONObject.put("mraid_type", nVar.B());
                jSONObject.put("platform", "1");
                d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }

    public static void a(n nVar, Context context, String str) {
        if (nVar != null) {
            nVar.a("2000063");
            nVar.c(str);
            nVar.a(ab.m(context));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", nVar.a());
                jSONObject.put("cid", nVar.e());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, nVar.c());
                jSONObject.put("network_type", nVar.k());
                jSONObject.put("rid", nVar.f());
                jSONObject.put("rid_n", nVar.g());
                jSONObject.put("reason", nVar.h());
                d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }
}
