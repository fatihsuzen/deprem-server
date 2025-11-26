package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.m  reason: case insensitive filesystem */
public abstract /* synthetic */ class C1155m {
    public static r a(C1164n nVar, r rVar, U1 u12, List list) {
        if (nVar.i(rVar.b())) {
            r f5 = nVar.f(rVar.b());
            if (f5 instanceof C1137k) {
                return ((C1137k) f5).a(u12, list);
            }
            throw new IllegalArgumentException(String.format("%s is not a function", new Object[]{rVar.b()}));
        } else if ("hasOwnProperty".equals(rVar.b())) {
            C1238v2.a("hasOwnProperty", 1, list);
            if (nVar.i(u12.a((r) list.get(0)).b())) {
                return r.f5558g0;
            }
            return r.f5559h0;
        } else {
            throw new IllegalArgumentException(String.format("Object has no function %s", new Object[]{rVar.b()}));
        }
    }

    public static Iterator b(Map map) {
        return new C1146l(map.keySet().iterator());
    }
}
