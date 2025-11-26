package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import k3.C2616a;
import k3.l;

public final /* synthetic */ class f implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f549a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ConnectivityManager f550b;

    public /* synthetic */ f(l lVar, ConnectivityManager connectivityManager) {
        this.f549a = lVar;
        this.f550b = connectivityManager;
    }

    public final Object invoke() {
        return SharedNetworkCallback.addCallback$lambda$6(this.f549a, this.f550b);
    }
}
