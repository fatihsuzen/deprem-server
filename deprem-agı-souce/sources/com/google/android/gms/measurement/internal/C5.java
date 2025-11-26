package com.google.android.gms.measurement.internal;

import android.content.Intent;

final /* synthetic */ class C5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ D5 f5811a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f5812b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ C1402q2 f5813c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Intent f5814d;

    /* synthetic */ C5(D5 d5, int i5, C1402q2 q2Var, Intent intent) {
        this.f5811a = d5;
        this.f5812b = i5;
        this.f5813c = q2Var;
        this.f5814d = intent;
    }

    public final /* synthetic */ void run() {
        this.f5811a.f(this.f5812b, this.f5813c, this.f5814d);
    }
}
