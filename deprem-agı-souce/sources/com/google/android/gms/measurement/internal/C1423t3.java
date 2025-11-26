package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import f0.C1653h;

/* renamed from: com.google.android.gms.measurement.internal.t3  reason: case insensitive filesystem */
final /* synthetic */ class C1423t3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C1465z3 f6729a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ B6 f6730b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Bundle f6731c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ C1653h f6732d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f6733e;

    /* synthetic */ C1423t3(C1465z3 z3Var, B6 b6, Bundle bundle, C1653h hVar, String str) {
        this.f6729a = z3Var;
        this.f6730b = b6;
        this.f6731c = bundle;
        this.f6732d = hVar;
        this.f6733e = str;
    }

    public final /* synthetic */ void run() {
        this.f6729a.r0(this.f6730b, this.f6731c, this.f6732d, this.f6733e);
    }
}
