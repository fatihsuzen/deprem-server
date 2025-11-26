package N;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import b0.C1005d;

/* renamed from: N.j  reason: case insensitive filesystem */
public interface C0716j extends IInterface {

    /* renamed from: N.j$a */
    public static abstract class a extends C1005d implements C0716j {
        public static C0716j j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof C0716j) {
                return (C0716j) queryLocalInterface;
            }
            return new u0(iBinder);
        }
    }

    Account B();
}
