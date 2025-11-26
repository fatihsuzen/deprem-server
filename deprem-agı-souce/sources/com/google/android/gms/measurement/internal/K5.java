package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.C0;

final /* synthetic */ class K5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f5955a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ C0 f5956b;

    /* synthetic */ K5(AppMeasurementDynamiteService appMeasurementDynamiteService, C0 c02) {
        this.f5955a = appMeasurementDynamiteService;
        this.f5956b = c02;
    }

    public final /* synthetic */ void run() {
        try {
            this.f5956b.d();
        } catch (RemoteException e5) {
            ((X2) C0722p.k(this.f5955a.f5742a)).a().r().b("Failed to call IDynamiteUploadBatchesCallback", e5);
        }
    }
}
