package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.t;

@RequiresApi(29)
final class EdgeToEdgeApi29 implements EdgeToEdgeImpl {
    @DoNotInline
    public void setUp(SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, Window window, View view, boolean z4, boolean z5) {
        t.e(systemBarStyle, "statusBarStyle");
        t.e(systemBarStyle2, "navigationBarStyle");
        t.e(window, "window");
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        boolean z6 = false;
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(systemBarStyle.getScrimWithEnforcedContrast$activity_release(z4));
        window.setNavigationBarColor(systemBarStyle2.getScrimWithEnforcedContrast$activity_release(z5));
        window.setStatusBarContrastEnforced(false);
        if (systemBarStyle2.getNightMode$activity_release() == 0) {
            z6 = true;
        }
        window.setNavigationBarContrastEnforced(z6);
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, view);
        windowInsetsControllerCompat.setAppearanceLightStatusBars(!z4);
        windowInsetsControllerCompat.setAppearanceLightNavigationBars(true ^ z5);
    }
}
