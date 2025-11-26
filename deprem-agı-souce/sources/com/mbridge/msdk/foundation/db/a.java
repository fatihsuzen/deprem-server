package com.mbridge.msdk.foundation.db;

public class a<T> {
    protected f mHelper;

    public a(f fVar) {
        this.mHelper = fVar;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000d, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x000f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        com.mbridge.msdk.foundation.tools.af.a("BaseDao", "getReadableDatabase error");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.database.sqlite.SQLiteDatabase getReadableDatabase() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.mbridge.msdk.foundation.db.f r0 = r2.mHelper     // Catch:{ Exception -> 0x000b }
            android.database.sqlite.SQLiteDatabase r0 = r0.c()     // Catch:{ Exception -> 0x000b }
            monitor-exit(r2)
            return r0
        L_0x0009:
            r0 = move-exception
            goto L_0x0019
        L_0x000b:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0009 }
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = "BaseDao"
            java.lang.String r1 = "getReadableDatabase error"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0009 }
        L_0x0016:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0019:
            monitor-exit(r2)     // Catch:{ all -> 0x0009 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.a.getReadableDatabase():android.database.sqlite.SQLiteDatabase");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000d, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x000f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        com.mbridge.msdk.foundation.tools.af.a("BaseDao", "getWritableDatabase error");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.database.sqlite.SQLiteDatabase getWritableDatabase() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.mbridge.msdk.foundation.db.f r0 = r2.mHelper     // Catch:{ Exception -> 0x000b }
            android.database.sqlite.SQLiteDatabase r0 = r0.d()     // Catch:{ Exception -> 0x000b }
            monitor-exit(r2)
            return r0
        L_0x0009:
            r0 = move-exception
            goto L_0x0019
        L_0x000b:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0009 }
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = "BaseDao"
            java.lang.String r1 = "getWritableDatabase error"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0009 }
        L_0x0016:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0019:
            monitor-exit(r2)     // Catch:{ all -> 0x0009 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.a.getWritableDatabase():android.database.sqlite.SQLiteDatabase");
    }
}
