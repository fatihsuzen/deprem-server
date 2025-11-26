package androidx.work.impl.background.systemjob;

import X2.C2250q;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import java.util.List;
import k3.l;
import kotlin.jvm.internal.t;

public final class JobSchedulerExtKt {
    private static final String TAG;
    public static final String WORKMANAGER_NAMESPACE = "androidx.work.systemjobscheduler";

    static {
        String tagWithPrefix = Logger.tagWithPrefix("SystemJobScheduler");
        t.d(tagWithPrefix, "tagWithPrefix(...)");
        TAG = tagWithPrefix;
    }

    public static final String createErrorMessage(Context context, WorkDatabase workDatabase, Configuration configuration) {
        int i5;
        int i6;
        String str;
        t.e(context, "context");
        t.e(workDatabase, "workDatabase");
        t.e(configuration, "configuration");
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 31) {
            i5 = 150;
        } else {
            i5 = 100;
        }
        int size = workDatabase.workSpecDao().getScheduledWork().size();
        String str2 = "<faulty JobScheduler failed to getPendingJobs>";
        if (i7 >= 34) {
            JobScheduler wmJobScheduler = getWmJobScheduler(context);
            List<JobInfo> safePendingJobs = getSafePendingJobs(wmJobScheduler);
            if (safePendingJobs != null) {
                List<JobInfo> pendingJobs = SystemJobScheduler.getPendingJobs(context, wmJobScheduler);
                int i8 = 0;
                if (pendingJobs != null) {
                    i6 = safePendingJobs.size() - pendingJobs.size();
                } else {
                    i6 = 0;
                }
                String str3 = null;
                if (i6 == 0) {
                    str = null;
                } else {
                    str = i6 + " of which are not owned by WorkManager";
                }
                Object systemService = context.getSystemService("jobscheduler");
                t.c(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
                List<JobInfo> pendingJobs2 = SystemJobScheduler.getPendingJobs(context, (JobScheduler) systemService);
                if (pendingJobs2 != null) {
                    i8 = pendingJobs2.size();
                }
                if (i8 != 0) {
                    str3 = i8 + " from WorkManager in the default namespace";
                }
                str2 = C2250q.V(C2250q.k(safePendingJobs.size() + " jobs in \"androidx.work.systemjobscheduler\" namespace", str, str3), ",\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null);
            }
        } else {
            List<JobInfo> pendingJobs3 = SystemJobScheduler.getPendingJobs(context, getWmJobScheduler(context));
            if (pendingJobs3 != null) {
                str2 = pendingJobs3.size() + " jobs from WorkManager";
            }
        }
        return "JobScheduler " + i5 + " job limit exceeded.\nIn JobScheduler there are " + str2 + ".\nThere are " + size + " jobs tracked by WorkManager's database;\nthe Configuration limit is " + configuration.getMaxSchedulerLimit() + '.';
    }

    public static final List<JobInfo> getSafePendingJobs(JobScheduler jobScheduler) {
        t.e(jobScheduler, "<this>");
        try {
            return JobScheduler21.INSTANCE.getAllPendingJobs(jobScheduler);
        } catch (Throwable th) {
            Logger.get().error(TAG, "getAllPendingJobs() is not reliable on this device.", th);
            return null;
        }
    }

    public static final JobScheduler getWmJobScheduler(Context context) {
        t.e(context, "<this>");
        Object systemService = context.getSystemService("jobscheduler");
        t.c(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
        JobScheduler jobScheduler = (JobScheduler) systemService;
        if (Build.VERSION.SDK_INT >= 34) {
            return JobScheduler34.INSTANCE.forNamespace(jobScheduler);
        }
        return jobScheduler;
    }
}
