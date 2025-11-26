package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.D5;
import f0.C1645M;

public final class AppMeasurementService extends Service implements C1645M {

    /* renamed from: a  reason: collision with root package name */
    private D5 f5718a;

    private final D5 d() {
        if (this.f5718a == null) {
            this.f5718a = new D5(this);
        }
        return this.f5718a;
    }

    public final boolean a(int i5) {
        return stopSelfResult(i5);
    }

    public final void b(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    public final void c(JobParameters jobParameters, boolean z4) {
        throw new UnsupportedOperationException();
    }

    public IBinder onBind(Intent intent) {
        return d().d(intent);
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

    public int onStartCommand(Intent intent, int i5, int i6) {
        d().c(intent, i5, i6);
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        d();
        D5.j(intent);
        return true;
    }
}
