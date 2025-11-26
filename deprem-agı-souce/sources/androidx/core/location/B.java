package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class B implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f262a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f263b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f264c;

    public /* synthetic */ B(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, int i5) {
        this.f262a = gpsStatusTransport;
        this.f263b = executor;
        this.f264c = i5;
    }

    public final void run() {
        LocationManagerCompat.GpsStatusTransport.c(this.f262a, this.f263b, this.f264c);
    }
}
