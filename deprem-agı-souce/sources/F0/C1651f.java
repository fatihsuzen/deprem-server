package f0;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.P;
import java.util.List;

/* renamed from: f0.f  reason: case insensitive filesystem */
public final class C1651f extends P implements C1653h {
    C1651f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    public final void g0(List list) {
        Parcel j5 = j();
        j5.writeTypedList(list);
        q0(2, j5);
    }
}
