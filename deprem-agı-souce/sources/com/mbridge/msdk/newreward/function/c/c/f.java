package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;

public final class f extends b {

    /* renamed from: b  reason: collision with root package name */
    private final t f10628b = new t(b(), c(), this);

    public f(b bVar, a aVar) {
        super(bVar, aVar);
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
        return this.f10628b;
    }
}
