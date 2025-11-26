package androidx.work.impl.model;

import W2.J;
import X2.C2250q;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class DependencyDao_Impl implements DependencyDao {
    public static final Companion Companion = new Companion((C2633k) null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<Dependency> __insertAdapterOfDependency = new EntityInsertAdapter<Dependency>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, Dependency dependency) {
            t.e(sQLiteStatement, "statement");
            t.e(dependency, "entity");
            sQLiteStatement.bindText(1, dependency.getWorkSpecId());
            sQLiteStatement.bindText(2, dependency.getPrerequisiteId());
        }
    };

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final List<C2733c> getRequiredConverters() {
            return C2250q.g();
        }

        private Companion() {
        }
    }

    public DependencyDao_Impl(RoomDatabase roomDatabase) {
        t.e(roomDatabase, "__db");
        this.__db = roomDatabase;
    }

    /* access modifiers changed from: private */
    public static final List getDependentWorkIds$lambda$3(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(prepare.getText(0));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final List getPrerequisites$lambda$2(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(prepare.getText(0));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final boolean hasCompletedAllPrerequisites$lambda$1(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        boolean z4 = true;
        try {
            prepare.bindText(1, str2);
            boolean z5 = false;
            if (prepare.step()) {
                if (((int) prepare.getLong(0)) == 0) {
                    z4 = false;
                }
                z5 = z4;
            }
            return z5;
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final boolean hasDependents$lambda$4(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        boolean z4 = true;
        try {
            prepare.bindText(1, str2);
            boolean z5 = false;
            if (prepare.step()) {
                if (((int) prepare.getLong(0)) == 0) {
                    z4 = false;
                }
                z5 = z4;
            }
            return z5;
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final J insertDependency$lambda$0(DependencyDao_Impl dependencyDao_Impl, Dependency dependency, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        dependencyDao_Impl.__insertAdapterOfDependency.insert(sQLiteConnection, dependency);
        return J.f19942a;
    }

    public List<String> getDependentWorkIds(String str) {
        t.e(str, "id");
        return (List) DBUtil.performBlocking(this.__db, true, false, new C0425a("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", str));
    }

    public List<String> getPrerequisites(String str) {
        t.e(str, "id");
        return (List) DBUtil.performBlocking(this.__db, true, false, new C0431e("SELECT prerequisite_id FROM dependency WHERE work_spec_id=?", str));
    }

    public boolean hasCompletedAllPrerequisites(String str) {
        t.e(str, "id");
        return ((Boolean) DBUtil.performBlocking(this.__db, true, false, new C0430d("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", str))).booleanValue();
    }

    public boolean hasDependents(String str) {
        t.e(str, "id");
        return ((Boolean) DBUtil.performBlocking(this.__db, true, false, new C0429c("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", str))).booleanValue();
    }

    public void insertDependency(Dependency dependency) {
        t.e(dependency, "dependency");
        DBUtil.performBlocking(this.__db, false, true, new C0427b(this, dependency));
    }
}
