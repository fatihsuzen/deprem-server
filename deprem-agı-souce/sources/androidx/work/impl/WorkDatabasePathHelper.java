package androidx.work.impl;

import W2.s;
import W2.y;
import X2.M;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.t;
import q3.C2729e;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class WorkDatabasePathHelper {
    public static final WorkDatabasePathHelper INSTANCE = new WorkDatabasePathHelper();

    private WorkDatabasePathHelper() {
    }

    public static final void migrateDatabase(Context context) {
        String str;
        t.e(context, "context");
        WorkDatabasePathHelper workDatabasePathHelper = INSTANCE;
        if (workDatabasePathHelper.getDefaultDatabasePath(context).exists()) {
            Logger.get().debug(WorkDatabasePathHelperKt.TAG, "Migrating WorkDatabase to the no-backup directory");
            for (Map.Entry next : workDatabasePathHelper.migrationPaths(context).entrySet()) {
                File file = (File) next.getKey();
                File file2 = (File) next.getValue();
                if (file.exists()) {
                    if (file2.exists()) {
                        Logger.get().warning(WorkDatabasePathHelperKt.TAG, "Over-writing contents of " + file2);
                    }
                    if (file.renameTo(file2)) {
                        str = "Migrated " + file + "to " + file2;
                    } else {
                        str = "Renaming " + file + " to " + file2 + " failed";
                    }
                    Logger.get().debug(WorkDatabasePathHelperKt.TAG, str);
                }
            }
        }
    }

    public final File getDatabasePath(Context context) {
        t.e(context, "context");
        File noBackupFilesDir = context.getNoBackupFilesDir();
        t.d(noBackupFilesDir, "getNoBackupFilesDir(...)");
        return noBackupFilesDir;
    }

    public final File getDefaultDatabasePath(Context context) {
        t.e(context, "context");
        File databasePath = context.getDatabasePath(WorkDatabasePathHelperKt.WORK_DATABASE_NAME);
        t.d(databasePath, "getDatabasePath(...)");
        return databasePath;
    }

    public final Map<File, File> migrationPaths(Context context) {
        t.e(context, "context");
        File defaultDatabasePath = getDefaultDatabasePath(context);
        File databasePath = getDatabasePath(context);
        String[] access$getDATABASE_EXTRA_FILES$p = WorkDatabasePathHelperKt.DATABASE_EXTRA_FILES;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C2729e.c(M.e(access$getDATABASE_EXTRA_FILES$p.length), 16));
        for (String str : access$getDATABASE_EXTRA_FILES$p) {
            s a5 = y.a(new File(defaultDatabasePath.getPath() + str), new File(databasePath.getPath() + str));
            linkedHashMap.put(a5.c(), a5.d());
        }
        return M.n(linkedHashMap, y.a(defaultDatabasePath, databasePath));
    }
}
