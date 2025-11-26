package androidx.sqlite.db;

import java.io.Closeable;

public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int i5, byte[] bArr);

    void bindDouble(int i5, double d5);

    void bindLong(int i5, long j5);

    void bindNull(int i5);

    void bindString(int i5, String str);

    void clearBindings();
}
