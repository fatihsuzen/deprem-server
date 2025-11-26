package androidx.work.impl;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.work.impl.WorkerWrapper$launch$1$resolution$1", f = "WorkerWrapper.kt", l = {98}, m = "invokeSuspend")
final class WorkerWrapper$launch$1$resolution$1 extends l implements p {
    int label;
    final /* synthetic */ WorkerWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkerWrapper$launch$1$resolution$1(WorkerWrapper workerWrapper, C2308e eVar) {
        super(2, eVar);
        this.this$0 = workerWrapper;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new WorkerWrapper$launch$1$resolution$1(this.this$0, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            WorkerWrapper workerWrapper = this.this$0;
            this.label = 1;
            Object access$runWorker = workerWrapper.runWorker(this);
            if (access$runWorker == f5) {
                return f5;
            }
            return access$runWorker;
        } else if (i5 == 1) {
            u.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((WorkerWrapper$launch$1$resolution$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
