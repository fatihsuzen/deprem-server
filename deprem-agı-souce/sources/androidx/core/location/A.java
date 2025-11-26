package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class A implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f260a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f261b;

    public /* synthetic */ A(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor) {
        this.f260a = gpsStatusTransport;
        this.f261b = executor;
    }

    public final void run() {
        LocationManagerCompat.GpsStatusTransport.a(this.f260a, this.f261b);
    }
}
