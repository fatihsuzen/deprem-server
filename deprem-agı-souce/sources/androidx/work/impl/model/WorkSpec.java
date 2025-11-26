package androidx.work.impl.model;

import X2.C2250q;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.collection.a;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2729e;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Entity(indices = {@Index({"schedule_requested_at"}), @Index({"last_enqueue_time"})})
public final class WorkSpec {
    public static final Companion Companion = new Companion((C2633k) null);
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1;
    private static final String TAG;
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER = new A();
    @ColumnInfo(name = "backoff_on_system_interruptions")
    private Boolean backOffOnSystemInterruptions;
    @ColumnInfo(name = "backoff_delay_duration")
    public long backoffDelayDuration;
    @ColumnInfo(name = "backoff_policy")
    public BackoffPolicy backoffPolicy;
    @Embedded
    public Constraints constraints;
    @ColumnInfo(name = "run_in_foreground")
    public boolean expedited;
    @ColumnInfo(name = "flex_duration")
    public long flexDuration;
    @ColumnInfo(defaultValue = "0")
    private final int generation;
    @ColumnInfo(name = "id")
    @PrimaryKey
    public final String id;
    @ColumnInfo(name = "initial_delay")
    public long initialDelay;
    @ColumnInfo(name = "input")
    public Data input;
    @ColumnInfo(name = "input_merger_class_name")
    public String inputMergerClassName;
    @ColumnInfo(name = "interval_duration")
    public long intervalDuration;
    @ColumnInfo(defaultValue = "-1", name = "last_enqueue_time")
    public long lastEnqueueTime;
    @ColumnInfo(name = "minimum_retention_duration")
    public long minimumRetentionDuration;
    @ColumnInfo(defaultValue = "9223372036854775807", name = "next_schedule_time_override")
    private long nextScheduleTimeOverride;
    @ColumnInfo(defaultValue = "0", name = "next_schedule_time_override_generation")
    private int nextScheduleTimeOverrideGeneration;
    @ColumnInfo(name = "out_of_quota_policy")
    public OutOfQuotaPolicy outOfQuotaPolicy;
    @ColumnInfo(name = "output")
    public Data output;
    @ColumnInfo(defaultValue = "0", name = "period_count")
    private int periodCount;
    @ColumnInfo(name = "run_attempt_count")
    public int runAttemptCount;
    @ColumnInfo(name = "schedule_requested_at")
    public long scheduleRequestedAt;
    @ColumnInfo(name = "state")
    public WorkInfo.State state;
    @ColumnInfo(defaultValue = "-256", name = "stop_reason")
    private final int stopReason;
    @ColumnInfo(name = "trace_tag")
    private String traceTag;
    @ColumnInfo(name = "worker_class_name")
    public String workerClassName;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final long calculateNextRunTime(boolean z4, int i5, BackoffPolicy backoffPolicy, long j5, long j6, int i6, boolean z5, long j7, long j8, long j9, long j10) {
            long j11;
            long j12 = j10;
            t.e(backoffPolicy, "backoffPolicy");
            if (j12 != Long.MAX_VALUE && z5) {
                return i6 == 0 ? j12 : C2729e.d(j12, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS + j6);
            }
            if (z4) {
                if (backoffPolicy == BackoffPolicy.LINEAR) {
                    j11 = j5 * ((long) i5);
                } else {
                    j11 = (long) Math.scalb((float) j5, i5 - 1);
                }
                return C2729e.f(j11, WorkRequest.MAX_BACKOFF_MILLIS) + j6;
            } else if (z5) {
                long j13 = i6 == 0 ? j6 + j7 : j6 + j9;
                return (j8 == j9 || i6 != 0) ? j13 : j13 + (j9 - j8);
            } else if (j6 == -1) {
                return Long.MAX_VALUE;
            } else {
                return j6 + j7;
            }
        }

        private Companion() {
        }
    }

    public static final class IdAndState {
        @ColumnInfo(name = "id")
        public String id;
        @ColumnInfo(name = "state")
        public WorkInfo.State state;

        public IdAndState(String str, WorkInfo.State state2) {
            t.e(str, "id");
            t.e(state2, MRAIDCommunicatorUtil.KEY_STATE);
            this.id = str;
            this.state = state2;
        }

        public static /* synthetic */ IdAndState copy$default(IdAndState idAndState, String str, WorkInfo.State state2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = idAndState.id;
            }
            if ((i5 & 2) != 0) {
                state2 = idAndState.state;
            }
            return idAndState.copy(str, state2);
        }

        public final String component1() {
            return this.id;
        }

        public final WorkInfo.State component2() {
            return this.state;
        }

        public final IdAndState copy(String str, WorkInfo.State state2) {
            t.e(str, "id");
            t.e(state2, MRAIDCommunicatorUtil.KEY_STATE);
            return new IdAndState(str, state2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            return t.a(this.id, idAndState.id) && this.state == idAndState.state;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.state.hashCode();
        }

        public String toString() {
            return "IdAndState(id=" + this.id + ", state=" + this.state + ')';
        }
    }

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkSpec");
        t.d(tagWithPrefix, "tagWithPrefix(...)");
        TAG = tagWithPrefix;
    }

    public WorkSpec(String str, WorkInfo.State state2, String str2, String str3, Data data, Data data2, long j5, long j6, long j7, Constraints constraints2, @IntRange(from = 0) int i5, BackoffPolicy backoffPolicy2, long j8, long j9, long j10, long j11, boolean z4, OutOfQuotaPolicy outOfQuotaPolicy2, int i6, int i7, long j12, int i8, int i9, String str4, Boolean bool) {
        Constraints constraints3 = constraints2;
        BackoffPolicy backoffPolicy3 = backoffPolicy2;
        OutOfQuotaPolicy outOfQuotaPolicy3 = outOfQuotaPolicy2;
        t.e(str, "id");
        t.e(state2, MRAIDCommunicatorUtil.KEY_STATE);
        t.e(str2, "workerClassName");
        t.e(str3, "inputMergerClassName");
        t.e(data, "input");
        t.e(data2, "output");
        t.e(constraints3, "constraints");
        t.e(backoffPolicy3, "backoffPolicy");
        t.e(outOfQuotaPolicy3, "outOfQuotaPolicy");
        this.id = str;
        this.state = state2;
        this.workerClassName = str2;
        this.inputMergerClassName = str3;
        this.input = data;
        this.output = data2;
        this.initialDelay = j5;
        this.intervalDuration = j6;
        this.flexDuration = j7;
        this.constraints = constraints3;
        this.runAttemptCount = i5;
        this.backoffPolicy = backoffPolicy3;
        this.backoffDelayDuration = j8;
        this.lastEnqueueTime = j9;
        this.minimumRetentionDuration = j10;
        this.scheduleRequestedAt = j11;
        this.expedited = z4;
        this.outOfQuotaPolicy = outOfQuotaPolicy3;
        this.periodCount = i6;
        this.generation = i7;
        this.nextScheduleTimeOverride = j12;
        this.nextScheduleTimeOverrideGeneration = i8;
        this.stopReason = i9;
        this.traceTag = str4;
        this.backOffOnSystemInterruptions = bool;
    }

    /* access modifiers changed from: private */
    public static final List WORK_INFO_MAPPER$lambda$1(List list) {
        if (list == null) {
            return null;
        }
        Iterable<WorkInfoPojo> iterable = list;
        ArrayList arrayList = new ArrayList(C2250q.p(iterable, 10));
        for (WorkInfoPojo workInfo : iterable) {
            arrayList.add(workInfo.toWorkInfo());
        }
        return arrayList;
    }

    public static /* synthetic */ WorkSpec copy$default(WorkSpec workSpec, String str, WorkInfo.State state2, String str2, String str3, Data data, Data data2, long j5, long j6, long j7, Constraints constraints2, int i5, BackoffPolicy backoffPolicy2, long j8, long j9, long j10, long j11, boolean z4, OutOfQuotaPolicy outOfQuotaPolicy2, int i6, int i7, long j12, int i8, int i9, String str4, Boolean bool, int i10, Object obj) {
        Boolean bool2;
        String str5;
        long j13;
        long j14;
        long j15;
        long j16;
        OutOfQuotaPolicy outOfQuotaPolicy3;
        int i11;
        int i12;
        long j17;
        int i13;
        WorkInfo.State state3;
        int i14;
        boolean z5;
        String str6;
        String str7;
        Data data3;
        Data data4;
        long j18;
        long j19;
        long j20;
        Constraints constraints3;
        int i15;
        BackoffPolicy backoffPolicy3;
        WorkSpec workSpec2 = workSpec;
        int i16 = i10;
        String str8 = (i16 & 1) != 0 ? workSpec2.id : str;
        WorkInfo.State state4 = (i16 & 2) != 0 ? workSpec2.state : state2;
        String str9 = (i16 & 4) != 0 ? workSpec2.workerClassName : str2;
        String str10 = (i16 & 8) != 0 ? workSpec2.inputMergerClassName : str3;
        Data data5 = (i16 & 16) != 0 ? workSpec2.input : data;
        Data data6 = (i16 & 32) != 0 ? workSpec2.output : data2;
        long j21 = (i16 & 64) != 0 ? workSpec2.initialDelay : j5;
        long j22 = (i16 & 128) != 0 ? workSpec2.intervalDuration : j6;
        long j23 = (i16 & 256) != 0 ? workSpec2.flexDuration : j7;
        Constraints constraints4 = (i16 & 512) != 0 ? workSpec2.constraints : constraints2;
        int i17 = (i16 & 1024) != 0 ? workSpec2.runAttemptCount : i5;
        String str11 = str8;
        BackoffPolicy backoffPolicy4 = (i16 & 2048) != 0 ? workSpec2.backoffPolicy : backoffPolicy2;
        WorkInfo.State state5 = state4;
        long j24 = (i16 & 4096) != 0 ? workSpec2.backoffDelayDuration : j8;
        long j25 = (i16 & 8192) != 0 ? workSpec2.lastEnqueueTime : j9;
        long j26 = (i16 & 16384) != 0 ? workSpec2.minimumRetentionDuration : j10;
        long j27 = (i16 & 32768) != 0 ? workSpec2.scheduleRequestedAt : j11;
        boolean z6 = (i10 & 65536) != 0 ? workSpec2.expedited : z4;
        long j28 = j27;
        OutOfQuotaPolicy outOfQuotaPolicy4 = (i10 & 131072) != 0 ? workSpec2.outOfQuotaPolicy : outOfQuotaPolicy2;
        int i18 = (i10 & 262144) != 0 ? workSpec2.periodCount : i6;
        OutOfQuotaPolicy outOfQuotaPolicy5 = outOfQuotaPolicy4;
        int i19 = (i10 & 524288) != 0 ? workSpec2.generation : i7;
        int i20 = i18;
        long j29 = (i10 & 1048576) != 0 ? workSpec2.nextScheduleTimeOverride : j12;
        int i21 = (i10 & 2097152) != 0 ? workSpec2.nextScheduleTimeOverrideGeneration : i8;
        int i22 = (i10 & 4194304) != 0 ? workSpec2.stopReason : i9;
        int i23 = i21;
        String str12 = (i10 & 8388608) != 0 ? workSpec2.traceTag : str4;
        if ((i10 & 16777216) != 0) {
            str5 = str12;
            bool2 = workSpec2.backOffOnSystemInterruptions;
            j14 = j25;
            j15 = j26;
            j16 = j28;
            outOfQuotaPolicy3 = outOfQuotaPolicy5;
            i11 = i20;
            i12 = i19;
            j17 = j29;
            i13 = i23;
            i14 = i22;
            z5 = z6;
            str7 = str10;
            data3 = data5;
            data4 = data6;
            j18 = j21;
            j19 = j22;
            j20 = j23;
            constraints3 = constraints4;
            i15 = i17;
            backoffPolicy3 = backoffPolicy4;
            j13 = j24;
            state3 = state5;
            str6 = str9;
        } else {
            bool2 = bool;
            str5 = str12;
            j13 = j24;
            j14 = j25;
            j15 = j26;
            j16 = j28;
            outOfQuotaPolicy3 = outOfQuotaPolicy5;
            i11 = i20;
            i12 = i19;
            j17 = j29;
            i13 = i23;
            state3 = state5;
            i14 = i22;
            z5 = z6;
            str6 = str9;
            str7 = str10;
            data3 = data5;
            data4 = data6;
            j18 = j21;
            j19 = j22;
            j20 = j23;
            constraints3 = constraints4;
            i15 = i17;
            backoffPolicy3 = backoffPolicy4;
        }
        return workSpec2.copy(str11, state3, str6, str7, data3, data4, j18, j19, j20, constraints3, i15, backoffPolicy3, j13, j14, j15, j16, z5, outOfQuotaPolicy3, i11, i12, j17, i13, i14, str5, bool2);
    }

    public final long calculateNextRunTime() {
        return Companion.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride);
    }

    public final String component1() {
        return this.id;
    }

    public final Constraints component10() {
        return this.constraints;
    }

    public final int component11() {
        return this.runAttemptCount;
    }

    public final BackoffPolicy component12() {
        return this.backoffPolicy;
    }

    public final long component13() {
        return this.backoffDelayDuration;
    }

    public final long component14() {
        return this.lastEnqueueTime;
    }

    public final long component15() {
        return this.minimumRetentionDuration;
    }

    public final long component16() {
        return this.scheduleRequestedAt;
    }

    public final boolean component17() {
        return this.expedited;
    }

    public final OutOfQuotaPolicy component18() {
        return this.outOfQuotaPolicy;
    }

    public final int component19() {
        return this.periodCount;
    }

    public final WorkInfo.State component2() {
        return this.state;
    }

    public final int component20() {
        return this.generation;
    }

    public final long component21() {
        return this.nextScheduleTimeOverride;
    }

    public final int component22() {
        return this.nextScheduleTimeOverrideGeneration;
    }

    public final int component23() {
        return this.stopReason;
    }

    public final String component24() {
        return this.traceTag;
    }

    public final Boolean component25() {
        return this.backOffOnSystemInterruptions;
    }

    public final String component3() {
        return this.workerClassName;
    }

    public final String component4() {
        return this.inputMergerClassName;
    }

    public final Data component5() {
        return this.input;
    }

    public final Data component6() {
        return this.output;
    }

    public final long component7() {
        return this.initialDelay;
    }

    public final long component8() {
        return this.intervalDuration;
    }

    public final long component9() {
        return this.flexDuration;
    }

    public final WorkSpec copy(String str, WorkInfo.State state2, String str2, String str3, Data data, Data data2, long j5, long j6, long j7, Constraints constraints2, @IntRange(from = 0) int i5, BackoffPolicy backoffPolicy2, long j8, long j9, long j10, long j11, boolean z4, OutOfQuotaPolicy outOfQuotaPolicy2, int i6, int i7, long j12, int i8, int i9, String str4, Boolean bool) {
        String str5 = str;
        t.e(str5, "id");
        WorkInfo.State state3 = state2;
        t.e(state3, MRAIDCommunicatorUtil.KEY_STATE);
        String str6 = str2;
        t.e(str6, "workerClassName");
        String str7 = str3;
        t.e(str7, "inputMergerClassName");
        Data data3 = data;
        t.e(data3, "input");
        Data data4 = data2;
        t.e(data4, "output");
        Constraints constraints3 = constraints2;
        t.e(constraints3, "constraints");
        t.e(backoffPolicy2, "backoffPolicy");
        OutOfQuotaPolicy outOfQuotaPolicy3 = outOfQuotaPolicy2;
        t.e(outOfQuotaPolicy3, "outOfQuotaPolicy");
        OutOfQuotaPolicy outOfQuotaPolicy4 = outOfQuotaPolicy3;
        return new WorkSpec(str5, state3, str6, str7, data3, data4, j5, j6, j7, constraints3, i5, backoffPolicy2, j8, j9, j10, j11, z4, outOfQuotaPolicy4, i6, i7, j12, i8, i9, str4, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        return t.a(this.id, workSpec.id) && this.state == workSpec.state && t.a(this.workerClassName, workSpec.workerClassName) && t.a(this.inputMergerClassName, workSpec.inputMergerClassName) && t.a(this.input, workSpec.input) && t.a(this.output, workSpec.output) && this.initialDelay == workSpec.initialDelay && this.intervalDuration == workSpec.intervalDuration && this.flexDuration == workSpec.flexDuration && t.a(this.constraints, workSpec.constraints) && this.runAttemptCount == workSpec.runAttemptCount && this.backoffPolicy == workSpec.backoffPolicy && this.backoffDelayDuration == workSpec.backoffDelayDuration && this.lastEnqueueTime == workSpec.lastEnqueueTime && this.minimumRetentionDuration == workSpec.minimumRetentionDuration && this.scheduleRequestedAt == workSpec.scheduleRequestedAt && this.expedited == workSpec.expedited && this.outOfQuotaPolicy == workSpec.outOfQuotaPolicy && this.periodCount == workSpec.periodCount && this.generation == workSpec.generation && this.nextScheduleTimeOverride == workSpec.nextScheduleTimeOverride && this.nextScheduleTimeOverrideGeneration == workSpec.nextScheduleTimeOverrideGeneration && this.stopReason == workSpec.stopReason && t.a(this.traceTag, workSpec.traceTag) && t.a(this.backOffOnSystemInterruptions, workSpec.backOffOnSystemInterruptions);
    }

    public final Boolean getBackOffOnSystemInterruptions() {
        return this.backOffOnSystemInterruptions;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final long getNextScheduleTimeOverride() {
        return this.nextScheduleTimeOverride;
    }

    public final int getNextScheduleTimeOverrideGeneration() {
        return this.nextScheduleTimeOverrideGeneration;
    }

    public final int getPeriodCount() {
        return this.periodCount;
    }

    public final int getStopReason() {
        return this.stopReason;
    }

    public final String getTraceTag() {
        return this.traceTag;
    }

    public final boolean hasConstraints() {
        return !t.a(Constraints.NONE, this.constraints);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.workerClassName.hashCode()) * 31) + this.inputMergerClassName.hashCode()) * 31) + this.input.hashCode()) * 31) + this.output.hashCode()) * 31) + a.a(this.initialDelay)) * 31) + a.a(this.intervalDuration)) * 31) + a.a(this.flexDuration)) * 31) + this.constraints.hashCode()) * 31) + this.runAttemptCount) * 31) + this.backoffPolicy.hashCode()) * 31) + a.a(this.backoffDelayDuration)) * 31) + a.a(this.lastEnqueueTime)) * 31) + a.a(this.minimumRetentionDuration)) * 31) + a.a(this.scheduleRequestedAt)) * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.expedited)) * 31) + this.outOfQuotaPolicy.hashCode()) * 31) + this.periodCount) * 31) + this.generation) * 31) + a.a(this.nextScheduleTimeOverride)) * 31) + this.nextScheduleTimeOverrideGeneration) * 31) + this.stopReason) * 31;
        String str = this.traceTag;
        int i5 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.backOffOnSystemInterruptions;
        if (bool != null) {
            i5 = bool.hashCode();
        }
        return hashCode2 + i5;
    }

    public final boolean isBackedOff() {
        if (this.state != WorkInfo.State.ENQUEUED || this.runAttemptCount <= 0) {
            return false;
        }
        return true;
    }

    public final boolean isPeriodic() {
        if (this.intervalDuration != 0) {
            return true;
        }
        return false;
    }

    public final void setBackOffOnSystemInterruptions(Boolean bool) {
        this.backOffOnSystemInterruptions = bool;
    }

    public final void setBackoffDelayDuration(long j5) {
        if (j5 > WorkRequest.MAX_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value");
        }
        if (j5 < WorkRequest.MIN_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration less than minimum value");
        }
        this.backoffDelayDuration = C2729e.i(j5, WorkRequest.MIN_BACKOFF_MILLIS, WorkRequest.MAX_BACKOFF_MILLIS);
    }

    public final void setNextScheduleTimeOverride(long j5) {
        this.nextScheduleTimeOverride = j5;
    }

    public final void setNextScheduleTimeOverrideGeneration(int i5) {
        this.nextScheduleTimeOverrideGeneration = i5;
    }

    public final void setPeriodCount(int i5) {
        this.periodCount = i5;
    }

    public final void setPeriodic(long j5) {
        if (j5 < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        setPeriodic(C2729e.d(j5, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS), C2729e.d(j5, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS));
    }

    public final void setTraceTag(String str) {
        this.traceTag = str;
    }

    public String toString() {
        return "{WorkSpec: " + this.id + '}';
    }

    public final void setPeriodic(long j5, long j6) {
        if (j5 < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        this.intervalDuration = C2729e.d(j5, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS);
        if (j6 < PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            Logger.get().warning(TAG, "Flex duration lesser than minimum allowed value; Changed to 300000");
        }
        if (j6 > this.intervalDuration) {
            Logger logger = Logger.get();
            String str = TAG;
            logger.warning(str, "Flex duration greater than interval duration; Changed to " + j5);
        }
        this.flexDuration = C2729e.i(j6, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS, this.intervalDuration);
    }

    public static final class WorkInfoPojo {
        @ColumnInfo(name = "backoff_delay_duration")
        private long backoffDelayDuration;
        @ColumnInfo(name = "backoff_policy")
        private BackoffPolicy backoffPolicy;
        @Embedded
        private final Constraints constraints;
        @ColumnInfo(name = "flex_duration")
        private final long flexDuration;
        @ColumnInfo(name = "generation")
        private final int generation;
        @ColumnInfo(name = "id")
        private final String id;
        @ColumnInfo(name = "initial_delay")
        private final long initialDelay;
        @ColumnInfo(name = "interval_duration")
        private final long intervalDuration;
        @ColumnInfo(name = "last_enqueue_time")
        private long lastEnqueueTime;
        @ColumnInfo(name = "next_schedule_time_override")
        private final long nextScheduleTimeOverride;
        @ColumnInfo(name = "output")
        private final Data output;
        @ColumnInfo(defaultValue = "0", name = "period_count")
        private int periodCount;
        @Relation(entity = WorkProgress.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"progress"})
        private final List<Data> progress;
        @ColumnInfo(name = "run_attempt_count")
        private final int runAttemptCount;
        @ColumnInfo(name = "state")
        private final WorkInfo.State state;
        @ColumnInfo(name = "stop_reason")
        private final int stopReason;
        @Relation(entity = WorkTag.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"tag"})
        private final List<String> tags;

        public WorkInfoPojo(String str, WorkInfo.State state2, Data data, long j5, long j6, long j7, Constraints constraints2, int i5, BackoffPolicy backoffPolicy2, long j8, long j9, int i6, int i7, long j10, int i8, List<String> list, List<Data> list2) {
            BackoffPolicy backoffPolicy3 = backoffPolicy2;
            List<String> list3 = list;
            List<Data> list4 = list2;
            t.e(str, "id");
            t.e(state2, MRAIDCommunicatorUtil.KEY_STATE);
            t.e(data, "output");
            t.e(constraints2, "constraints");
            t.e(backoffPolicy3, "backoffPolicy");
            t.e(list3, "tags");
            t.e(list4, "progress");
            this.id = str;
            this.state = state2;
            this.output = data;
            this.initialDelay = j5;
            this.intervalDuration = j6;
            this.flexDuration = j7;
            this.constraints = constraints2;
            this.runAttemptCount = i5;
            this.backoffPolicy = backoffPolicy3;
            this.backoffDelayDuration = j8;
            this.lastEnqueueTime = j9;
            this.periodCount = i6;
            this.generation = i7;
            this.nextScheduleTimeOverride = j10;
            this.stopReason = i8;
            this.tags = list3;
            this.progress = list4;
        }

        private final long calculateNextRunTimeMillis() {
            if (this.state == WorkInfo.State.ENQUEUED) {
                return WorkSpec.Companion.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride);
            }
            return Long.MAX_VALUE;
        }

        public static /* synthetic */ WorkInfoPojo copy$default(WorkInfoPojo workInfoPojo, String str, WorkInfo.State state2, Data data, long j5, long j6, long j7, Constraints constraints2, int i5, BackoffPolicy backoffPolicy2, long j8, long j9, int i6, int i7, long j10, int i8, List list, List list2, int i9, Object obj) {
            WorkInfoPojo workInfoPojo2 = workInfoPojo;
            int i10 = i9;
            return workInfoPojo2.copy((i10 & 1) != 0 ? workInfoPojo2.id : str, (i10 & 2) != 0 ? workInfoPojo2.state : state2, (i10 & 4) != 0 ? workInfoPojo2.output : data, (i10 & 8) != 0 ? workInfoPojo2.initialDelay : j5, (i10 & 16) != 0 ? workInfoPojo2.intervalDuration : j6, (i10 & 32) != 0 ? workInfoPojo2.flexDuration : j7, (i10 & 64) != 0 ? workInfoPojo2.constraints : constraints2, (i10 & 128) != 0 ? workInfoPojo2.runAttemptCount : i5, (i10 & 256) != 0 ? workInfoPojo2.backoffPolicy : backoffPolicy2, (i10 & 512) != 0 ? workInfoPojo2.backoffDelayDuration : j8, (i10 & 1024) != 0 ? workInfoPojo2.lastEnqueueTime : j9, (i10 & 2048) != 0 ? workInfoPojo2.periodCount : i6, (i10 & 4096) != 0 ? workInfoPojo2.generation : i7, (i10 & 8192) != 0 ? workInfoPojo2.nextScheduleTimeOverride : j10, (i10 & 16384) != 0 ? workInfoPojo2.stopReason : i8, (32768 & i10) != 0 ? workInfoPojo2.tags : list, (i10 & 65536) != 0 ? workInfoPojo2.progress : list2);
        }

        private final WorkInfo.PeriodicityInfo getPeriodicityOrNull() {
            long j5 = this.intervalDuration;
            if (j5 != 0) {
                return new WorkInfo.PeriodicityInfo(j5, this.flexDuration);
            }
            return null;
        }

        public final String component1() {
            return this.id;
        }

        public final long component10() {
            return this.backoffDelayDuration;
        }

        public final long component11() {
            return this.lastEnqueueTime;
        }

        public final int component12() {
            return this.periodCount;
        }

        public final int component13() {
            return this.generation;
        }

        public final long component14() {
            return this.nextScheduleTimeOverride;
        }

        public final int component15() {
            return this.stopReason;
        }

        public final List<String> component16() {
            return this.tags;
        }

        public final List<Data> component17() {
            return this.progress;
        }

        public final WorkInfo.State component2() {
            return this.state;
        }

        public final Data component3() {
            return this.output;
        }

        public final long component4() {
            return this.initialDelay;
        }

        public final long component5() {
            return this.intervalDuration;
        }

        public final long component6() {
            return this.flexDuration;
        }

        public final Constraints component7() {
            return this.constraints;
        }

        public final int component8() {
            return this.runAttemptCount;
        }

        public final BackoffPolicy component9() {
            return this.backoffPolicy;
        }

        public final WorkInfoPojo copy(String str, WorkInfo.State state2, Data data, long j5, long j6, long j7, Constraints constraints2, int i5, BackoffPolicy backoffPolicy2, long j8, long j9, int i6, int i7, long j10, int i8, List<String> list, List<Data> list2) {
            String str2 = str;
            t.e(str2, "id");
            WorkInfo.State state3 = state2;
            t.e(state3, MRAIDCommunicatorUtil.KEY_STATE);
            Data data2 = data;
            t.e(data2, "output");
            Constraints constraints3 = constraints2;
            t.e(constraints3, "constraints");
            BackoffPolicy backoffPolicy3 = backoffPolicy2;
            t.e(backoffPolicy3, "backoffPolicy");
            t.e(list, "tags");
            List<Data> list3 = list2;
            t.e(list3, "progress");
            List<Data> list4 = list3;
            return new WorkInfoPojo(str2, state3, data2, j5, j6, j7, constraints3, i5, backoffPolicy3, j8, j9, i6, i7, j10, i8, list, list4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) obj;
            return t.a(this.id, workInfoPojo.id) && this.state == workInfoPojo.state && t.a(this.output, workInfoPojo.output) && this.initialDelay == workInfoPojo.initialDelay && this.intervalDuration == workInfoPojo.intervalDuration && this.flexDuration == workInfoPojo.flexDuration && t.a(this.constraints, workInfoPojo.constraints) && this.runAttemptCount == workInfoPojo.runAttemptCount && this.backoffPolicy == workInfoPojo.backoffPolicy && this.backoffDelayDuration == workInfoPojo.backoffDelayDuration && this.lastEnqueueTime == workInfoPojo.lastEnqueueTime && this.periodCount == workInfoPojo.periodCount && this.generation == workInfoPojo.generation && this.nextScheduleTimeOverride == workInfoPojo.nextScheduleTimeOverride && this.stopReason == workInfoPojo.stopReason && t.a(this.tags, workInfoPojo.tags) && t.a(this.progress, workInfoPojo.progress);
        }

        public final long getBackoffDelayDuration() {
            return this.backoffDelayDuration;
        }

        public final BackoffPolicy getBackoffPolicy() {
            return this.backoffPolicy;
        }

        public final Constraints getConstraints() {
            return this.constraints;
        }

        public final long getFlexDuration() {
            return this.flexDuration;
        }

        public final int getGeneration() {
            return this.generation;
        }

        public final String getId() {
            return this.id;
        }

        public final long getInitialDelay() {
            return this.initialDelay;
        }

        public final long getIntervalDuration() {
            return this.intervalDuration;
        }

        public final long getLastEnqueueTime() {
            return this.lastEnqueueTime;
        }

        public final long getNextScheduleTimeOverride() {
            return this.nextScheduleTimeOverride;
        }

        public final Data getOutput() {
            return this.output;
        }

        public final int getPeriodCount() {
            return this.periodCount;
        }

        public final List<Data> getProgress() {
            return this.progress;
        }

        public final int getRunAttemptCount() {
            return this.runAttemptCount;
        }

        public final WorkInfo.State getState() {
            return this.state;
        }

        public final int getStopReason() {
            return this.stopReason;
        }

        public final List<String> getTags() {
            return this.tags;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.output.hashCode()) * 31) + a.a(this.initialDelay)) * 31) + a.a(this.intervalDuration)) * 31) + a.a(this.flexDuration)) * 31) + this.constraints.hashCode()) * 31) + this.runAttemptCount) * 31) + this.backoffPolicy.hashCode()) * 31) + a.a(this.backoffDelayDuration)) * 31) + a.a(this.lastEnqueueTime)) * 31) + this.periodCount) * 31) + this.generation) * 31) + a.a(this.nextScheduleTimeOverride)) * 31) + this.stopReason) * 31) + this.tags.hashCode()) * 31) + this.progress.hashCode();
        }

        public final boolean isBackedOff() {
            if (this.state != WorkInfo.State.ENQUEUED || this.runAttemptCount <= 0) {
                return false;
            }
            return true;
        }

        public final boolean isPeriodic() {
            if (this.intervalDuration != 0) {
                return true;
            }
            return false;
        }

        public final void setBackoffDelayDuration(long j5) {
            this.backoffDelayDuration = j5;
        }

        public final void setBackoffPolicy(BackoffPolicy backoffPolicy2) {
            t.e(backoffPolicy2, "<set-?>");
            this.backoffPolicy = backoffPolicy2;
        }

        public final void setLastEnqueueTime(long j5) {
            this.lastEnqueueTime = j5;
        }

        public final void setPeriodCount(int i5) {
            this.periodCount = i5;
        }

        public String toString() {
            return "WorkInfoPojo(id=" + this.id + ", state=" + this.state + ", output=" + this.output + ", initialDelay=" + this.initialDelay + ", intervalDuration=" + this.intervalDuration + ", flexDuration=" + this.flexDuration + ", constraints=" + this.constraints + ", runAttemptCount=" + this.runAttemptCount + ", backoffPolicy=" + this.backoffPolicy + ", backoffDelayDuration=" + this.backoffDelayDuration + ", lastEnqueueTime=" + this.lastEnqueueTime + ", periodCount=" + this.periodCount + ", generation=" + this.generation + ", nextScheduleTimeOverride=" + this.nextScheduleTimeOverride + ", stopReason=" + this.stopReason + ", tags=" + this.tags + ", progress=" + this.progress + ')';
        }

        public final WorkInfo toWorkInfo() {
            Data data;
            if (!this.progress.isEmpty()) {
                data = this.progress.get(0);
            } else {
                data = Data.EMPTY;
            }
            Data data2 = data;
            UUID fromString = UUID.fromString(this.id);
            t.d(fromString, "fromString(...)");
            return new WorkInfo(fromString, this.state, new HashSet(this.tags), this.output, data2, this.runAttemptCount, this.generation, this.constraints, this.initialDelay, getPeriodicityOrNull(), calculateNextRunTimeMillis(), this.stopReason);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ WorkInfoPojo(java.lang.String r29, androidx.work.WorkInfo.State r30, androidx.work.Data r31, long r32, long r34, long r36, androidx.work.Constraints r38, int r39, androidx.work.BackoffPolicy r40, long r41, long r43, int r45, int r46, long r47, int r49, java.util.List r50, java.util.List r51, int r52, kotlin.jvm.internal.C2633k r53) {
            /*
                r28 = this;
                r0 = r52
                r1 = r0 & 8
                r2 = 0
                if (r1 == 0) goto L_0x000a
                r8 = r2
                goto L_0x000c
            L_0x000a:
                r8 = r32
            L_0x000c:
                r1 = r0 & 16
                if (r1 == 0) goto L_0x0012
                r10 = r2
                goto L_0x0014
            L_0x0012:
                r10 = r34
            L_0x0014:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x001a
                r12 = r2
                goto L_0x001c
            L_0x001a:
                r12 = r36
            L_0x001c:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L_0x0025
                androidx.work.BackoffPolicy r1 = androidx.work.BackoffPolicy.EXPONENTIAL
                r16 = r1
                goto L_0x0027
            L_0x0025:
                r16 = r40
            L_0x0027:
                r1 = r0 & 512(0x200, float:7.175E-43)
                if (r1 == 0) goto L_0x0030
                r4 = 30000(0x7530, double:1.4822E-319)
                r17 = r4
                goto L_0x0032
            L_0x0030:
                r17 = r41
            L_0x0032:
                r1 = r0 & 1024(0x400, float:1.435E-42)
                if (r1 == 0) goto L_0x0039
                r19 = r2
                goto L_0x003b
            L_0x0039:
                r19 = r43
            L_0x003b:
                r0 = r0 & 2048(0x800, float:2.87E-42)
                if (r0 == 0) goto L_0x0059
                r0 = 0
                r21 = r0
            L_0x0042:
                r4 = r28
                r5 = r29
                r6 = r30
                r7 = r31
                r14 = r38
                r15 = r39
                r22 = r46
                r23 = r47
                r25 = r49
                r26 = r50
                r27 = r51
                goto L_0x005c
            L_0x0059:
                r21 = r45
                goto L_0x0042
            L_0x005c:
                r4.<init>(r5, r6, r7, r8, r10, r12, r14, r15, r16, r17, r19, r21, r22, r23, r25, r26, r27)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpec.WorkInfoPojo.<init>(java.lang.String, androidx.work.WorkInfo$State, androidx.work.Data, long, long, long, androidx.work.Constraints, int, androidx.work.BackoffPolicy, long, long, int, int, long, int, java.util.List, java.util.List, int, kotlin.jvm.internal.k):void");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WorkSpec(java.lang.String r37, androidx.work.WorkInfo.State r38, java.lang.String r39, java.lang.String r40, androidx.work.Data r41, androidx.work.Data r42, long r43, long r45, long r47, androidx.work.Constraints r49, int r50, androidx.work.BackoffPolicy r51, long r52, long r54, long r56, long r58, boolean r60, androidx.work.OutOfQuotaPolicy r61, int r62, int r63, long r64, int r66, int r67, java.lang.String r68, java.lang.Boolean r69, int r70, kotlin.jvm.internal.C2633k r71) {
        /*
            r36 = this;
            r0 = r70
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.ENQUEUED
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r38
        L_0x000c:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x001d
            java.lang.Class<androidx.work.OverwritingInputMerger> r1 = androidx.work.OverwritingInputMerger.class
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "getName(...)"
            kotlin.jvm.internal.t.d(r1, r2)
            r6 = r1
            goto L_0x001f
        L_0x001d:
            r6 = r40
        L_0x001f:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0027
            androidx.work.Data r1 = androidx.work.Data.EMPTY
            r7 = r1
            goto L_0x0029
        L_0x0027:
            r7 = r41
        L_0x0029:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0031
            androidx.work.Data r1 = androidx.work.Data.EMPTY
            r8 = r1
            goto L_0x0033
        L_0x0031:
            r8 = r42
        L_0x0033:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x003b
            r9 = r2
            goto L_0x003d
        L_0x003b:
            r9 = r43
        L_0x003d:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0043
            r11 = r2
            goto L_0x0045
        L_0x0043:
            r11 = r45
        L_0x0045:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x004b
            r13 = r2
            goto L_0x004d
        L_0x004b:
            r13 = r47
        L_0x004d:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0055
            androidx.work.Constraints r1 = androidx.work.Constraints.NONE
            r15 = r1
            goto L_0x0057
        L_0x0055:
            r15 = r49
        L_0x0057:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            r5 = 0
            if (r1 == 0) goto L_0x005f
            r16 = r5
            goto L_0x0061
        L_0x005f:
            r16 = r50
        L_0x0061:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x006a
            androidx.work.BackoffPolicy r1 = androidx.work.BackoffPolicy.EXPONENTIAL
            r17 = r1
            goto L_0x006c
        L_0x006a:
            r17 = r51
        L_0x006c:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0073
            r18 = 30000(0x7530, double:1.4822E-319)
            goto L_0x0075
        L_0x0073:
            r18 = r52
        L_0x0075:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            r20 = -1
            if (r1 == 0) goto L_0x007e
            r22 = r20
            goto L_0x0080
        L_0x007e:
            r22 = r54
        L_0x0080:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0085
            goto L_0x0087
        L_0x0085:
            r2 = r56
        L_0x0087:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0090
            r24 = r20
            goto L_0x0092
        L_0x0090:
            r24 = r58
        L_0x0092:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x009a
            r26 = r5
            goto L_0x009c
        L_0x009a:
            r26 = r60
        L_0x009c:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a6
            androidx.work.OutOfQuotaPolicy r1 = androidx.work.OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST
            r27 = r1
            goto L_0x00a8
        L_0x00a6:
            r27 = r61
        L_0x00a8:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b0
            r28 = r5
            goto L_0x00b2
        L_0x00b0:
            r28 = r62
        L_0x00b2:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00ba
            r29 = r5
            goto L_0x00bc
        L_0x00ba:
            r29 = r63
        L_0x00bc:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00c9
            r20 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r30 = r20
            goto L_0x00cb
        L_0x00c9:
            r30 = r64
        L_0x00cb:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00d3
            r32 = r5
            goto L_0x00d5
        L_0x00d3:
            r32 = r66
        L_0x00d5:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00df
            r1 = -256(0xffffffffffffff00, float:NaN)
            r33 = r1
            goto L_0x00e1
        L_0x00df:
            r33 = r67
        L_0x00e1:
            r1 = 8388608(0x800000, float:1.17549435E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00ea
            r1 = 0
            r34 = r1
            goto L_0x00ec
        L_0x00ea:
            r34 = r68
        L_0x00ec:
            r1 = 16777216(0x1000000, float:2.3509887E-38)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0100
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r35 = r0
        L_0x00f5:
            r5 = r39
            r20 = r22
            r22 = r2
            r2 = r36
            r3 = r37
            goto L_0x0103
        L_0x0100:
            r35 = r69
            goto L_0x00f5
        L_0x0103:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r13, r15, r16, r17, r18, r20, r22, r24, r26, r27, r28, r29, r30, r32, r33, r34, r35)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpec.<init>(java.lang.String, androidx.work.WorkInfo$State, java.lang.String, java.lang.String, androidx.work.Data, androidx.work.Data, long, long, long, androidx.work.Constraints, int, androidx.work.BackoffPolicy, long, long, long, long, boolean, androidx.work.OutOfQuotaPolicy, int, int, long, int, int, java.lang.String, java.lang.Boolean, int, kotlin.jvm.internal.k):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WorkSpec(java.lang.String r38, java.lang.String r39) {
        /*
            r37 = this;
            java.lang.String r0 = "id"
            r2 = r38
            kotlin.jvm.internal.t.e(r2, r0)
            java.lang.String r0 = "workerClassName_"
            r4 = r39
            kotlin.jvm.internal.t.e(r4, r0)
            r35 = 33554426(0x1fffffa, float:9.4039514E-38)
            r36 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r1 = r37
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r10, r12, r14, r15, r16, r17, r19, r21, r23, r25, r26, r27, r28, r29, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpec.<init>(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WorkSpec(java.lang.String r39, androidx.work.impl.model.WorkSpec r40) {
        /*
            r38 = this;
            r0 = r40
            java.lang.String r1 = "newId"
            r3 = r39
            kotlin.jvm.internal.t.e(r3, r1)
            java.lang.String r1 = "other"
            kotlin.jvm.internal.t.e(r0, r1)
            java.lang.String r5 = r0.workerClassName
            androidx.work.WorkInfo$State r4 = r0.state
            java.lang.String r6 = r0.inputMergerClassName
            androidx.work.Data r7 = new androidx.work.Data
            androidx.work.Data r1 = r0.input
            r7.<init>((androidx.work.Data) r1)
            androidx.work.Data r8 = new androidx.work.Data
            androidx.work.Data r1 = r0.output
            r8.<init>((androidx.work.Data) r1)
            long r9 = r0.initialDelay
            long r11 = r0.intervalDuration
            long r13 = r0.flexDuration
            androidx.work.Constraints r15 = new androidx.work.Constraints
            androidx.work.Constraints r1 = r0.constraints
            r15.<init>(r1)
            int r1 = r0.runAttemptCount
            androidx.work.BackoffPolicy r2 = r0.backoffPolicy
            r16 = r1
            r17 = r2
            long r1 = r0.backoffDelayDuration
            r18 = r1
            long r1 = r0.lastEnqueueTime
            r20 = r1
            long r1 = r0.minimumRetentionDuration
            r22 = r1
            long r1 = r0.scheduleRequestedAt
            r24 = r1
            boolean r1 = r0.expedited
            androidx.work.OutOfQuotaPolicy r2 = r0.outOfQuotaPolicy
            r26 = r1
            int r1 = r0.periodCount
            r28 = r1
            r27 = r2
            long r1 = r0.nextScheduleTimeOverride
            r30 = r1
            int r1 = r0.nextScheduleTimeOverrideGeneration
            int r2 = r0.stopReason
            r32 = r1
            java.lang.String r1 = r0.traceTag
            java.lang.Boolean r0 = r0.backOffOnSystemInterruptions
            r36 = 524288(0x80000, float:7.34684E-40)
            r37 = 0
            r29 = 0
            r35 = r0
            r34 = r1
            r33 = r2
            r2 = r38
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r13, r15, r16, r17, r18, r20, r22, r24, r26, r27, r28, r29, r30, r32, r33, r34, r35, r36, r37)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpec.<init>(java.lang.String, androidx.work.impl.model.WorkSpec):void");
    }
}
