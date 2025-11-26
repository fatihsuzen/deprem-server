package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class J implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f282a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f283b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f284c;

    public /* synthetic */ J(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i5) {
        this.f282a = preRGnssStatusTransport;
        this.f283b = executor;
        this.f284c = i5;
    }

    public final void run() {
        LocationManagerCompat.PreRGnssStatusTransport.b(this.f282a, this.f283b, this.f284c);
    }
}
