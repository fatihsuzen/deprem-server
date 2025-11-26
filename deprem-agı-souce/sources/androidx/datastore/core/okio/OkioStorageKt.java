package androidx.datastore.core.okio;

import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.InterProcessCoordinatorKt;
import com.mbridge.msdk.MBridgeConstans;
import e4.Q;
import kotlin.jvm.internal.t;

public final class OkioStorageKt {
    public static final InterProcessCoordinator createSingleProcessCoordinator(Q q5) {
        t.e(q5, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        return InterProcessCoordinatorKt.createSingleProcessCoordinator(q5.g().toString());
    }
}
