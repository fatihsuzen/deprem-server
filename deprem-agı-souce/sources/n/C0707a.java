package N;

import N.C0716j;
import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

/* renamed from: N.a  reason: case insensitive filesystem */
public abstract class C0707a extends C0716j.a {
    public static Account k(C0716j jVar) {
        if (jVar == null) {
            return null;
        }
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            return jVar.B();
        } catch (RemoteException unused) {
            Log.w("AccountAccessor", "Remote account accessor probably died");
            return null;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
