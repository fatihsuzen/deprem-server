package T1;

import android.net.nsd.NsdServiceInfo;

public final /* synthetic */ class I0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ S0 f19065a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NsdServiceInfo f19066b;

    public /* synthetic */ I0(S0 s02, NsdServiceInfo nsdServiceInfo) {
        this.f19065a = s02;
        this.f19066b = nsdServiceInfo;
    }

    public final void run() {
        S0.g1(this.f19065a, this.f19066b);
    }
}
