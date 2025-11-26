package Y;

import E.g;
import L.f;
import N.C0710d;
import N.C0713g;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public final class f extends C0713g {

    /* renamed from: I  reason: collision with root package name */
    private final g f4485I;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Context context, Looper looper, C0710d dVar, g gVar, f.a aVar, f.b bVar) {
        super(context, looper, 68, dVar, aVar, bVar);
        E.f fVar = new E.f(gVar == null ? g.f2386d : gVar);
        fVar.a(b.a());
        this.f4485I = new g(fVar);
    }

    /* access modifiers changed from: protected */
    public final Bundle A() {
        return this.f4485I.a();
    }

    /* access modifiers changed from: protected */
    public final String E() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    /* access modifiers changed from: protected */
    public final String F() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    public final int k() {
        return 12800000;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        if (queryLocalInterface instanceof g) {
            return (g) queryLocalInterface;
        }
        return new g(iBinder);
    }
}
