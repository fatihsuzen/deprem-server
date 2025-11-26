package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
class CheckableImageView extends ImageView implements Checkable {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private boolean mChecked;

    public CheckableImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public int[] onCreateDrawableState(int i5) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i5 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void setChecked(boolean z4) {
        if (this.mChecked != z4) {
            this.mChecked = z4;
            refreshDrawableState();
        }
    }

    public void toggle() {
        setChecked(!this.mChecked);
    }

    public CheckableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckableImageView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
