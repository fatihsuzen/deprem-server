package A1;

import android.app.UiModeManager;
import android.content.Context;
import u1.g;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static UiModeManager f2282a;

    public static g a() {
        UiModeManager uiModeManager = f2282a;
        if (uiModeManager == null) {
            return g.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        if (currentModeType == 1) {
            return g.MOBILE;
        }
        if (currentModeType != 4) {
            return g.OTHER;
        }
        return g.CTV;
    }

    public static void b(Context context) {
        if (context != null) {
            f2282a = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
