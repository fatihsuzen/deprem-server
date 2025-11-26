package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.leanback.R;

class GuidedActionsRelativeLayout extends RelativeLayout {
    private boolean mInOverride;
    private InterceptKeyEventListener mInterceptKeyEventListener;
    private float mKeyLinePercent;

    interface InterceptKeyEventListener {
        boolean onInterceptKeyEvent(KeyEvent keyEvent);
    }

    public GuidedActionsRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptKeyEventListener interceptKeyEventListener = this.mInterceptKeyEventListener;
        if (interceptKeyEventListener == null || !interceptKeyEventListener.onInterceptKeyEvent(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        this.mInOverride = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        View findViewById;
        int size = View.MeasureSpec.getSize(i6);
        if (size > 0 && (findViewById = findViewById(R.id.guidedactions_sub_list)) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
            if (marginLayoutParams.topMargin < 0 && !this.mInOverride) {
                this.mInOverride = true;
            }
            if (this.mInOverride) {
                marginLayoutParams.topMargin = (int) ((this.mKeyLinePercent * ((float) size)) / 100.0f);
            }
        }
        super.onMeasure(i5, i6);
    }

    public void setInterceptKeyEventListener(InterceptKeyEventListener interceptKeyEventListener) {
        this.mInterceptKeyEventListener = interceptKeyEventListener;
    }

    public GuidedActionsRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuidedActionsRelativeLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mInOverride = false;
        this.mKeyLinePercent = GuidanceStylingRelativeLayout.getKeyLinePercent(context);
    }
}
