package com.mbridge.msdk.dycreator.g;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class h extends a {
    public final void a(Object obj) {
        g gVar;
        ConcurrentHashMap<Integer, Object> concurrentHashMap = this.f8698a;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            for (Map.Entry next : this.f8698a.entrySet()) {
                if (next != null) {
                    try {
                        if (!(next.getValue() == null || (gVar = (g) next.getValue()) == null)) {
                            gVar.a(obj);
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            }
        }
    }
}
