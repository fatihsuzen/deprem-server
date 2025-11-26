package B3;

import k3.p;

/* renamed from: B3.a  reason: case insensitive filesystem */
public abstract class C1981a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final D f17387a = new D("CLOSED");

    public static final C1982b b(C1982b bVar) {
        while (true) {
            Object b5 = bVar.g();
            if (b5 == f17387a) {
                return bVar;
            }
            C1982b bVar2 = (C1982b) b5;
            if (bVar2 != null) {
                bVar = bVar2;
            } else if (bVar.m()) {
                return bVar;
            }
        }
    }

    public static final Object c(A a5, long j5, p pVar) {
        while (true) {
            if (a5.f17367c >= j5 && !a5.k()) {
                return B.a(a5);
            }
            Object b5 = a5.g();
            if (b5 == f17387a) {
                return B.a(f17387a);
            }
            A a6 = (A) ((C1982b) b5);
            if (a6 == null) {
                a6 = (A) pVar.invoke(Long.valueOf(a5.f17367c + 1), a5);
                if (a5.o(a6)) {
                    if (a5.k()) {
                        a5.n();
                    }
                }
            }
            a5 = a6;
        }
    }
}
