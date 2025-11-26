package androidx.sqlite.db.framework;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;

public final /* synthetic */ class g implements DatabaseErrorHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SupportSQLiteOpenHelper.Callback f479a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FrameworkSQLiteOpenHelper.DBRefHolder f480b;

    public /* synthetic */ g(SupportSQLiteOpenHelper.Callback callback, FrameworkSQLiteOpenHelper.DBRefHolder dBRefHolder) {
        this.f479a = callback;
        this.f480b = dBRefHolder;
    }

    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
        FrameworkSQLiteOpenHelper.OpenHelper._init_$lambda$0(this.f479a, this.f480b, sQLiteDatabase);
    }
}
