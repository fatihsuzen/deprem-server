package androidx.room;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.util.KClassUtil;
import k3.C2616a;
import kotlin.jvm.internal.t;

public final class Room$inMemoryDatabaseBuilder$1 implements C2616a {
    public static final Room$inMemoryDatabaseBuilder$1 INSTANCE = new Room$inMemoryDatabaseBuilder$1();

    static {
        t.j();
    }

    public final RoomDatabase invoke() {
        t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (RoomDatabase) KClassUtil.findAndInstantiateDatabaseImpl$default(RoomDatabase.class, (String) null, 2, (Object) null);
    }
}
