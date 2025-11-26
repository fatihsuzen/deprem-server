package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class H implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f276a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f277b;

    public /* synthetic */ H(LocationManagerCompat.LocationListenerTransport locationListenerTransport, int i5) {
        this.f276a = locationListenerTransport;
        this.f277b = i5;
    }

    public final void run() {
        LocationManagerCompat.LocationListenerTransport.f(this.f276a, this.f277b);
    }
}
