package androidx.room.support;

import W2.J;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.room.DelegatingOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mbridge.msdk.MBridgeConstans;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import k.a;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    private final AutoCloser autoCloser;
    private final AutoClosingSupportSQLiteDatabase autoClosingDb;
    private final SupportSQLiteOpenHelper delegate;

    public static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {
        private final AutoCloser autoCloser;

        public AutoClosingSupportSQLiteDatabase(AutoCloser autoCloser2) {
            t.e(autoCloser2, "autoCloser");
            this.autoCloser = autoCloser2;
        }

        /* access modifiers changed from: private */
        public static final Object _set_pageSize_$lambda$3(long j5, SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            supportSQLiteDatabase.setPageSize(j5);
            return null;
        }

        /* access modifiers changed from: private */
        public static final J _set_version_$lambda$1(int i5, SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            supportSQLiteDatabase.setVersion(i5);
            return J.f19942a;
        }

        /* access modifiers changed from: private */
        public static final int delete$lambda$5(String str, String str2, Object[] objArr, SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            return supportSQLiteDatabase.delete(str, str2, objArr);
        }

        /* access modifiers changed from: private */
        public static final J execSQL$lambda$7(String str, SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            supportSQLiteDatabase.execSQL(str);
            return J.f19942a;
        }

        /* access modifiers changed from: private */
        public static final J execSQL$lambda$8(String str, Object[] objArr, SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            supportSQLiteDatabase.execSQL(str, objArr);
            return J.f19942a;
        }

        /* access modifiers changed from: private */
        public static final long insert$lambda$4(String str, int i5, ContentValues contentValues, SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            return supportSQLiteDatabase.insert(str, i5, contentValues);
        }

        /* access modifiers changed from: private */
        public static final boolean needUpgrade$lambda$9(int i5, SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            return supportSQLiteDatabase.needUpgrade(i5);
        }

        /* access modifiers changed from: private */
        public static final Object pokeOpen$lambda$0(SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "it");
            return null;
        }

        /* access modifiers changed from: private */
        public static final J setForeignKeyConstraintsEnabled$lambda$12(boolean z4, SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            supportSQLiteDatabase.setForeignKeyConstraintsEnabled(z4);
            return J.f19942a;
        }

        /* access modifiers changed from: private */
        public static final J setLocale$lambda$10(Locale locale, SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            supportSQLiteDatabase.setLocale(locale);
            return J.f19942a;
        }

        /* access modifiers changed from: private */
        public static final J setMaxSqlCacheSize$lambda$11(int i5, SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            supportSQLiteDatabase.setMaxSqlCacheSize(i5);
            return J.f19942a;
        }

        /* access modifiers changed from: private */
        public static final long setMaximumSize$lambda$2(long j5, SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            return supportSQLiteDatabase.setMaximumSize(j5);
        }

        /* access modifiers changed from: private */
        public static final int update$lambda$6(String str, int i5, ContentValues contentValues, String str2, Object[] objArr, SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            int i6 = i5;
            String str3 = str;
            SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
            Object[] objArr2 = objArr;
            String str4 = str2;
            return supportSQLiteDatabase2.update(str3, i6, contentValues, str4, objArr2);
        }

        public void beginTransaction() {
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransaction();
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        public void beginTransactionNonExclusive() {
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionNonExclusive();
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        public /* synthetic */ void beginTransactionReadOnly() {
            a.a(this);
        }

        public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
            t.e(sQLiteTransactionListener, "transactionListener");
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListener(sQLiteTransactionListener);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
            t.e(sQLiteTransactionListener, "transactionListener");
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        public /* synthetic */ void beginTransactionWithListenerReadOnly(SQLiteTransactionListener sQLiteTransactionListener) {
            a.b(this, sQLiteTransactionListener);
        }

        public void close() throws IOException {
            this.autoCloser.closeDatabaseIfOpen();
        }

        public SupportSQLiteStatement compileStatement(String str) {
            t.e(str, "sql");
            return new AutoClosingSupportSQLiteStatement(str, this.autoCloser);
        }

        public int delete(String str, String str2, Object[] objArr) {
            t.e(str, "table");
            return ((Number) this.autoCloser.executeRefCountingFunction(new d(str, str2, objArr))).intValue();
        }

        public void disableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        public boolean enableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        public void endTransaction() {
            try {
                SupportSQLiteDatabase delegateDatabase$room_runtime_release = this.autoCloser.getDelegateDatabase$room_runtime_release();
                t.b(delegateDatabase$room_runtime_release);
                delegateDatabase$room_runtime_release.endTransaction();
            } finally {
                this.autoCloser.decrementCountAndScheduleClose();
            }
        }

        public /* synthetic */ void execPerConnectionSQL(String str, Object[] objArr) {
            a.c(this, str, objArr);
        }

        public void execSQL(String str) throws SQLException {
            t.e(str, "sql");
            this.autoCloser.executeRefCountingFunction(new h(str));
        }

        public List<Pair<String, String>> getAttachedDbs() {
            return (List) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1.INSTANCE);
        }

        public long getMaximumSize() {
            return ((Number) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1.INSTANCE)).longValue();
        }

        public long getPageSize() {
            return ((Number) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1.INSTANCE)).longValue();
        }

        public String getPath() {
            return (String) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1.INSTANCE);
        }

        public int getVersion() {
            return ((Number) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1.INSTANCE)).intValue();
        }

        public boolean inTransaction() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() == null) {
                return false;
            }
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1.INSTANCE)).booleanValue();
        }

        public long insert(String str, int i5, ContentValues contentValues) throws SQLException {
            t.e(str, "table");
            t.e(contentValues, "values");
            return ((Number) this.autoCloser.executeRefCountingFunction(new k(str, i5, contentValues))).longValue();
        }

        public boolean isDatabaseIntegrityOk() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDatabaseIntegrityOk$1.INSTANCE)).booleanValue();
        }

        public boolean isDbLockedByCurrentThread() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() == null) {
                return false;
            }
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDbLockedByCurrentThread$1.INSTANCE)).booleanValue();
        }

        public /* synthetic */ boolean isExecPerConnectionSQLSupported() {
            return a.d(this);
        }

        public boolean isOpen() {
            SupportSQLiteDatabase delegateDatabase$room_runtime_release = this.autoCloser.getDelegateDatabase$room_runtime_release();
            if (delegateDatabase$room_runtime_release != null) {
                return delegateDatabase$room_runtime_release.isOpen();
            }
            return false;
        }

        public boolean isReadOnly() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1.INSTANCE)).booleanValue();
        }

        public boolean isWriteAheadLoggingEnabled() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isWriteAheadLoggingEnabled$1.INSTANCE)).booleanValue();
        }

        public boolean needUpgrade(int i5) {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(new m(i5))).booleanValue();
        }

        public final void pokeOpen() {
            this.autoCloser.executeRefCountingFunction(new j());
        }

        public Cursor query(String str) {
            t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(str), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        public void setForeignKeyConstraintsEnabled(boolean z4) {
            this.autoCloser.executeRefCountingFunction(new n(z4));
        }

        public void setLocale(Locale locale) {
            t.e(locale, "locale");
            this.autoCloser.executeRefCountingFunction(new c(locale));
        }

        public void setMaxSqlCacheSize(int i5) {
            this.autoCloser.executeRefCountingFunction(new b(i5));
        }

        public long setMaximumSize(long j5) {
            return ((Number) this.autoCloser.executeRefCountingFunction(new e(j5))).longValue();
        }

        public void setPageSize(long j5) {
            this.autoCloser.executeRefCountingFunction(new l(j5));
        }

        public void setTransactionSuccessful() {
            SupportSQLiteDatabase delegateDatabase$room_runtime_release = this.autoCloser.getDelegateDatabase$room_runtime_release();
            t.b(delegateDatabase$room_runtime_release);
            delegateDatabase$room_runtime_release.setTransactionSuccessful();
        }

        public void setVersion(int i5) {
            this.autoCloser.executeRefCountingFunction(new f(i5));
        }

        public int update(String str, int i5, ContentValues contentValues, String str2, Object[] objArr) {
            t.e(str, "table");
            t.e(contentValues, "values");
            return ((Number) this.autoCloser.executeRefCountingFunction(new g(str, i5, contentValues, str2, objArr))).intValue();
        }

        public boolean yieldIfContendedSafely() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1.INSTANCE)).booleanValue();
        }

        public void execSQL(String str, Object[] objArr) throws SQLException {
            t.e(str, "sql");
            t.e(objArr, "bindArgs");
            this.autoCloser.executeRefCountingFunction(new i(str, objArr));
        }

        public boolean yieldIfContendedSafely(long j5) {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$2.INSTANCE)).booleanValue();
        }

        public Cursor query(String str, Object[] objArr) {
            t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
            t.e(objArr, "bindArgs");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(str, objArr), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
            t.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(supportSQLiteQuery), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @RequiresApi(api = 24)
        public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
            t.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(supportSQLiteQuery, cancellationSignal), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }
    }

    private static final class AutoClosingSupportSQLiteStatement implements SupportSQLiteStatement {
        private static final int COLUMN_TYPE_BLOB = 4;
        private static final int COLUMN_TYPE_DOUBLE = 2;
        private static final int COLUMN_TYPE_LONG = 1;
        private static final int COLUMN_TYPE_NULL = 5;
        private static final int COLUMN_TYPE_STRING = 3;
        public static final Companion Companion = new Companion((C2633k) null);
        private final AutoCloser autoCloser;
        private int[] bindingTypes = new int[0];
        private byte[][] blobBindings = new byte[0][];
        private double[] doubleBindings = new double[0];
        private long[] longBindings = new long[0];
        private final String sql;
        private String[] stringBindings = new String[0];

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            private Companion() {
            }
        }

        public AutoClosingSupportSQLiteStatement(String str, AutoCloser autoCloser2) {
            t.e(str, "sql");
            t.e(autoCloser2, "autoCloser");
            this.sql = str;
            this.autoCloser = autoCloser2;
        }

        private final void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
            int length = this.bindingTypes.length;
            for (int i5 = 1; i5 < length; i5++) {
                int i6 = this.bindingTypes[i5];
                if (i6 == 1) {
                    supportSQLiteProgram.bindLong(i5, this.longBindings[i5]);
                } else if (i6 == 2) {
                    supportSQLiteProgram.bindDouble(i5, this.doubleBindings[i5]);
                } else if (i6 == 3) {
                    String str = this.stringBindings[i5];
                    t.b(str);
                    supportSQLiteProgram.bindString(i5, str);
                } else if (i6 == 4) {
                    byte[] bArr = this.blobBindings[i5];
                    t.b(bArr);
                    supportSQLiteProgram.bindBlob(i5, bArr);
                } else if (i6 == 5) {
                    supportSQLiteProgram.bindNull(i5);
                }
            }
        }

        private final void ensureCapacity(int i5, int i6) {
            int i7 = i6 + 1;
            int[] iArr = this.bindingTypes;
            if (iArr.length < i7) {
                int[] copyOf = Arrays.copyOf(iArr, i7);
                t.d(copyOf, "copyOf(...)");
                this.bindingTypes = copyOf;
            }
            if (i5 == 1) {
                long[] jArr = this.longBindings;
                if (jArr.length < i7) {
                    long[] copyOf2 = Arrays.copyOf(jArr, i7);
                    t.d(copyOf2, "copyOf(...)");
                    this.longBindings = copyOf2;
                }
            } else if (i5 == 2) {
                double[] dArr = this.doubleBindings;
                if (dArr.length < i7) {
                    double[] copyOf3 = Arrays.copyOf(dArr, i7);
                    t.d(copyOf3, "copyOf(...)");
                    this.doubleBindings = copyOf3;
                }
            } else if (i5 == 3) {
                String[] strArr = this.stringBindings;
                if (strArr.length < i7) {
                    Object[] copyOf4 = Arrays.copyOf(strArr, i7);
                    t.d(copyOf4, "copyOf(...)");
                    this.stringBindings = (String[]) copyOf4;
                }
            } else if (i5 == 4) {
                byte[][] bArr = this.blobBindings;
                if (bArr.length < i7) {
                    Object[] copyOf5 = Arrays.copyOf(bArr, i7);
                    t.d(copyOf5, "copyOf(...)");
                    this.blobBindings = (byte[][]) copyOf5;
                }
            }
        }

        /* access modifiers changed from: private */
        public static final J execute$lambda$0(SupportSQLiteStatement supportSQLiteStatement) {
            t.e(supportSQLiteStatement, "statement");
            supportSQLiteStatement.execute();
            return J.f19942a;
        }

        /* access modifiers changed from: private */
        public static final long executeInsert$lambda$2(SupportSQLiteStatement supportSQLiteStatement) {
            t.e(supportSQLiteStatement, "obj");
            return supportSQLiteStatement.executeInsert();
        }

        /* access modifiers changed from: private */
        public static final int executeUpdateDelete$lambda$1(SupportSQLiteStatement supportSQLiteStatement) {
            t.e(supportSQLiteStatement, "obj");
            return supportSQLiteStatement.executeUpdateDelete();
        }

        private final <T> T executeWithRefCount(l lVar) {
            return this.autoCloser.executeRefCountingFunction(new r(this, lVar));
        }

        /* access modifiers changed from: private */
        public static final Object executeWithRefCount$lambda$5(AutoClosingSupportSQLiteStatement autoClosingSupportSQLiteStatement, l lVar, SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            SupportSQLiteStatement compileStatement = supportSQLiteDatabase.compileStatement(autoClosingSupportSQLiteStatement.sql);
            autoClosingSupportSQLiteStatement.bindTo(compileStatement);
            return lVar.invoke(compileStatement);
        }

        /* access modifiers changed from: private */
        public static final long simpleQueryForLong$lambda$3(SupportSQLiteStatement supportSQLiteStatement) {
            t.e(supportSQLiteStatement, "obj");
            return supportSQLiteStatement.simpleQueryForLong();
        }

        /* access modifiers changed from: private */
        public static final String simpleQueryForString$lambda$4(SupportSQLiteStatement supportSQLiteStatement) {
            t.e(supportSQLiteStatement, "obj");
            return supportSQLiteStatement.simpleQueryForString();
        }

        public void bindBlob(int i5, byte[] bArr) {
            t.e(bArr, "value");
            ensureCapacity(4, i5);
            this.bindingTypes[i5] = 4;
            this.blobBindings[i5] = bArr;
        }

        public void bindDouble(int i5, double d5) {
            ensureCapacity(2, i5);
            this.bindingTypes[i5] = 2;
            this.doubleBindings[i5] = d5;
        }

        public void bindLong(int i5, long j5) {
            ensureCapacity(1, i5);
            this.bindingTypes[i5] = 1;
            this.longBindings[i5] = j5;
        }

        public void bindNull(int i5) {
            ensureCapacity(5, i5);
            this.bindingTypes[i5] = 5;
        }

        public void bindString(int i5, String str) {
            t.e(str, "value");
            ensureCapacity(3, i5);
            this.bindingTypes[i5] = 3;
            this.stringBindings[i5] = str;
        }

        public void clearBindings() {
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        public void close() {
            clearBindings();
        }

        public void execute() {
            executeWithRefCount(new t());
        }

        public long executeInsert() {
            return ((Number) executeWithRefCount(new s())).longValue();
        }

        public int executeUpdateDelete() {
            return ((Number) executeWithRefCount(new q())).intValue();
        }

        public long simpleQueryForLong() {
            return ((Number) executeWithRefCount(new o())).longValue();
        }

        public String simpleQueryForString() {
            return (String) executeWithRefCount(new p());
        }
    }

    private static final class KeepAliveCursor implements Cursor {
        private final AutoCloser autoCloser;
        private final Cursor delegate;

        public KeepAliveCursor(Cursor cursor, AutoCloser autoCloser2) {
            t.e(cursor, "delegate");
            t.e(autoCloser2, "autoCloser");
            this.delegate = cursor;
            this.autoCloser = autoCloser2;
        }

        public void close() {
            this.delegate.close();
            this.autoCloser.decrementCountAndScheduleClose();
        }

        public void copyStringToBuffer(int i5, CharArrayBuffer charArrayBuffer) {
            this.delegate.copyStringToBuffer(i5, charArrayBuffer);
        }

        public void deactivate() {
            this.delegate.deactivate();
        }

        public byte[] getBlob(int i5) {
            return this.delegate.getBlob(i5);
        }

        public int getColumnCount() {
            return this.delegate.getColumnCount();
        }

        public int getColumnIndex(String str) {
            return this.delegate.getColumnIndex(str);
        }

        public int getColumnIndexOrThrow(String str) {
            return this.delegate.getColumnIndexOrThrow(str);
        }

        public String getColumnName(int i5) {
            return this.delegate.getColumnName(i5);
        }

        public String[] getColumnNames() {
            return this.delegate.getColumnNames();
        }

        public int getCount() {
            return this.delegate.getCount();
        }

        public double getDouble(int i5) {
            return this.delegate.getDouble(i5);
        }

        public Bundle getExtras() {
            return this.delegate.getExtras();
        }

        public float getFloat(int i5) {
            return this.delegate.getFloat(i5);
        }

        public int getInt(int i5) {
            return this.delegate.getInt(i5);
        }

        public long getLong(int i5) {
            return this.delegate.getLong(i5);
        }

        public Uri getNotificationUri() {
            return this.delegate.getNotificationUri();
        }

        public int getPosition() {
            return this.delegate.getPosition();
        }

        public short getShort(int i5) {
            return this.delegate.getShort(i5);
        }

        public String getString(int i5) {
            return this.delegate.getString(i5);
        }

        public int getType(int i5) {
            return this.delegate.getType(i5);
        }

        public boolean getWantsAllOnMoveCalls() {
            return this.delegate.getWantsAllOnMoveCalls();
        }

        public boolean isAfterLast() {
            return this.delegate.isAfterLast();
        }

        public boolean isBeforeFirst() {
            return this.delegate.isBeforeFirst();
        }

        public boolean isClosed() {
            return this.delegate.isClosed();
        }

        public boolean isFirst() {
            return this.delegate.isFirst();
        }

        public boolean isLast() {
            return this.delegate.isLast();
        }

        public boolean isNull(int i5) {
            return this.delegate.isNull(i5);
        }

        public boolean move(int i5) {
            return this.delegate.move(i5);
        }

        public boolean moveToFirst() {
            return this.delegate.moveToFirst();
        }

        public boolean moveToLast() {
            return this.delegate.moveToLast();
        }

        public boolean moveToNext() {
            return this.delegate.moveToNext();
        }

        public boolean moveToPosition(int i5) {
            return this.delegate.moveToPosition(i5);
        }

        public boolean moveToPrevious() {
            return this.delegate.moveToPrevious();
        }

        public void registerContentObserver(ContentObserver contentObserver) {
            this.delegate.registerContentObserver(contentObserver);
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.delegate.registerDataSetObserver(dataSetObserver);
        }

        public boolean requery() {
            return this.delegate.requery();
        }

        public Bundle respond(Bundle bundle) {
            return this.delegate.respond(bundle);
        }

        public void setExtras(Bundle bundle) {
            this.delegate.setExtras(bundle);
        }

        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.delegate.setNotificationUri(contentResolver, uri);
        }

        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.delegate.unregisterContentObserver(contentObserver);
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.delegate.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public AutoClosingRoomOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper, AutoCloser autoCloser2) {
        t.e(supportSQLiteOpenHelper, "delegate");
        t.e(autoCloser2, "autoCloser");
        this.delegate = supportSQLiteOpenHelper;
        this.autoCloser = autoCloser2;
        this.autoClosingDb = new AutoClosingSupportSQLiteDatabase(autoCloser2);
        autoCloser2.initOpenHelper(getDelegate());
    }

    public void close() {
        this.autoClosingDb.close();
    }

    public final AutoCloser getAutoCloser$room_runtime_release() {
        return this.autoCloser;
    }

    public String getDatabaseName() {
        return this.delegate.getDatabaseName();
    }

    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        this.autoClosingDb.pokeOpen();
        return this.autoClosingDb;
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        this.autoClosingDb.pokeOpen();
        return this.autoClosingDb;
    }

    public void setWriteAheadLoggingEnabled(boolean z4) {
        this.delegate.setWriteAheadLoggingEnabled(z4);
    }
}
