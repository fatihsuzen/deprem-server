package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {
    private final LinearLayoutManager mLayoutManager;
    private ViewPager2.PageTransformer mPageTransformer;

    PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    /* access modifiers changed from: package-private */
    public ViewPager2.PageTransformer getPageTransformer() {
        return this.mPageTransformer;
    }

    public void onPageScrollStateChanged(int i5) {
    }

    public void onPageScrolled(int i5, float f5, int i6) {
        if (this.mPageTransformer != null) {
            float f6 = -f5;
            int i7 = 0;
            while (i7 < this.mLayoutManager.getChildCount()) {
                View childAt = this.mLayoutManager.getChildAt(i7);
                if (childAt != null) {
                    this.mPageTransformer.transformPage(childAt, ((float) (this.mLayoutManager.getPosition(childAt) - i5)) + f6);
                    i7++;
                } else {
                    throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(i7), Integer.valueOf(this.mLayoutManager.getChildCount())}));
                }
            }
        }
    }

    public void onPageSelected(int i5) {
    }

    /* access modifiers changed from: package-private */
    public void setPageTransformer(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.mPageTransformer = pageTransformer;
    }
}
