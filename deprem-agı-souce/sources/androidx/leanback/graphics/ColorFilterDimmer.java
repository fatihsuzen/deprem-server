package androidx.leanback.graphics;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.view.View;
import androidx.leanback.R;

public final class ColorFilterDimmer {
    private final float mActiveLevel;
    private final ColorFilterCache mColorDimmer;
    private final float mDimmedLevel;
    private ColorFilter mFilter;
    private final Paint mPaint;

    private ColorFilterDimmer(ColorFilterCache colorFilterCache, float f5, float f6) {
        this.mColorDimmer = colorFilterCache;
        f5 = f5 > 1.0f ? 1.0f : f5;
        float f7 = 0.0f;
        f5 = f5 < 0.0f ? 0.0f : f5;
        f6 = f6 > 1.0f ? 1.0f : f6;
        f7 = f6 >= 0.0f ? f6 : f7;
        this.mActiveLevel = f5;
        this.mDimmedLevel = f7;
        this.mPaint = new Paint();
    }

    public static ColorFilterDimmer create(ColorFilterCache colorFilterCache, float f5, float f6) {
        return new ColorFilterDimmer(colorFilterCache, f5, f6);
    }

    public static ColorFilterDimmer createDefault(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.LeanbackTheme);
        int color = obtainStyledAttributes.getColor(R.styleable.LeanbackTheme_overlayDimMaskColor, context.getResources().getColor(R.color.lb_view_dim_mask_color));
        float fraction = obtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimActiveLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_active_level, 1, 0));
        float fraction2 = obtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimDimmedLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_dimmed_level, 1, 1));
        obtainStyledAttributes.recycle();
        return new ColorFilterDimmer(ColorFilterCache.getColorFilterCache(color), fraction, fraction2);
    }

    public void applyFilterToView(View view) {
        if (this.mFilter != null) {
            view.setLayerType(2, this.mPaint);
        } else {
            view.setLayerType(0, (Paint) null);
        }
        view.invalidate();
    }

    public ColorFilter getColorFilter() {
        return this.mFilter;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public void setActiveLevel(float f5) {
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        ColorFilterCache colorFilterCache = this.mColorDimmer;
        float f6 = this.mDimmedLevel;
        ColorFilter filterForLevel = colorFilterCache.getFilterForLevel(f6 + (f5 * (this.mActiveLevel - f6)));
        this.mFilter = filterForLevel;
        this.mPaint.setColorFilter(filterForLevel);
    }
}
