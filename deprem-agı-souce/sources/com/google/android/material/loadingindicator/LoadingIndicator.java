package com.google.android.material.loadingindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.AnimatorDurationScaleProvider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Arrays;

public final class LoadingIndicator extends View implements Drawable.Callback {
    static final int DEF_STYLE_RES = R.style.Widget_Material3_LoadingIndicator;
    @NonNull
    private final LoadingIndicatorDrawable drawable;
    @NonNull
    private final LoadingIndicatorSpec specs;

    public LoadingIndicator(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @NonNull
    public CharSequence getAccessibilityClassName() {
        return ProgressBar.class.getName();
    }

    @ColorInt
    public int getContainerColor() {
        return this.specs.containerColor;
    }

    @Px
    public int getContainerHeight() {
        return this.specs.containerHeight;
    }

    @Px
    public int getContainerWidth() {
        return this.specs.containerWidth;
    }

    @NonNull
    public LoadingIndicatorDrawable getDrawable() {
        return this.drawable;
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.specs.indicatorColors;
    }

    @Px
    public int getIndicatorSize() {
        return this.specs.indicatorSize;
    }

    public void invalidateDrawable(@NonNull Drawable drawable2) {
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public boolean isEffectivelyVisible() {
        View view = this;
        while (view.getVisibility() == 0) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                if (getWindowVisibility() == 0) {
                    return true;
                }
                return false;
            } else if (!(parent instanceof View)) {
                return true;
            } else {
                view = (View) parent;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        int save = canvas.save();
        if (!(getPaddingLeft() == 0 && getPaddingTop() == 0)) {
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
        }
        if (!(getPaddingRight() == 0 && getPaddingBottom() == 0)) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        this.drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        LoadingIndicatorDrawingDelegate drawingDelegate = this.drawable.getDrawingDelegate();
        int preferredWidth = drawingDelegate.getPreferredWidth() + getPaddingLeft() + getPaddingRight();
        int preferredHeight = drawingDelegate.getPreferredHeight() + getPaddingTop() + getPaddingBottom();
        if (mode == Integer.MIN_VALUE) {
            i5 = View.MeasureSpec.makeMeasureSpec(Math.min(size, preferredWidth), 1073741824);
        } else if (mode == 0) {
            i5 = View.MeasureSpec.makeMeasureSpec(preferredWidth, 1073741824);
        }
        if (mode2 == Integer.MIN_VALUE) {
            i6 = View.MeasureSpec.makeMeasureSpec(Math.min(size2, preferredHeight), 1073741824);
        } else if (mode2 == 0) {
            i6 = View.MeasureSpec.makeMeasureSpec(preferredHeight, 1073741824);
        }
        super.onMeasure(i5, i6);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        this.drawable.setBounds(0, 0, i5, i6);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i5) {
        boolean z4;
        super.onVisibilityChanged(view, i5);
        LoadingIndicatorDrawable loadingIndicatorDrawable = this.drawable;
        boolean visibleToUser = visibleToUser();
        if (i5 == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        loadingIndicatorDrawable.setVisible(visibleToUser, false, z4);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i5) {
        boolean z4;
        super.onWindowVisibilityChanged(i5);
        LoadingIndicatorDrawable loadingIndicatorDrawable = this.drawable;
        boolean visibleToUser = visibleToUser();
        if (i5 == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        loadingIndicatorDrawable.setVisible(visibleToUser, false, z4);
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setAnimatorDurationScaleProvider(@NonNull AnimatorDurationScaleProvider animatorDurationScaleProvider) {
        this.drawable.animatorDurationScaleProvider = animatorDurationScaleProvider;
    }

    public void setContainerColor(@ColorInt int i5) {
        LoadingIndicatorSpec loadingIndicatorSpec = this.specs;
        if (loadingIndicatorSpec.containerColor != i5) {
            loadingIndicatorSpec.containerColor = i5;
            invalidate();
        }
    }

    public void setContainerHeight(@Px int i5) {
        LoadingIndicatorSpec loadingIndicatorSpec = this.specs;
        if (loadingIndicatorSpec.containerHeight != i5) {
            loadingIndicatorSpec.containerHeight = i5;
            requestLayout();
            invalidate();
        }
    }

    public void setContainerWidth(@Px int i5) {
        LoadingIndicatorSpec loadingIndicatorSpec = this.specs;
        if (loadingIndicatorSpec.containerWidth != i5) {
            loadingIndicatorSpec.containerWidth = i5;
            requestLayout();
            invalidate();
        }
    }

    public void setIndicatorColor(@ColorInt int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{MaterialColors.getColor(getContext(), androidx.appcompat.R.attr.colorPrimary, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.specs.indicatorColors = iArr;
            this.drawable.getAnimatorDelegate().invalidateSpecValues();
            invalidate();
        }
    }

    public void setIndicatorSize(@Px int i5) {
        LoadingIndicatorSpec loadingIndicatorSpec = this.specs;
        if (loadingIndicatorSpec.indicatorSize != i5) {
            loadingIndicatorSpec.indicatorSize = i5;
            requestLayout();
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean visibleToUser() {
        if (!isAttachedToWindow() || getWindowVisibility() != 0 || !isEffectivelyVisible()) {
            return false;
        }
        return true;
    }

    public LoadingIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.loadingIndicatorStyle);
    }

    public LoadingIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i5, DEF_STYLE_RES), attributeSet, i5);
        Context context2 = getContext();
        LoadingIndicatorDrawable create = LoadingIndicatorDrawable.create(context2, new LoadingIndicatorSpec(context2, attributeSet, i5));
        this.drawable = create;
        create.setCallback(this);
        this.specs = create.getDrawingDelegate().specs;
        setAnimatorDurationScaleProvider(new AnimatorDurationScaleProvider());
    }
}
