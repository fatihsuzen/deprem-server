package com.mbridge.msdk.newreward.function.f;

import android.content.Context;
import android.os.Build;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.same.net.e.b;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.out.MBConfiguration;
import java.util.Map;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, String> f10975a;

    /* access modifiers changed from: protected */
    public final Map<String, String> a() {
        String str = "";
        if (f10975a == null) {
            e eVar = new e();
            eVar.a("platform", "1");
            eVar.a("os_version", Build.VERSION.RELEASE);
            Context c5 = c.m().c();
            eVar.a(CampaignEx.JSON_KEY_PACKAGE_NAME, ab.f(c5));
            eVar.a("app_version_name", ab.q(c5));
            eVar.a("app_version_code", ab.r(c5) + str);
            eVar.a("orientation", ab.s(c5) + str);
            eVar.a("model", ab.h());
            eVar.a("brand", ab.x());
            eVar.a("gaid2", f.b());
            eVar.a("gaid", str);
            int m5 = ab.m(c5);
            eVar.a("network_type", m5 + str);
            eVar.a("network_str", ab.a(c5, m5));
            eVar.a("language", ab.t(c5));
            eVar.a("timezone", ab.y());
            eVar.a("useragent", ab.g());
            eVar.a("sdk_version", MBConfiguration.SDK_VERSION);
            eVar.a("screen_size", ab.j(c5) + "x" + ab.h(c5));
            b.a(eVar, MBridgeConstans.APP_ID, c.m().k());
            eVar.a("band_width", com.mbridge.msdk.foundation.same.net.a.a().b() + str);
            eVar.a("open", com.mbridge.msdk.foundation.same.a.f9176S);
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.a()) {
                eVar.a("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                eVar.a("re_domain", "1");
            }
            long currentTimeMillis = System.currentTimeMillis();
            String l5 = c.m().l();
            b.a(eVar, "sign", l5);
            eVar.a(CampaignEx.JSON_KEY_ST_TS, currentTimeMillis + str);
            if (com.mbridge.msdk.e.b.a()) {
                eVar.a("st", SameMD5.getMD5(l5 + currentTimeMillis));
            } else {
                eVar.a("st", SameMD5.getMD5(currentTimeMillis + l5));
            }
            f10975a = eVar.a();
        }
        Map<String, String> map = f10975a;
        if (map != null) {
            String a5 = Aa.a();
            if (a5 != null) {
                str = a5;
            }
            map.put("channel", str);
        }
        return f10975a;
    }
}
