package androidx.leanback.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

final class ForegroundHelper {
    private ForegroundHelper() {
    }

    static Drawable getForeground(View view) {
        return view.getForeground();
    }

    static void setForeground(View view, Drawable drawable) {
        view.setForeground(drawable);
    }

    static boolean supportsForeground() {
        return true;
    }
}
