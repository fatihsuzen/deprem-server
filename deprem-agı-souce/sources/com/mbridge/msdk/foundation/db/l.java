package com.mbridge.msdk.foundation.db;

import android.database.Cursor;

public class l extends a {

    /* renamed from: a  reason: collision with root package name */
    private static l f8982a;

    private l(f fVar) {
        super(fVar);
    }

    public static l a(f fVar) {
        if (f8982a == null) {
            synchronized (l.class) {
                try {
                    if (f8982a == null) {
                        f8982a = new l(fVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8982a;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockFinish
        jadx.core.utils.exceptions.JadxRuntimeException: Dominance frontier not set for block: B:6:0x0019
        	at jadx.core.dex.nodes.BlockNode.lock(BlockNode.java:75)
        	at jadx.core.utils.ImmutableList.forEach(ImmutableList.java:108)
        	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:472)
        	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:27)
        */
    private synchronized int b(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "DELETE FROM reporterror WHERE count >= ?"
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x001c }
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ Exception -> 0x001c }
            android.database.sqlite.SQLiteDatabase r1 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x001c }
            android.database.Cursor r3 = r1.rawQuery(r0, r3)     // Catch:{ Exception -> 0x001c }
            int r3 = r3.getCount()     // Catch:{ Exception -> 0x001c }
            monitor-exit(r2)
            return r3
        L_0x0019:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0019 }
            throw r3
        L_0x001c:
            monitor-exit(r2)
            r3 = -1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.l.b(int):int");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockFinish
        jadx.core.utils.exceptions.JadxRuntimeException: Dominance frontier not set for block: B:3:0x0006
        	at jadx.core.dex.nodes.BlockNode.lock(BlockNode.java:75)
        	at jadx.core.utils.ImmutableList.forEach(ImmutableList.java:108)
        	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:472)
        	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:27)
        */
    public final synchronized void a(java.lang.String r5, java.lang.String r6, long r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 != 0) goto L_0x0008
            java.lang.String r5 = ""
            goto L_0x0008
        L_0x0006:
            r5 = move-exception
            goto L_0x0032
        L_0x0008:
            android.database.sqlite.SQLiteDatabase r0 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0034 }
            if (r0 != 0) goto L_0x0010
            monitor-exit(r4)
            return
        L_0x0010:
            java.lang.String r0 = "DELETE from reporterror where url= ? and data= ? and time_stamp= ? or count > ?"
            android.database.sqlite.SQLiteDatabase r1 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0034 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x0034 }
            r8 = 5
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0034 }
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0034 }
            r3 = 0
            r2[r3] = r6     // Catch:{ Exception -> 0x0034 }
            r6 = 1
            r2[r6] = r5     // Catch:{ Exception -> 0x0034 }
            r5 = 2
            r2[r5] = r7     // Catch:{ Exception -> 0x0034 }
            r5 = 3
            r2[r5] = r8     // Catch:{ Exception -> 0x0034 }
            r1.execSQL(r0, r2)     // Catch:{ Exception -> 0x0034 }
            goto L_0x0034
        L_0x0032:
            monitor-exit(r4)     // Catch:{ all -> 0x0006 }
            throw r5
        L_0x0034:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.l.a(java.lang.String, java.lang.String, long):void");
    }

    public final synchronized int b() {
        int i5;
        Cursor cursor = null;
        try {
            Cursor query = getReadableDatabase().query("reporterror", new String[]{" count(*) "}, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
            i5 = query.getCount();
            query.close();
        } catch (Exception e5) {
            try {
                e5.printStackTrace();
                i5 = 0;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r10 != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        if (r10 == null) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int a() {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = " count(*) "
            java.lang.String[] r3 = new java.lang.String[]{r0}     // Catch:{ all -> 0x002f }
            r9 = 0
            r10 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.getReadableDatabase()     // Catch:{ Exception -> 0x0027 }
            java.lang.String r2 = "reporterror"
            r7 = 0
            r8 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0027 }
            if (r10 == 0) goto L_0x0029
            boolean r0 = r10.moveToFirst()     // Catch:{ Exception -> 0x0027 }
            if (r0 == 0) goto L_0x0029
            int r9 = r10.getInt(r9)     // Catch:{ Exception -> 0x0027 }
            goto L_0x0029
        L_0x0025:
            r0 = move-exception
            goto L_0x0039
        L_0x0027:
            r0 = move-exception
            goto L_0x0031
        L_0x0029:
            if (r10 == 0) goto L_0x0037
        L_0x002b:
            r10.close()     // Catch:{ all -> 0x002f }
            goto L_0x0037
        L_0x002f:
            r0 = move-exception
            goto L_0x003f
        L_0x0031:
            r0.printStackTrace()     // Catch:{ all -> 0x0025 }
            if (r10 == 0) goto L_0x0037
            goto L_0x002b
        L_0x0037:
            monitor-exit(r11)
            return r9
        L_0x0039:
            if (r10 == 0) goto L_0x003e
            r10.close()     // Catch:{ all -> 0x002f }
        L_0x003e:
            throw r0     // Catch:{ all -> 0x002f }
        L_0x003f:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.l.a():int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: android.database.Cursor} */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.util.List<com.mbridge.msdk.foundation.entity.l>] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0087, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0088, code lost:
        r1 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x008f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0090, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0087 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a4 A[SYNTHETIC, Splitter:B:31:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ac A[SYNTHETIC, Splitter:B:37:0x00ac] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.l> a(int r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            r0 = 5
            r1 = 0
            r11.b(r0)     // Catch:{ Exception -> 0x009d }
            android.database.sqlite.SQLiteDatabase r2 = r11.getReadableDatabase()     // Catch:{ Exception -> 0x009d }
            java.lang.String r3 = "reporterror"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009d }
            r0.<init>()     // Catch:{ Exception -> 0x009d }
            r0.append(r12)     // Catch:{ Exception -> 0x009d }
            java.lang.String r12 = ""
            r0.append(r12)     // Catch:{ Exception -> 0x009d }
            java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x009d }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x009d }
            if (r12 == 0) goto L_0x0092
            int r0 = r12.getCount()     // Catch:{ Exception -> 0x008f, all -> 0x0087 }
            if (r0 <= 0) goto L_0x0092
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x008f, all -> 0x0087 }
            r2.<init>()     // Catch:{ Exception -> 0x008f, all -> 0x0087 }
        L_0x0034:
            boolean r0 = r12.moveToNext()     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            if (r0 == 0) goto L_0x008d
            java.lang.String r0 = "url"
            int r0 = r12.getColumnIndex(r0)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            java.lang.String r0 = r12.getString(r0)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            java.lang.String r1 = "data"
            int r1 = r12.getColumnIndex(r1)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            java.lang.String r1 = r12.getString(r1)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            java.lang.String r3 = "method"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            java.lang.String r3 = r12.getString(r3)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            java.lang.String r4 = "unitId"
            int r4 = r12.getColumnIndex(r4)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            java.lang.String r4 = r12.getString(r4)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            java.lang.String r5 = "count"
            int r5 = r12.getColumnIndex(r5)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            int r5 = r12.getInt(r5)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            java.lang.String r6 = "time_stamp"
            int r6 = r12.getColumnIndex(r6)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            long r6 = r12.getLong(r6)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            com.mbridge.msdk.foundation.entity.l r8 = new com.mbridge.msdk.foundation.entity.l     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            r8.<init>(r0, r3, r1, r4)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            int r5 = r5 + 1
            r8.a((int) r5)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            r8.a((long) r6)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            r2.add(r8)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            goto L_0x0034
        L_0x0087:
            r0 = move-exception
            r1 = r12
            goto L_0x00aa
        L_0x008a:
            r0 = move-exception
        L_0x008b:
            r1 = r12
            goto L_0x009f
        L_0x008d:
            r1 = r2
            goto L_0x0092
        L_0x008f:
            r0 = move-exception
            r2 = r1
            goto L_0x008b
        L_0x0092:
            if (r12 == 0) goto L_0x00a8
            r12.close()     // Catch:{ all -> 0x0098 }
            goto L_0x00a8
        L_0x0098:
            r0 = move-exception
            r12 = r0
            goto L_0x00b0
        L_0x009b:
            r0 = move-exception
            goto L_0x00aa
        L_0x009d:
            r0 = move-exception
            r2 = r1
        L_0x009f:
            r0.printStackTrace()     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x00a7
            r1.close()     // Catch:{ all -> 0x0098 }
        L_0x00a7:
            r1 = r2
        L_0x00a8:
            monitor-exit(r11)
            return r1
        L_0x00aa:
            if (r1 == 0) goto L_0x00af
            r1.close()     // Catch:{ all -> 0x0098 }
        L_0x00af:
            throw r0     // Catch:{ all -> 0x0098 }
        L_0x00b0:
            monitor-exit(r11)     // Catch:{ all -> 0x0098 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.l.a(int):java.util.List");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockFinish
        jadx.core.utils.exceptions.JadxRuntimeException: Dominance frontier not set for block: B:11:0x001c
        	at jadx.core.dex.nodes.BlockNode.lock(BlockNode.java:75)
        	at jadx.core.utils.ImmutableList.forEach(ImmutableList.java:108)
        	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:472)
        	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:27)
        */
    public final synchronized int a(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = -1
            java.lang.String r1 = "url=?"
            java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch:{ Exception -> 0x001f }
            android.database.sqlite.SQLiteDatabase r2 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x001f }
            if (r2 != 0) goto L_0x0010
            monitor-exit(r4)
            return r0
        L_0x0010:
            android.database.sqlite.SQLiteDatabase r2 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x001f }
            java.lang.String r3 = "reporterror"
            int r5 = r2.delete(r3, r1, r5)     // Catch:{ Exception -> 0x001f }
            monitor-exit(r4)
            return r5
        L_0x001c:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x001c }
            throw r5
        L_0x001f:
            monitor-exit(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.l.a(java.lang.String):int");
    }
}
