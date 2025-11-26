package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

final /* synthetic */ class A5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ D5 f5737a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ C1402q2 f5738b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ JobParameters f5739c;

    /* synthetic */ A5(D5 d5, C1402q2 q2Var, JobParameters jobParameters) {
        this.f5737a = d5;
        this.f5738b = q2Var;
        this.f5739c = jobParameters;
    }

    public final /* synthetic */ void run() {
        this.f5737a.g(this.f5738b, this.f5739c);
    }
}
