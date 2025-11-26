package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

public final /* synthetic */ class a implements SQLiteDatabase.CursorFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SupportSQLiteQuery f475a;

    public /* synthetic */ a(SupportSQLiteQuery supportSQLiteQuery) {
        this.f475a = supportSQLiteQuery;
    }

    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return FrameworkSQLiteDatabase.query$lambda$2(this.f475a, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }
}
