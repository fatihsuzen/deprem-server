package androidx.work.impl.model;

import W2.J;
import X2.C2250q;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.work.Data;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class WorkProgressDao_Impl implements WorkProgressDao {
    public static final Companion Companion = new Companion((C2633k) null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<WorkProgress> __insertAdapterOfWorkProgress = new EntityInsertAdapter<WorkProgress>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, WorkProgress workProgress) {
            t.e(sQLiteStatement, "statement");
            t.e(workProgress, "entity");
            sQLiteStatement.bindText(1, workProgress.getWorkSpecId());
            sQLiteStatement.bindBlob(2, Data.Companion.toByteArrayInternalV1(workProgress.getProgress()));
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

    public WorkProgressDao_Impl(RoomDatabase roomDatabase) {
        t.e(roomDatabase, "__db");
        this.__db = roomDatabase;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static final J delete$lambda$2(String str, String str2, SQLiteConnection sQLiteConnection) {
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

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static final J deleteAll$lambda$3(String str, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.step();
            prepare.close();
            return J.f19942a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final Data getProgressForWorkSpecId$lambda$1(String str, String str2, SQLiteConnection sQLiteConnection) {
        byte[] bArr;
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            Data data = null;
            if (prepare.step()) {
                if (prepare.isNull(0)) {
                    bArr = null;
                } else {
                    bArr = prepare.getBlob(0);
                }
                if (bArr != null) {
                    data = Data.Companion.fromByteArray(bArr);
                }
            }
            return data;
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final J insert$lambda$0(WorkProgressDao_Impl workProgressDao_Impl, WorkProgress workProgress, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        workProgressDao_Impl.__insertAdapterOfWorkProgress.insert(sQLiteConnection, workProgress);
        return J.f19942a;
    }

    public void delete(String str) {
        t.e(str, "workSpecId");
        DBUtil.performBlocking(this.__db, false, true, new C0450y("DELETE from WorkProgress where work_spec_id=?", str));
    }

    public void deleteAll() {
        DBUtil.performBlocking(this.__db, false, true, new C0449x("DELETE FROM WorkProgress"));
    }

    public Data getProgressForWorkSpecId(String str) {
        t.e(str, "workSpecId");
        return (Data) DBUtil.performBlocking(this.__db, true, false, new C0448w("SELECT progress FROM WorkProgress WHERE work_spec_id=?", str));
    }

    public void insert(WorkProgress workProgress) {
        t.e(workProgress, "progress");
        DBUtil.performBlocking(this.__db, false, true, new C0451z(this, workProgress));
    }
}
