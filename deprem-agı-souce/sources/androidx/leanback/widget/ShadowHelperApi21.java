package androidx.leanback.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class ShadowHelperApi21 {
    static final ViewOutlineProvider sOutlineProvider = new ViewOutlineProvider() {
        public void getOutline(View view, Outline outline) {
            outline.setRect(0, 0, view.getWidth(), view.getHeight());
            outline.setAlpha(1.0f);
        }
    };

    static class ShadowImpl {
        float mFocusedZ;
        float mNormalZ;
        View mShadowContainer;

        ShadowImpl() {
        }
    }

    private ShadowHelperApi21() {
    }

    public static Object addDynamicShadow(View view, float f5, float f6, int i5) {
        if (i5 > 0) {
            RoundedRectHelperApi21.setClipToRoundedOutline(view, true, i5);
        } else {
            view.setOutlineProvider(sOutlineProvider);
        }
        ShadowImpl shadowImpl = new ShadowImpl();
        shadowImpl.mShadowContainer = view;
        shadowImpl.mNormalZ = f5;
        shadowImpl.mFocusedZ = f6;
        view.setZ(f5);
        return shadowImpl;
    }

    public static void setShadowFocusLevel(Object obj, float f5) {
        ShadowImpl shadowImpl = (ShadowImpl) obj;
        View view = shadowImpl.mShadowContainer;
        float f6 = shadowImpl.mNormalZ;
        view.setZ(f6 + (f5 * (shadowImpl.mFocusedZ - f6)));
    }
}
