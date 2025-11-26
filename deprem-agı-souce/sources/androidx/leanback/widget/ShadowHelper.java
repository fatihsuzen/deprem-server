package androidx.leanback.widget;

import android.view.View;

final class ShadowHelper {
    private ShadowHelper() {
    }

    static Object addDynamicShadow(View view, float f5, float f6, int i5) {
        return ShadowHelperApi21.addDynamicShadow(view, f5, f6, i5);
    }

    static void setShadowFocusLevel(Object obj, float f5) {
        ShadowHelperApi21.setShadowFocusLevel(obj, f5);
    }

    static boolean supportsDynamicShadow() {
        return true;
    }
}
