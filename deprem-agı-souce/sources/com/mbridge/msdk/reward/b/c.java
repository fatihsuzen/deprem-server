package com.mbridge.msdk.reward.b;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.videocommon.a.a;
import com.mbridge.msdk.videocommon.d.b;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Context f11408a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11409b;

    public c(Context context, String str) {
        this.f11408a = context;
        this.f11409b = str;
    }

    public final void run() {
        CopyOnWriteArrayList<CampaignEx> a5;
        if (this.f11408a != null && !TextUtils.isEmpty(this.f11409b)) {
            try {
                Context context = this.f11408a;
                String str = this.f11409b;
                if (context != null) {
                    try {
                        o a6 = o.a((f) g.a(context));
                        if (!TextUtils.isEmpty(str) && a6 != null && a6.a() > 0) {
                            List<n> a7 = a6.a("m_download_end");
                            List<n> a8 = a6.a("2000021");
                            List<n> a9 = a6.a("2000039");
                            List<n> a10 = a6.a("m_download_end");
                            List<n> a11 = a6.a("m_download_end");
                            List<n> a12 = a6.a("2000044");
                            com.mbridge.msdk.foundation.same.report.n.e(a8);
                            com.mbridge.msdk.foundation.same.report.n.a(a7);
                            com.mbridge.msdk.foundation.same.report.n.c(a9);
                            com.mbridge.msdk.foundation.same.report.n.b(a10);
                            com.mbridge.msdk.foundation.same.report.n.f(a11);
                            com.mbridge.msdk.foundation.same.report.n.d(a12);
                        }
                    } catch (Exception e5) {
                        af.b("RewardReport", e5.getMessage());
                    }
                }
                ad.a();
                ad.a(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES));
                ad.a(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML));
                b.a().c(this.f11409b);
                if (!ah.a().a("c_d_v_w_i", false) && !TextUtils.isEmpty(this.f11409b) && (a5 = a.a().a(this.f11409b, 1)) != null && a5.size() > 0) {
                    com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(this.f11408a, this.f11409b, a5, 94, (com.mbridge.msdk.videocommon.listener.a) null);
                }
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoControllerInitTask", "initRewardVideoController task ", e6);
                }
            }
        }
    }
}
