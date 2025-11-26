package com.google.android.gms.common.api.internal;

import L.C0668a;
import L.f;
import L.j;
import N.C0722p;
import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class a extends BasePendingResult {

    /* renamed from: n  reason: collision with root package name */
    private final C0668a.c f4873n;

    /* renamed from: o  reason: collision with root package name */
    private final C0668a f4874o;

    protected a(C0668a aVar, f fVar) {
        super((f) C0722p.l(fVar, "GoogleApiClient must not be null"));
        C0722p.l(aVar, "Api must not be null");
        this.f4873n = aVar.b();
        this.f4874o = aVar;
    }

    private void n(RemoteException remoteException) {
        o(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
    }

    /* access modifiers changed from: protected */
    public abstract void k(C0668a.b bVar);

    public final void m(C0668a.b bVar) {
        try {
            k(bVar);
        } catch (DeadObjectException e5) {
            n(e5);
            throw e5;
        } catch (RemoteException e6) {
            n(e6);
        }
    }

    public final void o(Status status) {
        C0722p.b(!status.i(), "Failed result must not be success");
        j c5 = c(status);
        f(c5);
        l(c5);
    }

    /* access modifiers changed from: protected */
    public void l(j jVar) {
    }
}
