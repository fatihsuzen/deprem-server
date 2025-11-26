package com.google.android.gms.internal.measurement;

import java.util.List;

public final class F extends C1261y {
    protected F() {
        this.f5629a.add(O.AND);
        this.f5629a.add(O.NOT);
        this.f5629a.add(O.OR);
    }

    public final r a(String str, U1 u12, List list) {
        O o5 = O.ADD;
        int ordinal = C1238v2.e(str).ordinal();
        if (ordinal == 1) {
            C1238v2.a(O.AND.name(), 2, list);
            r a5 = u12.a((r) list.get(0));
            if (a5.d().booleanValue()) {
                return u12.a((r) list.get(1));
            }
            return a5;
        } else if (ordinal == 47) {
            C1238v2.a(O.NOT.name(), 1, list);
            return new C1101g(Boolean.valueOf(!u12.a((r) list.get(0)).d().booleanValue()));
        } else if (ordinal != 50) {
            return super.b(str);
        } else {
            C1238v2.a(O.OR.name(), 2, list);
            r a6 = u12.a((r) list.get(0));
            if (!a6.d().booleanValue()) {
                return u12.a((r) list.get(1));
            }
            return a6;
        }
    }
}
