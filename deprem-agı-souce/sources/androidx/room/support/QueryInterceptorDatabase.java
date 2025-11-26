package androidx.room.support;

import X2.C2242i;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import b3.C2308e;
import b3.C2312i;
import com.mbridge.msdk.MBridgeConstans;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.t;
import w3.C2908y0;
import w3.M;
import w3.O;

public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {
    private final SupportSQLiteDatabase delegate;
    /* access modifiers changed from: private */
    public final RoomDatabase.QueryCallback queryCallback;
    private final M queryCallbackScope;

    public QueryInterceptorDatabase(SupportSQLiteDatabase supportSQLiteDatabase, M m5, RoomDatabase.QueryCallback queryCallback2) {
        t.e(supportSQLiteDatabase, "delegate");
        t.e(m5, "queryCallbackScope");
        t.e(queryCallback2, "queryCallback");
        this.delegate = supportSQLiteDatabase;
        this.queryCallbackScope = m5;
        this.queryCallback = queryCallback2;
    }

    public void beginTransaction() {
        C2908y0 unused = C2876i.d(this.queryCallbackScope, (C2312i) null, (O) null, new QueryInterceptorDatabase$beginTransaction$1(this, (C2308e) null), 3, (Object) null);
        this.delegate.beginTransaction();
    }

    public void beginTransactionNonExclusive() {
        C2908y0 unused = C2876i.d(this.queryCallbackScope, (C2312i) null, (O) null, new QueryInterceptorDatabase$beginTransactionNonExclusive$1(this, (C2308e) null), 3, (Object) null);
        this.delegate.beginTransactionNonExclusive();
    }

    public void beginTransactionReadOnly() {
        this.delegate.beginTransactionReadOnly();
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        t.e(sQLiteTransactionListener, "transactionListener");
        C2908y0 unused = C2876i.d(this.queryCallbackScope, (C2312i) null, (O) null, new QueryInterceptorDatabase$beginTransactionWithListener$1(this, (C2308e) null), 3, (Object) null);
        this.delegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        t.e(sQLiteTransactionListener, "transactionListener");
        C2908y0 unused = C2876i.d(this.queryCallbackScope, (C2312i) null, (O) null, new QueryInterceptorDatabase$beginTransactionWithListenerNonExclusive$1(this, (C2308e) null), 3, (Object) null);
        this.delegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    public void beginTransactionWithListenerReadOnly(SQLiteTransactionListener sQLiteTransactionListener) {
        t.e(sQLiteTransactionListener, "transactionListener");
        this.delegate.beginTransactionWithListenerReadOnly(sQLiteTransactionListener);
    }

    public void close() {
        this.delegate.close();
    }

    public SupportSQLiteStatement compileStatement(String str) {
        t.e(str, "sql");
        return new QueryInterceptorStatement(this.delegate.compileStatement(str), str, this.queryCallbackScope, this.queryCallback);
    }

    public int delete(String str, String str2, Object[] objArr) {
        t.e(str, "table");
        return this.delegate.delete(str, str2, objArr);
    }

    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    public void endTransaction() {
        C2908y0 unused = C2876i.d(this.queryCallbackScope, (C2312i) null, (O) null, new QueryInterceptorDatabase$endTransaction$1(this, (C2308e) null), 3, (Object) null);
        this.delegate.endTransaction();
    }

    public void execPerConnectionSQL(String str, @SuppressLint({"ArrayReturn"}) Object[] objArr) {
        t.e(str, "sql");
        this.delegate.execPerConnectionSQL(str, objArr);
    }

    public void execSQL(String str) {
        t.e(str, "sql");
        C2908y0 unused = C2876i.d(this.queryCallbackScope, (C2312i) null, (O) null, new QueryInterceptorDatabase$execSQL$1(this, str, (C2308e) null), 3, (Object) null);
        this.delegate.execSQL(str);
    }

    public List<Pair<String, String>> getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    public String getPath() {
        return this.delegate.getPath();
    }

    public int getVersion() {
        return this.delegate.getVersion();
    }

    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    public long insert(String str, int i5, ContentValues contentValues) {
        t.e(str, "table");
        t.e(contentValues, "values");
        return this.delegate.insert(str, i5, contentValues);
    }

    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    public boolean isExecPerConnectionSQLSupported() {
        return this.delegate.isExecPerConnectionSQLSupported();
    }

    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    public boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    public boolean needUpgrade(int i5) {
        return this.delegate.needUpgrade(i5);
    }

    public Cursor query(String str) {
        t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        C2908y0 unused = C2876i.d(this.queryCallbackScope, (C2312i) null, (O) null, new QueryInterceptorDatabase$query$1(this, str, (C2308e) null), 3, (Object) null);
        return this.delegate.query(str);
    }

    public void setForeignKeyConstraintsEnabled(boolean z4) {
        this.delegate.setForeignKeyConstraintsEnabled(z4);
    }

    public void setLocale(Locale locale) {
        t.e(locale, "locale");
        this.delegate.setLocale(locale);
    }

    public void setMaxSqlCacheSize(int i5) {
        this.delegate.setMaxSqlCacheSize(i5);
    }

    public long setMaximumSize(long j5) {
        return this.delegate.setMaximumSize(j5);
    }

    public void setPageSize(long j5) {
        this.delegate.setPageSize(j5);
    }

    public void setTransactionSuccessful() {
        C2908y0 unused = C2876i.d(this.queryCallbackScope, (C2312i) null, (O) null, new QueryInterceptorDatabase$setTransactionSuccessful$1(this, (C2308e) null), 3, (Object) null);
        this.delegate.setTransactionSuccessful();
    }

    public void setVersion(int i5) {
        this.delegate.setVersion(i5);
    }

    public int update(String str, int i5, ContentValues contentValues, String str2, Object[] objArr) {
        t.e(str, "table");
        t.e(contentValues, "values");
        return this.delegate.update(str, i5, contentValues, str2, objArr);
    }

    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    public boolean yieldIfContendedSafely(long j5) {
        return this.delegate.yieldIfContendedSafely(j5);
    }

    public void execSQL(String str, Object[] objArr) {
        t.e(str, "sql");
        t.e(objArr, "bindArgs");
        C2908y0 unused = C2876i.d(this.queryCallbackScope, (C2312i) null, (O) null, new QueryInterceptorDatabase$execSQL$2(this, str, C2242i.q0(objArr), (C2308e) null), 3, (Object) null);
        this.delegate.execSQL(str, objArr);
    }

    public Cursor query(String str, Object[] objArr) {
        t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        t.e(objArr, "bindArgs");
        C2908y0 unused = C2876i.d(this.queryCallbackScope, (C2312i) null, (O) null, new QueryInterceptorDatabase$query$2(this, str, C2242i.q0(objArr), (C2308e) null), 3, (Object) null);
        return this.delegate.query(str, objArr);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        t.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        C2908y0 unused = C2876i.d(this.queryCallbackScope, (C2312i) null, (O) null, new QueryInterceptorDatabase$query$3(this, supportSQLiteQuery, queryInterceptorProgram, (C2308e) null), 3, (Object) null);
        return this.delegate.query(supportSQLiteQuery);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        t.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        C2908y0 unused = C2876i.d(this.queryCallbackScope, (C2312i) null, (O) null, new QueryInterceptorDatabase$query$4(this, supportSQLiteQuery, queryInterceptorProgram, (C2308e) null), 3, (Object) null);
        return this.delegate.query(supportSQLiteQuery);
    }
}
