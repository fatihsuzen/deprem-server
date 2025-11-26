package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ap;
import java.net.URLEncoder;

public class o extends a<n> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8985a = "com.mbridge.msdk.foundation.db.o";

    /* renamed from: b  reason: collision with root package name */
    private static o f8986b;

    private o(f fVar) {
        super(fVar);
    }

    public static o a(f fVar) {
        if (f8986b == null) {
            synchronized (o.class) {
                try {
                    if (f8986b == null) {
                        f8986b = new o(fVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8986b;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r1 != 0) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        if (r1 == 0) goto L_0x002c;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0033 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int a() {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            r1 = 0
            java.lang.String r2 = "select count(*) from reward_report"
            android.database.sqlite.SQLiteDatabase r3 = r4.getReadableDatabase()     // Catch:{ Exception -> 0x001c }
            android.database.Cursor r1 = r3.rawQuery(r2, r1)     // Catch:{ Exception -> 0x001c }
            if (r1 == 0) goto L_0x001e
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x001c }
            if (r2 == 0) goto L_0x001e
            int r0 = r1.getInt(r0)     // Catch:{ Exception -> 0x001c }
            goto L_0x001e
        L_0x001a:
            r0 = move-exception
            goto L_0x002e
        L_0x001c:
            r2 = move-exception
            goto L_0x0026
        L_0x001e:
            if (r1 == 0) goto L_0x002c
        L_0x0020:
            r1.close()     // Catch:{ Exception -> 0x002c }
            goto L_0x002c
        L_0x0024:
            r0 = move-exception
            goto L_0x0034
        L_0x0026:
            r2.printStackTrace()     // Catch:{ all -> 0x001a }
            if (r1 == 0) goto L_0x002c
            goto L_0x0020
        L_0x002c:
            monitor-exit(r4)
            return r0
        L_0x002e:
            if (r1 == 0) goto L_0x0033
            r1.close()     // Catch:{ Exception -> 0x0033 }
        L_0x0033:
            throw r0     // Catch:{ all -> 0x0024 }
        L_0x0034:
            monitor-exit(r4)     // Catch:{ all -> 0x0024 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.o.a():int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: android.database.Cursor} */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:22|23|(2:129|130)|131|132) */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0306, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0307, code lost:
        r4 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x030d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x030e, code lost:
        r4 = r10;
        r21 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:131:0x0347 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0306 A[ExcHandler: all (th java.lang.Throwable), PHI: r10 
      PHI: (r10v4 android.database.Cursor) = (r10v3 android.database.Cursor), (r10v5 android.database.Cursor), (r10v5 android.database.Cursor), (r10v5 android.database.Cursor), (r10v5 android.database.Cursor), (r10v5 android.database.Cursor), (r10v5 android.database.Cursor) binds: [B:8:0x0021, B:16:0x00f2, B:26:0x0139, B:34:0x016d, B:40:0x017b, B:46:0x018f, B:53:0x01a7] A[DONT_GENERATE, DONT_INLINE], Splitter:B:8:0x0021] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x033e A[SYNTHETIC, Splitter:B:126:0x033e] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0344 A[SYNTHETIC, Splitter:B:129:0x0344] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02d0 A[Catch:{ Exception -> 0x0258, all -> 0x0254 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02d6 A[Catch:{ Exception -> 0x0258, all -> 0x0254 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.n> a(java.lang.String r25) {
        /*
            r24 = this;
            r1 = r25
            monitor-enter(r24)
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0318 }
            if (r0 != 0) goto L_0x0348
            android.database.sqlite.SQLiteDatabase r10 = r24.getReadableDatabase()     // Catch:{ Exception -> 0x032b, all -> 0x0325 }
            java.lang.String r11 = "reward_report"
            java.lang.String r13 = "key=?"
            java.lang.String[] r14 = new java.lang.String[]{r1}     // Catch:{ Exception -> 0x032b, all -> 0x0325 }
            r16 = 0
            r17 = 0
            r12 = 0
            r15 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x032b, all -> 0x0325 }
            if (r10 == 0) goto L_0x031c
            int r0 = r10.getCount()     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            if (r0 <= 0) goto L_0x031c
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            r11.<init>()     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
        L_0x002c:
            boolean r0 = r10.moveToNext()     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            if (r0 == 0) goto L_0x0312
            java.lang.String r0 = "key"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r3 = r10.getString(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r0 = "networkType"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            int r14 = r10.getInt(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r0 = "network_str"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r20 = r10.getString(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r0 = "isCompleteView"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            r10.getInt(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r0 = "watchedMillis"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            r10.getInt(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r0 = "videoLength"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            int r15 = r10.getInt(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r0 = "offerUrl"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r16 = r10.getString(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r0 = "reason"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r6 = r10.getString(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r0 = "result"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            int r17 = r10.getInt(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r0 = "duration"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r18 = r10.getString(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r0 = "videoSize"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            int r19 = r10.getInt(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r0 = "campaignId"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r0 = r10.getString(r0)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r2 = "video_url"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r8 = r10.getString(r2)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r2 = "unitId"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r12 = r10.getString(r2)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r2 = "rid"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r13 = r10.getString(r2)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r2 = "rid_n"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r2 = r10.getString(r2)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r4 = "ad_type"
            int r4 = r10.getColumnIndex(r4)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r4 = r10.getString(r4)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r5 = "resource_type"
            int r5 = r10.getColumnIndex(r5)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r5 = r10.getString(r5)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r7 = "device_id"
            int r7 = r10.getColumnIndex(r7)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            java.lang.String r7 = r10.getString(r7)     // Catch:{ Exception -> 0x030d, all -> 0x0306 }
            r21 = 0
            java.lang.String r9 = "creative"
            int r9 = r10.getColumnIndex(r9)     // Catch:{ Exception -> 0x030a, all -> 0x0306 }
            java.lang.String r9 = r10.getString(r9)     // Catch:{ Exception -> 0x030a, all -> 0x0306 }
            r22 = r2
            java.lang.String r2 = "adspace_t"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ Exception -> 0x030a, all -> 0x0306 }
            int r2 = r10.getInt(r2)     // Catch:{ Exception -> 0x030a, all -> 0x0306 }
            r23 = r2
            java.lang.String r2 = "2000021"
            boolean r2 = r1.equals(r2)     // Catch:{ Exception -> 0x030a, all -> 0x0306 }
            if (r2 == 0) goto L_0x0137
            com.mbridge.msdk.foundation.entity.n r2 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x0134 }
            r4 = r14
            r5 = r16
            r7 = r20
            r14 = r22
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0134 }
            r2.e((java.lang.String) r0)     // Catch:{ Exception -> 0x0134 }
            r2.m(r8)     // Catch:{ Exception -> 0x0134 }
            r2.f(r13)     // Catch:{ Exception -> 0x0134 }
            r2.g(r14)     // Catch:{ Exception -> 0x0134 }
            r2.c((java.lang.String) r12)     // Catch:{ Exception -> 0x0134 }
        L_0x012b:
            r4 = r10
            r16 = r11
            goto L_0x02ce
        L_0x0130:
            r0 = move-exception
            r9 = r10
            goto L_0x0342
        L_0x0134:
            r0 = move-exception
            goto L_0x0330
        L_0x0137:
            java.lang.String r2 = "2000022"
            boolean r2 = r1.equals(r2)     // Catch:{ Exception -> 0x030a, all -> 0x0306 }
            if (r2 == 0) goto L_0x0165
            r2 = r12
            com.mbridge.msdk.foundation.entity.n r12 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x0134 }
            r5 = r13
            r13 = r3
            r3 = r5
            r5 = r22
            r12.<init>((java.lang.String) r13, (int) r14, (int) r15, (java.lang.String) r16, (int) r17, (java.lang.String) r18, (int) r19, (java.lang.String) r20)     // Catch:{ Exception -> 0x0134 }
            r12.e((java.lang.String) r0)     // Catch:{ Exception -> 0x0134 }
            r12.m(r8)     // Catch:{ Exception -> 0x0134 }
            r12.f(r3)     // Catch:{ Exception -> 0x0134 }
            r12.c((java.lang.String) r2)     // Catch:{ Exception -> 0x0134 }
            r12.h(r6)     // Catch:{ Exception -> 0x0134 }
            r12.g(r5)     // Catch:{ Exception -> 0x0134 }
            r12.d((java.lang.String) r4)     // Catch:{ Exception -> 0x0134 }
        L_0x015f:
            r4 = r10
            r16 = r11
            r2 = r12
            goto L_0x02ce
        L_0x0165:
            r2 = r13
            r13 = r3
            r3 = r2
            r2 = r12
            r12 = r22
            java.lang.String r8 = "2000025"
            boolean r8 = r1.equals(r8)     // Catch:{ Exception -> 0x030a, all -> 0x0306 }
            if (r8 == 0) goto L_0x0179
            com.mbridge.msdk.foundation.entity.n r12 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x0134 }
            r12.<init>((java.lang.String) r13, (int) r14, (int) r15, (java.lang.String) r16, (int) r17, (java.lang.String) r18, (int) r19, (java.lang.String) r20)     // Catch:{ Exception -> 0x0134 }
            goto L_0x015f
        L_0x0179:
            java.lang.String r8 = "2000024"
            boolean r8 = r1.equals(r8)     // Catch:{ Exception -> 0x030a, all -> 0x0306 }
            if (r8 == 0) goto L_0x018d
            com.mbridge.msdk.foundation.entity.n r2 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x0134 }
            r3 = r13
            r4 = r14
            r5 = r16
            r7 = r20
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0134 }
            goto L_0x012b
        L_0x018d:
            java.lang.String r8 = "2000039"
            boolean r8 = r8.equals(r1)     // Catch:{ Exception -> 0x030a, all -> 0x0306 }
            if (r8 == 0) goto L_0x01a5
            java.lang.String r0 = "h5_click_data"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x0134 }
            java.lang.String r0 = r10.getString(r0)     // Catch:{ Exception -> 0x0134 }
            com.mbridge.msdk.foundation.entity.n r2 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x0134 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0134 }
            goto L_0x012b
        L_0x01a5:
            java.lang.String r8 = "2000043"
            boolean r8 = r8.equals(r1)     // Catch:{ Exception -> 0x030a, all -> 0x0306 }
            if (r8 == 0) goto L_0x020f
            java.lang.String r8 = "type"
            int r8 = r10.getColumnIndex(r8)     // Catch:{ Exception -> 0x020a, all -> 0x0206 }
            java.lang.String r8 = r10.getString(r8)     // Catch:{ Exception -> 0x020a, all -> 0x0206 }
            java.lang.String r13 = "endcard_url"
            int r13 = r10.getColumnIndex(r13)     // Catch:{ Exception -> 0x020a, all -> 0x0206 }
            java.lang.String r13 = r10.getString(r13)     // Catch:{ Exception -> 0x020a, all -> 0x0206 }
            r14 = r5
            r5 = r0
            com.mbridge.msdk.foundation.entity.n r0 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x020a, all -> 0x0206 }
            r15 = r4
            r16 = r11
            r4 = r13
            r13 = r3
            r11 = r7
            r3 = r18
            r7 = r6
            r6 = r2
            r2 = r17
            r17 = r10
            r10 = r23
            r0.<init>((java.lang.String) r1, (int) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x01ed, all -> 0x01e8 }
            r0.f(r13)     // Catch:{ Exception -> 0x01ed, all -> 0x01e8 }
            r0.g(r12)     // Catch:{ Exception -> 0x01ed, all -> 0x01e8 }
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01ed, all -> 0x01e8 }
            if (r2 != 0) goto L_0x01f2
            r0.e((java.lang.String) r5)     // Catch:{ Exception -> 0x01ed, all -> 0x01e8 }
            goto L_0x01f2
        L_0x01e8:
            r0 = move-exception
        L_0x01e9:
            r9 = r17
            goto L_0x0342
        L_0x01ed:
            r0 = move-exception
            r10 = r17
            goto L_0x0330
        L_0x01f2:
            r0.c((int) r10)     // Catch:{ Exception -> 0x01ed, all -> 0x01e8 }
            r0.d((java.lang.String) r15)     // Catch:{ Exception -> 0x01ed, all -> 0x01e8 }
            r0.b((java.lang.String) r14)     // Catch:{ Exception -> 0x01ed, all -> 0x01e8 }
            r0.j(r11)     // Catch:{ Exception -> 0x01ed, all -> 0x01e8 }
            r0.i(r9)     // Catch:{ Exception -> 0x01ed, all -> 0x01e8 }
            r2 = r0
            r4 = r17
            goto L_0x02ce
        L_0x0206:
            r0 = move-exception
            r17 = r10
            goto L_0x01e9
        L_0x020a:
            r0 = move-exception
            r17 = r10
            goto L_0x0330
        L_0x020f:
            r13 = r3
            r15 = r4
            r3 = r5
            r16 = r11
            r5 = r0
            r0 = r2
            r11 = r7
            r2 = r17
            r17 = r10
            r10 = r23
            java.lang.String r4 = "2000045"
            boolean r4 = r4.equals(r1)     // Catch:{ Exception -> 0x0260, all -> 0x025c }
            if (r4 == 0) goto L_0x0264
            com.mbridge.msdk.foundation.entity.n r3 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x0260, all -> 0x025c }
            r3.<init>()     // Catch:{ Exception -> 0x0260, all -> 0x025c }
            r3.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0260, all -> 0x025c }
            r3.a((int) r14)     // Catch:{ Exception -> 0x0260, all -> 0x025c }
            r3.b((int) r2)     // Catch:{ Exception -> 0x0260, all -> 0x025c }
            r3.e((java.lang.String) r5)     // Catch:{ Exception -> 0x0260, all -> 0x025c }
            java.lang.String r2 = "template_url"
            r4 = r17
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            java.lang.String r2 = r4.getString(r2)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r3.q(r2)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r3.h(r6)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r3.f(r13)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r3.g(r12)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r3.c((java.lang.String) r0)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r2 = r3
            goto L_0x02ce
        L_0x0254:
            r0 = move-exception
        L_0x0255:
            r9 = r4
            goto L_0x0342
        L_0x0258:
            r0 = move-exception
        L_0x0259:
            r10 = r4
            goto L_0x0330
        L_0x025c:
            r0 = move-exception
            r4 = r17
            goto L_0x0255
        L_0x0260:
            r0 = move-exception
            r4 = r17
            goto L_0x0259
        L_0x0264:
            r4 = r17
            java.lang.String r7 = "2000044"
            boolean r7 = r7.equals(r1)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            if (r7 == 0) goto L_0x0296
            com.mbridge.msdk.foundation.entity.n r2 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r2.<init>()     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r2.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r2.a((int) r14)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r2.e((java.lang.String) r5)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            java.lang.String r3 = "image_url"
            int r3 = r4.getColumnIndex(r3)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            java.lang.String r3 = r4.getString(r3)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r2.p(r3)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r2.h(r6)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r2.f(r13)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r2.g(r12)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r2.c((java.lang.String) r0)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            goto L_0x02ce
        L_0x0296:
            java.lang.String r7 = "2000054"
            boolean r7 = r7.equals(r1)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            if (r7 == 0) goto L_0x02cc
            com.mbridge.msdk.foundation.entity.n r7 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r7.<init>()     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r7.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r7.b((java.lang.String) r3)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r7.c((java.lang.String) r0)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r7.j(r11)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r7.d((java.lang.String) r15)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r7.e((java.lang.String) r5)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r7.f(r13)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r7.g(r12)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r7.b((int) r2)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r7.h(r6)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r7.a((int) r14)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r7.i(r9)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r7.c((int) r10)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r2 = r7
            goto L_0x02ce
        L_0x02cc:
            r2 = r21
        L_0x02ce:
            if (r2 == 0) goto L_0x02d6
            r0 = r16
            r0.add(r2)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            goto L_0x02d8
        L_0x02d6:
            r0 = r16
        L_0x02d8:
            java.lang.String r2 = "id"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            int r2 = r4.getInt(r2)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            android.database.sqlite.SQLiteDatabase r3 = r24.getWritableDatabase()     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            java.lang.String r5 = "reward_report"
            java.lang.String r6 = "id = ?"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r7.<init>()     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r7.append(r2)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            java.lang.String r2 = ""
            r7.append(r2)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            java.lang.String r2 = r7.toString()     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r3.delete(r5, r6, r2)     // Catch:{ Exception -> 0x0258, all -> 0x0254 }
            r11 = r0
            r10 = r4
            goto L_0x002c
        L_0x0306:
            r0 = move-exception
            r4 = r10
            goto L_0x0255
        L_0x030a:
            r0 = move-exception
            r4 = r10
            goto L_0x0330
        L_0x030d:
            r0 = move-exception
            r4 = r10
            r21 = 0
            goto L_0x0330
        L_0x0312:
            r4 = r10
            r0 = r11
            r4.close()     // Catch:{ Exception -> 0x031a }
            goto L_0x031a
        L_0x0318:
            r0 = move-exception
            goto L_0x034c
        L_0x031a:
            monitor-exit(r24)
            return r0
        L_0x031c:
            r4 = r10
            r21 = 0
            if (r4 == 0) goto L_0x034a
            r4.close()     // Catch:{ Exception -> 0x034a }
            goto L_0x034a
        L_0x0325:
            r0 = move-exception
            r21 = 0
            r9 = r21
            goto L_0x0342
        L_0x032b:
            r0 = move-exception
            r21 = 0
            r10 = r21
        L_0x0330:
            r0.printStackTrace()     // Catch:{ all -> 0x0130 }
            java.lang.String r1 = f8985a     // Catch:{ all -> 0x0130 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0130 }
            com.mbridge.msdk.foundation.tools.af.b(r1, r0)     // Catch:{ all -> 0x0130 }
            if (r10 == 0) goto L_0x034a
            r10.close()     // Catch:{ Exception -> 0x034a }
            goto L_0x034a
        L_0x0342:
            if (r9 == 0) goto L_0x0347
            r9.close()     // Catch:{ Exception -> 0x0347 }
        L_0x0347:
            throw r0     // Catch:{ all -> 0x0318 }
        L_0x0348:
            r21 = 0
        L_0x034a:
            monitor-exit(r24)
            return r21
        L_0x034c:
            monitor-exit(r24)     // Catch:{ all -> 0x0318 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.o.a(java.lang.String):java.util.List");
    }

    public final synchronized long a(n nVar) {
        if (nVar != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("key", nVar.a());
                contentValues.put("networkType", Integer.valueOf(nVar.k()));
                contentValues.put("network_str", nVar.l());
                contentValues.put("isCompleteView", Integer.valueOf(nVar.z()));
                contentValues.put("watchedMillis", Integer.valueOf(nVar.A()));
                contentValues.put("videoLength", Integer.valueOf(nVar.p()));
                if (!TextUtils.isEmpty(nVar.r())) {
                    contentValues.put("offerUrl", nVar.r());
                }
                if (!TextUtils.isEmpty(nVar.h())) {
                    contentValues.put("reason", URLEncoder.encode(nVar.h(), "utf-8"));
                }
                contentValues.put("result", Integer.valueOf(nVar.m()));
                contentValues.put(TypedValues.TransitionType.S_DURATION, nVar.n());
                contentValues.put("videoSize", Long.valueOf(nVar.o()));
                contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, nVar.t());
                String s5 = nVar.s();
                if (!TextUtils.isEmpty(s5)) {
                    contentValues.put(CampaignEx.ENDCARD_URL, s5);
                }
                String q5 = nVar.q();
                if (!TextUtils.isEmpty(q5)) {
                    contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, q5);
                }
                String f5 = nVar.f();
                if (!TextUtils.isEmpty(f5)) {
                    contentValues.put("rid", f5);
                }
                String g5 = nVar.g();
                if (!TextUtils.isEmpty(g5)) {
                    contentValues.put("rid_n", g5);
                }
                String D4 = nVar.D();
                if (!TextUtils.isEmpty(D4)) {
                    contentValues.put("template_url", D4);
                }
                String y4 = nVar.y();
                if (!TextUtils.isEmpty(y4)) {
                    contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, y4);
                }
                String d5 = nVar.d();
                if (!TextUtils.isEmpty(d5)) {
                    contentValues.put("ad_type", URLEncoder.encode(d5, "utf-8"));
                }
                contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, nVar.c());
                contentValues.put("campaignId", nVar.e());
                if ("2000039".equals(nVar.a())) {
                    String a5 = com.mbridge.msdk.foundation.same.report.n.a(nVar);
                    if (ap.b(a5)) {
                        contentValues.put("h5_click_data", a5);
                    }
                }
                String b5 = nVar.b();
                if (!TextUtils.isEmpty(b5)) {
                    contentValues.put("resource_type", URLEncoder.encode(b5, "utf-8"));
                }
                String j5 = nVar.j();
                if (!TextUtils.isEmpty(j5)) {
                    contentValues.put("device_id", URLEncoder.encode(j5, "utf-8"));
                }
                String i5 = nVar.i();
                if (!TextUtils.isEmpty(i5)) {
                    contentValues.put("creative", URLEncoder.encode(i5, "utf-8"));
                }
                contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(nVar.u()));
                return getWritableDatabase().insert("reward_report", (String) null, contentValues);
            } catch (Exception e5) {
                af.b(f8985a, e5.getMessage());
            } catch (Throwable th) {
                throw th;
            }
        }
        return -1;
    }
}
