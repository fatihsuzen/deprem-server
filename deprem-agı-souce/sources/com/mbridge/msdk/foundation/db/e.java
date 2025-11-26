package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.AabEntity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.entity.b;
import com.mbridge.msdk.foundation.entity.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.out.Campaign;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class e extends a<Campaign> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8951a = "com.mbridge.msdk.foundation.db.e";

    /* renamed from: b  reason: collision with root package name */
    private static e f8952b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8953c = "rid";

    /* renamed from: d  reason: collision with root package name */
    private final String f8954d = "lrid";

    /* renamed from: e  reason: collision with root package name */
    private final String f8955e = "cid";

    /* renamed from: f  reason: collision with root package name */
    private final String f8956f = CampaignEx.JSON_KEY_PLCT;

    /* renamed from: g  reason: collision with root package name */
    private final String f8957g = CampaignEx.JSON_KEY_PLCTB;

    /* renamed from: h  reason: collision with root package name */
    private final String f8958h = CampaignEx.JSON_KEY_TIMESTAMP;

    /* renamed from: i  reason: collision with root package name */
    private final String f8959i = "ridCount";

    /* renamed from: j  reason: collision with root package name */
    private final String f8960j = " WHERE ";

    /* renamed from: k  reason: collision with root package name */
    private final String f8961k = " AND ";

    /* renamed from: l  reason: collision with root package name */
    private final String f8962l = "SELECT ";

    /* renamed from: m  reason: collision with root package name */
    private final String f8963m = "*";

    /* renamed from: n  reason: collision with root package name */
    private final String f8964n = " FROM ";

    /* renamed from: o  reason: collision with root package name */
    private final String f8965o = " AND readyState = '0'";

    /* renamed from: p  reason: collision with root package name */
    private final String f8966p = " AND is_bid_campaign = 1";

    /* renamed from: q  reason: collision with root package name */
    private final String f8967q = " order by ts ASC";

    /* renamed from: r  reason: collision with root package name */
    private final String f8968r = " group by request_id";

    /* renamed from: s  reason: collision with root package name */
    private final String f8969s = " group by bid_token";

    private e(f fVar) {
        super(fVar);
    }

    public static synchronized e a(f fVar) {
        e eVar;
        synchronized (e.class) {
            try {
                if (f8952b == null) {
                    f8952b = new e(fVar);
                }
                eVar = f8952b;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return eVar;
    }

    public final synchronized void b(String str, List<CampaignEx> list) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx next : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("readyState", 0);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, "unitid = ? AND id = ? AND request_id = ? ", new String[]{str, next.getId(), next.getRequestId()});
                        }
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("CampaignDao", e5.getLocalizedMessage());
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void c(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "unitid = ? "
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x001b }
            android.database.sqlite.SQLiteDatabase r1 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x001b }
            if (r1 != 0) goto L_0x000f
            monitor-exit(r3)
            return
        L_0x000f:
            android.database.sqlite.SQLiteDatabase r1 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x001b }
            java.lang.String r2 = "campaign"
            r1.delete(r2, r0, r4)     // Catch:{ Exception -> 0x001b }
            goto L_0x0029
        L_0x0019:
            r4 = move-exception
            goto L_0x002b
        L_0x001b:
            r4 = move-exception
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0029
            java.lang.String r0 = "CampaignDao"
            java.lang.String r4 = r4.getLocalizedMessage()     // Catch:{ all -> 0x0019 }
            com.mbridge.msdk.foundation.tools.af.b(r0, r4)     // Catch:{ all -> 0x0019 }
        L_0x0029:
            monitor-exit(r3)
            return
        L_0x002b:
            monitor-exit(r3)     // Catch:{ all -> 0x0019 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.c(java.lang.String):void");
    }

    public final List<c> d(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            String str2 = "SELECT request_id as rid ,count(*) as ridCount ,vcn,token_r,bid_token,local_request_id,ts as timestamp FROM campaign" + ((((" WHERE unitid = ? AND level = 0 AND adSource = 1" + " AND is_bid_campaign = 1") + " AND readyState = '0'") + " group by request_id") + " order by ts ASC");
            String[] strArr = {str};
            Cursor cursor = null;
            try {
                synchronized (new Object()) {
                    cursor = getReadableDatabase().rawQuery(str2, strArr);
                }
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        while (cursor.moveToNext()) {
                            c cVar = new c();
                            String string = cursor.getString(cursor.getColumnIndex("rid"));
                            if (!TextUtils.isEmpty(string)) {
                                String string2 = cursor.getString(cursor.getColumnIndex("local_request_id"));
                                String string3 = cursor.getString(cursor.getColumnIndex("bid_token"));
                                int i5 = cursor.getInt(cursor.getColumnIndex("ridCount"));
                                int i6 = cursor.getInt(cursor.getColumnIndex("token_r"));
                                long j5 = cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_TIMESTAMP));
                                int i7 = cursor.getInt(cursor.getColumnIndex("vcn"));
                                cVar.a(string);
                                cVar.a(i5);
                                cVar.c(j5);
                                cVar.b(i6);
                                cVar.c(i7);
                                cVar.c(string2);
                                if (!TextUtils.isEmpty(string3)) {
                                    cVar.b(string3);
                                }
                                arrayList.add(cVar);
                            }
                        }
                    }
                }
                if (cursor != null) {
                    cursor.close();
                    return arrayList;
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CampaignDao", e5.getLocalizedMessage());
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return arrayList;
    }

    public final List<String> e(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                synchronized (new Object()) {
                    cursor = getReadableDatabase().rawQuery("SELECT " + "local_request_id" + " as " + "lrid" + " FROM " + "campaign" + " WHERE " + "unitid" + " = ? AND " + "readyState" + " = ?", new String[]{str, String.valueOf(2)});
                }
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("lrid"));
                            if (!TextUtils.isEmpty(string)) {
                                arrayList.add(string);
                            }
                        }
                    }
                }
                if (cursor != null) {
                    cursor.close();
                    return arrayList;
                }
            } catch (Exception e5) {
                af.b("CampaignDao", e5.getLocalizedMessage());
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return arrayList;
    }

    public final ConcurrentHashMap<String, c> f(String str) {
        String[] strArr = {str};
        String str2 = "SELECT request_id as rid, id as cid, plct as plct, plctb as plctb, ts as timestamp FROM campaign" + ((" WHERE unitid = ? AND level = 0 AND adSource = 1" + " AND is_bid_campaign = 1") + " AND readyState = '0'");
        ConcurrentHashMap<String, c> concurrentHashMap = new ConcurrentHashMap<>();
        Cursor cursor = null;
        try {
            synchronized (new Object()) {
                cursor = getReadableDatabase().rawQuery(str2, strArr);
            }
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(cursor.getColumnIndex("rid"));
                        String string2 = cursor.getString(cursor.getColumnIndex("cid"));
                        long j5 = cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCT));
                        long j6 = cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCTB));
                        long j7 = cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_TIMESTAMP));
                        if (concurrentHashMap.containsKey(string)) {
                            c cVar = concurrentHashMap.get(string);
                            if (cVar != null) {
                                cVar.a(string);
                                cVar.a(j5);
                                cVar.b(j6);
                                cVar.c(j7);
                                if (cVar.c() != null) {
                                    cVar.c().add(string2);
                                }
                            }
                        } else {
                            c cVar2 = new c();
                            cVar2.a(string);
                            cVar2.a(j5);
                            cVar2.b(j6);
                            cVar2.c(j7);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(string2);
                            cVar2.a((List<String>) arrayList);
                            concurrentHashMap.put(string, cVar2);
                        }
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
                return concurrentHashMap;
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignDao", e5.getLocalizedMessage());
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return concurrentHashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r2, int r3, int r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "unitid = ? AND level = ? AND adSource = ? "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0023 }
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4}     // Catch:{ Exception -> 0x0023 }
            android.database.sqlite.SQLiteDatabase r3 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x0023 }
            if (r3 != 0) goto L_0x0017
            monitor-exit(r1)
            return
        L_0x0017:
            android.database.sqlite.SQLiteDatabase r3 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r4 = "campaign"
            r3.delete(r4, r0, r2)     // Catch:{ Exception -> 0x0023 }
            goto L_0x0031
        L_0x0021:
            r2 = move-exception
            goto L_0x0033
        L_0x0023:
            r2 = move-exception
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0021 }
            if (r3 == 0) goto L_0x0031
            java.lang.String r3 = "CampaignDao"
            java.lang.String r2 = r2.getLocalizedMessage()     // Catch:{ all -> 0x0021 }
            com.mbridge.msdk.foundation.tools.af.b(r3, r2)     // Catch:{ all -> 0x0021 }
        L_0x0031:
            monitor-exit(r1)
            return
        L_0x0033:
            monitor-exit(r1)     // Catch:{ all -> 0x0021 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.a(java.lang.String, int, int):void");
    }

    public final int c(String str, String str2) {
        String str3;
        String[] strArr;
        if (!TextUtils.isEmpty(str)) {
            strArr = new String[]{str2, str};
            str3 = "unitid = ?  AND request_id = ?  AND is_bid_campaign = 1";
        } else {
            strArr = new String[]{str2};
            str3 = "unitid = ?  AND is_bid_campaign = 1";
        }
        String str4 = str3 + " AND readyState = '0'";
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("readyState", 2);
            return getWritableDatabase().update("campaign", contentValues, str4, strArr);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignDao", e5.getLocalizedMessage());
            }
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r3, int r4, int r5, boolean r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "unitid = ? AND level = ? AND adSource = ? "
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0038 }
            r1.<init>()     // Catch:{ Exception -> 0x0038 }
            r1.append(r0)     // Catch:{ Exception -> 0x0038 }
            java.lang.String r0 = " AND is_bid_campaign = ? "
            r1.append(r0)     // Catch:{ Exception -> 0x0038 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0038 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0038 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0038 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x0038 }
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5, r6}     // Catch:{ Exception -> 0x0038 }
            android.database.sqlite.SQLiteDatabase r4 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x0038 }
            if (r4 != 0) goto L_0x002c
            monitor-exit(r2)
            return
        L_0x002c:
            android.database.sqlite.SQLiteDatabase r4 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x0038 }
            java.lang.String r5 = "campaign"
            r4.delete(r5, r0, r3)     // Catch:{ Exception -> 0x0038 }
            goto L_0x0046
        L_0x0036:
            r3 = move-exception
            goto L_0x0048
        L_0x0038:
            r3 = move-exception
            boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0036 }
            if (r4 == 0) goto L_0x0046
            java.lang.String r4 = "CampaignDao"
            java.lang.String r3 = r3.getLocalizedMessage()     // Catch:{ all -> 0x0036 }
            com.mbridge.msdk.foundation.tools.af.b(r4, r3)     // Catch:{ all -> 0x0036 }
        L_0x0046:
            monitor-exit(r2)
            return
        L_0x0048:
            monitor-exit(r2)     // Catch:{ all -> 0x0036 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.a(java.lang.String, int, int, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0065, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> b(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            java.lang.String r2 = "SELECT * FROM "
            r1.<init>(r2)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            java.lang.String r2 = "campaign"
            r1.append(r2)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            java.lang.String r2 = " WHERE "
            r1.append(r2)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            java.lang.String r2 = "unitid"
            r1.append(r2)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            java.lang.String r2 = " = ? AND "
            r1.append(r2)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            java.lang.String r2 = "readyState"
            r1.append(r2)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            java.lang.String r2 = " = "
            r1.append(r2)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            r2 = 2
            r1.append(r2)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            android.database.sqlite.SQLiteDatabase r2 = r3.getReadableDatabase()     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            android.database.Cursor r4 = r2.rawQuery(r1, r4)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            if (r4 == 0) goto L_0x005f
            int r1 = r4.getCount()     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            if (r1 <= 0) goto L_0x005f
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            r1.<init>()     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
        L_0x0048:
            boolean r2 = r4.moveToNext()     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            if (r2 == 0) goto L_0x005a
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r3.a((android.database.Cursor) r4)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            r1.add(r2)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            goto L_0x0048
        L_0x0056:
            r4 = move-exception
            goto L_0x0066
        L_0x0058:
            r4 = move-exception
            goto L_0x0078
        L_0x005a:
            r4.close()     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            monitor-exit(r3)
            return r1
        L_0x005f:
            if (r4 == 0) goto L_0x0064
            r4.close()     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
        L_0x0064:
            monitor-exit(r3)
            return r0
        L_0x0066:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x0076
            java.lang.String r1 = "CampaignDao"
            java.lang.String r4 = r4.getLocalizedMessage()     // Catch:{ all -> 0x0074 }
            com.mbridge.msdk.foundation.tools.af.b(r1, r4)     // Catch:{ all -> 0x0074 }
            goto L_0x0076
        L_0x0074:
            r4 = move-exception
            goto L_0x0087
        L_0x0076:
            monitor-exit(r3)
            return r0
        L_0x0078:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x0085
            java.lang.String r1 = "CampaignDao"
            java.lang.String r4 = r4.getLocalizedMessage()     // Catch:{ all -> 0x0074 }
            com.mbridge.msdk.foundation.tools.af.b(r1, r4)     // Catch:{ all -> 0x0074 }
        L_0x0085:
            monitor-exit(r3)
            return r0
        L_0x0087:
            monitor-exit(r3)     // Catch:{ all -> 0x0074 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.b(java.lang.String):java.util.List");
    }

    public final synchronized void e(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                String str3 = "";
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str)) {
                    str3 = "unitid = ? AND ";
                    arrayList.add(str);
                }
                arrayList.add(str2);
                ContentValues contentValues = new ContentValues();
                contentValues.put("readyState", 2);
                getWritableDatabase().update("campaign", contentValues, str3 + "n_local_request_id" + " = ? AND " + "bid_token" + " IS NOT NULL AND " + "n_local_request_id" + " IS NOT NULL", (String[]) arrayList.toArray(new String[0]));
            }
        } catch (Exception e5) {
            af.b("CampaignDao", e5.getLocalizedMessage());
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final synchronized void a(String str, List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (CampaignEx next : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("readyState", 2);
                        String str2 = "id = ? AND unitid = ? AND request_id = ? " + " AND is_bid_campaign = ? ";
                        String[] strArr = {next.getId(), str, next.getRequestId(), next.isBidCampaign() ? "1" : "0"};
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, str2, strArr);
                        }
                    }
                }
            } catch (SQLException e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CampaignDao", e5.getLocalizedMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            android.database.sqlite.SQLiteDatabase r0 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x002a }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r3)
            return
        L_0x0009:
            java.lang.String r0 = "id = ? AND request_id = ? "
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}     // Catch:{ Exception -> 0x002a }
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ Exception -> 0x002a }
            r5.<init>()     // Catch:{ Exception -> 0x002a }
            java.lang.String r1 = "readyState"
            r2 = 2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x002a }
            r5.put(r1, r2)     // Catch:{ Exception -> 0x002a }
            android.database.sqlite.SQLiteDatabase r1 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = "campaign"
            r1.update(r2, r5, r0, r4)     // Catch:{ Exception -> 0x002a }
            goto L_0x0038
        L_0x0028:
            r4 = move-exception
            goto L_0x003a
        L_0x002a:
            r4 = move-exception
            boolean r5 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0028 }
            if (r5 == 0) goto L_0x0038
            java.lang.String r5 = "CampaignDao"
            java.lang.String r4 = r4.getLocalizedMessage()     // Catch:{ all -> 0x0028 }
            com.mbridge.msdk.foundation.tools.af.b(r5, r4)     // Catch:{ all -> 0x0028 }
        L_0x0038:
            monitor-exit(r3)
            return
        L_0x003a:
            monitor-exit(r3)     // Catch:{ all -> 0x0028 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.b(java.lang.String, java.lang.String):void");
    }

    public final synchronized void a(String str, CampaignEx campaignEx, boolean z4, String str2) {
        try {
            StringBuilder sb = new StringBuilder();
            if (campaignEx == null && !TextUtils.isEmpty(str2)) {
                sb.append("unitid");
                sb.append(" = ? AND ");
                sb.append("request_id");
                sb.append(" = ?");
            } else if (campaignEx != null && campaignEx.getLoadTimeoutState() == 0) {
                sb.append("unitid");
                sb.append(" = ? AND ");
                sb.append("id");
                sb.append(" = ? AND ");
                sb.append("request_id");
                sb.append(" = ?");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            if (campaignEx == null || campaignEx.getLoadTimeoutState() != 0) {
                arrayList.add(str2);
            } else {
                arrayList.add(String.valueOf(campaignEx.getId()));
                arrayList.add(campaignEx.getRequestId());
            }
            if (!TextUtils.isEmpty(sb)) {
                if (ah.a().a("c_n_c_s", true)) {
                    sb.append(" AND readyState");
                    sb.append(" != 0");
                }
                if (z4) {
                    sb.append(" AND is_bid_campaign = 1");
                } else {
                    sb.append(" AND is_bid_campaign = 0");
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("readyState", 2);
                SQLiteDatabase writableDatabase = getWritableDatabase();
                String[] strArr = (String[]) arrayList.toArray(new String[0]);
                if (writableDatabase != null) {
                    writableDatabase.update("campaign", contentValues, sb.toString(), strArr);
                }
            }
        } catch (SQLException e5) {
            af.b("CampaignDao", e5.getLocalizedMessage());
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0084, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void d(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0030 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r3)
            return
        L_0x0009:
            java.lang.String r0 = "unitid = ?"
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0030 }
            r1.<init>()     // Catch:{ Exception -> 0x0030 }
            r1.add(r4)     // Catch:{ Exception -> 0x0030 }
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0030 }
            if (r4 != 0) goto L_0x0032
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
            r4.<init>()     // Catch:{ Exception -> 0x0030 }
            r4.append(r0)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r0 = " AND bid_token != ?"
            r4.append(r0)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x0030 }
            r1.add(r5)     // Catch:{ Exception -> 0x0030 }
            goto L_0x0032
        L_0x002e:
            r4 = move-exception
            goto L_0x0085
        L_0x0030:
            r4 = move-exception
            goto L_0x0076
        L_0x0032:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
            r4.<init>()     // Catch:{ Exception -> 0x0030 }
            r4.append(r0)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r5 = " AND is_bid_campaign = 1"
            r4.append(r5)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0030 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
            r5.<init>()     // Catch:{ Exception -> 0x0030 }
            r5.append(r4)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r4 = " AND bid_token IS NOT NULL"
            r5.append(r4)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x0030 }
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ Exception -> 0x0030 }
            r5.<init>()     // Catch:{ Exception -> 0x0030 }
            java.lang.String r0 = "readyState"
            r2 = 2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0030 }
            r5.put(r0, r2)     // Catch:{ Exception -> 0x0030 }
            r0 = 0
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0030 }
            java.lang.Object[] r0 = r1.toArray(r0)     // Catch:{ Exception -> 0x0030 }
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ Exception -> 0x0030 }
            android.database.sqlite.SQLiteDatabase r1 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x0030 }
            java.lang.String r2 = "campaign"
            r1.update(r2, r5, r4, r0)     // Catch:{ Exception -> 0x0030 }
            goto L_0x0083
        L_0x0076:
            boolean r5 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x002e }
            if (r5 == 0) goto L_0x0083
            java.lang.String r5 = "CampaignDao"
            java.lang.String r4 = r4.getLocalizedMessage()     // Catch:{ all -> 0x002e }
            com.mbridge.msdk.foundation.tools.af.b(r5, r4)     // Catch:{ all -> 0x002e }
        L_0x0083:
            monitor-exit(r3)
            return
        L_0x0085:
            monitor-exit(r3)     // Catch:{ all -> 0x002e }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.d(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void f(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x002f }
            if (r0 != 0) goto L_0x0031
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x000e
            goto L_0x0031
        L_0x000e:
            java.lang.String r0 = "unitid = ? AND bid_token = ? AND bid_token IS NOT NULL"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}     // Catch:{ Exception -> 0x002f }
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ Exception -> 0x002f }
            r5.<init>()     // Catch:{ Exception -> 0x002f }
            java.lang.String r1 = "readyState"
            r2 = 2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x002f }
            r5.put(r1, r2)     // Catch:{ Exception -> 0x002f }
            android.database.sqlite.SQLiteDatabase r1 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x002f }
            java.lang.String r2 = "campaign"
            r1.update(r2, r5, r0, r4)     // Catch:{ Exception -> 0x002f }
            goto L_0x003c
        L_0x002d:
            r4 = move-exception
            goto L_0x003e
        L_0x002f:
            r4 = move-exception
            goto L_0x0033
        L_0x0031:
            monitor-exit(r3)
            return
        L_0x0033:
            java.lang.String r5 = "CampaignDao"
            java.lang.String r4 = r4.getLocalizedMessage()     // Catch:{ all -> 0x002d }
            com.mbridge.msdk.foundation.tools.af.b(r5, r4)     // Catch:{ all -> 0x002d }
        L_0x003c:
            monitor-exit(r3)
            return
        L_0x003e:
            monitor-exit(r3)     // Catch:{ all -> 0x002d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.f(java.lang.String, java.lang.String):void");
    }

    public final synchronized void b(long j5, String str) {
        try {
            String[] strArr = {String.valueOf(System.currentTimeMillis() - j5), str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", "ts< ? and unitid= ? ", strArr);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignDao", e5.getLocalizedMessage());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(final java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r3, final java.lang.String r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x001c
            int r0 = r3.size()     // Catch:{ all -> 0x0019 }
            if (r0 != 0) goto L_0x000a
            goto L_0x001c
        L_0x000a:
            java.lang.Thread r0 = new java.lang.Thread     // Catch:{ all -> 0x0019 }
            com.mbridge.msdk.foundation.db.e$1 r1 = new com.mbridge.msdk.foundation.db.e$1     // Catch:{ all -> 0x0019 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0019 }
            r0.<init>(r1)     // Catch:{ all -> 0x0019 }
            r0.start()     // Catch:{ all -> 0x0019 }
            monitor-exit(r2)
            return
        L_0x0019:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0019 }
            throw r3
        L_0x001c:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.b(java.util.List, java.lang.String):void");
    }

    public final synchronized List<CampaignEx> b(String str, int i5, int i6, int i7) {
        ArrayList arrayList;
        String str2;
        try {
            arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add(String.valueOf(i6));
            arrayList.add(String.valueOf(i7));
            str2 = "";
            if (i5 > 0) {
                str2 = " LIMIT ?";
                arrayList.add(String.valueOf(i5));
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return a("SELECT * FROM campaign" + " WHERE unitid = ? AND level = ? AND adSource = ?" + str2, (String[]) arrayList.toArray(new String[0]));
    }

    public final synchronized void a(String str, List<CampaignEx> list, boolean z4) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx next : list) {
                    a(str, next, z4, next.getRequestId());
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0064, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r6, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r7, java.lang.String r8, int r9) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0061 }
            if (r0 != 0) goto L_0x0063
            if (r7 == 0) goto L_0x0063
            int r0 = r7.size()     // Catch:{ all -> 0x0061 }
            if (r0 <= 0) goto L_0x0063
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0061 }
            if (r0 != 0) goto L_0x0063
            android.database.sqlite.SQLiteDatabase r0 = r5.getWritableDatabase()     // Catch:{ all -> 0x0061 }
            if (r0 != 0) goto L_0x001d
            monitor-exit(r5)
            return
        L_0x001d:
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0051 }
        L_0x0021:
            boolean r1 = r7.hasNext()     // Catch:{ Exception -> 0x0051 }
            if (r1 == 0) goto L_0x0063
            java.lang.Object r1 = r7.next()     // Catch:{ Exception -> 0x0051 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1     // Catch:{ Exception -> 0x0051 }
            if (r1 == 0) goto L_0x0021
            java.lang.String r2 = "unitid = ? AND id = ? AND request_id = ? "
            java.lang.String r3 = r1.getId()     // Catch:{ Exception -> 0x0051 }
            java.lang.String r1 = r1.getRequestId()     // Catch:{ Exception -> 0x0051 }
            java.lang.String[] r1 = new java.lang.String[]{r6, r3, r1}     // Catch:{ Exception -> 0x0051 }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x0051 }
            r3.<init>()     // Catch:{ Exception -> 0x0051 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x0051 }
            r3.put(r8, r4)     // Catch:{ Exception -> 0x0051 }
            java.lang.String r4 = "campaign"
            r0.update(r4, r3, r2, r1)     // Catch:{ Exception -> 0x0051 }
            goto L_0x0021
        L_0x004f:
            r6 = move-exception
            goto L_0x0060
        L_0x0051:
            r6 = move-exception
            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x004f }
            if (r7 == 0) goto L_0x0063
            java.lang.String r7 = "CampaignDao"
            java.lang.String r6 = r6.getLocalizedMessage()     // Catch:{ all -> 0x004f }
            com.mbridge.msdk.foundation.tools.af.b(r7, r6)     // Catch:{ all -> 0x004f }
            goto L_0x0063
        L_0x0060:
            throw r6     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r6 = move-exception
            goto L_0x0065
        L_0x0063:
            monitor-exit(r5)
            return
        L_0x0065:
            monitor-exit(r5)     // Catch:{ all -> 0x0061 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.a(java.lang.String, java.util.List, java.lang.String, int):void");
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        r0 = r4;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005d, code lost:
        r0 = r4;
        r4 = r5;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0079, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052 A[ExcHandler: all (r5v6 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:12:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> b(java.lang.String r4, int r5, boolean r6) {
        /*
            r3 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0014
            java.lang.String r6 = "placement_id = ? AND ad_type = ? "
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0011 }
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}     // Catch:{ Exception -> 0x0011 }
            goto L_0x001e
        L_0x000e:
            r4 = move-exception
            goto L_0x0077
        L_0x0011:
            r4 = move-exception
            r5 = r0
            goto L_0x0068
        L_0x0014:
            java.lang.String r6 = "ad_type = ? "
            java.lang.String r4 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0011 }
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x0011 }
        L_0x001e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0011 }
            r5.<init>()     // Catch:{ Exception -> 0x0011 }
            java.lang.String r1 = "SELECT * FROM campaign WHERE "
            r5.append(r1)     // Catch:{ Exception -> 0x0011 }
            r5.append(r6)     // Catch:{ Exception -> 0x0011 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0011 }
            android.database.sqlite.SQLiteDatabase r6 = r3.getReadableDatabase()     // Catch:{ Exception -> 0x0011 }
            android.database.Cursor r4 = r6.rawQuery(r5, r4)     // Catch:{ Exception -> 0x0011 }
            if (r4 == 0) goto L_0x0062
            int r5 = r4.getCount()     // Catch:{ Exception -> 0x005c, all -> 0x0052 }
            if (r5 <= 0) goto L_0x0062
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x005c, all -> 0x0052 }
            r5.<init>()     // Catch:{ Exception -> 0x005c, all -> 0x0052 }
        L_0x0044:
            boolean r6 = r4.moveToNext()     // Catch:{ Exception -> 0x0056, all -> 0x0052 }
            if (r6 == 0) goto L_0x005a
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r3.a((android.database.Cursor) r4)     // Catch:{ Exception -> 0x0056, all -> 0x0052 }
            r5.add(r6)     // Catch:{ Exception -> 0x0056, all -> 0x0052 }
            goto L_0x0044
        L_0x0052:
            r5 = move-exception
            r0 = r4
            r4 = r5
            goto L_0x0077
        L_0x0056:
            r6 = move-exception
            r0 = r4
            r4 = r6
            goto L_0x0068
        L_0x005a:
            r0 = r5
            goto L_0x0062
        L_0x005c:
            r5 = move-exception
            r2 = r0
            r0 = r4
            r4 = r5
            r5 = r2
            goto L_0x0068
        L_0x0062:
            if (r4 == 0) goto L_0x0067
            r4.close()
        L_0x0067:
            return r0
        L_0x0068:
            java.lang.String r6 = "CampaignDao"
            java.lang.String r4 = r4.getLocalizedMessage()     // Catch:{ all -> 0x000e }
            com.mbridge.msdk.foundation.tools.af.b(r6, r4)     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0076
            r0.close()
        L_0x0076:
            return r5
        L_0x0077:
            if (r0 == 0) goto L_0x007c
            r0.close()
        L_0x007c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.b(java.lang.String, int, boolean):java.util.List");
    }

    public final synchronized void a(String str, List<CampaignEx> list, List<CampaignEx> list2, boolean z4) {
        String str2;
        if (getWritableDatabase() != null) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        for (CampaignEx next : list) {
                            try {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("readyState", 0);
                                String[] strArr = {str, next.getId(), next.getRequestId()};
                                if (z4) {
                                    str2 = "unitid = ? AND id = ? AND request_id = ? " + " AND " + "is_bid_campaign" + " = 1";
                                } else {
                                    str2 = "unitid = ? AND id = ? AND request_id = ? " + " AND " + "is_bid_campaign" + " = 0";
                                }
                                getWritableDatabase().update("campaign", contentValues, str2, strArr);
                            } catch (Exception e5) {
                                if (MBridgeConstans.DEBUG) {
                                    af.b("CampaignDao", e5.getLocalizedMessage());
                                }
                            }
                        }
                    }
                } catch (Exception e6) {
                    try {
                        if (MBridgeConstans.DEBUG) {
                            af.b("CampaignDao", e6.getLocalizedMessage());
                        }
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (list2 != null && list2.size() > 0) {
                for (CampaignEx next2 : list2) {
                    try {
                        if (next2.getLoadTimeoutState() == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("unitid");
                            sb.append(" = ? AND ");
                            sb.append("id");
                            sb.append(" = ? AND ");
                            sb.append("request_id");
                            sb.append(" = ? ");
                            String[] strArr2 = {str, next2.getId(), next2.getRequestId()};
                            if (z4) {
                                sb.append(" AND is_bid_campaign = 1");
                            } else {
                                sb.append(" AND is_bid_campaign = 0");
                            }
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("readyState", 2);
                            getWritableDatabase().update("campaign", contentValues2, sb.toString(), strArr2);
                        }
                    } catch (SQLException e7) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("CampaignDao", e7.getLocalizedMessage());
                        }
                    }
                }
            }
        }
    }

    public final synchronized void a(String str, List<CampaignEx> list, String str2) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx next : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("local_request_id", str2);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, "unitid = ? AND id = ? AND request_id = ? ", new String[]{str, next.getId(), next.getRequestId()});
                        }
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("CampaignDao", e5.getLocalizedMessage());
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "id = ? AND unitid = ? "
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ Exception -> 0x001b }
            android.database.sqlite.SQLiteDatabase r4 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x001b }
            if (r4 != 0) goto L_0x000f
            monitor-exit(r2)
            return
        L_0x000f:
            android.database.sqlite.SQLiteDatabase r4 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x001b }
            java.lang.String r1 = "campaign"
            r4.delete(r1, r0, r3)     // Catch:{ Exception -> 0x001b }
            goto L_0x0029
        L_0x0019:
            r3 = move-exception
            goto L_0x002b
        L_0x001b:
            r3 = move-exception
            boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0019 }
            if (r4 == 0) goto L_0x0029
            java.lang.String r4 = "CampaignDao"
            java.lang.String r3 = r3.getLocalizedMessage()     // Catch:{ all -> 0x0019 }
            com.mbridge.msdk.foundation.tools.af.b(r4, r3)     // Catch:{ all -> 0x0019 }
        L_0x0029:
            monitor-exit(r2)
            return
        L_0x002b:
            monitor-exit(r2)     // Catch:{ all -> 0x0019 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.a(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r3)
            return
        L_0x0009:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003c }
            r0.<init>()     // Catch:{ Exception -> 0x003c }
            java.lang.String r1 = "unitid"
            r0.append(r1)     // Catch:{ Exception -> 0x003c }
            java.lang.String r1 = " = ? AND "
            r0.append(r1)     // Catch:{ Exception -> 0x003c }
            java.lang.String r1 = "readyState"
            r0.append(r1)     // Catch:{ Exception -> 0x003c }
            java.lang.String r1 = " = "
            r0.append(r1)     // Catch:{ Exception -> 0x003c }
            r1 = 2
            r0.append(r1)     // Catch:{ Exception -> 0x003c }
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x003c }
            android.database.sqlite.SQLiteDatabase r1 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x003c }
            if (r1 == 0) goto L_0x004a
            java.lang.String r2 = "campaign"
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x003c }
            r1.delete(r2, r0, r4)     // Catch:{ Exception -> 0x003c }
            goto L_0x004a
        L_0x003a:
            r4 = move-exception
            goto L_0x004c
        L_0x003c:
            r4 = move-exception
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x004a
            java.lang.String r0 = "CampaignDao"
            java.lang.String r4 = r4.getLocalizedMessage()     // Catch:{ all -> 0x003a }
            com.mbridge.msdk.foundation.tools.af.b(r0, r4)     // Catch:{ all -> 0x003a }
        L_0x004a:
            monitor-exit(r3)
            return
        L_0x004c:
            monitor-exit(r3)     // Catch:{ all -> 0x003a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.a(java.lang.String):void");
    }

    public final synchronized void a(List<CampaignEx> list, String str) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx next : list) {
                    try {
                        String[] strArr = {str, next.getId(), next.getRequestId()};
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("readyState", 2);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, "unitid" + " = ? AND " + "id" + " = ? AND " + "request_id" + " = ? ", strArr);
                        }
                    } catch (SQLException e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("CampaignDao", e5.getLocalizedMessage());
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r2, java.lang.String r3, boolean r4, java.lang.String r5) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "id = ? AND unitid = ? AND is_bid_campaign = ? AND request_id = ? "
            if (r4 == 0) goto L_0x000c
            java.lang.String r4 = "1"
            goto L_0x000e
        L_0x0008:
            r2 = move-exception
            goto L_0x0042
        L_0x000a:
            r2 = move-exception
            goto L_0x0033
        L_0x000c:
            java.lang.String r4 = "0"
        L_0x000e:
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5}     // Catch:{ Exception -> 0x000a }
            android.database.sqlite.SQLiteDatabase r3 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x000a }
            if (r3 != 0) goto L_0x001a
            monitor-exit(r1)
            return
        L_0x001a:
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x000a }
            r3.<init>()     // Catch:{ Exception -> 0x000a }
            java.lang.String r4 = "readyState"
            r5 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x000a }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x000a }
            android.database.sqlite.SQLiteDatabase r4 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x000a }
            java.lang.String r5 = "campaign"
            r4.update(r5, r3, r0, r2)     // Catch:{ Exception -> 0x000a }
            goto L_0x0040
        L_0x0033:
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0008 }
            if (r3 == 0) goto L_0x0040
            java.lang.String r3 = "CampaignDao"
            java.lang.String r2 = r2.getLocalizedMessage()     // Catch:{ all -> 0x0008 }
            com.mbridge.msdk.foundation.tools.af.b(r3, r2)     // Catch:{ all -> 0x0008 }
        L_0x0040:
            monitor-exit(r1)
            return
        L_0x0042:
            monitor-exit(r1)     // Catch:{ all -> 0x0008 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.a(java.lang.String, java.lang.String, boolean, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r2, java.lang.String r3, int r4, int r5, boolean r6) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "id = ? AND unitid = ? AND level = ? AND adSource = ? "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0025 }
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5}     // Catch:{ Exception -> 0x0025 }
            if (r6 == 0) goto L_0x0027
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            r3.<init>()     // Catch:{ Exception -> 0x0025 }
            r3.append(r0)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r4 = " AND is_bid_campaign = 1"
            r3.append(r4)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0025 }
            goto L_0x0038
        L_0x0023:
            r2 = move-exception
            goto L_0x0059
        L_0x0025:
            r2 = move-exception
            goto L_0x004a
        L_0x0027:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            r3.<init>()     // Catch:{ Exception -> 0x0025 }
            r3.append(r0)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r4 = " AND is_bid_campaign = 0"
            r3.append(r4)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0025 }
        L_0x0038:
            android.database.sqlite.SQLiteDatabase r4 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x0025 }
            if (r4 != 0) goto L_0x0040
            monitor-exit(r1)
            return
        L_0x0040:
            android.database.sqlite.SQLiteDatabase r4 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x0025 }
            java.lang.String r5 = "campaign"
            r4.delete(r5, r3, r2)     // Catch:{ Exception -> 0x0025 }
            goto L_0x0057
        L_0x004a:
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0023 }
            if (r3 == 0) goto L_0x0057
            java.lang.String r3 = "CampaignDao"
            java.lang.String r2 = r2.getLocalizedMessage()     // Catch:{ all -> 0x0023 }
            com.mbridge.msdk.foundation.tools.af.b(r3, r2)     // Catch:{ all -> 0x0023 }
        L_0x0057:
            monitor-exit(r1)
            return
        L_0x0059:
            monitor-exit(r1)     // Catch:{ all -> 0x0023 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.a(java.lang.String, java.lang.String, int, int, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r2, int r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r4 == 0) goto L_0x0012
            java.lang.String r4 = "placement_id = ? AND ad_type = ? "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0010 }
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ Exception -> 0x0010 }
            goto L_0x002b
        L_0x000e:
            r2 = move-exception
            goto L_0x004c
        L_0x0010:
            r2 = move-exception
            goto L_0x003d
        L_0x0012:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0010 }
            r2.<init>()     // Catch:{ Exception -> 0x0010 }
            java.lang.String r4 = "ad_type = "
            r2.append(r4)     // Catch:{ Exception -> 0x0010 }
            r2.append(r3)     // Catch:{ Exception -> 0x0010 }
            java.lang.String r4 = r2.toString()     // Catch:{ Exception -> 0x0010 }
            java.lang.String r2 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0010 }
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x0010 }
        L_0x002b:
            android.database.sqlite.SQLiteDatabase r3 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x0010 }
            if (r3 != 0) goto L_0x0033
            monitor-exit(r1)
            return
        L_0x0033:
            android.database.sqlite.SQLiteDatabase r3 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x0010 }
            java.lang.String r0 = "campaign"
            r3.delete(r0, r4, r2)     // Catch:{ Exception -> 0x0010 }
            goto L_0x004a
        L_0x003d:
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x000e }
            if (r3 == 0) goto L_0x004a
            java.lang.String r3 = "CampaignDao"
            java.lang.String r2 = r2.getLocalizedMessage()     // Catch:{ all -> 0x000e }
            com.mbridge.msdk.foundation.tools.af.b(r3, r2)     // Catch:{ all -> 0x000e }
        L_0x004a:
            monitor-exit(r1)
            return
        L_0x004c:
            monitor-exit(r1)     // Catch:{ all -> 0x000e }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.a(java.lang.String, int, boolean):void");
    }

    public final synchronized void a() {
        try {
            String[] strArr = {String.valueOf(System.currentTimeMillis() - 3600000)};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", "ts< ? AND ts>0", strArr);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignDao", e5.getLocalizedMessage());
            }
        }
    }

    public final synchronized void a(long j5, String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = "(plctb>0 and (plctb* 1000+ts)< " + currentTimeMillis + " ) or (" + CampaignEx.JSON_KEY_PLCTB + "<=" + 0 + " and " + CampaignEx.JSON_KEY_ST_TS + "< " + (currentTimeMillis - j5) + " ) and " + "unitid" + "=?";
            String[] strArr = {str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", str2, strArr);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignDao", e5.getLocalizedMessage());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2, java.lang.String r3, java.lang.String r4, int r5) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x002c
            int r0 = r2.size()     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x000a
            goto L_0x002c
        L_0x000a:
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x0012
            monitor-exit(r1)
            return
        L_0x0012:
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0026 }
        L_0x0016:
            boolean r0 = r2.hasNext()     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r2.next()     // Catch:{ all -> 0x0026 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ all -> 0x0026 }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0, (java.lang.String) r3, (java.lang.String) r4, (int) r5)     // Catch:{ all -> 0x0026 }
            goto L_0x0016
        L_0x0026:
            r2 = move-exception
            goto L_0x002a
        L_0x0028:
            monitor-exit(r1)
            return
        L_0x002a:
            monitor-exit(r1)     // Catch:{ all -> 0x0026 }
            throw r2
        L_0x002c:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.a(java.util.List, java.lang.String, java.lang.String, int):void");
    }

    private synchronized long a(CampaignEx campaignEx, String str, String str2, int i5) {
        if (campaignEx == null) {
            return 0;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1;
            }
            ContentValues contentValues = new ContentValues();
            if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String put : campaignEx.getPv_urls()) {
                    jSONArray.put(put);
                }
                contentValues.put("pv_urls", jSONArray.toString());
            }
            contentValues.put("id", campaignEx.getId());
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            contentValues.put("placement_id", str);
            contentValues.put("unitid", str2);
            contentValues.put("tab", Integer.valueOf(campaignEx.getTab()));
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
            contentValues.put(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
            contentValues.put("deeplink_url", campaignEx.getDeepLinkURL());
            contentValues.put(CampaignEx.JSON_KEY_USER_ACTIVATION, Boolean.toString(campaignEx.getUserActivation()));
            contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
            contentValues.put(b.JSON_KEY_C_I, campaignEx.getNetAddress());
            contentValues.put(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH, Integer.valueOf(campaignEx.getAc_s()));
            contentValues.put(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME, campaignEx.getAc());
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
            contentValues.put("fc_b", Integer.valueOf(campaignEx.getFcb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Integer.valueOf(campaignEx.getVideoSize()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, Integer.valueOf(campaignEx.getVideoLength()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
            contentValues.put(CampaignEx.JSON_KEY_ENDCARD_CLICK, Integer.valueOf(campaignEx.getEndcard_click_result()));
            contentValues.put(CampaignEx.JSON_KEY_WATCH_MILE, Integer.valueOf(campaignEx.getWatchMile()));
            contentValues.put("advImp", campaignEx.getAdvImp());
            contentValues.put("bty", Integer.valueOf(campaignEx.getBty()));
            contentValues.put(CampaignEx.JSON_KEY_T_IMP, Integer.valueOf(campaignEx.getTImp()));
            contentValues.put(CampaignEx.JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
            contentValues.put(CampaignEx.JSON_KEY_OFFER_TYPE, Integer.valueOf(campaignEx.getOfferType()));
            contentValues.put(b.JSON_KEY_HTML_URL, campaignEx.getHtmlUrl());
            contentValues.put(b.JSON_KEY_END_SCREEN_URL, campaignEx.getEndScreenUrl());
            contentValues.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, Integer.valueOf(campaignEx.getRewardAmount()));
            contentValues.put(CampaignEx.JSON_KEY_REWARD_NAME, campaignEx.getRewardName());
            contentValues.put("reward_play_status", Integer.valueOf(campaignEx.getRewardPlayStatus()));
            contentValues.put("retarget", Integer.valueOf(campaignEx.getRetarget_offer()));
            contentValues.put("native_ad_tracking", campaignEx.getNativeVideoTrackingString());
            contentValues.put(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO, Integer.valueOf(campaignEx.getPlayable_ads_without_video()));
            contentValues.put(CampaignEx.ENDCARD_URL, campaignEx.getendcard_url());
            contentValues.put(CampaignEx.VIDEO_END_TYPE, Integer.valueOf(campaignEx.getVideo_end_type()));
            contentValues.put(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
            contentValues.put(CampaignEx.JSON_KEY_NV_T2, Integer.valueOf(campaignEx.getNvT2()));
            contentValues.put(CampaignEx.JSON_KEY_GIF_URL, campaignEx.getGifUrl());
            if (campaignEx.getRewardTemplateMode() != null) {
                contentValues.put("reward_teamplate", campaignEx.getRewardTemplateMode().d());
            }
            contentValues.put("c_coi", Integer.valueOf(campaignEx.getClickTimeOutInterval()));
            contentValues.put(CampaignEx.JSON_KEY_C_UA, Integer.valueOf(campaignEx.getcUA()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_UA, Integer.valueOf(campaignEx.getImpUA()));
            contentValues.put(CampaignEx.JSON_KEY_JM_PD, Integer.valueOf(campaignEx.getJmPd()));
            contentValues.put("is_deleted", Integer.valueOf(campaignEx.getIsDeleted()));
            contentValues.put("is_click", Integer.valueOf(campaignEx.getIsClick()));
            contentValues.put("is_add_sucesful", Integer.valueOf(campaignEx.getIsAddSuccesful()));
            contentValues.put("short_ctime", String.valueOf(System.currentTimeMillis()));
            contentValues.put("ia_icon", campaignEx.getKeyIaIcon());
            contentValues.put("ia_url", campaignEx.getKeyIaUrl());
            contentValues.put("ia_rst", Integer.valueOf(campaignEx.getKeyIaRst()));
            contentValues.put("ia_ori", Integer.valueOf(campaignEx.getKeyIaOri()));
            contentValues.put("ad_type", Integer.valueOf(campaignEx.getAdType()));
            contentValues.put(CampaignEx.KEY_IA_EXT1, campaignEx.getIa_ext1());
            contentValues.put(CampaignEx.KEY_IA_EXT2, campaignEx.getIa_ext2());
            contentValues.put(CampaignEx.KEY_IS_DOWNLOAD, Integer.valueOf(campaignEx.getIsDownLoadZip()));
            contentValues.put(CampaignEx.KEY_IA_CACHE, campaignEx.getInteractiveCache());
            contentValues.put(CampaignEx.KEY_OC_TIME, Integer.valueOf(campaignEx.getOc_time()));
            contentValues.put(CampaignEx.KEY_OC_TYPE, Integer.valueOf(campaignEx.getOc_type()));
            contentValues.put(CampaignEx.KEY_T_LIST, campaignEx.getT_list());
            CampaignEx.a adchoice = campaignEx.getAdchoice();
            if (adchoice != null) {
                contentValues.put(CampaignEx.KEY_ADCHOICE, adchoice.a());
                contentValues.put("adchoice_size_height", Integer.valueOf(adchoice.e()));
                contentValues.put("adchoice_size_width", Integer.valueOf(adchoice.f()));
            }
            contentValues.put(CampaignEx.JSON_KEY_PLCT, Long.valueOf(campaignEx.getPlct()));
            contentValues.put(CampaignEx.JSON_KEY_PLCTB, Long.valueOf(campaignEx.getPlctb()));
            contentValues.put(CampaignEx.JSON_KEY_C_C_TIME, Long.valueOf(campaignEx.getCandidateCacheTime()));
            contentValues.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getAdHtml());
            contentValues.put("ad_zip", campaignEx.getAdZip());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_URL, campaignEx.getBannerUrl());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_HTML, campaignEx.getBannerHtml());
            contentValues.put(CampaignEx.JSON_KEY_CREATIVE_ID, Long.valueOf(campaignEx.getCreativeId()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CREATIVE_ID, Long.valueOf(campaignEx.getVidCrtvId()));
            contentValues.put(CampaignEx.JSON_KEY_EC_CREATIVE_ID, Long.valueOf(campaignEx.getEcCrtvId()));
            contentValues.put(CampaignEx.JSON_KEY_EC_TEMP_ID, Long.valueOf(campaignEx.getEcTemplateId()));
            contentValues.put("is_bid_campaign", Boolean.valueOf(campaignEx.isBidCampaign()));
            contentValues.put("bid_token", campaignEx.getBidToken());
            contentValues.put(CampaignEx.JSON_KEY_MRAID, campaignEx.getMraid());
            contentValues.put("is_mraid_campaign", Boolean.valueOf(campaignEx.isMraid()));
            contentValues.put(CampaignEx.KEY_OMID, campaignEx.getOmid());
            contentValues.put(b.JSON_KEY_MOF_TPLID, Integer.valueOf(campaignEx.getMof_tplid()));
            contentValues.put(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(campaignEx.getReady_rate()));
            contentValues.put(CampaignEx.JSON_KEY_EXT_DATA, campaignEx.getExt_data());
            contentValues.put(b.JSON_KEY_NSCPT, Integer.valueOf(campaignEx.getNscpt()));
            contentValues.put(b.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
            contentValues.put(b.JSON_KEY_REQ_EXT_DATA, campaignEx.getReq_ext_data());
            contentValues.put("readyState", Integer.valueOf(campaignEx.getReadyState()));
            contentValues.put("request_id", campaignEx.getRequestId());
            contentValues.put("n_request_id", campaignEx.getNRid());
            contentValues.put("local_request_id", campaignEx.getLocalRequestId());
            contentValues.put("n_local_request_id", campaignEx.getNLRid());
            contentValues.put("err_type_default_ad", Integer.valueOf(campaignEx.getTyped()));
            contentValues.put("err_reason_default_ad", campaignEx.getReasond());
            contentValues.put("load_timeout", Integer.valueOf(campaignEx.getLoadTimeoutState()));
            contentValues.put(CampaignEx.JSON_KEY_MAITVE, Integer.valueOf(campaignEx.getMaitve()));
            contentValues.put(CampaignEx.JSON_KEY_MAITVESRC, campaignEx.getMaitve_src());
            contentValues.put(CampaignEx.JSON_KEY_FLB, Integer.valueOf(campaignEx.getFlb()));
            contentValues.put(CampaignEx.JSON_KEY_FLB_SKIP_TIME, Integer.valueOf(campaignEx.getFlbSkipTime()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD, Integer.valueOf(campaignEx.getCbd()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST, Integer.valueOf(campaignEx.getVst()));
            contentValues.put(CampaignEx.JSON_KEY_USE_SKIP_TIME, Integer.valueOf(campaignEx.getUseSkipTime()));
            contentValues.put(CampaignEx.JSON_KEY_PROG_BAR, Integer.valueOf(campaignEx.getProgressBarShow()));
            contentValues.put("vcn", Integer.valueOf(campaignEx.getVcn()));
            contentValues.put("token_r", Integer.valueOf(campaignEx.getTokenRule()));
            contentValues.put("encrypt_p", campaignEx.getEncryptPrice());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE, Integer.valueOf(campaignEx.getVideoCheckType()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE, Integer.valueOf(campaignEx.getVideoCtnType()));
            contentValues.put(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRuleString());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME, Integer.valueOf(campaignEx.getVideoCompleteTime()));
            contentValues.put(CampaignEx.JSON_KEY_TP_OFFER, Integer.valueOf(campaignEx.getTpOffer()));
            contentValues.put(CampaignEx.JSON_KEY_FAC, Integer.valueOf(campaignEx.getFac()));
            if (campaignEx.getAabEntity() != null) {
                contentValues.put(CampaignEx.JSON_KEY_AAB, campaignEx.getAabEntity().toJson().toString());
            }
            contentValues.put(CampaignEx.JSON_KEY_PRIVACY_URL, campaignEx.getPrivacyUrl());
            contentValues.put("privacy_button_video", Integer.valueOf(campaignEx.getPrivacyButtonTemplateVisibility()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_REPORT_TYPE, Integer.valueOf(campaignEx.getImpReportType()));
            contentValues.put("auto_minicard", Integer.valueOf(campaignEx.getAutoShowStoreMiniCard()));
            contentValues.put("mincard_trigger_time", Integer.valueOf(campaignEx.getShowStoreMiniCardDelayTime()));
            return getWritableDatabase().insert("campaign", (String) null, contentValues);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignDao", e5.getLocalizedMessage());
            }
            return -1;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final synchronized long a(CampaignEx campaignEx, String str, int i5) {
        String[] strArr;
        String str2;
        if (campaignEx == null) {
            return 0;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", campaignEx.getId());
            if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String put : campaignEx.getPv_urls()) {
                    jSONArray.put(put);
                }
                contentValues.put("pv_urls", jSONArray.toString());
            }
            contentValues.put("unitid", str);
            contentValues.put("request_id", campaignEx.getRequestId());
            contentValues.put("n_request_id", campaignEx.getNRid());
            contentValues.put("local_request_id", campaignEx.getLocalRequestId());
            contentValues.put("n_local_request_id", campaignEx.getNLRid());
            contentValues.put("err_type_default_ad", Integer.valueOf(campaignEx.getTyped()));
            contentValues.put("err_reason_default_ad", campaignEx.getReasond());
            contentValues.put("tab", Integer.valueOf(campaignEx.getTab()));
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
            contentValues.put(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
            contentValues.put("deeplink_url", campaignEx.getDeepLinkURL());
            contentValues.put(CampaignEx.JSON_KEY_USER_ACTIVATION, Boolean.toString(campaignEx.getUserActivation()));
            contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
            contentValues.put(b.JSON_KEY_C_I, campaignEx.getNetAddress());
            contentValues.put(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH, Integer.valueOf(campaignEx.getAc_s()));
            contentValues.put(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME, campaignEx.getAc());
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
            contentValues.put("fc_b", Integer.valueOf(campaignEx.getFcb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Integer.valueOf(campaignEx.getVideoSize()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, Integer.valueOf(campaignEx.getVideoLength()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
            contentValues.put(CampaignEx.JSON_KEY_ENDCARD_CLICK, Integer.valueOf(campaignEx.getEndcard_click_result()));
            contentValues.put(CampaignEx.JSON_KEY_WATCH_MILE, Integer.valueOf(campaignEx.getWatchMile()));
            contentValues.put("advImp", campaignEx.getAdvImp());
            contentValues.put("bty", Integer.valueOf(campaignEx.getBty()));
            contentValues.put(CampaignEx.JSON_KEY_T_IMP, Integer.valueOf(campaignEx.getTImp()));
            contentValues.put(CampaignEx.JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
            contentValues.put(CampaignEx.JSON_KEY_OFFER_TYPE, Integer.valueOf(campaignEx.getOfferType()));
            contentValues.put(b.JSON_KEY_HTML_URL, campaignEx.getHtmlUrl());
            contentValues.put(b.JSON_KEY_END_SCREEN_URL, campaignEx.getEndScreenUrl());
            contentValues.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, Integer.valueOf(campaignEx.getRewardAmount()));
            contentValues.put(CampaignEx.JSON_KEY_REWARD_NAME, campaignEx.getRewardName());
            contentValues.put("reward_play_status", Integer.valueOf(campaignEx.getRewardPlayStatus()));
            contentValues.put("retarget", Integer.valueOf(campaignEx.getRetarget_offer()));
            contentValues.put("native_ad_tracking", campaignEx.getNativeVideoTrackingString());
            contentValues.put(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO, Integer.valueOf(campaignEx.getPlayable_ads_without_video()));
            contentValues.put(CampaignEx.ENDCARD_URL, campaignEx.getendcard_url());
            contentValues.put(CampaignEx.VIDEO_END_TYPE, Integer.valueOf(campaignEx.getVideo_end_type()));
            contentValues.put(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
            contentValues.put(CampaignEx.JSON_KEY_NV_T2, Integer.valueOf(campaignEx.getNvT2()));
            contentValues.put(CampaignEx.JSON_KEY_GIF_URL, campaignEx.getGifUrl());
            if (campaignEx.getRewardTemplateMode() != null) {
                contentValues.put("reward_teamplate", campaignEx.getRewardTemplateMode().d());
            }
            contentValues.put("c_coi", Integer.valueOf(campaignEx.getClickTimeOutInterval()));
            contentValues.put(CampaignEx.JSON_KEY_C_UA, Integer.valueOf(campaignEx.getcUA()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_UA, Integer.valueOf(campaignEx.getImpUA()));
            contentValues.put(CampaignEx.JSON_KEY_JM_PD, Integer.valueOf(campaignEx.getJmPd()));
            contentValues.put("is_deleted", Integer.valueOf(campaignEx.getIsDeleted()));
            contentValues.put("is_click", Integer.valueOf(campaignEx.getIsClick()));
            contentValues.put("is_add_sucesful", Integer.valueOf(campaignEx.getIsAddSuccesful()));
            contentValues.put("short_ctime", String.valueOf(System.currentTimeMillis()));
            contentValues.put("ia_icon", campaignEx.getKeyIaIcon());
            contentValues.put("ia_url", campaignEx.getKeyIaUrl());
            contentValues.put("ia_rst", Integer.valueOf(campaignEx.getKeyIaRst()));
            contentValues.put("ia_ori", Integer.valueOf(campaignEx.getKeyIaOri()));
            contentValues.put("ad_type", Integer.valueOf(campaignEx.getAdType()));
            contentValues.put(CampaignEx.KEY_IA_EXT1, campaignEx.getIa_ext1());
            contentValues.put(CampaignEx.KEY_IA_EXT2, campaignEx.getIa_ext2());
            contentValues.put(CampaignEx.KEY_IS_DOWNLOAD, Integer.valueOf(campaignEx.getIsDownLoadZip()));
            contentValues.put(CampaignEx.KEY_IA_CACHE, campaignEx.getInteractiveCache());
            contentValues.put(CampaignEx.KEY_OC_TIME, Integer.valueOf(campaignEx.getOc_time()));
            contentValues.put(CampaignEx.KEY_OC_TYPE, Integer.valueOf(campaignEx.getOc_type()));
            contentValues.put(CampaignEx.KEY_T_LIST, campaignEx.getT_list());
            CampaignEx.a adchoice = campaignEx.getAdchoice();
            if (adchoice != null) {
                contentValues.put(CampaignEx.KEY_ADCHOICE, adchoice.a());
                contentValues.put("adchoice_size_height", Integer.valueOf(adchoice.e()));
                contentValues.put("adchoice_size_width", Integer.valueOf(adchoice.f()));
            }
            contentValues.put(CampaignEx.JSON_KEY_PLCT, Long.valueOf(campaignEx.getPlct()));
            contentValues.put(CampaignEx.JSON_KEY_PLCTB, Long.valueOf(campaignEx.getPlctb()));
            contentValues.put(CampaignEx.JSON_KEY_C_C_TIME, Long.valueOf(campaignEx.getCandidateCacheTime()));
            contentValues.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getAdHtml());
            contentValues.put("ad_zip", campaignEx.getAdZip());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_URL, campaignEx.getBannerUrl());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_HTML, campaignEx.getBannerHtml());
            contentValues.put(CampaignEx.JSON_KEY_CREATIVE_ID, Long.valueOf(campaignEx.getCreativeId()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CREATIVE_ID, Long.valueOf(campaignEx.getVidCrtvId()));
            contentValues.put(CampaignEx.JSON_KEY_EC_CREATIVE_ID, Long.valueOf(campaignEx.getEcCrtvId()));
            contentValues.put(CampaignEx.JSON_KEY_EC_TEMP_ID, Long.valueOf(campaignEx.getEcTemplateId()));
            contentValues.put("is_bid_campaign", Boolean.valueOf(campaignEx.isBidCampaign()));
            contentValues.put("bid_token", campaignEx.getBidToken());
            contentValues.put(CampaignEx.JSON_KEY_MRAID, campaignEx.getMraid());
            contentValues.put("is_mraid_campaign", Boolean.valueOf(campaignEx.isMraid()));
            contentValues.put(CampaignEx.KEY_OMID, campaignEx.getOmid());
            contentValues.put(b.JSON_KEY_MOF_TPLID, Integer.valueOf(campaignEx.getMof_tplid()));
            contentValues.put(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(campaignEx.getReady_rate()));
            contentValues.put(CampaignEx.JSON_KEY_EXT_DATA, campaignEx.getExt_data());
            contentValues.put(b.JSON_KEY_NSCPT, Integer.valueOf(campaignEx.getNscpt()));
            contentValues.put(b.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
            contentValues.put(b.JSON_KEY_REQ_EXT_DATA, campaignEx.getReq_ext_data());
            contentValues.put("readyState", Integer.valueOf(campaignEx.getReadyState()));
            contentValues.put("load_timeout", Integer.valueOf(campaignEx.getLoadTimeoutState()));
            contentValues.put("placement_id", campaignEx.getPlacementId());
            contentValues.put(CampaignEx.JSON_KEY_MAITVE, Integer.valueOf(campaignEx.getMaitve()));
            contentValues.put(CampaignEx.JSON_KEY_MAITVESRC, campaignEx.getMaitve_src());
            contentValues.put(CampaignEx.JSON_KEY_FLB, Integer.valueOf(campaignEx.getFlb()));
            contentValues.put(CampaignEx.JSON_KEY_FLB_SKIP_TIME, Integer.valueOf(campaignEx.getFlbSkipTime()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD, Integer.valueOf(campaignEx.getCbd()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST, Integer.valueOf(campaignEx.getVst()));
            contentValues.put(CampaignEx.JSON_KEY_USE_SKIP_TIME, Integer.valueOf(campaignEx.getUseSkipTime()));
            contentValues.put(CampaignEx.JSON_KEY_PROG_BAR, Integer.valueOf(campaignEx.getProgressBarShow()));
            contentValues.put("vcn", Integer.valueOf(campaignEx.getVcn()));
            contentValues.put("token_r", Integer.valueOf(campaignEx.getTokenRule()));
            contentValues.put("encrypt_p", campaignEx.getEncryptPrice());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE, Integer.valueOf(campaignEx.getVideoCheckType()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE, Integer.valueOf(campaignEx.getVideoCtnType()));
            contentValues.put(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRuleString());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME, Integer.valueOf(campaignEx.getVideoCompleteTime()));
            contentValues.put(CampaignEx.JSON_KEY_TP_OFFER, Integer.valueOf(campaignEx.getTpOffer()));
            contentValues.put(CampaignEx.JSON_KEY_FAC, Integer.valueOf(campaignEx.getFac()));
            contentValues.put(CampaignEx.JSON_KEY_PRIVACY_URL, campaignEx.getPrivacyUrl());
            contentValues.put("privacy_button_video", Integer.valueOf(campaignEx.getPrivacyButtonTemplateVisibility()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_REPORT_TYPE, Integer.valueOf(campaignEx.getImpReportType()));
            if (campaignEx.getAabEntity() != null) {
                contentValues.put(CampaignEx.JSON_KEY_AAB, campaignEx.getAabEntity().toJson().toString());
            }
            contentValues.put("auto_minicard", Integer.valueOf(campaignEx.getAutoShowStoreMiniCard()));
            contentValues.put("mincard_trigger_time", Integer.valueOf(campaignEx.getShowStoreMiniCardDelayTime()));
            if (a(campaignEx.getId(), campaignEx.getTab(), str, i5, campaignEx.getType(), campaignEx.isBidCampaign())) {
                if (campaignEx.isBidCampaign()) {
                    str2 = "unitid = ? AND is_bid_campaign = 1";
                    strArr = new String[]{str};
                } else {
                    strArr = new String[]{campaignEx.getId(), str};
                    str2 = "id = ? AND unitid = ? AND is_bid_campaign = 0";
                }
                return (long) getWritableDatabase().update("campaign", contentValues, str2, strArr);
            }
            return getWritableDatabase().insert("campaign", (String) null, contentValues);
        } catch (Exception e5) {
            Exception exc = e5;
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignDao", exc.getLocalizedMessage());
            }
            return -1;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0063, code lost:
        return -1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006f A[Catch:{ all -> 0x0059 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int a(java.lang.String r11, long r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            r1 = 0
            com.mbridge.msdk.c.h r0 = com.mbridge.msdk.c.h.a()     // Catch:{ Exception -> 0x0068, all -> 0x0065 }
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0068, all -> 0x0065 }
            java.lang.String r2 = r2.k()     // Catch:{ Exception -> 0x0068, all -> 0x0065 }
            com.mbridge.msdk.c.g r0 = r0.b(r2)     // Catch:{ Exception -> 0x0068, all -> 0x0065 }
            if (r0 != 0) goto L_0x0024
            com.mbridge.msdk.c.h.a()     // Catch:{ Exception -> 0x0020, all -> 0x001c }
            com.mbridge.msdk.c.g r0 = com.mbridge.msdk.c.i.a()     // Catch:{ Exception -> 0x0020, all -> 0x001c }
            goto L_0x0024
        L_0x001c:
            r0 = move-exception
            r11 = r0
            r4 = r10
            goto L_0x007a
        L_0x0020:
            r0 = move-exception
            r11 = r0
            r4 = r10
            goto L_0x006b
        L_0x0024:
            long r2 = r0.ad()     // Catch:{ Exception -> 0x0068, all -> 0x0065 }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r4
            r10.a((long) r2, (java.lang.String) r11)     // Catch:{ Exception -> 0x0068, all -> 0x0065 }
            r8 = 1
            r9 = 0
            r6 = 0
            r7 = 0
            r4 = r10
            r5 = r11
            java.util.List r11 = r4.a((java.lang.String) r5, (int) r6, (int) r7, (int) r8, (boolean) r9)     // Catch:{ Exception -> 0x005c }
            if (r11 == 0) goto L_0x0062
            boolean r0 = r11.isEmpty()     // Catch:{ Exception -> 0x005c }
            if (r0 == 0) goto L_0x0041
            goto L_0x0062
        L_0x0041:
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Exception -> 0x005c }
        L_0x0045:
            boolean r0 = r11.hasNext()     // Catch:{ Exception -> 0x005c }
            if (r0 == 0) goto L_0x005f
            java.lang.Object r0 = r11.next()     // Catch:{ Exception -> 0x005c }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ Exception -> 0x005c }
            boolean r0 = r0.isSpareOffer(r12, r2)     // Catch:{ Exception -> 0x005c }
            if (r0 != 0) goto L_0x0045
            monitor-exit(r10)
            return r1
        L_0x0059:
            r0 = move-exception
        L_0x005a:
            r11 = r0
            goto L_0x007a
        L_0x005c:
            r0 = move-exception
        L_0x005d:
            r11 = r0
            goto L_0x006b
        L_0x005f:
            monitor-exit(r10)
            r11 = 1
            return r11
        L_0x0062:
            monitor-exit(r10)
            r11 = -1
            return r11
        L_0x0065:
            r0 = move-exception
            r4 = r10
            goto L_0x005a
        L_0x0068:
            r0 = move-exception
            r4 = r10
            goto L_0x005d
        L_0x006b:
            boolean r12 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0059 }
            if (r12 == 0) goto L_0x0078
            java.lang.String r12 = "CampaignDao"
            java.lang.String r11 = r11.getLocalizedMessage()     // Catch:{ all -> 0x0059 }
            com.mbridge.msdk.foundation.tools.af.b(r12, r11)     // Catch:{ all -> 0x0059 }
        L_0x0078:
            monitor-exit(r10)
            return r1
        L_0x007a:
            monitor-exit(r10)     // Catch:{ all -> 0x0059 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.a(java.lang.String, long):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(java.lang.String r2, int r3, java.lang.String r4, int r5, int r6, boolean r7) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "SELECT id FROM campaign WHERE "
            if (r7 == 0) goto L_0x001d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x001b }
            r2.<init>()     // Catch:{ all -> 0x001b }
            r2.append(r0)     // Catch:{ all -> 0x001b }
            java.lang.String r3 = "unitid = ? AND is_bid_campaign = 1"
            r2.append(r3)     // Catch:{ all -> 0x001b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x001b }
            java.lang.String[] r3 = new java.lang.String[]{r4}     // Catch:{ all -> 0x001b }
            goto L_0x003f
        L_0x001b:
            r2 = move-exception
            goto L_0x005d
        L_0x001d:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x001b }
            r7.<init>()     // Catch:{ all -> 0x001b }
            r7.append(r0)     // Catch:{ all -> 0x001b }
            java.lang.String r0 = "id= ? AND tab= ? AND unitid = ? AND level = ? AND adSource = ? AND is_bid_campaign = 0"
            r7.append(r0)     // Catch:{ all -> 0x001b }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x001b }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x001b }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x001b }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x001b }
            java.lang.String[] r3 = new java.lang.String[]{r2, r3, r4, r5, r6}     // Catch:{ all -> 0x001b }
            r2 = r7
        L_0x003f:
            android.database.sqlite.SQLiteDatabase r4 = r1.getReadableDatabase()     // Catch:{ all -> 0x001b }
            android.database.Cursor r2 = r4.rawQuery(r2, r3)     // Catch:{ all -> 0x001b }
            if (r2 == 0) goto L_0x0055
            int r3 = r2.getCount()     // Catch:{ all -> 0x001b }
            if (r3 <= 0) goto L_0x0055
            r2.close()     // Catch:{ all -> 0x001b }
            monitor-exit(r1)
            r2 = 1
            return r2
        L_0x0055:
            if (r2 == 0) goto L_0x005a
            r2.close()     // Catch:{ all -> 0x001b }
        L_0x005a:
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x005d:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.a(java.lang.String, int, java.lang.String, int, int, boolean):boolean");
    }

    public final List<CampaignEx> a(String str, int i5, int i6, int i7) {
        String str2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(String.valueOf(i6));
        arrayList.add(String.valueOf(i7));
        if (i5 > 0) {
            arrayList.add(String.valueOf(i5));
            str2 = " LIMIT ?";
        } else {
            str2 = "";
        }
        return a("SELECT * FROM campaign" + " WHERE unitid = ? AND level = ? AND adSource = ?" + str2, (String[]) arrayList.toArray(new String[0]));
    }

    public final synchronized List<CampaignEx> a(String str, int i5, int i6, int i7, boolean z4) {
        ArrayList arrayList;
        String str2;
        String str3;
        try {
            arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add(String.valueOf(i6));
            arrayList.add(String.valueOf(i7));
            if (z4) {
                str2 = " WHERE unitid = ? AND level = ? AND adSource = ?" + " AND is_bid_campaign = 1";
            } else {
                str2 = " WHERE unitid = ? AND level = ? AND adSource = ?" + " AND is_bid_campaign = 0";
            }
            str3 = "";
            if (i5 > 0) {
                str3 = " LIMIT ?";
                arrayList.add(String.valueOf(i5));
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return a("SELECT * FROM campaign" + str2 + str3, (String[]) arrayList.toArray(new String[0]));
    }

    public final synchronized List<CampaignEx> a(String str, int i5, int i6, int i7, String str2) {
        String str3;
        ArrayList arrayList;
        String str4;
        try {
            str3 = (" WHERE unitid = ?  AND level = ?  AND adSource = ? " + " AND is_bid_campaign = 1") + " AND readyState = '0'";
            arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add(String.valueOf(i6));
            arrayList.add(String.valueOf(i7));
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + " AND request_id = ? ";
                arrayList.add(str2);
            }
            str4 = "";
            if (i5 > 0) {
                str4 = " LIMIT ?";
                arrayList.add(String.valueOf(i5));
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return a("SELECT * FROM campaign" + (str3 + " order by ts ASC") + str4, (String[]) arrayList.toArray(new String[0]));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x06f6, code lost:
        if (r8 != null) goto L_0x06f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x070d, code lost:
        if (r8 == null) goto L_0x0710;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0711, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0704 A[Catch:{ all -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0714 A[SYNTHETIC, Splitter:B:52:0x0714] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> a(java.lang.String r8, java.lang.String[] r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.getReadableDatabase()     // Catch:{ Exception -> 0x06fe, all -> 0x06fc }
            android.database.Cursor r8 = r1.rawQuery(r8, r9)     // Catch:{ Exception -> 0x06fe, all -> 0x06fc }
            if (r8 == 0) goto L_0x06f6
            int r9 = r8.getCount()     // Catch:{ Exception -> 0x0052 }
            if (r9 <= 0) goto L_0x06f6
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x0052 }
            r9.<init>()     // Catch:{ Exception -> 0x0052 }
        L_0x0017:
            boolean r1 = r8.moveToNext()     // Catch:{ Exception -> 0x0052 }
            if (r1 == 0) goto L_0x06ef
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = new com.mbridge.msdk.foundation.entity.CampaignEx     // Catch:{ Exception -> 0x0052 }
            r1.<init>()     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "pv_urls"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0052 }
            r4 = 0
            if (r3 != 0) goto L_0x0058
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ Exception -> 0x0052 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0052 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0052 }
            r2.<init>()     // Catch:{ Exception -> 0x0052 }
            r5 = r4
        L_0x003e:
            int r6 = r3.length()     // Catch:{ Exception -> 0x0052 }
            if (r5 >= r6) goto L_0x0055
            java.lang.String r6 = r3.getString(r5)     // Catch:{ Exception -> 0x0052 }
            r2.add(r6)     // Catch:{ Exception -> 0x0052 }
            int r5 = r5 + 1
            goto L_0x003e
        L_0x004e:
            r9 = move-exception
            r0 = r8
            goto L_0x0712
        L_0x0052:
            r9 = move-exception
            goto L_0x0700
        L_0x0055:
            r1.setPv_urls(r2)     // Catch:{ Exception -> 0x0052 }
        L_0x0058:
            java.lang.String r2 = "id"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setId(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "tab"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setTab(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "package_name"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setPackageName(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "app_name"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setAppName(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "app_desc"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setAppDesc(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "app_size"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setSize(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "image_size"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setImageSize(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "icon_url"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setIconUrl(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "image_url"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setImageUrl(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "impression_url"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setImpressionURL(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "notice_url"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setNoticeUrl(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "download_url"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setClickURL(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "wtick"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setWtick(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "deeplink_url"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setDeepLinkUrl(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "user_activation"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            boolean r2 = java.lang.Boolean.parseBoolean(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setUserActivation(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "only_impression"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setOnlyImpressionURL(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "c_i"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setNetAddress(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "ac"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setAc(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "ac_s"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setAc_s(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "template"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setTemplate(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "landing_type"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setLandingType(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "link_type"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setLinkType(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "click_mode"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setClick_mode(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "star"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            double r2 = java.lang.Double.parseDouble(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setRating(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "number_rating"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setNumberRating(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "cti"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setClickInterval(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "ts"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            long r2 = r8.getLong(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setTimestamp(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "level"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setCacheLevel(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "adSource"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setType(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "ad_call"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setAdCall(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "fc_a"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setFca(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "fc_b"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setFcb(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "ad_url_list"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setAd_url_list(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "video_length"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setVideoLength(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "video_size"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setVideoSize(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "video_resolution"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setVideoResolution(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "endcard_click_result"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setEndcard_click_result(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "video_url"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setVideoUrlEncode(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "watch_mile"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setWatchMile(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "t_imp"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setTImp(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "bty"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setBty(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "advImp"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setAdvImp(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "local_request_id"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setLocalRequestId(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "n_request_id"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setNRid(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "n_local_request_id"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setNLRid(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "err_type_default_ad"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setTyped(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "err_reason_default_ad"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setReasond(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "offer_type"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setOfferType(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "guidelines"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setGuidelines(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "html_url"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setHtmlUrl(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "end_screen_url"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setEndScreenUrl(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "reward_name"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setRewardName(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "reward_amount"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setRewardAmount(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "reward_play_status"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setRewardPlayStatus(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "retarget"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setRetarget_offer(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "unitid"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setCampaignUnitId(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "native_ad_tracking"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            com.mbridge.msdk.foundation.entity.j r2 = com.mbridge.msdk.foundation.entity.CampaignEx.TrackingStr2Object(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setNativeVideoTracking(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "native_ad_tracking"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setNativeVideoTrackingString(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "video_end_type"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setVideo_end_type(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "endcard_url"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setendcard_url(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "playable_ads_without_video"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setPlayable_ads_without_video(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "mof_template_url"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setMof_template_url(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "mof_tplid"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setMof_tplid(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "reward_teamplate"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r2 = com.mbridge.msdk.foundation.entity.CampaignEx.c.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0052 }
            r1.setRewardTemplateMode(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "md5_file"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setVideoMD5Value(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "gif_url"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setGifUrl(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "nv_t2"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setNvT2(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "c_coi"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setClickTimeOutInterval(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "c_ua"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setcUA(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "imp_ua"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setImpUA(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "oc_time"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setOc_time(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "oc_type"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setOc_type(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "t_list"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setT_list(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "gh_id"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setGhId(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "gh_path"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setGhPath(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "bind_id"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setBindId(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "adchoice"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0052 }
            if (r3 != 0) goto L_0x045b
            com.mbridge.msdk.foundation.entity.CampaignEx$a r2 = com.mbridge.msdk.foundation.entity.CampaignEx.a.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0052 }
            r1.setAdchoice(r2)     // Catch:{ Exception -> 0x0052 }
        L_0x045b:
            java.lang.String r2 = "adchoice_size_height"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setAdchoiceSizeHeight(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "adchoice_size_width"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setAdchoiceSizeWidth(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "plct"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            long r2 = r8.getLong(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setPlct(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "plctb"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            long r2 = r8.getLong(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setPlctb(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "c_c_time"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            long r2 = r8.getLong(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setCandidateCacheTime(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "ad_zip"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setAdZip(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "ad_html"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setAdHtml(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "banner_url"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setBannerUrl(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "banner_html"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setBannerHtml(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "creative_id"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            long r2 = r8.getLong(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setCreativeId(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "vid_crtv_id"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            long r2 = r8.getLong(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setVidCrtvId(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "ec_crtv_id"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            long r2 = r8.getLong(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setEcCrtvId(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "ec_temp_id"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            long r2 = r8.getLong(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setEcTemplateId(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "is_bid_campaign"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r3 = 1
            if (r2 != r3) goto L_0x0513
            r2 = r3
            goto L_0x0514
        L_0x0513:
            r2 = r4
        L_0x0514:
            r1.setIsBidCampaign(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "bid_token"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setBidToken(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "ad_type"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setAdType(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "fac"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setFac(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "tp_offer"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setTpOffer(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "mraid"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setMraid(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "is_mraid_campaign"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            if (r2 != r3) goto L_0x0565
            r4 = r3
        L_0x0565:
            r1.setIsMraid(r4)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "omid"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setOmid(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "ready_rate"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setReady_rate(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "ext_data"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setExt_data(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "nscpt"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setNscpt(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "req_ext_data"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setReq_ext_data(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "readyState"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setReadyState(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "load_timeout"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setLoadTimeoutState(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "placement_id"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setPlacementId(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "maitve"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setMaitve(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "maitve_src"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setMaitve_src(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "flb"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setFlb(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "flb_skiptime"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setFlbSkipTime(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "cbd"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setCbd(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "vst"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setVst(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "use_skip_time"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setUseSkipTime(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "prog_bar"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setProgressBarShow(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "adspace_t"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setAdSpaceT(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "vcn"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setVcn(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "token_r"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setTokenRule(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "encrypt_p"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setEncryptPrice(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "vck_t"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setVideoCheckType(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "vctn_t"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setVideoCtnType(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "rs_ignc_r"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setRsIgnoreCheckRuleByString(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "view_com_time"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setVideoCompleteTime(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "aab"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            com.mbridge.msdk.foundation.entity.AabEntity r2 = com.mbridge.msdk.foundation.entity.AabEntity.parser(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setAabEntity(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "privacy_url"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setPrivacyUrl(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "privacy_button_video"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setPrivacyButtonTemplateVisibility(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "imp_report_type"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setImpReportType(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "auto_minicard"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setAutoShowStoreMiniCard(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "mincard_trigger_time"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r8.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r1.setShowStoreMiniCardDelayTime(r2)     // Catch:{ Exception -> 0x0052 }
            r9.add(r1)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0017
        L_0x06ef:
            r8.close()     // Catch:{ all -> 0x06f4 }
            monitor-exit(r7)
            return r9
        L_0x06f4:
            r8 = move-exception
            goto L_0x0718
        L_0x06f6:
            if (r8 == 0) goto L_0x0710
        L_0x06f8:
            r8.close()     // Catch:{ all -> 0x06f4 }
            goto L_0x0710
        L_0x06fc:
            r9 = move-exception
            goto L_0x0712
        L_0x06fe:
            r9 = move-exception
            r8 = r0
        L_0x0700:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x070d
            java.lang.String r1 = "CampaignDao"
            java.lang.String r9 = r9.getLocalizedMessage()     // Catch:{ all -> 0x004e }
            com.mbridge.msdk.foundation.tools.af.b(r1, r9)     // Catch:{ all -> 0x004e }
        L_0x070d:
            if (r8 == 0) goto L_0x0710
            goto L_0x06f8
        L_0x0710:
            monitor-exit(r7)
            return r0
        L_0x0712:
            if (r0 == 0) goto L_0x0717
            r0.close()     // Catch:{ all -> 0x06f4 }
        L_0x0717:
            throw r9     // Catch:{ all -> 0x06f4 }
        L_0x0718:
            monitor-exit(r7)     // Catch:{ all -> 0x06f4 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.a(java.lang.String, java.lang.String[]):java.util.List");
    }

    private CampaignEx a(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        CampaignEx campaignEx = new CampaignEx();
        boolean z4 = false;
        try {
            String string = cursor.getString(cursor.getColumnIndex("pv_urls"));
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    arrayList.add(jSONArray.getString(i5));
                }
                campaignEx.setPv_urls(arrayList);
            }
        } catch (JSONException e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignDao", e5.getLocalizedMessage());
            }
        }
        campaignEx.setId(cursor.getString(cursor.getColumnIndex("id")));
        campaignEx.setTab(cursor.getInt(cursor.getColumnIndex("tab")));
        campaignEx.setPackageName(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_PACKAGE_NAME)));
        campaignEx.setAppName(cursor.getString(cursor.getColumnIndex("app_name")));
        campaignEx.setAppDesc(cursor.getString(cursor.getColumnIndex("app_desc")));
        campaignEx.setSize(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_APP_SIZE)));
        campaignEx.setImageSize(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_SIZE)));
        campaignEx.setIconUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_ICON_URL)));
        campaignEx.setImageUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_URL)));
        campaignEx.setImpressionURL(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMPRESSION_URL)));
        campaignEx.setNoticeUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_NOTICE_URL)));
        campaignEx.setClickURL(cursor.getString(cursor.getColumnIndex(DownloadModel.DOWNLOAD_URL)));
        campaignEx.setWtick(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK)));
        campaignEx.setDeepLinkUrl(cursor.getString(cursor.getColumnIndex("deeplink_url")));
        campaignEx.setUserActivation(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_USER_ACTIVATION))));
        campaignEx.setOnlyImpressionURL(cursor.getString(cursor.getColumnIndex("only_impression")));
        campaignEx.setNetAddress(cursor.getString(cursor.getColumnIndex(b.JSON_KEY_C_I)));
        campaignEx.setAc(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME)));
        campaignEx.setAc_s(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH)));
        campaignEx.setTemplate(cursor.getInt(cursor.getColumnIndex("template")));
        campaignEx.setLandingType(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_LANDING_TYPE)));
        campaignEx.setLinkType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_LINK_TYPE)));
        campaignEx.setClick_mode(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_CLICK_MODE)));
        campaignEx.setRating(Double.parseDouble(cursor.getString(cursor.getColumnIndex("star"))));
        campaignEx.setNumberRating(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NUMBER_RATING)));
        campaignEx.setClickInterval(cursor.getInt(cursor.getColumnIndex("cti")));
        campaignEx.setTimestamp(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_ST_TS)));
        campaignEx.setCacheLevel(cursor.getInt(cursor.getColumnIndex("level")));
        campaignEx.setAdCall(cursor.getString(cursor.getColumnIndex("ad_call")));
        campaignEx.setFcb(cursor.getInt(cursor.getColumnIndex("fc_b")));
        campaignEx.setAd_url_list(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AD_URL_LIST)));
        campaignEx.setVideoLength(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_LENGTHL)));
        campaignEx.setVideoSize(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_SIZE)));
        campaignEx.setVideoResolution(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_RESOLUTION)));
        campaignEx.setEndcard_click_result(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_ENDCARD_CLICK)));
        campaignEx.setVideoUrlEncode(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_URL)));
        campaignEx.setWatchMile(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_WATCH_MILE)));
        campaignEx.setTImp(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_T_IMP)));
        campaignEx.setBty(cursor.getInt(cursor.getColumnIndex("bty")));
        campaignEx.setAdvImp(cursor.getString(cursor.getColumnIndex("advImp")));
        campaignEx.setLocalRequestId(cursor.getString(cursor.getColumnIndex("local_request_id")));
        campaignEx.setNRid(cursor.getString(cursor.getColumnIndex("n_request_id")));
        campaignEx.setNLRid(cursor.getString(cursor.getColumnIndex("n_local_request_id")));
        campaignEx.setTyped(cursor.getInt(cursor.getColumnIndex("err_type_default_ad")));
        campaignEx.setReasond(cursor.getString(cursor.getColumnIndex("err_reason_default_ad")));
        campaignEx.setGuidelines(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
        campaignEx.setOfferType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_OFFER_TYPE)));
        campaignEx.setHtmlUrl(cursor.getString(cursor.getColumnIndex(b.JSON_KEY_HTML_URL)));
        campaignEx.setGuidelines(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
        campaignEx.setHtmlUrl(cursor.getString(cursor.getColumnIndex(b.JSON_KEY_HTML_URL)));
        campaignEx.setEndScreenUrl(cursor.getString(cursor.getColumnIndex(b.JSON_KEY_END_SCREEN_URL)));
        campaignEx.setRewardName(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_NAME)));
        campaignEx.setRewardAmount(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_AMOUNT)));
        campaignEx.setRewardPlayStatus(cursor.getInt(cursor.getColumnIndex("reward_play_status")));
        campaignEx.setRetarget_offer(cursor.getInt(cursor.getColumnIndex("retarget")));
        campaignEx.setCampaignUnitId(cursor.getString(cursor.getColumnIndex("unitid")));
        campaignEx.setNativeVideoTracking(CampaignEx.TrackingStr2Object(cursor.getString(cursor.getColumnIndex("native_ad_tracking"))));
        campaignEx.setNativeVideoTrackingString(cursor.getString(cursor.getColumnIndex("native_ad_tracking")));
        campaignEx.setVideo_end_type(cursor.getInt(cursor.getColumnIndex(CampaignEx.VIDEO_END_TYPE)));
        campaignEx.setendcard_url(cursor.getString(cursor.getColumnIndex(CampaignEx.ENDCARD_URL)));
        campaignEx.setPlayable_ads_without_video(cursor.getInt(cursor.getColumnIndex(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO)));
        campaignEx.setMof_template_url(cursor.getString(cursor.getColumnIndex(b.JSON_KEY_MOF_TEMPLATE_URL)));
        campaignEx.setMof_tplid(cursor.getInt(cursor.getColumnIndex(b.JSON_KEY_MOF_TPLID)));
        campaignEx.setRewardTemplateMode(CampaignEx.c.a(cursor.getString(cursor.getColumnIndex("reward_teamplate"))));
        campaignEx.setVideoMD5Value(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5)));
        campaignEx.setGifUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GIF_URL)));
        campaignEx.setNvT2(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NV_T2)));
        campaignEx.setClickTimeOutInterval(cursor.getInt(cursor.getColumnIndex("c_coi")));
        campaignEx.setcUA(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_C_UA)));
        campaignEx.setImpUA(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMP_UA)));
        campaignEx.setJmPd(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_JM_PD)));
        campaignEx.setIsDeleted(cursor.getInt(cursor.getColumnIndex("is_deleted")));
        campaignEx.setIsClick(cursor.getInt(cursor.getColumnIndex("is_click")));
        campaignEx.setIsAddSuccesful(cursor.getInt(cursor.getColumnIndex("is_add_sucesful")));
        campaignEx.setIsDownLoadZip(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_IS_DOWNLOAD)));
        campaignEx.setInteractiveCache(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_CACHE)));
        campaignEx.setKeyIaOri(cursor.getInt(cursor.getColumnIndex("ia_ori")));
        campaignEx.setAdType(cursor.getInt(cursor.getColumnIndex("ad_type")));
        campaignEx.setFac(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FAC)));
        campaignEx.setTpOffer(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_TP_OFFER)));
        campaignEx.setIa_ext1(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_EXT1)));
        campaignEx.setIa_ext2(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_EXT2)));
        campaignEx.setKeyIaRst(cursor.getInt(cursor.getColumnIndex("ia_rst")));
        campaignEx.setKeyIaUrl(cursor.getString(cursor.getColumnIndex("ia_url")));
        campaignEx.setKeyIaIcon(cursor.getString(cursor.getColumnIndex("ia_icon")));
        campaignEx.setOc_time(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_OC_TIME)));
        campaignEx.setOc_type(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_OC_TYPE)));
        campaignEx.setT_list(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_T_LIST)));
        campaignEx.setGhId(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_GH_ID)));
        campaignEx.setGhPath(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_GH_PATH)));
        campaignEx.setBindId(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_BIND_ID)));
        String string2 = cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_ADCHOICE));
        if (!TextUtils.isEmpty(string2)) {
            campaignEx.setAdchoice(CampaignEx.a.a(string2));
        }
        campaignEx.setAdchoiceSizeHeight(cursor.getInt(cursor.getColumnIndex("adchoice_size_height")));
        campaignEx.setAdchoiceSizeWidth(cursor.getInt(cursor.getColumnIndex("adchoice_size_width")));
        campaignEx.setPlct(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCT)));
        campaignEx.setPlctb(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCTB)));
        campaignEx.setCandidateCacheTime(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_C_C_TIME)));
        campaignEx.setAdZip(cursor.getString(cursor.getColumnIndex("ad_zip")));
        campaignEx.setAdHtml(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AD_HTML)));
        campaignEx.setBannerUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_BANNER_URL)));
        campaignEx.setBannerHtml(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_BANNER_HTML)));
        campaignEx.setCreativeId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_CREATIVE_ID)));
        campaignEx.setVidCrtvId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CREATIVE_ID)));
        campaignEx.setEcCrtvId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_EC_CREATIVE_ID)));
        campaignEx.setEcTemplateId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_EC_TEMP_ID)));
        campaignEx.setIsBidCampaign(cursor.getInt(cursor.getColumnIndex("is_bid_campaign")) == 1);
        campaignEx.setBidToken(cursor.getString(cursor.getColumnIndex("bid_token")));
        campaignEx.setMraid(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_MRAID)));
        if (cursor.getInt(cursor.getColumnIndex("is_mraid_campaign")) == 1) {
            z4 = true;
        }
        campaignEx.setIsMraid(z4);
        campaignEx.setOmid(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_OMID)));
        campaignEx.setReady_rate(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_READY_RATE)));
        campaignEx.setExt_data(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_EXT_DATA)));
        campaignEx.setNscpt(cursor.getInt(cursor.getColumnIndex(b.JSON_KEY_NSCPT)));
        campaignEx.setReq_ext_data(cursor.getString(cursor.getColumnIndex(b.JSON_KEY_REQ_EXT_DATA)));
        campaignEx.setReadyState(cursor.getInt(cursor.getColumnIndex("readyState")));
        campaignEx.setLoadTimeoutState(cursor.getInt(cursor.getColumnIndex("load_timeout")));
        campaignEx.setPlacementId(cursor.getString(cursor.getColumnIndex("placement_id")));
        campaignEx.setMaitve(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_MAITVE)));
        campaignEx.setMaitve_src(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_MAITVESRC)));
        campaignEx.setFlb(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FLB)));
        campaignEx.setFlbSkipTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FLB_SKIP_TIME)));
        campaignEx.setCbd(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD)));
        campaignEx.setVst(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST)));
        campaignEx.setUseSkipTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_USE_SKIP_TIME)));
        campaignEx.setProgressBarShow(cursor.getColumnIndex(CampaignEx.JSON_KEY_PROG_BAR));
        campaignEx.setAdSpaceT(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T)));
        campaignEx.setVcn(cursor.getInt(cursor.getColumnIndex("vcn")));
        campaignEx.setTokenRule(cursor.getInt(cursor.getColumnIndex("token_r")));
        campaignEx.setEncryptPrice(cursor.getString(cursor.getColumnIndex("encrypt_p")));
        campaignEx.setVideoCheckType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE)));
        campaignEx.setVideoCtnType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE)));
        campaignEx.setRsIgnoreCheckRuleByString(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE)));
        campaignEx.setVideoCompleteTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME)));
        campaignEx.setAabEntity(AabEntity.parser(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AAB))));
        campaignEx.setPrivacyUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_PRIVACY_URL)));
        campaignEx.setPrivacyButtonTemplateVisibility(cursor.getInt(cursor.getColumnIndex("privacy_button_video")));
        campaignEx.setImpReportType(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMP_REPORT_TYPE));
        campaignEx.setAutoShowStoreMiniCard(cursor.getInt(cursor.getColumnIndex("auto_minicard")));
        campaignEx.setShowStoreMiniCardDelayTime(cursor.getInt(cursor.getColumnIndex("mincard_trigger_time")));
        return campaignEx;
    }
}
