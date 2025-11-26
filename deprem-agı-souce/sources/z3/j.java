package z3;

import A3.q;
import W2.J;
import W2.u;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import w3.C2908y0;
import w3.M;
import w3.O;

abstract /* synthetic */ class j {

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f26630a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2972e f26631b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2972e eVar, C2308e eVar2) {
            super(2, eVar2);
            this.f26631b = eVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f26631b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f26630a;
            if (i5 == 0) {
                u.b(obj);
                C2972e eVar = this.f26631b;
                this.f26630a = 1;
                if (C2974g.h(eVar, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final Object a(C2972e eVar, C2308e eVar2) {
        Object collect = eVar.collect(q.f17310a, eVar2);
        if (collect == C2316b.f()) {
            return collect;
        }
        return J.f19942a;
    }

    public static final Object b(C2973f fVar, C2972e eVar, C2308e eVar2) {
        C2974g.n(fVar);
        Object collect = eVar.collect(fVar, eVar2);
        if (collect == C2316b.f()) {
            return collect;
        }
        return J.f19942a;
    }

    public static final C2908y0 c(C2972e eVar, M m5) {
        return C2876i.d(m5, (C2312i) null, (O) null, new a(eVar, (C2308e) null), 3, (Object) null);
    }
}
