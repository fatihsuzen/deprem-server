package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.jvm.internal.t;

public final class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteStatement {
    private final SQLiteStatement delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteStatement(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        t.e(sQLiteStatement, "delegate");
        this.delegate = sQLiteStatement;
    }

    public void execute() {
        this.delegate.execute();
    }

    public long executeInsert() {
        return this.delegate.executeInsert();
    }

    public int executeUpdateDelete() {
        return this.delegate.executeUpdateDelete();
    }

    public long simpleQueryForLong() {
        return this.delegate.simpleQueryForLong();
    }

    public String simpleQueryForString() {
        return this.delegate.simpleQueryForString();
    }
}
