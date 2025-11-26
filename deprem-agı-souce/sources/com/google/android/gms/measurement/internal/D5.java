package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.internal.measurement.C1237v1;
import com.google.android.gms.internal.measurement.J0;
import f0.C1645M;
import j$.util.Objects;

public final class D5 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5828a;

    public D5(Context context) {
        C0722p.k(context);
        this.f5828a = context;
    }

    public static final void i(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onRebind called with null intent");
        } else {
            Log.v("FA", "onRebind called. action: ".concat(String.valueOf(intent.getAction())));
        }
    }

    public static final boolean j(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onUnbind called with null intent");
            return true;
        }
        Log.v("FA", "onUnbind called for intent. action: ".concat(String.valueOf(intent.getAction())));
        return true;
    }

    private final void k(q6 q6Var, Runnable runnable) {
        q6Var.b().t(new C1467z5(this, q6Var, runnable));
    }

    public final void a() {
        Log.v("FA", this.f5828a.getClass().getSimpleName().concat(" is starting up."));
    }

    public final void b() {
        Log.v("FA", this.f5828a.getClass().getSimpleName().concat(" is shutting down."));
    }

    public final int c(Intent intent, int i5, int i6) {
        if (intent == null) {
            Log.w("FA", "AppMeasurementService started with null intent");
            return 2;
        }
        Context context = this.f5828a;
        X2 O4 = X2.O(context, (J0) null, (Long) null);
        C1402q2 a5 = O4.a();
        String action = intent.getAction();
        O4.c();
        a5.w().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i6), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            k(q6.F(context), new C5(this, i6, a5, intent));
        }
        return 2;
    }

    public final IBinder d(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new C1465z3(q6.F(this.f5828a), (String) null);
        }
        Log.w("FA", "onBind received unknown action: ".concat(String.valueOf(action)));
        return null;
    }

    public final boolean e(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("action");
        Log.v("FA", "onStartJob received action: ".concat(String.valueOf(string)));
        if (Objects.equals(string, "com.google.android.gms.measurement.UPLOAD")) {
            q6 F4 = q6.F(this.f5828a);
            C1402q2 a5 = F4.a();
            F4.c();
            a5.w().b("Local AppMeasurementJobService called. action", (String) C0722p.k(string));
            k(F4, new A5(this, a5, jobParameters));
        }
        if (!Objects.equals(string, "com.google.android.gms.measurement.SCION_UPLOAD")) {
            return true;
        }
        String str = (String) C0722p.k(string);
        C1237v1.o(this.f5828a, (Bundle) null).C(new B5(this, jobParameters));
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void f(int i5, C1402q2 q2Var, Intent intent) {
        Context context = this.f5828a;
        C1645M m5 = (C1645M) context;
        if (m5.a(i5)) {
            q2Var.w().b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i5));
            X2.O(context, (J0) null, (Long) null).a().w().a("Completed wakeful intent.");
            m5.b(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void g(C1402q2 q2Var, JobParameters jobParameters) {
        q2Var.w().a("AppMeasurementJobService processed last upload request.");
        ((C1645M) this.f5828a).c(jobParameters, false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void h(JobParameters jobParameters) {
        Log.v("FA", "[sgtm] AppMeasurementJobService processed last Scion upload request.");
        ((C1645M) this.f5828a).c(jobParameters, false);
    }
}
