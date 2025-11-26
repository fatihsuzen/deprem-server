package com.mbridge.msdk.newreward.function.command.a;

import com.mbridge.msdk.newreward.function.command.a;
import com.mbridge.msdk.newreward.function.command.e;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.ReportReceiver;

public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.receiver.b f10677a;

    public b(Object obj) {
        this.f10677a = new ReportReceiver(obj);
    }

    public final void a(com.mbridge.msdk.newreward.function.command.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
    }

    public final <T extends e> T a(com.mbridge.msdk.newreward.function.command.b bVar) {
        com.mbridge.msdk.newreward.function.command.receiver.b bVar2;
        if (!(bVar == null || (bVar2 = this.f10677a) == null)) {
            bVar2.a(bVar);
        }
        return null;
    }
}
