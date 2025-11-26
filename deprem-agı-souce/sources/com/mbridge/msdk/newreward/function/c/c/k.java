package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;
import java.util.ArrayList;

public final class k extends c {

    /* renamed from: c  reason: collision with root package name */
    private final v f10631c = new v(b(), c(), this);

    public k(b bVar, a aVar) {
        super(bVar, aVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a_() {
        if (c() == null) {
            return false;
        }
        CampaignEx h5 = c().h();
        if (h5 == null || h5.getRewardTemplateMode() == null || TextUtils.isEmpty(h5.getRewardTemplateMode().e())) {
            return true;
        }
        ArrayList<Integer> rsIgnoreCheckRule = h5.getRsIgnoreCheckRule();
        if (rsIgnoreCheckRule != null && !rsIgnoreCheckRule.isEmpty()) {
            try {
                return rsIgnoreCheckRule.contains(1);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public final int b_() {
        return 2;
    }

    public final String j() {
        CampaignEx h5;
        if (c() == null || (h5 = c().h()) == null || h5.getRewardTemplateMode() == null || TextUtils.isEmpty(h5.getRewardTemplateMode().e())) {
            return "";
        }
        return h5.getRewardTemplateMode().e();
    }

    public final q l() {
        return this.f10631c;
    }
}
