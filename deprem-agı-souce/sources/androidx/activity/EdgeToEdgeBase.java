package androidx.activity;

import android.view.View;
import android.view.Window;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.t;

final class EdgeToEdgeBase implements EdgeToEdgeImpl {
    public void setUp(SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, Window window, View view, boolean z4, boolean z5) {
        t.e(systemBarStyle, "statusBarStyle");
        t.e(systemBarStyle2, "navigationBarStyle");
        t.e(window, "window");
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
    }
}
