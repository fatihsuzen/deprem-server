package com.mbridge.msdk.dycreator.f;

import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;

public final class a implements com.mbridge.msdk.dycreator.f.a.a {

    /* renamed from: a  reason: collision with root package name */
    private DyOption f8696a;

    /* renamed from: b  reason: collision with root package name */
    private CampaignEx f8697b;

    public a(DyOption dyOption) {
        this.f8696a = dyOption;
        this.f8697b = dyOption.getCampaignEx();
    }

    public final CampaignEx getBindData() {
        return this.f8697b;
    }

    public final DyOption getEffectData() {
        return this.f8696a;
    }
}
