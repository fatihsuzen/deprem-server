package z;

import android.database.sqlite.SQLiteDatabase;
import z.W;

public final /* synthetic */ class U implements W.a {
    public final void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN product_id INTEGER");
    }
}
