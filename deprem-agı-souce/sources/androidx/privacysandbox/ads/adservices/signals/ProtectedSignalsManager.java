package androidx.privacysandbox.ads.adservices.signals;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import b3.C2308e;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class ProtectedSignalsManager {
    public static final Companion Companion = new Companion((C2633k) null);
    private static final String TAG = "ProtectedSignalsManager";

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        @ExperimentalFeatures.Ext12OptIn
        @SuppressLint({"NewApi"})
        public final ProtectedSignalsManager obtain(Context context) {
            t.e(context, "context");
            if (AdServicesInfo.INSTANCE.adServicesVersion() >= 12) {
                Log.d(ProtectedSignalsManager.TAG, "Adservices version 12 detected, obtaining ProtectedSignalsManagerImpl.");
                android.adservices.signals.ProtectedSignalsManager a5 = android.adservices.signals.ProtectedSignalsManager.get(context);
                t.d(a5, "get(context)");
                return new ProtectedSignalsManagerImpl(a5);
            }
            Log.d(ProtectedSignalsManager.TAG, "Adservices less than 12, returning null for ProtectedSignalsManager.obtain.");
            return null;
        }

        private Companion() {
        }
    }

    @ExperimentalFeatures.Ext12OptIn
    @SuppressLint({"NewApi"})
    public static final ProtectedSignalsManager obtain(Context context) {
        return Companion.obtain(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    @ExperimentalFeatures.Ext12OptIn
    public abstract Object updateSignals(UpdateSignalsRequest updateSignalsRequest, C2308e eVar);
}
