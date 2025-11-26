package androidx.work;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", l = {67}, m = "invokeSuspend")
final class CoroutineWorker$startWork$1 extends l implements p {
    int label;
    final /* synthetic */ CoroutineWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutineWorker$startWork$1(CoroutineWorker coroutineWorker, C2308e eVar) {
        super(2, eVar);
        this.this$0 = coroutineWorker;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new CoroutineWorker$startWork$1(this.this$0, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            CoroutineWorker coroutineWorker = this.this$0;
            this.label = 1;
            Object doWork = coroutineWorker.doWork(this);
            if (doWork == f5) {
                return f5;
            }
            return doWork;
        } else if (i5 == 1) {
            u.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((CoroutineWorker$startWork$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
