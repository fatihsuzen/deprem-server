package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.f.a;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import java.io.File;
import java.net.URLEncoder;
import org.json.JSONObject;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9530a = "h";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Context f9531b;

    public h(Context context, int i5) {
        this.f9531b = context;
    }

    public final void a(l lVar) {
    }

    public final void b(String str, String str2, String str3, String str4, String str5, boolean z4) {
        try {
            if (!TextUtils.isEmpty(str5)) {
                JSONObject jSONObject = new JSONObject();
                if (z4) {
                    jSONObject.put(CampaignEx.JSON_KEY_HB, 1);
                }
                jSONObject.put("key", URLEncoder.encode("2000066", "utf-8"));
                jSONObject.put("rid", URLEncoder.encode(str, "utf-8"));
                jSONObject.put("rid_n", URLEncoder.encode(str2, "utf-8"));
                jSONObject.put("cid", URLEncoder.encode(str3, "utf-8"));
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, URLEncoder.encode(str4, "utf-8"));
                jSONObject.put("err_method", str5);
                d.a().a(jSONObject);
            }
        } catch (Exception e5) {
            af.b(f9530a, e5.getMessage());
        }
    }

    public h(Context context) {
        this.f9531b = context.getApplicationContext();
    }

    public final void a(int i5, int i6, String str, String str2, String str3) {
        Context context = this.f9531b;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000058");
            jSONObject.put("appid", c.m().k());
            jSONObject.put("dl_type", String.valueOf(i5));
            jSONObject.put("dl_link_type", String.valueOf(i6));
            jSONObject.put("rid", str);
            jSONObject.put("rid_n", str2);
            jSONObject.put("cid", str3);
            jSONObject.put("tgt_v", ab.u(context));
            jSONObject.put("app_v_n", ab.q(context));
            jSONObject.put("app_v_c", ab.r(context));
            d.a().a(jSONObject);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("ReportControllerDiff", e5.getMessage());
            }
        }
    }

    public final void a(String str, File file) {
        d.a().c(str);
        if (file != null) {
            try {
                file.delete();
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b(f9530a, "reportException", e5);
                }
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, boolean z4) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (z4) {
                jSONObject.put(CampaignEx.JSON_KEY_HB, 1);
            }
            jSONObject.put("key", URLEncoder.encode("2000065", "utf-8"));
            jSONObject.put("rid", URLEncoder.encode(str, "utf-8"));
            jSONObject.put("rid_n", URLEncoder.encode(str2, "utf-8"));
            jSONObject.put("cid", URLEncoder.encode(str3, "utf-8"));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, URLEncoder.encode(str4, "utf-8"));
            jSONObject.put(CampaignEx.JSON_KEY_CLICK_URL, URLEncoder.encode(str5, "utf-8"));
            d.a().a(jSONObject);
        } catch (Exception e5) {
            af.b(f9530a, e5.getMessage());
        }
    }

    public final void a(final l lVar, final Boolean bool) {
        if (lVar == null) {
            return;
        }
        if (lVar.b().equals(ShareTarget.METHOD_GET)) {
            d.a().c(lVar.a());
            a.e().execute(new Runnable() {
                public final void run() {
                    try {
                        if (h.this.f9531b == null) {
                            return;
                        }
                        if (lVar != null) {
                            com.mbridge.msdk.foundation.db.l.a((f) g.a(h.this.f9531b)).a(lVar.d());
                            if (bool.booleanValue() && com.mbridge.msdk.foundation.db.l.a((f) g.a(h.this.f9531b)).b() > 20) {
                                com.mbridge.msdk.foundation.controller.d.a().b();
                            }
                        }
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b(h.f9530a, "reportNetError", e5);
                        }
                    }
                }
            });
        } else if (lVar.b().equals(ShareTarget.METHOD_POST)) {
            d.a().c(lVar.a());
            a.e().execute(new Runnable() {
                public final void run() {
                    if (h.this.f9531b != null && lVar != null) {
                        try {
                            com.mbridge.msdk.foundation.db.l.a((f) g.a(h.this.f9531b)).a(lVar.a(), lVar.d(), lVar.c());
                            if (bool.booleanValue() && com.mbridge.msdk.foundation.db.l.a((f) g.a(h.this.f9531b)).a() > 0) {
                                com.mbridge.msdk.foundation.controller.d.a().b();
                            }
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b(h.f9530a, "reportNetError", e5);
                            }
                        }
                    }
                }
            });
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        try {
            int m5 = ab.m(this.f9531b);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", URLEncoder.encode("2000071", "utf-8"));
            jSONObject.put("rid", URLEncoder.encode(str, "utf-8"));
            jSONObject.put("rid_n", URLEncoder.encode(str2, "utf-8"));
            jSONObject.put("cid", URLEncoder.encode(str3, "utf-8"));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, URLEncoder.encode(str4, "utf-8"));
            jSONObject.put("reason", URLEncoder.encode(str5, "utf-8"));
            jSONObject.put("network_type", URLEncoder.encode(String.valueOf(m5), "utf-8"));
            jSONObject.put("result", URLEncoder.encode("0", "utf-8"));
            d.a().a(jSONObject);
        } catch (Exception e5) {
            af.b(f9530a, e5.getMessage());
        }
    }

    public final void a() {
        try {
            if (i.a()) {
                String k5 = c.m().k();
                com.mbridge.msdk.c.g b5 = com.mbridge.msdk.c.h.a().b(k5);
                if (b5 == null) {
                    com.mbridge.msdk.c.h.a();
                    b5 = i.a();
                }
                String c5 = com.mbridge.msdk.foundation.tools.f.c();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "2000053");
                jSONObject.put("Appid", k5);
                jSONObject.put("uptips2", b5.au());
                jSONObject.put("info_status", com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().h());
                jSONObject.put("iseu", b5.M());
                if (!TextUtils.isEmpty(c5)) {
                    jSONObject.put("gaid", c5);
                }
                jSONObject.put("GDPR_area", b5.aH());
                jSONObject.put("GDPR_consent", com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().g());
                d.a().a(jSONObject);
                i.b();
            }
        } catch (Throwable th) {
            af.b(f9530a, th.getMessage());
        }
    }
}
