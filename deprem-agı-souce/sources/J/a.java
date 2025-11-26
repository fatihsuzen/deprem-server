package j;

import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public abstract /* synthetic */ class a {
    public static void a(SQLiteStatement sQLiteStatement, int i5, boolean z4) {
        long j5;
        if (z4) {
            j5 = 1;
        } else {
            j5 = 0;
        }
        sQLiteStatement.bindLong(i5, j5);
    }

    public static void b(SQLiteStatement sQLiteStatement, int i5, float f5) {
        sQLiteStatement.bindDouble(i5, (double) f5);
    }

    public static void c(SQLiteStatement sQLiteStatement, int i5, int i6) {
        sQLiteStatement.bindLong(i5, (long) i6);
    }

    public static boolean d(SQLiteStatement sQLiteStatement, int i5) {
        if (sQLiteStatement.getLong(i5) != 0) {
            return true;
        }
        return false;
    }

    public static List e(SQLiteStatement sQLiteStatement) {
        int columnCount = sQLiteStatement.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i5 = 0; i5 < columnCount; i5++) {
            arrayList.add(sQLiteStatement.getColumnName(i5));
        }
        return arrayList;
    }

    public static float f(SQLiteStatement sQLiteStatement, int i5) {
        return (float) sQLiteStatement.getDouble(i5);
    }

    public static int g(SQLiteStatement sQLiteStatement, int i5) {
        return (int) sQLiteStatement.getLong(i5);
    }
}
