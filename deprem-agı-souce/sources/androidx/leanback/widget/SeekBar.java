package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;
import androidx.leanback.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class SeekBar extends View {
    private AccessibilitySeekListener mAccessibilitySeekListener;
    private int mActiveBarHeight;
    private int mActiveRadius;
    private final Paint mBackgroundPaint;
    private final RectF mBackgroundRect = new RectF();
    private int mBarHeight;
    private final Paint mKnobPaint;
    private int mKnobx;
    private int mMax;
    private int mProgress;
    private final Paint mProgressPaint;
    private final RectF mProgressRect = new RectF();
    private int mSecondProgress;
    private final Paint mSecondProgressPaint;
    private final RectF mSecondProgressRect = new RectF();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class AccessibilitySeekListener {
        public abstract boolean onAccessibilitySeekBackward();

        public abstract boolean onAccessibilitySeekForward();
    }

    public SeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint(1);
        this.mSecondProgressPaint = paint;
        Paint paint2 = new Paint(1);
        this.mProgressPaint = paint2;
        Paint paint3 = new Paint(1);
        this.mBackgroundPaint = paint3;
        Paint paint4 = new Paint(1);
        this.mKnobPaint = paint4;
        setWillNotDraw(false);
        paint3.setColor(-7829368);
        paint.setColor(-3355444);
        paint2.setColor(SupportMenu.CATEGORY_MASK);
        paint4.setColor(-1);
        this.mBarHeight = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_progressbar_bar_height);
        this.mActiveBarHeight = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_progressbar_active_bar_height);
        this.mActiveRadius = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_progressbar_active_radius);
    }

    private void calculate() {
        int i5;
        int i6;
        if (isFocused()) {
            i5 = this.mActiveBarHeight;
        } else {
            i5 = this.mBarHeight;
        }
        int width = getWidth();
        int height = getHeight();
        int i7 = (height - i5) / 2;
        RectF rectF = this.mBackgroundRect;
        int i8 = this.mBarHeight;
        float f5 = (float) i7;
        float f6 = (float) (height - i7);
        rectF.set((float) (i8 / 2), f5, (float) (width - (i8 / 2)), f6);
        if (isFocused()) {
            i6 = this.mActiveRadius;
        } else {
            i6 = this.mBarHeight / 2;
        }
        float f7 = (float) (width - (i6 * 2));
        float f8 = (((float) this.mProgress) / ((float) this.mMax)) * f7;
        RectF rectF2 = this.mProgressRect;
        int i9 = this.mBarHeight;
        rectF2.set((float) (i9 / 2), f5, ((float) (i9 / 2)) + f8, f6);
        this.mSecondProgressRect.set(this.mProgressRect.right, f5, ((float) (this.mBarHeight / 2)) + ((((float) this.mSecondProgress) / ((float) this.mMax)) * f7), f6);
        this.mKnobx = i6 + ((int) f8);
        invalidate();
    }

    public CharSequence getAccessibilityClassName() {
        return android.widget.SeekBar.class.getName();
    }

    public int getMax() {
        return this.mMax;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getSecondProgress() {
        return this.mSecondProgress;
    }

    public int getSecondaryProgressColor() {
        return this.mSecondProgressPaint.getColor();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i5;
        super.onDraw(canvas);
        if (isFocused()) {
            i5 = this.mActiveRadius;
        } else {
            i5 = this.mBarHeight / 2;
        }
        float f5 = (float) i5;
        canvas.drawRoundRect(this.mBackgroundRect, f5, f5, this.mBackgroundPaint);
        RectF rectF = this.mSecondProgressRect;
        if (rectF.right > rectF.left) {
            canvas.drawRoundRect(rectF, f5, f5, this.mSecondProgressPaint);
        }
        canvas.drawRoundRect(this.mProgressRect, f5, f5, this.mProgressPaint);
        canvas.drawCircle((float) this.mKnobx, (float) (getHeight() / 2), f5, this.mKnobPaint);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z4, int i5, Rect rect) {
        super.onFocusChanged(z4, i5, rect);
        calculate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        calculate();
    }

    public boolean performAccessibilityAction(int i5, Bundle bundle) {
        AccessibilitySeekListener accessibilitySeekListener = this.mAccessibilitySeekListener;
        if (accessibilitySeekListener != null) {
            if (i5 == 4096) {
                return accessibilitySeekListener.onAccessibilitySeekForward();
            }
            if (i5 == 8192) {
                return accessibilitySeekListener.onAccessibilitySeekBackward();
            }
        }
        return super.performAccessibilityAction(i5, bundle);
    }

    public void setAccessibilitySeekListener(AccessibilitySeekListener accessibilitySeekListener) {
        this.mAccessibilitySeekListener = accessibilitySeekListener;
    }

    public void setActiveBarHeight(int i5) {
        this.mActiveBarHeight = i5;
        calculate();
    }

    public void setActiveRadius(int i5) {
        this.mActiveRadius = i5;
        calculate();
    }

    public void setBarHeight(int i5) {
        this.mBarHeight = i5;
        calculate();
    }

    public void setMax(int i5) {
        this.mMax = i5;
        calculate();
    }

    public void setProgress(int i5) {
        int i6 = this.mMax;
        if (i5 > i6) {
            i5 = i6;
        } else if (i5 < 0) {
            i5 = 0;
        }
        this.mProgress = i5;
        calculate();
    }

    public void setProgressColor(int i5) {
        this.mProgressPaint.setColor(i5);
    }

    public void setSecondaryProgress(int i5) {
        int i6 = this.mMax;
        if (i5 > i6) {
            i5 = i6;
        } else if (i5 < 0) {
            i5 = 0;
        }
        this.mSecondProgress = i5;
        calculate();
    }

    public void setSecondaryProgressColor(int i5) {
        this.mSecondProgressPaint.setColor(i5);
    }
}
