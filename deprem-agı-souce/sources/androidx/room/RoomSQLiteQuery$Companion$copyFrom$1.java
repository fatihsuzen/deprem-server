package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import kotlin.jvm.internal.t;

public final class RoomSQLiteQuery$Companion$copyFrom$1 implements SupportSQLiteProgram {
    private final /* synthetic */ RoomSQLiteQuery $$delegate_0;

    RoomSQLiteQuery$Companion$copyFrom$1(RoomSQLiteQuery roomSQLiteQuery) {
        this.$$delegate_0 = roomSQLiteQuery;
    }

    public void bindBlob(int i5, byte[] bArr) {
        t.e(bArr, "value");
        this.$$delegate_0.bindBlob(i5, bArr);
    }

    public void bindDouble(int i5, double d5) {
        this.$$delegate_0.bindDouble(i5, d5);
    }

    public void bindLong(int i5, long j5) {
        this.$$delegate_0.bindLong(i5, j5);
    }

    public void bindNull(int i5) {
        this.$$delegate_0.bindNull(i5);
    }

    public void bindString(int i5, String str) {
        t.e(str, "value");
        this.$$delegate_0.bindString(i5, str);
    }

    public void clearBindings() {
        this.$$delegate_0.clearBindings();
    }

    public void close() {
        this.$$delegate_0.close();
    }
}
