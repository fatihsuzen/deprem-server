package com.mbridge.msdk.newreward.a.a;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import java.util.Map;

public final class b extends a {
    public b(c cVar) {
        super(cVar);
    }

    public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
        if (!(bVar == null || this.f10335c == null)) {
            try {
                if (bVar.i() == -1) {
                    this.f10335c.a(System.currentTimeMillis());
                }
                e eVar = this.f10335c;
                eVar.b(bVar.i() + "");
                com.mbridge.msdk.foundation.same.net.e.c a5 = com.mbridge.msdk.foundation.same.net.e.c.a();
                a5.a(this.f10335c.B() + "_" + this.f10335c.C() + "_" + this.f10335c.H() + "_" + this.f10335c.h(), bVar.i(), bVar.k(), System.currentTimeMillis());
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
        if (this.f10335c.d() || this.f10335c.e() || this.f10335c.f()) {
            a(this.f10334b, bVar);
        } else {
            a(bVar);
        }
    }

    public final void reqSuccessful(Object obj) {
        Map map = (Map) obj;
        a(((Integer) map.get(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)).intValue(), map.get("object"));
    }
}
