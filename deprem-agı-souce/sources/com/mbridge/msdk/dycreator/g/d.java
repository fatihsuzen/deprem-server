package com.mbridge.msdk.dycreator.g;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class d extends a {
    public final void a(Object obj) {
        i iVar;
        try {
            synchronized (this) {
                ConcurrentHashMap<Integer, Object> concurrentHashMap = this.f8698a;
                if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                    for (Map.Entry next : this.f8698a.entrySet()) {
                        if (!(next == null || !(next.getValue() instanceof i) || (iVar = (i) next.getValue()) == null)) {
                            iVar.a(obj);
                        }
                    }
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        } catch (Throwable th) {
            throw th;
        }
    }
}
