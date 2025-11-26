package androidx.sqlite.db.framework;

import W2.C2223l;
import W2.m;
import W2.p;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mbridge.msdk.MBridgeConstans;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import k3.r;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final Companion Companion = new Companion((C2633k) null);
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    /* access modifiers changed from: private */
    public static final C2223l beginTransactionMethod$delegate;
    /* access modifiers changed from: private */
    public static final C2223l getThreadSessionMethod$delegate;
    private final SQLiteDatabase delegate;

    @RequiresApi(30)
    public static final class Api30Impl {
        public static final Api30Impl INSTANCE = new Api30Impl();

        private Api30Impl() {
        }

        public final void execPerConnectionSQL(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr) {
            t.e(sQLiteDatabase, "sQLiteDatabase");
            t.e(str, "sql");
            sQLiteDatabase.execPerConnectionSQL(str, objArr);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final Method getBeginTransactionMethod() {
            return (Method) FrameworkSQLiteDatabase.beginTransactionMethod$delegate.getValue();
        }

        /* access modifiers changed from: private */
        public final Method getGetThreadSessionMethod() {
            return (Method) FrameworkSQLiteDatabase.getThreadSessionMethod$delegate.getValue();
        }

        private Companion() {
        }
    }

    static {
        p pVar = p.NONE;
        getThreadSessionMethod$delegate = m.a(pVar, new d());
        beginTransactionMethod$delegate = m.a(pVar, new e());
    }

    public FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        t.e(sQLiteDatabase, "delegate");
        this.delegate = sQLiteDatabase;
    }

    /* access modifiers changed from: private */
    public static final Method beginTransactionMethod_delegate$lambda$8() {
        Class<?> returnType;
        try {
            Method access$getGetThreadSessionMethod = Companion.getGetThreadSessionMethod();
            if (access$getGetThreadSessionMethod == null || (returnType = access$getGetThreadSessionMethod.getReturnType()) == null) {
                return null;
            }
            Class cls = Integer.TYPE;
            return returnType.getDeclaredMethod("beginTransaction", new Class[]{cls, SQLiteTransactionListener.class, cls, CancellationSignal.class});
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static final Method getThreadSessionMethod_delegate$lambda$7() {
        try {
            Method declaredMethod = SQLiteDatabase.class.getDeclaredMethod("getThreadSession", (Class[]) null);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    private final void internalBeginTransactionWithListenerReadOnly(SQLiteTransactionListener sQLiteTransactionListener) {
        Companion companion = Companion;
        if (companion.getBeginTransactionMethod() != null && companion.getGetThreadSessionMethod() != null) {
            Method access$getBeginTransactionMethod = companion.getBeginTransactionMethod();
            t.b(access$getBeginTransactionMethod);
            Method access$getGetThreadSessionMethod = companion.getGetThreadSessionMethod();
            t.b(access$getGetThreadSessionMethod);
            Object invoke = access$getGetThreadSessionMethod.invoke(this.delegate, (Object[]) null);
            if (invoke != null) {
                access$getBeginTransactionMethod.invoke(invoke, new Object[]{0, sQLiteTransactionListener, 0, null});
                return;
            }
            throw new IllegalStateException("Required value was null.");
        } else if (sQLiteTransactionListener != null) {
            beginTransactionWithListener(sQLiteTransactionListener);
        } else {
            beginTransaction();
        }
    }

    /* access modifiers changed from: private */
    public static final SQLiteCursor query$lambda$0(SupportSQLiteQuery supportSQLiteQuery, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        t.b(sQLiteQuery);
        supportSQLiteQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* access modifiers changed from: private */
    public static final Cursor query$lambda$1(r rVar, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return (Cursor) rVar.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* access modifiers changed from: private */
    public static final Cursor query$lambda$2(SupportSQLiteQuery supportSQLiteQuery, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        t.b(sQLiteQuery);
        supportSQLiteQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    public void beginTransaction() {
        this.delegate.beginTransaction();
    }

    public void beginTransactionNonExclusive() {
        this.delegate.beginTransactionNonExclusive();
    }

    public void beginTransactionReadOnly() {
        internalBeginTransactionWithListenerReadOnly((SQLiteTransactionListener) null);
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        t.e(sQLiteTransactionListener, "transactionListener");
        this.delegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        t.e(sQLiteTransactionListener, "transactionListener");
        this.delegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    public void beginTransactionWithListenerReadOnly(SQLiteTransactionListener sQLiteTransactionListener) {
        t.e(sQLiteTransactionListener, "transactionListener");
        internalBeginTransactionWithListenerReadOnly(sQLiteTransactionListener);
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public SupportSQLiteStatement compileStatement(String str) {
        t.e(str, "sql");
        SQLiteStatement compileStatement = this.delegate.compileStatement(str);
        t.d(compileStatement, "compileStatement(...)");
        return new FrameworkSQLiteStatement(compileStatement);
    }

    public int delete(String str, String str2, Object[] objArr) {
        t.e(str, "table");
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(str);
        if (!(str2 == null || str2.length() == 0)) {
            sb.append(" WHERE ");
            sb.append(str2);
        }
        SupportSQLiteStatement compileStatement = compileStatement(sb.toString());
        SimpleSQLiteQuery.Companion.bind(compileStatement, objArr);
        return compileStatement.executeUpdateDelete();
    }

    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    public void endTransaction() {
        this.delegate.endTransaction();
    }

    public void execPerConnectionSQL(String str, Object[] objArr) {
        t.e(str, "sql");
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            Api30Impl.INSTANCE.execPerConnectionSQL(this.delegate, str, objArr);
            return;
        }
        throw new UnsupportedOperationException("execPerConnectionSQL is not supported on a SDK version lower than 30, current version is: " + i5);
    }

    public void execSQL(String str) throws SQLException {
        t.e(str, "sql");
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

    public long insert(String str, int i5, ContentValues contentValues) throws SQLException {
        t.e(str, "table");
        t.e(contentValues, "values");
        return this.delegate.insertWithOnConflict(str, (String) null, contentValues, i5);
    }

    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    public final boolean isDelegate(SQLiteDatabase sQLiteDatabase) {
        t.e(sQLiteDatabase, "sqLiteDatabase");
        return t.a(this.delegate, sQLiteDatabase);
    }

    public boolean isExecPerConnectionSQLSupported() {
        if (Build.VERSION.SDK_INT >= 30) {
            return true;
        }
        return false;
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
        return query((SupportSQLiteQuery) new SimpleSQLiteQuery(str));
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

    /* renamed from: setMaximumSize  reason: collision with other method in class */
    public void m197setMaximumSize(long j5) {
        this.delegate.setMaximumSize(j5);
    }

    public void setPageSize(long j5) {
        this.delegate.setPageSize(j5);
    }

    public void setTransactionSuccessful() {
        this.delegate.setTransactionSuccessful();
    }

    public void setVersion(int i5) {
        this.delegate.setVersion(i5);
    }

    public int update(String str, int i5, ContentValues contentValues, String str2, Object[] objArr) {
        int i6;
        String str3;
        t.e(str, "table");
        t.e(contentValues, "values");
        if (contentValues.size() != 0) {
            int size = contentValues.size();
            if (objArr == null) {
                i6 = size;
            } else {
                i6 = objArr.length + size;
            }
            Object[] objArr2 = new Object[i6];
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ");
            sb.append(CONFLICT_VALUES[i5]);
            sb.append(str);
            sb.append(" SET ");
            int i7 = 0;
            for (String next : contentValues.keySet()) {
                if (i7 > 0) {
                    str3 = ",";
                } else {
                    str3 = "";
                }
                sb.append(str3);
                sb.append(next);
                objArr2[i7] = contentValues.get(next);
                sb.append("=?");
                i7++;
            }
            if (objArr != null) {
                for (int i8 = size; i8 < i6; i8++) {
                    objArr2[i8] = objArr[i8 - size];
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(" WHERE ");
                sb.append(str2);
            }
            SupportSQLiteStatement compileStatement = compileStatement(sb.toString());
            SimpleSQLiteQuery.Companion.bind(compileStatement, objArr2);
            return compileStatement.executeUpdateDelete();
        }
        throw new IllegalArgumentException("Empty values");
    }

    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    public void execSQL(String str, Object[] objArr) throws SQLException {
        t.e(str, "sql");
        t.e(objArr, "bindArgs");
        this.delegate.execSQL(str, objArr);
    }

    public Cursor query(String str, Object[] objArr) {
        t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        t.e(objArr, "bindArgs");
        return query((SupportSQLiteQuery) new SimpleSQLiteQuery(str, objArr));
    }

    public long setMaximumSize(long j5) {
        this.delegate.setMaximumSize(j5);
        return this.delegate.getMaximumSize();
    }

    public boolean yieldIfContendedSafely(long j5) {
        return this.delegate.yieldIfContendedSafely(j5);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        t.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        Cursor rawQueryWithFactory = this.delegate.rawQueryWithFactory(new c(new b(supportSQLiteQuery)), supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, (String) null);
        t.d(rawQueryWithFactory, "rawQueryWithFactory(...)");
        return rawQueryWithFactory;
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        t.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        SQLiteDatabase sQLiteDatabase = this.delegate;
        a aVar = new a(supportSQLiteQuery);
        String sql = supportSQLiteQuery.getSql();
        String[] strArr = EMPTY_STRING_ARRAY;
        t.b(cancellationSignal);
        Cursor rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(aVar, sql, strArr, (String) null, cancellationSignal);
        t.d(rawQueryWithFactory, "rawQueryWithFactory(...)");
        return rawQueryWithFactory;
    }
}
