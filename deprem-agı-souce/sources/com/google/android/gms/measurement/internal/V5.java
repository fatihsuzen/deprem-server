package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.internal.measurement.C1156m0;
import com.google.android.gms.internal.measurement.C1165n0;

public final class V5 extends C1292b6 {

    /* renamed from: d  reason: collision with root package name */
    private final AlarmManager f6119d = ((AlarmManager) this.f5730a.e().getSystemService(NotificationCompat.CATEGORY_ALARM));

    /* renamed from: e  reason: collision with root package name */
    private C1447x f6120e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f6121f;

    protected V5(q6 q6Var) {
        super(q6Var);
    }

    private final C1447x o() {
        if (this.f6120e == null) {
            this.f6120e = new U5(this, this.f6129b.g0());
        }
        return this.f6120e;
    }

    private final void p() {
        JobScheduler jobScheduler = (JobScheduler) this.f5730a.e().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(q());
        }
    }

    private final int q() {
        if (this.f6121f == null) {
            this.f6121f = Integer.valueOf("measurement".concat(String.valueOf(this.f5730a.e().getPackageName())).hashCode());
        }
        return this.f6121f.intValue();
    }

    private final PendingIntent r() {
        Context e5 = this.f5730a.e();
        return PendingIntent.getBroadcast(e5, 0, new Intent().setClassName(e5, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), C1156m0.f5436a);
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        AlarmManager alarmManager = this.f6119d;
        if (alarmManager != null) {
            alarmManager.cancel(r());
        }
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        p();
        return false;
    }

    public final void m(long j5) {
        j();
        X2 x22 = this.f5730a;
        x22.c();
        Context e5 = x22.e();
        if (!z6.j0(e5)) {
            x22.a().v().a("Receiver not registered/enabled");
        }
        if (!z6.E(e5, false)) {
            x22.a().v().a("Service not registered/enabled");
        }
        n();
        x22.a().w().b("Scheduling upload, millis", Long.valueOf(j5));
        long elapsedRealtime = x22.f().elapsedRealtime() + j5;
        x22.w();
        if (j5 < Math.max(0, ((Long) C1304d2.f6284M.b((Object) null)).longValue()) && !o().c()) {
            o().b(j5);
        }
        x22.c();
        if (Build.VERSION.SDK_INT >= 24) {
            Context e6 = x22.e();
            ComponentName componentName = new ComponentName(e6, "com.google.android.gms.measurement.AppMeasurementJobService");
            int q5 = q();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            C1165n0.a(e6, new JobInfo.Builder(q5, componentName).setMinimumLatency(j5).setOverrideDeadline(j5 + j5).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
            return;
        }
        AlarmManager alarmManager = this.f6119d;
        if (alarmManager != null) {
            x22.w();
            alarmManager.setInexactRepeating(2, elapsedRealtime, Math.max(((Long) C1304d2.f6274H.b((Object) null)).longValue(), j5), r());
        }
    }

    public final void n() {
        j();
        this.f5730a.a().w().a("Unscheduling upload");
        AlarmManager alarmManager = this.f6119d;
        if (alarmManager != null) {
            alarmManager.cancel(r());
        }
        o().d();
        if (Build.VERSION.SDK_INT >= 24) {
            p();
        }
    }
}
