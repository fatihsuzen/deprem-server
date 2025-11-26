package androidx.privacysandbox.ads.adservices.measurement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.InputEvent;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import androidx.privacysandbox.ads.adservices.internal.BackCompatManager;
import b3.C2308e;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class MeasurementManager {
    public static final Companion Companion = new Companion((C2633k) null);
    public static final int MEASUREMENT_API_STATE_DISABLED = 0;
    public static final int MEASUREMENT_API_STATE_ENABLED = 1;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public final MeasurementManager obtain(Context context) {
            t.e(context, "context");
            StringBuilder sb = new StringBuilder();
            sb.append("AdServicesInfo.version=");
            AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
            sb.append(adServicesInfo.adServicesVersion());
            Log.d("MeasurementManager", sb.toString());
            if (adServicesInfo.adServicesVersion() >= 5) {
                return new MeasurementManagerApi33Ext5Impl(context);
            }
            if (adServicesInfo.extServicesVersionS() >= 9) {
                return (MeasurementManager) BackCompatManager.INSTANCE.getManager(context, "MeasurementManager", new MeasurementManager$Companion$obtain$1(context));
            }
            return null;
        }

        private Companion() {
        }
    }

    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    public static final MeasurementManager obtain(Context context) {
        return Companion.obtain(context);
    }

    public abstract Object deleteRegistrations(DeletionRequest deletionRequest, C2308e eVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object getMeasurementApiStatus(C2308e eVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object registerSource(Uri uri, InputEvent inputEvent, C2308e eVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @ExperimentalFeatures.RegisterSourceOptIn
    public abstract Object registerSource(SourceRegistrationRequest sourceRegistrationRequest, C2308e eVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object registerTrigger(Uri uri, C2308e eVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object registerWebSource(WebSourceRegistrationRequest webSourceRegistrationRequest, C2308e eVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object registerWebTrigger(WebTriggerRegistrationRequest webTriggerRegistrationRequest, C2308e eVar);
}
