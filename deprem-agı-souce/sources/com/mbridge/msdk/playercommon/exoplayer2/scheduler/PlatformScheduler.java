package com.mbridge.msdk.playercommon.exoplayer2.scheduler;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

@TargetApi(21)
public final class PlatformScheduler implements Scheduler {
    private static final String KEY_REQUIREMENTS = "requirements";
    private static final String KEY_SERVICE_ACTION = "service_action";
    private static final String KEY_SERVICE_PACKAGE = "service_package";
    private static final String TAG = "PlatformScheduler";
    private final int jobId;
    private final JobScheduler jobScheduler;
    private final ComponentName jobServiceComponentName;

    public static final class PlatformSchedulerService extends JobService {
        public final boolean onStartJob(JobParameters jobParameters) {
            PlatformScheduler.logd("PlatformSchedulerService started");
            PersistableBundle extras = jobParameters.getExtras();
            if (new Requirements(extras.getInt(PlatformScheduler.KEY_REQUIREMENTS)).checkRequirements(this)) {
                PlatformScheduler.logd("Requirements are met");
                String string = extras.getString(PlatformScheduler.KEY_SERVICE_ACTION);
                String string2 = extras.getString(PlatformScheduler.KEY_SERVICE_PACKAGE);
                Intent intent = new Intent(string).setPackage(string2);
                PlatformScheduler.logd("Starting service action: " + string + " package: " + string2);
                Util.startForegroundService(this, intent);
                return false;
            }
            PlatformScheduler.logd("Requirements are not met");
            jobFinished(jobParameters, true);
            return false;
        }

        public final boolean onStopJob(JobParameters jobParameters) {
            return false;
        }
    }

    public PlatformScheduler(Context context, int i5) {
        this.jobId = i5;
        this.jobServiceComponentName = new ComponentName(context, PlatformSchedulerService.class);
        this.jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
    }

    private static JobInfo buildJobInfo(int i5, ComponentName componentName, Requirements requirements, String str, String str2) {
        int i6;
        JobInfo.Builder builder = new JobInfo.Builder(i5, componentName);
        int requiredNetworkType = requirements.getRequiredNetworkType();
        if (requiredNetworkType == 0) {
            i6 = 0;
        } else if (requiredNetworkType != 1) {
            i6 = 2;
            if (requiredNetworkType != 2) {
                i6 = 3;
                if (requiredNetworkType != 3) {
                    i6 = 4;
                    if (requiredNetworkType != 4) {
                        throw new UnsupportedOperationException();
                    } else if (Util.SDK_INT < 26) {
                        throw new UnsupportedOperationException();
                    }
                } else if (Util.SDK_INT < 24) {
                    throw new UnsupportedOperationException();
                }
            }
        } else {
            i6 = 1;
        }
        builder.setRequiredNetworkType(i6);
        builder.setRequiresDeviceIdle(requirements.isIdleRequired());
        builder.setRequiresCharging(requirements.isChargingRequired());
        builder.setPersisted(true);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(KEY_SERVICE_ACTION, str);
        persistableBundle.putString(KEY_SERVICE_PACKAGE, str2);
        persistableBundle.putInt(KEY_REQUIREMENTS, requirements.getRequirementsData());
        builder.setExtras(persistableBundle);
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static void logd(String str) {
    }

    public final boolean cancel() {
        logd("Canceling job: " + this.jobId);
        this.jobScheduler.cancel(this.jobId);
        return true;
    }

    public final boolean schedule(Requirements requirements, String str, String str2) {
        int schedule = this.jobScheduler.schedule(buildJobInfo(this.jobId, this.jobServiceComponentName, requirements, str2, str));
        logd("Scheduling job: " + this.jobId + " result: " + schedule);
        if (schedule == 1) {
            return true;
        }
        return false;
    }
}
