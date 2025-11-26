package androidx.privacysandbox.ads.adservices.topics;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import androidx.privacysandbox.ads.adservices.internal.BackCompatManager;
import b3.C2308e;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class TopicsManager {
    public static final Companion Companion = new Companion((C2633k) null);

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public final TopicsManager obtain(Context context) {
            t.e(context, "context");
            AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
            if (adServicesInfo.adServicesVersion() >= 11) {
                return new TopicsManagerApi33Ext11Impl(context);
            }
            if (adServicesInfo.adServicesVersion() >= 5) {
                return new TopicsManagerApi33Ext5Impl(context);
            }
            if (adServicesInfo.adServicesVersion() == 4) {
                return new TopicsManagerApi33Ext4Impl(context);
            }
            if (adServicesInfo.extServicesVersionS() >= 11) {
                return (TopicsManager) BackCompatManager.INSTANCE.getManager(context, "TopicsManager", new TopicsManager$Companion$obtain$1(context));
            }
            if (adServicesInfo.extServicesVersionS() >= 9) {
                return (TopicsManager) BackCompatManager.INSTANCE.getManager(context, "TopicsManager", new TopicsManager$Companion$obtain$2(context));
            }
            return null;
        }

        private Companion() {
        }
    }

    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    public static final TopicsManager obtain(Context context) {
        return Companion.obtain(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    public abstract Object getTopics(GetTopicsRequest getTopicsRequest, C2308e eVar);
}
