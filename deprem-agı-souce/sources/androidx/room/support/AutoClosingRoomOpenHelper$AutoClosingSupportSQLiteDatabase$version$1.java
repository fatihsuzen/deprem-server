package androidx.room.support;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.y;

/* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1 extends y {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1() {
        super(SupportSQLiteDatabase.class, "version", "getVersion()I", 0);
    }

    public Object get(Object obj) {
        return Integer.valueOf(((SupportSQLiteDatabase) obj).getVersion());
    }

    public void set(Object obj, Object obj2) {
        ((SupportSQLiteDatabase) obj).setVersion(((Number) obj2).intValue());
    }
}
