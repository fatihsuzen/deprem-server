package N;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import b0.C1002a;
import b0.C1006e;

public final class u0 extends C1002a implements C0716j {
    u0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    public final Account B() {
        Parcel i5 = i(2, j());
        Account account = (Account) C1006e.a(i5, Account.CREATOR);
        i5.recycle();
        return account;
    }
}
