package androidx.room.driver;

import androidx.room.driver.SupportSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import kotlin.jvm.internal.t;

public final class SupportSQLiteStatement$SupportAndroidSQLiteStatement$ensureCursor$1 implements SupportSQLiteQuery {
    final /* synthetic */ SupportSQLiteStatement.SupportAndroidSQLiteStatement this$0;

    SupportSQLiteStatement$SupportAndroidSQLiteStatement$ensureCursor$1(SupportSQLiteStatement.SupportAndroidSQLiteStatement supportAndroidSQLiteStatement) {
        this.this$0 = supportAndroidSQLiteStatement;
    }

    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        t.e(supportSQLiteProgram, "statement");
        int length = this.this$0.bindingTypes.length;
        for (int i5 = 1; i5 < length; i5++) {
            int i6 = this.this$0.bindingTypes[i5];
            if (i6 == 1) {
                supportSQLiteProgram.bindLong(i5, this.this$0.longBindings[i5]);
            } else if (i6 == 2) {
                supportSQLiteProgram.bindDouble(i5, this.this$0.doubleBindings[i5]);
            } else if (i6 == 3) {
                String str = this.this$0.stringBindings[i5];
                t.b(str);
                supportSQLiteProgram.bindString(i5, str);
            } else if (i6 == 4) {
                byte[] bArr = this.this$0.blobBindings[i5];
                t.b(bArr);
                supportSQLiteProgram.bindBlob(i5, bArr);
            } else if (i6 == 5) {
                supportSQLiteProgram.bindNull(i5);
            }
        }
    }

    public int getArgCount() {
        return this.this$0.bindingTypes.length;
    }

    public String getSql() {
        return this.this$0.getSql();
    }
}
