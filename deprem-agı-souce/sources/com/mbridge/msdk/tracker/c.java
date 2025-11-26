package com.mbridge.msdk.tracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private final b f11492a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11493b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f11494c = new Object();

    public c(b bVar, String str) {
        this.f11492a = bVar;
        this.f11493b = str;
    }

    private static boolean a(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase == null || !sQLiteDatabase.isOpen() || sQLiteDatabase.isReadOnly();
    }

    private static void d(SQLiteDatabase sQLiteDatabase) {
        if (!y.a((Object) sQLiteDatabase)) {
            try {
                sQLiteDatabase.beginTransaction();
            } catch (Exception e5) {
                if (a.f11490a) {
                    Log.e("TrackManager", "beginTransaction: ", e5);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a8, code lost:
        return;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.util.List<com.mbridge.msdk.tracker.i> r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f11494c
            monitor-enter(r0)
            com.mbridge.msdk.tracker.b r1 = r6.f11492a     // Catch:{ all -> 0x001a }
            boolean r1 = com.mbridge.msdk.tracker.y.a((java.lang.Object) r1)     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x00a7
            boolean r1 = com.mbridge.msdk.tracker.y.a((java.util.List<?>) r7)     // Catch:{ all -> 0x001a }
            if (r1 == 0) goto L_0x0013
            goto L_0x00a7
        L_0x0013:
            com.mbridge.msdk.tracker.b r1 = r6.f11492a     // Catch:{ Exception -> 0x001d }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x001d }
            goto L_0x003d
        L_0x001a:
            r7 = move-exception
            goto L_0x00a9
        L_0x001d:
            r1 = move-exception
            boolean r2 = com.mbridge.msdk.tracker.a.f11490a     // Catch:{ all -> 0x001a }
            if (r2 == 0) goto L_0x003c
            java.lang.String r2 = "TrackManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x001a }
            r3.<init>()     // Catch:{ all -> 0x001a }
            java.lang.String r4 = "updateReportStateSuccess getWritableDatabase: "
            r3.append(r4)     // Catch:{ all -> 0x001a }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x001a }
            r3.append(r1)     // Catch:{ all -> 0x001a }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x001a }
            android.util.Log.e(r2, r1)     // Catch:{ all -> 0x001a }
        L_0x003c:
            r1 = 0
        L_0x003d:
            boolean r2 = a((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x001a }
            if (r2 == 0) goto L_0x0045
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            goto L_0x00a2
        L_0x0045:
            d(r1)     // Catch:{ Exception -> 0x0079 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0079 }
        L_0x004c:
            boolean r2 = r7.hasNext()     // Catch:{ Exception -> 0x0079 }
            if (r2 == 0) goto L_0x007b
            java.lang.Object r2 = r7.next()     // Catch:{ Exception -> 0x0079 }
            com.mbridge.msdk.tracker.i r2 = (com.mbridge.msdk.tracker.i) r2     // Catch:{ Exception -> 0x0079 }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x0079 }
            r3.<init>()     // Catch:{ Exception -> 0x0079 }
            java.lang.String r4 = "state"
            r5 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0079 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x0079 }
            java.lang.String r4 = "uuid = ?"
            java.lang.String r2 = r2.f()     // Catch:{ Exception -> 0x0079 }
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x0079 }
            java.lang.String r5 = r6.f11493b     // Catch:{ Exception -> 0x0079 }
            r1.update(r5, r3, r4, r2)     // Catch:{ Exception -> 0x0079 }
            goto L_0x004c
        L_0x0077:
            r7 = move-exception
            goto L_0x00a3
        L_0x0079:
            r7 = move-exception
            goto L_0x0082
        L_0x007b:
            c((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ Exception -> 0x0079 }
        L_0x007e:
            b((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x001a }
            goto L_0x00a1
        L_0x0082:
            boolean r2 = com.mbridge.msdk.tracker.a.f11490a     // Catch:{ all -> 0x0077 }
            if (r2 == 0) goto L_0x007e
            java.lang.String r2 = "TrackManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r3.<init>()     // Catch:{ all -> 0x0077 }
            java.lang.String r4 = "updateReportStateSuccess: "
            r3.append(r4)     // Catch:{ all -> 0x0077 }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x0077 }
            r3.append(r7)     // Catch:{ all -> 0x0077 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0077 }
            android.util.Log.e(r2, r7)     // Catch:{ all -> 0x0077 }
            goto L_0x007e
        L_0x00a1:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
        L_0x00a2:
            return
        L_0x00a3:
            b((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x001a }
            throw r7     // Catch:{ all -> 0x001a }
        L_0x00a7:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            return
        L_0x00a9:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.tracker.c.b(java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b8, code lost:
        return;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.util.List<com.mbridge.msdk.tracker.i> r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f11494c
            monitor-enter(r0)
            com.mbridge.msdk.tracker.b r1 = r6.f11492a     // Catch:{ all -> 0x001a }
            boolean r1 = com.mbridge.msdk.tracker.y.a((java.lang.Object) r1)     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x00b7
            boolean r1 = com.mbridge.msdk.tracker.y.a((java.util.List<?>) r7)     // Catch:{ all -> 0x001a }
            if (r1 == 0) goto L_0x0013
            goto L_0x00b7
        L_0x0013:
            com.mbridge.msdk.tracker.b r1 = r6.f11492a     // Catch:{ Exception -> 0x001d }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x001d }
            goto L_0x003d
        L_0x001a:
            r7 = move-exception
            goto L_0x00b9
        L_0x001d:
            r1 = move-exception
            boolean r2 = com.mbridge.msdk.tracker.a.f11490a     // Catch:{ all -> 0x001a }
            if (r2 == 0) goto L_0x003c
            java.lang.String r2 = "TrackManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x001a }
            r3.<init>()     // Catch:{ all -> 0x001a }
            java.lang.String r4 = "updateReportStateFailed getWritableDatabase: "
            r3.append(r4)     // Catch:{ all -> 0x001a }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x001a }
            r3.append(r1)     // Catch:{ all -> 0x001a }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x001a }
            android.util.Log.e(r2, r1)     // Catch:{ all -> 0x001a }
        L_0x003c:
            r1 = 0
        L_0x003d:
            boolean r2 = a((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x001a }
            if (r2 == 0) goto L_0x0045
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            goto L_0x00b2
        L_0x0045:
            d(r1)     // Catch:{ Exception -> 0x0089 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0089 }
        L_0x004c:
            boolean r2 = r7.hasNext()     // Catch:{ Exception -> 0x0089 }
            if (r2 == 0) goto L_0x008b
            java.lang.Object r2 = r7.next()     // Catch:{ Exception -> 0x0089 }
            com.mbridge.msdk.tracker.i r2 = (com.mbridge.msdk.tracker.i) r2     // Catch:{ Exception -> 0x0089 }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x0089 }
            r3.<init>()     // Catch:{ Exception -> 0x0089 }
            java.lang.String r4 = "state"
            int r5 = r2.e()     // Catch:{ Exception -> 0x0089 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0089 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r4 = "report_count"
            int r5 = r2.d()     // Catch:{ Exception -> 0x0089 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0089 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r4 = "uuid = ?"
            java.lang.String r2 = r2.f()     // Catch:{ Exception -> 0x0089 }
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x0089 }
            java.lang.String r5 = r6.f11493b     // Catch:{ Exception -> 0x0089 }
            r1.update(r5, r3, r4, r2)     // Catch:{ Exception -> 0x0089 }
            goto L_0x004c
        L_0x0087:
            r7 = move-exception
            goto L_0x00b3
        L_0x0089:
            r7 = move-exception
            goto L_0x0092
        L_0x008b:
            c((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ Exception -> 0x0089 }
        L_0x008e:
            b((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x001a }
            goto L_0x00b1
        L_0x0092:
            boolean r2 = com.mbridge.msdk.tracker.a.f11490a     // Catch:{ all -> 0x0087 }
            if (r2 == 0) goto L_0x008e
            java.lang.String r2 = "TrackManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r3.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r4 = "updateReportStateFailed: "
            r3.append(r4)     // Catch:{ all -> 0x0087 }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x0087 }
            r3.append(r7)     // Catch:{ all -> 0x0087 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0087 }
            android.util.Log.e(r2, r7)     // Catch:{ all -> 0x0087 }
            goto L_0x008e
        L_0x00b1:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
        L_0x00b2:
            return
        L_0x00b3:
            b((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x001a }
            throw r7     // Catch:{ all -> 0x001a }
        L_0x00b7:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            return
        L_0x00b9:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.tracker.c.c(java.util.List):void");
    }

    public final long a(i iVar) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.f11494c) {
            long j5 = -1;
            if (y.a((Object) this.f11492a)) {
                return -1;
            }
            try {
                sQLiteDatabase = this.f11492a.getWritableDatabase();
            } catch (Exception e5) {
                if (a.f11490a) {
                    Log.e("TrackManager", "insert getWritableDatabase: " + e5.getMessage());
                }
                sQLiteDatabase = null;
            } catch (Throwable th) {
                b(sQLiteDatabase);
                throw th;
            }
            if (a(sQLiteDatabase)) {
                return -1;
            }
            try {
                d(sQLiteDatabase);
                ContentValues contentValues = new ContentValues(16);
                e c5 = iVar.c();
                contentValues.put(RewardPlus.NAME, c5.a());
                contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(c5.b()));
                contentValues.put("time_stamp", Long.valueOf(c5.f()));
                contentValues.put("properties", c5.d().toString());
                contentValues.put("priority", Integer.valueOf(c5.c()));
                contentValues.put(MRAIDCommunicatorUtil.KEY_STATE, Integer.valueOf(iVar.e()));
                contentValues.put("report_count", Integer.valueOf(iVar.d()));
                contentValues.put("uuid", c5.e());
                contentValues.put("ignore_max_timeout", Integer.valueOf(c5.j() ^ true ? 1 : 0));
                contentValues.put("ignore_max_retry_times", Integer.valueOf(c5.k() ^ true ? 1 : 0));
                contentValues.put("invalid_time", Long.valueOf(iVar.g()));
                j5 = sQLiteDatabase.insert(this.f11493b, (String) null, contentValues);
                c(sQLiteDatabase);
            } catch (Exception e6) {
                if (a.f11490a) {
                    Log.e("TrackManager", "insert: " + e6.getMessage());
                }
            }
            b(sQLiteDatabase);
            return j5;
        }
    }

    public final int b() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.f11494c) {
            int i5 = -1;
            if (y.a((Object) this.f11492a)) {
                return -1;
            }
            try {
                sQLiteDatabase = this.f11492a.getWritableDatabase();
            } catch (Exception e5) {
                if (a.f11490a) {
                    Log.e("TrackManager", "deleteInvalidEvents getWritableDatabase: " + e5.getMessage());
                }
                sQLiteDatabase = null;
            } catch (Throwable th) {
                b(sQLiteDatabase);
                throw th;
            }
            if (a(sQLiteDatabase)) {
                return -1;
            }
            try {
                d(sQLiteDatabase);
                i5 = sQLiteDatabase.delete(this.f11493b, "state = ? OR state = ?", new String[]{String.valueOf(-1), String.valueOf(2)});
                c(sQLiteDatabase);
            } catch (Exception e6) {
                if (a.f11490a) {
                    Log.e("TrackManager", "deleteInvalidEvents: " + e6.getMessage());
                }
            }
            b(sQLiteDatabase);
            return i5;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f11494c
            monitor-enter(r0)
            com.mbridge.msdk.tracker.b r1 = r6.f11492a     // Catch:{ all -> 0x000d }
            boolean r1 = com.mbridge.msdk.tracker.y.a((java.lang.Object) r1)     // Catch:{ all -> 0x000d }
            if (r1 == 0) goto L_0x0010
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            return
        L_0x000d:
            r1 = move-exception
            goto L_0x0090
        L_0x0010:
            com.mbridge.msdk.tracker.b r1 = r6.f11492a     // Catch:{ Exception -> 0x0017 }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x0017 }
            goto L_0x0037
        L_0x0017:
            r1 = move-exception
            boolean r2 = com.mbridge.msdk.tracker.a.f11490a     // Catch:{ all -> 0x000d }
            if (r2 == 0) goto L_0x0036
            java.lang.String r2 = "TrackManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x000d }
            r3.<init>()     // Catch:{ all -> 0x000d }
            java.lang.String r4 = "updateReportStateForReporting getWritableDatabase: "
            r3.append(r4)     // Catch:{ all -> 0x000d }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x000d }
            r3.append(r1)     // Catch:{ all -> 0x000d }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x000d }
            android.util.Log.e(r2, r1)     // Catch:{ all -> 0x000d }
        L_0x0036:
            r1 = 0
        L_0x0037:
            boolean r2 = a((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x000d }
            if (r2 == 0) goto L_0x003f
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            goto L_0x008b
        L_0x003f:
            d(r1)     // Catch:{ Exception -> 0x006a }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x006a }
            r2.<init>()     // Catch:{ Exception -> 0x006a }
            java.lang.String r3 = "state"
            r4 = 3
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x006a }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x006a }
            java.lang.String r3 = "state = ?"
            r4 = 1
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x006a }
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x006a }
            java.lang.String r5 = r6.f11493b     // Catch:{ Exception -> 0x006a }
            r1.update(r5, r2, r3, r4)     // Catch:{ Exception -> 0x006a }
            c((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ Exception -> 0x006a }
        L_0x0064:
            b((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x000d }
            goto L_0x008a
        L_0x0068:
            r2 = move-exception
            goto L_0x008c
        L_0x006a:
            r2 = move-exception
            boolean r3 = com.mbridge.msdk.tracker.a.f11490a     // Catch:{ all -> 0x0068 }
            if (r3 == 0) goto L_0x0064
            java.lang.String r3 = "TrackManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r4.<init>()     // Catch:{ all -> 0x0068 }
            java.lang.String r5 = "updateReportStateForReporting: "
            r4.append(r5)     // Catch:{ all -> 0x0068 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0068 }
            r4.append(r2)     // Catch:{ all -> 0x0068 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0068 }
            android.util.Log.e(r3, r2)     // Catch:{ all -> 0x0068 }
            goto L_0x0064
        L_0x008a:
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
        L_0x008b:
            return
        L_0x008c:
            b((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x000d }
            throw r2     // Catch:{ all -> 0x000d }
        L_0x0090:
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.tracker.c.c():void");
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [java.util.List<com.mbridge.msdk.tracker.i>] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v8, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082 A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.mbridge.msdk.tracker.i> a(int r14) {
        /*
            r13 = this;
            java.lang.Object r1 = r13.f11494c
            monitor-enter(r1)
            com.mbridge.msdk.tracker.b r0 = r13.f11492a     // Catch:{ all -> 0x000e }
            boolean r0 = com.mbridge.msdk.tracker.y.a((java.lang.Object) r0)     // Catch:{ all -> 0x000e }
            r2 = 0
            if (r0 == 0) goto L_0x0012
            monitor-exit(r1)     // Catch:{ all -> 0x000e }
            return r2
        L_0x000e:
            r0 = move-exception
            r14 = r0
            goto L_0x00ac
        L_0x0012:
            com.mbridge.msdk.tracker.b r0 = r13.f11492a     // Catch:{ Exception -> 0x001a }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ Exception -> 0x001a }
            r3 = r0
            goto L_0x003a
        L_0x001a:
            r0 = move-exception
            boolean r3 = com.mbridge.msdk.tracker.a.f11490a     // Catch:{ all -> 0x000e }
            if (r3 == 0) goto L_0x0039
            java.lang.String r3 = "TrackManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x000e }
            r4.<init>()     // Catch:{ all -> 0x000e }
            java.lang.String r5 = "getAvailable getWritableDatabase: "
            r4.append(r5)     // Catch:{ all -> 0x000e }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x000e }
            r4.append(r0)     // Catch:{ all -> 0x000e }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x000e }
            android.util.Log.e(r3, r0)     // Catch:{ all -> 0x000e }
        L_0x0039:
            r3 = r2
        L_0x003a:
            boolean r0 = a((android.database.sqlite.SQLiteDatabase) r3)     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0042
            monitor-exit(r1)     // Catch:{ all -> 0x000e }
            return r2
        L_0x0042:
            d(r3)     // Catch:{ Exception -> 0x007c }
            java.lang.String r6 = "state = ? OR state = ?"
            r0 = 0
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x007c }
            r4 = 3
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x007c }
            java.lang.String[] r7 = new java.lang.String[]{r0, r4}     // Catch:{ Exception -> 0x007c }
            java.lang.String r10 = "priority DESC"
            java.lang.String r4 = r13.f11493b     // Catch:{ Exception -> 0x007c }
            java.lang.String r11 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x007c }
            r5 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r14 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x007c }
            java.util.List r2 = com.mbridge.msdk.tracker.y.b((android.database.Cursor) r14)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            c((android.database.sqlite.SQLiteDatabase) r3)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            b((android.database.sqlite.SQLiteDatabase) r3)     // Catch:{ all -> 0x000e }
            com.mbridge.msdk.tracker.y.a((android.database.Cursor) r14)     // Catch:{ all -> 0x000e }
            goto L_0x00a3
        L_0x0072:
            r0 = move-exception
            r2 = r14
            goto L_0x00a5
        L_0x0075:
            r0 = move-exception
            r12 = r2
            r2 = r14
            r14 = r12
            goto L_0x007e
        L_0x007a:
            r0 = move-exception
            goto L_0x00a5
        L_0x007c:
            r0 = move-exception
            r14 = r2
        L_0x007e:
            boolean r4 = com.mbridge.msdk.tracker.a.f11490a     // Catch:{ all -> 0x007a }
            if (r4 == 0) goto L_0x009c
            java.lang.String r4 = "TrackManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x007a }
            r5.<init>()     // Catch:{ all -> 0x007a }
            java.lang.String r6 = "getAvailable: "
            r5.append(r6)     // Catch:{ all -> 0x007a }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x007a }
            r5.append(r0)     // Catch:{ all -> 0x007a }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x007a }
            android.util.Log.e(r4, r0)     // Catch:{ all -> 0x007a }
        L_0x009c:
            b((android.database.sqlite.SQLiteDatabase) r3)     // Catch:{ all -> 0x000e }
            com.mbridge.msdk.tracker.y.a((android.database.Cursor) r2)     // Catch:{ all -> 0x000e }
            r2 = r14
        L_0x00a3:
            monitor-exit(r1)     // Catch:{ all -> 0x000e }
            return r2
        L_0x00a5:
            b((android.database.sqlite.SQLiteDatabase) r3)     // Catch:{ all -> 0x000e }
            com.mbridge.msdk.tracker.y.a((android.database.Cursor) r2)     // Catch:{ all -> 0x000e }
            throw r0     // Catch:{ all -> 0x000e }
        L_0x00ac:
            monitor-exit(r1)     // Catch:{ all -> 0x000e }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.tracker.c.a(int):java.util.List");
    }

    private static void b(SQLiteDatabase sQLiteDatabase) {
        if (!y.a((Object) sQLiteDatabase) && sQLiteDatabase.inTransaction()) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Exception e5) {
                if (a.f11490a) {
                    Log.e("TrackManager", "endTransaction: ", e5);
                }
            }
        }
    }

    private static void c(SQLiteDatabase sQLiteDatabase) {
        if (!y.a((Object) sQLiteDatabase)) {
            try {
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e5) {
                if (a.f11490a) {
                    Log.e("TrackManager", "transactionSuccess: ", e5);
                }
            }
        }
    }

    public final int a() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.f11494c) {
            int i5 = 0;
            if (y.a((Object) this.f11492a)) {
                return 0;
            }
            Cursor cursor = null;
            try {
                sQLiteDatabase = this.f11492a.getWritableDatabase();
            } catch (Exception e5) {
                if (a.f11490a) {
                    Log.e("TrackManager", "getAvailableCount getWritableDatabase: " + e5.getMessage());
                }
                sQLiteDatabase = null;
            } catch (Throwable th) {
                b(sQLiteDatabase);
                y.a((Cursor) null);
                throw th;
            }
            if (a(sQLiteDatabase)) {
                return 0;
            }
            try {
                d(sQLiteDatabase);
                cursor = sQLiteDatabase.query(this.f11493b, (String[]) null, "state = ? OR state = ?", new String[]{String.valueOf(3), String.valueOf(0)}, (String) null, (String) null, (String) null, (String) null);
                if (cursor != null && cursor.moveToNext()) {
                    i5 = Math.max(cursor.getCount(), 0);
                }
                c(sQLiteDatabase);
                b(sQLiteDatabase);
            } catch (Exception e6) {
                if (a.f11490a) {
                    Log.e("TrackManager", "getAvailableCount: " + e6.getMessage());
                }
                b(sQLiteDatabase);
            }
            y.a(cursor);
            return i5;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a8, code lost:
        return;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.List<com.mbridge.msdk.tracker.i> r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f11494c
            monitor-enter(r0)
            com.mbridge.msdk.tracker.b r1 = r6.f11492a     // Catch:{ all -> 0x001a }
            boolean r1 = com.mbridge.msdk.tracker.y.a((java.lang.Object) r1)     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x00a7
            boolean r1 = com.mbridge.msdk.tracker.y.a((java.util.List<?>) r7)     // Catch:{ all -> 0x001a }
            if (r1 == 0) goto L_0x0013
            goto L_0x00a7
        L_0x0013:
            com.mbridge.msdk.tracker.b r1 = r6.f11492a     // Catch:{ Exception -> 0x001d }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x001d }
            goto L_0x003d
        L_0x001a:
            r7 = move-exception
            goto L_0x00a9
        L_0x001d:
            r1 = move-exception
            boolean r2 = com.mbridge.msdk.tracker.a.f11490a     // Catch:{ all -> 0x001a }
            if (r2 == 0) goto L_0x003c
            java.lang.String r2 = "TrackManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x001a }
            r3.<init>()     // Catch:{ all -> 0x001a }
            java.lang.String r4 = "updateReportStateReporting getWritableDatabase: "
            r3.append(r4)     // Catch:{ all -> 0x001a }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x001a }
            r3.append(r1)     // Catch:{ all -> 0x001a }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x001a }
            android.util.Log.e(r2, r1)     // Catch:{ all -> 0x001a }
        L_0x003c:
            r1 = 0
        L_0x003d:
            boolean r2 = a((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x001a }
            if (r2 == 0) goto L_0x0045
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            goto L_0x00a2
        L_0x0045:
            d(r1)     // Catch:{ Exception -> 0x0079 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0079 }
        L_0x004c:
            boolean r2 = r7.hasNext()     // Catch:{ Exception -> 0x0079 }
            if (r2 == 0) goto L_0x007b
            java.lang.Object r2 = r7.next()     // Catch:{ Exception -> 0x0079 }
            com.mbridge.msdk.tracker.i r2 = (com.mbridge.msdk.tracker.i) r2     // Catch:{ Exception -> 0x0079 }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x0079 }
            r3.<init>()     // Catch:{ Exception -> 0x0079 }
            java.lang.String r4 = "state"
            r5 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0079 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x0079 }
            java.lang.String r4 = "uuid = ?"
            java.lang.String r2 = r2.f()     // Catch:{ Exception -> 0x0079 }
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x0079 }
            java.lang.String r5 = r6.f11493b     // Catch:{ Exception -> 0x0079 }
            r1.update(r5, r3, r4, r2)     // Catch:{ Exception -> 0x0079 }
            goto L_0x004c
        L_0x0077:
            r7 = move-exception
            goto L_0x00a3
        L_0x0079:
            r7 = move-exception
            goto L_0x0082
        L_0x007b:
            c((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ Exception -> 0x0079 }
        L_0x007e:
            b((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x001a }
            goto L_0x00a1
        L_0x0082:
            boolean r2 = com.mbridge.msdk.tracker.a.f11490a     // Catch:{ all -> 0x0077 }
            if (r2 == 0) goto L_0x007e
            java.lang.String r2 = "TrackManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r3.<init>()     // Catch:{ all -> 0x0077 }
            java.lang.String r4 = "updateReportStateReporting: "
            r3.append(r4)     // Catch:{ all -> 0x0077 }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x0077 }
            r3.append(r7)     // Catch:{ all -> 0x0077 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0077 }
            android.util.Log.e(r2, r7)     // Catch:{ all -> 0x0077 }
            goto L_0x007e
        L_0x00a1:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
        L_0x00a2:
            return
        L_0x00a3:
            b((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x001a }
            throw r7     // Catch:{ all -> 0x001a }
        L_0x00a7:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            return
        L_0x00a9:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.tracker.c.a(java.util.List):void");
    }
}
