package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;
import kotlin.jvm.internal.t;

public class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    private final SQLiteProgram delegate;

    public FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        t.e(sQLiteProgram, "delegate");
        this.delegate = sQLiteProgram;
    }

    public void bindBlob(int i5, byte[] bArr) {
        t.e(bArr, "value");
        this.delegate.bindBlob(i5, bArr);
    }

    public void bindDouble(int i5, double d5) {
        this.delegate.bindDouble(i5, d5);
    }

    public void bindLong(int i5, long j5) {
        this.delegate.bindLong(i5, j5);
    }

    public void bindNull(int i5) {
        this.delegate.bindNull(i5);
    }

    public void bindString(int i5, String str) {
        t.e(str, "value");
        this.delegate.bindString(i5, str);
    }

    public void clearBindings() {
        this.delegate.clearBindings();
    }

    public void close() {
        this.delegate.close();
    }
}
