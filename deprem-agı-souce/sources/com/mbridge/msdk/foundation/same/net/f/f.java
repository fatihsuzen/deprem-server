package com.mbridge.msdk.foundation.same.net.f;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.controller.authoritycontroller.b;
import com.mbridge.msdk.foundation.controller.authoritycontroller.c;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;

public final class f {
    public static void a(e eVar) {
        eVar.a("api_version", a.f9185d);
    }

    public static void b(e eVar) {
        try {
            if (TextUtils.isEmpty(a.f9179V)) {
                a.f9179V = com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
            }
            if (!TextUtils.isEmpty(a.f9179V)) {
                eVar.a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, a.f9179V);
            }
            if (TextUtils.isEmpty(a.f9188g)) {
                a.f9188g = com.mbridge.msdk.foundation.a.a.a.a().a("c");
            }
            if (!TextUtils.isEmpty(a.f9188g)) {
                eVar.a("c", a.f9188g);
            }
        } catch (Exception e5) {
            af.b("CommonRequestParamsForAdd", e5.getMessage());
        }
    }

    public static void c(e eVar) {
        eVar.a("dyview_type", a.f9204w);
    }

    public static void d(e eVar) {
        String str;
        if (c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            eVar.a("withGP", ab.v() + "");
            eVar.a("has_wx", ab.v(com.mbridge.msdk.foundation.controller.c.m().c()) + "");
            eVar.a("integrated_wx", ab.z() + "");
            eVar.a("opensdk_ver", ab.u() + "");
            eVar.a("wx_api_ver", ab.c(com.mbridge.msdk.foundation.controller.c.m().h()) + "");
            eVar.a("mnc", ab.l(com.mbridge.msdk.foundation.controller.c.m().c()));
            eVar.a("mcc", ab.k(com.mbridge.msdk.foundation.controller.c.m().c()));
            String i5 = ab.i();
            if (!TextUtils.isEmpty(i5)) {
                eVar.a("hardware", i5);
            }
            eVar.a("adid_limit", com.mbridge.msdk.foundation.tools.f.a() + "");
            if (b.b()) {
                str = "1";
            } else {
                str = "0";
            }
            eVar.a("adid_limit_dev", str);
        }
        if (c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
            eVar.a(e.f9400g, ab.n());
        }
        g.b(eVar);
        a(eVar, false);
        g(eVar);
        b(eVar);
        h(eVar);
        i(eVar);
    }

    public static void e(e eVar) {
        if (ab.q() != 0) {
            eVar.a("tun", ab.q() + "");
        }
    }

    public static void f(e eVar) {
        if (eVar != null) {
            if (!c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                eVar.a("model");
                eVar.a("brand");
                eVar.a("screen_size");
                eVar.a("sub_ip");
                eVar.a("network_type");
                eVar.a("useragent");
                eVar.a("ua");
                eVar.a("language");
                eVar.a("network_str");
                eVar.a("os_version");
                eVar.a("country_code");
                eVar.a("cronet_env");
                eVar.a("adid_limit");
                eVar.a("adid_limit_dev");
            }
            if (!c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
                eVar.a(e.f9394a);
                eVar.a(e.f9395b);
                eVar.a("power_rate");
                eVar.a("charging");
                eVar.a("timezone");
            }
            if (!c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                eVar.a("gaid");
                eVar.a("gaid2");
                eVar.a("az_aid_info");
            }
            g.c(eVar);
        }
    }

    private static void g(e eVar) {
        int t5 = ab.t();
        if (t5 != -1) {
            eVar.a("unknown_source", t5 + "");
        }
    }

    private static void h(e eVar) {
        String e5 = com.mbridge.msdk.foundation.tools.f.e();
        if (!TextUtils.isEmpty(e5)) {
            eVar.a("az_aid_info", e5);
        }
    }

    private static void i(e eVar) {
        String str = com.mbridge.msdk.e.c.f8764a;
        if (!TextUtils.isEmpty(str)) {
            eVar.a("cronet_env", str);
        }
    }

    public static void a(e eVar, Context context) {
        if (c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            eVar.a("withGP", ab.v() + "");
            eVar.a("has_wx", ab.v(context) + "");
            eVar.a("integrated_wx", ab.z() + "");
            eVar.a("opensdk_ver", ab.u() + "");
            eVar.a("wx_api_ver", ab.c(com.mbridge.msdk.foundation.controller.c.m().h()) + "");
            eVar.a("mnc", ab.l(com.mbridge.msdk.foundation.controller.c.m().c()));
            eVar.a("mcc", ab.k(com.mbridge.msdk.foundation.controller.c.m().c()));
            String i5 = ab.i();
            if (!TextUtils.isEmpty(i5)) {
                eVar.a("hardware", i5);
            }
            c.j();
            String str = "1";
            if (com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_DNT, 0) == 1) {
                eVar.a("dnt", str);
            }
            String str2 = e.f9396c;
            eVar.a(str2, c.j().f() + "");
            eVar.a("adid_limit", com.mbridge.msdk.foundation.tools.f.a() + "");
            if (!b.b()) {
                str = "0";
            }
            eVar.a("adid_limit_dev", str);
        }
        if (c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
            String str3 = e.f9394a;
            eVar.a(str3, ai.b() + "");
            String str4 = e.f9395b;
            eVar.a(str4, ai.a() + "");
            eVar.a(e.f9400g, ab.n());
        }
        eVar.a("pkg_source", ab.a(ab.f(context), context));
        if (com.mbridge.msdk.foundation.controller.c.m().i() != null) {
            eVar.a("web_env", com.mbridge.msdk.foundation.controller.c.m().i().toString());
        }
        eVar.a("http_req", "2");
        g.a(eVar, context);
        a(eVar, true);
        g(eVar);
        b(eVar);
        g b5 = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        if (b5 == null) {
            h.a();
            b5 = i.a();
        }
        if (b5.K() == 1) {
            eVar.a("gdpr_consent", c.j().g() + "");
        } else if (b5.aH()) {
            eVar.a("gdpr_consent", c.j().g() + "");
        }
        String i6 = c.j().i();
        if (!TextUtils.isEmpty(i6)) {
            eVar.a("tc_string", i6);
        }
        h(eVar);
        i(eVar);
        g.a(eVar);
    }

    private static void a(e eVar, boolean z4) {
        g b5 = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
        if (b5 != null) {
            if (!TextUtils.isEmpty(b5.d()) && z4) {
                eVar.a("a_stid", b5.d());
            }
            try {
                g.a(eVar, c5, z4, b5);
            } catch (Exception e5) {
                af.b("CommonRequestParamsForAdd", e5.getMessage());
            }
        }
    }
}
