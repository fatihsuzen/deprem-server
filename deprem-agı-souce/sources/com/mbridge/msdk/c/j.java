package com.mbridge.msdk.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.a.a.a;
import com.mbridge.msdk.foundation.same.net.b;
import com.mbridge.msdk.foundation.same.net.e.d;
import com.mbridge.msdk.foundation.same.net.f.c;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import org.json.JSONArray;
import org.json.JSONObject;

public class j {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f8017a = "j";

    private String b() {
        String str = d.f().f9383r ? d.f().f9347H : d.f().f9346G;
        try {
            if (!d.f().f9383r || !d.f().f9382q || d.f().f9387v >= d.f().f9388w.size()) {
                return str;
            }
            String str2 = d.f().f9388w.get(d.f().f9387v);
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if (!str2.startsWith("http")) {
                if (!str2.startsWith("https")) {
                    return str;
                }
            }
            return str2 + "/setting";
        } catch (Throwable th) {
            af.b(f8017a, th.getMessage());
            return str;
        }
    }

    /* access modifiers changed from: private */
    public void c(final Context context, final String str, final String str2) {
        if (!d.f().a()) {
            try {
                if (!d.f().f9382q) {
                    d.f().f9382q = true;
                    if (System.currentTimeMillis() >= a.a().b("mkey_spare_host_ts").longValue() + 86400000) {
                        String a5 = a.a().a("mkey_spare_host");
                        if (!TextUtils.isEmpty(a5)) {
                            for (String str3 : a5.split("\n")) {
                                if (!TextUtils.isEmpty(str3.trim()) && !d.f().f9385t.contains(str3.trim())) {
                                    d.f().f9385t.add(str3.trim());
                                    d.f().f9388w.add(str3.trim());
                                }
                            }
                            c(context, str, str2);
                            return;
                        }
                    }
                    new c(context.getApplicationContext()).get(0, d.f().f9367b, new e(), (b) new com.mbridge.msdk.foundation.same.net.b.a() {
                        public final void a(String str) {
                            d.f().f9382q = false;
                            String a5 = j.f8017a;
                            af.a(a5, "fetch CNDSettingHost failed, errorCode = " + str);
                        }

                        public final void b(String str) {
                            af.a(j.f8017a, "fetch CNDSettingHost success, content = " + str);
                            if (!TextUtils.isEmpty(str)) {
                                a.a().a("mkey_spare_host_ts", System.currentTimeMillis());
                                a.a().a("mkey_spare_host", str);
                                for (String str2 : str.split("\n")) {
                                    if (!TextUtils.isEmpty(str2.trim()) && !d.f().f9385t.contains(str2.trim())) {
                                        d.f().f9385t.add(str2.trim());
                                        d.f().f9388w.add(str2.trim());
                                    }
                                }
                                j.this.c(context, str, str2);
                            }
                        }
                    }, "setting", (long) ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                d.f().f9382q = false;
                af.b(f8017a, th2.getMessage());
            }
        } else {
            b(context, str, str2);
        }
    }

    public final void a(Context context, String str, String str2) {
        a(context, str, str2, "1", new com.mbridge.msdk.foundation.same.net.f.d() {
            public final void a(String str) {
            }

            public final void a(JSONObject jSONObject) {
                if (jSONObject != null && jSONObject.has(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I)) {
                    try {
                        v.a().a(jSONObject.getString(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I));
                    } catch (Exception e5) {
                        af.b(j.f8017a, e5.getMessage());
                    }
                }
            }
        });
    }

    private void a(Context context, String str, String str2, String str3, com.mbridge.msdk.foundation.same.net.f.d dVar) {
        if (context != null) {
            e eVar = new e();
            eVar.a(MBridgeConstans.APP_ID, str);
            eVar.a("sign", SameMD5.getMD5(str + str2));
            try {
                String ay = h.a().a(str).ay();
                if (TextUtils.isEmpty(ay)) {
                    ay = "";
                }
                eVar.a("vtag", ay);
            } catch (Throwable th) {
                af.b(f8017a, th.getMessage());
            }
            if (d.f().f9382q) {
                eVar.a("st_net", d.f().f9384s + "");
            }
            eVar.a("only_p_info", str3);
            com.mbridge.msdk.c.a.c cVar = new com.mbridge.msdk.c.a.c(context);
            String str4 = d.f().f9346G;
            try {
                if (d.f().f9383r && d.f().f9382q && d.f().f9387v < d.f().f9388w.size()) {
                    String str5 = d.f().f9388w.get(d.f().f9387v);
                    if (!TextUtils.isEmpty(str5)) {
                        if (!str5.startsWith("http")) {
                            if (str5.startsWith("https")) {
                            }
                        }
                        str4 = str5 + "/setting";
                    }
                }
            } catch (Throwable th2) {
                af.b(f8017a, th2.getMessage());
            }
            cVar.get(1, str4, eVar, (b) dVar, "setting", (long) ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        }
    }

    public final void b(final Context context, final String str, final String str2) {
        if (context != null) {
            a(context, str, str2, "0", new com.mbridge.msdk.foundation.same.net.f.d() {
                public final void a(JSONObject jSONObject) {
                    try {
                        j.this.a(1, 0, "");
                    } catch (Throwable th) {
                        af.b(j.f8017a, th.getMessage());
                    }
                    try {
                        if (ak.a(jSONObject)) {
                            if (jSONObject.optInt("vtag_status", 0) == 1) {
                                String g5 = h.a().g(str);
                                if (!TextUtils.isEmpty(g5)) {
                                    try {
                                        jSONObject = h.a().a(new JSONObject(g5), jSONObject);
                                    } catch (Exception e5) {
                                        af.b(j.f8017a, e5.getMessage());
                                    }
                                }
                            }
                            jSONObject.put("current_time", System.currentTimeMillis());
                            if (d.f().f9383r) {
                                if (TextUtils.isEmpty(jSONObject.optString("hst_st_t"))) {
                                    jSONObject.put("hst_st_t", d.f().f9377l);
                                }
                            } else if (TextUtils.isEmpty(jSONObject.optString("hst_st"))) {
                                jSONObject.put("hst_st", d.f().f9373h);
                            }
                            h.a().g(str, jSONObject.toString());
                            d.f().e();
                            try {
                                if (!TextUtils.isEmpty(jSONObject.optString("mraid_js"))) {
                                    com.mbridge.msdk.c.b.a.a().a(context, jSONObject.optString("mraid_js"));
                                }
                            } catch (Exception e6) {
                                af.b(j.f8017a, e6.getMessage());
                            }
                            if (!TextUtils.isEmpty(jSONObject.optString("web_env_url"))) {
                                com.mbridge.msdk.c.b.b.a().a(context, jSONObject.optString("web_env_url"));
                            }
                            j.a(j.this, context, str);
                        } else {
                            h.a().f(str);
                        }
                        j.a(j.this);
                    } catch (Exception e7) {
                        af.b(j.f8017a, e7.getMessage());
                    }
                }

                public final void a(String str) {
                    try {
                        j.this.a(2, 0, str);
                    } catch (Throwable th) {
                        af.b(j.f8017a, th.getMessage());
                    }
                    if (!d.f().f9383r) {
                        d.f().f9386u++;
                    } else {
                        d.f().f9387v++;
                    }
                    j.this.c(context, str, str2);
                    j.a(j.this);
                    af.b(j.f8017a, "get app setting error" + str);
                }
            });
            a(3, 0, "");
        }
    }

    public final void a(Context context, final String str, String str2, final String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = com.mbridge.msdk.foundation.controller.c.m().k();
            str2 = com.mbridge.msdk.foundation.controller.c.m().b();
        }
        if (h.a().e(str3, str) && h.a().a(str, 2, str3)) {
            e eVar = new e();
            String str4 = "[" + str3 + "]";
            eVar.a("unit_ids", str4);
            eVar.a(MBridgeConstans.APP_ID, str);
            eVar.a("sign", SameMD5.getMD5(str + str2));
            try {
                String t5 = h.a().c(str, str4).t();
                if (TextUtils.isEmpty(t5)) {
                    t5 = "";
                }
                eVar.a("vtag", t5);
            } catch (Throwable th) {
                af.b(f8017a, th.getMessage());
            }
            AnonymousClass4 r6 = new com.mbridge.msdk.foundation.same.net.f.d() {
                public final void a(JSONObject jSONObject) {
                    try {
                        if (ak.a(jSONObject)) {
                            String optString = jSONObject.optString("vtag", "");
                            String optString2 = jSONObject.optString("rid", "");
                            JSONArray optJSONArray = jSONObject.optJSONArray("unitSetting");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                                if (jSONObject.optInt("vtag_status", 0) == 1) {
                                    h.a();
                                    String str = str;
                                    String str2 = str3;
                                    String a5 = a.a().a(str + "_" + str2);
                                    if (!TextUtils.isEmpty(a5)) {
                                        try {
                                            optJSONObject = h.a().a(new JSONObject(a5), optJSONObject);
                                        } catch (Exception e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                }
                                optJSONObject.put("current_time", System.currentTimeMillis());
                                optJSONObject.put("vtag", optString);
                                optJSONObject.put("rid", optString2);
                                h.a().a(str, str3, optJSONObject.toString());
                            }
                        } else {
                            h.a().h(str, str3);
                        }
                        j.this.a(1, 1, "");
                    } catch (Exception e6) {
                        af.b(j.f8017a, e6.getMessage());
                    }
                }

                public final void a(String str) {
                    j.this.a(2, 1, "");
                }
            };
            r6.setUnitId(str3);
            new com.mbridge.msdk.c.a.c(context).get(1, d.f().f9346G, eVar, (b) r6, "setting", (long) ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
            a(3, 1, "");
        }
    }

    /* access modifiers changed from: private */
    public void a(int i5, int i6, String str) {
        String str2;
        try {
            com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a("key", "2000112");
            eVar.a("st_net", Integer.valueOf(d.f().f9384s));
            eVar.a("result", Integer.valueOf(i5));
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(i6));
            if (i6 == 0) {
                str2 = b();
            } else {
                str2 = d.f().f9383r ? d.f().f9347H : d.f().f9346G;
            }
            eVar.a("url", str2);
            eVar.a("reason", str);
            cVar.a("2000112", eVar);
            com.mbridge.msdk.foundation.same.report.d.d.a().a("2000112", cVar);
        } catch (Throwable th) {
            af.b(f8017a, th.getMessage());
        }
    }

    static /* synthetic */ void a(j jVar, Context context, String str) {
        g b5;
        h a5 = h.a();
        if (!(a5 == null || (b5 = a5.b(str)) == null)) {
            MBridgeConstans.OMID_JS_SERVICE_URL = b5.X();
            MBridgeConstans.OMID_JS_H5_URL = b5.W();
        }
        com.mbridge.msdk.a.b.a(context);
        com.mbridge.msdk.a.b.b(context);
    }

    static /* synthetic */ void a(j jVar) {
        try {
            new h(com.mbridge.msdk.foundation.controller.c.m().c()).a();
        } catch (Throwable th) {
            af.b(f8017a, th.getMessage());
        }
    }
}
