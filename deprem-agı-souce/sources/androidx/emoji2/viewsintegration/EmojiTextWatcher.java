package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiTextWatcher implements TextWatcher {
    private final EditText mEditText;
    private int mEmojiReplaceStrategy = 0;
    private boolean mEnabled;
    private final boolean mExpectInitializedEmojiCompat;
    private EmojiCompat.InitCallback mInitCallback;
    private int mMaxEmojiCount = Integer.MAX_VALUE;

    @RequiresApi(19)
    private static class InitCallbackImpl extends EmojiCompat.InitCallback {
        private final Reference<EditText> mViewRef;

        InitCallbackImpl(EditText editText) {
            this.mViewRef = new WeakReference(editText);
        }

        public void onInitialized() {
            super.onInitialized();
            EmojiTextWatcher.processTextOnEnablingEvent(this.mViewRef.get(), 1);
        }
    }

    EmojiTextWatcher(EditText editText, boolean z4) {
        this.mEditText = editText;
        this.mExpectInitializedEmojiCompat = z4;
        this.mEnabled = true;
    }

    private EmojiCompat.InitCallback getInitCallback() {
        if (this.mInitCallback == null) {
            this.mInitCallback = new InitCallbackImpl(this.mEditText);
        }
        return this.mInitCallback;
    }

    static void processTextOnEnablingEvent(@Nullable EditText editText, int i5) {
        if (i5 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.get().process(editableText);
            EmojiInputFilter.updateSelection(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean shouldSkipForDisabledOrNotConfigured() {
        if (!this.mEnabled) {
            return true;
        }
        if (this.mExpectInitializedEmojiCompat || EmojiCompat.isConfigured()) {
            return false;
        }
        return true;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
    }

    /* access modifiers changed from: package-private */
    public int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    /* access modifiers changed from: package-private */
    public int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        if (!this.mEditText.isInEditMode() && !shouldSkipForDisabledOrNotConfigured() && i6 <= i7 && (charSequence instanceof Spannable)) {
            int loadState = EmojiCompat.get().getLoadState();
            if (loadState != 0) {
                if (loadState == 1) {
                    EmojiCompat.get().process((Spannable) charSequence, i5, i5 + i7, this.mMaxEmojiCount, this.mEmojiReplaceStrategy);
                    return;
                } else if (loadState != 3) {
                    return;
                }
            }
            EmojiCompat.get().registerInitCallback(getInitCallback());
        }
    }

    /* access modifiers changed from: package-private */
    public void setEmojiReplaceStrategy(int i5) {
        this.mEmojiReplaceStrategy = i5;
    }

    public void setEnabled(boolean z4) {
        if (this.mEnabled != z4) {
            if (this.mInitCallback != null) {
                EmojiCompat.get().unregisterInitCallback(this.mInitCallback);
            }
            this.mEnabled = z4;
            if (z4) {
                processTextOnEnablingEvent(this.mEditText, EmojiCompat.get().getLoadState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setMaxEmojiCount(int i5) {
        this.mMaxEmojiCount = i5;
    }
}
