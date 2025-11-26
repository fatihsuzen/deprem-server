package z;

import android.database.sqlite.SQLiteDatabase;
import z.W;

public final /* synthetic */ class Q implements W.a {
    public final void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
