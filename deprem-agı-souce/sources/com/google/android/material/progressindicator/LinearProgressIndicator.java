package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import j$.util.Objects;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {
    public static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_LinearProgressIndicator;
    public static final int INDETERMINATE_ANIMATION_TYPE_CONTIGUOUS = 0;
    public static final int INDETERMINATE_ANIMATION_TYPE_DISJOINT = 1;
    public static final int INDICATOR_DIRECTION_END_TO_START = 3;
    public static final int INDICATOR_DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int INDICATOR_DIRECTION_RIGHT_TO_LEFT = 1;
    public static final int INDICATOR_DIRECTION_START_TO_END = 2;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IndeterminateAnimationType {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IndicatorDirection {
    }

    public LinearProgressIndicator(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void initializeDrawables() {
        LinearDrawingDelegate linearDrawingDelegate = new LinearDrawingDelegate((LinearProgressIndicatorSpec) this.spec);
        setIndeterminateDrawable(IndeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.spec, linearDrawingDelegate));
        setProgressDrawable(DeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.spec, linearDrawingDelegate));
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    @Px
    public int getTrackInnerCornerRadius() {
        return ((LinearProgressIndicatorSpec) this.spec).trackInnerCornerRadius;
    }

    @Nullable
    public Integer getTrackStopIndicatorPadding() {
        return ((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorPadding;
    }

    @Px
    public int getTrackStopIndicatorSize() {
        return ((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        S s5 = this.spec;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s5;
        boolean z5 = true;
        if (!(((LinearProgressIndicatorSpec) s5).indicatorDirection == 1 || ((getLayoutDirection() == 1 && ((LinearProgressIndicatorSpec) this.spec).indicatorDirection == 2) || (getLayoutDirection() == 0 && ((LinearProgressIndicatorSpec) this.spec).indicatorDirection == 3)))) {
            z5 = false;
        }
        linearProgressIndicatorSpec.drawHorizontallyInverse = z5;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        int paddingLeft = i5 - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i6 - (getPaddingTop() + getPaddingBottom());
        IndeterminateDrawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        DeterminateDrawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    public void setIndeterminateAnimationType(int i5) {
        if (((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType != i5) {
            if (!visibleToUser() || !isIndeterminate()) {
                S s5 = this.spec;
                ((LinearProgressIndicatorSpec) s5).indeterminateAnimationType = i5;
                ((LinearProgressIndicatorSpec) s5).validateSpec();
                if (i5 == 0) {
                    getIndeterminateDrawable().setAnimatorDelegate(new LinearIndeterminateContiguousAnimatorDelegate((LinearProgressIndicatorSpec) this.spec));
                } else {
                    getIndeterminateDrawable().setAnimatorDelegate(new LinearIndeterminateDisjointAnimatorDelegate(getContext(), (LinearProgressIndicatorSpec) this.spec));
                }
                registerSwitchIndeterminateModeCallback();
                invalidate();
                return;
            }
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
    }

    public void setIndicatorColor(@NonNull int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
    }

    public void setIndicatorDirection(int i5) {
        S s5 = this.spec;
        ((LinearProgressIndicatorSpec) s5).indicatorDirection = i5;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s5;
        boolean z4 = true;
        if (!(i5 == 1 || ((getLayoutDirection() == 1 && ((LinearProgressIndicatorSpec) this.spec).indicatorDirection == 2) || (getLayoutDirection() == 0 && i5 == 3)))) {
            z4 = false;
        }
        linearProgressIndicatorSpec.drawHorizontallyInverse = z4;
        invalidate();
    }

    public void setProgressCompat(int i5, boolean z4) {
        S s5 = this.spec;
        if (s5 == null || ((LinearProgressIndicatorSpec) s5).indeterminateAnimationType != 0 || !isIndeterminate()) {
            super.setProgressCompat(i5, z4);
        }
    }

    public void setTrackCornerRadius(int i5) {
        super.setTrackCornerRadius(i5);
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
        invalidate();
    }

    public void setTrackInnerCornerRadius(@Px int i5) {
        S s5 = this.spec;
        if (((LinearProgressIndicatorSpec) s5).trackInnerCornerRadius != i5) {
            ((LinearProgressIndicatorSpec) s5).trackInnerCornerRadius = Math.round(Math.min((float) i5, ((float) ((LinearProgressIndicatorSpec) s5).trackThickness) / 2.0f));
            S s6 = this.spec;
            ((LinearProgressIndicatorSpec) s6).useRelativeTrackInnerCornerRadius = false;
            ((LinearProgressIndicatorSpec) s6).hasInnerCornerRadius = true;
            ((LinearProgressIndicatorSpec) s6).validateSpec();
            invalidate();
        }
    }

    public void setTrackInnerCornerRadiusFraction(float f5) {
        S s5 = this.spec;
        if (((LinearProgressIndicatorSpec) s5).trackInnerCornerRadiusFraction != f5) {
            ((LinearProgressIndicatorSpec) s5).trackInnerCornerRadiusFraction = Math.min(f5, 0.5f);
            S s6 = this.spec;
            ((LinearProgressIndicatorSpec) s6).useRelativeTrackInnerCornerRadius = true;
            ((LinearProgressIndicatorSpec) s6).hasInnerCornerRadius = true;
            ((LinearProgressIndicatorSpec) s6).validateSpec();
            invalidate();
        }
    }

    public void setTrackStopIndicatorPadding(@Nullable Integer num) {
        if (!Objects.equals(((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorPadding, num)) {
            ((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorPadding = num;
            invalidate();
        }
    }

    public void setTrackStopIndicatorSize(@Px int i5) {
        S s5 = this.spec;
        if (((LinearProgressIndicatorSpec) s5).trackStopIndicatorSize != i5) {
            ((LinearProgressIndicatorSpec) s5).trackStopIndicatorSize = Math.min(i5, ((LinearProgressIndicatorSpec) s5).trackThickness);
            ((LinearProgressIndicatorSpec) this.spec).validateSpec();
            invalidate();
        }
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    /* access modifiers changed from: package-private */
    public LinearProgressIndicatorSpec createSpec(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5) {
        super(context, attributeSet, i5, DEF_STYLE_RES);
        initializeDrawables();
        this.initialized = true;
    }
}
