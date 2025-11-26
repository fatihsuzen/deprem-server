package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.view.WindowCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.t;

@RequiresApi(21)
final class EdgeToEdgeApi21 implements EdgeToEdgeImpl {
    @DoNotInline
    public void setUp(SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, Window window, View view, boolean z4, boolean z5) {
        t.e(systemBarStyle, "statusBarStyle");
        t.e(systemBarStyle2, "navigationBarStyle");
        t.e(window, "window");
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        window.addFlags(134217728);
    }
}
