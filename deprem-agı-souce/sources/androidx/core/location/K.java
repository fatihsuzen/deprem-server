package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class K implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f285a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f286b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GnssStatus f287c;

    public /* synthetic */ K(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, GnssStatus gnssStatus) {
        this.f285a = preRGnssStatusTransport;
        this.f286b = executor;
        this.f287c = gnssStatus;
    }

    public final void run() {
        LocationManagerCompat.PreRGnssStatusTransport.d(this.f285a, this.f286b, this.f287c);
    }
}
