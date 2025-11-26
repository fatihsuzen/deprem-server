package com.mbridge.msdk.newreward.a.b;

import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.c.c.m;
import com.mbridge.msdk.newreward.function.c.c.q;
import com.mbridge.msdk.newreward.function.c.c.x;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.io.IOException;

public final class k implements a {
    public final void a(Object obj, final b bVar) throws IOException {
        a aVar = (a) obj;
        m a5 = aVar.a();
        if (aVar.h() == null || !aVar.h().isDynamicView()) {
            if (a5 != null) {
                a5.l().a(0, new x() {
                    public final void a(b bVar, a aVar, q qVar) {
                    }

                    public final void b(b bVar, a aVar, q qVar) {
                        if (bVar.y()) {
                            bVar.reqSuccessful(aVar);
                        }
                    }

                    public final void a(b bVar, a aVar, q qVar, MBridgeError mBridgeError) {
                        if (bVar.y()) {
                            bVar.reqSuccessful(aVar);
                        }
                    }

                    public final void b(b bVar, a aVar, q qVar, MBridgeError mBridgeError) {
                        if (bVar.y()) {
                            bVar.reqSuccessful(aVar);
                        }
                    }
                });
            } else if (bVar != null) {
                bVar.reqSuccessful(aVar);
            }
        } else if (bVar != null) {
            bVar.reqSuccessful(aVar);
        }
    }
}
