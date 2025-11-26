package androidx.room.support;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import kotlin.jvm.internal.t;

public final class PrePackagedCopyOpenHelper$createFrameworkOpenHelper$configuration$1 extends SupportSQLiteOpenHelper.Callback {
    final /* synthetic */ int $version;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PrePackagedCopyOpenHelper$createFrameworkOpenHelper$configuration$1(int i5, int i6) {
        super(i6);
        this.$version = i5;
    }

    public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "db");
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "db");
        int i5 = this.$version;
        if (i5 < 1) {
            supportSQLiteDatabase.setVersion(i5);
        }
    }

    public void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i5, int i6) {
        t.e(supportSQLiteDatabase, "db");
    }
}
