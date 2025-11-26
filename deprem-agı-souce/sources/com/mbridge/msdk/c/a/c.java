package com.mbridge.msdk.c.a;

import android.content.Context;
import android.os.Build;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.out.MBConfiguration;

public final class c extends com.mbridge.msdk.foundation.same.net.f.c {
    public c(Context context) {
        super(context);
    }

    public final void addExtraParams(String str, e eVar) {
        super.addExtraParams(str, eVar);
        eVar.a("platform", "1");
        eVar.a("os_version", Build.VERSION.RELEASE);
        eVar.a(CampaignEx.JSON_KEY_PACKAGE_NAME, ab.f(this.mContext));
        eVar.a("app_version_name", ab.q(this.mContext));
        eVar.a("app_version_code", ab.r(this.mContext) + "");
        eVar.a("orientation", ab.s(this.mContext) + "");
        eVar.a("model", ab.h());
        eVar.a("brand", ab.x());
        eVar.a("gaid2", f.b());
        int m5 = ab.m(this.mContext);
        eVar.a("network_type", m5 + "");
        eVar.a("network_str", ab.a(this.mContext, m5));
        eVar.a("language", ab.t(this.mContext));
        eVar.a("timezone", ab.y());
        eVar.a("useragent", ab.g());
        eVar.a("sdk_version", MBConfiguration.SDK_VERSION);
        eVar.a("screen_size", ab.j(this.mContext) + "x" + ab.h(this.mContext));
        d.a(this.mContext, eVar);
        com.mbridge.msdk.foundation.same.net.f.f.d(eVar);
    }
}
