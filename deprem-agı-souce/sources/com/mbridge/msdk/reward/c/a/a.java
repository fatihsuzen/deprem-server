package com.mbridge.msdk.reward.c.a;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.videocommon.d.b;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f11410a;

    private a() {
    }

    public static a a() {
        if (f11410a == null) {
            synchronized (a.class) {
                try {
                    if (f11410a == null) {
                        f11410a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f11410a;
    }

    public final void a(String str, c cVar) {
        List<CampaignEx> h5;
        c cVar2;
        if (cVar == null) {
            try {
                cVar2 = new c();
            } catch (Exception e5) {
                try {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                    }
                } catch (Exception e6) {
                    if (MBridgeConstans.DEBUG) {
                        e6.printStackTrace();
                        return;
                    }
                    return;
                }
            }
        } else {
            cVar2 = cVar;
        }
        com.mbridge.msdk.videocommon.d.a b5 = b.a().b();
        if (b5 != null) {
            cVar2.h(b5.b());
            cVar2.f(b5.c());
        }
        if (cVar != null) {
            try {
                int j5 = cVar.j();
                String i5 = cVar.i();
                boolean z4 = false;
                if (TextUtils.isEmpty(i5) && (h5 = cVar.h()) != null && h5.size() > 0 && h5.get(0) != null) {
                    i5 = h5.get(0).getCampaignUnitId();
                    j5 = h5.get(0).getAdType();
                    cVar.b(j5);
                    cVar.d(i5);
                }
                if (j5 == 287) {
                    z4 = true;
                }
                com.mbridge.msdk.videocommon.d.c a5 = b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), i5, z4);
                if (a5 != null) {
                    cVar.g(a5.l());
                    cVar.n(a5.k());
                }
            } catch (Exception e7) {
                if (MBridgeConstans.DEBUG) {
                    e7.printStackTrace();
                }
            }
        }
        d.a().a(cVar);
        d.a().a(str, cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
    }
}
