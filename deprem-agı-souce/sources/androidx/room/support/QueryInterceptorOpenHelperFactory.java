package androidx.room.support;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import kotlin.jvm.internal.t;
import w3.M;

public final class QueryInterceptorOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final SupportSQLiteOpenHelper.Factory delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final M queryCallbackScope;

    public QueryInterceptorOpenHelperFactory(SupportSQLiteOpenHelper.Factory factory, M m5, RoomDatabase.QueryCallback queryCallback2) {
        t.e(factory, "delegate");
        t.e(m5, "queryCallbackScope");
        t.e(queryCallback2, "queryCallback");
        this.delegate = factory;
        this.queryCallbackScope = m5;
        this.queryCallback = queryCallback2;
    }

    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        t.e(configuration, "configuration");
        return new QueryInterceptorOpenHelper(this.delegate.create(configuration), this.queryCallbackScope, this.queryCallback);
    }
}
