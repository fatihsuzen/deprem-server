package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class M implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f290a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f291b;

    public /* synthetic */ M(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.f290a = preRGnssStatusTransport;
        this.f291b = executor;
    }

    public final void run() {
        LocationManagerCompat.PreRGnssStatusTransport.c(this.f290a, this.f291b);
    }
}
