package androidx.work.impl.constraints;

import W2.J;
import W2.u;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;
import w3.X;
import y3.v;

@f(c = "androidx.work.impl.constraints.NetworkRequestConstraintController$track$1$timeoutJob$1", f = "WorkConstraintsTracker.kt", l = {151}, m = "invokeSuspend")
final class NetworkRequestConstraintController$track$1$timeoutJob$1 extends l implements p {
    final /* synthetic */ v $$this$callbackFlow;
    int label;
    final /* synthetic */ NetworkRequestConstraintController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetworkRequestConstraintController$track$1$timeoutJob$1(NetworkRequestConstraintController networkRequestConstraintController, v vVar, C2308e eVar) {
        super(2, eVar);
        this.this$0 = networkRequestConstraintController;
        this.$$this$callbackFlow = vVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new NetworkRequestConstraintController$track$1$timeoutJob$1(this.this$0, this.$$this$callbackFlow, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            long access$getTimeoutMs$p = this.this$0.timeoutMs;
            this.label = 1;
            if (X.b(access$getTimeoutMs$p, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Logger logger = Logger.get();
        String access$getTAG$p = WorkConstraintsTrackerKt.TAG;
        logger.debug(access$getTAG$p, "NetworkRequestConstraintController didn't receive neither onCapabilitiesChanged/onLost callback, sending `ConstraintsNotMet` after " + this.this$0.timeoutMs + " ms");
        this.$$this$callbackFlow.r(new ConstraintsState.ConstraintsNotMet(7));
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((NetworkRequestConstraintController$track$1$timeoutJob$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
