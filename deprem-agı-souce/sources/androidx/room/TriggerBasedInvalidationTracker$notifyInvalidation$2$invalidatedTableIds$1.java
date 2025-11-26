package androidx.room;

import W2.J;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1", f = "InvalidationTracker.kt", l = {413, 420}, m = "invokeSuspend")
final class TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 extends l implements p {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, C2308e eVar) {
        super(2, eVar);
        this.this$0 = triggerBasedInvalidationTracker;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 = new TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1(this.this$0, eVar);
        triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1.L$0 = obj;
        return triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1;
    }

    public final Object invoke(Transactor transactor, C2308e eVar) {
        return ((TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1) create(transactor, eVar)).invokeSuspend(J.f19942a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.room.Transactor} */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        if (r7 == r0) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
        if (r7 == r0) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        return r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            W2.u.b(r7)     // Catch:{ SQLException -> 0x005a }
            goto L_0x0057
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            java.lang.Object r1 = r6.L$0
            androidx.room.Transactor r1 = (androidx.room.Transactor) r1
            W2.u.b(r7)
            goto L_0x0035
        L_0x0022:
            W2.u.b(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            androidx.room.Transactor r1 = (androidx.room.Transactor) r1
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r1.inTransaction(r6)
            if (r7 != r0) goto L_0x0035
            goto L_0x0056
        L_0x0035:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0042
            java.util.Set r7 = X2.T.d()
            return r7
        L_0x0042:
            androidx.room.Transactor$SQLiteTransactionType r7 = androidx.room.Transactor.SQLiteTransactionType.IMMEDIATE     // Catch:{ SQLException -> 0x005a }
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1$1 r3 = new androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1$1     // Catch:{ SQLException -> 0x005a }
            androidx.room.TriggerBasedInvalidationTracker r4 = r6.this$0     // Catch:{ SQLException -> 0x005a }
            r5 = 0
            r3.<init>(r4, r5)     // Catch:{ SQLException -> 0x005a }
            r6.L$0 = r5     // Catch:{ SQLException -> 0x005a }
            r6.label = r2     // Catch:{ SQLException -> 0x005a }
            java.lang.Object r7 = r1.withTransaction(r7, r3, r6)     // Catch:{ SQLException -> 0x005a }
            if (r7 != r0) goto L_0x0057
        L_0x0056:
            return r0
        L_0x0057:
            java.util.Set r7 = (java.util.Set) r7     // Catch:{ SQLException -> 0x005a }
            return r7
        L_0x005a:
            java.util.Set r7 = X2.T.d()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
