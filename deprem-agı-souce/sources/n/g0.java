package N;

import K.C0655b;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;

public final class g0 extends Q {

    /* renamed from: g  reason: collision with root package name */
    public final IBinder f3091g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ C0709c f3092h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g0(C0709c cVar, int i5, IBinder iBinder, Bundle bundle) {
        super(cVar, i5, bundle);
        this.f3092h = cVar;
        this.f3091g = iBinder;
    }

    /* access modifiers changed from: protected */
    public final void f(C0655b bVar) {
        if (this.f3092h.f3037v != null) {
            this.f3092h.f3037v.j(bVar);
        }
        this.f3092h.L(bVar);
    }

    /* access modifiers changed from: protected */
    public final boolean g() {
        try {
            IBinder iBinder = this.f3091g;
            C0722p.k(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f3092h.E().equals(interfaceDescriptor)) {
                String E4 = this.f3092h.E();
                Log.w("GmsClient", "service descriptor mismatch: " + E4 + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface s5 = this.f3092h.s(this.f3091g);
            if (s5 == null || (!C0709c.g0(this.f3092h, 2, 4, s5) && !C0709c.g0(this.f3092h, 3, 4, s5))) {
                return false;
            }
            this.f3092h.f3041z = null;
            C0709c cVar = this.f3092h;
            Bundle x4 = cVar.x();
            if (cVar.f3036u == null) {
                return true;
            }
            this.f3092h.f3036u.k(x4);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
