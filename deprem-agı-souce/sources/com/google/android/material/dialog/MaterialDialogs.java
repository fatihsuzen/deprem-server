package com.google.android.material.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialDialogs {
    private MaterialDialogs() {
    }

    @NonNull
    public static Rect getDialogBackgroundInsets(@NonNull Context context, @AttrRes int i5, int i6) {
        int i7;
        Context context2 = context;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, (AttributeSet) null, R.styleable.MaterialAlertDialog, i5, i6, new int[0]);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetStart, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetTop, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetEnd, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetBottom, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_bottom));
        obtainStyledAttributes.recycle();
        int layoutDirection = context2.getResources().getConfiguration().getLayoutDirection();
        if (layoutDirection == 1) {
            i7 = dimensionPixelSize3;
        } else {
            i7 = dimensionPixelSize;
        }
        if (layoutDirection != 1) {
            dimensionPixelSize = dimensionPixelSize3;
        }
        return new Rect(i7, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize4);
    }

    @NonNull
    public static InsetDrawable insetDrawable(@Nullable Drawable drawable, @NonNull Rect rect) {
        return new InsetDrawable(drawable, rect.left, rect.top, rect.right, rect.bottom);
    }
}
