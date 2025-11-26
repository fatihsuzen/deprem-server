package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GnssMeasurementsTransport f304a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f305b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f306c;

    public /* synthetic */ y(LocationManagerCompat.GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, int i5) {
        this.f304a = gnssMeasurementsTransport;
        this.f305b = executor;
        this.f306c = i5;
    }

    public final void run() {
        LocationManagerCompat.GnssMeasurementsTransport.b(this.f304a, this.f305b, this.f306c);
    }
}
