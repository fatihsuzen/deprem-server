package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {
    public static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_CircularProgressIndicator;
    public static final int INDETERMINATE_ANIMATION_TYPE_ADVANCE = 0;
    public static final int INDETERMINATE_ANIMATION_TYPE_RETREAT = 1;
    public static final int INDICATOR_DIRECTION_CLOCKWISE = 0;
    public static final int INDICATOR_DIRECTION_COUNTERCLOCKWISE = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IndeterminateAnimationType {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IndicatorDirection {
    }

    public CircularProgressIndicator(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void initializeDrawables() {
        CircularDrawingDelegate circularDrawingDelegate = new CircularDrawingDelegate((CircularProgressIndicatorSpec) this.spec);
        setIndeterminateDrawable(IndeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.spec, circularDrawingDelegate));
        setProgressDrawable(DeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.spec, circularDrawingDelegate));
    }

    public int getIndeterminateAnimationType() {
        return ((CircularProgressIndicatorSpec) this.spec).indeterminateAnimationType;
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    @Px
    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorInset;
    }

    @Px
    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorSize;
    }

    public void setIndeterminateAnimationType(int i5) {
        IndeterminateAnimatorDelegate indeterminateAnimatorDelegate;
        if (((CircularProgressIndicatorSpec) this.spec).indeterminateAnimationType != i5) {
            if (!visibleToUser() || !isIndeterminate()) {
                S s5 = this.spec;
                ((CircularProgressIndicatorSpec) s5).indeterminateAnimationType = i5;
                ((CircularProgressIndicatorSpec) s5).validateSpec();
                if (i5 == 1) {
                    indeterminateAnimatorDelegate = new CircularIndeterminateRetreatAnimatorDelegate(getContext(), (CircularProgressIndicatorSpec) this.spec);
                } else {
                    indeterminateAnimatorDelegate = new CircularIndeterminateAdvanceAnimatorDelegate((CircularProgressIndicatorSpec) this.spec);
                }
                getIndeterminateDrawable().setAnimatorDelegate(indeterminateAnimatorDelegate);
                registerSwitchIndeterminateModeCallback();
                invalidate();
                return;
            }
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
    }

    public void setIndicatorDirection(int i5) {
        ((CircularProgressIndicatorSpec) this.spec).indicatorDirection = i5;
        invalidate();
    }

    public void setIndicatorInset(@Px int i5) {
        S s5 = this.spec;
        if (((CircularProgressIndicatorSpec) s5).indicatorInset != i5) {
            ((CircularProgressIndicatorSpec) s5).indicatorInset = i5;
            invalidate();
        }
    }

    public void setIndicatorSize(@Px int i5) {
        int max = Math.max(i5, getTrackThickness() * 2);
        S s5 = this.spec;
        if (((CircularProgressIndicatorSpec) s5).indicatorSize != max) {
            ((CircularProgressIndicatorSpec) s5).indicatorSize = max;
            ((CircularProgressIndicatorSpec) s5).validateSpec();
            requestLayout();
            invalidate();
        }
    }

    public void setTrackThickness(int i5) {
        super.setTrackThickness(i5);
        ((CircularProgressIndicatorSpec) this.spec).validateSpec();
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    /* access modifiers changed from: package-private */
    public CircularProgressIndicatorSpec createSpec(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5) {
        super(context, attributeSet, i5, DEF_STYLE_RES);
        initializeDrawables();
        this.initialized = true;
    }
}
