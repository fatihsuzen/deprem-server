package androidx.room.util;

import W2.J;
import X2.C2250q;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import b3.C2308e;
import i3.C2579a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k3.p;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import t3.s;

final /* synthetic */ class DBUtil__DBUtilKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void dropFtsSyncTriggers(SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "connection");
        List c5 = C2250q.c();
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (prepare.step()) {
            try {
                c5.add(prepare.getText(0));
            } catch (Throwable th) {
                C2579a.a(prepare, th);
                throw th;
            }
        }
        J j5 = J.f19942a;
        C2579a.a(prepare, (Throwable) null);
        for (String str : C2250q.a(c5)) {
            if (s.P(str, "room_fts_content_sync_", false, 2, (Object) null)) {
                SQLite.execSQL(sQLiteConnection, "DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        i3.C2579a.a(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        throw r0;
     */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void foreignKeyCheck(androidx.sqlite.SQLiteConnection r2, java.lang.String r3) {
        /*
            java.lang.String r0 = "db"
            kotlin.jvm.internal.t.e(r2, r0)
            java.lang.String r0 = "tableName"
            kotlin.jvm.internal.t.e(r3, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "PRAGMA foreign_key_check(`"
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = "`)"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            androidx.sqlite.SQLiteStatement r2 = r2.prepare(r3)
            boolean r3 = r2.step()     // Catch:{ all -> 0x0031 }
            if (r3 != 0) goto L_0x0033
            W2.J r3 = W2.J.f19942a     // Catch:{ all -> 0x0031 }
            r3 = 0
            i3.C2579a.a(r2, r3)
            return
        L_0x0031:
            r3 = move-exception
            goto L_0x003d
        L_0x0033:
            java.lang.String r3 = processForeignKeyCheckFailure$DBUtil__DBUtilKt(r2)     // Catch:{ all -> 0x0031 }
            android.database.SQLException r0 = new android.database.SQLException     // Catch:{ all -> 0x0031 }
            r0.<init>(r3)     // Catch:{ all -> 0x0031 }
            throw r0     // Catch:{ all -> 0x0031 }
        L_0x003d:
            throw r3     // Catch:{ all -> 0x003e }
        L_0x003e:
            r0 = move-exception
            i3.C2579a.a(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtilKt.foreignKeyCheck(androidx.sqlite.SQLiteConnection, java.lang.String):void");
    }

    public static final <R> Object internalPerform(RoomDatabase roomDatabase, boolean z4, boolean z5, p pVar, C2308e eVar) {
        RoomDatabase roomDatabase2 = roomDatabase;
        boolean z6 = z4;
        return roomDatabase2.useConnection$room_runtime_release(z6, new DBUtil__DBUtilKt$internalPerform$2(z5, z6, roomDatabase2, pVar, (C2308e) null), eVar);
    }

    private static final <R> Object internalPerform$$forInline(RoomDatabase roomDatabase, boolean z4, boolean z5, p pVar, C2308e eVar) {
        RoomDatabase roomDatabase2 = roomDatabase;
        boolean z6 = z4;
        DBUtil__DBUtilKt$internalPerform$2 dBUtil__DBUtilKt$internalPerform$2 = new DBUtil__DBUtilKt$internalPerform$2(z5, z6, roomDatabase2, pVar, (C2308e) null);
        r.c(0);
        Object useConnection$room_runtime_release = roomDatabase2.useConnection$room_runtime_release(z6, dBUtil__DBUtilKt$internalPerform$2, eVar);
        r.c(1);
        return useConnection$room_runtime_release;
    }

    private static final String processForeignKeyCheckFailure$DBUtil__DBUtilKt(SQLiteStatement sQLiteStatement) {
        StringBuilder sb = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i5 = 0;
        do {
            if (i5 == 0) {
                sb.append("Foreign key violation(s) detected in '");
                sb.append(sQLiteStatement.getText(0));
                sb.append("'.\n");
            }
            String text = sQLiteStatement.getText(3);
            if (!linkedHashMap.containsKey(text)) {
                linkedHashMap.put(text, sQLiteStatement.getText(2));
            }
            i5++;
        } while (sQLiteStatement.step());
        sb.append("Number of different violations discovered: ");
        sb.append(linkedHashMap.keySet().size());
        sb.append("\n");
        sb.append("Number of rows in violation: ");
        sb.append(i5);
        sb.append("\n");
        sb.append("Violation(s) detected in the following constraint(s):\n");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            sb.append("\tParent Table = ");
            sb.append((String) entry.getValue());
            sb.append(", Foreign Key Constraint Index = ");
            sb.append((String) entry.getKey());
            sb.append("\n");
        }
        return sb.toString();
    }
}
