package com.mbridge.msdk.tracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.work.PeriodicWorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.List;

final class y {
    public static long a(int i5, long j5, long j6) {
        if (i5 <= 0 || j5 == 0 || i5 <= 10) {
            return j6;
        }
        if (i5 <= 20) {
            return ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
        }
        if (i5 <= 30) {
            return 120000;
        }
        if (i5 <= 40) {
            return 180000;
        }
        if (i5 <= 50) {
            return 240000;
        }
        return PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    }

    static boolean b(Object obj) {
        return obj != null;
    }

    static boolean a(Object obj) {
        return obj == null;
    }

    static boolean b(List<i> list) {
        if (a((List<?>) list)) {
            return false;
        }
        for (i next : list) {
            if (!a((Object) next)) {
                e c5 = next.c();
                if (!a((Object) c5) && c5.c() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean a(List<?> list) {
        return list == null || list.size() == 0;
    }

    static void a(Cursor cursor) {
        try {
            if (b((Object) cursor) && !cursor.isClosed()) {
                cursor.close();
            }
        } catch (Exception unused) {
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null) {
            return true;
        }
        NetworkInfo networkInfo = null;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception unused) {
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            return true;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused2) {
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c6 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.List<com.mbridge.msdk.tracker.i> b(android.database.Cursor r18) {
        /*
            r1 = r18
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r0 = "name"
            int r3 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00de }
            java.lang.String r0 = "type"
            int r4 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00de }
            java.lang.String r0 = "time_stamp"
            int r5 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00de }
            java.lang.String r0 = "properties"
            int r6 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00de }
            java.lang.String r0 = "priority"
            int r7 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00de }
            java.lang.String r0 = "uuid"
            int r8 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00de }
            java.lang.String r0 = "duration"
            int r9 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00de }
            java.lang.String r0 = "state"
            int r10 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00de }
            java.lang.String r0 = "report_count"
            int r11 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00de }
            java.lang.String r0 = "ignore_max_timeout"
            int r12 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00de }
            java.lang.String r0 = "ignore_max_retry_times"
            int r13 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00de }
            java.lang.String r0 = "invalid_time"
            int r14 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00de }
        L_0x004f:
            boolean r0 = r1.moveToNext()
            if (r0 == 0) goto L_0x00de
            java.lang.String r0 = r1.getString(r3)     // Catch:{ JSONException -> 0x00cd }
            com.mbridge.msdk.tracker.e r15 = new com.mbridge.msdk.tracker.e     // Catch:{ JSONException -> 0x00cd }
            r15.<init>(r0)     // Catch:{ JSONException -> 0x00cd }
            int r0 = r1.getInt(r4)     // Catch:{ JSONException -> 0x00cd }
            r15.a((int) r0)     // Catch:{ JSONException -> 0x00cd }
            r16 = r3
            r17 = r4
            long r3 = r1.getLong(r5)     // Catch:{ JSONException -> 0x00cb }
            r15.a((long) r3)     // Catch:{ JSONException -> 0x00cb }
            java.lang.String r0 = r1.getString(r6)     // Catch:{ JSONException -> 0x00cb }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00cb }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x00cb }
            r15.a((org.json.JSONObject) r3)     // Catch:{ JSONException -> 0x00cb }
            int r0 = r1.getInt(r7)     // Catch:{ JSONException -> 0x00cb }
            r15.b((int) r0)     // Catch:{ JSONException -> 0x00cb }
            java.lang.String r0 = r1.getString(r8)     // Catch:{ JSONException -> 0x00cb }
            r15.a((java.lang.String) r0)     // Catch:{ JSONException -> 0x00cb }
            long r3 = r1.getLong(r9)     // Catch:{ JSONException -> 0x00cb }
            r15.b((long) r3)     // Catch:{ JSONException -> 0x00cb }
            com.mbridge.msdk.tracker.i r0 = new com.mbridge.msdk.tracker.i     // Catch:{ JSONException -> 0x00cb }
            r0.<init>(r15)     // Catch:{ JSONException -> 0x00cb }
            int r3 = r1.getInt(r10)     // Catch:{ JSONException -> 0x00cb }
            r0.b((int) r3)     // Catch:{ JSONException -> 0x00cb }
            int r3 = r1.getInt(r11)     // Catch:{ JSONException -> 0x00cb }
            r0.a((int) r3)     // Catch:{ JSONException -> 0x00cb }
            int r3 = r1.getInt(r12)     // Catch:{ JSONException -> 0x00cb }
            r4 = 0
            r15 = 1
            if (r3 != 0) goto L_0x00ae
            r3 = r15
            goto L_0x00af
        L_0x00ae:
            r3 = r4
        L_0x00af:
            r0.a((boolean) r3)     // Catch:{ JSONException -> 0x00cb }
            int r3 = r1.getInt(r13)     // Catch:{ JSONException -> 0x00cb }
            if (r3 != 0) goto L_0x00b9
            r4 = r15
        L_0x00b9:
            r0.b((boolean) r4)     // Catch:{ JSONException -> 0x00cb }
            long r3 = r1.getLong(r14)     // Catch:{ JSONException -> 0x00cb }
            r0.a((long) r3)     // Catch:{ JSONException -> 0x00cb }
            r2.add(r0)     // Catch:{ JSONException -> 0x00cb }
        L_0x00c6:
            r3 = r16
            r4 = r17
            goto L_0x004f
        L_0x00cb:
            r0 = move-exception
            goto L_0x00d2
        L_0x00cd:
            r0 = move-exception
            r16 = r3
            r17 = r4
        L_0x00d2:
            boolean r3 = com.mbridge.msdk.tracker.a.f11490a
            if (r3 == 0) goto L_0x00c6
            java.lang.String r3 = "TrackManager"
            java.lang.String r4 = "create: "
            android.util.Log.e(r3, r4, r0)
            goto L_0x00c6
        L_0x00de:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.tracker.y.b(android.database.Cursor):java.util.List");
    }
}
