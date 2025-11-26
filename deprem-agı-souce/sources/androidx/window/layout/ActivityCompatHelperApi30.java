package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;

@RequiresApi(30)
public final class ActivityCompatHelperApi30 {
    public static final ActivityCompatHelperApi30 INSTANCE = new ActivityCompatHelperApi30();

    private ActivityCompatHelperApi30() {
    }

    public final Rect currentWindowBounds(Activity activity) {
        t.e(activity, "activity");
        Rect a5 = activity.getWindowManager().getCurrentWindowMetrics().getBounds();
        t.d(a5, "activity.windowManager.currentWindowMetrics.bounds");
        return a5;
    }

    public final Rect maximumWindowBounds(Activity activity) {
        t.e(activity, "activity");
        Rect a5 = activity.getWindowManager().getMaximumWindowMetrics().getBounds();
        t.d(a5, "activity.windowManager.maximumWindowMetrics.bounds");
        return a5;
    }
}
