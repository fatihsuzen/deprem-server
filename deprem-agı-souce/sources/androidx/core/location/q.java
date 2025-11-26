package androidx.core.location;

import android.os.CancellationSignal;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class q implements CancellationSignal.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.CancellableLocationListener f294a;

    public /* synthetic */ q(LocationManagerCompat.CancellableLocationListener cancellableLocationListener) {
        this.f294a = cancellableLocationListener;
    }

    public final void onCancel() {
        this.f294a.cancel();
    }
}
