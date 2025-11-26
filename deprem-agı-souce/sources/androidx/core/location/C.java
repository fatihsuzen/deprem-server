package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class C implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f265a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f266b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GnssStatusCompat f267c;

    public /* synthetic */ C(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, GnssStatusCompat gnssStatusCompat) {
        this.f265a = gpsStatusTransport;
        this.f266b = executor;
        this.f267c = gnssStatusCompat;
    }

    public final void run() {
        LocationManagerCompat.GpsStatusTransport.d(this.f265a, this.f266b, this.f267c);
    }
}
