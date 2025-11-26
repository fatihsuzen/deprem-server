package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class D implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f268a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f269b;

    public /* synthetic */ D(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str) {
        this.f268a = locationListenerTransport;
        this.f269b = str;
    }

    public final void run() {
        LocationManagerCompat.LocationListenerTransport.a(this.f268a, this.f269b);
    }
}
