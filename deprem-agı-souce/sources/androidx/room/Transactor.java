package androidx.room;

import b3.C2308e;
import d3.C2344a;
import d3.C2345b;
import k3.p;

public interface Transactor extends PooledConnection {

    public enum SQLiteTransactionType {
        DEFERRED,
        IMMEDIATE,
        EXCLUSIVE;

        static {
            SQLiteTransactionType[] $values;
            $ENTRIES = C2345b.a($values);
        }

        public static C2344a getEntries() {
            return $ENTRIES;
        }
    }

    Object inTransaction(C2308e eVar);

    <R> Object withTransaction(SQLiteTransactionType sQLiteTransactionType, p pVar, C2308e eVar);
}
