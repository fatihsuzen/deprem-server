package com.google.android.gms.measurement.internal;

final /* synthetic */ class G5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ H5 f5903a;

    /* synthetic */ G5(H5 h5) {
        this.f5903a = h5;
    }

    public final /* synthetic */ void run() {
        long j5;
        H5 h5 = this.f5903a;
        N5 n5 = h5.f5912c.f5922b;
        n5.h();
        X2 x22 = n5.f5730a;
        x22.a().v().a("Application going to the background");
        x22.x().f5850t.b(true);
        n5.o(true);
        if (!x22.w().N()) {
            long j6 = h5.f5911b;
            L5 l5 = n5.f5999f;
            l5.d(false, false, j6);
            l5.b(j6);
        }
        x22.a().u().b("Application backgrounded at: timestamp_millis", Long.valueOf(h5.f5910a));
        X2 x23 = n5.f5730a;
        C1452x4 B4 = x23.B();
        B4.h();
        X2 x24 = B4.f5730a;
        B4.j();
        C1446w5 J4 = x24.J();
        J4.h();
        J4.j();
        if (!J4.y() || J4.f5730a.C().W() >= 242600) {
            x24.J().t();
        }
        if (x22.w().H((String) null, C1304d2.f6289O0)) {
            if (x22.C().P(x22.e().getPackageName(), x22.w().R())) {
                j5 = 1000;
            } else {
                j5 = x22.w().D(x22.e().getPackageName(), C1304d2.f6268E);
            }
            x22.a().w().b("[sgtm] Scheduling batch upload with minimum latency in millis", Long.valueOf(j5));
            x23.N().o(j5);
        }
    }
}
