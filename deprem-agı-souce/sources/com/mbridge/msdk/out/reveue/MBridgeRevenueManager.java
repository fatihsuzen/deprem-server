package com.mbridge.msdk.out.reveue;

import android.content.Context;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;

public class MBridgeRevenueManager {
    public static void track(Context context, MBridgeRevenueParamsEntity mBridgeRevenueParamsEntity) {
        if (c.m().c() == null) {
            c.m().b(context);
        }
        try {
            e eVar = new e();
            eVar.a(RewardPlus.NAME, mBridgeRevenueParamsEntity.getMediationName());
            com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            cVar.a("m_start_ad_rev", eVar);
            d.a().a("m_start_ad_rev", cVar);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        com.mbridge.msdk.foundation.same.report.e.a().a(mBridgeRevenueParamsEntity.getReportData());
    }
}
