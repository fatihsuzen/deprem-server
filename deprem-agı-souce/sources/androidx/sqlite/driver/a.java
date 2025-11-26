package androidx.sqlite.driver;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.driver.AndroidSQLiteStatement;

public final /* synthetic */ class a implements SQLiteDatabase.CursorFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidSQLiteStatement.SelectAndroidSQLiteStatement f481a;

    public /* synthetic */ a(AndroidSQLiteStatement.SelectAndroidSQLiteStatement selectAndroidSQLiteStatement) {
        this.f481a = selectAndroidSQLiteStatement;
    }

    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return AndroidSQLiteStatement.SelectAndroidSQLiteStatement.ensureCursor$lambda$0(this.f481a, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }
}
