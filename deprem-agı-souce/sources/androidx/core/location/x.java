package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GnssMeasurementsTransport f301a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f302b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GnssMeasurementsEvent f303c;

    public /* synthetic */ x(LocationManagerCompat.GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, GnssMeasurementsEvent gnssMeasurementsEvent) {
        this.f301a = gnssMeasurementsTransport;
        this.f302b = executor;
        this.f303c = gnssMeasurementsEvent;
    }

    public final void run() {
        LocationManagerCompat.GnssMeasurementsTransport.a(this.f301a, this.f302b, this.f303c);
    }
}
