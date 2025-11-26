package androidx.room.support;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.y;

/* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1 extends y {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1() {
        super(SupportSQLiteDatabase.class, "pageSize", "getPageSize()J", 0);
    }

    public Object get(Object obj) {
        return Long.valueOf(((SupportSQLiteDatabase) obj).getPageSize());
    }

    public void set(Object obj, Object obj2) {
        ((SupportSQLiteDatabase) obj).setPageSize(((Number) obj2).longValue());
    }
}
