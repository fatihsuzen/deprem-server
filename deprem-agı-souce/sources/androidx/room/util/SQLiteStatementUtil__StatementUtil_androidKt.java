package androidx.room.util;

import android.os.Build;
import androidx.sqlite.SQLiteStatement;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.t;
import t3.s;

final /* synthetic */ class SQLiteStatementUtil__StatementUtil_androidKt {
    public static final int columnIndexOf(SQLiteStatement sQLiteStatement, String str) {
        t.e(sQLiteStatement, "<this>");
        t.e(str, RewardPlus.NAME);
        int columnIndexOfCommon = SQLiteStatementUtil.columnIndexOfCommon(sQLiteStatement, str);
        if (columnIndexOfCommon >= 0) {
            return columnIndexOfCommon;
        }
        int columnIndexOfCommon2 = SQLiteStatementUtil.columnIndexOfCommon(sQLiteStatement, '`' + str + '`');
        if (columnIndexOfCommon2 >= 0) {
            return columnIndexOfCommon2;
        }
        return findColumnIndexBySuffix$SQLiteStatementUtil__StatementUtil_androidKt(sQLiteStatement, str);
    }

    private static final int findColumnIndexBySuffix$SQLiteStatementUtil__StatementUtil_androidKt(SQLiteStatement sQLiteStatement, String str) {
        if (Build.VERSION.SDK_INT <= 25 && str.length() != 0) {
            int columnCount = sQLiteStatement.getColumnCount();
            String str2 = '.' + str;
            String str3 = '.' + str + '`';
            for (int i5 = 0; i5 < columnCount; i5++) {
                String columnName = sQLiteStatement.getColumnName(i5);
                if (columnName.length() >= str.length() + 2 && (s.D(columnName, str2, false, 2, (Object) null) || (columnName.charAt(0) == '`' && s.D(columnName, str3, false, 2, (Object) null)))) {
                    return i5;
                }
            }
        }
        return -1;
    }
}
