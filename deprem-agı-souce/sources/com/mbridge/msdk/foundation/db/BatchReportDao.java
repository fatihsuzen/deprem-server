package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.e.d;
import com.mbridge.msdk.foundation.same.report.BatchReportMessage;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class BatchReportDao extends a<BatchReportMessage> implements NoProGuard, Serializable {
    private static volatile BatchReportDao instance;
    private final Object lock = new Object();

    protected BatchReportDao(f fVar) {
        super(fVar);
    }

    public static BatchReportDao getInstance(f fVar) {
        if (instance == null) {
            synchronized (BatchReportDao.class) {
                try {
                    if (instance == null) {
                        instance = new BatchReportDao(fVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public void addReportMessage(String str, int i5) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (d.a(writableDatabase)) {
            try {
                synchronized (this.lock) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("report_message", str);
                    contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                    contentValues.put("uuid", UUID.randomUUID().toString().replace("-", ""));
                    contentValues.put("report_state", 0);
                    contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(i5));
                    writableDatabase.insert("batch_report", (String) null, contentValues);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public void deleteBatchReportMessagesByTimestamp(long j5) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (d.a(writableDatabase)) {
            try {
                synchronized (this.lock) {
                    writableDatabase.execSQL("delete from " + "batch_report" + " where " + "time" + " <= ?", new Object[]{Long.valueOf(j5)});
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:19|(0)|32|33) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0098, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0099, code lost:
        r2 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a5, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cf, code lost:
        if (r2 != null) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        throw r10;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x00aa */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x00d4 */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d1 A[SYNTHETIC, Splitter:B:30:0x00d1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<com.mbridge.msdk.foundation.same.report.BatchReportMessage> getBatchReportMessages(long r10, int r12) {
        /*
            r9 = this;
            android.database.sqlite.SQLiteDatabase r0 = r9.getWritableDatabase()
            boolean r1 = com.mbridge.msdk.e.d.a(r0)
            r2 = 0
            if (r1 != 0) goto L_0x000c
            return r2
        L_0x000c:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "SELECT * FROM "
            r3.append(r4)
            java.lang.String r4 = "batch_report"
            r3.append(r4)
            java.lang.String r4 = " WHERE "
            r3.append(r4)
            java.lang.String r4 = "time"
            r3.append(r4)
            java.lang.String r4 = " <= ? AND "
            r3.append(r4)
            java.lang.String r4 = "report_state"
            r3.append(r4)
            java.lang.String r4 = " = 0"
            r3.append(r4)
            java.lang.String r4 = " AND "
            r3.append(r4)
            java.lang.String r4 = "type"
            r3.append(r4)
            java.lang.String r4 = " = ? ORDER BY "
            r3.append(r4)
            java.lang.String r4 = "time"
            r3.append(r4)
            java.lang.String r4 = " ASC "
            r3.append(r4)
            java.lang.Object r4 = r9.lock
            monitor-enter(r4)
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x009b }
            java.lang.String r5 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x009b }
            java.lang.String[] r12 = new java.lang.String[]{r5, r12}     // Catch:{ Exception -> 0x009b }
            android.database.Cursor r12 = r0.rawQuery(r3, r12)     // Catch:{ Exception -> 0x009b }
            if (r12 == 0) goto L_0x009d
        L_0x006b:
            boolean r3 = r12.moveToNext()     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            if (r3 == 0) goto L_0x009d
            com.mbridge.msdk.foundation.same.report.BatchReportMessage r3 = new com.mbridge.msdk.foundation.same.report.BatchReportMessage     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            java.lang.String r5 = "uuid"
            int r5 = r12.getColumnIndex(r5)     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            java.lang.String r5 = r12.getString(r5)     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            java.lang.String r6 = "report_message"
            int r6 = r12.getColumnIndex(r6)     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            java.lang.String r6 = r12.getString(r6)     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            java.lang.String r7 = "time"
            int r7 = r12.getColumnIndex(r7)     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            long r7 = r12.getLong(r7)     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            r3.<init>(r5, r6, r7)     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            r1.add(r3)     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            goto L_0x006b
        L_0x0098:
            r10 = move-exception
            r2 = r12
            goto L_0x00cf
        L_0x009b:
            r12 = move-exception
            goto L_0x00a7
        L_0x009d:
            if (r12 == 0) goto L_0x00aa
            r12.close()     // Catch:{ Exception -> 0x00aa }
            goto L_0x00aa
        L_0x00a3:
            r10 = move-exception
            goto L_0x00d5
        L_0x00a5:
            r10 = move-exception
            goto L_0x00cf
        L_0x00a7:
            r12.printStackTrace()     // Catch:{ all -> 0x00a5 }
        L_0x00aa:
            android.content.ContentValues r12 = new android.content.ContentValues     // Catch:{ Exception -> 0x00c9 }
            r12.<init>()     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r2 = "report_state"
            r3 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x00c9 }
            r12.put(r2, r3)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r2 = "batch_report"
            java.lang.String r3 = "time <= ?"
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String[] r10 = new java.lang.String[]{r10}     // Catch:{ Exception -> 0x00c9 }
            r0.update(r2, r12, r3, r10)     // Catch:{ Exception -> 0x00c9 }
            goto L_0x00cd
        L_0x00c9:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ all -> 0x00a3 }
        L_0x00cd:
            monitor-exit(r4)     // Catch:{ all -> 0x00a3 }
            return r1
        L_0x00cf:
            if (r2 == 0) goto L_0x00d4
            r2.close()     // Catch:{ Exception -> 0x00d4 }
        L_0x00d4:
            throw r10     // Catch:{ all -> 0x00a3 }
        L_0x00d5:
            monitor-exit(r4)     // Catch:{ all -> 0x00a3 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.BatchReportDao.getBatchReportMessages(long, int):java.util.ArrayList");
    }

    public void updateMessagesReportState(ArrayList<BatchReportMessage> arrayList) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (arrayList != null && arrayList.size() != 0 && d.a(writableDatabase)) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                BatchReportMessage batchReportMessage = arrayList.get(i5);
                i5++;
                BatchReportMessage batchReportMessage2 = batchReportMessage;
                try {
                    synchronized (this.lock) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("report_state", 0);
                        writableDatabase.update("batch_report", contentValues, "uuid = ?", new String[]{batchReportMessage2.getUuid()});
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public static BatchReportDao getInstance(Context context) {
        if (instance == null) {
            synchronized (BatchReportDao.class) {
                try {
                    if (instance == null) {
                        instance = new BatchReportDao(g.a(context));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }
}
