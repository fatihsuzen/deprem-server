package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import com.mbridge.msdk.foundation.c.b;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.receiver.a;
import java.util.Map;

public final class i implements a {

    /* renamed from: a  reason: collision with root package name */
    private b f10821a;

    public final void a(com.mbridge.msdk.newreward.function.command.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        if (bVar == null || bVar.b() == null) {
            a(bVar2, new b(-1, "command or object is null"));
            return;
        }
        try {
            Map map = (Map) bVar.b();
            this.f10821a = (b) map.get("reason");
            e eVar = (e) map.get("adapter_model");
            map.put("candidate_type", 0);
            map.put("scene", 2);
            com.mbridge.msdk.newreward.function.a.b bVar3 = (com.mbridge.msdk.newreward.function.a.b) ((c) map.get("command_manager")).b((Object) map);
            if (!com.mbridge.msdk.newreward.function.h.c.c(eVar.J())) {
                a(bVar2, this.f10821a);
                return;
            }
            eVar.b(true);
            if (bVar3 == null) {
                a(bVar2, this.f10821a);
            } else if (bVar3.h() == com.mbridge.msdk.newreward.function.a.b.f10520d) {
                eVar.D().a(bVar3.a());
                if (bVar2 != null) {
                    try {
                        bVar2.reqSuccessful(bVar3.a());
                    } catch (Exception e5) {
                        af.b("SmartLoadReceiver", "handlerCandidateSuccess", e5);
                    }
                }
            } else {
                a(bVar2, new b(bVar3.g(), bVar3.b()));
            }
        } catch (Exception e6) {
            af.b("SmartLoadReceiver", "action", e6);
            if (bVar2 != null) {
                b bVar4 = this.f10821a;
                if (bVar4 == null) {
                    a(bVar2, new b(-1, "SmartLoadReceiver action exception"));
                } else {
                    a(bVar2, bVar4);
                }
            }
        }
    }

    private static void a(com.mbridge.msdk.newreward.a.b.b bVar, b bVar2) {
        if (bVar != null) {
            try {
                bVar.reqFailed(bVar2);
            } catch (Exception e5) {
                af.b("SmartLoadReceiver", "handlerCandidateFailed", e5);
            }
        }
    }
}
