package com.google.android.gms.internal.measurement;

import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.x  reason: case insensitive filesystem */
public final class C1253x extends C1261y {
    public C1253x() {
        this.f5629a.add(O.BITWISE_AND);
        this.f5629a.add(O.BITWISE_LEFT_SHIFT);
        this.f5629a.add(O.BITWISE_NOT);
        this.f5629a.add(O.BITWISE_OR);
        this.f5629a.add(O.BITWISE_RIGHT_SHIFT);
        this.f5629a.add(O.BITWISE_UNSIGNED_RIGHT_SHIFT);
        this.f5629a.add(O.BITWISE_XOR);
    }

    public final r a(String str, U1 u12, List list) {
        O o5 = O.ADD;
        switch (C1238v2.e(str).ordinal()) {
            case 4:
                C1238v2.a(O.BITWISE_AND.name(), 2, list);
                return new C1128j(Double.valueOf((double) (C1238v2.g(u12.a((r) list.get(0)).C().doubleValue()) & C1238v2.g(u12.a((r) list.get(1)).C().doubleValue()))));
            case 5:
                C1238v2.a(O.BITWISE_LEFT_SHIFT.name(), 2, list);
                return new C1128j(Double.valueOf((double) (C1238v2.g(u12.a((r) list.get(0)).C().doubleValue()) << ((int) (C1238v2.h(u12.a((r) list.get(1)).C().doubleValue()) & 31)))));
            case 6:
                C1238v2.a(O.BITWISE_NOT.name(), 1, list);
                return new C1128j(Double.valueOf((double) (~C1238v2.g(u12.a((r) list.get(0)).C().doubleValue()))));
            case 7:
                C1238v2.a(O.BITWISE_OR.name(), 2, list);
                return new C1128j(Double.valueOf((double) (C1238v2.g(u12.a((r) list.get(0)).C().doubleValue()) | C1238v2.g(u12.a((r) list.get(1)).C().doubleValue()))));
            case 8:
                C1238v2.a(O.BITWISE_RIGHT_SHIFT.name(), 2, list);
                return new C1128j(Double.valueOf((double) (C1238v2.g(u12.a((r) list.get(0)).C().doubleValue()) >> ((int) (C1238v2.h(u12.a((r) list.get(1)).C().doubleValue()) & 31)))));
            case 9:
                C1238v2.a(O.BITWISE_UNSIGNED_RIGHT_SHIFT.name(), 2, list);
                return new C1128j(Double.valueOf((double) (C1238v2.h(u12.a((r) list.get(0)).C().doubleValue()) >>> ((int) (C1238v2.h(u12.a((r) list.get(1)).C().doubleValue()) & 31)))));
            case 10:
                C1238v2.a(O.BITWISE_XOR.name(), 2, list);
                return new C1128j(Double.valueOf((double) (C1238v2.g(u12.a((r) list.get(0)).C().doubleValue()) ^ C1238v2.g(u12.a((r) list.get(1)).C().doubleValue()))));
            default:
                return super.b(str);
        }
    }
}
