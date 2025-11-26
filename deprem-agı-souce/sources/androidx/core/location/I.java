package androidx.core.location;

import android.os.Bundle;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class I implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f278a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f279b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f280c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Bundle f281d;

    public /* synthetic */ I(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str, int i5, Bundle bundle) {
        this.f278a = locationListenerTransport;
        this.f279b = str;
        this.f280c = i5;
        this.f281d = bundle;
    }

    public final void run() {
        LocationManagerCompat.LocationListenerTransport.b(this.f278a, this.f279b, this.f280c, this.f281d);
    }
}
