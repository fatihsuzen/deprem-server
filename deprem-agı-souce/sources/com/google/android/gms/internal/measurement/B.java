package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

public final class B extends C1261y {
    protected B() {
        this.f5629a.add(O.APPLY);
        this.f5629a.add(O.BLOCK);
        this.f5629a.add(O.BREAK);
        this.f5629a.add(O.CASE);
        this.f5629a.add(O.DEFAULT);
        this.f5629a.add(O.CONTINUE);
        this.f5629a.add(O.DEFINE_FUNCTION);
        this.f5629a.add(O.FN);
        this.f5629a.add(O.IF);
        this.f5629a.add(O.QUOTE);
        this.f5629a.add(O.RETURN);
        this.f5629a.add(O.SWITCH);
        this.f5629a.add(O.TERNARY);
    }

    private static r c(U1 u12, List list) {
        C1238v2.b(O.FN.name(), 2, list);
        r a5 = u12.a((r) list.get(0));
        r a6 = u12.a((r) list.get(1));
        if (a6 instanceof C1092f) {
            List l5 = ((C1092f) a6).l();
            List arrayList = new ArrayList();
            if (list.size() > 2) {
                arrayList = list.subList(2, list.size());
            }
            return new C1191q(a5.b(), l5, arrayList, u12);
        }
        throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", new Object[]{a6.getClass().getCanonicalName()}));
    }

    public final r a(String str, U1 u12, List list) {
        r rVar;
        r rVar2;
        O o5 = O.ADD;
        int ordinal = C1238v2.e(str).ordinal();
        if (ordinal == 2) {
            C1238v2.a(O.APPLY.name(), 3, list);
            r a5 = u12.a((r) list.get(0));
            String b5 = u12.a((r) list.get(1)).b();
            r a6 = u12.a((r) list.get(2));
            if (!(a6 instanceof C1092f)) {
                throw new IllegalArgumentException(String.format("Function arguments for Apply are not a list found %s", new Object[]{a6.getClass().getCanonicalName()}));
            } else if (!b5.isEmpty()) {
                return a5.k(b5, u12, ((C1092f) a6).l());
            } else {
                throw new IllegalArgumentException("Function name for apply is undefined");
            }
        } else if (ordinal == 15) {
            C1238v2.a(O.BREAK.name(), 0, list);
            return r.f5555d0;
        } else if (ordinal == 25) {
            return c(u12, list);
        } else {
            if (ordinal == 41) {
                C1238v2.b(O.IF.name(), 2, list);
                r a7 = u12.a((r) list.get(0));
                r a8 = u12.a((r) list.get(1));
                if (list.size() > 2) {
                    rVar = u12.a((r) list.get(2));
                } else {
                    rVar = null;
                }
                r rVar3 = r.f5553b0;
                if (a7.d().booleanValue()) {
                    rVar2 = u12.b((C1092f) a8);
                } else if (rVar != null) {
                    rVar2 = u12.b((C1092f) rVar);
                } else {
                    rVar2 = rVar3;
                }
                if (true != (rVar2 instanceof C1110h)) {
                    return rVar3;
                }
                return rVar2;
            } else if (ordinal == 54) {
                return new C1092f(list);
            } else {
                if (ordinal != 57) {
                    if (ordinal != 19) {
                        if (ordinal == 20) {
                            C1238v2.b(O.DEFINE_FUNCTION.name(), 2, list);
                            C1191q qVar = (C1191q) c(u12, list);
                            if (qVar.e() == null) {
                                u12.e("", qVar);
                                return qVar;
                            }
                            u12.e(qVar.e(), qVar);
                            return qVar;
                        } else if (ordinal == 60) {
                            C1238v2.a(O.SWITCH.name(), 3, list);
                            r a9 = u12.a((r) list.get(0));
                            r a10 = u12.a((r) list.get(1));
                            r a11 = u12.a((r) list.get(2));
                            if (!(a10 instanceof C1092f)) {
                                throw new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
                            } else if (a11 instanceof C1092f) {
                                C1092f fVar = (C1092f) a10;
                                C1092f fVar2 = (C1092f) a11;
                                boolean z4 = false;
                                for (int i5 = 0; i5 < fVar.o(); i5++) {
                                    if (z4 || a9.equals(u12.a(fVar.q(i5)))) {
                                        r a12 = u12.a(fVar2.q(i5));
                                        if (!(a12 instanceof C1110h)) {
                                            z4 = true;
                                        } else if (((C1110h) a12).e().equals("break")) {
                                            return r.f5553b0;
                                        } else {
                                            return a12;
                                        }
                                    } else {
                                        z4 = false;
                                    }
                                }
                                if (fVar.o() + 1 == fVar2.o()) {
                                    r a13 = u12.a(fVar2.q(fVar.o()));
                                    if (a13 instanceof C1110h) {
                                        String e5 = ((C1110h) a13).e();
                                        if (e5.equals("return") || e5.equals("continue")) {
                                            return a13;
                                        }
                                    }
                                }
                                return r.f5553b0;
                            } else {
                                throw new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                            }
                        } else if (ordinal != 61) {
                            switch (ordinal) {
                                case 11:
                                    return u12.c().b(new C1092f(list));
                                case 12:
                                    C1238v2.a(O.BREAK.name(), 0, list);
                                    return r.f5556e0;
                                case 13:
                                    break;
                                default:
                                    return super.b(str);
                            }
                        } else {
                            C1238v2.a(O.TERNARY.name(), 3, list);
                            if (u12.a((r) list.get(0)).d().booleanValue()) {
                                return u12.a((r) list.get(1));
                            }
                            return u12.a((r) list.get(2));
                        }
                    }
                    if (list.isEmpty()) {
                        return r.f5553b0;
                    }
                    r a14 = u12.a((r) list.get(0));
                    if (a14 instanceof C1092f) {
                        return u12.b((C1092f) a14);
                    }
                    return r.f5553b0;
                } else if (list.isEmpty()) {
                    return r.f5557f0;
                } else {
                    C1238v2.a(O.RETURN.name(), 1, list);
                    return new C1110h("return", u12.a((r) list.get(0)));
                }
            }
        }
    }
}
