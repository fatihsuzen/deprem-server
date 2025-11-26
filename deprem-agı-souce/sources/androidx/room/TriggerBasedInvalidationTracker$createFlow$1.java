package androidx.room;

import W2.J;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import z3.C2973f;

@f(c = "androidx.room.TriggerBasedInvalidationTracker$createFlow$1", f = "InvalidationTracker.kt", l = {233, 233, 237}, m = "invokeSuspend")
final class TriggerBasedInvalidationTracker$createFlow$1 extends l implements p {
    final /* synthetic */ boolean $emitInitialState;
    final /* synthetic */ String[] $resolvedTableNames;
    final /* synthetic */ int[] $tableIds;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TriggerBasedInvalidationTracker$createFlow$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, int[] iArr, boolean z4, String[] strArr, C2308e eVar) {
        super(2, eVar);
        this.this$0 = triggerBasedInvalidationTracker;
        this.$tableIds = iArr;
        this.$emitInitialState = z4;
        this.$resolvedTableNames = strArr;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        TriggerBasedInvalidationTracker$createFlow$1 triggerBasedInvalidationTracker$createFlow$1 = new TriggerBasedInvalidationTracker$createFlow$1(this.this$0, this.$tableIds, this.$emitInitialState, this.$resolvedTableNames, eVar);
        triggerBasedInvalidationTracker$createFlow$1.L$0 = obj;
        return triggerBasedInvalidationTracker$createFlow$1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        if (w3.C2872g.g((b3.C2312i) r12, r5, r11) == r0) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0092, code lost:
        if (r12.collect(r4, r11) != r0) goto L_0x0095;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r11.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 == r5) goto L_0x002b
            if (r1 == r4) goto L_0x0023
            if (r1 == r3) goto L_0x001a
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001a:
            W2.u.b(r12)     // Catch:{ all -> 0x001f }
            goto L_0x0095
        L_0x001f:
            r0 = move-exception
            r12 = r0
            goto L_0x009b
        L_0x0023:
            java.lang.Object r1 = r11.L$0
            z3.f r1 = (z3.C2973f) r1
            W2.u.b(r12)
            goto L_0x0071
        L_0x002b:
            java.lang.Object r1 = r11.L$0
            z3.f r1 = (z3.C2973f) r1
            W2.u.b(r12)
            goto L_0x005d
        L_0x0033:
            W2.u.b(r12)
            java.lang.Object r12 = r11.L$0
            z3.f r12 = (z3.C2973f) r12
            androidx.room.TriggerBasedInvalidationTracker r1 = r11.this$0
            androidx.room.ObservedTableStates r1 = r1.observedTableStates
            int[] r6 = r11.$tableIds
            boolean r1 = r1.onObserverAdded$room_runtime_release(r6)
            if (r1 == 0) goto L_0x0073
            androidx.room.TriggerBasedInvalidationTracker r1 = r11.this$0
            androidx.room.RoomDatabase r1 = r1.database
            r11.L$0 = r12
            r11.label = r5
            r5 = 0
            java.lang.Object r1 = androidx.room.util.DBUtil.getCoroutineContext(r1, r5, r11)
            if (r1 != r0) goto L_0x005a
            goto L_0x0094
        L_0x005a:
            r10 = r1
            r1 = r12
            r12 = r10
        L_0x005d:
            b3.i r12 = (b3.C2312i) r12
            androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1 r5 = new androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1
            androidx.room.TriggerBasedInvalidationTracker r6 = r11.this$0
            r5.<init>(r6, r2)
            r11.L$0 = r1
            r11.label = r4
            java.lang.Object r12 = w3.C2872g.g(r12, r5, r11)
            if (r12 != r0) goto L_0x0071
            goto L_0x0094
        L_0x0071:
            r7 = r1
            goto L_0x0074
        L_0x0073:
            r7 = r12
        L_0x0074:
            kotlin.jvm.internal.L r5 = new kotlin.jvm.internal.L     // Catch:{ all -> 0x001f }
            r5.<init>()     // Catch:{ all -> 0x001f }
            androidx.room.TriggerBasedInvalidationTracker r12 = r11.this$0     // Catch:{ all -> 0x001f }
            androidx.room.ObservedTableVersions r12 = r12.observedTableVersions     // Catch:{ all -> 0x001f }
            androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2 r4 = new androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2     // Catch:{ all -> 0x001f }
            boolean r6 = r11.$emitInitialState     // Catch:{ all -> 0x001f }
            java.lang.String[] r8 = r11.$resolvedTableNames     // Catch:{ all -> 0x001f }
            int[] r9 = r11.$tableIds     // Catch:{ all -> 0x001f }
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x001f }
            r11.L$0 = r2     // Catch:{ all -> 0x001f }
            r11.label = r3     // Catch:{ all -> 0x001f }
            java.lang.Object r12 = r12.collect(r4, r11)     // Catch:{ all -> 0x001f }
            if (r12 != r0) goto L_0x0095
        L_0x0094:
            return r0
        L_0x0095:
            W2.h r12 = new W2.h     // Catch:{ all -> 0x001f }
            r12.<init>()     // Catch:{ all -> 0x001f }
            throw r12     // Catch:{ all -> 0x001f }
        L_0x009b:
            androidx.room.TriggerBasedInvalidationTracker r0 = r11.this$0
            androidx.room.ObservedTableStates r0 = r0.observedTableStates
            int[] r1 = r11.$tableIds
            r0.onObserverRemoved$room_runtime_release(r1)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$createFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(C2973f fVar, C2308e eVar) {
        return ((TriggerBasedInvalidationTracker$createFlow$1) create(fVar, eVar)).invokeSuspend(J.f19942a);
    }
}
