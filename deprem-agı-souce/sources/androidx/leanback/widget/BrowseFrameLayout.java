package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;

public class BrowseFrameLayout extends FrameLayout {
    private OnFocusSearchListener mListener;
    private OnChildFocusListener mOnChildFocusListener;
    private View.OnKeyListener mOnDispatchKeyListener;

    public interface OnChildFocusListener {
        void onRequestChildFocus(View view, View view2);

        boolean onRequestFocusInDescendants(int i5, Rect rect);
    }

    public interface OnFocusSearchListener {
        View onFocusSearch(View view, int i5);
    }

    public BrowseFrameLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        View.OnKeyListener onKeyListener = this.mOnDispatchKeyListener;
        if (onKeyListener == null || dispatchKeyEvent) {
            return dispatchKeyEvent;
        }
        return onKeyListener.onKey(getRootView(), keyEvent.getKeyCode(), keyEvent);
    }

    public View focusSearch(View view, int i5) {
        View onFocusSearch;
        OnFocusSearchListener onFocusSearchListener = this.mListener;
        if (onFocusSearchListener == null || (onFocusSearch = onFocusSearchListener.onFocusSearch(view, i5)) == null) {
            return super.focusSearch(view, i5);
        }
        return onFocusSearch;
    }

    public OnChildFocusListener getOnChildFocusListener() {
        return this.mOnChildFocusListener;
    }

    public OnFocusSearchListener getOnFocusSearchListener() {
        return this.mListener;
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i5, Rect rect) {
        OnChildFocusListener onChildFocusListener = this.mOnChildFocusListener;
        if (onChildFocusListener == null || !onChildFocusListener.onRequestFocusInDescendants(i5, rect)) {
            return super.onRequestFocusInDescendants(i5, rect);
        }
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        OnChildFocusListener onChildFocusListener = this.mOnChildFocusListener;
        if (onChildFocusListener != null) {
            onChildFocusListener.onRequestChildFocus(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public void setOnChildFocusListener(OnChildFocusListener onChildFocusListener) {
        this.mOnChildFocusListener = onChildFocusListener;
    }

    public void setOnDispatchKeyListener(View.OnKeyListener onKeyListener) {
        this.mOnDispatchKeyListener = onKeyListener;
    }

    public void setOnFocusSearchListener(OnFocusSearchListener onFocusSearchListener) {
        this.mListener = onFocusSearchListener;
    }

    public BrowseFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BrowseFrameLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
