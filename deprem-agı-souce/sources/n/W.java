package N;

import android.os.IBinder;
import android.os.IInterface;
import b0.C1005d;

public abstract class W extends C1005d implements X {
    public static X j(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        if (queryLocalInterface instanceof X) {
            return (X) queryLocalInterface;
        }
        return new V(iBinder);
    }
}
