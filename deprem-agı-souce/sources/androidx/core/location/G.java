package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class G implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f274a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Location f275b;

    public /* synthetic */ G(LocationManagerCompat.LocationListenerTransport locationListenerTransport, Location location) {
        this.f274a = locationListenerTransport;
        this.f275b = location;
    }

    public final void run() {
        LocationManagerCompat.LocationListenerTransport.c(this.f274a, this.f275b);
    }
}
