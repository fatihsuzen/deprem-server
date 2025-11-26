package androidx.sqlite;

import android.database.SQLException;

public final class SQLite {
    public static final int SQLITE_DATA_BLOB = 4;
    public static final int SQLITE_DATA_FLOAT = 2;
    public static final int SQLITE_DATA_INTEGER = 1;
    public static final int SQLITE_DATA_NULL = 5;
    public static final int SQLITE_DATA_TEXT = 3;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        i3.C2579a.a(r1, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void execSQL(androidx.sqlite.SQLiteConnection r1, java.lang.String r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.t.e(r1, r0)
            java.lang.String r0 = "sql"
            kotlin.jvm.internal.t.e(r2, r0)
            androidx.sqlite.SQLiteStatement r1 = r1.prepare(r2)
            r1.step()     // Catch:{ all -> 0x0016 }
            r2 = 0
            i3.C2579a.a(r1, r2)
            return
        L_0x0016:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0018 }
        L_0x0018:
            r0 = move-exception
            i3.C2579a.a(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.SQLite.execSQL(androidx.sqlite.SQLiteConnection, java.lang.String):void");
    }

    public static final Void throwSQLiteException(int i5, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error code: " + i5);
        if (str != null) {
            sb.append(", message: " + str);
        }
        throw new SQLException(sb.toString());
    }
}
