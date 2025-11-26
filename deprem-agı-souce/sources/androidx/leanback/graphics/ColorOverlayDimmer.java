package androidx.leanback.graphics;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import androidx.leanback.R;

public final class ColorOverlayDimmer {
    private final float mActiveLevel;
    private int mAlpha;
    private float mAlphaFloat;
    private final float mDimmedLevel;
    private final Paint mPaint;

    private ColorOverlayDimmer(int i5, float f5, float f6) {
        f5 = f5 > 1.0f ? 1.0f : f5;
        float f7 = 0.0f;
        f5 = f5 < 0.0f ? 0.0f : f5;
        f6 = f6 > 1.0f ? 1.0f : f6;
        f7 = f6 >= 0.0f ? f6 : f7;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(Color.rgb(Color.red(i5), Color.green(i5), Color.blue(i5)));
        this.mActiveLevel = f5;
        this.mDimmedLevel = f7;
        setActiveLevel(1.0f);
    }

    public static ColorOverlayDimmer createColorOverlayDimmer(int i5, float f5, float f6) {
        return new ColorOverlayDimmer(i5, f5, f6);
    }

    public static ColorOverlayDimmer createDefault(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.LeanbackTheme);
        int color = obtainStyledAttributes.getColor(R.styleable.LeanbackTheme_overlayDimMaskColor, context.getResources().getColor(R.color.lb_view_dim_mask_color));
        float fraction = obtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimActiveLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_active_level, 1, 0));
        float fraction2 = obtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimDimmedLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_dimmed_level, 1, 1));
        obtainStyledAttributes.recycle();
        return new ColorOverlayDimmer(color, fraction, fraction2);
    }

    public int applyToColor(int i5) {
        float f5 = 1.0f - this.mAlphaFloat;
        return Color.argb(Color.alpha(i5), (int) (((float) Color.red(i5)) * f5), (int) (((float) Color.green(i5)) * f5), (int) (((float) Color.blue(i5)) * f5));
    }

    public void drawColorOverlay(Canvas canvas, View view, boolean z4) {
        Canvas canvas2;
        canvas.save();
        float left = ((float) view.getLeft()) + view.getTranslationX();
        float top = ((float) view.getTop()) + view.getTranslationY();
        canvas.translate(left, top);
        canvas.concat(view.getMatrix());
        canvas.translate(-left, -top);
        if (z4) {
            canvas2 = canvas;
            canvas2.drawRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), this.mPaint);
        } else {
            canvas2 = canvas;
            canvas2.drawRect((float) (view.getLeft() + view.getPaddingLeft()), (float) (view.getTop() + view.getPaddingTop()), (float) (view.getRight() - view.getPaddingRight()), (float) (view.getBottom() - view.getPaddingBottom()), this.mPaint);
        }
        canvas2.restore();
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public float getAlphaFloat() {
        return this.mAlphaFloat;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public boolean needsDraw() {
        if (this.mAlpha != 0) {
            return true;
        }
        return false;
    }

    public void setActiveLevel(float f5) {
        float f6 = this.mDimmedLevel;
        float f7 = f6 + (f5 * (this.mActiveLevel - f6));
        this.mAlphaFloat = f7;
        int i5 = (int) (f7 * 255.0f);
        this.mAlpha = i5;
        this.mPaint.setAlpha(i5);
    }
}
