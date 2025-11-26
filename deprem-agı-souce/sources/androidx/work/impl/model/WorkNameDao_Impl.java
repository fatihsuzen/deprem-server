package androidx.work.impl.model;

import W2.J;
import X2.C2250q;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class WorkNameDao_Impl implements WorkNameDao {
    public static final Companion Companion = new Companion((C2633k) null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<WorkName> __insertAdapterOfWorkName = new EntityInsertAdapter<WorkName>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, WorkName workName) {
            t.e(sQLiteStatement, "statement");
            t.e(workName, "entity");
            sQLiteStatement.bindText(1, workName.getName());
            sQLiteStatement.bindText(2, workName.getWorkSpecId());
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

    public WorkNameDao_Impl(RoomDatabase roomDatabase) {
        t.e(roomDatabase, "__db");
        this.__db = roomDatabase;
    }

    /* access modifiers changed from: private */
    public static final List getNamesForWorkSpecId$lambda$2(String str, String str2, SQLiteConnection sQLiteConnection) {
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
    public static final List getWorkSpecIdsWithName$lambda$1(String str, String str2, SQLiteConnection sQLiteConnection) {
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
    public static final J insert$lambda$0(WorkNameDao_Impl workNameDao_Impl, WorkName workName, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        workNameDao_Impl.__insertAdapterOfWorkName.insert(sQLiteConnection, workName);
        return J.f19942a;
    }

    public List<String> getNamesForWorkSpecId(String str) {
        t.e(str, "workSpecId");
        return (List) DBUtil.performBlocking(this.__db, true, false, new C0446u("SELECT name FROM workname WHERE work_spec_id=?", str));
    }

    public List<String> getWorkSpecIdsWithName(String str) {
        t.e(str, RewardPlus.NAME);
        return (List) DBUtil.performBlocking(this.__db, true, false, new C0445t("SELECT work_spec_id FROM workname WHERE name=?", str));
    }

    public void insert(WorkName workName) {
        t.e(workName, "workName");
        DBUtil.performBlocking(this.__db, false, true, new C0447v(this, workName));
    }
}
