package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class L implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f288a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f289b;

    public /* synthetic */ L(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.f288a = preRGnssStatusTransport;
        this.f289b = executor;
    }

    public final void run() {
        LocationManagerCompat.PreRGnssStatusTransport.a(this.f288a, this.f289b);
    }
}
