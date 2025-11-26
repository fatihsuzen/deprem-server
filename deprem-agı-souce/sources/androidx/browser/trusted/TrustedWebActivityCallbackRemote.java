package androidx.browser.trusted;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.trusted.a;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TrustedWebActivityCallbackRemote {
    private final a mCallbackBinder;

    private TrustedWebActivityCallbackRemote(@NonNull a aVar) {
        this.mCallbackBinder = aVar;
    }

    @Nullable
    static TrustedWebActivityCallbackRemote fromBinder(@Nullable IBinder iBinder) {
        a aVar;
        if (iBinder == null) {
            aVar = null;
        } else {
            aVar = a.C0006a.asInterface(iBinder);
        }
        if (aVar == null) {
            return null;
        }
        return new TrustedWebActivityCallbackRemote(aVar);
    }

    public void runExtraCallback(@NonNull String str, @NonNull Bundle bundle) throws RemoteException {
        this.mCallbackBinder.onExtraCallback(str, bundle);
    }
}
