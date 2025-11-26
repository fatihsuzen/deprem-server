package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.al;

public class d extends a<JumpLoaderResult> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8949a = "d";

    /* renamed from: b  reason: collision with root package name */
    private static d f8950b;

    private d(f fVar) {
        super(fVar);
    }

    public static synchronized d a(f fVar) {
        d dVar;
        synchronized (d.class) {
            try {
                if (f8950b == null) {
                    f8950b = new d(fVar);
                }
                dVar = f8950b;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return dVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean c(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "SELECT id FROM campaignclick WHERE id= ? AND unitid= ?"
            android.database.sqlite.SQLiteDatabase r1 = r2.getReadableDatabase()     // Catch:{ all -> 0x001d }
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ all -> 0x001d }
            android.database.Cursor r3 = r1.rawQuery(r0, r3)     // Catch:{ all -> 0x001d }
            if (r3 == 0) goto L_0x001f
            int r4 = r3.getCount()     // Catch:{ all -> 0x001d }
            if (r4 <= 0) goto L_0x001f
            r3.close()     // Catch:{ all -> 0x001d }
            monitor-exit(r2)
            r3 = 1
            return r3
        L_0x001d:
            r3 = move-exception
            goto L_0x0027
        L_0x001f:
            if (r3 == 0) goto L_0x0024
            r3.close()     // Catch:{ all -> 0x001d }
        L_0x0024:
            monitor-exit(r2)
            r3 = 0
            return r3
        L_0x0027:
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.d.c(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
        if (r12 != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0063, code lost:
        if (r12 == null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0067, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005a A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006a A[SYNTHETIC, Splitter:B:38:0x006a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.mbridge.msdk.click.entity.JumpLoaderResult b(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            monitor-enter(r11)
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.getReadableDatabase()     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            java.lang.String r3 = "campaignclick"
            java.lang.String r5 = "id=? AND unitid=?"
            java.lang.String[] r6 = new java.lang.String[]{r12, r13}     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            r9 = 0
            r10 = 0
            r4 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            if (r12 == 0) goto L_0x004a
            int r13 = r12.getCount()     // Catch:{ Exception -> 0x0047 }
            if (r13 <= 0) goto L_0x004a
            boolean r13 = r12.moveToFirst()     // Catch:{ Exception -> 0x0047 }
            if (r13 == 0) goto L_0x004a
            java.lang.String r13 = "result"
            int r13 = r12.getColumnIndex(r13)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r13 = r12.getString(r13)     // Catch:{ Exception -> 0x0047 }
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0047 }
            if (r0 != 0) goto L_0x004a
            java.lang.Object r13 = com.mbridge.msdk.foundation.tools.al.a((java.lang.String) r13)     // Catch:{ Exception -> 0x0047 }
            com.mbridge.msdk.click.entity.JumpLoaderResult r13 = (com.mbridge.msdk.click.entity.JumpLoaderResult) r13     // Catch:{ Exception -> 0x0047 }
            r12.close()     // Catch:{ all -> 0x0040 }
            monitor-exit(r11)
            return r13
        L_0x0040:
            r0 = move-exception
            r12 = r0
            goto L_0x006e
        L_0x0043:
            r0 = move-exception
            r13 = r0
            r1 = r12
            goto L_0x0068
        L_0x0047:
            r0 = move-exception
            r13 = r0
            goto L_0x0056
        L_0x004a:
            if (r12 == 0) goto L_0x0066
        L_0x004c:
            r12.close()     // Catch:{ all -> 0x0040 }
            goto L_0x0066
        L_0x0050:
            r0 = move-exception
            r13 = r0
            goto L_0x0068
        L_0x0053:
            r0 = move-exception
            r13 = r0
            r12 = r1
        L_0x0056:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0063
            java.lang.String r0 = f8949a     // Catch:{ all -> 0x0043 }
            java.lang.String r13 = r13.getMessage()     // Catch:{ all -> 0x0043 }
            com.mbridge.msdk.foundation.tools.af.b(r0, r13)     // Catch:{ all -> 0x0043 }
        L_0x0063:
            if (r12 == 0) goto L_0x0066
            goto L_0x004c
        L_0x0066:
            monitor-exit(r11)
            return r1
        L_0x0068:
            if (r1 == 0) goto L_0x006d
            r1.close()     // Catch:{ all -> 0x0040 }
        L_0x006d:
            throw r13     // Catch:{ all -> 0x0040 }
        L_0x006e:
            monitor-exit(r11)     // Catch:{ all -> 0x0040 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.d.b(java.lang.String, java.lang.String):com.mbridge.msdk.click.entity.JumpLoaderResult");
    }

    public final synchronized void a() {
        try {
            getWritableDatabase().delete("campaignclick", " ( " + System.currentTimeMillis() + " - " + CampaignEx.JSON_KEY_ST_TS + ") > " + "cti", (String[]) null);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b(f8949a, e5.getMessage());
            }
        }
    }

    public final synchronized long a(CampaignEx campaignEx, String str) {
        if (campaignEx == null) {
            return 0;
        }
        try {
            String a5 = al.a((Object) campaignEx.getJumpResult());
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", campaignEx.getId());
            contentValues.put("unitid", str);
            contentValues.put("result", a5);
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval() * 1000));
            contentValues.put(CampaignEx.JSON_KEY_PACKAGE_NAME, campaignEx.getPackageName());
            g b5 = h.a().b(c.m().k());
            contentValues.put(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(System.currentTimeMillis()));
            if (b5 != null && b5.aa() > 0) {
                contentValues.put("cpei", Integer.valueOf(b5.aa() * 1000));
            }
            if (b5 != null && b5.ab() > 0) {
                contentValues.put("cpoci", Integer.valueOf(b5.ab() * 1000));
            }
            if (!c(campaignEx.getId(), str)) {
                return getWritableDatabase().insert("campaignclick", (String) null, contentValues);
            } else if (getWritableDatabase() == null) {
                return -1;
            } else {
                return (long) getWritableDatabase().update("campaignclick", contentValues, "id = ? AND unitid = ? ", new String[]{campaignEx.getId(), str});
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b(f8949a, e5.getMessage());
            }
            return -1;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0033 }
            r1.<init>()     // Catch:{ Exception -> 0x0033 }
            java.lang.String r2 = "SELECT id FROM campaignclick WHERE id= ? AND unitid= ? AND cti + ts > "
            r1.append(r2)     // Catch:{ Exception -> 0x0033 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0033 }
            r1.append(r2)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0033 }
            android.database.sqlite.SQLiteDatabase r2 = r4.getReadableDatabase()     // Catch:{ Exception -> 0x0033 }
            java.lang.String[] r5 = new java.lang.String[]{r5, r6}     // Catch:{ Exception -> 0x0033 }
            android.database.Cursor r5 = r2.rawQuery(r1, r5)     // Catch:{ Exception -> 0x0033 }
            if (r5 == 0) goto L_0x0035
            int r6 = r5.getCount()     // Catch:{ Exception -> 0x0033 }
            if (r6 <= 0) goto L_0x0035
            r5.close()     // Catch:{ Exception -> 0x0033 }
            monitor-exit(r4)
            r5 = 1
            return r5
        L_0x0031:
            r5 = move-exception
            goto L_0x004b
        L_0x0033:
            r5 = move-exception
            goto L_0x003c
        L_0x0035:
            if (r5 == 0) goto L_0x003a
            r5.close()     // Catch:{ Exception -> 0x0033 }
        L_0x003a:
            monitor-exit(r4)
            return r0
        L_0x003c:
            boolean r6 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0031 }
            if (r6 == 0) goto L_0x0049
            java.lang.String r6 = f8949a     // Catch:{ all -> 0x0031 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0031 }
            com.mbridge.msdk.foundation.tools.af.b(r6, r5)     // Catch:{ all -> 0x0031 }
        L_0x0049:
            monitor-exit(r4)
            return r0
        L_0x004b:
            monitor-exit(r4)     // Catch:{ all -> 0x0031 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.d.a(java.lang.String, java.lang.String):boolean");
    }
}
