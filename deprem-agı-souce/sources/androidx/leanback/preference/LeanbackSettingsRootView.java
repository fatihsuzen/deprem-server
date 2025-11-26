package androidx.leanback.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class LeanbackSettingsRootView extends FrameLayout {
    private View.OnKeyListener mOnBackKeyListener;

    public LeanbackSettingsRootView(Context context) {
        super(context);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z4;
        View.OnKeyListener onKeyListener;
        if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 4 && (onKeyListener = this.mOnBackKeyListener) != null) {
            z4 = onKeyListener.onKey(this, keyEvent.getKeyCode(), keyEvent);
        } else {
            z4 = false;
        }
        if (z4 || super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    public void setOnBackKeyListener(View.OnKeyListener onKeyListener) {
        this.mOnBackKeyListener = onKeyListener;
    }

    public LeanbackSettingsRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LeanbackSettingsRootView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
