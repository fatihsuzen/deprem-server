package androidx.work;

import android.os.Build;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.core.util.Consumer;
import androidx.work.impl.DefaultRunnableScheduler;
import androidx.work.multiprocess.RemoteWorkManager;
import b3.C2312i;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2729e;
import w3.C2865c0;
import w3.C2894r0;

public final class Configuration {
    public static final Companion Companion = new Companion((C2633k) null);
    public static final int MIN_SCHEDULER_LIMIT = 20;
    private final Clock clock;
    private final int contentUriTriggerWorkersLimit;
    private final String defaultProcessName;
    private final Executor executor;
    private final Consumer<Throwable> initializationExceptionHandler;
    private final InputMergerFactory inputMergerFactory;
    /* access modifiers changed from: private */
    public final boolean isMarkingJobsAsImportantWhileForeground;
    private final boolean isUsingDefaultTaskExecutor;
    private final int maxJobSchedulerId;
    private final int maxSchedulerLimit;
    private final int minJobSchedulerId;
    private final int minimumLoggingLevel;
    @IntRange(from = 0, to = 1200000)
    private final long remoteSessionTimeoutMillis;
    private final RunnableScheduler runnableScheduler;
    private final Consumer<Throwable> schedulingExceptionHandler;
    private final Executor taskExecutor;
    private final Tracer tracer;
    private final C2312i workerCoroutineContext;
    private final Consumer<WorkerExceptionInfo> workerExecutionExceptionHandler;
    private final WorkerFactory workerFactory;
    private final Consumer<WorkerExceptionInfo> workerInitializationExceptionHandler;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    public interface Provider {
        Configuration getWorkManagerConfiguration();
    }

    public Configuration(Builder builder) {
        int i5;
        t.e(builder, "builder");
        C2312i workerContext$work_runtime_release = builder.getWorkerContext$work_runtime_release();
        Executor executor$work_runtime_release = builder.getExecutor$work_runtime_release();
        boolean z4 = false;
        if (executor$work_runtime_release == null) {
            if (workerContext$work_runtime_release != null) {
                executor$work_runtime_release = ConfigurationKt.asExecutor(workerContext$work_runtime_release);
            } else {
                executor$work_runtime_release = null;
            }
            if (executor$work_runtime_release == null) {
                executor$work_runtime_release = ConfigurationKt.createDefaultExecutor(false);
            }
        }
        this.executor = executor$work_runtime_release;
        if (workerContext$work_runtime_release == null) {
            if (builder.getExecutor$work_runtime_release() != null) {
                workerContext$work_runtime_release = C2894r0.b(executor$work_runtime_release);
            } else {
                workerContext$work_runtime_release = C2865c0.a();
            }
        }
        this.workerCoroutineContext = workerContext$work_runtime_release;
        this.isUsingDefaultTaskExecutor = builder.getTaskExecutor$work_runtime_release() == null ? true : z4;
        Executor taskExecutor$work_runtime_release = builder.getTaskExecutor$work_runtime_release();
        this.taskExecutor = taskExecutor$work_runtime_release == null ? ConfigurationKt.createDefaultExecutor(true) : taskExecutor$work_runtime_release;
        Clock clock$work_runtime_release = builder.getClock$work_runtime_release();
        this.clock = clock$work_runtime_release == null ? new SystemClock() : clock$work_runtime_release;
        WorkerFactory workerFactory$work_runtime_release = builder.getWorkerFactory$work_runtime_release();
        this.workerFactory = workerFactory$work_runtime_release == null ? DefaultWorkerFactory.INSTANCE : workerFactory$work_runtime_release;
        InputMergerFactory inputMergerFactory$work_runtime_release = builder.getInputMergerFactory$work_runtime_release();
        this.inputMergerFactory = inputMergerFactory$work_runtime_release == null ? NoOpInputMergerFactory.INSTANCE : inputMergerFactory$work_runtime_release;
        RunnableScheduler runnableScheduler$work_runtime_release = builder.getRunnableScheduler$work_runtime_release();
        this.runnableScheduler = runnableScheduler$work_runtime_release == null ? new DefaultRunnableScheduler() : runnableScheduler$work_runtime_release;
        this.minimumLoggingLevel = builder.getLoggingLevel$work_runtime_release();
        this.minJobSchedulerId = builder.getMinJobSchedulerId$work_runtime_release();
        this.maxJobSchedulerId = builder.getMaxJobSchedulerId$work_runtime_release();
        if (Build.VERSION.SDK_INT == 23) {
            i5 = builder.getMaxSchedulerLimit$work_runtime_release() / 2;
        } else {
            i5 = builder.getMaxSchedulerLimit$work_runtime_release();
        }
        this.maxSchedulerLimit = i5;
        this.initializationExceptionHandler = builder.getInitializationExceptionHandler$work_runtime_release();
        this.schedulingExceptionHandler = builder.getSchedulingExceptionHandler$work_runtime_release();
        this.workerInitializationExceptionHandler = builder.getWorkerInitializationExceptionHandler$work_runtime_release();
        this.workerExecutionExceptionHandler = builder.getWorkerExecutionExceptionHandler$work_runtime_release();
        this.defaultProcessName = builder.getDefaultProcessName$work_runtime_release();
        this.remoteSessionTimeoutMillis = builder.getRemoteSessionTimeoutMillis$work_runtime_release();
        this.contentUriTriggerWorkersLimit = builder.getContentUriTriggerWorkersLimit$work_runtime_release();
        this.isMarkingJobsAsImportantWhileForeground = builder.getMarkJobsAsImportantWhileForeground$work_runtime_release();
        Tracer tracer$work_runtime_release = builder.getTracer$work_runtime_release();
        this.tracer = tracer$work_runtime_release == null ? ConfigurationKt.createDefaultTracer() : tracer$work_runtime_release;
    }

    @ExperimentalConfigurationApi
    private static /* synthetic */ void isMarkingJobsAsImportantWhileForeground$annotations() {
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final int getContentUriTriggerWorkersLimit() {
        return this.contentUriTriggerWorkersLimit;
    }

    public final String getDefaultProcessName() {
        return this.defaultProcessName;
    }

    public final Executor getExecutor() {
        return this.executor;
    }

    public final Consumer<Throwable> getInitializationExceptionHandler() {
        return this.initializationExceptionHandler;
    }

    public final InputMergerFactory getInputMergerFactory() {
        return this.inputMergerFactory;
    }

    public final int getMaxJobSchedulerId() {
        return this.maxJobSchedulerId;
    }

    @IntRange(from = 20, to = 50)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int getMaxSchedulerLimit() {
        return this.maxSchedulerLimit;
    }

    public final int getMinJobSchedulerId() {
        return this.minJobSchedulerId;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int getMinimumLoggingLevel() {
        return this.minimumLoggingLevel;
    }

    public final long getRemoteSessionTimeoutMillis() {
        return this.remoteSessionTimeoutMillis;
    }

    public final RunnableScheduler getRunnableScheduler() {
        return this.runnableScheduler;
    }

    public final Consumer<Throwable> getSchedulingExceptionHandler() {
        return this.schedulingExceptionHandler;
    }

    public final Executor getTaskExecutor() {
        return this.taskExecutor;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Tracer getTracer() {
        return this.tracer;
    }

    public final C2312i getWorkerCoroutineContext() {
        return this.workerCoroutineContext;
    }

    public final Consumer<WorkerExceptionInfo> getWorkerExecutionExceptionHandler() {
        return this.workerExecutionExceptionHandler;
    }

    public final WorkerFactory getWorkerFactory() {
        return this.workerFactory;
    }

    public final Consumer<WorkerExceptionInfo> getWorkerInitializationExceptionHandler() {
        return this.workerInitializationExceptionHandler;
    }

    @ExperimentalConfigurationApi
    public final boolean isMarkingJobsAsImportantWhileForeground() {
        return this.isMarkingJobsAsImportantWhileForeground;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isUsingDefaultTaskExecutor() {
        return this.isUsingDefaultTaskExecutor;
    }

    public static final class Builder {
        private Clock clock;
        private int contentUriTriggerWorkersLimit = 8;
        private String defaultProcessName;
        private Executor executor;
        private Consumer<Throwable> initializationExceptionHandler;
        private InputMergerFactory inputMergerFactory;
        private int loggingLevel = 4;
        private boolean markJobsAsImportantWhileForeground = true;
        private int maxJobSchedulerId = Integer.MAX_VALUE;
        private int maxSchedulerLimit = 20;
        private int minJobSchedulerId;
        private long remoteSessionTimeoutMillis = RemoteWorkManager.DEFAULT_SESSION_TIMEOUT_MILLIS;
        private RunnableScheduler runnableScheduler;
        private Consumer<Throwable> schedulingExceptionHandler;
        private Executor taskExecutor;
        private Tracer tracer;
        private C2312i workerContext;
        private Consumer<WorkerExceptionInfo> workerExecutionExceptionHandler;
        private WorkerFactory workerFactory;
        private Consumer<WorkerExceptionInfo> workerInitializationExceptionHandler;

        public Builder() {
        }

        public final Configuration build() {
            return new Configuration(this);
        }

        public final Clock getClock$work_runtime_release() {
            return this.clock;
        }

        public final int getContentUriTriggerWorkersLimit$work_runtime_release() {
            return this.contentUriTriggerWorkersLimit;
        }

        public final String getDefaultProcessName$work_runtime_release() {
            return this.defaultProcessName;
        }

        public final Executor getExecutor$work_runtime_release() {
            return this.executor;
        }

        public final Consumer<Throwable> getInitializationExceptionHandler$work_runtime_release() {
            return this.initializationExceptionHandler;
        }

        public final InputMergerFactory getInputMergerFactory$work_runtime_release() {
            return this.inputMergerFactory;
        }

        public final int getLoggingLevel$work_runtime_release() {
            return this.loggingLevel;
        }

        public final boolean getMarkJobsAsImportantWhileForeground$work_runtime_release() {
            return this.markJobsAsImportantWhileForeground;
        }

        public final int getMaxJobSchedulerId$work_runtime_release() {
            return this.maxJobSchedulerId;
        }

        public final int getMaxSchedulerLimit$work_runtime_release() {
            return this.maxSchedulerLimit;
        }

        public final int getMinJobSchedulerId$work_runtime_release() {
            return this.minJobSchedulerId;
        }

        public final long getRemoteSessionTimeoutMillis$work_runtime_release() {
            return this.remoteSessionTimeoutMillis;
        }

        public final RunnableScheduler getRunnableScheduler$work_runtime_release() {
            return this.runnableScheduler;
        }

        public final Consumer<Throwable> getSchedulingExceptionHandler$work_runtime_release() {
            return this.schedulingExceptionHandler;
        }

        public final Executor getTaskExecutor$work_runtime_release() {
            return this.taskExecutor;
        }

        public final Tracer getTracer$work_runtime_release() {
            return this.tracer;
        }

        public final C2312i getWorkerContext$work_runtime_release() {
            return this.workerContext;
        }

        public final Consumer<WorkerExceptionInfo> getWorkerExecutionExceptionHandler$work_runtime_release() {
            return this.workerExecutionExceptionHandler;
        }

        public final WorkerFactory getWorkerFactory$work_runtime_release() {
            return this.workerFactory;
        }

        public final Consumer<WorkerExceptionInfo> getWorkerInitializationExceptionHandler$work_runtime_release() {
            return this.workerInitializationExceptionHandler;
        }

        public final Builder setClock(Clock clock2) {
            t.e(clock2, "clock");
            this.clock = clock2;
            return this;
        }

        public final void setClock$work_runtime_release(Clock clock2) {
            this.clock = clock2;
        }

        public final Builder setContentUriTriggerWorkersLimit(int i5) {
            this.contentUriTriggerWorkersLimit = Math.max(i5, 0);
            return this;
        }

        public final void setContentUriTriggerWorkersLimit$work_runtime_release(int i5) {
            this.contentUriTriggerWorkersLimit = i5;
        }

        public final Builder setDefaultProcessName(String str) {
            t.e(str, "processName");
            this.defaultProcessName = str;
            return this;
        }

        public final void setDefaultProcessName$work_runtime_release(String str) {
            this.defaultProcessName = str;
        }

        public final Builder setExecutor(Executor executor2) {
            t.e(executor2, "executor");
            this.executor = executor2;
            return this;
        }

        public final void setExecutor$work_runtime_release(Executor executor2) {
            this.executor = executor2;
        }

        public final Builder setInitializationExceptionHandler(Consumer<Throwable> consumer) {
            t.e(consumer, "exceptionHandler");
            this.initializationExceptionHandler = consumer;
            return this;
        }

        public final void setInitializationExceptionHandler$work_runtime_release(Consumer<Throwable> consumer) {
            this.initializationExceptionHandler = consumer;
        }

        public final Builder setInputMergerFactory(InputMergerFactory inputMergerFactory2) {
            t.e(inputMergerFactory2, "inputMergerFactory");
            this.inputMergerFactory = inputMergerFactory2;
            return this;
        }

        public final void setInputMergerFactory$work_runtime_release(InputMergerFactory inputMergerFactory2) {
            this.inputMergerFactory = inputMergerFactory2;
        }

        public final Builder setJobSchedulerJobIdRange(int i5, int i6) {
            if (i6 - i5 >= 1000) {
                this.minJobSchedulerId = i5;
                this.maxJobSchedulerId = i6;
                return this;
            }
            throw new IllegalArgumentException("WorkManager needs a range of at least 1000 job ids.");
        }

        public final void setLoggingLevel$work_runtime_release(int i5) {
            this.loggingLevel = i5;
        }

        public final void setMarkJobsAsImportantWhileForeground$work_runtime_release(boolean z4) {
            this.markJobsAsImportantWhileForeground = z4;
        }

        @ExperimentalConfigurationApi
        public final Builder setMarkingJobsAsImportantWhileForeground(boolean z4) {
            this.markJobsAsImportantWhileForeground = z4;
            return this;
        }

        public final void setMaxJobSchedulerId$work_runtime_release(int i5) {
            this.maxJobSchedulerId = i5;
        }

        public final Builder setMaxSchedulerLimit(int i5) {
            if (i5 >= 20) {
                this.maxSchedulerLimit = Math.min(i5, 50);
                return this;
            }
            throw new IllegalArgumentException("WorkManager needs to be able to schedule at least 20 jobs in JobScheduler.");
        }

        public final void setMaxSchedulerLimit$work_runtime_release(int i5) {
            this.maxSchedulerLimit = i5;
        }

        public final void setMinJobSchedulerId$work_runtime_release(int i5) {
            this.minJobSchedulerId = i5;
        }

        public final Builder setMinimumLoggingLevel(int i5) {
            this.loggingLevel = i5;
            return this;
        }

        public final Builder setRemoteSessionTimeoutMillis(@IntRange(from = 0, to = 1200000) long j5) {
            if (j5 >= 0) {
                this.remoteSessionTimeoutMillis = C2729e.f(j5, RemoteWorkManager.MAX_SESSION_TIMEOUT_MILLIS);
                return this;
            }
            throw new IllegalArgumentException("The remote session timeout must not be negative.");
        }

        public final void setRemoteSessionTimeoutMillis$work_runtime_release(long j5) {
            this.remoteSessionTimeoutMillis = j5;
        }

        public final Builder setRunnableScheduler(RunnableScheduler runnableScheduler2) {
            t.e(runnableScheduler2, "runnableScheduler");
            this.runnableScheduler = runnableScheduler2;
            return this;
        }

        public final void setRunnableScheduler$work_runtime_release(RunnableScheduler runnableScheduler2) {
            this.runnableScheduler = runnableScheduler2;
        }

        public final Builder setSchedulingExceptionHandler(Consumer<Throwable> consumer) {
            t.e(consumer, "schedulingExceptionHandler");
            this.schedulingExceptionHandler = consumer;
            return this;
        }

        public final void setSchedulingExceptionHandler$work_runtime_release(Consumer<Throwable> consumer) {
            this.schedulingExceptionHandler = consumer;
        }

        public final Builder setTaskExecutor(Executor executor2) {
            t.e(executor2, "taskExecutor");
            this.taskExecutor = executor2;
            return this;
        }

        public final void setTaskExecutor$work_runtime_release(Executor executor2) {
            this.taskExecutor = executor2;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final Builder setTracer(Tracer tracer2) {
            t.e(tracer2, "tracer");
            this.tracer = tracer2;
            return this;
        }

        public final void setTracer$work_runtime_release(Tracer tracer2) {
            this.tracer = tracer2;
        }

        public final void setWorkerContext$work_runtime_release(C2312i iVar) {
            this.workerContext = iVar;
        }

        public final Builder setWorkerCoroutineContext(C2312i iVar) {
            t.e(iVar, "context");
            this.workerContext = iVar;
            return this;
        }

        public final Builder setWorkerExecutionExceptionHandler(Consumer<WorkerExceptionInfo> consumer) {
            t.e(consumer, "workerExceptionHandler");
            this.workerExecutionExceptionHandler = consumer;
            return this;
        }

        public final void setWorkerExecutionExceptionHandler$work_runtime_release(Consumer<WorkerExceptionInfo> consumer) {
            this.workerExecutionExceptionHandler = consumer;
        }

        public final Builder setWorkerFactory(WorkerFactory workerFactory2) {
            t.e(workerFactory2, "workerFactory");
            this.workerFactory = workerFactory2;
            return this;
        }

        public final void setWorkerFactory$work_runtime_release(WorkerFactory workerFactory2) {
            this.workerFactory = workerFactory2;
        }

        public final Builder setWorkerInitializationExceptionHandler(Consumer<WorkerExceptionInfo> consumer) {
            t.e(consumer, "workerExceptionHandler");
            this.workerInitializationExceptionHandler = consumer;
            return this;
        }

        public final void setWorkerInitializationExceptionHandler$work_runtime_release(Consumer<WorkerExceptionInfo> consumer) {
            this.workerInitializationExceptionHandler = consumer;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(Configuration configuration) {
            t.e(configuration, "configuration");
            this.executor = configuration.getExecutor();
            this.workerFactory = configuration.getWorkerFactory();
            this.inputMergerFactory = configuration.getInputMergerFactory();
            this.taskExecutor = configuration.getTaskExecutor();
            this.clock = configuration.getClock();
            this.loggingLevel = configuration.getMinimumLoggingLevel();
            this.minJobSchedulerId = configuration.getMinJobSchedulerId();
            this.maxJobSchedulerId = configuration.getMaxJobSchedulerId();
            this.maxSchedulerLimit = configuration.getMaxSchedulerLimit();
            this.runnableScheduler = configuration.getRunnableScheduler();
            this.initializationExceptionHandler = configuration.getInitializationExceptionHandler();
            this.schedulingExceptionHandler = configuration.getSchedulingExceptionHandler();
            this.workerInitializationExceptionHandler = configuration.getWorkerInitializationExceptionHandler();
            this.workerExecutionExceptionHandler = configuration.getWorkerExecutionExceptionHandler();
            this.defaultProcessName = configuration.getDefaultProcessName();
            this.remoteSessionTimeoutMillis = configuration.getRemoteSessionTimeoutMillis();
            this.contentUriTriggerWorkersLimit = configuration.getContentUriTriggerWorkersLimit();
            this.markJobsAsImportantWhileForeground = configuration.isMarkingJobsAsImportantWhileForeground;
            this.tracer = configuration.getTracer();
        }
    }
}
