package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;

public final class LinearProgressIndicatorSpec extends BaseProgressIndicatorSpec {
    boolean drawHorizontallyInverse;
    public boolean hasInnerCornerRadius;
    public int indeterminateAnimationType;
    public int indicatorDirection;
    @Px
    public int trackInnerCornerRadius;
    public float trackInnerCornerRadiusFraction;
    @Nullable
    public Integer trackStopIndicatorPadding;
    @Px
    public int trackStopIndicatorSize;
    public boolean useRelativeTrackInnerCornerRadius;

    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    public int getTrackInnerCornerRadiusInPx() {
        if (!this.hasInnerCornerRadius) {
            return getTrackCornerRadiusInPx();
        }
        if (this.useRelativeTrackInnerCornerRadius) {
            return (int) (((float) this.trackThickness) * this.trackInnerCornerRadiusFraction);
        }
        return this.trackInnerCornerRadius;
    }

    public boolean useStrokeCap() {
        if (!super.useStrokeCap() || getTrackInnerCornerRadiusInPx() != getTrackCornerRadiusInPx()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void validateSpec() {
        super.validateSpec();
        if (this.trackStopIndicatorSize < 0) {
            throw new IllegalArgumentException("Stop indicator size must be >= 0.");
        } else if (this.indeterminateAnimationType != 0) {
        } else {
            if ((getTrackCornerRadiusInPx() > 0 || (this.hasInnerCornerRadius && getTrackInnerCornerRadiusInPx() > 0)) && this.indicatorTrackGapSize == 0) {
                throw new IllegalArgumentException("Rounded corners without gap are not supported in contiguous indeterminate animation.");
            } else if (this.indicatorColors.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }

    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5) {
        this(context, attributeSet, i5, LinearProgressIndicator.DEF_STYLE_RES);
    }

    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5, @StyleRes int i6) {
        super(context, attributeSet, i5, i6);
        boolean z4 = false;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.LinearProgressIndicator, R.attr.linearProgressIndicatorStyle, LinearProgressIndicator.DEF_STYLE_RES, new int[0]);
        this.indeterminateAnimationType = obtainStyledAttributes.getInt(R.styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.indicatorDirection = obtainStyledAttributes.getInt(R.styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
        this.trackStopIndicatorSize = Math.min(obtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearProgressIndicator_trackStopIndicatorSize, 0), this.trackThickness);
        int i7 = R.styleable.LinearProgressIndicator_trackStopIndicatorPadding;
        if (obtainStyledAttributes.hasValue(i7)) {
            this.trackStopIndicatorPadding = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(i7, 0));
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(R.styleable.LinearProgressIndicator_trackInnerCornerRadius);
        if (peekValue != null) {
            int i8 = peekValue.type;
            if (i8 == 5) {
                this.trackInnerCornerRadius = Math.min(TypedValue.complexToDimensionPixelSize(peekValue.data, obtainStyledAttributes.getResources().getDisplayMetrics()), this.trackThickness / 2);
                this.useRelativeTrackInnerCornerRadius = false;
                this.hasInnerCornerRadius = true;
            } else if (i8 == 6) {
                this.trackInnerCornerRadiusFraction = Math.min(peekValue.getFraction(1.0f, 1.0f), 0.5f);
                this.useRelativeTrackInnerCornerRadius = true;
                this.hasInnerCornerRadius = true;
            }
        }
        obtainStyledAttributes.recycle();
        validateSpec();
        this.drawHorizontallyInverse = this.indicatorDirection == 1 ? true : z4;
    }
}
