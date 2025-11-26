package androidx.room;

import W2.J;
import androidx.room.Transactor;
import androidx.sqlite.SQLiteStatement;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.jvm.internal.t;

public final class TransactorKt {
    public static final <R> Object deferredTransaction(Transactor transactor, p pVar, C2308e eVar) {
        return transactor.withTransaction(Transactor.SQLiteTransactionType.DEFERRED, pVar, eVar);
    }

    public static final <R> Object exclusiveTransaction(Transactor transactor, p pVar, C2308e eVar) {
        return transactor.withTransaction(Transactor.SQLiteTransactionType.EXCLUSIVE, pVar, eVar);
    }

    public static final Object execSQL(PooledConnection pooledConnection, String str, C2308e eVar) {
        Object usePrepared = pooledConnection.usePrepared(str, new s(), eVar);
        if (usePrepared == C2316b.f()) {
            return usePrepared;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final boolean execSQL$lambda$0(SQLiteStatement sQLiteStatement) {
        t.e(sQLiteStatement, "it");
        return sQLiteStatement.step();
    }

    public static final <R> Object immediateTransaction(Transactor transactor, p pVar, C2308e eVar) {
        return transactor.withTransaction(Transactor.SQLiteTransactionType.IMMEDIATE, pVar, eVar);
    }
}
