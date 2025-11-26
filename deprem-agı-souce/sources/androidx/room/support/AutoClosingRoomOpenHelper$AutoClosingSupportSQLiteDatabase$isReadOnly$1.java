package androidx.room.support;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.E;

/* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1 extends E {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1() {
        super(SupportSQLiteDatabase.class, "isReadOnly", "isReadOnly()Z", 0);
    }

    public Object get(Object obj) {
        return Boolean.valueOf(((SupportSQLiteDatabase) obj).isReadOnly());
    }
}
