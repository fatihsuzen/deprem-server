package com.google.android.gms.measurement.internal;

import K.C0665l;
import N.C0709c;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import f0.C1650e;

/* renamed from: com.google.android.gms.measurement.internal.k2  reason: case insensitive filesystem */
public final class C1360k2 extends C0709c {
    public C1360k2(Context context, Looper looper, C0709c.a aVar, C0709c.b bVar) {
        super(context, looper, 93, aVar, bVar, (String) null);
    }

    /* access modifiers changed from: protected */
    public final String E() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    /* access modifiers changed from: protected */
    public final String F() {
        return "com.google.android.gms.measurement.START";
    }

    public final int k() {
        return C0665l.f2721a;
    }

    public final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        if (queryLocalInterface instanceof C1650e) {
            return (C1650e) queryLocalInterface;
        }
        return new C1312e2(iBinder);
    }
}
