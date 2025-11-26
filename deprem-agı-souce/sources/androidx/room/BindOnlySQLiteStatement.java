package androidx.room;

import androidx.annotation.IntRange;
import androidx.sqlite.SQLiteStatement;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

final class BindOnlySQLiteStatement implements SQLiteStatement {
    public static final Companion Companion = new Companion((C2633k) null);
    private static final String ONLY_BIND_CALLS_ALLOWED_ERROR = "Only bind*() calls are allowed on the RoomRawQuery received statement.";
    private final /* synthetic */ SQLiteStatement $$delegate_0;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    public BindOnlySQLiteStatement(SQLiteStatement sQLiteStatement) {
        t.e(sQLiteStatement, "delegate");
        this.$$delegate_0 = sQLiteStatement;
    }

    public void bindBlob(@IntRange(from = 1) int i5, byte[] bArr) {
        t.e(bArr, "value");
        this.$$delegate_0.bindBlob(i5, bArr);
    }

    public void bindBoolean(@IntRange(from = 1) int i5, boolean z4) {
        this.$$delegate_0.bindBoolean(i5, z4);
    }

    public void bindDouble(@IntRange(from = 1) int i5, double d5) {
        this.$$delegate_0.bindDouble(i5, d5);
    }

    public void bindFloat(@IntRange(from = 1) int i5, float f5) {
        this.$$delegate_0.bindFloat(i5, f5);
    }

    public void bindInt(@IntRange(from = 1) int i5, int i6) {
        this.$$delegate_0.bindInt(i5, i6);
    }

    public void bindLong(@IntRange(from = 1) int i5, long j5) {
        this.$$delegate_0.bindLong(i5, j5);
    }

    public void bindNull(@IntRange(from = 1) int i5) {
        this.$$delegate_0.bindNull(i5);
    }

    public void bindText(@IntRange(from = 1) int i5, String str) {
        t.e(str, "value");
        this.$$delegate_0.bindText(i5, str);
    }

    public void clearBindings() {
        this.$$delegate_0.clearBindings();
    }

    public void close() {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    public byte[] getBlob(int i5) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    public boolean getBoolean(@IntRange(from = 0) int i5) {
        return this.$$delegate_0.getBoolean(i5);
    }

    public int getColumnCount() {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    public String getColumnName(int i5) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    public List<String> getColumnNames() {
        return this.$$delegate_0.getColumnNames();
    }

    public int getColumnType(int i5) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    public double getDouble(int i5) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    public float getFloat(@IntRange(from = 0) int i5) {
        return this.$$delegate_0.getFloat(i5);
    }

    public int getInt(@IntRange(from = 0) int i5) {
        return this.$$delegate_0.getInt(i5);
    }

    public long getLong(int i5) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    public String getText(int i5) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    public boolean isNull(int i5) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    public void reset() {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    public boolean step() {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }
}
