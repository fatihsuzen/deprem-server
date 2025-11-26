package com.google.android.material.dockedtoolbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.TintTypedArray;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class DockedToolbarLayout extends FrameLayout {
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_DockedToolbar;
    private static final String TAG = "DockedToolbarLayout";
    /* access modifiers changed from: private */
    public Boolean paddingBottomSystemWindowInsets;
    /* access modifiers changed from: private */
    public Boolean paddingTopSystemWindowInsets;

    public DockedToolbarLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public boolean hasGravity(ViewGroup.LayoutParams layoutParams, int i5) {
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            if ((((CoordinatorLayout.LayoutParams) layoutParams).gravity & i5) == i5) {
                return true;
            }
            return false;
        } else if (!(layoutParams instanceof FrameLayout.LayoutParams) || (((FrameLayout.LayoutParams) layoutParams).gravity & i5) != i5) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (View.MeasureSpec.getMode(i6) != 1073741824) {
            int childCount = getChildCount();
            int max = Math.max(getMeasuredHeight(), getSuggestedMinimumHeight() + getPaddingTop() + getPaddingBottom());
            for (int i7 = 0; i7 < childCount; i7++) {
                measureChild(getChildAt(i7), i5, View.MeasureSpec.makeMeasureSpec(max, 1073741824));
            }
            setMeasuredDimension(getMeasuredWidth(), max);
        }
    }

    public DockedToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dockedToolbarStyle);
    }

    public DockedToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5) {
        this(context, attributeSet, i5, DEF_STYLE_RES);
    }

    public DockedToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5, @StyleRes int i6) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i5, i6), attributeSet, i5);
        Context context2 = getContext();
        AttributeSet attributeSet2 = attributeSet;
        int i7 = i5;
        int i8 = i6;
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet2, R.styleable.DockedToolbar, i7, i8, new int[0]);
        int i9 = R.styleable.DockedToolbar_backgroundTint;
        if (obtainTintedStyledAttributes.hasValue(i9)) {
            int color = obtainTintedStyledAttributes.getColor(i9, 0);
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(context2, attributeSet2, i7, i8).build());
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
            setBackground(materialShapeDrawable);
        }
        int i10 = R.styleable.DockedToolbar_paddingTopSystemWindowInsets;
        if (obtainTintedStyledAttributes.hasValue(i10)) {
            this.paddingTopSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(i10, true));
        }
        int i11 = R.styleable.DockedToolbar_paddingBottomSystemWindowInsets;
        if (obtainTintedStyledAttributes.hasValue(i11)) {
            this.paddingBottomSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(i11, true));
        }
        ViewUtils.doOnApplyWindowInsets(this, new ViewUtils.OnApplyWindowInsetsListener() {
            @NonNull
            public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.RelativePadding relativePadding) {
                int i5;
                int i6;
                if (DockedToolbarLayout.this.paddingTopSystemWindowInsets != null && DockedToolbarLayout.this.paddingBottomSystemWindowInsets != null && !DockedToolbarLayout.this.paddingTopSystemWindowInsets.booleanValue() && !DockedToolbarLayout.this.paddingBottomSystemWindowInsets.booleanValue()) {
                    return windowInsetsCompat;
                }
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout() | WindowInsetsCompat.Type.ime());
                int i7 = insets.bottom;
                int i8 = insets.top;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (!DockedToolbarLayout.this.hasGravity(layoutParams, 48) || DockedToolbarLayout.this.paddingTopSystemWindowInsets != null || !DockedToolbarLayout.this.getFitsSystemWindows()) {
                    i5 = 0;
                } else {
                    i5 = i8;
                }
                if (!DockedToolbarLayout.this.hasGravity(layoutParams, 80) || DockedToolbarLayout.this.paddingBottomSystemWindowInsets != null || !DockedToolbarLayout.this.getFitsSystemWindows()) {
                    i6 = 0;
                } else {
                    i6 = i7;
                }
                if (DockedToolbarLayout.this.paddingBottomSystemWindowInsets != null) {
                    if (!DockedToolbarLayout.this.paddingBottomSystemWindowInsets.booleanValue()) {
                        i7 = 0;
                    }
                    i6 = i7;
                }
                if (DockedToolbarLayout.this.paddingTopSystemWindowInsets != null) {
                    if (!DockedToolbarLayout.this.paddingTopSystemWindowInsets.booleanValue()) {
                        i8 = 0;
                    }
                    i5 = i8;
                }
                relativePadding.top += i5;
                relativePadding.bottom += i6;
                relativePadding.applyToView(view);
                return windowInsetsCompat;
            }
        });
        setImportantForAccessibility(1);
        obtainTintedStyledAttributes.recycle();
    }
}
