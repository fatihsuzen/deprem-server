package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import androidx.work.impl.constraints.IndividualNetworkCallback;
import k3.C2616a;
import kotlin.jvm.internal.I;

public final /* synthetic */ class a implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I f541a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ConnectivityManager f542b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IndividualNetworkCallback f543c;

    public /* synthetic */ a(I i5, ConnectivityManager connectivityManager, IndividualNetworkCallback individualNetworkCallback) {
        this.f541a = i5;
        this.f542b = connectivityManager;
        this.f543c = individualNetworkCallback;
    }

    public final Object invoke() {
        return IndividualNetworkCallback.Companion.addCallback$lambda$0(this.f541a, this.f542b, this.f543c);
    }
}
