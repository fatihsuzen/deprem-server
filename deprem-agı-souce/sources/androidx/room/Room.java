package androidx.room;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomDatabase;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import k3.C2616a;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import t3.s;

public final class Room {
    public static final Room INSTANCE = new Room();
    public static final String LOG_TAG = "ROOM";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    private Room() {
    }

    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context context, Class<T> cls, String str) {
        t.e(context, "context");
        t.e(cls, "klass");
        if (str == null || s.h0(str)) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        } else if (!t.a(str, ":memory:")) {
            return new RoomDatabase.Builder<>(context, cls, str);
        } else {
            throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
    }

    public static /* synthetic */ RoomDatabase.Builder databaseBuilder$default(Room room, Context context, String str, C2616a aVar, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            t.j();
            aVar = Room$databaseBuilder$3.INSTANCE;
        }
        t.e(context, "context");
        t.e(str, RewardPlus.NAME);
        t.e(aVar, "factory");
        if (s.h0(str)) {
            throw new IllegalArgumentException("Cannot build a database with empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
        } else if (!t.a(str, ":memory:")) {
            t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
            return new RoomDatabase.Builder(M.b(RoomDatabase.class), str, aVar, context);
        } else {
            throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
        }
    }

    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context context, Class<T> cls) {
        t.e(context, "context");
        t.e(cls, "klass");
        return new RoomDatabase.Builder<>(context, cls, (String) null);
    }

    public static /* synthetic */ RoomDatabase.Builder inMemoryDatabaseBuilder$default(Room room, Context context, C2616a aVar, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            t.j();
            aVar = Room$inMemoryDatabaseBuilder$1.INSTANCE;
        }
        t.e(context, "context");
        t.e(aVar, "factory");
        t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new RoomDatabase.Builder(M.b(RoomDatabase.class), (String) null, aVar, context);
    }

    public final /* synthetic */ <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context context, C2616a aVar) {
        t.e(context, "context");
        t.e(aVar, "factory");
        t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new RoomDatabase.Builder<>(M.b(RoomDatabase.class), (String) null, aVar, context);
    }

    public final /* synthetic */ <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context context, String str, C2616a aVar) {
        t.e(context, "context");
        t.e(str, RewardPlus.NAME);
        t.e(aVar, "factory");
        if (s.h0(str)) {
            throw new IllegalArgumentException("Cannot build a database with empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
        } else if (!t.a(str, ":memory:")) {
            t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
            return new RoomDatabase.Builder<>(M.b(RoomDatabase.class), str, aVar, context);
        } else {
            throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
        }
    }
}
