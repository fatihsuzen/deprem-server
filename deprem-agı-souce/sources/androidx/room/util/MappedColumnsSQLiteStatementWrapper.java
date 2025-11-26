package androidx.room.util;

import X2.M;
import androidx.annotation.IntRange;
import androidx.sqlite.SQLiteStatement;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;

public final class MappedColumnsSQLiteStatementWrapper implements SQLiteStatement {
    private final Map<String, Integer> columnNameToIndexMap;
    private final String[] columnNames;
    private final SQLiteStatement delegate;
    private final int[] mapping;

    public MappedColumnsSQLiteStatementWrapper(SQLiteStatement sQLiteStatement, String[] strArr, int[] iArr) {
        t.e(sQLiteStatement, "delegate");
        t.e(strArr, "columnNames");
        t.e(iArr, "mapping");
        this.delegate = sQLiteStatement;
        this.columnNames = strArr;
        this.mapping = iArr;
        if (strArr.length == iArr.length) {
            Map c5 = M.c();
            int length = strArr.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                c5.put(strArr[i5], Integer.valueOf(this.mapping[i6]));
                i5++;
                i6++;
            }
            int columnCount = getColumnCount();
            for (int i7 = 0; i7 < columnCount; i7++) {
                if (!c5.containsKey(getColumnName(i7))) {
                    c5.put(getColumnName(i7), Integer.valueOf(i7));
                }
            }
            this.columnNameToIndexMap = M.b(c5);
            return;
        }
        throw new IllegalArgumentException("Expected columnNames.size == mapping.size");
    }

    public void bindBlob(@IntRange(from = 1) int i5, byte[] bArr) {
        t.e(bArr, "value");
        this.delegate.bindBlob(i5, bArr);
    }

    public void bindBoolean(@IntRange(from = 1) int i5, boolean z4) {
        this.delegate.bindBoolean(i5, z4);
    }

    public void bindDouble(@IntRange(from = 1) int i5, double d5) {
        this.delegate.bindDouble(i5, d5);
    }

    public void bindFloat(@IntRange(from = 1) int i5, float f5) {
        this.delegate.bindFloat(i5, f5);
    }

    public void bindInt(@IntRange(from = 1) int i5, int i6) {
        this.delegate.bindInt(i5, i6);
    }

    public void bindLong(@IntRange(from = 1) int i5, long j5) {
        this.delegate.bindLong(i5, j5);
    }

    public void bindNull(@IntRange(from = 1) int i5) {
        this.delegate.bindNull(i5);
    }

    public void bindText(@IntRange(from = 1) int i5, String str) {
        t.e(str, "value");
        this.delegate.bindText(i5, str);
    }

    public void clearBindings() {
        this.delegate.clearBindings();
    }

    public void close() {
        this.delegate.close();
    }

    public byte[] getBlob(@IntRange(from = 0) int i5) {
        return this.delegate.getBlob(i5);
    }

    public boolean getBoolean(@IntRange(from = 0) int i5) {
        return this.delegate.getBoolean(i5);
    }

    public int getColumnCount() {
        return this.delegate.getColumnCount();
    }

    public final int getColumnIndex(String str) {
        t.e(str, RewardPlus.NAME);
        Integer num = this.columnNameToIndexMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public String getColumnName(@IntRange(from = 0) int i5) {
        return this.delegate.getColumnName(i5);
    }

    public List<String> getColumnNames() {
        return this.delegate.getColumnNames();
    }

    public int getColumnType(@IntRange(from = 0) int i5) {
        return this.delegate.getColumnType(i5);
    }

    public double getDouble(@IntRange(from = 0) int i5) {
        return this.delegate.getDouble(i5);
    }

    public float getFloat(@IntRange(from = 0) int i5) {
        return this.delegate.getFloat(i5);
    }

    public int getInt(@IntRange(from = 0) int i5) {
        return this.delegate.getInt(i5);
    }

    public long getLong(@IntRange(from = 0) int i5) {
        return this.delegate.getLong(i5);
    }

    public String getText(@IntRange(from = 0) int i5) {
        return this.delegate.getText(i5);
    }

    public boolean isNull(@IntRange(from = 0) int i5) {
        return this.delegate.isNull(i5);
    }

    public void reset() {
        this.delegate.reset();
    }

    public boolean step() {
        return this.delegate.step();
    }
}
