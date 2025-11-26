package androidx.room;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import k3.l;
import kotlin.jvm.internal.t;

public final class RoomConnectionManager$installOnOpenCallback$newCallbacks$1 extends RoomDatabase.Callback {
    final /* synthetic */ l $onOpen;

    RoomConnectionManager$installOnOpenCallback$newCallbacks$1(l lVar) {
        this.$onOpen = lVar;
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "db");
        this.$onOpen.invoke(supportSQLiteDatabase);
    }
}
