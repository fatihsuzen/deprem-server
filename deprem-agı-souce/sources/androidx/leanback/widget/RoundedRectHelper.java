package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.R;

final class RoundedRectHelper {
    private RoundedRectHelper() {
    }

    static void setClipToRoundedOutline(View view, boolean z4, int i5) {
        RoundedRectHelperApi21.setClipToRoundedOutline(view, z4, i5);
    }

    static boolean supportsRoundedCorner() {
        return true;
    }

    static void setClipToRoundedOutline(View view, boolean z4) {
        RoundedRectHelperApi21.setClipToRoundedOutline(view, z4, view.getResources().getDimensionPixelSize(R.dimen.lb_rounded_rect_corner_radius));
    }
}
