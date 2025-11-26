package androidx.datastore.core;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import z3.C2973f;

@f(c = "androidx.datastore.core.SingleProcessCoordinator$updateNotifications$1", f = "SingleProcessCoordinator.kt", l = {}, m = "invokeSuspend")
final class SingleProcessCoordinator$updateNotifications$1 extends l implements p {
    int label;

    SingleProcessCoordinator$updateNotifications$1(C2308e eVar) {
        super(2, eVar);
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new SingleProcessCoordinator$updateNotifications$1(eVar);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        if (this.label == 0) {
            u.b(obj);
            return J.f19942a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(C2973f fVar, C2308e eVar) {
        return ((SingleProcessCoordinator$updateNotifications$1) create(fVar, eVar)).invokeSuspend(J.f19942a);
    }
}
