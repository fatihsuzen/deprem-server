package k4;

import android.app.UiModeManager;
import android.content.Context;
import kotlin.jvm.internal.t;

public abstract class r {
    public static String a(Context context) {
        t.e(context, "context");
        Object systemService = context.getSystemService("uimode");
        if (systemService != null) {
            UiModeManager uiModeManager = (UiModeManager) systemService;
            if (uiModeManager.getCurrentModeType() == 4) {
                return "TV";
            }
            if (uiModeManager.getCurrentModeType() == 3) {
                return "automotive";
            }
            if (context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
                return "wearable";
            }
            if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
                return "tablet";
            }
            return "mobile";
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.UiModeManager");
    }
}
