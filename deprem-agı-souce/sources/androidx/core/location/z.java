package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f307a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f308b;

    public /* synthetic */ z(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor) {
        this.f307a = gpsStatusTransport;
        this.f308b = executor;
    }

    public final void run() {
        LocationManagerCompat.GpsStatusTransport.b(this.f307a, this.f308b);
    }
}
