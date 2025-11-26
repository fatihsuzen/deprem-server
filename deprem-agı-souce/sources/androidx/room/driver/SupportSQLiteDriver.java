package androidx.room.driver;

import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SupportSQLiteDriver implements SQLiteDriver {
    private final SupportSQLiteOpenHelper openHelper;

    public SupportSQLiteDriver(SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        t.e(supportSQLiteOpenHelper, "openHelper");
        this.openHelper = supportSQLiteOpenHelper;
    }

    public final SupportSQLiteOpenHelper getOpenHelper() {
        return this.openHelper;
    }

    public SupportSQLiteConnection open(String str) {
        t.e(str, "fileName");
        return new SupportSQLiteConnection(this.openHelper.getWritableDatabase());
    }
}
