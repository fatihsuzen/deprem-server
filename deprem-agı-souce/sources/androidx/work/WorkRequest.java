package androidx.work;

import X2.C2250q;
import X2.T;
import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.DurationApi26Impl;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import j$.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

public abstract class WorkRequest {
    public static final Companion Companion = new Companion((C2633k) null);
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000;
    @SuppressLint({"MinMaxConstant"})
    public static final long MAX_BACKOFF_MILLIS = 18000000;
    private static final int MAX_TRACE_SPAN_LENGTH = 127;
    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_BACKOFF_MILLIS = 10000;
    private final UUID id;
    private final Set<String> tags;
    private final WorkSpec workSpec;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final String deriveTraceTagFromClassName(String str) {
            String str2;
            List G02 = s.G0(str, new String[]{"."}, false, 0, 6, (Object) null);
            if (G02.size() == 1) {
                str2 = (String) G02.get(0);
            } else {
                str2 = (String) C2250q.X(G02);
            }
            if (str2.length() <= WorkRequest.MAX_TRACE_SPAN_LENGTH) {
                return str2;
            }
            return s.d1(str2, WorkRequest.MAX_TRACE_SPAN_LENGTH);
        }

        private Companion() {
        }
    }

    public WorkRequest(UUID uuid, WorkSpec workSpec2, Set<String> set) {
        t.e(uuid, "id");
        t.e(workSpec2, "workSpec");
        t.e(set, "tags");
        this.id = uuid;
        this.workSpec = workSpec2;
        this.tags = set;
    }

    public UUID getId() {
        return this.id;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String getStringId() {
        String uuid = getId().toString();
        t.d(uuid, "toString(...)");
        return uuid;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Set<String> getTags() {
        return this.tags;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final WorkSpec getWorkSpec() {
        return this.workSpec;
    }

    public static abstract class Builder<B extends Builder<B, ?>, W extends WorkRequest> {
        private boolean backoffCriteriaSet;
        private UUID id;
        private final Set<String> tags;
        private WorkSpec workSpec;
        private final Class<? extends ListenableWorker> workerClass;

        public Builder(Class<? extends ListenableWorker> cls) {
            t.e(cls, "workerClass");
            this.workerClass = cls;
            UUID randomUUID = UUID.randomUUID();
            t.d(randomUUID, "randomUUID(...)");
            this.id = randomUUID;
            String uuid = this.id.toString();
            t.d(uuid, "toString(...)");
            String name = cls.getName();
            t.d(name, "getName(...)");
            this.workSpec = new WorkSpec(uuid, name);
            String name2 = cls.getName();
            t.d(name2, "getName(...)");
            this.tags = T.e(name2);
        }

        public final B addTag(String str) {
            t.e(str, "tag");
            this.tags.add(str);
            return getThisObject$work_runtime_release();
        }

        public final W build() {
            boolean z4;
            W buildInternal$work_runtime_release = buildInternal$work_runtime_release();
            Constraints constraints = this.workSpec.constraints;
            if ((Build.VERSION.SDK_INT < 24 || !constraints.hasContentUriTriggers()) && !constraints.requiresBatteryNotLow() && !constraints.requiresCharging() && !constraints.requiresDeviceIdle()) {
                z4 = false;
            } else {
                z4 = true;
            }
            WorkSpec workSpec2 = this.workSpec;
            if (workSpec2.expedited) {
                if (z4) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                } else if (workSpec2.initialDelay > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            String traceTag = workSpec2.getTraceTag();
            if (traceTag == null) {
                WorkSpec workSpec3 = this.workSpec;
                workSpec3.setTraceTag(WorkRequest.Companion.deriveTraceTagFromClassName(workSpec3.workerClassName));
            } else if (traceTag.length() > WorkRequest.MAX_TRACE_SPAN_LENGTH) {
                this.workSpec.setTraceTag(s.d1(traceTag, WorkRequest.MAX_TRACE_SPAN_LENGTH));
            }
            UUID randomUUID = UUID.randomUUID();
            t.d(randomUUID, "randomUUID(...)");
            setId(randomUUID);
            return buildInternal$work_runtime_release;
        }

        public abstract W buildInternal$work_runtime_release();

        public final boolean getBackoffCriteriaSet$work_runtime_release() {
            return this.backoffCriteriaSet;
        }

        public final UUID getId$work_runtime_release() {
            return this.id;
        }

        public final Set<String> getTags$work_runtime_release() {
            return this.tags;
        }

        public abstract B getThisObject$work_runtime_release();

        public final WorkSpec getWorkSpec$work_runtime_release() {
            return this.workSpec;
        }

        public final Class<? extends ListenableWorker> getWorkerClass$work_runtime_release() {
            return this.workerClass;
        }

        public final B keepResultsForAtLeast(long j5, TimeUnit timeUnit) {
            t.e(timeUnit, "timeUnit");
            this.workSpec.minimumRetentionDuration = timeUnit.toMillis(j5);
            return getThisObject$work_runtime_release();
        }

        public final B setBackoffCriteria(BackoffPolicy backoffPolicy, long j5, TimeUnit timeUnit) {
            t.e(backoffPolicy, "backoffPolicy");
            t.e(timeUnit, "timeUnit");
            this.backoffCriteriaSet = true;
            WorkSpec workSpec2 = this.workSpec;
            workSpec2.backoffPolicy = backoffPolicy;
            workSpec2.setBackoffDelayDuration(timeUnit.toMillis(j5));
            return getThisObject$work_runtime_release();
        }

        public final void setBackoffCriteriaSet$work_runtime_release(boolean z4) {
            this.backoffCriteriaSet = z4;
        }

        @ExperimentalWorkRequestBuilderApi
        public final B setBackoffForSystemInterruptions() {
            this.workSpec.setBackOffOnSystemInterruptions(Boolean.TRUE);
            return getThisObject$work_runtime_release();
        }

        public final B setConstraints(Constraints constraints) {
            t.e(constraints, "constraints");
            this.workSpec.constraints = constraints;
            return getThisObject$work_runtime_release();
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        public B setExpedited(OutOfQuotaPolicy outOfQuotaPolicy) {
            t.e(outOfQuotaPolicy, "policy");
            WorkSpec workSpec2 = this.workSpec;
            workSpec2.expedited = true;
            workSpec2.outOfQuotaPolicy = outOfQuotaPolicy;
            return getThisObject$work_runtime_release();
        }

        public final B setId(UUID uuid) {
            t.e(uuid, "id");
            this.id = uuid;
            String uuid2 = uuid.toString();
            t.d(uuid2, "toString(...)");
            this.workSpec = new WorkSpec(uuid2, this.workSpec);
            return getThisObject$work_runtime_release();
        }

        public final void setId$work_runtime_release(UUID uuid) {
            t.e(uuid, "<set-?>");
            this.id = uuid;
        }

        public B setInitialDelay(long j5, TimeUnit timeUnit) {
            t.e(timeUnit, "timeUnit");
            this.workSpec.initialDelay = timeUnit.toMillis(j5);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay) {
                return getThisObject$work_runtime_release();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        @VisibleForTesting
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final B setInitialRunAttemptCount(int i5) {
            this.workSpec.runAttemptCount = i5;
            return getThisObject$work_runtime_release();
        }

        @VisibleForTesting
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final B setInitialState(WorkInfo.State state) {
            t.e(state, MRAIDCommunicatorUtil.KEY_STATE);
            this.workSpec.state = state;
            return getThisObject$work_runtime_release();
        }

        public final B setInputData(Data data) {
            t.e(data, "inputData");
            this.workSpec.input = data;
            return getThisObject$work_runtime_release();
        }

        @VisibleForTesting
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final B setLastEnqueueTime(long j5, TimeUnit timeUnit) {
            t.e(timeUnit, "timeUnit");
            this.workSpec.lastEnqueueTime = timeUnit.toMillis(j5);
            return getThisObject$work_runtime_release();
        }

        @VisibleForTesting
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final B setScheduleRequestedAt(long j5, TimeUnit timeUnit) {
            t.e(timeUnit, "timeUnit");
            this.workSpec.scheduleRequestedAt = timeUnit.toMillis(j5);
            return getThisObject$work_runtime_release();
        }

        public final B setTraceTag(String str) {
            t.e(str, "traceTag");
            this.workSpec.setTraceTag(str);
            return getThisObject$work_runtime_release();
        }

        public final void setWorkSpec$work_runtime_release(WorkSpec workSpec2) {
            t.e(workSpec2, "<set-?>");
            this.workSpec = workSpec2;
        }

        @RequiresApi(26)
        public final B keepResultsForAtLeast(Duration duration) {
            t.e(duration, TypedValues.TransitionType.S_DURATION);
            this.workSpec.minimumRetentionDuration = DurationApi26Impl.toMillisCompat(duration);
            return getThisObject$work_runtime_release();
        }

        @RequiresApi(26)
        public final B setBackoffCriteria(BackoffPolicy backoffPolicy, Duration duration) {
            t.e(backoffPolicy, "backoffPolicy");
            t.e(duration, TypedValues.TransitionType.S_DURATION);
            this.backoffCriteriaSet = true;
            WorkSpec workSpec2 = this.workSpec;
            workSpec2.backoffPolicy = backoffPolicy;
            workSpec2.setBackoffDelayDuration(DurationApi26Impl.toMillisCompat(duration));
            return getThisObject$work_runtime_release();
        }

        @RequiresApi(26)
        public B setInitialDelay(Duration duration) {
            t.e(duration, TypedValues.TransitionType.S_DURATION);
            this.workSpec.initialDelay = DurationApi26Impl.toMillisCompat(duration);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay) {
                return getThisObject$work_runtime_release();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }
    }
}
