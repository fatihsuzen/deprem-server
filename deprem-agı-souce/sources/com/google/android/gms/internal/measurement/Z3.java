package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Z3 extends C1137k {

    /* renamed from: c  reason: collision with root package name */
    private final C1065c f5293c;

    public Z3(C1065c cVar) {
        super("internal.eventLogger");
        this.f5293c = cVar;
    }

    public final r a(U1 u12, List list) {
        Map map;
        C1238v2.a(this.f5405a, 3, list);
        String b5 = u12.a((r) list.get(0)).b();
        long i5 = (long) C1238v2.i(u12.a((r) list.get(1)).C().doubleValue());
        r a5 = u12.a((r) list.get(2));
        if (a5 instanceof C1173o) {
            map = C1238v2.k((C1173o) a5);
        } else {
            map = new HashMap();
        }
        this.f5293c.e(b5, i5, map);
        return r.f5553b0;
    }
}
