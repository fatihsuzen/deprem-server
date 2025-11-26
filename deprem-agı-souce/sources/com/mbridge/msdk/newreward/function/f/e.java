package com.mbridge.msdk.newreward.function.f;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.e.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.net.f.f;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.out.CustomInfoManager;
import java.util.HashMap;
import java.util.Map;

public final class e extends a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f10987a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Context f10988b = c.m().c();

    /* renamed from: c  reason: collision with root package name */
    private final int f10989c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10990d;

    /* renamed from: e  reason: collision with root package name */
    private final String f10991e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f10992f;

    /* renamed from: g  reason: collision with root package name */
    private final String f10993g;

    /* renamed from: h  reason: collision with root package name */
    private int f10994h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10995i = false;

    public e(int i5, String str, String str2, boolean z4, String str3) {
        this.f10989c = i5;
        this.f10990d = str;
        this.f10991e = str2;
        this.f10992f = z4;
        this.f10993g = str3;
    }

    public final void a(boolean z4) {
        this.f10995i = z4;
    }

    public final int b() {
        return this.f10989c;
    }

    public final String c() {
        return this.f10990d;
    }

    public final String d() {
        return this.f10991e;
    }

    public final String e() {
        return this.f10993g;
    }

    public final Map<String, String> f() {
        int i5;
        int i6;
        int i7;
        Map<String, String> a5 = a();
        if (a5 != null) {
            this.f10987a.putAll(a5);
        }
        com.mbridge.msdk.foundation.same.net.f.e eVar = new com.mbridge.msdk.foundation.same.net.f.e(this.f10987a);
        if (b.a()) {
            eVar.a("gp_version", k.d(this.f10988b));
        }
        String str = "1";
        eVar.a("version_flag", str);
        int i8 = 1;
        if (b.a()) {
            com.mbridge.msdk.foundation.controller.authoritycontroller.c.c(true);
        }
        eVar.a("misk_spt", String.valueOf(ak.a()));
        String c5 = ak.c();
        if (!TextUtils.isEmpty(c5)) {
            eVar.a("misk_spt_det", c5);
        }
        String str2 = this.f10991e;
        if (str2 != null) {
            CustomInfoManager instance = CustomInfoManager.getInstance();
            if (this.f10992f) {
                i7 = 7;
            } else {
                i7 = 8;
            }
            String customInfoByUnitId = instance.getCustomInfoByUnitId(str2, i7);
            if (!TextUtils.isEmpty(customInfoByUnitId)) {
                eVar.a("ch_info", customInfoByUnitId);
            }
            com.mbridge.msdk.c.k d5 = h.a().d(c.m().k(), str2);
            if (d5 != null && !TextUtils.isEmpty(d5.a())) {
                eVar.a("u_stid", d5.a());
            }
        }
        String a6 = com.mbridge.msdk.foundation.same.a.b.a(this.f10991e, "reward");
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.PROPERTIES_UNIT_ID, this.f10991e);
        if (!TextUtils.isEmpty(this.f10990d)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.PLACEMENT_ID, this.f10990d);
        }
        com.mbridge.msdk.videocommon.d.c a7 = com.mbridge.msdk.videocommon.d.b.a().a(c.m().k(), this.f10991e);
        if (a7 != null) {
            i6 = a7.t();
            i5 = a7.u();
        } else {
            i6 = 0;
            i5 = 0;
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ad_num", String.valueOf(i6));
        if (this.f10989c != 287) {
            i8 = i5;
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "tnum", String.valueOf(i8));
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "only_impression", str);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ping_mode", str);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, com.mbridge.msdk.foundation.same.net.f.e.f9397d, a6);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, CampaignEx.JSON_KEY_AD_SOURCE_ID, str);
        String str3 = com.mbridge.msdk.foundation.same.net.f.e.f9399f;
        String str4 = MBridgeGlobalCommon.SESSION_ID;
        if (str4 == null) {
            str4 = "";
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, str3, str4);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ad_type", String.valueOf(this.f10989c));
        if (!TextUtils.isEmpty(this.f10993g)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "token", this.f10993g);
        }
        if (this.f10989c == 287) {
            int i9 = this.f10994h;
            if (i9 == a.f9166I || i9 == a.f9165H) {
                com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ivrwd", str);
            } else {
                com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ivrwd", "0");
            }
        }
        if (a7 != null && !TextUtils.isEmpty(a7.k())) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "u_stid", a7.k());
        }
        com.mbridge.msdk.videocommon.d.a b5 = com.mbridge.msdk.videocommon.d.b.a().b();
        if (b5 != null && !TextUtils.isEmpty(b5.b())) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "r_stid", b5.b());
        }
        if (!this.f10995i) {
            str = "0";
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "rw_plus", str);
        String d6 = ak.d(this.f10991e);
        if (!TextUtils.isEmpty(d6)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "j", d6);
        }
        f.a(eVar, this.f10988b);
        f.a(eVar);
        f.c(eVar);
        f.e(eVar);
        f.f(eVar);
        return eVar.a();
    }

    public final void a(int i5) {
        this.f10994h = i5;
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str) && b.a()) {
            this.f10987a.put("install_ids", str);
        }
    }

    public final void c(String str) {
        if (!TextUtils.isEmpty(str) && b.a() && b.a()) {
            this.f10987a.put("ttc_ids", str);
        }
    }

    public final void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f10987a.put(com.mbridge.msdk.foundation.same.net.f.e.f9399f, str);
        }
    }

    public final void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f10987a.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, str);
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f10987a.put(com.mbridge.msdk.foundation.same.net.f.e.f9398e, str);
        }
    }

    public final void b(int i5) {
        this.f10987a.put(TypedValues.CycleType.S_WAVE_OFFSET, String.valueOf(i5));
    }

    public final void a(Map<String, String> map) {
        if (this.f10987a != null && map != null && !map.isEmpty()) {
            this.f10987a.putAll(map);
        }
    }

    public final void c(int i5) {
        this.f10987a.put("req_type", String.valueOf(i5));
    }
}
