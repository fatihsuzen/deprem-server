package androidx.room.util;

import W2.J;
import androidx.room.RoomDatabase;
import androidx.room.Transactor;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1", f = "DBUtil.android.kt", l = {56, 57, 59, 60}, m = "invokeSuspend")
public final class DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 extends l implements p {
    final /* synthetic */ k3.l $block$inlined;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ boolean $isReadOnly;
    final /* synthetic */ RoomDatabase $this_internalPerform;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1(boolean z4, boolean z5, RoomDatabase roomDatabase, C2308e eVar, k3.l lVar) {
        super(2, eVar);
        this.$inTransaction = z4;
        this.$isReadOnly = z5;
        this.$this_internalPerform = roomDatabase;
        this.$block$inlined = lVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1(this.$inTransaction, this.$isReadOnly, this.$this_internalPerform, eVar, this.$block$inlined);
        dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1.L$0 = obj;
        return dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1;
    }

    public final Object invoke(Transactor transactor, C2308e eVar) {
        return ((DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1) create(transactor, eVar)).invokeSuspend(J.f19942a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009f, code lost:
        if (r8 != r0) goto L_0x00a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r7.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0044
            if (r1 == r5) goto L_0x0038
            if (r1 == r4) goto L_0x002c
            if (r1 == r3) goto L_0x0023
            if (r1 != r2) goto L_0x001b
            java.lang.Object r0 = r7.L$0
            W2.u.b(r8)
            goto L_0x00b3
        L_0x001b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0023:
            java.lang.Object r1 = r7.L$0
            androidx.room.Transactor r1 = (androidx.room.Transactor) r1
            W2.u.b(r8)
            goto L_0x00a2
        L_0x002c:
            java.lang.Object r1 = r7.L$1
            androidx.room.Transactor$SQLiteTransactionType r1 = (androidx.room.Transactor.SQLiteTransactionType) r1
            java.lang.Object r4 = r7.L$0
            androidx.room.Transactor r4 = (androidx.room.Transactor) r4
            W2.u.b(r8)
            goto L_0x0086
        L_0x0038:
            java.lang.Object r1 = r7.L$1
            androidx.room.Transactor$SQLiteTransactionType r1 = (androidx.room.Transactor.SQLiteTransactionType) r1
            java.lang.Object r5 = r7.L$0
            androidx.room.Transactor r5 = (androidx.room.Transactor) r5
            W2.u.b(r8)
            goto L_0x006a
        L_0x0044:
            W2.u.b(r8)
            java.lang.Object r8 = r7.L$0
            androidx.room.Transactor r8 = (androidx.room.Transactor) r8
            boolean r1 = r7.$inTransaction
            if (r1 == 0) goto L_0x00c6
            boolean r1 = r7.$isReadOnly
            if (r1 == 0) goto L_0x0056
            androidx.room.Transactor$SQLiteTransactionType r6 = androidx.room.Transactor.SQLiteTransactionType.DEFERRED
            goto L_0x0058
        L_0x0056:
            androidx.room.Transactor$SQLiteTransactionType r6 = androidx.room.Transactor.SQLiteTransactionType.IMMEDIATE
        L_0x0058:
            if (r1 != 0) goto L_0x008c
            r7.L$0 = r8
            r7.L$1 = r6
            r7.label = r5
            java.lang.Object r1 = r8.inTransaction(r7)
            if (r1 != r0) goto L_0x0067
            goto L_0x00b0
        L_0x0067:
            r5 = r8
            r8 = r1
            r1 = r6
        L_0x006a:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x0089
            androidx.room.RoomDatabase r8 = r7.$this_internalPerform
            androidx.room.InvalidationTracker r8 = r8.getInvalidationTracker()
            r7.L$0 = r5
            r7.L$1 = r1
            r7.label = r4
            java.lang.Object r8 = r8.sync$room_runtime_release(r7)
            if (r8 != r0) goto L_0x0085
            goto L_0x00b0
        L_0x0085:
            r4 = r5
        L_0x0086:
            r6 = r1
            r1 = r4
            goto L_0x008d
        L_0x0089:
            r6 = r1
            r1 = r5
            goto L_0x008d
        L_0x008c:
            r1 = r8
        L_0x008d:
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1$1 r8 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1$1
            k3.l r4 = r7.$block$inlined
            r5 = 0
            r8.<init>(r5, r4)
            r7.L$0 = r1
            r7.L$1 = r5
            r7.label = r3
            java.lang.Object r8 = r1.withTransaction(r6, r8, r7)
            if (r8 != r0) goto L_0x00a2
            goto L_0x00b0
        L_0x00a2:
            boolean r3 = r7.$isReadOnly
            if (r3 != 0) goto L_0x00c5
            r7.L$0 = r8
            r7.label = r2
            java.lang.Object r1 = r1.inTransaction(r7)
            if (r1 != r0) goto L_0x00b1
        L_0x00b0:
            return r0
        L_0x00b1:
            r0 = r8
            r8 = r1
        L_0x00b3:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x00c4
            androidx.room.RoomDatabase r8 = r7.$this_internalPerform
            androidx.room.InvalidationTracker r8 = r8.getInvalidationTracker()
            r8.refreshAsync()
        L_0x00c4:
            return r0
        L_0x00c5:
            return r8
        L_0x00c6:
            java.lang.String r0 = "null cannot be cast to non-null type androidx.room.coroutines.RawConnectionAccessor"
            kotlin.jvm.internal.t.c(r8, r0)
            androidx.room.coroutines.RawConnectionAccessor r8 = (androidx.room.coroutines.RawConnectionAccessor) r8
            androidx.sqlite.SQLiteConnection r8 = r8.getRawConnection()
            k3.l r0 = r7.$block$inlined
            java.lang.Object r8 = r0.invoke(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
