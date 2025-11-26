package androidx.room.paging;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteStatement;
import j.a;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CursorSQLiteStatement implements SQLiteStatement {
    public static final Companion Companion = new Companion((C2633k) null);
    private final Cursor cursor;

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

    public CursorSQLiteStatement(Cursor cursor2) {
        t.e(cursor2, "cursor");
        this.cursor = cursor2;
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

    public void close() {
        this.cursor.close();
    }

    public byte[] getBlob(int i5) {
        byte[] blob = this.cursor.getBlob(i5);
        t.d(blob, "getBlob(...)");
        return blob;
    }

    public /* synthetic */ boolean getBoolean(int i5) {
        return a.d(this, i5);
    }

    public int getColumnCount() {
        return this.cursor.getColumnCount();
    }

    public String getColumnName(int i5) {
        String columnName = this.cursor.getColumnName(i5);
        t.d(columnName, "getColumnName(...)");
        return columnName;
    }

    public /* synthetic */ List getColumnNames() {
        return a.e(this);
    }

    public int getColumnType(int i5) {
        return Companion.getDataType(this.cursor, i5);
    }

    public double getDouble(int i5) {
        return this.cursor.getDouble(i5);
    }

    public /* synthetic */ float getFloat(int i5) {
        return a.f(this, i5);
    }

    public /* synthetic */ int getInt(int i5) {
        return a.g(this, i5);
    }

    public long getLong(int i5) {
        return this.cursor.getLong(i5);
    }

    public String getText(int i5) {
        String string = this.cursor.getString(i5);
        t.d(string, "getString(...)");
        return string;
    }

    public boolean isNull(int i5) {
        return this.cursor.isNull(i5);
    }

    public void reset() {
        this.cursor.moveToPosition(-1);
    }

    public boolean step() {
        return this.cursor.moveToNext();
    }

    public Void bindBlob(int i5, byte[] bArr) {
        t.e(bArr, "value");
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    public Void bindDouble(int i5, double d5) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    public Void bindLong(int i5, long j5) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    public Void bindNull(int i5) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    public Void bindText(int i5, String str) {
        t.e(str, "value");
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    public Void clearBindings() {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }
}
