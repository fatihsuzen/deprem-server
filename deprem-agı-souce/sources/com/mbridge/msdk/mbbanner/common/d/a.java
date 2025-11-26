package com.mbridge.msdk.mbbanner.common.d;

import android.text.TextUtils;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class a {
    public static String a(String str) {
        String md5 = SameMD5.getMD5(ak.d());
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("_");
                if (split.length < 3) {
                    return "";
                }
                String str2 = split[2];
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            }
            return md5;
        } catch (Exception e5) {
            af.b("BannerReport", e5.getMessage());
            return "";
        }
    }

    public static c a(String str, String str2) {
        c cVar = new c();
        try {
            LinkedHashMap<String, c> b5 = d.a().b();
            if (b5 != null && !b5.isEmpty()) {
                Iterator<Map.Entry<String, c>> it = b5.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry next = it.next();
                    if (next != null && ((c) next.getValue()).s()) {
                        it.remove();
                    }
                }
            }
            cVar = d.a().a(str2, "");
            if (cVar == null) {
                c cVar2 = new c();
                try {
                    d.a().b().put(str2, cVar2);
                    cVar2.d(true);
                    cVar = cVar2;
                } catch (Exception e5) {
                    e = e5;
                    cVar = cVar2;
                    af.b("BannerReport", e.getMessage());
                    return cVar;
                }
            }
            cVar.b(296);
            cVar.c(str2);
            cVar.d(str);
            return cVar;
        } catch (Exception e6) {
            e = e6;
            af.b("BannerReport", e.getMessage());
            return cVar;
        }
    }

    public static void a(String str, c cVar, e eVar) {
        List<CampaignEx> h5;
        try {
            String i5 = cVar.i();
            if (TextUtils.isEmpty(i5) && (h5 = cVar.h()) != null && !h5.isEmpty() && h5.get(0) != null) {
                i5 = h5.get(0).getCampaignUnitId();
                cVar.b(h5.get(0).getAdType());
                cVar.d(i5);
            }
            k c5 = h.a().c(com.mbridge.msdk.foundation.controller.c.m().k(), i5);
            if (c5 != null) {
                e eVar2 = eVar == null ? new e() : eVar;
                eVar2.a("us_rid", c5.s());
                HashMap<String, String> hashMap = com.mbridge.msdk.foundation.controller.a.f8822b;
                if (hashMap != null) {
                    String str2 = hashMap.get(i5);
                    if (!TextUtils.isEmpty(str2)) {
                        eVar2.a("u_stid", str2);
                    }
                } else {
                    eVar2.a("u_stid", c5.a());
                }
            }
        } catch (Exception e5) {
            try {
                af.b("BannerReport", e5.getMessage());
            } catch (Exception e6) {
                af.b("BannerReport", e6.getMessage());
                return;
            }
        }
        if (eVar != null) {
            cVar.a(str, eVar);
        }
        d.a().a(str, cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
    }
}
