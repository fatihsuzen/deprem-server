package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.command.b;
import com.mbridge.msdk.newreward.function.command.receiver.a;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeSharedPreferenceModel;
import com.mbridge.msdk.newreward.function.d.c;
import java.util.List;
import java.util.Map;

public final class g implements a {
    public final void a(b bVar, final com.mbridge.msdk.newreward.a.b.b bVar2) {
        try {
            Map map = (Map) bVar.b();
            String str = (String) map.get("mb_ad_unit_id");
            boolean booleanValue = ((Boolean) map.get("mb_ad_is_header_bidding")).booleanValue();
            int integer = MBridgeSharedPreferenceModel.getInstance().getInteger(String.format(MBridgeCommon.SharedPreference.KEY_VCN, new Object[]{str}), 1);
            c.a().b().a(((Integer) map.get("mb_ad_type")).intValue(), (String) map.get("mb_ad_pid"), str, booleanValue, integer, (com.mbridge.msdk.newreward.function.d.b) new com.mbridge.msdk.newreward.function.d.b() {
                public final void a(List<com.mbridge.msdk.newreward.function.c.a.b> list) {
                    try {
                        com.mbridge.msdk.newreward.a.b.b bVar = bVar2;
                        if (bVar != null) {
                            bVar.reqSuccessful(list);
                        }
                    } catch (Exception e5) {
                        af.b("RestoreFromDBReceiver", "action", e5);
                    }
                }

                public final void a() {
                    try {
                        com.mbridge.msdk.newreward.a.b.b bVar = bVar2;
                        if (bVar != null) {
                            bVar.reqFailed(new com.mbridge.msdk.foundation.c.b(880040, "no cached campaign in db"));
                        }
                    } catch (Exception e5) {
                        af.b("RestoreFromDBReceiver", "action", e5);
                    }
                }
            });
        } catch (Exception e5) {
            af.b("RestoreFromDBReceiver", "action", e5);
        }
    }
}
