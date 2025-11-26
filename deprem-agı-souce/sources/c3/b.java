package C3;

import B3.K;
import B3.z;
import W2.t;
import W2.u;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.S;
import w3.C2854A;
import w3.F0;
import w3.X0;

public abstract class b {
    public static final void a(p pVar, Object obj, C2308e eVar) {
        C2312i context;
        Object i5;
        Object obj2;
        C2308e a5 = h.a(eVar);
        try {
            context = a5.getContext();
            i5 = K.i(context, (Object) null);
            h.b(a5);
            if (!(pVar instanceof a)) {
                obj2 = C2316b.d(pVar, obj, a5);
            } else {
                obj2 = ((p) S.c(pVar, 2)).invoke(obj, a5);
            }
            K.f(context, i5);
            if (obj2 != C2316b.f()) {
                a5.resumeWith(t.b(obj2));
            }
        } catch (Throwable th) {
            t.a aVar = t.f19966b;
            a5.resumeWith(t.b(u.a(th)));
        }
    }

    public static final Object b(z zVar, Object obj, p pVar) {
        Object obj2;
        try {
            if (!(pVar instanceof a)) {
                obj2 = C2316b.d(pVar, obj, zVar);
            } else {
                obj2 = ((p) S.c(pVar, 2)).invoke(obj, zVar);
            }
        } catch (Throwable th) {
            obj2 = new C2854A(th, false, 2, (C2633k) null);
        }
        if (obj2 == C2316b.f()) {
            return C2316b.f();
        }
        Object q02 = zVar.q0(obj2);
        if (q02 == F0.f26231b) {
            return C2316b.f();
        }
        if (!(q02 instanceof C2854A)) {
            return F0.h(q02);
        }
        throw ((C2854A) q02).f26214a;
    }

    public static final Object c(z zVar, Object obj, p pVar) {
        Object obj2;
        try {
            if (!(pVar instanceof a)) {
                obj2 = C2316b.d(pVar, obj, zVar);
            } else {
                obj2 = ((p) S.c(pVar, 2)).invoke(obj, zVar);
            }
        } catch (Throwable th) {
            obj2 = new C2854A(th, false, 2, (C2633k) null);
        }
        if (obj2 == C2316b.f()) {
            return C2316b.f();
        }
        Object q02 = zVar.q0(obj2);
        if (q02 == F0.f26231b) {
            return C2316b.f();
        }
        if (q02 instanceof C2854A) {
            Throwable th2 = ((C2854A) q02).f26214a;
            if (!(th2 instanceof X0) || ((X0) th2).f26264a != zVar) {
                throw th2;
            } else if (obj2 instanceof C2854A) {
                throw ((C2854A) obj2).f26214a;
            }
        } else {
            obj2 = F0.h(q02);
        }
        return obj2;
    }
}
