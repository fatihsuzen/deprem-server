package androidx.preference;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

public class EditTextPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private static final String SAVE_STATE_TEXT = "EditTextPreferenceDialogFragment.text";
    private static final int SHOW_REQUEST_TIMEOUT = 1000;
    private EditText mEditText;
    private long mShowRequestTime = -1;
    private final Runnable mShowSoftInputRunnable = new Runnable() {
        public void run() {
            EditTextPreferenceDialogFragmentCompat.this.scheduleShowSoftInputInner();
        }
    };
    private CharSequence mText;

    private EditTextPreference getEditTextPreference() {
        return (EditTextPreference) getPreference();
    }

    private boolean hasPendingShowSoftInputRequest() {
        long j5 = this.mShowRequestTime;
        if (j5 == -1 || j5 + 1000 <= SystemClock.currentThreadTimeMillis()) {
            return false;
        }
        return true;
    }

    @NonNull
    public static EditTextPreferenceDialogFragmentCompat newInstance(String str) {
        EditTextPreferenceDialogFragmentCompat editTextPreferenceDialogFragmentCompat = new EditTextPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        editTextPreferenceDialogFragmentCompat.setArguments(bundle);
        return editTextPreferenceDialogFragmentCompat;
    }

    private void setPendingShowSoftInputRequest(boolean z4) {
        long j5;
        if (z4) {
            j5 = SystemClock.currentThreadTimeMillis();
        } else {
            j5 = -1;
        }
        this.mShowRequestTime = j5;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean needInputMethod() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBindDialogView(@NonNull View view) {
        super.onBindDialogView(view);
        EditText editText = (EditText) view.findViewById(16908291);
        this.mEditText = editText;
        if (editText != null) {
            editText.requestFocus();
            this.mEditText.setText(this.mText);
            EditText editText2 = this.mEditText;
            editText2.setSelection(editText2.getText().length());
            if (getEditTextPreference().getOnBindEditTextListener() != null) {
                getEditTextPreference().getOnBindEditTextListener().onBindEditText(this.mEditText);
                return;
            }
            return;
        }
        throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.mText = getEditTextPreference().getText();
        } else {
            this.mText = bundle.getCharSequence(SAVE_STATE_TEXT);
        }
    }

    public void onDialogClosed(boolean z4) {
        if (z4) {
            String obj = this.mEditText.getText().toString();
            EditTextPreference editTextPreference = getEditTextPreference();
            if (editTextPreference.callChangeListener(obj)) {
                editTextPreference.setText(obj);
            }
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence(SAVE_STATE_TEXT, this.mText);
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void scheduleShowSoftInput() {
        setPendingShowSoftInputRequest(true);
        scheduleShowSoftInputInner();
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void scheduleShowSoftInputInner() {
        if (hasPendingShowSoftInputRequest()) {
            EditText editText = this.mEditText;
            if (editText == null || !editText.isFocused()) {
                setPendingShowSoftInputRequest(false);
            } else if (((InputMethodManager) this.mEditText.getContext().getSystemService("input_method")).showSoftInput(this.mEditText, 0)) {
                setPendingShowSoftInputRequest(false);
            } else {
                this.mEditText.removeCallbacks(this.mShowSoftInputRunnable);
                this.mEditText.postDelayed(this.mShowSoftInputRunnable, 50);
            }
        }
    }
}
