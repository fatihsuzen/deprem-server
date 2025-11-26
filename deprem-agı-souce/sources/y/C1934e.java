package y;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

/* renamed from: y.e  reason: case insensitive filesystem */
public final /* synthetic */ class C1934e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JobInfoSchedulerService f17012a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JobParameters f17013b;

    public /* synthetic */ C1934e(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f17012a = jobInfoSchedulerService;
        this.f17013b = jobParameters;
    }

    public final void run() {
        this.f17012a.jobFinished(this.f17013b, false);
    }
}
