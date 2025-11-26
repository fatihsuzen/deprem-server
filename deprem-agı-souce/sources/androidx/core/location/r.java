package androidx.core.location;

import android.location.LocationManager;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Callable;

public final /* synthetic */ class r implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManager f295a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f296b;

    public /* synthetic */ r(LocationManager locationManager, LocationManagerCompat.GpsStatusTransport gpsStatusTransport) {
        this.f295a = locationManager;
        this.f296b = gpsStatusTransport;
    }

    public final Object call() {
        return Boolean.valueOf(this.f295a.addGpsStatusListener(this.f296b));
    }
}
