package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import org.json.JSONObject;

public final class k extends a {

    /* renamed from: a  reason: collision with root package name */
    private static String f8980a = "ReplaceTempDao";

    /* renamed from: b  reason: collision with root package name */
    private static k f8981b;

    private k(f fVar) {
        super(fVar);
    }

    public static k a(f fVar) {
        if (f8981b == null) {
            synchronized (e.class) {
                try {
                    if (f8981b == null) {
                        f8981b = new k(fVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8981b;
    }

    private boolean b(String str) {
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT d_value FROM c_replace_temp WHERE d_key= ? ", new String[]{str});
        if (rawQuery != null && rawQuery.getCount() > 0) {
            try {
                rawQuery.close();
                return true;
            } catch (Exception unused) {
                return true;
            }
        } else if (rawQuery == null) {
            return false;
        } else {
            try {
                rawQuery.close();
                return false;
            } catch (Exception unused2) {
                return false;
            }
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        try {
            if (getWritableDatabase() != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("d_key", str);
                contentValues.put("d_value", jSONObject.toString());
                contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                if (!b(str)) {
                    getWritableDatabase().insert("c_replace_temp", (String) null, contentValues);
                    return;
                }
                getWritableDatabase().update("c_replace_temp", contentValues, "d_key = ? ", new String[]{str});
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r4 == null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0059, code lost:
        if (r4 != null) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject a(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String[] r4 = new java.lang.String[]{r4}
            android.database.sqlite.SQLiteDatabase r0 = r3.getReadableDatabase()
            java.lang.String r2 = "SELECT * FROM c_replace_temp WHERE d_key = ? "
            android.database.Cursor r4 = r0.rawQuery(r2, r4)
            if (r4 == 0) goto L_0x003d
            int r0 = r4.getCount()     // Catch:{ all -> 0x003b }
            if (r0 <= 0) goto L_0x003d
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x003b }
            r0.<init>()     // Catch:{ all -> 0x003b }
            r1 = r0
        L_0x0024:
            boolean r0 = r4.moveToNext()     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = "d_value"
            int r0 = r4.getColumnIndex(r0)     // Catch:{ all -> 0x003b }
            java.lang.String r0 = r4.getString(r0)     // Catch:{ all -> 0x003b }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x003b }
            r2.<init>(r0)     // Catch:{ all -> 0x003b }
            r1 = r2
            goto L_0x0024
        L_0x003b:
            r0 = move-exception
            goto L_0x0043
        L_0x003d:
            if (r4 == 0) goto L_0x0059
            r4.close()     // Catch:{ Exception -> 0x0059 }
            goto L_0x0059
        L_0x0043:
            java.lang.String r2 = f8980a     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0052 }
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x005c
        L_0x004e:
            r4.close()     // Catch:{ Exception -> 0x005c }
            goto L_0x005c
        L_0x0052:
            r0 = move-exception
            if (r4 == 0) goto L_0x0058
            r4.close()     // Catch:{ Exception -> 0x0058 }
        L_0x0058:
            throw r0
        L_0x0059:
            if (r4 == 0) goto L_0x005c
            goto L_0x004e
        L_0x005c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.k.a(java.lang.String):org.json.JSONObject");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x008a A[SYNTHETIC, Splitter:B:37:0x008a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject a() {
        /*
            r6 = this;
            r0 = 604800000(0x240c8400, float:3.046947E-17)
            long r0 = (long) r0
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r0
            android.database.sqlite.SQLiteDatabase r0 = r6.getWritableDatabase()     // Catch:{ Exception -> 0x0024 }
            if (r0 != 0) goto L_0x0010
            goto L_0x0028
        L_0x0010:
            android.database.sqlite.SQLiteDatabase r0 = r6.getWritableDatabase()     // Catch:{ Exception -> 0x0024 }
            java.lang.String r1 = "c_replace_temp"
            java.lang.String r4 = "time<?"
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0024 }
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x0024 }
            r0.delete(r1, r4, r2)     // Catch:{ Exception -> 0x0024 }
            goto L_0x0028
        L_0x0024:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0028:
            java.lang.String r0 = "SELECT * FROM c_replace_temp"
            android.database.sqlite.SQLiteDatabase r1 = r6.getReadableDatabase()
            r2 = 0
            android.database.Cursor r0 = r1.rawQuery(r0, r2)
            if (r0 == 0) goto L_0x006c
            int r1 = r0.getCount()     // Catch:{ all -> 0x0067 }
            if (r1 <= 0) goto L_0x006c
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0067 }
            r1.<init>()     // Catch:{ all -> 0x0067 }
        L_0x0040:
            boolean r2 = r0.moveToNext()     // Catch:{ all -> 0x0063 }
            if (r2 == 0) goto L_0x0065
            java.lang.String r2 = "d_key"
            int r2 = r0.getColumnIndex(r2)     // Catch:{ all -> 0x0063 }
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0063 }
            java.lang.String r3 = "d_value"
            int r3 = r0.getColumnIndex(r3)     // Catch:{ all -> 0x0063 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x0063 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0063 }
            r4.<init>(r3)     // Catch:{ all -> 0x0063 }
            r1.put(r2, r4)     // Catch:{ all -> 0x0063 }
            goto L_0x0040
        L_0x0063:
            r2 = move-exception
            goto L_0x0072
        L_0x0065:
            r2 = r1
            goto L_0x0088
        L_0x0067:
            r1 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L_0x0072
        L_0x006c:
            if (r0 == 0) goto L_0x0088
            r0.close()     // Catch:{ all -> 0x0067 }
            goto L_0x0088
        L_0x0072:
            java.lang.String r3 = f8980a     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0081 }
            com.mbridge.msdk.foundation.tools.af.b(r3, r2)     // Catch:{ all -> 0x0081 }
            if (r0 == 0) goto L_0x008e
            r0.close()     // Catch:{ Exception -> 0x008e }
            goto L_0x008e
        L_0x0081:
            r1 = move-exception
            if (r0 == 0) goto L_0x0087
            r0.close()     // Catch:{ Exception -> 0x0087 }
        L_0x0087:
            throw r1
        L_0x0088:
            if (r0 == 0) goto L_0x008d
            r0.close()     // Catch:{ Exception -> 0x008d }
        L_0x008d:
            r1 = r2
        L_0x008e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.k.a():org.json.JSONObject");
    }
}
