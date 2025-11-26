package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class GuidedActionItemContainer extends NonOverlappingLinearLayoutWithForeground {
    private boolean mFocusOutAllowed;

    public GuidedActionItemContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public View focusSearch(View view, int i5) {
        if (this.mFocusOutAllowed || !Util.isDescendant(this, view)) {
            return super.focusSearch(view, i5);
        }
        View focusSearch = super.focusSearch(view, i5);
        if (Util.isDescendant(this, focusSearch)) {
            return focusSearch;
        }
        return null;
    }

    public void setFocusOutAllowed(boolean z4) {
        this.mFocusOutAllowed = z4;
    }

    public GuidedActionItemContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuidedActionItemContainer(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mFocusOutAllowed = true;
    }
}
