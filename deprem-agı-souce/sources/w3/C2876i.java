package w3;

import B3.K;
import B3.z;
import C3.a;
import C3.b;
import b3.C2308e;
import b3.C2309f;
import b3.C2312i;
import b3.C2313j;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.t;

/* renamed from: w3.i  reason: case insensitive filesystem */
abstract /* synthetic */ class C2876i {
    public static final U a(M m5, C2312i iVar, O o5, p pVar) {
        V v5;
        C2312i k5 = G.k(m5, iVar);
        if (o5.c()) {
            v5 = new G0(k5, pVar);
        } else {
            v5 = new V(k5, true);
        }
        v5.P0(o5, v5, pVar);
        return v5;
    }

    public static /* synthetic */ U b(M m5, C2312i iVar, O o5, p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            iVar = C2313j.f20794a;
        }
        if ((i5 & 2) != 0) {
            o5 = O.DEFAULT;
        }
        return C2872g.a(m5, iVar, o5, pVar);
    }

    public static final C2908y0 c(M m5, C2312i iVar, O o5, p pVar) {
        C2860a aVar;
        C2312i k5 = G.k(m5, iVar);
        if (o5.c()) {
            aVar = new H0(k5, pVar);
        } else {
            aVar = new R0(k5, true);
        }
        aVar.P0(o5, aVar, pVar);
        return aVar;
    }

    public static /* synthetic */ C2908y0 d(M m5, C2312i iVar, O o5, p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            iVar = C2313j.f20794a;
        }
        if ((i5 & 2) != 0) {
            o5 = O.DEFAULT;
        }
        return C2872g.c(m5, iVar, o5, pVar);
    }

    /* JADX INFO: finally extract failed */
    public static final Object e(C2312i iVar, p pVar, C2308e eVar) {
        Object obj;
        C2312i context = eVar.getContext();
        C2312i j5 = G.j(context, iVar);
        B0.g(j5);
        if (j5 == context) {
            z zVar = new z(j5, eVar);
            obj = b.b(zVar, zVar, pVar);
        } else {
            C2309f.b bVar = C2309f.f20792a0;
            if (t.a(j5.get(bVar), context.get(bVar))) {
                b1 b1Var = new b1(j5, eVar);
                C2312i context2 = b1Var.getContext();
                Object i5 = K.i(context2, (Object) null);
                try {
                    Object b5 = b.b(b1Var, b1Var, pVar);
                    K.f(context2, i5);
                    obj = b5;
                } catch (Throwable th) {
                    K.f(context2, i5);
                    throw th;
                }
            } else {
                Y y4 = new Y(j5, eVar);
                a.c(pVar, y4, y4);
                obj = y4.Q0();
            }
        }
        if (obj == C2316b.f()) {
            h.c(eVar);
        }
        return obj;
    }
}
