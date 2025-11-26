package androidx.room;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {342}, m = "stopTrackingTable")
final class TriggerBasedInvalidationTracker$stopTrackingTable$1 extends d {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TriggerBasedInvalidationTracker$stopTrackingTable$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, C2308e eVar) {
        super(eVar);
        this.this$0 = triggerBasedInvalidationTracker;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.stopTrackingTable((PooledConnection) null, 0, this);
    }
}
