package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;

public class MaterialDivider extends View {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_MaterialDivider;
    @ColorInt
    private int color;
    @NonNull
    private final MaterialShapeDrawable dividerDrawable;
    private int insetEnd;
    private int insetStart;
    private int thickness;

    public MaterialDivider(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public int getDividerColor() {
        return this.color;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.insetEnd;
    }

    @Px
    public int getDividerInsetStart() {
        return this.insetStart;
    }

    public int getDividerThickness() {
        return this.thickness;
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        int i5;
        int width;
        int i6;
        super.onDraw(canvas);
        boolean z4 = true;
        if (getLayoutDirection() != 1) {
            z4 = false;
        }
        if (z4) {
            i5 = this.insetEnd;
        } else {
            i5 = this.insetStart;
        }
        if (z4) {
            width = getWidth();
            i6 = this.insetStart;
        } else {
            width = getWidth();
            i6 = this.insetEnd;
        }
        this.dividerDrawable.setBounds(i5, 0, width - i6, getBottom() - getTop());
        this.dividerDrawable.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        int mode = View.MeasureSpec.getMode(i6);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i7 = this.thickness;
            if (i7 > 0 && measuredHeight != i7) {
                measuredHeight = i7;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(@ColorInt int i5) {
        if (this.color != i5) {
            this.color = i5;
            this.dividerDrawable.setFillColor(ColorStateList.valueOf(i5));
            invalidate();
        }
    }

    public void setDividerColorResource(@ColorRes int i5) {
        setDividerColor(ContextCompat.getColor(getContext(), i5));
    }

    public void setDividerInsetEnd(@Px int i5) {
        this.insetEnd = i5;
    }

    public void setDividerInsetEndResource(@DimenRes int i5) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i5));
    }

    public void setDividerInsetStart(@Px int i5) {
        this.insetStart = i5;
    }

    public void setDividerInsetStartResource(@DimenRes int i5) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i5));
    }

    public void setDividerThickness(@Px int i5) {
        if (this.thickness != i5) {
            this.thickness = i5;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(@DimenRes int i5) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i5));
    }

    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialDividerStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialDivider(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.content.Context r0 = r6.getContext()
            com.google.android.material.shape.MaterialShapeDrawable r7 = new com.google.android.material.shape.MaterialShapeDrawable
            r7.<init>()
            r6.dividerDrawable = r7
            int[] r2 = com.google.android.material.R.styleable.MaterialDivider
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.MaterialDivider_dividerThickness
            android.content.res.Resources r1 = r6.getResources()
            int r2 = com.google.android.material.R.dimen.material_divider_thickness
            int r1 = r1.getDimensionPixelSize(r2)
            int r9 = r8.getDimensionPixelSize(r9, r1)
            r6.thickness = r9
            int r9 = com.google.android.material.R.styleable.MaterialDivider_dividerInsetStart
            int r9 = r8.getDimensionPixelOffset(r9, r7)
            r6.insetStart = r9
            int r9 = com.google.android.material.R.styleable.MaterialDivider_dividerInsetEnd
            int r7 = r8.getDimensionPixelOffset(r9, r7)
            r6.insetEnd = r7
            int r7 = com.google.android.material.R.styleable.MaterialDivider_dividerColor
            android.content.res.ColorStateList r7 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r8, (int) r7)
            int r7 = r7.getDefaultColor()
            r6.setDividerColor(r7)
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.divider.MaterialDivider.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
