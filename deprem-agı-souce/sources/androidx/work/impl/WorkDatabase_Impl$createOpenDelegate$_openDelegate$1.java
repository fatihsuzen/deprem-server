package androidx.work.impl;

import X2.C2250q;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenDelegate;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.work.impl.utils.PreferenceUtils;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.t;

public final class WorkDatabase_Impl$createOpenDelegate$_openDelegate$1 extends RoomOpenDelegate {
    final /* synthetic */ WorkDatabase_Impl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkDatabase_Impl$createOpenDelegate$_openDelegate$1(WorkDatabase_Impl workDatabase_Impl) {
        super(24, "08b926448d86528e697981ddd30459f7", "149fd8ad55885d3fe3549a37a0163243");
        this.this$0 = workDatabase_Impl;
    }

    public void createAllTables(SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "connection");
        SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
        SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
        SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT NOT NULL, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL DEFAULT -1, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `next_schedule_time_override` INTEGER NOT NULL DEFAULT 9223372036854775807, `next_schedule_time_override_generation` INTEGER NOT NULL DEFAULT 0, `stop_reason` INTEGER NOT NULL DEFAULT -256, `trace_tag` TEXT, `backoff_on_system_interruptions` INTEGER, `required_network_type` INTEGER NOT NULL, `required_network_request` BLOB NOT NULL DEFAULT x'', `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
        SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
        SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
        SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
        SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
        SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        SQLite.execSQL(sQLiteConnection, PreferenceUtils.CREATE_PREFERENCE);
        SQLite.execSQL(sQLiteConnection, RoomMasterTable.CREATE_QUERY);
        SQLite.execSQL(sQLiteConnection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '08b926448d86528e697981ddd30459f7')");
    }

    public void dropAllTables(SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "connection");
        SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `Dependency`");
        SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `WorkSpec`");
        SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `WorkTag`");
        SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `SystemIdInfo`");
        SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `WorkName`");
        SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `WorkProgress`");
        SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `Preference`");
    }

    public void onCreate(SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "connection");
    }

    public void onOpen(SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "connection");
        SQLite.execSQL(sQLiteConnection, "PRAGMA foreign_keys = ON");
        this.this$0.internalInitInvalidationTracker(sQLiteConnection);
    }

    public void onPostMigrate(SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "connection");
    }

    public void onPreMigrate(SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "connection");
        DBUtil.dropFtsSyncTriggers(sQLiteConnection);
    }

    public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection sQLiteConnection) {
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "connection");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, (String) null, 1));
        linkedHashMap.put("prerequisite_id", new TableInfo.Column("prerequisite_id", "TEXT", true, 2, (String) null, 1));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", C2250q.d("work_spec_id"), C2250q.d("id")));
        linkedHashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", C2250q.d("prerequisite_id"), C2250q.d("id")));
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        linkedHashSet2.add(new TableInfo.Index("index_Dependency_work_spec_id", false, C2250q.d("work_spec_id"), C2250q.d("ASC")));
        linkedHashSet2.add(new TableInfo.Index("index_Dependency_prerequisite_id", false, C2250q.d("prerequisite_id"), C2250q.d("ASC")));
        TableInfo tableInfo = new TableInfo("Dependency", linkedHashMap, linkedHashSet, linkedHashSet2);
        TableInfo.Companion companion = TableInfo.Companion;
        TableInfo read = companion.read(sQLiteConnection2, "Dependency");
        if (!tableInfo.equals(read)) {
            return new RoomOpenDelegate.ValidationResult(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
        linkedHashMap2.put(MRAIDCommunicatorUtil.KEY_STATE, new TableInfo.Column(MRAIDCommunicatorUtil.KEY_STATE, "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("worker_class_name", new TableInfo.Column("worker_class_name", "TEXT", true, 0, (String) null, 1));
        linkedHashMap2.put("input_merger_class_name", new TableInfo.Column("input_merger_class_name", "TEXT", true, 0, (String) null, 1));
        linkedHashMap2.put("input", new TableInfo.Column("input", "BLOB", true, 0, (String) null, 1));
        linkedHashMap2.put("output", new TableInfo.Column("output", "BLOB", true, 0, (String) null, 1));
        linkedHashMap2.put("initial_delay", new TableInfo.Column("initial_delay", "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("interval_duration", new TableInfo.Column("interval_duration", "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("flex_duration", new TableInfo.Column("flex_duration", "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("run_attempt_count", new TableInfo.Column("run_attempt_count", "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("backoff_policy", new TableInfo.Column("backoff_policy", "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("backoff_delay_duration", new TableInfo.Column("backoff_delay_duration", "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("last_enqueue_time", new TableInfo.Column("last_enqueue_time", "INTEGER", true, 0, "-1", 1));
        linkedHashMap2.put("minimum_retention_duration", new TableInfo.Column("minimum_retention_duration", "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("schedule_requested_at", new TableInfo.Column("schedule_requested_at", "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("run_in_foreground", new TableInfo.Column("run_in_foreground", "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("out_of_quota_policy", new TableInfo.Column("out_of_quota_policy", "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("period_count", new TableInfo.Column("period_count", "INTEGER", true, 0, "0", 1));
        linkedHashMap2.put("generation", new TableInfo.Column("generation", "INTEGER", true, 0, "0", 1));
        linkedHashMap2.put("next_schedule_time_override", new TableInfo.Column("next_schedule_time_override", "INTEGER", true, 0, "9223372036854775807", 1));
        linkedHashMap2.put("next_schedule_time_override_generation", new TableInfo.Column("next_schedule_time_override_generation", "INTEGER", true, 0, "0", 1));
        linkedHashMap2.put("stop_reason", new TableInfo.Column("stop_reason", "INTEGER", true, 0, "-256", 1));
        linkedHashMap2.put("trace_tag", new TableInfo.Column("trace_tag", "TEXT", false, 0, (String) null, 1));
        linkedHashMap2.put("backoff_on_system_interruptions", new TableInfo.Column("backoff_on_system_interruptions", "INTEGER", false, 0, (String) null, 1));
        linkedHashMap2.put("required_network_type", new TableInfo.Column("required_network_type", "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("required_network_request", new TableInfo.Column("required_network_request", "BLOB", true, 0, "x''", 1));
        linkedHashMap2.put("requires_charging", new TableInfo.Column("requires_charging", "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("requires_device_idle", new TableInfo.Column("requires_device_idle", "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("requires_battery_not_low", new TableInfo.Column("requires_battery_not_low", "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("requires_storage_not_low", new TableInfo.Column("requires_storage_not_low", "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("trigger_content_update_delay", new TableInfo.Column("trigger_content_update_delay", "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("trigger_max_content_delay", new TableInfo.Column("trigger_max_content_delay", "INTEGER", true, 0, (String) null, 1));
        linkedHashMap2.put("content_uri_triggers", new TableInfo.Column("content_uri_triggers", "BLOB", true, 0, (String) null, 1));
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        LinkedHashSet linkedHashSet4 = new LinkedHashSet();
        linkedHashSet4.add(new TableInfo.Index("index_WorkSpec_schedule_requested_at", false, C2250q.d("schedule_requested_at"), C2250q.d("ASC")));
        linkedHashSet4.add(new TableInfo.Index("index_WorkSpec_last_enqueue_time", false, C2250q.d("last_enqueue_time"), C2250q.d("ASC")));
        TableInfo tableInfo2 = new TableInfo("WorkSpec", linkedHashMap2, linkedHashSet3, linkedHashSet4);
        TableInfo read2 = companion.read(sQLiteConnection2, "WorkSpec");
        if (!tableInfo2.equals(read2)) {
            return new RoomOpenDelegate.ValidationResult(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put("tag", new TableInfo.Column("tag", "TEXT", true, 1, (String) null, 1));
        linkedHashMap3.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2, (String) null, 1));
        LinkedHashSet linkedHashSet5 = new LinkedHashSet();
        linkedHashSet5.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", C2250q.d("work_spec_id"), C2250q.d("id")));
        LinkedHashSet linkedHashSet6 = new LinkedHashSet();
        linkedHashSet6.add(new TableInfo.Index("index_WorkTag_work_spec_id", false, C2250q.d("work_spec_id"), C2250q.d("ASC")));
        TableInfo tableInfo3 = new TableInfo("WorkTag", linkedHashMap3, linkedHashSet5, linkedHashSet6);
        TableInfo read3 = companion.read(sQLiteConnection2, "WorkTag");
        if (!tableInfo3.equals(read3)) {
            return new RoomOpenDelegate.ValidationResult(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        linkedHashMap4.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, (String) null, 1));
        linkedHashMap4.put("generation", new TableInfo.Column("generation", "INTEGER", true, 2, "0", 1));
        linkedHashMap4.put("system_id", new TableInfo.Column("system_id", "INTEGER", true, 0, (String) null, 1));
        LinkedHashSet linkedHashSet7 = new LinkedHashSet();
        linkedHashSet7.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", C2250q.d("work_spec_id"), C2250q.d("id")));
        TableInfo tableInfo4 = new TableInfo("SystemIdInfo", linkedHashMap4, linkedHashSet7, new LinkedHashSet());
        TableInfo read4 = companion.read(sQLiteConnection2, "SystemIdInfo");
        if (!tableInfo4.equals(read4)) {
            return new RoomOpenDelegate.ValidationResult(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
        }
        LinkedHashMap linkedHashMap5 = new LinkedHashMap();
        linkedHashMap5.put(RewardPlus.NAME, new TableInfo.Column(RewardPlus.NAME, "TEXT", true, 1, (String) null, 1));
        linkedHashMap5.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2, (String) null, 1));
        LinkedHashSet linkedHashSet8 = new LinkedHashSet();
        linkedHashSet8.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", C2250q.d("work_spec_id"), C2250q.d("id")));
        LinkedHashSet linkedHashSet9 = new LinkedHashSet();
        linkedHashSet9.add(new TableInfo.Index("index_WorkName_work_spec_id", false, C2250q.d("work_spec_id"), C2250q.d("ASC")));
        TableInfo tableInfo5 = new TableInfo("WorkName", linkedHashMap5, linkedHashSet8, linkedHashSet9);
        TableInfo read5 = companion.read(sQLiteConnection2, "WorkName");
        if (!tableInfo5.equals(read5)) {
            return new RoomOpenDelegate.ValidationResult(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
        }
        LinkedHashMap linkedHashMap6 = new LinkedHashMap();
        linkedHashMap6.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, (String) null, 1));
        linkedHashMap6.put("progress", new TableInfo.Column("progress", "BLOB", true, 0, (String) null, 1));
        LinkedHashSet linkedHashSet10 = new LinkedHashSet();
        linkedHashSet10.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", C2250q.d("work_spec_id"), C2250q.d("id")));
        TableInfo tableInfo6 = new TableInfo("WorkProgress", linkedHashMap6, linkedHashSet10, new LinkedHashSet());
        TableInfo read6 = companion.read(sQLiteConnection2, "WorkProgress");
        if (!tableInfo6.equals(read6)) {
            return new RoomOpenDelegate.ValidationResult(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
        }
        LinkedHashMap linkedHashMap7 = new LinkedHashMap();
        linkedHashMap7.put("key", new TableInfo.Column("key", "TEXT", true, 1, (String) null, 1));
        linkedHashMap7.put("long_value", new TableInfo.Column("long_value", "INTEGER", false, 0, (String) null, 1));
        TableInfo tableInfo7 = new TableInfo("Preference", linkedHashMap7, new LinkedHashSet(), new LinkedHashSet());
        TableInfo read7 = companion.read(sQLiteConnection2, "Preference");
        if (tableInfo7.equals(read7)) {
            return new RoomOpenDelegate.ValidationResult(true, (String) null);
        }
        return new RoomOpenDelegate.ValidationResult(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
    }
}
