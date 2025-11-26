package com.mbridge.msdk.videocommon.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.same.net.e.d;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.videocommon.d.b;
import com.mbridge.msdk.videocommon.d.c;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f13014a = "com.mbridge.msdk.videocommon.c.a";

    public final void a(Context context, final String str, String str2) {
        e eVar = new e();
        eVar.a(MBridgeConstans.APP_ID, str);
        eVar.a("sign", SameMD5.getMD5(str + str2));
        try {
            com.mbridge.msdk.videocommon.d.a e5 = b.a().e();
            if (e5 == null) {
                eVar.a("vtag", "");
            } else {
                String a5 = e5.a();
                if (TextUtils.isEmpty(a5)) {
                    a5 = "";
                }
                eVar.a("vtag", a5);
            }
        } catch (Throwable th) {
            af.b(f13014a, th.getMessage());
        }
        new b(context).get(1, d.f().f9348I, eVar, (com.mbridge.msdk.foundation.same.net.b) new com.mbridge.msdk.foundation.same.net.f.d() {
            public final void a(JSONObject jSONObject) {
                try {
                    if (ak.a(jSONObject)) {
                        b.a().a(false);
                        if (jSONObject.optInt("vtag_status", 0) == 1) {
                            String g5 = b.a().g(str);
                            if (!TextUtils.isEmpty(g5)) {
                                jSONObject = h.a().a(new JSONObject(g5), jSONObject);
                            }
                        }
                        try {
                            jSONObject.put("current_time", System.currentTimeMillis());
                            b.a().c(str, jSONObject.toString());
                        } catch (JSONException e5) {
                            af.b(a.f13014a, e5.getMessage());
                        }
                    } else {
                        b.a().f(str);
                    }
                } catch (Exception e6) {
                    af.b(a.f13014a, e6.getMessage());
                } catch (Throwable th) {
                    af.b(a.f13014a, th.getMessage());
                    return;
                }
                a.this.a(1, 2, "");
            }

            public final void a(String str) {
                b.a().a(false);
                af.b(a.f13014a, str);
                a.this.a(2, 2, str);
            }
        }, "setting", (long) ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        a(3, 2, "");
    }

    public final void a(Context context, final String str, String str2, String str3, final c cVar) {
        e eVar = new e();
        eVar.a(MBridgeConstans.APP_ID, str);
        eVar.a("sign", SameMD5.getMD5(str + str2));
        eVar.a("unit_ids", "[" + str3 + "]");
        try {
            c f5 = b.a().f(str, str3);
            if (f5 == null) {
                eVar.a("vtag", "");
            } else {
                String j5 = f5.j();
                if (TextUtils.isEmpty(j5)) {
                    j5 = "";
                }
                eVar.a("vtag", j5);
            }
        } catch (Throwable th) {
            af.b(f13014a, th.getMessage());
        }
        AnonymousClass2 r6 = new com.mbridge.msdk.foundation.same.net.f.d() {
            public final void a(final JSONObject jSONObject) {
                try {
                    b.a().b(this.unitId);
                } catch (Exception e5) {
                    af.b(a.f13014a, e5.getMessage());
                } catch (Throwable th) {
                    af.b(a.f13014a, th.getMessage());
                    return;
                }
                if (ak.a(jSONObject)) {
                    if (jSONObject.optInt("vtag_status", 0) == 1) {
                        String e6 = b.a().e(str, this.unitId);
                        if (!TextUtils.isEmpty(e6)) {
                            try {
                                jSONObject = h.a().a(new JSONObject(e6), jSONObject);
                            } catch (Exception e7) {
                                af.b(a.f13014a, e7.getMessage());
                            }
                        }
                    }
                    if (b.e(jSONObject.toString())) {
                        jSONObject.put("current_time", System.currentTimeMillis());
                        AnonymousClass1 r02 = new Runnable() {
                            public final void run() {
                                b a5 = b.a();
                                AnonymousClass2 r12 = AnonymousClass2.this;
                                a5.a(str, r12.unitId, jSONObject.toString());
                            }
                        };
                        com.mbridge.msdk.foundation.controller.d.a();
                        com.mbridge.msdk.foundation.same.f.a.b().execute(r02);
                        c cVar = cVar;
                        if (cVar != null) {
                            cVar.a("request success");
                        }
                    } else {
                        c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.b("data error");
                        }
                    }
                } else {
                    b.a().d(str, this.unitId);
                }
                a.this.a(1, 3, "");
            }

            public final void a(String str) {
                try {
                    b.a().b(this.unitId);
                } catch (Exception e5) {
                    af.b(a.f13014a, e5.getMessage());
                }
                if (!TextUtils.isEmpty(str)) {
                    c cVar = cVar;
                    if (cVar != null) {
                        cVar.b(str);
                    }
                } else {
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.b("request error");
                    }
                }
                a.this.a(2, 3, str);
            }
        };
        r6.setUnitId(str3);
        new b(context).get(1, d.f().f9348I, eVar, (com.mbridge.msdk.foundation.same.net.b) r6, "setting", (long) ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        a(3, 3, "");
    }

    /* access modifiers changed from: private */
    public void a(int i5, int i6, String str) {
        try {
            com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a("key", "2000112");
            eVar.a("st_net", Integer.valueOf(d.f().f9384s));
            eVar.a("result", Integer.valueOf(i5));
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(i6));
            eVar.a("url", d.f().f9383r ? d.f().f9349J : d.f().f9348I);
            eVar.a("reason", str);
            cVar.a("2000112", eVar);
            com.mbridge.msdk.foundation.same.report.d.d.a().a("2000112", cVar);
        } catch (Throwable th) {
            af.b(f13014a, th.getMessage());
        }
    }
}
