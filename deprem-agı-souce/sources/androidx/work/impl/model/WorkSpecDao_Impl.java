package androidx.work.impl.model;

import W2.J;
import X2.C2250q;
import X2.M;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.NetworkRequestCompat;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import r3.C2733c;
import z3.C2972e;

public final class WorkSpecDao_Impl implements WorkSpecDao {
    public static final Companion Companion = new Companion((C2633k) null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<WorkSpec> __insertAdapterOfWorkSpec = new EntityInsertAdapter<WorkSpec>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`trace_tag`,`backoff_on_system_interruptions`,`required_network_type`,`required_network_request`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, WorkSpec workSpec) {
            t.e(sQLiteStatement, "statement");
            t.e(workSpec, "entity");
            sQLiteStatement.bindText(1, workSpec.id);
            sQLiteStatement.bindLong(2, (long) WorkTypeConverters.stateToInt(workSpec.state));
            sQLiteStatement.bindText(3, workSpec.workerClassName);
            sQLiteStatement.bindText(4, workSpec.inputMergerClassName);
            Data.Companion companion = Data.Companion;
            sQLiteStatement.bindBlob(5, companion.toByteArrayInternalV1(workSpec.input));
            sQLiteStatement.bindBlob(6, companion.toByteArrayInternalV1(workSpec.output));
            sQLiteStatement.bindLong(7, workSpec.initialDelay);
            sQLiteStatement.bindLong(8, workSpec.intervalDuration);
            sQLiteStatement.bindLong(9, workSpec.flexDuration);
            sQLiteStatement.bindLong(10, (long) workSpec.runAttemptCount);
            sQLiteStatement.bindLong(11, (long) WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
            sQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
            sQLiteStatement.bindLong(13, workSpec.lastEnqueueTime);
            sQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
            sQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
            sQLiteStatement.bindLong(16, workSpec.expedited ? 1 : 0);
            sQLiteStatement.bindLong(17, (long) WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
            sQLiteStatement.bindLong(18, (long) workSpec.getPeriodCount());
            sQLiteStatement.bindLong(19, (long) workSpec.getGeneration());
            sQLiteStatement.bindLong(20, workSpec.getNextScheduleTimeOverride());
            sQLiteStatement.bindLong(21, (long) workSpec.getNextScheduleTimeOverrideGeneration());
            sQLiteStatement.bindLong(22, (long) workSpec.getStopReason());
            String traceTag = workSpec.getTraceTag();
            if (traceTag == null) {
                sQLiteStatement.bindNull(23);
            } else {
                sQLiteStatement.bindText(23, traceTag);
            }
            Boolean backOffOnSystemInterruptions = workSpec.getBackOffOnSystemInterruptions();
            Integer valueOf = backOffOnSystemInterruptions != null ? Integer.valueOf(backOffOnSystemInterruptions.booleanValue() ? 1 : 0) : null;
            if (valueOf == null) {
                sQLiteStatement.bindNull(24);
            } else {
                sQLiteStatement.bindLong(24, (long) valueOf.intValue());
            }
            Constraints constraints = workSpec.constraints;
            sQLiteStatement.bindLong(25, (long) WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
            sQLiteStatement.bindBlob(26, WorkTypeConverters.fromNetworkRequest$work_runtime_release(constraints.getRequiredNetworkRequestCompat$work_runtime_release()));
            sQLiteStatement.bindLong(27, constraints.requiresCharging() ? 1 : 0);
            sQLiteStatement.bindLong(28, constraints.requiresDeviceIdle() ? 1 : 0);
            sQLiteStatement.bindLong(29, constraints.requiresBatteryNotLow() ? 1 : 0);
            sQLiteStatement.bindLong(30, constraints.requiresStorageNotLow() ? 1 : 0);
            sQLiteStatement.bindLong(31, constraints.getContentTriggerUpdateDelayMillis());
            sQLiteStatement.bindLong(32, constraints.getContentTriggerMaxDelayMillis());
            sQLiteStatement.bindBlob(33, WorkTypeConverters.setOfTriggersToByteArray(constraints.getContentUriTriggers()));
        }
    };
    private final EntityDeleteOrUpdateAdapter<WorkSpec> __updateAdapterOfWorkSpec = new EntityDeleteOrUpdateAdapter<WorkSpec>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`next_schedule_time_override` = ?,`next_schedule_time_override_generation` = ?,`stop_reason` = ?,`trace_tag` = ?,`backoff_on_system_interruptions` = ?,`required_network_type` = ?,`required_network_request` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, WorkSpec workSpec) {
            t.e(sQLiteStatement, "statement");
            t.e(workSpec, "entity");
            sQLiteStatement.bindText(1, workSpec.id);
            sQLiteStatement.bindLong(2, (long) WorkTypeConverters.stateToInt(workSpec.state));
            sQLiteStatement.bindText(3, workSpec.workerClassName);
            sQLiteStatement.bindText(4, workSpec.inputMergerClassName);
            Data.Companion companion = Data.Companion;
            sQLiteStatement.bindBlob(5, companion.toByteArrayInternalV1(workSpec.input));
            sQLiteStatement.bindBlob(6, companion.toByteArrayInternalV1(workSpec.output));
            sQLiteStatement.bindLong(7, workSpec.initialDelay);
            sQLiteStatement.bindLong(8, workSpec.intervalDuration);
            sQLiteStatement.bindLong(9, workSpec.flexDuration);
            sQLiteStatement.bindLong(10, (long) workSpec.runAttemptCount);
            sQLiteStatement.bindLong(11, (long) WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
            sQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
            sQLiteStatement.bindLong(13, workSpec.lastEnqueueTime);
            sQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
            sQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
            sQLiteStatement.bindLong(16, workSpec.expedited ? 1 : 0);
            sQLiteStatement.bindLong(17, (long) WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
            sQLiteStatement.bindLong(18, (long) workSpec.getPeriodCount());
            sQLiteStatement.bindLong(19, (long) workSpec.getGeneration());
            sQLiteStatement.bindLong(20, workSpec.getNextScheduleTimeOverride());
            sQLiteStatement.bindLong(21, (long) workSpec.getNextScheduleTimeOverrideGeneration());
            sQLiteStatement.bindLong(22, (long) workSpec.getStopReason());
            String traceTag = workSpec.getTraceTag();
            if (traceTag == null) {
                sQLiteStatement.bindNull(23);
            } else {
                sQLiteStatement.bindText(23, traceTag);
            }
            Boolean backOffOnSystemInterruptions = workSpec.getBackOffOnSystemInterruptions();
            Integer valueOf = backOffOnSystemInterruptions != null ? Integer.valueOf(backOffOnSystemInterruptions.booleanValue() ? 1 : 0) : null;
            if (valueOf == null) {
                sQLiteStatement.bindNull(24);
            } else {
                sQLiteStatement.bindLong(24, (long) valueOf.intValue());
            }
            Constraints constraints = workSpec.constraints;
            sQLiteStatement.bindLong(25, (long) WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
            sQLiteStatement.bindBlob(26, WorkTypeConverters.fromNetworkRequest$work_runtime_release(constraints.getRequiredNetworkRequestCompat$work_runtime_release()));
            sQLiteStatement.bindLong(27, constraints.requiresCharging() ? 1 : 0);
            sQLiteStatement.bindLong(28, constraints.requiresDeviceIdle() ? 1 : 0);
            sQLiteStatement.bindLong(29, constraints.requiresBatteryNotLow() ? 1 : 0);
            sQLiteStatement.bindLong(30, constraints.requiresStorageNotLow() ? 1 : 0);
            sQLiteStatement.bindLong(31, constraints.getContentTriggerUpdateDelayMillis());
            sQLiteStatement.bindLong(32, constraints.getContentTriggerMaxDelayMillis());
            sQLiteStatement.bindBlob(33, WorkTypeConverters.setOfTriggersToByteArray(constraints.getContentUriTriggers()));
            sQLiteStatement.bindText(34, workSpec.id);
        }
    };

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final List<C2733c> getRequiredConverters() {
            return C2250q.g();
        }

        private Companion() {
        }
    }

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        t.e(roomDatabase, "__db");
        this.__db = roomDatabase;
    }

    private final void __fetchRelationshipWorkProgressAsandroidxWorkData(SQLiteConnection sQLiteConnection, ArrayMap<String, List<Data>> arrayMap) {
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                RelationUtil.recursiveFetchArrayMap(arrayMap, true, new i0(this, sQLiteConnection));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
            StringUtil.appendPlaceholders(sb, keySet.size());
            sb.append(")");
            String sb2 = sb.toString();
            t.d(sb2, "toString(...)");
            SQLiteStatement prepare = sQLiteConnection.prepare(sb2);
            int i5 = 1;
            for (String bindText : keySet) {
                prepare.bindText(i5, bindText);
                i5++;
            }
            try {
                int columnIndex = SQLiteStatementUtil.getColumnIndex(prepare, "work_spec_id");
                if (columnIndex != -1) {
                    while (prepare.step()) {
                        List list = arrayMap.get(prepare.getText(columnIndex));
                        if (list != null) {
                            list.add(Data.Companion.fromByteArray(prepare.getBlob(0)));
                        }
                    }
                    prepare.close();
                }
            } finally {
                prepare.close();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final J __fetchRelationshipWorkProgressAsandroidxWorkData$lambda$53(WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap arrayMap) {
        t.e(arrayMap, "_tmpMap");
        workSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap);
        return J.f19942a;
    }

    private final void __fetchRelationshipWorkTagAsjavaLangString(SQLiteConnection sQLiteConnection, ArrayMap<String, List<String>> arrayMap) {
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                RelationUtil.recursiveFetchArrayMap(arrayMap, true, new l0(this, sQLiteConnection));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
            StringUtil.appendPlaceholders(sb, keySet.size());
            sb.append(")");
            String sb2 = sb.toString();
            t.d(sb2, "toString(...)");
            SQLiteStatement prepare = sQLiteConnection.prepare(sb2);
            int i5 = 1;
            for (String bindText : keySet) {
                prepare.bindText(i5, bindText);
                i5++;
            }
            try {
                int columnIndex = SQLiteStatementUtil.getColumnIndex(prepare, "work_spec_id");
                if (columnIndex != -1) {
                    while (prepare.step()) {
                        List list = arrayMap.get(prepare.getText(columnIndex));
                        if (list != null) {
                            list.add(prepare.getText(0));
                        }
                    }
                    prepare.close();
                }
            } finally {
                prepare.close();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final J __fetchRelationshipWorkTagAsjavaLangString$lambda$52(WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap arrayMap) {
        t.e(arrayMap, "_tmpMap");
        workSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final int countNonFinishedContentUriTriggerWorkers$lambda$36(String str, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            int i5 = 0;
            if (prepare.step()) {
                i5 = (int) prepare.getLong(0);
            }
            return i5;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static final J delete$lambda$37(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            prepare.step();
            prepare.close();
            return J.f19942a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final List getAllEligibleWorkSpecsForScheduling$lambda$29(String str, int i5, SQLiteConnection sQLiteConnection) {
        boolean z4;
        String text;
        int i6;
        Integer num;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        try {
            prepare.bindLong(1, (long) i5);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "worker_class_name");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "input_merger_class_name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "input");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "output");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "initial_delay");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "interval_duration");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "flex_duration");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "run_attempt_count");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_policy");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_delay_duration");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "last_enqueue_time");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "minimum_retention_duration");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "schedule_requested_at");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "run_in_foreground");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "out_of_quota_policy");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "period_count");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "generation");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "next_schedule_time_override");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "stop_reason");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trace_tag");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_on_system_interruptions");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "required_network_type");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "required_network_request");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_charging");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_device_idle");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_battery_not_low");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_storage_not_low");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trigger_content_update_delay");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trigger_max_content_delay");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text2 = prepare.getText(columnIndexOrThrow);
                int i7 = columnIndexOrThrow13;
                int i8 = columnIndexOrThrow14;
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(columnIndexOrThrow2));
                String text3 = prepare.getText(columnIndexOrThrow3);
                String text4 = prepare.getText(columnIndexOrThrow4);
                byte[] blob = prepare.getBlob(columnIndexOrThrow5);
                Data.Companion companion = Data.Companion;
                Data fromByteArray = companion.fromByteArray(blob);
                Data fromByteArray2 = companion.fromByteArray(prepare.getBlob(columnIndexOrThrow6));
                long j5 = prepare.getLong(columnIndexOrThrow7);
                long j6 = prepare.getLong(columnIndexOrThrow8);
                long j7 = prepare.getLong(columnIndexOrThrow9);
                int i9 = (int) prepare.getLong(columnIndexOrThrow10);
                int i10 = columnIndexOrThrow;
                int i11 = columnIndexOrThrow2;
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(columnIndexOrThrow11));
                long j8 = prepare.getLong(columnIndexOrThrow12);
                int i12 = i7;
                long j9 = prepare.getLong(i12);
                int i13 = i8;
                long j10 = prepare.getLong(i13);
                int i14 = i12;
                int i15 = columnIndexOrThrow15;
                long j11 = prepare.getLong(i15);
                columnIndexOrThrow15 = i15;
                int i16 = i13;
                int i17 = columnIndexOrThrow16;
                int i18 = columnIndexOrThrow3;
                if (((int) prepare.getLong(i17)) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int i19 = columnIndexOrThrow17;
                int i20 = columnIndexOrThrow4;
                OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int) prepare.getLong(i19));
                int i21 = columnIndexOrThrow18;
                int i22 = i19;
                int i23 = i17;
                int i24 = columnIndexOrThrow19;
                int i25 = i21;
                int i26 = columnIndexOrThrow20;
                long j12 = prepare.getLong(i26);
                int i27 = (int) prepare.getLong(i21);
                int i28 = i24;
                int i29 = (int) prepare.getLong(i24);
                int i30 = columnIndexOrThrow21;
                columnIndexOrThrow21 = i30;
                int i31 = (int) prepare.getLong(i30);
                int i32 = columnIndexOrThrow22;
                int i33 = (int) prepare.getLong(i32);
                int i34 = columnIndexOrThrow23;
                Boolean bool = null;
                if (prepare.isNull(i34)) {
                    text = null;
                } else {
                    text = prepare.getText(i34);
                }
                int i35 = i33;
                int i36 = columnIndexOrThrow24;
                if (prepare.isNull(i36)) {
                    i6 = i34;
                    columnIndexOrThrow22 = i32;
                    num = null;
                } else {
                    i6 = i34;
                    columnIndexOrThrow22 = i32;
                    num = Integer.valueOf((int) prepare.getLong(i36));
                }
                if (num != null) {
                    if (num.intValue() != 0) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    bool = Boolean.valueOf(z9);
                }
                Boolean bool2 = bool;
                int i37 = columnIndexOrThrow25;
                int i38 = i26;
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(i37));
                int i39 = columnIndexOrThrow26;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(i39));
                int i40 = i36;
                int i41 = i37;
                int i42 = columnIndexOrThrow27;
                if (((int) prepare.getLong(i42)) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                int i43 = i39;
                int i44 = columnIndexOrThrow28;
                if (((int) prepare.getLong(i44)) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int i45 = i42;
                int i46 = columnIndexOrThrow29;
                if (((int) prepare.getLong(i46)) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                int i47 = i44;
                columnIndexOrThrow29 = i46;
                int i48 = columnIndexOrThrow30;
                if (((int) prepare.getLong(i48)) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                int i49 = columnIndexOrThrow31;
                int i50 = columnIndexOrThrow32;
                columnIndexOrThrow31 = i49;
                int i51 = columnIndexOrThrow33;
                arrayList.add(new WorkSpec(text2, intToState, text3, text4, fromByteArray, fromByteArray2, j5, j6, j7, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z5, z6, z7, z8, prepare.getLong(i49), prepare.getLong(i50), WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(i51))), i9, intToBackoffPolicy, j8, j9, j10, j11, z4, intToOutOfQuotaPolicy, i27, i29, j12, i31, i35, text, bool2));
                int i52 = i45;
                columnIndexOrThrow28 = i47;
                columnIndexOrThrow4 = i20;
                columnIndexOrThrow17 = i22;
                columnIndexOrThrow18 = i25;
                columnIndexOrThrow19 = i28;
                columnIndexOrThrow20 = i38;
                columnIndexOrThrow23 = i6;
                columnIndexOrThrow24 = i40;
                columnIndexOrThrow25 = i41;
                columnIndexOrThrow26 = i43;
                columnIndexOrThrow27 = i52;
                columnIndexOrThrow33 = i51;
                columnIndexOrThrow32 = i50;
                columnIndexOrThrow30 = i48;
                columnIndexOrThrow = i10;
                columnIndexOrThrow13 = i14;
                columnIndexOrThrow14 = i16;
                columnIndexOrThrow2 = i11;
                columnIndexOrThrow3 = i18;
                columnIndexOrThrow16 = i23;
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final List getAllUnfinishedWork$lambda$21(String str, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(prepare.getText(0));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final List getAllWorkSpecIds$lambda$5(String str, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(prepare.getText(0));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final List getAllWorkSpecIdsLiveData$lambda$6(String str, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(prepare.getText(0));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final List getEligibleWorkForScheduling$lambda$25(String str, int i5, SQLiteConnection sQLiteConnection) {
        boolean z4;
        String text;
        int i6;
        Integer num;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        try {
            prepare.bindLong(1, (long) i5);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "worker_class_name");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "input_merger_class_name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "input");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "output");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "initial_delay");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "interval_duration");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "flex_duration");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "run_attempt_count");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_policy");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_delay_duration");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "last_enqueue_time");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "minimum_retention_duration");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "schedule_requested_at");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "run_in_foreground");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "out_of_quota_policy");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "period_count");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "generation");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "next_schedule_time_override");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "stop_reason");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trace_tag");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_on_system_interruptions");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "required_network_type");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "required_network_request");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_charging");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_device_idle");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_battery_not_low");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_storage_not_low");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trigger_content_update_delay");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trigger_max_content_delay");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text2 = prepare.getText(columnIndexOrThrow);
                int i7 = columnIndexOrThrow13;
                int i8 = columnIndexOrThrow14;
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(columnIndexOrThrow2));
                String text3 = prepare.getText(columnIndexOrThrow3);
                String text4 = prepare.getText(columnIndexOrThrow4);
                byte[] blob = prepare.getBlob(columnIndexOrThrow5);
                Data.Companion companion = Data.Companion;
                Data fromByteArray = companion.fromByteArray(blob);
                Data fromByteArray2 = companion.fromByteArray(prepare.getBlob(columnIndexOrThrow6));
                long j5 = prepare.getLong(columnIndexOrThrow7);
                long j6 = prepare.getLong(columnIndexOrThrow8);
                long j7 = prepare.getLong(columnIndexOrThrow9);
                int i9 = (int) prepare.getLong(columnIndexOrThrow10);
                int i10 = columnIndexOrThrow;
                int i11 = columnIndexOrThrow2;
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(columnIndexOrThrow11));
                long j8 = prepare.getLong(columnIndexOrThrow12);
                int i12 = i7;
                long j9 = prepare.getLong(i12);
                int i13 = i8;
                long j10 = prepare.getLong(i13);
                int i14 = i12;
                int i15 = columnIndexOrThrow15;
                long j11 = prepare.getLong(i15);
                columnIndexOrThrow15 = i15;
                int i16 = i13;
                int i17 = columnIndexOrThrow16;
                int i18 = columnIndexOrThrow3;
                if (((int) prepare.getLong(i17)) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int i19 = columnIndexOrThrow17;
                int i20 = columnIndexOrThrow4;
                OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int) prepare.getLong(i19));
                int i21 = columnIndexOrThrow18;
                int i22 = i19;
                int i23 = i17;
                int i24 = columnIndexOrThrow19;
                int i25 = i21;
                int i26 = columnIndexOrThrow20;
                long j12 = prepare.getLong(i26);
                int i27 = (int) prepare.getLong(i21);
                int i28 = i24;
                int i29 = (int) prepare.getLong(i24);
                int i30 = columnIndexOrThrow21;
                columnIndexOrThrow21 = i30;
                int i31 = (int) prepare.getLong(i30);
                int i32 = columnIndexOrThrow22;
                int i33 = (int) prepare.getLong(i32);
                int i34 = columnIndexOrThrow23;
                Boolean bool = null;
                if (prepare.isNull(i34)) {
                    text = null;
                } else {
                    text = prepare.getText(i34);
                }
                int i35 = i33;
                int i36 = columnIndexOrThrow24;
                if (prepare.isNull(i36)) {
                    i6 = i34;
                    columnIndexOrThrow22 = i32;
                    num = null;
                } else {
                    i6 = i34;
                    columnIndexOrThrow22 = i32;
                    num = Integer.valueOf((int) prepare.getLong(i36));
                }
                if (num != null) {
                    if (num.intValue() != 0) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    bool = Boolean.valueOf(z9);
                }
                Boolean bool2 = bool;
                int i37 = columnIndexOrThrow25;
                int i38 = i26;
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(i37));
                int i39 = columnIndexOrThrow26;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(i39));
                int i40 = i36;
                int i41 = i37;
                int i42 = columnIndexOrThrow27;
                if (((int) prepare.getLong(i42)) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                int i43 = i39;
                int i44 = columnIndexOrThrow28;
                if (((int) prepare.getLong(i44)) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int i45 = i42;
                int i46 = columnIndexOrThrow29;
                if (((int) prepare.getLong(i46)) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                int i47 = i44;
                columnIndexOrThrow29 = i46;
                int i48 = columnIndexOrThrow30;
                if (((int) prepare.getLong(i48)) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                int i49 = columnIndexOrThrow31;
                int i50 = columnIndexOrThrow32;
                columnIndexOrThrow31 = i49;
                int i51 = columnIndexOrThrow33;
                arrayList.add(new WorkSpec(text2, intToState, text3, text4, fromByteArray, fromByteArray2, j5, j6, j7, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z5, z6, z7, z8, prepare.getLong(i49), prepare.getLong(i50), WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(i51))), i9, intToBackoffPolicy, j8, j9, j10, j11, z4, intToOutOfQuotaPolicy, i27, i29, j12, i31, i35, text, bool2));
                int i52 = i45;
                columnIndexOrThrow28 = i47;
                columnIndexOrThrow4 = i20;
                columnIndexOrThrow17 = i22;
                columnIndexOrThrow18 = i25;
                columnIndexOrThrow19 = i28;
                columnIndexOrThrow20 = i38;
                columnIndexOrThrow23 = i6;
                columnIndexOrThrow24 = i40;
                columnIndexOrThrow25 = i41;
                columnIndexOrThrow26 = i43;
                columnIndexOrThrow27 = i52;
                columnIndexOrThrow33 = i51;
                columnIndexOrThrow32 = i50;
                columnIndexOrThrow30 = i48;
                columnIndexOrThrow = i10;
                columnIndexOrThrow13 = i14;
                columnIndexOrThrow14 = i16;
                columnIndexOrThrow2 = i11;
                columnIndexOrThrow3 = i18;
                columnIndexOrThrow16 = i23;
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final List getEligibleWorkForSchedulingWithContentUris$lambda$27(String str, SQLiteConnection sQLiteConnection) {
        boolean z4;
        String text;
        int i5;
        int i6;
        Integer num;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "worker_class_name");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "input_merger_class_name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "input");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "output");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "initial_delay");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "interval_duration");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "flex_duration");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "run_attempt_count");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_policy");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_delay_duration");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "last_enqueue_time");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "minimum_retention_duration");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "schedule_requested_at");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "run_in_foreground");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "out_of_quota_policy");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "period_count");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "generation");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "next_schedule_time_override");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "stop_reason");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trace_tag");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_on_system_interruptions");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "required_network_type");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "required_network_request");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_charging");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_device_idle");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_battery_not_low");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_storage_not_low");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trigger_content_update_delay");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trigger_max_content_delay");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text2 = prepare.getText(columnIndexOrThrow);
                int i7 = columnIndexOrThrow14;
                ArrayList arrayList2 = arrayList;
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(columnIndexOrThrow2));
                String text3 = prepare.getText(columnIndexOrThrow3);
                String text4 = prepare.getText(columnIndexOrThrow4);
                byte[] blob = prepare.getBlob(columnIndexOrThrow5);
                Data.Companion companion = Data.Companion;
                Data fromByteArray = companion.fromByteArray(blob);
                Data fromByteArray2 = companion.fromByteArray(prepare.getBlob(columnIndexOrThrow6));
                long j5 = prepare.getLong(columnIndexOrThrow7);
                long j6 = prepare.getLong(columnIndexOrThrow8);
                long j7 = prepare.getLong(columnIndexOrThrow9);
                int i8 = (int) prepare.getLong(columnIndexOrThrow10);
                int i9 = columnIndexOrThrow2;
                int i10 = columnIndexOrThrow3;
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(columnIndexOrThrow11));
                long j8 = prepare.getLong(columnIndexOrThrow12);
                long j9 = prepare.getLong(columnIndexOrThrow13);
                int i11 = i7;
                long j10 = prepare.getLong(i11);
                int i12 = columnIndexOrThrow15;
                long j11 = prepare.getLong(i12);
                int i13 = columnIndexOrThrow;
                int i14 = i11;
                int i15 = columnIndexOrThrow16;
                int i16 = i12;
                if (((int) prepare.getLong(i15)) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int i17 = columnIndexOrThrow17;
                int i18 = columnIndexOrThrow4;
                OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int) prepare.getLong(i17));
                int i19 = columnIndexOrThrow18;
                int i20 = columnIndexOrThrow5;
                int i21 = i19;
                int i22 = columnIndexOrThrow19;
                int i23 = i17;
                int i24 = columnIndexOrThrow20;
                long j12 = prepare.getLong(i24);
                int i25 = i15;
                int i26 = (int) prepare.getLong(i22);
                int i27 = columnIndexOrThrow21;
                int i28 = i24;
                int i29 = (int) prepare.getLong(i27);
                int i30 = (int) prepare.getLong(i19);
                int i31 = columnIndexOrThrow22;
                int i32 = i22;
                int i33 = (int) prepare.getLong(i31);
                int i34 = columnIndexOrThrow23;
                Boolean bool = null;
                if (prepare.isNull(i34)) {
                    text = null;
                } else {
                    text = prepare.getText(i34);
                }
                int i35 = i27;
                int i36 = columnIndexOrThrow24;
                if (prepare.isNull(i36)) {
                    i5 = i29;
                    i6 = i31;
                    num = null;
                } else {
                    i5 = i29;
                    i6 = i31;
                    num = Integer.valueOf((int) prepare.getLong(i36));
                }
                if (num != null) {
                    if (num.intValue() != 0) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    bool = Boolean.valueOf(z9);
                }
                int i37 = i33;
                int i38 = columnIndexOrThrow25;
                Boolean bool2 = bool;
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(i38));
                int i39 = columnIndexOrThrow26;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(i39));
                columnIndexOrThrow25 = i38;
                columnIndexOrThrow26 = i39;
                int i40 = columnIndexOrThrow27;
                if (((int) prepare.getLong(i40)) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                columnIndexOrThrow27 = i40;
                int i41 = columnIndexOrThrow28;
                if (((int) prepare.getLong(i41)) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int i42 = i34;
                int i43 = columnIndexOrThrow29;
                if (((int) prepare.getLong(i43)) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                int i44 = i41;
                columnIndexOrThrow29 = i43;
                int i45 = columnIndexOrThrow30;
                if (((int) prepare.getLong(i45)) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                int i46 = columnIndexOrThrow31;
                int i47 = columnIndexOrThrow32;
                int i48 = i36;
                int i49 = columnIndexOrThrow33;
                columnIndexOrThrow33 = i49;
                ArrayList arrayList3 = arrayList2;
                arrayList3.add(new WorkSpec(text2, intToState, text3, text4, fromByteArray, fromByteArray2, j5, j6, j7, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z5, z6, z7, z8, prepare.getLong(i46), prepare.getLong(i47), WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(i49))), i8, intToBackoffPolicy, j8, j9, j10, j11, z4, intToOutOfQuotaPolicy, i30, i26, j12, i5, i37, text, bool2));
                int i50 = i48;
                columnIndexOrThrow30 = i45;
                columnIndexOrThrow4 = i18;
                columnIndexOrThrow17 = i23;
                columnIndexOrThrow19 = i32;
                columnIndexOrThrow22 = i6;
                columnIndexOrThrow24 = i50;
                columnIndexOrThrow31 = i46;
                columnIndexOrThrow32 = i47;
                columnIndexOrThrow2 = i9;
                columnIndexOrThrow14 = i14;
                columnIndexOrThrow3 = i10;
                arrayList = arrayList3;
                columnIndexOrThrow = i13;
                columnIndexOrThrow15 = i16;
                columnIndexOrThrow16 = i25;
                columnIndexOrThrow20 = i28;
                columnIndexOrThrow21 = i35;
                columnIndexOrThrow23 = i42;
                columnIndexOrThrow28 = i44;
                columnIndexOrThrow5 = i20;
                columnIndexOrThrow18 = i21;
            }
            ArrayList arrayList4 = arrayList;
            prepare.close();
            return arrayList4;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final List getInputsFromPrerequisites$lambda$18(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(Data.Companion.fromByteArray(prepare.getBlob(0)));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final List getRecentlyCompletedWork$lambda$35(String str, long j5, SQLiteConnection sQLiteConnection) {
        boolean z4;
        String text;
        int i5;
        Integer num;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        try {
            prepare.bindLong(1, j5);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "worker_class_name");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "input_merger_class_name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "input");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "output");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "initial_delay");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "interval_duration");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "flex_duration");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "run_attempt_count");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_policy");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_delay_duration");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "last_enqueue_time");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "minimum_retention_duration");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "schedule_requested_at");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "run_in_foreground");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "out_of_quota_policy");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "period_count");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "generation");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "next_schedule_time_override");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "stop_reason");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trace_tag");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_on_system_interruptions");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "required_network_type");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "required_network_request");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_charging");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_device_idle");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_battery_not_low");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_storage_not_low");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trigger_content_update_delay");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trigger_max_content_delay");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text2 = prepare.getText(columnIndexOrThrow);
                int i6 = columnIndexOrThrow13;
                int i7 = columnIndexOrThrow14;
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(columnIndexOrThrow2));
                String text3 = prepare.getText(columnIndexOrThrow3);
                String text4 = prepare.getText(columnIndexOrThrow4);
                byte[] blob = prepare.getBlob(columnIndexOrThrow5);
                Data.Companion companion = Data.Companion;
                Data fromByteArray = companion.fromByteArray(blob);
                Data fromByteArray2 = companion.fromByteArray(prepare.getBlob(columnIndexOrThrow6));
                long j6 = prepare.getLong(columnIndexOrThrow7);
                long j7 = prepare.getLong(columnIndexOrThrow8);
                long j8 = prepare.getLong(columnIndexOrThrow9);
                int i8 = (int) prepare.getLong(columnIndexOrThrow10);
                int i9 = columnIndexOrThrow;
                int i10 = columnIndexOrThrow2;
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(columnIndexOrThrow11));
                long j9 = prepare.getLong(columnIndexOrThrow12);
                int i11 = i6;
                long j10 = prepare.getLong(i11);
                int i12 = i7;
                long j11 = prepare.getLong(i12);
                int i13 = i11;
                int i14 = columnIndexOrThrow15;
                long j12 = prepare.getLong(i14);
                columnIndexOrThrow15 = i14;
                int i15 = i12;
                int i16 = columnIndexOrThrow16;
                int i17 = columnIndexOrThrow3;
                if (((int) prepare.getLong(i16)) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int i18 = columnIndexOrThrow17;
                int i19 = columnIndexOrThrow4;
                OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int) prepare.getLong(i18));
                int i20 = columnIndexOrThrow18;
                int i21 = i18;
                int i22 = i16;
                int i23 = columnIndexOrThrow19;
                int i24 = i20;
                int i25 = columnIndexOrThrow20;
                long j13 = prepare.getLong(i25);
                int i26 = (int) prepare.getLong(i20);
                int i27 = i23;
                int i28 = (int) prepare.getLong(i23);
                int i29 = columnIndexOrThrow21;
                columnIndexOrThrow21 = i29;
                int i30 = (int) prepare.getLong(i29);
                int i31 = columnIndexOrThrow22;
                int i32 = (int) prepare.getLong(i31);
                int i33 = columnIndexOrThrow23;
                Boolean bool = null;
                if (prepare.isNull(i33)) {
                    text = null;
                } else {
                    text = prepare.getText(i33);
                }
                int i34 = i32;
                int i35 = columnIndexOrThrow24;
                if (prepare.isNull(i35)) {
                    i5 = i33;
                    columnIndexOrThrow22 = i31;
                    num = null;
                } else {
                    i5 = i33;
                    columnIndexOrThrow22 = i31;
                    num = Integer.valueOf((int) prepare.getLong(i35));
                }
                if (num != null) {
                    if (num.intValue() != 0) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    bool = Boolean.valueOf(z9);
                }
                Boolean bool2 = bool;
                int i36 = columnIndexOrThrow25;
                int i37 = i25;
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(i36));
                int i38 = columnIndexOrThrow26;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(i38));
                int i39 = i35;
                int i40 = i36;
                int i41 = columnIndexOrThrow27;
                if (((int) prepare.getLong(i41)) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                int i42 = i38;
                int i43 = columnIndexOrThrow28;
                if (((int) prepare.getLong(i43)) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int i44 = i41;
                int i45 = columnIndexOrThrow29;
                if (((int) prepare.getLong(i45)) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                int i46 = i43;
                columnIndexOrThrow29 = i45;
                int i47 = columnIndexOrThrow30;
                if (((int) prepare.getLong(i47)) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                int i48 = columnIndexOrThrow31;
                int i49 = columnIndexOrThrow32;
                columnIndexOrThrow31 = i48;
                int i50 = columnIndexOrThrow33;
                arrayList.add(new WorkSpec(text2, intToState, text3, text4, fromByteArray, fromByteArray2, j6, j7, j8, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z5, z6, z7, z8, prepare.getLong(i48), prepare.getLong(i49), WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(i50))), i8, intToBackoffPolicy, j9, j10, j11, j12, z4, intToOutOfQuotaPolicy, i26, i28, j13, i30, i34, text, bool2));
                int i51 = i46;
                columnIndexOrThrow4 = i19;
                columnIndexOrThrow17 = i21;
                columnIndexOrThrow18 = i24;
                columnIndexOrThrow19 = i27;
                columnIndexOrThrow20 = i37;
                columnIndexOrThrow23 = i5;
                columnIndexOrThrow24 = i39;
                columnIndexOrThrow25 = i40;
                columnIndexOrThrow26 = i42;
                columnIndexOrThrow27 = i44;
                columnIndexOrThrow28 = i51;
                columnIndexOrThrow33 = i50;
                columnIndexOrThrow32 = i49;
                columnIndexOrThrow30 = i47;
                columnIndexOrThrow = i9;
                columnIndexOrThrow13 = i13;
                columnIndexOrThrow14 = i15;
                columnIndexOrThrow2 = i10;
                columnIndexOrThrow3 = i17;
                columnIndexOrThrow16 = i22;
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final List getRunningWork$lambda$33(String str, SQLiteConnection sQLiteConnection) {
        boolean z4;
        String text;
        int i5;
        int i6;
        Integer num;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "worker_class_name");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "input_merger_class_name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "input");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "output");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "initial_delay");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "interval_duration");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "flex_duration");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "run_attempt_count");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_policy");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_delay_duration");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "last_enqueue_time");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "minimum_retention_duration");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "schedule_requested_at");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "run_in_foreground");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "out_of_quota_policy");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "period_count");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "generation");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "next_schedule_time_override");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "stop_reason");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trace_tag");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_on_system_interruptions");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "required_network_type");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "required_network_request");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_charging");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_device_idle");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_battery_not_low");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_storage_not_low");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trigger_content_update_delay");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trigger_max_content_delay");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text2 = prepare.getText(columnIndexOrThrow);
                int i7 = columnIndexOrThrow14;
                ArrayList arrayList2 = arrayList;
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(columnIndexOrThrow2));
                String text3 = prepare.getText(columnIndexOrThrow3);
                String text4 = prepare.getText(columnIndexOrThrow4);
                byte[] blob = prepare.getBlob(columnIndexOrThrow5);
                Data.Companion companion = Data.Companion;
                Data fromByteArray = companion.fromByteArray(blob);
                Data fromByteArray2 = companion.fromByteArray(prepare.getBlob(columnIndexOrThrow6));
                long j5 = prepare.getLong(columnIndexOrThrow7);
                long j6 = prepare.getLong(columnIndexOrThrow8);
                long j7 = prepare.getLong(columnIndexOrThrow9);
                int i8 = (int) prepare.getLong(columnIndexOrThrow10);
                int i9 = columnIndexOrThrow2;
                int i10 = columnIndexOrThrow3;
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(columnIndexOrThrow11));
                long j8 = prepare.getLong(columnIndexOrThrow12);
                long j9 = prepare.getLong(columnIndexOrThrow13);
                int i11 = i7;
                long j10 = prepare.getLong(i11);
                int i12 = columnIndexOrThrow15;
                long j11 = prepare.getLong(i12);
                int i13 = columnIndexOrThrow;
                int i14 = i11;
                int i15 = columnIndexOrThrow16;
                int i16 = i12;
                if (((int) prepare.getLong(i15)) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int i17 = columnIndexOrThrow17;
                int i18 = columnIndexOrThrow4;
                OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int) prepare.getLong(i17));
                int i19 = columnIndexOrThrow18;
                int i20 = columnIndexOrThrow5;
                int i21 = i19;
                int i22 = columnIndexOrThrow19;
                int i23 = i17;
                int i24 = columnIndexOrThrow20;
                long j12 = prepare.getLong(i24);
                int i25 = i15;
                int i26 = (int) prepare.getLong(i22);
                int i27 = columnIndexOrThrow21;
                int i28 = i24;
                int i29 = (int) prepare.getLong(i27);
                int i30 = (int) prepare.getLong(i19);
                int i31 = columnIndexOrThrow22;
                int i32 = i22;
                int i33 = (int) prepare.getLong(i31);
                int i34 = columnIndexOrThrow23;
                Boolean bool = null;
                if (prepare.isNull(i34)) {
                    text = null;
                } else {
                    text = prepare.getText(i34);
                }
                int i35 = i27;
                int i36 = columnIndexOrThrow24;
                if (prepare.isNull(i36)) {
                    i5 = i29;
                    i6 = i31;
                    num = null;
                } else {
                    i5 = i29;
                    i6 = i31;
                    num = Integer.valueOf((int) prepare.getLong(i36));
                }
                if (num != null) {
                    if (num.intValue() != 0) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    bool = Boolean.valueOf(z9);
                }
                int i37 = i33;
                int i38 = columnIndexOrThrow25;
                Boolean bool2 = bool;
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(i38));
                int i39 = columnIndexOrThrow26;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(i39));
                columnIndexOrThrow25 = i38;
                columnIndexOrThrow26 = i39;
                int i40 = columnIndexOrThrow27;
                if (((int) prepare.getLong(i40)) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                columnIndexOrThrow27 = i40;
                int i41 = columnIndexOrThrow28;
                if (((int) prepare.getLong(i41)) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int i42 = i34;
                int i43 = columnIndexOrThrow29;
                if (((int) prepare.getLong(i43)) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                int i44 = i41;
                columnIndexOrThrow29 = i43;
                int i45 = columnIndexOrThrow30;
                if (((int) prepare.getLong(i45)) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                int i46 = columnIndexOrThrow31;
                int i47 = columnIndexOrThrow32;
                int i48 = i36;
                int i49 = columnIndexOrThrow33;
                columnIndexOrThrow33 = i49;
                ArrayList arrayList3 = arrayList2;
                arrayList3.add(new WorkSpec(text2, intToState, text3, text4, fromByteArray, fromByteArray2, j5, j6, j7, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z5, z6, z7, z8, prepare.getLong(i46), prepare.getLong(i47), WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(i49))), i8, intToBackoffPolicy, j8, j9, j10, j11, z4, intToOutOfQuotaPolicy, i30, i26, j12, i5, i37, text, bool2));
                int i50 = i48;
                columnIndexOrThrow30 = i45;
                columnIndexOrThrow4 = i18;
                columnIndexOrThrow17 = i23;
                columnIndexOrThrow19 = i32;
                columnIndexOrThrow22 = i6;
                columnIndexOrThrow24 = i50;
                columnIndexOrThrow31 = i46;
                columnIndexOrThrow32 = i47;
                columnIndexOrThrow2 = i9;
                columnIndexOrThrow14 = i14;
                columnIndexOrThrow3 = i10;
                arrayList = arrayList3;
                columnIndexOrThrow = i13;
                columnIndexOrThrow15 = i16;
                columnIndexOrThrow16 = i25;
                columnIndexOrThrow20 = i28;
                columnIndexOrThrow21 = i35;
                columnIndexOrThrow23 = i42;
                columnIndexOrThrow28 = i44;
                columnIndexOrThrow5 = i20;
                columnIndexOrThrow18 = i21;
            }
            ArrayList arrayList4 = arrayList;
            prepare.close();
            return arrayList4;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final Long getScheduleRequestedAtLiveData$lambda$23(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            Long l5 = null;
            if (prepare.step()) {
                if (!prepare.isNull(0)) {
                    l5 = Long.valueOf(prepare.getLong(0));
                }
            }
            return l5;
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final List getScheduledWork$lambda$31(String str, SQLiteConnection sQLiteConnection) {
        boolean z4;
        String text;
        int i5;
        int i6;
        Integer num;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "worker_class_name");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "input_merger_class_name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "input");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "output");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "initial_delay");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "interval_duration");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "flex_duration");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "run_attempt_count");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_policy");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_delay_duration");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "last_enqueue_time");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "minimum_retention_duration");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "schedule_requested_at");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "run_in_foreground");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "out_of_quota_policy");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "period_count");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "generation");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "next_schedule_time_override");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "stop_reason");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trace_tag");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "backoff_on_system_interruptions");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "required_network_type");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "required_network_request");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_charging");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_device_idle");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_battery_not_low");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "requires_storage_not_low");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trigger_content_update_delay");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trigger_max_content_delay");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text2 = prepare.getText(columnIndexOrThrow);
                int i7 = columnIndexOrThrow14;
                ArrayList arrayList2 = arrayList;
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(columnIndexOrThrow2));
                String text3 = prepare.getText(columnIndexOrThrow3);
                String text4 = prepare.getText(columnIndexOrThrow4);
                byte[] blob = prepare.getBlob(columnIndexOrThrow5);
                Data.Companion companion = Data.Companion;
                Data fromByteArray = companion.fromByteArray(blob);
                Data fromByteArray2 = companion.fromByteArray(prepare.getBlob(columnIndexOrThrow6));
                long j5 = prepare.getLong(columnIndexOrThrow7);
                long j6 = prepare.getLong(columnIndexOrThrow8);
                long j7 = prepare.getLong(columnIndexOrThrow9);
                int i8 = (int) prepare.getLong(columnIndexOrThrow10);
                int i9 = columnIndexOrThrow2;
                int i10 = columnIndexOrThrow3;
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(columnIndexOrThrow11));
                long j8 = prepare.getLong(columnIndexOrThrow12);
                long j9 = prepare.getLong(columnIndexOrThrow13);
                int i11 = i7;
                long j10 = prepare.getLong(i11);
                int i12 = columnIndexOrThrow15;
                long j11 = prepare.getLong(i12);
                int i13 = columnIndexOrThrow;
                int i14 = i11;
                int i15 = columnIndexOrThrow16;
                int i16 = i12;
                if (((int) prepare.getLong(i15)) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int i17 = columnIndexOrThrow17;
                int i18 = columnIndexOrThrow4;
                OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int) prepare.getLong(i17));
                int i19 = columnIndexOrThrow18;
                int i20 = columnIndexOrThrow5;
                int i21 = i19;
                int i22 = columnIndexOrThrow19;
                int i23 = i17;
                int i24 = columnIndexOrThrow20;
                long j12 = prepare.getLong(i24);
                int i25 = i15;
                int i26 = (int) prepare.getLong(i22);
                int i27 = columnIndexOrThrow21;
                int i28 = i24;
                int i29 = (int) prepare.getLong(i27);
                int i30 = (int) prepare.getLong(i19);
                int i31 = columnIndexOrThrow22;
                int i32 = i22;
                int i33 = (int) prepare.getLong(i31);
                int i34 = columnIndexOrThrow23;
                Boolean bool = null;
                if (prepare.isNull(i34)) {
                    text = null;
                } else {
                    text = prepare.getText(i34);
                }
                int i35 = i27;
                int i36 = columnIndexOrThrow24;
                if (prepare.isNull(i36)) {
                    i5 = i29;
                    i6 = i31;
                    num = null;
                } else {
                    i5 = i29;
                    i6 = i31;
                    num = Integer.valueOf((int) prepare.getLong(i36));
                }
                if (num != null) {
                    if (num.intValue() != 0) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    bool = Boolean.valueOf(z9);
                }
                int i37 = i33;
                int i38 = columnIndexOrThrow25;
                Boolean bool2 = bool;
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(i38));
                int i39 = columnIndexOrThrow26;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(i39));
                columnIndexOrThrow25 = i38;
                columnIndexOrThrow26 = i39;
                int i40 = columnIndexOrThrow27;
                if (((int) prepare.getLong(i40)) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                columnIndexOrThrow27 = i40;
                int i41 = columnIndexOrThrow28;
                if (((int) prepare.getLong(i41)) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int i42 = i34;
                int i43 = columnIndexOrThrow29;
                if (((int) prepare.getLong(i43)) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                int i44 = i41;
                columnIndexOrThrow29 = i43;
                int i45 = columnIndexOrThrow30;
                if (((int) prepare.getLong(i45)) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                int i46 = columnIndexOrThrow31;
                int i47 = columnIndexOrThrow32;
                int i48 = i36;
                int i49 = columnIndexOrThrow33;
                columnIndexOrThrow33 = i49;
                ArrayList arrayList3 = arrayList2;
                arrayList3.add(new WorkSpec(text2, intToState, text3, text4, fromByteArray, fromByteArray2, j5, j6, j7, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z5, z6, z7, z8, prepare.getLong(i46), prepare.getLong(i47), WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(i49))), i8, intToBackoffPolicy, j8, j9, j10, j11, z4, intToOutOfQuotaPolicy, i30, i26, j12, i5, i37, text, bool2));
                int i50 = i48;
                columnIndexOrThrow30 = i45;
                columnIndexOrThrow4 = i18;
                columnIndexOrThrow17 = i23;
                columnIndexOrThrow19 = i32;
                columnIndexOrThrow22 = i6;
                columnIndexOrThrow24 = i50;
                columnIndexOrThrow31 = i46;
                columnIndexOrThrow32 = i47;
                columnIndexOrThrow2 = i9;
                columnIndexOrThrow14 = i14;
                columnIndexOrThrow3 = i10;
                arrayList = arrayList3;
                columnIndexOrThrow = i13;
                columnIndexOrThrow15 = i16;
                columnIndexOrThrow16 = i25;
                columnIndexOrThrow20 = i28;
                columnIndexOrThrow21 = i35;
                columnIndexOrThrow23 = i42;
                columnIndexOrThrow28 = i44;
                columnIndexOrThrow5 = i20;
                columnIndexOrThrow18 = i21;
            }
            ArrayList arrayList4 = arrayList;
            prepare.close();
            return arrayList4;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final WorkInfo.State getState$lambda$7(String str, String str2, SQLiteConnection sQLiteConnection) {
        Integer num;
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            WorkInfo.State state = null;
            if (prepare.step()) {
                if (prepare.isNull(0)) {
                    num = null;
                } else {
                    num = Integer.valueOf((int) prepare.getLong(0));
                }
                if (num != null) {
                    state = WorkTypeConverters.intToState(num.intValue());
                }
            }
            return state;
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final List getUnfinishedWorkWithName$lambda$20(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(prepare.getText(0));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final List getUnfinishedWorkWithTag$lambda$19(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(prepare.getText(0));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r33v0, resolved type: androidx.work.impl.model.WorkSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r33v1, resolved type: androidx.work.impl.model.WorkSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r33v2, resolved type: androidx.work.impl.model.WorkSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r67v0, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r33v3, resolved type: androidx.work.impl.model.WorkSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r33v5, resolved type: androidx.work.impl.model.WorkSpec} */
    /* JADX WARNING: type inference failed for: r33v4, types: [java.lang.Boolean] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.work.impl.model.WorkSpec getWorkSpec$lambda$3(java.lang.String r68, java.lang.String r69, androidx.sqlite.SQLiteConnection r70) {
        /*
            r0 = r70
            java.lang.String r1 = "_connection"
            kotlin.jvm.internal.t.e(r0, r1)
            r1 = r68
            androidx.sqlite.SQLiteStatement r1 = r0.prepare(r1)
            r0 = 1
            r2 = r69
            r1.bindText(r0, r2)     // Catch:{ all -> 0x01cf }
            java.lang.String r2 = "id"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x01cf }
            java.lang.String r3 = "state"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x01cf }
            java.lang.String r4 = "worker_class_name"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x01cf }
            java.lang.String r5 = "input_merger_class_name"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x01cf }
            java.lang.String r6 = "input"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x01cf }
            java.lang.String r7 = "output"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x01cf }
            java.lang.String r8 = "initial_delay"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x01cf }
            java.lang.String r9 = "interval_duration"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x01cf }
            java.lang.String r10 = "flex_duration"
            int r10 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r10)     // Catch:{ all -> 0x01cf }
            java.lang.String r11 = "run_attempt_count"
            int r11 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r11)     // Catch:{ all -> 0x01cf }
            java.lang.String r12 = "backoff_policy"
            int r12 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r12)     // Catch:{ all -> 0x01cf }
            java.lang.String r13 = "backoff_delay_duration"
            int r13 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r13)     // Catch:{ all -> 0x01cf }
            java.lang.String r14 = "last_enqueue_time"
            int r14 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r14)     // Catch:{ all -> 0x01cf }
            java.lang.String r15 = "minimum_retention_duration"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x01cf }
            java.lang.String r0 = "schedule_requested_at"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r69 = r0
            java.lang.String r0 = "run_in_foreground"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r70 = r0
            java.lang.String r0 = "out_of_quota_policy"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r16 = r0
            java.lang.String r0 = "period_count"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r17 = r0
            java.lang.String r0 = "generation"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r18 = r0
            java.lang.String r0 = "next_schedule_time_override"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r19 = r0
            java.lang.String r0 = "next_schedule_time_override_generation"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r20 = r0
            java.lang.String r0 = "stop_reason"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r21 = r0
            java.lang.String r0 = "trace_tag"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r22 = r0
            java.lang.String r0 = "backoff_on_system_interruptions"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r23 = r0
            java.lang.String r0 = "required_network_type"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r24 = r0
            java.lang.String r0 = "required_network_request"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r25 = r0
            java.lang.String r0 = "requires_charging"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r26 = r0
            java.lang.String r0 = "requires_device_idle"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r27 = r0
            java.lang.String r0 = "requires_battery_not_low"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r28 = r0
            java.lang.String r0 = "requires_storage_not_low"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r29 = r0
            java.lang.String r0 = "trigger_content_update_delay"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r30 = r0
            java.lang.String r0 = "trigger_max_content_delay"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            r31 = r0
            java.lang.String r0 = "content_uri_triggers"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x01cf }
            boolean r32 = r1.step()     // Catch:{ all -> 0x01cf }
            r33 = 0
            if (r32 == 0) goto L_0x0247
            java.lang.String r35 = r1.getText(r2)     // Catch:{ all -> 0x01cf }
            long r2 = r1.getLong(r3)     // Catch:{ all -> 0x01cf }
            int r2 = (int) r2     // Catch:{ all -> 0x01cf }
            androidx.work.WorkInfo$State r36 = androidx.work.impl.model.WorkTypeConverters.intToState(r2)     // Catch:{ all -> 0x01cf }
            java.lang.String r37 = r1.getText(r4)     // Catch:{ all -> 0x01cf }
            java.lang.String r38 = r1.getText(r5)     // Catch:{ all -> 0x01cf }
            byte[] r2 = r1.getBlob(r6)     // Catch:{ all -> 0x01cf }
            androidx.work.Data$Companion r3 = androidx.work.Data.Companion     // Catch:{ all -> 0x01cf }
            androidx.work.Data r39 = r3.fromByteArray(r2)     // Catch:{ all -> 0x01cf }
            byte[] r2 = r1.getBlob(r7)     // Catch:{ all -> 0x01cf }
            androidx.work.Data r40 = r3.fromByteArray(r2)     // Catch:{ all -> 0x01cf }
            long r41 = r1.getLong(r8)     // Catch:{ all -> 0x01cf }
            long r43 = r1.getLong(r9)     // Catch:{ all -> 0x01cf }
            long r45 = r1.getLong(r10)     // Catch:{ all -> 0x01cf }
            long r2 = r1.getLong(r11)     // Catch:{ all -> 0x01cf }
            int r2 = (int) r2     // Catch:{ all -> 0x01cf }
            long r3 = r1.getLong(r12)     // Catch:{ all -> 0x01cf }
            int r3 = (int) r3     // Catch:{ all -> 0x01cf }
            androidx.work.BackoffPolicy r49 = androidx.work.impl.model.WorkTypeConverters.intToBackoffPolicy(r3)     // Catch:{ all -> 0x01cf }
            long r50 = r1.getLong(r13)     // Catch:{ all -> 0x01cf }
            long r52 = r1.getLong(r14)     // Catch:{ all -> 0x01cf }
            long r54 = r1.getLong(r15)     // Catch:{ all -> 0x01cf }
            r3 = r69
            long r56 = r1.getLong(r3)     // Catch:{ all -> 0x01cf }
            r3 = r70
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x01cf }
            int r3 = (int) r3     // Catch:{ all -> 0x01cf }
            r4 = 0
            if (r3 == 0) goto L_0x0167
            r58 = 1
        L_0x0164:
            r3 = r16
            goto L_0x016a
        L_0x0167:
            r58 = r4
            goto L_0x0164
        L_0x016a:
            long r5 = r1.getLong(r3)     // Catch:{ all -> 0x01cf }
            int r3 = (int) r5     // Catch:{ all -> 0x01cf }
            androidx.work.OutOfQuotaPolicy r59 = androidx.work.impl.model.WorkTypeConverters.intToOutOfQuotaPolicy(r3)     // Catch:{ all -> 0x01cf }
            r3 = r17
            long r5 = r1.getLong(r3)     // Catch:{ all -> 0x01cf }
            int r3 = (int) r5     // Catch:{ all -> 0x01cf }
            r5 = r18
            long r5 = r1.getLong(r5)     // Catch:{ all -> 0x01cf }
            int r5 = (int) r5     // Catch:{ all -> 0x01cf }
            r6 = r19
            long r62 = r1.getLong(r6)     // Catch:{ all -> 0x01cf }
            r6 = r20
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x01cf }
            int r6 = (int) r6     // Catch:{ all -> 0x01cf }
            r7 = r21
            long r7 = r1.getLong(r7)     // Catch:{ all -> 0x01cf }
            int r7 = (int) r7     // Catch:{ all -> 0x01cf }
            r8 = r22
            boolean r9 = r1.isNull(r8)     // Catch:{ all -> 0x01cf }
            if (r9 == 0) goto L_0x01a2
            r66 = r33
        L_0x019f:
            r8 = r23
            goto L_0x01a9
        L_0x01a2:
            java.lang.String r8 = r1.getText(r8)     // Catch:{ all -> 0x01cf }
            r66 = r8
            goto L_0x019f
        L_0x01a9:
            boolean r9 = r1.isNull(r8)     // Catch:{ all -> 0x01cf }
            if (r9 == 0) goto L_0x01b2
            r8 = r33
            goto L_0x01bb
        L_0x01b2:
            long r8 = r1.getLong(r8)     // Catch:{ all -> 0x01cf }
            int r8 = (int) r8     // Catch:{ all -> 0x01cf }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x01cf }
        L_0x01bb:
            if (r8 == 0) goto L_0x01ca
            int r8 = r8.intValue()     // Catch:{ all -> 0x01cf }
            if (r8 == 0) goto L_0x01c5
            r8 = 1
            goto L_0x01c6
        L_0x01c5:
            r8 = r4
        L_0x01c6:
            java.lang.Boolean r33 = java.lang.Boolean.valueOf(r8)     // Catch:{ all -> 0x01cf }
        L_0x01ca:
            r8 = r24
            r67 = r33
            goto L_0x01d2
        L_0x01cf:
            r0 = move-exception
            goto L_0x024b
        L_0x01d2:
            long r8 = r1.getLong(r8)     // Catch:{ all -> 0x01cf }
            int r8 = (int) r8     // Catch:{ all -> 0x01cf }
            androidx.work.NetworkType r11 = androidx.work.impl.model.WorkTypeConverters.intToNetworkType(r8)     // Catch:{ all -> 0x01cf }
            r8 = r25
            byte[] r8 = r1.getBlob(r8)     // Catch:{ all -> 0x01cf }
            androidx.work.impl.utils.NetworkRequestCompat r10 = androidx.work.impl.model.WorkTypeConverters.toNetworkRequest$work_runtime_release(r8)     // Catch:{ all -> 0x01cf }
            r8 = r26
            long r8 = r1.getLong(r8)     // Catch:{ all -> 0x01cf }
            int r8 = (int) r8     // Catch:{ all -> 0x01cf }
            if (r8 == 0) goto L_0x01f2
            r12 = 1
        L_0x01ef:
            r8 = r27
            goto L_0x01f4
        L_0x01f2:
            r12 = r4
            goto L_0x01ef
        L_0x01f4:
            long r8 = r1.getLong(r8)     // Catch:{ all -> 0x01cf }
            int r8 = (int) r8     // Catch:{ all -> 0x01cf }
            if (r8 == 0) goto L_0x01ff
            r13 = 1
        L_0x01fc:
            r8 = r28
            goto L_0x0201
        L_0x01ff:
            r13 = r4
            goto L_0x01fc
        L_0x0201:
            long r8 = r1.getLong(r8)     // Catch:{ all -> 0x01cf }
            int r8 = (int) r8     // Catch:{ all -> 0x01cf }
            if (r8 == 0) goto L_0x020c
            r14 = 1
        L_0x0209:
            r8 = r29
            goto L_0x020e
        L_0x020c:
            r14 = r4
            goto L_0x0209
        L_0x020e:
            long r8 = r1.getLong(r8)     // Catch:{ all -> 0x01cf }
            int r8 = (int) r8     // Catch:{ all -> 0x01cf }
            if (r8 == 0) goto L_0x0219
            r15 = 1
        L_0x0216:
            r4 = r30
            goto L_0x021b
        L_0x0219:
            r15 = r4
            goto L_0x0216
        L_0x021b:
            long r16 = r1.getLong(r4)     // Catch:{ all -> 0x01cf }
            r4 = r31
            long r18 = r1.getLong(r4)     // Catch:{ all -> 0x01cf }
            byte[] r0 = r1.getBlob(r0)     // Catch:{ all -> 0x01cf }
            java.util.Set r20 = androidx.work.impl.model.WorkTypeConverters.byteArrayToSetOfTriggers(r0)     // Catch:{ all -> 0x01cf }
            androidx.work.Constraints r47 = new androidx.work.Constraints     // Catch:{ all -> 0x01cf }
            r9 = r47
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r18, r20)     // Catch:{ all -> 0x01cf }
            r47 = r9
            androidx.work.impl.model.WorkSpec r34 = new androidx.work.impl.model.WorkSpec     // Catch:{ all -> 0x01cf }
            r48 = r2
            r60 = r3
            r61 = r5
            r64 = r6
            r65 = r7
            r34.<init>(r35, r36, r37, r38, r39, r40, r41, r43, r45, r47, r48, r49, r50, r52, r54, r56, r58, r59, r60, r61, r62, r64, r65, r66, r67)     // Catch:{ all -> 0x01cf }
            r33 = r34
        L_0x0247:
            r1.close()
            return r33
        L_0x024b:
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDao_Impl.getWorkSpec$lambda$3(java.lang.String, java.lang.String, androidx.sqlite.SQLiteConnection):androidx.work.impl.model.WorkSpec");
    }

    /* access modifiers changed from: private */
    public static final List getWorkSpecIdAndStatesForName$lambda$4(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(new WorkSpec.IdAndState(prepare.getText(0), WorkTypeConverters.intToState((int) prepare.getLong(1))));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final List getWorkStatusPojoFlowDataForIds$lambda$11(String str, List list, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i5;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        WorkSpecDao_Impl workSpecDao_Impl2 = workSpecDao_Impl;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        try {
            Iterator it = list.iterator();
            int i6 = 1;
            int i7 = 1;
            while (it.hasNext()) {
                prepare.bindText(i7, (String) it.next());
                i7++;
            }
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (true) {
                i5 = 0;
                if (!prepare.step()) {
                    break;
                }
                String text = prepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = prepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            prepare.reset();
            workSpecDao_Impl2.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection2, arrayMap);
            workSpecDao_Impl2.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection2, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text3 = prepare.getText(i5);
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(i6));
                Data fromByteArray = Data.Companion.fromByteArray(prepare.getBlob(2));
                int i8 = (int) prepare.getLong(3);
                int i9 = (int) prepare.getLong(4);
                long j5 = prepare.getLong(14);
                long j6 = prepare.getLong(15);
                long j7 = prepare.getLong(16);
                ArrayMap arrayMap3 = arrayMap2;
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(17));
                long j8 = prepare.getLong(18);
                long j9 = prepare.getLong(19);
                int i10 = (int) prepare.getLong(20);
                long j10 = prepare.getLong(21);
                int i11 = (int) prepare.getLong(22);
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(5));
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(6));
                if (((int) prepare.getLong(7)) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (((int) prepare.getLong(8)) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (((int) prepare.getLong(9)) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (((int) prepare.getLong(10)) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Constraints constraints = new Constraints(networkRequest$work_runtime_release, intToNetworkType, z4, z5, z6, z7, prepare.getLong(11), prepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(13)));
                Object i12 = M.i(arrayMap, prepare.getText(0));
                t.d(i12, "getValue(...)");
                ArrayMap arrayMap4 = arrayMap3;
                Object i13 = M.i(arrayMap4, prepare.getText(0));
                t.d(i13, "getValue(...)");
                Constraints constraints2 = constraints;
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, intToState, fromByteArray, j5, j6, j7, constraints2, i8, intToBackoffPolicy, j8, j9, i10, i9, j10, i11, (List) i12, (List) i13));
                arrayMap2 = arrayMap4;
                i6 = 1;
                i5 = 0;
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final List getWorkStatusPojoFlowForName$lambda$17(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i5;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        WorkSpecDao_Impl workSpecDao_Impl2 = workSpecDao_Impl;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        int i6 = 1;
        try {
            prepare.bindText(1, str2);
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (true) {
                i5 = 0;
                if (!prepare.step()) {
                    break;
                }
                String text = prepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = prepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            prepare.reset();
            workSpecDao_Impl2.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection2, arrayMap);
            workSpecDao_Impl2.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection2, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text3 = prepare.getText(i5);
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(i6));
                Data fromByteArray = Data.Companion.fromByteArray(prepare.getBlob(2));
                int i7 = (int) prepare.getLong(3);
                int i8 = (int) prepare.getLong(4);
                long j5 = prepare.getLong(14);
                long j6 = prepare.getLong(15);
                long j7 = prepare.getLong(16);
                ArrayMap arrayMap3 = arrayMap;
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(17));
                long j8 = prepare.getLong(18);
                long j9 = prepare.getLong(19);
                int i9 = (int) prepare.getLong(20);
                long j10 = prepare.getLong(21);
                int i10 = (int) prepare.getLong(22);
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(5));
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(6));
                if (((int) prepare.getLong(7)) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (((int) prepare.getLong(8)) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (((int) prepare.getLong(9)) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (((int) prepare.getLong(10)) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Constraints constraints = new Constraints(networkRequest$work_runtime_release, intToNetworkType, z4, z5, z6, z7, prepare.getLong(11), prepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(13)));
                ArrayMap arrayMap4 = arrayMap3;
                Object i11 = M.i(arrayMap4, prepare.getText(0));
                t.d(i11, "getValue(...)");
                int i12 = i7;
                Object i13 = M.i(arrayMap2, prepare.getText(0));
                t.d(i13, "getValue(...)");
                Constraints constraints2 = constraints;
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, intToState, fromByteArray, j5, j6, j7, constraints2, i12, intToBackoffPolicy, j8, j9, i9, i8, j10, i10, (List) i11, (List) i13));
                arrayMap = arrayMap4;
                i5 = 0;
                i6 = 1;
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final List getWorkStatusPojoFlowForTag$lambda$13(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i5;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        WorkSpecDao_Impl workSpecDao_Impl2 = workSpecDao_Impl;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        int i6 = 1;
        try {
            prepare.bindText(1, str2);
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (true) {
                i5 = 0;
                if (!prepare.step()) {
                    break;
                }
                String text = prepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = prepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            prepare.reset();
            workSpecDao_Impl2.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection2, arrayMap);
            workSpecDao_Impl2.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection2, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text3 = prepare.getText(i5);
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(i6));
                Data fromByteArray = Data.Companion.fromByteArray(prepare.getBlob(2));
                int i7 = (int) prepare.getLong(3);
                int i8 = (int) prepare.getLong(4);
                long j5 = prepare.getLong(14);
                long j6 = prepare.getLong(15);
                long j7 = prepare.getLong(16);
                ArrayMap arrayMap3 = arrayMap;
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(17));
                long j8 = prepare.getLong(18);
                long j9 = prepare.getLong(19);
                int i9 = (int) prepare.getLong(20);
                long j10 = prepare.getLong(21);
                int i10 = (int) prepare.getLong(22);
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(5));
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(6));
                if (((int) prepare.getLong(7)) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (((int) prepare.getLong(8)) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (((int) prepare.getLong(9)) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (((int) prepare.getLong(10)) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Constraints constraints = new Constraints(networkRequest$work_runtime_release, intToNetworkType, z4, z5, z6, z7, prepare.getLong(11), prepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(13)));
                ArrayMap arrayMap4 = arrayMap3;
                Object i11 = M.i(arrayMap4, prepare.getText(0));
                t.d(i11, "getValue(...)");
                int i12 = i7;
                Object i13 = M.i(arrayMap2, prepare.getText(0));
                t.d(i13, "getValue(...)");
                Constraints constraints2 = constraints;
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, intToState, fromByteArray, j5, j6, j7, constraints2, i12, intToBackoffPolicy, j8, j9, i9, i8, j10, i10, (List) i11, (List) i13));
                arrayMap = arrayMap4;
                i5 = 0;
                i6 = 1;
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final WorkSpec.WorkInfoPojo getWorkStatusPojoForId$lambda$8(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        WorkSpec.WorkInfoPojo workInfoPojo;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        WorkSpecDao_Impl workSpecDao_Impl2 = workSpecDao_Impl;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        try {
            prepare.bindText(1, str2);
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (prepare.step()) {
                String text = prepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = prepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            prepare.reset();
            workSpecDao_Impl2.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection2, arrayMap);
            workSpecDao_Impl2.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection2, arrayMap2);
            if (prepare.step()) {
                String text3 = prepare.getText(0);
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(1));
                Data fromByteArray = Data.Companion.fromByteArray(prepare.getBlob(2));
                int i5 = (int) prepare.getLong(3);
                int i6 = (int) prepare.getLong(4);
                long j5 = prepare.getLong(14);
                long j6 = prepare.getLong(15);
                long j7 = prepare.getLong(16);
                ArrayMap arrayMap3 = arrayMap;
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(17));
                long j8 = prepare.getLong(18);
                long j9 = prepare.getLong(19);
                int i7 = (int) prepare.getLong(20);
                long j10 = prepare.getLong(21);
                int i8 = (int) prepare.getLong(22);
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(5));
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(6));
                if (((int) prepare.getLong(7)) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (((int) prepare.getLong(8)) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (((int) prepare.getLong(9)) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (((int) prepare.getLong(10)) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Constraints constraints = new Constraints(networkRequest$work_runtime_release, intToNetworkType, z4, z5, z6, z7, prepare.getLong(11), prepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(13)));
                Object i9 = M.i(arrayMap3, prepare.getText(0));
                t.d(i9, "getValue(...)");
                Object i10 = M.i(arrayMap2, prepare.getText(0));
                t.d(i10, "getValue(...)");
                int i11 = i7;
                Constraints constraints2 = constraints;
                workInfoPojo = new WorkSpec.WorkInfoPojo(text3, intToState, fromByteArray, j5, j6, j7, constraints2, i5, intToBackoffPolicy, j8, j9, i11, i6, j10, i8, (List) i9, (List) i10);
            } else {
                workInfoPojo = null;
            }
            prepare.close();
            return workInfoPojo;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final List getWorkStatusPojoForIds$lambda$9(String str, List list, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i5;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        WorkSpecDao_Impl workSpecDao_Impl2 = workSpecDao_Impl;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        try {
            Iterator it = list.iterator();
            int i6 = 1;
            int i7 = 1;
            while (it.hasNext()) {
                prepare.bindText(i7, (String) it.next());
                i7++;
            }
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (true) {
                i5 = 0;
                if (!prepare.step()) {
                    break;
                }
                String text = prepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = prepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            prepare.reset();
            workSpecDao_Impl2.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection2, arrayMap);
            workSpecDao_Impl2.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection2, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text3 = prepare.getText(i5);
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(i6));
                Data fromByteArray = Data.Companion.fromByteArray(prepare.getBlob(2));
                int i8 = (int) prepare.getLong(3);
                int i9 = (int) prepare.getLong(4);
                long j5 = prepare.getLong(14);
                long j6 = prepare.getLong(15);
                long j7 = prepare.getLong(16);
                ArrayMap arrayMap3 = arrayMap2;
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(17));
                long j8 = prepare.getLong(18);
                long j9 = prepare.getLong(19);
                int i10 = (int) prepare.getLong(20);
                long j10 = prepare.getLong(21);
                int i11 = (int) prepare.getLong(22);
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(5));
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(6));
                if (((int) prepare.getLong(7)) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (((int) prepare.getLong(8)) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (((int) prepare.getLong(9)) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (((int) prepare.getLong(10)) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Constraints constraints = new Constraints(networkRequest$work_runtime_release, intToNetworkType, z4, z5, z6, z7, prepare.getLong(11), prepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(13)));
                Object i12 = M.i(arrayMap, prepare.getText(0));
                t.d(i12, "getValue(...)");
                ArrayMap arrayMap4 = arrayMap3;
                Object i13 = M.i(arrayMap4, prepare.getText(0));
                t.d(i13, "getValue(...)");
                Constraints constraints2 = constraints;
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, intToState, fromByteArray, j5, j6, j7, constraints2, i8, intToBackoffPolicy, j8, j9, i10, i9, j10, i11, (List) i12, (List) i13));
                arrayMap2 = arrayMap4;
                i6 = 1;
                i5 = 0;
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final List getWorkStatusPojoForName$lambda$15(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i5;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        WorkSpecDao_Impl workSpecDao_Impl2 = workSpecDao_Impl;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        int i6 = 1;
        try {
            prepare.bindText(1, str2);
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (true) {
                i5 = 0;
                if (!prepare.step()) {
                    break;
                }
                String text = prepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = prepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            prepare.reset();
            workSpecDao_Impl2.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection2, arrayMap);
            workSpecDao_Impl2.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection2, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text3 = prepare.getText(i5);
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(i6));
                Data fromByteArray = Data.Companion.fromByteArray(prepare.getBlob(2));
                int i7 = (int) prepare.getLong(3);
                int i8 = (int) prepare.getLong(4);
                long j5 = prepare.getLong(14);
                long j6 = prepare.getLong(15);
                long j7 = prepare.getLong(16);
                ArrayMap arrayMap3 = arrayMap;
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(17));
                long j8 = prepare.getLong(18);
                long j9 = prepare.getLong(19);
                int i9 = (int) prepare.getLong(20);
                long j10 = prepare.getLong(21);
                int i10 = (int) prepare.getLong(22);
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(5));
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(6));
                if (((int) prepare.getLong(7)) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (((int) prepare.getLong(8)) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (((int) prepare.getLong(9)) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (((int) prepare.getLong(10)) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Constraints constraints = new Constraints(networkRequest$work_runtime_release, intToNetworkType, z4, z5, z6, z7, prepare.getLong(11), prepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(13)));
                ArrayMap arrayMap4 = arrayMap3;
                Object i11 = M.i(arrayMap4, prepare.getText(0));
                t.d(i11, "getValue(...)");
                int i12 = i7;
                Object i13 = M.i(arrayMap2, prepare.getText(0));
                t.d(i13, "getValue(...)");
                Constraints constraints2 = constraints;
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, intToState, fromByteArray, j5, j6, j7, constraints2, i12, intToBackoffPolicy, j8, j9, i9, i8, j10, i10, (List) i11, (List) i13));
                arrayMap = arrayMap4;
                i5 = 0;
                i6 = 1;
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final List getWorkStatusPojoForTag$lambda$12(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i5;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        WorkSpecDao_Impl workSpecDao_Impl2 = workSpecDao_Impl;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        int i6 = 1;
        try {
            prepare.bindText(1, str2);
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (true) {
                i5 = 0;
                if (!prepare.step()) {
                    break;
                }
                String text = prepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = prepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            prepare.reset();
            workSpecDao_Impl2.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection2, arrayMap);
            workSpecDao_Impl2.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection2, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text3 = prepare.getText(i5);
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(i6));
                Data fromByteArray = Data.Companion.fromByteArray(prepare.getBlob(2));
                int i7 = (int) prepare.getLong(3);
                int i8 = (int) prepare.getLong(4);
                long j5 = prepare.getLong(14);
                long j6 = prepare.getLong(15);
                long j7 = prepare.getLong(16);
                ArrayMap arrayMap3 = arrayMap;
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(17));
                long j8 = prepare.getLong(18);
                long j9 = prepare.getLong(19);
                int i9 = (int) prepare.getLong(20);
                long j10 = prepare.getLong(21);
                int i10 = (int) prepare.getLong(22);
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(5));
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(6));
                if (((int) prepare.getLong(7)) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (((int) prepare.getLong(8)) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (((int) prepare.getLong(9)) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (((int) prepare.getLong(10)) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Constraints constraints = new Constraints(networkRequest$work_runtime_release, intToNetworkType, z4, z5, z6, z7, prepare.getLong(11), prepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(13)));
                ArrayMap arrayMap4 = arrayMap3;
                Object i11 = M.i(arrayMap4, prepare.getText(0));
                t.d(i11, "getValue(...)");
                int i12 = i7;
                Object i13 = M.i(arrayMap2, prepare.getText(0));
                t.d(i13, "getValue(...)");
                Constraints constraints2 = constraints;
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, intToState, fromByteArray, j5, j6, j7, constraints2, i12, intToBackoffPolicy, j8, j9, i9, i8, j10, i10, (List) i11, (List) i13));
                arrayMap = arrayMap4;
                i5 = 0;
                i6 = 1;
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final List getWorkStatusPojoLiveDataForIds$lambda$10(String str, List list, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i5;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        WorkSpecDao_Impl workSpecDao_Impl2 = workSpecDao_Impl;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        try {
            Iterator it = list.iterator();
            int i6 = 1;
            int i7 = 1;
            while (it.hasNext()) {
                prepare.bindText(i7, (String) it.next());
                i7++;
            }
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (true) {
                i5 = 0;
                if (!prepare.step()) {
                    break;
                }
                String text = prepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = prepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            prepare.reset();
            workSpecDao_Impl2.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection2, arrayMap);
            workSpecDao_Impl2.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection2, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text3 = prepare.getText(i5);
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(i6));
                Data fromByteArray = Data.Companion.fromByteArray(prepare.getBlob(2));
                int i8 = (int) prepare.getLong(3);
                int i9 = (int) prepare.getLong(4);
                long j5 = prepare.getLong(14);
                long j6 = prepare.getLong(15);
                long j7 = prepare.getLong(16);
                ArrayMap arrayMap3 = arrayMap2;
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(17));
                long j8 = prepare.getLong(18);
                long j9 = prepare.getLong(19);
                int i10 = (int) prepare.getLong(20);
                long j10 = prepare.getLong(21);
                int i11 = (int) prepare.getLong(22);
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(5));
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(6));
                if (((int) prepare.getLong(7)) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (((int) prepare.getLong(8)) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (((int) prepare.getLong(9)) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (((int) prepare.getLong(10)) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Constraints constraints = new Constraints(networkRequest$work_runtime_release, intToNetworkType, z4, z5, z6, z7, prepare.getLong(11), prepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(13)));
                Object i12 = M.i(arrayMap, prepare.getText(0));
                t.d(i12, "getValue(...)");
                ArrayMap arrayMap4 = arrayMap3;
                Object i13 = M.i(arrayMap4, prepare.getText(0));
                t.d(i13, "getValue(...)");
                Constraints constraints2 = constraints;
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, intToState, fromByteArray, j5, j6, j7, constraints2, i8, intToBackoffPolicy, j8, j9, i10, i9, j10, i11, (List) i12, (List) i13));
                arrayMap2 = arrayMap4;
                i6 = 1;
                i5 = 0;
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final List getWorkStatusPojoLiveDataForName$lambda$16(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i5;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        WorkSpecDao_Impl workSpecDao_Impl2 = workSpecDao_Impl;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        int i6 = 1;
        try {
            prepare.bindText(1, str2);
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (true) {
                i5 = 0;
                if (!prepare.step()) {
                    break;
                }
                String text = prepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = prepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            prepare.reset();
            workSpecDao_Impl2.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection2, arrayMap);
            workSpecDao_Impl2.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection2, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text3 = prepare.getText(i5);
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(i6));
                Data fromByteArray = Data.Companion.fromByteArray(prepare.getBlob(2));
                int i7 = (int) prepare.getLong(3);
                int i8 = (int) prepare.getLong(4);
                long j5 = prepare.getLong(14);
                long j6 = prepare.getLong(15);
                long j7 = prepare.getLong(16);
                ArrayMap arrayMap3 = arrayMap;
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(17));
                long j8 = prepare.getLong(18);
                long j9 = prepare.getLong(19);
                int i9 = (int) prepare.getLong(20);
                long j10 = prepare.getLong(21);
                int i10 = (int) prepare.getLong(22);
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(5));
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(6));
                if (((int) prepare.getLong(7)) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (((int) prepare.getLong(8)) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (((int) prepare.getLong(9)) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (((int) prepare.getLong(10)) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Constraints constraints = new Constraints(networkRequest$work_runtime_release, intToNetworkType, z4, z5, z6, z7, prepare.getLong(11), prepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(13)));
                ArrayMap arrayMap4 = arrayMap3;
                Object i11 = M.i(arrayMap4, prepare.getText(0));
                t.d(i11, "getValue(...)");
                int i12 = i7;
                Object i13 = M.i(arrayMap2, prepare.getText(0));
                t.d(i13, "getValue(...)");
                Constraints constraints2 = constraints;
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, intToState, fromByteArray, j5, j6, j7, constraints2, i12, intToBackoffPolicy, j8, j9, i9, i8, j10, i10, (List) i11, (List) i13));
                arrayMap = arrayMap4;
                i5 = 0;
                i6 = 1;
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final List getWorkStatusPojoLiveDataForTag$lambda$14(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i5;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        WorkSpecDao_Impl workSpecDao_Impl2 = workSpecDao_Impl;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        int i6 = 1;
        try {
            prepare.bindText(1, str2);
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (true) {
                i5 = 0;
                if (!prepare.step()) {
                    break;
                }
                String text = prepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = prepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            prepare.reset();
            workSpecDao_Impl2.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection2, arrayMap);
            workSpecDao_Impl2.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection2, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text3 = prepare.getText(i5);
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(i6));
                Data fromByteArray = Data.Companion.fromByteArray(prepare.getBlob(2));
                int i7 = (int) prepare.getLong(3);
                int i8 = (int) prepare.getLong(4);
                long j5 = prepare.getLong(14);
                long j6 = prepare.getLong(15);
                long j7 = prepare.getLong(16);
                ArrayMap arrayMap3 = arrayMap;
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(17));
                long j8 = prepare.getLong(18);
                long j9 = prepare.getLong(19);
                int i9 = (int) prepare.getLong(20);
                long j10 = prepare.getLong(21);
                int i10 = (int) prepare.getLong(22);
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(5));
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(6));
                if (((int) prepare.getLong(7)) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (((int) prepare.getLong(8)) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (((int) prepare.getLong(9)) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (((int) prepare.getLong(10)) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Constraints constraints = new Constraints(networkRequest$work_runtime_release, intToNetworkType, z4, z5, z6, z7, prepare.getLong(11), prepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(13)));
                ArrayMap arrayMap4 = arrayMap3;
                Object i11 = M.i(arrayMap4, prepare.getText(0));
                t.d(i11, "getValue(...)");
                int i12 = i7;
                Object i13 = M.i(arrayMap2, prepare.getText(0));
                t.d(i13, "getValue(...)");
                Constraints constraints2 = constraints;
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, intToState, fromByteArray, j5, j6, j7, constraints2, i12, intToBackoffPolicy, j8, j9, i9, i8, j10, i10, (List) i11, (List) i13));
                arrayMap = arrayMap4;
                i5 = 0;
                i6 = 1;
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final boolean hasUnfinishedWorkFlow$lambda$22(String str, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            boolean z4 = false;
            if (prepare.step() && ((int) prepare.getLong(0)) != 0) {
                z4 = true;
            }
            return z4;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static final J incrementGeneration$lambda$50(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            prepare.step();
            prepare.close();
            return J.f19942a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static final J incrementPeriodCount$lambda$40(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            prepare.step();
            prepare.close();
            return J.f19942a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final int incrementWorkSpecRunAttemptCount$lambda$43(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            prepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final J insertWorkSpec$lambda$0(WorkSpecDao_Impl workSpecDao_Impl, WorkSpec workSpec, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        workSpecDao_Impl.__insertAdapterOfWorkSpec.insert(sQLiteConnection, workSpec);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final int markWorkSpecScheduled$lambda$47(String str, long j5, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindLong(1, j5);
            prepare.bindText(2, str2);
            prepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static final J pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast$lambda$49(String str, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.step();
            prepare.close();
            return J.f19942a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final int resetScheduledState$lambda$48(String str, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static final J resetWorkSpecNextScheduleTimeOverride$lambda$46(String str, String str2, int i5, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            prepare.bindLong(2, (long) i5);
            prepare.step();
            prepare.close();
            return J.f19942a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final int resetWorkSpecRunAttemptCount$lambda$44(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            prepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final int setCancelledState$lambda$39(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            prepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static final J setLastEnqueueTime$lambda$42(String str, long j5, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindLong(1, j5);
            prepare.bindText(2, str2);
            prepare.step();
            prepare.close();
            return J.f19942a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static final J setNextScheduleTimeOverride$lambda$45(String str, long j5, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindLong(1, j5);
            prepare.bindText(2, str2);
            prepare.step();
            prepare.close();
            return J.f19942a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static final J setOutput$lambda$41(String str, Data data, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindBlob(1, Data.Companion.toByteArrayInternalV1(data));
            prepare.bindText(2, str2);
            prepare.step();
            prepare.close();
            return J.f19942a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final int setState$lambda$38(String str, WorkInfo.State state, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindLong(1, (long) WorkTypeConverters.stateToInt(state));
            prepare.bindText(2, str2);
            prepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static final J setStopReason$lambda$51(String str, int i5, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindLong(1, (long) i5);
            prepare.bindText(2, str2);
            prepare.step();
            prepare.close();
            return J.f19942a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final J updateWorkSpec$lambda$1(WorkSpecDao_Impl workSpecDao_Impl, WorkSpec workSpec, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        workSpecDao_Impl.__updateAdapterOfWorkSpec.handle(sQLiteConnection, workSpec);
        return J.f19942a;
    }

    public int countNonFinishedContentUriTriggerWorkers() {
        return ((Number) DBUtil.performBlocking(this.__db, true, false, new D("Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)"))).intValue();
    }

    public void delete(String str) {
        t.e(str, "id");
        DBUtil.performBlocking(this.__db, false, true, new F("DELETE FROM workspec WHERE id=?", str));
    }

    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling(int i5) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new I("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", i5));
    }

    public List<String> getAllUnfinishedWork() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new B("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)"));
    }

    public List<String> getAllWorkSpecIds() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Z("SELECT id FROM workspec"));
    }

    public LiveData<List<String>> getAllWorkSpecIdsLiveData() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, true, (l) new C0428b0("SELECT id FROM workspec"));
    }

    public List<WorkSpec> getEligibleWorkForScheduling(int i5) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new W("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))", i5));
    }

    public List<WorkSpec> getEligibleWorkForSchedulingWithContentUris() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new v0("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time"));
    }

    public List<Data> getInputsFromPrerequisites(String str) {
        t.e(str, "id");
        return (List) DBUtil.performBlocking(this.__db, true, false, new C0426a0("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", str));
    }

    public List<WorkSpec> getRecentlyCompletedWork(long j5) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new U("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", j5));
    }

    public List<WorkSpec> getRunningWork() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new k0("SELECT * FROM workspec WHERE state=1"));
    }

    public LiveData<Long> getScheduleRequestedAtLiveData(String str) {
        t.e(str, "id");
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, false, (l) new w0("SELECT schedule_requested_at FROM workspec WHERE id=?", str));
    }

    public List<WorkSpec> getScheduledWork() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new V("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1"));
    }

    public WorkInfo.State getState(String str) {
        t.e(str, "id");
        return (WorkInfo.State) DBUtil.performBlocking(this.__db, true, false, new s0("SELECT state FROM workspec WHERE id=?", str));
    }

    public List<String> getUnfinishedWorkWithName(String str) {
        t.e(str, RewardPlus.NAME);
        return (List) DBUtil.performBlocking(this.__db, true, false, new N("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", str));
    }

    public List<String> getUnfinishedWorkWithTag(String str) {
        t.e(str, "tag");
        return (List) DBUtil.performBlocking(this.__db, true, false, new g0("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", str));
    }

    public WorkSpec getWorkSpec(String str) {
        t.e(str, "id");
        return (WorkSpec) DBUtil.performBlocking(this.__db, true, false, new Y("SELECT * FROM workspec WHERE id=?", str));
    }

    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String str) {
        t.e(str, RewardPlus.NAME);
        return (List) DBUtil.performBlocking(this.__db, true, false, new K("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", str));
    }

    public C2972e getWorkStatusPojoFlowDataForIds(List<String> list) {
        t.e(list, "ids");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        StringUtil.appendPlaceholders(sb, list.size());
        sb.append(")");
        String sb2 = sb.toString();
        t.d(sb2, "toString(...)");
        return FlowUtil.createFlow(this.__db, true, new String[]{"WorkTag", "WorkProgress", "workspec"}, new O(sb2, list, this));
    }

    public C2972e getWorkStatusPojoFlowForName(String str) {
        t.e(str, RewardPlus.NAME);
        return FlowUtil.createFlow(this.__db, true, new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, new n0("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", str, this));
    }

    public C2972e getWorkStatusPojoFlowForTag(String str) {
        t.e(str, "tag");
        return FlowUtil.createFlow(this.__db, true, new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, new L("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", str, this));
    }

    public WorkSpec.WorkInfoPojo getWorkStatusPojoForId(String str) {
        t.e(str, "id");
        return (WorkSpec.WorkInfoPojo) DBUtil.performBlocking(this.__db, true, true, new p0("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id=?", str, this));
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(List<String> list) {
        t.e(list, "ids");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        StringUtil.appendPlaceholders(sb, list.size());
        sb.append(")");
        String sb2 = sb.toString();
        t.d(sb2, "toString(...)");
        return (List) DBUtil.performBlocking(this.__db, true, true, new r0(sb2, list, this));
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(String str) {
        t.e(str, RewardPlus.NAME);
        return (List) DBUtil.performBlocking(this.__db, true, true, new m0("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", str, this));
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(String str) {
        t.e(str, "tag");
        return (List) DBUtil.performBlocking(this.__db, true, true, new P("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", str, this));
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(List<String> list) {
        t.e(list, "ids");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        StringUtil.appendPlaceholders(sb, list.size());
        sb.append(")");
        String sb2 = sb.toString();
        t.d(sb2, "toString(...)");
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, (l) new f0(sb2, list, this));
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(String str) {
        t.e(str, RewardPlus.NAME);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, true, (l) new j0("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", str, this));
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(String str) {
        t.e(str, "tag");
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, true, (l) new q0("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", str, this));
    }

    public C2972e hasUnfinishedWorkFlow() {
        return FlowUtil.createFlow(this.__db, false, new String[]{"workspec"}, new H("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1"));
    }

    public void incrementGeneration(String str) {
        t.e(str, "id");
        DBUtil.performBlocking(this.__db, false, true, new d0("UPDATE workspec SET generation=generation+1 WHERE id=?", str));
    }

    public void incrementPeriodCount(String str) {
        t.e(str, "id");
        DBUtil.performBlocking(this.__db, false, true, new T("UPDATE workspec SET period_count=period_count+1 WHERE id=?", str));
    }

    public int incrementWorkSpecRunAttemptCount(String str) {
        t.e(str, "id");
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new h0("UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?", str))).intValue();
    }

    public void insertWorkSpec(WorkSpec workSpec) {
        t.e(workSpec, "workSpec");
        DBUtil.performBlocking(this.__db, false, true, new u0(this, workSpec));
    }

    public int markWorkSpecScheduled(String str, long j5) {
        t.e(str, "id");
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new c0("UPDATE workspec SET schedule_requested_at=? WHERE id=?", j5, str))).intValue();
    }

    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast() {
        DBUtil.performBlocking(this.__db, false, true, new G("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))"));
    }

    public int resetScheduledState() {
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new J("UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)"))).intValue();
    }

    public void resetWorkSpecNextScheduleTimeOverride(String str, int i5) {
        t.e(str, "id");
        DBUtil.performBlocking(this.__db, false, true, new E("UPDATE workspec SET next_schedule_time_override=9223372036854775807 WHERE (id=? AND next_schedule_time_override_generation=?)", str, i5));
    }

    public int resetWorkSpecRunAttemptCount(String str) {
        t.e(str, "id");
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new S("UPDATE workspec SET run_attempt_count=0 WHERE id=?", str))).intValue();
    }

    public int setCancelledState(String str) {
        t.e(str, "id");
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new e0("UPDATE workspec SET stop_reason = CASE WHEN state=1 THEN 1 ELSE -256 END, state=5 WHERE id=?", str))).intValue();
    }

    public void setLastEnqueueTime(String str, long j5) {
        t.e(str, "id");
        DBUtil.performBlocking(this.__db, false, true, new t0("UPDATE workspec SET last_enqueue_time=? WHERE id=?", j5, str));
    }

    public void setNextScheduleTimeOverride(String str, long j5) {
        t.e(str, "id");
        DBUtil.performBlocking(this.__db, false, true, new X("UPDATE workspec SET next_schedule_time_override=? WHERE id=?", j5, str));
    }

    public void setOutput(String str, Data data) {
        t.e(str, "id");
        t.e(data, "output");
        DBUtil.performBlocking(this.__db, false, true, new M("UPDATE workspec SET output=? WHERE id=?", data, str));
    }

    public int setState(WorkInfo.State state, String str) {
        t.e(state, MRAIDCommunicatorUtil.KEY_STATE);
        t.e(str, "id");
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new o0("UPDATE workspec SET state=? WHERE id=?", state, str))).intValue();
    }

    public void setStopReason(String str, int i5) {
        t.e(str, "id");
        DBUtil.performBlocking(this.__db, false, true, new C("UPDATE workspec SET stop_reason=? WHERE id=?", i5, str));
    }

    public void updateWorkSpec(WorkSpec workSpec) {
        t.e(workSpec, "workSpec");
        DBUtil.performBlocking(this.__db, false, true, new Q(this, workSpec));
    }
}
