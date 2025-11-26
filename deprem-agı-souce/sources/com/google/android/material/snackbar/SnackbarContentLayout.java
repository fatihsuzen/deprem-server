package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private Button actionView;
    private final TimeInterpolator contentInterpolator;
    private int maxInlineActionWidth;
    private TextView messageView;

    public SnackbarContentLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private static void updateTopBottomPadding(@NonNull View view, int i5, int i6) {
        if (view.isPaddingRelative()) {
            view.setPaddingRelative(view.getPaddingStart(), i5, view.getPaddingEnd(), i6);
        } else {
            view.setPadding(view.getPaddingLeft(), i5, view.getPaddingRight(), i6);
        }
    }

    private boolean updateViewsWithinLayout(int i5, int i6, int i7) {
        boolean z4;
        if (i5 != getOrientation()) {
            setOrientation(i5);
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.messageView.getPaddingTop() == i6 && this.messageView.getPaddingBottom() == i7) {
            return z4;
        }
        updateTopBottomPadding(this.messageView, i6, i7);
        return true;
    }

    public void animateContentIn(int i5, int i6) {
        this.messageView.setAlpha(0.0f);
        long j5 = (long) i6;
        long j6 = (long) i5;
        this.messageView.animate().alpha(1.0f).setDuration(j5).setInterpolator(this.contentInterpolator).setStartDelay(j6).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(0.0f);
            this.actionView.animate().alpha(1.0f).setDuration(j5).setInterpolator(this.contentInterpolator).setStartDelay(j6).start();
        }
    }

    public void animateContentOut(int i5, int i6) {
        this.messageView.setAlpha(1.0f);
        long j5 = (long) i6;
        long j6 = (long) i5;
        this.messageView.animate().alpha(0.0f).setDuration(j5).setInterpolator(this.contentInterpolator).setStartDelay(j6).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(1.0f);
            this.actionView.animate().alpha(0.0f).setDuration(j5).setInterpolator(this.contentInterpolator).setStartDelay(j6).start();
        }
    }

    public Button getActionView() {
        return this.actionView;
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView) findViewById(R.id.snackbar_text);
        this.actionView = (Button) findViewById(R.id.snackbar_action);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        boolean z4;
        super.onMeasure(i5, i6);
        if (getOrientation() != 1) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
            Layout layout = this.messageView.getLayout();
            if (layout == null || layout.getLineCount() <= 1) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (!z4 || this.maxInlineActionWidth <= 0 || this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth) {
                if (!z4) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (!updateViewsWithinLayout(0, dimensionPixelSize, dimensionPixelSize)) {
                    return;
                }
            } else if (!updateViewsWithinLayout(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                return;
            }
            super.onMeasure(i5, i6);
        }
    }

    public void setMaxInlineActionWidth(int i5) {
        this.maxInlineActionWidth = i5;
    }

    /* access modifiers changed from: package-private */
    public void updateActionTextColorAlphaIfNeeded(float f5) {
        if (f5 != 1.0f) {
            this.actionView.setTextColor(MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface), this.actionView.getCurrentTextColor(), f5));
        }
    }

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.contentInterpolator = MotionUtils.resolveThemeInterpolator(context, R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }
}
