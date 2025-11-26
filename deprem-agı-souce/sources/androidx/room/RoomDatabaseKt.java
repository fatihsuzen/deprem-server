package androidx.room;

import b3.C2308e;
import java.util.Set;
import k3.l;
import k3.p;
import z3.C2972e;

public final class RoomDatabaseKt {
    public static final C2972e invalidationTrackerFlow(RoomDatabase roomDatabase, String[] strArr, boolean z4) {
        return RoomDatabaseKt__RoomDatabase_androidKt.invalidationTrackerFlow(roomDatabase, strArr, z4);
    }

    public static final <R> Object useReaderConnection(RoomDatabase roomDatabase, p pVar, C2308e eVar) {
        return RoomDatabaseKt__RoomDatabaseKt.useReaderConnection(roomDatabase, pVar, eVar);
    }

    public static final <R> Object useWriterConnection(RoomDatabase roomDatabase, p pVar, C2308e eVar) {
        return RoomDatabaseKt__RoomDatabaseKt.useWriterConnection(roomDatabase, pVar, eVar);
    }

    public static final void validateAutoMigrations(RoomDatabase roomDatabase, DatabaseConfiguration databaseConfiguration) {
        RoomDatabaseKt__RoomDatabaseKt.validateAutoMigrations(roomDatabase, databaseConfiguration);
    }

    public static final void validateMigrationsNotRequired(Set<Integer> set, Set<Integer> set2) {
        RoomDatabaseKt__RoomDatabaseKt.validateMigrationsNotRequired(set, set2);
    }

    public static final void validateTypeConverters(RoomDatabase roomDatabase, DatabaseConfiguration databaseConfiguration) {
        RoomDatabaseKt__RoomDatabaseKt.validateTypeConverters(roomDatabase, databaseConfiguration);
    }

    public static final <R> Object withTransaction(RoomDatabase roomDatabase, l lVar, C2308e eVar) {
        return RoomDatabaseKt__RoomDatabase_androidKt.withTransaction(roomDatabase, lVar, eVar);
    }

    public static final <R> Object withTransactionContext(RoomDatabase roomDatabase, l lVar, C2308e eVar) {
        return RoomDatabaseKt__RoomDatabase_androidKt.withTransactionContext(roomDatabase, lVar, eVar);
    }
}
