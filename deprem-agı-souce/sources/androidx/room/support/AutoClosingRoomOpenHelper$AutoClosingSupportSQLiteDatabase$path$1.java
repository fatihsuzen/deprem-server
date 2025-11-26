package androidx.room.support;

import androidx.sqlite.db.SupportSQLiteDatabase;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.E;

/* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1 extends E {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1() {
        super(SupportSQLiteDatabase.class, MBridgeConstans.DYNAMIC_VIEW_WX_PATH, "getPath()Ljava/lang/String;", 0);
    }

    public Object get(Object obj) {
        return ((SupportSQLiteDatabase) obj).getPath();
    }
}
