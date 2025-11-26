package k;

import android.database.sqlite.SQLiteTransactionListener;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.t;

public abstract /* synthetic */ class a {
    public static void a(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.beginTransaction();
    }

    public static void b(SupportSQLiteDatabase supportSQLiteDatabase, SQLiteTransactionListener sQLiteTransactionListener) {
        t.e(sQLiteTransactionListener, "transactionListener");
        supportSQLiteDatabase.beginTransactionWithListener(sQLiteTransactionListener);
    }

    public static void c(SupportSQLiteDatabase supportSQLiteDatabase, String str, Object[] objArr) {
        t.e(str, "sql");
        throw new UnsupportedOperationException();
    }

    public static boolean d(SupportSQLiteDatabase supportSQLiteDatabase) {
        return false;
    }
}
