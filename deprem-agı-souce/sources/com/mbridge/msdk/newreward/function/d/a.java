package com.mbridge.msdk.newreward.function.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.common.DatabaseUtils;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private SQLiteDatabase f10879a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f10880b = new Object();

    public a(SQLiteDatabase sQLiteDatabase) {
        this.f10879a = sQLiteDatabase;
    }

    public final void a(final b bVar) {
        MBridgeTaskManager.campaignTableExecute(new Runnable() {
            public final void run() {
                a.this.b(bVar);
            }
        });
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(int r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, boolean r21, java.lang.String r22, long r23) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            r2 = r19
            r3 = r20
            r4 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            android.database.sqlite.SQLiteDatabase r5 = r1.f10879a
            boolean r5 = com.mbridge.msdk.newreward.function.common.DatabaseUtils.isDatabaseAvailable(r5)
            if (r5 != 0) goto L_0x0021
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x0117
            java.lang.String r0 = "CampaignTable"
            java.lang.String r2 = "insert: database is not available"
            com.mbridge.msdk.foundation.tools.af.b(r0, r2)
            return
        L_0x0021:
            double r5 = com.mbridge.msdk.newreward.function.h.c.d(r22)
            java.lang.Object r7 = r1.f10880b
            monitor-enter(r7)
            java.lang.String r11 = "ad_type=? and app_id=? and placement_id=? and unit_id=? and local_id=?"
            java.lang.String r8 = java.lang.String.valueOf(r17)     // Catch:{ Exception -> 0x005d }
            com.mbridge.msdk.foundation.controller.c r9 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x005d }
            java.lang.String r9 = r9.k()     // Catch:{ Exception -> 0x005d }
            java.lang.String[] r12 = new java.lang.String[]{r8, r9, r0, r2, r3}     // Catch:{ Exception -> 0x005d }
            android.database.sqlite.SQLiteDatabase r8 = r1.f10879a     // Catch:{ Exception -> 0x005d }
            java.lang.String r9 = "campaign"
            r14 = 0
            r15 = 0
            r10 = 0
            r13 = 0
            android.database.Cursor r8 = r8.query(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x005d }
            if (r8 == 0) goto L_0x006d
            int r9 = r8.getCount()     // Catch:{ Exception -> 0x005d }
            if (r9 <= 0) goto L_0x006d
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x005d }
            if (r0 == 0) goto L_0x0060
            java.lang.String r0 = "CampaignTable"
            java.lang.String r2 = "insert:  already exist"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x005d }
            goto L_0x0060
        L_0x005a:
            r0 = move-exception
            goto L_0x0118
        L_0x005d:
            r0 = move-exception
            goto L_0x0108
        L_0x0060:
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.closeCursor(r8)     // Catch:{ Exception -> 0x005d }
            android.database.sqlite.SQLiteDatabase r0 = r1.f10879a     // Catch:{ all -> 0x006a }
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.endTransaction(r0)     // Catch:{ all -> 0x006a }
            monitor-exit(r7)     // Catch:{ all -> 0x006a }
            return
        L_0x006a:
            r0 = move-exception
            goto L_0x011e
        L_0x006d:
            android.database.sqlite.SQLiteDatabase r8 = r1.f10879a     // Catch:{ Exception -> 0x005d }
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.beginTransaction(r8)     // Catch:{ Exception -> 0x005d }
            android.content.ContentValues r8 = new android.content.ContentValues     // Catch:{ Exception -> 0x005d }
            r8.<init>()     // Catch:{ Exception -> 0x005d }
            java.lang.String r9 = "ad_type"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r17)     // Catch:{ Exception -> 0x005d }
            r8.put(r9, r10)     // Catch:{ Exception -> 0x005d }
            java.lang.String r9 = "app_id"
            com.mbridge.msdk.foundation.controller.c r10 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x005d }
            java.lang.String r10 = r10.k()     // Catch:{ Exception -> 0x005d }
            r8.put(r9, r10)     // Catch:{ Exception -> 0x005d }
            java.lang.String r9 = "placement_id"
            r8.put(r9, r0)     // Catch:{ Exception -> 0x005d }
            java.lang.String r0 = "unit_id"
            r8.put(r0, r2)     // Catch:{ Exception -> 0x005d }
            java.lang.String r0 = "local_id"
            r8.put(r0, r3)     // Catch:{ Exception -> 0x005d }
            java.lang.String r0 = "state"
            r8.put(r0, r4)     // Catch:{ Exception -> 0x005d }
            java.lang.String r0 = "bid_token"
            r2 = r22
            r8.put(r0, r2)     // Catch:{ Exception -> 0x005d }
            java.lang.String r0 = "invalid_time"
            java.lang.Long r2 = java.lang.Long.valueOf(r23)     // Catch:{ Exception -> 0x005d }
            r8.put(r0, r2)     // Catch:{ Exception -> 0x005d }
            java.lang.String r0 = "header_bidding"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r21)     // Catch:{ Exception -> 0x005d }
            r8.put(r0, r2)     // Catch:{ Exception -> 0x005d }
            java.lang.String r0 = "load_start_time"
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x005d }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x005d }
            r8.put(r0, r2)     // Catch:{ Exception -> 0x005d }
            java.lang.String r0 = "ecppv"
            java.lang.Double r2 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x005d }
            r8.put(r0, r2)     // Catch:{ Exception -> 0x005d }
            java.lang.String r0 = "s_show_index"
            r8.put(r0, r4)     // Catch:{ Exception -> 0x005d }
            java.lang.String r0 = "r_index"
            r8.put(r0, r4)     // Catch:{ Exception -> 0x005d }
            android.database.sqlite.SQLiteDatabase r0 = r1.f10879a     // Catch:{ Exception -> 0x005d }
            java.lang.String r2 = "campaign"
            r3 = 0
            long r2 = r0.insert(r2, r3, r8)     // Catch:{ Exception -> 0x005d }
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x005d }
            if (r0 == 0) goto L_0x00fd
            java.lang.String r0 = "CampaignTable"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005d }
            r4.<init>()     // Catch:{ Exception -> 0x005d }
            java.lang.String r5 = "insert result:  "
            r4.append(r5)     // Catch:{ Exception -> 0x005d }
            r4.append(r2)     // Catch:{ Exception -> 0x005d }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x005d }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x005d }
        L_0x00fd:
            android.database.sqlite.SQLiteDatabase r0 = r1.f10879a     // Catch:{ Exception -> 0x005d }
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.setTransactionSuccessful(r0)     // Catch:{ Exception -> 0x005d }
            android.database.sqlite.SQLiteDatabase r0 = r1.f10879a     // Catch:{ all -> 0x006a }
        L_0x0104:
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.endTransaction(r0)     // Catch:{ all -> 0x006a }
            goto L_0x0116
        L_0x0108:
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0113
            java.lang.String r2 = "CampaignTable"
            java.lang.String r3 = "insert: "
            com.mbridge.msdk.foundation.tools.af.b(r2, r3, r0)     // Catch:{ all -> 0x005a }
        L_0x0113:
            android.database.sqlite.SQLiteDatabase r0 = r1.f10879a     // Catch:{ all -> 0x006a }
            goto L_0x0104
        L_0x0116:
            monitor-exit(r7)     // Catch:{ all -> 0x006a }
        L_0x0117:
            return
        L_0x0118:
            android.database.sqlite.SQLiteDatabase r2 = r1.f10879a     // Catch:{ all -> 0x006a }
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.endTransaction(r2)     // Catch:{ all -> 0x006a }
            throw r0     // Catch:{ all -> 0x006a }
        L_0x011e:
            monitor-exit(r7)     // Catch:{ all -> 0x006a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.d.a.b(int, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, long):void");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(int r5, java.lang.String r6, java.lang.String r7) {
        /*
            r4 = this;
            android.database.sqlite.SQLiteDatabase r0 = r4.f10879a
            boolean r0 = com.mbridge.msdk.newreward.function.common.DatabaseUtils.isDatabaseAvailable(r0)
            if (r0 != 0) goto L_0x0014
            boolean r5 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r5 == 0) goto L_0x0087
            java.lang.String r5 = "CampaignTable"
            java.lang.String r6 = "clearLoadCheckCampaigns: database is not available"
            com.mbridge.msdk.foundation.tools.af.b(r5, r6)
            return
        L_0x0014:
            java.lang.Object r0 = r4.f10880b
            monitor-enter(r0)
            android.database.sqlite.SQLiteDatabase r1 = r4.f10879a     // Catch:{ Exception -> 0x0069 }
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.beginTransaction(r1)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r1 = "(0,405,401,404)"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0069 }
            r2.<init>()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = "ad_type=? and app_id=? and placement_id=? and unit_id=? and state in "
            r2.append(r3)     // Catch:{ Exception -> 0x0069 }
            r2.append(r1)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r1 = ";"
            r2.append(r1)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0069 }
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r2 = r2.k()     // Catch:{ Exception -> 0x0069 }
            java.lang.String[] r5 = new java.lang.String[]{r5, r2, r6, r7}     // Catch:{ Exception -> 0x0069 }
            android.database.sqlite.SQLiteDatabase r6 = r4.f10879a     // Catch:{ Exception -> 0x0069 }
            java.lang.String r7 = "campaign"
            int r5 = r6.delete(r7, r1, r5)     // Catch:{ Exception -> 0x0069 }
            boolean r6 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0069 }
            if (r6 == 0) goto L_0x006b
            java.lang.String r6 = "CampaignTable"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0069 }
            r7.<init>()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r1 = "clearLoadCheckCampaigns result:  "
            r7.append(r1)     // Catch:{ Exception -> 0x0069 }
            r7.append(r5)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x0069 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r6, (java.lang.String) r5)     // Catch:{ Exception -> 0x0069 }
            goto L_0x006b
        L_0x0067:
            r5 = move-exception
            goto L_0x0088
        L_0x0069:
            r5 = move-exception
            goto L_0x0078
        L_0x006b:
            android.database.sqlite.SQLiteDatabase r5 = r4.f10879a     // Catch:{ Exception -> 0x0069 }
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.setTransactionSuccessful(r5)     // Catch:{ Exception -> 0x0069 }
            android.database.sqlite.SQLiteDatabase r5 = r4.f10879a     // Catch:{ all -> 0x0076 }
        L_0x0072:
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.endTransaction(r5)     // Catch:{ all -> 0x0076 }
            goto L_0x0086
        L_0x0076:
            r5 = move-exception
            goto L_0x008e
        L_0x0078:
            boolean r6 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0067 }
            if (r6 == 0) goto L_0x0083
            java.lang.String r6 = "CampaignTable"
            java.lang.String r7 = "clearLoadCheckCampaigns: "
            com.mbridge.msdk.foundation.tools.af.b(r6, r7, r5)     // Catch:{ all -> 0x0067 }
        L_0x0083:
            android.database.sqlite.SQLiteDatabase r5 = r4.f10879a     // Catch:{ all -> 0x0076 }
            goto L_0x0072
        L_0x0086:
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
        L_0x0087:
            return
        L_0x0088:
            android.database.sqlite.SQLiteDatabase r6 = r4.f10879a     // Catch:{ all -> 0x0076 }
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.endTransaction(r6)     // Catch:{ all -> 0x0076 }
            throw r5     // Catch:{ all -> 0x0076 }
        L_0x008e:
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.d.a.c(int, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(int r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            android.database.sqlite.SQLiteDatabase r0 = r5.f10879a
            boolean r0 = com.mbridge.msdk.newreward.function.common.DatabaseUtils.isDatabaseAvailable(r0)
            if (r0 != 0) goto L_0x0014
            boolean r6 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r6 == 0) goto L_0x007b
            java.lang.String r6 = "CampaignTable"
            java.lang.String r7 = "clearUnInvalidCampaign: database is not available"
            com.mbridge.msdk.foundation.tools.af.b(r6, r7)
            return
        L_0x0014:
            java.lang.Object r0 = r5.f10880b
            monitor-enter(r0)
            android.database.sqlite.SQLiteDatabase r1 = r5.f10879a     // Catch:{ Exception -> 0x005d }
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.beginTransaction(r1)     // Catch:{ Exception -> 0x005d }
            java.lang.String r1 = a()     // Catch:{ Exception -> 0x005d }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x005d }
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x005d }
            java.lang.String r2 = r2.k()     // Catch:{ Exception -> 0x005d }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x005d }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x005d }
            java.lang.String[] r6 = new java.lang.String[]{r6, r2, r7, r8, r3}     // Catch:{ Exception -> 0x005d }
            android.database.sqlite.SQLiteDatabase r7 = r5.f10879a     // Catch:{ Exception -> 0x005d }
            java.lang.String r8 = "campaign"
            int r6 = r7.delete(r8, r1, r6)     // Catch:{ Exception -> 0x005d }
            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x005d }
            if (r7 == 0) goto L_0x005f
            java.lang.String r7 = "CampaignTable"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005d }
            r8.<init>()     // Catch:{ Exception -> 0x005d }
            java.lang.String r1 = "clearUnInvalidCampaign result:  "
            r8.append(r1)     // Catch:{ Exception -> 0x005d }
            r8.append(r6)     // Catch:{ Exception -> 0x005d }
            java.lang.String r6 = r8.toString()     // Catch:{ Exception -> 0x005d }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r7, (java.lang.String) r6)     // Catch:{ Exception -> 0x005d }
            goto L_0x005f
        L_0x005b:
            r6 = move-exception
            goto L_0x007c
        L_0x005d:
            r6 = move-exception
            goto L_0x006c
        L_0x005f:
            android.database.sqlite.SQLiteDatabase r6 = r5.f10879a     // Catch:{ Exception -> 0x005d }
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.setTransactionSuccessful(r6)     // Catch:{ Exception -> 0x005d }
            android.database.sqlite.SQLiteDatabase r6 = r5.f10879a     // Catch:{ all -> 0x006a }
        L_0x0066:
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.endTransaction(r6)     // Catch:{ all -> 0x006a }
            goto L_0x007a
        L_0x006a:
            r6 = move-exception
            goto L_0x0082
        L_0x006c:
            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x005b }
            if (r7 == 0) goto L_0x0077
            java.lang.String r7 = "CampaignTable"
            java.lang.String r8 = "clearUnInvalidCampaign: "
            com.mbridge.msdk.foundation.tools.af.b(r7, r8, r6)     // Catch:{ all -> 0x005b }
        L_0x0077:
            android.database.sqlite.SQLiteDatabase r6 = r5.f10879a     // Catch:{ all -> 0x006a }
            goto L_0x0066
        L_0x007a:
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
        L_0x007b:
            return
        L_0x007c:
            android.database.sqlite.SQLiteDatabase r7 = r5.f10879a     // Catch:{ all -> 0x006a }
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.endTransaction(r7)     // Catch:{ all -> 0x006a }
            throw r6     // Catch:{ all -> 0x006a }
        L_0x0082:
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.d.a.d(int, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0088 A[Catch:{ all -> 0x007f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> e(int r14, java.lang.String r15, java.lang.String r16) {
        /*
            r13 = this;
            android.database.sqlite.SQLiteDatabase r0 = r13.f10879a
            boolean r0 = com.mbridge.msdk.newreward.function.common.DatabaseUtils.isDatabaseAvailable(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0015
            boolean r14 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r14 == 0) goto L_0x0014
            java.lang.String r14 = "CampaignTable"
            java.lang.String r15 = "database is not available"
            com.mbridge.msdk.foundation.tools.af.b(r14, r15)
        L_0x0014:
            return r1
        L_0x0015:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.Object r3 = r13.f10880b
            monitor-enter(r3)
            java.lang.String r7 = a()     // Catch:{ Exception -> 0x0082 }
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x0082 }
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0082 }
            java.lang.String r0 = r0.k()     // Catch:{ Exception -> 0x0082 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0082 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0082 }
            r5 = r16
            java.lang.String[] r8 = new java.lang.String[]{r14, r0, r15, r5, r4}     // Catch:{ Exception -> 0x0082 }
            android.database.sqlite.SQLiteDatabase r4 = r13.f10879a     // Catch:{ Exception -> 0x0082 }
            java.lang.String r5 = "campaign"
            r11 = 0
            r12 = 0
            r6 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r14 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0082 }
            if (r14 == 0) goto L_0x007a
            int r15 = r14.getCount()     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            if (r15 > 0) goto L_0x0051
            goto L_0x007a
        L_0x0051:
            java.lang.String r15 = "local_id"
            int r15 = r14.getColumnIndex(r15)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
        L_0x0057:
            boolean r0 = r14.moveToNext()     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            if (r0 == 0) goto L_0x0073
            java.lang.String r0 = r14.getString(r15)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            if (r1 != 0) goto L_0x0057
            r2.add(r0)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            goto L_0x0057
        L_0x006b:
            r0 = move-exception
            r15 = r0
            r1 = r14
            goto L_0x0094
        L_0x006f:
            r0 = move-exception
            r15 = r0
            r1 = r14
            goto L_0x0084
        L_0x0073:
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.closeCursor(r14)     // Catch:{ all -> 0x0077 }
            goto L_0x0092
        L_0x0077:
            r0 = move-exception
            r14 = r0
            goto L_0x0098
        L_0x007a:
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.closeCursor(r14)     // Catch:{ all -> 0x0077 }
            monitor-exit(r3)     // Catch:{ all -> 0x0077 }
            return r1
        L_0x007f:
            r0 = move-exception
            r15 = r0
            goto L_0x0094
        L_0x0082:
            r0 = move-exception
            r15 = r0
        L_0x0084:
            boolean r14 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x007f }
            if (r14 == 0) goto L_0x008f
            java.lang.String r14 = "CampaignTable"
            java.lang.String r0 = "find: "
            com.mbridge.msdk.foundation.tools.af.b(r14, r0, r15)     // Catch:{ all -> 0x007f }
        L_0x008f:
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.closeCursor(r1)     // Catch:{ all -> 0x0077 }
        L_0x0092:
            monitor-exit(r3)     // Catch:{ all -> 0x0077 }
            return r2
        L_0x0094:
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.closeCursor(r1)     // Catch:{ all -> 0x0077 }
            throw r15     // Catch:{ all -> 0x0077 }
        L_0x0098:
            monitor-exit(r3)     // Catch:{ all -> 0x0077 }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.d.a.e(int, java.lang.String, java.lang.String):java.util.List");
    }

    public final void a(int i5, String str, String str2, boolean z4, b bVar) {
        final int i6 = i5;
        final String str3 = str;
        final String str4 = str2;
        final boolean z5 = z4;
        final b bVar2 = bVar;
        MBridgeTaskManager.campaignTableExecute(new Runnable() {
            public final void run() {
                List<b> a5 = a.this.a(i6, str3, str4, z5);
                if (a5 == null || a5.isEmpty()) {
                    b bVar = bVar2;
                    if (bVar != null) {
                        bVar.a();
                        return;
                    }
                    return;
                }
                b bVar2 = bVar2;
                if (bVar2 != null) {
                    bVar2.a(a5);
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c A[Catch:{ all -> 0x0048 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:37:0x0073=Splitter:B:37:0x0073, B:23:0x005a=Splitter:B:23:0x005a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.mbridge.msdk.newreward.function.c.a.b> a(int r12, java.lang.String r13, java.lang.String r14, boolean r15) {
        /*
            r11 = this;
            android.database.sqlite.SQLiteDatabase r0 = r11.f10879a
            boolean r0 = com.mbridge.msdk.newreward.function.common.DatabaseUtils.isDatabaseAvailable(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0015
            boolean r12 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r12 == 0) goto L_0x0014
            java.lang.String r12 = "CampaignTable"
            java.lang.String r13 = "find: database is not available"
            com.mbridge.msdk.foundation.tools.af.b(r12, r13)
        L_0x0014:
            return r1
        L_0x0015:
            java.lang.Object r2 = r11.f10880b
            monitor-enter(r2)
            java.lang.String r15 = java.lang.String.valueOf(r15)     // Catch:{ Exception -> 0x0065, all -> 0x0062 }
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0065, all -> 0x0062 }
            java.lang.String r0 = r0.k()     // Catch:{ Exception -> 0x0065, all -> 0x0062 }
            java.lang.String r6 = "ad_type=? and app_id=? and placement_id=? and unit_id=? and header_bidding=? and state in (401,404,405)"
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x0065, all -> 0x0062 }
            java.lang.String[] r7 = new java.lang.String[]{r12, r0, r13, r14, r15}     // Catch:{ Exception -> 0x0065, all -> 0x0062 }
            java.lang.String r10 = "load_start_time desc"
            android.database.sqlite.SQLiteDatabase r3 = r11.f10879a     // Catch:{ Exception -> 0x0065, all -> 0x0062 }
            java.lang.String r4 = "campaign"
            r8 = 0
            r9 = 0
            r5 = 0
            android.database.Cursor r12 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0065, all -> 0x0062 }
            java.util.List r13 = a((android.database.Cursor) r12)     // Catch:{ Exception -> 0x004c }
            if (r13 == 0) goto L_0x004f
            int r14 = r13.size()     // Catch:{ Exception -> 0x004c }
            if (r14 != 0) goto L_0x005a
            goto L_0x004f
        L_0x0048:
            r0 = move-exception
            r13 = r0
            r1 = r12
            goto L_0x0078
        L_0x004c:
            r0 = move-exception
            r13 = r0
            goto L_0x0068
        L_0x004f:
            boolean r14 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x004c }
            if (r14 == 0) goto L_0x005a
            java.lang.String r14 = "CampaignTable"
            java.lang.String r15 = "find: mBridgeCampaigns is null or empty"
            com.mbridge.msdk.foundation.tools.af.b(r14, r15)     // Catch:{ Exception -> 0x004c }
        L_0x005a:
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.closeCursor(r12)     // Catch:{ all -> 0x005f }
            monitor-exit(r2)     // Catch:{ all -> 0x005f }
            return r13
        L_0x005f:
            r0 = move-exception
            r12 = r0
            goto L_0x007c
        L_0x0062:
            r0 = move-exception
            r13 = r0
            goto L_0x0078
        L_0x0065:
            r0 = move-exception
            r13 = r0
            r12 = r1
        L_0x0068:
            boolean r14 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0048 }
            if (r14 == 0) goto L_0x0073
            java.lang.String r14 = "CampaignTable"
            java.lang.String r15 = "find: "
            com.mbridge.msdk.foundation.tools.af.b(r14, r15, r13)     // Catch:{ all -> 0x0048 }
        L_0x0073:
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.closeCursor(r12)     // Catch:{ all -> 0x005f }
            monitor-exit(r2)     // Catch:{ all -> 0x005f }
            return r1
        L_0x0078:
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.closeCursor(r1)     // Catch:{ all -> 0x005f }
            throw r13     // Catch:{ all -> 0x005f }
        L_0x007c:
            monitor-exit(r2)     // Catch:{ all -> 0x005f }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.d.a.a(int, java.lang.String, java.lang.String, boolean):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b9 A[Catch:{ all -> 0x00c1 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:48:0x00c5=Splitter:B:48:0x00c5, B:36:0x00ad=Splitter:B:36:0x00ad} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.mbridge.msdk.newreward.function.c.a.b> a(int r14, java.lang.String r15, java.lang.String r16, boolean r17, int r18, java.lang.String r19) {
        /*
            r13 = this;
            android.database.sqlite.SQLiteDatabase r0 = r13.f10879a
            boolean r0 = com.mbridge.msdk.newreward.function.common.DatabaseUtils.isDatabaseAvailable(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0015
            boolean r14 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r14 == 0) goto L_0x0014
            java.lang.String r14 = "CampaignTable"
            java.lang.String r15 = "find: database is not available"
            com.mbridge.msdk.foundation.tools.af.b(r14, r15)
        L_0x0014:
            return r1
        L_0x0015:
            java.lang.Object r2 = r13.f10880b
            monitor-enter(r2)
            java.lang.String r7 = java.lang.String.valueOf(r17)     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            java.lang.String r5 = r0.k()     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            boolean r0 = android.text.TextUtils.isEmpty(r19)     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            r6 = 3
            if (r0 == 0) goto L_0x0053
            java.lang.String r0 = "ad_type=? and app_id=? and placement_id=? and unit_id=? and header_bidding=? and state=? and invalid_time>?"
            r8 = r3
            java.lang.String r3 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            r9 = r8
            java.lang.String r8 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            r6 = r16
            r4 = r5
            r5 = r15
            java.lang.String[] r14 = new java.lang.String[]{r3, r4, r5, r6, r7, r8, r9}     // Catch:{ Exception -> 0x004e, all -> 0x004a }
        L_0x0047:
            r7 = r14
            r6 = r0
            goto L_0x0071
        L_0x004a:
            r0 = move-exception
            r14 = r0
            goto L_0x00ca
        L_0x004e:
            r0 = move-exception
            r14 = r0
            r15 = r1
            goto L_0x00b5
        L_0x0053:
            r9 = r3
            r4 = r5
            java.lang.String r0 = "local_id=? and ad_type=? and app_id=? and placement_id=? and unit_id=? and header_bidding=? and state=? and invalid_time>?"
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            java.lang.String r10 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            r6 = r15
            r9 = r3
            r5 = r4
            r8 = r7
            r4 = r14
            r7 = r16
            r3 = r19
            java.lang.String[] r14 = new java.lang.String[]{r3, r4, r5, r6, r7, r8, r9, r10}     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            goto L_0x0047
        L_0x0071:
            java.lang.String r10 = "load_start_time desc"
            android.database.sqlite.SQLiteDatabase r3 = r13.f10879a     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            java.lang.String r4 = "campaign"
            if (r18 > 0) goto L_0x007d
            r14 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x007f
        L_0x007d:
            r14 = r18
        L_0x007f:
            java.lang.String r11 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            r5 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r14 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            java.util.List r15 = a((android.database.Cursor) r14)     // Catch:{ Exception -> 0x009c, all -> 0x0097 }
            if (r15 == 0) goto L_0x00a2
            int r0 = r15.size()     // Catch:{ Exception -> 0x009c, all -> 0x0097 }
            if (r0 != 0) goto L_0x00ad
            goto L_0x00a2
        L_0x0097:
            r0 = move-exception
            r15 = r0
            r1 = r14
            r14 = r15
            goto L_0x00ca
        L_0x009c:
            r0 = move-exception
            r15 = r0
            r12 = r15
            r15 = r14
            r14 = r12
            goto L_0x00b5
        L_0x00a2:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x009c, all -> 0x0097 }
            if (r0 == 0) goto L_0x00ad
            java.lang.String r0 = "CampaignTable"
            java.lang.String r3 = "find: mBridgeCampaigns is null or empty"
            com.mbridge.msdk.foundation.tools.af.b(r0, r3)     // Catch:{ Exception -> 0x009c, all -> 0x0097 }
        L_0x00ad:
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.closeCursor(r14)     // Catch:{ all -> 0x00b2 }
            monitor-exit(r2)     // Catch:{ all -> 0x00b2 }
            return r15
        L_0x00b2:
            r0 = move-exception
            r14 = r0
            goto L_0x00ce
        L_0x00b5:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x00c5
            java.lang.String r0 = "CampaignTable"
            java.lang.String r3 = "find: "
            com.mbridge.msdk.foundation.tools.af.b(r0, r3, r14)     // Catch:{ all -> 0x00c1 }
            goto L_0x00c5
        L_0x00c1:
            r0 = move-exception
            r14 = r0
            r1 = r15
            goto L_0x00ca
        L_0x00c5:
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.closeCursor(r15)     // Catch:{ all -> 0x00b2 }
            monitor-exit(r2)     // Catch:{ all -> 0x00b2 }
            return r1
        L_0x00ca:
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.closeCursor(r1)     // Catch:{ all -> 0x00b2 }
            throw r14     // Catch:{ all -> 0x00b2 }
        L_0x00ce:
            monitor-exit(r2)     // Catch:{ all -> 0x00b2 }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.d.a.a(int, java.lang.String, java.lang.String, boolean, int, java.lang.String):java.util.List");
    }

    public final void b(b bVar) {
        SQLiteDatabase sQLiteDatabase;
        if (bVar != null) {
            List<com.mbridge.msdk.newreward.function.c.a.a> u5 = bVar.u();
            if (u5 == null || u5.isEmpty()) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CampaignTable", "insert: campaignList is null or empty");
                }
            } else if (DatabaseUtils.isDatabaseAvailable(this.f10879a)) {
                synchronized (this.f10880b) {
                    try {
                        DatabaseUtils.beginTransaction(this.f10879a);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("request_id", bVar.f());
                        contentValues.put("session_id", bVar.k());
                        contentValues.put("system_id", bVar.l());
                        contentValues.put("backup_id", bVar.m());
                        contentValues.put(MRAIDCommunicatorUtil.KEY_STATE, Integer.valueOf(bVar.j()));
                        contentValues.put("template", Integer.valueOf(bVar.o()));
                        contentValues.put("invalid_time", Long.valueOf(bVar.p()));
                        contentValues.put("invalid_time_2", Long.valueOf(bVar.q()));
                        contentValues.put("invalid_time_backup", Long.valueOf(bVar.r()));
                        contentValues.put("show_count", Integer.valueOf(bVar.t()));
                        contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_PARENT_SESSION_ID, bVar.n());
                        contentValues.put("token_rule", Integer.valueOf(bVar.G()));
                        contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(bVar.b()));
                        contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(bVar.a()));
                        contentValues.put(DataSchemeDataSource.SCHEME_DATA, bVar.v().toString());
                        long update = (long) this.f10879a.update("campaign", contentValues, "ad_type=? and app_id=? and placement_id=? and unit_id=? and local_id=?", new String[]{String.valueOf(bVar.c()), c.m().k(), bVar.d(), bVar.e(), bVar.g()});
                        if (MBridgeConstans.DEBUG) {
                            af.a("CampaignTable", "updateCampaign result:  " + update);
                        }
                        DatabaseUtils.setTransactionSuccessful(this.f10879a);
                        sQLiteDatabase = this.f10879a;
                    } catch (Exception e5) {
                        try {
                            if (MBridgeConstans.DEBUG) {
                                af.b("CampaignTable", "updateCampaign: ", e5);
                            }
                            sQLiteDatabase = this.f10879a;
                        } catch (Throwable th) {
                            DatabaseUtils.endTransaction(this.f10879a);
                            throw th;
                        }
                    }
                    DatabaseUtils.endTransaction(sQLiteDatabase);
                }
            } else if (MBridgeConstans.DEBUG) {
                af.b("CampaignTable", "insert: database is not available");
            }
        } else if (MBridgeConstans.DEBUG) {
            af.b("CampaignTable", "insert: mBridgeCampaigns is null");
        }
    }

    public final void a(int i5, String str, String str2, String str3, int i6) {
        MBridgeTaskManager.campaignTableExecute(b(i5, str, str2, str3, i6, (b) null));
    }

    public final void a(int i5, String str, String str2, String str3, int i6, b bVar) {
        MBridgeTaskManager.campaignTableExecute(b(i5, str, str2, str3, i6, bVar));
    }

    private static String a() {
        return "ad_type=? and app_id=? and placement_id=? and unit_id=? and (state in " + "(6,402,406,403,8,7)" + " or " + "invalid_time" + "<? )";
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.mbridge.msdk.newreward.function.c.a.b> a(android.database.Cursor r32) {
        /*
            r0 = r32
            if (r0 == 0) goto L_0x000a
            int r2 = r0.getCount()
            if (r2 > 0) goto L_0x000e
        L_0x000a:
            r16 = 0
            goto L_0x01ef
        L_0x000e:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x01e1 }
            r2.<init>()     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r3 = "ad_type"
            int r3 = r0.getColumnIndex(r3)     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r4 = "app_id"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r5 = "placement_id"
            int r5 = r0.getColumnIndex(r5)     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r6 = "unit_id"
            int r6 = r0.getColumnIndex(r6)     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r7 = "request_id"
            int r7 = r0.getColumnIndex(r7)     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r8 = "local_id"
            int r8 = r0.getColumnIndex(r8)     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r9 = "bid_token"
            int r9 = r0.getColumnIndex(r9)     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r10 = "header_bidding"
            int r10 = r0.getColumnIndex(r10)     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r11 = "load_start_time"
            int r11 = r0.getColumnIndex(r11)     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r12 = "backup_id"
            int r12 = r0.getColumnIndex(r12)     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r13 = "state"
            int r13 = r0.getColumnIndex(r13)     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r14 = "template"
            int r14 = r0.getColumnIndex(r14)     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r15 = "invalid_time"
            int r15 = r0.getColumnIndex(r15)     // Catch:{ Exception -> 0x01e1 }
            r16 = 0
            java.lang.String r1 = "invalid_time_2"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ Exception -> 0x01de }
            r17 = r2
            java.lang.String r2 = "invalid_time_backup"
            int r2 = r0.getColumnIndex(r2)     // Catch:{ Exception -> 0x01de }
            r18 = r2
            java.lang.String r2 = "ecppv"
            int r2 = r0.getColumnIndex(r2)     // Catch:{ Exception -> 0x01de }
            r19 = r2
            java.lang.String r2 = "session_id"
            int r2 = r0.getColumnIndex(r2)     // Catch:{ Exception -> 0x01de }
            r20 = r1
            java.lang.String r1 = "system_id"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ Exception -> 0x01de }
            r21 = r15
            java.lang.String r15 = "show_count"
            int r15 = r0.getColumnIndex(r15)     // Catch:{ Exception -> 0x01de }
            r22 = r15
            java.lang.String r15 = "parent_session_id"
            int r15 = r0.getColumnIndex(r15)     // Catch:{ Exception -> 0x01de }
            r23 = r15
            java.lang.String r15 = "data"
            int r15 = r0.getColumnIndex(r15)     // Catch:{ Exception -> 0x01de }
            r24 = r15
            java.lang.String r15 = "token_rule"
            int r15 = r0.getColumnIndex(r15)     // Catch:{ Exception -> 0x01de }
            r25 = r15
            java.lang.String r15 = "s_show_index"
            int r15 = r0.getColumnIndex(r15)     // Catch:{ Exception -> 0x01de }
            r26 = r15
            java.lang.String r15 = "r_index"
            int r15 = r0.getColumnIndex(r15)     // Catch:{ Exception -> 0x01de }
        L_0x00b9:
            boolean r27 = r0.moveToNext()     // Catch:{ Exception -> 0x01de }
            if (r27 == 0) goto L_0x01e0
            r27 = r15
            int r15 = r0.getInt(r3)     // Catch:{ Exception -> 0x01de }
            r28 = r3
            java.lang.String r3 = r0.getString(r4)     // Catch:{ Exception -> 0x01de }
            r29 = r4
            java.lang.String r4 = r0.getString(r5)     // Catch:{ Exception -> 0x01de }
            r30 = r5
            java.lang.String r5 = r0.getString(r6)     // Catch:{ Exception -> 0x01de }
            r31 = r6
            com.mbridge.msdk.newreward.function.c.a.b r6 = new com.mbridge.msdk.newreward.function.c.a.b     // Catch:{ Exception -> 0x01de }
            r6.<init>(r15, r3, r4, r5)     // Catch:{ Exception -> 0x01de }
            java.lang.String r3 = r0.getString(r7)     // Catch:{ Exception -> 0x01de }
            r6.a((java.lang.String) r3)     // Catch:{ Exception -> 0x01de }
            java.lang.String r3 = r0.getString(r8)     // Catch:{ Exception -> 0x01de }
            r6.b((java.lang.String) r3)     // Catch:{ Exception -> 0x01de }
            java.lang.String r3 = r0.getString(r9)     // Catch:{ Exception -> 0x01de }
            r6.c((java.lang.String) r3)     // Catch:{ Exception -> 0x01de }
            int r4 = r0.getInt(r10)     // Catch:{ Exception -> 0x01de }
            r5 = 1
            if (r4 != r5) goto L_0x00fb
            goto L_0x00fc
        L_0x00fb:
            r5 = 0
        L_0x00fc:
            r6.a((boolean) r5)     // Catch:{ Exception -> 0x01de }
            long r4 = r0.getLong(r11)     // Catch:{ Exception -> 0x01de }
            r6.e((long) r4)     // Catch:{ Exception -> 0x01de }
            java.lang.String r4 = r0.getString(r2)     // Catch:{ Exception -> 0x01de }
            r6.d((java.lang.String) r4)     // Catch:{ Exception -> 0x01de }
            java.lang.String r4 = r0.getString(r1)     // Catch:{ Exception -> 0x01de }
            r6.e((java.lang.String) r4)     // Catch:{ Exception -> 0x01de }
            java.lang.String r4 = r0.getString(r12)     // Catch:{ Exception -> 0x01de }
            r6.f((java.lang.String) r4)     // Catch:{ Exception -> 0x01de }
            int r4 = r0.getInt(r13)     // Catch:{ Exception -> 0x01de }
            r6.c((int) r4)     // Catch:{ Exception -> 0x01de }
            int r4 = r0.getInt(r14)     // Catch:{ Exception -> 0x01de }
            r6.d((int) r4)     // Catch:{ Exception -> 0x01de }
            r15 = r1
            r5 = r2
            r4 = r21
            long r1 = r0.getLong(r4)     // Catch:{ Exception -> 0x01de }
            r6.b((long) r1)     // Catch:{ Exception -> 0x01de }
            r21 = r4
            r2 = r5
            r1 = r20
            long r4 = r0.getLong(r1)     // Catch:{ Exception -> 0x01de }
            r6.c((long) r4)     // Catch:{ Exception -> 0x01de }
            r20 = r1
            r5 = r2
            r4 = r18
            long r1 = r0.getLong(r4)     // Catch:{ Exception -> 0x01de }
            r6.d((long) r1)     // Catch:{ Exception -> 0x01de }
            r18 = r4
            r2 = r5
            r1 = r19
            double r4 = r0.getDouble(r1)     // Catch:{ Exception -> 0x01de }
            r6.a((double) r4)     // Catch:{ Exception -> 0x01de }
            r4 = r22
            int r5 = r0.getInt(r4)     // Catch:{ Exception -> 0x01de }
            r6.e((int) r5)     // Catch:{ Exception -> 0x01de }
            r19 = r1
            r5 = r23
            java.lang.String r1 = r0.getString(r5)     // Catch:{ Exception -> 0x01de }
            r6.g((java.lang.String) r1)     // Catch:{ Exception -> 0x01de }
            r22 = r2
            r1 = r25
            int r2 = r0.getInt(r1)     // Catch:{ Exception -> 0x01de }
            r6.k(r2)     // Catch:{ Exception -> 0x01de }
            r25 = r1
            r2 = r26
            int r1 = r0.getInt(r2)     // Catch:{ Exception -> 0x01de }
            r6.b((int) r1)     // Catch:{ Exception -> 0x01de }
            r26 = r2
            r1 = r27
            int r2 = r0.getInt(r1)     // Catch:{ Exception -> 0x01de }
            r6.a((int) r2)     // Catch:{ Exception -> 0x01de }
            r2 = r24
            java.lang.String r23 = r0.getString(r2)     // Catch:{ Exception -> 0x01de }
            org.json.JSONObject r0 = com.mbridge.msdk.newreward.function.common.JSONUtils.parse(r23)     // Catch:{ Exception -> 0x01de }
            r6.a((org.json.JSONObject) r0)     // Catch:{ Exception -> 0x01de }
            r27 = r1
            r1 = r17
            r1.add(r6)     // Catch:{ Exception -> 0x01de }
            com.mbridge.msdk.foundation.entity.CampaignUnit r0 = com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(r0, r3)     // Catch:{ Exception -> 0x01de }
            if (r0 != 0) goto L_0x01c0
        L_0x01a7:
            r0 = r32
            r17 = r1
        L_0x01ab:
            r24 = r2
            r23 = r5
            r1 = r15
            r2 = r22
            r15 = r27
            r3 = r28
            r5 = r30
            r6 = r31
            r22 = r4
            r4 = r29
            goto L_0x00b9
        L_0x01c0:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x01de }
            r3.<init>()     // Catch:{ Exception -> 0x01de }
            java.util.ArrayList r0 = r0.getAds()     // Catch:{ Exception -> 0x01de }
            if (r0 != 0) goto L_0x01cc
            goto L_0x01a7
        L_0x01cc:
            r17 = r1
            java.lang.String r1 = r6.g()     // Catch:{ Exception -> 0x01de }
            com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon.handlerCampaigns(r1, r6, r0, r3)     // Catch:{ Exception -> 0x01de }
            r6.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r0)     // Catch:{ Exception -> 0x01de }
            r6.a((java.util.List<com.mbridge.msdk.newreward.function.c.a.a>) r3)     // Catch:{ Exception -> 0x01de }
            r0 = r32
            goto L_0x01ab
        L_0x01de:
            r0 = move-exception
            goto L_0x01e4
        L_0x01e0:
            return r17
        L_0x01e1:
            r0 = move-exception
            r16 = 0
        L_0x01e4:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x01ef
            java.lang.String r1 = "CampaignTable"
            java.lang.String r2 = "parseCampaignTable: "
            com.mbridge.msdk.foundation.tools.af.b(r1, r2, r0)
        L_0x01ef:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.d.a.a(android.database.Cursor):java.util.List");
    }

    private Runnable b(int i5, String str, String str2, String str3, int i6, b bVar) {
        final int i7 = i5;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final int i8 = i6;
        final b bVar2 = bVar;
        return new Runnable() {
            public final void run() {
                b bVar = bVar2;
                if (bVar != null) {
                    List<b> a5 = a.this.a(bVar.c(), bVar2.d(), bVar2.e(), bVar2.i(), 0, bVar2.g());
                    if (bVar2.a() > 0 && a5 != null && !a5.isEmpty()) {
                        return;
                    }
                    if (bVar2.a() != 0 || a5 == null || a5.isEmpty() || a5.get(0).t() <= 0) {
                        a.this.b(i7, str4, str5, str6, i8);
                        return;
                    }
                    return;
                }
                a.this.b(i7, str4, str5, str6, i8);
            }
        };
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(int r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, int r8) {
        /*
            r3 = this;
            android.database.sqlite.SQLiteDatabase r0 = r3.f10879a
            boolean r0 = com.mbridge.msdk.newreward.function.common.DatabaseUtils.isDatabaseAvailable(r0)
            if (r0 != 0) goto L_0x0014
            boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r4 == 0) goto L_0x007f
            java.lang.String r4 = "CampaignTable"
            java.lang.String r5 = "updateState: database is not available"
            com.mbridge.msdk.foundation.tools.af.b(r4, r5)
            return
        L_0x0014:
            java.lang.Object r0 = r3.f10880b
            monitor-enter(r0)
            android.database.sqlite.SQLiteDatabase r1 = r3.f10879a     // Catch:{ Exception -> 0x0061 }
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.beginTransaction(r1)     // Catch:{ Exception -> 0x0061 }
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ Exception -> 0x0061 }
            r1.<init>()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r2 = "state"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0061 }
            r1.put(r2, r8)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r8 = "ad_type=? and app_id=? and placement_id=? and unit_id=? and local_id=?"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0061 }
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r2 = r2.k()     // Catch:{ Exception -> 0x0061 }
            java.lang.String[] r4 = new java.lang.String[]{r4, r2, r5, r6, r7}     // Catch:{ Exception -> 0x0061 }
            android.database.sqlite.SQLiteDatabase r5 = r3.f10879a     // Catch:{ Exception -> 0x0061 }
            java.lang.String r6 = "campaign"
            int r4 = r5.update(r6, r1, r8, r4)     // Catch:{ Exception -> 0x0061 }
            boolean r5 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0061 }
            if (r5 == 0) goto L_0x0063
            java.lang.String r5 = "CampaignTable"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0061 }
            r6.<init>()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r7 = "updateState result:  "
            r6.append(r7)     // Catch:{ Exception -> 0x0061 }
            r6.append(r4)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x0061 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r5, (java.lang.String) r4)     // Catch:{ Exception -> 0x0061 }
            goto L_0x0063
        L_0x005f:
            r4 = move-exception
            goto L_0x0080
        L_0x0061:
            r4 = move-exception
            goto L_0x0070
        L_0x0063:
            android.database.sqlite.SQLiteDatabase r4 = r3.f10879a     // Catch:{ Exception -> 0x0061 }
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.setTransactionSuccessful(r4)     // Catch:{ Exception -> 0x0061 }
            android.database.sqlite.SQLiteDatabase r4 = r3.f10879a     // Catch:{ all -> 0x006e }
        L_0x006a:
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.endTransaction(r4)     // Catch:{ all -> 0x006e }
            goto L_0x007e
        L_0x006e:
            r4 = move-exception
            goto L_0x0086
        L_0x0070:
            boolean r5 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x005f }
            if (r5 == 0) goto L_0x007b
            java.lang.String r5 = "CampaignTable"
            java.lang.String r6 = "updateState: "
            com.mbridge.msdk.foundation.tools.af.b(r5, r6, r4)     // Catch:{ all -> 0x005f }
        L_0x007b:
            android.database.sqlite.SQLiteDatabase r4 = r3.f10879a     // Catch:{ all -> 0x006e }
            goto L_0x006a
        L_0x007e:
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
        L_0x007f:
            return
        L_0x0080:
            android.database.sqlite.SQLiteDatabase r5 = r3.f10879a     // Catch:{ all -> 0x006e }
            com.mbridge.msdk.newreward.function.common.DatabaseUtils.endTransaction(r5)     // Catch:{ all -> 0x006e }
            throw r4     // Catch:{ all -> 0x006e }
        L_0x0086:
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.d.a.b(int, java.lang.String, java.lang.String, java.lang.String, int):void");
    }

    public final void b(final int i5, final String str, final String str2) {
        MBridgeTaskManager.campaignTableExecute(new Runnable() {
            public final void run() {
                a.this.c(i5, str, str2);
            }
        });
    }

    public final void a(int i5, String str, String str2, String str3, boolean z4, String str4, long j5) {
        final int i6 = i5;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final boolean z5 = z4;
        final String str8 = str4;
        final long j6 = j5;
        MBridgeTaskManager.campaignTableExecute(new Runnable() {
            public final void run() {
                a.this.b(i6, str5, str6, str7, z5, str8, j6);
            }
        });
    }

    public final void a(int i5, String str, String str2, boolean z4, int i6, b bVar) {
        final int i7 = i5;
        final String str3 = str;
        final String str4 = str2;
        final boolean z5 = z4;
        final int i8 = i6;
        final b bVar2 = bVar;
        MBridgeTaskManager.campaignTableExecute(new Runnable() {
            public final void run() {
                List<b> a5 = a.this.a(i7, str3, str4, z5, i8, "");
                if (a5 == null || a5.size() == 0) {
                    b bVar = bVar2;
                    if (bVar != null) {
                        bVar.a();
                        return;
                    }
                    return;
                }
                b bVar2 = bVar2;
                if (bVar2 != null) {
                    bVar2.a(a5);
                }
            }
        });
    }

    public final void a(final int i5, final String str, final String str2) {
        MBridgeTaskManager.campaignTableExecute(new Runnable() {
            public final void run() {
                a.this.d(i5, str, str2);
            }
        });
    }
}
