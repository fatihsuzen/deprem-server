package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.newreward.function.command.b;
import com.mbridge.msdk.newreward.function.command.receiver.a;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import com.mbridge.msdk.video.bt.module.b.f;
import java.util.Map;

public final class j implements a {
    public final void a(final b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        MBridgeTaskManager.commonExecute(new Runnable() {
            public final void run() {
                try {
                    f.a(c.m().c(), (String) ((Map) bVar.b()).get("mb_ad_unit_id"));
                    ad.a();
                    ad.a(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES));
                    ad.a(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML));
                } catch (Exception unused) {
                }
            }
        });
    }
}
