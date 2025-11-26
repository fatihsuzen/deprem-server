package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.leanback.R;
import java.util.List;

public class SearchEditText extends StreamingTextView {
    private static final boolean DEBUG = false;
    private static final String TAG = "SearchEditText";
    OnKeyboardDismissListener mKeyboardDismissListener;

    public interface OnKeyboardDismissListener {
        void onKeyboardDismiss();
    }

    public SearchEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public /* bridge */ /* synthetic */ void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    public boolean onKeyPreIme(int i5, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.mKeyboardDismissListener != null) {
            post(new Runnable() {
                public void run() {
                    OnKeyboardDismissListener onKeyboardDismissListener = SearchEditText.this.mKeyboardDismissListener;
                    if (onKeyboardDismissListener != null) {
                        onKeyboardDismissListener.onKeyboardDismiss();
                    }
                }
            });
        }
        return super.onKeyPreIme(i5, keyEvent);
    }

    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    public /* bridge */ /* synthetic */ void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    public /* bridge */ /* synthetic */ void setFinalRecognizedText(CharSequence charSequence) {
        super.setFinalRecognizedText(charSequence);
    }

    public void setOnKeyboardDismissListener(OnKeyboardDismissListener onKeyboardDismissListener) {
        this.mKeyboardDismissListener = onKeyboardDismissListener;
    }

    public /* bridge */ /* synthetic */ void updateRecognizedText(String str, String str2) {
        super.updateRecognizedText(str, str2);
    }

    public SearchEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.TextAppearance_Leanback_SearchTextEdit);
    }

    public /* bridge */ /* synthetic */ void updateRecognizedText(String str, List list) {
        super.updateRecognizedText(str, (List<Float>) list);
    }

    public SearchEditText(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
