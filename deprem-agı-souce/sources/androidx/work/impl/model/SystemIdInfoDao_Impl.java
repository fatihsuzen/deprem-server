package androidx.work.impl.model;

import W2.J;
import X2.C2250q;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class SystemIdInfoDao_Impl implements SystemIdInfoDao {
    public static final Companion Companion = new Companion((C2633k) null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<SystemIdInfo> __insertAdapterOfSystemIdInfo = new EntityInsertAdapter<SystemIdInfo>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, SystemIdInfo systemIdInfo) {
            t.e(sQLiteStatement, "statement");
            t.e(systemIdInfo, "entity");
            sQLiteStatement.bindText(1, systemIdInfo.workSpecId);
            sQLiteStatement.bindLong(2, (long) systemIdInfo.getGeneration());
            sQLiteStatement.bindLong(3, (long) systemIdInfo.systemId);
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

    public SystemIdInfoDao_Impl(RoomDatabase roomDatabase) {
        t.e(roomDatabase, "__db");
        this.__db = roomDatabase;
    }

    /* access modifiers changed from: private */
    public static final SystemIdInfo getSystemIdInfo$lambda$1(String str, String str2, int i5, SQLiteConnection sQLiteConnection) {
        SystemIdInfo systemIdInfo;
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            prepare.bindLong(2, (long) i5);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "work_spec_id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "generation");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "system_id");
            if (prepare.step()) {
                systemIdInfo = new SystemIdInfo(prepare.getText(columnIndexOrThrow), (int) prepare.getLong(columnIndexOrThrow2), (int) prepare.getLong(columnIndexOrThrow3));
            } else {
                systemIdInfo = null;
            }
            return systemIdInfo;
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final List getWorkSpecIds$lambda$2(String str, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
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
    public static final J insertSystemIdInfo$lambda$0(SystemIdInfoDao_Impl systemIdInfoDao_Impl, SystemIdInfo systemIdInfo, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        systemIdInfoDao_Impl.__insertAdapterOfSystemIdInfo.insert(sQLiteConnection, systemIdInfo);
        return J.f19942a;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static final J removeSystemIdInfo$lambda$3(String str, String str2, int i5, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            prepare.bindLong(2, (long) i5);
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
    public static final J removeSystemIdInfo$lambda$4(String str, String str2, SQLiteConnection sQLiteConnection) {
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

    public /* synthetic */ SystemIdInfo getSystemIdInfo(WorkGenerationalId workGenerationalId) {
        return C0440n.a(this, workGenerationalId);
    }

    public List<String> getWorkSpecIds() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new C0442p("SELECT DISTINCT work_spec_id FROM SystemIdInfo"));
    }

    public void insertSystemIdInfo(SystemIdInfo systemIdInfo) {
        t.e(systemIdInfo, "systemIdInfo");
        DBUtil.performBlocking(this.__db, false, true, new C0441o(this, systemIdInfo));
    }

    public /* synthetic */ void removeSystemIdInfo(WorkGenerationalId workGenerationalId) {
        C0440n.b(this, workGenerationalId);
    }

    public SystemIdInfo getSystemIdInfo(String str, int i5) {
        t.e(str, "workSpecId");
        return (SystemIdInfo) DBUtil.performBlocking(this.__db, true, false, new r("SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?", str, i5));
    }

    public void removeSystemIdInfo(String str, int i5) {
        t.e(str, "workSpecId");
        DBUtil.performBlocking(this.__db, false, true, new C0443q("DELETE FROM SystemIdInfo where work_spec_id=? AND generation=?", str, i5));
    }

    public void removeSystemIdInfo(String str) {
        t.e(str, "workSpecId");
        DBUtil.performBlocking(this.__db, false, true, new C0444s("DELETE FROM SystemIdInfo where work_spec_id=?", str));
    }
}
