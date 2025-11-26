package androidx.room.util;

import W2.J;
import androidx.room.RoomDatabase;
import androidx.room.Transactor;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1", f = "DBUtil.android.kt", l = {56, 57, 59, 60, 67}, m = "invokeSuspend")
public final class DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1 extends l implements p {
    final /* synthetic */ k3.l $block$inlined;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ boolean $isReadOnly;
    final /* synthetic */ RoomDatabase $this_internalPerform;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1(boolean z4, boolean z5, RoomDatabase roomDatabase, C2308e eVar, k3.l lVar) {
        super(2, eVar);
        this.$inTransaction = z4;
        this.$isReadOnly = z5;
        this.$this_internalPerform = roomDatabase;
        this.$block$inlined = lVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1(this.$inTransaction, this.$isReadOnly, this.$this_internalPerform, eVar, this.$block$inlined);
        dBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1.L$0 = obj;
        return dBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1;
    }

    public final Object invoke(Transactor transactor, C2308e eVar) {
        return ((DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1) create(transactor, eVar)).invokeSuspend(J.f19942a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008b, code lost:
        if (r9.sync$room_runtime_release(r8) == r0) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a5, code lost:
        if (r9 == r0) goto L_0x00de;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r8.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L_0x004b
            if (r1 == r6) goto L_0x003f
            if (r1 == r5) goto L_0x0033
            if (r1 == r4) goto L_0x002a
            if (r1 == r3) goto L_0x0023
            if (r1 != r2) goto L_0x001b
            W2.u.b(r9)
            return r9
        L_0x001b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0023:
            java.lang.Object r0 = r8.L$0
            W2.u.b(r9)
            goto L_0x00b9
        L_0x002a:
            java.lang.Object r1 = r8.L$0
            androidx.room.Transactor r1 = (androidx.room.Transactor) r1
            W2.u.b(r9)
            goto L_0x00a8
        L_0x0033:
            java.lang.Object r1 = r8.L$1
            androidx.room.Transactor$SQLiteTransactionType r1 = (androidx.room.Transactor.SQLiteTransactionType) r1
            java.lang.Object r2 = r8.L$0
            androidx.room.Transactor r2 = (androidx.room.Transactor) r2
            W2.u.b(r9)
            goto L_0x008e
        L_0x003f:
            java.lang.Object r1 = r8.L$1
            androidx.room.Transactor$SQLiteTransactionType r1 = (androidx.room.Transactor.SQLiteTransactionType) r1
            java.lang.Object r2 = r8.L$0
            androidx.room.Transactor r2 = (androidx.room.Transactor) r2
            W2.u.b(r9)
            goto L_0x0073
        L_0x004b:
            W2.u.b(r9)
            java.lang.Object r9 = r8.L$0
            androidx.room.Transactor r9 = (androidx.room.Transactor) r9
            boolean r1 = r8.$inTransaction
            if (r1 == 0) goto L_0x00cc
            boolean r1 = r8.$isReadOnly
            if (r1 == 0) goto L_0x005d
            androidx.room.Transactor$SQLiteTransactionType r2 = androidx.room.Transactor.SQLiteTransactionType.DEFERRED
            goto L_0x005f
        L_0x005d:
            androidx.room.Transactor$SQLiteTransactionType r2 = androidx.room.Transactor.SQLiteTransactionType.IMMEDIATE
        L_0x005f:
            if (r1 != 0) goto L_0x0092
            r8.L$0 = r9
            r8.L$1 = r2
            r8.label = r6
            java.lang.Object r1 = r9.inTransaction(r8)
            if (r1 != r0) goto L_0x006f
            goto L_0x00de
        L_0x006f:
            r7 = r2
            r2 = r9
            r9 = r1
            r1 = r7
        L_0x0073:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x008e
            androidx.room.RoomDatabase r9 = r8.$this_internalPerform
            androidx.room.InvalidationTracker r9 = r9.getInvalidationTracker()
            r8.L$0 = r2
            r8.L$1 = r1
            r8.label = r5
            java.lang.Object r9 = r9.sync$room_runtime_release(r8)
            if (r9 != r0) goto L_0x008e
            goto L_0x00de
        L_0x008e:
            r7 = r2
            r2 = r1
            r1 = r7
            goto L_0x0093
        L_0x0092:
            r1 = r9
        L_0x0093:
            androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1$1 r9 = new androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1$1
            k3.l r5 = r8.$block$inlined
            r6 = 0
            r9.<init>(r6, r5)
            r8.L$0 = r1
            r8.L$1 = r6
            r8.label = r4
            java.lang.Object r9 = r1.withTransaction(r2, r9, r8)
            if (r9 != r0) goto L_0x00a8
            goto L_0x00de
        L_0x00a8:
            boolean r2 = r8.$isReadOnly
            if (r2 != 0) goto L_0x00cb
            r8.L$0 = r9
            r8.label = r3
            java.lang.Object r1 = r1.inTransaction(r8)
            if (r1 != r0) goto L_0x00b7
            goto L_0x00de
        L_0x00b7:
            r0 = r9
            r9 = r1
        L_0x00b9:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x00ca
            androidx.room.RoomDatabase r9 = r8.$this_internalPerform
            androidx.room.InvalidationTracker r9 = r9.getInvalidationTracker()
            r9.refreshAsync()
        L_0x00ca:
            return r0
        L_0x00cb:
            return r9
        L_0x00cc:
            k3.l r9 = r8.$block$inlined
            r8.label = r2
            r1 = 6
            kotlin.jvm.internal.r.c(r1)
            java.lang.Object r9 = r9.invoke(r8)
            r1 = 7
            kotlin.jvm.internal.r.c(r1)
            if (r9 != r0) goto L_0x00df
        L_0x00de:
            return r0
        L_0x00df:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
