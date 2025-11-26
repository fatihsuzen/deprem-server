package com.google.android.material.floatingtoolbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class FloatingToolbarLayout extends FrameLayout {
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_FloatingToolbar;
    private static final String TAG = "FloatingToolbarLayout";
    /* access modifiers changed from: private */
    public int bottomMarginWindowInset;
    /* access modifiers changed from: private */
    public int leftMarginWindowInset;
    /* access modifiers changed from: private */
    public boolean marginBottomSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean marginLeftSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean marginRightSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean marginTopSystemWindowInsets;
    private Rect originalMargins;
    /* access modifiers changed from: private */
    public int rightMarginWindowInset;
    /* access modifiers changed from: private */
    public int topMarginWindowInset;

    public FloatingToolbarLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public void updateMargins() {
        int i5;
        int i6;
        int i7;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Rect rect = this.originalMargins;
        if (rect == null) {
            Log.w(TAG, "Unable to update margins because original view margins are not set");
            return;
        }
        int i8 = rect.left;
        int i9 = 0;
        if (this.marginLeftSystemWindowInsets) {
            i5 = this.leftMarginWindowInset;
        } else {
            i5 = 0;
        }
        int i10 = i8 + i5;
        int i11 = rect.right;
        if (this.marginRightSystemWindowInsets) {
            i6 = this.rightMarginWindowInset;
        } else {
            i6 = 0;
        }
        int i12 = i11 + i6;
        int i13 = rect.top;
        if (this.marginTopSystemWindowInsets) {
            i7 = this.topMarginWindowInset;
        } else {
            i7 = 0;
        }
        int i14 = i13 + i7;
        int i15 = rect.bottom;
        if (this.marginBottomSystemWindowInsets) {
            i9 = this.bottomMarginWindowInset;
        }
        int i16 = i15 + i9;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams.bottomMargin != i16 || marginLayoutParams.leftMargin != i10 || marginLayoutParams.rightMargin != i12 || marginLayoutParams.topMargin != i14) {
            marginLayoutParams.bottomMargin = i16;
            marginLayoutParams.leftMargin = i10;
            marginLayoutParams.rightMargin = i12;
            marginLayoutParams.topMargin = i14;
            requestLayout();
        }
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.originalMargins = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            updateMargins();
            return;
        }
        this.originalMargins = null;
    }

    public FloatingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingToolbarStyle);
    }

    public FloatingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5) {
        this(context, attributeSet, i5, DEF_STYLE_RES);
    }

    public FloatingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5, @StyleRes int i6) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i5, i6), attributeSet, i5);
        Context context2 = getContext();
        AttributeSet attributeSet2 = attributeSet;
        int i7 = i5;
        int i8 = i6;
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet2, R.styleable.FloatingToolbar, i7, i8, new int[0]);
        int i9 = R.styleable.FloatingToolbar_backgroundTint;
        if (obtainTintedStyledAttributes.hasValue(i9)) {
            int color = obtainTintedStyledAttributes.getColor(i9, 0);
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(context2, attributeSet2, i7, i8).build());
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
            setBackground(materialShapeDrawable);
        }
        this.marginLeftSystemWindowInsets = obtainTintedStyledAttributes.getBoolean(R.styleable.FloatingToolbar_marginLeftSystemWindowInsets, true);
        this.marginTopSystemWindowInsets = obtainTintedStyledAttributes.getBoolean(R.styleable.FloatingToolbar_marginTopSystemWindowInsets, false);
        this.marginRightSystemWindowInsets = obtainTintedStyledAttributes.getBoolean(R.styleable.FloatingToolbar_marginRightSystemWindowInsets, true);
        this.marginBottomSystemWindowInsets = obtainTintedStyledAttributes.getBoolean(R.styleable.FloatingToolbar_marginBottomSystemWindowInsets, true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
            @NonNull
            public WindowInsetsCompat onApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
                if (!FloatingToolbarLayout.this.marginLeftSystemWindowInsets && !FloatingToolbarLayout.this.marginRightSystemWindowInsets && !FloatingToolbarLayout.this.marginTopSystemWindowInsets && !FloatingToolbarLayout.this.marginBottomSystemWindowInsets) {
                    return windowInsetsCompat;
                }
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout() | WindowInsetsCompat.Type.ime());
                int unused = FloatingToolbarLayout.this.bottomMarginWindowInset = insets.bottom;
                int unused2 = FloatingToolbarLayout.this.topMarginWindowInset = insets.top;
                int unused3 = FloatingToolbarLayout.this.rightMarginWindowInset = insets.right;
                int unused4 = FloatingToolbarLayout.this.leftMarginWindowInset = insets.left;
                FloatingToolbarLayout.this.updateMargins();
                return windowInsetsCompat;
            }
        });
        obtainTintedStyledAttributes.recycle();
    }
}
