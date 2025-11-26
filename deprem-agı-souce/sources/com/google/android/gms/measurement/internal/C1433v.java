package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.measurement.C1048a0;
import com.google.android.gms.internal.measurement.C1102g0;
import java.io.File;

/* renamed from: com.google.android.gms.measurement.internal.v  reason: case insensitive filesystem */
public abstract class C1433v {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        if (r0 == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        r10 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A[ExcHandler: all (r0v15 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:2:0x0007] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0084 A[Catch:{ all -> 0x00e9, SQLiteException -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00be A[Catch:{ all -> 0x00e9, SQLiteException -> 0x00b9 }, LOOP:1: B:42:0x00be->B:47:0x00d0, LOOP_START, PHI: r1 
      PHI: (r1v4 int) = (r1v3 int), (r1v5 int) binds: [B:41:0x00bc, B:47:0x00d0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d9 A[Catch:{ all -> 0x00e9, SQLiteException -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[Catch:{  }, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(com.google.android.gms.measurement.internal.C1402q2 r10, android.database.sqlite.SQLiteDatabase r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String[] r15) {
        /*
            if (r10 == 0) goto L_0x00ff
            r1 = 0
            java.lang.String r3 = "SQLITE_MASTER"
            java.lang.String r0 = "name"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ SQLiteException -> 0x0031, all -> 0x002a }
            java.lang.String r5 = "name=?"
            java.lang.String[] r6 = new java.lang.String[]{r12}     // Catch:{ SQLiteException -> 0x0031, all -> 0x002a }
            r8 = 0
            r9 = 0
            r7 = 0
            r2 = r11
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x002e, all -> 0x002a }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0028 }
            r11.close()
            if (r0 != 0) goto L_0x0046
            goto L_0x0043
        L_0x0023:
            r0 = move-exception
            r10 = r0
            r1 = r11
            goto L_0x00f9
        L_0x0028:
            r0 = move-exception
            goto L_0x0035
        L_0x002a:
            r0 = move-exception
            r10 = r0
            goto L_0x00f9
        L_0x002e:
            r0 = move-exception
        L_0x002f:
            r11 = r0
            goto L_0x0034
        L_0x0031:
            r0 = move-exception
            r2 = r11
            goto L_0x002f
        L_0x0034:
            r11 = r1
        L_0x0035:
            com.google.android.gms.measurement.internal.o2 r3 = r10.r()     // Catch:{ all -> 0x0023 }
            java.lang.String r4 = "Error querying for table"
            r3.c(r4, r12, r0)     // Catch:{ all -> 0x0023 }
            if (r11 == 0) goto L_0x0043
            r11.close()
        L_0x0043:
            r2.execSQL(r13)
        L_0x0046:
            java.lang.String r11 = "Table "
            java.lang.String r13 = " is missing required column: "
            java.lang.String r0 = "SELECT * FROM "
            java.lang.String r3 = " LIMIT 0"
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ SQLiteException -> 0x00b9 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x00b9 }
            int r5 = r12.length()     // Catch:{ SQLiteException -> 0x00b9 }
            int r5 = r5 + 22
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00b9 }
            r6.<init>(r5)     // Catch:{ SQLiteException -> 0x00b9 }
            r6.append(r0)     // Catch:{ SQLiteException -> 0x00b9 }
            r6.append(r12)     // Catch:{ SQLiteException -> 0x00b9 }
            r6.append(r3)     // Catch:{ SQLiteException -> 0x00b9 }
            java.lang.String r0 = r6.toString()     // Catch:{ SQLiteException -> 0x00b9 }
            android.database.Cursor r1 = r2.rawQuery(r0, r1)     // Catch:{ SQLiteException -> 0x00b9 }
            java.lang.String[] r0 = r1.getColumnNames()     // Catch:{ all -> 0x00e9 }
            java.util.Collections.addAll(r4, r0)     // Catch:{ all -> 0x00e9 }
            r1.close()     // Catch:{ SQLiteException -> 0x00b9 }
            java.lang.String r0 = ","
            java.lang.String[] r14 = r14.split(r0)     // Catch:{ SQLiteException -> 0x00b9 }
            int r0 = r14.length     // Catch:{ SQLiteException -> 0x00b9 }
            r1 = 0
            r3 = r1
        L_0x0082:
            if (r3 >= r0) goto L_0x00bc
            r5 = r14[r3]     // Catch:{ SQLiteException -> 0x00b9 }
            boolean r6 = r4.remove(r5)     // Catch:{ SQLiteException -> 0x00b9 }
            if (r6 == 0) goto L_0x008f
            int r3 = r3 + 1
            goto L_0x0082
        L_0x008f:
            android.database.sqlite.SQLiteException r14 = new android.database.sqlite.SQLiteException     // Catch:{ SQLiteException -> 0x00b9 }
            int r15 = r12.length()     // Catch:{ SQLiteException -> 0x00b9 }
            int r15 = r15 + 35
            java.lang.String r0 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x00b9 }
            int r0 = r0.length()     // Catch:{ SQLiteException -> 0x00b9 }
            int r15 = r15 + r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00b9 }
            r0.<init>(r15)     // Catch:{ SQLiteException -> 0x00b9 }
            r0.append(r11)     // Catch:{ SQLiteException -> 0x00b9 }
            r0.append(r12)     // Catch:{ SQLiteException -> 0x00b9 }
            r0.append(r13)     // Catch:{ SQLiteException -> 0x00b9 }
            r0.append(r5)     // Catch:{ SQLiteException -> 0x00b9 }
            java.lang.String r11 = r0.toString()     // Catch:{ SQLiteException -> 0x00b9 }
            r14.<init>(r11)     // Catch:{ SQLiteException -> 0x00b9 }
            throw r14     // Catch:{ SQLiteException -> 0x00b9 }
        L_0x00b9:
            r0 = move-exception
            r11 = r0
            goto L_0x00ef
        L_0x00bc:
            if (r15 == 0) goto L_0x00d3
        L_0x00be:
            int r11 = r15.length     // Catch:{ SQLiteException -> 0x00b9 }
            if (r1 >= r11) goto L_0x00d3
            r11 = r15[r1]     // Catch:{ SQLiteException -> 0x00b9 }
            boolean r11 = r4.remove(r11)     // Catch:{ SQLiteException -> 0x00b9 }
            if (r11 != 0) goto L_0x00d0
            int r11 = r1 + 1
            r11 = r15[r11]     // Catch:{ SQLiteException -> 0x00b9 }
            r2.execSQL(r11)     // Catch:{ SQLiteException -> 0x00b9 }
        L_0x00d0:
            int r1 = r1 + 2
            goto L_0x00be
        L_0x00d3:
            boolean r11 = r4.isEmpty()     // Catch:{ SQLiteException -> 0x00b9 }
            if (r11 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.o2 r11 = r10.r()     // Catch:{ SQLiteException -> 0x00b9 }
            java.lang.String r13 = "Table has extra columns. table, columns"
            java.lang.String r14 = ", "
            java.lang.String r14 = android.text.TextUtils.join(r14, r4)     // Catch:{ SQLiteException -> 0x00b9 }
            r11.c(r13, r12, r14)     // Catch:{ SQLiteException -> 0x00b9 }
        L_0x00e8:
            return
        L_0x00e9:
            r0 = move-exception
            r11 = r0
            r1.close()     // Catch:{ SQLiteException -> 0x00b9 }
            throw r11     // Catch:{ SQLiteException -> 0x00b9 }
        L_0x00ef:
            com.google.android.gms.measurement.internal.o2 r10 = r10.o()
            java.lang.String r13 = "Failed to verify columns on table that was just created"
            r10.b(r13, r12)
            throw r11
        L_0x00f9:
            if (r1 == 0) goto L_0x00fe
            r1.close()
        L_0x00fe:
            throw r10
        L_0x00ff:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Monitor must not be null"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1433v.a(com.google.android.gms.measurement.internal.q2, android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    static void b(C1402q2 q2Var, SQLiteDatabase sQLiteDatabase) {
        if (q2Var != null) {
            C1048a0.a();
            String path = sQLiteDatabase.getPath();
            int i5 = C1102g0.f5355b;
            File file = new File(path);
            if (!file.setReadable(false, false)) {
                q2Var.r().a("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                q2Var.r().a("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                q2Var.r().a("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                q2Var.r().a("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }
}
