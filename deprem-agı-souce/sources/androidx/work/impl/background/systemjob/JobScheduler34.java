package androidx.work.impl.background.systemjob;

import android.app.job.JobScheduler;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;

@RequiresApi(34)
final class JobScheduler34 {
    public static final JobScheduler34 INSTANCE = new JobScheduler34();

    private JobScheduler34() {
    }

    public final JobScheduler forNamespace(JobScheduler jobScheduler) {
        t.e(jobScheduler, "jobScheduler");
        JobScheduler a5 = jobScheduler.forNamespace(JobSchedulerExtKt.WORKMANAGER_NAMESPACE);
        t.d(a5, "forNamespace(...)");
        return a5;
    }
}
