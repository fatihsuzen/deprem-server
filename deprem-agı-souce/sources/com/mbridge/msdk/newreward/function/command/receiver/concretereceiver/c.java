package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.a.d;
import com.mbridge.msdk.newreward.function.command.receiver.e;
import com.mbridge.msdk.newreward.function.e.b;
import java.util.Map;

public final class c implements e {

    /* renamed from: a  reason: collision with root package name */
    private b f10787a;

    public final Object a(Object obj) {
        if (this.f10787a != null || obj == null) {
            return null;
        }
        try {
            Map map = (Map) obj;
            com.mbridge.msdk.newreward.b.b bVar = (com.mbridge.msdk.newreward.b.b) map.get("controller_model");
            com.mbridge.msdk.newreward.function.command.c cVar = (com.mbridge.msdk.newreward.function.command.c) map.get("command_manager");
            d dVar = (d) map.get("adapter_manager");
            if (!(bVar == null || cVar == null)) {
                if (dVar != null) {
                    b bVar2 = new b(bVar.e(), bVar.d(), bVar.c(), bVar.f());
                    this.f10787a = bVar2;
                    bVar2.a(cVar, dVar);
                    return null;
                }
            }
            return null;
        } catch (Exception e5) {
            af.b("LoadCheckReceiver", "action", e5);
        }
    }
}
