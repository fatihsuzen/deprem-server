package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.List;

public final /* synthetic */ class F implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f272a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f273b;

    public /* synthetic */ F(LocationManagerCompat.LocationListenerTransport locationListenerTransport, List list) {
        this.f272a = locationListenerTransport;
        this.f273b = list;
    }

    public final void run() {
        LocationManagerCompat.LocationListenerTransport.d(this.f272a, this.f273b);
    }
}
