package com.mbridge.msdk.foundation.db;

import com.mbridge.msdk.foundation.db.a.a;
import com.mbridge.msdk.foundation.entity.g;

public class j extends a<g> {

    /* renamed from: a  reason: collision with root package name */
    private static j f8979a;

    private j(f fVar) {
        super(fVar);
    }

    public static j a(f fVar) {
        if (f8979a == null) {
            synchronized (j.class) {
                try {
                    if (f8979a == null) {
                        f8979a = new j(fVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8979a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0026, code lost:
        if (r1 == null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean b(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            monitor-enter(r6)     // Catch:{ Exception -> 0x0036, all -> 0x002f }
            java.lang.String r2 = "SELECT id FROM frequence WHERE id= ?"
            android.database.sqlite.SQLiteDatabase r3 = r5.getReadableDatabase()     // Catch:{ all -> 0x0023 }
            java.lang.String[] r4 = new java.lang.String[]{r6}     // Catch:{ all -> 0x0023 }
            android.database.Cursor r1 = r3.rawQuery(r2, r4)     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0025
            int r2 = r1.getCount()     // Catch:{ all -> 0x0023 }
            if (r2 <= 0) goto L_0x0025
            monitor-exit(r6)     // Catch:{ all -> 0x0023 }
            r1.close()     // Catch:{ all -> 0x0021 }
            monitor-exit(r5)
            r6 = 1
            return r6
        L_0x0021:
            r6 = move-exception
            goto L_0x003c
        L_0x0023:
            r2 = move-exception
            goto L_0x002d
        L_0x0025:
            monitor-exit(r6)     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x002b
            r1.close()     // Catch:{ all -> 0x0021 }
        L_0x002b:
            monitor-exit(r5)
            return r0
        L_0x002d:
            monitor-exit(r6)     // Catch:{ all -> 0x0023 }
            throw r2     // Catch:{ Exception -> 0x0036, all -> 0x002f }
        L_0x002f:
            r6 = move-exception
            if (r1 == 0) goto L_0x0035
            r1.close()     // Catch:{ all -> 0x0021 }
        L_0x0035:
            throw r6     // Catch:{ all -> 0x0021 }
        L_0x0036:
            if (r1 == 0) goto L_0x003e
            r1.close()     // Catch:{ all -> 0x0021 }
            goto L_0x003e
        L_0x003c:
            monitor-exit(r5)     // Catch:{ all -> 0x0021 }
            throw r6
        L_0x003e:
            monitor-exit(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.j.b(java.lang.String):boolean");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockFinish
        jadx.core.utils.exceptions.JadxRuntimeException: Dominance frontier not set for block: B:5:0x002a
        	at jadx.core.dex.nodes.BlockNode.lock(BlockNode.java:75)
        	at jadx.core.utils.ImmutableList.forEach(ImmutableList.java:108)
        	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:472)
        	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:27)
        */
    public final synchronized void a() {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x002d }
            r2 = 86400000(0x5265c00, double:4.2687272E-316)
            long r0 = r0 - r2
            com.mbridge.msdk.foundation.db.a.a r2 = com.mbridge.msdk.foundation.db.a.a.a()     // Catch:{ Exception -> 0x002d }
            r2.a((long) r0)     // Catch:{ Exception -> 0x002d }
            java.lang.String r2 = "ts< ? "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x002d }
            java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x002d }
            android.database.sqlite.SQLiteDatabase r1 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x002d }
            if (r1 == 0) goto L_0x002d
            android.database.sqlite.SQLiteDatabase r1 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x002d }
            java.lang.String r3 = "frequence"
            r1.delete(r3, r2, r0)     // Catch:{ Exception -> 0x002d }
            goto L_0x002d
        L_0x002a:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x002a }
            throw r0
        L_0x002d:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.j.a():void");
    }

    public final synchronized void a(String str) {
        a.a().a(str);
        if (b(str) && getReadableDatabase() != null) {
            getReadableDatabase().execSQL("UPDATE frequence Set impression_count=impression_count+1 WHERE id= ?", new Object[]{str});
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockFinish
        jadx.core.utils.exceptions.JadxRuntimeException: Dominance frontier not set for block: B:11:0x007b
        	at jadx.core.dex.nodes.BlockNode.lock(BlockNode.java:75)
        	at jadx.core.utils.ImmutableList.forEach(ImmutableList.java:108)
        	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:472)
        	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:27)
        */
    private synchronized long b(com.mbridge.msdk.foundation.entity.g r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = -1
            com.mbridge.msdk.foundation.db.a.a r2 = com.mbridge.msdk.foundation.db.a.a.a()     // Catch:{ Exception -> 0x007e }
            r2.a((com.mbridge.msdk.foundation.entity.g) r7)     // Catch:{ Exception -> 0x007e }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x007e }
            r2.<init>()     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = "id"
            java.lang.String r4 = r7.a()     // Catch:{ Exception -> 0x007e }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = "fc_a"
            int r4 = r7.c()     // Catch:{ Exception -> 0x007e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x007e }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = "fc_b"
            int r4 = r7.d()     // Catch:{ Exception -> 0x007e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x007e }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = "ts"
            long r4 = r7.f()     // Catch:{ Exception -> 0x007e }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x007e }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = "impression_count"
            int r4 = r7.e()     // Catch:{ Exception -> 0x007e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x007e }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = "click_count"
            int r4 = r7.b()     // Catch:{ Exception -> 0x007e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x007e }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = "ts"
            long r4 = r7.f()     // Catch:{ Exception -> 0x007e }
            java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x007e }
            r2.put(r3, r7)     // Catch:{ Exception -> 0x007e }
            android.database.sqlite.SQLiteDatabase r7 = r6.getWritableDatabase()     // Catch:{ Exception -> 0x007e }
            if (r7 != 0) goto L_0x006e
            monitor-exit(r6)
            return r0
        L_0x006e:
            android.database.sqlite.SQLiteDatabase r7 = r6.getWritableDatabase()     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = "frequence"
            r4 = 0
            long r0 = r7.insert(r3, r4, r2)     // Catch:{ Exception -> 0x007e }
            monitor-exit(r6)
            return r0
        L_0x007b:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x007b }
            throw r7
        L_0x007e:
            monitor-exit(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.j.b(com.mbridge.msdk.foundation.entity.g):long");
    }

    public final synchronized void a(g gVar) {
        if (!b(gVar.a())) {
            b(gVar);
        }
    }
}
