package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.material.R;

class PasswordToggleEndIconDelegate extends EndIconDelegate {
    @Nullable
    private EditText editText;
    private int iconResId = R.drawable.design_password_eye;
    private final View.OnClickListener onIconClickListener = new n(this);

    PasswordToggleEndIconDelegate(@NonNull EndCompoundLayout endCompoundLayout, @DrawableRes int i5) {
        super(endCompoundLayout);
        if (i5 != 0) {
            this.iconResId = i5;
        }
    }

    public static /* synthetic */ void a(PasswordToggleEndIconDelegate passwordToggleEndIconDelegate, View view) {
        EditText editText2 = passwordToggleEndIconDelegate.editText;
        if (editText2 != null) {
            int selectionEnd = editText2.getSelectionEnd();
            if (passwordToggleEndIconDelegate.hasPasswordTransformation()) {
                passwordToggleEndIconDelegate.editText.setTransformationMethod((TransformationMethod) null);
            } else {
                passwordToggleEndIconDelegate.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                passwordToggleEndIconDelegate.editText.setSelection(selectionEnd);
            }
            passwordToggleEndIconDelegate.refreshIconState();
        }
    }

    private boolean hasPasswordTransformation() {
        EditText editText2 = this.editText;
        if (editText2 == null || !(editText2.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            return false;
        }
        return true;
    }

    private static boolean isInputTypePassword(EditText editText2) {
        if (editText2 == null) {
            return false;
        }
        if (editText2.getInputType() == 16 || editText2.getInputType() == 128 || editText2.getInputType() == 144 || editText2.getInputType() == 224) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void beforeEditTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        refreshIconState();
    }

    /* access modifiers changed from: package-private */
    @StringRes
    public int getIconContentDescriptionResId() {
        return R.string.password_toggle_content_description;
    }

    /* access modifiers changed from: package-private */
    @DrawableRes
    public int getIconDrawableResId() {
        return this.iconResId;
    }

    /* access modifiers changed from: package-private */
    public View.OnClickListener getOnIconClickListener() {
        return this.onIconClickListener;
    }

    /* access modifiers changed from: package-private */
    public boolean isIconCheckable() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isIconChecked() {
        return !hasPasswordTransformation();
    }

    /* access modifiers changed from: package-private */
    public void onEditTextAttached(@Nullable EditText editText2) {
        this.editText = editText2;
        refreshIconState();
    }

    /* access modifiers changed from: package-private */
    public void setUp() {
        if (isInputTypePassword(this.editText)) {
            this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* access modifiers changed from: package-private */
    public void tearDown() {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            editText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
