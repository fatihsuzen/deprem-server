package com.mbridge.msdk.foundation.same.report;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.authoritycontroller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class n {
    public static void a(List<com.mbridge.msdk.foundation.entity.n> list) {
        if (list != null && !list.isEmpty()) {
            for (com.mbridge.msdk.foundation.entity.n next : list) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (next.b() != null) {
                        jSONObject.put("resource_type", next.b());
                    }
                    if (next.i() != null) {
                        jSONObject.put("creative", next.i());
                    }
                    jSONObject.put("key", next.a());
                    jSONObject.put("result", next.m());
                    jSONObject.put(TypedValues.TransitionType.S_DURATION, next.n());
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, next.o());
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, next.p());
                    jSONObject.put("reason", next.h());
                    jSONObject.put("cid", next.e());
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_URL, next.q());
                    jSONObject.put("rid", next.f());
                    jSONObject.put("rid_n", next.g());
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, next.c());
                    jSONObject.put("offer_url", next.r());
                    if (c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                        jSONObject.put("network_type", next.k());
                        jSONObject.put("network_str", next.l());
                    }
                    d.a().a(jSONObject);
                } catch (Throwable th) {
                    af.b("VideoDataReport", th.getMessage());
                }
            }
        }
    }

    public static void b(List<com.mbridge.msdk.foundation.entity.n> list) {
        if (list != null && !list.isEmpty()) {
            for (com.mbridge.msdk.foundation.entity.n next : list) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", next.a());
                    jSONObject.put("result", next.m());
                    jSONObject.put(TypedValues.TransitionType.S_DURATION, next.n());
                    jSONObject.put(CampaignEx.ENDCARD_URL, next.s());
                    jSONObject.put("cid", next.e());
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, next.c());
                    jSONObject.put("reason", next.h());
                    jSONObject.put("ad_type", next.d());
                    jSONObject.put("rid", next.f());
                    jSONObject.put("rid_n", next.g());
                    jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, next.t());
                    jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, next.u());
                    d.a().a(jSONObject);
                } catch (Throwable th) {
                    af.b("VideoDataReport", th.getMessage());
                }
            }
        }
    }

    public static void c(List<com.mbridge.msdk.foundation.entity.n> list) {
        Iterator<com.mbridge.msdk.foundation.entity.n> it;
        Iterator<com.mbridge.msdk.foundation.entity.n> it2;
        if (list != null) {
            try {
                it2 = list;
                if (!list.isEmpty()) {
                    it = list.iterator();
                    while (it.hasNext()) {
                        com.mbridge.msdk.foundation.entity.n next = it.next();
                        if (next != null) {
                            it2 = it;
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("key", next.a());
                            jSONObject.put(NotificationCompat.CATEGORY_EVENT, ak.a(next.v()));
                            jSONObject.put("template", ak.a(next.w()));
                            jSONObject.put(TtmlNode.TAG_LAYOUT, ak.a(next.x()));
                            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, ak.a(next.c()));
                            jSONObject.put("cid", ak.a(next.e()));
                            if (c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                                jSONObject.put("network_str", next.l());
                                jSONObject.put("network_type", next.k());
                            }
                            d.a().a(jSONObject);
                        }
                    }
                }
            } catch (Exception e5) {
                af.b("VideoDataReport", e5.getMessage());
                it = it2;
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }

    public static void d(List<com.mbridge.msdk.foundation.entity.n> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    for (com.mbridge.msdk.foundation.entity.n next : list) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("key", next.a());
                        jSONObject.put("cid", next.e());
                        jSONObject.put(CampaignEx.JSON_KEY_IMAGE_URL, next.y());
                        jSONObject.put("reason", next.h());
                        jSONObject.put("rid", next.f());
                        jSONObject.put("rid_n", next.g());
                        jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, next.c());
                        if (c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                            jSONObject.put("network_type", next.k());
                        }
                        d.a().a(jSONObject);
                    }
                }
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }

    public static void e(List<com.mbridge.msdk.foundation.entity.n> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    for (com.mbridge.msdk.foundation.entity.n next : list) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("key", next.a());
                        jSONObject.put("reason", next.h());
                        jSONObject.put("cid", next.e());
                        jSONObject.put(CampaignEx.JSON_KEY_VIDEO_URL, next.q());
                        jSONObject.put("rid", next.f());
                        jSONObject.put("rid_n", next.g());
                        jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, next.c());
                        jSONObject.put("offer_url", next.r());
                        if (c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                            jSONObject.put("network_type", next.k());
                            jSONObject.put("network_str", next.l());
                        }
                        d.a().a(jSONObject);
                    }
                }
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }

    public static String f(List<com.mbridge.msdk.foundation.entity.n> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.isEmpty()) {
                return null;
            }
            for (com.mbridge.msdk.foundation.entity.n next : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", next.a());
                jSONObject.put("cid", next.e());
                jSONObject.put("template_url", next.D());
                jSONObject.put("reason", next.h());
                jSONObject.put("rid", next.f());
                jSONObject.put("rid_n", next.g());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, next.c());
                jSONObject.put("result", next.m());
                if (c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("network_type", next.k());
                }
                d.a().a(jSONObject);
            }
            return null;
        } catch (Throwable th) {
            af.b("VideoDataReport", th.getMessage());
            return null;
        }
    }

    public static void b(com.mbridge.msdk.foundation.entity.n nVar) {
        if (nVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", nVar.a());
                jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, ak.a(nVar.E()));
                jSONObject.put("template_url", ak.a(nVar.D()));
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, ak.a(nVar.c()));
                jSONObject.put("cid", ak.a(nVar.e()));
                if (c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("network_str", nVar.l());
                    jSONObject.put("network_type", nVar.k());
                }
                d.a().a(jSONObject);
            } catch (Exception e5) {
                af.b("VideoDataReport", e5.getMessage());
            }
        }
    }

    public static String a(com.mbridge.msdk.foundation.entity.n nVar) {
        if (nVar == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", nVar.a());
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, ak.a(nVar.v()));
            jSONObject.put("template", ak.a(nVar.w()));
            jSONObject.put(TtmlNode.TAG_LAYOUT, ak.a(nVar.x()));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, ak.a(nVar.c()));
            jSONObject.put("cid", ak.a(nVar.e()));
            if (c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("network_str", nVar.l());
                jSONObject.put("network_type", nVar.k());
            }
            return jSONObject.toString();
        } catch (Exception e5) {
            af.b("VideoDataReport", e5.getMessage());
            return "";
        }
    }
}
