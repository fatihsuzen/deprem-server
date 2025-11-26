package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.List;
import org.json.JSONArray;

public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8947a = "com.mbridge.msdk.foundation.db.c";

    /* renamed from: b  reason: collision with root package name */
    private static volatile c f8948b;

    private c(f fVar) {
        super(fVar);
    }

    public static c a(f fVar) {
        if (f8948b == null) {
            synchronized (c.class) {
                try {
                    if (f8948b == null) {
                        f8948b = new c(fVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8948b;
    }

    public final void b(String str, String str2, String str3) {
        if (a(str, str3)) {
            try {
                getWritableDatabase().execSQL("UPDATE CacheCampaign SET show_count = show_count + 1, show_time = ? WHERE " + "rid = ? AND unitid = ? AND state = ?", new Object[]{Long.valueOf(System.currentTimeMillis()), str, str3, "1"});
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public final long a(String str, String str2, String str3, int i5) {
        if (!a(str, str3)) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MRAIDCommunicatorUtil.KEY_STATE, Integer.valueOf(i5));
        return (long) getWritableDatabase().update("CacheCampaign", contentValues, "rid= ? AND unitid = ? AND state = 0", new String[]{str, str3});
    }

    private synchronized boolean a(String str, String str2) {
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT rid FROM CacheCampaign WHERE " + "rid= ? AND unitid = ? ", new String[]{str, str2});
        if (rawQuery != null && rawQuery.getCount() > 0) {
            try {
                rawQuery.close();
            } catch (Exception unused) {
            }
        } else if (rawQuery != null) {
            try {
                rawQuery.close();
            } catch (Exception unused2) {
            }
        }
        return false;
        return true;
    }

    public final synchronized void a(String str, int i5) {
        if (i5 <= 0) {
            i5 = 1;
        }
        try {
            String str2 = "unitid = ? AND ( (ts + interval_ts) < " + System.currentTimeMillis() + " OR " + "show_count" + " >= ?)";
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    writableDatabase.delete("CacheCampaign", str2, new String[]{str, String.valueOf(i5)});
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        } catch (Exception e6) {
            af.b("CacheCampaignDao", e6.getLocalizedMessage());
        }
    }

    public final synchronized void a(String str, String str2, String str3) {
        try {
            if (a(str2, str)) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase != null) {
                    try {
                        writableDatabase.delete("CacheCampaign", "unitid = ? AND rid = ? ", new String[]{str, str2});
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            }
        } catch (Exception e6) {
            af.b("CampaignDao", e6.getLocalizedMessage());
        }
    }

    public final long a(List<CampaignEx> list, String str) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    if (!TextUtils.isEmpty(str)) {
                        CampaignEx campaignEx = list.get(0);
                        if (campaignEx == null) {
                            return 0;
                        }
                        if (getWritableDatabase() == null) {
                            return -1;
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("rid", campaignEx.getRequestId());
                        contentValues.put("lrid", campaignEx.getLocalRequestId());
                        contentValues.put("unitid", str);
                        JSONArray jSONArray = new JSONArray();
                        for (CampaignEx campaignToJsonObject : list) {
                            jSONArray.put(CampaignEx.campaignToJsonObject(campaignToJsonObject));
                        }
                        contentValues.put("campaigns", jSONArray.toString());
                        contentValues.put(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(campaignEx.getTimestamp()));
                        long candidateCacheTime = campaignEx.getCandidateCacheTime();
                        if (candidateCacheTime == 0) {
                            candidateCacheTime = campaignEx.getPlctb();
                            if (candidateCacheTime == 0) {
                                g b5 = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                                if (b5 == null) {
                                    h.a();
                                    b5 = i.a();
                                }
                                candidateCacheTime = b5.ad();
                            }
                        }
                        try {
                            if (ah.a().a("c_e_t", false)) {
                                candidateCacheTime *= 24;
                            }
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        contentValues.put("interval_ts", Long.valueOf(candidateCacheTime * 1000));
                        contentValues.put("ecppv", campaignEx.getEcppv());
                        contentValues.put("show_count", Integer.valueOf(campaignEx.getShowCount()));
                        contentValues.put(MRAIDCommunicatorUtil.KEY_STATE, 0);
                        if (!a(campaignEx.getRequestId(), str)) {
                            return getWritableDatabase().insert("CacheCampaign", (String) null, contentValues);
                        }
                        return (long) getWritableDatabase().update("CacheCampaign", contentValues, "rid= ? AND lrid= ? AND unitid = ? AND state = 1", new String[]{campaignEx.getRequestId(), campaignEx.getLocalRequestId(), str});
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                return -1;
            }
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ff, code lost:
        if (r5 != null) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010a, code lost:
        if (r5 != null) goto L_0x0101;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.mbridge.msdk.foundation.b.b> a(java.lang.String r5, int r6, long r7) {
        /*
            r4 = this;
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7}
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "SELECT * FROM CacheCampaign"
            r6.append(r7)
            java.lang.String r7 = " WHERE unitid = ? AND state > ? and (show_time is null or show_time < ? )"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r7 = 0
            android.database.sqlite.SQLiteDatabase r8 = r4.getReadableDatabase()     // Catch:{ all -> 0x0105 }
            android.database.Cursor r5 = r8.rawQuery(r6, r5)     // Catch:{ all -> 0x0105 }
            if (r5 == 0) goto L_0x00ff
            int r6 = r5.getCount()     // Catch:{ all -> 0x007b }
            if (r6 <= 0) goto L_0x00ff
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x007b }
            r6.<init>()     // Catch:{ all -> 0x007b }
        L_0x0035:
            boolean r8 = r5.moveToNext()     // Catch:{ all -> 0x007b }
            if (r8 == 0) goto L_0x00fb
            com.mbridge.msdk.foundation.b.b r8 = new com.mbridge.msdk.foundation.b.b     // Catch:{ all -> 0x007b }
            r8.<init>()     // Catch:{ all -> 0x007b }
            java.lang.String r0 = "campaigns"
            int r0 = r5.getColumnIndex(r0)     // Catch:{ all -> 0x007b }
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x007b }
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ all -> 0x007b }
            r1.<init>(r0)     // Catch:{ all -> 0x007b }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x007b }
            if (r0 == 0) goto L_0x0059
            r5.close()     // Catch:{ Exception -> 0x0058 }
        L_0x0058:
            return r7
        L_0x0059:
            int r0 = r1.length()     // Catch:{ all -> 0x007b }
            if (r0 <= 0) goto L_0x0081
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ all -> 0x007b }
            r0.<init>()     // Catch:{ all -> 0x007b }
            r2 = 0
        L_0x0065:
            int r3 = r1.length()     // Catch:{ all -> 0x007b }
            if (r2 >= r3) goto L_0x007e
            java.lang.Object r3 = r1.get(r2)     // Catch:{ all -> 0x007b }
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ all -> 0x007b }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaignWithBackData(r3)     // Catch:{ all -> 0x007b }
            r0.add(r3)     // Catch:{ all -> 0x007b }
            int r2 = r2 + 1
            goto L_0x0065
        L_0x007b:
            r6 = move-exception
            goto L_0x0107
        L_0x007e:
            r8.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r0)     // Catch:{ all -> 0x007b }
        L_0x0081:
            java.lang.String r0 = "lrid"
            int r0 = r5.getColumnIndex(r0)     // Catch:{ all -> 0x007b }
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x007b }
            r8.b((java.lang.String) r0)     // Catch:{ all -> 0x007b }
            java.lang.String r0 = "rid"
            int r0 = r5.getColumnIndex(r0)     // Catch:{ all -> 0x007b }
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x007b }
            r8.c((java.lang.String) r0)     // Catch:{ all -> 0x007b }
            java.lang.String r0 = "unitid"
            int r0 = r5.getColumnIndex(r0)     // Catch:{ all -> 0x007b }
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x007b }
            r8.d(r0)     // Catch:{ all -> 0x007b }
            java.lang.String r0 = "ecppv"
            int r0 = r5.getColumnIndex(r0)     // Catch:{ all -> 0x007b }
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x007b }
            r8.a((java.lang.String) r0)     // Catch:{ all -> 0x007b }
            java.lang.String r0 = "ts"
            int r0 = r5.getColumnIndex(r0)     // Catch:{ all -> 0x007b }
            long r0 = r5.getLong(r0)     // Catch:{ all -> 0x007b }
            r8.b((long) r0)     // Catch:{ all -> 0x007b }
            java.lang.String r0 = "state"
            int r0 = r5.getColumnIndex(r0)     // Catch:{ all -> 0x007b }
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x007b }
            r8.b((int) r0)     // Catch:{ all -> 0x007b }
            java.lang.String r0 = "show_count"
            int r0 = r5.getColumnIndex(r0)     // Catch:{ all -> 0x007b }
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x007b }
            r8.a((int) r0)     // Catch:{ all -> 0x007b }
            java.lang.String r0 = "show_time"
            int r0 = r5.getColumnIndex(r0)     // Catch:{ all -> 0x007b }
            long r0 = r5.getLong(r0)     // Catch:{ all -> 0x007b }
            r8.c((long) r0)     // Catch:{ all -> 0x007b }
            java.lang.String r0 = "interval_ts"
            int r0 = r5.getColumnIndex(r0)     // Catch:{ all -> 0x007b }
            long r0 = r5.getLong(r0)     // Catch:{ all -> 0x007b }
            r8.a((long) r0)     // Catch:{ all -> 0x007b }
            r6.add(r8)     // Catch:{ all -> 0x007b }
            goto L_0x0035
        L_0x00fb:
            r5.close()     // Catch:{ Exception -> 0x00fe }
        L_0x00fe:
            return r6
        L_0x00ff:
            if (r5 == 0) goto L_0x010d
        L_0x0101:
            r5.close()     // Catch:{ Exception -> 0x010d }
            goto L_0x010d
        L_0x0105:
            r6 = move-exception
            r5 = r7
        L_0x0107:
            r6.printStackTrace()     // Catch:{ all -> 0x010e }
            if (r5 == 0) goto L_0x010d
            goto L_0x0101
        L_0x010d:
            return r7
        L_0x010e:
            r6 = move-exception
            if (r5 == 0) goto L_0x0114
            r5.close()     // Catch:{ Exception -> 0x0114 }
        L_0x0114:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.c.a(java.lang.String, int, long):java.util.List");
    }
}
