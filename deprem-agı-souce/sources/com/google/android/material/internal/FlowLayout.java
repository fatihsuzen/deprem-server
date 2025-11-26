package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class FlowLayout extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private int rowCount;
    private boolean singleLine;

    public FlowLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private static int getMeasuredDimension(int i5, int i6, int i7) {
        if (i6 == Integer.MIN_VALUE) {
            return Math.min(i7, i5);
        }
        if (i6 != 1073741824) {
            return i7;
        }
        return i5;
    }

    private void loadFromAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        this.lineSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.itemSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_horizontalItemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public int getItemSpacing() {
        return this.itemSpacing;
    }

    /* access modifiers changed from: protected */
    public int getLineSpacing() {
        return this.lineSpacing;
    }

    /* access modifiers changed from: protected */
    public int getRowCount() {
        return this.rowCount;
    }

    public int getRowIndex(@NonNull View view) {
        Object tag = view.getTag(R.id.row_index_key);
        if (!(tag instanceof Integer)) {
            return -1;
        }
        return ((Integer) tag).intValue();
    }

    public boolean isSingleLine() {
        return this.singleLine;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        boolean z5;
        int i9;
        int i10;
        boolean z6;
        int i11;
        int i12;
        if (getChildCount() == 0) {
            this.rowCount = 0;
            return;
        }
        boolean z7 = true;
        this.rowCount = 1;
        if (getLayoutDirection() == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            i9 = getPaddingRight();
        } else {
            i9 = getPaddingLeft();
        }
        if (z5) {
            i10 = getPaddingLeft();
        } else {
            i10 = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int i13 = 0;
        int i14 = i9;
        int i15 = paddingTop;
        while (i13 < getChildCount()) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
                z6 = z7;
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i11 = marginLayoutParams.getMarginStart();
                    i12 = marginLayoutParams.getMarginEnd();
                } else {
                    i12 = 0;
                    i11 = 0;
                }
                int measuredWidth = i14 + i11 + childAt.getMeasuredWidth();
                int i16 = i7 - i5;
                int i17 = i16 - i10;
                z6 = z7;
                if (!this.singleLine && measuredWidth > i17) {
                    measuredWidth = i9 + i11 + childAt.getMeasuredWidth();
                    i15 = paddingTop + this.lineSpacing;
                    this.rowCount++;
                    i14 = i9;
                }
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.rowCount - 1));
                int measuredHeight = childAt.getMeasuredHeight() + i15;
                if (z5) {
                    childAt.layout(i16 - measuredWidth, i15, (i16 - i14) - i11, measuredHeight);
                } else {
                    childAt.layout(i14 + i11, i15, measuredWidth, measuredHeight);
                }
                i14 += i11 + i12 + childAt.getMeasuredWidth() + this.itemSpacing;
                paddingTop = measuredHeight;
            }
            i13++;
            z7 = z6;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int size = View.MeasureSpec.getSize(i5);
        int mode = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i6);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i7 = size;
        } else {
            i7 = Integer.MAX_VALUE;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i7 - getPaddingRight();
        int i11 = paddingTop;
        int i12 = 0;
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 8) {
                int i14 = i5;
                int i15 = i6;
            } else {
                measureChild(childAt, i5, i6);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i9 = marginLayoutParams.leftMargin;
                    i8 = marginLayoutParams.rightMargin;
                } else {
                    i9 = 0;
                    i8 = 0;
                }
                int i16 = paddingLeft;
                if (paddingLeft + i9 + childAt.getMeasuredWidth() <= paddingRight || isSingleLine()) {
                    i10 = i16;
                } else {
                    i10 = getPaddingLeft();
                    i11 = this.lineSpacing + paddingTop;
                }
                int measuredWidth = i10 + i9 + childAt.getMeasuredWidth();
                int measuredHeight = i11 + childAt.getMeasuredHeight();
                if (measuredWidth > i12) {
                    i12 = measuredWidth;
                }
                paddingLeft = i10 + i9 + i8 + childAt.getMeasuredWidth() + this.itemSpacing;
                if (i13 == getChildCount() - 1) {
                    i12 += i8;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(getMeasuredDimension(size, mode, i12 + getPaddingRight()), getMeasuredDimension(size2, mode2, paddingTop + getPaddingBottom()));
    }

    /* access modifiers changed from: protected */
    public void setItemSpacing(int i5) {
        this.itemSpacing = i5;
    }

    /* access modifiers changed from: protected */
    public void setLineSpacing(int i5) {
        this.lineSpacing = i5;
    }

    public void setSingleLine(boolean z4) {
        this.singleLine = z4;
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }
}
