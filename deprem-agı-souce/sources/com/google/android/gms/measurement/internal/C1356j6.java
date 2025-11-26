package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.G0;
import f0.C1633A;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.j6  reason: case insensitive filesystem */
final class C1356j6 implements C1633A {

    /* renamed from: a  reason: collision with root package name */
    public final G0 f6510a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f6511b;

    C1356j6(AppMeasurementDynamiteService appMeasurementDynamiteService, G0 g02) {
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f6511b = appMeasurementDynamiteService;
        this.f6510a = g02;
    }

    public final void a(String str, String str2, Bundle bundle, long j5) {
        try {
            this.f6510a.n(str, str2, bundle, j5);
        } catch (RemoteException e5) {
            RemoteException remoteException = e5;
            X2 x22 = this.f6511b.f5742a;
            if (x22 != null) {
                x22.a().r().b("Event interceptor threw exception", remoteException);
            }
        }
    }
}
