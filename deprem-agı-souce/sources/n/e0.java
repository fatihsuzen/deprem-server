package N;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class e0 extends T {

    /* renamed from: a  reason: collision with root package name */
    private C0709c f3068a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3069b;

    public e0(C0709c cVar, int i5) {
        this.f3068a = cVar;
        this.f3069b = i5;
    }

    public final void L(int i5, IBinder iBinder, Bundle bundle) {
        C0722p.l(this.f3068a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f3068a.N(i5, iBinder, bundle, this.f3069b);
        this.f3068a = null;
    }

    public final void l(int i5, IBinder iBinder, i0 i0Var) {
        C0709c cVar = this.f3068a;
        C0722p.l(cVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        C0722p.k(i0Var);
        C0709c.c0(cVar, i0Var);
        L(i5, iBinder, i0Var.f3102a);
    }

    public final void z(int i5, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
}
