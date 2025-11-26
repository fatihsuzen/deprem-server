package f0;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.P;
import com.google.android.gms.internal.measurement.S;
import com.google.android.gms.measurement.internal.Z5;

/* renamed from: f0.i  reason: case insensitive filesystem */
public final class C1654i extends P implements C1656k {
    C1654i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    public final void b0(Z5 z5) {
        Parcel j5 = j();
        S.c(j5, z5);
        q0(2, j5);
    }
}
