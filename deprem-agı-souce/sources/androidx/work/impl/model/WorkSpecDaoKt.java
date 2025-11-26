package androidx.work.impl.model;

import X2.C2250q;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.UUID;
import kotlin.jvm.internal.t;
import w3.I;
import z3.C2972e;
import z3.C2974g;

public final class WorkSpecDaoKt {
    private static final String WORK_INFO_BY_IDS = "SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (:ids)";
    private static final String WORK_INFO_BY_NAME = "SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=:name)";
    private static final String WORK_INFO_BY_TAG = "SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=:tag)";
    private static final String WORK_INFO_COLUMNS = "id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason";

    public static final C2972e dedup(C2972e eVar, I i5) {
        t.e(eVar, "<this>");
        t.e(i5, "dispatcher");
        return C2974g.r(C2974g.j(new WorkSpecDaoKt$dedup$$inlined$map$1(eVar)), i5);
    }

    public static final C2972e getWorkStatusPojoFlowDataForIds(WorkSpecDao workSpecDao, UUID uuid) {
        t.e(workSpecDao, "<this>");
        t.e(uuid, "id");
        return C2974g.j(new WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1(workSpecDao.getWorkStatusPojoFlowDataForIds(C2250q.d(String.valueOf(uuid)))));
    }

    public static final C2972e getWorkStatusPojoFlowForName(WorkSpecDao workSpecDao, I i5, String str) {
        t.e(workSpecDao, "<this>");
        t.e(i5, "dispatcher");
        t.e(str, RewardPlus.NAME);
        return dedup(workSpecDao.getWorkStatusPojoFlowForName(str), i5);
    }

    public static final C2972e getWorkStatusPojoFlowForTag(WorkSpecDao workSpecDao, I i5, String str) {
        t.e(workSpecDao, "<this>");
        t.e(i5, "dispatcher");
        t.e(str, "tag");
        return dedup(workSpecDao.getWorkStatusPojoFlowForTag(str), i5);
    }
}
