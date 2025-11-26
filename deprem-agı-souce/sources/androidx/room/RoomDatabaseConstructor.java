package androidx.room;

import androidx.room.RoomDatabase;

public interface RoomDatabaseConstructor<T extends RoomDatabase> {
    T initialize();
}
