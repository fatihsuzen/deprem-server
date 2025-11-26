package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

public final class n extends a<Campaign> {

    /* renamed from: a  reason: collision with root package name */
    private static n f8984a;

    private n(f fVar) {
        super(fVar);
    }

    public static synchronized n a(f fVar) {
        n nVar;
        synchronized (n.class) {
            try {
                if (f8984a == null) {
                    f8984a = new n(fVar);
                }
                nVar = f8984a;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return nVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "video_url = ? "
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x001b }
            android.database.sqlite.SQLiteDatabase r1 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x001b }
            if (r1 != 0) goto L_0x000f
            monitor-exit(r3)
            return
        L_0x000f:
            android.database.sqlite.SQLiteDatabase r1 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x001b }
            java.lang.String r2 = "video"
            r1.delete(r2, r0, r4)     // Catch:{ Exception -> 0x001b }
            goto L_0x0029
        L_0x0019:
            r4 = move-exception
            goto L_0x002b
        L_0x001b:
            r4 = move-exception
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0029
            java.lang.String r0 = "VideoDao"
            java.lang.String r4 = r4.getLocalizedMessage()     // Catch:{ all -> 0x0019 }
            com.mbridge.msdk.foundation.tools.af.b(r0, r4)     // Catch:{ all -> 0x0019 }
        L_0x0029:
            monitor-exit(r3)
            return
        L_0x002b:
            monitor-exit(r3)     // Catch:{ all -> 0x0019 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.b(java.lang.String):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.mbridge.msdk.foundation.entity.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.mbridge.msdk.foundation.entity.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.mbridge.msdk.foundation.entity.m} */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00aa A[Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b5 A[SYNTHETIC, Splitter:B:42:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00cc A[SYNTHETIC, Splitter:B:53:0x00cc] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.mbridge.msdk.foundation.entity.m a(java.lang.String r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x008f }
            r1 = 0
            if (r0 == 0) goto L_0x000a
            monitor-exit(r6)
            return r1
        L_0x000a:
            java.lang.String r0 = "SELECT * FROM video WHERE video_url = ? "
            java.lang.String[] r7 = new java.lang.String[]{r7}     // Catch:{ Exception -> 0x00a2, all -> 0x00a0 }
            android.database.sqlite.SQLiteDatabase r2 = r6.getReadableDatabase()     // Catch:{ Exception -> 0x00a2, all -> 0x00a0 }
            android.database.Cursor r7 = r2.rawQuery(r0, r7)     // Catch:{ Exception -> 0x00a2, all -> 0x00a0 }
            if (r7 == 0) goto L_0x0089
            int r0 = r7.getCount()     // Catch:{ Exception -> 0x0084 }
            if (r0 <= 0) goto L_0x0089
            com.mbridge.msdk.foundation.entity.m r0 = new com.mbridge.msdk.foundation.entity.m     // Catch:{ Exception -> 0x0084 }
            r0.<init>()     // Catch:{ Exception -> 0x0084 }
        L_0x0025:
            boolean r1 = r7.moveToNext()     // Catch:{ Exception -> 0x0080 }
            if (r1 == 0) goto L_0x0082
            java.lang.String r1 = "video_url"
            int r1 = r7.getColumnIndex(r1)     // Catch:{ Exception -> 0x0080 }
            java.lang.String r1 = r7.getString(r1)     // Catch:{ Exception -> 0x0080 }
            r0.b((java.lang.String) r1)     // Catch:{ Exception -> 0x0080 }
            java.lang.String r1 = "video_state"
            int r1 = r7.getColumnIndex(r1)     // Catch:{ Exception -> 0x0080 }
            int r1 = r7.getInt(r1)     // Catch:{ Exception -> 0x0080 }
            r0.a((int) r1)     // Catch:{ Exception -> 0x0080 }
            java.lang.String r1 = "pregeress_size"
            int r1 = r7.getColumnIndex(r1)     // Catch:{ Exception -> 0x0080 }
            long r1 = r7.getLong(r1)     // Catch:{ Exception -> 0x0080 }
            r0.b((long) r1)     // Catch:{ Exception -> 0x0080 }
            java.lang.String r1 = "total_size"
            int r1 = r7.getColumnIndex(r1)     // Catch:{ Exception -> 0x0080 }
            int r1 = r7.getInt(r1)     // Catch:{ Exception -> 0x0080 }
            r0.b((int) r1)     // Catch:{ Exception -> 0x0080 }
            java.lang.String r1 = "video_path"
            int r1 = r7.getColumnIndex(r1)     // Catch:{ Exception -> 0x0080 }
            java.lang.String r1 = r7.getString(r1)     // Catch:{ Exception -> 0x0080 }
            r0.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0080 }
            java.lang.String r1 = "video_download_start"
            int r1 = r7.getColumnIndex(r1)     // Catch:{ Exception -> 0x0080 }
            long r1 = r7.getLong(r1)     // Catch:{ Exception -> 0x0080 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 * r3
            r0.a((long) r1)     // Catch:{ Exception -> 0x0080 }
            goto L_0x0025
        L_0x007d:
            r0 = move-exception
            r1 = r7
            goto L_0x00ca
        L_0x0080:
            r1 = move-exception
            goto L_0x00a6
        L_0x0082:
            r1 = r0
            goto L_0x0089
        L_0x0084:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x00a6
        L_0x0089:
            if (r7 == 0) goto L_0x00c8
            r7.close()     // Catch:{ Exception -> 0x0091 }
            goto L_0x00c8
        L_0x008f:
            r7 = move-exception
            goto L_0x00df
        L_0x0091:
            r7 = move-exception
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x008f }
            if (r0 == 0) goto L_0x00c8
            java.lang.String r0 = "VideoDao"
            java.lang.String r7 = r7.getLocalizedMessage()     // Catch:{ all -> 0x008f }
            com.mbridge.msdk.foundation.tools.af.b(r0, r7)     // Catch:{ all -> 0x008f }
            goto L_0x00c8
        L_0x00a0:
            r0 = move-exception
            goto L_0x00ca
        L_0x00a2:
            r7 = move-exception
            r0 = r1
            r1 = r7
            r7 = r0
        L_0x00a6:
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x007d }
            if (r2 == 0) goto L_0x00b3
            java.lang.String r2 = "VideoDao"
            java.lang.String r1 = r1.getLocalizedMessage()     // Catch:{ all -> 0x007d }
            com.mbridge.msdk.foundation.tools.af.b(r2, r1)     // Catch:{ all -> 0x007d }
        L_0x00b3:
            if (r7 == 0) goto L_0x00c7
            r7.close()     // Catch:{ Exception -> 0x00b9 }
            goto L_0x00c7
        L_0x00b9:
            r7 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x00c7
            java.lang.String r1 = "VideoDao"
            java.lang.String r7 = r7.getLocalizedMessage()     // Catch:{ all -> 0x008f }
            com.mbridge.msdk.foundation.tools.af.b(r1, r7)     // Catch:{ all -> 0x008f }
        L_0x00c7:
            r1 = r0
        L_0x00c8:
            monitor-exit(r6)
            return r1
        L_0x00ca:
            if (r1 == 0) goto L_0x00de
            r1.close()     // Catch:{ Exception -> 0x00d0 }
            goto L_0x00de
        L_0x00d0:
            r7 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x00de
            java.lang.String r1 = "VideoDao"
            java.lang.String r7 = r7.getLocalizedMessage()     // Catch:{ all -> 0x008f }
            com.mbridge.msdk.foundation.tools.af.b(r1, r7)     // Catch:{ all -> 0x008f }
        L_0x00de:
            throw r0     // Catch:{ all -> 0x008f }
        L_0x00df:
            monitor-exit(r6)     // Catch:{ all -> 0x008f }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.a(java.lang.String):com.mbridge.msdk.foundation.entity.m");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0051, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean b(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0010
            java.lang.String r3 = "SELECT id FROM video WHERE video_url = ? "
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ all -> 0x000e }
            goto L_0x0017
        L_0x000e:
            r2 = move-exception
            goto L_0x0053
        L_0x0010:
            java.lang.String r0 = "SELECT id FROM video WHERE video_url = ? AND id = ? "
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x000e }
            r3 = r0
        L_0x0017:
            android.database.sqlite.SQLiteDatabase r0 = r1.getReadableDatabase()     // Catch:{ all -> 0x000e }
            android.database.Cursor r2 = r0.rawQuery(r3, r2)     // Catch:{ all -> 0x000e }
            if (r2 == 0) goto L_0x003c
            int r3 = r2.getCount()     // Catch:{ all -> 0x000e }
            if (r3 <= 0) goto L_0x003c
            r2.close()     // Catch:{ Exception -> 0x002b }
            goto L_0x0039
        L_0x002b:
            r2 = move-exception
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x000e }
            if (r3 == 0) goto L_0x0039
            java.lang.String r3 = "VideoDao"
            java.lang.String r2 = r2.getLocalizedMessage()     // Catch:{ all -> 0x000e }
            com.mbridge.msdk.foundation.tools.af.b(r3, r2)     // Catch:{ all -> 0x000e }
        L_0x0039:
            monitor-exit(r1)
            r2 = 1
            return r2
        L_0x003c:
            if (r2 == 0) goto L_0x0050
            r2.close()     // Catch:{ Exception -> 0x0042 }
            goto L_0x0050
        L_0x0042:
            r2 = move-exception
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x000e }
            if (r3 == 0) goto L_0x0050
            java.lang.String r3 = "VideoDao"
            java.lang.String r2 = r2.getLocalizedMessage()     // Catch:{ all -> 0x000e }
            com.mbridge.msdk.foundation.tools.af.b(r3, r2)     // Catch:{ all -> 0x000e }
        L_0x0050:
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x0053:
            monitor-exit(r1)     // Catch:{ all -> 0x000e }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.b(java.lang.String, java.lang.String):boolean");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final synchronized long b(java.lang.String r5, long r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = -1
            android.database.sqlite.SQLiteDatabase r1 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x003e }
            if (r1 != 0) goto L_0x000b
            long r5 = (long) r0
            monitor-exit(r4)
            return r5
        L_0x000b:
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ Exception -> 0x003e }
            r1.<init>()     // Catch:{ Exception -> 0x003e }
            java.lang.String r2 = "total_size"
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x003e }
            r1.put(r2, r6)     // Catch:{ Exception -> 0x003e }
            java.lang.String r6 = ""
            boolean r6 = r4.b((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x003e }
            if (r6 == 0) goto L_0x004c
            java.lang.String r6 = "video_url = ? "
            java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch:{ Exception -> 0x003e }
            java.lang.Object r7 = new java.lang.Object     // Catch:{ Exception -> 0x003e }
            r7.<init>()     // Catch:{ Exception -> 0x003e }
            monitor-enter(r7)     // Catch:{ Exception -> 0x003e }
            android.database.sqlite.SQLiteDatabase r2 = r4.getWritableDatabase()     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = "video"
            int r0 = r2.update(r3, r1, r6, r5)     // Catch:{ all -> 0x0039 }
            monitor-exit(r7)     // Catch:{ all -> 0x0039 }
            goto L_0x004c
        L_0x0039:
            r5 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0039 }
            throw r5     // Catch:{ Exception -> 0x003e }
        L_0x003c:
            r5 = move-exception
            goto L_0x004f
        L_0x003e:
            r5 = move-exception
            boolean r6 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x003c }
            if (r6 == 0) goto L_0x004c
            java.lang.String r6 = "VideoDao"
            java.lang.String r5 = r5.getLocalizedMessage()     // Catch:{ all -> 0x003c }
            com.mbridge.msdk.foundation.tools.af.b(r6, r5)     // Catch:{ all -> 0x003c }
        L_0x004c:
            long r5 = (long) r0
            monitor-exit(r4)
            return r5
        L_0x004f:
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.b(java.lang.String, long):long");
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.mbridge.msdk.foundation.entity.m, android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:17|(2:32|33)|34|35) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0092, code lost:
        if (r0 != 0) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a7, code lost:
        if (r0 != 0) goto L_0x0094;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00b1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.mbridge.msdk.foundation.entity.m a(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0098 }
            r0 = 0
            if (r7 == 0) goto L_0x000a
            monitor-exit(r5)
            return r0
        L_0x000a:
            com.mbridge.msdk.foundation.entity.m r7 = new com.mbridge.msdk.foundation.entity.m     // Catch:{ all -> 0x0098 }
            r7.<init>()     // Catch:{ all -> 0x0098 }
            java.lang.String r1 = " WHERE video_url = ? "
            java.lang.String[] r6 = new java.lang.String[]{r6}     // Catch:{ all -> 0x0098 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
            r2.<init>()     // Catch:{ all -> 0x0098 }
            java.lang.String r3 = "SELECT * FROM video"
            r2.append(r3)     // Catch:{ all -> 0x0098 }
            r2.append(r1)     // Catch:{ all -> 0x0098 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0098 }
            android.database.sqlite.SQLiteDatabase r2 = r5.getReadableDatabase()     // Catch:{ Exception -> 0x0090 }
            android.database.Cursor r0 = r2.rawQuery(r1, r6)     // Catch:{ Exception -> 0x0090 }
            if (r0 == 0) goto L_0x0092
            int r6 = r0.getCount()     // Catch:{ Exception -> 0x0090 }
            if (r6 <= 0) goto L_0x0092
        L_0x0036:
            boolean r6 = r0.moveToNext()     // Catch:{ Exception -> 0x0090 }
            if (r6 == 0) goto L_0x0092
            java.lang.String r6 = "video_url"
            int r6 = r0.getColumnIndex(r6)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x0090 }
            r7.b((java.lang.String) r6)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r6 = "video_state"
            int r6 = r0.getColumnIndex(r6)     // Catch:{ Exception -> 0x0090 }
            int r6 = r0.getInt(r6)     // Catch:{ Exception -> 0x0090 }
            r7.a((int) r6)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r6 = "pregeress_size"
            int r6 = r0.getColumnIndex(r6)     // Catch:{ Exception -> 0x0090 }
            long r1 = r0.getLong(r6)     // Catch:{ Exception -> 0x0090 }
            r7.b((long) r1)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r6 = "total_size"
            int r6 = r0.getColumnIndex(r6)     // Catch:{ Exception -> 0x0090 }
            int r6 = r0.getInt(r6)     // Catch:{ Exception -> 0x0090 }
            r7.b((int) r6)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r6 = "video_path"
            int r6 = r0.getColumnIndex(r6)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x0090 }
            r7.a((java.lang.String) r6)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r6 = "video_download_start"
            int r6 = r0.getColumnIndex(r6)     // Catch:{ Exception -> 0x0090 }
            long r1 = r0.getLong(r6)     // Catch:{ Exception -> 0x0090 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 * r3
            r7.a((long) r1)     // Catch:{ Exception -> 0x0090 }
            goto L_0x0036
        L_0x008e:
            r6 = move-exception
            goto L_0x00ac
        L_0x0090:
            r6 = move-exception
            goto L_0x009a
        L_0x0092:
            if (r0 == 0) goto L_0x00aa
        L_0x0094:
            r0.close()     // Catch:{ Exception -> 0x00aa }
            goto L_0x00aa
        L_0x0098:
            r6 = move-exception
            goto L_0x00b2
        L_0x009a:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x00a7
            java.lang.String r1 = "VideoDao"
            java.lang.String r6 = r6.getLocalizedMessage()     // Catch:{ all -> 0x008e }
            com.mbridge.msdk.foundation.tools.af.b(r1, r6)     // Catch:{ all -> 0x008e }
        L_0x00a7:
            if (r0 == 0) goto L_0x00aa
            goto L_0x0094
        L_0x00aa:
            monitor-exit(r5)
            return r7
        L_0x00ac:
            if (r0 == 0) goto L_0x00b1
            r0.close()     // Catch:{ Exception -> 0x00b1 }
        L_0x00b1:
            throw r6     // Catch:{ all -> 0x0098 }
        L_0x00b2:
            monitor-exit(r5)     // Catch:{ all -> 0x0098 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.a(java.lang.String, java.lang.String):com.mbridge.msdk.foundation.entity.m");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r5, long r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch:{ Exception -> 0x0034 }
            r0.<init>()     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = "video_download_start"
            r2 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r2
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0034 }
            r0.put(r1, r6)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r6 = ""
            boolean r6 = r4.b((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0034 }
            if (r6 == 0) goto L_0x0042
            java.lang.String r6 = "video_url = ? "
            java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch:{ Exception -> 0x0034 }
            android.database.sqlite.SQLiteDatabase r7 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = "video"
            r7.update(r1, r0, r6, r5)     // Catch:{ Exception -> 0x0034 }
            goto L_0x0042
        L_0x0032:
            r5 = move-exception
            goto L_0x0044
        L_0x0034:
            r5 = move-exception
            boolean r6 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0032 }
            if (r6 == 0) goto L_0x0042
            java.lang.String r6 = "VideoDao"
            java.lang.String r5 = r5.getLocalizedMessage()     // Catch:{ all -> 0x0032 }
            com.mbridge.msdk.foundation.tools.af.b(r6, r5)     // Catch:{ all -> 0x0032 }
        L_0x0042:
            monitor-exit(r4)
            return
        L_0x0044:
            monitor-exit(r4)     // Catch:{ all -> 0x0032 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.a(java.lang.String, long):void");
    }

    public final synchronized long a(CampaignEx campaignEx, long j5, String str, int i5) {
        if (campaignEx == null) {
            return 0;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("unitid", campaignEx.getCampaignUnitId());
            contentValues.put("id", campaignEx.getId());
            contentValues.put(CampaignEx.JSON_KEY_PACKAGE_NAME, campaignEx.getPackageName());
            contentValues.put("app_name", campaignEx.getAppName());
            contentValues.put("app_desc", campaignEx.getAppDesc());
            contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
            contentValues.put(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
            contentValues.put(DownloadModel.DOWNLOAD_URL, campaignEx.getClickURL());
            contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(campaignEx.getTimestamp()));
            contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
            contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
            contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
            contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
            contentValues.put("star", Double.valueOf(campaignEx.getRating()));
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
            contentValues.put("level", Integer.valueOf(campaignEx.getCacheLevel()));
            contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
            contentValues.put("ad_call", campaignEx.getAdCall());
            contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
            contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
            contentValues.put("total_size", Long.valueOf(j5));
            contentValues.put("video_state", Integer.valueOf(i5));
            contentValues.put("video_download_start", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("ad_bid_token", campaignEx.getBidToken());
            if (!TextUtils.isEmpty(str)) {
                contentValues.put("video_path", str);
            }
            if (b(campaignEx.getVideoUrlEncode(), campaignEx.getId())) {
                return 0;
            }
            return getWritableDatabase().insert(MimeTypes.BASE_TYPE_VIDEO, (String) null, contentValues);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("VideoDao", e5.getLocalizedMessage());
            }
            return -1;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final synchronized long a(java.lang.String r4, long r5, int r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = -1
            android.database.sqlite.SQLiteDatabase r1 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x0047 }
            if (r1 != 0) goto L_0x000b
            long r4 = (long) r0
            monitor-exit(r3)
            return r4
        L_0x000b:
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ Exception -> 0x0047 }
            r1.<init>()     // Catch:{ Exception -> 0x0047 }
            java.lang.String r2 = "pregeress_size"
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x0047 }
            r1.put(r2, r5)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r5 = "video_state"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0047 }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r5 = ""
            boolean r5 = r3.b((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x0047 }
            if (r5 == 0) goto L_0x0055
            java.lang.String r5 = "video_url = ? "
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x0047 }
            java.lang.Object r6 = new java.lang.Object     // Catch:{ Exception -> 0x0047 }
            r6.<init>()     // Catch:{ Exception -> 0x0047 }
            monitor-enter(r6)     // Catch:{ Exception -> 0x0047 }
            android.database.sqlite.SQLiteDatabase r7 = r3.getWritableDatabase()     // Catch:{ all -> 0x0042 }
            java.lang.String r2 = "video"
            int r0 = r7.update(r2, r1, r5, r4)     // Catch:{ all -> 0x0042 }
            monitor-exit(r6)     // Catch:{ all -> 0x0042 }
            goto L_0x0055
        L_0x0042:
            r4 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0042 }
            throw r4     // Catch:{ Exception -> 0x0047 }
        L_0x0045:
            r4 = move-exception
            goto L_0x0058
        L_0x0047:
            r4 = move-exception
            boolean r5 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0045 }
            if (r5 == 0) goto L_0x0055
            java.lang.String r5 = "VideoDao"
            java.lang.String r4 = r4.getLocalizedMessage()     // Catch:{ all -> 0x0045 }
            com.mbridge.msdk.foundation.tools.af.b(r5, r4)     // Catch:{ all -> 0x0045 }
        L_0x0055:
            long r4 = (long) r0
            monitor-exit(r3)
            return r4
        L_0x0058:
            monitor-exit(r3)     // Catch:{ all -> 0x0045 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.a(java.lang.String, long, int):long");
    }
}
