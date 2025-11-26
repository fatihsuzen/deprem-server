package com.mbridge.msdk.reward.d;

import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.tracker.network.h;
import java.util.List;

public abstract class a extends c {
    public abstract void a(int i5, String str, c cVar);

    public abstract void a(CampaignUnit campaignUnit);

    public final void a(List<Frame> list) {
    }

    public final void b(int i5, String str, c cVar) {
        a(i5, str, cVar);
    }

    public final void a(List<h> list, CampaignUnit campaignUnit) {
        a(campaignUnit);
    }
}
