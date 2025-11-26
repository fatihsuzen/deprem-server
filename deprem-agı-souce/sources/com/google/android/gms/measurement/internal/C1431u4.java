package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.u4  reason: case insensitive filesystem */
final /* synthetic */ class C1431u4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C1452x4 f6774a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f6775b;

    /* synthetic */ C1431u4(C1452x4 x4Var, String str) {
        this.f6774a = x4Var;
        this.f6775b = str;
    }

    public final /* synthetic */ void run() {
        X2 x22 = this.f6774a.f5730a;
        if (x22.L().x(this.f6775b)) {
            x22.L().p();
        }
    }
}
