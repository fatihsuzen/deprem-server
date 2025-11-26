package androidx.room.util;

import X2.C2242i;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.EnvironmentCompat;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import h3.C2453b;
import k3.l;
import kotlin.jvm.internal.t;
import t3.s;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class CursorUtil {
    public static final Cursor copyAndClose(Cursor cursor) {
        t.e(cursor, "c");
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                int columnCount = cursor.getColumnCount();
                for (int i5 = 0; i5 < columnCount; i5++) {
                    int type = cursor.getType(i5);
                    if (type == 0) {
                        objArr[i5] = null;
                    } else if (type == 1) {
                        objArr[i5] = Long.valueOf(cursor.getLong(i5));
                    } else if (type == 2) {
                        objArr[i5] = Double.valueOf(cursor.getDouble(i5));
                    } else if (type == 3) {
                        objArr[i5] = cursor.getString(i5);
                    } else if (type == 4) {
                        objArr[i5] = cursor.getBlob(i5);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                matrixCursor.addRow(objArr);
            }
            C2453b.a(cursor, (Throwable) null);
            return matrixCursor;
        } catch (Throwable th) {
            C2453b.a(cursor, th);
            throw th;
        }
    }

    private static final int findColumnIndexBySuffix(Cursor cursor, String str) {
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        String[] columnNames = cursor.getColumnNames();
        t.b(columnNames);
        return findColumnIndexBySuffix(columnNames, str);
    }

    public static final int getColumnIndex(Cursor cursor, String str) {
        t.e(cursor, "c");
        t.e(str, RewardPlus.NAME);
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex('`' + str + '`');
        if (columnIndex2 >= 0) {
            return columnIndex2;
        }
        return findColumnIndexBySuffix(cursor, str);
    }

    public static final int getColumnIndexOrThrow(Cursor cursor, String str) {
        String str2;
        t.e(cursor, "c");
        t.e(str, RewardPlus.NAME);
        int columnIndex = getColumnIndex(cursor, str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            t.d(columnNames, "getColumnNames(...)");
            str2 = C2242i.e0(columnNames, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 63, (Object) null);
        } catch (Exception e5) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e5);
            str2 = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        kotlin.jvm.internal.r.b(1);
        h3.C2453b.a(r2, r3);
        kotlin.jvm.internal.r.a(1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <R> R useCursor(android.database.Cursor r2, k3.l r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.t.e(r2, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.t.e(r3, r0)
            r0 = 1
            java.lang.Object r3 = r3.invoke(r2)     // Catch:{ all -> 0x001a }
            kotlin.jvm.internal.r.b(r0)
            r1 = 0
            h3.C2453b.a(r2, r1)
            kotlin.jvm.internal.r.a(r0)
            return r3
        L_0x001a:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x001c }
        L_0x001c:
            r1 = move-exception
            kotlin.jvm.internal.r.b(r0)
            h3.C2453b.a(r2, r3)
            kotlin.jvm.internal.r.a(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.CursorUtil.useCursor(android.database.Cursor, k3.l):java.lang.Object");
    }

    public static final Cursor wrapMappedColumns(Cursor cursor, String[] strArr, int[] iArr) {
        t.e(cursor, "cursor");
        t.e(strArr, "columnNames");
        t.e(iArr, "mapping");
        if (strArr.length == iArr.length) {
            return new CursorUtil$wrapMappedColumns$2(cursor, strArr, iArr);
        }
        throw new IllegalStateException("Expected columnNames.length == mapping.length");
    }

    @VisibleForTesting
    public static final int findColumnIndexBySuffix(String[] strArr, String str) {
        t.e(strArr, "columnNames");
        t.e(str, RewardPlus.NAME);
        String str2 = '.' + str;
        String str3 = '.' + str + '`';
        int length = strArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            String str4 = strArr[i5];
            int i7 = i6 + 1;
            if (str4.length() >= str.length() + 2 && (s.D(str4, str2, false, 2, (Object) null) || (str4.charAt(0) == '`' && s.D(str4, str3, false, 2, (Object) null)))) {
                return i6;
            }
            i5++;
            i6 = i7;
        }
        return -1;
    }
}
