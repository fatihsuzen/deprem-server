package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import java.util.List;

public final class N extends C1261y {
    protected N() {
        this.f5629a.add(O.ASSIGN);
        this.f5629a.add(O.CONST);
        this.f5629a.add(O.CREATE_ARRAY);
        this.f5629a.add(O.CREATE_OBJECT);
        this.f5629a.add(O.EXPRESSION_LIST);
        this.f5629a.add(O.f5052I);
        this.f5629a.add(O.GET_INDEX);
        this.f5629a.add(O.GET_PROPERTY);
        this.f5629a.add(O.NULL);
        this.f5629a.add(O.SET_PROPERTY);
        this.f5629a.add(O.TYPEOF);
        this.f5629a.add(O.UNDEFINED);
        this.f5629a.add(O.VAR);
    }

    public final r a(String str, U1 u12, List list) {
        String str2;
        O o5 = O.ADD;
        int ordinal = C1238v2.e(str).ordinal();
        int i5 = 0;
        if (ordinal == 3) {
            C1238v2.a(O.ASSIGN.name(), 2, list);
            r a5 = u12.a((r) list.get(0));
            if (!(a5 instanceof C1235v)) {
                throw new IllegalArgumentException(String.format("Expected string for assign var. got %s", new Object[]{a5.getClass().getCanonicalName()}));
            } else if (u12.d(a5.b())) {
                r a6 = u12.a((r) list.get(1));
                u12.e(a5.b(), a6);
                return a6;
            } else {
                throw new IllegalArgumentException(String.format("Attempting to assign undefined value %s", new Object[]{a5.b()}));
            }
        } else if (ordinal == 14) {
            C1238v2.b(O.CONST.name(), 2, list);
            if (list.size() % 2 == 0) {
                int i6 = 0;
                while (i6 < list.size() - 1) {
                    r a7 = u12.a((r) list.get(i6));
                    if (a7 instanceof C1235v) {
                        u12.g(a7.b(), u12.a((r) list.get(i6 + 1)));
                        i6 += 2;
                    } else {
                        throw new IllegalArgumentException(String.format("Expected string for const name. got %s", new Object[]{a7.getClass().getCanonicalName()}));
                    }
                }
                return r.f5553b0;
            }
            throw new IllegalArgumentException(String.format("CONST requires an even number of arguments, found %s", new Object[]{Integer.valueOf(list.size())}));
        } else if (ordinal == 24) {
            C1238v2.b(O.EXPRESSION_LIST.name(), 1, list);
            r rVar = r.f5553b0;
            while (i5 < list.size()) {
                rVar = u12.a((r) list.get(i5));
                if (!(rVar instanceof C1110h)) {
                    i5++;
                } else {
                    throw new IllegalStateException("ControlValue cannot be in an expression list");
                }
            }
            return rVar;
        } else if (ordinal == 33) {
            C1238v2.a(O.f5052I.name(), 1, list);
            r a8 = u12.a((r) list.get(0));
            if (a8 instanceof C1235v) {
                return u12.h(a8.b());
            }
            throw new IllegalArgumentException(String.format("Expected string for get var. got %s", new Object[]{a8.getClass().getCanonicalName()}));
        } else if (ordinal == 49) {
            C1238v2.a(O.NULL.name(), 0, list);
            return r.f5554c0;
        } else if (ordinal == 58) {
            C1238v2.a(O.SET_PROPERTY.name(), 3, list);
            r a9 = u12.a((r) list.get(0));
            r a10 = u12.a((r) list.get(1));
            r a11 = u12.a((r) list.get(2));
            if (a9 == r.f5553b0 || a9 == r.f5554c0) {
                throw new IllegalStateException(String.format("Can't set property %s of %s", new Object[]{a10.b(), a9.b()}));
            } else if ((a9 instanceof C1092f) && (a10 instanceof C1128j)) {
                ((C1092f) a9).r(a10.C().intValue(), a11);
                return a11;
            } else if (!(a9 instanceof C1164n)) {
                return a11;
            } else {
                ((C1164n) a9).g(a10.b(), a11);
                return a11;
            }
        } else if (ordinal != 17) {
            if (ordinal != 18) {
                if (ordinal == 35 || ordinal == 36) {
                    C1238v2.a(O.GET_PROPERTY.name(), 2, list);
                    r a12 = u12.a((r) list.get(0));
                    r a13 = u12.a((r) list.get(1));
                    if ((a12 instanceof C1092f) && C1238v2.d(a13)) {
                        return ((C1092f) a12).q(a13.C().intValue());
                    }
                    if (a12 instanceof C1164n) {
                        return ((C1164n) a12).f(a13.b());
                    }
                    if (a12 instanceof C1235v) {
                        if ("length".equals(a13.b())) {
                            return new C1128j(Double.valueOf((double) a12.b().length()));
                        }
                        if (C1238v2.d(a13) && a13.C().doubleValue() < ((double) a12.b().length())) {
                            return new C1235v(String.valueOf(a12.b().charAt(a13.C().intValue())));
                        }
                    }
                    return r.f5553b0;
                }
                switch (ordinal) {
                    case 62:
                        C1238v2.a(O.TYPEOF.name(), 1, list);
                        r a14 = u12.a((r) list.get(0));
                        if (a14 instanceof C1244w) {
                            str2 = "undefined";
                        } else if (a14 instanceof C1101g) {
                            str2 = TypedValues.Custom.S_BOOLEAN;
                        } else if (a14 instanceof C1128j) {
                            str2 = "number";
                        } else if (a14 instanceof C1235v) {
                            str2 = TypedValues.Custom.S_STRING;
                        } else if (a14 instanceof C1191q) {
                            str2 = "function";
                        } else if ((a14 instanceof C1208s) || (a14 instanceof C1110h)) {
                            throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", new Object[]{a14}));
                        } else {
                            str2 = "object";
                        }
                        return new C1235v(str2);
                    case 63:
                        C1238v2.a(O.UNDEFINED.name(), 0, list);
                        return r.f5553b0;
                    case 64:
                        C1238v2.b(O.VAR.name(), 1, list);
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            r a15 = u12.a((r) it.next());
                            if (a15 instanceof C1235v) {
                                u12.f(a15.b(), r.f5553b0);
                            } else {
                                throw new IllegalArgumentException(String.format("Expected string for var name. got %s", new Object[]{a15.getClass().getCanonicalName()}));
                            }
                        }
                        return r.f5553b0;
                    default:
                        return super.b(str);
                }
            } else if (list.isEmpty()) {
                return new C1173o();
            } else {
                if (list.size() % 2 == 0) {
                    C1173o oVar = new C1173o();
                    while (i5 < list.size() - 1) {
                        r a16 = u12.a((r) list.get(i5));
                        r a17 = u12.a((r) list.get(i5 + 1));
                        if ((a16 instanceof C1110h) || (a17 instanceof C1110h)) {
                            throw new IllegalStateException("Failed to evaluate map entry");
                        }
                        oVar.g(a16.b(), a17);
                        i5 += 2;
                    }
                    return oVar;
                }
                throw new IllegalArgumentException(String.format("CREATE_OBJECT requires an even number of arguments, found %s", new Object[]{Integer.valueOf(list.size())}));
            }
        } else if (list.isEmpty()) {
            return new C1092f();
        } else {
            C1092f fVar = new C1092f();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                r a18 = u12.a((r) it2.next());
                if (!(a18 instanceof C1110h)) {
                    fVar.r(i5, a18);
                    i5++;
                } else {
                    throw new IllegalStateException("Failed to evaluate array element");
                }
            }
            return fVar;
        }
    }
}
