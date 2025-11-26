package androidx.room.util;

import android.database.Cursor;
import android.database.CursorWrapper;
import kotlin.jvm.internal.t;
import t3.s;

public final class CursorUtil$wrapMappedColumns$2 extends CursorWrapper {
    final /* synthetic */ String[] $columnNames;
    final /* synthetic */ int[] $mapping;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CursorUtil$wrapMappedColumns$2(Cursor cursor, String[] strArr, int[] iArr) {
        super(cursor);
        this.$columnNames = strArr;
        this.$mapping = iArr;
    }

    public int getColumnIndex(String str) {
        t.e(str, "columnName");
        String[] strArr = this.$columnNames;
        int[] iArr = this.$mapping;
        int length = strArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7 = i6 + 1;
            if (s.E(strArr[i5], str, true)) {
                return iArr[i6];
            }
            i5++;
            i6 = i7;
        }
        return super.getColumnIndex(str);
    }
}
