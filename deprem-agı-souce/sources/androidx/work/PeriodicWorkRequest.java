package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresApi;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.DurationApi26Impl;
import j$.time.Duration;
import j3.C2582a;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class PeriodicWorkRequest extends WorkRequest {
    public static final Companion Companion = new Companion((C2633k) null);
    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_FLEX_MILLIS = 300000;
    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_INTERVAL_MILLIS = 900000;

    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(Class<? extends ListenableWorker> cls, long j5, TimeUnit timeUnit) {
            super(cls);
            t.e(cls, "workerClass");
            t.e(timeUnit, "repeatIntervalTimeUnit");
            getWorkSpec$work_runtime_release().setPeriodic(timeUnit.toMillis(j5));
        }

        public final Builder clearNextScheduleTimeOverride() {
            getWorkSpec$work_runtime_release().setNextScheduleTimeOverride(Long.MAX_VALUE);
            getWorkSpec$work_runtime_release().setNextScheduleTimeOverrideGeneration(1);
            return this;
        }

        public Builder getThisObject$work_runtime_release() {
            return this;
        }

        public final Builder setNextScheduleTimeOverride(long j5) {
            if (j5 != Long.MAX_VALUE) {
                getWorkSpec$work_runtime_release().setNextScheduleTimeOverride(j5);
                getWorkSpec$work_runtime_release().setNextScheduleTimeOverrideGeneration(1);
                return this;
            }
            throw new IllegalArgumentException("Cannot set Long.MAX_VALUE as the schedule override time");
        }

        public PeriodicWorkRequest buildInternal$work_runtime_release() {
            if (getBackoffCriteriaSet$work_runtime_release() && getWorkSpec$work_runtime_release().constraints.requiresDeviceIdle()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            } else if (!getWorkSpec$work_runtime_release().expedited) {
                return new PeriodicWorkRequest(this);
            } else {
                throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(C2733c cVar, long j5, TimeUnit timeUnit) {
            super(C2582a.a(cVar));
            t.e(cVar, "workerClass");
            t.e(timeUnit, "repeatIntervalTimeUnit");
            getWorkSpec$work_runtime_release().setPeriodic(timeUnit.toMillis(j5));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(Class<? extends ListenableWorker> cls, Duration duration) {
            super(cls);
            t.e(cls, "workerClass");
            t.e(duration, "repeatInterval");
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(duration));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(C2733c cVar, Duration duration) {
            super(C2582a.a(cVar));
            t.e(cVar, "workerClass");
            t.e(duration, "repeatInterval");
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(duration));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(Class<? extends ListenableWorker> cls, long j5, TimeUnit timeUnit, long j6, TimeUnit timeUnit2) {
            super(cls);
            t.e(cls, "workerClass");
            t.e(timeUnit, "repeatIntervalTimeUnit");
            t.e(timeUnit2, "flexIntervalTimeUnit");
            getWorkSpec$work_runtime_release().setPeriodic(timeUnit.toMillis(j5), timeUnit2.toMillis(j6));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(C2733c cVar, long j5, TimeUnit timeUnit, long j6, TimeUnit timeUnit2) {
            super(C2582a.a(cVar));
            t.e(cVar, "workerClass");
            t.e(timeUnit, "repeatIntervalTimeUnit");
            t.e(timeUnit2, "flexIntervalTimeUnit");
            getWorkSpec$work_runtime_release().setPeriodic(timeUnit.toMillis(j5), timeUnit2.toMillis(j6));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(Class<? extends ListenableWorker> cls, Duration duration, Duration duration2) {
            super(cls);
            t.e(cls, "workerClass");
            t.e(duration, "repeatInterval");
            t.e(duration2, "flexInterval");
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(duration), DurationApi26Impl.toMillisCompat(duration2));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(C2733c cVar, Duration duration, Duration duration2) {
            super(C2582a.a(cVar));
            t.e(cVar, "workerClass");
            t.e(duration, "repeatInterval");
            t.e(duration2, "flexInterval");
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(duration), DurationApi26Impl.toMillisCompat(duration2));
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeriodicWorkRequest(Builder builder) {
        super(builder.getId$work_runtime_release(), builder.getWorkSpec$work_runtime_release(), builder.getTags$work_runtime_release());
        t.e(builder, "builder");
    }
}
