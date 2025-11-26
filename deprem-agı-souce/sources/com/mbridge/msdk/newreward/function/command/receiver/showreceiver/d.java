package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.function.command.b;
import com.mbridge.msdk.newreward.function.command.receiver.a;
import com.mbridge.msdk.newreward.player.view.moreoffer.TemplateMoreOffer;
import java.util.Map;

public final class d implements a {
    public final void a(b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        if (bVar != null) {
            try {
                if (bVar.b() instanceof Map) {
                    Map map = (Map) bVar.b();
                    int intValue = ((Integer) map.get("add_temple")).intValue();
                    ViewGroup viewGroup = (ViewGroup) map.get("parent_temple");
                    int intValue2 = ((Integer) map.get("more_offer_type")).intValue();
                    if (intValue == 295) {
                        new TemplateMoreOffer(viewGroup.getContext(), bVar2, intValue2).show(viewGroup);
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }
}
