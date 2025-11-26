package androidx.room;

import W2.C2223l;
import W2.m;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class SharedSQLiteStatement {
    private final RoomDatabase database;
    private final AtomicBoolean lock = new AtomicBoolean(false);
    private final C2223l stmt$delegate = m.b(new q(this));

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        t.e(roomDatabase, "database");
        this.database = roomDatabase;
    }

    private final SupportSQLiteStatement createNewStatement() {
        return this.database.compileStatement(createQuery());
    }

    private final SupportSQLiteStatement getStmt() {
        return (SupportSQLiteStatement) this.stmt$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final SupportSQLiteStatement stmt_delegate$lambda$0(SharedSQLiteStatement sharedSQLiteStatement) {
        return sharedSQLiteStatement.createNewStatement();
    }

    public SupportSQLiteStatement acquire() {
        assertNotMainThread();
        return getStmt(this.lock.compareAndSet(false, true));
    }

    /* access modifiers changed from: protected */
    public void assertNotMainThread() {
        this.database.assertNotMainThread();
    }

    /* access modifiers changed from: protected */
    public abstract String createQuery();

    public void release(SupportSQLiteStatement supportSQLiteStatement) {
        t.e(supportSQLiteStatement, "statement");
        if (supportSQLiteStatement == getStmt()) {
            this.lock.set(false);
        }
    }

    private final SupportSQLiteStatement getStmt(boolean z4) {
        if (z4) {
            return getStmt();
        }
        return createNewStatement();
    }
}
