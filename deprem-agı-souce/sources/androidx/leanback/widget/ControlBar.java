package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

class ControlBar extends LinearLayout {
    private int mChildMarginFromCenter;
    boolean mDefaultFocusToMiddle = true;
    int mLastFocusIndex = -1;
    private OnChildFocusedListener mOnChildFocusedListener;

    public interface OnChildFocusedListener {
        void onChildFocusedListener(View view, View view2);
    }

    public ControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i5, int i6) {
        if (i5 == 33 || i5 == 130) {
            int i7 = this.mLastFocusIndex;
            if (i7 >= 0 && i7 < getChildCount()) {
                arrayList.add(getChildAt(this.mLastFocusIndex));
            } else if (getChildCount() > 0) {
                arrayList.add(getChildAt(getDefaultFocusIndex()));
            }
        } else {
            super.addFocusables(arrayList, i5, i6);
        }
    }

    /* access modifiers changed from: package-private */
    public int getDefaultFocusIndex() {
        if (this.mDefaultFocusToMiddle) {
            return getChildCount() / 2;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (this.mChildMarginFromCenter > 0) {
            int i7 = 0;
            int i8 = 0;
            while (i7 < getChildCount() - 1) {
                View childAt = getChildAt(i7);
                i7++;
                View childAt2 = getChildAt(i7);
                int measuredWidth = this.mChildMarginFromCenter - ((childAt.getMeasuredWidth() + childAt2.getMeasuredWidth()) / 2);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt2.getLayoutParams();
                layoutParams.setMarginStart(measuredWidth);
                childAt2.setLayoutParams(layoutParams);
                i8 += measuredWidth - layoutParams.getMarginStart();
            }
            setMeasuredDimension(getMeasuredWidth() + i8, getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i5, Rect rect) {
        int i6;
        if (getChildCount() > 0) {
            int i7 = this.mLastFocusIndex;
            if (i7 < 0 || i7 >= getChildCount()) {
                i6 = getDefaultFocusIndex();
            } else {
                i6 = this.mLastFocusIndex;
            }
            if (getChildAt(i6).requestFocus(i5, rect)) {
                return true;
            }
        }
        return super.onRequestFocusInDescendants(i5, rect);
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        this.mLastFocusIndex = indexOfChild(view);
        OnChildFocusedListener onChildFocusedListener = this.mOnChildFocusedListener;
        if (onChildFocusedListener != null) {
            onChildFocusedListener.onChildFocusedListener(view, view2);
        }
    }

    public void setChildMarginFromCenter(int i5) {
        this.mChildMarginFromCenter = i5;
    }

    /* access modifiers changed from: package-private */
    public void setDefaultFocusToMiddle(boolean z4) {
        this.mDefaultFocusToMiddle = z4;
    }

    public void setOnChildFocusedListener(OnChildFocusedListener onChildFocusedListener) {
        this.mOnChildFocusedListener = onChildFocusedListener;
    }

    public ControlBar(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
