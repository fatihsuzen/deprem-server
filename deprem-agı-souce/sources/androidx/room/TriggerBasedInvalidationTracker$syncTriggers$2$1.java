package androidx.room;

import W2.J;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1", f = "InvalidationTracker.kt", l = {301, 309}, m = "invokeSuspend")
final class TriggerBasedInvalidationTracker$syncTriggers$2$1 extends l implements p {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TriggerBasedInvalidationTracker$syncTriggers$2$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, C2308e eVar) {
        super(2, eVar);
        this.this$0 = triggerBasedInvalidationTracker;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        TriggerBasedInvalidationTracker$syncTriggers$2$1 triggerBasedInvalidationTracker$syncTriggers$2$1 = new TriggerBasedInvalidationTracker$syncTriggers$2$1(this.this$0, eVar);
        triggerBasedInvalidationTracker$syncTriggers$2$1.L$0 = obj;
        return triggerBasedInvalidationTracker$syncTriggers$2$1;
    }

    public final Object invoke(Transactor transactor, C2308e eVar) {
        return ((TriggerBasedInvalidationTracker$syncTriggers$2$1) create(transactor, eVar)).invokeSuspend(J.f19942a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.room.Transactor} */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
        if (r1.withTransaction(r3, r4, r7) == r0) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0060, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        if (r8 == r0) goto L_0x0060;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            W2.u.b(r8)
            goto L_0x0061
        L_0x0012:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001a:
            java.lang.Object r1 = r7.L$0
            androidx.room.Transactor r1 = (androidx.room.Transactor) r1
            W2.u.b(r8)
            goto L_0x0035
        L_0x0022:
            W2.u.b(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            androidx.room.Transactor r1 = (androidx.room.Transactor) r1
            r7.L$0 = r1
            r7.label = r3
            java.lang.Object r8 = r1.inTransaction(r7)
            if (r8 != r0) goto L_0x0035
            goto L_0x0060
        L_0x0035:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0040
            W2.J r8 = W2.J.f19942a
            return r8
        L_0x0040:
            androidx.room.TriggerBasedInvalidationTracker r8 = r7.this$0
            androidx.room.ObservedTableStates r8 = r8.observedTableStates
            androidx.room.ObservedTableStates$ObserveOp[] r8 = r8.getTablesToSync$room_runtime_release()
            if (r8 == 0) goto L_0x0061
            androidx.room.Transactor$SQLiteTransactionType r3 = androidx.room.Transactor.SQLiteTransactionType.IMMEDIATE
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1 r4 = new androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1
            androidx.room.TriggerBasedInvalidationTracker r5 = r7.this$0
            r6 = 0
            r4.<init>(r8, r5, r1, r6)
            r7.L$0 = r6
            r7.label = r2
            java.lang.Object r8 = r1.withTransaction(r3, r4, r7)
            if (r8 != r0) goto L_0x0061
        L_0x0060:
            return r0
        L_0x0061:
            W2.J r8 = W2.J.f19942a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
