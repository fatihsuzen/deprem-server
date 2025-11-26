package androidx.room;

import b3.C2308e;
import k3.C2616a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {367}, m = "refreshInvalidation$room_runtime_release")
final class TriggerBasedInvalidationTracker$refreshInvalidation$1 extends d {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TriggerBasedInvalidationTracker$refreshInvalidation$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, C2308e eVar) {
        super(eVar);
        this.this$0 = triggerBasedInvalidationTracker;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.refreshInvalidation$room_runtime_release((String[]) null, (C2616a) null, (C2616a) null, this);
    }
}
