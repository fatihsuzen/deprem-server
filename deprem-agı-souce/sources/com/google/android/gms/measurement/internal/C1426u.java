package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.C1051a3;
import com.google.android.gms.internal.measurement.C1145k7;
import com.google.android.gms.internal.measurement.L6;
import com.google.android.gms.internal.measurement.O2;
import com.google.android.gms.internal.measurement.V2;
import com.google.android.gms.internal.measurement.Y2;
import com.google.android.gms.internal.measurement.Z2;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import f0.C1643K;
import f0.C1648c;
import f0.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.u  reason: case insensitive filesystem */
final class C1426u extends C1292b6 {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f6749f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* renamed from: g  reason: collision with root package name */
    static final String[] f6750g = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f6751h = {TtmlNode.ATTR_TTS_ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f6752i = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;", "gmp_version_for_remote_config", "ALTER TABLE apps ADD COLUMN gmp_version_for_remote_config INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f6753j = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final String[] f6754k = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final String[] f6755l = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final String[] f6756m = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static final String[] f6757n = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static final String[] f6758o = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static final String[] f6759p = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* renamed from: d  reason: collision with root package name */
    private final C1419t f6760d;

    /* renamed from: e  reason: collision with root package name */
    private final R5 f6761e = new R5(this.f5730a.f());

    C1426u(q6 q6Var) {
        super(q6Var);
        this.f5730a.w();
        this.f6760d = new C1419t(this, this.f5730a.e(), "google_app_measurement.db");
    }

    private final String M(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = u0().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                String string = rawQuery.getString(0);
                rawQuery.close();
                return string;
            }
            rawQuery.close();
            return "";
        } catch (SQLiteException e5) {
            this.f5730a.a().o().c("Database error", str, e5);
            throw e5;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final void N(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase u02 = u0();
            String asString = contentValues.getAsString(MBridgeConstans.APP_ID);
            if (asString == null) {
                this.f5730a.a().q().b("Value of the primary key is not set.", C1402q2.x(MBridgeConstans.APP_ID));
                return;
            }
            StringBuilder sb = new StringBuilder(10);
            sb.append(MBridgeConstans.APP_ID);
            sb.append(" = ?");
            if (((long) u02.update("consent_settings", contentValues, sb.toString(), new String[]{asString})) == 0 && u02.insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                this.f5730a.a().o().c("Failed to insert/update table (got -1). key", C1402q2.x("consent_settings"), C1402q2.x(MBridgeConstans.APP_ID));
            }
        } catch (SQLiteException e5) {
            this.f5730a.a().o().d("Error storing into table. key", C1402q2.x("consent_settings"), C1402q2.x(MBridgeConstans.APP_ID), e5);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x012f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.measurement.internal.C O(java.lang.String r30, java.lang.String r31, java.lang.String r32) {
        /*
            r29 = this;
            r1 = r29
            N.C0722p.e(r31)
            N.C0722p.e(r32)
            r1.h()
            r1.j()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r9 = "last_exempt_from_sampling"
            java.lang.String r10 = "current_session_count"
            java.lang.String r2 = "lifetime_count"
            java.lang.String r3 = "current_bundle_count"
            java.lang.String r4 = "last_fire_timestamp"
            java.lang.String r5 = "last_bundled_timestamp"
            java.lang.String r6 = "last_bundled_day"
            java.lang.String r7 = "last_sampled_complex_event_id"
            java.lang.String r8 = "last_sampling_rate"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10}
            java.util.List r2 = java.util.Arrays.asList(r2)
            r0.<init>(r2)
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r1.u0()     // Catch:{ SQLiteException -> 0x0108, all -> 0x0106 }
            r11 = 0
            java.lang.String[] r4 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0108, all -> 0x0106 }
            java.lang.Object[] r0 = r0.toArray(r4)     // Catch:{ SQLiteException -> 0x0108, all -> 0x0106 }
            r5 = r0
            java.lang.String[] r5 = (java.lang.String[]) r5     // Catch:{ SQLiteException -> 0x0108, all -> 0x0106 }
            java.lang.String r6 = "app_id=? and name=?"
            java.lang.String[] r7 = new java.lang.String[]{r31, r32}     // Catch:{ SQLiteException -> 0x0108, all -> 0x0106 }
            r9 = 0
            r10 = 0
            r8 = 0
            r4 = r30
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0108, all -> 0x0106 }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x00ca }
            if (r0 != 0) goto L_0x0053
            goto L_0x0127
        L_0x0053:
            long r15 = r3.getLong(r11)     // Catch:{ SQLiteException -> 0x00ca }
            r0 = 1
            long r17 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x00ca }
            r4 = 2
            long r21 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00ca }
            r4 = 3
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x00ca }
            r6 = 0
            if (r5 == 0) goto L_0x006d
            r23 = r6
            goto L_0x0073
        L_0x006d:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00ca }
            r23 = r4
        L_0x0073:
            r4 = 4
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x00ca }
            if (r5 == 0) goto L_0x007d
            r25 = r2
            goto L_0x0087
        L_0x007d:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00ca }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x00ca }
            r25 = r4
        L_0x0087:
            r4 = 5
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x00ca }
            if (r5 == 0) goto L_0x0091
            r26 = r2
            goto L_0x009b
        L_0x0091:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00ca }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x00ca }
            r26 = r4
        L_0x009b:
            r4 = 6
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x00ca }
            if (r5 == 0) goto L_0x00a5
            r27 = r2
            goto L_0x00af
        L_0x00a5:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00ca }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x00ca }
            r27 = r4
        L_0x00af:
            r4 = 7
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x00ca }
            if (r5 != 0) goto L_0x00cc
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00ca }
            r8 = 1
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x00c1
            r11 = r0
        L_0x00c1:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r11)     // Catch:{ SQLiteException -> 0x00ca }
            r28 = r0
            goto L_0x00ce
        L_0x00c8:
            r0 = move-exception
            goto L_0x0104
        L_0x00ca:
            r0 = move-exception
            goto L_0x010a
        L_0x00cc:
            r28 = r2
        L_0x00ce:
            r0 = 8
            boolean r4 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x00ca }
            if (r4 == 0) goto L_0x00d9
        L_0x00d6:
            r19 = r6
            goto L_0x00de
        L_0x00d9:
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x00ca }
            goto L_0x00d6
        L_0x00de:
            com.google.android.gms.measurement.internal.C r12 = new com.google.android.gms.measurement.internal.C     // Catch:{ SQLiteException -> 0x00ca }
            r13 = r31
            r14 = r32
            r12.<init>(r13, r14, r15, r17, r19, r21, r23, r25, r26, r27, r28)     // Catch:{ SQLiteException -> 0x00ca }
            boolean r0 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x00ca }
            if (r0 == 0) goto L_0x0100
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ SQLiteException -> 0x00ca }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ SQLiteException -> 0x00ca }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ SQLiteException -> 0x00ca }
            java.lang.String r4 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.C1402q2.x(r31)     // Catch:{ SQLiteException -> 0x00ca }
            r0.b(r4, r5)     // Catch:{ SQLiteException -> 0x00ca }
        L_0x0100:
            r3.close()
            return r12
        L_0x0104:
            r2 = r3
            goto L_0x012d
        L_0x0106:
            r0 = move-exception
            goto L_0x012d
        L_0x0108:
            r0 = move-exception
            r3 = r2
        L_0x010a:
            com.google.android.gms.measurement.internal.X2 r4 = r1.f5730a     // Catch:{ all -> 0x00c8 }
            com.google.android.gms.measurement.internal.q2 r5 = r4.a()     // Catch:{ all -> 0x00c8 }
            com.google.android.gms.measurement.internal.o2 r5 = r5.o()     // Catch:{ all -> 0x00c8 }
            java.lang.String r6 = "Error querying events. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C1402q2.x(r31)     // Catch:{ all -> 0x00c8 }
            com.google.android.gms.measurement.internal.j2 r4 = r4.D()     // Catch:{ all -> 0x00c8 }
            r14 = r32
            java.lang.String r4 = r4.a(r14)     // Catch:{ all -> 0x00c8 }
            r5.d(r6, r7, r4, r0)     // Catch:{ all -> 0x00c8 }
        L_0x0127:
            if (r3 == 0) goto L_0x012c
            r3.close()
        L_0x012c:
            return r2
        L_0x012d:
            if (r2 == 0) goto L_0x0132
            r2.close()
        L_0x0132:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1426u.O(java.lang.String, java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.C");
    }

    private final void P(String str, C c5) {
        long j5;
        C0722p.k(c5);
        h();
        j();
        ContentValues contentValues = new ContentValues();
        String str2 = c5.f5791a;
        contentValues.put(MBridgeConstans.APP_ID, str2);
        contentValues.put(RewardPlus.NAME, c5.f5792b);
        contentValues.put("lifetime_count", Long.valueOf(c5.f5793c));
        contentValues.put("current_bundle_count", Long.valueOf(c5.f5794d));
        contentValues.put("last_fire_timestamp", Long.valueOf(c5.f5796f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(c5.f5797g));
        contentValues.put("last_bundled_day", c5.f5798h);
        contentValues.put("last_sampled_complex_event_id", c5.f5799i);
        contentValues.put("last_sampling_rate", c5.f5800j);
        contentValues.put("current_session_count", Long.valueOf(c5.f5795e));
        Boolean bool = c5.f5801k;
        if (bool == null || !bool.booleanValue()) {
            j5 = null;
        } else {
            j5 = 1L;
        }
        contentValues.put("last_exempt_from_sampling", j5);
        try {
            if (u0().insertWithOnConflict(str, (String) null, contentValues, 5) == -1) {
                this.f5730a.a().o().b("Failed to insert/update event aggregates (got -1). appId", C1402q2.x(str2));
            }
        } catch (SQLiteException e5) {
            this.f5730a.a().o().c("Error storing event aggregates. appId", C1402q2.x(c5.f5791a), e5);
        }
    }

    private final void Q(String str, String str2) {
        C0722p.e(str2);
        h();
        j();
        try {
            u0().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e5) {
            this.f5730a.a().o().c("Error deleting snapshot. appId", C1402q2.x(str2), e5);
        }
    }

    private final t6 R(String str, long j5, byte[] bArr, String str2, String str3, int i5, int i6, long j6, long j7, long j8) {
        String str4 = str3;
        int i7 = i6;
        if (TextUtils.isEmpty(str2)) {
            this.f5730a.a().v().a("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            V2 v22 = (V2) u6.W(Y2.M(), bArr);
            C1643K a5 = C1643K.a(i5);
            if (!(a5 == C1643K.GOOGLE_SIGNAL || a5 == C1643K.GOOGLE_SIGNAL_PENDING || i7 <= 0)) {
                ArrayList arrayList = new ArrayList();
                for (C1051a3 q5 : v22.r()) {
                    Z2 z22 = (Z2) q5.q();
                    z22.z0(i7);
                    arrayList.add((C1051a3) z22.o());
                }
                v22.z();
                v22.y(arrayList);
            }
            HashMap hashMap = new HashMap();
            if (str4 != null) {
                String[] split = str4.split("\r\n");
                int length = split.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        break;
                    }
                    String str5 = split[i8];
                    if (str5.isEmpty()) {
                        break;
                    }
                    String[] split2 = str5.split("=", 2);
                    if (split2.length != 2) {
                        this.f5730a.a().o().b("Invalid upload header: ", str5);
                        break;
                    }
                    hashMap.put(split2[0], split2[1]);
                    i8++;
                }
            }
            s6 s6Var = new s6();
            s6Var.b(j5);
            s6Var.c((Y2) v22.o());
            s6Var.d(str2);
            s6Var.e(hashMap);
            s6Var.f(a5);
            s6Var.g(j6);
            s6Var.h(j7);
            s6Var.i(j8);
            s6Var.j(i7);
            return s6Var.a();
        } catch (IOException e5) {
            this.f5730a.a().o().c("Failed to queued MeasurementBatch from upload_queue. appId", str, e5);
            return null;
        }
    }

    private final String S() {
        X2 x22 = this.f5730a;
        long currentTimeMillis = x22.f().currentTimeMillis();
        Locale locale = Locale.US;
        C1643K k5 = C1643K.GOOGLE_SIGNAL;
        Integer valueOf = Integer.valueOf(k5.A());
        Long valueOf2 = Long.valueOf(currentTimeMillis);
        x22.w();
        Long l5 = (Long) C1304d2.f6298T.b((Object) null);
        l5.longValue();
        String format = String.format(locale, "(upload_type = %d AND ABS(creation_timestamp - %d) > %d)", new Object[]{valueOf, valueOf2, l5});
        Integer valueOf3 = Integer.valueOf(k5.A());
        x22.w();
        String format2 = String.format(locale, "(upload_type != %d AND ABS(creation_timestamp - %d) > %d)", new Object[]{valueOf3, valueOf2, Long.valueOf(C1371m.q())});
        StringBuilder sb = new StringBuilder(format.length() + 5 + format2.length() + 1);
        sb.append("(");
        sb.append(format);
        sb.append(" OR ");
        sb.append(format2);
        sb.append(")");
        return sb.toString();
    }

    private static final String T(List list) {
        if (list.isEmpty()) {
            return "";
        }
        return String.format(" AND (upload_type IN (%s))", new Object[]{TextUtils.join(", ", list)});
    }

    static final void o0(ContentValues contentValues, String str, Object obj) {
        C0722p.e("value");
        C0722p.k(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put("value", (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final long p0(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = u0().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j5 = cursor.getLong(0);
                cursor.close();
                return j5;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e5) {
            this.f5730a.a().o().c("Database error", str, e5);
            throw e5;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long q0(String str, String[] strArr, long j5) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = u0().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                j5 = rawQuery.getLong(0);
            }
            rawQuery.close();
            return j5;
        } catch (SQLiteException e5) {
            this.f5730a.a().o().c("Database error", str, e5);
            throw e5;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long A() {
        return q0("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final boolean A0(x6 x6Var) {
        C0722p.k(x6Var);
        h();
        j();
        String str = x6Var.f6892a;
        String str2 = x6Var.f6894c;
        if (B0(str, str2) == null) {
            if (z6.r0(str2)) {
                if (p0("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str}) >= ((long) this.f5730a.w().F(str, C1304d2.f6304W, 25, 100))) {
                    return false;
                }
            } else if (!"_npa".equals(str2)) {
                long p02 = p0("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str, x6Var.f6893b});
                this.f5730a.w();
                if (p02 >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put(TtmlNode.ATTR_TTS_ORIGIN, x6Var.f6893b);
        contentValues.put(RewardPlus.NAME, str2);
        contentValues.put("set_timestamp", Long.valueOf(x6Var.f6895d));
        o0(contentValues, "value", x6Var.f6896e);
        try {
            if (u0().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.f5730a.a().o().b("Failed to insert/update user property (got -1). appId", C1402q2.x(str));
            return true;
        } catch (SQLiteException e5) {
            this.f5730a.a().o().c("Error storing user property. appId", C1402q2.x(x6Var.f6892a), e5);
            return true;
        }
    }

    public final boolean B() {
        if (p0("select count(1) > 0 from raw_events", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.x6 B0(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            N.C0722p.e(r11)
            N.C0722p.e(r12)
            r10.h()
            r10.j()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.u0()     // Catch:{ SQLiteException -> 0x0079, all -> 0x0076 }
            java.lang.String r3 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r4 = "value"
            java.lang.String r5 = "origin"
            java.lang.String[] r4 = new java.lang.String[]{r0, r4, r5}     // Catch:{ SQLiteException -> 0x0079, all -> 0x0076 }
            java.lang.String r5 = "app_id=? and name=?"
            java.lang.String[] r6 = new java.lang.String[]{r11, r12}     // Catch:{ SQLiteException -> 0x0079, all -> 0x0076 }
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0079, all -> 0x0076 }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0070 }
            if (r0 != 0) goto L_0x0032
            goto L_0x0099
        L_0x0032:
            r0 = 0
            long r7 = r2.getLong(r0)     // Catch:{ SQLiteException -> 0x0070 }
            r0 = 1
            java.lang.Object r9 = r10.x(r2, r0)     // Catch:{ SQLiteException -> 0x0070 }
            if (r9 != 0) goto L_0x0040
            goto L_0x0099
        L_0x0040:
            r0 = 2
            java.lang.String r5 = r2.getString(r0)     // Catch:{ SQLiteException -> 0x0070 }
            com.google.android.gms.measurement.internal.x6 r3 = new com.google.android.gms.measurement.internal.x6     // Catch:{ SQLiteException -> 0x0070 }
            r4 = r11
            r6 = r12
            r3.<init>(r4, r5, r6, r7, r9)     // Catch:{ SQLiteException -> 0x0069 }
            boolean r11 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0069 }
            if (r11 == 0) goto L_0x006c
            com.google.android.gms.measurement.internal.X2 r11 = r10.f5730a     // Catch:{ SQLiteException -> 0x0069 }
            com.google.android.gms.measurement.internal.q2 r11 = r11.a()     // Catch:{ SQLiteException -> 0x0069 }
            com.google.android.gms.measurement.internal.o2 r11 = r11.o()     // Catch:{ SQLiteException -> 0x0069 }
            java.lang.String r12 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.C1402q2.x(r4)     // Catch:{ SQLiteException -> 0x0069 }
            r11.b(r12, r0)     // Catch:{ SQLiteException -> 0x0069 }
            goto L_0x006c
        L_0x0066:
            r0 = move-exception
            r11 = r0
            goto L_0x0074
        L_0x0069:
            r0 = move-exception
        L_0x006a:
            r11 = r0
            goto L_0x007e
        L_0x006c:
            r2.close()
            return r3
        L_0x0070:
            r0 = move-exception
            r4 = r11
            r6 = r12
            goto L_0x006a
        L_0x0074:
            r1 = r2
            goto L_0x009f
        L_0x0076:
            r0 = move-exception
            r11 = r0
            goto L_0x009f
        L_0x0079:
            r0 = move-exception
            r4 = r11
            r6 = r12
            r11 = r0
            r2 = r1
        L_0x007e:
            com.google.android.gms.measurement.internal.X2 r12 = r10.f5730a     // Catch:{ all -> 0x0066 }
            com.google.android.gms.measurement.internal.q2 r0 = r12.a()     // Catch:{ all -> 0x0066 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ all -> 0x0066 }
            java.lang.String r3 = "Error querying user property. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C1402q2.x(r4)     // Catch:{ all -> 0x0066 }
            com.google.android.gms.measurement.internal.j2 r12 = r12.D()     // Catch:{ all -> 0x0066 }
            java.lang.String r12 = r12.c(r6)     // Catch:{ all -> 0x0066 }
            r0.d(r3, r4, r12, r11)     // Catch:{ all -> 0x0066 }
        L_0x0099:
            if (r2 == 0) goto L_0x009e
            r2.close()
        L_0x009e:
            return r1
        L_0x009f:
            if (r1 == 0) goto L_0x00a4
            r1.close()
        L_0x00a4:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1426u.B0(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.x6");
    }

    public final boolean C(String str, String str2) {
        if (p0("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List C0(java.lang.String r13) {
        /*
            r12 = this;
            N.C0722p.e(r13)
            r12.h()
            r12.j()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r9 = "1000"
            r10 = 0
            android.database.sqlite.SQLiteDatabase r1 = r12.u0()     // Catch:{ SQLiteException -> 0x0085 }
            java.lang.String r2 = "user_attributes"
            java.lang.String r3 = "name"
            java.lang.String r4 = "origin"
            java.lang.String r5 = "set_timestamp"
            java.lang.String r6 = "value"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5, r6}     // Catch:{ SQLiteException -> 0x0085 }
            java.lang.String r4 = "app_id=?"
            java.lang.String[] r5 = new java.lang.String[]{r13}     // Catch:{ SQLiteException -> 0x0085 }
            java.lang.String r8 = "rowid"
            com.google.android.gms.measurement.internal.X2 r11 = r12.f5730a     // Catch:{ SQLiteException -> 0x0085 }
            r11.w()     // Catch:{ SQLiteException -> 0x0085 }
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0085 }
            boolean r1 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x004f }
            if (r1 == 0) goto L_0x009d
        L_0x003c:
            r1 = 0
            java.lang.String r5 = r10.getString(r1)     // Catch:{ SQLiteException -> 0x004f }
            r1 = 1
            java.lang.String r1 = r10.getString(r1)     // Catch:{ SQLiteException -> 0x004f }
            if (r1 != 0) goto L_0x004a
            java.lang.String r1 = ""
        L_0x004a:
            r4 = r1
            goto L_0x0052
        L_0x004c:
            r0 = move-exception
            r13 = r0
            goto L_0x00a3
        L_0x004f:
            r0 = move-exception
            r3 = r13
            goto L_0x0088
        L_0x0052:
            r1 = 2
            long r6 = r10.getLong(r1)     // Catch:{ SQLiteException -> 0x004f }
            r1 = 3
            java.lang.Object r8 = r12.x(r10, r1)     // Catch:{ SQLiteException -> 0x004f }
            if (r8 != 0) goto L_0x0071
            com.google.android.gms.measurement.internal.q2 r1 = r11.a()     // Catch:{ SQLiteException -> 0x004f }
            com.google.android.gms.measurement.internal.o2 r1 = r1.o()     // Catch:{ SQLiteException -> 0x004f }
            java.lang.String r2 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C1402q2.x(r13)     // Catch:{ SQLiteException -> 0x004f }
            r1.b(r2, r3)     // Catch:{ SQLiteException -> 0x004f }
            r3 = r13
            goto L_0x007a
        L_0x0071:
            com.google.android.gms.measurement.internal.x6 r2 = new com.google.android.gms.measurement.internal.x6     // Catch:{ SQLiteException -> 0x004f }
            r3 = r13
            r2.<init>(r3, r4, r5, r6, r8)     // Catch:{ SQLiteException -> 0x0083 }
            r0.add(r2)     // Catch:{ SQLiteException -> 0x0083 }
        L_0x007a:
            boolean r13 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0083 }
            if (r13 != 0) goto L_0x0081
            goto L_0x009d
        L_0x0081:
            r13 = r3
            goto L_0x003c
        L_0x0083:
            r0 = move-exception
            goto L_0x0088
        L_0x0085:
            r0 = move-exception
            r3 = r13
            r13 = r0
        L_0x0088:
            com.google.android.gms.measurement.internal.X2 r13 = r12.f5730a     // Catch:{ all -> 0x004c }
            com.google.android.gms.measurement.internal.q2 r13 = r13.a()     // Catch:{ all -> 0x004c }
            com.google.android.gms.measurement.internal.o2 r13 = r13.o()     // Catch:{ all -> 0x004c }
            java.lang.String r1 = "Error querying user properties. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.C1402q2.x(r3)     // Catch:{ all -> 0x004c }
            r13.c(r1, r2, r0)     // Catch:{ all -> 0x004c }
            java.util.List r0 = java.util.Collections.EMPTY_LIST     // Catch:{ all -> 0x004c }
        L_0x009d:
            if (r10 == 0) goto L_0x00a2
            r10.close()
        L_0x00a2:
            return r0
        L_0x00a3:
            if (r10 == 0) goto L_0x00a8
            r10.close()
        L_0x00a8:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1426u.C0(java.lang.String):java.util.List");
    }

    public final boolean D() {
        if (p0("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00cc, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f7, code lost:
        r16 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0110, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0111, code lost:
        r12 = r3;
        r14 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0117, code lost:
        r12 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x011b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x011c, code lost:
        r14 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x011f, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0141, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0039, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00cc A[Catch:{ SQLiteException -> 0x0119, all -> 0x00cc }, ExcHandler: all (th java.lang.Throwable), Splitter:B:16:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0039 A[Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }, ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0016] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List D0(java.lang.String r23, java.lang.String r24, java.lang.String r25) {
        /*
            r22 = this;
            r1 = r22
            r0 = r25
            N.C0722p.e(r23)
            r1.h()
            r1.j()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r11 = "1001"
            java.lang.String r3 = "*"
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x011b, all -> 0x0039 }
            r13 = 3
            r4.<init>(r13)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0039 }
            r15 = r23
            r4.add(r15)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0039 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x011b, all -> 0x0039 }
            java.lang.String r6 = "app_id=?"
            r5.<init>(r6)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0039 }
            boolean r6 = android.text.TextUtils.isEmpty(r24)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0039 }
            if (r6 != 0) goto L_0x003f
            r14 = r24
            r4.add(r14)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            java.lang.String r6 = " and origin=?"
            r5.append(r6)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            goto L_0x0041
        L_0x0039:
            r0 = move-exception
            goto L_0x011f
        L_0x003c:
            r0 = move-exception
            goto L_0x0121
        L_0x003f:
            r14 = r24
        L_0x0041:
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            r7 = 1
            if (r6 != 0) goto L_0x0068
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            int r6 = r6.length()     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            int r6 = r6 + r7
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            r8.<init>(r6)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            r8.append(r0)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            r8.append(r3)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            java.lang.String r3 = r8.toString()     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            r4.add(r3)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            java.lang.String r3 = " and name glob ?"
            r5.append(r3)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
        L_0x0068:
            int r3 = r4.size()     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            java.lang.Object[] r3 = r4.toArray(r3)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            r4 = r7
            r7 = r3
            android.database.sqlite.SQLiteDatabase r3 = r1.u0()     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            r6 = r4
            java.lang.String r4 = "user_attributes"
            java.lang.String r8 = "name"
            java.lang.String r9 = "set_timestamp"
            java.lang.String r10 = "value"
            java.lang.String r6 = "origin"
            java.lang.String[] r6 = new java.lang.String[]{r8, r9, r10, r6}     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            java.lang.String r10 = "rowid"
            com.google.android.gms.measurement.internal.X2 r8 = r1.f5730a     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            r8.w()     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            r9 = r8
            r8 = 0
            r17 = r9
            r9 = 0
            r12 = r6
            r6 = r5
            r5 = r12
            r21 = r17
            r12 = 1
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0119, all -> 0x00cc }
            if (r4 != 0) goto L_0x00ab
            goto L_0x0138
        L_0x00ab:
            int r4 = r2.size()     // Catch:{ SQLiteException -> 0x0119, all -> 0x00cc }
            r21.w()     // Catch:{ SQLiteException -> 0x0119, all -> 0x00cc }
            r5 = 1000(0x3e8, float:1.401E-42)
            if (r4 < r5) goto L_0x00ce
            com.google.android.gms.measurement.internal.q2 r0 = r21.a()     // Catch:{ SQLiteException -> 0x0119, all -> 0x00cc }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ SQLiteException -> 0x0119, all -> 0x00cc }
            java.lang.String r4 = "Read more than the max allowed user properties, ignoring excess"
            r21.w()     // Catch:{ SQLiteException -> 0x0119, all -> 0x00cc }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ SQLiteException -> 0x0119, all -> 0x00cc }
            r0.b(r4, r5)     // Catch:{ SQLiteException -> 0x0119, all -> 0x00cc }
            goto L_0x0138
        L_0x00cc:
            r0 = move-exception
            goto L_0x0117
        L_0x00ce:
            r4 = 0
            java.lang.String r17 = r3.getString(r4)     // Catch:{ SQLiteException -> 0x0119, all -> 0x00cc }
            long r18 = r3.getLong(r12)     // Catch:{ SQLiteException -> 0x0119, all -> 0x00cc }
            r4 = 2
            java.lang.Object r20 = r1.x(r3, r4)     // Catch:{ SQLiteException -> 0x0119, all -> 0x00cc }
            java.lang.String r4 = r3.getString(r13)     // Catch:{ SQLiteException -> 0x0119, all -> 0x00cc }
            if (r20 != 0) goto L_0x00fa
            com.google.android.gms.measurement.internal.q2 r5 = r21.a()     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00cc }
            com.google.android.gms.measurement.internal.o2 r5 = r5.o()     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00cc }
            java.lang.String r6 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C1402q2.x(r15)     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00cc }
            r5.d(r6, r7, r4, r0)     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00cc }
            r16 = r4
            goto L_0x0104
        L_0x00f6:
            r0 = move-exception
            r16 = r4
            goto L_0x0111
        L_0x00fa:
            com.google.android.gms.measurement.internal.x6 r14 = new com.google.android.gms.measurement.internal.x6     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00cc }
            r16 = r4
            r14.<init>(r15, r16, r17, r18, r20)     // Catch:{ SQLiteException -> 0x0110, all -> 0x00cc }
            r2.add(r14)     // Catch:{ SQLiteException -> 0x0110, all -> 0x00cc }
        L_0x0104:
            boolean r4 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x0110, all -> 0x00cc }
            if (r4 != 0) goto L_0x010b
            goto L_0x0138
        L_0x010b:
            r15 = r23
            r14 = r16
            goto L_0x00ab
        L_0x0110:
            r0 = move-exception
        L_0x0111:
            r12 = r3
            r14 = r16
            goto L_0x0122
        L_0x0115:
            r12 = r3
            goto L_0x0122
        L_0x0117:
            r12 = r3
            goto L_0x013f
        L_0x0119:
            r0 = move-exception
            goto L_0x0115
        L_0x011b:
            r0 = move-exception
            r14 = r24
            goto L_0x0121
        L_0x011f:
            r12 = 0
            goto L_0x013f
        L_0x0121:
            r12 = 0
        L_0x0122:
            com.google.android.gms.measurement.internal.X2 r2 = r1.f5730a     // Catch:{ all -> 0x013e }
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()     // Catch:{ all -> 0x013e }
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()     // Catch:{ all -> 0x013e }
            java.lang.String r3 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C1402q2.x(r23)     // Catch:{ all -> 0x013e }
            r2.d(r3, r4, r14, r0)     // Catch:{ all -> 0x013e }
            java.util.List r2 = java.util.Collections.EMPTY_LIST     // Catch:{ all -> 0x013e }
            r3 = r12
        L_0x0138:
            if (r3 == 0) goto L_0x013d
            r3.close()
        L_0x013d:
            return r2
        L_0x013e:
            r0 = move-exception
        L_0x013f:
            if (r12 == 0) goto L_0x0144
            r12.close()
        L_0x0144:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1426u.D0(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final long E(String str) {
        C0722p.e(str);
        return q0("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    public final boolean E0(C1341i iVar) {
        C0722p.k(iVar);
        h();
        j();
        String str = iVar.f6470a;
        C0722p.k(str);
        if (B0(str, iVar.f6472c.f6788b) == null) {
            long p02 = p0("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.f5730a.w();
            if (p02 >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put(TtmlNode.ATTR_TTS_ORIGIN, iVar.f6471b);
        contentValues.put(RewardPlus.NAME, iVar.f6472c.f6788b);
        o0(contentValues, "value", C0722p.k(iVar.f6472c.c()));
        contentValues.put("active", Boolean.valueOf(iVar.f6474e));
        contentValues.put("trigger_event_name", iVar.f6475f);
        contentValues.put("trigger_timeout", Long.valueOf(iVar.f6477h));
        X2 x22 = this.f5730a;
        contentValues.put("timed_out_event", x22.C().T(iVar.f6476g));
        contentValues.put("creation_timestamp", Long.valueOf(iVar.f6473d));
        contentValues.put("triggered_event", x22.C().T(iVar.f6478i));
        contentValues.put("triggered_timestamp", Long.valueOf(iVar.f6472c.f6789c));
        contentValues.put("time_to_live", Long.valueOf(iVar.f6479j));
        contentValues.put("expired_event", x22.C().T(iVar.f6480k));
        try {
            if (u0().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) != -1) {
                return true;
            }
            x22.a().o().b("Failed to insert/update conditional user property (got -1)", C1402q2.x(str));
            return true;
        } catch (SQLiteException e5) {
            this.f5730a.a().o().c("Error storing conditional user property", C1402q2.x(str), e5);
            return true;
        }
    }

    public final boolean F(String str, Long l5, long j5, O2 o22) {
        h();
        j();
        C0722p.k(o22);
        C0722p.e(str);
        C0722p.k(l5);
        X2 x22 = this.f5730a;
        byte[] e5 = o22.e();
        x22.a().w().c("Saving complex main event, appId, data size", x22.D().a(str), Integer.valueOf(e5.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("event_id", l5);
        contentValues.put("children_to_process", Long.valueOf(j5));
        contentValues.put("main_event", e5);
        try {
            if (u0().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            x22.a().o().b("Failed to insert complex main event (got -1). appId", C1402q2.x(str));
            return false;
        } catch (SQLiteException e6) {
            this.f5730a.a().o().c("Error storing complex main event. appId", C1402q2.x(str), e6);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0121  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.C1341i F0(java.lang.String r26, java.lang.String r27) {
        /*
            r25 = this;
            r1 = r25
            N.C0722p.e(r26)
            N.C0722p.e(r27)
            r1.h()
            r1.j()
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r1.u0()     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00f8 }
            java.lang.String r10 = "conditional_properties"
            java.lang.String r11 = "origin"
            java.lang.String r12 = "value"
            java.lang.String r13 = "active"
            java.lang.String r14 = "trigger_event_name"
            java.lang.String r15 = "trigger_timeout"
            java.lang.String r16 = "timed_out_event"
            java.lang.String r17 = "creation_timestamp"
            java.lang.String r18 = "triggered_event"
            java.lang.String r19 = "triggered_timestamp"
            java.lang.String r20 = "time_to_live"
            java.lang.String r21 = "expired_event"
            java.lang.String[] r11 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00f8 }
            java.lang.String r12 = "app_id=? and name=?"
            java.lang.String[] r13 = new java.lang.String[]{r26, r27}     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00f8 }
            r15 = 0
            r16 = 0
            r14 = 0
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00f8 }
            boolean r0 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x0053 }
            if (r0 != 0) goto L_0x0045
            goto L_0x0119
        L_0x0045:
            r0 = 0
            java.lang.String r2 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x0053 }
            if (r2 != 0) goto L_0x004e
            java.lang.String r2 = ""
        L_0x004e:
            r7 = r2
            goto L_0x0058
        L_0x0050:
            r0 = move-exception
            goto L_0x00f6
        L_0x0053:
            r0 = move-exception
            r3 = r27
            goto L_0x00fe
        L_0x0058:
            r2 = 1
            java.lang.Object r6 = r1.x(r9, r2)     // Catch:{ SQLiteException -> 0x0053 }
            r3 = 2
            int r3 = r9.getInt(r3)     // Catch:{ SQLiteException -> 0x0053 }
            if (r3 == 0) goto L_0x0067
            r16 = r2
            goto L_0x0069
        L_0x0067:
            r16 = r0
        L_0x0069:
            r0 = 3
            java.lang.String r17 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x0053 }
            r0 = 4
            long r19 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x0053 }
            com.google.android.gms.measurement.internal.q6 r0 = r1.f6129b     // Catch:{ SQLiteException -> 0x0053 }
            com.google.android.gms.measurement.internal.u6 r2 = r0.K0()     // Catch:{ SQLiteException -> 0x0053 }
            r3 = 5
            byte[] r3 = r9.getBlob(r3)     // Catch:{ SQLiteException -> 0x0053 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.G> r4 = com.google.android.gms.measurement.internal.G.CREATOR     // Catch:{ SQLiteException -> 0x0053 }
            android.os.Parcelable r2 = r2.N(r3, r4)     // Catch:{ SQLiteException -> 0x0053 }
            r18 = r2
            com.google.android.gms.measurement.internal.G r18 = (com.google.android.gms.measurement.internal.G) r18     // Catch:{ SQLiteException -> 0x0053 }
            r2 = 6
            long r14 = r9.getLong(r2)     // Catch:{ SQLiteException -> 0x0053 }
            com.google.android.gms.measurement.internal.u6 r2 = r0.K0()     // Catch:{ SQLiteException -> 0x0053 }
            r3 = 7
            byte[] r3 = r9.getBlob(r3)     // Catch:{ SQLiteException -> 0x0053 }
            android.os.Parcelable r2 = r2.N(r3, r4)     // Catch:{ SQLiteException -> 0x0053 }
            r21 = r2
            com.google.android.gms.measurement.internal.G r21 = (com.google.android.gms.measurement.internal.G) r21     // Catch:{ SQLiteException -> 0x0053 }
            r2 = 8
            long r2 = r9.getLong(r2)     // Catch:{ SQLiteException -> 0x0053 }
            r5 = 9
            long r22 = r9.getLong(r5)     // Catch:{ SQLiteException -> 0x0053 }
            com.google.android.gms.measurement.internal.u6 r0 = r0.K0()     // Catch:{ SQLiteException -> 0x0053 }
            r5 = 10
            byte[] r5 = r9.getBlob(r5)     // Catch:{ SQLiteException -> 0x0053 }
            android.os.Parcelable r0 = r0.N(r5, r4)     // Catch:{ SQLiteException -> 0x0053 }
            r24 = r0
            com.google.android.gms.measurement.internal.G r24 = (com.google.android.gms.measurement.internal.G) r24     // Catch:{ SQLiteException -> 0x0053 }
            com.google.android.gms.measurement.internal.v6 r13 = new com.google.android.gms.measurement.internal.v6     // Catch:{ SQLiteException -> 0x0053 }
            r4 = r2
            r2 = r13
            r3 = r27
            r2.<init>(r3, r4, r6, r7)     // Catch:{ SQLiteException -> 0x00f0 }
            r13 = r2
            com.google.android.gms.measurement.internal.i r10 = new com.google.android.gms.measurement.internal.i     // Catch:{ SQLiteException -> 0x00f0 }
            r11 = r26
            r12 = r7
            r10.<init>(r11, r12, r13, r14, r16, r17, r18, r19, r21, r22, r24)     // Catch:{ SQLiteException -> 0x00f0 }
            boolean r0 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x00f0 }
            if (r0 == 0) goto L_0x00f2
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ SQLiteException -> 0x00f0 }
            com.google.android.gms.measurement.internal.q2 r2 = r0.a()     // Catch:{ SQLiteException -> 0x00f0 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()     // Catch:{ SQLiteException -> 0x00f0 }
            java.lang.String r4 = "Got multiple records for conditional property, expected one"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.C1402q2.x(r26)     // Catch:{ SQLiteException -> 0x00f0 }
            com.google.android.gms.measurement.internal.j2 r0 = r0.D()     // Catch:{ SQLiteException -> 0x00f0 }
            java.lang.String r0 = r0.c(r3)     // Catch:{ SQLiteException -> 0x00f0 }
            r2.c(r4, r5, r0)     // Catch:{ SQLiteException -> 0x00f0 }
            goto L_0x00f2
        L_0x00f0:
            r0 = move-exception
            goto L_0x00fe
        L_0x00f2:
            r9.close()
            return r10
        L_0x00f6:
            r8 = r9
            goto L_0x011f
        L_0x00f8:
            r0 = move-exception
            goto L_0x011f
        L_0x00fa:
            r0 = move-exception
            r3 = r27
            r9 = r8
        L_0x00fe:
            com.google.android.gms.measurement.internal.X2 r2 = r1.f5730a     // Catch:{ all -> 0x0050 }
            com.google.android.gms.measurement.internal.q2 r4 = r2.a()     // Catch:{ all -> 0x0050 }
            com.google.android.gms.measurement.internal.o2 r4 = r4.o()     // Catch:{ all -> 0x0050 }
            java.lang.String r5 = "Error querying conditional property"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.C1402q2.x(r26)     // Catch:{ all -> 0x0050 }
            com.google.android.gms.measurement.internal.j2 r2 = r2.D()     // Catch:{ all -> 0x0050 }
            java.lang.String r2 = r2.c(r3)     // Catch:{ all -> 0x0050 }
            r4.d(r5, r6, r2, r0)     // Catch:{ all -> 0x0050 }
        L_0x0119:
            if (r9 == 0) goto L_0x011e
            r9.close()
        L_0x011e:
            return r8
        L_0x011f:
            if (r8 == 0) goto L_0x0124
            r8.close()
        L_0x0124:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1426u.F0(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.i");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle G(java.lang.String r6) {
        /*
            r5 = this;
            r5.h()
            r5.j()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.u0()     // Catch:{ SQLiteException -> 0x006e, all -> 0x006c }
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            java.lang.String[] r3 = new java.lang.String[]{r6}     // Catch:{ SQLiteException -> 0x006e, all -> 0x006c }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x006e, all -> 0x006c }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x002d }
            if (r2 != 0) goto L_0x002f
            com.google.android.gms.measurement.internal.X2 r6 = r5.f5730a     // Catch:{ SQLiteException -> 0x002d }
            com.google.android.gms.measurement.internal.q2 r6 = r6.a()     // Catch:{ SQLiteException -> 0x002d }
            com.google.android.gms.measurement.internal.o2 r6 = r6.w()     // Catch:{ SQLiteException -> 0x002d }
            java.lang.String r2 = "Default event parameters not found"
            r6.a(r2)     // Catch:{ SQLiteException -> 0x002d }
            goto L_0x007f
        L_0x002b:
            r6 = move-exception
            goto L_0x006a
        L_0x002d:
            r6 = move-exception
            goto L_0x0070
        L_0x002f:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch:{ SQLiteException -> 0x002d }
            com.google.android.gms.internal.measurement.N2 r3 = com.google.android.gms.internal.measurement.O2.P()     // Catch:{ IOException -> 0x0055 }
            com.google.android.gms.internal.measurement.E5 r2 = com.google.android.gms.measurement.internal.u6.W(r3, r2)     // Catch:{ IOException -> 0x0055 }
            com.google.android.gms.internal.measurement.N2 r2 = (com.google.android.gms.internal.measurement.N2) r2     // Catch:{ IOException -> 0x0055 }
            com.google.android.gms.internal.measurement.e5 r2 = r2.o()     // Catch:{ IOException -> 0x0055 }
            com.google.android.gms.internal.measurement.O2 r2 = (com.google.android.gms.internal.measurement.O2) r2     // Catch:{ IOException -> 0x0055 }
            com.google.android.gms.measurement.internal.q6 r6 = r5.f6129b     // Catch:{ SQLiteException -> 0x002d }
            r6.K0()     // Catch:{ SQLiteException -> 0x002d }
            java.util.List r6 = r2.F()     // Catch:{ SQLiteException -> 0x002d }
            android.os.Bundle r6 = com.google.android.gms.measurement.internal.u6.q(r6)     // Catch:{ SQLiteException -> 0x002d }
            r1.close()
            return r6
        L_0x0055:
            r2 = move-exception
            com.google.android.gms.measurement.internal.X2 r3 = r5.f5730a     // Catch:{ SQLiteException -> 0x002d }
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()     // Catch:{ SQLiteException -> 0x002d }
            com.google.android.gms.measurement.internal.o2 r3 = r3.o()     // Catch:{ SQLiteException -> 0x002d }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.C1402q2.x(r6)     // Catch:{ SQLiteException -> 0x002d }
            r3.c(r4, r6, r2)     // Catch:{ SQLiteException -> 0x002d }
            goto L_0x007f
        L_0x006a:
            r0 = r1
            goto L_0x0085
        L_0x006c:
            r6 = move-exception
            goto L_0x0085
        L_0x006e:
            r6 = move-exception
            r1 = r0
        L_0x0070:
            com.google.android.gms.measurement.internal.X2 r2 = r5.f5730a     // Catch:{ all -> 0x002b }
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()     // Catch:{ all -> 0x002b }
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()     // Catch:{ all -> 0x002b }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.b(r3, r6)     // Catch:{ all -> 0x002b }
        L_0x007f:
            if (r1 == 0) goto L_0x0084
            r1.close()
        L_0x0084:
            return r0
        L_0x0085:
            if (r0 == 0) goto L_0x008a
            r0.close()
        L_0x008a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1426u.G(java.lang.String):android.os.Bundle");
    }

    public final int G0(String str, String str2) {
        C0722p.e(str);
        C0722p.e(str2);
        h();
        j();
        try {
            return u0().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e5) {
            X2 x22 = this.f5730a;
            x22.a().o().d("Error deleting conditional property", C1402q2.x(str), x22.D().c(str2), e5);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean H(String str, long j5) {
        try {
            if (q0("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j5)}, 0) <= 0 && q0("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j5)}, 0) > 0) {
                return true;
            }
            return false;
        } catch (SQLiteException e5) {
            this.f5730a.a().o().b("Error checking backfill conditions", e5);
            return false;
        }
    }

    public final List H0(String str, String str2, String str3) {
        C0722p.e(str);
        h();
        j();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return I0(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: com.google.android.gms.internal.measurement.a3} */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r4v18, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r4v19 */
    /* JADX WARNING: type inference failed for: r4v20 */
    /* JADX WARNING: type inference failed for: r0v36, types: [com.google.android.gms.internal.measurement.e5] */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0084, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0086, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d9, code lost:
        r4 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00db, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0123, code lost:
        r4.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0084 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:16:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02a7 A[Catch:{ SQLiteException -> 0x02c0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void I(java.lang.String r25, java.lang.Long r26, java.lang.String r27, android.os.Bundle r28) {
        /*
            r24 = this;
            r1 = r24
            r5 = r25
            N.C0722p.k(r28)
            r1.h()
            r1.j()
            if (r26 == 0) goto L_0x001a
            com.google.android.gms.measurement.internal.s r0 = new com.google.android.gms.measurement.internal.s
            long r2 = r26.longValue()
            r0.<init>(r1, r5, r2)
        L_0x0018:
            r12 = r0
            goto L_0x0020
        L_0x001a:
            com.google.android.gms.measurement.internal.s r0 = new com.google.android.gms.measurement.internal.s
            r0.<init>(r1, r5)
            goto L_0x0018
        L_0x0020:
            java.util.List r0 = r12.a()
        L_0x0024:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x02e1
            java.util.Iterator r13 = r0.iterator()
        L_0x002e:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x02d7
            java.lang.Object r0 = r13.next()
            r14 = r0
            com.google.android.gms.measurement.internal.r r14 = (com.google.android.gms.measurement.internal.r) r14
            boolean r0 = android.text.TextUtils.isEmpty(r27)
            if (r0 != 0) goto L_0x011e
            long r2 = r14.f6684b
            r4 = 0
            android.database.sqlite.SQLiteDatabase r15 = r1.u0()     // Catch:{ SQLiteException -> 0x00df }
            java.lang.String r16 = "raw_events_metadata"
            java.lang.String r0 = "metadata"
            java.lang.String[] r17 = new java.lang.String[]{r0}     // Catch:{ SQLiteException -> 0x00df }
            java.lang.String r18 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String r0 = java.lang.Long.toString(r2)     // Catch:{ SQLiteException -> 0x00df }
            java.lang.String[] r19 = new java.lang.String[]{r5, r0}     // Catch:{ SQLiteException -> 0x00df }
            java.lang.String r22 = "rowid"
            java.lang.String r23 = "2"
            r20 = 0
            r21 = 0
            android.database.Cursor r2 = r15.query(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x00df }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            if (r0 != 0) goto L_0x0088
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            java.lang.String r3 = "Raw event metadata record is missing. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.C1402q2.x(r5)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0.b(r3, r6)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
        L_0x007f:
            r2.close()
            goto L_0x00fa
        L_0x0084:
            r0 = move-exception
            goto L_0x00d9
        L_0x0086:
            r0 = move-exception
            goto L_0x00db
        L_0x0088:
            r0 = 0
            byte[] r0 = r2.getBlob(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            com.google.android.gms.internal.measurement.Z2 r3 = com.google.android.gms.internal.measurement.C1051a3.k0()     // Catch:{ IOException -> 0x00c4 }
            com.google.android.gms.internal.measurement.E5 r0 = com.google.android.gms.measurement.internal.u6.W(r3, r0)     // Catch:{ IOException -> 0x00c4 }
            com.google.android.gms.internal.measurement.Z2 r0 = (com.google.android.gms.internal.measurement.Z2) r0     // Catch:{ IOException -> 0x00c4 }
            com.google.android.gms.internal.measurement.e5 r0 = r0.o()     // Catch:{ IOException -> 0x00c4 }
            r3 = r0
            com.google.android.gms.internal.measurement.a3 r3 = (com.google.android.gms.internal.measurement.C1051a3) r3     // Catch:{ IOException -> 0x00c4 }
            boolean r0 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x00b8, all -> 0x0084 }
            if (r0 == 0) goto L_0x00ba
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ SQLiteException -> 0x00b8, all -> 0x0084 }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ SQLiteException -> 0x00b8, all -> 0x0084 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()     // Catch:{ SQLiteException -> 0x00b8, all -> 0x0084 }
            java.lang.String r4 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.C1402q2.x(r5)     // Catch:{ SQLiteException -> 0x00b8, all -> 0x0084 }
            r0.b(r4, r6)     // Catch:{ SQLiteException -> 0x00b8, all -> 0x0084 }
            goto L_0x00ba
        L_0x00b8:
            r0 = move-exception
            goto L_0x00c2
        L_0x00ba:
            r2.close()     // Catch:{ SQLiteException -> 0x00b8, all -> 0x0084 }
            r2.close()
        L_0x00c0:
            r4 = r3
            goto L_0x00fa
        L_0x00c2:
            r4 = r2
            goto L_0x00e1
        L_0x00c4:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r3 = r1.f5730a     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            com.google.android.gms.measurement.internal.o2 r3 = r3.o()     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            java.lang.String r6 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C1402q2.x(r5)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r3.c(r6, r7, r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            goto L_0x007f
        L_0x00d9:
            r4 = r2
            goto L_0x0121
        L_0x00db:
            r3 = r4
            goto L_0x00c2
        L_0x00dd:
            r0 = move-exception
            goto L_0x0121
        L_0x00df:
            r0 = move-exception
            r3 = r4
        L_0x00e1:
            com.google.android.gms.measurement.internal.X2 r2 = r1.f5730a     // Catch:{ all -> 0x00dd }
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()     // Catch:{ all -> 0x00dd }
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()     // Catch:{ all -> 0x00dd }
            java.lang.String r6 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C1402q2.x(r5)     // Catch:{ all -> 0x00dd }
            r2.c(r6, r7, r0)     // Catch:{ all -> 0x00dd }
            if (r4 == 0) goto L_0x00c0
            r4.close()
            goto L_0x00c0
        L_0x00fa:
            if (r4 == 0) goto L_0x011e
            java.util.List r0 = r4.n2()
            java.util.Iterator r0 = r0.iterator()
        L_0x0104:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x011e
            java.lang.Object r2 = r0.next()
            com.google.android.gms.internal.measurement.r3 r2 = (com.google.android.gms.internal.measurement.C1203r3) r2
            java.lang.String r2 = r2.H()
            r15 = r27
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x0104
            goto L_0x002e
        L_0x011e:
            r15 = r27
            goto L_0x0127
        L_0x0121:
            if (r4 == 0) goto L_0x0126
            r4.close()
        L_0x0126:
            throw r0
        L_0x0127:
            com.google.android.gms.measurement.internal.q6 r0 = r1.f6129b
            com.google.android.gms.measurement.internal.u6 r2 = r0.K0()
            com.google.android.gms.internal.measurement.O2 r3 = r14.f6686d
            android.os.Bundle r9 = new android.os.Bundle
            r9.<init>()
            java.util.List r4 = r3.F()
            java.util.Iterator r4 = r4.iterator()
        L_0x013c:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x01ba
            java.lang.Object r6 = r4.next()
            com.google.android.gms.internal.measurement.S2 r6 = (com.google.android.gms.internal.measurement.S2) r6
            boolean r7 = r6.N()
            if (r7 == 0) goto L_0x015a
            java.lang.String r7 = r6.G()
            double r10 = r6.O()
            r9.putDouble(r7, r10)
            goto L_0x013c
        L_0x015a:
            boolean r7 = r6.L()
            if (r7 == 0) goto L_0x016c
            java.lang.String r7 = r6.G()
            float r6 = r6.M()
            r9.putFloat(r7, r6)
            goto L_0x013c
        L_0x016c:
            boolean r7 = r6.J()
            if (r7 == 0) goto L_0x017e
            java.lang.String r7 = r6.G()
            long r10 = r6.K()
            r9.putLong(r7, r10)
            goto L_0x013c
        L_0x017e:
            boolean r7 = r6.H()
            if (r7 == 0) goto L_0x0190
            java.lang.String r7 = r6.G()
            java.lang.String r6 = r6.I()
            r9.putString(r7, r6)
            goto L_0x013c
        L_0x0190:
            java.util.List r7 = r6.P()
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x01aa
            java.lang.String r7 = r6.G()
            java.util.List r6 = r6.P()
            android.os.Bundle[] r6 = com.google.android.gms.measurement.internal.u6.Y(r6)
            r9.putParcelableArray(r7, r6)
            goto L_0x013c
        L_0x01aa:
            com.google.android.gms.measurement.internal.X2 r7 = r2.f5730a
            com.google.android.gms.measurement.internal.q2 r7 = r7.a()
            com.google.android.gms.measurement.internal.o2 r7 = r7.o()
            java.lang.String r8 = "Unexpected parameter type for parameter"
            r7.b(r8, r6)
            goto L_0x013c
        L_0x01ba:
            java.lang.String r2 = "_o"
            java.lang.String r4 = r9.getString(r2)
            r9.remove(r2)
            com.google.android.gms.measurement.internal.r2 r6 = new com.google.android.gms.measurement.internal.r2
            java.lang.String r7 = r3.I()
            if (r4 != 0) goto L_0x01cd
            java.lang.String r4 = ""
        L_0x01cd:
            r8 = r4
            long r10 = r3.K()
            r6.<init>(r7, r8, r9, r10)
            com.google.android.gms.measurement.internal.X2 r2 = r1.f5730a
            android.os.Bundle r11 = r6.f6692d
            java.lang.String r4 = r6.f6689a
            com.google.android.gms.measurement.internal.z6 r7 = r2.C()
            java.lang.String r8 = "_cmp"
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x01ed
            r4 = r28
            r8 = r4
        L_0x01ea:
            r16 = r0
            goto L_0x0218
        L_0x01ed:
            android.os.Bundle r4 = new android.os.Bundle
            r8 = r28
            r4.<init>(r8)
            java.util.Set r9 = r8.keySet()
            java.util.Iterator r9 = r9.iterator()
        L_0x01fc:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x01ea
            java.lang.Object r10 = r9.next()
            java.lang.String r10 = (java.lang.String) r10
            r16 = r0
            java.lang.String r0 = "gad_"
            boolean r0 = r10.startsWith(r0)
            if (r0 == 0) goto L_0x0215
            r4.remove(r10)
        L_0x0215:
            r0 = r16
            goto L_0x01fc
        L_0x0218:
            r7.w(r11, r4)
            r0 = r3
            com.google.android.gms.measurement.internal.X2 r3 = r1.f5730a
            java.lang.String r4 = r6.f6690b
            r6 = r2
            com.google.android.gms.measurement.internal.B r2 = new com.google.android.gms.measurement.internal.B
            r7 = r6
            java.lang.String r6 = r0.I()
            r9 = r7
            long r7 = r0.K()
            long r17 = r0.M()
            r0 = r9
            r9 = r17
            r2.<init>((com.google.android.gms.measurement.internal.X2) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (long) r7, (long) r9, (android.os.Bundle) r11)
            long r3 = r14.f6683a
            long r5 = r14.f6684b
            boolean r7 = r14.f6685c
            r1.h()
            r1.j()
            N.C0722p.k(r2)
            java.lang.String r8 = r2.f5744a
            N.C0722p.e(r8)
            com.google.android.gms.measurement.internal.u6 r9 = r16.K0()
            com.google.android.gms.internal.measurement.O2 r9 = r9.J(r2)
            byte[] r9 = r9.e()
            android.content.ContentValues r10 = new android.content.ContentValues
            r10.<init>()
            java.lang.String r11 = "app_id"
            r10.put(r11, r8)
            java.lang.String r11 = r2.f5745b
            java.lang.String r14 = "name"
            r10.put(r14, r11)
            r16 = r3
            long r3 = r2.f5747d
            java.lang.String r11 = "timestamp"
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r10.put(r11, r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r5)
            java.lang.String r4 = "metadata_fingerprint"
            r10.put(r4, r3)
            java.lang.String r3 = "data"
            r10.put(r3, r9)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.String r4 = "realtime"
            r10.put(r4, r3)
            android.database.sqlite.SQLiteDatabase r3 = r1.u0()     // Catch:{ SQLiteException -> 0x02c0 }
            java.lang.String r4 = "raw_events"
            java.lang.String r5 = "rowid = ?"
            java.lang.String r6 = java.lang.String.valueOf(r16)     // Catch:{ SQLiteException -> 0x02c0 }
            java.lang.String[] r6 = new java.lang.String[]{r6}     // Catch:{ SQLiteException -> 0x02c0 }
            int r3 = r3.update(r4, r10, r5, r6)     // Catch:{ SQLiteException -> 0x02c0 }
            long r3 = (long) r3     // Catch:{ SQLiteException -> 0x02c0 }
            r5 = 1
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x02bc
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ SQLiteException -> 0x02c0 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ SQLiteException -> 0x02c0 }
            java.lang.String r5 = "Failed to update raw event. appId, updatedRows"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.C1402q2.x(r8)     // Catch:{ SQLiteException -> 0x02c0 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x02c0 }
            r0.c(r5, r6, r3)     // Catch:{ SQLiteException -> 0x02c0 }
        L_0x02bc:
            r5 = r25
            goto L_0x002e
        L_0x02c0:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r3 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()
            com.google.android.gms.measurement.internal.o2 r3 = r3.o()
            java.lang.String r2 = r2.f5744a
            java.lang.String r4 = "Error updating raw event. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.C1402q2.x(r2)
            r3.c(r4, r2, r0)
            goto L_0x02bc
        L_0x02d7:
            r15 = r27
            java.util.List r0 = r12.a()
            r5 = r25
            goto L_0x0024
        L_0x02e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1426u.I(java.lang.String, java.lang.Long, java.lang.String, android.os.Bundle):void");
    }

    public final List I0(String str, String[] strArr) {
        boolean z4;
        h();
        j();
        List arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase u02 = u0();
            String[] strArr2 = {MBridgeConstans.APP_ID, TtmlNode.ATTR_TTS_ORIGIN, RewardPlus.NAME, "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"};
            X2 x22 = this.f5730a;
            x22.w();
            cursor = u02.query("conditional_properties", strArr2, str, strArr, (String) null, (String) null, "rowid", "1001");
            if (cursor.moveToFirst()) {
                while (true) {
                    int size = arrayList.size();
                    x22.w();
                    if (size < 1000) {
                        String string = cursor.getString(0);
                        String string2 = cursor.getString(1);
                        String string3 = cursor.getString(2);
                        Object x4 = x(cursor, 3);
                        if (cursor.getInt(4) != 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        String string4 = cursor.getString(5);
                        long j5 = cursor.getLong(6);
                        q6 q6Var = this.f6129b;
                        u6 K02 = q6Var.K0();
                        byte[] blob = cursor.getBlob(7);
                        Parcelable.Creator<G> creator = G.CREATOR;
                        String str2 = string2;
                        String str3 = str2;
                        arrayList.add(new C1341i(string, str3, new v6(string3, cursor.getLong(10), x4, str2), cursor.getLong(8), z4, string4, (G) K02.N(blob, creator), j5, (G) q6Var.K0().N(cursor.getBlob(9), creator), cursor.getLong(11), (G) q6Var.K0().N(cursor.getBlob(12), creator)));
                        if (!cursor.moveToNext()) {
                            break;
                        }
                    } else {
                        C1388o2 o5 = x22.a().o();
                        x22.w();
                        o5.b("Read more than the max allowed conditional properties, ignoring extra", 1000);
                        break;
                    }
                }
            }
        } catch (SQLiteException e5) {
            this.f5730a.a().o().b("Error querying conditional user property value", e5);
            arrayList = Collections.EMPTY_LIST;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.google.android.gms.measurement.internal.E3} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        if (r5 != null) goto L_0x002d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.E3 J(java.lang.String r5) {
        /*
            r4 = this;
            N.C0722p.k(r5)
            r4.h()
            r4.j()
            java.lang.String[] r5 = new java.lang.String[]{r5}
            java.lang.String r0 = "select consent_state, consent_source from consent_settings where app_id=? limit 1;"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r4.u0()     // Catch:{ SQLiteException -> 0x0049, all -> 0x0046 }
            android.database.Cursor r5 = r2.rawQuery(r0, r5)     // Catch:{ SQLiteException -> 0x0049, all -> 0x0046 }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0033 }
            if (r0 != 0) goto L_0x0035
            com.google.android.gms.measurement.internal.X2 r0 = r4.f5730a     // Catch:{ SQLiteException -> 0x0033 }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ SQLiteException -> 0x0033 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()     // Catch:{ SQLiteException -> 0x0033 }
            java.lang.String r2 = "No data found"
            r0.a(r2)     // Catch:{ SQLiteException -> 0x0033 }
        L_0x002d:
            r5.close()
            goto L_0x005e
        L_0x0031:
            r0 = move-exception
            goto L_0x0044
        L_0x0033:
            r0 = move-exception
            goto L_0x004c
        L_0x0035:
            r0 = 0
            java.lang.String r0 = r5.getString(r0)     // Catch:{ SQLiteException -> 0x0033 }
            r2 = 1
            int r2 = r5.getInt(r2)     // Catch:{ SQLiteException -> 0x0033 }
            com.google.android.gms.measurement.internal.E3 r1 = com.google.android.gms.measurement.internal.E3.f(r0, r2)     // Catch:{ SQLiteException -> 0x0033 }
            goto L_0x002d
        L_0x0044:
            r1 = r5
            goto L_0x0064
        L_0x0046:
            r5 = move-exception
            r0 = r5
            goto L_0x0064
        L_0x0049:
            r5 = move-exception
            r0 = r5
            r5 = r1
        L_0x004c:
            com.google.android.gms.measurement.internal.X2 r2 = r4.f5730a     // Catch:{ all -> 0x0031 }
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()     // Catch:{ all -> 0x0031 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = "Error querying database."
            r2.b(r3, r0)     // Catch:{ all -> 0x0031 }
            if (r5 == 0) goto L_0x005e
            goto L_0x002d
        L_0x005e:
            if (r1 != 0) goto L_0x0063
            com.google.android.gms.measurement.internal.E3 r5 = com.google.android.gms.measurement.internal.E3.f5857c
            return r5
        L_0x0063:
            return r1
        L_0x0064:
            if (r1 == 0) goto L_0x0069
            r1.close()
        L_0x0069:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1426u.J(java.lang.String):com.google.android.gms.measurement.internal.E3");
    }

    /* JADX WARNING: Removed duplicated region for block: B:90:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0306  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.C1443w2 J0(java.lang.String r52) {
        /*
            r51 = this;
            r1 = r51
            r2 = r52
            N.C0722p.e(r2)
            r1.h()
            r1.j()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r1.u0()     // Catch:{ SQLiteException -> 0x02e9, all -> 0x02e7 }
            java.lang.String r5 = "apps"
            java.lang.String r6 = "app_instance_id"
            java.lang.String r7 = "gmp_app_id"
            java.lang.String r8 = "resettable_device_id_hash"
            java.lang.String r9 = "last_bundle_index"
            java.lang.String r10 = "last_bundle_start_timestamp"
            java.lang.String r11 = "last_bundle_end_timestamp"
            java.lang.String r12 = "app_version"
            java.lang.String r13 = "app_store"
            java.lang.String r14 = "gmp_version"
            java.lang.String r15 = "dev_cert_hash"
            java.lang.String r16 = "measurement_enabled"
            java.lang.String r17 = "day"
            java.lang.String r18 = "daily_public_events_count"
            java.lang.String r19 = "daily_events_count"
            java.lang.String r20 = "daily_conversions_count"
            java.lang.String r21 = "config_fetched_time"
            java.lang.String r22 = "failed_config_fetch_time"
            java.lang.String r23 = "app_version_int"
            java.lang.String r24 = "firebase_instance_id"
            java.lang.String r25 = "daily_error_events_count"
            java.lang.String r26 = "daily_realtime_events_count"
            java.lang.String r27 = "health_monitor_sample"
            java.lang.String r28 = "android_id"
            java.lang.String r29 = "adid_reporting_enabled"
            java.lang.String r30 = "admob_app_id"
            java.lang.String r31 = "dynamite_version"
            java.lang.String r32 = "safelisted_events"
            java.lang.String r33 = "ga_app_id"
            java.lang.String r34 = "session_stitching_token"
            java.lang.String r35 = "sgtm_upload_enabled"
            java.lang.String r36 = "target_os_version"
            java.lang.String r37 = "session_stitching_token_hash"
            java.lang.String r38 = "ad_services_version"
            java.lang.String r39 = "unmatched_first_open_without_ad_id"
            java.lang.String r40 = "npa_metadata_value"
            java.lang.String r41 = "attribution_eligibility_status"
            java.lang.String r42 = "sgtm_preview_key"
            java.lang.String r43 = "dma_consent_state"
            java.lang.String r44 = "daily_realtime_dcu_count"
            java.lang.String r45 = "bundle_delivery_index"
            java.lang.String r46 = "serialized_npa_metadata"
            java.lang.String r47 = "unmatched_pfo"
            java.lang.String r48 = "unmatched_uwa"
            java.lang.String r49 = "ad_campaign_info"
            java.lang.String r50 = "client_upload_eligibility"
            java.lang.String[] r6 = new java.lang.String[]{r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50}     // Catch:{ SQLiteException -> 0x02e9, all -> 0x02e7 }
            java.lang.String r7 = "app_id=?"
            java.lang.String[] r8 = new java.lang.String[]{r2}     // Catch:{ SQLiteException -> 0x02e9, all -> 0x02e7 }
            r10 = 0
            r11 = 0
            r9 = 0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x02e9, all -> 0x02e7 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x00aa }
            if (r0 != 0) goto L_0x0087
            goto L_0x02fe
        L_0x0087:
            com.google.android.gms.measurement.internal.w2 r0 = new com.google.android.gms.measurement.internal.w2     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.q6 r5 = r1.f6129b     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.X2 r6 = r5.g0()     // Catch:{ SQLiteException -> 0x00aa }
            r0.<init>(r6, r2)     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.E3 r6 = r5.g(r2)     // Catch:{ SQLiteException -> 0x00aa }
            f0.w r7 = f0.w.ANALYTICS_STORAGE     // Catch:{ SQLiteException -> 0x00aa }
            boolean r6 = r6.o(r7)     // Catch:{ SQLiteException -> 0x00aa }
            r8 = 0
            if (r6 == 0) goto L_0x00ad
            java.lang.String r6 = r4.getString(r8)     // Catch:{ SQLiteException -> 0x00aa }
            r0.q0(r6)     // Catch:{ SQLiteException -> 0x00aa }
            goto L_0x00ad
        L_0x00a7:
            r0 = move-exception
            goto L_0x02e5
        L_0x00aa:
            r0 = move-exception
            goto L_0x02eb
        L_0x00ad:
            r6 = 1
            java.lang.String r9 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r0.s0(r9)     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.E3 r9 = r5.g(r2)     // Catch:{ SQLiteException -> 0x00aa }
            f0.w r10 = f0.w.AD_STORAGE     // Catch:{ SQLiteException -> 0x00aa }
            boolean r9 = r9.o(r10)     // Catch:{ SQLiteException -> 0x00aa }
            if (r9 == 0) goto L_0x00c9
            r9 = 2
            java.lang.String r9 = r4.getString(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.w0(r9)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x00c9:
            r9 = 3
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.f(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 4
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.A0(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 5
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.C0(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 6
            java.lang.String r9 = r4.getString(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.E0(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 7
            java.lang.String r9 = r4.getString(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.I0(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 8
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.K0(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 9
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.a(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 10
            boolean r10 = r4.isNull(r9)     // Catch:{ SQLiteException -> 0x00aa }
            if (r10 != 0) goto L_0x0111
            int r9 = r4.getInt(r9)     // Catch:{ SQLiteException -> 0x00aa }
            if (r9 == 0) goto L_0x0113
        L_0x0111:
            r9 = r6
            goto L_0x0114
        L_0x0113:
            r9 = r8
        L_0x0114:
            r0.e(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 11
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.o(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 12
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.q(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 13
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.s(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 14
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.u(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 15
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.i(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 16
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.k(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 17
            boolean r10 = r4.isNull(r9)     // Catch:{ SQLiteException -> 0x00aa }
            if (r10 == 0) goto L_0x0159
            r9 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x015e
        L_0x0159:
            int r9 = r4.getInt(r9)     // Catch:{ SQLiteException -> 0x00aa }
            long r9 = (long) r9     // Catch:{ SQLiteException -> 0x00aa }
        L_0x015e:
            r0.G0(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 18
            java.lang.String r9 = r4.getString(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.y0(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 19
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.y(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 20
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.w(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 21
            java.lang.String r9 = r4.getString(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.O(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 23
            boolean r10 = r4.isNull(r9)     // Catch:{ SQLiteException -> 0x00aa }
            if (r10 != 0) goto L_0x0193
            int r9 = r4.getInt(r9)     // Catch:{ SQLiteException -> 0x00aa }
            if (r9 == 0) goto L_0x0195
        L_0x0193:
            r9 = r6
            goto L_0x0196
        L_0x0195:
            r9 = r8
        L_0x0196:
            r0.Q(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 25
            boolean r10 = r4.isNull(r9)     // Catch:{ SQLiteException -> 0x00aa }
            if (r10 == 0) goto L_0x01a4
            r9 = 0
            goto L_0x01a8
        L_0x01a4:
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x01a8:
            r0.c(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 26
            boolean r10 = r4.isNull(r9)     // Catch:{ SQLiteException -> 0x00aa }
            if (r10 != 0) goto L_0x01c5
            java.lang.String r9 = r4.getString(r9)     // Catch:{ SQLiteException -> 0x00aa }
            java.lang.String r10 = ","
            r11 = -1
            java.lang.String[] r9 = r9.split(r10, r11)     // Catch:{ SQLiteException -> 0x00aa }
            java.util.List r9 = java.util.Arrays.asList(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.U(r9)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x01c5:
            com.google.android.gms.measurement.internal.E3 r5 = r5.g(r2)     // Catch:{ SQLiteException -> 0x00aa }
            boolean r5 = r5.o(r7)     // Catch:{ SQLiteException -> 0x00aa }
            if (r5 == 0) goto L_0x01d8
            r5 = 28
            java.lang.String r5 = r4.getString(r5)     // Catch:{ SQLiteException -> 0x00aa }
            r0.u0(r5)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x01d8:
            r5 = 29
            boolean r7 = r4.isNull(r5)     // Catch:{ SQLiteException -> 0x00aa }
            if (r7 != 0) goto L_0x01e8
            int r5 = r4.getInt(r5)     // Catch:{ SQLiteException -> 0x00aa }
            if (r5 == 0) goto L_0x01e8
            r5 = r6
            goto L_0x01e9
        L_0x01e8:
            r5 = r8
        L_0x01e9:
            r0.W(r5)     // Catch:{ SQLiteException -> 0x00aa }
            r5 = 39
            long r9 = r4.getLong(r5)     // Catch:{ SQLiteException -> 0x00aa }
            r0.F(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r5 = 36
            java.lang.String r5 = r4.getString(r5)     // Catch:{ SQLiteException -> 0x00aa }
            r0.m0(r5)     // Catch:{ SQLiteException -> 0x00aa }
            r5 = 30
            long r9 = r4.getLong(r5)     // Catch:{ SQLiteException -> 0x00aa }
            r0.Y(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r5 = 31
            long r9 = r4.getLong(r5)     // Catch:{ SQLiteException -> 0x00aa }
            r0.a0(r9)     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.internal.measurement.C1145k7.a()     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.X2 r5 = r1.f5730a     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.m r7 = r5.w()     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.c2 r9 = com.google.android.gms.measurement.internal.C1304d2.f6293Q0     // Catch:{ SQLiteException -> 0x00aa }
            boolean r7 = r7.H(r2, r9)     // Catch:{ SQLiteException -> 0x00aa }
            if (r7 == 0) goto L_0x0233
            r7 = 32
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x00aa }
            r0.c0(r7)     // Catch:{ SQLiteException -> 0x00aa }
            r7 = 35
            long r9 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00aa }
            r0.k0(r9)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x0233:
            r7 = 33
            boolean r9 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x00aa }
            if (r9 != 0) goto L_0x0243
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x00aa }
            if (r7 == 0) goto L_0x0243
            r7 = r6
            goto L_0x0244
        L_0x0243:
            r7 = r8
        L_0x0244:
            r0.e0(r7)     // Catch:{ SQLiteException -> 0x00aa }
            r7 = 34
            boolean r9 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x00aa }
            if (r9 == 0) goto L_0x0251
            r6 = r3
            goto L_0x025c
        L_0x0251:
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x00aa }
            if (r7 == 0) goto L_0x0258
            r8 = r6
        L_0x0258:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r8)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x025c:
            r0.S(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r6 = 37
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r0.C(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r6 = 38
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r0.E(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r6 = 40
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x00aa }
            if (r7 == 0) goto L_0x027c
            java.lang.String r6 = ""
            goto L_0x0286
        L_0x027c:
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x00aa }
            java.lang.Object r6 = N.C0722p.k(r6)     // Catch:{ SQLiteException -> 0x00aa }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ SQLiteException -> 0x00aa }
        L_0x0286:
            r0.H(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r6 = 41
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x00aa }
            if (r7 != 0) goto L_0x029c
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x00aa }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r0.g0(r6)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x029c:
            r6 = 42
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x00aa }
            if (r7 != 0) goto L_0x02af
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x00aa }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r0.i0(r6)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x02af:
            r6 = 43
            byte[] r6 = r4.getBlob(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r0.J(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r6 = 44
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x00aa }
            if (r7 != 0) goto L_0x02c7
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r0.L(r6)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x02c7:
            r0.n0()     // Catch:{ SQLiteException -> 0x00aa }
            boolean r6 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x00aa }
            if (r6 == 0) goto L_0x02e1
            com.google.android.gms.measurement.internal.q2 r5 = r5.a()     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.o2 r5 = r5.o()     // Catch:{ SQLiteException -> 0x00aa }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C1402q2.x(r2)     // Catch:{ SQLiteException -> 0x00aa }
            r5.b(r6, r7)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x02e1:
            r4.close()
            return r0
        L_0x02e5:
            r3 = r4
            goto L_0x0304
        L_0x02e7:
            r0 = move-exception
            goto L_0x0304
        L_0x02e9:
            r0 = move-exception
            r4 = r3
        L_0x02eb:
            com.google.android.gms.measurement.internal.X2 r5 = r1.f5730a     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.measurement.internal.q2 r5 = r5.a()     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.measurement.internal.o2 r5 = r5.o()     // Catch:{ all -> 0x00a7 }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.C1402q2.x(r2)     // Catch:{ all -> 0x00a7 }
            r5.c(r6, r2, r0)     // Catch:{ all -> 0x00a7 }
        L_0x02fe:
            if (r4 == 0) goto L_0x0303
            r4.close()
        L_0x0303:
            return r3
        L_0x0304:
            if (r3 == 0) goto L_0x0309
            r3.close()
        L_0x0309:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1426u.J0(java.lang.String):com.google.android.gms.measurement.internal.w2");
    }

    public final boolean K(String str, S5 s5) {
        h();
        j();
        C0722p.k(s5);
        C0722p.e(str);
        X2 x22 = this.f5730a;
        long currentTimeMillis = x22.f().currentTimeMillis();
        C1296c2 c2Var = C1304d2.f6369w0;
        long j5 = s5.f6082b;
        if (j5 < currentTimeMillis - ((Long) c2Var.b((Object) null)).longValue() || j5 > ((Long) c2Var.b((Object) null)).longValue() + currentTimeMillis) {
            x22.a().r().d("Storing trigger URI outside of the max retention time span. appId, now, timestamp", C1402q2.x(str), Long.valueOf(currentTimeMillis), Long.valueOf(j5));
        }
        x22.a().w().a("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("trigger_uri", s5.f6081a);
        contentValues.put("source", Integer.valueOf(s5.f6083c));
        contentValues.put("timestamp_millis", Long.valueOf(j5));
        try {
            if (u0().insert("trigger_uris", (String) null, contentValues) != -1) {
                return true;
            }
            x22.a().o().b("Failed to insert trigger URI (got -1). appId", C1402q2.x(str));
            return false;
        } catch (SQLiteException e5) {
            this.f5730a.a().o().c("Error storing trigger URI. appId", C1402q2.x(str), e5);
            return false;
        }
    }

    public final void K0(C1443w2 w2Var, boolean z4, boolean z5) {
        C0722p.k(w2Var);
        h();
        j();
        String o02 = w2Var.o0();
        C0722p.k(o02);
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, o02);
        if (z4) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.f6129b.g(o02).o(w.ANALYTICS_STORAGE)) {
            contentValues.put("app_instance_id", w2Var.p0());
        }
        contentValues.put("gmp_app_id", w2Var.r0());
        q6 q6Var = this.f6129b;
        if (q6Var.g(o02).o(w.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", w2Var.v0());
        }
        contentValues.put("last_bundle_index", Long.valueOf(w2Var.g()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(w2Var.z0()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(w2Var.B0()));
        contentValues.put("app_version", w2Var.D0());
        contentValues.put("app_store", w2Var.H0());
        contentValues.put("gmp_version", Long.valueOf(w2Var.J0()));
        contentValues.put("dev_cert_hash", Long.valueOf(w2Var.L0()));
        contentValues.put("measurement_enabled", Boolean.valueOf(w2Var.d()));
        contentValues.put("day", Long.valueOf(w2Var.n()));
        contentValues.put("daily_public_events_count", Long.valueOf(w2Var.p()));
        contentValues.put("daily_events_count", Long.valueOf(w2Var.r()));
        contentValues.put("daily_conversions_count", Long.valueOf(w2Var.t()));
        contentValues.put("config_fetched_time", Long.valueOf(w2Var.h()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(w2Var.j()));
        contentValues.put("app_version_int", Long.valueOf(w2Var.F0()));
        contentValues.put("firebase_instance_id", w2Var.x0());
        contentValues.put("daily_error_events_count", Long.valueOf(w2Var.x()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(w2Var.v()));
        contentValues.put("health_monitor_sample", w2Var.z());
        contentValues.put("android_id", 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(w2Var.P()));
        contentValues.put("dynamite_version", Long.valueOf(w2Var.b()));
        if (q6Var.g(o02).o(w.ANALYTICS_STORAGE)) {
            contentValues.put("session_stitching_token", w2Var.t0());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(w2Var.V()));
        contentValues.put("target_os_version", Long.valueOf(w2Var.X()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(w2Var.Z()));
        C1145k7.a();
        X2 x22 = this.f5730a;
        if (x22.w().H(o02, C1304d2.f6293Q0)) {
            contentValues.put("ad_services_version", Integer.valueOf(w2Var.b0()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(w2Var.j0()));
        }
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(w2Var.d0()));
        contentValues.put("npa_metadata_value", w2Var.R());
        contentValues.put("bundle_delivery_index", Long.valueOf(w2Var.G()));
        contentValues.put("sgtm_preview_key", w2Var.l0());
        contentValues.put("dma_consent_state", Integer.valueOf(w2Var.B()));
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(w2Var.D()));
        contentValues.put("serialized_npa_metadata", w2Var.I());
        contentValues.put("client_upload_eligibility", Integer.valueOf(w2Var.M()));
        List T4 = w2Var.T();
        if (T4 != null) {
            if (T4.isEmpty()) {
                x22.a().r().b("Safelisted events should not be an empty list. appId", o02);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", T4));
            }
        }
        L6.a();
        if (x22.w().H((String) null, C1304d2.f6283L0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        contentValues.put("unmatched_pfo", w2Var.f0());
        contentValues.put("unmatched_uwa", w2Var.h0());
        contentValues.put("ad_campaign_info", w2Var.K());
        try {
            SQLiteDatabase u02 = u0();
            if (((long) u02.update("apps", contentValues, "app_id = ?", new String[]{o02})) == 0 && u02.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                x22.a().o().b("Failed to insert/update app (got -1). appId", C1402q2.x(o02));
            }
        } catch (SQLiteException e5) {
            this.f5730a.a().o().c("Error storing app. appId", C1402q2.x(o02), e5);
        }
    }

    public final void L(String str, E3 e32) {
        C0722p.k(str);
        C0722p.k(e32);
        h();
        j();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("consent_state", e32.l());
        contentValues.put("consent_source", Integer.valueOf(e32.b()));
        N("consent_settings", MBridgeConstans.APP_ID, contentValues);
    }

    public final C1399q L0(long j5, String str, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        return M0(j5, str, 1, false, false, z6, false, z8, z9, z10);
    }

    public final C1399q M0(long j5, String str, long j6, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        C0722p.e(str);
        h();
        j();
        String[] strArr = {str};
        C1399q qVar = new C1399q();
        Cursor cursor = null;
        try {
            SQLiteDatabase u02 = u0();
            cursor = u02.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                this.f5730a.a().r().b("Not updating daily counts, app is not known. appId", C1402q2.x(str));
            } else {
                if (cursor.getLong(0) == j5) {
                    qVar.f6619b = cursor.getLong(1);
                    qVar.f6618a = cursor.getLong(2);
                    qVar.f6620c = cursor.getLong(3);
                    qVar.f6621d = cursor.getLong(4);
                    qVar.f6622e = cursor.getLong(5);
                    qVar.f6623f = cursor.getLong(6);
                    qVar.f6624g = cursor.getLong(7);
                }
                if (z4) {
                    qVar.f6619b += j6;
                }
                if (z5) {
                    qVar.f6618a += j6;
                }
                if (z6) {
                    qVar.f6620c += j6;
                }
                if (z7) {
                    qVar.f6621d += j6;
                }
                if (z8) {
                    qVar.f6622e += j6;
                }
                if (z9) {
                    qVar.f6623f += j6;
                }
                if (z10) {
                    qVar.f6624g += j6;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j5));
                contentValues.put("daily_public_events_count", Long.valueOf(qVar.f6618a));
                contentValues.put("daily_events_count", Long.valueOf(qVar.f6619b));
                contentValues.put("daily_conversions_count", Long.valueOf(qVar.f6620c));
                contentValues.put("daily_error_events_count", Long.valueOf(qVar.f6621d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(qVar.f6622e));
                contentValues.put("daily_realtime_dcu_count", Long.valueOf(qVar.f6623f));
                contentValues.put("daily_registered_triggers_count", Long.valueOf(qVar.f6624g));
                u02.update("apps", contentValues, "app_id=?", strArr);
            }
        } catch (SQLiteException e5) {
            this.f5730a.a().o().c("Error updating daily counts. appId", C1402q2.x(str), e5);
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
        if (cursor != null) {
            cursor.close();
        }
        return qVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.C1392p N0(java.lang.String r11) {
        /*
            r10 = this;
            N.C0722p.e(r11)
            r10.h()
            r10.j()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.u0()     // Catch:{ SQLiteException -> 0x006d, all -> 0x006a }
            java.lang.String r3 = "apps"
            java.lang.String r0 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String r5 = "e_tag"
            java.lang.String[] r4 = new java.lang.String[]{r0, r4, r5}     // Catch:{ SQLiteException -> 0x006d, all -> 0x006a }
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[]{r11}     // Catch:{ SQLiteException -> 0x006d, all -> 0x006a }
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x006d, all -> 0x006a }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x005a }
            if (r0 != 0) goto L_0x002e
            goto L_0x0082
        L_0x002e:
            r0 = 0
            byte[] r0 = r2.getBlob(r0)     // Catch:{ SQLiteException -> 0x005a }
            r3 = 1
            java.lang.String r3 = r2.getString(r3)     // Catch:{ SQLiteException -> 0x005a }
            r4 = 2
            java.lang.String r4 = r2.getString(r4)     // Catch:{ SQLiteException -> 0x005a }
            boolean r5 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x005a }
            if (r5 == 0) goto L_0x005c
            com.google.android.gms.measurement.internal.X2 r5 = r10.f5730a     // Catch:{ SQLiteException -> 0x005a }
            com.google.android.gms.measurement.internal.q2 r5 = r5.a()     // Catch:{ SQLiteException -> 0x005a }
            com.google.android.gms.measurement.internal.o2 r5 = r5.o()     // Catch:{ SQLiteException -> 0x005a }
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C1402q2.x(r11)     // Catch:{ SQLiteException -> 0x005a }
            r5.b(r6, r7)     // Catch:{ SQLiteException -> 0x005a }
            goto L_0x005c
        L_0x0057:
            r0 = move-exception
            r11 = r0
            goto L_0x0068
        L_0x005a:
            r0 = move-exception
            goto L_0x006f
        L_0x005c:
            if (r0 != 0) goto L_0x005f
            goto L_0x0082
        L_0x005f:
            com.google.android.gms.measurement.internal.p r5 = new com.google.android.gms.measurement.internal.p     // Catch:{ SQLiteException -> 0x005a }
            r5.<init>(r0, r3, r4)     // Catch:{ SQLiteException -> 0x005a }
            r2.close()
            return r5
        L_0x0068:
            r1 = r2
            goto L_0x0088
        L_0x006a:
            r0 = move-exception
            r11 = r0
            goto L_0x0088
        L_0x006d:
            r0 = move-exception
            r2 = r1
        L_0x006f:
            com.google.android.gms.measurement.internal.X2 r3 = r10.f5730a     // Catch:{ all -> 0x0057 }
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()     // Catch:{ all -> 0x0057 }
            com.google.android.gms.measurement.internal.o2 r3 = r3.o()     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.C1402q2.x(r11)     // Catch:{ all -> 0x0057 }
            r3.c(r4, r11, r0)     // Catch:{ all -> 0x0057 }
        L_0x0082:
            if (r2 == 0) goto L_0x0087
            r2.close()
        L_0x0087:
            return r1
        L_0x0088:
            if (r1 == 0) goto L_0x008d
            r1.close()
        L_0x008d:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1426u.N0(java.lang.String):com.google.android.gms.measurement.internal.p");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0043, code lost:
        if (r3 > (com.google.android.gms.measurement.internal.C1371m.q() + r1)) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean O0(com.google.android.gms.internal.measurement.C1051a3 r8, boolean r9) {
        /*
            r7 = this;
            r7.h()
            r7.j()
            N.C0722p.k(r8)
            java.lang.String r0 = r8.F()
            N.C0722p.e(r0)
            boolean r0 = r8.u2()
            N.C0722p.n(r0)
            r7.u()
            com.google.android.gms.measurement.internal.X2 r0 = r7.f5730a
            com.google.android.gms.common.util.d r1 = r0.f()
            long r1 = r1.currentTimeMillis()
            long r3 = r8.v2()
            r0.w()
            long r5 = com.google.android.gms.measurement.internal.C1371m.q()
            long r5 = r1 - r5
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x0045
            long r3 = r8.v2()
            r0.w()
            long r5 = com.google.android.gms.measurement.internal.C1371m.q()
            long r5 = r5 + r1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x0066
        L_0x0045:
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()
            java.lang.String r3 = r8.F()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C1402q2.x(r3)
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            long r4 = r8.v2()
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            java.lang.String r4 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            r0.d(r4, r3, r1, r2)
        L_0x0066:
            byte[] r0 = r8.e()
            r1 = 0
            com.google.android.gms.measurement.internal.q6 r2 = r7.f6129b     // Catch:{ IOException -> 0x0108 }
            com.google.android.gms.measurement.internal.u6 r2 = r2.K0()     // Catch:{ IOException -> 0x0108 }
            byte[] r0 = r2.V(r0)     // Catch:{ IOException -> 0x0108 }
            com.google.android.gms.measurement.internal.X2 r2 = r7.f5730a
            com.google.android.gms.measurement.internal.q2 r3 = r2.a()
            com.google.android.gms.measurement.internal.o2 r3 = r3.w()
            int r4 = r0.length
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "Saving bundle, size"
            r3.b(r5, r4)
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.String r4 = r8.F()
            java.lang.String r5 = "app_id"
            r3.put(r5, r4)
            long r4 = r8.v2()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r5 = "bundle_end_timestamp"
            r3.put(r5, r4)
            java.lang.String r4 = "data"
            r3.put(r4, r0)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r0 = "has_realtime"
            r3.put(r0, r9)
            boolean r9 = r8.G0()
            if (r9 == 0) goto L_0x00c5
            int r9 = r8.H0()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r0 = "retry_count"
            r3.put(r0, r9)
        L_0x00c5:
            android.database.sqlite.SQLiteDatabase r9 = r7.u0()     // Catch:{ SQLiteException -> 0x00ec }
            java.lang.String r0 = "queue"
            r4 = 0
            long r3 = r9.insert(r0, r4, r3)     // Catch:{ SQLiteException -> 0x00ec }
            r5 = -1
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 != 0) goto L_0x00ee
            com.google.android.gms.measurement.internal.q2 r9 = r2.a()     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.o2 r9 = r9.o()     // Catch:{ SQLiteException -> 0x00ec }
            java.lang.String r0 = "Failed to insert bundle (got -1). appId"
            java.lang.String r2 = r8.F()     // Catch:{ SQLiteException -> 0x00ec }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.C1402q2.x(r2)     // Catch:{ SQLiteException -> 0x00ec }
            r9.b(r0, r2)     // Catch:{ SQLiteException -> 0x00ec }
            return r1
        L_0x00ec:
            r9 = move-exception
            goto L_0x00f0
        L_0x00ee:
            r8 = 1
            return r8
        L_0x00f0:
            com.google.android.gms.measurement.internal.X2 r0 = r7.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()
            java.lang.String r8 = r8.F()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.C1402q2.x(r8)
            java.lang.String r2 = "Error storing bundle. appId"
            r0.c(r2, r8, r9)
            return r1
        L_0x0108:
            r9 = move-exception
            com.google.android.gms.measurement.internal.X2 r0 = r7.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()
            java.lang.String r8 = r8.F()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.C1402q2.x(r8)
            java.lang.String r2 = "Data loss. Failed to serialize bundle. appId"
            r0.c(r2, r8, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1426u.O0(com.google.android.gms.internal.measurement.a3, boolean):boolean");
    }

    public final C1454y U(String str) {
        C0722p.k(str);
        h();
        j();
        return C1454y.g(M("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final void V(String str, C1454y yVar) {
        C0722p.k(str);
        C0722p.k(yVar);
        h();
        j();
        E3 J4 = J(str);
        E3 e32 = E3.f5857c;
        if (J4 == e32) {
            L(str, e32);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("dma_consent_settings", yVar.e());
        N("consent_settings", MBridgeConstans.APP_ID, contentValues);
    }

    public final void W(String str, E3 e32) {
        C0722p.k(str);
        C0722p.k(e32);
        h();
        j();
        L(str, J(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("storage_consent_at_bundling", e32.l());
        N("consent_settings", MBridgeConstans.APP_ID, contentValues);
    }

    public final E3 X(String str) {
        C0722p.k(str);
        h();
        j();
        return E3.f(M("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""), 100);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02f8, code lost:
        r11 = r7.e();
        r12 = new android.content.ContentValues();
        r12.put(r0, r2);
        r19 = r0;
        r12.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0311, code lost:
        if (r7.F() == false) goto L_0x031c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0313, code lost:
        r0 = java.lang.Integer.valueOf(r7.G());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x031c, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x031d, code lost:
        r12.put("filter_id", r0);
        r21 = r3;
        r12.put("property_name", r7.H());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x032f, code lost:
        if (r7.L() == false) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0331, code lost:
        r0 = java.lang.Boolean.valueOf(r7.M());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x033a, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x033b, code lost:
        r12.put("session_scoped", r0);
        r12.put(com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x034d, code lost:
        if (u0().insertWithOnConflict("property_filters", (java.lang.String) null, r12, 5) != -1) goto L_0x0365;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x034f, code lost:
        r1.f5730a.a().o().b("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.C1402q2.x(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0363, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0365, code lost:
        r0 = r19;
        r3 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:?, code lost:
        r1.f5730a.a().o().c("Error storing property filter. appId", com.google.android.gms.measurement.internal.C1402q2.x(r2), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0176, code lost:
        r11 = r0.H().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0182, code lost:
        if (r11.hasNext() == false) goto L_0x01a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x018e, code lost:
        if (((com.google.android.gms.internal.measurement.H1) r11.next()).F() != false) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0190, code lost:
        r1.f5730a.a().r().c("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.C1402q2.x(r2), java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01a9, code lost:
        r11 = r0.K().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01b1, code lost:
        r12 = r11.hasNext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01b5, code lost:
        r19 = r0;
        r0 = com.mbridge.msdk.MBridgeConstans.APP_ID;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01c3, code lost:
        if (r12 == false) goto L_0x029c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r12 = (com.google.android.gms.internal.measurement.C1271z1) r11.next();
        j();
        h();
        N.C0722p.e(r2);
        N.C0722p.k(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01df, code lost:
        if (r12.H().isEmpty() == false) goto L_0x0213;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01e1, code lost:
        r0 = r1.f5730a.a().r();
        r11 = com.google.android.gms.measurement.internal.C1402q2.x(r2);
        r13 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01f9, code lost:
        if (r12.F() == false) goto L_0x0206;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01fb, code lost:
        r16 = java.lang.Integer.valueOf(r12.G());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0206, code lost:
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0208, code lost:
        r0.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r11, r13, java.lang.String.valueOf(r16));
        r20 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0213, code lost:
        r3 = r12.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0217, code lost:
        r20 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r7 = new android.content.ContentValues();
        r7.put(r0, r2);
        r7.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x022c, code lost:
        if (r12.F() == false) goto L_0x023a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x022e, code lost:
        r0 = java.lang.Integer.valueOf(r12.G());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0237, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x023a, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x023b, code lost:
        r7.put("filter_id", r0);
        r7.put("event_name", r12.H());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x024b, code lost:
        if (r12.P() == false) goto L_0x0256;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x024d, code lost:
        r0 = java.lang.Boolean.valueOf(r12.Q());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0256, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0257, code lost:
        r7.put("session_scoped", r0);
        r7.put(com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0269, code lost:
        if (u0().insertWithOnConflict("event_filters", (java.lang.String) null, r7, 5) != -1) goto L_0x027e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x026b, code lost:
        r1.f5730a.a().o().b("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.C1402q2.x(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x027e, code lost:
        r3 = r24;
        r0 = r19;
        r7 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0286, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        r1.f5730a.a().o().c("Error storing event filter. appId", com.google.android.gms.measurement.internal.C1402q2.x(r2), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x029c, code lost:
        r20 = r7;
        r3 = r19.H().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02aa, code lost:
        if (r3.hasNext() == false) goto L_0x03a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02ac, code lost:
        r7 = (com.google.android.gms.internal.measurement.H1) r3.next();
        j();
        h();
        N.C0722p.e(r2);
        N.C0722p.k(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02c6, code lost:
        if (r7.H().isEmpty() == false) goto L_0x02f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02c8, code lost:
        r0 = r1.f5730a.a().r();
        r9 = com.google.android.gms.measurement.internal.C1402q2.x(r2);
        r11 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02e0, code lost:
        if (r7.F() == false) goto L_0x02ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02e2, code lost:
        r16 = java.lang.Integer.valueOf(r7.G());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02ed, code lost:
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02ef, code lost:
        r0.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r9, r11, java.lang.String.valueOf(r16));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Y(java.lang.String r23, java.util.List r24) {
        /*
            r22 = this;
            r1 = r22
            r2 = r23
            r3 = r24
            java.lang.String r4 = "app_id=? and audience_id=?"
            java.lang.String r0 = "app_id=?"
            java.lang.String r5 = "event_filters"
            java.lang.String r6 = "property_filters"
            N.C0722p.k(r3)
            r8 = 0
        L_0x0012:
            int r9 = r3.size()
            if (r8 >= r9) goto L_0x00d7
            java.lang.Object r9 = r3.get(r8)
            com.google.android.gms.internal.measurement.x1 r9 = (com.google.android.gms.internal.measurement.C1255x1) r9
            com.google.android.gms.internal.measurement.c5 r9 = r9.q()
            com.google.android.gms.internal.measurement.w1 r9 = (com.google.android.gms.internal.measurement.C1246w1) r9
            int r10 = r9.w()
            if (r10 == 0) goto L_0x009c
            r10 = 0
        L_0x002b:
            int r11 = r9.w()
            if (r10 >= r11) goto L_0x009c
            com.google.android.gms.internal.measurement.z1 r11 = r9.x(r10)
            com.google.android.gms.internal.measurement.c5 r11 = r11.q()
            com.google.android.gms.internal.measurement.y1 r11 = (com.google.android.gms.internal.measurement.C1263y1) r11
            com.google.android.gms.internal.measurement.c5 r12 = r11.clone()
            com.google.android.gms.internal.measurement.y1 r12 = (com.google.android.gms.internal.measurement.C1263y1) r12
            java.lang.String r13 = r11.r()
            java.lang.String r13 = f0.x.b(r13)
            if (r13 == 0) goto L_0x0050
            r12.s(r13)
            r13 = 1
            goto L_0x0051
        L_0x0050:
            r13 = 0
        L_0x0051:
            r15 = 0
        L_0x0052:
            int r14 = r11.t()
            if (r15 >= r14) goto L_0x0089
            com.google.android.gms.internal.measurement.B1 r14 = r11.w(r15)
            java.lang.String r7 = r14.M()
            r17 = r11
            java.lang.String[] r11 = f0.y.f15336a
            r18 = r13
            java.lang.String[] r13 = f0.y.f15337b
            java.lang.String r7 = f0.C1644L.b(r7, r11, r13)
            if (r7 == 0) goto L_0x0082
            com.google.android.gms.internal.measurement.c5 r11 = r14.q()
            com.google.android.gms.internal.measurement.A1 r11 = (com.google.android.gms.internal.measurement.A1) r11
            r11.r(r7)
            com.google.android.gms.internal.measurement.e5 r7 = r11.o()
            com.google.android.gms.internal.measurement.B1 r7 = (com.google.android.gms.internal.measurement.B1) r7
            r12.x(r15, r7)
            r13 = 1
            goto L_0x0084
        L_0x0082:
            r13 = r18
        L_0x0084:
            int r15 = r15 + 1
            r11 = r17
            goto L_0x0052
        L_0x0089:
            r18 = r13
            if (r18 == 0) goto L_0x0099
            r9.y(r10, r12)
            com.google.android.gms.internal.measurement.e5 r7 = r9.o()
            com.google.android.gms.internal.measurement.x1 r7 = (com.google.android.gms.internal.measurement.C1255x1) r7
            r3.set(r8, r7)
        L_0x0099:
            int r10 = r10 + 1
            goto L_0x002b
        L_0x009c:
            int r7 = r9.r()
            if (r7 == 0) goto L_0x00d3
            r7 = 0
        L_0x00a3:
            int r10 = r9.r()
            if (r7 >= r10) goto L_0x00d3
            com.google.android.gms.internal.measurement.H1 r10 = r9.s(r7)
            java.lang.String r11 = r10.H()
            java.lang.String[] r12 = f0.z.f15340a
            java.lang.String[] r13 = f0.z.f15341b
            java.lang.String r11 = f0.C1644L.b(r11, r12, r13)
            if (r11 == 0) goto L_0x00d0
            com.google.android.gms.internal.measurement.c5 r10 = r10.q()
            com.google.android.gms.internal.measurement.G1 r10 = (com.google.android.gms.internal.measurement.G1) r10
            r10.r(r11)
            r9.t(r7, r10)
            com.google.android.gms.internal.measurement.e5 r10 = r9.o()
            com.google.android.gms.internal.measurement.x1 r10 = (com.google.android.gms.internal.measurement.C1255x1) r10
            r3.set(r8, r10)
        L_0x00d0:
            int r7 = r7 + 1
            goto L_0x00a3
        L_0x00d3:
            int r8 = r8 + 1
            goto L_0x0012
        L_0x00d7:
            r1.j()
            r1.h()
            N.C0722p.e(r2)
            N.C0722p.k(r3)
            android.database.sqlite.SQLiteDatabase r7 = r1.u0()
            r7.beginTransaction()
            r1.j()     // Catch:{ all -> 0x013b }
            r1.h()     // Catch:{ all -> 0x013b }
            N.C0722p.e(r2)     // Catch:{ all -> 0x013b }
            android.database.sqlite.SQLiteDatabase r8 = r1.u0()     // Catch:{ all -> 0x013b }
            java.lang.String[] r9 = new java.lang.String[]{r2}     // Catch:{ all -> 0x013b }
            r8.delete(r6, r0, r9)     // Catch:{ all -> 0x013b }
            java.lang.String[] r9 = new java.lang.String[]{r2}     // Catch:{ all -> 0x013b }
            r8.delete(r5, r0, r9)     // Catch:{ all -> 0x013b }
            java.util.Iterator r8 = r3.iterator()     // Catch:{ all -> 0x013b }
        L_0x0109:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x013b }
            if (r0 == 0) goto L_0x03a7
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x013b }
            com.google.android.gms.internal.measurement.x1 r0 = (com.google.android.gms.internal.measurement.C1255x1) r0     // Catch:{ all -> 0x013b }
            r1.j()     // Catch:{ all -> 0x013b }
            r1.h()     // Catch:{ all -> 0x013b }
            N.C0722p.e(r2)     // Catch:{ all -> 0x013b }
            N.C0722p.k(r0)     // Catch:{ all -> 0x013b }
            boolean r10 = r0.F()     // Catch:{ all -> 0x013b }
            if (r10 != 0) goto L_0x0140
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ all -> 0x013b }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ all -> 0x013b }
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()     // Catch:{ all -> 0x013b }
            java.lang.String r9 = "Audience with no ID. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.C1402q2.x(r2)     // Catch:{ all -> 0x013b }
            r0.b(r9, r10)     // Catch:{ all -> 0x013b }
            goto L_0x0109
        L_0x013b:
            r0 = move-exception
            r20 = r7
            goto L_0x0494
        L_0x0140:
            int r10 = r0.G()     // Catch:{ all -> 0x013b }
            java.util.List r11 = r0.K()     // Catch:{ all -> 0x013b }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x013b }
        L_0x014c:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x013b }
            if (r12 == 0) goto L_0x0176
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x013b }
            com.google.android.gms.internal.measurement.z1 r12 = (com.google.android.gms.internal.measurement.C1271z1) r12     // Catch:{ all -> 0x013b }
            boolean r12 = r12.F()     // Catch:{ all -> 0x013b }
            if (r12 != 0) goto L_0x014c
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ all -> 0x013b }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ all -> 0x013b }
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()     // Catch:{ all -> 0x013b }
            java.lang.String r9 = "Event filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.C1402q2.x(r2)     // Catch:{ all -> 0x013b }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x013b }
            r0.c(r9, r11, r10)     // Catch:{ all -> 0x013b }
            goto L_0x0109
        L_0x0176:
            java.util.List r11 = r0.H()     // Catch:{ all -> 0x013b }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x013b }
        L_0x017e:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x013b }
            if (r12 == 0) goto L_0x01a9
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x013b }
            com.google.android.gms.internal.measurement.H1 r12 = (com.google.android.gms.internal.measurement.H1) r12     // Catch:{ all -> 0x013b }
            boolean r12 = r12.F()     // Catch:{ all -> 0x013b }
            if (r12 != 0) goto L_0x017e
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ all -> 0x013b }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ all -> 0x013b }
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()     // Catch:{ all -> 0x013b }
            java.lang.String r9 = "Property filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.C1402q2.x(r2)     // Catch:{ all -> 0x013b }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x013b }
            r0.c(r9, r11, r10)     // Catch:{ all -> 0x013b }
            goto L_0x0109
        L_0x01a9:
            java.util.List r11 = r0.K()     // Catch:{ all -> 0x013b }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x013b }
        L_0x01b1:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x013b }
            r17 = -1
            java.lang.String r13 = "data"
            java.lang.String r14 = "session_scoped"
            java.lang.String r9 = "filter_id"
            java.lang.String r15 = "audience_id"
            r19 = r0
            java.lang.String r0 = "app_id"
            if (r12 == 0) goto L_0x029c
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x013b }
            com.google.android.gms.internal.measurement.z1 r12 = (com.google.android.gms.internal.measurement.C1271z1) r12     // Catch:{ all -> 0x013b }
            r1.j()     // Catch:{ all -> 0x013b }
            r1.h()     // Catch:{ all -> 0x013b }
            N.C0722p.e(r2)     // Catch:{ all -> 0x013b }
            N.C0722p.k(r12)     // Catch:{ all -> 0x013b }
            java.lang.String r20 = r12.H()     // Catch:{ all -> 0x013b }
            boolean r20 = r20.isEmpty()     // Catch:{ all -> 0x013b }
            if (r20 == 0) goto L_0x0213
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ all -> 0x013b }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ all -> 0x013b }
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()     // Catch:{ all -> 0x013b }
            java.lang.String r9 = "Event filter had no event name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.C1402q2.x(r2)     // Catch:{ all -> 0x013b }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x013b }
            boolean r14 = r12.F()     // Catch:{ all -> 0x013b }
            if (r14 == 0) goto L_0x0206
            int r12 = r12.G()     // Catch:{ all -> 0x013b }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x013b }
            r16 = r12
            goto L_0x0208
        L_0x0206:
            r16 = 0
        L_0x0208:
            java.lang.String r12 = java.lang.String.valueOf(r16)     // Catch:{ all -> 0x013b }
            r0.d(r9, r11, r13, r12)     // Catch:{ all -> 0x013b }
            r20 = r7
            goto L_0x037e
        L_0x0213:
            byte[] r3 = r12.e()     // Catch:{ all -> 0x013b }
            r20 = r7
            android.content.ContentValues r7 = new android.content.ContentValues     // Catch:{ all -> 0x0237 }
            r7.<init>()     // Catch:{ all -> 0x0237 }
            r7.put(r0, r2)     // Catch:{ all -> 0x0237 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0237 }
            r7.put(r15, r0)     // Catch:{ all -> 0x0237 }
            boolean r0 = r12.F()     // Catch:{ all -> 0x0237 }
            if (r0 == 0) goto L_0x023a
            int r0 = r12.G()     // Catch:{ all -> 0x0237 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0237 }
            goto L_0x023b
        L_0x0237:
            r0 = move-exception
            goto L_0x0494
        L_0x023a:
            r0 = 0
        L_0x023b:
            r7.put(r9, r0)     // Catch:{ all -> 0x0237 }
            java.lang.String r0 = "event_name"
            java.lang.String r9 = r12.H()     // Catch:{ all -> 0x0237 }
            r7.put(r0, r9)     // Catch:{ all -> 0x0237 }
            boolean r0 = r12.P()     // Catch:{ all -> 0x0237 }
            if (r0 == 0) goto L_0x0256
            boolean r0 = r12.Q()     // Catch:{ all -> 0x0237 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0237 }
            goto L_0x0257
        L_0x0256:
            r0 = 0
        L_0x0257:
            r7.put(r14, r0)     // Catch:{ all -> 0x0237 }
            r7.put(r13, r3)     // Catch:{ all -> 0x0237 }
            android.database.sqlite.SQLiteDatabase r0 = r1.u0()     // Catch:{ SQLiteException -> 0x0286 }
            r3 = 5
            r9 = 0
            long r12 = r0.insertWithOnConflict(r5, r9, r7, r3)     // Catch:{ SQLiteException -> 0x0286 }
            int r0 = (r12 > r17 ? 1 : (r12 == r17 ? 0 : -1))
            if (r0 != 0) goto L_0x027e
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ SQLiteException -> 0x0286 }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ SQLiteException -> 0x0286 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ SQLiteException -> 0x0286 }
            java.lang.String r3 = "Failed to insert event filter (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C1402q2.x(r2)     // Catch:{ SQLiteException -> 0x0286 }
            r0.b(r3, r7)     // Catch:{ SQLiteException -> 0x0286 }
        L_0x027e:
            r3 = r24
            r0 = r19
            r7 = r20
            goto L_0x01b1
        L_0x0286:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r3 = r1.f5730a     // Catch:{ all -> 0x0237 }
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()     // Catch:{ all -> 0x0237 }
            com.google.android.gms.measurement.internal.o2 r3 = r3.o()     // Catch:{ all -> 0x0237 }
            java.lang.String r7 = "Error storing event filter. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.C1402q2.x(r2)     // Catch:{ all -> 0x0237 }
            r3.c(r7, r9, r0)     // Catch:{ all -> 0x0237 }
            goto L_0x037e
        L_0x029c:
            r20 = r7
            java.util.List r3 = r19.H()     // Catch:{ all -> 0x0237 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0237 }
        L_0x02a6:
            boolean r7 = r3.hasNext()     // Catch:{ all -> 0x0237 }
            if (r7 == 0) goto L_0x03a1
            java.lang.Object r7 = r3.next()     // Catch:{ all -> 0x0237 }
            com.google.android.gms.internal.measurement.H1 r7 = (com.google.android.gms.internal.measurement.H1) r7     // Catch:{ all -> 0x0237 }
            r1.j()     // Catch:{ all -> 0x0237 }
            r1.h()     // Catch:{ all -> 0x0237 }
            N.C0722p.e(r2)     // Catch:{ all -> 0x0237 }
            N.C0722p.k(r7)     // Catch:{ all -> 0x0237 }
            java.lang.String r11 = r7.H()     // Catch:{ all -> 0x0237 }
            boolean r11 = r11.isEmpty()     // Catch:{ all -> 0x0237 }
            if (r11 == 0) goto L_0x02f8
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ all -> 0x0237 }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ all -> 0x0237 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()     // Catch:{ all -> 0x0237 }
            java.lang.String r3 = "Property filter had no property name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.C1402q2.x(r2)     // Catch:{ all -> 0x0237 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0237 }
            boolean r12 = r7.F()     // Catch:{ all -> 0x0237 }
            if (r12 == 0) goto L_0x02ed
            int r7 = r7.G()     // Catch:{ all -> 0x0237 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0237 }
            r16 = r7
            goto L_0x02ef
        L_0x02ed:
            r16 = 0
        L_0x02ef:
            java.lang.String r7 = java.lang.String.valueOf(r16)     // Catch:{ all -> 0x0237 }
            r0.d(r3, r9, r11, r7)     // Catch:{ all -> 0x0237 }
            goto L_0x037e
        L_0x02f8:
            byte[] r11 = r7.e()     // Catch:{ all -> 0x0237 }
            android.content.ContentValues r12 = new android.content.ContentValues     // Catch:{ all -> 0x0237 }
            r12.<init>()     // Catch:{ all -> 0x0237 }
            r12.put(r0, r2)     // Catch:{ all -> 0x0237 }
            r19 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0237 }
            r12.put(r15, r0)     // Catch:{ all -> 0x0237 }
            boolean r0 = r7.F()     // Catch:{ all -> 0x0237 }
            if (r0 == 0) goto L_0x031c
            int r0 = r7.G()     // Catch:{ all -> 0x0237 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0237 }
            goto L_0x031d
        L_0x031c:
            r0 = 0
        L_0x031d:
            r12.put(r9, r0)     // Catch:{ all -> 0x0237 }
            java.lang.String r0 = "property_name"
            r21 = r3
            java.lang.String r3 = r7.H()     // Catch:{ all -> 0x0237 }
            r12.put(r0, r3)     // Catch:{ all -> 0x0237 }
            boolean r0 = r7.L()     // Catch:{ all -> 0x0237 }
            if (r0 == 0) goto L_0x033a
            boolean r0 = r7.M()     // Catch:{ all -> 0x0237 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0237 }
            goto L_0x033b
        L_0x033a:
            r0 = 0
        L_0x033b:
            r12.put(r14, r0)     // Catch:{ all -> 0x0237 }
            r12.put(r13, r11)     // Catch:{ all -> 0x0237 }
            android.database.sqlite.SQLiteDatabase r0 = r1.u0()     // Catch:{ SQLiteException -> 0x0363 }
            r3 = 0
            r7 = 5
            long r11 = r0.insertWithOnConflict(r6, r3, r12, r7)     // Catch:{ SQLiteException -> 0x0363 }
            int r0 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r0 != 0) goto L_0x0365
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ SQLiteException -> 0x0363 }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ SQLiteException -> 0x0363 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ SQLiteException -> 0x0363 }
            java.lang.String r3 = "Failed to insert property filter (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C1402q2.x(r2)     // Catch:{ SQLiteException -> 0x0363 }
            r0.b(r3, r7)     // Catch:{ SQLiteException -> 0x0363 }
            goto L_0x037e
        L_0x0363:
            r0 = move-exception
            goto L_0x036b
        L_0x0365:
            r0 = r19
            r3 = r21
            goto L_0x02a6
        L_0x036b:
            com.google.android.gms.measurement.internal.X2 r3 = r1.f5730a     // Catch:{ all -> 0x0237 }
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()     // Catch:{ all -> 0x0237 }
            com.google.android.gms.measurement.internal.o2 r3 = r3.o()     // Catch:{ all -> 0x0237 }
            java.lang.String r7 = "Error storing property filter. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.C1402q2.x(r2)     // Catch:{ all -> 0x0237 }
            r3.c(r7, r9, r0)     // Catch:{ all -> 0x0237 }
        L_0x037e:
            r1.j()     // Catch:{ all -> 0x0237 }
            r1.h()     // Catch:{ all -> 0x0237 }
            N.C0722p.e(r2)     // Catch:{ all -> 0x0237 }
            android.database.sqlite.SQLiteDatabase r0 = r1.u0()     // Catch:{ all -> 0x0237 }
            java.lang.String r3 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0237 }
            java.lang.String[] r3 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x0237 }
            r0.delete(r6, r4, r3)     // Catch:{ all -> 0x0237 }
            java.lang.String r3 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0237 }
            java.lang.String[] r3 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x0237 }
            r0.delete(r5, r4, r3)     // Catch:{ all -> 0x0237 }
        L_0x03a1:
            r3 = r24
            r7 = r20
            goto L_0x0109
        L_0x03a7:
            r20 = r7
            r3 = 0
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0237 }
            r0.<init>()     // Catch:{ all -> 0x0237 }
            java.util.Iterator r4 = r24.iterator()     // Catch:{ all -> 0x0237 }
        L_0x03b3:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0237 }
            if (r5 == 0) goto L_0x03d3
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0237 }
            com.google.android.gms.internal.measurement.x1 r5 = (com.google.android.gms.internal.measurement.C1255x1) r5     // Catch:{ all -> 0x0237 }
            boolean r6 = r5.F()     // Catch:{ all -> 0x0237 }
            if (r6 == 0) goto L_0x03ce
            int r5 = r5.G()     // Catch:{ all -> 0x0237 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0237 }
            goto L_0x03cf
        L_0x03ce:
            r9 = r3
        L_0x03cf:
            r0.add(r9)     // Catch:{ all -> 0x0237 }
            goto L_0x03b3
        L_0x03d3:
            java.lang.String r3 = "("
            java.lang.String r4 = ")"
            java.lang.String r5 = "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in "
            java.lang.String r6 = " order by rowid desc limit -1 offset ?)"
            N.C0722p.e(r2)     // Catch:{ all -> 0x0237 }
            r1.j()     // Catch:{ all -> 0x0237 }
            r1.h()     // Catch:{ all -> 0x0237 }
            android.database.sqlite.SQLiteDatabase r7 = r1.u0()     // Catch:{ all -> 0x0237 }
            java.lang.String r8 = "select count(1) from audience_filter_values where app_id=?"
            java.lang.String[] r9 = new java.lang.String[]{r2}     // Catch:{ SQLiteException -> 0x0479 }
            long r8 = r1.p0(r8, r9)     // Catch:{ SQLiteException -> 0x0479 }
            com.google.android.gms.measurement.internal.X2 r10 = r1.f5730a     // Catch:{ all -> 0x0237 }
            com.google.android.gms.measurement.internal.m r10 = r10.w()     // Catch:{ all -> 0x0237 }
            com.google.android.gms.measurement.internal.c2 r11 = com.google.android.gms.measurement.internal.C1304d2.f6302V     // Catch:{ all -> 0x0237 }
            int r10 = r10.E(r2, r11)     // Catch:{ all -> 0x0237 }
            r11 = 2000(0x7d0, float:2.803E-42)
            int r10 = java.lang.Math.min(r11, r10)     // Catch:{ all -> 0x0237 }
            r11 = 0
            int r10 = java.lang.Math.max(r11, r10)     // Catch:{ all -> 0x0237 }
            long r12 = (long) r10     // Catch:{ all -> 0x0237 }
            int r8 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r8 > 0) goto L_0x0410
            goto L_0x048d
        L_0x0410:
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x0237 }
            r8.<init>()     // Catch:{ all -> 0x0237 }
        L_0x0415:
            int r9 = r0.size()     // Catch:{ all -> 0x0237 }
            if (r11 >= r9) goto L_0x0431
            java.lang.Object r9 = r0.get(r11)     // Catch:{ all -> 0x0237 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ all -> 0x0237 }
            if (r9 == 0) goto L_0x048d
            int r9 = r9.intValue()     // Catch:{ all -> 0x0237 }
            java.lang.String r9 = java.lang.Integer.toString(r9)     // Catch:{ all -> 0x0237 }
            r8.add(r9)     // Catch:{ all -> 0x0237 }
            int r11 = r11 + 1
            goto L_0x0415
        L_0x0431:
            java.lang.String r0 = ","
            java.lang.String r0 = android.text.TextUtils.join(r0, r8)     // Catch:{ all -> 0x0237 }
            java.lang.String r8 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0237 }
            int r8 = r8.length()     // Catch:{ all -> 0x0237 }
            int r8 = r8 + 2
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0237 }
            r9.<init>(r8)     // Catch:{ all -> 0x0237 }
            r9.append(r3)     // Catch:{ all -> 0x0237 }
            r9.append(r0)     // Catch:{ all -> 0x0237 }
            r9.append(r4)     // Catch:{ all -> 0x0237 }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x0237 }
            java.lang.String r3 = "audience_filter_values"
            int r4 = r0.length()     // Catch:{ all -> 0x0237 }
            int r4 = r4 + 140
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0237 }
            r8.<init>(r4)     // Catch:{ all -> 0x0237 }
            r8.append(r5)     // Catch:{ all -> 0x0237 }
            r8.append(r0)     // Catch:{ all -> 0x0237 }
            r8.append(r6)     // Catch:{ all -> 0x0237 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x0237 }
            java.lang.String r4 = java.lang.Integer.toString(r10)     // Catch:{ all -> 0x0237 }
            java.lang.String[] r2 = new java.lang.String[]{r2, r4}     // Catch:{ all -> 0x0237 }
            r7.delete(r3, r0, r2)     // Catch:{ all -> 0x0237 }
            goto L_0x048d
        L_0x0479:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r3 = r1.f5730a     // Catch:{ all -> 0x0237 }
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()     // Catch:{ all -> 0x0237 }
            com.google.android.gms.measurement.internal.o2 r3 = r3.o()     // Catch:{ all -> 0x0237 }
            java.lang.String r4 = "Database error querying filters. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.C1402q2.x(r2)     // Catch:{ all -> 0x0237 }
            r3.c(r4, r2, r0)     // Catch:{ all -> 0x0237 }
        L_0x048d:
            r20.setTransactionSuccessful()     // Catch:{ all -> 0x0237 }
            r20.endTransaction()
            return
        L_0x0494:
            r20.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1426u.Y(java.lang.String, java.util.List):void");
    }

    /* access modifiers changed from: package-private */
    public final C Z(String str, O2 o22, String str2) {
        String str3 = str;
        C O4 = O("events", str3, o22.I());
        if (O4 == null) {
            X2 x22 = this.f5730a;
            x22.a().r().c("Event aggregate wasn't created during raw event logging. appId, event", C1402q2.x(str3), x22.D().a(str2));
            return new C(str3, o22.I(), 1, 1, 1, o22.K(), 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
        }
        long j5 = O4.f5795e + 1;
        long j6 = O4.f5794d + 1;
        long j7 = O4.f5793c + 1;
        String str4 = O4.f5791a;
        String str5 = O4.f5792b;
        long j8 = O4.f5796f;
        long j9 = O4.f5797g;
        Long l5 = O4.f5798h;
        Long l6 = l5;
        return new C(str4, str5, j7, j6, j5, j8, j9, l6, O4.f5799i, O4.f5800j, O4.f5801k);
    }

    /* access modifiers changed from: protected */
    public final boolean a0() {
        X2 x22 = this.f5730a;
        Context e5 = x22.e();
        x22.w();
        return e5.getDatabasePath("google_app_measurement.db").exists();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ long b0(String str, String[] strArr, long j5) {
        return q0("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", strArr, -1);
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        return false;
    }

    public final long m(String str, Y2 y22, String str2, Map map, C1643K k5, Long l5) {
        int delete;
        Long l6 = l5;
        h();
        j();
        C0722p.k(y22);
        C0722p.e(str);
        h();
        j();
        if (a0()) {
            q6 q6Var = this.f6129b;
            long a5 = q6Var.L0().f6912f.a();
            X2 x22 = this.f5730a;
            long elapsedRealtime = x22.f().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - a5);
            x22.w();
            if (abs > C1371m.r()) {
                q6Var.L0().f6912f.b(elapsedRealtime);
                h();
                j();
                if (a0() && (delete = u0().delete("upload_queue", S(), new String[0])) > 0) {
                    x22.a().w().b("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(delete));
                }
                C0722p.e(str);
                h();
                j();
                try {
                    int E4 = x22.w().E(str, C1304d2.f6260A);
                    if (E4 > 0) {
                        u0().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(E4)});
                    }
                } catch (SQLiteException e5) {
                    this.f5730a.a().o().c("Error deleting over the limit queued batches. appId", C1402q2.x(str), e5);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str4).length());
            sb.append(str3);
            sb.append("=");
            sb.append(str4);
            arrayList.add(sb.toString());
        }
        byte[] e6 = y22.e();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("measurement_batch", e6);
        contentValues.put("upload_uri", str2);
        contentValues.put("upload_headers", C1648c.a("\r\n", arrayList));
        contentValues.put("upload_type", Integer.valueOf(k5.A()));
        X2 x23 = this.f5730a;
        contentValues.put("creation_timestamp", Long.valueOf(x23.f().currentTimeMillis()));
        contentValues.put("retry_count", 0);
        if (l6 != null) {
            contentValues.put("associated_row_id", l6);
        }
        try {
            long insert = u0().insert("upload_queue", (String) null, contentValues);
            if (insert != -1) {
                return insert;
            }
            x23.a().o().b("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
            return -1;
        } catch (SQLiteException e7) {
            this.f5730a.a().o().c("Error storing MeasurementBatch to upload_queue. appId", str, e7);
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ R5 m0() {
        return this.f6761e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.t6 n(long r19) {
        /*
            r18 = this;
            r18.h()
            r18.j()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r18.u0()     // Catch:{ SQLiteException -> 0x0091, all -> 0x008f }
            java.lang.String r3 = "upload_queue"
            java.lang.String r4 = "rowId"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "measurement_batch"
            java.lang.String r7 = "upload_uri"
            java.lang.String r8 = "upload_headers"
            java.lang.String r9 = "upload_type"
            java.lang.String r10 = "retry_count"
            java.lang.String r11 = "creation_timestamp"
            java.lang.String r12 = "associated_row_id"
            java.lang.String r13 = "last_upload_timestamp"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10, r11, r12, r13}     // Catch:{ SQLiteException -> 0x0091, all -> 0x008f }
            java.lang.String r5 = "rowId=?"
            java.lang.String r0 = java.lang.String.valueOf(r19)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008f }
            java.lang.String[] r6 = new java.lang.String[]{r0}     // Catch:{ SQLiteException -> 0x0091, all -> 0x008f }
            java.lang.String r10 = "1"
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008f }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            if (r0 != 0) goto L_0x0042
            r3 = r18
            goto L_0x00ab
        L_0x0042:
            r0 = 1
            java.lang.String r0 = r2.getString(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            java.lang.Object r0 = N.C0722p.k(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0 = 2
            byte[] r7 = r2.getBlob(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0 = 3
            java.lang.String r8 = r2.getString(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0 = 4
            java.lang.String r9 = r2.getString(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0 = 5
            int r10 = r2.getInt(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0 = 6
            int r11 = r2.getInt(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0 = 7
            long r12 = r2.getLong(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0 = 8
            long r14 = r2.getLong(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0 = 9
            long r16 = r2.getLong(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r3 = r18
            r5 = r19
            com.google.android.gms.measurement.internal.t6 r0 = r3.R(r4, r5, r7, r8, r9, r10, r11, r12, r14, r16)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r2.close()
            return r0
        L_0x0084:
            r0 = move-exception
            goto L_0x0088
        L_0x0086:
            r0 = move-exception
            goto L_0x008c
        L_0x0088:
            r3 = r18
        L_0x008a:
            r1 = r2
            goto L_0x00b3
        L_0x008c:
            r3 = r18
            goto L_0x0098
        L_0x008f:
            r0 = move-exception
            goto L_0x0093
        L_0x0091:
            r0 = move-exception
            goto L_0x0096
        L_0x0093:
            r3 = r18
            goto L_0x00b3
        L_0x0096:
            r2 = r1
            goto L_0x008c
        L_0x0098:
            com.google.android.gms.measurement.internal.X2 r4 = r3.f5730a     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.o2 r4 = r4.o()     // Catch:{ all -> 0x00b1 }
            java.lang.String r5 = "Error to querying MeasurementBatch from upload_queue. rowId"
            java.lang.Long r6 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x00b1 }
            r4.c(r5, r6, r0)     // Catch:{ all -> 0x00b1 }
        L_0x00ab:
            if (r2 == 0) goto L_0x00b0
            r2.close()
        L_0x00b0:
            return r1
        L_0x00b1:
            r0 = move-exception
            goto L_0x008a
        L_0x00b3:
            if (r1 == 0) goto L_0x00b8
            r1.close()
        L_0x00b8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1426u.n(long):com.google.android.gms.measurement.internal.t6");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0235, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0236, code lost:
        r6 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0254, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0078, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0080, code lost:
        r6 = r3;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:15:0x0064, B:41:0x00be] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x020d A[Catch:{ SQLiteException -> 0x01ef }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078 A[ExcHandler: all (th java.lang.Throwable), PHI: r3 
      PHI: (r3v14 android.database.Cursor) = (r3v4 android.database.Cursor), (r3v5 android.database.Cursor), (r3v5 android.database.Cursor), (r3v5 android.database.Cursor), (r3v5 android.database.Cursor), (r3v11 android.database.Cursor), (r3v16 android.database.Cursor), (r3v16 android.database.Cursor), (r3v16 android.database.Cursor) binds: [B:48:0x00d2, B:108:0x0221, B:109:?, B:55:0x011e, B:62:0x0151, B:41:0x00be, B:15:0x0064, B:20:0x0070, B:21:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:15:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01bd A[Catch:{ SQLiteException -> 0x01ef }, LOOP:0: B:88:0x01bd->B:103:0x020a, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n0(java.lang.String r20, long r21, long r23, com.google.android.gms.measurement.internal.m6 r25) {
        /*
            r19 = this;
            r1 = r19
            r2 = r25
            N.C0722p.k(r2)
            r1.h()
            r1.j()
            java.lang.String r0 = " order by rowid limit 1;"
            java.lang.String r3 = "select metadata_fingerprint from raw_events where app_id = ?"
            java.lang.String r4 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            java.lang.String r5 = "select app_id, metadata_fingerprint from raw_events where "
            r6 = 0
            android.database.sqlite.SQLiteDatabase r7 = r1.u0()     // Catch:{ SQLiteException -> 0x0037 }
            boolean r8 = android.text.TextUtils.isEmpty(r20)     // Catch:{ SQLiteException -> 0x0037 }
            r9 = 1
            java.lang.String r10 = ""
            r11 = 0
            r12 = -1
            if (r8 == 0) goto L_0x0086
            int r0 = (r23 > r12 ? 1 : (r23 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x003c
            java.lang.String r3 = java.lang.String.valueOf(r23)     // Catch:{ SQLiteException -> 0x0037 }
            java.lang.String r8 = java.lang.String.valueOf(r21)     // Catch:{ SQLiteException -> 0x0037 }
            java.lang.String[] r3 = new java.lang.String[]{r3, r8}     // Catch:{ SQLiteException -> 0x0037 }
            goto L_0x0044
        L_0x0037:
            r0 = move-exception
            r8 = r20
            goto L_0x0237
        L_0x003c:
            java.lang.String r3 = java.lang.String.valueOf(r21)     // Catch:{ SQLiteException -> 0x0037 }
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0037 }
        L_0x0044:
            if (r0 == 0) goto L_0x0048
            java.lang.String r10 = "rowid <= ? and "
        L_0x0048:
            int r0 = r10.length()     // Catch:{ SQLiteException -> 0x0037 }
            int r0 = r0 + 148
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0037 }
            r8.<init>(r0)     // Catch:{ SQLiteException -> 0x0037 }
            r8.append(r5)     // Catch:{ SQLiteException -> 0x0037 }
            r8.append(r10)     // Catch:{ SQLiteException -> 0x0037 }
            r8.append(r4)     // Catch:{ SQLiteException -> 0x0037 }
            java.lang.String r0 = r8.toString()     // Catch:{ SQLiteException -> 0x0037 }
            android.database.Cursor r3 = r7.rawQuery(r0, r3)     // Catch:{ SQLiteException -> 0x0037 }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x007e, all -> 0x0078 }
            if (r0 != 0) goto L_0x006c
            goto L_0x024c
        L_0x006c:
            java.lang.String r4 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x007e, all -> 0x0078 }
            java.lang.String r0 = r3.getString(r9)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            r3.close()     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            goto L_0x00ce
        L_0x0078:
            r0 = move-exception
            goto L_0x0080
        L_0x007a:
            r0 = move-exception
        L_0x007b:
            r6 = r3
            goto L_0x0238
        L_0x007e:
            r0 = move-exception
            goto L_0x0083
        L_0x0080:
            r6 = r3
            goto L_0x0252
        L_0x0083:
            r4 = r20
            goto L_0x007b
        L_0x0086:
            int r4 = (r23 > r12 ? 1 : (r23 == r12 ? 0 : -1))
            if (r4 == 0) goto L_0x0098
            java.lang.String r5 = java.lang.String.valueOf(r23)     // Catch:{ SQLiteException -> 0x0037 }
            r8 = r20
            java.lang.String[] r5 = new java.lang.String[]{r8, r5}     // Catch:{ SQLiteException -> 0x0095 }
            goto L_0x009e
        L_0x0095:
            r0 = move-exception
            goto L_0x0237
        L_0x0098:
            r8 = r20
            java.lang.String[] r5 = new java.lang.String[]{r8}     // Catch:{ SQLiteException -> 0x0095 }
        L_0x009e:
            if (r4 == 0) goto L_0x00a2
            java.lang.String r10 = " and rowid <= ?"
        L_0x00a2:
            int r4 = r10.length()     // Catch:{ SQLiteException -> 0x0095 }
            int r4 = r4 + 84
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0095 }
            r14.<init>(r4)     // Catch:{ SQLiteException -> 0x0095 }
            r14.append(r3)     // Catch:{ SQLiteException -> 0x0095 }
            r14.append(r10)     // Catch:{ SQLiteException -> 0x0095 }
            r14.append(r0)     // Catch:{ SQLiteException -> 0x0095 }
            java.lang.String r0 = r14.toString()     // Catch:{ SQLiteException -> 0x0095 }
            android.database.Cursor r3 = r7.rawQuery(r0, r5)     // Catch:{ SQLiteException -> 0x0095 }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0235, all -> 0x0078 }
            if (r0 != 0) goto L_0x00c6
            goto L_0x024c
        L_0x00c6:
            java.lang.String r0 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x0235, all -> 0x0078 }
            r3.close()     // Catch:{ SQLiteException -> 0x0235, all -> 0x0078 }
            r4 = r8
        L_0x00ce:
            java.lang.String r8 = "raw_events_metadata"
            java.lang.String r5 = "metadata"
            java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            java.lang.String r10 = "app_id = ? and metadata_fingerprint = ?"
            r14 = r11
            java.lang.String[] r11 = new java.lang.String[]{r4, r0}     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            r15 = r14
            java.lang.String r14 = "rowid"
            r16 = r15
            java.lang.String r15 = "2"
            r17 = r12
            r12 = 0
            r13 = 0
            r9 = r5
            r5 = r16
            android.database.Cursor r3 = r7.query(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            boolean r8 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            if (r8 != 0) goto L_0x010a
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            java.lang.String r2 = "Raw event metadata record is missing. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.C1402q2.x(r4)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            r0.b(r2, r5)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            goto L_0x024c
        L_0x010a:
            byte[] r8 = r3.getBlob(r5)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            com.google.android.gms.internal.measurement.Z2 r9 = com.google.android.gms.internal.measurement.C1051a3.k0()     // Catch:{ IOException -> 0x0220 }
            com.google.android.gms.internal.measurement.E5 r8 = com.google.android.gms.measurement.internal.u6.W(r9, r8)     // Catch:{ IOException -> 0x0220 }
            com.google.android.gms.internal.measurement.Z2 r8 = (com.google.android.gms.internal.measurement.Z2) r8     // Catch:{ IOException -> 0x0220 }
            com.google.android.gms.internal.measurement.e5 r8 = r8.o()     // Catch:{ IOException -> 0x0220 }
            com.google.android.gms.internal.measurement.a3 r8 = (com.google.android.gms.internal.measurement.C1051a3) r8     // Catch:{ IOException -> 0x0220 }
            boolean r9 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            if (r9 == 0) goto L_0x0137
            com.google.android.gms.measurement.internal.X2 r9 = r1.f5730a     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            com.google.android.gms.measurement.internal.q2 r9 = r9.a()     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            com.google.android.gms.measurement.internal.o2 r9 = r9.r()     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            java.lang.String r10 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.C1402q2.x(r4)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            r9.b(r10, r11)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
        L_0x0137:
            r3.close()     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            N.C0722p.k(r8)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            r2.f6555a = r8     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            com.google.android.gms.measurement.internal.X2 r8 = r1.f5730a     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            com.google.android.gms.measurement.internal.m r9 = r8.w()     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            com.google.android.gms.measurement.internal.c2 r10 = com.google.android.gms.measurement.internal.C1304d2.f6347l1     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            boolean r6 = r9.H(r6, r10)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            java.lang.String r9 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            java.lang.String r10 = "app_id = ? and metadata_fingerprint = ?"
            if (r6 == 0) goto L_0x018c
            java.lang.String[] r6 = new java.lang.String[]{r4, r0}     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            java.lang.String r11 = "select (rowid - 1) as max_rowid from raw_events where app_id = ? and metadata_fingerprint != ? order by rowid limit 1;"
            r12 = -1
            long r14 = r1.q0(r11, r6, r12)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            int r6 = (r23 > r12 ? 1 : (r23 == r12 ? 0 : -1))
            if (r6 != 0) goto L_0x016e
            int r6 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x0167
            r10 = r12
            goto L_0x0170
        L_0x0167:
            java.lang.String[] r0 = new java.lang.String[]{r4, r0}     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
        L_0x016b:
            r11 = r0
            r0 = r8
            goto L_0x01a0
        L_0x016e:
            r10 = r23
        L_0x0170:
            int r6 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x017d
            int r12 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r12 == 0) goto L_0x017d
            long r14 = java.lang.Math.min(r10, r14)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            goto L_0x0180
        L_0x017d:
            if (r6 == 0) goto L_0x0180
            r14 = r10
        L_0x0180:
            java.lang.String r6 = java.lang.String.valueOf(r14)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            java.lang.String[] r0 = new java.lang.String[]{r4, r0, r6}     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
        L_0x0188:
            r11 = r0
            r0 = r8
            r10 = r9
            goto L_0x01a0
        L_0x018c:
            r12 = -1
            int r6 = (r23 > r12 ? 1 : (r23 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x019b
            java.lang.String r6 = java.lang.String.valueOf(r23)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            java.lang.String[] r0 = new java.lang.String[]{r4, r0, r6}     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            goto L_0x0188
        L_0x019b:
            java.lang.String[] r0 = new java.lang.String[]{r4, r0}     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            goto L_0x016b
        L_0x01a0:
            java.lang.String r8 = "raw_events"
            java.lang.String r6 = "rowid"
            java.lang.String r9 = "name"
            java.lang.String r12 = "timestamp"
            java.lang.String r13 = "data"
            java.lang.String[] r9 = new java.lang.String[]{r6, r9, r12, r13}     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            java.lang.String r14 = "rowid"
            r15 = 0
            r12 = 0
            r13 = 0
            android.database.Cursor r6 = r7.query(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            boolean r3 = r6.moveToFirst()     // Catch:{ SQLiteException -> 0x01ef }
            if (r3 == 0) goto L_0x020d
        L_0x01bd:
            long r7 = r6.getLong(r5)     // Catch:{ SQLiteException -> 0x01ef }
            r0 = 3
            byte[] r0 = r6.getBlob(r0)     // Catch:{ SQLiteException -> 0x01ef }
            com.google.android.gms.internal.measurement.N2 r3 = com.google.android.gms.internal.measurement.O2.P()     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.E5 r0 = com.google.android.gms.measurement.internal.u6.W(r3, r0)     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.N2 r0 = (com.google.android.gms.internal.measurement.N2) r0     // Catch:{ IOException -> 0x01f1 }
            r3 = 1
            java.lang.String r9 = r6.getString(r3)     // Catch:{ SQLiteException -> 0x01ef }
            r0.E(r9)     // Catch:{ SQLiteException -> 0x01ef }
            r9 = 2
            long r9 = r6.getLong(r9)     // Catch:{ SQLiteException -> 0x01ef }
            r0.H(r9)     // Catch:{ SQLiteException -> 0x01ef }
            com.google.android.gms.internal.measurement.e5 r0 = r0.o()     // Catch:{ SQLiteException -> 0x01ef }
            com.google.android.gms.internal.measurement.O2 r0 = (com.google.android.gms.internal.measurement.O2) r0     // Catch:{ SQLiteException -> 0x01ef }
            boolean r0 = r2.a(r7, r0)     // Catch:{ SQLiteException -> 0x01ef }
            if (r0 != 0) goto L_0x0206
            goto L_0x021e
        L_0x01ed:
            r0 = move-exception
            goto L_0x0252
        L_0x01ef:
            r0 = move-exception
            goto L_0x0238
        L_0x01f1:
            r0 = move-exception
            r3 = 1
            com.google.android.gms.measurement.internal.X2 r7 = r1.f5730a     // Catch:{ SQLiteException -> 0x01ef }
            com.google.android.gms.measurement.internal.q2 r7 = r7.a()     // Catch:{ SQLiteException -> 0x01ef }
            com.google.android.gms.measurement.internal.o2 r7 = r7.o()     // Catch:{ SQLiteException -> 0x01ef }
            java.lang.String r8 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.C1402q2.x(r4)     // Catch:{ SQLiteException -> 0x01ef }
            r7.c(r8, r9, r0)     // Catch:{ SQLiteException -> 0x01ef }
        L_0x0206:
            boolean r0 = r6.moveToNext()     // Catch:{ SQLiteException -> 0x01ef }
            if (r0 != 0) goto L_0x01bd
            goto L_0x021e
        L_0x020d:
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ SQLiteException -> 0x01ef }
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()     // Catch:{ SQLiteException -> 0x01ef }
            java.lang.String r2 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C1402q2.x(r4)     // Catch:{ SQLiteException -> 0x01ef }
            r0.b(r2, r3)     // Catch:{ SQLiteException -> 0x01ef }
        L_0x021e:
            r3 = r6
            goto L_0x024c
        L_0x0220:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r2 = r1.f5730a     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            java.lang.String r5 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.C1402q2.x(r4)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            r2.c(r5, r6, r0)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0078 }
            goto L_0x024c
        L_0x0235:
            r0 = move-exception
            r6 = r3
        L_0x0237:
            r4 = r8
        L_0x0238:
            com.google.android.gms.measurement.internal.X2 r2 = r1.f5730a     // Catch:{ all -> 0x01ed }
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()     // Catch:{ all -> 0x01ed }
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()     // Catch:{ all -> 0x01ed }
            java.lang.String r3 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C1402q2.x(r4)     // Catch:{ all -> 0x01ed }
            r2.c(r3, r4, r0)     // Catch:{ all -> 0x01ed }
            goto L_0x021e
        L_0x024c:
            if (r3 == 0) goto L_0x0251
            r3.close()
        L_0x0251:
            return
        L_0x0252:
            if (r6 == 0) goto L_0x0257
            r6.close()
        L_0x0257:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1426u.n0(java.lang.String, long, long, com.google.android.gms.measurement.internal.m6):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List o(java.lang.String r19, f0.N r20, int r21) {
        /*
            r18 = this;
            N.C0722p.e(r19)
            r18.h()
            r18.j()
            java.lang.String r0 = " AND NOT "
            java.lang.String r1 = "app_id=?"
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r18.u0()     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            java.lang.String r4 = "upload_queue"
            java.lang.String r5 = "rowId"
            java.lang.String r6 = "app_id"
            java.lang.String r7 = "measurement_batch"
            java.lang.String r8 = "upload_uri"
            java.lang.String r9 = "upload_headers"
            java.lang.String r10 = "upload_type"
            java.lang.String r11 = "retry_count"
            java.lang.String r12 = "creation_timestamp"
            java.lang.String r13 = "associated_row_id"
            java.lang.String r14 = "last_upload_timestamp"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14}     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r6 = r20
            java.util.List r6 = r6.f15314a     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            java.lang.String r6 = T(r6)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            java.lang.String r7 = r18.S()     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            java.lang.String r8 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            int r8 = r8.length()     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            int r8 = r8 + 17
            int r9 = r7.length()     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            int r8 = r8 + r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r9.<init>(r8)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r9.append(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r9.append(r6)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r9.append(r0)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r9.append(r7)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            java.lang.String r6 = r9.toString()     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            java.lang.String[] r7 = new java.lang.String[]{r19}     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            java.lang.String r10 = "creation_timestamp ASC"
            if (r21 <= 0) goto L_0x006a
            java.lang.String r0 = java.lang.String.valueOf(r21)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r11 = r0
            goto L_0x006b
        L_0x006a:
            r11 = r2
        L_0x006b:
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r0.<init>()     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
        L_0x0076:
            boolean r1 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            if (r1 == 0) goto L_0x00bd
            r1 = 0
            long r5 = r2.getLong(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r1 = 2
            byte[] r7 = r2.getBlob(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r1 = 3
            java.lang.String r8 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r1 = 4
            java.lang.String r9 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r1 = 5
            int r10 = r2.getInt(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r1 = 6
            int r11 = r2.getInt(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r1 = 7
            long r12 = r2.getLong(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r1 = 8
            long r14 = r2.getLong(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r1 = 9
            long r16 = r2.getLong(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r3 = r18
            r4 = r19
            com.google.android.gms.measurement.internal.t6 r1 = r3.R(r4, r5, r7, r8, r9, r10, r11, r12, r14, r16)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            if (r1 == 0) goto L_0x0076
            r0.add(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            goto L_0x0076
        L_0x00b9:
            r0 = move-exception
            goto L_0x00c0
        L_0x00bb:
            r0 = move-exception
            goto L_0x00c3
        L_0x00bd:
            r3 = r18
            goto L_0x00d8
        L_0x00c0:
            r3 = r18
            goto L_0x00df
        L_0x00c3:
            r3 = r18
            com.google.android.gms.measurement.internal.X2 r1 = r3.f5730a     // Catch:{ all -> 0x00de }
            com.google.android.gms.measurement.internal.q2 r1 = r1.a()     // Catch:{ all -> 0x00de }
            com.google.android.gms.measurement.internal.o2 r1 = r1.o()     // Catch:{ all -> 0x00de }
            java.lang.String r4 = "Error to querying MeasurementBatch from upload_queue. appId"
            r5 = r19
            r1.c(r4, r5, r0)     // Catch:{ all -> 0x00de }
            java.util.List r0 = java.util.Collections.EMPTY_LIST     // Catch:{ all -> 0x00de }
        L_0x00d8:
            if (r2 == 0) goto L_0x00dd
            r2.close()
        L_0x00dd:
            return r0
        L_0x00de:
            r0 = move-exception
        L_0x00df:
            if (r2 == 0) goto L_0x00e4
            r2.close()
        L_0x00e4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1426u.o(java.lang.String, f0.N, int):java.util.List");
    }

    public final boolean p(String str) {
        C1643K[] kArr = {C1643K.GOOGLE_SIGNAL};
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(kArr[0].A()));
        String T4 = T(arrayList);
        String S4 = S();
        StringBuilder sb = new StringBuilder(String.valueOf(T4).length() + 61 + S4.length());
        sb.append("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
        sb.append(T4);
        sb.append(" AND NOT ");
        sb.append(S4);
        if (p0(sb.toString(), new String[]{str}) != 0) {
            return true;
        }
        return false;
    }

    public final void q(Long l5) {
        h();
        j();
        C0722p.k(l5);
        try {
            if (u0().delete("upload_queue", "rowid=?", new String[]{l5.toString()}) != 1) {
                this.f5730a.a().r().a("Deleted fewer rows from upload_queue than expected");
            }
        } catch (SQLiteException e5) {
            this.f5730a.a().o().b("Failed to delete a MeasurementBatch in a upload_queue table", e5);
            throw e5;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String r() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.u0()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0024, all -> 0x0022 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x001c }
            if (r2 == 0) goto L_0x0036
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x001c }
            r0.close()
            return r1
        L_0x001a:
            r1 = move-exception
            goto L_0x001e
        L_0x001c:
            r2 = move-exception
            goto L_0x0027
        L_0x001e:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x003c
        L_0x0022:
            r0 = move-exception
            goto L_0x003c
        L_0x0024:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L_0x0027:
            com.google.android.gms.measurement.internal.X2 r3 = r6.f5730a     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.o2 r3 = r3.o()     // Catch:{ all -> 0x001a }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.b(r4, r2)     // Catch:{ all -> 0x001a }
        L_0x0036:
            if (r0 == 0) goto L_0x003b
            r0.close()
        L_0x003b:
            return r1
        L_0x003c:
            if (r1 == 0) goto L_0x0041
            r1.close()
        L_0x0041:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1426u.r():java.lang.String");
    }

    public final void r0() {
        j();
        u0().beginTransaction();
    }

    public final boolean s() {
        if (p0("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    public final void s0() {
        j();
        u0().setTransactionSuccessful();
    }

    public final void t(long j5) {
        h();
        j();
        try {
            if (u0().delete("queue", "rowid=?", new String[]{String.valueOf(j5)}) != 1) {
                throw new SQLiteException("Deleted fewer rows from queue than expected");
            }
        } catch (SQLiteException e5) {
            this.f5730a.a().o().b("Failed to delete a bundle in a queue table", e5);
            throw e5;
        }
    }

    public final void t0() {
        j();
        u0().endTransaction();
    }

    /* access modifiers changed from: package-private */
    public final void u() {
        h();
        j();
        if (a0()) {
            q6 q6Var = this.f6129b;
            long a5 = q6Var.L0().f6911e.a();
            X2 x22 = this.f5730a;
            long elapsedRealtime = x22.f().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - a5);
            x22.w();
            if (abs > C1371m.r()) {
                q6Var.L0().f6911e.b(elapsedRealtime);
                h();
                j();
                if (a0()) {
                    SQLiteDatabase u02 = u0();
                    String valueOf = String.valueOf(x22.f().currentTimeMillis());
                    x22.w();
                    int delete = u02.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{valueOf, String.valueOf(C1371m.q())});
                    if (delete > 0) {
                        x22.a().w().b("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase u0() {
        h();
        try {
            return this.f6760d.getWritableDatabase();
        } catch (SQLiteException e5) {
            this.f5730a.a().r().b("Error opening database", e5);
            throw e5;
        }
    }

    /* access modifiers changed from: package-private */
    public final void v(List list) {
        h();
        j();
        C0722p.k(list);
        C0722p.m(list.size());
        if (a0()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(sb2.length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (p0(sb3.toString(), (String[]) null) > 0) {
                this.f5730a.a().r().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase u02 = u0();
                StringBuilder sb4 = new StringBuilder(sb2.length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                u02.execSQL(sb4.toString());
            } catch (SQLiteException e5) {
                this.f5730a.a().o().b("Error incrementing retry count. error", e5);
            }
        }
    }

    public final C v0(String str, String str2) {
        return O("events", str, str2);
    }

    /* access modifiers changed from: package-private */
    public final void w(Long l5) {
        h();
        j();
        C0722p.k(l5);
        if (a0()) {
            StringBuilder sb = new StringBuilder(l5.toString().length() + 86);
            sb.append("SELECT COUNT(1) FROM upload_queue WHERE rowid = ");
            sb.append(l5);
            sb.append(" AND retry_count =  2147483647 LIMIT 1");
            if (p0(sb.toString(), (String[]) null) > 0) {
                this.f5730a.a().r().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase u02 = u0();
                long currentTimeMillis = this.f5730a.f().currentTimeMillis();
                StringBuilder sb2 = new StringBuilder(String.valueOf(currentTimeMillis).length() + 60);
                sb2.append(" SET retry_count = retry_count + 1, last_upload_timestamp = ");
                sb2.append(currentTimeMillis);
                String sb3 = sb2.toString();
                StringBuilder sb4 = new StringBuilder(sb3.length() + 34 + l5.toString().length() + 29);
                sb4.append("UPDATE upload_queue");
                sb4.append(sb3);
                sb4.append(" WHERE rowid = ");
                sb4.append(l5);
                sb4.append(" AND retry_count < 2147483647");
                u02.execSQL(sb4.toString());
            } catch (SQLiteException e5) {
                this.f5730a.a().o().b("Error incrementing retry count. error", e5);
            }
        }
    }

    public final void w0(C c5) {
        P("events", c5);
    }

    /* access modifiers changed from: package-private */
    public final Object x(Cursor cursor, int i5) {
        int type = cursor.getType(i5);
        if (type == 0) {
            this.f5730a.a().o().a("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i5));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i5));
            }
            if (type == 3) {
                return cursor.getString(i5);
            }
            if (type != 4) {
                this.f5730a.a().o().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            this.f5730a.a().o().a("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    public final void x0(String str) {
        C O4;
        Q("events_snapshot", str);
        Cursor cursor = null;
        try {
            cursor = u0().query("events", (String[]) Collections.singletonList(RewardPlus.NAME).toArray(new String[0]), "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (cursor.moveToFirst()) {
                do {
                    String string = cursor.getString(0);
                    if (!(string == null || (O4 = O("events", str, string)) == null)) {
                        P("events_snapshot", O4);
                    }
                } while (cursor.moveToNext());
            }
        } catch (SQLiteException e5) {
            this.f5730a.a().o().c("Error creating snapshot. appId", C1402q2.x(str), e5);
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
        if (cursor != null) {
            cursor.close();
        }
    }

    public final long y() {
        return q0("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c0, code lost:
        if (r8 != null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0059, code lost:
        if (r8 != null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x005b, code lost:
        P("events", r8);
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cf A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void y0(java.lang.String r20) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            java.lang.String r3 = "events_snapshot"
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r4 = "lifetime_count"
            java.lang.String r5 = "name"
            java.lang.String[] r4 = new java.lang.String[]{r5, r4}
            java.util.List r4 = java.util.Arrays.asList(r4)
            r0.<init>(r4)
            java.lang.String r4 = "events"
            java.lang.String r5 = "_f"
            com.google.android.gms.measurement.internal.C r6 = r1.O(r4, r2, r5)
            java.lang.String r7 = "_v"
            com.google.android.gms.measurement.internal.C r8 = r1.O(r4, r2, r7)
            r1.Q(r4, r2)
            r9 = 0
            r10 = 0
            android.database.sqlite.SQLiteDatabase r11 = r1.u0()     // Catch:{ SQLiteException -> 0x009e, all -> 0x009b }
            java.lang.String r12 = "events_snapshot"
            java.lang.String[] r13 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x009e, all -> 0x009b }
            java.lang.Object[] r0 = r0.toArray(r13)     // Catch:{ SQLiteException -> 0x009e, all -> 0x009b }
            r13 = r0
            java.lang.String[] r13 = (java.lang.String[]) r13     // Catch:{ SQLiteException -> 0x009e, all -> 0x009b }
            java.lang.String r14 = "app_id=?"
            java.lang.String[] r15 = new java.lang.String[]{r2}     // Catch:{ SQLiteException -> 0x009e, all -> 0x009b }
            r17 = 0
            r18 = 0
            r16 = 0
            android.database.Cursor r9 = r11.query(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x009e, all -> 0x009b }
            boolean r0 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x009e, all -> 0x009b }
            if (r0 != 0) goto L_0x0060
            r9.close()
            if (r6 == 0) goto L_0x0059
        L_0x0054:
            r1.P(r4, r6)
            goto L_0x00c3
        L_0x0059:
            if (r8 == 0) goto L_0x00c3
        L_0x005b:
            r1.P(r4, r8)
            goto L_0x00c3
        L_0x0060:
            r11 = r10
            r12 = r11
        L_0x0062:
            java.lang.String r0 = r9.getString(r10)     // Catch:{ SQLiteException -> 0x008e, all -> 0x008c }
            r13 = 1
            long r14 = r9.getLong(r13)     // Catch:{ SQLiteException -> 0x008e, all -> 0x008c }
            r16 = 1
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 < 0) goto L_0x0080
            boolean r14 = r5.equals(r0)     // Catch:{ SQLiteException -> 0x008e, all -> 0x008c }
            if (r14 == 0) goto L_0x0079
            r11 = r13
            goto L_0x0080
        L_0x0079:
            boolean r14 = r7.equals(r0)     // Catch:{ SQLiteException -> 0x008e, all -> 0x008c }
            if (r14 == 0) goto L_0x0080
            r12 = r13
        L_0x0080:
            if (r0 == 0) goto L_0x0090
            com.google.android.gms.measurement.internal.C r0 = r1.O(r3, r2, r0)     // Catch:{ SQLiteException -> 0x008e, all -> 0x008c }
            if (r0 == 0) goto L_0x0090
            r1.P(r4, r0)     // Catch:{ SQLiteException -> 0x008e, all -> 0x008c }
            goto L_0x0090
        L_0x008c:
            r0 = move-exception
            goto L_0x0097
        L_0x008e:
            r0 = move-exception
            goto L_0x0099
        L_0x0090:
            boolean r0 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x008e, all -> 0x008c }
            if (r0 != 0) goto L_0x0062
            goto L_0x00b4
        L_0x0097:
            r10 = r11
            goto L_0x00c8
        L_0x0099:
            r10 = r11
            goto L_0x00a0
        L_0x009b:
            r0 = move-exception
            r12 = r10
            goto L_0x00c8
        L_0x009e:
            r0 = move-exception
            r12 = r10
        L_0x00a0:
            com.google.android.gms.measurement.internal.X2 r5 = r1.f5730a     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.measurement.internal.q2 r5 = r5.a()     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.measurement.internal.o2 r5 = r5.o()     // Catch:{ all -> 0x00c7 }
            java.lang.String r7 = "Error querying snapshot. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.C1402q2.x(r2)     // Catch:{ all -> 0x00c7 }
            r5.c(r7, r11, r0)     // Catch:{ all -> 0x00c7 }
            r11 = r10
        L_0x00b4:
            if (r9 == 0) goto L_0x00b9
            r9.close()
        L_0x00b9:
            if (r11 != 0) goto L_0x00be
            if (r6 == 0) goto L_0x00be
            goto L_0x0054
        L_0x00be:
            if (r12 != 0) goto L_0x00c3
            if (r8 == 0) goto L_0x00c3
            goto L_0x005b
        L_0x00c3:
            r1.Q(r3, r2)
            return
        L_0x00c7:
            r0 = move-exception
        L_0x00c8:
            if (r9 == 0) goto L_0x00cd
            r9.close()
        L_0x00cd:
            if (r10 != 0) goto L_0x00d6
            if (r6 != 0) goto L_0x00d2
            goto L_0x00d6
        L_0x00d2:
            r1.P(r4, r6)
            goto L_0x00dd
        L_0x00d6:
            if (r12 != 0) goto L_0x00dd
            if (r8 == 0) goto L_0x00dd
            r1.P(r4, r8)
        L_0x00dd:
            r1.Q(r3, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1426u.y0(java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public final long z(String str, String str2) {
        long j5;
        SQLiteException e5;
        long j6;
        C0722p.e(str);
        C0722p.e("first_open_count");
        h();
        j();
        SQLiteDatabase u02 = u0();
        u02.beginTransaction();
        try {
            StringBuilder sb = new StringBuilder(48);
            sb.append("select ");
            sb.append("first_open_count");
            sb.append(" from app2 where app_id=?");
            j5 = -1;
            j6 = q0(sb.toString(), new String[]{str}, -1);
            if (j6 == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(MBridgeConstans.APP_ID, str);
                contentValues.put("first_open_count", 0);
                contentValues.put("previous_install_count", 0);
                if (u02.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                    this.f5730a.a().o().c("Failed to insert column (got -1). appId", C1402q2.x(str), "first_open_count");
                    u02.endTransaction();
                    return j5;
                }
                j6 = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(MBridgeConstans.APP_ID, str);
                contentValues2.put("first_open_count", Long.valueOf(1 + j6));
                if (((long) u02.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    this.f5730a.a().o().c("Failed to update column (got 0). appId", C1402q2.x(str), "first_open_count");
                    u02.endTransaction();
                    return j5;
                }
                u02.setTransactionSuccessful();
                j5 = j6;
                u02.endTransaction();
                return j5;
            } catch (SQLiteException e6) {
                e5 = e6;
                try {
                    this.f5730a.a().o().d("Error inserting column. appId", C1402q2.x(str), "first_open_count", e5);
                    j5 = j6;
                    u02.endTransaction();
                    return j5;
                } catch (Throwable th) {
                    u02.endTransaction();
                    throw th;
                }
            }
        } catch (SQLiteException e7) {
            e5 = e7;
            j6 = 0;
            this.f5730a.a().o().d("Error inserting column. appId", C1402q2.x(str), "first_open_count", e5);
            j5 = j6;
            u02.endTransaction();
            return j5;
        }
    }

    public final void z0(String str, String str2) {
        C0722p.e(str);
        C0722p.e(str2);
        h();
        j();
        try {
            u0().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e5) {
            X2 x22 = this.f5730a;
            x22.a().o().d("Error deleting user property. appId", C1402q2.x(str), x22.D().c(str2), e5);
        }
    }
}
