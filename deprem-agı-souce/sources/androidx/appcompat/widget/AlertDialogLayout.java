package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(@Nullable Context context) {
        super(context);
    }

    private void forceUniformWidth(int i5, int i6) {
        int i7;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int i8 = 0;
        while (i8 < i5) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i9 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    i7 = i6;
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i7, 0);
                    layoutParams.height = i9;
                    i8++;
                    i6 = i7;
                }
            }
            i7 = i6;
            i8++;
            i6 = i7;
        }
    }

    private static int resolveMinimumHeight(View view) {
        int minimumHeight = ViewCompat.getMinimumHeight(view);
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return resolveMinimumHeight(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private void setChildFrame(View view, int i5, int i6, int i7, int i8) {
        view.layout(i5, i6, i7 + i5, i8 + i6);
    }

    private boolean tryOnMeasure(int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = i5;
        int i13 = i6;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == R.id.topPanel) {
                    view = childAt;
                } else if (id == R.id.buttonPanel) {
                    view2 = childAt;
                } else if ((id != R.id.contentPanel && id != R.id.customPanel) || view3 != null) {
                    return false;
                } else {
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i13);
        int size = View.MeasureSpec.getSize(i13);
        int mode2 = View.MeasureSpec.getMode(i12);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i12, 0);
            paddingTop += view.getMeasuredHeight();
            i7 = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            i7 = 0;
        }
        if (view2 != null) {
            view2.measure(i12, 0);
            i9 = resolveMinimumHeight(view2);
            i8 = view2.getMeasuredHeight() - i9;
            paddingTop += i9;
            i7 = View.combineMeasuredStates(i7, view2.getMeasuredState());
        } else {
            i9 = 0;
            i8 = 0;
        }
        if (view3 != null) {
            if (mode == 0) {
                i11 = 0;
            } else {
                i11 = View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode);
            }
            view3.measure(i12, i11);
            i10 = view3.getMeasuredHeight();
            paddingTop += i10;
            i7 = View.combineMeasuredStates(i7, view3.getMeasuredState());
        } else {
            i10 = 0;
        }
        int i15 = size - paddingTop;
        if (view2 != null) {
            int i16 = paddingTop - i9;
            int min = Math.min(i15, i8);
            if (min > 0) {
                i15 -= min;
                i9 += min;
            }
            view2.measure(i12, View.MeasureSpec.makeMeasureSpec(i9, 1073741824));
            paddingTop = i16 + view2.getMeasuredHeight();
            i7 = View.combineMeasuredStates(i7, view2.getMeasuredState());
        }
        if (view3 != null && i15 > 0) {
            view3.measure(i12, View.MeasureSpec.makeMeasureSpec(i10 + i15, mode));
            paddingTop = (paddingTop - i10) + view3.getMeasuredHeight();
            i7 = View.combineMeasuredStates(i7, view3.getMeasuredState());
        }
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                i17 = Math.max(i17, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i17 + getPaddingLeft() + getPaddingRight(), i12, i7), View.resolveSizeAndState(paddingTop, i13, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        forceUniformWidth(childCount, i13);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int paddingLeft = getPaddingLeft();
        int i14 = i7 - i5;
        int paddingRight = i14 - getPaddingRight();
        int paddingRight2 = (i14 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i15 = gravity & 112;
        int i16 = gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i15 == 16) {
            i9 = getPaddingTop() + (((i8 - i6) - measuredHeight) / 2);
        } else if (i15 != 80) {
            i9 = getPaddingTop();
        } else {
            i9 = ((getPaddingTop() + i8) - i6) - measuredHeight;
        }
        Drawable dividerDrawable = getDividerDrawable();
        if (dividerDrawable == null) {
            i10 = 0;
        } else {
            i10 = dividerDrawable.getIntrinsicHeight();
        }
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                int i18 = layoutParams.gravity;
                if (i18 < 0) {
                    i18 = i16;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i18, getLayoutDirection()) & 7;
                if (absoluteGravity == 1) {
                    i11 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i12 = layoutParams.rightMargin;
                    i13 = i11 - i12;
                } else if (absoluteGravity != 5) {
                    i13 = layoutParams.leftMargin + paddingLeft;
                } else {
                    i11 = paddingRight - measuredWidth;
                    i12 = layoutParams.rightMargin;
                    i13 = i11 - i12;
                }
                int i19 = i13;
                if (hasDividerBeforeChildAt(i17)) {
                    i9 += i10;
                }
                int i20 = i9 + layoutParams.topMargin;
                setChildFrame(childAt, i19, i20, measuredWidth, measuredHeight2);
                i9 = i20 + measuredHeight2 + layoutParams.bottomMargin;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        if (!tryOnMeasure(i5, i6)) {
            super.onMeasure(i5, i6);
        }
    }

    public AlertDialogLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
