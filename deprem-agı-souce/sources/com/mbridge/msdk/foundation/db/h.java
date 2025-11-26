package com.mbridge.msdk.foundation.db;

import com.mbridge.msdk.out.Campaign;

public class h extends a<Campaign> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8976a = "com.mbridge.msdk.foundation.db.h";

    /* renamed from: b  reason: collision with root package name */
    private static h f8977b;

    private h(f fVar) {
        super(fVar);
    }

    public static h a(f fVar) {
        if (f8977b == null) {
            synchronized (h.class) {
                try {
                    if (f8977b == null) {
                        f8977b = new h(fVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8977b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean b(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            java.lang.String r1 = "SELECT play_time FROM dailyplaycap WHERE unit_id= ?"
            android.database.sqlite.SQLiteDatabase r2 = r3.getReadableDatabase()     // Catch:{ all -> 0x0025 }
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ all -> 0x0025 }
            android.database.Cursor r4 = r2.rawQuery(r1, r4)     // Catch:{ all -> 0x0025 }
            if (r4 == 0) goto L_0x001e
            int r1 = r4.getCount()     // Catch:{ all -> 0x0025 }
            if (r1 <= 0) goto L_0x001e
            r4.close()     // Catch:{ all -> 0x0025 }
            monitor-exit(r3)
            r4 = 1
            return r4
        L_0x001e:
            if (r4 == 0) goto L_0x0023
            r4.close()     // Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r3)
            return r0
        L_0x0025:
            monitor-exit(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.h.b(java.lang.String):boolean");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void c(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            monitor-enter(r4)
            android.database.sqlite.SQLiteDatabase r1 = r4.getWritableDatabase()     // Catch:{ all -> 0x002d }
            if (r1 != 0) goto L_0x000e
            monitor-exit(r4)
            return
        L_0x000e:
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ all -> 0x002d }
            r1.<init>()     // Catch:{ all -> 0x002d }
            java.lang.String r2 = "first_insert_timestamp"
            r1.put(r2, r0)     // Catch:{ all -> 0x002d }
            java.lang.String r2 = "play_time"
            r1.put(r2, r0)     // Catch:{ all -> 0x002d }
            java.lang.String r0 = "unit_id = ?"
            android.database.sqlite.SQLiteDatabase r2 = r4.getWritableDatabase()     // Catch:{ all -> 0x002d }
            java.lang.String r3 = "dailyplaycap"
            java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch:{ all -> 0x002d }
            r2.update(r3, r1, r0, r5)     // Catch:{ all -> 0x002d }
            goto L_0x0034
        L_0x002d:
            java.lang.String r5 = f8976a     // Catch:{ all -> 0x0036 }
            java.lang.String r0 = "resetTimeAndTimestamp error"
            com.mbridge.msdk.foundation.tools.af.c(r5, r0)     // Catch:{ all -> 0x0036 }
        L_0x0034:
            monitor-exit(r4)
            return
        L_0x0036:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.h.c(java.lang.String):void");
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String, android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a8, code lost:
        if (r1 != 0) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b1, code lost:
        if (r1 == 0) goto L_0x00b4;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00bb */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r16) {
        /*
            r15 = this;
            monitor-enter(r15)
            r1 = 0
            android.database.sqlite.SQLiteDatabase r0 = r15.getWritableDatabase()     // Catch:{ Exception -> 0x005b }
            if (r0 != 0) goto L_0x000a
            monitor-exit(r15)
            return
        L_0x000a:
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch:{ Exception -> 0x005b }
            r0.<init>()     // Catch:{ Exception -> 0x005b }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x005b }
            boolean r4 = r15.b(r16)     // Catch:{ Exception -> 0x005b }
            r5 = 1
            if (r4 == 0) goto L_0x0086
            java.lang.String r4 = "SELECT * FROM dailyplaycap where unit_id = ?"
            android.database.sqlite.SQLiteDatabase r7 = r15.getReadableDatabase()     // Catch:{ Exception -> 0x005b }
            java.lang.String[] r8 = new java.lang.String[]{r16}     // Catch:{ Exception -> 0x005b }
            android.database.Cursor r1 = r7.rawQuery(r4, r8)     // Catch:{ Exception -> 0x005b }
            r7 = 0
            if (r1 == 0) goto L_0x005d
            int r4 = r1.getCount()     // Catch:{ Exception -> 0x005b }
            if (r4 <= 0) goto L_0x005d
            r1.moveToFirst()     // Catch:{ Exception -> 0x005b }
            java.lang.String r4 = "first_insert_timestamp"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ Exception -> 0x005b }
            long r9 = r1.getLong(r4)     // Catch:{ Exception -> 0x005b }
            java.lang.String r4 = "play_time"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ Exception -> 0x005b }
            int r4 = r1.getInt(r4)     // Catch:{ Exception -> 0x005b }
            long r11 = (long) r4     // Catch:{ Exception -> 0x005b }
            r13 = 86400000(0x5265c00, double:4.2687272E-316)
            long r13 = r2 - r13
            int r4 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x005f
            r15.c(r16)     // Catch:{ Exception -> 0x005b }
            r11 = r7
            goto L_0x005f
        L_0x0059:
            r0 = move-exception
            goto L_0x00b6
        L_0x005b:
            r0 = move-exception
            goto L_0x00ae
        L_0x005d:
            r9 = r7
            r11 = r9
        L_0x005f:
            int r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r4 != 0) goto L_0x006c
            java.lang.String r4 = "first_insert_timestamp"
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x005b }
            r0.put(r4, r2)     // Catch:{ Exception -> 0x005b }
        L_0x006c:
            java.lang.String r2 = "play_time"
            long r11 = r11 + r5
            java.lang.Long r3 = java.lang.Long.valueOf(r11)     // Catch:{ Exception -> 0x005b }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x005b }
            java.lang.String r2 = "unit_id = ?"
            android.database.sqlite.SQLiteDatabase r3 = r15.getWritableDatabase()     // Catch:{ Exception -> 0x005b }
            java.lang.String r4 = "dailyplaycap"
            java.lang.String[] r5 = new java.lang.String[]{r16}     // Catch:{ Exception -> 0x005b }
            r3.update(r4, r0, r2, r5)     // Catch:{ Exception -> 0x005b }
            goto L_0x00a8
        L_0x0086:
            java.lang.String r4 = "first_insert_timestamp"
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x005b }
            r0.put(r4, r2)     // Catch:{ Exception -> 0x005b }
            java.lang.String r2 = "play_time"
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x005b }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x005b }
            java.lang.String r2 = "unit_id"
            r3 = r16
            r0.put(r2, r3)     // Catch:{ Exception -> 0x005b }
            android.database.sqlite.SQLiteDatabase r2 = r15.getWritableDatabase()     // Catch:{ Exception -> 0x005b }
            java.lang.String r3 = "dailyplaycap"
            r2.insert(r3, r1, r0)     // Catch:{ Exception -> 0x005b }
        L_0x00a8:
            if (r1 == 0) goto L_0x00b4
        L_0x00aa:
            r1.close()     // Catch:{ all -> 0x00b4 }
            goto L_0x00b4
        L_0x00ae:
            r0.printStackTrace()     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x00b4
            goto L_0x00aa
        L_0x00b4:
            monitor-exit(r15)
            return
        L_0x00b6:
            if (r1 == 0) goto L_0x00bb
            r1.close()     // Catch:{ all -> 0x00bb }
        L_0x00bb:
            throw r0     // Catch:{ all -> 0x00bc }
        L_0x00bc:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x00bc }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.h.a(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
        if (r0 != null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006f, code lost:
        if (r0 == null) goto L_0x0072;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r11, int r12) {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            java.lang.String r2 = "SELECT * FROM dailyplaycap where unit_id = ?"
            android.database.sqlite.SQLiteDatabase r3 = r10.getReadableDatabase()     // Catch:{ all -> 0x0049 }
            java.lang.String[] r4 = new java.lang.String[]{r11}     // Catch:{ all -> 0x0049 }
            android.database.Cursor r0 = r3.rawQuery(r2, r4)     // Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x0053
            int r2 = r0.getCount()     // Catch:{ all -> 0x0049 }
            if (r2 <= 0) goto L_0x0053
            boolean r2 = r0.moveToFirst()     // Catch:{ all -> 0x0049 }
            if (r2 == 0) goto L_0x0053
            java.lang.String r2 = "first_insert_timestamp"
            int r2 = r0.getColumnIndex(r2)     // Catch:{ all -> 0x0049 }
            long r2 = r0.getLong(r2)     // Catch:{ all -> 0x0049 }
            java.lang.String r4 = "play_time"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ all -> 0x0049 }
            int r4 = r0.getInt(r4)     // Catch:{ all -> 0x0049 }
            long r4 = (long) r4     // Catch:{ all -> 0x0049 }
            r6 = 0
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0053
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0049 }
            r8 = 86400000(0x5265c00, double:4.2687272E-316)
            long r6 = r6 - r8
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x004b
            r10.c(r11)     // Catch:{ all -> 0x0049 }
            goto L_0x0053
        L_0x0049:
            r11 = move-exception
            goto L_0x0059
        L_0x004b:
            if (r12 <= 0) goto L_0x0053
            long r11 = (long) r12
            int r11 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r11 < 0) goto L_0x0053
            r1 = 1
        L_0x0053:
            if (r0 == 0) goto L_0x0072
        L_0x0055:
            r0.close()     // Catch:{ all -> 0x0072 }
            goto L_0x0072
        L_0x0059:
            java.lang.String r12 = f8976a     // Catch:{ all -> 0x0073 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r2.<init>()     // Catch:{ all -> 0x0073 }
            java.lang.String r3 = "isOverCap is error"
            r2.append(r3)     // Catch:{ all -> 0x0073 }
            r2.append(r11)     // Catch:{ all -> 0x0073 }
            java.lang.String r11 = r2.toString()     // Catch:{ all -> 0x0073 }
            com.mbridge.msdk.foundation.tools.af.c(r12, r11)     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x0072
            goto L_0x0055
        L_0x0072:
            return r1
        L_0x0073:
            r11 = move-exception
            if (r0 == 0) goto L_0x0079
            r0.close()     // Catch:{ all -> 0x0079 }
        L_0x0079:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.h.a(java.lang.String, int):boolean");
    }
}
