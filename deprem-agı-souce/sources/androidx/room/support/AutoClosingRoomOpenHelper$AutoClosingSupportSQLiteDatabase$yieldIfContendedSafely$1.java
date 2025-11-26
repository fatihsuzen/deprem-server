package androidx.room.support;

import androidx.sqlite.db.SupportSQLiteDatabase;
import k3.l;
import kotlin.jvm.internal.C2639q;
import kotlin.jvm.internal.t;

/* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1 extends C2639q implements l {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1() {
        super(1, SupportSQLiteDatabase.class, "yieldIfContendedSafely", "yieldIfContendedSafely()Z", 0);
    }

    public final Boolean invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "p0");
        return Boolean.valueOf(supportSQLiteDatabase.yieldIfContendedSafely());
    }
}
