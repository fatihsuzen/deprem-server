package com.mbridge.msdk.reward.adapter;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.a.b;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.videocommon.d.c;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f11288a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11289b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f11290c;

    /* renamed from: d  reason: collision with root package name */
    private final c f11291d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11292e;

    public d(String str, String str2, boolean z4, c cVar, String str3) {
        this.f11288a = str;
        this.f11289b = str2;
        this.f11290c = z4;
        this.f11291d = cVar;
        this.f11292e = str3;
    }

    public final e a(boolean z4, String str, int i5, String str2, String str3, String str4, String str5, boolean z5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        String str6;
        String str7;
        int i11 = i6;
        String k5 = com.mbridge.msdk.foundation.controller.c.m().k();
        String md5 = SameMD5.getMD5(com.mbridge.msdk.foundation.controller.c.m().k() + com.mbridge.msdk.foundation.controller.c.m().b());
        if (z4) {
            i7 = 2;
        } else {
            i7 = 3;
        }
        c cVar = this.f11291d;
        if (cVar != null) {
            i9 = cVar.t();
            i8 = this.f11291d.u();
        } else {
            i9 = 0;
            i8 = 0;
        }
        String a5 = b.a(this.f11289b, "reward");
        if (this.f11290c) {
            i10 = 287;
        } else {
            i10 = 94;
        }
        e eVar = new e();
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.APP_ID, k5);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.PROPERTIES_UNIT_ID, this.f11289b);
        if (!TextUtils.isEmpty(this.f11288a)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.PLACEMENT_ID, this.f11288a);
        }
        String str8 = "";
        if (com.mbridge.msdk.e.b.a()) {
            if (str4 == null) {
                str6 = str8;
            } else {
                str6 = str4;
            }
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ttc_ids", str6);
            if (str3 == null) {
                str7 = str8;
            } else {
                str7 = str3;
            }
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "install_ids", str7);
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "sign", md5);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "req_type", String.valueOf(i7));
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ad_num", String.valueOf(i9));
        if (this.f11290c) {
            i8 = 1;
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "tnum", String.valueOf(i8));
        String str9 = "1";
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "only_impression", str9);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ping_mode", str9);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, e.f9397d, a5);
        String str10 = e.f9398e;
        if (str == null) {
            str = str8;
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, str10, str);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, CampaignEx.JSON_KEY_AD_SOURCE_ID, String.valueOf(1));
        String str11 = e.f9399f;
        if (str2 == null) {
            str2 = str8;
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, str11, str2);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ad_type", String.valueOf(i10));
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, TypedValues.CycleType.S_WAVE_OFFSET, String.valueOf(i5));
        if (!TextUtils.isEmpty(str5)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "token", str5);
        }
        if (this.f11290c) {
            if (i11 == a.f9166I || i11 == a.f9165H) {
                com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ivrwd", str9);
            } else {
                com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ivrwd", "0");
            }
        }
        c cVar2 = this.f11291d;
        if (cVar2 != null && !TextUtils.isEmpty(cVar2.k())) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "u_stid", this.f11291d.k());
        }
        com.mbridge.msdk.videocommon.d.a b5 = com.mbridge.msdk.videocommon.d.b.a().b();
        if (b5 != null && !TextUtils.isEmpty(b5.b())) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "r_stid", b5.b());
        }
        if (!z5) {
            str9 = "0";
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "rw_plus", str9);
        String d5 = ak.d(this.f11289b);
        if (!TextUtils.isEmpty(d5)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "j", d5);
        }
        String str12 = this.f11292e;
        if (str12 != null) {
            str8 = str12;
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, str8);
        return eVar;
    }
}
