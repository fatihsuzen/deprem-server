package com.google.android.gms.internal.measurement;

import java.util.List;

public final class A extends C1261y {
    public A() {
        this.f5629a.add(O.EQUALS);
        this.f5629a.add(O.GREATER_THAN);
        this.f5629a.add(O.GREATER_THAN_EQUALS);
        this.f5629a.add(O.IDENTITY_EQUALS);
        this.f5629a.add(O.IDENTITY_NOT_EQUALS);
        this.f5629a.add(O.LESS_THAN);
        this.f5629a.add(O.LESS_THAN_EQUALS);
        this.f5629a.add(O.NOT_EQUALS);
    }

    private static boolean c(r rVar, r rVar2) {
        int i5;
        if (rVar instanceof C1164n) {
            rVar = new C1235v(rVar.b());
        }
        if (rVar2 instanceof C1164n) {
            rVar2 = new C1235v(rVar2.b());
        }
        if (!(rVar instanceof C1235v) || !(rVar2 instanceof C1235v)) {
            double doubleValue = rVar.C().doubleValue();
            double doubleValue2 = rVar2.C().doubleValue();
            if (Double.isNaN(doubleValue) || Double.isNaN(doubleValue2) || ((doubleValue == 0.0d && doubleValue2 == 0.0d) || ((i5 == 0 && doubleValue2 == 0.0d) || Double.compare(doubleValue, doubleValue2) >= 0))) {
                return false;
            }
            return true;
        } else if (rVar.b().compareTo(rVar2.b()) < 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean d(r rVar, r rVar2) {
        if (rVar.getClass().equals(rVar2.getClass())) {
            if ((rVar instanceof C1244w) || (rVar instanceof C1182p)) {
                return true;
            }
            if (rVar instanceof C1128j) {
                if (Double.isNaN(rVar.C().doubleValue()) || Double.isNaN(rVar2.C().doubleValue()) || rVar.C().doubleValue() != rVar2.C().doubleValue()) {
                    return false;
                }
                return true;
            } else if (rVar instanceof C1235v) {
                return rVar.b().equals(rVar2.b());
            } else {
                if (rVar instanceof C1101g) {
                    return rVar.d().equals(rVar2.d());
                }
                if (rVar == rVar2) {
                    return true;
                }
                return false;
            }
        } else if (((rVar instanceof C1244w) || (rVar instanceof C1182p)) && ((rVar2 instanceof C1244w) || (rVar2 instanceof C1182p))) {
            return true;
        } else {
            boolean z4 = rVar instanceof C1128j;
            if (z4 && (rVar2 instanceof C1235v)) {
                return d(rVar, new C1128j(rVar2.C()));
            }
            boolean z5 = rVar instanceof C1235v;
            if (z5 && (rVar2 instanceof C1128j)) {
                return d(new C1128j(rVar.C()), rVar2);
            }
            if (rVar instanceof C1101g) {
                return d(new C1128j(rVar.C()), rVar2);
            }
            if (rVar2 instanceof C1101g) {
                return d(rVar, new C1128j(rVar2.C()));
            }
            if ((z5 || z4) && (rVar2 instanceof C1164n)) {
                return d(rVar, new C1235v(rVar2.b()));
            }
            if (!(rVar instanceof C1164n) || (!(rVar2 instanceof C1235v) && !(rVar2 instanceof C1128j))) {
                return false;
            }
            return d(new C1235v(rVar.b()), rVar2);
        }
    }

    private static boolean e(r rVar, r rVar2) {
        if (rVar instanceof C1164n) {
            rVar = new C1235v(rVar.b());
        }
        if (rVar2 instanceof C1164n) {
            rVar2 = new C1235v(rVar2.b());
        }
        if (((!(rVar instanceof C1235v) || !(rVar2 instanceof C1235v)) && (Double.isNaN(rVar.C().doubleValue()) || Double.isNaN(rVar2.C().doubleValue()))) || c(rVar2, rVar)) {
            return false;
        }
        return true;
    }

    public final r a(String str, U1 u12, List list) {
        boolean z4;
        boolean d5;
        C1238v2.a(C1238v2.e(str).name(), 2, list);
        r a5 = u12.a((r) list.get(0));
        r a6 = u12.a((r) list.get(1));
        int ordinal = C1238v2.e(str).ordinal();
        if (ordinal != 23) {
            if (ordinal == 48) {
                d5 = d(a5, a6);
            } else if (ordinal == 42) {
                z4 = c(a5, a6);
            } else if (ordinal != 43) {
                switch (ordinal) {
                    case 37:
                        z4 = c(a6, a5);
                        break;
                    case 38:
                        z4 = e(a6, a5);
                        break;
                    case 39:
                        z4 = C1238v2.f(a5, a6);
                        break;
                    case 40:
                        d5 = C1238v2.f(a5, a6);
                        break;
                    default:
                        return super.b(str);
                }
            } else {
                z4 = e(a5, a6);
            }
            z4 = !d5;
        } else {
            z4 = d(a5, a6);
        }
        if (z4) {
            return r.f5558g0;
        }
        return r.f5559h0;
    }
}
