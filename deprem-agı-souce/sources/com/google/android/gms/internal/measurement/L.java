package com.google.android.gms.internal.measurement;

import java.util.List;

public final class L extends C1261y {
    protected L() {
        this.f5629a.add(O.ADD);
        this.f5629a.add(O.DIVIDE);
        this.f5629a.add(O.MODULUS);
        this.f5629a.add(O.MULTIPLY);
        this.f5629a.add(O.NEGATE);
        this.f5629a.add(O.POST_DECREMENT);
        this.f5629a.add(O.POST_INCREMENT);
        this.f5629a.add(O.PRE_DECREMENT);
        this.f5629a.add(O.PRE_INCREMENT);
        this.f5629a.add(O.SUBTRACT);
    }

    public final r a(String str, U1 u12, List list) {
        O o5 = O.ADD;
        int ordinal = C1238v2.e(str).ordinal();
        if (ordinal == 0) {
            C1238v2.a(O.ADD.name(), 2, list);
            r a5 = u12.a((r) list.get(0));
            r a6 = u12.a((r) list.get(1));
            if (!(a5 instanceof C1164n) && !(a5 instanceof C1235v) && !(a6 instanceof C1164n) && !(a6 instanceof C1235v)) {
                return new C1128j(Double.valueOf(a5.C().doubleValue() + a6.C().doubleValue()));
            }
            return new C1235v(String.valueOf(a5.b()).concat(String.valueOf(a6.b())));
        } else if (ordinal == 21) {
            C1238v2.a(O.DIVIDE.name(), 2, list);
            return new C1128j(Double.valueOf(u12.a((r) list.get(0)).C().doubleValue() / u12.a((r) list.get(1)).C().doubleValue()));
        } else if (ordinal == 59) {
            C1238v2.a(O.SUBTRACT.name(), 2, list);
            return new C1128j(Double.valueOf(u12.a((r) list.get(0)).C().doubleValue() + new C1128j(Double.valueOf(-u12.a((r) list.get(1)).C().doubleValue())).C().doubleValue()));
        } else if (ordinal == 52 || ordinal == 53) {
            C1238v2.a(str, 2, list);
            r a7 = u12.a((r) list.get(0));
            u12.a((r) list.get(1));
            return a7;
        } else if (ordinal == 55 || ordinal == 56) {
            C1238v2.a(str, 1, list);
            return u12.a((r) list.get(0));
        } else {
            switch (ordinal) {
                case 44:
                    C1238v2.a(O.MODULUS.name(), 2, list);
                    return new C1128j(Double.valueOf(u12.a((r) list.get(0)).C().doubleValue() % u12.a((r) list.get(1)).C().doubleValue()));
                case 45:
                    C1238v2.a(O.MULTIPLY.name(), 2, list);
                    return new C1128j(Double.valueOf(u12.a((r) list.get(0)).C().doubleValue() * u12.a((r) list.get(1)).C().doubleValue()));
                case 46:
                    C1238v2.a(O.NEGATE.name(), 1, list);
                    return new C1128j(Double.valueOf(-u12.a((r) list.get(0)).C().doubleValue()));
                default:
                    return super.b(str);
            }
        }
    }
}
