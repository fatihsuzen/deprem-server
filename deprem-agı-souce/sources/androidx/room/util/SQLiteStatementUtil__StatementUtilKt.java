package androidx.room.util;

import X2.C2250q;
import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteStatement;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import k3.l;
import kotlin.jvm.internal.t;

final /* synthetic */ class SQLiteStatementUtil__StatementUtilKt {
    public static final int columnIndexOfCommon(SQLiteStatement sQLiteStatement, String str) {
        t.e(sQLiteStatement, "<this>");
        t.e(str, RewardPlus.NAME);
        if (sQLiteStatement instanceof MappedColumnsSQLiteStatementWrapper) {
            return ((MappedColumnsSQLiteStatementWrapper) sQLiteStatement).getColumnIndex(str);
        }
        int columnCount = sQLiteStatement.getColumnCount();
        for (int i5 = 0; i5 < columnCount; i5++) {
            if (t.a(str, sQLiteStatement.getColumnName(i5))) {
                return i5;
            }
        }
        return -1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int getColumnIndex(SQLiteStatement sQLiteStatement, String str) {
        t.e(sQLiteStatement, "stmt");
        t.e(str, RewardPlus.NAME);
        return SQLiteStatementUtil.columnIndexOf(sQLiteStatement, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int getColumnIndexOrThrow(SQLiteStatement sQLiteStatement, String str) {
        t.e(sQLiteStatement, "stmt");
        t.e(str, RewardPlus.NAME);
        int columnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, str);
        if (columnIndexOf >= 0) {
            return columnIndexOf;
        }
        int columnCount = sQLiteStatement.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i5 = 0; i5 < columnCount; i5++) {
            arrayList.add(sQLiteStatement.getColumnName(i5));
        }
        String V4 = C2250q.V(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 63, (Object) null);
        throw new IllegalArgumentException("Column '" + str + "' does not exist. Available columns: [" + V4 + ']');
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final SQLiteStatement wrapMappedColumns(SQLiteStatement sQLiteStatement, String[] strArr, int[] iArr) {
        t.e(sQLiteStatement, "statement");
        t.e(strArr, "columnNames");
        t.e(iArr, "mapping");
        return new MappedColumnsSQLiteStatementWrapper(sQLiteStatement, strArr, iArr);
    }
}
