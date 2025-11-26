package androidx.leanback.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

public final class HorizontalHoverCardSwitcher extends PresenterSwitcher {
    int mCardLeft;
    int mCardRight;
    private int[] mTmpOffsets = new int[2];
    private Rect mTmpRect = new Rect();

    /* access modifiers changed from: protected */
    public void insertView(View view) {
        getParentViewGroup().addView(view);
    }

    /* access modifiers changed from: protected */
    public void onViewSelected(View view) {
        int width = getParentViewGroup().getWidth() - getParentViewGroup().getPaddingRight();
        int paddingLeft = getParentViewGroup().getPaddingLeft();
        boolean z4 = false;
        view.measure(0, 0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (view.getLayoutDirection() == 1) {
            z4 = true;
        }
        if (!z4 && this.mCardLeft + view.getMeasuredWidth() > width) {
            marginLayoutParams.leftMargin = width - view.getMeasuredWidth();
        } else if (z4 && this.mCardLeft < paddingLeft) {
            marginLayoutParams.leftMargin = paddingLeft;
        } else if (z4) {
            marginLayoutParams.leftMargin = this.mCardRight - view.getMeasuredWidth();
        } else {
            marginLayoutParams.leftMargin = this.mCardLeft;
        }
        view.requestLayout();
    }

    public void select(HorizontalGridView horizontalGridView, View view, Object obj) {
        ViewGroup parentViewGroup = getParentViewGroup();
        horizontalGridView.getViewSelectedOffsets(view, this.mTmpOffsets);
        this.mTmpRect.set(0, 0, view.getWidth(), view.getHeight());
        parentViewGroup.offsetDescendantRectToMyCoords(view, this.mTmpRect);
        Rect rect = this.mTmpRect;
        int i5 = rect.left;
        int i6 = this.mTmpOffsets[0];
        this.mCardLeft = i5 - i6;
        this.mCardRight = rect.right - i6;
        select(obj);
    }
}
