package androidx.lifecycle;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import java.util.concurrent.CancellationException;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.C2908y0;
import w3.M;
import w3.X;

@f(c = "androidx.lifecycle.BlockRunner$cancel$1", f = "CoroutineLiveData.kt", l = {180}, m = "invokeSuspend")
final class BlockRunner$cancel$1 extends l implements p {
    int label;
    final /* synthetic */ BlockRunner<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlockRunner$cancel$1(BlockRunner<T> blockRunner, C2308e eVar) {
        super(2, eVar);
        this.this$0 = blockRunner;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new BlockRunner$cancel$1(this.this$0, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            long access$getTimeoutInMs$p = this.this$0.timeoutInMs;
            this.label = 1;
            if (X.b(access$getTimeoutInMs$p, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!this.this$0.liveData.hasActiveObservers()) {
            C2908y0 access$getRunningJob$p = this.this$0.runningJob;
            if (access$getRunningJob$p != null) {
                C2908y0.a.a(access$getRunningJob$p, (CancellationException) null, 1, (Object) null);
            }
            this.this$0.runningJob = null;
        }
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((BlockRunner$cancel$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
