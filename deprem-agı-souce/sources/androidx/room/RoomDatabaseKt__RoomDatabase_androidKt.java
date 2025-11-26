package androidx.room;

import b3.C2308e;
import b3.C2309f;
import b3.C2312i;
import c3.C2316b;
import java.util.Arrays;
import java.util.concurrent.RejectedExecutionException;
import k3.l;
import k3.p;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.t;
import w3.C2872g;
import w3.C2886n;
import w3.V0;
import z3.C2972e;

final /* synthetic */ class RoomDatabaseKt__RoomDatabase_androidKt {
    /* access modifiers changed from: private */
    public static final C2312i createTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt(RoomDatabase roomDatabase, C2309f fVar) {
        TransactionElement transactionElement = new TransactionElement(fVar);
        return fVar.plus(transactionElement).plus(V0.a(roomDatabase.getSuspendingTransactionId(), Integer.valueOf(System.identityHashCode(transactionElement))));
    }

    public static final C2972e invalidationTrackerFlow(RoomDatabase roomDatabase, String[] strArr, boolean z4) {
        t.e(roomDatabase, "<this>");
        t.e(strArr, "tables");
        return roomDatabase.getInvalidationTracker().createFlow((String[]) Arrays.copyOf(strArr, strArr.length), z4);
    }

    public static /* synthetic */ C2972e invalidationTrackerFlow$default(RoomDatabase roomDatabase, String[] strArr, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = true;
        }
        return RoomDatabaseKt.invalidationTrackerFlow(roomDatabase, strArr, z4);
    }

    /* access modifiers changed from: private */
    public static final <R> Object startTransactionCoroutine$RoomDatabaseKt__RoomDatabase_androidKt(RoomDatabase roomDatabase, C2312i iVar, p pVar, C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        try {
            roomDatabase.getTransactionExecutor().execute(new RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1(iVar, nVar, roomDatabase, pVar));
        } catch (RejectedExecutionException e5) {
            nVar.k(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e5));
        }
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        return x4;
    }

    public static final <R> Object withTransaction(RoomDatabase roomDatabase, l lVar, C2308e eVar) {
        return RoomDatabaseKt.withTransactionContext(roomDatabase, new RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2(roomDatabase, lVar, (C2308e) null), eVar);
    }

    public static final <R> Object withTransactionContext(RoomDatabase roomDatabase, l lVar, C2308e eVar) {
        C2309f fVar = null;
        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(lVar, (C2308e) null);
        TransactionElement transactionElement = (TransactionElement) eVar.getContext().get(TransactionElement.Key);
        if (transactionElement != null) {
            fVar = transactionElement.getTransactionDispatcher$room_runtime_release();
        }
        if (fVar != null) {
            return C2872g.g(fVar, roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, eVar);
        }
        return startTransactionCoroutine$RoomDatabaseKt__RoomDatabase_androidKt(roomDatabase, eVar.getContext(), roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, eVar);
    }
}
