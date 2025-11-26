package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import androidx.leanback.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class PlaybackTransportRowView extends LinearLayout {
    private OnUnhandledKeyListener mOnUnhandledKeyListener;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface OnUnhandledKeyListener {
        boolean onUnhandledKey(KeyEvent keyEvent);
    }

    public PlaybackTransportRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        OnUnhandledKeyListener onUnhandledKeyListener = this.mOnUnhandledKeyListener;
        if (onUnhandledKeyListener == null || !onUnhandledKeyListener.onUnhandledKey(keyEvent)) {
            return false;
        }
        return true;
    }

    public View focusSearch(View view, int i5) {
        View childAt;
        if (view != null) {
            if (i5 == 33) {
                for (int indexOfChild = indexOfChild(getFocusedChild()) - 1; indexOfChild >= 0; indexOfChild--) {
                    View childAt2 = getChildAt(indexOfChild);
                    if (childAt2.hasFocusable()) {
                        return childAt2;
                    }
                }
            } else if (i5 == 130) {
                int indexOfChild2 = indexOfChild(getFocusedChild());
                do {
                    indexOfChild2++;
                    if (indexOfChild2 < getChildCount()) {
                        childAt = getChildAt(indexOfChild2);
                    }
                } while (!childAt.hasFocusable());
                return childAt;
            } else if ((i5 == 17 || i5 == 66) && (getFocusedChild() instanceof ViewGroup)) {
                return FocusFinder.getInstance().findNextFocus((ViewGroup) getFocusedChild(), view, i5);
            }
        }
        return super.focusSearch(view, i5);
    }

    /* access modifiers changed from: package-private */
    public OnUnhandledKeyListener getOnUnhandledKeyListener() {
        return this.mOnUnhandledKeyListener;
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i5, Rect rect) {
        View findFocus = findFocus();
        if (findFocus != null && findFocus.requestFocus(i5, rect)) {
            return true;
        }
        View findViewById = findViewById(R.id.playback_progress);
        if (findViewById == null || !findViewById.isFocusable() || !findViewById.requestFocus(i5, rect)) {
            return super.onRequestFocusInDescendants(i5, rect);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void setOnUnhandledKeyListener(OnUnhandledKeyListener onUnhandledKeyListener) {
        this.mOnUnhandledKeyListener = onUnhandledKeyListener;
    }

    public PlaybackTransportRowView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
