package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

class NonOverlappingRelativeLayout extends RelativeLayout {
    public NonOverlappingRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public NonOverlappingRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public NonOverlappingRelativeLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
