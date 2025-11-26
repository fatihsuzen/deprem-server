package androidx.room.support;

import androidx.sqlite.db.SupportSQLiteDatabase;
import k3.l;
import kotlin.jvm.internal.C2639q;
import kotlin.jvm.internal.t;

/* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1 extends C2639q implements l {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1() {
        super(1, SupportSQLiteDatabase.class, "inTransaction", "inTransaction()Z", 0);
    }

    public final Boolean invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "p0");
        return Boolean.valueOf(supportSQLiteDatabase.inTransaction());
    }
}
