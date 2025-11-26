package com.mbridge.msdk.videocommon.c;

import android.content.Context;
import android.os.Build;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.net.f.c;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.out.MBConfiguration;

public final class b extends c {
    public b(Context context) {
        super(context);
    }

    public final void addExtraParams(String str, e eVar) {
        try {
            super.addExtraParams(str, eVar);
            eVar.a("platform", "1");
            eVar.a("os_version", Build.VERSION.RELEASE);
            eVar.a(CampaignEx.JSON_KEY_PACKAGE_NAME, ab.f(this.mContext));
            eVar.a("app_version_name", ab.q(this.mContext));
            eVar.a("app_version_code", ab.r(this.mContext) + "");
            eVar.a("orientation", ab.s(this.mContext) + "");
            eVar.a("model", ab.h());
            eVar.a("brand", ab.x());
            int m5 = ab.m(this.mContext);
            eVar.a("network_type", m5 + "");
            eVar.a("network_str", ab.a(this.mContext, m5) + "");
            eVar.a("language", ab.t(this.mContext));
            eVar.a("timezone", ab.y());
            eVar.a("useragent", ab.g());
            eVar.a("sdk_version", MBConfiguration.SDK_VERSION);
            eVar.a("screen_size", ab.j(this.mContext) + "x" + ab.h(this.mContext));
            if (com.mbridge.msdk.e.b.a()) {
                eVar.a("gaid", "");
                eVar.a("gp_version", k.d(this.mContext));
                eVar.a("is_clever", a.f9160C);
            } else {
                eVar.a("gaid", f.c());
            }
            com.mbridge.msdk.foundation.same.net.f.f.d(eVar);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
