package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import k3.r;

public final /* synthetic */ class b implements r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SupportSQLiteQuery f476a;

    public /* synthetic */ b(SupportSQLiteQuery supportSQLiteQuery) {
        this.f476a = supportSQLiteQuery;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return FrameworkSQLiteDatabase.query$lambda$0(this.f476a, (SQLiteDatabase) obj, (SQLiteCursorDriver) obj2, (String) obj3, (SQLiteQuery) obj4);
    }
}
