package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public final class K extends C1261y {
    protected K() {
        this.f5629a.add(O.FOR_IN);
        this.f5629a.add(O.FOR_IN_CONST);
        this.f5629a.add(O.FOR_IN_LET);
        this.f5629a.add(O.FOR_LET);
        this.f5629a.add(O.FOR_OF);
        this.f5629a.add(O.FOR_OF_CONST);
        this.f5629a.add(O.FOR_OF_LET);
        this.f5629a.add(O.WHILE);
    }

    private static r c(I i5, r rVar, r rVar2) {
        return e(i5, rVar.c(), rVar2);
    }

    private static r d(I i5, r rVar, r rVar2) {
        if (rVar instanceof Iterable) {
            return e(i5, ((Iterable) rVar).iterator(), rVar2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    private static r e(I i5, Iterator it, r rVar) {
        if (it != null) {
            while (it.hasNext()) {
                r b5 = i5.a((r) it.next()).b((C1092f) rVar);
                if (b5 instanceof C1110h) {
                    C1110h hVar = (C1110h) b5;
                    if ("break".equals(hVar.e())) {
                        return r.f5553b0;
                    }
                    if ("return".equals(hVar.e())) {
                        return hVar;
                    }
                }
            }
        }
        return r.f5553b0;
    }

    public final r a(String str, U1 u12, List list) {
        O o5 = O.ADD;
        int ordinal = C1238v2.e(str).ordinal();
        if (ordinal != 65) {
            switch (ordinal) {
                case 26:
                    C1238v2.a(O.FOR_IN.name(), 3, list);
                    if (list.get(0) instanceof C1235v) {
                        return c(new J(u12, ((r) list.get(0)).b()), u12.a((r) list.get(1)), u12.a((r) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
                case 27:
                    C1238v2.a(O.FOR_IN_CONST.name(), 3, list);
                    if (list.get(0) instanceof C1235v) {
                        return c(new G(u12, ((r) list.get(0)).b()), u12.a((r) list.get(1)), u12.a((r) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
                case 28:
                    C1238v2.a(O.FOR_IN_LET.name(), 3, list);
                    if (list.get(0) instanceof C1235v) {
                        return c(new H(u12, ((r) list.get(0)).b()), u12.a((r) list.get(1)), u12.a((r) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
                case 29:
                    C1238v2.a(O.FOR_LET.name(), 4, list);
                    r a5 = u12.a((r) list.get(0));
                    if (a5 instanceof C1092f) {
                        C1092f fVar = (C1092f) a5;
                        r rVar = (r) list.get(1);
                        r rVar2 = (r) list.get(2);
                        r a6 = u12.a((r) list.get(3));
                        U1 c5 = u12.c();
                        for (int i5 = 0; i5 < fVar.o(); i5++) {
                            String b5 = fVar.q(i5).b();
                            c5.e(b5, u12.h(b5));
                        }
                        while (u12.a(rVar).d().booleanValue()) {
                            r b6 = u12.b((C1092f) a6);
                            if (b6 instanceof C1110h) {
                                C1110h hVar = (C1110h) b6;
                                if ("break".equals(hVar.e())) {
                                    return r.f5553b0;
                                }
                                if ("return".equals(hVar.e())) {
                                    return hVar;
                                }
                            }
                            U1 c6 = u12.c();
                            for (int i6 = 0; i6 < fVar.o(); i6++) {
                                String b7 = fVar.q(i6).b();
                                c6.e(b7, c5.h(b7));
                            }
                            c6.a(rVar2);
                            c5 = c6;
                        }
                        return r.f5553b0;
                    }
                    throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
                case 30:
                    C1238v2.a(O.FOR_OF.name(), 3, list);
                    if (list.get(0) instanceof C1235v) {
                        return d(new J(u12, ((r) list.get(0)).b()), u12.a((r) list.get(1)), u12.a((r) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
                case 31:
                    C1238v2.a(O.FOR_OF_CONST.name(), 3, list);
                    if (list.get(0) instanceof C1235v) {
                        return d(new G(u12, ((r) list.get(0)).b()), u12.a((r) list.get(1)), u12.a((r) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
                case 32:
                    C1238v2.a(O.FOR_OF_LET.name(), 3, list);
                    if (list.get(0) instanceof C1235v) {
                        return d(new H(u12, ((r) list.get(0)).b()), u12.a((r) list.get(1)), u12.a((r) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
                default:
                    return super.b(str);
            }
        } else {
            C1238v2.a(O.WHILE.name(), 4, list);
            r rVar3 = (r) list.get(0);
            r rVar4 = (r) list.get(1);
            r a7 = u12.a((r) list.get(3));
            if (u12.a((r) list.get(2)).d().booleanValue()) {
                r b8 = u12.b((C1092f) a7);
                if (b8 instanceof C1110h) {
                    C1110h hVar2 = (C1110h) b8;
                    if ("break".equals(hVar2.e())) {
                        return r.f5553b0;
                    }
                    if ("return".equals(hVar2.e())) {
                        return hVar2;
                    }
                }
            }
            while (u12.a(rVar3).d().booleanValue()) {
                r b9 = u12.b((C1092f) a7);
                if (b9 instanceof C1110h) {
                    C1110h hVar3 = (C1110h) b9;
                    if ("break".equals(hVar3.e())) {
                        return r.f5553b0;
                    }
                    if ("return".equals(hVar3.e())) {
                        return hVar3;
                    }
                }
                u12.a(rVar4);
            }
            return r.f5553b0;
        }
    }
}
