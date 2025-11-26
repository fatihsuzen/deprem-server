package androidx.work.impl.constraints.controllers;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import y3.t;
import y3.v;

@f(c = "androidx.work.impl.constraints.controllers.BaseConstraintController$track$1", f = "ContraintControllers.kt", l = {63}, m = "invokeSuspend")
final class BaseConstraintController$track$1 extends l implements p {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseConstraintController<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseConstraintController$track$1(BaseConstraintController<T> baseConstraintController, C2308e eVar) {
        super(2, eVar);
        this.this$0 = baseConstraintController;
    }

    /* access modifiers changed from: private */
    public static final J invokeSuspend$lambda$0(BaseConstraintController baseConstraintController, BaseConstraintController$track$1$listener$1 baseConstraintController$track$1$listener$1) {
        baseConstraintController.tracker.removeListener(baseConstraintController$track$1$listener$1);
        return J.f19942a;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        BaseConstraintController$track$1 baseConstraintController$track$1 = new BaseConstraintController$track$1(this.this$0, eVar);
        baseConstraintController$track$1.L$0 = obj;
        return baseConstraintController$track$1;
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            v vVar = (v) this.L$0;
            BaseConstraintController$track$1$listener$1 baseConstraintController$track$1$listener$1 = new BaseConstraintController$track$1$listener$1(this.this$0, vVar);
            this.this$0.tracker.addListener(baseConstraintController$track$1$listener$1);
            a aVar = new a(this.this$0, baseConstraintController$track$1$listener$1);
            this.label = 1;
            if (t.a(vVar, aVar, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }

    public final Object invoke(v vVar, C2308e eVar) {
        return ((BaseConstraintController$track$1) create(vVar, eVar)).invokeSuspend(J.f19942a);
    }
}
