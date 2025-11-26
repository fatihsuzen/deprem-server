package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.G0;
import f0.C1634B;
import j$.util.Objects;

final class A6 implements C1634B {

    /* renamed from: a  reason: collision with root package name */
    public final G0 f5740a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f5741b;

    A6(AppMeasurementDynamiteService appMeasurementDynamiteService, G0 g02) {
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f5741b = appMeasurementDynamiteService;
        this.f5740a = g02;
    }

    public final void a(String str, String str2, Bundle bundle, long j5) {
        try {
            this.f5740a.n(str, str2, bundle, j5);
        } catch (RemoteException e5) {
            RemoteException remoteException = e5;
            X2 x22 = this.f5741b.f5742a;
            if (x22 != null) {
                x22.a().r().b("Event listener threw exception", remoteException);
            }
        }
    }
}
