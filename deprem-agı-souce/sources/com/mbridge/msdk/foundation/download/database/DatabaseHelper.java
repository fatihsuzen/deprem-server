package com.mbridge.msdk.foundation.download.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.GlobalComponent;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.tools.af;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper implements IDatabaseHelper {
    /* access modifiers changed from: private */
    public volatile SQLiteDatabase database;
    /* access modifiers changed from: private */
    public final IDatabaseOpenHelper databaseOpenHelper;
    private final Handler handler;
    /* access modifiers changed from: private */
    public final String tableName = GlobalComponent.getInstance().getDatabaseTableName();

    public DatabaseHelper(Context context, Handler handler2, IDatabaseOpenHelper iDatabaseOpenHelper) {
        this.handler = handler2;
        this.databaseOpenHelper = iDatabaseOpenHelper;
    }

    public void clear() {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(DatabaseHelper.this.database) && DatabaseHelper.this.database.isOpen()) {
                    try {
                        DatabaseHelper.this.database.beginTransaction();
                        DatabaseHelper.this.database.delete(DatabaseHelper.this.tableName, (String) null, (String[]) null);
                        DatabaseHelper.this.database.setTransactionSuccessful();
                        if (DatabaseHelper.this.database.inTransaction()) {
                            DatabaseHelper.this.database.endTransaction();
                            return;
                        }
                        return;
                    } catch (Exception e5) {
                        try {
                            if (MBridgeConstans.DEBUG) {
                                e5.printStackTrace();
                            }
                            if (DatabaseHelper.this.database.inTransaction()) {
                                DatabaseHelper.this.database.endTransaction();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            af.b(IDatabaseHelper.TAG, th.getMessage());
                        }
                    } catch (Throwable th2) {
                        af.b(IDatabaseHelper.TAG, th2.getMessage());
                        return;
                    }
                } else {
                    return;
                }
                throw th;
            }
        });
    }

    public void find(final String str, final String str2, final IDatabaseHelper.IDatabaseListener iDatabaseListener) {
        this.handler.post(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:29:0x009d A[Catch:{ all -> 0x0083 }] */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x00a2  */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x00a9  */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x00af  */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x00b6  */
            /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r5 = this;
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r0 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r0 = r0.database
                    boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r0)
                    if (r0 == 0) goto L_0x0019
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r0 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper r1 = r0.databaseOpenHelper
                    android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()
                    android.database.sqlite.SQLiteDatabase unused = r0.database = r1
                L_0x0019:
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r0 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r0 = r0.database
                    boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r0)
                    r1 = 0
                    if (r0 != 0) goto L_0x00ba
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r0 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r0 = r0.database
                    boolean r0 = r0.isOpen()
                    if (r0 != 0) goto L_0x0034
                    goto L_0x00ba
                L_0x0034:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    r0.<init>()     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    java.lang.String r2 = "SELECT * FROM "
                    r0.append(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    java.lang.String r2 = r2.tableName     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    r0.append(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    java.lang.String r2 = " WHERE "
                    r0.append(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    java.lang.String r2 = "download_id"
                    r0.append(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    java.lang.String r2 = " = ? AND "
                    r0.append(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    java.lang.String r2 = "director_path"
                    r0.append(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    java.lang.String r2 = " = ?"
                    r0.append(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    android.database.sqlite.SQLiteDatabase r2 = r2.database     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    java.lang.String r3 = r3     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    java.lang.String r4 = r4     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    android.database.Cursor r0 = r2.rawQuery(r0, r3)     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
                    if (r0 == 0) goto L_0x0087
                    boolean r2 = r0.moveToFirst()     // Catch:{ Exception -> 0x0085 }
                    if (r2 == 0) goto L_0x0087
                    com.mbridge.msdk.foundation.download.database.DownloadModel r1 = com.mbridge.msdk.foundation.download.database.DownloadModel.create((android.database.Cursor) r0)     // Catch:{ Exception -> 0x0085 }
                    goto L_0x0087
                L_0x0083:
                    r2 = move-exception
                    goto L_0x00ad
                L_0x0085:
                    r2 = move-exception
                    goto L_0x0099
                L_0x0087:
                    if (r0 == 0) goto L_0x008c
                    r0.close()
                L_0x008c:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r5
                    if (r0 == 0) goto L_0x00c7
                    r0.onDatabase(r1)
                    return
                L_0x0094:
                    r2 = move-exception
                    r0 = r1
                    goto L_0x00ad
                L_0x0097:
                    r2 = move-exception
                    r0 = r1
                L_0x0099:
                    boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0083 }
                    if (r3 == 0) goto L_0x00a0
                    r2.printStackTrace()     // Catch:{ all -> 0x0083 }
                L_0x00a0:
                    if (r0 == 0) goto L_0x00a5
                    r0.close()
                L_0x00a5:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r5
                    if (r0 == 0) goto L_0x00c7
                    r0.onDatabase(r1)
                    goto L_0x00c7
                L_0x00ad:
                    if (r0 == 0) goto L_0x00b2
                    r0.close()
                L_0x00b2:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r5
                    if (r0 == 0) goto L_0x00b9
                    r0.onDatabase(r1)
                L_0x00b9:
                    throw r2
                L_0x00ba:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r5
                    boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
                    if (r0 == 0) goto L_0x00c7
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r5
                    r0.onDatabase(r1)
                L_0x00c7:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.database.DatabaseHelper.AnonymousClass1.run():void");
            }
        });
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
    public List<DownloadModel> findAll() {
        ArrayList arrayList = new ArrayList();
        ? r12 = 0;
        try {
            if (Objects.isNull(this.database)) {
                this.database = this.databaseOpenHelper.getWritableDatabase();
            }
            if (!Objects.isNull(this.database)) {
                if (this.database.isOpen()) {
                    Cursor rawQuery = rawQuery("SELECT * FROM " + this.tableName, r12);
                    if (rawQuery != null) {
                        while (rawQuery.moveToNext()) {
                            arrayList.add(DownloadModel.create(rawQuery));
                        }
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                        return arrayList;
                    }
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            return arrayList;
        } catch (Throwable unused) {
            if (r12 != 0) {
                r12.close();
            }
        }
        return arrayList;
    }

    public void findByDownloadUrl(final String str, final IDatabaseHelper.IDatabaseListener iDatabaseListener) {
        this.handler.post(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:29:0x0091 A[Catch:{ all -> 0x0077 }] */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x0096  */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x009d  */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x00a3  */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x00aa  */
            /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r0 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r0 = r0.database
                    boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r0)
                    if (r0 == 0) goto L_0x0019
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r0 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper r1 = r0.databaseOpenHelper
                    android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()
                    android.database.sqlite.SQLiteDatabase unused = r0.database = r1
                L_0x0019:
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r0 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r0 = r0.database
                    boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r0)
                    r1 = 0
                    if (r0 != 0) goto L_0x00ae
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r0 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r0 = r0.database
                    boolean r0 = r0.isOpen()
                    if (r0 != 0) goto L_0x0034
                    goto L_0x00ae
                L_0x0034:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
                    r0.<init>()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
                    java.lang.String r2 = "SELECT * FROM "
                    r0.append(r2)     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
                    java.lang.String r2 = r2.tableName     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
                    r0.append(r2)     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
                    java.lang.String r2 = " WHERE "
                    r0.append(r2)     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
                    java.lang.String r2 = "download_url"
                    r0.append(r2)     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
                    java.lang.String r2 = " = ?"
                    r0.append(r2)     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
                    android.database.sqlite.SQLiteDatabase r2 = r2.database     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
                    java.lang.String r3 = r3     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
                    java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
                    android.database.Cursor r0 = r2.rawQuery(r0, r3)     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
                    if (r0 == 0) goto L_0x007b
                    boolean r2 = r0.moveToFirst()     // Catch:{ Exception -> 0x0079 }
                    if (r2 == 0) goto L_0x007b
                    com.mbridge.msdk.foundation.download.database.DownloadModel r1 = com.mbridge.msdk.foundation.download.database.DownloadModel.create((android.database.Cursor) r0)     // Catch:{ Exception -> 0x0079 }
                    goto L_0x007b
                L_0x0077:
                    r2 = move-exception
                    goto L_0x00a1
                L_0x0079:
                    r2 = move-exception
                    goto L_0x008d
                L_0x007b:
                    if (r0 == 0) goto L_0x0080
                    r0.close()
                L_0x0080:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r4
                    if (r0 == 0) goto L_0x00bb
                    r0.onDatabase(r1)
                    return
                L_0x0088:
                    r2 = move-exception
                    r0 = r1
                    goto L_0x00a1
                L_0x008b:
                    r2 = move-exception
                    r0 = r1
                L_0x008d:
                    boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0077 }
                    if (r3 == 0) goto L_0x0094
                    r2.printStackTrace()     // Catch:{ all -> 0x0077 }
                L_0x0094:
                    if (r0 == 0) goto L_0x0099
                    r0.close()
                L_0x0099:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r4
                    if (r0 == 0) goto L_0x00bb
                    r0.onDatabase(r1)
                    goto L_0x00bb
                L_0x00a1:
                    if (r0 == 0) goto L_0x00a6
                    r0.close()
                L_0x00a6:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r4
                    if (r0 == 0) goto L_0x00ad
                    r0.onDatabase(r1)
                L_0x00ad:
                    throw r2
                L_0x00ae:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r4
                    boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
                    if (r0 == 0) goto L_0x00bb
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r4
                    r0.onDatabase(r1)
                L_0x00bb:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.database.DatabaseHelper.AnonymousClass2.run():void");
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.mbridge.msdk.foundation.download.database.DownloadModel> getUnwantedModels(long r6) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r5.database     // Catch:{ Exception -> 0x0019 }
            boolean r2 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r2)     // Catch:{ Exception -> 0x0019 }
            if (r2 == 0) goto L_0x001b
            com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper r2 = r5.databaseOpenHelper     // Catch:{ Exception -> 0x0019 }
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x0019 }
            r5.database = r2     // Catch:{ Exception -> 0x0019 }
            goto L_0x001b
        L_0x0017:
            r6 = move-exception
            goto L_0x0089
        L_0x0019:
            r6 = move-exception
            goto L_0x007c
        L_0x001b:
            android.database.sqlite.SQLiteDatabase r2 = r5.database     // Catch:{ Exception -> 0x0019 }
            boolean r2 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r2)     // Catch:{ Exception -> 0x0019 }
            if (r2 != 0) goto L_0x0088
            android.database.sqlite.SQLiteDatabase r2 = r5.database     // Catch:{ Exception -> 0x0019 }
            boolean r2 = r2.isOpen()     // Catch:{ Exception -> 0x0019 }
            if (r2 != 0) goto L_0x002c
            goto L_0x0088
        L_0x002c:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0019 }
            long r2 = r2 - r6
            android.database.sqlite.SQLiteDatabase r6 = r5.database     // Catch:{ Exception -> 0x0019 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0019 }
            r7.<init>()     // Catch:{ Exception -> 0x0019 }
            java.lang.String r4 = "SELECT * FROM "
            r7.append(r4)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r4 = r5.tableName     // Catch:{ Exception -> 0x0019 }
            r7.append(r4)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r4 = " WHERE "
            r7.append(r4)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r4 = "last_modified_time"
            r7.append(r4)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r4 = " <= ?"
            r7.append(r4)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0019 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0019 }
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x0019 }
            android.database.Cursor r1 = r6.rawQuery(r7, r2)     // Catch:{ Exception -> 0x0019 }
            if (r1 == 0) goto L_0x0076
            boolean r6 = r1.moveToFirst()     // Catch:{ Exception -> 0x0019 }
            if (r6 == 0) goto L_0x0076
        L_0x0069:
            com.mbridge.msdk.foundation.download.database.DownloadModel r6 = com.mbridge.msdk.foundation.download.database.DownloadModel.create((android.database.Cursor) r1)     // Catch:{ Exception -> 0x0019 }
            r0.add(r6)     // Catch:{ Exception -> 0x0019 }
            boolean r6 = r1.moveToNext()     // Catch:{ Exception -> 0x0019 }
            if (r6 != 0) goto L_0x0069
        L_0x0076:
            if (r1 == 0) goto L_0x0088
            r1.close()
            return r0
        L_0x007c:
            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0017 }
            if (r7 == 0) goto L_0x0083
            r6.printStackTrace()     // Catch:{ all -> 0x0017 }
        L_0x0083:
            if (r1 == 0) goto L_0x0088
            r1.close()
        L_0x0088:
            return r0
        L_0x0089:
            if (r1 == 0) goto L_0x008e
            r1.close()
        L_0x008e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.database.DatabaseHelper.getUnwantedModels(long):java.util.List");
    }

    public void insert(final DownloadModel downloadModel) {
        this.handler.postAtFrontOfQueue(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(DatabaseHelper.this.database) && DatabaseHelper.this.database.isOpen()) {
                    try {
                        DatabaseHelper.this.database.beginTransaction();
                        DatabaseHelper.this.database.insert(DatabaseHelper.this.tableName, (String) null, DownloadModel.create(downloadModel));
                        DatabaseHelper.this.database.setTransactionSuccessful();
                        if (DatabaseHelper.this.database.inTransaction()) {
                            DatabaseHelper.this.database.endTransaction();
                            return;
                        }
                        return;
                    } catch (Exception e5) {
                        try {
                            if (MBridgeConstans.DEBUG) {
                                e5.printStackTrace();
                            }
                            if (DatabaseHelper.this.database.inTransaction()) {
                                DatabaseHelper.this.database.endTransaction();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            af.b(IDatabaseHelper.TAG, th.getMessage());
                        }
                    } catch (Throwable th2) {
                        af.b(IDatabaseHelper.TAG, th2.getMessage());
                        return;
                    }
                } else {
                    return;
                }
                throw th;
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0083, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x009a, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.database.Cursor rawQuery(java.lang.String r3, java.lang.String[] r4) {
        /*
            r2 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r2.database     // Catch:{ Exception -> 0x0015 }
            boolean r1 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r1)     // Catch:{ Exception -> 0x0015 }
            if (r1 == 0) goto L_0x0017
            com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper r1 = r2.databaseOpenHelper     // Catch:{ Exception -> 0x0015 }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x0015 }
            r2.database = r1     // Catch:{ Exception -> 0x0015 }
            goto L_0x0017
        L_0x0012:
            r3 = move-exception
            goto L_0x0084
        L_0x0015:
            r3 = move-exception
            goto L_0x0066
        L_0x0017:
            android.database.sqlite.SQLiteDatabase r1 = r2.database     // Catch:{ Exception -> 0x0015 }
            boolean r1 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r1)     // Catch:{ Exception -> 0x0015 }
            if (r1 != 0) goto L_0x004f
            android.database.sqlite.SQLiteDatabase r1 = r2.database     // Catch:{ Exception -> 0x0015 }
            boolean r1 = r1.isOpen()     // Catch:{ Exception -> 0x0015 }
            if (r1 != 0) goto L_0x0028
            goto L_0x004f
        L_0x0028:
            android.database.sqlite.SQLiteDatabase r1 = r2.database     // Catch:{ Exception -> 0x0015 }
            r1.beginTransaction()     // Catch:{ Exception -> 0x0015 }
            android.database.sqlite.SQLiteDatabase r1 = r2.database     // Catch:{ Exception -> 0x0015 }
            android.database.Cursor r3 = r1.rawQuery(r3, r4)     // Catch:{ Exception -> 0x0015 }
            android.database.sqlite.SQLiteDatabase r4 = r2.database     // Catch:{ Exception -> 0x0015 }
            r4.setTransactionSuccessful()     // Catch:{ Exception -> 0x0015 }
            android.database.sqlite.SQLiteDatabase r4 = r2.database     // Catch:{ all -> 0x0046 }
            boolean r4 = r4.inTransaction()     // Catch:{ all -> 0x0046 }
            if (r4 == 0) goto L_0x004e
            android.database.sqlite.SQLiteDatabase r4 = r2.database     // Catch:{ all -> 0x0046 }
            r4.endTransaction()     // Catch:{ all -> 0x0046 }
            return r3
        L_0x0046:
            r4 = move-exception
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x004e
            r4.printStackTrace()
        L_0x004e:
            return r3
        L_0x004f:
            android.database.sqlite.SQLiteDatabase r3 = r2.database     // Catch:{ all -> 0x005d }
            boolean r3 = r3.inTransaction()     // Catch:{ all -> 0x005d }
            if (r3 == 0) goto L_0x0065
            android.database.sqlite.SQLiteDatabase r3 = r2.database     // Catch:{ all -> 0x005d }
            r3.endTransaction()     // Catch:{ all -> 0x005d }
            return r0
        L_0x005d:
            r3 = move-exception
            boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r4 == 0) goto L_0x0065
            r3.printStackTrace()
        L_0x0065:
            return r0
        L_0x0066:
            boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0012 }
            if (r4 == 0) goto L_0x006d
            r3.printStackTrace()     // Catch:{ all -> 0x0012 }
        L_0x006d:
            android.database.sqlite.SQLiteDatabase r3 = r2.database     // Catch:{ all -> 0x007b }
            boolean r3 = r3.inTransaction()     // Catch:{ all -> 0x007b }
            if (r3 == 0) goto L_0x0083
            android.database.sqlite.SQLiteDatabase r3 = r2.database     // Catch:{ all -> 0x007b }
            r3.endTransaction()     // Catch:{ all -> 0x007b }
            goto L_0x0083
        L_0x007b:
            r3 = move-exception
            boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r4 == 0) goto L_0x0083
            r3.printStackTrace()
        L_0x0083:
            return r0
        L_0x0084:
            android.database.sqlite.SQLiteDatabase r4 = r2.database     // Catch:{ all -> 0x0092 }
            boolean r4 = r4.inTransaction()     // Catch:{ all -> 0x0092 }
            if (r4 == 0) goto L_0x009a
            android.database.sqlite.SQLiteDatabase r4 = r2.database     // Catch:{ all -> 0x0092 }
            r4.endTransaction()     // Catch:{ all -> 0x0092 }
            goto L_0x009a
        L_0x0092:
            r4 = move-exception
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x009a
            r4.printStackTrace()
        L_0x009a:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.database.DatabaseHelper.rawQuery(java.lang.String, java.lang.String[]):android.database.Cursor");
    }

    public void remove(final String str, final String str2) {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(DatabaseHelper.this.database) && DatabaseHelper.this.database.isOpen()) {
                    try {
                        SQLiteDatabase access$000 = DatabaseHelper.this.database;
                        access$000.execSQL("DELETE FROM " + DatabaseHelper.this.tableName + " WHERE " + DownloadModel.DOWNLOAD_ID + " = ? AND " + DownloadModel.DIRECTORY_PATH + " = ?", new Object[]{str, str2});
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            e5.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void update(final DownloadModel downloadModel, final String str) {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(DatabaseHelper.this.database) && DatabaseHelper.this.database.isOpen()) {
                    try {
                        DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, DownloadModel.create(downloadModel), "download_id = ? AND director_path = ?", new String[]{downloadModel.getDownloadId(), str});
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            e5.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void updateProgress(final String str, final String str2, final DownloadModel downloadModel) {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(DatabaseHelper.this.database) && DatabaseHelper.this.database.isOpen()) {
                    try {
                        DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, DownloadModel.create(downloadModel), "download_id = ? AND director_path = ?", new String[]{str, str2});
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            e5.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void updateUnzipResource(final String str, String str2, long j5) {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(DatabaseHelper.this.database) && DatabaseHelper.this.database.isOpen()) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(DownloadModel.DOWNLOAD_ID, str);
                        DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, contentValues, "download_id = ?", new String[]{str});
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            e5.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void remove(final String str) {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(DatabaseHelper.this.database) && DatabaseHelper.this.database.isOpen()) {
                    try {
                        SQLiteDatabase access$000 = DatabaseHelper.this.database;
                        access$000.execSQL("DELETE FROM " + DatabaseHelper.this.tableName + " WHERE " + DownloadModel.DOWNLOAD_ID + " = ?", new Object[]{str});
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            e5.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}
