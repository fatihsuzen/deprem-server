package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.os.PersistableBundle;
import com.google.android.gms.internal.measurement.C1141k3;

public final class D4 extends C1320f2 {

    /* renamed from: c  reason: collision with root package name */
    private JobScheduler f5827c;

    public D4(X2 x22) {
        super(x22);
    }

    /* access modifiers changed from: protected */
    public final boolean m() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void n() {
        this.f5827c = (JobScheduler) this.f5730a.e().getSystemService("jobscheduler");
    }

    public final void o(long j5) {
        String str;
        j();
        h();
        JobScheduler jobScheduler = this.f5827c;
        if (jobScheduler == null || jobScheduler.getPendingJob(p()) == null) {
            C1141k3 q5 = q();
            if (q5 == C1141k3.CLIENT_UPLOAD_ELIGIBLE) {
                X2 x22 = this.f5730a;
                x22.a().w().b("[sgtm] Scheduling Scion upload, millis", Long.valueOf(j5));
                PersistableBundle persistableBundle = new PersistableBundle();
                persistableBundle.putString("action", "com.google.android.gms.measurement.SCION_UPLOAD");
                int schedule = ((JobScheduler) C0722p.k(this.f5827c)).schedule(new JobInfo.Builder(p(), new ComponentName(x22.e(), "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(j5).setOverrideDeadline(j5 + j5).setExtras(persistableBundle).build());
                C1388o2 w4 = x22.a().w();
                if (schedule == 1) {
                    str = "SUCCESS";
                } else {
                    str = "FAILURE";
                }
                w4.b("[sgtm] Scion upload job scheduled with result", str);
                return;
            }
            this.f5730a.a().w().b("[sgtm] Not eligible for Scion upload", q5.name());
            return;
        }
        this.f5730a.a().w().a("[sgtm] There's an existing pending job, skip this schedule.");
    }

    /* access modifiers changed from: package-private */
    public final int p() {
        return "measurement-client".concat(String.valueOf(this.f5730a.e().getPackageName())).hashCode();
    }

    /* access modifiers changed from: package-private */
    public final C1141k3 q() {
        j();
        h();
        if (this.f5827c == null) {
            return C1141k3.MISSING_JOB_SCHEDULER;
        }
        X2 x22 = this.f5730a;
        if (!x22.w().P()) {
            return C1141k3.NOT_ENABLED_IN_MANIFEST;
        }
        X2 x23 = this.f5730a;
        if (x23.L().u() < 119000) {
            return C1141k3.SDK_TOO_OLD;
        }
        if (!z6.F(x22.e(), "com.google.android.gms.measurement.AppMeasurementJobService")) {
            return C1141k3.MEASUREMENT_SERVICE_NOT_ENABLED;
        }
        if (Build.VERSION.SDK_INT < 24) {
            return C1141k3.ANDROID_TOO_OLD;
        }
        if (!x23.J().y()) {
            return C1141k3.NON_PLAY_MODE;
        }
        return C1141k3.CLIENT_UPLOAD_ELIGIBLE;
    }
}
