package androidx.sqlite.driver;

import android.database.sqlite.SQLiteDatabase;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import kotlin.jvm.internal.t;

public final class AndroidSQLiteDriver implements SQLiteDriver {
    public SQLiteConnection open(String str) {
        t.e(str, "fileName");
        SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(str, (SQLiteDatabase.CursorFactory) null);
        t.b(openOrCreateDatabase);
        return new AndroidSQLiteConnection(openOrCreateDatabase);
    }
}
