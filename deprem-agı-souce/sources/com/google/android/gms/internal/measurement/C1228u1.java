package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import j$.util.Objects;

/* renamed from: com.google.android.gms.internal.measurement.u1  reason: case insensitive filesystem */
final class C1228u1 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5594a;

    C1228u1(C1237v1 v1Var) {
        Objects.requireNonNull(v1Var);
        this.f5594a = v1Var;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.f5594a.f(new C1157m1(this, bundle, activity));
    }

    public final void onActivityDestroyed(Activity activity) {
        this.f5594a.f(new C1210s1(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        this.f5594a.f(new C1184p1(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        this.f5594a.f(new C1175o1(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        C1218t0 t0Var = new C1218t0();
        this.f5594a.f(new C1201r1(this, activity, t0Var));
        Bundle q02 = t0Var.q0(50);
        if (q02 != null) {
            bundle.putAll(q02);
        }
    }

    public final void onActivityStarted(Activity activity) {
        this.f5594a.f(new C1166n1(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        this.f5594a.f(new C1193q1(this, activity));
    }
}
