package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

final /* synthetic */ class B5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ D5 f5758a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ JobParameters f5759b;

    /* synthetic */ B5(D5 d5, JobParameters jobParameters) {
        this.f5758a = d5;
        this.f5759b = jobParameters;
    }

    public final /* synthetic */ void run() {
        this.f5758a.h(this.f5759b);
    }
}
