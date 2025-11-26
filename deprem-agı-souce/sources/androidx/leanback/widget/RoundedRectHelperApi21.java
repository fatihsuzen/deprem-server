package androidx.leanback.widget;

import android.graphics.Outline;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class RoundedRectHelperApi21 {
    private static final int MAX_CACHED_PROVIDER = 32;
    private static SparseArray<ViewOutlineProvider> sRoundedRectProvider;

    static final class RoundedRectOutlineProvider extends ViewOutlineProvider {
        private int mRadius;

        RoundedRectOutlineProvider(int i5) {
            this.mRadius = i5;
        }

        public void getOutline(View view, Outline outline) {
            Outline outline2 = outline;
            outline2.setRoundRect(0, 0, view.getWidth(), view.getHeight(), (float) this.mRadius);
            outline2.setAlpha(1.0f);
        }
    }

    private RoundedRectHelperApi21() {
    }

    public static void setClipToRoundedOutline(View view, boolean z4, int i5) {
        if (z4) {
            if (sRoundedRectProvider == null) {
                sRoundedRectProvider = new SparseArray<>();
            }
            ViewOutlineProvider viewOutlineProvider = sRoundedRectProvider.get(i5);
            if (viewOutlineProvider == null) {
                viewOutlineProvider = new RoundedRectOutlineProvider(i5);
                if (sRoundedRectProvider.size() < 32) {
                    sRoundedRectProvider.put(i5, viewOutlineProvider);
                }
            }
            view.setOutlineProvider(viewOutlineProvider);
        } else {
            view.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        }
        view.setClipToOutline(z4);
    }
}
