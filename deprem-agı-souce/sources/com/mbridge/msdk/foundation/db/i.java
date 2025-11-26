package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.f;

public final class i extends a<f> {

    /* renamed from: a  reason: collision with root package name */
    private static i f8978a;

    private i(f fVar) {
        super(fVar);
    }

    public static synchronized i a(f fVar) {
        i iVar;
        synchronized (i.class) {
            try {
                if (f8978a == null) {
                    f8978a = new i(fVar);
                }
                iVar = f8978a;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return iVar;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockFinish
        jadx.core.utils.exceptions.JadxRuntimeException: Dominance frontier not set for block: B:5:0x0023
        	at jadx.core.dex.nodes.BlockNode.lock(BlockNode.java:75)
        	at jadx.core.utils.ImmutableList.forEach(ImmutableList.java:108)
        	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:472)
        	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:27)
        */
    public final synchronized void a(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0026 }
            r2 = 86400000(0x5265c00, double:4.2687272E-316)
            long r0 = r0 - r2
            java.lang.String r2 = "time< ? and unitId=?"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0026 }
            java.lang.String[] r5 = new java.lang.String[]{r0, r5}     // Catch:{ Exception -> 0x0026 }
            android.database.sqlite.SQLiteDatabase r0 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0026 }
            if (r0 == 0) goto L_0x0026
            android.database.sqlite.SQLiteDatabase r0 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0026 }
            java.lang.String r1 = "fq_info"
            r0.delete(r1, r2, r5)     // Catch:{ Exception -> 0x0026 }
            goto L_0x0026
        L_0x0023:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0023 }
            throw r5
        L_0x0026:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.i.a(java.lang.String):void");
    }

    public final synchronized void a(f fVar) {
        try {
            if (getWritableDatabase() != null) {
                if (fVar != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("id", fVar.a());
                    contentValues.put("time", Long.valueOf(fVar.b()));
                    contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, fVar.d());
                    contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(fVar.c()));
                    if (a(fVar.d(), fVar.a())) {
                        getWritableDatabase().update("fq_info", contentValues, "id = ? AND unitId = ? ", new String[]{fVar.a(), fVar.d()});
                    } else {
                        getWritableDatabase().insert("fq_info", (String) null, contentValues);
                    }
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean a(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 0
            java.lang.String r1 = "select id from fq_info where unitId= ?  and id= ? "
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ Exception -> 0x0020 }
            android.database.sqlite.SQLiteDatabase r4 = r2.getReadableDatabase()     // Catch:{ Exception -> 0x0020 }
            android.database.Cursor r3 = r4.rawQuery(r1, r3)     // Catch:{ Exception -> 0x0020 }
            if (r3 == 0) goto L_0x0022
            int r4 = r3.getCount()     // Catch:{ Exception -> 0x0020 }
            if (r4 <= 0) goto L_0x0022
            r3.close()     // Catch:{ Exception -> 0x0020 }
            monitor-exit(r2)
            r3 = 1
            return r3
        L_0x001e:
            r3 = move-exception
            goto L_0x002e
        L_0x0020:
            r3 = move-exception
            goto L_0x0029
        L_0x0022:
            if (r3 == 0) goto L_0x0027
            r3.close()     // Catch:{ Exception -> 0x0020 }
        L_0x0027:
            monitor-exit(r2)
            return r0
        L_0x0029:
            r3.printStackTrace()     // Catch:{ all -> 0x001e }
            monitor-exit(r2)
            return r0
        L_0x002e:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.i.a(java.lang.String, java.lang.String):boolean");
    }
}
