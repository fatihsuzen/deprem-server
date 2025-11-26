package androidx.sqlite.driver;

import W2.C2219h;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteStatement;
import j.a;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

public abstract class AndroidSQLiteStatement implements SQLiteStatement {
    public static final Companion Companion = new Companion((C2633k) null);
    private final SQLiteDatabase db;
    private boolean isClosed;
    private final String sql;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private final boolean isRowStatement(String str) {
            String obj = s.W0(str).toString();
            if (obj.length() < 3) {
                return false;
            }
            String substring = obj.substring(0, 3);
            t.d(substring, "substring(...)");
            String upperCase = substring.toUpperCase(Locale.ROOT);
            t.d(upperCase, "toUpperCase(...)");
            int hashCode = upperCase.hashCode();
            if (hashCode != 79487) {
                if (hashCode != 81978) {
                    if (hashCode == 85954 && upperCase.equals("WIT")) {
                        return true;
                    }
                } else if (!upperCase.equals("SEL")) {
                    return false;
                } else {
                    return true;
                }
            } else if (upperCase.equals("PRA")) {
                return true;
            }
            return false;
        }

        public final AndroidSQLiteStatement create(SQLiteDatabase sQLiteDatabase, String str) {
            t.e(sQLiteDatabase, "db");
            t.e(str, "sql");
            if (isRowStatement(str)) {
                return new SelectAndroidSQLiteStatement(sQLiteDatabase, str);
            }
            return new OtherAndroidSQLiteStatement(sQLiteDatabase, str);
        }

        private Companion() {
        }
    }

    private static final class OtherAndroidSQLiteStatement extends AndroidSQLiteStatement {
        private final android.database.sqlite.SQLiteStatement delegate;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OtherAndroidSQLiteStatement(SQLiteDatabase sQLiteDatabase, String str) {
            super(sQLiteDatabase, str, (C2633k) null);
            t.e(sQLiteDatabase, "db");
            t.e(str, "sql");
            android.database.sqlite.SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
            t.d(compileStatement, "compileStatement(...)");
            this.delegate = compileStatement;
        }

        public void bindBlob(int i5, byte[] bArr) {
            t.e(bArr, "value");
            throwIfClosed();
            this.delegate.bindBlob(i5, bArr);
        }

        public void bindDouble(int i5, double d5) {
            throwIfClosed();
            this.delegate.bindDouble(i5, d5);
        }

        public void bindLong(int i5, long j5) {
            throwIfClosed();
            this.delegate.bindLong(i5, j5);
        }

        public void bindNull(int i5) {
            throwIfClosed();
            this.delegate.bindNull(i5);
        }

        public void bindText(int i5, String str) {
            t.e(str, "value");
            throwIfClosed();
            this.delegate.bindString(i5, str);
        }

        public void clearBindings() {
            throwIfClosed();
            this.delegate.clearBindings();
        }

        public void close() {
            this.delegate.close();
            setClosed(true);
        }

        public byte[] getBlob(int i5) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new C2219h();
        }

        public int getColumnCount() {
            throwIfClosed();
            return 0;
        }

        public String getColumnName(int i5) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new C2219h();
        }

        public int getColumnType(int i5) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new C2219h();
        }

        public double getDouble(int i5) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new C2219h();
        }

        public long getLong(int i5) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new C2219h();
        }

        public String getText(int i5) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new C2219h();
        }

        public boolean isNull(int i5) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new C2219h();
        }

        public void reset() {
        }

        public boolean step() {
            throwIfClosed();
            this.delegate.execute();
            return false;
        }
    }

    private static final class SelectAndroidSQLiteStatement extends AndroidSQLiteStatement {
        public static final Companion Companion = new Companion((C2633k) null);
        private int[] bindingTypes = new int[0];
        private byte[][] blobBindings = new byte[0][];
        private Cursor cursor;
        private double[] doubleBindings = new double[0];
        private long[] longBindings = new long[0];
        private String[] stringBindings = new String[0];

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            /* access modifiers changed from: private */
            public final int getDataType(Cursor cursor, int i5) {
                int type = cursor.getType(i5);
                int type2 = cursor.getType(i5);
                if (type2 == 0) {
                    return 5;
                }
                int i6 = 1;
                if (type2 != 1) {
                    i6 = 2;
                    if (type2 != 2) {
                        i6 = 3;
                        if (type2 != 3) {
                            if (type2 == 4) {
                                return 4;
                            }
                            throw new IllegalStateException(("Unknown field type: " + type).toString());
                        }
                    }
                }
                return i6;
            }

            private Companion() {
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SelectAndroidSQLiteStatement(SQLiteDatabase sQLiteDatabase, String str) {
            super(sQLiteDatabase, str, (C2633k) null);
            t.e(sQLiteDatabase, "db");
            t.e(str, "sql");
        }

        private final void bindTo(SQLiteProgram sQLiteProgram) {
            int length = this.bindingTypes.length;
            for (int i5 = 1; i5 < length; i5++) {
                int i6 = this.bindingTypes[i5];
                if (i6 == 1) {
                    sQLiteProgram.bindLong(i5, this.longBindings[i5]);
                } else if (i6 == 2) {
                    sQLiteProgram.bindDouble(i5, this.doubleBindings[i5]);
                } else if (i6 == 3) {
                    sQLiteProgram.bindString(i5, this.stringBindings[i5]);
                } else if (i6 == 4) {
                    sQLiteProgram.bindBlob(i5, this.blobBindings[i5]);
                } else if (i6 == 5) {
                    sQLiteProgram.bindNull(i5);
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

        private final void ensureCursor() {
            if (this.cursor == null) {
                this.cursor = getDb().rawQueryWithFactory(new a(this), getSql(), new String[0], (String) null);
            }
        }

        /* access modifiers changed from: private */
        public static final Cursor ensureCursor$lambda$0(SelectAndroidSQLiteStatement selectAndroidSQLiteStatement, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            t.b(sQLiteQuery);
            selectAndroidSQLiteStatement.bindTo(sQLiteQuery);
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }

        private final void throwIfInvalidColumn(Cursor cursor2, int i5) {
            if (i5 < 0 || i5 >= cursor2.getColumnCount()) {
                SQLite.throwSQLiteException(25, "column index out of range");
                throw new C2219h();
            }
        }

        private final Cursor throwIfNoRow() {
            Cursor cursor2 = this.cursor;
            if (cursor2 != null) {
                return cursor2;
            }
            SQLite.throwSQLiteException(21, "no row");
            throw new C2219h();
        }

        public void bindBlob(int i5, byte[] bArr) {
            t.e(bArr, "value");
            throwIfClosed();
            ensureCapacity(4, i5);
            this.bindingTypes[i5] = 4;
            this.blobBindings[i5] = bArr;
        }

        public void bindDouble(int i5, double d5) {
            throwIfClosed();
            ensureCapacity(2, i5);
            this.bindingTypes[i5] = 2;
            this.doubleBindings[i5] = d5;
        }

        public void bindLong(int i5, long j5) {
            throwIfClosed();
            ensureCapacity(1, i5);
            this.bindingTypes[i5] = 1;
            this.longBindings[i5] = j5;
        }

        public void bindNull(int i5) {
            throwIfClosed();
            ensureCapacity(5, i5);
            this.bindingTypes[i5] = 5;
        }

        public void bindText(int i5, String str) {
            t.e(str, "value");
            throwIfClosed();
            ensureCapacity(3, i5);
            this.bindingTypes[i5] = 3;
            this.stringBindings[i5] = str;
        }

        public void clearBindings() {
            throwIfClosed();
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        public void close() {
            if (!isClosed()) {
                reset();
            }
            setClosed(true);
        }

        public byte[] getBlob(int i5) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i5);
            byte[] blob = throwIfNoRow.getBlob(i5);
            t.d(blob, "getBlob(...)");
            return blob;
        }

        public int getColumnCount() {
            throwIfClosed();
            ensureCursor();
            Cursor cursor2 = this.cursor;
            if (cursor2 != null) {
                return cursor2.getColumnCount();
            }
            return 0;
        }

        public String getColumnName(int i5) {
            throwIfClosed();
            ensureCursor();
            Cursor cursor2 = this.cursor;
            if (cursor2 != null) {
                throwIfInvalidColumn(cursor2, i5);
                String columnName = cursor2.getColumnName(i5);
                t.d(columnName, "getColumnName(...)");
                return columnName;
            }
            throw new IllegalStateException("Required value was null.");
        }

        public int getColumnType(int i5) {
            throwIfClosed();
            ensureCursor();
            Cursor cursor2 = this.cursor;
            if (cursor2 != null) {
                throwIfInvalidColumn(cursor2, i5);
                return Companion.getDataType(cursor2, i5);
            }
            throw new IllegalStateException("Required value was null.");
        }

        public double getDouble(int i5) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i5);
            return throwIfNoRow.getDouble(i5);
        }

        public long getLong(int i5) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i5);
            return throwIfNoRow.getLong(i5);
        }

        public String getText(int i5) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i5);
            String string = throwIfNoRow.getString(i5);
            t.d(string, "getString(...)");
            return string;
        }

        public boolean isNull(int i5) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i5);
            return throwIfNoRow.isNull(i5);
        }

        public void reset() {
            throwIfClosed();
            Cursor cursor2 = this.cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            this.cursor = null;
        }

        public boolean step() {
            throwIfClosed();
            ensureCursor();
            Cursor cursor2 = this.cursor;
            if (cursor2 != null) {
                return cursor2.moveToNext();
            }
            throw new IllegalStateException("Required value was null.");
        }
    }

    public /* synthetic */ AndroidSQLiteStatement(SQLiteDatabase sQLiteDatabase, String str, C2633k kVar) {
        this(sQLiteDatabase, str);
    }

    public /* synthetic */ void bindBoolean(int i5, boolean z4) {
        a.a(this, i5, z4);
    }

    public /* synthetic */ void bindFloat(int i5, float f5) {
        a.b(this, i5, f5);
    }

    public /* synthetic */ void bindInt(int i5, int i6) {
        a.c(this, i5, i6);
    }

    public /* synthetic */ boolean getBoolean(int i5) {
        return a.d(this, i5);
    }

    public /* synthetic */ List getColumnNames() {
        return a.e(this);
    }

    /* access modifiers changed from: protected */
    public final SQLiteDatabase getDb() {
        return this.db;
    }

    public /* synthetic */ float getFloat(int i5) {
        return a.f(this, i5);
    }

    public /* synthetic */ int getInt(int i5) {
        return a.g(this, i5);
    }

    /* access modifiers changed from: protected */
    public final String getSql() {
        return this.sql;
    }

    /* access modifiers changed from: protected */
    public final boolean isClosed() {
        return this.isClosed;
    }

    /* access modifiers changed from: protected */
    public final void setClosed(boolean z4) {
        this.isClosed = z4;
    }

    /* access modifiers changed from: protected */
    public final void throwIfClosed() {
        if (this.isClosed) {
            SQLite.throwSQLiteException(21, "statement is closed");
            throw new C2219h();
        }
    }

    private AndroidSQLiteStatement(SQLiteDatabase sQLiteDatabase, String str) {
        this.db = sQLiteDatabase;
        this.sql = str;
    }
}
