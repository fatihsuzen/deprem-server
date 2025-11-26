package f0;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.Q;
import com.google.android.gms.internal.measurement.S;
import com.google.android.gms.measurement.internal.Z5;

/* renamed from: f0.j  reason: case insensitive filesystem */
public abstract class C1655j extends Q implements C1656k {
    public C1655j() {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean i(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 != 2) {
            return false;
        }
        S.f(parcel);
        b0((Z5) S.b(parcel, Z5.CREATOR));
        return true;
    }
}
