package androidx.room.support;

import androidx.room.DelegatingOpenHelper;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import kotlin.jvm.internal.t;
import w3.M;

public final class QueryInterceptorOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    private final SupportSQLiteOpenHelper delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final M queryCallbackScope;

    public QueryInterceptorOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper, M m5, RoomDatabase.QueryCallback queryCallback2) {
        t.e(supportSQLiteOpenHelper, "delegate");
        t.e(m5, "queryCallbackScope");
        t.e(queryCallback2, "queryCallback");
        this.delegate = supportSQLiteOpenHelper;
        this.queryCallbackScope = m5;
        this.queryCallback = queryCallback2;
    }

    public void close() {
        this.delegate.close();
    }

    public String getDatabaseName() {
        return this.delegate.getDatabaseName();
    }

    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        return new QueryInterceptorDatabase(getDelegate().getReadableDatabase(), this.queryCallbackScope, this.queryCallback);
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        return new QueryInterceptorDatabase(getDelegate().getWritableDatabase(), this.queryCallbackScope, this.queryCallback);
    }

    public void setWriteAheadLoggingEnabled(boolean z4) {
        this.delegate.setWriteAheadLoggingEnabled(z4);
    }
}
