package androidx.room.util;

import W2.s;
import X2.C2250q;
import X2.M;
import androidx.annotation.RestrictTo;
import androidx.room.DatabaseConfiguration;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MigrationUtil {
    public static final boolean contains(RoomDatabase.MigrationContainer migrationContainer, int i5, int i6) {
        t.e(migrationContainer, "<this>");
        Map<Integer, Map<Integer, Migration>> migrations = migrationContainer.getMigrations();
        if (!migrations.containsKey(Integer.valueOf(i5))) {
            return false;
        }
        Map map = migrations.get(Integer.valueOf(i5));
        if (map == null) {
            map = M.h();
        }
        return map.containsKey(Integer.valueOf(i6));
    }

    public static final List<Migration> findMigrationPath(RoomDatabase.MigrationContainer migrationContainer, int i5, int i6) {
        boolean z4;
        t.e(migrationContainer, "<this>");
        if (i5 == i6) {
            return C2250q.g();
        }
        if (i6 > i5) {
            z4 = true;
        } else {
            z4 = false;
        }
        return findUpMigrationPath(migrationContainer, new ArrayList(), z4, i5, i6);
    }

    private static final List<Migration> findUpMigrationPath(RoomDatabase.MigrationContainer migrationContainer, List<Migration> list, boolean z4, int i5, int i6) {
        s sVar;
        int i7;
        boolean z5;
        while (true) {
            if (z4) {
                if (i5 >= i6) {
                    return list;
                }
            } else if (i5 <= i6) {
                return list;
            }
            if (z4) {
                sVar = migrationContainer.getSortedDescendingNodes$room_runtime_release(i5);
            } else {
                sVar = migrationContainer.getSortedNodes$room_runtime_release(i5);
            }
            if (sVar == null) {
                return null;
            }
            Map map = (Map) sVar.a();
            Iterator it = ((Iterable) sVar.b()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    i7 = i5;
                    z5 = false;
                    break;
                }
                i7 = ((Number) it.next()).intValue();
                if (!z4) {
                    if (i6 <= i7 && i7 < i5) {
                        break;
                    }
                } else if (i5 + 1 <= i7 && i7 <= i6) {
                    break;
                }
            }
            Object obj = map.get(Integer.valueOf(i7));
            t.b(obj);
            list.add(obj);
            z5 = true;
            if (!z5) {
                return null;
            }
            i5 = i7;
        }
    }

    public static final boolean isMigrationRequired(DatabaseConfiguration databaseConfiguration, int i5, int i6) {
        t.e(databaseConfiguration, "<this>");
        if (i5 > i6 && databaseConfiguration.allowDestructiveMigrationOnDowngrade) {
            return false;
        }
        Set<Integer> migrationNotRequiredFrom$room_runtime_release = databaseConfiguration.getMigrationNotRequiredFrom$room_runtime_release();
        if (!databaseConfiguration.requireMigration || (migrationNotRequiredFrom$room_runtime_release != null && migrationNotRequiredFrom$room_runtime_release.contains(Integer.valueOf(i5)))) {
            return false;
        }
        return true;
    }
}
