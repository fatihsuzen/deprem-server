package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.D5;
import f0.C1645M;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements C1645M {

    /* renamed from: a  reason: collision with root package name */
    private D5 f5716a;

    private final D5 d() {
        if (this.f5716a == null) {
            this.f5716a = new D5(this);
        }
        return this.f5716a;
    }

    public final boolean a(int i5) {
        throw new UnsupportedOperationException();
    }

    public final void b(Intent intent) {
    }

    public final void c(JobParameters jobParameters, boolean z4) {
        jobFinished(jobParameters, false);
    }

    public void onCreate() {
        super.onCreate();
        d().a();
    }

    public void onDestroy() {
        d().b();
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        d();
        D5.i(intent);
    }

    public boolean onStartJob(JobParameters jobParameters) {
        d().e(jobParameters);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public boolean onUnbind(Intent intent) {
        d();
        D5.j(intent);
        return true;
    }
}
