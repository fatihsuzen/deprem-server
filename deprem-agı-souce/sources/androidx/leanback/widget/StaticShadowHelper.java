package androidx.leanback.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.R;

final class StaticShadowHelper {

    static class ShadowImpl {
        View mFocusShadow;
        View mNormalShadow;

        ShadowImpl() {
        }
    }

    private StaticShadowHelper() {
    }

    static Object addStaticShadow(ViewGroup viewGroup) {
        viewGroup.setLayoutMode(1);
        LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lb_shadow, viewGroup, true);
        ShadowImpl shadowImpl = new ShadowImpl();
        shadowImpl.mNormalShadow = viewGroup.findViewById(R.id.lb_shadow_normal);
        shadowImpl.mFocusShadow = viewGroup.findViewById(R.id.lb_shadow_focused);
        return shadowImpl;
    }

    static void prepareParent(ViewGroup viewGroup) {
        viewGroup.setLayoutMode(1);
    }

    static void setShadowFocusLevel(Object obj, float f5) {
        ShadowImpl shadowImpl = (ShadowImpl) obj;
        shadowImpl.mNormalShadow.setAlpha(1.0f - f5);
        shadowImpl.mFocusShadow.setAlpha(f5);
    }

    static boolean supportsShadow() {
        return true;
    }
}
