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
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class WorkTagDao_Impl implements WorkTagDao {
    public static final Companion Companion = new Companion((C2633k) null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<WorkTag> __insertAdapterOfWorkTag = new EntityInsertAdapter<WorkTag>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, WorkTag workTag) {
            t.e(sQLiteStatement, "statement");
            t.e(workTag, "entity");
            sQLiteStatement.bindText(1, workTag.getTag());
            sQLiteStatement.bindText(2, workTag.getWorkSpecId());
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

    public WorkTagDao_Impl(RoomDatabase roomDatabase) {
        t.e(roomDatabase, "__db");
        this.__db = roomDatabase;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static final J deleteByWorkSpecId$lambda$3(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            prepare.step();
            prepare.close();
            return J.f19942a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final List getTagsForWorkSpecId$lambda$2(String str, String str2, SQLiteConnection sQLiteConnection) {
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
    public static final List getWorkSpecIdsWithTag$lambda$1(String str, String str2, SQLiteConnection sQLiteConnection) {
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
    public static final J insert$lambda$0(WorkTagDao_Impl workTagDao_Impl, WorkTag workTag, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        workTagDao_Impl.__insertAdapterOfWorkTag.insert(sQLiteConnection, workTag);
        return J.f19942a;
    }

    public void deleteByWorkSpecId(String str) {
        t.e(str, "id");
        DBUtil.performBlocking(this.__db, false, true, new y0("DELETE FROM worktag WHERE work_spec_id=?", str));
    }

    public List<String> getTagsForWorkSpecId(String str) {
        t.e(str, "id");
        return (List) DBUtil.performBlocking(this.__db, true, false, new z0("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", str));
    }

    public List<String> getWorkSpecIdsWithTag(String str) {
        t.e(str, "tag");
        return (List) DBUtil.performBlocking(this.__db, true, false, new B0("SELECT work_spec_id FROM worktag WHERE tag=?", str));
    }

    public void insert(WorkTag workTag) {
        t.e(workTag, "workTag");
        DBUtil.performBlocking(this.__db, false, true, new A0(this, workTag));
    }

    public /* synthetic */ void insertTags(String str, Set set) {
        x0.a(this, str, set);
    }
}
