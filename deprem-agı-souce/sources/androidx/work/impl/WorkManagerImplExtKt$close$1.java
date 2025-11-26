package androidx.work.impl;

import W2.J;
import W2.u;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import w3.B0;
import w3.C2908y0;
import w3.M;

@f(c = "androidx.work.impl.WorkManagerImplExtKt$close$1", f = "WorkManagerImplExt.kt", l = {121}, m = "invokeSuspend")
final class WorkManagerImplExtKt$close$1 extends l implements p {
    final /* synthetic */ WorkManagerImpl $this_close;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkManagerImplExtKt$close$1(WorkManagerImpl workManagerImpl, C2308e eVar) {
        super(2, eVar);
        this.$this_close = workManagerImpl;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new WorkManagerImplExtKt$close$1(this.$this_close, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            C2312i.b bVar = this.$this_close.getWorkManagerScope().getCoroutineContext().get(C2908y0.f26320k0);
            t.b(bVar);
            this.label = 1;
            if (B0.e((C2908y0) bVar, this) == f5) {
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
        return ((WorkManagerImplExtKt$close$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
