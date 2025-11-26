package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;

/* renamed from: com.google.android.gms.measurement.internal.i2  reason: case insensitive filesystem */
public final class C1344i2 extends C1320f2 {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f6483e = {"app_version", "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};

    /* renamed from: c  reason: collision with root package name */
    private final C1336h2 f6484c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6485d;

    C1344i2(X2 x22) {
        super(x22);
        Context e5 = this.f5730a.e();
        this.f5730a.w();
        this.f6484c = new C1336h2(this, e5, "google_app_measurement_local.db");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v2, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v3, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v4, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v5, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v6, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v7, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v10, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v11, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v12, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v13, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v14, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v15, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v16, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v17, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v18, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v21, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v22, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v23, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v24, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v25, resolved type: boolean} */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f7, code lost:
        r20 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f9, code lost:
        r20 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        r20 = r20;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0185 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0185 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0185 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x012b A[SYNTHETIC, Splitter:B:77:0x012b] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), PHI: r20 
      PHI: (r20v10 byte[]) = (r20v1 byte[]), (r20v23 byte[]) binds: [B:49:0x00e3, B:52:0x00e9] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:49:0x00e3] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x015b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean z(int r19, byte[] r20) {
        /*
            r18 = this;
            r1 = r18
            r1.h()
            boolean r0 = r1.f6485d
            r2 = 0
            if (r0 == 0) goto L_0x000b
            goto L_0x006a
        L_0x000b:
            com.google.android.gms.measurement.internal.X2 r3 = r1.f5730a
            com.google.android.gms.measurement.internal.m r0 = r3.w()
            com.google.android.gms.measurement.internal.c2 r4 = com.google.android.gms.measurement.internal.C1304d2.f6320c1
            r5 = 0
            boolean r0 = r0.H(r5, r4)
            if (r0 == 0) goto L_0x0025
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            com.google.android.gms.measurement.internal.g2 r0 = r0.L()
            com.google.android.gms.measurement.internal.B6 r0 = r0.o(r5)
            goto L_0x0026
        L_0x0025:
            r0 = r5
        L_0x0026:
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r19)
            java.lang.String r8 = "type"
            r6.put(r8, r7)
            java.lang.String r7 = "entry"
            r8 = r20
            r6.put(r7, r8)
            com.google.android.gms.measurement.internal.m r7 = r3.w()
            boolean r4 = r7.H(r5, r4)
            if (r4 == 0) goto L_0x0059
            if (r0 == 0) goto L_0x0059
            java.lang.String r4 = "app_version"
            java.lang.String r7 = r0.f5767c
            r6.put(r4, r7)
            long r7 = r0.f5774j
            java.lang.String r0 = "app_version_int"
            java.lang.Long r4 = java.lang.Long.valueOf(r7)
            r6.put(r0, r4)
        L_0x0059:
            r3.w()
            r4 = 5
            r7 = r2
            r8 = r4
        L_0x005f:
            if (r7 >= r4) goto L_0x0197
            r9 = 1
            android.database.sqlite.SQLiteDatabase r10 = r1.w()     // Catch:{ SQLiteFullException -> 0x0166, SQLiteDatabaseLockedException -> 0x014f, SQLiteException -> 0x0122, all -> 0x011e }
            if (r10 != 0) goto L_0x0080
            r1.f6485d = r9     // Catch:{ SQLiteFullException -> 0x0079, SQLiteDatabaseLockedException -> 0x0075, SQLiteException -> 0x006e, all -> 0x006b }
        L_0x006a:
            return r2
        L_0x006b:
            r0 = move-exception
            goto L_0x018c
        L_0x006e:
            r0 = move-exception
            r17 = r2
            r20 = r9
            goto L_0x0118
        L_0x0075:
            r17 = r2
            goto L_0x011a
        L_0x0079:
            r0 = move-exception
            r17 = r2
            r20 = r9
            goto L_0x011c
        L_0x0080:
            r10.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0079, SQLiteDatabaseLockedException -> 0x0075, SQLiteException -> 0x006e, all -> 0x006b }
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r11 = r10.rawQuery(r0, r5)     // Catch:{ SQLiteFullException -> 0x0079, SQLiteDatabaseLockedException -> 0x0075, SQLiteException -> 0x006e, all -> 0x006b }
            r12 = 0
            if (r11 == 0) goto L_0x00aa
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteFullException -> 0x00a3, SQLiteDatabaseLockedException -> 0x009f, SQLiteException -> 0x0098 }
            if (r0 == 0) goto L_0x00aa
            long r12 = r11.getLong(r2)     // Catch:{ SQLiteFullException -> 0x00a3, SQLiteDatabaseLockedException -> 0x009f, SQLiteException -> 0x0098 }
            goto L_0x00aa
        L_0x0098:
            r0 = move-exception
            r17 = r2
        L_0x009b:
            r20 = r9
            goto L_0x0129
        L_0x009f:
            r17 = r2
            goto L_0x0153
        L_0x00a3:
            r0 = move-exception
            r17 = r2
        L_0x00a6:
            r20 = r9
            goto L_0x016b
        L_0x00aa:
            r14 = 100000(0x186a0, double:4.94066E-319)
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            java.lang.String r14 = "messages"
            if (r0 < 0) goto L_0x00ff
            com.google.android.gms.measurement.internal.q2 r0 = r3.a()     // Catch:{ SQLiteFullException -> 0x00a3, SQLiteDatabaseLockedException -> 0x009f, SQLiteException -> 0x0098 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ SQLiteFullException -> 0x00a3, SQLiteDatabaseLockedException -> 0x009f, SQLiteException -> 0x0098 }
            java.lang.String r15 = "Data loss, local db full"
            r0.a(r15)     // Catch:{ SQLiteFullException -> 0x00a3, SQLiteDatabaseLockedException -> 0x009f, SQLiteException -> 0x0098 }
            java.lang.String r0 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            r15 = 100001(0x186a1, double:4.9407E-319)
            long r15 = r15 - r12
            java.lang.String r12 = java.lang.Long.toString(r15)     // Catch:{ SQLiteFullException -> 0x00a3, SQLiteDatabaseLockedException -> 0x009f, SQLiteException -> 0x0098 }
            java.lang.String[] r12 = new java.lang.String[]{r12}     // Catch:{ SQLiteFullException -> 0x00a3, SQLiteDatabaseLockedException -> 0x009f, SQLiteException -> 0x0098 }
            int r0 = r10.delete(r14, r0, r12)     // Catch:{ SQLiteFullException -> 0x00a3, SQLiteDatabaseLockedException -> 0x009f, SQLiteException -> 0x0098 }
            long r12 = (long) r0     // Catch:{ SQLiteFullException -> 0x00a3, SQLiteDatabaseLockedException -> 0x009f, SQLiteException -> 0x0098 }
            int r0 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r0 == 0) goto L_0x00ff
            com.google.android.gms.measurement.internal.q2 r0 = r3.a()     // Catch:{ SQLiteFullException -> 0x00a3, SQLiteDatabaseLockedException -> 0x009f, SQLiteException -> 0x0098 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ SQLiteFullException -> 0x00a3, SQLiteDatabaseLockedException -> 0x009f, SQLiteException -> 0x0098 }
            r17 = r2
            java.lang.String r2 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r4 = java.lang.Long.valueOf(r15)     // Catch:{ SQLiteFullException -> 0x00fd, SQLiteDatabaseLockedException -> 0x0153, SQLiteException -> 0x00fb }
            r20 = r9
            java.lang.Long r9 = java.lang.Long.valueOf(r12)     // Catch:{ SQLiteFullException -> 0x00f8, SQLiteDatabaseLockedException -> 0x0153, SQLiteException -> 0x00f6 }
            long r15 = r15 - r12
            java.lang.Long r12 = java.lang.Long.valueOf(r15)     // Catch:{ SQLiteFullException -> 0x00f8, SQLiteDatabaseLockedException -> 0x0153, SQLiteException -> 0x00f6 }
            r0.d(r2, r4, r9, r12)     // Catch:{ SQLiteFullException -> 0x00f8, SQLiteDatabaseLockedException -> 0x0153, SQLiteException -> 0x00f6 }
            goto L_0x0103
        L_0x00f6:
            r0 = move-exception
            goto L_0x0129
        L_0x00f8:
            r0 = move-exception
            goto L_0x016b
        L_0x00fb:
            r0 = move-exception
            goto L_0x009b
        L_0x00fd:
            r0 = move-exception
            goto L_0x00a6
        L_0x00ff:
            r17 = r2
            r20 = r9
        L_0x0103:
            r10.insertOrThrow(r14, r5, r6)     // Catch:{ SQLiteFullException -> 0x00f8, SQLiteDatabaseLockedException -> 0x0153, SQLiteException -> 0x00f6 }
            r10.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x00f8, SQLiteDatabaseLockedException -> 0x0153, SQLiteException -> 0x00f6 }
            r10.endTransaction()     // Catch:{ SQLiteFullException -> 0x00f8, SQLiteDatabaseLockedException -> 0x0153, SQLiteException -> 0x00f6 }
            if (r11 == 0) goto L_0x0111
            r11.close()
        L_0x0111:
            r10.close()
            return r20
        L_0x0115:
            r5 = r11
            goto L_0x018c
        L_0x0118:
            r11 = r5
            goto L_0x0129
        L_0x011a:
            r11 = r5
            goto L_0x0153
        L_0x011c:
            r11 = r5
            goto L_0x016b
        L_0x011e:
            r0 = move-exception
            r10 = r5
            goto L_0x018c
        L_0x0122:
            r0 = move-exception
            r17 = r2
            r20 = r9
            r10 = r5
            r11 = r10
        L_0x0129:
            if (r10 == 0) goto L_0x0134
            boolean r2 = r10.inTransaction()     // Catch:{ all -> 0x0164 }
            if (r2 == 0) goto L_0x0134
            r10.endTransaction()     // Catch:{ all -> 0x0164 }
        L_0x0134:
            com.google.android.gms.measurement.internal.X2 r2 = r1.f5730a     // Catch:{ all -> 0x0164 }
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()     // Catch:{ all -> 0x0164 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()     // Catch:{ all -> 0x0164 }
            java.lang.String r4 = "Error writing entry to local database"
            r2.b(r4, r0)     // Catch:{ all -> 0x0164 }
            r2 = r20
            r1.f6485d = r2     // Catch:{ all -> 0x0164 }
            if (r11 == 0) goto L_0x014c
            r11.close()
        L_0x014c:
            if (r10 == 0) goto L_0x0185
            goto L_0x0160
        L_0x014f:
            r17 = r2
            r10 = r5
            r11 = r10
        L_0x0153:
            long r12 = (long) r8
            android.os.SystemClock.sleep(r12)     // Catch:{ all -> 0x0164 }
            int r8 = r8 + 20
            if (r11 == 0) goto L_0x015e
            r11.close()
        L_0x015e:
            if (r10 == 0) goto L_0x0185
        L_0x0160:
            r10.close()
            goto L_0x0185
        L_0x0164:
            r0 = move-exception
            goto L_0x0115
        L_0x0166:
            r0 = move-exception
            r17 = r2
            r10 = r5
            r11 = r10
        L_0x016b:
            com.google.android.gms.measurement.internal.X2 r2 = r1.f5730a     // Catch:{ all -> 0x0164 }
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()     // Catch:{ all -> 0x0164 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()     // Catch:{ all -> 0x0164 }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.b(r4, r0)     // Catch:{ all -> 0x0164 }
            r2 = 1
            r1.f6485d = r2     // Catch:{ all -> 0x0164 }
            if (r11 == 0) goto L_0x0182
            r11.close()
        L_0x0182:
            if (r10 == 0) goto L_0x0185
            goto L_0x0160
        L_0x0185:
            int r7 = r7 + 1
            r2 = r17
            r4 = 5
            goto L_0x005f
        L_0x018c:
            if (r5 == 0) goto L_0x0191
            r5.close()
        L_0x0191:
            if (r10 == 0) goto L_0x0196
            r10.close()
        L_0x0196:
            throw r0
        L_0x0197:
            r17 = r2
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.a(r2)
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1344i2.z(int, byte[]):boolean");
    }

    /* access modifiers changed from: protected */
    public final boolean m() {
        return false;
    }

    public final void o() {
        int delete;
        h();
        try {
            SQLiteDatabase w4 = w();
            if (w4 != null && (delete = w4.delete("messages", (String) null, (String[]) null)) > 0) {
                this.f5730a.a().w().b("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e5) {
            this.f5730a.a().o().b("Error resetting local analytics data. error", e5);
        }
    }

    public final boolean p(G g5) {
        Parcel obtain = Parcel.obtain();
        H.a(g5, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return z(0, marshall);
        }
        this.f5730a.a().p().a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean q(v6 v6Var) {
        Parcel obtain = Parcel.obtain();
        w6.a(v6Var, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return z(1, marshall);
        }
        this.f5730a.a().p().a("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean r(C1341i iVar) {
        X2 x22 = this.f5730a;
        byte[] T4 = x22.C().T(iVar);
        if (T4.length <= 131072) {
            return z(2, T4);
        }
        x22.a().p().a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean s(E e5) {
        X2 x22 = this.f5730a;
        byte[] T4 = x22.C().T(e5);
        if (T4 == null) {
            x22.a().p().a("Null default event parameters; not writing to database");
            return false;
        } else if (T4.length <= 131072) {
            return z(4, T4);
        } else {
            x22.a().p().a("Default event parameters too long for local database. Sending directly to service");
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v15, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v78, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v45, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v46, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v52, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v60, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.util.List, java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:110|111|112|113) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:160|161|162|163) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:90|91|92|93) */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        r1.f5730a.a().o().a("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:?, code lost:
        r5.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01fb, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        r1.f5730a.a().o().a("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:?, code lost:
        r5.recycle();
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0249, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
        r1.f5730a.a().o().a("Failed to load default event parameters from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x025e, code lost:
        r17 = r17;
        r17 = r17;
        r17 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:?, code lost:
        r5.recycle();
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        r17 = r3;
        r19 = r4;
        r21 = r5;
        r6 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
        r17 = r3;
        r19 = r4;
        r21 = r5;
        r6 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0315, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        r17 = r3;
        r19 = r4;
        r21 = r5;
        r6 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0388, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x039d, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x03a2, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x016b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        r1.f5730a.a().o().a("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        r8.recycle();
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:110:0x01b6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:135:0x0203 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:160:0x024f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:90:0x0173 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A[Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }, ExcHandler: all (th java.lang.Throwable), Splitter:B:11:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x030c A[SYNTHETIC, Splitter:B:190:0x030c] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x032f A[SYNTHETIC, Splitter:B:207:0x032f] */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x034a  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x0361  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0388  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x039d  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x03a2  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0314 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x038e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x038e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x038e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List t(int r30) {
        /*
            r29 = this;
            r1 = r29
            java.lang.String r2 = "Error reading entries from local database"
            java.lang.String r3 = "entry"
            java.lang.String r4 = "type"
            java.lang.String r5 = "rowid"
            r1.h()
            boolean r0 = r1.f6485d
            r6 = 0
            if (r0 == 0) goto L_0x0013
            return r6
        L_0x0013:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            boolean r0 = r1.x()
            if (r0 == 0) goto L_0x03b8
            r8 = 5
            r9 = 0
            r11 = r8
            r10 = r9
        L_0x0022:
            if (r10 >= r8) goto L_0x03a6
            r12 = 1
            android.database.sqlite.SQLiteDatabase r13 = r1.w()     // Catch:{ SQLiteFullException -> 0x036c, SQLiteDatabaseLockedException -> 0x0350, SQLiteException -> 0x0323, all -> 0x031e }
            if (r13 != 0) goto L_0x004e
            r1.f6485d = r12     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            return r6
        L_0x002e:
            r0 = move-exception
            goto L_0x0315
        L_0x0031:
            r0 = move-exception
            r17 = r3
            r19 = r4
            r21 = r5
            r6 = r9
            goto L_0x0318
        L_0x003b:
            r17 = r3
            r19 = r4
            r21 = r5
            r6 = r9
            goto L_0x031a
        L_0x0044:
            r0 = move-exception
            r17 = r3
            r19 = r4
            r21 = r5
            r6 = r9
            goto L_0x031c
        L_0x004e:
            r13.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            java.lang.String r0 = "3"
            java.lang.String r14 = "messages"
            java.lang.String[] r15 = new java.lang.String[]{r5}     // Catch:{ all -> 0x0301 }
            java.lang.String r16 = "type=?"
            java.lang.String[] r17 = new java.lang.String[]{r0}     // Catch:{ all -> 0x0301 }
            java.lang.String r20 = "rowid desc"
            java.lang.String r21 = "1"
            r18 = 0
            r19 = 0
            android.database.Cursor r14 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0301 }
            boolean r0 = r14.moveToFirst()     // Catch:{ all -> 0x007b }
            r22 = -1
            if (r0 == 0) goto L_0x0085
            long r15 = r14.getLong(r9)     // Catch:{ all -> 0x007b }
            r14.close()     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            goto L_0x008a
        L_0x007b:
            r0 = move-exception
            r17 = r3
            r19 = r4
            r21 = r5
            r6 = r9
            goto L_0x030a
        L_0x0085:
            r14.close()     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            r15 = r22
        L_0x008a:
            int r0 = (r15 > r22 ? 1 : (r15 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x009d
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r14 = new java.lang.String[r12]     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            java.lang.String r15 = java.lang.String.valueOf(r15)     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            r14[r9] = r15     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            r16 = r0
            r17 = r14
            goto L_0x00a1
        L_0x009d:
            r16 = r6
            r17 = r16
        L_0x00a1:
            java.lang.String[] r0 = new java.lang.String[]{r5, r4, r3}     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            com.google.android.gms.measurement.internal.X2 r14 = r1.f5730a     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            com.google.android.gms.measurement.internal.m r15 = r14.w()     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            r30 = r12
            com.google.android.gms.measurement.internal.c2 r12 = com.google.android.gms.measurement.internal.C1304d2.f6320c1     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            boolean r15 = r15.H(r6, r12)     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            r25 = 4
            r26 = 3
            r6 = 2
            if (r15 == 0) goto L_0x00ca
            java.lang.String[] r0 = new java.lang.String[r8]     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            r0[r9] = r5     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            r0[r30] = r4     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            r0[r6] = r3     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            java.lang.String r15 = "app_version"
            r0[r26] = r15     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            java.lang.String r15 = "app_version_int"
            r0[r25] = r15     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
        L_0x00ca:
            r15 = r0
            r0 = r14
            java.lang.String r14 = "messages"
            java.lang.String r20 = "rowid asc"
            r18 = 100
            java.lang.String r21 = java.lang.Integer.toString(r18)     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
            r18 = 0
            r19 = 0
            android.database.Cursor r14 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteFullException -> 0x0044, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0031, all -> 0x002e }
        L_0x00de:
            boolean r15 = r14.moveToNext()     // Catch:{ SQLiteFullException -> 0x02bb, SQLiteDatabaseLockedException -> 0x02b2, SQLiteException -> 0x02a8 }
            if (r15 == 0) goto L_0x02c5
            long r22 = r14.getLong(r9)     // Catch:{ SQLiteFullException -> 0x02bb, SQLiteDatabaseLockedException -> 0x02b2, SQLiteException -> 0x02a8 }
            r15 = r30
            int r8 = r14.getInt(r15)     // Catch:{ SQLiteFullException -> 0x02bb, SQLiteDatabaseLockedException -> 0x02b2, SQLiteException -> 0x02a8 }
            byte[] r15 = r14.getBlob(r6)     // Catch:{ SQLiteFullException -> 0x02bb, SQLiteDatabaseLockedException -> 0x02b2, SQLiteException -> 0x02a8 }
            com.google.android.gms.measurement.internal.m r6 = r0.w()     // Catch:{ SQLiteFullException -> 0x02bb, SQLiteDatabaseLockedException -> 0x02b2, SQLiteException -> 0x02a8 }
            r9 = 0
            boolean r6 = r6.H(r9, r12)     // Catch:{ SQLiteFullException -> 0x0124, SQLiteDatabaseLockedException -> 0x011b, SQLiteException -> 0x0111 }
            if (r6 == 0) goto L_0x012e
            r6 = r26
            java.lang.String r9 = r14.getString(r6)     // Catch:{ SQLiteFullException -> 0x0124, SQLiteDatabaseLockedException -> 0x011b, SQLiteException -> 0x0111 }
            r6 = r25
            long r19 = r14.getLong(r6)     // Catch:{ SQLiteFullException -> 0x0124, SQLiteDatabaseLockedException -> 0x011b, SQLiteException -> 0x0111 }
        L_0x0109:
            r6 = r3
            r27 = r19
            r19 = r4
            r3 = r27
            goto L_0x0132
        L_0x0111:
            r0 = move-exception
            r17 = r3
            r19 = r4
            r21 = r5
        L_0x0118:
            r6 = 0
            goto L_0x032d
        L_0x011b:
            r17 = r3
            r19 = r4
            r21 = r5
        L_0x0121:
            r6 = 0
            goto L_0x0359
        L_0x0124:
            r0 = move-exception
            r17 = r3
            r19 = r4
            r21 = r5
        L_0x012b:
            r6 = 0
            goto L_0x0376
        L_0x012e:
            r19 = 0
            r9 = 0
            goto L_0x0109
        L_0x0132:
            if (r8 != 0) goto L_0x0195
            android.os.Parcel r8 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0191, SQLiteDatabaseLockedException -> 0x018e, SQLiteException -> 0x018a }
            r20 = r0
            int r0 = r15.length     // Catch:{ a -> 0x0171, all -> 0x016d }
            r21 = r5
            r5 = 0
            r8.unmarshall(r15, r5, r0)     // Catch:{ a -> 0x0173 }
            r8.setDataPosition(r5)     // Catch:{ a -> 0x0173 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.G> r0 = com.google.android.gms.measurement.internal.G.CREATOR     // Catch:{ a -> 0x0173 }
            java.lang.Object r0 = r0.createFromParcel(r8)     // Catch:{ a -> 0x0173 }
            com.google.android.gms.measurement.internal.G r0 = (com.google.android.gms.measurement.internal.G) r0     // Catch:{ a -> 0x0173 }
            r8.recycle()     // Catch:{ SQLiteFullException -> 0x0167, SQLiteDatabaseLockedException -> 0x0164, SQLiteException -> 0x0160 }
            if (r0 == 0) goto L_0x0159
            f0.l r5 = new f0.l     // Catch:{ SQLiteFullException -> 0x0167, SQLiteDatabaseLockedException -> 0x0164, SQLiteException -> 0x0160 }
            r5.<init>(r0, r9, r3)     // Catch:{ SQLiteFullException -> 0x0167, SQLiteDatabaseLockedException -> 0x0164, SQLiteException -> 0x0160 }
            r7.add(r5)     // Catch:{ SQLiteFullException -> 0x0167, SQLiteDatabaseLockedException -> 0x0164, SQLiteException -> 0x0160 }
        L_0x0159:
            r17 = r6
            r0 = 2
        L_0x015c:
            r3 = 3
            r6 = 0
            goto L_0x0295
        L_0x0160:
            r0 = move-exception
        L_0x0161:
            r17 = r6
            goto L_0x0118
        L_0x0164:
            r17 = r6
            goto L_0x0121
        L_0x0167:
            r0 = move-exception
        L_0x0168:
            r17 = r6
            goto L_0x012b
        L_0x016b:
            r0 = move-exception
            goto L_0x0186
        L_0x016d:
            r0 = move-exception
            r21 = r5
            goto L_0x0186
        L_0x0171:
            r21 = r5
        L_0x0173:
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ all -> 0x016b }
            java.lang.String r3 = "Failed to load event from local database"
            r0.a(r3)     // Catch:{ all -> 0x016b }
            r8.recycle()     // Catch:{ SQLiteFullException -> 0x0167, SQLiteDatabaseLockedException -> 0x0164, SQLiteException -> 0x0160 }
            goto L_0x0159
        L_0x0186:
            r8.recycle()     // Catch:{ SQLiteFullException -> 0x0167, SQLiteDatabaseLockedException -> 0x0164, SQLiteException -> 0x0160 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0167, SQLiteDatabaseLockedException -> 0x0164, SQLiteException -> 0x0160 }
        L_0x018a:
            r0 = move-exception
            r21 = r5
            goto L_0x0161
        L_0x018e:
            r21 = r5
            goto L_0x0164
        L_0x0191:
            r0 = move-exception
            r21 = r5
            goto L_0x0168
        L_0x0195:
            r20 = r0
            r21 = r5
            r5 = 1
            if (r8 != r5) goto L_0x01d8
            android.os.Parcel r5 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0167, SQLiteDatabaseLockedException -> 0x0164, SQLiteException -> 0x0160 }
            int r0 = r15.length     // Catch:{ a -> 0x01b6 }
            r8 = 0
            r5.unmarshall(r15, r8, r0)     // Catch:{ a -> 0x01b6 }
            r5.setDataPosition(r8)     // Catch:{ a -> 0x01b6 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.v6> r0 = com.google.android.gms.measurement.internal.v6.CREATOR     // Catch:{ a -> 0x01b6 }
            java.lang.Object r0 = r0.createFromParcel(r5)     // Catch:{ a -> 0x01b6 }
            com.google.android.gms.measurement.internal.v6 r0 = (com.google.android.gms.measurement.internal.v6) r0     // Catch:{ a -> 0x01b6 }
            r5.recycle()     // Catch:{ SQLiteFullException -> 0x0167, SQLiteDatabaseLockedException -> 0x0164, SQLiteException -> 0x0160 }
            goto L_0x01c9
        L_0x01b4:
            r0 = move-exception
            goto L_0x01d4
        L_0x01b6:
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ all -> 0x01b4 }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ all -> 0x01b4 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ all -> 0x01b4 }
            java.lang.String r8 = "Failed to load user property from local database"
            r0.a(r8)     // Catch:{ all -> 0x01b4 }
            r5.recycle()     // Catch:{ SQLiteFullException -> 0x0167, SQLiteDatabaseLockedException -> 0x0164, SQLiteException -> 0x0160 }
            r0 = 0
        L_0x01c9:
            if (r0 == 0) goto L_0x0159
            f0.l r5 = new f0.l     // Catch:{ SQLiteFullException -> 0x0167, SQLiteDatabaseLockedException -> 0x0164, SQLiteException -> 0x0160 }
            r5.<init>(r0, r9, r3)     // Catch:{ SQLiteFullException -> 0x0167, SQLiteDatabaseLockedException -> 0x0164, SQLiteException -> 0x0160 }
            r7.add(r5)     // Catch:{ SQLiteFullException -> 0x0167, SQLiteDatabaseLockedException -> 0x0164, SQLiteException -> 0x0160 }
            goto L_0x0159
        L_0x01d4:
            r5.recycle()     // Catch:{ SQLiteFullException -> 0x0167, SQLiteDatabaseLockedException -> 0x0164, SQLiteException -> 0x0160 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0167, SQLiteDatabaseLockedException -> 0x0164, SQLiteException -> 0x0160 }
        L_0x01d8:
            r0 = 2
            if (r8 != r0) goto L_0x0226
            android.os.Parcel r5 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0167, SQLiteDatabaseLockedException -> 0x0164, SQLiteException -> 0x0160 }
            int r8 = r15.length     // Catch:{ a -> 0x0201, all -> 0x01fd }
            r17 = r6
            r6 = 0
            r5.unmarshall(r15, r6, r8)     // Catch:{ a -> 0x0203 }
            r5.setDataPosition(r6)     // Catch:{ a -> 0x0203 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.i> r6 = com.google.android.gms.measurement.internal.C1341i.CREATOR     // Catch:{ a -> 0x0203 }
            java.lang.Object r6 = r6.createFromParcel(r5)     // Catch:{ a -> 0x0203 }
            com.google.android.gms.measurement.internal.i r6 = (com.google.android.gms.measurement.internal.C1341i) r6     // Catch:{ a -> 0x0203 }
            r5.recycle()     // Catch:{ SQLiteFullException -> 0x01f8, SQLiteDatabaseLockedException -> 0x0121, SQLiteException -> 0x01f5 }
            goto L_0x0216
        L_0x01f5:
            r0 = move-exception
            goto L_0x0118
        L_0x01f8:
            r0 = move-exception
            goto L_0x012b
        L_0x01fb:
            r0 = move-exception
            goto L_0x0222
        L_0x01fd:
            r0 = move-exception
            r17 = r6
            goto L_0x0222
        L_0x0201:
            r17 = r6
        L_0x0203:
            com.google.android.gms.measurement.internal.X2 r6 = r1.f5730a     // Catch:{ all -> 0x01fb }
            com.google.android.gms.measurement.internal.q2 r6 = r6.a()     // Catch:{ all -> 0x01fb }
            com.google.android.gms.measurement.internal.o2 r6 = r6.o()     // Catch:{ all -> 0x01fb }
            java.lang.String r8 = "Failed to load conditional user property from local database"
            r6.a(r8)     // Catch:{ all -> 0x01fb }
            r5.recycle()     // Catch:{ SQLiteFullException -> 0x01f8, SQLiteDatabaseLockedException -> 0x0121, SQLiteException -> 0x01f5 }
            r6 = 0
        L_0x0216:
            if (r6 == 0) goto L_0x015c
            f0.l r5 = new f0.l     // Catch:{ SQLiteFullException -> 0x01f8, SQLiteDatabaseLockedException -> 0x0121, SQLiteException -> 0x01f5 }
            r5.<init>(r6, r9, r3)     // Catch:{ SQLiteFullException -> 0x01f8, SQLiteDatabaseLockedException -> 0x0121, SQLiteException -> 0x01f5 }
            r7.add(r5)     // Catch:{ SQLiteFullException -> 0x01f8, SQLiteDatabaseLockedException -> 0x0121, SQLiteException -> 0x01f5 }
            goto L_0x015c
        L_0x0222:
            r5.recycle()     // Catch:{ SQLiteFullException -> 0x01f8, SQLiteDatabaseLockedException -> 0x0121, SQLiteException -> 0x01f5 }
            throw r0     // Catch:{ SQLiteFullException -> 0x01f8, SQLiteDatabaseLockedException -> 0x0121, SQLiteException -> 0x01f5 }
        L_0x0226:
            r17 = r6
            r6 = 4
            if (r8 != r6) goto L_0x0272
            android.os.Parcel r5 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01f8, SQLiteDatabaseLockedException -> 0x0121, SQLiteException -> 0x01f5 }
            int r8 = r15.length     // Catch:{ a -> 0x024e, all -> 0x024b }
            r6 = 0
            r5.unmarshall(r15, r6, r8)     // Catch:{ a -> 0x024f }
            r5.setDataPosition(r6)     // Catch:{ a -> 0x024f }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.E> r8 = com.google.android.gms.measurement.internal.E.CREATOR     // Catch:{ a -> 0x024f }
            java.lang.Object r8 = r8.createFromParcel(r5)     // Catch:{ a -> 0x024f }
            com.google.android.gms.measurement.internal.E r8 = (com.google.android.gms.measurement.internal.E) r8     // Catch:{ a -> 0x024f }
            r5.recycle()     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            goto L_0x0262
        L_0x0243:
            r0 = move-exception
            goto L_0x032d
        L_0x0246:
            r0 = move-exception
            goto L_0x0376
        L_0x0249:
            r0 = move-exception
            goto L_0x026e
        L_0x024b:
            r0 = move-exception
            r6 = 0
            goto L_0x026e
        L_0x024e:
            r6 = 0
        L_0x024f:
            com.google.android.gms.measurement.internal.X2 r8 = r1.f5730a     // Catch:{ all -> 0x0249 }
            com.google.android.gms.measurement.internal.q2 r8 = r8.a()     // Catch:{ all -> 0x0249 }
            com.google.android.gms.measurement.internal.o2 r8 = r8.o()     // Catch:{ all -> 0x0249 }
            java.lang.String r15 = "Failed to load default event parameters from local database"
            r8.a(r15)     // Catch:{ all -> 0x0249 }
            r5.recycle()     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            r8 = 0
        L_0x0262:
            if (r8 == 0) goto L_0x026c
            f0.l r5 = new f0.l     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            r5.<init>(r8, r9, r3)     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            r7.add(r5)     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
        L_0x026c:
            r3 = 3
            goto L_0x0295
        L_0x026e:
            r5.recycle()     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
        L_0x0272:
            r3 = 3
            r6 = 0
            if (r8 != r3) goto L_0x0286
            com.google.android.gms.measurement.internal.X2 r4 = r1.f5730a     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            com.google.android.gms.measurement.internal.o2 r4 = r4.w()     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            java.lang.String r5 = "Skipping app launch break"
            r4.a(r5)     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            goto L_0x0295
        L_0x0286:
            com.google.android.gms.measurement.internal.X2 r4 = r1.f5730a     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            com.google.android.gms.measurement.internal.o2 r4 = r4.o()     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            java.lang.String r5 = "Unknown record type in local database"
            r4.a(r5)     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
        L_0x0295:
            r26 = r3
            r9 = r6
            r3 = r17
            r4 = r19
            r5 = r21
            r30 = 1
            r8 = 5
            r25 = 4
            r6 = r0
            r0 = r20
            goto L_0x00de
        L_0x02a8:
            r0 = move-exception
            r17 = r3
            r19 = r4
            r21 = r5
            r6 = r9
            goto L_0x032d
        L_0x02b2:
            r17 = r3
            r19 = r4
            r21 = r5
            r6 = r9
            goto L_0x0359
        L_0x02bb:
            r0 = move-exception
            r17 = r3
            r19 = r4
            r21 = r5
            r6 = r9
            goto L_0x0376
        L_0x02c5:
            r17 = r3
            r19 = r4
            r21 = r5
            r6 = r9
            java.lang.String r0 = "messages"
            java.lang.String r3 = "rowid <= ?"
            java.lang.String r4 = java.lang.Long.toString(r22)     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            int r0 = r13.delete(r0, r3, r4)     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            int r3 = r7.size()     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            if (r0 >= r3) goto L_0x02f1
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            java.lang.String r3 = "Fewer entries removed from local database than expected"
            r0.a(r3)     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
        L_0x02f1:
            r13.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            r13.endTransaction()     // Catch:{ SQLiteFullException -> 0x0246, SQLiteDatabaseLockedException -> 0x0359, SQLiteException -> 0x0243 }
            r14.close()
            r13.close()
            return r7
        L_0x02fe:
            r6 = r14
            goto L_0x039b
        L_0x0301:
            r0 = move-exception
            r17 = r3
            r19 = r4
            r21 = r5
            r6 = r9
            r14 = 0
        L_0x030a:
            if (r14 == 0) goto L_0x0314
            r14.close()     // Catch:{ SQLiteFullException -> 0x0312, SQLiteDatabaseLockedException -> 0x031a, SQLiteException -> 0x0310, all -> 0x002e }
            goto L_0x0314
        L_0x0310:
            r0 = move-exception
            goto L_0x0318
        L_0x0312:
            r0 = move-exception
            goto L_0x031c
        L_0x0314:
            throw r0     // Catch:{ SQLiteFullException -> 0x0312, SQLiteDatabaseLockedException -> 0x031a, SQLiteException -> 0x0310, all -> 0x002e }
        L_0x0315:
            r6 = 0
            goto L_0x039b
        L_0x0318:
            r14 = 0
            goto L_0x032d
        L_0x031a:
            r14 = 0
            goto L_0x0359
        L_0x031c:
            r14 = 0
            goto L_0x0376
        L_0x031e:
            r0 = move-exception
            r6 = 0
            r13 = 0
            goto L_0x039b
        L_0x0323:
            r0 = move-exception
            r17 = r3
            r19 = r4
            r21 = r5
            r6 = r9
            r13 = 0
            goto L_0x0318
        L_0x032d:
            if (r13 == 0) goto L_0x0338
            boolean r3 = r13.inTransaction()     // Catch:{ all -> 0x036a }
            if (r3 == 0) goto L_0x0338
            r13.endTransaction()     // Catch:{ all -> 0x036a }
        L_0x0338:
            com.google.android.gms.measurement.internal.X2 r3 = r1.f5730a     // Catch:{ all -> 0x036a }
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()     // Catch:{ all -> 0x036a }
            com.google.android.gms.measurement.internal.o2 r3 = r3.o()     // Catch:{ all -> 0x036a }
            r3.b(r2, r0)     // Catch:{ all -> 0x036a }
            r15 = 1
            r1.f6485d = r15     // Catch:{ all -> 0x036a }
            if (r14 == 0) goto L_0x034d
            r14.close()
        L_0x034d:
            if (r13 == 0) goto L_0x038e
            goto L_0x0366
        L_0x0350:
            r17 = r3
            r19 = r4
            r21 = r5
            r6 = r9
            r13 = 0
            goto L_0x031a
        L_0x0359:
            long r3 = (long) r11
            android.os.SystemClock.sleep(r3)     // Catch:{ all -> 0x036a }
            int r11 = r11 + 20
            if (r14 == 0) goto L_0x0364
            r14.close()
        L_0x0364:
            if (r13 == 0) goto L_0x038e
        L_0x0366:
            r13.close()
            goto L_0x038e
        L_0x036a:
            r0 = move-exception
            goto L_0x02fe
        L_0x036c:
            r0 = move-exception
            r17 = r3
            r19 = r4
            r21 = r5
            r6 = r9
            r13 = 0
            goto L_0x031c
        L_0x0376:
            com.google.android.gms.measurement.internal.X2 r3 = r1.f5730a     // Catch:{ all -> 0x036a }
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()     // Catch:{ all -> 0x036a }
            com.google.android.gms.measurement.internal.o2 r3 = r3.o()     // Catch:{ all -> 0x036a }
            r3.b(r2, r0)     // Catch:{ all -> 0x036a }
            r15 = 1
            r1.f6485d = r15     // Catch:{ all -> 0x036a }
            if (r14 == 0) goto L_0x038b
            r14.close()
        L_0x038b:
            if (r13 == 0) goto L_0x038e
            goto L_0x0366
        L_0x038e:
            int r10 = r10 + 1
            r9 = r6
            r3 = r17
            r4 = r19
            r5 = r21
            r6 = 0
            r8 = 5
            goto L_0x0022
        L_0x039b:
            if (r6 == 0) goto L_0x03a0
            r6.close()
        L_0x03a0:
            if (r13 == 0) goto L_0x03a5
            r13.close()
        L_0x03a5:
            throw r0
        L_0x03a6:
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.a(r2)
            r24 = 0
            return r24
        L_0x03b8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1344i2.t(int):java.util.List");
    }

    public final boolean u() {
        return z(3, new byte[0]);
    }

    public final boolean v() {
        h();
        if (!this.f6485d && x()) {
            int i5 = 5;
            int i6 = 0;
            while (true) {
                if (i6 >= 5) {
                    this.f5730a.a().r().a("Error deleting app launch break from local database in reasonable time");
                    break;
                }
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase w4 = w();
                    if (w4 == null) {
                        this.f6485d = true;
                    } else {
                        w4.beginTransaction();
                        w4.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                        w4.setTransactionSuccessful();
                        w4.endTransaction();
                        w4.close();
                        return true;
                    }
                } catch (SQLiteFullException e5) {
                    this.f5730a.a().o().b("Error deleting app launch break from local database", e5);
                    this.f6485d = true;
                    if (sQLiteDatabase == null) {
                    }
                    sQLiteDatabase.close();
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep((long) i5);
                    i5 += 20;
                    if (sQLiteDatabase == null) {
                    }
                    sQLiteDatabase.close();
                } catch (SQLiteException e6) {
                    if (sQLiteDatabase != null) {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    }
                    this.f5730a.a().o().b("Error deleting app launch break from local database", e6);
                    this.f6485d = true;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                } catch (Throwable th) {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
                i6++;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase w() {
        if (this.f6485d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f6484c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f6485d = true;
        return null;
    }

    /* access modifiers changed from: package-private */
    public final boolean x() {
        X2 x22 = this.f5730a;
        Context e5 = x22.e();
        x22.w();
        return e5.getDatabasePath("google_app_measurement_local.db").exists();
    }
}
