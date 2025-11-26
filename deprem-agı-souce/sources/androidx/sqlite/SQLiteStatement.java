package androidx.sqlite;

import androidx.annotation.IntRange;
import java.util.List;

public interface SQLiteStatement extends AutoCloseable {
    void bindBlob(@IntRange(from = 1) int i5, byte[] bArr);

    void bindBoolean(@IntRange(from = 1) int i5, boolean z4);

    void bindDouble(@IntRange(from = 1) int i5, double d5);

    void bindFloat(@IntRange(from = 1) int i5, float f5);

    void bindInt(@IntRange(from = 1) int i5, int i6);

    void bindLong(@IntRange(from = 1) int i5, long j5);

    void bindNull(@IntRange(from = 1) int i5);

    void bindText(@IntRange(from = 1) int i5, String str);

    void clearBindings();

    void close();

    byte[] getBlob(@IntRange(from = 0) int i5);

    boolean getBoolean(@IntRange(from = 0) int i5);

    int getColumnCount();

    String getColumnName(@IntRange(from = 0) int i5);

    List<String> getColumnNames();

    int getColumnType(@IntRange(from = 0) int i5);

    double getDouble(@IntRange(from = 0) int i5);

    float getFloat(@IntRange(from = 0) int i5);

    int getInt(@IntRange(from = 0) int i5);

    long getLong(@IntRange(from = 0) int i5);

    String getText(@IntRange(from = 0) int i5);

    boolean isNull(@IntRange(from = 0) int i5);

    void reset();

    boolean step();
}
