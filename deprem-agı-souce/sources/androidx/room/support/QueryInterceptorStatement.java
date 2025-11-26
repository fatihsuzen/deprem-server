package androidx.room.support;

import X2.C2250q;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import b3.C2308e;
import b3.C2312i;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import w3.C2908y0;
import w3.M;
import w3.O;

public final class QueryInterceptorStatement implements SupportSQLiteStatement {
    private final List<Object> bindArgsCache = new ArrayList();
    private final SupportSQLiteStatement delegate;
    /* access modifiers changed from: private */
    public final RoomDatabase.QueryCallback queryCallback;
    private final M queryCallbackScope;
    /* access modifiers changed from: private */
    public final String sqlStatement;

    public QueryInterceptorStatement(SupportSQLiteStatement supportSQLiteStatement, String str, M m5, RoomDatabase.QueryCallback queryCallback2) {
        t.e(supportSQLiteStatement, "delegate");
        t.e(str, "sqlStatement");
        t.e(m5, "queryCallbackScope");
        t.e(queryCallback2, "queryCallback");
        this.delegate = supportSQLiteStatement;
        this.sqlStatement = str;
        this.queryCallbackScope = m5;
        this.queryCallback = queryCallback2;
    }

    private final void saveArgsToCache(int i5, Object obj) {
        int i6 = i5 - 1;
        if (i6 >= this.bindArgsCache.size()) {
            int size = (i6 - this.bindArgsCache.size()) + 1;
            for (int i7 = 0; i7 < size; i7++) {
                this.bindArgsCache.add((Object) null);
            }
        }
        this.bindArgsCache.set(i6, obj);
    }

    public void bindBlob(int i5, byte[] bArr) {
        t.e(bArr, "value");
        saveArgsToCache(i5, bArr);
        this.delegate.bindBlob(i5, bArr);
    }

    public void bindDouble(int i5, double d5) {
        saveArgsToCache(i5, Double.valueOf(d5));
        this.delegate.bindDouble(i5, d5);
    }

    public void bindLong(int i5, long j5) {
        saveArgsToCache(i5, Long.valueOf(j5));
        this.delegate.bindLong(i5, j5);
    }

    public void bindNull(int i5) {
        saveArgsToCache(i5, (Object) null);
        this.delegate.bindNull(i5);
    }

    public void bindString(int i5, String str) {
        t.e(str, "value");
        saveArgsToCache(i5, str);
        this.delegate.bindString(i5, str);
    }

    public void clearBindings() {
        this.bindArgsCache.clear();
        this.delegate.clearBindings();
    }

    public void close() {
        this.delegate.close();
    }

    public void execute() {
        C2908y0 unused = C2876i.d(this.queryCallbackScope, (C2312i) null, (O) null, new QueryInterceptorStatement$execute$1(this, C2250q.n0(this.bindArgsCache), (C2308e) null), 3, (Object) null);
        this.delegate.execute();
    }

    public long executeInsert() {
        C2908y0 unused = C2876i.d(this.queryCallbackScope, (C2312i) null, (O) null, new QueryInterceptorStatement$executeInsert$1(this, C2250q.n0(this.bindArgsCache), (C2308e) null), 3, (Object) null);
        return this.delegate.executeInsert();
    }

    public int executeUpdateDelete() {
        C2908y0 unused = C2876i.d(this.queryCallbackScope, (C2312i) null, (O) null, new QueryInterceptorStatement$executeUpdateDelete$1(this, C2250q.n0(this.bindArgsCache), (C2308e) null), 3, (Object) null);
        return this.delegate.executeUpdateDelete();
    }

    public long simpleQueryForLong() {
        C2908y0 unused = C2876i.d(this.queryCallbackScope, (C2312i) null, (O) null, new QueryInterceptorStatement$simpleQueryForLong$1(this, C2250q.n0(this.bindArgsCache), (C2308e) null), 3, (Object) null);
        return this.delegate.simpleQueryForLong();
    }

    public String simpleQueryForString() {
        C2908y0 unused = C2876i.d(this.queryCallbackScope, (C2312i) null, (O) null, new QueryInterceptorStatement$simpleQueryForString$1(this, C2250q.n0(this.bindArgsCache), (C2308e) null), 3, (Object) null);
        return this.delegate.simpleQueryForString();
    }
}
