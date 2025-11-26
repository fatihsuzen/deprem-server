package androidx.browser.customtabs;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.c;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EngagementSignalsCallbackRemote implements EngagementSignalsCallback {
    private static final String TAG = "EngagementSigsCallbkRmt";
    private final c mCallbackBinder;

    private EngagementSignalsCallbackRemote(@NonNull c cVar) {
        this.mCallbackBinder = cVar;
    }

    @NonNull
    static EngagementSignalsCallbackRemote fromBinder(@NonNull IBinder iBinder) {
        return new EngagementSignalsCallbackRemote(c.a.asInterface(iBinder));
    }

    public void onGreatestScrollPercentageIncreased(@IntRange(from = 1, to = 100) int i5, @NonNull Bundle bundle) {
        try {
            this.mCallbackBinder.onGreatestScrollPercentageIncreased(i5, bundle);
        } catch (RemoteException unused) {
            Log.e(TAG, "RemoteException during IEngagementSignalsCallback transaction");
        }
    }

    public void onSessionEnded(boolean z4, @NonNull Bundle bundle) {
        try {
            this.mCallbackBinder.onSessionEnded(z4, bundle);
        } catch (RemoteException unused) {
            Log.e(TAG, "RemoteException during IEngagementSignalsCallback transaction");
        }
    }

    public void onVerticalScrollEvent(boolean z4, @NonNull Bundle bundle) {
        try {
            this.mCallbackBinder.onVerticalScrollEvent(z4, bundle);
        } catch (RemoteException unused) {
            Log.e(TAG, "RemoteException during IEngagementSignalsCallback transaction");
        }
    }
}
