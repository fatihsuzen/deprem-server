package androidx.work.impl;

import android.content.Context;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.utils.IdGeneratorKt;
import androidx.work.impl.utils.PreferenceUtils;
import kotlin.jvm.internal.t;

public final class WorkMigration9To10 extends Migration {
    private final Context context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WorkMigration9To10(Context context2) {
        super(9, 10);
        t.e(context2, "context");
        this.context = context2;
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "db");
        supportSQLiteDatabase.execSQL(PreferenceUtils.CREATE_PREFERENCE);
        PreferenceUtils.migrateLegacyPreferences(this.context, supportSQLiteDatabase);
        IdGeneratorKt.migrateLegacyIdGenerator(this.context, supportSQLiteDatabase);
    }
}
