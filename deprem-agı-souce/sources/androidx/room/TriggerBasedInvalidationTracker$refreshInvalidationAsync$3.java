package androidx.room;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import java.util.Set;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.room.TriggerBasedInvalidationTracker$refreshInvalidationAsync$3", f = "InvalidationTracker.kt", l = {389}, m = "invokeSuspend")
final class TriggerBasedInvalidationTracker$refreshInvalidationAsync$3 extends l implements p {
    final /* synthetic */ C2616a $onRefreshCompleted;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, C2616a aVar, C2308e eVar) {
        super(2, eVar);
        this.this$0 = triggerBasedInvalidationTracker;
        this.$onRefreshCompleted = aVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(this.this$0, this.$onRefreshCompleted, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = this.this$0;
            this.label = 1;
            obj = triggerBasedInvalidationTracker.notifyInvalidation(this);
            if (obj == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            try {
                u.b(obj);
            } catch (Throwable th) {
                this.$onRefreshCompleted.invoke();
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Set set = (Set) obj;
        this.$onRefreshCompleted.invoke();
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((TriggerBasedInvalidationTracker$refreshInvalidationAsync$3) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
