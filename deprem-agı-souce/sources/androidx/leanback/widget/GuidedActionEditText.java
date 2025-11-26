package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillValue;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.widget.TextViewCompat;
import androidx.leanback.widget.GuidedActionAutofillSupport;
import androidx.leanback.widget.ImeKeyMonitor;

@SuppressLint({"AppCompatCustomView"})
public class GuidedActionEditText extends EditText implements ImeKeyMonitor, GuidedActionAutofillSupport {
    private GuidedActionAutofillSupport.OnAutofillListener mAutofillListener;
    private ImeKeyMonitor.ImeKeyListener mKeyListener;
    private final Drawable mNoPaddingDrawable;
    private final Drawable mSavedBackground;

    static final class NoPaddingDrawable extends Drawable {
        NoPaddingDrawable() {
        }

        public void draw(Canvas canvas) {
        }

        public int getOpacity() {
            return -2;
        }

        public boolean getPadding(Rect rect) {
            rect.set(0, 0, 0, 0);
            return true;
        }

        public void setAlpha(int i5) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public GuidedActionEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public void autofill(AutofillValue autofillValue) {
        super.autofill(autofillValue);
        GuidedActionAutofillSupport.OnAutofillListener onAutofillListener = this.mAutofillListener;
        if (onAutofillListener != null) {
            onAutofillListener.onAutofill(this);
        }
    }

    @RequiresApi(26)
    public int getAutofillType() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z4, int i5, Rect rect) {
        super.onFocusChanged(z4, i5, rect);
        if (z4) {
            setBackground(this.mSavedBackground);
        } else {
            setBackground(this.mNoPaddingDrawable);
        }
        if (!z4) {
            setFocusable(false);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Class cls;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (isFocused()) {
            cls = EditText.class;
        } else {
            cls = TextView.class;
        }
        accessibilityNodeInfo.setClassName(cls.getName());
    }

    public boolean onKeyPreIme(int i5, KeyEvent keyEvent) {
        boolean z4;
        ImeKeyMonitor.ImeKeyListener imeKeyListener = this.mKeyListener;
        if (imeKeyListener != null) {
            z4 = imeKeyListener.onKeyPreIme(this, i5, keyEvent);
        } else {
            z4 = false;
        }
        if (!z4) {
            return super.onKeyPreIme(i5, keyEvent);
        }
        return z4;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isInTouchMode() || isFocusableInTouchMode() || isTextSelectable()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setImeKeyListener(ImeKeyMonitor.ImeKeyListener imeKeyListener) {
        this.mKeyListener = imeKeyListener;
    }

    public void setOnAutofillListener(GuidedActionAutofillSupport.OnAutofillListener onAutofillListener) {
        this.mAutofillListener = onAutofillListener;
    }

    public GuidedActionEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842862);
    }

    public GuidedActionEditText(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mSavedBackground = getBackground();
        NoPaddingDrawable noPaddingDrawable = new NoPaddingDrawable();
        this.mNoPaddingDrawable = noPaddingDrawable;
        setBackground(noPaddingDrawable);
    }
}
