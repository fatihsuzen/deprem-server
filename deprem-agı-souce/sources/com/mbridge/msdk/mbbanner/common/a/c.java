package com.mbridge.msdk.mbbanner.common.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a.b;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbbanner.common.util.BannerUtils;

public class c extends d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9925a = "c";

    public static e a(boolean z4, Context context, String str, String str2, int i5, a aVar) {
        String k5 = com.mbridge.msdk.foundation.controller.c.m().k();
        String md5 = SameMD5.getMD5(com.mbridge.msdk.foundation.controller.c.m().k() + com.mbridge.msdk.foundation.controller.c.m().b());
        String a5 = ak.a(context, str);
        String a6 = b.a(str, "banner");
        String closeIds = BannerUtils.getCloseIds(str);
        e eVar = new e();
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.APP_ID, k5);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.PROPERTIES_UNIT_ID, str);
        if (!TextUtils.isEmpty(aVar.d())) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.PLACEMENT_ID, aVar.d());
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "sign", md5);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "only_impression", "1");
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ping_mode", "1");
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, e.f9398e, a5);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, CampaignEx.JSON_KEY_AD_SOURCE_ID, "1");
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, e.f9399f, str2);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ad_type", "296");
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, TypedValues.CycleType.S_WAVE_OFFSET, i5 + "");
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, e.f9397d, a6);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "close_id", closeIds);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, com.mbridge.msdk.foundation.entity.b.JSON_KEY_UNIT_SIZE, aVar.a() + "");
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "refresh_time", aVar.b() + "");
        if (!TextUtils.isEmpty(aVar.c())) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "token", aVar.c() + "");
        }
        if (!TextUtils.isEmpty(aVar.e())) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, aVar.e());
        }
        return eVar;
    }
}
