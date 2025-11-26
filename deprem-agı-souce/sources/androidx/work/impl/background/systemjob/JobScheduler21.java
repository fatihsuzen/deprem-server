package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import java.util.List;
import kotlin.jvm.internal.t;

final class JobScheduler21 {
    public static final JobScheduler21 INSTANCE = new JobScheduler21();

    private JobScheduler21() {
    }

    public final List<JobInfo> getAllPendingJobs(JobScheduler jobScheduler) {
        t.e(jobScheduler, "jobScheduler");
        List<JobInfo> allPendingJobs = jobScheduler.getAllPendingJobs();
        t.d(allPendingJobs, "getAllPendingJobs(...)");
        return allPendingJobs;
    }
}
