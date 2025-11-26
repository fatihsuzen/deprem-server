package f0;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.Q;
import com.google.android.gms.internal.measurement.S;
import com.google.android.gms.measurement.internal.S5;
import java.util.ArrayList;

/* renamed from: f0.g  reason: case insensitive filesystem */
public abstract class C1652g extends Q implements C1653h {
    public C1652g() {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean i(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 != 2) {
            return false;
        }
        ArrayList<S5> createTypedArrayList = parcel.createTypedArrayList(S5.CREATOR);
        S.f(parcel);
        g0(createTypedArrayList);
        return true;
    }
}
