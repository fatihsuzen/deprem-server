package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;
import java.util.ArrayList;

public final class j extends c {

    /* renamed from: c  reason: collision with root package name */
    private final v f10630c = new v(b(), c(), this);

    public j(b bVar, a aVar) {
        super(bVar, aVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a_() {
        if (c() == null) {
            return false;
        }
        CampaignEx h5 = c().h();
        if (h5 == null || TextUtils.isEmpty(h5.getendcard_url())) {
            return true;
        }
        ArrayList<Integer> rsIgnoreCheckRule = h5.getRsIgnoreCheckRule();
        if (!(rsIgnoreCheckRule == null || rsIgnoreCheckRule.size() == 0)) {
            try {
                return rsIgnoreCheckRule.contains(2);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public final int b_() {
        return 4;
    }

    public final String j() {
        CampaignEx h5;
        if (c() == null || (h5 = c().h()) == null || TextUtils.isEmpty(h5.getendcard_url())) {
            return "";
        }
        return h5.getendcard_url();
    }

    public final q l() {
        return this.f10630c;
    }
}
