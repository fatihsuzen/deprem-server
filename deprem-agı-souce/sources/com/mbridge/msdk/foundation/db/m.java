package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.h;

public class m extends a<h> {

    /* renamed from: a  reason: collision with root package name */
    private static m f8983a;

    private m(f fVar) {
        super(fVar);
    }

    public static m a(f fVar) {
        if (f8983a == null) {
            synchronized (m.class) {
                try {
                    if (f8983a == null) {
                        f8983a = new m(fVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8983a;
    }

    public final synchronized void a(String str) {
        if (getWritableDatabase() != null) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.delete(MBridgeConstans.PROPERTIES_UNIT_ID, "unitId = ?", new String[]{str + ""});
        }
    }

    public final synchronized void a(String str, String str2, int i5) {
        if (getWritableDatabase() != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("placement_id", str);
            contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str2);
            contentValues.put("ad_type", Integer.valueOf(i5));
            getWritableDatabase().insert(MBridgeConstans.PROPERTIES_UNIT_ID, (String) null, contentValues);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: android.database.Cursor} */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.util.List<com.mbridge.msdk.foundation.entity.i>] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x006f */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0048 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0016] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0064 A[SYNTHETIC, Splitter:B:30:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006c A[SYNTHETIC, Splitter:B:38:0x006c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.i> a(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "select * from unit_id WHERE ad_type = ?"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r5.getReadableDatabase()     // Catch:{ Exception -> 0x005d }
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x005d }
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ Exception -> 0x005d }
            android.database.Cursor r0 = r2.rawQuery(r0, r3)     // Catch:{ Exception -> 0x005d }
            if (r0 == 0) goto L_0x0053
            int r2 = r0.getCount()     // Catch:{ Exception -> 0x0050, all -> 0x0048 }
            if (r2 <= 0) goto L_0x0053
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0050, all -> 0x0048 }
            int r3 = r0.getCount()     // Catch:{ Exception -> 0x0050, all -> 0x0048 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0050, all -> 0x0048 }
        L_0x0025:
            boolean r1 = r0.moveToNext()     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            if (r1 == 0) goto L_0x004e
            java.lang.String r1 = "placement_id"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            java.lang.String r3 = "unitId"
            int r3 = r0.getColumnIndex(r3)     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            com.mbridge.msdk.foundation.entity.i r4 = new com.mbridge.msdk.foundation.entity.i     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            r4.<init>(r1, r3, r6)     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            r2.add(r4)     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            goto L_0x0025
        L_0x0048:
            r6 = move-exception
            r1 = r0
            goto L_0x006a
        L_0x004b:
            r6 = move-exception
        L_0x004c:
            r1 = r0
            goto L_0x005f
        L_0x004e:
            r1 = r2
            goto L_0x0053
        L_0x0050:
            r6 = move-exception
            r2 = r1
            goto L_0x004c
        L_0x0053:
            if (r0 == 0) goto L_0x0068
            r0.close()     // Catch:{ Exception -> 0x0068 }
            goto L_0x0068
        L_0x0059:
            r6 = move-exception
            goto L_0x0070
        L_0x005b:
            r6 = move-exception
            goto L_0x006a
        L_0x005d:
            r6 = move-exception
            r2 = r1
        L_0x005f:
            r6.printStackTrace()     // Catch:{ all -> 0x005b }
            if (r1 == 0) goto L_0x0067
            r1.close()     // Catch:{ Exception -> 0x0067 }
        L_0x0067:
            r1 = r2
        L_0x0068:
            monitor-exit(r5)
            return r1
        L_0x006a:
            if (r1 == 0) goto L_0x006f
            r1.close()     // Catch:{ Exception -> 0x006f }
        L_0x006f:
            throw r6     // Catch:{ all -> 0x0059 }
        L_0x0070:
            monitor-exit(r5)     // Catch:{ all -> 0x0059 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.m.a(int):java.util.List");
    }
}
