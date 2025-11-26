package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class E implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f270a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f271b;

    public /* synthetic */ E(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str) {
        this.f270a = locationListenerTransport;
        this.f271b = str;
    }

    public final void run() {
        LocationManagerCompat.LocationListenerTransport.e(this.f270a, this.f271b);
    }
}
