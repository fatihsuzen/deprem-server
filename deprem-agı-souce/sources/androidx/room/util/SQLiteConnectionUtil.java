package androidx.room.util;

public final class SQLiteConnectionUtil {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        i3.C2579a.a(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        throw r1;
     */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long getLastInsertedRowId(androidx.sqlite.SQLiteConnection r3) {
        /*
            java.lang.String r0 = "connection"
            kotlin.jvm.internal.t.e(r3, r0)
            int r0 = getTotalChangedRows(r3)
            if (r0 != 0) goto L_0x000e
            r0 = -1
            return r0
        L_0x000e:
            java.lang.String r0 = "SELECT last_insert_rowid()"
            androidx.sqlite.SQLiteStatement r3 = r3.prepare(r0)
            r3.step()     // Catch:{ all -> 0x0021 }
            r0 = 0
            long r0 = r3.getLong(r0)     // Catch:{ all -> 0x0021 }
            r2 = 0
            i3.C2579a.a(r3, r2)
            return r0
        L_0x0021:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r1 = move-exception
            i3.C2579a.a(r3, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.SQLiteConnectionUtil.getLastInsertedRowId(androidx.sqlite.SQLiteConnection):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        i3.C2579a.a(r2, r0);
     */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int getTotalChangedRows(androidx.sqlite.SQLiteConnection r2) {
        /*
            java.lang.String r0 = "connection"
            kotlin.jvm.internal.t.e(r2, r0)
            java.lang.String r0 = "SELECT changes()"
            androidx.sqlite.SQLiteStatement r2 = r2.prepare(r0)
            r2.step()     // Catch:{ all -> 0x0019 }
            r0 = 0
            long r0 = r2.getLong(r0)     // Catch:{ all -> 0x0019 }
            int r0 = (int) r0
            r1 = 0
            i3.C2579a.a(r2, r1)
            return r0
        L_0x0019:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x001b }
        L_0x001b:
            r1 = move-exception
            i3.C2579a.a(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.SQLiteConnectionUtil.getTotalChangedRows(androidx.sqlite.SQLiteConnection):int");
    }
}
