package androidx.room;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.room.InvalidationTracker$refreshVersionsSync$1", f = "InvalidationTracker.android.kt", l = {345}, m = "invokeSuspend")
final class InvalidationTracker$refreshVersionsSync$1 extends l implements p {
    int label;
    final /* synthetic */ InvalidationTracker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InvalidationTracker$refreshVersionsSync$1(InvalidationTracker invalidationTracker, C2308e eVar) {
        super(2, eVar);
        this.this$0 = invalidationTracker;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new InvalidationTracker$refreshVersionsSync$1(this.this$0, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            C2616a access$getOnRefreshScheduled$p = this.this$0.onRefreshScheduled;
            C2616a access$getOnRefreshCompleted$p = this.this$0.onRefreshCompleted;
            this.label = 1;
            if (this.this$0.implementation.refreshInvalidation$room_runtime_release(new String[0], access$getOnRefreshScheduled$p, access$getOnRefreshCompleted$p, this) == f5) {
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
        return ((InvalidationTracker$refreshVersionsSync$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
