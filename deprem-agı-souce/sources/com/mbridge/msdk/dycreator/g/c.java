package com.mbridge.msdk.dycreator.g;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class c extends a {
    public final void a(Object obj) {
        b bVar;
        ConcurrentHashMap<Integer, Object> concurrentHashMap = this.f8698a;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            for (Map.Entry next : this.f8698a.entrySet()) {
                if (next != null) {
                    try {
                        if (!(next.getValue() == null || (bVar = (b) next.getValue()) == null)) {
                            bVar.a(obj);
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            }
        }
    }
}
